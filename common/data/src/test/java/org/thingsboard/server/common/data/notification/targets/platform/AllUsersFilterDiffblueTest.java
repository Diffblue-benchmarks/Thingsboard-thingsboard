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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AllUsersFilterDiffblueTest {
  /**
   * Test {@link AllUsersFilter#equals(Object)}, and {@link AllUsersFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AllUsersFilter#equals(Object)}
   *   <li>{@link AllUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AllUsersFilter.equals(Object)", "int AllUsersFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AllUsersFilter allUsersFilter = new AllUsersFilter();
    AllUsersFilter allUsersFilter2 = new AllUsersFilter();

    // Act and Assert
    assertEquals(allUsersFilter, allUsersFilter2);
    assertEquals(allUsersFilter.hashCode(), allUsersFilter2.hashCode());
  }

  /**
   * Test {@link AllUsersFilter#equals(Object)}, and {@link AllUsersFilter#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AllUsersFilter#equals(Object)}
   *   <li>{@link AllUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AllUsersFilter.equals(Object)", "int AllUsersFilter.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AllUsersFilter allUsersFilter = new AllUsersFilter();

    // Act and Assert
    assertEquals(allUsersFilter, allUsersFilter);
    int expectedHashCodeResult = allUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, allUsersFilter.hashCode());
  }

  /**
   * Test {@link AllUsersFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AllUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AllUsersFilter.equals(Object)", "int AllUsersFilter.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AllUsersFilter(), null);
  }

  /**
   * Test {@link AllUsersFilter#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AllUsersFilter#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AllUsersFilter.equals(Object)", "int AllUsersFilter.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AllUsersFilter(), "Different type to AllUsersFilter");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AllUsersFilter}
   *   <li>{@link AllUsersFilter#toString()}
   *   <li>{@link AllUsersFilter#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AllUsersFilter.<init>()",
    "UsersFilterType AllUsersFilter.getType()",
    "String AllUsersFilter.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AllUsersFilter actualAllUsersFilter = new AllUsersFilter();
    String actualToStringResult = actualAllUsersFilter.toString();

    // Assert
    assertEquals("AllUsersFilter()", actualToStringResult);
    assertEquals(UsersFilterType.ALL_USERS, actualAllUsersFilter.getType());
  }
}
