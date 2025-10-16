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
package org.thingsboard.server.common.data.page;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.page.SortOrder.Direction;

class SortOrderDiffblueTest {
  /**
   * Test {@link SortOrder#equals(Object)}, and {@link SortOrder#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SortOrder#equals(Object)}
   *   <li>{@link SortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortOrder.equals(Object)", "int SortOrder.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SortOrder sortOrder = SortOrder.BY_CREATED_TIME_DESC;
    SortOrder sortOrder2 = SortOrder.BY_CREATED_TIME_DESC;

    // Act and Assert
    assertEquals(sortOrder, sortOrder2);
    assertEquals(sortOrder.hashCode(), sortOrder2.hashCode());
  }

  /**
   * Test {@link SortOrder#equals(Object)}, and {@link SortOrder#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SortOrder#equals(Object)}
   *   <li>{@link SortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortOrder.equals(Object)", "int SortOrder.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SortOrder ofResult = SortOrder.of("Property", Direction.ASC);
    SortOrder ofResult2 = SortOrder.of("Property", Direction.ASC);

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link SortOrder#equals(Object)}, and {@link SortOrder#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SortOrder#equals(Object)}
   *   <li>{@link SortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortOrder.equals(Object)", "int SortOrder.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SortOrder ofResult = SortOrder.of("Property", null);
    SortOrder ofResult2 = SortOrder.of("Property", null);

    // Act and Assert
    assertEquals(ofResult, ofResult2);
    assertEquals(ofResult.hashCode(), ofResult2.hashCode());
  }

  /**
   * Test {@link SortOrder#equals(Object)}, and {@link SortOrder#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SortOrder#equals(Object)}
   *   <li>{@link SortOrder#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortOrder.equals(Object)", "int SortOrder.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SortOrder sortOrder = SortOrder.BY_CREATED_TIME_DESC;

    // Act and Assert
    assertEquals(sortOrder, sortOrder);
    int expectedHashCodeResult = sortOrder.hashCode();
    assertEquals(expectedHashCodeResult, sortOrder.hashCode());
  }

  /**
   * Test {@link SortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortOrder.equals(Object)", "int SortOrder.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SortOrder.of("Property", Direction.ASC), SortOrder.BY_CREATED_TIME_DESC);
  }

  /**
   * Test {@link SortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortOrder.equals(Object)", "int SortOrder.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(SortOrder.of("createdTime", Direction.ASC), SortOrder.BY_CREATED_TIME_DESC);
  }

  /**
   * Test {@link SortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortOrder.equals(Object)", "int SortOrder.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SortOrder ofResult = SortOrder.of(null, Direction.ASC);

    // Act and Assert
    assertNotEquals(ofResult, SortOrder.BY_CREATED_TIME_DESC);
  }

  /**
   * Test {@link SortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortOrder.equals(Object)", "int SortOrder.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SortOrder ofResult = SortOrder.of("Property", null);

    // Act and Assert
    assertNotEquals(ofResult, SortOrder.of("Property", Direction.ASC));
  }

  /**
   * Test {@link SortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortOrder.equals(Object)", "int SortOrder.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SortOrder.BY_CREATED_TIME_DESC, null);
  }

  /**
   * Test {@link SortOrder#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SortOrder#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SortOrder.equals(Object)", "int SortOrder.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(SortOrder.BY_CREATED_TIME_DESC, "Different type to SortOrder");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SortOrder#SortOrder(String, Direction)}
   *   <li>{@link SortOrder#toString()}
   *   <li>{@link SortOrder#getDirection()}
   *   <li>{@link SortOrder#getProperty()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SortOrder.<init>(String, Direction)",
    "Direction SortOrder.getDirection()",
    "String SortOrder.getProperty()",
    "String SortOrder.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SortOrder actualSortOrder = new SortOrder("Property", Direction.ASC);
    String actualToStringResult = actualSortOrder.toString();
    Direction actualDirection = actualSortOrder.getDirection();

    // Assert
    assertEquals("Property", actualSortOrder.getProperty());
    assertEquals("SortOrder(property=Property, direction=ASC)", actualToStringResult);
    assertEquals(Direction.ASC, actualDirection);
  }

  /**
   * Test {@link SortOrder#SortOrder(String)}.
   *
   * <p>Method under test: {@link SortOrder#SortOrder(String)}
   */
  @Test
  @DisplayName("Test new SortOrder(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SortOrder.<init>(String)"})
  void testNewSortOrder() {
    // Arrange and Act
    SortOrder actualSortOrder = new SortOrder("Property");

    // Assert
    assertEquals("Property", actualSortOrder.getProperty());
    assertEquals(Direction.ASC, actualSortOrder.getDirection());
  }

  /**
   * Test {@link SortOrder#of(String, Direction)}.
   *
   * <p>Method under test: {@link SortOrder#of(String, Direction)}
   */
  @Test
  @DisplayName("Test of(String, Direction)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"SortOrder SortOrder.of(String, Direction)"})
  void testOf() {
    // Arrange and Act
    SortOrder actualOfResult = SortOrder.of("Property", Direction.ASC);

    // Assert
    assertEquals("Property", actualOfResult.getProperty());
    assertEquals(Direction.ASC, actualOfResult.getDirection());
  }
}
