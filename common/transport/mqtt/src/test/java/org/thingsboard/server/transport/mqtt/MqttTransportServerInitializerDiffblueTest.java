package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MqttTransportServerInitializerDiffblueTest {
  /**
   * Test
   * {@link MqttTransportServerInitializer#MqttTransportServerInitializer(MqttTransportContext, boolean)}.
   * <ul>
   *   <li>When {@link MqttTransportContext} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link MqttTransportServerInitializer#MqttTransportServerInitializer(MqttTransportContext, boolean)}
   */
  @Test
  @DisplayName("Test new MqttTransportServerInitializer(MqttTransportContext, boolean); when MqttTransportContext (default constructor)")
  void testNewMqttTransportServerInitializer_whenMqttTransportContext() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue((new MqttTransportServerInitializer(new MqttTransportContext(), true)).isSharable());
    assertTrue((new MqttTransportServerInitializer(mock(MqttTransportContext.class), true)).isSharable());
  }
}
