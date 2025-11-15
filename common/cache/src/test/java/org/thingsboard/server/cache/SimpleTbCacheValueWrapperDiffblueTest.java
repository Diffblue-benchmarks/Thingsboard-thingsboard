/**
 * Copyright © 2016-2024 The Thingsboard Authors
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
 */
package org.thingsboard.server.cache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.springframework.cache.Cache;

class SimpleTbCacheValueWrapperDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SimpleTbCacheValueWrapper#toString()}
   *   <li>{@link SimpleTbCacheValueWrapper#get()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    SimpleTbCacheValueWrapper<Object> emptyResult = SimpleTbCacheValueWrapper.empty();

    // Act
    String actualToStringResult = emptyResult.toString();

    // Assert
    assertEquals("SimpleTbCacheValueWrapper(value=null)", actualToStringResult);
    assertNull(emptyResult.get());
  }

  /**
   * Method under test: {@link SimpleTbCacheValueWrapper#empty()}
   */
  @Test
  void testEmpty() {
    // Arrange and Act
    SimpleTbCacheValueWrapper<Object> actualEmptyResult = SimpleTbCacheValueWrapper.empty();

    // Assert
    assertNull(actualEmptyResult.get());
  }

  /**
   * Method under test: {@link SimpleTbCacheValueWrapper#wrap(Object)}
   */
  @Test
  void testWrap() {
    // Arrange and Act
    SimpleTbCacheValueWrapper<Object> actualWrapResult = SimpleTbCacheValueWrapper.wrap("Value");

    // Assert
    assertEquals("Value", actualWrapResult.get());
  }

  /**
   * Method under test: {@link SimpleTbCacheValueWrapper#wrap(Cache.ValueWrapper)}
   */
  @Test
  void testWrap2() {
    // Arrange
    Cache.ValueWrapper source = mock(Cache.ValueWrapper.class);
    when(source.get()).thenReturn("Get");

    // Act
    SimpleTbCacheValueWrapper<Object> actualWrapResult = SimpleTbCacheValueWrapper.wrap(source);
    Object actualGetResult = actualWrapResult.get();

    // Assert
    verify(source).get();
    assertEquals("Get", actualGetResult);
  }
}
