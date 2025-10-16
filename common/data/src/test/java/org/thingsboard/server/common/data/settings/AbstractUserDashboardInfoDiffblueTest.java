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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;

class AbstractUserDashboardInfoDiffblueTest {
  /**
   * Test {@link AbstractUserDashboardInfo#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link LastVisitedDashboardInfo} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when LastVisitedDashboardInfo (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.canEqual(Object)"})
  void testCanEqual_whenLastVisitedDashboardInfo_thenReturnTrue() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    // Act and Assert
    assertTrue(lastVisitedDashboardInfo.canEqual(new LastVisitedDashboardInfo()));
  }

  /**
   * Test {@link AbstractUserDashboardInfo#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractUserDashboardInfo.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new LastVisitedDashboardInfo().canEqual("Other"));
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}, and {@link
   * AbstractUserDashboardInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();

    // Act and Assert
    assertEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
    assertEquals(lastVisitedDashboardInfo.hashCode(), lastVisitedDashboardInfo2.hashCode());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}, and {@link
   * AbstractUserDashboardInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    // Act and Assert
    assertEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo);
    int expectedHashCodeResult = lastVisitedDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, lastVisitedDashboardInfo.hashCode());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    StarredDashboardInfo starredDashboardInfo = new StarredDashboardInfo();
    starredDashboardInfo.setId(EntityId.NULL_UUID);
    starredDashboardInfo.setStarredAt(1L);
    starredDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, starredDashboardInfo);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn(null);
    when(lastVisitedDashboardInfo2.getId()).thenReturn(null);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(EntityId.NULL_UUID);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn(null);
    when(lastVisitedDashboardInfo2.getId()).thenReturn(null);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setTitle("Dr");

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn(null);
    when(lastVisitedDashboardInfo2.getId()).thenReturn(null);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(EntityId.NULL_UUID);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setTitle("Dr");
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(EntityId.NULL_UUID);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LastVisitedDashboardInfo(), null);
  }

  /**
   * Test {@link AbstractUserDashboardInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AbstractUserDashboardInfo.equals(Object)",
    "int AbstractUserDashboardInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LastVisitedDashboardInfo(), "Different type to AbstractUserDashboardInfo");
  }

  /**
   * Test {@link AbstractUserDashboardInfo#getId()}.
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractUserDashboardInfo.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new LastVisitedDashboardInfo().getId());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#getTitle()}.
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractUserDashboardInfo.getTitle()"})
  void testGetTitle() {
    // Arrange, Act and Assert
    assertNull(new LastVisitedDashboardInfo().getTitle());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#setId(UUID)}.
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#setId(UUID)}
   */
  @Test
  @DisplayName("Test setId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractUserDashboardInfo.setId(UUID)"})
  void testSetId() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    UUID id = EntityId.NULL_UUID;

    // Act
    lastVisitedDashboardInfo.setId(id);

    // Assert
    assertSame(id, lastVisitedDashboardInfo.getId());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#setTitle(String)}.
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#setTitle(String)}
   */
  @Test
  @DisplayName("Test setTitle(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractUserDashboardInfo.setTitle(String)"})
  void testSetTitle() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    // Act
    lastVisitedDashboardInfo.setTitle("Dr");

    // Assert
    assertEquals("Dr", lastVisitedDashboardInfo.getTitle());
  }

  /**
   * Test {@link AbstractUserDashboardInfo#toString()}.
   *
   * <p>Method under test: {@link AbstractUserDashboardInfo#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractUserDashboardInfo.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "LastVisitedDashboardInfo(starred=false, lastVisited=0)",
        new LastVisitedDashboardInfo().toString());
  }
}
