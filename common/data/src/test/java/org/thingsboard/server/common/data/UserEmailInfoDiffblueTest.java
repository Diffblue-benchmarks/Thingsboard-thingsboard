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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.UserId;

class UserEmailInfoDiffblueTest {
  /**
   * Test {@link UserEmailInfo#equals(Object)}, and {@link UserEmailInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserEmailInfo#equals(Object)}
   *   <li>{@link UserEmailInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe");
    UserEmailInfo userEmailInfo2 = new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe");

    // Act and Assert
    assertEquals(userEmailInfo, userEmailInfo2);
    int expectedHashCodeResult = userEmailInfo.hashCode();
    assertEquals(expectedHashCodeResult, userEmailInfo2.hashCode());
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}, and {@link UserEmailInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserEmailInfo#equals(Object)}
   *   <li>{@link UserEmailInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(new UserId(EntityId.NULL_UUID), "jane.doe@example.org", "Jane",
        "Doe");
    UserEmailInfo userEmailInfo2 = new UserEmailInfo(new UserId(EntityId.NULL_UUID), "jane.doe@example.org", "Jane",
        "Doe");

    // Act and Assert
    assertEquals(userEmailInfo, userEmailInfo2);
    int expectedHashCodeResult = userEmailInfo.hashCode();
    assertEquals(expectedHashCodeResult, userEmailInfo2.hashCode());
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}, and {@link UserEmailInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserEmailInfo#equals(Object)}
   *   <li>{@link UserEmailInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, null, "Jane", "Doe");
    UserEmailInfo userEmailInfo2 = new UserEmailInfo(null, null, "Jane", "Doe");

    // Act and Assert
    assertEquals(userEmailInfo, userEmailInfo2);
    int expectedHashCodeResult = userEmailInfo.hashCode();
    assertEquals(expectedHashCodeResult, userEmailInfo2.hashCode());
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}, and {@link UserEmailInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserEmailInfo#equals(Object)}
   *   <li>{@link UserEmailInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", null, "Doe");
    UserEmailInfo userEmailInfo2 = new UserEmailInfo(null, "jane.doe@example.org", null, "Doe");

    // Act and Assert
    assertEquals(userEmailInfo, userEmailInfo2);
    int expectedHashCodeResult = userEmailInfo.hashCode();
    assertEquals(expectedHashCodeResult, userEmailInfo2.hashCode());
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}, and {@link UserEmailInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link UserEmailInfo#equals(Object)}
   *   <li>{@link UserEmailInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "Jane", null);
    UserEmailInfo userEmailInfo2 = new UserEmailInfo(null, "jane.doe@example.org", "Jane", null);

    // Act and Assert
    assertEquals(userEmailInfo, userEmailInfo2);
    int expectedHashCodeResult = userEmailInfo.hashCode();
    assertEquals(expectedHashCodeResult, userEmailInfo2.hashCode());
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(new UserId(EntityId.NULL_UUID), "jane.doe@example.org", "Jane",
        "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "john.smith@example.org", "Jane", "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, null, "Jane", "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "John", "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", null, "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Smith");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "jane.doe@example.org", "Jane", null);

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange, Act and Assert
    assertNotEquals(new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"), 1);
  }

  /**
   * Test {@link UserEmailInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean UserEmailInfo.equals(Object)", "int UserEmailInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(null, "john.smith@example.org", "Jane", "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo,
        new UserEmailInfo(new UserId(EntityId.NULL_UUID), "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Test {@link UserEmailInfo#getId()}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserEmailInfo#getId()}
   */
  @Test
  @DisplayName("Test getId(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UserId UserEmailInfo.getId()"})
  void testGetId_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe")).getId());
  }
}
