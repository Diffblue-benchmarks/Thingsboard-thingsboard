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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusConsumerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;

class QueueConsumerManagerDiffblueTest {
  /**
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
   * Method under test: {@link QueueConsumerManager#subscribe()}
   */
  @Test
  void testSubscribe() {
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
   * Method under test: {@link QueueConsumerManager#subscribe(Set)}
   */
  @Test
  void testSubscribe2() {
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
   * Method under test: {@link QueueConsumerManager#launch()}
   */
  @Test
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
   * Method under test: {@link QueueConsumerManager#stop()}
   */
  @Test
  void testStop() {
    // Arrange
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(null,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    when(consumerCreator.get()).thenReturn(tbServiceBusConsumerTemplate);
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
    assertSame(tbServiceBusConsumerTemplate, consumer);
  }

  /**
   * Method under test: {@link QueueConsumerManager#getConsumer()}
   */
  @Test
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

  /**
   * Method under test:
   * {@link QueueConsumerManager#QueueConsumerManager(String, QueueConsumerManager.MsgPackProcessor, long, Supplier, ExecutorService, String)}
   */
  @Test
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
}
