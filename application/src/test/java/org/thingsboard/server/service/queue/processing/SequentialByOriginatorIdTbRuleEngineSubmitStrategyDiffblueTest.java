package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SequentialByOriginatorIdTbRuleEngineSubmitStrategyDiffblueTest {
  /**
   * Test
   * {@link SequentialByOriginatorIdTbRuleEngineSubmitStrategy#SequentialByOriginatorIdTbRuleEngineSubmitStrategy(String)}.
   * <p>
   * Method under test:
   * {@link SequentialByOriginatorIdTbRuleEngineSubmitStrategy#SequentialByOriginatorIdTbRuleEngineSubmitStrategy(String)}
   */
  @Test
  @DisplayName("Test new SequentialByOriginatorIdTbRuleEngineSubmitStrategy(String)")
  void testNewSequentialByOriginatorIdTbRuleEngineSubmitStrategy() {
    // Arrange and Act
    SequentialByOriginatorIdTbRuleEngineSubmitStrategy actualSequentialByOriginatorIdTbRuleEngineSubmitStrategy = new SequentialByOriginatorIdTbRuleEngineSubmitStrategy(
        "Queue Name");

    // Assert
    assertEquals("Queue Name", actualSequentialByOriginatorIdTbRuleEngineSubmitStrategy.queueName);
    assertNull(actualSequentialByOriginatorIdTbRuleEngineSubmitStrategy.orderedMsgList);
  }
}
