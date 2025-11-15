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
package org.thingsboard.server.queue.sqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;

class TbAwsSqsConsumerTemplateDiffblueTest {
  /**
   * Method under test:
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  void testNewTbAwsSqsConsumerTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbAwsSqsSettings sqsSettings = mock(TbAwsSqsSettings.class);
    when(sqsSettings.getRegion()).thenReturn("us-east-2");
    when(sqsSettings.getUseDefaultCredentialProviderChain()).thenReturn(true);

    // Act
    TbAwsSqsConsumerTemplate<TbQueueMsg> actualTbAwsSqsConsumerTemplate = new TbAwsSqsConsumerTemplate<>(null,
        sqsSettings, "Topic", mock(TbQueueMsgDecoder.class));

    // Assert
    verify(sqsSettings).getRegion();
    verify(sqsSettings).getUseDefaultCredentialProviderChain();
    assertEquals("Topic", actualTbAwsSqsConsumerTemplate.getTopic());
    assertFalse(actualTbAwsSqsConsumerTemplate.isStopped());
    assertTrue(actualTbAwsSqsConsumerTemplate.getFullTopicNames().isEmpty());
  }

  /**
   * Method under test:
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  void testNewTbAwsSqsConsumerTemplate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbAwsSqsSettings sqsSettings = mock(TbAwsSqsSettings.class);
    when(sqsSettings.getRegion()).thenReturn("us-east-2");
    when(sqsSettings.getUseDefaultCredentialProviderChain()).thenReturn(false);
    when(sqsSettings.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(sqsSettings.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    TbAwsSqsConsumerTemplate<TbQueueMsg> actualTbAwsSqsConsumerTemplate = new TbAwsSqsConsumerTemplate<>(null,
        sqsSettings, "Topic", mock(TbQueueMsgDecoder.class));

    // Assert
    verify(sqsSettings).getAccessKeyId();
    verify(sqsSettings).getRegion();
    verify(sqsSettings).getSecretAccessKey();
    verify(sqsSettings).getUseDefaultCredentialProviderChain();
    assertEquals("Topic", actualTbAwsSqsConsumerTemplate.getTopic());
    assertFalse(actualTbAwsSqsConsumerTemplate.isStopped());
    assertTrue(actualTbAwsSqsConsumerTemplate.getFullTopicNames().isEmpty());
  }
}
