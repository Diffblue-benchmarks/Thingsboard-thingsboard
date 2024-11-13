package org.thingsboard.monitoring.config.transport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.monitoring.service.transport.TransportHealthChecker;
import org.thingsboard.monitoring.service.transport.impl.MqttTransportHealthChecker;

class TransportTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TransportType#getName()}
   *   <li>{@link TransportType#getServiceClass()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TransportType valueOfResult = TransportType.valueOf("MQTT");

    // Act
    String actualName = valueOfResult.getName();
    Class<? extends TransportHealthChecker<?>> actualServiceClass = valueOfResult.getServiceClass();

    // Assert
    assertEquals("MQTT", actualName);
    Class<MqttTransportHealthChecker> expectedServiceClass = MqttTransportHealthChecker.class;
    assertEquals(expectedServiceClass, actualServiceClass);
  }
}
