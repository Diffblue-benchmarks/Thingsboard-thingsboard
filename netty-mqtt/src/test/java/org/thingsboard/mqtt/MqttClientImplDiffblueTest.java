/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.collect.HashMultimap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.mqtt.MqttMessageIdAndPropertiesVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttVersion;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import java.util.Iterator;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link MqttClientImpl#isConnected()}.
   *
   * <p>Method under test: {@link MqttClientImpl#isConnected()}
   */
  @Test
  @DisplayName("Test isConnected()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean MqttClientImpl.isConnected()"})
  void testIsConnected() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    // Act and Assert
    assertFalse(mqttClientImpl.isConnected());
  }

  /**
   * Test {@link MqttClientImpl#reconnect()}.
   *
   * <p>Method under test: {@link MqttClientImpl#reconnect()}
   */
  @Test
  @DisplayName("Test reconnect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"io.netty.util.concurrent.Promise MqttClientImpl.reconnect()"})
  void testReconnect() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> mqttClientImpl.reconnect());
  }

  /**
   * Test {@link MqttClientImpl#on(String, MqttHandler)} with {@code topic}, {@code handler}.
   *
   * <p>Method under test: {@link MqttClientImpl#on(String, MqttHandler)}
   */
  @Test
  @DisplayName("Test on(String, MqttHandler) with 'topic', 'handler'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link MqttClientImpl#on(String, MqttHandler)} with {@code topic}, {@code handler}.
   *
   * <p>Method under test: {@link MqttClientImpl#on(String, MqttHandler)}
   */
  @Test
  @DisplayName("Test on(String, MqttHandler) with 'topic', 'handler'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.on(String, MqttHandler)"})
  void testOnWithTopicHandler2() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.on("Topic", mock(MqttHandler.class));

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoopGroup);
    Iterator<EventExecutor> iteratorResult = eventLoop2.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertFalse(nextResult.isShutdown());
    assertFalse(nextResult.isShuttingDown());
    assertFalse(nextResult.isTerminated());
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#on(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#on(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName("Test on(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link MqttClientImpl#on(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#on(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName("Test on(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.on(String, MqttHandler, MqttQoS)"})
  void testOnWithTopicHandlerQos2() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.on("Topic", mock(MqttHandler.class), MqttQoS.AT_MOST_ONCE);

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoopGroup);
    Iterator<EventExecutor> iteratorResult = eventLoop2.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertFalse(nextResult.isShutdown());
    assertFalse(nextResult.isShuttingDown());
    assertFalse(nextResult.isTerminated());
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler)} with {@code topic}, {@code handler}.
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler)}
   */
  @Test
  @DisplayName("Test once(String, MqttHandler) with 'topic', 'handler'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link MqttClientImpl#once(String, MqttHandler)} with {@code topic}, {@code handler}.
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler)}
   */
  @Test
  @DisplayName("Test once(String, MqttHandler) with 'topic', 'handler'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler)"})
  void testOnceWithTopicHandler2() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.once("Topic", mock(MqttHandler.class));

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoopGroup);
    Iterator<EventExecutor> iteratorResult = eventLoop2.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertFalse(nextResult.isShutdown());
    assertFalse(nextResult.isShuttingDown());
    assertFalse(nextResult.isTerminated());
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)} with {@code topic}, {@code
   * handler}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#once(String, MqttHandler, MqttQoS)}
   */
  @Test
  @DisplayName("Test once(String, MqttHandler, MqttQoS) with 'topic', 'handler', 'qos'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler, MqttQoS)"})
  void testOnceWithTopicHandlerQos() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act
    Future<Void> actualOnceResult =
        mqttClientImpl.once("Topic", mock(MqttHandler.class), MqttQoS.AT_MOST_ONCE);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.once(String, MqttHandler, MqttQoS)"})
  void testOnceWithTopicHandlerQos2() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.once("Topic", mock(MqttHandler.class), MqttQoS.AT_MOST_ONCE);

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoopGroup);
    Iterator<EventExecutor> iteratorResult = eventLoop2.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertFalse(nextResult.isShutdown());
    assertFalse(nextResult.isShuttingDown());
    assertFalse(nextResult.isTerminated());
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   *
   * <p>Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.off("Topic");

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoopGroup);
    Iterator<EventExecutor> iteratorResult = eventLoop2.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertFalse(nextResult.isShutdown());
    assertFalse(nextResult.isShuttingDown());
    assertFalse(nextResult.isTerminated());
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#off(String, MqttHandler)} with {@code topic}, {@code handler}.
   *
   * <p>Method under test: {@link MqttClientImpl#off(String, MqttHandler)}
   */
  @Test
  @DisplayName("Test off(String, MqttHandler) with 'topic', 'handler'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String, MqttHandler)"})
  void testOffWithTopicHandler() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.off("Topic", mock(MqttHandler.class));

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoopGroup);
    Iterator<EventExecutor> iteratorResult = eventLoop2.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertFalse(nextResult.isShutdown());
    assertFalse(nextResult.isShuttingDown());
    assertFalse(nextResult.isTerminated());
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#off(String, MqttHandler)} with {@code topic}, {@code handler}.
   *
   * <ul>
   *   <li>Then return {@link DefaultPromise}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#off(String, MqttHandler)}
   */
  @Test
  @DisplayName("Test off(String, MqttHandler) with 'topic', 'handler'; then return DefaultPromise")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String, MqttHandler)"})
  void testOffWithTopicHandler_thenReturnDefaultPromise()
      throws InterruptedException, ExecutionException {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("Topic", mock(MqttHandler.class));

    // Assert
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
  }

  /**
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   *
   * <ul>
   *   <li>Then return {@link DefaultPromise}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'; then return DefaultPromise")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic_thenReturnDefaultPromise() throws InterruptedException, ExecutionException {
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
   * Test {@link MqttClientImpl#publish(String, ByteBuf)} with {@code topic}, {@code payload}.
   *
   * <p>Method under test: {@link MqttClientImpl#publish(String, ByteBuf)}
   */
  @Test
  @DisplayName("Test publish(String, ByteBuf) with 'topic', 'payload'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.publish(String, ByteBuf)"})
  void testPublishWithTopicPayload() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.publish(
        "Topic", new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())));

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoopGroup);
    Iterator<EventExecutor> iteratorResult = eventLoop2.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertFalse(nextResult.isShutdown());
    assertFalse(nextResult.isShuttingDown());
    assertFalse(nextResult.isTerminated());
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#publish(String, ByteBuf, MqttQoS)} with {@code topic}, {@code
   * payload}, {@code qos}.
   *
   * <p>Method under test: {@link MqttClientImpl#publish(String, ByteBuf, MqttQoS)}
   */
  @Test
  @DisplayName("Test publish(String, ByteBuf, MqttQoS) with 'topic', 'payload', 'qos'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.publish(String, ByteBuf, MqttQoS)"})
  void testPublishWithTopicPayloadQos() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.publish(
        "Topic",
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
        MqttQoS.AT_MOST_ONCE);

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoopGroup);
    Iterator<EventExecutor> iteratorResult = eventLoop2.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertFalse(nextResult.isShutdown());
    assertFalse(nextResult.isShuttingDown());
    assertFalse(nextResult.isTerminated());
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#publish(String, ByteBuf, MqttQoS, boolean)} with {@code topic},
   * {@code payload}, {@code qos}, {@code retain}.
   *
   * <p>Method under test: {@link MqttClientImpl#publish(String, ByteBuf, MqttQoS, boolean)}
   */
  @Test
  @DisplayName(
      "Test publish(String, ByteBuf, MqttQoS, boolean) with 'topic', 'payload', 'qos', 'retain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.publish(String, ByteBuf, MqttQoS, boolean)"})
  void testPublishWithTopicPayloadQosRetain() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.publish(
        "Topic",
        new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())),
        MqttQoS.AT_MOST_ONCE,
        true);

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoopGroup);
    Iterator<EventExecutor> iteratorResult = eventLoop2.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertFalse(nextResult.isShutdown());
    assertFalse(nextResult.isShuttingDown());
    assertFalse(nextResult.isTerminated());
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * <p>Method under test: {@link MqttClientImpl#publish(String, ByteBuf, boolean)}
   */
  @Test
  @DisplayName("Test publish(String, ByteBuf, boolean) with 'topic', 'payload', 'retain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.publish(String, ByteBuf, boolean)"})
  void testPublishWithTopicPayloadRetain() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.publish(
        "Topic", new DuplicatedByteBuf(new EmptyByteBuf(new PooledByteBufAllocator())), true);

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoopGroup);
    Iterator<EventExecutor> iteratorResult = eventLoop2.iterator();
    EventExecutor nextResult = iteratorResult.next();
    assertTrue(iteratorResult.hasNext());
    assertTrue(nextResult instanceof DefaultEventLoop);
    assertFalse(nextResult.isShutdown());
    assertFalse(nextResult.isShuttingDown());
    assertFalse(nextResult.isTerminated());
    Iterator<EventExecutor> iteratorResult2 = nextResult.iterator();
    EventExecutor actualNextResult = iteratorResult2.next();
    assertFalse(iteratorResult2.hasNext());
    assertSame(nextResult, actualNextResult);
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
    assertTrue(nextResult.terminationFuture() instanceof DefaultPromise);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link MqttClientImpl#onSuccessfulReconnect()}.
   *
   * <p>Method under test: {@link MqttClientImpl#onSuccessfulReconnect()}
   */
  @Test
  @DisplayName("Test onSuccessfulReconnect()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientImpl.onSuccessfulReconnect()"})
  void testOnSuccessfulReconnect() {
    // Arrange
    MqttClientCallback callback = mock(MqttClientCallback.class);
    doNothing().when(callback).onSuccessfulReconnect();

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setCallback(callback);

    // Act
    mqttClientImpl.onSuccessfulReconnect();

    // Assert
    verify(callback).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttClientImpl#onSuccessfulReconnect()}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#onSuccessfulReconnect()}
   */
  @Test
  @DisplayName("Test onSuccessfulReconnect(); then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientImpl.onSuccessfulReconnect()"})
  void testOnSuccessfulReconnect_thenDoesNotThrow() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    // Act and Assert
    assertDoesNotThrow(() -> mqttClientImpl.onSuccessfulReconnect());
  }

  /**
   * Test {@link MqttClientImpl#onSuccessfulReconnect()}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#onSuccessfulReconnect()}
   */
  @Test
  @DisplayName("Test onSuccessfulReconnect(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MqttClientImpl.onSuccessfulReconnect()"})
  void testOnSuccessfulReconnect_thenThrowIllegalStateException() {
    // Arrange
    MqttClientCallback callback = mock(MqttClientCallback.class);
    doThrow(new IllegalStateException()).when(callback).onSuccessfulReconnect();

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setCallback(callback);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> mqttClientImpl.onSuccessfulReconnect());
    verify(callback).onSuccessfulReconnect();
  }

  /**
   * Test {@link MqttClientImpl#sendAndFlushPacket(Object)}.
   *
   * <p>Method under test: {@link MqttClientImpl#sendAndFlushPacket(Object)}
   */
  @Test
  @DisplayName("Test sendAndFlushPacket(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"io.netty.channel.ChannelFuture MqttClientImpl.sendAndFlushPacket(Object)"})
  void testSendAndFlushPacket() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    // Act and Assert
    assertNull(mqttClientImpl.sendAndFlushPacket("Message"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertFalse(mqttClientImpl.isReconnect());
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
