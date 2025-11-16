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
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.common.consumer.QueueConsumerManager.MsgPackProcessor;
import org.thingsboard.server.queue.common.consumer.QueueConsumerManager.QueueConsumerManagerBuilder;

@ContextConfiguration(classes = {QueueConsumerManagerBuilder.class})
@ExtendWith(SpringExtension.class)
class QueueConsumerManagerDiffblueTest {
  @Autowired private QueueConsumerManagerBuilder<TbQueueMsg> queueConsumerManagerBuilder;

  /**
   * Test {@link QueueConsumerManager#getConsumer()}.
   *
   * <p>Method under test: {@link QueueConsumerManager#getConsumer()}
   */
  @Test
  @DisplayName("Test getConsumer()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.queue.TbQueueConsumer QueueConsumerManager.getConsumer()"
  })
  void testGetConsumer() {
    // Arrange
    QueueConsumerManagerBuilder<TbQueueMsg> builderResult = QueueConsumerManager.builder();

    QueueConsumerManagerBuilder<TbQueueMsg> consumerCreatorResult =
        builderResult.consumerCreator(mock(Supplier.class));

    // Act and Assert
    assertNull(
        consumerCreatorResult
            .consumerExecutor(new DefaultEventLoop())
            .msgPackProcessor(mock(MsgPackProcessor.class))
            .name("Name")
            .pollInterval(42L)
            .threadPrefix("Thread Prefix")
            .build()
            .getConsumer());
  }

  /**
   * Test QueueConsumerManagerBuilder {@link QueueConsumerManagerBuilder#build()}.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void QueueConsumerManagerBuilder.<init>()",
    "QueueConsumerManager QueueConsumerManagerBuilder.build()",
    "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.consumerCreator(Supplier)",
    "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.consumerExecutor(ExecutorService)",
    "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.msgPackProcessor(MsgPackProcessor)",
    "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.name(String)",
    "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.pollInterval(long)",
    "QueueConsumerManagerBuilder QueueConsumerManagerBuilder.threadPrefix(String)",
    "String QueueConsumerManagerBuilder.toString()"
  })
  void testQueueConsumerManagerBuilderBuild() {
    // Arrange and Act
    QueueConsumerManagerBuilder<TbQueueMsg> actualBuilderResult = QueueConsumerManager.builder();
    QueueConsumerManagerBuilder<TbQueueMsg> actualConsumerCreatorResult =
        actualBuilderResult.consumerCreator(mock(Supplier.class));

    // Assert
    assertNull(
        actualConsumerCreatorResult
            .consumerExecutor(new DefaultEventLoop())
            .msgPackProcessor(mock(MsgPackProcessor.class))
            .name("Name")
            .pollInterval(42L)
            .threadPrefix("Thread Prefix")
            .build()
            .getConsumer());
  }
}
