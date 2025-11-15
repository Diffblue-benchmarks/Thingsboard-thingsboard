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
package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class BaseDeleteTsKvQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#equals(Object)}
   *   <li>{@link BaseDeleteTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);
    BaseDeleteTsKvQuery baseDeleteTsKvQuery2 = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseDeleteTsKvQuery, baseDeleteTsKvQuery2);
    int expectedHashCodeResult = baseDeleteTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseDeleteTsKvQuery2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#equals(Object)}
   *   <li>{@link BaseDeleteTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseDeleteTsKvQuery, baseDeleteTsKvQuery);
    int expectedHashCodeResult = baseDeleteTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseDeleteTsKvQuery.hashCode());
  }

  /**
   * Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L, true);

    // Act and Assert
    assertNotEquals(baseDeleteTsKvQuery, new BaseDeleteTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseDeleteTsKvQuery("Key", 1L, 1L), null);
  }

  /**
   * Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseDeleteTsKvQuery("Key", 1L, 1L), "Different type to BaseDeleteTsKvQuery");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#toString()}
   *   <li>{@link BaseDeleteTsKvQuery#getDeleteLatest()}
   *   <li>{@link BaseDeleteTsKvQuery#getRewriteLatestIfDeleted()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act
    String actualToStringResult = baseDeleteTsKvQuery.toString();
    Boolean actualDeleteLatest = baseDeleteTsKvQuery.getDeleteLatest();

    // Assert
    assertEquals("BaseDeleteTsKvQuery(rewriteLatestIfDeleted=false, deleteLatest=true)", actualToStringResult);
    assertFalse(baseDeleteTsKvQuery.getRewriteLatestIfDeleted());
    assertTrue(actualDeleteLatest);
  }
}
