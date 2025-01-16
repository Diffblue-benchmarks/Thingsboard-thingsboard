package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
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

class BurstTbRuleEngineSubmitStrategyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link BurstTbRuleEngineSubmitStrategy#BurstTbRuleEngineSubmitStrategy(String)}
   *   <li>{@link BurstTbRuleEngineSubmitStrategy#doOnSuccess(UUID)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    BurstTbRuleEngineSubmitStrategy actualBurstTbRuleEngineSubmitStrategy = new BurstTbRuleEngineSubmitStrategy(
        "Queue Name");
    actualBurstTbRuleEngineSubmitStrategy.doOnSuccess(UUID.randomUUID());

    // Assert that nothing has changed
    assertEquals("Queue Name", actualBurstTbRuleEngineSubmitStrategy.queueName);
  }

  /**
   * Test {@link BurstTbRuleEngineSubmitStrategy#submitAttempt(BiConsumer)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then calls {@link BiConsumer#accept(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BurstTbRuleEngineSubmitStrategy#submitAttempt(BiConsumer)}
   */
  @Test
  @DisplayName("Test submitAttempt(BiConsumer); given ArrayList() add 'null'; then calls accept(Object, Object)")
  void testSubmitAttempt_givenArrayListAddNull_thenCallsAccept() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgs = new ArrayList<>();
    msgs.add(null);

    BurstTbRuleEngineSubmitStrategy burstTbRuleEngineSubmitStrategy = new BurstTbRuleEngineSubmitStrategy("Queue Name");
    burstTbRuleEngineSubmitStrategy.init(msgs);
    BiConsumer<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgConsumer = mock(BiConsumer.class);
    doNothing().when(msgConsumer)
        .accept(Mockito.<UUID>any(), Mockito.<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>>any());

    // Act
    burstTbRuleEngineSubmitStrategy.submitAttempt(msgConsumer);

    // Assert that nothing has changed
    verify(msgConsumer).accept(isA(UUID.class), isNull());
  }

  /**
   * Test {@link BurstTbRuleEngineSubmitStrategy#submitAttempt(BiConsumer)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then calls {@link BiConsumer#accept(Object, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BurstTbRuleEngineSubmitStrategy#submitAttempt(BiConsumer)}
   */
  @Test
  @DisplayName("Test submitAttempt(BiConsumer); given ArrayList() add 'null'; then calls accept(Object, Object)")
  void testSubmitAttempt_givenArrayListAddNull_thenCallsAccept2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgs = new ArrayList<>();
    msgs.add(null);
    msgs.add(null);

    BurstTbRuleEngineSubmitStrategy burstTbRuleEngineSubmitStrategy = new BurstTbRuleEngineSubmitStrategy("Queue Name");
    burstTbRuleEngineSubmitStrategy.init(msgs);
    BiConsumer<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgConsumer = mock(BiConsumer.class);
    doNothing().when(msgConsumer)
        .accept(Mockito.<UUID>any(), Mockito.<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>>any());

    // Act
    burstTbRuleEngineSubmitStrategy.submitAttempt(msgConsumer);

    // Assert that nothing has changed
    verify(msgConsumer, atLeast(1)).accept(Mockito.<UUID>any(), isNull());
  }
}
