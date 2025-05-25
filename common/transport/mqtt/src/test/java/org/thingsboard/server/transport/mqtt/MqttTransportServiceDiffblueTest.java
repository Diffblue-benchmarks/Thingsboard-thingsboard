package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MqttTransportServiceDiffblueTest {
  /**
   * Test {@link MqttTransportService#getName()}.
   * <p>
   * Method under test: {@link MqttTransportService#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String MqttTransportService.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertEquals("MQTT", (new MqttTransportService()).getName());
  }
}
