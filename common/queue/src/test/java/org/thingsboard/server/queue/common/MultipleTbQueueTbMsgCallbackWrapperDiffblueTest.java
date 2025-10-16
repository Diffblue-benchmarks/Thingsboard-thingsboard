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
import java.io.IOException;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.queue.TbQueueMsgMetadata;
import org.thingsboard.server.queue.kafka.KafkaTbQueueMsgMetadata;

class MultipleTbQueueTbMsgCallbackWrapperDiffblueTest {
  /**
   * Test {@link MultipleTbQueueTbMsgCallbackWrapper#onSuccess(TbQueueMsgMetadata)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgCallback} {@link TbMsgCallback#onSuccess()} does nothing.
   *   <li>Then calls {@link TbMsgCallback#onSuccess()}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleTbQueueTbMsgCallbackWrapper#onSuccess(TbQueueMsgMetadata)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(TbQueueMsgMetadata); given TbMsgCallback onSuccess() does nothing; then calls onSuccess()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleTbQueueTbMsgCallbackWrapper.onSuccess(TbQueueMsgMetadata)"})
  void testOnSuccess_givenTbMsgCallbackOnSuccessDoesNothing_thenCallsOnSuccess() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onSuccess();
    MultipleTbQueueTbMsgCallbackWrapper multipleTbQueueTbMsgCallbackWrapper =
        new MultipleTbQueueTbMsgCallbackWrapper(1, tbMsgCallback);
    RecordMetadata metadata = new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3);

    // Act
    multipleTbQueueTbMsgCallbackWrapper.onSuccess(new KafkaTbQueueMsgMetadata(metadata));

    // Assert
    verify(tbMsgCallback).onSuccess();
  }

  /**
   * Test {@link MultipleTbQueueTbMsgCallbackWrapper#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code Unknown}.
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleTbQueueTbMsgCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); when IOException(String) with 'Unknown'; then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleTbQueueTbMsgCallbackWrapper.onFailure(Throwable)"})
  void testOnFailure_whenIOExceptionWithUnknown_thenCallsOnFailure() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    MultipleTbQueueTbMsgCallbackWrapper multipleTbQueueTbMsgCallbackWrapper =
        new MultipleTbQueueTbMsgCallbackWrapper(3, tbMsgCallback);

    // Act
    multipleTbQueueTbMsgCallbackWrapper.onFailure(new IOException("Unknown"));

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Test {@link MultipleTbQueueTbMsgCallbackWrapper#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then calls {@link TbMsgCallback#onFailure(RuleEngineException)}.
   * </ul>
   *
   * <p>Method under test: {@link MultipleTbQueueTbMsgCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); when Throwable(); then calls onFailure(RuleEngineException)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MultipleTbQueueTbMsgCallbackWrapper.onFailure(Throwable)"})
  void testOnFailure_whenThrowable_thenCallsOnFailure() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    MultipleTbQueueTbMsgCallbackWrapper multipleTbQueueTbMsgCallbackWrapper =
        new MultipleTbQueueTbMsgCallbackWrapper(3, tbMsgCallback);

    // Act
    multipleTbQueueTbMsgCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }
}
