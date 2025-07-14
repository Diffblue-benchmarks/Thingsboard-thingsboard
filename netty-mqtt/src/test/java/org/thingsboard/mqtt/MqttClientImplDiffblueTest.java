package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.collect.HashMultimap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.mqtt.MqttMessageIdAndPropertiesVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttTopicSubscription;
import io.netty.handler.codec.mqtt.MqttVersion;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.common.util.ListeningExecutor;

class MqttClientImplDiffblueTest {
  /**
   * Test {@link MqttClientImpl#MqttClientImpl(MqttClientConfig, MqttHandler, ListeningExecutor)}.
   *
   * <p>Method under test: {@link MqttClientImpl#MqttClientImpl(MqttClientConfig, MqttHandler,
   * ListeningExecutor)}
   */
  @Test
  @DisplayName("Test new MqttClientImpl(MqttClientConfig, MqttHandler, ListeningExecutor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void MqttClientImpl.<init>(MqttClientConfig, MqttHandler, ListeningExecutor)"
  })
  void testNewMqttClientImpl() {
    // Arrange
    MqttClientConfig clientConfig = new MqttClientConfig();
    MqttHandler defaultHandler = mock(MqttHandler.class);
    ListeningExecutor handlerExecutor = mock(ListeningExecutor.class);

    // Act
    MqttClientImpl actualMqttClientImpl =
        new MqttClientImpl(clientConfig, defaultHandler, handlerExecutor);

    // Assert
    assertNull(actualMqttClientImpl.getEventLoop());
    assertNull(actualMqttClientImpl.getCallback());
    assertFalse(actualMqttClientImpl.isConnected());
    assertFalse(actualMqttClientImpl.isReconnect());
    assertTrue(actualMqttClientImpl.getPendingPublishes().isEmpty());
    assertTrue(actualMqttClientImpl.getPendingServerUnsubscribes().isEmpty());
    assertTrue(actualMqttClientImpl.getPendingSubscriptions().isEmpty());
    assertTrue(actualMqttClientImpl.getQos2PendingIncomingPublishes().isEmpty());
    assertTrue(actualMqttClientImpl.getPendingSubscribeTopics().isEmpty());
    assertTrue(actualMqttClientImpl.getServerSubscriptions().isEmpty());
    assertSame(clientConfig, actualMqttClientImpl.getClientConfig());
    assertSame(handlerExecutor, actualMqttClientImpl.getHandlerExecutor());
    assertSame(defaultHandler, actualMqttClientImpl.getDefaultHandler());
  }

  /**
   * Test {@link MqttClientImpl#MqttClientImpl(MqttHandler, ListeningExecutor)}.
   *
   * <p>Method under test: {@link MqttClientImpl#MqttClientImpl(MqttHandler, ListeningExecutor)}
   */
  @Test
  @DisplayName("Test new MqttClientImpl(MqttHandler, ListeningExecutor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttClientImpl.<init>(MqttHandler, ListeningExecutor)"})
  void testNewMqttClientImpl2() {
    // Arrange
    MqttHandler defaultHandler = mock(MqttHandler.class);
    ListeningExecutor handlerExecutor = mock(ListeningExecutor.class);

    // Act
    MqttClientImpl actualMqttClientImpl = new MqttClientImpl(defaultHandler, handlerExecutor);

    // Assert
    assertNull(actualMqttClientImpl.getEventLoop());
    assertNull(actualMqttClientImpl.getCallback());
    assertFalse(actualMqttClientImpl.isConnected());
    assertFalse(actualMqttClientImpl.isReconnect());
    assertTrue(actualMqttClientImpl.getPendingPublishes().isEmpty());
    assertTrue(actualMqttClientImpl.getPendingServerUnsubscribes().isEmpty());
    assertTrue(actualMqttClientImpl.getPendingSubscriptions().isEmpty());
    assertTrue(actualMqttClientImpl.getQos2PendingIncomingPublishes().isEmpty());
    assertTrue(actualMqttClientImpl.getPendingSubscribeTopics().isEmpty());
    assertTrue(actualMqttClientImpl.getServerSubscriptions().isEmpty());
    assertSame(handlerExecutor, actualMqttClientImpl.getHandlerExecutor());
    assertSame(defaultHandler, actualMqttClientImpl.getDefaultHandler());
  }

  /**
   * Test {@link MqttClientImpl#on(String, MqttHandler)} with {@code topic}, {@code handler}.
   *
   * <p>Method under test: {@link MqttClientImpl#on(String, MqttHandler)}
   */
  @Test
  @DisplayName("Test on(String, MqttHandler) with 'topic', 'handler'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.on(String, MqttHandler)"})
  void testOnWithTopicHandler() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act
    Future<Void> actualOnResult = mqttClientImpl.on("Topic", mock(MqttHandler.class));

    // Assert
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    assertTrue(
        getResult.getSubscribeMessage().variableHeader()
            instanceof MqttMessageIdAndPropertiesVariableHeader);
    assertTrue(actualOnResult instanceof DefaultPromise);
    assertEquals("Topic", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(1, getResult.getHandlers().size());
    assertFalse(getResult.isSent());
    assertTrue(pendingSubscribeTopics.contains("Topic"));
    assertTrue(mqttClientImpl.getHandlerToSubscription().entries().isEmpty());
  }

  /**
   * Test {@link MqttClientImpl#on(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#on(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName("Test on(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.on(String, MqttHandler, MqttQoS)"})
  void testOnWithTopicHandlerQos() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act
    Future<Void> actualOnResult =
        mqttClientImpl.on("Topic", mock(MqttHandler.class), MqttQoS.AT_MOST_ONCE);

    // Assert
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    assertTrue(
        getResult.getSubscribeMessage().variableHeader()
            instanceof MqttMessageIdAndPropertiesVariableHeader);
    assertTrue(actualOnResult instanceof DefaultPromise);
    assertEquals("Topic", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(1, getResult.getHandlers().size());
    assertFalse(getResult.isSent());
    assertTrue(pendingSubscribeTopics.contains("Topic"));
    assertTrue(mqttClientImpl.getHandlerToSubscription().entries().isEmpty());
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler)} with {@code topic}, {@code handler}.
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler)}
   */
  @Test
  @DisplayName("Test once(String, MqttHandler) with 'topic', 'handler'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler)"})
  void testOnceWithTopicHandler() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act
    Future<Void> actualOnceResult = mqttClientImpl.once("Topic", mock(MqttHandler.class));

    // Assert
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    assertTrue(
        getResult.getSubscribeMessage().variableHeader()
            instanceof MqttMessageIdAndPropertiesVariableHeader);
    assertTrue(actualOnceResult instanceof DefaultPromise);
    assertEquals("Topic", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(1, getResult.getHandlers().size());
    assertFalse(getResult.isSent());
    assertTrue(pendingSubscribeTopics.contains("Topic"));
    assertTrue(mqttClientImpl.getHandlerToSubscription().entries().isEmpty());
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName("Test once(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler, MqttQoS)"})
  void testOnceWithTopicHandlerQos() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act
    mqttClientImpl.once("Topic", mock(MqttHandler.class), MqttQoS.AT_MOST_ONCE);

    // Assert
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    List<MqttTopicSubscription> topicSubscriptionsResult =
        getResult.getSubscribeMessage().payload().topicSubscriptions();
    assertEquals(1, topicSubscriptionsResult.size());
    MqttTopicSubscription getResult2 = topicSubscriptionsResult.get(0);
    assertEquals("Topic", getResult2.topicFilter());
    assertEquals("Topic", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(MqttQoS.AT_MOST_ONCE, getResult2.option().qos());
    assertTrue(pendingSubscribeTopics.contains("Topic"));
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName("Test once(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler, MqttQoS)"})
  void testOnceWithTopicHandlerQos2() {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.once("Topic", mock(MqttHandler.class), MqttQoS.AT_MOST_ONCE);

    // Assert
    verify(eventLoop, atLeast(1)).next();
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    List<MqttTopicSubscription> topicSubscriptionsResult =
        getResult.getSubscribeMessage().payload().topicSubscriptions();
    assertEquals(1, topicSubscriptionsResult.size());
    MqttTopicSubscription getResult2 = topicSubscriptionsResult.get(0);
    assertEquals("Topic", getResult2.topicFilter());
    assertEquals("Topic", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(MqttQoS.AT_MOST_ONCE, getResult2.option().qos());
    assertTrue(pendingSubscribeTopics.contains("Topic"));
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName("Test once(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler, MqttQoS)"})
  void testOnceWithTopicHandlerQos3() {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.once("Topic", mock(MqttHandler.class), MqttQoS.EXACTLY_ONCE);

    // Assert
    verify(eventLoop, atLeast(1)).next();
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    List<MqttTopicSubscription> topicSubscriptionsResult =
        getResult.getSubscribeMessage().payload().topicSubscriptions();
    assertEquals(1, topicSubscriptionsResult.size());
    MqttTopicSubscription getResult2 = topicSubscriptionsResult.get(0);
    assertEquals("Topic", getResult2.topicFilter());
    assertEquals("Topic", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(MqttQoS.EXACTLY_ONCE, getResult2.option().qos());
    assertTrue(pendingSubscribeTopics.contains("Topic"));
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName("Test once(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler, MqttQoS)"})
  void testOnceWithTopicHandlerQos4() {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.once(
        "org.thingsboard.mqtt.MqttClientImpl", mock(MqttHandler.class), MqttQoS.EXACTLY_ONCE);

    // Assert
    verify(eventLoop, atLeast(1)).next();
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    List<MqttTopicSubscription> topicSubscriptionsResult =
        getResult.getSubscribeMessage().payload().topicSubscriptions();
    assertEquals(1, topicSubscriptionsResult.size());
    MqttTopicSubscription getResult2 = topicSubscriptionsResult.get(0);
    assertEquals("org.thingsboard.mqtt.MqttClientImpl", getResult2.topicFilter());
    assertEquals("org.thingsboard.mqtt.MqttClientImpl", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(MqttQoS.EXACTLY_ONCE, getResult2.option().qos());
    assertTrue(pendingSubscribeTopics.contains("org.thingsboard.mqtt.MqttClientImpl"));
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName("Test once(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler, MqttQoS)"})
  void testOnceWithTopicHandlerQos5() {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(
            new MqttClientConfig(), mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.once("Topic", mock(MqttHandler.class), MqttQoS.AT_LEAST_ONCE);

    // Assert
    verify(eventLoop, atLeast(1)).next();
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    List<MqttTopicSubscription> topicSubscriptionsResult =
        getResult.getSubscribeMessage().payload().topicSubscriptions();
    assertEquals(1, topicSubscriptionsResult.size());
    MqttTopicSubscription getResult2 = topicSubscriptionsResult.get(0);
    assertEquals("Topic", getResult2.topicFilter());
    assertEquals("Topic", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(MqttQoS.AT_LEAST_ONCE, getResult2.option().qos());
    assertTrue(pendingSubscribeTopics.contains("Topic"));
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName("Test once(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler, MqttQoS)"})
  void testOnceWithTopicHandlerQos6() {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(
            new MqttClientConfig(), mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.once("42", mock(MqttHandler.class), MqttQoS.AT_LEAST_ONCE);

    // Assert
    verify(eventLoop, atLeast(1)).next();
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    List<MqttTopicSubscription> topicSubscriptionsResult =
        getResult.getSubscribeMessage().payload().topicSubscriptions();
    assertEquals(1, topicSubscriptionsResult.size());
    MqttTopicSubscription getResult2 = topicSubscriptionsResult.get(0);
    assertEquals("42", getResult2.topicFilter());
    assertEquals("42", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(MqttQoS.AT_LEAST_ONCE, getResult2.option().qos());
    assertTrue(pendingSubscribeTopics.contains("42"));
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <ul>
   *   <li>Given {@link MqttClientConfig#MqttClientConfig()} Password is {@code iloveyou}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName(
      "Test once(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'; given MqttClientConfig() Password is 'iloveyou'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler, MqttQoS)"})
  void testOnceWithTopicHandlerQos_givenMqttClientConfigPasswordIsIloveyou() {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientConfig clientConfig = new MqttClientConfig();
    clientConfig.setPassword("iloveyou");

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(clientConfig, mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.once("Topic", mock(MqttHandler.class), MqttQoS.AT_LEAST_ONCE);

    // Assert
    verify(eventLoop, atLeast(1)).next();
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    List<MqttTopicSubscription> topicSubscriptionsResult =
        getResult.getSubscribeMessage().payload().topicSubscriptions();
    assertEquals(1, topicSubscriptionsResult.size());
    MqttTopicSubscription getResult2 = topicSubscriptionsResult.get(0);
    assertEquals("Topic", getResult2.topicFilter());
    assertEquals("Topic", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(MqttQoS.AT_LEAST_ONCE, getResult2.option().qos());
    assertTrue(pendingSubscribeTopics.contains("Topic"));
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler)} with {@code topic}, {@code handler}.
   *
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()} addShutdownHook {@link Runnable}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler)}
   */
  @Test
  @DisplayName(
      "Test once(String, MqttHandler) with 'topic', 'handler'; given DefaultEventLoop() addShutdownHook Runnable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler)"})
  void testOnceWithTopicHandler_givenDefaultEventLoopAddShutdownHookRunnable() {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOnceResult = mqttClientImpl.once("Topic", mock(MqttHandler.class));

    // Assert
    verify(eventLoop, atLeast(1)).next();
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    assertTrue(
        getResult.getSubscribeMessage().variableHeader()
            instanceof MqttMessageIdAndPropertiesVariableHeader);
    assertTrue(actualOnceResult instanceof DefaultPromise);
    assertEquals("Topic", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(1, getResult.getHandlers().size());
    assertFalse(getResult.isSent());
    assertTrue(pendingSubscribeTopics.contains("Topic"));
    assertTrue(mqttClientImpl.getHandlerToSubscription().entries().isEmpty());
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler)} with {@code topic}, {@code handler}.
   *
   * <ul>
   *   <li>Given {@link DefaultEventLoop} {@link DefaultEventLoop#next()} return {@link EventLoop}.
   *   <li>Then calls {@link DefaultEventLoop#next()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler)}
   */
  @Test
  @DisplayName(
      "Test once(String, MqttHandler) with 'topic', 'handler'; given DefaultEventLoop next() return EventLoop; then calls next()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler)"})
  void testOnceWithTopicHandler_givenDefaultEventLoopNextReturnEventLoop_thenCallsNext() {
    // Arrange
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(mock(EventLoop.class));

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOnceResult = mqttClientImpl.once("Topic", mock(MqttHandler.class));

    // Assert
    verify(eventLoop, atLeast(1)).next();
    ConcurrentMap<Integer, MqttPendingSubscription> pendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    assertEquals(1, pendingSubscriptions.size());
    MqttPendingSubscription getResult = pendingSubscriptions.get(1);
    assertTrue(
        getResult.getSubscribeMessage().variableHeader()
            instanceof MqttMessageIdAndPropertiesVariableHeader);
    assertTrue(actualOnceResult instanceof DefaultPromise);
    assertEquals("Topic", getResult.getTopic());
    Set<String> pendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    assertEquals(1, pendingSubscribeTopics.size());
    assertEquals(1, getResult.getHandlers().size());
    assertFalse(getResult.isSent());
    assertTrue(pendingSubscribeTopics.contains("Topic"));
    assertTrue(mqttClientImpl.getHandlerToSubscription().entries().isEmpty());
  }

  /**
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   *
   * <p>Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic() throws InterruptedException, ExecutionException {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("Topic");

    // Assert
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
  }

  /**
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   *
   * <p>Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic2() throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("Topic");

    // Assert
    verify(eventLoop).next();
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
  }

  /**
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   *
   * <p>Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic3() throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(
            new MqttClientConfig(), mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("Topic");

    // Assert
    verify(eventLoop).next();
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
  }

  /**
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   *
   * <p>Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic4() throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(null, mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("");

    // Assert
    verify(eventLoop).next();
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
  }

  /**
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'; when '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic_when42() throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("42");

    // Assert
    verify(eventLoop).next();
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
  }

  /**
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   *
   * <ul>
   *   <li>When {@code MqttSubscription}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'; when 'org.thingsboard.mqtt.MqttSubscription'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic_whenOrgThingsboardMqttMqttSubscription()
      throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("org.thingsboard.mqtt.MqttSubscription");

    // Assert
    verify(eventLoop).next();
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
  }

  /**
   * Test {@link MqttClientImpl#publish(String, ByteBuf, MqttQoS, boolean)} with {@code topic},
   * {@code payload}, {@code qos}, {@code retain}.
   *
   * <ul>
   *   <li>Then return {@link DefaultPromise}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#publish(String, ByteBuf, MqttQoS, boolean)}
   */
  @Test
  @DisplayName(
      "Test publish(String, ByteBuf, MqttQoS, boolean) with 'topic', 'payload', 'qos', 'retain'; then return DefaultPromise")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.publish(String, ByteBuf, MqttQoS, boolean)"})
  void testPublishWithTopicPayloadQosRetain_thenReturnDefaultPromise() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act and Assert
    assertTrue(
        mqttClientImpl.publish(
                "Topic",
                new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
                MqttQoS.AT_MOST_ONCE,
                true)
            instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#publish(String, ByteBuf, MqttQoS)} with {@code topic}, {@code
   * payload}, {@code qos}.
   *
   * <ul>
   *   <li>Then return {@link DefaultPromise}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#publish(String, ByteBuf, MqttQoS)}
   */
  @Test
  @DisplayName(
      "Test publish(String, ByteBuf, MqttQoS) with 'topic', 'payload', 'qos'; then return DefaultPromise")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.publish(String, ByteBuf, MqttQoS)"})
  void testPublishWithTopicPayloadQos_thenReturnDefaultPromise() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act and Assert
    assertTrue(
        mqttClientImpl.publish(
                "Topic",
                new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
                MqttQoS.AT_MOST_ONCE)
            instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#publish(String, ByteBuf, boolean)} with {@code topic}, {@code
   * payload}, {@code retain}.
   *
   * <ul>
   *   <li>Then return {@link DefaultPromise}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#publish(String, ByteBuf, boolean)}
   */
  @Test
  @DisplayName(
      "Test publish(String, ByteBuf, boolean) with 'topic', 'payload', 'retain'; then return DefaultPromise")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.publish(String, ByteBuf, boolean)"})
  void testPublishWithTopicPayloadRetain_thenReturnDefaultPromise() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act and Assert
    assertTrue(
        mqttClientImpl.publish(
                "Topic",
                new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
                true)
            instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#publish(String, ByteBuf)} with {@code topic}, {@code payload}.
   *
   * <ul>
   *   <li>Then return {@link DefaultPromise}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#publish(String, ByteBuf)}
   */
  @Test
  @DisplayName("Test publish(String, ByteBuf) with 'topic', 'payload'; then return DefaultPromise")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.publish(String, ByteBuf)"})
  void testPublishWithTopicPayload_thenReturnDefaultPromise() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act and Assert
    assertTrue(
        mqttClientImpl.publish(
                "Topic", new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())))
            instanceof DefaultPromise);
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MqttClientImpl#setCallback(MqttClientCallback)}
   *   <li>{@link MqttClientImpl#setEventLoop(EventLoopGroup)}
   *   <li>{@link MqttClientImpl#getCallback()}
   *   <li>{@link MqttClientImpl#getClientConfig()}
   *   <li>{@link MqttClientImpl#getDefaultHandler()}
   *   <li>{@link MqttClientImpl#getEventLoop()}
   *   <li>{@link MqttClientImpl#getHandlerExecutor()}
   *   <li>{@link MqttClientImpl#getHandlerToSubscription()}
   *   <li>{@link MqttClientImpl#getPendingPublishes()}
   *   <li>{@link MqttClientImpl#getPendingServerUnsubscribes()}
   *   <li>{@link MqttClientImpl#getPendingSubscribeTopics()}
   *   <li>{@link MqttClientImpl#getPendingSubscriptions()}
   *   <li>{@link MqttClientImpl#getQos2PendingIncomingPublishes()}
   *   <li>{@link MqttClientImpl#getServerSubscriptions()}
   *   <li>{@link MqttClientImpl#getSubscriptions()}
   *   <li>{@link MqttClientImpl#isReconnect()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "MqttClientCallback MqttClientImpl.getCallback()",
    "MqttClientConfig MqttClientImpl.getClientConfig()",
    "MqttHandler MqttClientImpl.getDefaultHandler()",
    "EventLoopGroup MqttClientImpl.getEventLoop()",
    "ListeningExecutor MqttClientImpl.getHandlerExecutor()",
    "HashMultimap MqttClientImpl.getHandlerToSubscription()",
    "ConcurrentMap MqttClientImpl.getPendingPublishes()",
    "ConcurrentMap MqttClientImpl.getPendingServerUnsubscribes()",
    "Set MqttClientImpl.getPendingSubscribeTopics()",
    "ConcurrentMap MqttClientImpl.getPendingSubscriptions()",
    "ConcurrentMap MqttClientImpl.getQos2PendingIncomingPublishes()",
    "Set MqttClientImpl.getServerSubscriptions()",
    "HashMultimap MqttClientImpl.getSubscriptions()",
    "boolean MqttClientImpl.isReconnect()",
    "void MqttClientImpl.setCallback(MqttClientCallback)",
    "void MqttClientImpl.setEventLoop(EventLoopGroup)"
  })
  void testGettersAndSetters() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    MqttClientCallback callback = mock(MqttClientCallback.class);

    // Act
    mqttClientImpl.setCallback(callback);
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    mqttClientImpl.setEventLoop(eventLoop);
    MqttClientCallback actualCallback = mqttClientImpl.getCallback();
    MqttClientConfig actualClientConfig = mqttClientImpl.getClientConfig();
    mqttClientImpl.getDefaultHandler();
    EventLoopGroup actualEventLoop = mqttClientImpl.getEventLoop();
    mqttClientImpl.getHandlerExecutor();
    HashMultimap<MqttHandler, MqttSubscription> actualHandlerToSubscription =
        mqttClientImpl.getHandlerToSubscription();
    ConcurrentMap<Integer, MqttPendingPublish> actualPendingPublishes =
        mqttClientImpl.getPendingPublishes();
    ConcurrentMap<Integer, MqttPendingUnsubscription> actualPendingServerUnsubscribes =
        mqttClientImpl.getPendingServerUnsubscribes();
    Set<String> actualPendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    ConcurrentMap<Integer, MqttPendingSubscription> actualPendingSubscriptions =
        mqttClientImpl.getPendingSubscriptions();
    ConcurrentMap<Integer, MqttIncomingQos2Publish> actualQos2PendingIncomingPublishes =
        mqttClientImpl.getQos2PendingIncomingPublishes();
    Set<String> actualServerSubscriptions = mqttClientImpl.getServerSubscriptions();
    HashMultimap<String, MqttSubscription> actualSubscriptions = mqttClientImpl.getSubscriptions();
    boolean actualIsReconnectResult = mqttClientImpl.isReconnect();

    // Assert
    assertNull(actualClientConfig.getSslContext());
    assertNull(actualClientConfig.getOwnerId());
    assertNull(actualClientConfig.getPassword());
    assertNull(actualClientConfig.getUsername());
    assertNull(actualClientConfig.getLastWill());
    assertEquals(0, actualHandlerToSubscription.size());
    assertEquals(1L, actualClientConfig.getReconnectDelay());
    assertEquals(60, actualClientConfig.getTimeoutSeconds());
    assertEquals(8092, actualClientConfig.getMaxBytesInMessage());
    assertEquals(MqttVersion.MQTT_3_1, actualClientConfig.getProtocolVersion());
    assertFalse(actualIsReconnectResult);
    assertTrue(actualHandlerToSubscription.isEmpty());
    assertTrue(actualPendingPublishes.isEmpty());
    assertTrue(actualPendingServerUnsubscribes.isEmpty());
    assertTrue(actualPendingSubscriptions.isEmpty());
    assertTrue(actualQos2PendingIncomingPublishes.isEmpty());
    assertTrue(actualPendingSubscribeTopics.isEmpty());
    assertTrue(actualServerSubscriptions.isEmpty());
    assertTrue(actualClientConfig.isCleanSession());
    assertTrue(actualClientConfig.isReconnect());
    assertEquals(actualHandlerToSubscription, actualSubscriptions);
    Class<NioSocketChannel> expectedChannelClass = NioSocketChannel.class;
    assertEquals(expectedChannelClass, actualClientConfig.getChannelClass());
    assertSame(eventLoop, actualEventLoop);
    assertSame(callback, actualCallback);
  }
}
