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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EntityId;

class HomeDashboardInfoDiffblueTest {
  /**
   * Test {@link HomeDashboardInfo#equals(Object)}, and {@link HomeDashboardInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboardInfo#equals(Object)}
   *   <li>{@link HomeDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboardInfo.equals(Object)", "int HomeDashboardInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(null, true);
    HomeDashboardInfo homeDashboardInfo2 = new HomeDashboardInfo(null, true);

    // Act and Assert
    assertEquals(homeDashboardInfo, homeDashboardInfo2);
    int expectedHashCodeResult = homeDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, homeDashboardInfo2.hashCode());
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}, and {@link HomeDashboardInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboardInfo#equals(Object)}
   *   <li>{@link HomeDashboardInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboardInfo.equals(Object)", "int HomeDashboardInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(new DashboardId(EntityId.NULL_UUID), true);
    HomeDashboardInfo homeDashboardInfo2 = new HomeDashboardInfo(new DashboardId(EntityId.NULL_UUID), true);

    // Act and Assert
    assertEquals(homeDashboardInfo, homeDashboardInfo2);
    int expectedHashCodeResult = homeDashboardInfo.hashCode();
    assertEquals(expectedHashCodeResult, homeDashboardInfo2.hashCode());
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboardInfo.equals(Object)", "int HomeDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(new DashboardId(EntityId.NULL_UUID), true);

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(null, true));
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboardInfo.equals(Object)", "int HomeDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(null, false);

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(null, true));
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboardInfo.equals(Object)", "int HomeDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new HomeDashboardInfo(null, true), 1);
  }

  /**
   * Test {@link HomeDashboardInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboardInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboardInfo.equals(Object)", "int HomeDashboardInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HomeDashboardInfo homeDashboardInfo = new HomeDashboardInfo(null, true);

    // Act and Assert
    assertNotEquals(homeDashboardInfo, new HomeDashboardInfo(new DashboardId(EntityId.NULL_UUID), true));
  }
}
