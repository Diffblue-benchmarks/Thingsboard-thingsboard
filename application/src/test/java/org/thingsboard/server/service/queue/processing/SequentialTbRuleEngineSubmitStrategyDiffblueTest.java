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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;

@ContextConfiguration(classes = {SequentialTbRuleEngineSubmitStrategy.class, String.class})
@ExtendWith(SpringExtension.class)
class SequentialTbRuleEngineSubmitStrategyDiffblueTest {
  @Autowired
  private SequentialTbRuleEngineSubmitStrategy sequentialTbRuleEngineSubmitStrategy;

  /**
   * Test
   * {@link SequentialTbRuleEngineSubmitStrategy#SequentialTbRuleEngineSubmitStrategy(String)}.
   * <p>
   * Method under test:
   * {@link SequentialTbRuleEngineSubmitStrategy#SequentialTbRuleEngineSubmitStrategy(String)}
   */
  @Test
  @DisplayName("Test new SequentialTbRuleEngineSubmitStrategy(String)")
  void testNewSequentialTbRuleEngineSubmitStrategy() {
    // Arrange and Act
    SequentialTbRuleEngineSubmitStrategy actualSequentialTbRuleEngineSubmitStrategy = new SequentialTbRuleEngineSubmitStrategy(
        "Queue Name");

    // Assert
    assertEquals("Queue Name", actualSequentialTbRuleEngineSubmitStrategy.queueName);
    assertNull(actualSequentialTbRuleEngineSubmitStrategy.orderedMsgList);
  }

  /**
   * Test {@link SequentialTbRuleEngineSubmitStrategy#submitAttempt(BiConsumer)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then calls {@link BiConsumer#accept(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SequentialTbRuleEngineSubmitStrategy#submitAttempt(BiConsumer)}
   */
  @Test
  @DisplayName("Test submitAttempt(BiConsumer); given ArrayList() add 'null'; then calls accept(Object, Object)")
  void testSubmitAttempt_givenArrayListAddNull_thenCallsAccept() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgs = new ArrayList<>();
    msgs.add(null);

    SequentialTbRuleEngineSubmitStrategy sequentialTbRuleEngineSubmitStrategy = new SequentialTbRuleEngineSubmitStrategy(
        "Queue Name");
    sequentialTbRuleEngineSubmitStrategy.init(msgs);
    BiConsumer<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgConsumer = mock(BiConsumer.class);
    doNothing().when(msgConsumer)
        .accept(Mockito.<UUID>any(), Mockito.<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>>any());

    // Act
    sequentialTbRuleEngineSubmitStrategy.submitAttempt(msgConsumer);

    // Assert
    verify(msgConsumer).accept(isA(UUID.class), isNull());
  }
}
