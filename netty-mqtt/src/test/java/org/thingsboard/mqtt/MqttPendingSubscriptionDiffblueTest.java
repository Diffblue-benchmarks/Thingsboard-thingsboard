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
import io.netty.handler.codec.mqtt.MqttSubscribeMessage;
import io.netty.handler.codec.mqtt.MqttSubscribePayload;
import io.netty.util.concurrent.Promise;
import java.util.ArrayList;
import java.util.Set;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.mqtt.MqttPendingSubscription.MqttPendingHandler;

class MqttPendingSubscriptionDiffblueTest {
  /**
   * Test MqttPendingHandler getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttPendingHandler#MqttPendingHandler(MqttPendingSubscription, MqttHandler,
   *       boolean)}
   *   <li>{@link MqttPendingHandler#getHandler()}
   *   <li>{@link MqttPendingHandler#isOnce()}
   * </ul>
   */
  @Test
  @DisplayName("Test MqttPendingHandler getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttPendingHandler.<init>(MqttPendingSubscription, MqttHandler, boolean)",
    "MqttHandler MqttPendingHandler.getHandler()",
    "boolean MqttPendingHandler.isOnce()"
  })
  void testMqttPendingHandlerGettersAndSetters() {
    // Arrange
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttHandler handler = mock(MqttHandler.class);

    // Act
    MqttPendingHandler actualMqttPendingHandler =
        new MqttPendingSubscription(
            future,
            "Topic",
            new MqttSubscribeMessage(
                mqttFixedHeader, variableHeader, new MqttSubscribePayload(new ArrayList<>())),
            mock(PendingOperation.class))
        .new MqttPendingHandler(handler, true);
    MqttHandler actualHandler = actualMqttPendingHandler.getHandler();

    // Assert
    assertTrue(actualMqttPendingHandler.isOnce());
    assertSame(handler, actualHandler);
  }

  /**
   * Test {@link MqttPendingSubscription#MqttPendingSubscription(Promise, String,
   * MqttSubscribeMessage, PendingOperation)}.
   *
   * <p>Method under test: {@link MqttPendingSubscription#MqttPendingSubscription(Promise, String,
   * MqttSubscribeMessage, PendingOperation)}
   */
  @Test
  @DisplayName(
      "Test new MqttPendingSubscription(Promise, String, MqttSubscribeMessage, PendingOperation)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttPendingSubscription.<init>(Promise, String, MqttSubscribeMessage, PendingOperation)"
  })
  void testNewMqttPendingSubscription() {
    // Arrange
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttSubscribeMessage message =
        new MqttSubscribeMessage(
            mqttFixedHeader, variableHeader, new MqttSubscribePayload(new ArrayList<>()));

    // Act
    MqttPendingSubscription actualMqttPendingSubscription =
        new MqttPendingSubscription(future, "Topic", message, mock(PendingOperation.class));

    // Assert
    Promise<Void> future2 = actualMqttPendingSubscription.getFuture();
    assertTrue(future2 instanceof DefaultChannelProgressivePromise);
    assertEquals("Topic", actualMqttPendingSubscription.getTopic());
    assertFalse(actualMqttPendingSubscription.isSent());
    assertTrue(actualMqttPendingSubscription.getHandlers().isEmpty());
    assertSame(future, future2);
    assertSame(message, actualMqttPendingSubscription.getSubscribeMessage());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttPendingSubscription#setSent(boolean)}
   *   <li>{@link MqttPendingSubscription#getFuture()}
   *   <li>{@link MqttPendingSubscription#getHandlers()}
   *   <li>{@link MqttPendingSubscription#getSubscribeMessage()}
   *   <li>{@link MqttPendingSubscription#getTopic()}
   *   <li>{@link MqttPendingSubscription#isSent()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "Promise MqttPendingSubscription.getFuture()",
    "Set MqttPendingSubscription.getHandlers()",
    "MqttSubscribeMessage MqttPendingSubscription.getSubscribeMessage()",
    "String MqttPendingSubscription.getTopic()",
    "boolean MqttPendingSubscription.isSent()",
    "void MqttPendingSubscription.setSent(boolean)"
  })
  void testGettersAndSetters() {
    // Arrange
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttSubscribeMessage message =
        new MqttSubscribeMessage(
            mqttFixedHeader, variableHeader, new MqttSubscribePayload(new ArrayList<>()));

    MqttPendingSubscription mqttPendingSubscription =
        new MqttPendingSubscription(future, "Topic", message, mock(PendingOperation.class));

    // Act
    mqttPendingSubscription.setSent(true);
    Promise<Void> actualFuture = mqttPendingSubscription.getFuture();
    Set<MqttPendingHandler> actualHandlers = mqttPendingSubscription.getHandlers();
    MqttSubscribeMessage actualSubscribeMessage = mqttPendingSubscription.getSubscribeMessage();
    String actualTopic = mqttPendingSubscription.getTopic();
    boolean actualIsSentResult = mqttPendingSubscription.isSent();

    // Assert
    assertTrue(actualFuture instanceof DefaultChannelProgressivePromise);
    assertEquals("Topic", actualTopic);
    assertTrue(actualHandlers.isEmpty());
    assertTrue(actualIsSentResult);
    assertSame(future, actualFuture);
    assertSame(message, actualSubscribeMessage);
  }

  /**
   * Test {@link MqttPendingSubscription#addHandler(MqttHandler, boolean)}.
   *
   * <p>Method under test: {@link MqttPendingSubscription#addHandler(MqttHandler, boolean)}
   */
  @Test
  @DisplayName("Test addHandler(MqttHandler, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingSubscription.addHandler(MqttHandler, boolean)"})
  void testAddHandler() {
    // Arrange
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttPendingSubscription mqttPendingSubscription =
        new MqttPendingSubscription(
            future,
            "Topic",
            new MqttSubscribeMessage(
                mqttFixedHeader, variableHeader, new MqttSubscribePayload(new ArrayList<>())),
            mock(PendingOperation.class));

    // Act
    mqttPendingSubscription.addHandler(mock(MqttHandler.class), true);

    // Assert
    assertEquals(1, mqttPendingSubscription.getHandlers().size());
  }

  /**
   * Test {@link MqttPendingSubscription#startRetransmitTimer(EventLoop, Consumer)}.
   *
   * <ul>
   *   <li>Then calls {@link PendingOperation#isCanceled()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingSubscription#startRetransmitTimer(EventLoop, Consumer)}
   */
  @Test
  @DisplayName("Test startRetransmitTimer(EventLoop, Consumer); then calls isCanceled()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingSubscription.startRetransmitTimer(EventLoop, Consumer)"})
  void testStartRetransmitTimer_thenCallsIsCanceled() {
    // Arrange
    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(true);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttPendingSubscription mqttPendingSubscription =
        new MqttPendingSubscription(
            future,
            "Topic",
            new MqttSubscribeMessage(
                mqttFixedHeader, variableHeader, new MqttSubscribePayload(new ArrayList<>())),
            operation);
    mqttPendingSubscription.setSent(true);

    // Act
    mqttPendingSubscription.startRetransmitTimer(new DefaultEventLoop(), mock(Consumer.class));

    // Assert that nothing has changed
    verify(operation).isCanceled();
  }

  /**
   * Test {@link MqttPendingSubscription#startRetransmitTimer(EventLoop, Consumer)}.
   *
   * <ul>
   *   <li>Then not {@link DefaultEventLoop#DefaultEventLoop()} Terminated.
   * </ul>
   *
   * <p>Method under test: {@link MqttPendingSubscription#startRetransmitTimer(EventLoop, Consumer)}
   */
  @Test
  @DisplayName(
      "Test startRetransmitTimer(EventLoop, Consumer); then not DefaultEventLoop() Terminated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttPendingSubscription.startRetransmitTimer(EventLoop, Consumer)"})
  void testStartRetransmitTimer_thenNotDefaultEventLoopTerminated() {
    // Arrange
    PendingOperation operation = mock(PendingOperation.class);
    when(operation.isCanceled()).thenReturn(false);
    DefaultChannelProgressivePromise future =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    MqttFixedHeader mqttFixedHeader =
        new MqttFixedHeader(MqttMessageType.CONNECT, true, MqttQoS.AT_MOST_ONCE, true, 3);

    MqttMessageIdAndPropertiesVariableHeader variableHeader =
        new MqttMessageIdAndPropertiesVariableHeader(1, new MqttProperties());

    MqttPendingSubscription mqttPendingSubscription =
        new MqttPendingSubscription(
            future,
            "Topic",
            new MqttSubscribeMessage(
                mqttFixedHeader, variableHeader, new MqttSubscribePayload(new ArrayList<>())),
            operation);
    mqttPendingSubscription.setSent(true);
    DefaultEventLoop eventLoop = new DefaultEventLoop();

    // Act
    mqttPendingSubscription.startRetransmitTimer(eventLoop, mock(Consumer.class));

    // Assert
    verify(operation).isCanceled();
    assertFalse(eventLoop.isTerminated());
  }
}
