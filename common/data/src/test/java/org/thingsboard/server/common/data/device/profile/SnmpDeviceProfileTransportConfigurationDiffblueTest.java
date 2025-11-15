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
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.transport.snmp.config.SnmpCommunicationConfig;
import org.thingsboard.server.common.data.transport.snmp.config.ToServerRpcRequestSnmpCommunicationConfig;

class SnmpDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  void testValidate() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> (new SnmpDeviceProfileTransportConfiguration()).validate());
  }

  /**
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  void testValidate2() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(null);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  void testValidate3() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(null);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  void testValidate4() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(null);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(-1);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  void testValidate5() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(null);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(-1);
    snmpDeviceProfileTransportConfiguration.setRetries(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  void testValidate6() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(new ToServerRpcRequestSnmpCommunicationConfig());

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Method under test: {@link SnmpDeviceProfileTransportConfiguration#validate()}
   */
  @Test
  void testValidate7() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(null);
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(0);
    snmpDeviceProfileTransportConfiguration.setRetries(0);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> snmpDeviceProfileTransportConfiguration.validate());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(10);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setTimeoutMs(10);

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setRetries(1);

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setRetries(1);

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(new ArrayList<>());

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setCommunicationConfigs(new ArrayList<>());

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = snmpDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, snmpDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceProfileTransportConfiguration(), 1);
  }

  /**
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setTimeoutMs(10);

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setRetries(1);

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(new ArrayList<>());

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setTimeoutMs(10);

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
  }

  /**
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setRetries(1);

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
  }

  /**
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration2 = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration2.setCommunicationConfigs(new ArrayList<>());

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, snmpDeviceProfileTransportConfiguration2);
  }

  /**
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(mock(ToServerRpcRequestSnmpCommunicationConfig.class));

    SnmpDeviceProfileTransportConfiguration snmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    snmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);

    // Act and Assert
    assertNotEquals(snmpDeviceProfileTransportConfiguration, new SnmpDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Method under test:
   * {@link SnmpDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SnmpDeviceProfileTransportConfiguration(),
        "Different type to SnmpDeviceProfileTransportConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link SnmpDeviceProfileTransportConfiguration}
   *   <li>
   * {@link SnmpDeviceProfileTransportConfiguration#setCommunicationConfigs(List)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#setRetries(Integer)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#setTimeoutMs(Integer)}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#toString()}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#getCommunicationConfigs()}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#getRetries()}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#getTimeoutMs()}
   *   <li>{@link SnmpDeviceProfileTransportConfiguration#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    SnmpDeviceProfileTransportConfiguration actualSnmpDeviceProfileTransportConfiguration = new SnmpDeviceProfileTransportConfiguration();
    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    actualSnmpDeviceProfileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    actualSnmpDeviceProfileTransportConfiguration.setRetries(1);
    actualSnmpDeviceProfileTransportConfiguration.setTimeoutMs(10);
    String actualToStringResult = actualSnmpDeviceProfileTransportConfiguration.toString();
    List<SnmpCommunicationConfig> actualCommunicationConfigs = actualSnmpDeviceProfileTransportConfiguration
        .getCommunicationConfigs();
    Integer actualRetries = actualSnmpDeviceProfileTransportConfiguration.getRetries();
    Integer actualTimeoutMs = actualSnmpDeviceProfileTransportConfiguration.getTimeoutMs();
    DeviceTransportType actualType = actualSnmpDeviceProfileTransportConfiguration.getType();

    // Assert that nothing has changed
    assertEquals("SnmpDeviceProfileTransportConfiguration(timeoutMs=10, retries=1, communicationConfigs=[])",
        actualToStringResult);
    assertEquals(1, actualRetries.intValue());
    assertEquals(10, actualTimeoutMs.intValue());
    assertEquals(DeviceTransportType.SNMP, actualType);
    assertTrue(actualCommunicationConfigs.isEmpty());
    assertSame(communicationConfigs, actualCommunicationConfigs);
  }
}
