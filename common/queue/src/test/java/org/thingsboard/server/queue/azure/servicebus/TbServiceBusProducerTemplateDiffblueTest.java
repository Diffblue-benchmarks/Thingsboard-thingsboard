package org.thingsboard.server.queue.azure.servicebus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.queue.TbQueueAdmin;
import org.thingsboard.server.queue.TbQueueMsg;

class TbServiceBusProducerTemplateDiffblueTest {
  /**
   * Test {@link TbServiceBusProducerTemplate#TbServiceBusProducerTemplate(TbQueueAdmin,
   * TbServiceBusSettings, String)}.
   *
   * <p>Method under test: {@link
   * TbServiceBusProducerTemplate#TbServiceBusProducerTemplate(TbQueueAdmin, TbServiceBusSettings,
   * String)}
   */
  @Test
  @DisplayName("Test new TbServiceBusProducerTemplate(TbQueueAdmin, TbServiceBusSettings, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbServiceBusProducerTemplate.<init>(TbQueueAdmin, TbServiceBusSettings, String)"
  })
  void testNewTbServiceBusProducerTemplate() {
    // Arrange and Act
    TbServiceBusProducerTemplate<TbQueueMsg> actualTbServiceBusProducerTemplate =
        new TbServiceBusProducerTemplate<>(null, new TbServiceBusSettings(), "Default Topic");

    // Assert
    assertEquals("Default Topic", actualTbServiceBusProducerTemplate.getDefaultTopic());
  }
}
