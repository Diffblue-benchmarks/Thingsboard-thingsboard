package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MqttTransportServiceDiffblueTest {
  /**
   * Test {@link MqttTransportService#getName()}.
   * <p>
   * Method under test: {@link MqttTransportService#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("MQTT", (new MqttTransportService()).getName());
  }
}
