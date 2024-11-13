package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
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
import org.thingsboard.server.queue.common.TbProtoJsQueueMsg;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;

@ContextConfiguration(classes = {BurstTbRuleEngineSubmitStrategy.class, String.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class AbstractTbRuleEngineSubmitStrategyDiffblueTest {
  @Autowired
  private AbstractTbRuleEngineSubmitStrategy abstractTbRuleEngineSubmitStrategy;

  /**
   * Test {@link AbstractTbRuleEngineSubmitStrategy#init(List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then {@link AbstractTbRuleEngineSubmitStrategy}
   * {@link AbstractTbRuleEngineSubmitStrategy#orderedMsgList} size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbRuleEngineSubmitStrategy#init(List)}
   */
  @Test
  @DisplayName("Test init(List); given 'null'; then AbstractTbRuleEngineSubmitStrategy orderedMsgList size is two")
  void testInit_givenNull_thenAbstractTbRuleEngineSubmitStrategyOrderedMsgListSizeIsTwo() {
    // Arrange
    ArrayList<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgs = new ArrayList<>();
    msgs.add(null);
    msgs.add(null);

    // Act
    abstractTbRuleEngineSubmitStrategy.init(msgs);

    // Assert
    assertTrue(abstractTbRuleEngineSubmitStrategy instanceof BurstTbRuleEngineSubmitStrategy);
    List<IdMsgPair<TransportProtos.ToRuleEngineMsg>> idMsgPairList = ((BurstTbRuleEngineSubmitStrategy) abstractTbRuleEngineSubmitStrategy).orderedMsgList;
    assertEquals(2, idMsgPairList.size());
    assertNull(idMsgPairList.get(1).getMsg());
  }

  /**
   * Test {@link AbstractTbRuleEngineSubmitStrategy#init(List)}.
   * <ul>
   *   <li>Then {@link AbstractTbRuleEngineSubmitStrategy}
   * {@link AbstractTbRuleEngineSubmitStrategy#orderedMsgList} first Msg is
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbRuleEngineSubmitStrategy#init(List)}
   */
  @Test
  @DisplayName("Test init(List); then AbstractTbRuleEngineSubmitStrategy orderedMsgList first Msg is 'null'")
  void testInit_thenAbstractTbRuleEngineSubmitStrategyOrderedMsgListFirstMsgIsNull() {
    // Arrange
    ArrayList<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgs = new ArrayList<>();
    msgs.add(null);

    // Act
    abstractTbRuleEngineSubmitStrategy.init(msgs);

    // Assert
    assertTrue(abstractTbRuleEngineSubmitStrategy instanceof BurstTbRuleEngineSubmitStrategy);
    List<IdMsgPair<TransportProtos.ToRuleEngineMsg>> idMsgPairList = ((BurstTbRuleEngineSubmitStrategy) abstractTbRuleEngineSubmitStrategy).orderedMsgList;
    assertEquals(1, idMsgPairList.size());
    assertNull(idMsgPairList.get(0).getMsg());
    assertEquals(1, msgs.size());
  }

  /**
   * Test {@link AbstractTbRuleEngineSubmitStrategy#init(List)}.
   * <ul>
   *   <li>Then {@link AbstractTbRuleEngineSubmitStrategy} PendingMap size is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbRuleEngineSubmitStrategy#init(List)}
   */
  @Test
  @DisplayName("Test init(List); then AbstractTbRuleEngineSubmitStrategy PendingMap size is one")
  void testInit_thenAbstractTbRuleEngineSubmitStrategyPendingMapSizeIsOne() {
    // Arrange
    ArrayList<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgs = new ArrayList<>();
    msgs.add(mock(TbProtoJsQueueMsg.class));

    // Act
    abstractTbRuleEngineSubmitStrategy.init(msgs);

    // Assert
    assertTrue(abstractTbRuleEngineSubmitStrategy instanceof BurstTbRuleEngineSubmitStrategy);
    assertEquals(1, ((BurstTbRuleEngineSubmitStrategy) abstractTbRuleEngineSubmitStrategy).orderedMsgList.size());
    assertEquals(1, abstractTbRuleEngineSubmitStrategy.getPendingMap().size());
  }

  /**
   * Test {@link AbstractTbRuleEngineSubmitStrategy#init(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then {@link ArrayList#ArrayList()} Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbRuleEngineSubmitStrategy#init(List)}
   */
  @Test
  @DisplayName("Test init(List); when ArrayList(); then ArrayList() Empty")
  void testInit_whenArrayList_thenArrayListEmpty() {
    // Arrange
    ArrayList<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgs = new ArrayList<>();

    // Act
    abstractTbRuleEngineSubmitStrategy.init(msgs);

    // Assert
    assertTrue(abstractTbRuleEngineSubmitStrategy instanceof BurstTbRuleEngineSubmitStrategy);
    assertTrue(msgs.isEmpty());
    assertTrue(((BurstTbRuleEngineSubmitStrategy) abstractTbRuleEngineSubmitStrategy).orderedMsgList.isEmpty());
    assertTrue(abstractTbRuleEngineSubmitStrategy.getPendingMap().isEmpty());
  }

  /**
   * Test {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link TbProtoJsQueueMsg}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}
   */
  @Test
  @DisplayName("Test getPendingMap(); given ArrayList() add TbProtoJsQueueMsg; then return size is one")
  void testGetPendingMap_givenArrayListAddTbProtoJsQueueMsg_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> msgs = new ArrayList<>();
    msgs.add(mock(TbProtoJsQueueMsg.class));

    BurstTbRuleEngineSubmitStrategy burstTbRuleEngineSubmitStrategy = new BurstTbRuleEngineSubmitStrategy("Queue Name");
    burstTbRuleEngineSubmitStrategy.init(msgs);

    // Act and Assert
    assertEquals(1, burstTbRuleEngineSubmitStrategy.getPendingMap().size());
  }

  /**
   * Test {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}
   */
  @Test
  @DisplayName("Test getPendingMap(); then return Empty")
  void testGetPendingMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BurstTbRuleEngineSubmitStrategy burstTbRuleEngineSubmitStrategy = new BurstTbRuleEngineSubmitStrategy("Queue Name");
    burstTbRuleEngineSubmitStrategy.init(new ArrayList<>());

    // Act and Assert
    assertTrue(burstTbRuleEngineSubmitStrategy.getPendingMap().isEmpty());
  }
}
