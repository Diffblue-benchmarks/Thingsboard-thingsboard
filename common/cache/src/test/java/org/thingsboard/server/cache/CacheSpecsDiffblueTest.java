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
import org.junit.jupiter.api.Test;

class CacheSpecsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheSpecs#equals(Object)}
   *   <li>{@link CacheSpecs#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(1);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertEquals(cacheSpecs, cacheSpecs2);
    int expectedHashCodeResult = cacheSpecs.hashCode();
    assertEquals(expectedHashCodeResult, cacheSpecs2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheSpecs#equals(Object)}
   *   <li>{@link CacheSpecs#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(null);
    cacheSpecs.setTimeToLiveInMinutes(1);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(null);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertEquals(cacheSpecs, cacheSpecs2);
    int expectedHashCodeResult = cacheSpecs.hashCode();
    assertEquals(expectedHashCodeResult, cacheSpecs2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheSpecs#equals(Object)}
   *   <li>{@link CacheSpecs#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(null);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(null);

    // Act and Assert
    assertEquals(cacheSpecs, cacheSpecs2);
    int expectedHashCodeResult = cacheSpecs.hashCode();
    assertEquals(expectedHashCodeResult, cacheSpecs2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CacheSpecs#equals(Object)}
   *   <li>{@link CacheSpecs#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertEquals(cacheSpecs, cacheSpecs);
    int expectedHashCodeResult = cacheSpecs.hashCode();
    assertEquals(expectedHashCodeResult, cacheSpecs.hashCode());
  }

  /**
   * Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(1);
    cacheSpecs.setTimeToLiveInMinutes(1);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, cacheSpecs2);
  }

  /**
   * Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(null);
    cacheSpecs.setTimeToLiveInMinutes(1);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, cacheSpecs2);
  }

  /**
   * Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(3);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, cacheSpecs2);
  }

  /**
   * Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(null);

    CacheSpecs cacheSpecs2 = new CacheSpecs();
    cacheSpecs2.setMaxSize(3);
    cacheSpecs2.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, cacheSpecs2);
  }

  /**
   * Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, null);
  }

  /**
   * Method under test: {@link CacheSpecs#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CacheSpecs cacheSpecs = new CacheSpecs();
    cacheSpecs.setMaxSize(3);
    cacheSpecs.setTimeToLiveInMinutes(1);

    // Act and Assert
    assertNotEquals(cacheSpecs, "Different type to CacheSpecs");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CacheSpecs}
   *   <li>{@link CacheSpecs#setMaxSize(Integer)}
   *   <li>{@link CacheSpecs#setTimeToLiveInMinutes(Integer)}
   *   <li>{@link CacheSpecs#toString()}
   *   <li>{@link CacheSpecs#getMaxSize()}
   *   <li>{@link CacheSpecs#getTimeToLiveInMinutes()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CacheSpecs actualCacheSpecs = new CacheSpecs();
    actualCacheSpecs.setMaxSize(3);
    actualCacheSpecs.setTimeToLiveInMinutes(1);
    String actualToStringResult = actualCacheSpecs.toString();
    Integer actualMaxSize = actualCacheSpecs.getMaxSize();

    // Assert that nothing has changed
    assertEquals("CacheSpecs(timeToLiveInMinutes=1, maxSize=3)", actualToStringResult);
    assertEquals(1, actualCacheSpecs.getTimeToLiveInMinutes().intValue());
    assertEquals(3, actualMaxSize.intValue());
  }
}
