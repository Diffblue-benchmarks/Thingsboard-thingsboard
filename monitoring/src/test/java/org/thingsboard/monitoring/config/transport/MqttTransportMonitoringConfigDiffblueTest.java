package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class MqttTransportMonitoringConfigDiffblueTest {
  /**
   * Test {@link MqttTransportMonitoringConfig#equals(Object)}, and
   * {@link MqttTransportMonitoringConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttTransportMonitoringConfig#equals(Object)}
   *   <li>{@link MqttTransportMonitoringConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MqttTransportMonitoringConfig mqttTransportMonitoringConfig = new MqttTransportMonitoringConfig();
    MqttTransportMonitoringConfig mqttTransportMonitoringConfig2 = new MqttTransportMonitoringConfig();

    // Act and Assert
    assertEquals(mqttTransportMonitoringConfig, mqttTransportMonitoringConfig2);
    int expectedHashCodeResult = mqttTransportMonitoringConfig.hashCode();
    assertEquals(expectedHashCodeResult, mqttTransportMonitoringConfig2.hashCode());
  }

  /**
   * Test {@link MqttTransportMonitoringConfig#equals(Object)}, and
   * {@link MqttTransportMonitoringConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttTransportMonitoringConfig#equals(Object)}
   *   <li>{@link MqttTransportMonitoringConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MqttTransportMonitoringConfig mqttTransportMonitoringConfig = new MqttTransportMonitoringConfig();
    mqttTransportMonitoringConfig.setQos(1);

    MqttTransportMonitoringConfig mqttTransportMonitoringConfig2 = new MqttTransportMonitoringConfig();
    mqttTransportMonitoringConfig2.setQos(1);

    // Act and Assert
    assertEquals(mqttTransportMonitoringConfig, mqttTransportMonitoringConfig2);
    int expectedHashCodeResult = mqttTransportMonitoringConfig.hashCode();
    assertEquals(expectedHashCodeResult, mqttTransportMonitoringConfig2.hashCode());
  }

  /**
   * Test {@link MqttTransportMonitoringConfig#equals(Object)}, and
   * {@link MqttTransportMonitoringConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttTransportMonitoringConfig#equals(Object)}
   *   <li>{@link MqttTransportMonitoringConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MqttTransportMonitoringConfig mqttTransportMonitoringConfig = new MqttTransportMonitoringConfig();

    // Act and Assert
    assertEquals(mqttTransportMonitoringConfig, mqttTransportMonitoringConfig);
    int expectedHashCodeResult = mqttTransportMonitoringConfig.hashCode();
    assertEquals(expectedHashCodeResult, mqttTransportMonitoringConfig.hashCode());
  }

  /**
   * Test {@link MqttTransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttTransportMonitoringConfig(), 1);
  }

  /**
   * Test {@link MqttTransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MqttTransportMonitoringConfig mqttTransportMonitoringConfig = new MqttTransportMonitoringConfig();
    mqttTransportMonitoringConfig.setQos(1);

    // Act and Assert
    assertNotEquals(mqttTransportMonitoringConfig, new MqttTransportMonitoringConfig());
  }

  /**
   * Test {@link MqttTransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MqttTransportMonitoringConfig mqttTransportMonitoringConfig = new MqttTransportMonitoringConfig();
    mqttTransportMonitoringConfig.setTargets(new ArrayList<>());

    // Act and Assert
    assertNotEquals(mqttTransportMonitoringConfig, new MqttTransportMonitoringConfig());
  }

  /**
   * Test {@link MqttTransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MqttTransportMonitoringConfig mqttTransportMonitoringConfig = new MqttTransportMonitoringConfig();

    MqttTransportMonitoringConfig mqttTransportMonitoringConfig2 = new MqttTransportMonitoringConfig();
    mqttTransportMonitoringConfig2.setQos(1);

    // Act and Assert
    assertNotEquals(mqttTransportMonitoringConfig, mqttTransportMonitoringConfig2);
  }

  /**
   * Test {@link MqttTransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceConfig device = mock(DeviceConfig.class);
    doNothing().when(device).setCredentials(Mockito.<DeviceCredentials>any());
    doNothing().when(device).setId(Mockito.<String>any());
    doNothing().when(device).setName(Mockito.<String>any());
    device.setCredentials(new DeviceCredentials());
    device.setId("42");
    device.setName("Name");
    TransportMonitoringTarget transportMonitoringTarget = mock(TransportMonitoringTarget.class);
    doNothing().when(transportMonitoringTarget).setDevice(Mockito.<DeviceConfig>any());
    doNothing().when(transportMonitoringTarget).setQueue(Mockito.<String>any());
    doNothing().when(transportMonitoringTarget).setBaseUrl(Mockito.<String>any());
    doNothing().when(transportMonitoringTarget).setCheckDomainIps(anyBoolean());
    transportMonitoringTarget.setBaseUrl("https://example.org/example");
    transportMonitoringTarget.setCheckDomainIps(true);
    transportMonitoringTarget.setDevice(device);
    transportMonitoringTarget.setQueue("Queue");

    ArrayList<TransportMonitoringTarget> targets = new ArrayList<>();
    targets.add(transportMonitoringTarget);

    MqttTransportMonitoringConfig mqttTransportMonitoringConfig = new MqttTransportMonitoringConfig();
    mqttTransportMonitoringConfig.setTargets(targets);

    // Act and Assert
    assertNotEquals(mqttTransportMonitoringConfig, new MqttTransportMonitoringConfig());
  }

  /**
   * Test {@link MqttTransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttTransportMonitoringConfig(), null);
  }

  /**
   * Test {@link MqttTransportMonitoringConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttTransportMonitoringConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MqttTransportMonitoringConfig(), "Different type to MqttTransportMonitoringConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MqttTransportMonitoringConfig#setQos(Integer)}
   *   <li>{@link MqttTransportMonitoringConfig#toString()}
   *   <li>{@link MqttTransportMonitoringConfig#getQos()}
   *   <li>{@link MqttTransportMonitoringConfig#getTransportType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    MqttTransportMonitoringConfig mqttTransportMonitoringConfig = new MqttTransportMonitoringConfig();

    // Act
    mqttTransportMonitoringConfig.setQos(1);
    String actualToStringResult = mqttTransportMonitoringConfig.toString();
    Integer actualQos = mqttTransportMonitoringConfig.getQos();
    TransportType actualTransportType = mqttTransportMonitoringConfig.getTransportType();

    // Assert that nothing has changed
    assertEquals("MqttTransportMonitoringConfig(qos=1)", actualToStringResult);
    assertEquals(1, actualQos.intValue());
    assertEquals(TransportType.MQTT, actualTransportType);
  }
}
