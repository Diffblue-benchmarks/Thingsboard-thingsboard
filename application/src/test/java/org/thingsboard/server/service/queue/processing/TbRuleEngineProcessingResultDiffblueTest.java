package org.thingsboard.server.service.queue.processing;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.service.queue.TbMsgPackProcessingContext;

class TbRuleEngineProcessingResultDiffblueTest {
  /**
   * Test
   * {@link TbRuleEngineProcessingResult#TbRuleEngineProcessingResult(String, boolean, TbMsgPackProcessingContext)}.
   * <ul>
   *   <li>Then return Success.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingResult#TbRuleEngineProcessingResult(String, boolean, TbMsgPackProcessingContext)}
   */
  @Test
  @DisplayName("Test new TbRuleEngineProcessingResult(String, boolean, TbMsgPackProcessingContext); then return Success")
  void testNewTbRuleEngineProcessingResult_thenReturnSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());

    // Act
    TbRuleEngineProcessingResult actualTbRuleEngineProcessingResult = new TbRuleEngineProcessingResult("Queue Name",
        false, new TbMsgPackProcessingContext("Queue Name", submitStrategy, true));

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(actualTbRuleEngineProcessingResult.isSuccess());
    ConcurrentMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> expectedSuccessMap = actualTbRuleEngineProcessingResult
        .getSuccessMap();
    assertSame(expectedSuccessMap, actualTbRuleEngineProcessingResult.getCtx().getSuccessMap());
  }

  /**
   * Test
   * {@link TbRuleEngineProcessingResult#TbRuleEngineProcessingResult(String, boolean, TbMsgPackProcessingContext)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Timeout.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRuleEngineProcessingResult#TbRuleEngineProcessingResult(String, boolean, TbMsgPackProcessingContext)}
   */
  @Test
  @DisplayName("Test new TbRuleEngineProcessingResult(String, boolean, TbMsgPackProcessingContext); when 'true'; then return Timeout")
  void testNewTbRuleEngineProcessingResult_whenTrue_thenReturnTimeout() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());

    // Act
    TbRuleEngineProcessingResult actualTbRuleEngineProcessingResult = new TbRuleEngineProcessingResult("Queue Name",
        true, new TbMsgPackProcessingContext("Queue Name", submitStrategy, true));

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(actualTbRuleEngineProcessingResult.isTimeout());
    ConcurrentMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> expectedSuccessMap = actualTbRuleEngineProcessingResult
        .getSuccessMap();
    assertSame(expectedSuccessMap, actualTbRuleEngineProcessingResult.getCtx().getSuccessMap());
  }

  /**
   * Test {@link TbRuleEngineProcessingResult#getPendingMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingResult#getPendingMap()}
   */
  @Test
  @DisplayName("Test getPendingMap(); then return Empty")
  void testGetPendingMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    ConcurrentHashMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> uuidTbProtoQueueMsgMap = new ConcurrentHashMap<>();
    when(submitStrategy.getPendingMap()).thenReturn(uuidTbProtoQueueMsgMap);

    // Act
    ConcurrentMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualPendingMap = (new TbRuleEngineProcessingResult(
        "Queue Name", true, new TbMsgPackProcessingContext("Queue Name", submitStrategy, true))).getPendingMap();

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(actualPendingMap.isEmpty());
    assertSame(uuidTbProtoQueueMsgMap, actualPendingMap);
  }

  /**
   * Test {@link TbRuleEngineProcessingResult#getSuccessMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingResult#getSuccessMap()}
   */
  @Test
  @DisplayName("Test getSuccessMap(); then return Empty")
  void testGetSuccessMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());

    // Act
    ConcurrentMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualSuccessMap = (new TbRuleEngineProcessingResult(
        "Queue Name", true, new TbMsgPackProcessingContext("Queue Name", submitStrategy, true))).getSuccessMap();

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(actualSuccessMap.isEmpty());
  }

  /**
   * Test {@link TbRuleEngineProcessingResult#getFailedMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingResult#getFailedMap()}
   */
  @Test
  @DisplayName("Test getFailedMap(); then return Empty")
  void testGetFailedMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());

    // Act
    ConcurrentMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> actualFailedMap = (new TbRuleEngineProcessingResult(
        "Queue Name", true, new TbMsgPackProcessingContext("Queue Name", submitStrategy, true))).getFailedMap();

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(actualFailedMap.isEmpty());
  }

  /**
   * Test {@link TbRuleEngineProcessingResult#getExceptionsMap()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRuleEngineProcessingResult#getExceptionsMap()}
   */
  @Test
  @DisplayName("Test getExceptionsMap(); then return Empty")
  void testGetExceptionsMap_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());

    // Act
    ConcurrentMap<TenantId, RuleEngineException> actualExceptionsMap = (new TbRuleEngineProcessingResult("Queue Name",
        true, new TbMsgPackProcessingContext("Queue Name", submitStrategy, true))).getExceptionsMap();

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(actualExceptionsMap.isEmpty());
  }
}
