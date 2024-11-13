package org.thingsboard.server.queue.sqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;

class TbAwsSqsConsumerTemplateDiffblueTest {
  /**
   * Test
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}.
   * <p>
   * Method under test:
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)")
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
   * Test
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>Then calls {@link TbAwsSqsSettings#getAccessKeyId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAwsSqsConsumerTemplate#TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbAwsSqsConsumerTemplate(TbQueueAdmin, TbAwsSqsSettings, String, TbQueueMsgDecoder); given 'false'; then calls getAccessKeyId()")
  void testNewTbAwsSqsConsumerTemplate_givenFalse_thenCallsGetAccessKeyId() {
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
