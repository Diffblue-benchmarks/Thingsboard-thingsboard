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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.CoapDeviceType;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.TransportPayloadType;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.device.data.PowerSavingConfiguration;

class CoapDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#getCoapDeviceTypeConfiguration()}
   */
  @Test
  void testGetCoapDeviceTypeConfiguration() {
    // Arrange and Act
    CoapDeviceTypeConfiguration actualCoapDeviceTypeConfiguration = (new CoapDeviceProfileTransportConfiguration())
        .getCoapDeviceTypeConfiguration();
    CoapDeviceType actualCoapDeviceType = actualCoapDeviceTypeConfiguration.getCoapDeviceType();

    // Assert
    assertTrue(actualCoapDeviceTypeConfiguration instanceof DefaultCoapDeviceTypeConfiguration);
    TransportPayloadTypeConfiguration transportPayloadTypeConfiguration = ((DefaultCoapDeviceTypeConfiguration) actualCoapDeviceTypeConfiguration)
        .getTransportPayloadTypeConfiguration();
    assertTrue(transportPayloadTypeConfiguration instanceof JsonTransportPayloadConfiguration);
    assertEquals(CoapDeviceType.DEFAULT, actualCoapDeviceTypeConfiguration.getCoapDeviceType());
    assertEquals(CoapDeviceType.DEFAULT, actualCoapDeviceType);
    assertEquals(TransportPayloadType.JSON, transportPayloadTypeConfiguration.getTransportPayloadType());
  }

  /**
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#getCoapDeviceTypeConfiguration()}
   */
  @Test
  void testGetCoapDeviceTypeConfiguration2() {
    // Arrange
    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();
    coapDeviceProfileTransportConfiguration.setCoapDeviceTypeConfiguration(null);

    // Act
    CoapDeviceTypeConfiguration actualCoapDeviceTypeConfiguration = coapDeviceProfileTransportConfiguration
        .getCoapDeviceTypeConfiguration();
    CoapDeviceType actualCoapDeviceType = actualCoapDeviceTypeConfiguration.getCoapDeviceType();

    // Assert
    assertTrue(actualCoapDeviceTypeConfiguration instanceof DefaultCoapDeviceTypeConfiguration);
    TransportPayloadTypeConfiguration transportPayloadTypeConfiguration = ((DefaultCoapDeviceTypeConfiguration) actualCoapDeviceTypeConfiguration)
        .getTransportPayloadTypeConfiguration();
    assertTrue(transportPayloadTypeConfiguration instanceof JsonTransportPayloadConfiguration);
    assertEquals(CoapDeviceType.DEFAULT, actualCoapDeviceTypeConfiguration.getCoapDeviceType());
    assertEquals(CoapDeviceType.DEFAULT, actualCoapDeviceType);
    assertEquals(TransportPayloadType.JSON, transportPayloadTypeConfiguration.getTransportPayloadType());
  }

  /**
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#getCoapDeviceTypeConfiguration()}
   */
  @Test
  void testGetCoapDeviceTypeConfiguration3() {
    // Arrange
    CoapDeviceTypeConfiguration coapDeviceTypeConfiguration = mock(CoapDeviceTypeConfiguration.class);
    when(coapDeviceTypeConfiguration.getCoapDeviceType()).thenReturn(CoapDeviceType.DEFAULT);

    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();
    coapDeviceProfileTransportConfiguration.setCoapDeviceTypeConfiguration(coapDeviceTypeConfiguration);

    // Act
    CoapDeviceType actualCoapDeviceType = coapDeviceProfileTransportConfiguration.getCoapDeviceTypeConfiguration()
        .getCoapDeviceType();

    // Assert
    verify(coapDeviceTypeConfiguration).getCoapDeviceType();
    assertEquals(CoapDeviceType.DEFAULT, actualCoapDeviceType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();
    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration2 = new CoapDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(coapDeviceProfileTransportConfiguration, coapDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = coapDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, coapDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PowerSavingConfiguration clientSettings = new PowerSavingConfiguration();
    clientSettings.setEdrxCycle(1L);
    clientSettings.setPagingTransmissionWindow(1L);
    clientSettings.setPowerMode(PowerMode.PSM);
    clientSettings.setPsmActivityTimer(1L);

    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();
    coapDeviceProfileTransportConfiguration.setClientSettings(clientSettings);

    PowerSavingConfiguration clientSettings2 = new PowerSavingConfiguration();
    clientSettings2.setEdrxCycle(1L);
    clientSettings2.setPagingTransmissionWindow(1L);
    clientSettings2.setPowerMode(PowerMode.PSM);
    clientSettings2.setPsmActivityTimer(1L);

    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration2 = new CoapDeviceProfileTransportConfiguration();
    coapDeviceProfileTransportConfiguration2.setClientSettings(clientSettings2);

    // Act and Assert
    assertEquals(coapDeviceProfileTransportConfiguration, coapDeviceProfileTransportConfiguration2);
    int expectedHashCodeResult = coapDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, coapDeviceProfileTransportConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(coapDeviceProfileTransportConfiguration, coapDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = coapDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, coapDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();

    DefaultCoapDeviceTypeConfiguration defaultCoapDeviceTypeConfiguration = new DefaultCoapDeviceTypeConfiguration();
    defaultCoapDeviceTypeConfiguration
        .setTransportPayloadTypeConfiguration(mock(TransportPayloadTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(coapDeviceProfileTransportConfiguration, defaultCoapDeviceTypeConfiguration);
  }

  /**
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();
    coapDeviceProfileTransportConfiguration.setCoapDeviceTypeConfiguration(mock(CoapDeviceTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(coapDeviceProfileTransportConfiguration, new CoapDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PowerSavingConfiguration clientSettings = new PowerSavingConfiguration();
    clientSettings.setEdrxCycle(1L);
    clientSettings.setPagingTransmissionWindow(1L);
    clientSettings.setPowerMode(PowerMode.PSM);
    clientSettings.setPsmActivityTimer(1L);

    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();
    coapDeviceProfileTransportConfiguration.setClientSettings(clientSettings);

    // Act and Assert
    assertNotEquals(coapDeviceProfileTransportConfiguration, new CoapDeviceProfileTransportConfiguration());
  }

  /**
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();

    PowerSavingConfiguration clientSettings = new PowerSavingConfiguration();
    clientSettings.setEdrxCycle(1L);
    clientSettings.setPagingTransmissionWindow(1L);
    clientSettings.setPowerMode(PowerMode.PSM);
    clientSettings.setPsmActivityTimer(1L);

    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration2 = new CoapDeviceProfileTransportConfiguration();
    coapDeviceProfileTransportConfiguration2.setClientSettings(clientSettings);

    // Act and Assert
    assertNotEquals(coapDeviceProfileTransportConfiguration, coapDeviceProfileTransportConfiguration2);
  }

  /**
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapDeviceProfileTransportConfiguration(),
        "Different type to CoapDeviceProfileTransportConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link CoapDeviceProfileTransportConfiguration}
   *   <li>
   * {@link CoapDeviceProfileTransportConfiguration#setClientSettings(PowerSavingConfiguration)}
   *   <li>
   * {@link CoapDeviceProfileTransportConfiguration#setCoapDeviceTypeConfiguration(CoapDeviceTypeConfiguration)}
   *   <li>{@link CoapDeviceProfileTransportConfiguration#toString()}
   *   <li>{@link CoapDeviceProfileTransportConfiguration#getClientSettings()}
   *   <li>{@link CoapDeviceProfileTransportConfiguration#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CoapDeviceProfileTransportConfiguration actualCoapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();
    PowerSavingConfiguration clientSettings = new PowerSavingConfiguration();
    clientSettings.setEdrxCycle(1L);
    clientSettings.setPagingTransmissionWindow(1L);
    clientSettings.setPowerMode(PowerMode.PSM);
    clientSettings.setPsmActivityTimer(1L);
    actualCoapDeviceProfileTransportConfiguration.setClientSettings(clientSettings);
    actualCoapDeviceProfileTransportConfiguration
        .setCoapDeviceTypeConfiguration(mock(CoapDeviceTypeConfiguration.class));
    actualCoapDeviceProfileTransportConfiguration.toString();
    PowerSavingConfiguration actualClientSettings = actualCoapDeviceProfileTransportConfiguration.getClientSettings();

    // Assert that nothing has changed
    assertEquals(DeviceTransportType.COAP, actualCoapDeviceProfileTransportConfiguration.getType());
    assertSame(clientSettings, actualClientSettings);
  }
}
