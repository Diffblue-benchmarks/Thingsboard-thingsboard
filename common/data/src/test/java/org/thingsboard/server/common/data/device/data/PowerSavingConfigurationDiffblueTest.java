package org.thingsboard.server.common.data.device.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class PowerSavingConfigurationDiffblueTest {
  /**
   * Test {@link PowerSavingConfiguration#equals(Object)}, and
   * {@link PowerSavingConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PowerSavingConfiguration#equals(Object)}
   *   <li>{@link PowerSavingConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}, and
   * {@link PowerSavingConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PowerSavingConfiguration#equals(Object)}
   *   <li>{@link PowerSavingConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}, and
   * {@link PowerSavingConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link PowerSavingConfiguration#equals(Object)}
   *   <li>{@link PowerSavingConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link PowerSavingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link PowerSavingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
