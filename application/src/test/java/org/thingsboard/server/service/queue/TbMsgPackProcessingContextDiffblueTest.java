package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.RuleNodeInfo;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.common.TbProtoQueueMsg;
import org.thingsboard.server.service.queue.processing.AbstractTbRuleEngineSubmitStrategy;
import org.thingsboard.server.service.queue.processing.BatchTbRuleEngineSubmitStrategy;
import org.thingsboard.server.service.queue.processing.TbRuleEngineSubmitStrategy;

class TbMsgPackProcessingContextDiffblueTest {
  /**
   * Test
   * {@link TbMsgPackProcessingContext#TbMsgPackProcessingContext(String, TbRuleEngineSubmitStrategy, boolean)}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()}.</li>
   *   <li>Then return not Canceled.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPackProcessingContext#TbMsgPackProcessingContext(String, TbRuleEngineSubmitStrategy, boolean)}
   */
  @Test
  @DisplayName("Test new TbMsgPackProcessingContext(String, TbRuleEngineSubmitStrategy, boolean); given ConcurrentHashMap(); then return not Canceled")
  void testNewTbMsgPackProcessingContext_givenConcurrentHashMap_thenReturnNotCanceled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    ConcurrentHashMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> uuidTbProtoQueueMsgMap = new ConcurrentHashMap<>();
    when(submitStrategy.getPendingMap()).thenReturn(uuidTbProtoQueueMsgMap);

    // Act
    TbMsgPackProcessingContext actualTbMsgPackProcessingContext = new TbMsgPackProcessingContext("Queue Name",
        submitStrategy, true);

