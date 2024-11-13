package org.thingsboard.server.queue.azure.servicebus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;

class TbServiceBusConsumerTemplateDiffblueTest {
  /**
   * Test
   * {@link TbServiceBusConsumerTemplate#TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbServiceBusConsumerTemplate#TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder); when 'null'; then return 'Topic'")
  void testNewTbServiceBusConsumerTemplate_whenNull_thenReturnTopic() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    TbServiceBusConsumerTemplate<TbQueueMsg> actualTbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(
        null, new TbServiceBusSettings(), "Topic", mock(TbQueueMsgDecoder.class));

    // Assert
    assertEquals("Topic", actualTbServiceBusConsumerTemplate.getTopic());
    assertFalse(actualTbServiceBusConsumerTemplate.isStopped());
    assertTrue(actualTbServiceBusConsumerTemplate.getFullTopicNames().isEmpty());
  }
}
