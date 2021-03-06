// @formatter:off
 /*******************************************************************************
 *
 * This file is part of tensorics.
 *
 * Copyright (c) 2008-2011, CERN. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/
// @formatter:on
package org.tensorics.core.tensorbacked.lang;

import static org.tensorics.core.tensorbacked.TensorbackedInternals.dimensionsOf;

import java.util.Map;

import org.tensorics.core.tensor.ImmutableTensor;
import org.tensorics.core.tensor.Position;
import org.tensorics.core.tensor.Tensor;
import org.tensorics.core.tensor.lang.TensorStructurals;
import org.tensorics.core.tensorbacked.Tensorbacked;
import org.tensorics.core.tensorbacked.TensorbackedInternals;

import com.google.common.base.Preconditions;

public class OngoingTensorbackedConstruction<V, TB extends Tensorbacked<V>> {

    private final Class<TB> tensorbackedClass;

    public OngoingTensorbackedConstruction(Class<TB> tensorbackedClass) {
        this.tensorbackedClass = Preconditions.checkNotNull(tensorbackedClass, "tensorbackedClass must not be null");
    }

    public TB from(Tensor<V> tensor) {
        return TensorbackedInternals.createBackedByTensor(tensorbackedClass, tensor);
    }

    public TB byMerging(Iterable<Tensor<V>> tensors) {
        return from(TensorStructurals.merge(tensors));
    }

    public TB byMergingTb(Iterable<? extends Tensorbacked<V>> tensorbackeds) {
        return byMerging(TensorbackedInternals.tensorsOf(tensorbackeds));
    }

    public TB fromMap(Map<Position, V> inputMap) {
        Preconditions.checkNotNull(inputMap, "inputMap must not be null");
        Tensor<V> tensor = ImmutableTensor.fromMap(dimensionsOf(tensorbackedClass), inputMap);
        return from(tensor);
    }

}
