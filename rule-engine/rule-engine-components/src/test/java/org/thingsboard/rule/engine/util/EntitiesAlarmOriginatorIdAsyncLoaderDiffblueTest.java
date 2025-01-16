package org.thingsboard.rule.engine.util;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.RuleEngineAlarmService;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntitiesAlarmOriginatorIdAsyncLoaderDiffblueTest {
  /**
   * Test
   * {@link EntitiesAlarmOriginatorIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesAlarmOriginatorIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findEntityIdAsync(TbContext, EntityId); then calls addListener(Runnable, Executor)")
  void testFindEntityIdAsync_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Alarm> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmByIdAsync(Mockito.<TenantId>any(), Mockito.<AlarmId>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    EntitiesAlarmOriginatorIdAsyncLoader.findEntityIdAsync(ctx, new AlarmId(UUID.randomUUID()));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(ruleEngineAlarmService).findAlarmByIdAsync(isA(TenantId.class), isA(AlarmId.class));
    verify(ctx).getAlarmService();
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getTenantId();
  }
}
