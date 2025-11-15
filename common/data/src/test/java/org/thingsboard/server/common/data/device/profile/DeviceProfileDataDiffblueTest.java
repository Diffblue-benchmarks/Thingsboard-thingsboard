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
package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class DeviceProfileDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileData#equals(Object)}
   *   <li>{@link DeviceProfileData#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = deviceProfileData.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfileData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileData#equals(Object)}
   *   <li>{@link DeviceProfileData#hashCode()}
   * </ul>
   */
  @Test
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
    int expectedHashCodeResult = deviceProfileData.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfileData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceProfileData#equals(Object)}
   *   <li>{@link DeviceProfileData#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(null);
    deviceProfileData.setProvisionConfiguration(mock(X509CertificateChainProvisionConfiguration.class));
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
   * Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link DeviceProfileData#equals(Object)}
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceProfileData}
   *   <li>{@link DeviceProfileData#setAlarms(List)}
   *   <li>{@link DeviceProfileData#setConfiguration(DeviceProfileConfiguration)}
   *   <li>
   * {@link DeviceProfileData#setProvisionConfiguration(DeviceProfileProvisionConfiguration)}
   *   <li>
   * {@link DeviceProfileData#setTransportConfiguration(DeviceProfileTransportConfiguration)}
   *   <li>{@link DeviceProfileData#toString()}
   *   <li>{@link DeviceProfileData#getAlarms()}
   *   <li>{@link DeviceProfileData#getConfiguration()}
   *   <li>{@link DeviceProfileData#getProvisionConfiguration()}
   *   <li>{@link DeviceProfileData#getTransportConfiguration()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceProfileData actualDeviceProfileData = new DeviceProfileData();
    ArrayList<DeviceProfileAlarm> alarms = new ArrayList<>();
    actualDeviceProfileData.setAlarms(alarms);
    DeviceProfileConfiguration configuration = mock(DeviceProfileConfiguration.class);
    actualDeviceProfileData.setConfiguration(configuration);
    X509CertificateChainProvisionConfiguration provisionConfiguration = new X509CertificateChainProvisionConfiguration();
    actualDeviceProfileData.setProvisionConfiguration(provisionConfiguration);
    DeviceProfileTransportConfiguration transportConfiguration = mock(DeviceProfileTransportConfiguration.class);
    actualDeviceProfileData.setTransportConfiguration(transportConfiguration);
    actualDeviceProfileData.toString();
    List<DeviceProfileAlarm> actualAlarms = actualDeviceProfileData.getAlarms();
    DeviceProfileConfiguration actualConfiguration = actualDeviceProfileData.getConfiguration();
    DeviceProfileProvisionConfiguration actualProvisionConfiguration = actualDeviceProfileData
        .getProvisionConfiguration();
    DeviceProfileTransportConfiguration actualTransportConfiguration = actualDeviceProfileData
        .getTransportConfiguration();

    // Assert that nothing has changed
    assertTrue(actualAlarms.isEmpty());
    assertSame(alarms, actualAlarms);
    assertSame(provisionConfiguration, actualProvisionConfiguration);
    assertSame(configuration, actualConfiguration);
    assertSame(transportConfiguration, actualTransportConfiguration);
  }
}
