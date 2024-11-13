package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.CoapDeviceType;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.TransportPayloadType;
import org.thingsboard.server.common.data.device.data.PowerMode;
import org.thingsboard.server.common.data.device.data.PowerSavingConfiguration;

class CoapDeviceProfileTransportConfigurationDiffblueTest {
  /**
   * Test
   * {@link CoapDeviceProfileTransportConfiguration#getCoapDeviceTypeConfiguration()}.
   * <p>
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#getCoapDeviceTypeConfiguration()}
   */
  @Test
  @DisplayName("Test getCoapDeviceTypeConfiguration()")
  void testGetCoapDeviceTypeConfiguration() {
    // Arrange
    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();
    coapDeviceProfileTransportConfiguration.setCoapDeviceTypeConfiguration(null);

    // Act
    CoapDeviceTypeConfiguration actualCoapDeviceTypeConfiguration = coapDeviceProfileTransportConfiguration
        .getCoapDeviceTypeConfiguration();
    actualCoapDeviceTypeConfiguration.getCoapDeviceType();

    // Assert
    assertTrue(actualCoapDeviceTypeConfiguration instanceof DefaultCoapDeviceTypeConfiguration);
    TransportPayloadTypeConfiguration transportPayloadTypeConfiguration = ((DefaultCoapDeviceTypeConfiguration) actualCoapDeviceTypeConfiguration)
        .getTransportPayloadTypeConfiguration();
    assertTrue(transportPayloadTypeConfiguration instanceof JsonTransportPayloadConfiguration);
    assertEquals(CoapDeviceType.DEFAULT, actualCoapDeviceTypeConfiguration.getCoapDeviceType());
    assertEquals(TransportPayloadType.JSON, transportPayloadTypeConfiguration.getTransportPayloadType());
  }

  /**
   * Test
   * {@link CoapDeviceProfileTransportConfiguration#getCoapDeviceTypeConfiguration()}.
   * <ul>
   *   <li>Given {@link CoapDeviceProfileTransportConfiguration} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#getCoapDeviceTypeConfiguration()}
   */
  @Test
  @DisplayName("Test getCoapDeviceTypeConfiguration(); given CoapDeviceProfileTransportConfiguration (default constructor)")
  void testGetCoapDeviceTypeConfiguration_givenCoapDeviceProfileTransportConfiguration() {
    // Arrange and Act
    CoapDeviceTypeConfiguration actualCoapDeviceTypeConfiguration = (new CoapDeviceProfileTransportConfiguration())
        .getCoapDeviceTypeConfiguration();
    actualCoapDeviceTypeConfiguration.getCoapDeviceType();

    // Assert
    assertTrue(actualCoapDeviceTypeConfiguration instanceof DefaultCoapDeviceTypeConfiguration);
    TransportPayloadTypeConfiguration transportPayloadTypeConfiguration = ((DefaultCoapDeviceTypeConfiguration) actualCoapDeviceTypeConfiguration)
        .getTransportPayloadTypeConfiguration();
    assertTrue(transportPayloadTypeConfiguration instanceof JsonTransportPayloadConfiguration);
    assertEquals(CoapDeviceType.DEFAULT, actualCoapDeviceTypeConfiguration.getCoapDeviceType());
    assertEquals(TransportPayloadType.JSON, transportPayloadTypeConfiguration.getTransportPayloadType());
  }

  /**
   * Test
   * {@link CoapDeviceProfileTransportConfiguration#getCoapDeviceTypeConfiguration()}.
   * <ul>
   *   <li>Then calls {@link CoapDeviceTypeConfiguration#getCoapDeviceType()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#getCoapDeviceTypeConfiguration()}
   */
  @Test
  @DisplayName("Test getCoapDeviceTypeConfiguration(); then calls getCoapDeviceType()")
  void testGetCoapDeviceTypeConfiguration_thenCallsGetCoapDeviceType() {
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
   * Test {@link CoapDeviceProfileTransportConfiguration#equals(Object)}, and
   * {@link CoapDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link CoapDeviceProfileTransportConfiguration#equals(Object)}, and
   * {@link CoapDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link CoapDeviceProfileTransportConfiguration#equals(Object)}, and
   * {@link CoapDeviceProfileTransportConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   *   <li>{@link CoapDeviceProfileTransportConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();

    // Act and Assert
    assertEquals(coapDeviceProfileTransportConfiguration, coapDeviceProfileTransportConfiguration);
    int expectedHashCodeResult = coapDeviceProfileTransportConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, coapDeviceProfileTransportConfiguration.hashCode());
  }

  /**
   * Test {@link CoapDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link CoapDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CoapDeviceProfileTransportConfiguration coapDeviceProfileTransportConfiguration = new CoapDeviceProfileTransportConfiguration();
    coapDeviceProfileTransportConfiguration.setCoapDeviceTypeConfiguration(mock(CoapDeviceTypeConfiguration.class));

    // Act and Assert
    assertNotEquals(coapDeviceProfileTransportConfiguration, new CoapDeviceProfileTransportConfiguration());
  }

  /**
   * Test {@link CoapDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link CoapDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link CoapDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapDeviceProfileTransportConfiguration(), null);
  }

  /**
   * Test {@link CoapDeviceProfileTransportConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CoapDeviceProfileTransportConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CoapDeviceProfileTransportConfiguration(),
        "Different type to CoapDeviceProfileTransportConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
