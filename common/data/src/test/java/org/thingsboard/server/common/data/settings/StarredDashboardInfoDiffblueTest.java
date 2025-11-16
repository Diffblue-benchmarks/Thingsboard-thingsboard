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
package org.thingsboard.server.common.data.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class StarredDashboardInfoDiffblueTest {
  /**
   * Test {@link StarredDashboardInfo#equals(Object)}, and {@link StarredDashboardInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StarredDashboardInfo#equals(Object)}
   *   <li>{@link StarredDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StarredDashboardInfo.equals(Object)",
    "int StarredDashboardInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    StarredDashboardInfo starredDashboardInfo2 = new StarredDashboardInfo();
    starredDashboardInfo2.setId(EntityId.NULL_UUID);
    starredDashboardInfo2.setStarredAt(1L);
    starredDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertEquals(starredDashboardInfo, starredDashboardInfo2);
    assertEquals(starredDashboardInfo.hashCode(), starredDashboardInfo2.hashCode());
  }

  /**
   * Test {@link StarredDashboardInfo#equals(Object)}, and {@link StarredDashboardInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StarredDashboardInfo#equals(Object)}
   *   <li>{@link StarredDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StarredDashboardInfo.equals(Object)",
    "int StarredDashboardInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertEquals(starredDashboardInfo, starredDashboardInfo);
    int expectedHashCodeResult = starredDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, starredDashboardInfo.hashCode());
  }

  /**
   * Test {@link StarredDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StarredDashboardInfo.equals(Object)",
    "int StarredDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(UUID.randomUUID());
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    StarredDashboardInfo starredDashboardInfo2 = new StarredDashboardInfo();
    starredDashboardInfo2.setId(EntityId.NULL_UUID);
    starredDashboardInfo2.setStarredAt(1L);
    starredDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(starredDashboardInfo, starredDashboardInfo2);
  }

  /**
   * Test {@link StarredDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StarredDashboardInfo.equals(Object)",
    "int StarredDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(3L);
    starredDashboardInfo.setTitle("Dr");

    StarredDashboardInfo starredDashboardInfo2 = new StarredDashboardInfo();
    starredDashboardInfo2.setId(EntityId.NULL_UUID);
    starredDashboardInfo2.setStarredAt(1L);
    starredDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(starredDashboardInfo, starredDashboardInfo2);
  }

  /**
   * Test {@link StarredDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StarredDashboardInfo.equals(Object)",
    "int StarredDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(starredDashboardInfo, null);
  }

  /**
   * Test {@link StarredDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StarredDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean StarredDashboardInfo.equals(Object)",
    "int StarredDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(starredDashboardInfo, "Different type to StarredDashboardInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link StarredDashboardInfo}
   *   <li>{@link StarredDashboardInfo#setStarredAt(long)}
   *   <li>{@link StarredDashboardInfo#toString()}
   *   <li>{@link StarredDashboardInfo#getStarredAt()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StarredDashboardInfo.<init>()",
    "long StarredDashboardInfo.getStarredAt()",
    "void StarredDashboardInfo.setStarredAt(long)",
    "String StarredDashboardInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    StarredDashboardInfo actualStarredDashboardInfo = new StarredDashboardInfo();
    actualStarredDashboardInfo.setStarredAt(1L);
    String actualToStringResult = actualStarredDashboardInfo.toString();
    long actualStarredAt = actualStarredDashboardInfo.getStarredAt();

    // Assert
    assertEquals("StarredDashboardInfo(starredAt=1)", actualToStringResult);
    assertNull(actualStarredDashboardInfo.getTitle());
    assertNull(actualStarredDashboardInfo.getId());
    assertEquals(1L, actualStarredAt);
  }
}
