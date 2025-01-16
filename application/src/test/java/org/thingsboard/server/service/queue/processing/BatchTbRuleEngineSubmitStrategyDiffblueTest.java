package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.UUID;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;

class BatchTbRuleEngineSubmitStrategyDiffblueTest {
  /**
   * Test
   * {@link BatchTbRuleEngineSubmitStrategy#BatchTbRuleEngineSubmitStrategy(String, int)}.
   * <p>
   * Method under test:
   * {@link BatchTbRuleEngineSubmitStrategy#BatchTbRuleEngineSubmitStrategy(String, int)}
   */
  @Test
  @DisplayName("Test new BatchTbRuleEngineSubmitStrategy(String, int)")
  void testNewBatchTbRuleEngineSubmitStrategy() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    BatchTbRuleEngineSubmitStrategy actualBatchTbRuleEngineSubmitStrategy = new BatchTbRuleEngineSubmitStrategy(
        "Queue Name", 3);

    // Assert
    assertEquals("Queue Name", actualBatchTbRuleEngineSubmitStrategy.queueName);
    assertNull(actualBatchTbRuleEngineSubmitStrategy.orderedMsgList);
  }

  /**
   * Test {@link BatchTbRuleEngineSubmitStrategy#submitAttempt(BiConsumer)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then calls {@link BiConsumer#accept(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BatchTbRuleEngineSubmitStrategy#submitAttempt(BiConsumer)}
   */
  @Test
  @DisplayName("Test submitAttempt(BiConsumer); given ArrayList() add 'null'; then calls accept(Object, Object)")
  void testSubmitAttempt_givenArrayListAddNull_thenCallsAccept() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgs = new ArrayList<>();
    msgs.add(null);

    BatchTbRuleEngineSubmitStrategy batchTbRuleEngineSubmitStrategy = new BatchTbRuleEngineSubmitStrategy("Queue Name",
        3);
    batchTbRuleEngineSubmitStrategy.init(msgs);
    BiConsumer<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgConsumer = mock(BiConsumer.class);
    doNothing().when(msgConsumer)
        .accept(Mockito.<UUID>any(), Mockito.<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>>any());

    // Act
    batchTbRuleEngineSubmitStrategy.submitAttempt(msgConsumer);

    // Assert
    verify(msgConsumer).accept(isA(UUID.class), isNull());
  }
}
