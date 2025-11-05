package org.thingsboard.server.queue.pubsub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;

class TbPubSubProducerTemplateDiffblueTest {
  /**
   * Test {@link TbPubSubProducerTemplate#TbPubSubProducerTemplate(TbQueueAdmin, TbPubSubSettings,
   * String)}.
   *
   * <p>Method under test: {@link TbPubSubProducerTemplate#TbPubSubProducerTemplate(TbQueueAdmin,
   * TbPubSubSettings, String)}
   */
  @Test
  @DisplayName("Test new TbPubSubProducerTemplate(TbQueueAdmin, TbPubSubSettings, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbPubSubProducerTemplate.<init>(TbQueueAdmin, TbPubSubSettings, String)"
  })
  void testNewTbPubSubProducerTemplate() {
    // Arrange and Act
    TbPubSubProducerTemplate<TbQueueMsg> actualTbPubSubProducerTemplate =
        new TbPubSubProducerTemplate<>(null, new TbPubSubSettings(), "Default Topic");

    // Assert
    assertEquals("Default Topic", actualTbPubSubProducerTemplate.getDefaultTopic());
  }
}
