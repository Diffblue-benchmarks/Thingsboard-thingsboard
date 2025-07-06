package org.thingsboard.server.queue.pubsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;

@ExtendWith(MockitoExtension.class)
class TbPubSubProducerTemplateDiffblueTest {
  @Mock private TbPubSubSettings tbPubSubSettings;

  @Mock private TbQueueAdmin tbQueueAdmin;

  /**
   * Test {@link TbPubSubProducerTemplate#TbPubSubProducerTemplate(TbQueueAdmin, TbPubSubSettings,
   * String)}.
   *
   * <p>Method under test: {@link TbPubSubProducerTemplate#TbPubSubProducerTemplate(TbQueueAdmin,
   * TbPubSubSettings, String)}
   */
  @Test
  @DisplayName("Test new TbPubSubProducerTemplate(TbQueueAdmin, TbPubSubSettings, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbPubSubProducerTemplate.<init>(TbQueueAdmin, TbPubSubSettings, String)"
  })
  void testNewTbPubSubProducerTemplate() {
    // Arrange and Act
    TbPubSubProducerTemplate<TbQueueMsg> actualTbPubSubProducerTemplate =
        new TbPubSubProducerTemplate<>(tbQueueAdmin, tbPubSubSettings, "Default Topic");

    // Assert
    assertEquals("Default Topic", actualTbPubSubProducerTemplate.getDefaultTopic());
  }
}
