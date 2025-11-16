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
package org.thingsboard.server.queue.common;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Consumer;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.queue.TbQueueMsgMetadata;
import org.thingsboard.server.queue.kafka.KafkaTbQueueMsgMetadata;

class SimpleTbQueueCallbackDiffblueTest {
  /**
   * Test {@link SimpleTbQueueCallback#onSuccess(TbQueueMsgMetadata)}.
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTbQueueCallback#onSuccess(TbQueueMsgMetadata)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(TbQueueMsgMetadata); given Consumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTbQueueCallback.onSuccess(TbQueueMsgMetadata)"})
  void testOnSuccess_givenConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    Consumer<TbQueueMsgMetadata> onSuccess = mock(Consumer.class);
    doNothing().when(onSuccess).accept(Mockito.<TbQueueMsgMetadata>any());
    SimpleTbQueueCallback simpleTbQueueCallback =
        new SimpleTbQueueCallback(onSuccess, mock(Consumer.class));
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);

    // Act
    simpleTbQueueCallback.onSuccess(new KafkaTbQueueMsgMetadata(metadata));

    // Assert
    verify(onSuccess).accept(isA(TbQueueMsgMetadata.class));
  }

  /**
   * Test {@link SimpleTbQueueCallback#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link Consumer} {@link Consumer#accept(Object)} does nothing.
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link SimpleTbQueueCallback#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); given Consumer accept(Object) does nothing; then calls accept(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SimpleTbQueueCallback.onFailure(Throwable)"})
  void testOnFailure_givenConsumerAcceptDoesNothing_thenCallsAccept() {
    // Arrange
    Consumer<Throwable> onFailure = mock(Consumer.class);
    doNothing().when(onFailure).accept(Mockito.<Throwable>any());
    SimpleTbQueueCallback simpleTbQueueCallback =
        new SimpleTbQueueCallback(mock(Consumer.class), onFailure);

    // Act
    simpleTbQueueCallback.onFailure(new Throwable());

    // Assert
    verify(onFailure).accept(isA(Throwable.class));
  }
}
