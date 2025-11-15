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
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.queue.TbQueueConsumer;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusConsumerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;
import org.thingsboard.server.queue.common.consumer.QueueConsumerManager.MsgPackProcessor;
import org.thingsboard.server.queue.common.consumer.QueueConsumerManager.QueueConsumerManagerBuilder;

@ContextConfiguration(classes = {QueueConsumerManagerBuilder.class})
@ExtendWith(SpringExtension.class)
class QueueConsumerManagerDiffblueTest {
  @Autowired
  private QueueConsumerManagerBuilder<TbQueueMsg> queueConsumerManagerBuilder;

  /**
   * Test {@link QueueConsumerManager#QueueConsumerManager(String, MsgPackProcessor, long, Supplier, ExecutorService, String)}.
   * <p>
   * Method under test: {@link QueueConsumerManager#QueueConsumerManager(String, MsgPackProcessor, long, Supplier, ExecutorService, String)}
   */
  @Test
  @DisplayName("Test new QueueConsumerManager(String, MsgPackProcessor, long, Supplier, ExecutorService, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void QueueConsumerManager.<init>(String, MsgPackProcessor, long, Supplier, ExecutorService, String)"})
  void testNewQueueConsumerManager() {
    // Arrange
    MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(MsgPackProcessor.class);
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
   *   <li>{@link QueueConsumerManagerBuilder#build()}
   *   <li>{@link QueueConsumerManagerBuilder#consumerCreator(Supplier)}
   *   <li>{@link QueueConsumerManagerBuilder#consumerExecutor(ExecutorService)}
   *   <li>{@link QueueConsumerManagerBuilder#msgPackProcessor(MsgPackProcessor)}
   *   <li>{@link QueueConsumerManagerBuilder#name(String)}
   *   <li>{@link QueueConsumerManagerBuilder#pollInterval(long)}
   *   <li>{@link QueueConsumerManagerBuilder#threadPrefix(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test QueueConsumerManagerBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueConsumerManagerBuilder.<init>()",
      "QueueConsumerManager QueueConsumerManagerBuilder.build()",
      "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.consumerCreator(Supplier)",
      "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.consumerExecutor(ExecutorService)",
      "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.msgPackProcessor(MsgPackProcessor)",
      "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.name(String)",
      "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.pollInterval(long)",
      "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.threadPrefix(String)",
      "String QueueConsumerManagerBuilder.toString()"})
  void testQueueConsumerManagerBuilderBuild() {
    // Arrange
    QueueConsumerManagerBuilder<TbQueueMsg> builderResult = QueueConsumerManager.builder();
    QueueConsumerManagerBuilder<TbQueueMsg> consumerCreatorResult = builderResult.consumerCreator(mock(Supplier.class));

    // Act and Assert
    assertNull(consumerCreatorResult.consumerExecutor(new DefaultEventLoop())
        .msgPackProcessor(mock(MsgPackProcessor.class))
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueConsumerManager.subscribe(Set)"})
  void testSubscribeWithSet_thenCallsGet() {
    // Arrange
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    when(consumerCreator.get()).thenReturn(
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));
    MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(MsgPackProcessor.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueConsumerManager.subscribe()"})
  void testSubscribe_thenCallsGet() {
    // Arrange
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    when(consumerCreator.get()).thenReturn(
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));
    MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(MsgPackProcessor.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueConsumerManager.launch()"})
  void testLaunch() {
    // Arrange
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    when(consumerCreator.get()).thenReturn(
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));
    MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(MsgPackProcessor.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueConsumerManager.stop()"})
  void testStop() {
    // Arrange
    Supplier<TbQueueConsumer<TbQueueMsg>> consumerCreator = mock(Supplier.class);
    when(consumerCreator.get()).thenReturn(
        new TbServiceBusConsumerTemplate<>(null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class)));
    MsgPackProcessor<TbQueueMsg> msgPackProcessor = mock(MsgPackProcessor.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbQueueConsumer QueueConsumerManager.getConsumer()"})
  void testGetConsumer() {
    // Arrange
    QueueConsumerManagerBuilder<TbQueueMsg> builderResult = QueueConsumerManager.builder();
    QueueConsumerManagerBuilder<TbQueueMsg> consumerCreatorResult = builderResult.consumerCreator(mock(Supplier.class));
    QueueConsumerManager<TbQueueMsg> buildResult = consumerCreatorResult.consumerExecutor(new DefaultEventLoop())
        .msgPackProcessor(mock(MsgPackProcessor.class))
        .name("Name")
        .pollInterval(42L)
        .threadPrefix("Thread Prefix")
        .build();

    // Act and Assert
    assertNull(buildResult.getConsumer());
  }
}
