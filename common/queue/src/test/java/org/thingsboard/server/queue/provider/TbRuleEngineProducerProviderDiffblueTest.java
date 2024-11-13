package org.thingsboard.server.queue.provider;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbRuleEngineProducerProviderDiffblueTest {
  /**
   * Test {@link TbRuleEngineProducerProvider#getTbVersionControlMsgProducer()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProducerProvider#getTbVersionControlMsgProducer()}
   */
  @Test
  @DisplayName("Test getTbVersionControlMsgProducer(); then throw RuntimeException")
  void testGetTbVersionControlMsgProducer_thenThrowRuntimeException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertThrows(RuntimeException.class,
        () -> (new TbRuleEngineProducerProvider(null)).getTbVersionControlMsgProducer());
  }
}
