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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class HomeDashboardDiffblueTest {
  /**
   * Test {@link HomeDashboard#HomeDashboard(Dashboard, boolean)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return MobileHide.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboard#HomeDashboard(Dashboard, boolean)}
   */
  @Test
  @DisplayName("Test new HomeDashboard(Dashboard, boolean); given 'true'; then return MobileHide")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HomeDashboard.<init>(Dashboard, boolean)"})
  void testNewHomeDashboard_givenTrue_thenReturnMobileHide() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setMobileHide(true);

    // Act
    HomeDashboard actualHomeDashboard = new HomeDashboard(dashboard, true);

    // Assert
    assertNull(actualHomeDashboard.getConfiguration());
    assertNull(actualHomeDashboard.getMobileOrder());
    assertNull(actualHomeDashboard.getVersion());
    assertNull(actualHomeDashboard.getImage());
    assertNull(actualHomeDashboard.getName());
    assertNull(actualHomeDashboard.getTitle());
    assertNull(actualHomeDashboard.getAssignedCustomers());
    assertNull(actualHomeDashboard.getUuidId());
    assertNull(actualHomeDashboard.getExternalId());
    assertNull(actualHomeDashboard.getId());
    assertNull(actualHomeDashboard.getTenantId());
    assertEquals(0L, actualHomeDashboard.getCreatedTime());
    List<ObjectNode> entityAliasesConfig = actualHomeDashboard.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(actualHomeDashboard.isMobileHide());
    assertTrue(actualHomeDashboard.isHideDashboardToolbar());
    assertSame(entityAliasesConfig, actualHomeDashboard.getWidgetsConfig());
  }

  /**
   * Test {@link HomeDashboard#HomeDashboard(Dashboard, boolean)}.
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.</li>
   *   <li>Then return not MobileHide.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboard#HomeDashboard(Dashboard, boolean)}
   */
  @Test
  @DisplayName("Test new HomeDashboard(Dashboard, boolean); when Dashboard(); then return not MobileHide")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void HomeDashboard.<init>(Dashboard, boolean)"})
  void testNewHomeDashboard_whenDashboard_thenReturnNotMobileHide() {
    // Arrange and Act
    HomeDashboard actualHomeDashboard = new HomeDashboard(new Dashboard(), true);

    // Assert
    assertNull(actualHomeDashboard.getConfiguration());
    assertNull(actualHomeDashboard.getMobileOrder());
    assertNull(actualHomeDashboard.getVersion());
    assertNull(actualHomeDashboard.getImage());
    assertNull(actualHomeDashboard.getName());
    assertNull(actualHomeDashboard.getTitle());
    assertNull(actualHomeDashboard.getAssignedCustomers());
    assertNull(actualHomeDashboard.getUuidId());
    assertNull(actualHomeDashboard.getExternalId());
    assertNull(actualHomeDashboard.getId());
    assertNull(actualHomeDashboard.getTenantId());
    assertEquals(0L, actualHomeDashboard.getCreatedTime());
    assertFalse(actualHomeDashboard.isMobileHide());
    List<ObjectNode> entityAliasesConfig = actualHomeDashboard.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(actualHomeDashboard.isHideDashboardToolbar());
    assertSame(entityAliasesConfig, actualHomeDashboard.getWidgetsConfig());
  }

  /**
   * Test {@link HomeDashboard#equals(Object)}, and {@link HomeDashboard#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboard#equals(Object)}
   *   <li>{@link HomeDashboard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboard.equals(Object)", "int HomeDashboard.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    HomeDashboard homeDashboard = new HomeDashboard(new Dashboard(), true);
    HomeDashboard homeDashboard2 = new HomeDashboard(new Dashboard(), true);

    // Act and Assert
    assertEquals(homeDashboard, homeDashboard2);
    int expectedHashCodeResult = homeDashboard.hashCode();
    assertEquals(expectedHashCodeResult, homeDashboard2.hashCode());
  }

  /**
   * Test {@link HomeDashboard#equals(Object)}, and {@link HomeDashboard#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboard#equals(Object)}
   *   <li>{@link HomeDashboard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboard.equals(Object)", "int HomeDashboard.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HomeDashboard homeDashboard = new HomeDashboard(new Dashboard(), true);

    // Act and Assert
    assertEquals(homeDashboard, homeDashboard);
    int expectedHashCodeResult = homeDashboard.hashCode();
    assertEquals(expectedHashCodeResult, homeDashboard.hashCode());
  }

  /**
   * Test {@link HomeDashboard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboard.equals(Object)", "int HomeDashboard.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HomeDashboard homeDashboard = new HomeDashboard(new Dashboard(), false);

    // Act and Assert
    assertNotEquals(homeDashboard, new HomeDashboard(new Dashboard(), true));
  }

  /**
   * Test {@link HomeDashboard#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboard.equals(Object)", "int HomeDashboard.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HomeDashboard(new Dashboard(), true), null);
  }

  /**
   * Test {@link HomeDashboard#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link HomeDashboard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboard.equals(Object)", "int HomeDashboard.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HomeDashboard(new Dashboard(), true), "Different type to HomeDashboard");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboard#setHideDashboardToolbar(boolean)}
   *   <li>{@link HomeDashboard#toString()}
   *   <li>{@link HomeDashboard#isHideDashboardToolbar()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean HomeDashboard.isHideDashboardToolbar()",
      "void HomeDashboard.setHideDashboardToolbar(boolean)", "String HomeDashboard.toString()"})
  void testGettersAndSetters() {
    // Arrange
    HomeDashboard homeDashboard = new HomeDashboard(new Dashboard(), true);

    // Act
    homeDashboard.setHideDashboardToolbar(true);
    String actualToStringResult = homeDashboard.toString();

    // Assert
    assertEquals("HomeDashboard(hideDashboardToolbar=true)", actualToStringResult);
    assertTrue(homeDashboard.isHideDashboardToolbar());
  }
}
