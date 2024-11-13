package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.Timer;
import io.micrometer.core.instrument.noop.NoopTimer;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.RuleEngineException;
import org.thingsboard.server.common.msg.queue.RuleNodeInfo;
import org.thingsboard.server.service.queue.processing.AbstractTbRuleEngineSubmitStrategy;
import org.thingsboard.server.service.queue.processing.BatchTbRuleEngineSubmitStrategy;

@DisabledInAotMode
class TbMsgPackCallbackDiffblueTest {
  @MockBean
  private TbMsgPackCallback tbMsgPackCallback;

  /**
   * Test
   * {@link TbMsgPackCallback#TbMsgPackCallback(UUID, TenantId, TbMsgPackProcessingContext)}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()}.</li>
   *   <li>Then return MsgValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPackCallback#TbMsgPackCallback(UUID, TenantId, TbMsgPackProcessingContext)}
   */
  @Test
  @DisplayName("Test new TbMsgPackCallback(UUID, TenantId, TbMsgPackProcessingContext); given ConcurrentHashMap(); then return MsgValid")
  void testNewTbMsgPackCallback_givenConcurrentHashMap_thenReturnMsgValid() {
    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());

    // Act
    TbMsgPackCallback actualTbMsgPackCallback = new TbMsgPackCallback(id, tenantId,
        new TbMsgPackProcessingContext("Queue Name", submitStrategy, true));

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(actualTbMsgPackCallback.isMsgValid());
  }

  /**
   * Test
   * {@link TbMsgPackCallback#TbMsgPackCallback(UUID, TenantId, TbMsgPackProcessingContext, Timer, Timer)}.
   * <ul>
   *   <li>Given {@link ConcurrentHashMap#ConcurrentHashMap()}.</li>
   *   <li>Then return MsgValid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgPackCallback#TbMsgPackCallback(UUID, TenantId, TbMsgPackProcessingContext, Timer, Timer)}
   */
  @Test
  @DisplayName("Test new TbMsgPackCallback(UUID, TenantId, TbMsgPackProcessingContext, Timer, Timer); given ConcurrentHashMap(); then return MsgValid")
  void testNewTbMsgPackCallback_givenConcurrentHashMap_thenReturnMsgValid2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UUID id = UUID.randomUUID();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    NoopTimer successfulMsgTimer = new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit",
        "The characteristics of someone or something", Meter.Type.COUNTER));

    // Act
    TbMsgPackCallback actualTbMsgPackCallback = new TbMsgPackCallback(id, tenantId, ctx, successfulMsgTimer,
        new NoopTimer(new Meter.Id("Name", Tags.empty(), "Base Unit", "The characteristics of someone or something",
            Meter.Type.COUNTER)));

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(actualTbMsgPackCallback.isMsgValid());
  }

  /**
   * Test {@link TbMsgPackCallback#onSuccess()}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#onSuccess()}
   */
  @Test
  @DisplayName("Test onSuccess(); then calls getPendingMap()")
  void testOnSuccess_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();

    // Act
    (new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx)).onSuccess();

    // Assert
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackCallback#onSuccess()}.
   * <ul>
   *   <li>Then calls {@link TbMsgPackProcessingContext#onSuccess(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#onSuccess()}
   */
  @Test
  @DisplayName("Test onSuccess(); then calls onSuccess(UUID)")
  void testOnSuccess_thenCallsOnSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbMsgPackProcessingContext ctx = mock(TbMsgPackProcessingContext.class);
    doNothing().when(ctx).onSuccess(Mockito.<UUID>any());
    UUID id = UUID.randomUUID();

    // Act
    (new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx)).onSuccess();

    // Assert that nothing has changed
    verify(ctx).onSuccess(isA(UUID.class));
  }

  /**
   * Test {@link TbMsgPackCallback#onRateLimit(RuleEngineException)}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#onRateLimit(RuleEngineException)}
   */
  @Test
  @DisplayName("Test onRateLimit(RuleEngineException); then calls getPendingMap()")
  void testOnRateLimit_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();
    TbMsgPackCallback tbMsgPackCallback = new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx);

    // Act
    tbMsgPackCallback.onRateLimit(new RuleEngineException("An error occurred"));

    // Assert
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackCallback#onRateLimit(RuleEngineException)}.
   * <ul>
   *   <li>Then calls {@link TbMsgPackProcessingContext#onSuccess(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#onRateLimit(RuleEngineException)}
   */
  @Test
  @DisplayName("Test onRateLimit(RuleEngineException); then calls onSuccess(UUID)")
  void testOnRateLimit_thenCallsOnSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbMsgPackProcessingContext ctx = mock(TbMsgPackProcessingContext.class);
    doNothing().when(ctx).onSuccess(Mockito.<UUID>any());
    UUID id = UUID.randomUUID();
    TbMsgPackCallback tbMsgPackCallback = new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx);

    // Act
    tbMsgPackCallback.onRateLimit(new RuleEngineException("An error occurred"));

    // Assert that nothing has changed
    verify(ctx).onSuccess(isA(UUID.class));
  }

  /**
   * Test {@link TbMsgPackCallback#onFailure(RuleEngineException)}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#onFailure(RuleEngineException)}
   */
  @Test
  @DisplayName("Test onFailure(RuleEngineException); then calls getPendingMap()")
  void testOnFailure_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();
    TbMsgPackCallback tbMsgPackCallback = new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx);

    // Act
    tbMsgPackCallback.onFailure(new RuleEngineException("An error occurred"));

    // Assert
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackCallback#onFailure(RuleEngineException)}.
   * <ul>
   *   <li>Then calls
   * {@link TbMsgPackProcessingContext#onFailure(TenantId, UUID, RuleEngineException)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#onFailure(RuleEngineException)}
   */
  @Test
  @DisplayName("Test onFailure(RuleEngineException); then calls onFailure(TenantId, UUID, RuleEngineException)")
  void testOnFailure_thenCallsOnFailure() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbMsgPackProcessingContext ctx = mock(TbMsgPackProcessingContext.class);
    doNothing().when(ctx).onFailure(Mockito.<TenantId>any(), Mockito.<UUID>any(), Mockito.<RuleEngineException>any());
    UUID id = UUID.randomUUID();
    TbMsgPackCallback tbMsgPackCallback = new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx);

    // Act
    tbMsgPackCallback.onFailure(new RuleEngineException("An error occurred"));

    // Assert
    verify(ctx).onFailure(isA(TenantId.class), isA(UUID.class), isA(RuleEngineException.class));
  }

  /**
   * Test {@link TbMsgPackCallback#isMsgValid()}.
   * <p>
   * Method under test: {@link TbMsgPackCallback#isMsgValid()}
   */
  @Test
  @DisplayName("Test isMsgValid()")
  void testIsMsgValid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();

    // Act
    boolean actualIsMsgValidResult = (new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx)).isMsgValid();

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(actualIsMsgValidResult);
  }

  /**
   * Test {@link TbMsgPackCallback#isMsgValid()}.
   * <p>
   * Method under test: {@link TbMsgPackCallback#isMsgValid()}
   */
  @Test
  @DisplayName("Test isMsgValid()")
  void testIsMsgValid2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, false);

    UUID id = UUID.randomUUID();

    // Act
    boolean actualIsMsgValidResult = (new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx)).isMsgValid();

    // Assert
    verify(submitStrategy).getPendingMap();
    assertTrue(actualIsMsgValidResult);
  }

  /**
   * Test {@link TbMsgPackCallback#isMsgValid()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#isMsgValid()}
   */
  @Test
  @DisplayName("Test isMsgValid(); then return 'false'")
  void testIsMsgValid_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbMsgPackProcessingContext ctx = mock(TbMsgPackProcessingContext.class);
    when(ctx.isCanceled()).thenReturn(true);
    UUID id = UUID.randomUUID();

    // Act
    boolean actualIsMsgValidResult = (new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx)).isMsgValid();

    // Assert
    verify(ctx).isCanceled();
    assertFalse(actualIsMsgValidResult);
  }

  /**
   * Test {@link TbMsgPackCallback#onProcessingStart(RuleNodeInfo)}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#onProcessingStart(RuleNodeInfo)}
   */
  @Test
  @DisplayName("Test onProcessingStart(RuleNodeInfo); then calls getPendingMap()")
  void testOnProcessingStart_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();
    TbMsgPackCallback tbMsgPackCallback = new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx);

    // Act
    tbMsgPackCallback
        .onProcessingStart(new RuleNodeInfo(new RuleNodeId(UUID.randomUUID()), "Rule Chain Name", "Rule Node Name"));

    // Assert
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackCallback#onProcessingStart(RuleNodeInfo)}.
   * <ul>
   *   <li>Then calls
   * {@link TbMsgPackProcessingContext#onProcessingStart(UUID, RuleNodeInfo)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#onProcessingStart(RuleNodeInfo)}
   */
  @Test
  @DisplayName("Test onProcessingStart(RuleNodeInfo); then calls onProcessingStart(UUID, RuleNodeInfo)")
  void testOnProcessingStart_thenCallsOnProcessingStart() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbMsgPackProcessingContext ctx = mock(TbMsgPackProcessingContext.class);
    doNothing().when(ctx).onProcessingStart(Mockito.<UUID>any(), Mockito.<RuleNodeInfo>any());
    UUID id = UUID.randomUUID();
    TbMsgPackCallback tbMsgPackCallback = new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx);

    // Act
    tbMsgPackCallback
        .onProcessingStart(new RuleNodeInfo(new RuleNodeId(UUID.randomUUID()), "Rule Chain Name", "Rule Node Name"));

    // Assert that nothing has changed
    verify(ctx).onProcessingStart(isA(UUID.class), isA(RuleNodeInfo.class));
  }

  /**
   * Test {@link TbMsgPackCallback#onProcessingEnd(RuleNodeId)}.
   * <ul>
   *   <li>Then calls
   * {@link AbstractTbRuleEngineSubmitStrategy#getPendingMap()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#onProcessingEnd(RuleNodeId)}
   */
  @Test
  @DisplayName("Test onProcessingEnd(RuleNodeId); then calls getPendingMap()")
  void testOnProcessingEnd_thenCallsGetPendingMap() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BatchTbRuleEngineSubmitStrategy submitStrategy = mock(BatchTbRuleEngineSubmitStrategy.class);
    when(submitStrategy.getPendingMap()).thenReturn(new ConcurrentHashMap<>());
    TbMsgPackProcessingContext ctx = new TbMsgPackProcessingContext("Queue Name", submitStrategy, true);

    UUID id = UUID.randomUUID();
    TbMsgPackCallback tbMsgPackCallback = new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx);

    // Act
    tbMsgPackCallback.onProcessingEnd(new RuleNodeId(UUID.randomUUID()));

    // Assert that nothing has changed
    verify(submitStrategy).getPendingMap();
  }

  /**
   * Test {@link TbMsgPackCallback#onProcessingEnd(RuleNodeId)}.
   * <ul>
   *   <li>Then calls
   * {@link TbMsgPackProcessingContext#onProcessingEnd(UUID, RuleNodeId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbMsgPackCallback#onProcessingEnd(RuleNodeId)}
   */
  @Test
  @DisplayName("Test onProcessingEnd(RuleNodeId); then calls onProcessingEnd(UUID, RuleNodeId)")
  void testOnProcessingEnd_thenCallsOnProcessingEnd() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbMsgPackProcessingContext ctx = mock(TbMsgPackProcessingContext.class);
    doNothing().when(ctx).onProcessingEnd(Mockito.<UUID>any(), Mockito.<RuleNodeId>any());
    UUID id = UUID.randomUUID();
    TbMsgPackCallback tbMsgPackCallback = new TbMsgPackCallback(id, new TenantId(UUID.randomUUID()), ctx);

    // Act
    tbMsgPackCallback.onProcessingEnd(new RuleNodeId(UUID.randomUUID()));

    // Assert that nothing has changed
    verify(ctx).onProcessingEnd(isA(UUID.class), isA(RuleNodeId.class));
  }
}
