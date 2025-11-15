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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class LastVisitedDashboardInfoDiffblueTest {
  /**
   * Test {@link LastVisitedDashboardInfo#equals(Object)}, and {@link LastVisitedDashboardInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LastVisitedDashboardInfo#equals(Object)}
   *   <li>{@link LastVisitedDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LastVisitedDashboardInfo.equals(Object)", "int LastVisitedDashboardInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo2.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo2.setLastVisited(1L);
    lastVisitedDashboardInfo2.setStarred(true);
    lastVisitedDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
    int expectedHashCodeResult = lastVisitedDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, lastVisitedDashboardInfo2.hashCode());
  }

  /**
   * Test {@link LastVisitedDashboardInfo#equals(Object)}, and {@link LastVisitedDashboardInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LastVisitedDashboardInfo#equals(Object)}
   *   <li>{@link LastVisitedDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LastVisitedDashboardInfo.equals(Object)", "int LastVisitedDashboardInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo);
    int expectedHashCodeResult = lastVisitedDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, lastVisitedDashboardInfo.hashCode());
  }

  /**
   * Test {@link LastVisitedDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastVisitedDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LastVisitedDashboardInfo.equals(Object)", "int LastVisitedDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(UUID.randomUUID());
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo2.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo2.setLastVisited(1L);
    lastVisitedDashboardInfo2.setStarred(true);
    lastVisitedDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link LastVisitedDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastVisitedDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LastVisitedDashboardInfo.equals(Object)", "int LastVisitedDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(3L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo2.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo2.setLastVisited(1L);
    lastVisitedDashboardInfo2.setStarred(true);
    lastVisitedDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link LastVisitedDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastVisitedDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LastVisitedDashboardInfo.equals(Object)", "int LastVisitedDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(false);
    lastVisitedDashboardInfo.setTitle("Dr");

    LastVisitedDashboardInfo lastVisitedDashboardInfo2 = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo2.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo2.setLastVisited(1L);
    lastVisitedDashboardInfo2.setStarred(true);
    lastVisitedDashboardInfo2.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, lastVisitedDashboardInfo2);
  }

  /**
   * Test {@link LastVisitedDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastVisitedDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LastVisitedDashboardInfo.equals(Object)", "int LastVisitedDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, null);
  }

  /**
   * Test {@link LastVisitedDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LastVisitedDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LastVisitedDashboardInfo.equals(Object)", "int LastVisitedDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LastVisitedDashboardInfo lastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    lastVisitedDashboardInfo.setId(EntityId.NULL_UUID);
    lastVisitedDashboardInfo.setLastVisited(1L);
    lastVisitedDashboardInfo.setStarred(true);
    lastVisitedDashboardInfo.setTitle("Dr");

    // Act and Assert
    assertNotEquals(lastVisitedDashboardInfo, "Different type to LastVisitedDashboardInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LastVisitedDashboardInfo}
   *   <li>{@link LastVisitedDashboardInfo#setLastVisited(long)}
   *   <li>{@link LastVisitedDashboardInfo#setStarred(boolean)}
   *   <li>{@link LastVisitedDashboardInfo#toString()}
   *   <li>{@link LastVisitedDashboardInfo#getLastVisited()}
   *   <li>{@link LastVisitedDashboardInfo#isStarred()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LastVisitedDashboardInfo.<init>()", "long LastVisitedDashboardInfo.getLastVisited()",
      "boolean LastVisitedDashboardInfo.isStarred()", "void LastVisitedDashboardInfo.setLastVisited(long)",
      "void LastVisitedDashboardInfo.setStarred(boolean)", "String LastVisitedDashboardInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LastVisitedDashboardInfo actualLastVisitedDashboardInfo = new LastVisitedDashboardInfo();
    actualLastVisitedDashboardInfo.setLastVisited(1L);
    actualLastVisitedDashboardInfo.setStarred(true);
    String actualToStringResult = actualLastVisitedDashboardInfo.toString();
    long actualLastVisited = actualLastVisitedDashboardInfo.getLastVisited();
    boolean actualIsStarredResult = actualLastVisitedDashboardInfo.isStarred();

    // Assert
    assertEquals("LastVisitedDashboardInfo(starred=true, lastVisited=1)", actualToStringResult);
    assertNull(actualLastVisitedDashboardInfo.getTitle());
    assertNull(actualLastVisitedDashboardInfo.getId());
    assertEquals(1L, actualLastVisited);
    assertTrue(actualIsStarredResult);
  }
}
