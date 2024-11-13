package org.thingsboard.server.queue.common.consumer;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusConsumerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;
import org.thingsboard.server.queue.common.consumer.QueueConsumerManager.QueueConsumerManagerBuilder;

class QueueConsumerManagerDiffblueTest {
  /**
   * Test
   * {@link QueueConsumerManager#QueueConsumerManager(String, MsgPackProcessor, long, Supplier, ExecutorService, String)}.
   * <p>
   * Method under test:
   * {@link QueueConsumerManager#QueueConsumerManager(String, QueueConsumerManager.MsgPackProcessor, long, Supplier, ExecutorService, String)}
   */
  @Test
  @DisplayName("Test new QueueConsumerManager(String, MsgPackProcessor, long, Supplier, ExecutorService, String)")
  void testNewQueueConsumerManager() {
    // Arrange
    QueueConsumerManager.MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(
        QueueConsumerManager.MsgPackProcessor.class);
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(null,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    when(consumerCreator.get()).thenReturn(tbServiceBusConsumerTemplate);

    // Act
    QueueConsumerManager<TbQueueMsg> actualQueueConsumerManager = new QueueConsumerManager<>("Name", msgPackProcessor,
        42L, consumerCreator, new DefaultEventLoop(), "Thread Prefix");

    // Assert
    verify(consumerCreator).get();
    assertSame(tbServiceBusConsumerTemplate, actualQueueConsumerManager.getConsumer());
  }

  /**
   * Test QueueConsumerManagerBuilder {@link QueueConsumerManagerBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link QueueConsumerManager.QueueConsumerManagerBuilder#build()}
   *   <li>
   * {@link QueueConsumerManager.QueueConsumerManagerBuilder#consumerCreator(Supplier)}
   *   <li>
   * {@link QueueConsumerManager.QueueConsumerManagerBuilder#consumerExecutor(ExecutorService)}
   *   <li>
   * {@link QueueConsumerManager.QueueConsumerManagerBuilder#msgPackProcessor(QueueConsumerManager.MsgPackProcessor)}
   *   <li>{@link QueueConsumerManager.QueueConsumerManagerBuilder#name(String)}
   *   <li>
   * {@link QueueConsumerManager.QueueConsumerManagerBuilder#pollInterval(long)}
   *   <li>
   * {@link QueueConsumerManager.QueueConsumerManagerBuilder#threadPrefix(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test QueueConsumerManagerBuilder build()")
  void testQueueConsumerManagerBuilderBuild() {
    // Arrange
    QueueConsumerManager.QueueConsumerManagerBuilder<TbQueueMsg> builderResult = QueueConsumerManager.builder();
    QueueConsumerManager.QueueConsumerManagerBuilder<TbQueueMsg> consumerCreatorResult = builderResult
        .consumerCreator(mock(Supplier.class));

    // Act and Assert
    assertNull(consumerCreatorResult.consumerExecutor(new DefaultEventLoop())
        .msgPackProcessor(mock(QueueConsumerManager.MsgPackProcessor.class))
        .name("Name")
        .pollInterval(42L)
        .threadPrefix("Thread Prefix")
        .build()
        .getConsumer());
  }

  /**
   * Test {@link QueueConsumerManager#subscribe(Set)} with {@code Set}.
   * <ul>
   *   <li>Then calls {@link Supplier#get()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueConsumerManager#subscribe(Set)}
   */
  @Test
  @DisplayName("Test subscribe(Set) with 'Set'; then calls get()")
  void testSubscribeWithSet_thenCallsGet() {
    // Arrange
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    when(consumerCreator.get()).thenReturn(
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));
    QueueConsumerManager.MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(
        QueueConsumerManager.MsgPackProcessor.class);
    QueueConsumerManager<TbQueueMsg> queueConsumerManager = new QueueConsumerManager<>("Name", msgPackProcessor, 42L,
        consumerCreator, new DefaultEventLoop(), "Thread Prefix");

    // Act
    queueConsumerManager.subscribe(new HashSet<>());

    // Assert
    verify(consumerCreator).get();
  }

