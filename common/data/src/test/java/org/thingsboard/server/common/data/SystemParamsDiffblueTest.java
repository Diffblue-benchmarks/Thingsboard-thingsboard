package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SystemParamsDiffblueTest {
  /**
   * Test {@link SystemParams#equals(Object)}, and {@link SystemParams#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemParams#equals(Object)}
   *   <li>{@link SystemParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertEquals(systemParams, systemParams2);
    int expectedHashCodeResult = systemParams.hashCode();
    assertEquals(expectedHashCodeResult, systemParams2.hashCode());
  }

  /**
   * Test {@link SystemParams#equals(Object)}, and {@link SystemParams#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SystemParams#equals(Object)}
   *   <li>{@link SystemParams#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertEquals(systemParams, systemParams);
    int expectedHashCodeResult = systemParams.hashCode();
    assertEquals(expectedHashCodeResult, systemParams.hashCode());
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> allowedDashboardIds = new ArrayList<>();
    allowedDashboardIds.add("foo");

    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(allowedDashboardIds);
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(false);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(false);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(3L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(1L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(false);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(false);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(false);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(null);
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(NullNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(false);

    SystemParams systemParams2 = new SystemParams();
    systemParams2.setAllowedDashboardIds(new ArrayList<>());
    systemParams2.setEdgesSupportEnabled(true);
    systemParams2.setHasRepository(true);
    systemParams2.setMaxDatapointsLimit(1L);
    systemParams2.setMaxResourceSize(3L);
    systemParams2.setMobileQrEnabled(true);
    systemParams2.setPersistDeviceStateToTelemetry(true);
    systemParams2.setTbelEnabled(true);
    systemParams2.setUserSettings(MissingNode.getInstance());
    systemParams2.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, systemParams2);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, null);
  }

  /**
   * Test {@link SystemParams#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SystemParams#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SystemParams.equals(Object)", "int SystemParams.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SystemParams systemParams = new SystemParams();
    systemParams.setAllowedDashboardIds(new ArrayList<>());
    systemParams.setEdgesSupportEnabled(true);
    systemParams.setHasRepository(true);
    systemParams.setMaxDatapointsLimit(1L);
    systemParams.setMaxResourceSize(3L);
    systemParams.setMobileQrEnabled(true);
    systemParams.setPersistDeviceStateToTelemetry(true);
    systemParams.setTbelEnabled(true);
    systemParams.setUserSettings(MissingNode.getInstance());
    systemParams.setUserTokenAccessEnabled(true);

    // Act and Assert
    assertNotEquals(systemParams, "Different type to SystemParams");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link SystemParams}
   *   <li>{@link SystemParams#setAllowedDashboardIds(List)}
   *   <li>{@link SystemParams#setEdgesSupportEnabled(boolean)}
   *   <li>{@link SystemParams#setHasRepository(boolean)}
   *   <li>{@link SystemParams#setMaxDatapointsLimit(long)}
   *   <li>{@link SystemParams#setMaxResourceSize(long)}
   *   <li>{@link SystemParams#setMobileQrEnabled(boolean)}
   *   <li>{@link SystemParams#setPersistDeviceStateToTelemetry(boolean)}
   *   <li>{@link SystemParams#setTbelEnabled(boolean)}
   *   <li>{@link SystemParams#setUserSettings(JsonNode)}
   *   <li>{@link SystemParams#setUserTokenAccessEnabled(boolean)}
   *   <li>{@link SystemParams#toString()}
   *   <li>{@link SystemParams#getAllowedDashboardIds()}
   *   <li>{@link SystemParams#getMaxDatapointsLimit()}
   *   <li>{@link SystemParams#getMaxResourceSize()}
   *   <li>{@link SystemParams#getUserSettings()}
   *   <li>{@link SystemParams#isEdgesSupportEnabled()}
   *   <li>{@link SystemParams#isHasRepository()}
   *   <li>{@link SystemParams#isMobileQrEnabled()}
   *   <li>{@link SystemParams#isPersistDeviceStateToTelemetry()}
   *   <li>{@link SystemParams#isTbelEnabled()}
   *   <li>{@link SystemParams#isUserTokenAccessEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SystemParams.<init>()", "List SystemParams.getAllowedDashboardIds()",
      "long SystemParams.getMaxDatapointsLimit()", "long SystemParams.getMaxResourceSize()",
      "JsonNode SystemParams.getUserSettings()", "boolean SystemParams.isEdgesSupportEnabled()",
      "boolean SystemParams.isHasRepository()", "boolean SystemParams.isMobileQrEnabled()",
      "boolean SystemParams.isPersistDeviceStateToTelemetry()", "boolean SystemParams.isTbelEnabled()",
      "boolean SystemParams.isUserTokenAccessEnabled()", "void SystemParams.setAllowedDashboardIds(List)",
      "void SystemParams.setEdgesSupportEnabled(boolean)", "void SystemParams.setHasRepository(boolean)",
      "void SystemParams.setMaxDatapointsLimit(long)", "void SystemParams.setMaxResourceSize(long)",
      "void SystemParams.setMobileQrEnabled(boolean)", "void SystemParams.setPersistDeviceStateToTelemetry(boolean)",
      "void SystemParams.setTbelEnabled(boolean)", "void SystemParams.setUserSettings(JsonNode)",
      "void SystemParams.setUserTokenAccessEnabled(boolean)", "String SystemParams.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SystemParams actualSystemParams = new SystemParams();
    ArrayList<String> allowedDashboardIds = new ArrayList<>();
    actualSystemParams.setAllowedDashboardIds(allowedDashboardIds);
    actualSystemParams.setEdgesSupportEnabled(true);
    actualSystemParams.setHasRepository(true);
    actualSystemParams.setMaxDatapointsLimit(1L);
    actualSystemParams.setMaxResourceSize(3L);
    actualSystemParams.setMobileQrEnabled(true);
    actualSystemParams.setPersistDeviceStateToTelemetry(true);
    actualSystemParams.setTbelEnabled(true);
    MissingNode userSettings = MissingNode.getInstance();
    actualSystemParams.setUserSettings(userSettings);
    actualSystemParams.setUserTokenAccessEnabled(true);
    String actualToStringResult = actualSystemParams.toString();
    List<String> actualAllowedDashboardIds = actualSystemParams.getAllowedDashboardIds();
    long actualMaxDatapointsLimit = actualSystemParams.getMaxDatapointsLimit();
    long actualMaxResourceSize = actualSystemParams.getMaxResourceSize();
    JsonNode actualUserSettings = actualSystemParams.getUserSettings();
    boolean actualIsEdgesSupportEnabledResult = actualSystemParams.isEdgesSupportEnabled();
    boolean actualIsHasRepositoryResult = actualSystemParams.isHasRepository();
    boolean actualIsMobileQrEnabledResult = actualSystemParams.isMobileQrEnabled();
    boolean actualIsPersistDeviceStateToTelemetryResult = actualSystemParams.isPersistDeviceStateToTelemetry();
    boolean actualIsTbelEnabledResult = actualSystemParams.isTbelEnabled();
    boolean actualIsUserTokenAccessEnabledResult = actualSystemParams.isUserTokenAccessEnabled();

    // Assert
    assertEquals("SystemParams(userTokenAccessEnabled=true, allowedDashboardIds=[], edgesSupportEnabled=true,"
        + " hasRepository=true, tbelEnabled=true, persistDeviceStateToTelemetry=true, userSettings=, maxDatapointsLimit"
        + "=1, maxResourceSize=3, mobileQrEnabled=true)", actualToStringResult);
    assertEquals(1L, actualMaxDatapointsLimit);
    assertEquals(3L, actualMaxResourceSize);
    assertTrue(actualAllowedDashboardIds.isEmpty());
    assertTrue(actualIsEdgesSupportEnabledResult);
    assertTrue(actualIsHasRepositoryResult);
    assertTrue(actualIsMobileQrEnabledResult);
    assertTrue(actualIsPersistDeviceStateToTelemetryResult);
    assertTrue(actualIsTbelEnabledResult);
    assertTrue(actualIsUserTokenAccessEnabledResult);
    assertSame(allowedDashboardIds, actualAllowedDashboardIds);
    assertSame(userSettings, actualUserSettings);
  }
}
