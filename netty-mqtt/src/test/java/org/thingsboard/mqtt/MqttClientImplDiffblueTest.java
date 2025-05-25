package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.collect.HashMultimap;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.mqtt.MqttVersion;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Future;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.common.util.ListeningExecutor;

class MqttClientImplDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @MethodsUnderTest({"MqttClientCallback MqttClientImpl.getCallback()",
      "MqttClientConfig MqttClientImpl.getClientConfig()", "MqttHandler MqttClientImpl.getDefaultHandler()",
      "EventLoopGroup MqttClientImpl.getEventLoop()", "ListeningExecutor MqttClientImpl.getHandlerExecutor()",
      "HashMultimap MqttClientImpl.getHandlerToSubscription()", "ConcurrentMap MqttClientImpl.getPendingPublishes()",
      "ConcurrentMap MqttClientImpl.getPendingServerUnsubscribes()", "Set MqttClientImpl.getPendingSubscribeTopics()",
      "ConcurrentMap MqttClientImpl.getPendingSubscriptions()",
      "ConcurrentMap MqttClientImpl.getQos2PendingIncomingPublishes()", "Set MqttClientImpl.getServerSubscriptions()",
      "HashMultimap MqttClientImpl.getSubscriptions()", "boolean MqttClientImpl.isReconnect()",
      "void MqttClientImpl.setCallback(MqttClientCallback)", "void MqttClientImpl.setEventLoop(EventLoopGroup)"})
  void testGettersAndSetters2() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
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
    HashMultimap<MqttHandler, MqttSubscription> actualHandlerToSubscription = mqttClientImpl.getHandlerToSubscription();
    ConcurrentMap<Integer, MqttPendingPublish> actualPendingPublishes = mqttClientImpl.getPendingPublishes();
    ConcurrentMap<Integer, MqttPendingUnsubscription> actualPendingServerUnsubscribes = mqttClientImpl
        .getPendingServerUnsubscribes();
    Set<String> actualPendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    ConcurrentMap<Integer, MqttPendingSubscription> actualPendingSubscriptions = mqttClientImpl
        .getPendingSubscriptions();
    ConcurrentMap<Integer, MqttIncomingQos2Publish> actualQos2PendingIncomingPublishes = mqttClientImpl
        .getQos2PendingIncomingPublishes();
    Set<String> actualServerSubscriptions = mqttClientImpl.getServerSubscriptions();
    HashMultimap<String, MqttSubscription> actualSubscriptions = mqttClientImpl.getSubscriptions();
    boolean actualIsReconnectResult = mqttClientImpl.isReconnect();

    // Assert
    assertNull(actualClientConfig.getSslContext());
    assertNull(actualClientConfig.getOwnerId());
    assertNull(actualClientConfig.getPassword());
    assertNull(actualClientConfig.getUsername());
    assertNull(actualClientConfig.getLastWill());
    assertEquals(1L, actualClientConfig.getReconnectDelay());
    assertEquals(60, actualClientConfig.getTimeoutSeconds());
    assertEquals(8092, actualClientConfig.getMaxBytesInMessage());
    assertEquals(MqttVersion.MQTT_3_1, actualClientConfig.getProtocolVersion());
    assertFalse(actualIsReconnectResult);
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

  /**
   * Test {@link MqttClientImpl#MqttClientImpl(MqttClientConfig, MqttHandler, ListeningExecutor)}.
   * <p>
   * Method under test: {@link MqttClientImpl#MqttClientImpl(MqttClientConfig, MqttHandler, ListeningExecutor)}
   */
  @Test
  @DisplayName("Test new MqttClientImpl(MqttClientConfig, MqttHandler, ListeningExecutor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttClientImpl.<init>(MqttClientConfig, MqttHandler, ListeningExecutor)"})
  void testNewMqttClientImpl() {
    // Arrange
    MqttClientConfig clientConfig = new MqttClientConfig();
    MqttHandler defaultHandler = mock(MqttHandler.class);
    ListeningExecutor handlerExecutor = mock(ListeningExecutor.class);

    // Act
    MqttClientImpl actualMqttClientImpl = new MqttClientImpl(clientConfig, defaultHandler, handlerExecutor);

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
   * <p>
   * Method under test: {@link MqttClientImpl#MqttClientImpl(MqttHandler, ListeningExecutor)}
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
   * Test {@link MqttClientImpl#MqttClientImpl(MqttClientConfig, MqttHandler, ListeningExecutor)}.
   * <p>
   * Method under test: {@link MqttClientImpl#MqttClientImpl(MqttClientConfig, MqttHandler, ListeningExecutor)}
   */
  @Test
  @DisplayName("Test new MqttClientImpl(MqttClientConfig, MqttHandler, ListeningExecutor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttClientImpl.<init>(MqttClientConfig, MqttHandler, ListeningExecutor)"})
  void testNewMqttClientImpl3() {
    // Arrange
    MqttClientConfig clientConfig = new MqttClientConfig();
    MqttHandler defaultHandler = mock(MqttHandler.class);
    ListeningExecutor handlerExecutor = mock(ListeningExecutor.class);

    // Act
    MqttClientImpl actualMqttClientImpl = new MqttClientImpl(clientConfig, defaultHandler, handlerExecutor);

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
   * <p>
   * Method under test: {@link MqttClientImpl#MqttClientImpl(MqttHandler, ListeningExecutor)}
   */
  @Test
  @DisplayName("Test new MqttClientImpl(MqttHandler, ListeningExecutor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void MqttClientImpl.<init>(MqttHandler, ListeningExecutor)"})
  void testNewMqttClientImpl4() {
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
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   * <ul>
   *   <li>Then return {@link DefaultPromise}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'; then return DefaultPromise")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic_thenReturnDefaultPromise() throws InterruptedException, ExecutionException {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("Topic");

    // Assert
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @MethodsUnderTest({"MqttClientCallback MqttClientImpl.getCallback()",
      "MqttClientConfig MqttClientImpl.getClientConfig()", "MqttHandler MqttClientImpl.getDefaultHandler()",
      "EventLoopGroup MqttClientImpl.getEventLoop()", "ListeningExecutor MqttClientImpl.getHandlerExecutor()",
      "HashMultimap MqttClientImpl.getHandlerToSubscription()", "ConcurrentMap MqttClientImpl.getPendingPublishes()",
      "ConcurrentMap MqttClientImpl.getPendingServerUnsubscribes()", "Set MqttClientImpl.getPendingSubscribeTopics()",
      "ConcurrentMap MqttClientImpl.getPendingSubscriptions()",
      "ConcurrentMap MqttClientImpl.getQos2PendingIncomingPublishes()", "Set MqttClientImpl.getServerSubscriptions()",
      "HashMultimap MqttClientImpl.getSubscriptions()", "boolean MqttClientImpl.isReconnect()",
      "void MqttClientImpl.setCallback(MqttClientCallback)", "void MqttClientImpl.setEventLoop(EventLoopGroup)"})
  void testGettersAndSetters() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
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
    HashMultimap<MqttHandler, MqttSubscription> actualHandlerToSubscription = mqttClientImpl.getHandlerToSubscription();
    ConcurrentMap<Integer, MqttPendingPublish> actualPendingPublishes = mqttClientImpl.getPendingPublishes();
    ConcurrentMap<Integer, MqttPendingUnsubscription> actualPendingServerUnsubscribes = mqttClientImpl
        .getPendingServerUnsubscribes();
    Set<String> actualPendingSubscribeTopics = mqttClientImpl.getPendingSubscribeTopics();
    ConcurrentMap<Integer, MqttPendingSubscription> actualPendingSubscriptions = mqttClientImpl
        .getPendingSubscriptions();
    ConcurrentMap<Integer, MqttIncomingQos2Publish> actualQos2PendingIncomingPublishes = mqttClientImpl
        .getQos2PendingIncomingPublishes();
    Set<String> actualServerSubscriptions = mqttClientImpl.getServerSubscriptions();
    HashMultimap<String, MqttSubscription> actualSubscriptions = mqttClientImpl.getSubscriptions();
    boolean actualIsReconnectResult = mqttClientImpl.isReconnect();

    // Assert
    assertNull(actualClientConfig.getSslContext());
    assertNull(actualClientConfig.getOwnerId());
    assertNull(actualClientConfig.getPassword());
    assertNull(actualClientConfig.getUsername());
    assertNull(actualClientConfig.getLastWill());
    assertEquals(1L, actualClientConfig.getReconnectDelay());
    assertEquals(60, actualClientConfig.getTimeoutSeconds());
    assertEquals(8092, actualClientConfig.getMaxBytesInMessage());
    assertEquals(MqttVersion.MQTT_3_1, actualClientConfig.getProtocolVersion());
    assertFalse(actualIsReconnectResult);
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