  /**
   * Test {@link QueueConsumerManager#subscribe()}.
   * <ul>
   *   <li>Then calls {@link Supplier#get()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueConsumerManager#subscribe()}
   */
  @Test
  @DisplayName("Test subscribe(); then calls get()")
  void testSubscribe_thenCallsGet() {
    // Arrange
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    when(consumerCreator.get()).thenReturn(
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));
    QueueConsumerManager.MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(
        QueueConsumerManager.MsgPackProcessor.class);
    QueueConsumerManager<TbQueueMsg> queueConsumerManager = new QueueConsumerManager<>("Name", msgPackProcessor, 42L,
        consumerCreator, new DefaultEventLoop(), "Thread Prefix");

    // Act
    queueConsumerManager.subscribe();

    // Assert
    verify(consumerCreator).get();
  }

  /**
   * Test {@link QueueConsumerManager#launch()}.
   * <p>
   * Method under test: {@link QueueConsumerManager#launch()}
   */
  @Test
  @DisplayName("Test launch()")
  void testLaunch() {
    // Arrange
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    when(consumerCreator.get()).thenReturn(
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));
    QueueConsumerManager.MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(
        QueueConsumerManager.MsgPackProcessor.class);
    QueueConsumerManager<TbQueueMsg> queueConsumerManager = new QueueConsumerManager<>("Name", msgPackProcessor, 42L,
        consumerCreator, new DefaultEventLoop(), "Thread Prefix");

    // Act
    queueConsumerManager.launch();

    // Assert
    verify(consumerCreator).get();
  }

  /**
   * Test {@link QueueConsumerManager#launch()}.
   * <p>
   * Method under test: {@link QueueConsumerManager#launch()}
   */
  @Test
  @DisplayName("Test launch()")
  void testLaunch2() {
    // Arrange
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    when(consumerCreator.get()).thenReturn(
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));
    QueueConsumerManager.MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(
        QueueConsumerManager.MsgPackProcessor.class);
    QueueConsumerManager<TbQueueMsg> queueConsumerManager = new QueueConsumerManager<>("Name", msgPackProcessor, 42L,
        consumerCreator, new DefaultEventLoop(), "Thread Prefix");

    // Act
    queueConsumerManager.launch();

    // Assert
    verify(consumerCreator).get();
  }

  /**
   * Test {@link QueueConsumerManager#stop()}.
   * <p>
   * Method under test: {@link QueueConsumerManager#stop()}
   */
  @Test
  @DisplayName("Test stop()")
  void testStop() {
    // Arrange
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    when(consumerCreator.get()).thenReturn(
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));
    QueueConsumerManager.MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(
        QueueConsumerManager.MsgPackProcessor.class);
    QueueConsumerManager<TbQueueMsg> queueConsumerManager = new QueueConsumerManager<>("Name", msgPackProcessor, 42L,
        consumerCreator, new DefaultEventLoop(), "Thread Prefix");

    // Act
    queueConsumerManager.stop();

    // Assert
    verify(consumerCreator).get();
    TbQueueConsumer<TbQueueMsg> consumer = queueConsumerManager.getConsumer();
    assertTrue(consumer instanceof TbServiceBusConsumerTemplate);
    assertTrue(consumer.isStopped());
  }

  /**
   * Test {@link QueueConsumerManager#getConsumer()}.
   * <p>
   * Method under test: {@link QueueConsumerManager#getConsumer()}
   */
  @Test
  @DisplayName("Test getConsumer()")
  void testGetConsumer() {
    // Arrange
    QueueConsumerManager.QueueConsumerManagerBuilder<TbQueueMsg> builderResult = QueueConsumerManager.builder();
    QueueConsumerManager.QueueConsumerManagerBuilder<TbQueueMsg> consumerCreatorResult = builderResult
        .consumerCreator(mock(Supplier.class));
    QueueConsumerManager<TbQueueMsg> buildResult = consumerCreatorResult.consumerExecutor(new DefaultEventLoop())
        .msgPackProcessor(mock(QueueConsumerManager.MsgPackProcessor.class))
        .name("Name")
        .pollInterval(42L)
        .threadPrefix("Thread Prefix")
        .build();

    // Act and Assert
    assertNull(buildResult.getConsumer());
  }
}
