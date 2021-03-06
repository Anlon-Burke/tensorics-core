// @formatter:off
/**
*
* This file is part of streaming pool (http://www.streamingpool.org).
* 
* Copyright (c) 2017-present, CERN. All rights reserved.
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
*/
// @formatter:on

package org.tensorics.core.analysis.lang;

import static java.util.Objects.requireNonNull;

import org.tensorics.core.analysis.ConditionBuilder;
import org.tensorics.core.tree.domain.Expression;

public class OngoingNamedCondition<T> {

    protected final ConditionBuilder builder;
    protected final Expression<T> source;

    public OngoingNamedCondition(ConditionBuilder builder, Expression<T> source) {
        this.builder = requireNonNull(builder, "builder must not be null");
        this.source = requireNonNull(source, "source must not be null");
    }

    public OngoingNamedCondition<T> withName(String name) {
        this.builder.withName(name);
        return this;
    }

    public OngoingNamedCondition<T> withKey(String key) {
        this.builder.withKey(key);
        return this;
    }

}