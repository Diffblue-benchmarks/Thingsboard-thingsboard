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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.collect.HashMultimap;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.mqtt.MqttVersion;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.Promise;
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
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    // Act
    mqttClientImpl.connect("localhost");

    // Assert
    EventLoopGroup eventLoop = mqttClientImpl.getEventLoop();
    EventLoop nextResult = eventLoop.next();
    assertTrue(nextResult instanceof NioEventLoop);
    Iterator<EventExecutor> iteratorResult = eventLoop.iterator();
    assertTrue(iteratorResult.next() instanceof NioEventLoop);
    assertTrue(eventLoop instanceof NioEventLoopGroup);
    assertTrue(iteratorResult.hasNext());
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost2() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost");

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoop);
    assertTrue(actualConnectResult instanceof DefaultPromise);
    assertFalse(eventLoop2.isTerminated());
    assertSame(eventLoop, eventLoop2);
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost3() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(null, mock(ListeningExecutor.class));

    // Act
    mqttClientImpl.connect("localhost");

    // Assert
    EventLoopGroup eventLoop = mqttClientImpl.getEventLoop();
    EventLoop nextResult = eventLoop.next();
    assertTrue(nextResult instanceof NioEventLoop);
    Iterator<EventExecutor> iteratorResult = eventLoop.iterator();
    assertTrue(iteratorResult.next() instanceof NioEventLoop);
    assertTrue(eventLoop instanceof NioEventLoopGroup);
    assertTrue(iteratorResult.hasNext());
    assertSame(nextResult, nextResult.next());
    assertSame(eventLoop, nextResult.parent());
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost4() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost");

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoop);
    assertTrue(actualConnectResult instanceof DefaultPromise);
    assertFalse(eventLoop2.isTerminated());
    assertSame(eventLoop, eventLoop2);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    // Act
    mqttClientImpl.connect("localhost", 8080);

    // Assert
    EventLoopGroup eventLoop = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop.next() instanceof NioEventLoop);
    assertTrue(eventLoop instanceof NioEventLoopGroup);
    assertTrue(eventLoop.terminationFuture() instanceof DefaultPromise);
    assertTrue(eventLoop.iterator().hasNext());
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort2() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoop);
    assertTrue(actualConnectResult instanceof DefaultPromise);
    assertFalse(eventLoop2.isTerminated());
    assertSame(eventLoop, eventLoop2);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort3() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    // Act
    mqttClientImpl.connect("localhost", 8080);

    // Assert
    EventLoopGroup eventLoop = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop.next() instanceof NioEventLoop);
    assertTrue(eventLoop instanceof NioEventLoopGroup);
    assertTrue(eventLoop.terminationFuture() instanceof DefaultPromise);
    assertTrue(eventLoop.iterator().hasNext());
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort4() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoop);
    assertTrue(actualConnectResult instanceof DefaultPromise);
    assertFalse(eventLoop2.isTerminated());
    assertSame(eventLoop, eventLoop2);
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()} addShutdownHook {@link Runnable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'; given DefaultEventLoop() addShutdownHook Runnable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost_givenDefaultEventLoopAddShutdownHookRunnable() {
    // Arrange
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    eventLoop.addShutdownHook(mock(Runnable.class));

    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);
    new IllegalStateException("UNKNOWN");

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost");

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoop);
    assertTrue(actualConnectResult instanceof DefaultPromise);
    assertFalse(eventLoop2.isTerminated());
    assertSame(eventLoop, eventLoop2);
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()} addShutdownHook {@link Runnable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'; given DefaultEventLoop() addShutdownHook Runnable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost_givenDefaultEventLoopAddShutdownHookRunnable2() {
    // Arrange
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    eventLoop.addShutdownHook(mock(Runnable.class));
    eventLoop.addShutdownHook(mock(Runnable.class));

    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);
    new IllegalStateException("UNKNOWN");

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost");

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoop);
    assertTrue(actualConnectResult instanceof DefaultPromise);
    assertFalse(eventLoop2.isTerminated());
    assertSame(eventLoop, eventLoop2);
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()} addShutdownHook {@link Runnable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'; given DefaultEventLoop() addShutdownHook Runnable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost_givenDefaultEventLoopAddShutdownHookRunnable3() {
    // Arrange
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    eventLoop.addShutdownHook(mock(Runnable.class));
    eventLoop.addShutdownHook(mock(Runnable.class));
    eventLoop.addShutdownHook(mock(Runnable.class));

    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);
    new IllegalStateException("UNKNOWN");

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost");

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoop);
    assertTrue(actualConnectResult instanceof DefaultPromise);
    assertFalse(eventLoop2.isTerminated());
    assertSame(eventLoop, eventLoop2);
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()} addShutdownHook {@link Runnable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'; given DefaultEventLoop() addShutdownHook Runnable")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost_givenDefaultEventLoopAddShutdownHookRunnable4() {
    // Arrange
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    eventLoop.addShutdownHook(mock(Runnable.class));
    eventLoop.addShutdownHook(mock(Runnable.class));
    eventLoop.addShutdownHook(mock(Runnable.class));
    eventLoop.addShutdownHook(mock(Runnable.class));

    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);
    new IllegalStateException("UNKNOWN");

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost");

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoop);
    assertTrue(actualConnectResult instanceof DefaultPromise);
    assertFalse(eventLoop2.isTerminated());
    assertSame(eventLoop, eventLoop2);
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with {@code [{}] Connecting to server, isReconnect - {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'; given IllegalStateException(String) with '[{}] Connecting to server, isReconnect - {}'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost_givenIllegalStateExceptionWithConnectingToServerIsReconnect() {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoop eventLoop = new DefaultEventLoop();
    mqttClientImpl.setEventLoop(eventLoop);
    new IllegalStateException("[{}] Connecting to server, isReconnect - {}");

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost");

    // Assert
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof DefaultEventLoop);
    assertTrue(actualConnectResult instanceof DefaultPromise);
    assertFalse(eventLoop2.isTerminated());
    assertSame(eventLoop, eventLoop2);
  }

  /**
   * Test {@link MqttClientImpl#isConnected()}.
   * <p>
   * Method under test: {@link MqttClientImpl#isConnected()}
   */
  @Test
  @DisplayName("Test isConnected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttClientImpl.isConnected()"})
  void testIsConnected() {
    // Arrange, Act and Assert
    assertFalse((new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class))).isConnected());
  }

  /**
   * Test {@link MqttClientImpl#isConnected()}.
   * <p>
   * Method under test: {@link MqttClientImpl#isConnected()}
   */
  @Test
  @DisplayName("Test isConnected()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean MqttClientImpl.isConnected()"})
  void testIsConnected2() {
    // Arrange, Act and Assert
    assertFalse((new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class))).isConnected());
  }

  /**
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   * <p>
   * Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic() throws InterruptedException, ExecutionException {
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
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   * <p>
   * Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic2() throws InterruptedException, ExecutionException {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(null, mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("Topic");

    // Assert
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
  }

  /**
   * Test {@link MqttClientImpl#off(String, MqttHandler)} with {@code topic}, {@code handler}.
   * <ul>
   *   <li>Then return {@link DefaultPromise}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttClientImpl#off(String, MqttHandler)}
   */
  @Test
  @DisplayName("Test off(String, MqttHandler) with 'topic', 'handler'; then return DefaultPromise")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String, MqttHandler)"})
  void testOffWithTopicHandler_thenReturnDefaultPromise() throws InterruptedException, ExecutionException {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("Topic", mock(MqttHandler.class));

    // Assert
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
  }

  /**
   * Test {@link MqttClientImpl#off(String, MqttHandler)} with {@code topic}, {@code handler}.
   * <ul>
   *   <li>Then return {@link DefaultPromise}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MqttClientImpl#off(String, MqttHandler)}
   */
  @Test
  @DisplayName("Test off(String, MqttHandler) with 'topic', 'handler'; then return DefaultPromise")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Future MqttClientImpl.off(String, MqttHandler)"})
  void testOffWithTopicHandler_thenReturnDefaultPromise2() throws InterruptedException, ExecutionException {
    // Arrange
    MqttClientImpl mqttClientImpl = new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
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