    // Assert
    verify(submitStrategy).getPendingMap();
    assertFalse(actualTbMsgPackProcessingContext.isCanceled());
    assertFalse(actualTbMsgPackProcessingContext.isProfilerEnabled());
    assertTrue(actualTbMsgPackProcessingContext.getExceptionsMap().isEmpty());
    assertTrue(actualTbMsgPackProcessingContext.getFailedMap().isEmpty());
    ConcurrentMap<UUID, TbProtoQueueMsg<TransportProtos.ToRuleEngineMsg>> pendingMap = actualTbMsgPackProcessingContext
        .getPendingMap();
    assertTrue(pendingMap.isEmpty());
    assertSame(uuidTbProtoQueueMsgMap, pendingMap);
  }

  /**
   * Test {@link TbMsgPackProcessingContext#await(long, TimeUnit)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackProcessingContext#await(long, TimeUnit)}
   */
  @Test
  @DisplayName("Test await(long, TimeUnit); then return 'false'")
  void testAwait_thenReturnFalse() throws InterruptedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());

    // Act
    boolean actualAwaitResult = (new TbMsgPackProcessingContext("Queue Name", submitStrategy, true)).await(1L,
        TimeUnit.NANOSECONDS);

    // Assert
    verify(submitStrategy).getPendingMap();
    assertFalse(actualAwaitResult);
  }

  /**
   * Test {@link TbMsgPackProcessingContext#onSuccess(UUID)}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackProcessingContext#onSuccess(UUID)}
   */
  @Test
  @DisplayName("Test onSuccess(UUID); then calls getPendingMap()")
  void testOnSuccess_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext tbMsgPackProcessingContext = new TbMsgPackProcessingContext("Queue Name", submitStrategy,
        true);

    // Act
    tbMsgPackProcessingContext.onSuccess(UUID.randomUUID());

    // Assert
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test
   * {@link TbMsgPackProcessingContext#onFailure(TenantId, UUID, RuleEngineException)}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPackProcessingContext#onFailure(TenantId, UUID, RuleEngineException)}
   */
  @Test
  @DisplayName("Test onFailure(TenantId, UUID, RuleEngineException); then calls getPendingMap()")
  void testOnFailure_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext tbMsgPackProcessingContext = new TbMsgPackProcessingContext("Queue Name", submitStrategy,
        true);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UUID id = UUID.randomUUID();

    // Act
    tbMsgPackProcessingContext.onFailure(tenantId, id, new RuleEngineException("An error occurred"));

    // Assert
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test
   * {@link TbMsgPackProcessingContext#onProcessingStart(UUID, RuleNodeInfo)}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPackProcessingContext#onProcessingStart(UUID, RuleNodeInfo)}
   */
  @Test
  @DisplayName("Test onProcessingStart(UUID, RuleNodeInfo); then calls getPendingMap()")
  void testOnProcessingStart_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext tbMsgPackProcessingContext = new TbMsgPackProcessingContext("Queue Name", submitStrategy,
        true);
    UUID id = UUID.randomUUID();

    // Act
    tbMsgPackProcessingContext.onProcessingStart(id,
        new RuleNodeInfo(new RuleNodeId(UUID.randomUUID()), "Rule Chain Name", "Rule Node Name"));

    // Assert
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackProcessingContext#onProcessingEnd(UUID, RuleNodeId)}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPackProcessingContext#onProcessingEnd(UUID, RuleNodeId)}
   */
  @Test
  @DisplayName("Test onProcessingEnd(UUID, RuleNodeId); then calls getPendingMap()")
  void testOnProcessingEnd_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext tbMsgPackProcessingContext = new TbMsgPackProcessingContext("Queue Name", submitStrategy,
        true);
    UUID id = UUID.randomUUID();

    // Act
    tbMsgPackProcessingContext.onProcessingEnd(id, new RuleNodeId(UUID.randomUUID()));

    // Assert that nothing has changed
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackProcessingContext#onTimeout(TbMsgProfilerInfo)}.
   * <ul>
   *   <li>Given {@link SimpleEntry#SimpleEntry(Object, Object)} with randomUUID and
   * minus one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPackProcessingContext#onTimeout(TbMsgProfilerInfo)}
   */
  @Test
  @DisplayName("Test onTimeout(TbMsgProfilerInfo); given SimpleEntry(Object, Object) with randomUUID and minus one")
  void testOnTimeout_givenSimpleEntryWithRandomUUIDAndMinusOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext tbMsgPackProcessingContext = new TbMsgPackProcessingContext("Queue Name", submitStrategy,
        true);
    TbMsgProfilerInfo profilerInfo = mock(TbMsgProfilerInfo.class);
    when(profilerInfo.onTimeout()).thenReturn(new AbstractMap.SimpleEntry<>(UUID.randomUUID(), -1L));

    // Act
    tbMsgPackProcessingContext.onTimeout(profilerInfo);

    // Assert
    verify(profilerInfo).onTimeout();
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackProcessingContext#onTimeout(TbMsgProfilerInfo)}.
   * <ul>
   *   <li>Given {@link SimpleEntry#SimpleEntry(Object, Object)} with randomUUID and
   * one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPackProcessingContext#onTimeout(TbMsgProfilerInfo)}
   */
  @Test
  @DisplayName("Test onTimeout(TbMsgProfilerInfo); given SimpleEntry(Object, Object) with randomUUID and one")
  void testOnTimeout_givenSimpleEntryWithRandomUUIDAndOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext tbMsgPackProcessingContext = new TbMsgPackProcessingContext("Queue Name", submitStrategy,
        true);
    TbMsgProfilerInfo profilerInfo = mock(TbMsgProfilerInfo.class);
    when(profilerInfo.onTimeout()).thenReturn(new AbstractMap.SimpleEntry<>(UUID.randomUUID(), 1L));

    // Act
    tbMsgPackProcessingContext.onTimeout(profilerInfo);

    // Assert
    verify(profilerInfo).onTimeout();
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackProcessingContext#onTimeout(TbMsgProfilerInfo)}.
   * <ul>
   *   <li>When {@link TbMsgProfilerInfo#TbMsgProfilerInfo(UUID)} with msgId is
   * randomUUID.</li>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPackProcessingContext#onTimeout(TbMsgProfilerInfo)}
   */
  @Test
  @DisplayName("Test onTimeout(TbMsgProfilerInfo); when TbMsgProfilerInfo(UUID) with msgId is randomUUID; then calls getPendingMap()")
  void testOnTimeout_whenTbMsgProfilerInfoWithMsgIdIsRandomUUID_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext tbMsgPackProcessingContext = new TbMsgPackProcessingContext("Queue Name", submitStrategy,
        true);

    // Act
    tbMsgPackProcessingContext.onTimeout(new TbMsgProfilerInfo(UUID.randomUUID()));

    // Assert that nothing has changed
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackProcessingContext#getLastVisitedRuleNode(UUID)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPackProcessingContext#getLastVisitedRuleNode(UUID)}
   */
  @Test
  @DisplayName("Test getLastVisitedRuleNode(UUID); then return 'null'")
  void testGetLastVisitedRuleNode_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext tbMsgPackProcessingContext = new TbMsgPackProcessingContext("Queue Name", submitStrategy,
        true);

    // Act
    RuleNodeInfo actualLastVisitedRuleNode = tbMsgPackProcessingContext.getLastVisitedRuleNode(UUID.randomUUID());

    // Assert
    verify(submitStrategy).getPendingMap();
    assertNull(actualLastVisitedRuleNode);
  }

  /**
   * Test {@link TbMsgPackProcessingContext#printProfilerStats()}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackProcessingContext#printProfilerStats()}
   */
  @Test
  @DisplayName("Test printProfilerStats(); then calls getPendingMap()")
  void testPrintProfilerStats_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());

    // Act
    (new TbMsgPackProcessingContext("Queue Name", submitStrategy, true)).printProfilerStats();

    // Assert that nothing has changed
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackProcessingContext#cleanup()}.
   * <p>
   * Method under test: {@link TbMsgPackProcessingContext#cleanup()}
   */
  @Test
  @DisplayName("Test cleanup()")
  void testCleanup() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext tbMsgPackProcessingContext = new TbMsgPackProcessingContext("Queue Name", submitStrategy,
        true);

    // Act
    tbMsgPackProcessingContext.cleanup();

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(tbMsgPackProcessingContext.isCanceled());
  }

  /**
   * Test {@link TbMsgPackProcessingContext#isCanceled()}.
   * <p>
   * Method under test: {@link TbMsgPackProcessingContext#isCanceled()}
   */
  @Test
  @DisplayName("Test isCanceled()")
  void testIsCanceled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());

    // Act
    boolean actualIsCanceledResult = (new TbMsgPackProcessingContext("Queue Name", submitStrategy, true)).isCanceled();

    // Assert
    verify(submitStrategy).getPendingMap();
    assertFalse(actualIsCanceledResult);
  }

  /**
   * Test {@link TbMsgPackProcessingContext#isCanceled()}.
   * <p>
   * Method under test: {@link TbMsgPackProcessingContext#isCanceled()}
   */
  @Test
  @DisplayName("Test isCanceled()")
  void testIsCanceled2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());

    // Act
    boolean actualIsCanceledResult = (new TbMsgPackProcessingContext("Queue Name", submitStrategy, false)).isCanceled();

    // Assert
    verify(submitStrategy).getPendingMap();
    assertFalse(actualIsCanceledResult);
  }
}
