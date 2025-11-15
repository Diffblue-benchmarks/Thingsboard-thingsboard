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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusConsumerTemplate;
import org.thingsboard.server.queue.azure.servicebus.TbServiceBusSettings;

class AbstractTbQueueConsumerTemplateDiffblueTest {
  /**
   * Method under test: {@link AbstractTbQueueConsumerTemplate#poll(long)}
   */
  @Test
  void testPoll() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(null,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertTrue(tbServiceBusConsumerTemplate.poll(1L).isEmpty());
  }

  /**
   * Method under test: {@link AbstractTbQueueConsumerTemplate#stop()}
   */
  @Test
  void testStop() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(null,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbServiceBusConsumerTemplate.stop();

    // Assert
    assertTrue(tbServiceBusConsumerTemplate.isStopped());
  }

  /**
   * Method under test: {@link AbstractTbQueueConsumerTemplate#unsubscribe()}
   */
  @Test
  void testUnsubscribe() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(null,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act
    tbServiceBusConsumerTemplate.unsubscribe();

    // Assert
    assertTrue(tbServiceBusConsumerTemplate.isStopped());
  }

  /**
   * Method under test: {@link AbstractTbQueueConsumerTemplate#isStopped()}
   */
  @Test
  void testIsStopped() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(null,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertFalse(tbServiceBusConsumerTemplate.isStopped());
  }

  /**
   * Method under test:
   * {@link AbstractTbQueueConsumerTemplate#getFullTopicNames()}
   */
  @Test
  void testGetFullTopicNames() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(null,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertTrue(tbServiceBusConsumerTemplate.getFullTopicNames().isEmpty());
  }

  /**
   * Method under test:
   * {@link AbstractTbQueueConsumerTemplate#isLongPollingSupported()}
   */
  @Test
  void testIsLongPollingSupported() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(null,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertFalse(tbServiceBusConsumerTemplate.isLongPollingSupported());
  }

  /**
   * Method under test: {@link AbstractTbQueueConsumerTemplate#getTopic()}
   */
  @Test
  void testGetTopic() {
    // Arrange
    TbServiceBusConsumerTemplate<TbQueueMsg> tbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(null,
        new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Act and Assert
    assertEquals("Topic", tbServiceBusConsumerTemplate.getTopic());
  }
}
