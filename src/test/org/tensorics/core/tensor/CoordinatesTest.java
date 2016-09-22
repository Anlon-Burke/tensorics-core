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
package org.tensorics.core.tensor;

import static org.tensorics.core.testing.TestUtil.assertUtilityClass;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CoordinatesTest {

    @Test
    public void verifyUtiliyClass() {
        assertUtilityClass(Coordinates.class);
    }

    @Test
    public void checkRelationsAllowed() {
        Set<Class<?>> coordinates = new HashSet<>();
        coordinates.add(IA.class);
        coordinates.add(IB.class);

        Coordinates.checkClassRelations(A.class, coordinates);
    }

    @Test
    public void checkRelationsAllowed2() {
        Set<Class<?>> coordinates = new HashSet<>();
        coordinates.add(IA.class);
        coordinates.add(IC.class);
        Coordinates.checkClassRelations(C.class, coordinates);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkRelationsNotAllowed() {
        Set<Class<?>> coordinates = new HashSet<>();
        coordinates.add(IA.class);
        coordinates.add(IC.class);
        Coordinates.checkClassRelations(B.class, coordinates);
    }
    
}

interface IA {
}

interface IB {
}

interface IC extends IB {
}

class A implements IA {
}

class B implements IB {
}

class C implements IC {
}