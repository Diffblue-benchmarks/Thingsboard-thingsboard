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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DashboardDiffblueTest {
  /**
   * Test {@link Dashboard#getExternalId()}.
   * <p>
   * Method under test: {@link Dashboard#getExternalId()}
   */
  @Test
  @DisplayName("Test getExternalId()")
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new Dashboard()).getExternalId());
  }

  /**
   * Test {@link Dashboard#Dashboard(DashboardInfo)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return MobileHide.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#Dashboard(DashboardInfo)}
   */
  @Test
  @DisplayName("Test new Dashboard(DashboardInfo); given 'true'; then return MobileHide")
  void testNewDashboard_givenTrue_thenReturnMobileHide() {
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

  /**
   * Test {@link Dashboard#Dashboard(Dashboard)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link Dashboard#Dashboard()} MobileHide is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#Dashboard(Dashboard)}
   */
  @Test
  @DisplayName("Test new Dashboard(Dashboard); given 'true'; when Dashboard() MobileHide is 'true'")
  void testNewDashboard_givenTrue_whenDashboardMobileHideIsTrue() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setMobileHide(true);

    // Act and Assert
    assertEquals(dashboard, new Dashboard(dashboard));
  }

  /**
   * Test {@link Dashboard#Dashboard(Dashboard)}.
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#Dashboard(Dashboard)}
   */
  @Test
  @DisplayName("Test new Dashboard(Dashboard); when Dashboard()")
  void testNewDashboard_whenDashboard() {
    // Arrange
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertEquals(dashboard, new Dashboard(dashboard));
  }

  /**
   * Test {@link Dashboard#Dashboard(DashboardInfo)}.
   * <ul>
   *   <li>When {@link DashboardInfo#DashboardInfo()}.</li>
   *   <li>Then return not MobileHide.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#Dashboard(DashboardInfo)}
   */
  @Test
  @DisplayName("Test new Dashboard(DashboardInfo); when DashboardInfo(); then return not MobileHide")
  void testNewDashboard_whenDashboardInfo_thenReturnNotMobileHide() {
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
   * Test {@link Dashboard#getEntityAliasesConfig()}.
   * <ul>
   *   <li>Given {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#getEntityAliasesConfig()}
   */
  @Test
  @DisplayName("Test getEntityAliasesConfig(); given Dashboard()")
  void testGetEntityAliasesConfig_givenDashboard() {
    // Arrange, Act and Assert
    assertTrue((new Dashboard()).getEntityAliasesConfig().isEmpty());
  }

  /**
   * Test {@link Dashboard#getEntityAliasesConfig()}.
   * <ul>
   *   <li>Given {@link Dashboard#Dashboard()} Configuration is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#getEntityAliasesConfig()}
   */
  @Test
  @DisplayName("Test getEntityAliasesConfig(); given Dashboard() Configuration is Instance")
  void testGetEntityAliasesConfig_givenDashboardConfigurationIsInstance() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertTrue(dashboard.getEntityAliasesConfig().isEmpty());
  }

  /**
   * Test {@link Dashboard#getWidgetsConfig()}.
   * <ul>
   *   <li>Given {@link Dashboard#Dashboard()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#getWidgetsConfig()}
   */
  @Test
  @DisplayName("Test getWidgetsConfig(); given Dashboard()")
  void testGetWidgetsConfig_givenDashboard() {
    // Arrange, Act and Assert
    assertTrue((new Dashboard()).getWidgetsConfig().isEmpty());
  }

  /**
   * Test {@link Dashboard#getWidgetsConfig()}.
   * <ul>
   *   <li>Given {@link Dashboard#Dashboard()} Configuration is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#getWidgetsConfig()}
   */
  @Test
  @DisplayName("Test getWidgetsConfig(); given Dashboard() Configuration is Instance")
  void testGetWidgetsConfig_givenDashboardConfigurationIsInstance() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    dashboard.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertTrue(dashboard.getWidgetsConfig().isEmpty());
  }

  /**
   * Test {@link Dashboard#equals(Object)}, and {@link Dashboard#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Dashboard#equals(Object)}
   *   <li>{@link Dashboard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link Dashboard#equals(Object)}, and {@link Dashboard#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link Dashboard#equals(Object)}
   *   <li>{@link Dashboard#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertEquals(dashboard, dashboard);
    int expectedHashCodeResult = dashboard.hashCode();
    assertEquals(expectedHashCodeResult, dashboard.hashCode());
  }

  /**
   * Test {@link Dashboard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HomeDashboard homeDashboard = new HomeDashboard(new Dashboard(), true);

    // Act and Assert
    assertNotEquals(homeDashboard, new Dashboard());
  }

  /**
   * Test {@link Dashboard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Dashboard dashboard = new Dashboard();

    // Act and Assert
    assertNotEquals(dashboard, new HomeDashboard(new Dashboard(), true));
  }

  /**
   * Test {@link Dashboard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new Dashboard(), mock(AdminSettings.class));
  }

  /**
   * Test {@link Dashboard#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Dashboard dashboard = new Dashboard();
    HomeDashboard homeDashboard = mock(HomeDashboard.class);
    when(homeDashboard.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(dashboard, homeDashboard);
  }

  /**
   * Test {@link Dashboard#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Dashboard(), null);
  }

  /**
   * Test {@link Dashboard#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link Dashboard#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Dashboard(), "Different type to Dashboard");
  }
}
