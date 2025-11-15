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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class CacheSpecsMapDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheSpecsMap#equals(Object)}
   *   <li>{@link CacheSpecsMap#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CacheSpecsMap cacheSpecsMap2 = new CacheSpecsMap();

    // Act and Assert
    assertEquals(cacheSpecsMap, cacheSpecsMap2);
    int expectedHashCodeResult = cacheSpecsMap.hashCode();
    assertEquals(expectedHashCodeResult, cacheSpecsMap2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheSpecsMap#equals(Object)}
   *   <li>{@link CacheSpecsMap#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    cacheSpecsMap.setSpecs(new HashMap<>());

    CacheSpecsMap cacheSpecsMap2 = new CacheSpecsMap();
    cacheSpecsMap2.setSpecs(new HashMap<>());

    // Act and Assert
    assertEquals(cacheSpecsMap, cacheSpecsMap2);
    int expectedHashCodeResult = cacheSpecsMap.hashCode();
    assertEquals(expectedHashCodeResult, cacheSpecsMap2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheSpecsMap#equals(Object)}
   *   <li>{@link CacheSpecsMap#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act and Assert
    assertEquals(cacheSpecsMap, cacheSpecsMap);
    int expectedHashCodeResult = cacheSpecsMap.hashCode();
    assertEquals(expectedHashCodeResult, cacheSpecsMap.hashCode());
  }

  /**
   * Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CacheSpecsMap(), 1);
  }

  /**
   * Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    cacheSpecsMap.setRefreshTokenExpTime(1);

    // Act and Assert
    assertNotEquals(cacheSpecsMap, new CacheSpecsMap());
  }

  /**
   * Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    cacheSpecsMap.setSpecs(new HashMap<>());

    // Act and Assert
    assertNotEquals(cacheSpecsMap, new CacheSpecsMap());
  }

  /**
   * Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    CacheSpecsMap cacheSpecsMap2 = new CacheSpecsMap();
    cacheSpecsMap2.setSpecs(new HashMap<>());

    // Act and Assert
    assertNotEquals(cacheSpecsMap, cacheSpecsMap2);
  }

  /**
   * Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    HashMap<String, CacheSpecs> specs = new HashMap<>();
    specs.computeIfPresent("foo", mock(BiFunction.class));

    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    cacheSpecsMap.setSpecs(specs);

    // Act and Assert
    assertNotEquals(cacheSpecsMap, new CacheSpecsMap());
  }

  /**
   * Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CacheSpecsMap(), null);
  }

  /**
   * Method under test: {@link CacheSpecsMap#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CacheSpecsMap(), "Different type to CacheSpecsMap");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheSpecsMap#setRefreshTokenExpTime(int)}
   *   <li>{@link CacheSpecsMap#setSpecs(Map)}
   *   <li>{@link CacheSpecsMap#toString()}
   *   <li>{@link CacheSpecsMap#getRefreshTokenExpTime()}
   *   <li>{@link CacheSpecsMap#getSpecs()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act
    cacheSpecsMap.setRefreshTokenExpTime(1);
    HashMap<String, CacheSpecs> specs = new HashMap<>();
    cacheSpecsMap.setSpecs(specs);
    String actualToStringResult = cacheSpecsMap.toString();
    int actualRefreshTokenExpTime = cacheSpecsMap.getRefreshTokenExpTime();
    Map<String, CacheSpecs> actualSpecs = cacheSpecsMap.getSpecs();

    // Assert that nothing has changed
    assertEquals("CacheSpecsMap(refreshTokenExpTime=1, specs={})", actualToStringResult);
    assertEquals(1, actualRefreshTokenExpTime);
    assertTrue(actualSpecs.isEmpty());
    assertSame(specs, actualSpecs);
  }
}
