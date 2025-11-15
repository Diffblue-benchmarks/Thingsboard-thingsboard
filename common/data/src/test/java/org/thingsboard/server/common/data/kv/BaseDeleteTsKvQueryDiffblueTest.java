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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BaseDeleteTsKvQueryDiffblueTest {
  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}, and {@link BaseDeleteTsKvQuery#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#equals(Object)}
   *   <li>{@link BaseDeleteTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseDeleteTsKvQuery.equals(Object)", "int BaseDeleteTsKvQuery.hashCode()"})
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
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}, and {@link BaseDeleteTsKvQuery#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#equals(Object)}
   *   <li>{@link BaseDeleteTsKvQuery#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseDeleteTsKvQuery.equals(Object)", "int BaseDeleteTsKvQuery.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L);

    // Act and Assert
    assertEquals(baseDeleteTsKvQuery, baseDeleteTsKvQuery);
    int expectedHashCodeResult = baseDeleteTsKvQuery.hashCode();
    assertEquals(expectedHashCodeResult, baseDeleteTsKvQuery.hashCode());
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseDeleteTsKvQuery.equals(Object)", "int BaseDeleteTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseDeleteTsKvQuery baseDeleteTsKvQuery = new BaseDeleteTsKvQuery("Key", 1L, 1L, true);

    // Act and Assert
    assertNotEquals(baseDeleteTsKvQuery, new BaseDeleteTsKvQuery("Key", 1L, 1L));
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseDeleteTsKvQuery.equals(Object)", "int BaseDeleteTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseDeleteTsKvQuery("Key", 1L, 1L), null);
  }

  /**
   * Test {@link BaseDeleteTsKvQuery#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseDeleteTsKvQuery#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean BaseDeleteTsKvQuery.equals(Object)", "int BaseDeleteTsKvQuery.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseDeleteTsKvQuery("Key", 1L, 1L), "Different type to BaseDeleteTsKvQuery");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BaseDeleteTsKvQuery#toString()}
   *   <li>{@link BaseDeleteTsKvQuery#getDeleteLatest()}
   *   <li>{@link BaseDeleteTsKvQuery#getRewriteLatestIfDeleted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean BaseDeleteTsKvQuery.getDeleteLatest()",
      "Boolean BaseDeleteTsKvQuery.getRewriteLatestIfDeleted()", "String BaseDeleteTsKvQuery.toString()"})
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
