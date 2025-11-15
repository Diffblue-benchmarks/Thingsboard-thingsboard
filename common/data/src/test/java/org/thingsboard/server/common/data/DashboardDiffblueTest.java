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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DashboardDiffblueTest {
  /**
   * Method under test: {@link Dashboard#getEntityAliasesConfig()}
   */
  @Test
  void testGetEntityAliasesConfig() {
    // Arrange, Act and Assert
    assertTrue((new Dashboard()).getEntityAliasesConfig().isEmpty());
  }

  /**
   * Method under test: {@link Dashboard#getEntityAliasesConfig()}
   */
  @Test
  void testGetEntityAliasesConfig2() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertTrue(dashboard.getEntityAliasesConfig().isEmpty());
  }

  /**
   * Method under test: {@link Dashboard#getWidgetsConfig()}
   */
  @Test
  void testGetWidgetsConfig() {
    // Arrange, Act and Assert
    assertTrue((new Dashboard()).getWidgetsConfig().isEmpty());
  }

  /**
   * Method under test: {@link Dashboard#getWidgetsConfig()}
   */
  @Test
  void testGetWidgetsConfig2() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertTrue(dashboard.getWidgetsConfig().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Dashboard#equals(Object)}
   *   <li>{@link Dashboard#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    Dashboard dashboard2 = new Dashboard();

    // Act and Assert
    assertEquals(dashboard, dashboard2);
    int expectedHashCodeResult = dashboard.hashCode();
    assertEquals(expectedHashCodeResult, dashboard2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link Dashboard#equals(Object)}
   *   <li>{@link Dashboard#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertEquals(dashboard, dashboard);
    int expectedHashCodeResult = dashboard.hashCode();
    assertEquals(expectedHashCodeResult, dashboard.hashCode());
  }

  /**
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HomeDashboard homeDashboard = new HomeDashboard(new Dashboard(), true);

    // Act and Assert
    assertNotEquals(homeDashboard, new Dashboard());
  }

  /**
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertNotEquals(dashboard, new HomeDashboard(new Dashboard(), true));
  }

  /**
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new Dashboard(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    HomeDashboard homeDashboard = mock(HomeDashboard.class);
    when(homeDashboard.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(dashboard, homeDashboard);
  }

  /**
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Dashboard(), null);
  }

  /**
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Dashboard(), "Different type to Dashboard");
  }

  /**
   * Method under test: {@link Dashboard#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new Dashboard()).getExternalId());
  }

  /**
   * Method under test: {@link Dashboard#Dashboard(Dashboard)}
   */
  @Test
  void testNewDashboard() {
    // Arrange
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertEquals(dashboard, new Dashboard(dashboard));
  }

  /**
   * Method under test: {@link Dashboard#Dashboard(Dashboard)}
   */
  @Test
  void testNewDashboard2() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setMobileHide(true);

    // Act and Assert
    assertEquals(dashboard, new Dashboard(dashboard));
  }

  /**
   * Method under test: {@link Dashboard#Dashboard(DashboardInfo)}
   */
  @Test
  void testNewDashboard3() {
    // Arrange and Act
    Dashboard actualDashboard = new Dashboard(new DashboardInfo());

    // Assert
    assertNull(actualDashboard.getConfiguration());
    assertNull(actualDashboard.getMobileOrder());
    assertNull(actualDashboard.getVersion());
    assertNull(actualDashboard.getImage());
    assertNull(actualDashboard.getName());
    assertNull(actualDashboard.getTitle());
    assertNull(actualDashboard.getAssignedCustomers());
    assertNull(actualDashboard.getUuidId());
    assertNull(actualDashboard.getExternalId());
    assertNull(actualDashboard.getId());
    assertNull(actualDashboard.getTenantId());
    assertEquals(0L, actualDashboard.getCreatedTime());
    assertFalse(actualDashboard.isMobileHide());
    List<ObjectNode> entityAliasesConfig = actualDashboard.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertSame(entityAliasesConfig, actualDashboard.getWidgetsConfig());
  }

  /**
   * Method under test: {@link Dashboard#Dashboard(DashboardInfo)}
   */
  @Test
  void testNewDashboard4() {
    // Arrange
    DashboardInfo dashboardInfo = new DashboardInfo();
    dashboardInfo.setMobileHide(true);

    // Act
    Dashboard actualDashboard = new Dashboard(dashboardInfo);

    // Assert
    assertNull(actualDashboard.getConfiguration());
    assertNull(actualDashboard.getMobileOrder());
    assertNull(actualDashboard.getVersion());
    assertNull(actualDashboard.getImage());
    assertNull(actualDashboard.getName());
    assertNull(actualDashboard.getTitle());
    assertNull(actualDashboard.getAssignedCustomers());
    assertNull(actualDashboard.getUuidId());
    assertNull(actualDashboard.getExternalId());
    assertNull(actualDashboard.getId());
    assertNull(actualDashboard.getTenantId());
    assertEquals(0L, actualDashboard.getCreatedTime());
    List<ObjectNode> entityAliasesConfig = actualDashboard.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(actualDashboard.isMobileHide());
    assertSame(entityAliasesConfig, actualDashboard.getWidgetsConfig());
  }
}
