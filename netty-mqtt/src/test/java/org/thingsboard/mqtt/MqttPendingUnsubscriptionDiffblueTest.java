package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessageIdAndPropertiesVariableHeader;
import io.netty.handler.codec.mqtt.MqttMessageType;
import io.netty.handler.codec.mqtt.MqttProperties;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttUnsubscribeMessage;
import io.netty.handler.codec.mqtt.MqttUnsubscribePayload;
import io.netty.util.concurrent.Promise;
import java.util.ArrayList;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class MqttPendingUnsubscriptionDiffblueTest {
  /**
   * Test {@link MqttPendingUnsubscription#MqttPendingUnsubscription(Promise, String,
   * MqttUnsubscribeMessage, PendingOperation)}.
   *
   * <p>Method under test: {@link MqttPendingUnsubscription#MqttPendingUnsubscription(Promise,
   * String, MqttUnsubscribeMessage, PendingOperation)}
   */
  @Test
  @DisplayName(
      "Test new MqttPendingUnsubscription(Promise, String, MqttUnsubscribeMessage, PendingOperation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttPendingUnsubscription.<init>(Promise, String, MqttUnsubscribeMessage, PendingOperation)"
  })
  void testNewMqttPendingUnsubscription() {
    // Arrange
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    // Act
    MqttPendingUnsubscription actualMqttPendingUnsubscription =
        new MqttPendingUnsubscription(
            future,
            "Topic",
            new MqttUnsubscribeMessage(
                mqttFixedHeader, variableHeader, new MqttUnsubscribePayload(new ArrayList<>())),
            mock(PendingOperation.class));

    // Assert
    Promise<Void> future2 = actualMqttPendingUnsubscription.getFuture();
    assertTrue(future2 instanceof DefaultChannelProgressivePromise);
    assertEquals("Topic", actualMqttPendingUnsubscription.getTopic());
    assertSame(future, future2);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttPendingUnsubscription#getFuture()}
   *   <li>{@link MqttPendingUnsubscription#getTopic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Promise MqttPendingUnsubscription.getFuture()",
    "String MqttPendingUnsubscription.getTopic()"
  })
  void testGettersAndSetters() {
    // Arrange
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttPendingUnsubscription mqttPendingUnsubscription =
        new MqttPendingUnsubscription(
            future,
            "Topic",
            new MqttUnsubscribeMessage(
                mqttFixedHeader, variableHeader, new MqttUnsubscribePayload(new ArrayList<>())),
            mock(PendingOperation.class));

    // Act
    Promise<Void> actualFuture = mqttPendingUnsubscription.getFuture();

    // Assert
    assertTrue(actualFuture instanceof DefaultChannelProgressivePromise);
    assertEquals("Topic", mqttPendingUnsubscription.getTopic());
    assertSame(future, actualFuture);
  }

  /**
   * Test {@link MqttPendingUnsubscription#startRetransmissionTimer(EventLoop, Consumer)}.
   *
   * <ul>
   *   <li>Given {@link PendingOperation} {@link PendingOperation#isCanceled()} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingUnsubscription#startRetransmissionTimer(EventLoop,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test startRetransmissionTimer(EventLoop, Consumer); given PendingOperation isCanceled() return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttPendingUnsubscription.startRetransmissionTimer(EventLoop, Consumer)"
  })
  void testStartRetransmissionTimer_givenPendingOperationIsCanceledReturnTrue() {
    // Arrange
    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(true);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttPendingUnsubscription mqttPendingUnsubscription =
        new MqttPendingUnsubscription(
            future,
            "Topic",
            new MqttUnsubscribeMessage(
                mqttFixedHeader, variableHeader, new MqttUnsubscribePayload(new ArrayList<>())),
            operation);

    // Act
    mqttPendingUnsubscription.startRetransmissionTimer(
        new DefaultEventLoop(), mock(Consumer.class));

    // Assert
    verify(operation).isCanceled();
  }

  /**
   * Test {@link MqttPendingUnsubscription#startRetransmissionTimer(EventLoop, Consumer)}.
   *
   * <ul>
   *   <li>Then not {@link DefaultEventLoop#DefaultEventLoop()} Terminated.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingUnsubscription#startRetransmissionTimer(EventLoop,
   * Consumer)}
   */
  @Test
  @DisplayName(
      "Test startRetransmissionTimer(EventLoop, Consumer); then not DefaultEventLoop() Terminated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttPendingUnsubscription.startRetransmissionTimer(EventLoop, Consumer)"
  })
  void testStartRetransmissionTimer_thenNotDefaultEventLoopTerminated() {
    // Arrange
    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttPendingUnsubscription mqttPendingUnsubscription =
        new MqttPendingUnsubscription(
            future,
            "Topic",
            new MqttUnsubscribeMessage(
                mqttFixedHeader, variableHeader, new MqttUnsubscribePayload(new ArrayList<>())),
            operation);
    DefaultEventLoop eventLoop = new DefaultEventLoop();

    // Act
    mqttPendingUnsubscription.startRetransmissionTimer(eventLoop, mock(Consumer.class));

    // Assert
    verify(operation).isCanceled();
    assertFalse(eventLoop.isTerminated());
  }

  /**
   * Test {@link MqttPendingUnsubscription#onUnsubackReceived()}.
   *
   * <ul>
   *   <li>Then calls {@link PendingOperation#isCanceled()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingUnsubscription#onUnsubackReceived()}
   */
  @Test
  @DisplayName("Test onUnsubackReceived(); then calls isCanceled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingUnsubscription.onUnsubackReceived()"})
  void testOnUnsubackReceived_thenCallsIsCanceled() {
    // Arrange
    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttPendingUnsubscription mqttPendingUnsubscription =
        new MqttPendingUnsubscription(
            future,
            "Topic",
            new MqttUnsubscribeMessage(
                mqttFixedHeader, variableHeader, new MqttUnsubscribePayload(new ArrayList<>())),
            operation);
    mqttPendingUnsubscription.startRetransmissionTimer(
        new DefaultEventLoop(), mock(Consumer.class));

    // Act
    mqttPendingUnsubscription.onUnsubackReceived();

    // Assert
    verify(operation).isCanceled();
  }

  /**
   * Test {@link MqttPendingUnsubscription#onChannelClosed()}.
   *
   * <ul>
   *   <li>Then calls {@link PendingOperation#isCanceled()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingUnsubscription#onChannelClosed()}
   */
  @Test
  @DisplayName("Test onChannelClosed(); then calls isCanceled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingUnsubscription.onChannelClosed()"})
  void testOnChannelClosed_thenCallsIsCanceled() {
    // Arrange
    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttPendingUnsubscription mqttPendingUnsubscription =
        new MqttPendingUnsubscription(
            future,
            "Topic",
            new MqttUnsubscribeMessage(
                mqttFixedHeader, variableHeader, new MqttUnsubscribePayload(new ArrayList<>())),
            operation);
    mqttPendingUnsubscription.startRetransmissionTimer(
        new DefaultEventLoop(), mock(Consumer.class));

    // Act
    mqttPendingUnsubscription.onChannelClosed();

    // Assert
    verify(operation).isCanceled();
  }
}
