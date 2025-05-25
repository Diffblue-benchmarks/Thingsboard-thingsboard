package org.thingsboard.server.transport.mqtt;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MqttTransportServerInitializerDiffblueTest {
  /**
   * Test {@link MqttTransportServerInitializer#MqttTransportServerInitializer(MqttTransportContext, boolean)}.
   * <p>
   * Method under test: {@link MqttTransportServerInitializer#MqttTransportServerInitializer(MqttTransportContext, boolean)}
   */
  @Test
  @DisplayName("Test new MqttTransportServerInitializer(MqttTransportContext, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttTransportServerInitializer.<init>(MqttTransportContext, boolean)"})
  void testNewMqttTransportServerInitializer() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertTrue((new MqttTransportServerInitializer(new MqttTransportContext(), true)).isSharable());
  }
}
