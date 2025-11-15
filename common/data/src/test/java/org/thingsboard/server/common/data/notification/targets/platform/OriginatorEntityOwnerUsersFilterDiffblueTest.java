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
package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OriginatorEntityOwnerUsersFilterDiffblueTest {
  /**
   * Test {@link OriginatorEntityOwnerUsersFilter#equals(Object)}, and {@link OriginatorEntityOwnerUsersFilter#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OriginatorEntityOwnerUsersFilter.equals(Object)",
      "int OriginatorEntityOwnerUsersFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OriginatorEntityOwnerUsersFilter originatorEntityOwnerUsersFilter = new OriginatorEntityOwnerUsersFilter();
    OriginatorEntityOwnerUsersFilter originatorEntityOwnerUsersFilter2 = new OriginatorEntityOwnerUsersFilter();

    // Act and Assert
    assertEquals(originatorEntityOwnerUsersFilter, originatorEntityOwnerUsersFilter2);
    int expectedHashCodeResult = originatorEntityOwnerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, originatorEntityOwnerUsersFilter2.hashCode());
  }

  /**
   * Test {@link OriginatorEntityOwnerUsersFilter#equals(Object)}, and {@link OriginatorEntityOwnerUsersFilter#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OriginatorEntityOwnerUsersFilter.equals(Object)",
      "int OriginatorEntityOwnerUsersFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OriginatorEntityOwnerUsersFilter originatorEntityOwnerUsersFilter = new OriginatorEntityOwnerUsersFilter();

    // Act and Assert
    assertEquals(originatorEntityOwnerUsersFilter, originatorEntityOwnerUsersFilter);
    int expectedHashCodeResult = originatorEntityOwnerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, originatorEntityOwnerUsersFilter.hashCode());
  }

  /**
   * Test {@link OriginatorEntityOwnerUsersFilter#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OriginatorEntityOwnerUsersFilter.equals(Object)",
      "int OriginatorEntityOwnerUsersFilter.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OriginatorEntityOwnerUsersFilter(), 1);
  }

  /**
   * Test {@link OriginatorEntityOwnerUsersFilter#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OriginatorEntityOwnerUsersFilter.equals(Object)",
      "int OriginatorEntityOwnerUsersFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OriginatorEntityOwnerUsersFilter(), null);
  }

  /**
   * Test {@link OriginatorEntityOwnerUsersFilter#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OriginatorEntityOwnerUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean OriginatorEntityOwnerUsersFilter.equals(Object)",
      "int OriginatorEntityOwnerUsersFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OriginatorEntityOwnerUsersFilter(), "Different type to OriginatorEntityOwnerUsersFilter");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link OriginatorEntityOwnerUsersFilter}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#toString()}
   *   <li>{@link OriginatorEntityOwnerUsersFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void OriginatorEntityOwnerUsersFilter.<init>()",
      "UsersFilterType OriginatorEntityOwnerUsersFilter.getType()",
      "String OriginatorEntityOwnerUsersFilter.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    OriginatorEntityOwnerUsersFilter actualOriginatorEntityOwnerUsersFilter = new OriginatorEntityOwnerUsersFilter();
    String actualToStringResult = actualOriginatorEntityOwnerUsersFilter.toString();

    // Assert
    assertEquals("OriginatorEntityOwnerUsersFilter()", actualToStringResult);
    assertEquals(UsersFilterType.ORIGINATOR_ENTITY_OWNER_USERS, actualOriginatorEntityOwnerUsersFilter.getType());
  }
}
