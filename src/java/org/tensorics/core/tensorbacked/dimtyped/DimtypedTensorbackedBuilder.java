package org.tensorics.core.tensorbacked.dimtyped;

import org.tensorics.core.tensor.Position;
import org.tensorics.core.tensor.Tensor;
import org.tensorics.core.tensorbacked.Tensorbacked;
import org.tensorics.core.tensorbacked.TensorbackedBuilder;

import java.util.Map;
import java.util.Set;

public interface DimtypedTensorbackedBuilder<V, TB extends DimtypedTensorbacked<V>, B extends DimtypedTensorbackedBuilder<V, TB, B>> extends TensorbackedBuilder<V, TB> {

    @Override
    B context(Position context);

    @Override
    B context(Object... coordinates);

    @Override
    B putAll(Tensor<V> tensor);

    @Override
    B putAll(Position position, Tensor<V> tensor);

    @Override
    B putAll(Position position, Tensorbacked<V> tensorbacked);

    @Override
    B putAll(TB tensorBacked);

    @Override
    B put(Position position, V value);

    @Override
    B putAll(Set<Map.Entry<Position, V>> entries);

    @Override
    B put(Map.Entry<Position, V> entry);

    @Override
    B remove(Position position);

    @Override
    B putAll(Map<Position, V> newEntries);

    @Override
    B putAll(Position position, Map<Position, V> map);

    @Override
    TB build();
}
