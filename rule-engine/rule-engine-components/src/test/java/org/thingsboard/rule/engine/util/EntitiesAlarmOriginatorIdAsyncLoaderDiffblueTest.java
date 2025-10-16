/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.rule.engine.util;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
   * Test {@link EntitiesAlarmOriginatorIdAsyncLoader#findEntityIdAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesAlarmOriginatorIdAsyncLoader#findEntityIdAsync(TbContext,
   * EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntityIdAsync(TbContext, EntityId); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EntitiesAlarmOriginatorIdAsyncLoader.findEntityIdAsync(TbContext, EntityId)"
  })
  void testFindEntityIdAsync_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Alarm> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Alarm> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Alarm> apiFuture = new ForwardingApiFuture<>(delegate2);

    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmByIdAsync(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

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
