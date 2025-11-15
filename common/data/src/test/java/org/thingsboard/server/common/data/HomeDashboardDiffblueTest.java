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
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.junit.jupiter.api.Test;

class HomeDashboardDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboard#equals(Object)}
   *   <li>{@link HomeDashboard#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboard#equals(Object)}
   *   <li>{@link HomeDashboard#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    HomeDashboard homeDashboard = new HomeDashboard(new Dashboard(), true);

    // Act and Assert
    assertEquals(homeDashboard, homeDashboard);
    int expectedHashCodeResult = homeDashboard.hashCode();
    assertEquals(expectedHashCodeResult, homeDashboard.hashCode());
  }

  /**
   * Method under test: {@link HomeDashboard#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HomeDashboard(new Dashboard(), true), null);
  }

  /**
   * Method under test: {@link HomeDashboard#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new HomeDashboard(new Dashboard(), true), "Different type to HomeDashboard");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HomeDashboard#setHideDashboardToolbar(boolean)}
   *   <li>{@link HomeDashboard#toString()}
   *   <li>{@link HomeDashboard#isHideDashboardToolbar()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HomeDashboard homeDashboard = new HomeDashboard(new Dashboard(), true);

    // Act
    homeDashboard.setHideDashboardToolbar(true);
    String actualToStringResult = homeDashboard.toString();

    // Assert that nothing has changed
    assertEquals("HomeDashboard(hideDashboardToolbar=true)", actualToStringResult);
    assertTrue(homeDashboard.isHideDashboardToolbar());
  }

  /**
   * Method under test: {@link HomeDashboard#HomeDashboard(Dashboard, boolean)}
   */
  @Test
  void testNewHomeDashboard() {
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
   * Method under test: {@link HomeDashboard#HomeDashboard(Dashboard, boolean)}
   */
  @Test
  void testNewHomeDashboard2() {
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
}
