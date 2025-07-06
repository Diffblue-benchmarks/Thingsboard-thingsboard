package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.ChannelFuture;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.mqtt.MqttConnectReturnCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MqttConnectResultDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttConnectResult#MqttConnectResult(boolean, MqttConnectReturnCode,
   *       ChannelFuture)}
   *   <li>{@link MqttConnectResult#getCloseFuture()}
   *   <li>{@link MqttConnectResult#getReturnCode()}
   *   <li>{@link MqttConnectResult#isSuccess()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttConnectResult.<init>(boolean, MqttConnectReturnCode, ChannelFuture)",
    "ChannelFuture MqttConnectResult.getCloseFuture()",
    "MqttConnectReturnCode MqttConnectResult.getReturnCode()",
    "boolean MqttConnectResult.isSuccess()"
  })
  void testGettersAndSetters() {
    // Arrange
    DefaultChannelProgressivePromise closeFuture =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());

    // Act
    MqttConnectResult actualMqttConnectResult =
        new MqttConnectResult(true, MqttConnectReturnCode.CONNECTION_ACCEPTED, closeFuture);
    ChannelFuture actualCloseFuture = actualMqttConnectResult.getCloseFuture();
    MqttConnectReturnCode actualReturnCode = actualMqttConnectResult.getReturnCode();

    // Assert
    assertTrue(actualCloseFuture instanceof DefaultChannelProgressivePromise);
    assertEquals(MqttConnectReturnCode.CONNECTION_ACCEPTED, actualReturnCode);
    assertTrue(actualMqttConnectResult.isSuccess());
    assertSame(closeFuture, actualCloseFuture);
  }
}
