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
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;

class AbstractUserDashboardInfoDiffblueTest {
  /**
   * Method under test: {@link AbstractUserDashboardInfo#canEqual(Object)}
   */
  @Test
  void testCanEqual() {
    // Arrange, Act and Assert
    assertFalse((new LastVisitedDashboardInfo()).canEqual("Other"));
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#canEqual(Object)}
   */
  @Test
  void testCanEqual2() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    // Act and Assert
    assertTrue(lastVisitedDashboardInfo.canEqual(new LastVisitedDashboardInfo()));
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();

    // Act and Assert
    assertEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
    int expectedHashCodeResult = lastVisitedDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, lastVisitedDashboardInfo2.hashCode());
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    // Act and Assert
    assertEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo);
    int expectedHashCodeResult = lastVisitedDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, lastVisitedDashboardInfo.hashCode());
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
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
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(null);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(UUID.randomUUID());
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
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setTitle("Dr");
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(null);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setTitle("Mr");
    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = mock(LastVisitedDashboardInfo.class);
    when(lastVisitedDashboardInfo2.isStarred()).thenReturn(true);
    when(lastVisitedDashboardInfo2.getTitle()).thenReturn("Dr");
    when(lastVisitedDashboardInfo2.getId()).thenReturn(null);
    when(lastVisitedDashboardInfo2.getLastVisited()).thenReturn(1L);
    when(lastVisitedDashboardInfo2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LastVisitedDashboardInfo(), null);
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LastVisitedDashboardInfo(), "Different type to AbstractUserDashboardInfo");
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new LastVisitedDashboardInfo()).getId());
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#getTitle()}
   */
  @Test
  void testGetTitle() {
    // Arrange, Act and Assert
    assertNull((new LastVisitedDashboardInfo()).getTitle());
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#setId(UUID)}
   */
  @Test
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
   * Method under test: {@link AbstractUserDashboardInfo#setTitle(String)}
   */
  @Test
  void testSetTitle() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();

    // Act
    lastVisitedDashboardInfo.setTitle("Dr");

    // Assert
    assertEquals("Dr", lastVisitedDashboardInfo.getTitle());
  }

  /**
   * Method under test: {@link AbstractUserDashboardInfo#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("LastVisitedDashboardInfo(starred=false, lastVisited=0)", (new LastVisitedDashboardInfo()).toString());
  }
}
