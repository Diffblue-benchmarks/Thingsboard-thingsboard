package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;

@ContextConfiguration(classes = {SequentialByOriginatorIdTbRuleEngineSubmitStrategy.class, String.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class SequentialByEntityIdTbRuleEngineSubmitStrategyDiffblueTest {
  @Autowired
  private SequentialByEntityIdTbRuleEngineSubmitStrategy sequentialByEntityIdTbRuleEngineSubmitStrategy;

  /**
   * Test {@link SequentialByEntityIdTbRuleEngineSubmitStrategy#init(List)}.
   * <p>
   * Method under test:
   * {@link SequentialByEntityIdTbRuleEngineSubmitStrategy#init(List)}
   */
  @Test
  @DisplayName("Test init(List)")
  void testInit() {
    // Arrange
    ArrayList<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgs = new ArrayList<>();

    // Act
    sequentialByEntityIdTbRuleEngineSubmitStrategy.init(msgs);

    // Assert
    assertTrue(
        sequentialByEntityIdTbRuleEngineSubmitStrategy instanceof SequentialByOriginatorIdTbRuleEngineSubmitStrategy);
    assertTrue(msgs.isEmpty());
    assertTrue(
        ((SequentialByOriginatorIdTbRuleEngineSubmitStrategy) sequentialByEntityIdTbRuleEngineSubmitStrategy).orderedMsgList
            .isEmpty());
    assertTrue(sequentialByEntityIdTbRuleEngineSubmitStrategy.getPendingMap().isEmpty());
  }
}
