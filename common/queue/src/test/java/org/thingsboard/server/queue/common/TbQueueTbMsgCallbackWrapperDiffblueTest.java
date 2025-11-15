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
import java.io.IOException;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;
import org.thingsboard.server.queue.TbQueueMsgMetadata;
import org.thingsboard.server.queue.kafka.KafkaTbQueueMsgMetadata;

class TbQueueTbMsgCallbackWrapperDiffblueTest {
  /**
   * Method under test:
   * {@link TbQueueTbMsgCallbackWrapper#onSuccess(TbQueueMsgMetadata)}
   */
  @Test
  void testOnSuccess() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onSuccess();
    TbQueueTbMsgCallbackWrapper tbQueueTbMsgCallbackWrapper = new TbQueueTbMsgCallbackWrapper(tbMsgCallback);

    // Act
    tbQueueTbMsgCallbackWrapper
        .onSuccess(new KafkaTbQueueMsgMetadata(new RecordMetadata(new TopicPartition("Topic", 1), 1L, 1, 10L, 3, 3)));

    // Assert that nothing has changed
    verify(tbMsgCallback).onSuccess();
  }

  /**
   * Method under test: {@link TbQueueTbMsgCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  void testOnFailure() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    TbQueueTbMsgCallbackWrapper tbQueueTbMsgCallbackWrapper = new TbQueueTbMsgCallbackWrapper(tbMsgCallback);

    // Act
    tbQueueTbMsgCallbackWrapper.onFailure(new Throwable());

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }

  /**
   * Method under test: {@link TbQueueTbMsgCallbackWrapper#onFailure(Throwable)}
   */
  @Test
  void testOnFailure2() {
    // Arrange
    TbMsgCallback tbMsgCallback = mock(TbMsgCallback.class);
    doNothing().when(tbMsgCallback).onFailure(Mockito.<RuleEngineException>any());
    TbQueueTbMsgCallbackWrapper tbQueueTbMsgCallbackWrapper = new TbQueueTbMsgCallbackWrapper(tbMsgCallback);

    // Act
    tbQueueTbMsgCallbackWrapper.onFailure(new IOException("Unknown"));

    // Assert
    verify(tbMsgCallback).onFailure(isA(RuleEngineException.class));
  }
}
