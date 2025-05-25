package org.thingsboard.server.queue.azure.servicebus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;
import org.thingsboard.server.queue.TbQueueMsgDecoder;

@ExtendWith(MockitoExtension.class)
class TbServiceBusConsumerTemplateDiffblueTest {
  @Mock
  private TbQueueAdmin tbQueueAdmin;

  @Mock
  private TbServiceBusSettings tbServiceBusSettings;

  /**
   * Test {@link TbServiceBusConsumerTemplate#TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)}.
   * <p>
   * Method under test: {@link TbServiceBusConsumerTemplate#TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)}
   */
  @Test
  @DisplayName("Test new TbServiceBusConsumerTemplate(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void TbServiceBusConsumerTemplate.<init>(TbQueueAdmin, TbServiceBusSettings, String, TbQueueMsgDecoder)"})
  void testNewTbServiceBusConsumerTemplate() {
    // Arrange and Act
    TbServiceBusConsumerTemplate<TbQueueMsg> actualTbServiceBusConsumerTemplate = new TbServiceBusConsumerTemplate<>(
        tbQueueAdmin, tbServiceBusSettings, "Topic", mock(TbQueueMsgDecoder.class));

    // Assert
    assertEquals("Topic", actualTbServiceBusConsumerTemplate.getTopic());
    assertFalse(actualTbServiceBusConsumerTemplate.isStopped());
    assertTrue(actualTbServiceBusConsumerTemplate.getFullTopicNames().isEmpty());
  }
}
