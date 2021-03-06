/*
 * Copyright (c) 2005-2013 Clark & Parsia, LLC. <http://www.clarkparsia.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.complexible.common.collect;

import org.junit.Test;

import static org.junit.Assert.*;
import com.complexible.common.collect.BigArrayList;

/**
 * <p>{@link com.complexible.common.collect.BigArrayList} tests</p>
 *
 * @author Pedro Oliveira
 */
public class BigArrayListTest {

    @Test
    public void testBigArray() {

        int splitSize = 100;

        BigArrayList<Integer> list = BigArrayList.create(splitSize);

        assertEquals(list.size(), 0, 0);

        for(int i = 0; i < splitSize; i++) {
            assertTrue(list.add(i));
        }

        assertEquals(list.size(), splitSize, 0);

        try {
            list.get(splitSize + 1);
            fail("Exception expected!");
        }catch(Throwable e) {
        }

        for(int i = 0; i < splitSize; i++) {
            assertEquals(list.get(i), i, 0);
        }

        for(int i = splitSize; i < splitSize*2; i++) {
            assertTrue(list.add(i));
        }

        assertEquals(list.size(), splitSize*2, 0);

        for(int i = 0; i < splitSize*2; i++) {
            assertEquals(list.get(i), i, 0);
        }

        try {
            list.get(splitSize * 2 + 1);
            fail("Exception expected!");
        }catch(Throwable e) {
        }
    }
}
