package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DeviceProfileDataDiffblueTest {
  /**
   * Test {@link DeviceProfileData#equals(Object)}, and {@link DeviceProfileData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileData#equals(Object)}
   *   <li>{@link DeviceProfileData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(null);
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(null);

    DeviceProfileData deviceProfileData2 = new DeviceProfileData();
    deviceProfileData2.setAlarms(new ArrayList<>());
    deviceProfileData2.setConfiguration(null);
    deviceProfileData2.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData2.setTransportConfiguration(null);

    // Act and Assert
    assertEquals(deviceProfileData, deviceProfileData2);
    assertEquals(deviceProfileData.hashCode(), deviceProfileData2.hashCode());
  }

  /**
   * Test {@link DeviceProfileData#equals(Object)}, and {@link DeviceProfileData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileData#equals(Object)}
   *   <li>{@link DeviceProfileData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(null);
    deviceProfileData.setProvisionConfiguration(null);
    deviceProfileData.setTransportConfiguration(null);

    DeviceProfileData deviceProfileData2 = new DeviceProfileData();
    deviceProfileData2.setAlarms(new ArrayList<>());
    deviceProfileData2.setConfiguration(null);
    deviceProfileData2.setProvisionConfiguration(null);
    deviceProfileData2.setTransportConfiguration(null);

    // Act and Assert
    assertEquals(deviceProfileData, deviceProfileData2);
    assertEquals(deviceProfileData.hashCode(), deviceProfileData2.hashCode());
  }

  /**
   * Test {@link DeviceProfileData#equals(Object)}, and {@link DeviceProfileData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileData#equals(Object)}
   *   <li>{@link DeviceProfileData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act and Assert
    assertEquals(deviceProfileData, deviceProfileData);
    int expectedHashCodeResult = deviceProfileData.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfileData.hashCode());
  }

  /**
   * Test {@link DeviceProfileData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfileData deviceProfileData2 = new DeviceProfileData();
    deviceProfileData2.setAlarms(new ArrayList<>());
    deviceProfileData2.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData2.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData2.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceProfileData, deviceProfileData2);
  }

  /**
   * Test {@link DeviceProfileData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(null);
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfileData deviceProfileData2 = new DeviceProfileData();
    deviceProfileData2.setAlarms(new ArrayList<>());
    deviceProfileData2.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData2.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData2.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceProfileData, deviceProfileData2);
  }

  /**
   * Test {@link DeviceProfileData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(null);
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    DeviceProfileData deviceProfileData2 = new DeviceProfileData();
    deviceProfileData2.setAlarms(new ArrayList<>());
    deviceProfileData2.setConfiguration(null);
    deviceProfileData2.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData2.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceProfileData, deviceProfileData2);
  }

  /**
   * Test {@link DeviceProfileData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(null);
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(null);

    DeviceProfileData deviceProfileData2 = new DeviceProfileData();
    deviceProfileData2.setAlarms(new ArrayList<>());
    deviceProfileData2.setConfiguration(null);
    deviceProfileData2.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData2.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceProfileData, deviceProfileData2);
  }

  /**
   * Test {@link DeviceProfileData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(null);
    deviceProfileData.setProvisionConfiguration(null);
    deviceProfileData.setTransportConfiguration(null);

    DeviceProfileData deviceProfileData2 = new DeviceProfileData();
    deviceProfileData2.setAlarms(new ArrayList<>());
    deviceProfileData2.setConfiguration(null);
    deviceProfileData2.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData2.setTransportConfiguration(null);

    // Act and Assert
    assertNotEquals(deviceProfileData, deviceProfileData2);
  }

  /**
   * Test {@link DeviceProfileData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(null);
    deviceProfileData.setProvisionConfiguration(
        mock(X509CertificateChainProvisionConfiguration.class));
    deviceProfileData.setTransportConfiguration(null);

    DeviceProfileData deviceProfileData2 = new DeviceProfileData();
    deviceProfileData2.setAlarms(new ArrayList<>());
    deviceProfileData2.setConfiguration(null);
    deviceProfileData2.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData2.setTransportConfiguration(null);

    // Act and Assert
    assertNotEquals(deviceProfileData, deviceProfileData2);
  }

  /**
   * Test {@link DeviceProfileData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceProfileData, null);
  }

  /**
   * Test {@link DeviceProfileData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceProfileData.equals(Object)",
    "int DeviceProfileData.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));

    // Act and Assert
    assertNotEquals(deviceProfileData, "Different type to DeviceProfileData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceProfileData}
   *   <li>{@link DeviceProfileData#setAlarms(List)}
   *   <li>{@link DeviceProfileData#setConfiguration(DeviceProfileConfiguration)}
   *   <li>{@link DeviceProfileData#setProvisionConfiguration(DeviceProfileProvisionConfiguration)}
   *   <li>{@link DeviceProfileData#setTransportConfiguration(DeviceProfileTransportConfiguration)}
   *   <li>{@link DeviceProfileData#toString()}
   *   <li>{@link DeviceProfileData#getAlarms()}
   *   <li>{@link DeviceProfileData#getConfiguration()}
   *   <li>{@link DeviceProfileData#getProvisionConfiguration()}
   *   <li>{@link DeviceProfileData#getTransportConfiguration()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceProfileData.<init>()",
    "List DeviceProfileData.getAlarms()",
    "DeviceProfileConfiguration DeviceProfileData.getConfiguration()",
    "DeviceProfileProvisionConfiguration DeviceProfileData.getProvisionConfiguration()",
    "DeviceProfileTransportConfiguration DeviceProfileData.getTransportConfiguration()",
    "void DeviceProfileData.setAlarms(List)",
    "void DeviceProfileData.setConfiguration(DeviceProfileConfiguration)",
    "void DeviceProfileData.setProvisionConfiguration(DeviceProfileProvisionConfiguration)",
    "void DeviceProfileData.setTransportConfiguration(DeviceProfileTransportConfiguration)",
    "java.lang.String DeviceProfileData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceProfileData actualDeviceProfileData = new DeviceProfileData();
    ArrayList<DeviceProfileAlarm> alarms = new ArrayList<>();
    actualDeviceProfileData.setAlarms(alarms);
    DeviceProfileConfiguration configuration = mock(DeviceProfileConfiguration.class);
    actualDeviceProfileData.setConfiguration(configuration);
    X509CertificateChainProvisionConfiguration provisionConfiguration =
        new X509CertificateChainProvisionConfiguration();
    actualDeviceProfileData.setProvisionConfiguration(provisionConfiguration);
    DeviceProfileTransportConfiguration transportConfiguration =
        mock(DeviceProfileTransportConfiguration.class);
    actualDeviceProfileData.setTransportConfiguration(transportConfiguration);
    actualDeviceProfileData.toString();
    List<DeviceProfileAlarm> actualAlarms = actualDeviceProfileData.getAlarms();
    DeviceProfileConfiguration actualConfiguration = actualDeviceProfileData.getConfiguration();
    DeviceProfileProvisionConfiguration actualProvisionConfiguration =
        actualDeviceProfileData.getProvisionConfiguration();
    DeviceProfileTransportConfiguration actualTransportConfiguration =
        actualDeviceProfileData.getTransportConfiguration();

    // Assert
    assertTrue(actualAlarms.isEmpty());
    assertSame(alarms, actualAlarms);
    assertSame(provisionConfiguration, actualProvisionConfiguration);
    assertSame(configuration, actualConfiguration);
    assertSame(transportConfiguration, actualTransportConfiguration);
  }
}
