package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.collect.HashMultimap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.DuplicatedByteBuf;
import io.netty.buffer.EmptyByteBuf;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.DefaultChannelProgressivePromise;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.local.LocalEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.mqtt.MqttMessageIdAndPropertiesVariableHeader;
import io.netty.handler.codec.mqtt.MqttQoS;
import io.netty.handler.codec.mqtt.MqttVersion;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.Promise;
import io.netty.util.concurrent.ScheduledFuture;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.apache.tools.ant.TaskAdapter;
import org.apache.tools.ant.util.WorkerAnt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
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
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act and Assert
    assertTrue(mqttClientImpl.connect("localhost") instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost2() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.connect("localhost");

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
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost3() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any()))
        .thenReturn(new WorkerAnt(new TaskAdapter()));
    DefaultEventLoop eventLoop = new DefaultEventLoop(threadFactory);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost");

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(new DefaultEventLoop());

    // Act and Assert
    assertTrue(mqttClientImpl.connect("localhost", 8080) instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort2() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    DefaultEventLoopGroup eventLoop = new DefaultEventLoopGroup();
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.connect("localhost", 8080);

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
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort3() {
    // Arrange
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.register(Mockito.<Channel>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort4() {
    // Arrange
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.isSuccess()).thenThrow(new IllegalStateException());
    when(defaultChannelProgressivePromise.isDone()).thenReturn(true);
    when(defaultChannelProgressivePromise.channel()).thenReturn(new EmbeddedChannel());
    when(defaultChannelProgressivePromise.cause()).thenReturn(new Throwable());

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.register(Mockito.<Channel>any())).thenReturn(defaultChannelProgressivePromise);
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> mqttClientImpl.connect("localhost", 8080));
    verify(defaultChannelProgressivePromise).channel();
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    verify(defaultChannelProgressivePromise).cause();
    verify(defaultChannelProgressivePromise).isDone();
    verify(defaultChannelProgressivePromise).isSuccess();
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort5() {
    // Arrange
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.isSuccess()).thenReturn(true);
    when(defaultChannelProgressivePromise.isDone()).thenReturn(true);
    when(defaultChannelProgressivePromise.channel()).thenReturn(new EmbeddedChannel());
    when(defaultChannelProgressivePromise.cause()).thenReturn(new Throwable());

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    Mockito.<ScheduledFuture<?>>when(
            eventLoop.schedule(Mockito.<Runnable>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenThrow(new ChannelClosedException("An error occurred"));
    when(eventLoop.register(Mockito.<Channel>any())).thenReturn(defaultChannelProgressivePromise);
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    verify(defaultChannelProgressivePromise).channel();
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    verify(eventLoop).schedule(isA(Runnable.class), eq(1L), eq(TimeUnit.SECONDS));
    verify(defaultChannelProgressivePromise).cause();
    verify(defaultChannelProgressivePromise).isDone();
    verify(defaultChannelProgressivePromise).isSuccess();
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort6() {
    // Arrange
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.setFailure(Mockito.<Throwable>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.close())
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(embeddedChannel.newPromise()).thenReturn(defaultChannelProgressivePromise);
    when(embeddedChannel.eventLoop()).thenReturn(null);

    DefaultChannelProgressivePromise defaultChannelProgressivePromise2 =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise2.isSuccess()).thenReturn(true);
    when(defaultChannelProgressivePromise2.isDone()).thenReturn(true);
    when(defaultChannelProgressivePromise2.channel()).thenReturn(embeddedChannel);
    when(defaultChannelProgressivePromise2.cause()).thenReturn(new Throwable());

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.register(Mockito.<Channel>any())).thenReturn(defaultChannelProgressivePromise2);
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    verify(embeddedChannel).eventLoop();
    verify(embeddedChannel).newPromise();
    verify(defaultChannelProgressivePromise2).channel();
    verify(defaultChannelProgressivePromise).setFailure(isA(Throwable.class));
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    verify(embeddedChannel).close();
    verify(defaultChannelProgressivePromise2).cause();
    verify(defaultChannelProgressivePromise2).isDone();
    verify(defaultChannelProgressivePromise2).isSuccess();
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort7() {
    // Arrange
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.tryFailure(Mockito.<Throwable>any()))
        .thenThrow(new IllegalStateException());
    when(defaultChannelProgressivePromise.setFailure(Mockito.<Throwable>any()))
        .thenThrow(new IllegalStateException());

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.close())
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(embeddedChannel.newPromise()).thenReturn(defaultChannelProgressivePromise);
    when(embeddedChannel.eventLoop()).thenReturn(null);

    DefaultChannelProgressivePromise defaultChannelProgressivePromise2 =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise2.isSuccess()).thenReturn(true);
    when(defaultChannelProgressivePromise2.isDone()).thenReturn(true);
    when(defaultChannelProgressivePromise2.channel()).thenReturn(embeddedChannel);
    when(defaultChannelProgressivePromise2.cause()).thenReturn(new Throwable());

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.register(Mockito.<Channel>any())).thenReturn(defaultChannelProgressivePromise2);
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> mqttClientImpl.connect("localhost", 8080));
    verify(embeddedChannel).eventLoop();
    verify(embeddedChannel).newPromise();
    verify(defaultChannelProgressivePromise2).channel();
    verify(defaultChannelProgressivePromise).setFailure(isA(Throwable.class));
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    verify(embeddedChannel).close();
    verify(defaultChannelProgressivePromise2).cause();
    verify(defaultChannelProgressivePromise2).isDone();
    verify(defaultChannelProgressivePromise2).isSuccess();
    verify(defaultChannelProgressivePromise).tryFailure(isA(Throwable.class));
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort8() {
    // Arrange
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        new DefaultChannelProgressivePromise(new EmbeddedChannel());
    defaultChannelProgressivePromise.addListeners(mock(GenericFutureListener.class));

    DefaultChannelProgressivePromise defaultChannelProgressivePromise2 =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise2.tryFailure(Mockito.<Throwable>any()))
        .thenThrow(new IllegalStateException());
    when(defaultChannelProgressivePromise2.setFailure(Mockito.<Throwable>any()))
        .thenThrow(new IllegalStateException());

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.close()).thenReturn(defaultChannelProgressivePromise);
    when(embeddedChannel.newPromise()).thenReturn(defaultChannelProgressivePromise2);
    when(embeddedChannel.eventLoop()).thenReturn(null);

    DefaultChannelProgressivePromise defaultChannelProgressivePromise3 =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise3.isSuccess()).thenReturn(true);
    when(defaultChannelProgressivePromise3.isDone()).thenReturn(true);
    when(defaultChannelProgressivePromise3.channel()).thenReturn(embeddedChannel);
    when(defaultChannelProgressivePromise3.cause()).thenReturn(new Throwable());

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.register(Mockito.<Channel>any())).thenReturn(defaultChannelProgressivePromise3);
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> mqttClientImpl.connect("localhost", 8080));
    verify(embeddedChannel).eventLoop();
    verify(embeddedChannel).newPromise();
    verify(defaultChannelProgressivePromise3).channel();
    verify(defaultChannelProgressivePromise2).setFailure(isA(Throwable.class));
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    verify(embeddedChannel).close();
    verify(defaultChannelProgressivePromise3).cause();
    verify(defaultChannelProgressivePromise3).isDone();
    verify(defaultChannelProgressivePromise3).isSuccess();
    verify(defaultChannelProgressivePromise2).tryFailure(isA(Throwable.class));
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort9() {
    // Arrange
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.tryFailure(Mockito.<Throwable>any())).thenReturn(true);
    when(defaultChannelProgressivePromise.setFailure(Mockito.<Throwable>any()))
        .thenThrow(new ChannelClosedException("An error occurred"));
    when(defaultChannelProgressivePromise.addListener(
            Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.close())
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(embeddedChannel.newPromise()).thenReturn(defaultChannelProgressivePromise);
    when(embeddedChannel.eventLoop()).thenReturn(null);

    DefaultChannelProgressivePromise defaultChannelProgressivePromise2 =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise2.isSuccess()).thenReturn(true);
    when(defaultChannelProgressivePromise2.isDone()).thenReturn(true);
    when(defaultChannelProgressivePromise2.channel()).thenReturn(embeddedChannel);
    when(defaultChannelProgressivePromise2.cause()).thenReturn(null);

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.register(Mockito.<Channel>any())).thenReturn(defaultChannelProgressivePromise2);
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    verify(embeddedChannel).eventLoop();
    verify(embeddedChannel).newPromise();
    verify(defaultChannelProgressivePromise).addListener(isA(GenericFutureListener.class));
    verify(defaultChannelProgressivePromise2).channel();
    verify(defaultChannelProgressivePromise).setFailure(isA(Throwable.class));
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    verify(embeddedChannel).close();
    verify(defaultChannelProgressivePromise2).cause();
    verify(defaultChannelProgressivePromise2).isDone();
    verify(defaultChannelProgressivePromise2).isSuccess();
    verify(defaultChannelProgressivePromise).tryFailure(isA(Throwable.class));
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <ul>
   *   <li>Given {@link DefaultEventLoop#DefaultEventLoop()} addShutdownHook {@link Runnable}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName(
      "Test connect(String, int) with 'host', 'port'; given DefaultEventLoop() addShutdownHook Runnable")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort_givenDefaultEventLoopAddShutdownHookRunnable() {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));

    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.tryFailure(Mockito.<Throwable>any())).thenReturn(true);
    when(defaultChannelProgressivePromise.setFailure(Mockito.<Throwable>any()))
        .thenThrow(new IllegalStateException());
    when(defaultChannelProgressivePromise.addListener(
            Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.close())
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(embeddedChannel.newPromise()).thenReturn(defaultChannelProgressivePromise);
    when(embeddedChannel.eventLoop()).thenReturn(null);

    DefaultChannelProgressivePromise defaultChannelProgressivePromise2 =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise2.isSuccess()).thenReturn(true);
    when(defaultChannelProgressivePromise2.isDone()).thenReturn(true);
    when(defaultChannelProgressivePromise2.channel()).thenReturn(embeddedChannel);
    when(defaultChannelProgressivePromise2.cause()).thenReturn(new Throwable());

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.register(Mockito.<Channel>any())).thenReturn(defaultChannelProgressivePromise2);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    verify(embeddedChannel).eventLoop();
    verify(embeddedChannel).newPromise();
    verify(defaultChannelProgressivePromise).addListener(isA(GenericFutureListener.class));
    verify(defaultChannelProgressivePromise2).channel();
    verify(defaultChannelProgressivePromise).setFailure(isA(Throwable.class));
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    verify(embeddedChannel).close();
    verify(defaultChannelProgressivePromise2).cause();
    verify(defaultChannelProgressivePromise2).isDone();
    verify(defaultChannelProgressivePromise2).isSuccess();
    verify(defaultChannelProgressivePromise).tryFailure(isA(Throwable.class));
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <ul>
   *   <li>Given {@link DefaultEventLoop} {@link DefaultEventLoop#next()} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName(
      "Test connect(String, int) with 'host', 'port'; given DefaultEventLoop next() throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort_givenDefaultEventLoopNextThrowIllegalStateException() {
    // Arrange
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenThrow(new IllegalStateException());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> mqttClientImpl.connect("localhost", 8080));
    verify(eventLoop).next();
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <ul>
   *   <li>Given {@link DefaultEventLoop} {@link DefaultEventLoop#register(Channel)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName(
      "Test connect(String, int) with 'host', 'port'; given DefaultEventLoop register(Channel) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort_givenDefaultEventLoopRegisterThrowIllegalStateException() {
    // Arrange
    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.register(Mockito.<Channel>any())).thenThrow(new IllegalStateException());
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> mqttClientImpl.connect("localhost", 8080));
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <ul>
   *   <li>Given {@link DefaultEventLoop} {@link DefaultEventLoop#schedule(Runnable, long,
   *       TimeUnit)} throw {@link IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName(
      "Test connect(String, int) with 'host', 'port'; given DefaultEventLoop schedule(Runnable, long, TimeUnit) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort_givenDefaultEventLoopScheduleThrowIllegalStateException() {
    // Arrange
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.isSuccess()).thenReturn(true);
    when(defaultChannelProgressivePromise.isDone()).thenReturn(true);
    when(defaultChannelProgressivePromise.channel()).thenReturn(new EmbeddedChannel());
    when(defaultChannelProgressivePromise.cause()).thenReturn(new Throwable());

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    Mockito.<ScheduledFuture<?>>when(
            eventLoop.schedule(Mockito.<Runnable>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenThrow(new IllegalStateException());
    when(eventLoop.register(Mockito.<Channel>any())).thenReturn(defaultChannelProgressivePromise);
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    verify(defaultChannelProgressivePromise).channel();
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    verify(eventLoop).schedule(isA(Runnable.class), eq(1L), eq(TimeUnit.SECONDS));
    verify(defaultChannelProgressivePromise).cause();
    verify(defaultChannelProgressivePromise).isDone();
    verify(defaultChannelProgressivePromise).isSuccess();
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultChannelProgressivePromise#addListener(GenericFutureListener)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName(
      "Test connect(String, int) with 'host', 'port'; then calls addListener(GenericFutureListener)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort_thenCallsAddListener() {
    // Arrange
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.tryFailure(Mockito.<Throwable>any())).thenReturn(true);
    when(defaultChannelProgressivePromise.setFailure(Mockito.<Throwable>any()))
        .thenThrow(new IllegalStateException());
    when(defaultChannelProgressivePromise.addListener(
            Mockito.<GenericFutureListener<Future<Void>>>any()))
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));

    EmbeddedChannel embeddedChannel = mock(EmbeddedChannel.class);
    when(embeddedChannel.close())
        .thenReturn(new DefaultChannelProgressivePromise(new EmbeddedChannel()));
    when(embeddedChannel.newPromise()).thenReturn(defaultChannelProgressivePromise);
    when(embeddedChannel.eventLoop()).thenReturn(null);

    DefaultChannelProgressivePromise defaultChannelProgressivePromise2 =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise2.isSuccess()).thenReturn(true);
    when(defaultChannelProgressivePromise2.isDone()).thenReturn(true);
    when(defaultChannelProgressivePromise2.channel()).thenReturn(embeddedChannel);
    when(defaultChannelProgressivePromise2.cause()).thenReturn(new Throwable());

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.register(Mockito.<Channel>any())).thenReturn(defaultChannelProgressivePromise2);
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    verify(embeddedChannel).eventLoop();
    verify(embeddedChannel).newPromise();
    verify(defaultChannelProgressivePromise).addListener(isA(GenericFutureListener.class));
    verify(defaultChannelProgressivePromise2).channel();
    verify(defaultChannelProgressivePromise).setFailure(isA(Throwable.class));
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    verify(embeddedChannel).close();
    verify(defaultChannelProgressivePromise2).cause();
    verify(defaultChannelProgressivePromise2).isDone();
    verify(defaultChannelProgressivePromise2).isSuccess();
    verify(defaultChannelProgressivePromise).tryFailure(isA(Throwable.class));
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <ul>
   *   <li>Then calls {@link ThreadFactory#newThread(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName("Test connect(String, int) with 'host', 'port'; then calls newThread(Runnable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort_thenCallsNewThread() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenThrow(new IllegalStateException());
    DefaultEventLoop eventLoop = new DefaultEventLoop(threadFactory);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String, int)} with {@code host}, {@code port}.
   *
   * <ul>
   *   <li>Then calls {@link DefaultEventLoop#schedule(Runnable, long, TimeUnit)}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String, int)}
   */
  @Test
  @DisplayName(
      "Test connect(String, int) with 'host', 'port'; then calls schedule(Runnable, long, TimeUnit)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String, int)"})
  void testConnectWithHostPort_thenCallsSchedule() {
    // Arrange
    DefaultChannelProgressivePromise defaultChannelProgressivePromise =
        mock(DefaultChannelProgressivePromise.class);
    when(defaultChannelProgressivePromise.isSuccess()).thenReturn(true);
    when(defaultChannelProgressivePromise.isDone()).thenReturn(true);
    when(defaultChannelProgressivePromise.channel()).thenReturn(new EmbeddedChannel());
    when(defaultChannelProgressivePromise.cause()).thenReturn(new Throwable());

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    Mockito.<ScheduledFuture<?>>when(
            eventLoop.schedule(Mockito.<Runnable>any(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(mock(ScheduledFuture.class));
    when(eventLoop.register(Mockito.<Channel>any())).thenReturn(defaultChannelProgressivePromise);
    when(eventLoop.next()).thenReturn(new DefaultEventLoop());

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost", 8080);

    // Assert
    verify(defaultChannelProgressivePromise).channel();
    verify(eventLoop).next();
    verify(eventLoop).register(isA(Channel.class));
    verify(eventLoop).schedule(isA(Runnable.class), eq(1L), eq(TimeUnit.SECONDS));
    verify(defaultChannelProgressivePromise).cause();
    verify(defaultChannelProgressivePromise).isDone();
    verify(defaultChannelProgressivePromise).isSuccess();
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   *
   * <ul>
   *   <li>Given {@link ThreadFactory} {@link ThreadFactory#newThread(Runnable)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName(
      "Test connect(String) with 'host'; given ThreadFactory newThread(Runnable) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost_givenThreadFactoryNewThreadReturnNull() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(null);
    LocalEventLoopGroup eventLoop = new LocalEventLoopGroup(threadFactory);
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.connect("org.thingsboard.mqtt.MqttClientImpl");

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof LocalEventLoopGroup);
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
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   *
   * <ul>
   *   <li>Given {@link ThreadFactory} {@link ThreadFactory#newThread(Runnable)} return {@link
   *       Thread#Thread()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName(
      "Test connect(String) with 'host'; given ThreadFactory newThread(Runnable) return Thread()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost_givenThreadFactoryNewThreadReturnThread() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenReturn(new Thread());
    DefaultEventLoop eventLoop = new DefaultEventLoop(threadFactory);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost");

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   *
   * <ul>
   *   <li>Given {@link ThreadFactory} {@link ThreadFactory#newThread(Runnable)} throw {@link
   *       IllegalStateException#IllegalStateException()}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName(
      "Test connect(String) with 'host'; given ThreadFactory newThread(Runnable) throw IllegalStateException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost_givenThreadFactoryNewThreadThrowIllegalStateException() {
    // Arrange
    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenThrow(new IllegalStateException());
    DefaultEventLoop eventLoop = new DefaultEventLoop(threadFactory);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Promise<MqttConnectResult> actualConnectResult = mqttClientImpl.connect("localhost");

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    assertTrue(actualConnectResult instanceof DefaultPromise);
  }

  /**
   * Test {@link MqttClientImpl#connect(String)} with {@code host}.
   *
   * <ul>
   *   <li>When {@code localhost42}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#connect(String)}
   */
  @Test
  @DisplayName("Test connect(String) with 'host'; when 'localhost42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Promise MqttClientImpl.connect(String)"})
  void testConnectWithHost_whenLocalhost42() {
    // Arrange
    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));

    ThreadFactory threadFactory = mock(ThreadFactory.class);
    when(threadFactory.newThread(Mockito.<Runnable>any())).thenThrow(new IllegalStateException());
    LocalEventLoopGroup eventLoop = new LocalEventLoopGroup(threadFactory);
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    mqttClientImpl.connect("localhost42");

    // Assert
    verify(threadFactory).newThread(isA(Runnable.class));
    EventLoopGroup eventLoop2 = mqttClientImpl.getEventLoop();
    assertTrue(eventLoop2 instanceof LocalEventLoopGroup);
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
  @MethodsUnderTest({"Promise MqttClientImpl.reconnect()"})
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic2() {
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
   * Test {@link MqttClientImpl#off(String)} with {@code topic}.
   *
   * <p>Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic3() throws InterruptedException, ExecutionException {
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic4() throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic5() throws InterruptedException, ExecutionException {
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
    Future<Void> actualOffResult = mqttClientImpl.off("[{}] Unsubscribing from {}Topic");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic6() throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(
            mock(MqttClientConfig.class), mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setCallback(mock(MqttClientCallback.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("[{}] Unsubscribing from {}Topic");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic7() throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    defaultEventLoop.addShutdownHook(mock(Runnable.class));

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(
            mock(MqttClientConfig.class), mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setCallback(mock(MqttClientCallback.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("[{}] Unsubscribing from {}Topic");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic8() throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    defaultEventLoop.addShutdownHook(mock(Runnable.class));

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setCallback(mock(MqttClientCallback.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOffResult =
        mqttClientImpl.off(
            "[{}] Unsubscribing from {}org.thingsboard.mqtt.MqttPendingSubscription");

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic9() throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    defaultEventLoop.addShutdownHook(mock(Runnable.class));

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setCallback(mock(MqttClientCallback.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOffResult =
        mqttClientImpl.off(
            "[{}] Unsubscribing from {}org.thingsboard.mqtt.MqttPendingSubscription");

    // Assert
    verify(eventLoop).next();
    assertTrue(actualOffResult instanceof DefaultPromise);
    assertNull(actualOffResult.get());
    assertTrue(actualOffResult.isDone());
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
   *   <li>When {@code [{}] Unsubscribing from {}Topic}.
   * </ul>
   *
   * <p>Method under test: {@link MqttClientImpl#off(String)}
   */
  @Test
  @DisplayName("Test off(String) with 'topic'; when '[{}] Unsubscribing from {}Topic'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Future MqttClientImpl.off(String)"})
  void testOffWithTopic_whenUnsubscribingFromTopic()
      throws InterruptedException, ExecutionException {
    // Arrange
    DefaultEventLoop defaultEventLoop = new DefaultEventLoop();
    defaultEventLoop.addShutdownHook(mock(Runnable.class));
    defaultEventLoop.addShutdownHook(mock(Runnable.class));

    DefaultEventLoop eventLoop = mock(DefaultEventLoop.class);
    when(eventLoop.next()).thenReturn(defaultEventLoop);

    MqttClientImpl mqttClientImpl =
        new MqttClientImpl(mock(MqttHandler.class), mock(ListeningExecutor.class));
    mqttClientImpl.setEventLoop(eventLoop);

    // Act
    Future<Void> actualOffResult = mqttClientImpl.off("[{}] Unsubscribing from {}Topic");

    // Assert
    verify(eventLoop).next();
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
  @MethodsUnderTest({"ChannelFuture MqttClientImpl.sendAndFlushPacket(Object)"})
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
