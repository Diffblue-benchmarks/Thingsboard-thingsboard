package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.profile.lwm2m.OtherConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.TelemetryMappingConfiguration;
import org.thingsboard.server.common.data.device.profile.lwm2m.bootstrap.LwM2MBootstrapServerCredential;

class Lwm2mDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * Lwm2mDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 =
        new Lwm2mDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(
        lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = lwm2mDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * Lwm2mDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(new TelemetryMappingConfiguration());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setObserveAttr(new TelemetryMappingConfiguration());

    // Act and Assert
    assertEquals(
        lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = lwm2mDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * Lwm2mDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setBootstrap(new ArrayList<>());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setBootstrap(new ArrayList<>());

    // Act and Assert
    assertEquals(
        lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = lwm2mDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * Lwm2mDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(new OtherConfiguration());

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setClientLwM2mSettings(new OtherConfiguration());

    // Act and Assert
    assertEquals(
        lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = lwm2mDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}, and {@link
   * Lwm2mDeviceProfileTransportConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(
        lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = lwm2mDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, lwm2mDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Lwm2mDeviceProfileTransportConfiguration(), 1);
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setObserveAttr(new TelemetryMappingConfiguration());

    // Act and Assert
    assertNotEquals(
        lwm2mDeviceProfileTransportConfiguration, new Lwm2mDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setBootstrapServerUpdateEnable(true);

    // Act and Assert
    assertNotEquals(
        lwm2mDeviceProfileTransportConfiguration, new Lwm2mDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setBootstrap(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        lwm2mDeviceProfileTransportConfiguration, new Lwm2mDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(new OtherConfiguration());

    // Act and Assert
    assertNotEquals(
        lwm2mDeviceProfileTransportConfiguration, new Lwm2mDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setObserveAttr(new TelemetryMappingConfiguration());

    // Act and Assert
    assertNotEquals(
        lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setBootstrap(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();

    Lwm2mDeviceProfileTransportConfiguration lwm2mDeviceProfileTransportConfiguration2 =
        new Lwm2mDeviceProfileTransportConfiguration();
    lwm2mDeviceProfileTransportConfiguration2.setClientLwM2mSettings(new OtherConfiguration());

    // Act and Assert
    assertNotEquals(
        lwm2mDeviceProfileTransportConfiguration, lwm2mDeviceProfileTransportConfiguration2);
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new Lwm2mDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Test {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link Lwm2mDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean Lwm2mDeviceProfileTransportConfiguration.equals(Object)",
    "int Lwm2mDeviceProfileTransportConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new Lwm2mDeviceProfileTransportConfiguration(),
        "Different type to Lwm2mDeviceProfileTransportConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link Lwm2mDeviceProfileTransportConfiguration}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#setBootstrap(List)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#setBootstrapServerUpdateEnable(boolean)}
   *   <li>{@link
   *       Lwm2mDeviceProfileTransportConfiguration#setClientLwM2mSettings(OtherConfiguration)}
   *   <li>{@link
   *       Lwm2mDeviceProfileTransportConfiguration#setObserveAttr(TelemetryMappingConfiguration)}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#toString()}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#getBootstrap()}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#getClientLwM2mSettings()}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#getObserveAttr()}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#getType()}
   *   <li>{@link Lwm2mDeviceProfileTransportConfiguration#isBootstrapServerUpdateEnable()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void Lwm2mDeviceProfileTransportConfiguration.<init>()",
    "List Lwm2mDeviceProfileTransportConfiguration.getBootstrap()",
    "OtherConfiguration Lwm2mDeviceProfileTransportConfiguration.getClientLwM2mSettings()",
    "TelemetryMappingConfiguration Lwm2mDeviceProfileTransportConfiguration.getObserveAttr()",
    "DeviceTransportType Lwm2mDeviceProfileTransportConfiguration.getType()",
    "boolean Lwm2mDeviceProfileTransportConfiguration.isBootstrapServerUpdateEnable()",
    "void Lwm2mDeviceProfileTransportConfiguration.setBootstrap(List)",
    "void Lwm2mDeviceProfileTransportConfiguration.setBootstrapServerUpdateEnable(boolean)",
    "void Lwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(OtherConfiguration)",
    "void Lwm2mDeviceProfileTransportConfiguration.setObserveAttr(TelemetryMappingConfiguration)",
    "String Lwm2mDeviceProfileTransportConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    Lwm2mDeviceProfileTransportConfiguration actualLwm2mDeviceProfileTransportConfiguration =
        new Lwm2mDeviceProfileTransportConfiguration();
    ArrayList<LwM2MBootstrapServerCredential> bootstrap = new ArrayList<>();
    actualLwm2mDeviceProfileTransportConfiguration.setBootstrap(bootstrap);
    actualLwm2mDeviceProfileTransportConfiguration.setBootstrapServerUpdateEnable(true);
    OtherConfiguration clientLwM2mSettings = new OtherConfiguration();
    actualLwm2mDeviceProfileTransportConfiguration.setClientLwM2mSettings(clientLwM2mSettings);
    TelemetryMappingConfiguration observeAttr = new TelemetryMappingConfiguration();
    actualLwm2mDeviceProfileTransportConfiguration.setObserveAttr(observeAttr);
    String actualToStringResult = actualLwm2mDeviceProfileTransportConfiguration.toString();
    List<LwM2MBootstrapServerCredential> actualBootstrap =
        actualLwm2mDeviceProfileTransportConfiguration.getBootstrap();
    OtherConfiguration actualClientLwM2mSettings =
        actualLwm2mDeviceProfileTransportConfiguration.getClientLwM2mSettings();
    TelemetryMappingConfiguration actualObserveAttr =
        actualLwm2mDeviceProfileTransportConfiguration.getObserveAttr();
    DeviceTransportType actualType = actualLwm2mDeviceProfileTransportConfiguration.getType();
    boolean actualIsBootstrapServerUpdateEnableResult =
        actualLwm2mDeviceProfileTransportConfiguration.isBootstrapServerUpdateEnable();

    // Assert
    assertEquals(
        "Lwm2mDeviceProfileTransportConfiguration(observeAttr=TelemetryMappingConfiguration(keyName=null,"
            + " observe=null, attribute=null, telemetry=null, attributeLwm2m=null), bootstrapServerUpdateEnable=true,"
            + " bootstrap=[], clientLwM2mSettings=OtherConfiguration(fwUpdateStrategy=null, swUpdateStrategy=null,"
            + " clientOnlyObserveAfterConnect=null, powerMode=null, psmActivityTimer=null, edrxCycle=null,"
            + " pagingTransmissionWindow=null, fwUpdateResource=null, swUpdateResource=null, defaultObjectIDVer=null"
            + "))",
        actualToStringResult);
    assertEquals(DeviceTransportType.LWM2M, actualType);
    assertTrue(actualBootstrap.isEmpty());
    assertTrue(actualIsBootstrapServerUpdateEnableResult);
    assertSame(bootstrap, actualBootstrap);
    assertSame(clientLwM2mSettings, actualClientLwM2mSettings);
    assertSame(observeAttr, actualObserveAttr);
  }
}
