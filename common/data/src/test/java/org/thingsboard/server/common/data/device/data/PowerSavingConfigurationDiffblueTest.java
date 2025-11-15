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
package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PowerSavingConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PowerSavingConfiguration#equals(Object)}
   *   <li>{@link PowerSavingConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    PowerSavingConfiguration powerSavingConfiguration2 = new PowerSavingConfiguration();
    powerSavingConfiguration2.setEdrxCycle(1L);
    powerSavingConfiguration2.setPagingTransmissionWindow(1L);
    powerSavingConfiguration2.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration2.setPsmActivityTimer(1L);

    // Act and Assert
    assertEquals(powerSavingConfiguration, powerSavingConfiguration2);
    int expectedHashCodeResult = powerSavingConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, powerSavingConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PowerSavingConfiguration#equals(Object)}
   *   <li>{@link PowerSavingConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration = mock(CoapDeviceTransportConfiguration.class);
    when(coapDeviceTransportConfiguration.getPowerMode()).thenReturn(PowerMode.PSM);
    when(coapDeviceTransportConfiguration.getPagingTransmissionWindow()).thenReturn(1L);
    when(coapDeviceTransportConfiguration.getEdrxCycle()).thenReturn(1L);
    when(coapDeviceTransportConfiguration.getPsmActivityTimer()).thenReturn(1L);
    when(coapDeviceTransportConfiguration.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(coapDeviceTransportConfiguration).setEdrxCycle(Mockito.<Long>any());
    doNothing().when(coapDeviceTransportConfiguration).setPagingTransmissionWindow(Mockito.<Long>any());
    doNothing().when(coapDeviceTransportConfiguration).setPowerMode(Mockito.<PowerMode>any());
    doNothing().when(coapDeviceTransportConfiguration).setPsmActivityTimer(Mockito.<Long>any());
    coapDeviceTransportConfiguration.setEdrxCycle(1L);
    coapDeviceTransportConfiguration.setPagingTransmissionWindow(1L);
    coapDeviceTransportConfiguration.setPowerMode(PowerMode.PSM);
    coapDeviceTransportConfiguration.setPsmActivityTimer(1L);

    // Act and Assert
    assertEquals(powerSavingConfiguration, coapDeviceTransportConfiguration);
    int notExpectedHashCodeResult = powerSavingConfiguration.hashCode();
    assertNotEquals(notExpectedHashCodeResult, coapDeviceTransportConfiguration.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PowerSavingConfiguration#equals(Object)}
   *   <li>{@link PowerSavingConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    // Act and Assert
    assertEquals(powerSavingConfiguration, powerSavingConfiguration);
    int expectedHashCodeResult = powerSavingConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, powerSavingConfiguration.hashCode());
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration = new CoapDeviceTransportConfiguration();
    coapDeviceTransportConfiguration.setEdrxCycle(1L);
    coapDeviceTransportConfiguration.setPagingTransmissionWindow(1L);
    coapDeviceTransportConfiguration.setPowerMode(PowerMode.PSM);
    coapDeviceTransportConfiguration.setPsmActivityTimer(1L);

    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(coapDeviceTransportConfiguration, powerSavingConfiguration);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(3L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    PowerSavingConfiguration powerSavingConfiguration2 = new PowerSavingConfiguration();
    powerSavingConfiguration2.setEdrxCycle(1L);
    powerSavingConfiguration2.setPagingTransmissionWindow(1L);
    powerSavingConfiguration2.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration2.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, powerSavingConfiguration2);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(null);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    PowerSavingConfiguration powerSavingConfiguration2 = new PowerSavingConfiguration();
    powerSavingConfiguration2.setEdrxCycle(1L);
    powerSavingConfiguration2.setPagingTransmissionWindow(1L);
    powerSavingConfiguration2.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration2.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, powerSavingConfiguration2);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(3L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    PowerSavingConfiguration powerSavingConfiguration2 = new PowerSavingConfiguration();
    powerSavingConfiguration2.setEdrxCycle(1L);
    powerSavingConfiguration2.setPagingTransmissionWindow(1L);
    powerSavingConfiguration2.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration2.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, powerSavingConfiguration2);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(null);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    PowerSavingConfiguration powerSavingConfiguration2 = new PowerSavingConfiguration();
    powerSavingConfiguration2.setEdrxCycle(1L);
    powerSavingConfiguration2.setPagingTransmissionWindow(1L);
    powerSavingConfiguration2.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration2.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, powerSavingConfiguration2);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(null);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    PowerSavingConfiguration powerSavingConfiguration2 = new PowerSavingConfiguration();
    powerSavingConfiguration2.setEdrxCycle(1L);
    powerSavingConfiguration2.setPagingTransmissionWindow(1L);
    powerSavingConfiguration2.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration2.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, powerSavingConfiguration2);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.DRX);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    PowerSavingConfiguration powerSavingConfiguration2 = new PowerSavingConfiguration();
    powerSavingConfiguration2.setEdrxCycle(1L);
    powerSavingConfiguration2.setPagingTransmissionWindow(1L);
    powerSavingConfiguration2.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration2.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, powerSavingConfiguration2);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(3L);

    PowerSavingConfiguration powerSavingConfiguration2 = new PowerSavingConfiguration();
    powerSavingConfiguration2.setEdrxCycle(1L);
    powerSavingConfiguration2.setPagingTransmissionWindow(1L);
    powerSavingConfiguration2.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration2.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, powerSavingConfiguration2);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(null);

    PowerSavingConfiguration powerSavingConfiguration2 = new PowerSavingConfiguration();
    powerSavingConfiguration2.setEdrxCycle(1L);
    powerSavingConfiguration2.setPagingTransmissionWindow(1L);
    powerSavingConfiguration2.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration2.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, powerSavingConfiguration2);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    CoapDeviceTransportConfiguration coapDeviceTransportConfiguration = new CoapDeviceTransportConfiguration();
    coapDeviceTransportConfiguration.setEdrxCycle(1L);
    coapDeviceTransportConfiguration.setPagingTransmissionWindow(1L);
    coapDeviceTransportConfiguration.setPowerMode(PowerMode.PSM);
    coapDeviceTransportConfiguration.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, coapDeviceTransportConfiguration);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, null);
  }

  /**
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PowerSavingConfiguration powerSavingConfiguration = new PowerSavingConfiguration();
    powerSavingConfiguration.setEdrxCycle(1L);
    powerSavingConfiguration.setPagingTransmissionWindow(1L);
    powerSavingConfiguration.setPowerMode(PowerMode.PSM);
    powerSavingConfiguration.setPsmActivityTimer(1L);

    // Act and Assert
    assertNotEquals(powerSavingConfiguration, "Different type to PowerSavingConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link PowerSavingConfiguration}
   *   <li>{@link PowerSavingConfiguration#setEdrxCycle(Long)}
   *   <li>{@link PowerSavingConfiguration#setPagingTransmissionWindow(Long)}
   *   <li>{@link PowerSavingConfiguration#setPowerMode(PowerMode)}
   *   <li>{@link PowerSavingConfiguration#setPsmActivityTimer(Long)}
   *   <li>{@link PowerSavingConfiguration#toString()}
   *   <li>{@link PowerSavingConfiguration#getEdrxCycle()}
   *   <li>{@link PowerSavingConfiguration#getPagingTransmissionWindow()}
   *   <li>{@link PowerSavingConfiguration#getPowerMode()}
   *   <li>{@link PowerSavingConfiguration#getPsmActivityTimer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PowerSavingConfiguration actualPowerSavingConfiguration = new PowerSavingConfiguration();
    actualPowerSavingConfiguration.setEdrxCycle(1L);
    actualPowerSavingConfiguration.setPagingTransmissionWindow(1L);
    actualPowerSavingConfiguration.setPowerMode(PowerMode.PSM);
    actualPowerSavingConfiguration.setPsmActivityTimer(1L);
    String actualToStringResult = actualPowerSavingConfiguration.toString();
    Long actualEdrxCycle = actualPowerSavingConfiguration.getEdrxCycle();
    Long actualPagingTransmissionWindow = actualPowerSavingConfiguration.getPagingTransmissionWindow();
    PowerMode actualPowerMode = actualPowerSavingConfiguration.getPowerMode();
    Long actualPsmActivityTimer = actualPowerSavingConfiguration.getPsmActivityTimer();

    // Assert that nothing has changed
    assertEquals("PowerSavingConfiguration(powerMode=PSM, psmActivityTimer=1, edrxCycle=1, pagingTransmissionWindow=1)",
        actualToStringResult);
    assertEquals(1L, actualEdrxCycle.longValue());
    assertEquals(1L, actualPagingTransmissionWindow.longValue());
    assertEquals(1L, actualPsmActivityTimer.longValue());
    assertEquals(PowerMode.PSM, actualPowerMode);
  }
}
