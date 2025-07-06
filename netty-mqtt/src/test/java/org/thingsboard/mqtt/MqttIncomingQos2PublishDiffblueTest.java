package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttPublishMessage;
import io.netty.handler.codec.mqtt.MqttPublishVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MqttIncomingQos2PublishDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttIncomingQos2Publish#MqttIncomingQos2Publish(MqttPublishMessage)}
   *   <li>{@link MqttIncomingQos2Publish#getIncomingPublish()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttIncomingQos2Publish.<init>(MqttPublishMessage)",
    "MqttPublishMessage MqttIncomingQos2Publish.getIncomingPublish()"
  })
  void testGettersAndSetters() {
    // Arrange
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader("Topic Name", 1);

    MqttPublishMessage incomingPublish =
        new MqttPublishMessage(
            mqttFixedHeader,
            variableHeader,
            new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())));

    // Act and Assert
    assertSame(incomingPublish, new MqttIncomingQos2Publish(incomingPublish).getIncomingPublish());
  }
}
