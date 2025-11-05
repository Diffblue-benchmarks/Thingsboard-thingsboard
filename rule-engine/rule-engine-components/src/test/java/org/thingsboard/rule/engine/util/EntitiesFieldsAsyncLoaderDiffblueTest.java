package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.api.RuleEngineAlarmService;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.EntityFieldsData;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntitiesFieldsAsyncLoaderDiffblueTest {
  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   *
   * <p>Method under test: {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findAsync(TbContext, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EntitiesFieldsAsyncLoader.findAsync(TbContext, EntityId)"})
  void testFindAsync() {
    // Arrange
    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmByIdAsync(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenThrow(new NoSuchElementException());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () ->
            EntitiesFieldsAsyncLoader.findAsync(
                ctx, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ruleEngineAlarmService).findAlarmByIdAsync(isA(TenantId.class), isA(AlarmId.class));
    verify(ctx).getAlarmService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} throw {@link NoSuchElementException#NoSuchElementException()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findAsync(TbContext, EntityId); given ListenableFutureTask addListener(Runnable, Executor) throw NoSuchElementException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EntitiesFieldsAsyncLoader.findAsync(TbContext, EntityId)"})
  void testFindAsync_givenListenableFutureTaskAddListenerThrowNoSuchElementException() {
    // Arrange
    ListenableFutureTask<Alarm> delegate = mock(ListenableFutureTask.class);
    doThrow(new NoSuchElementException())
        .when(delegate)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Alarm> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Alarm> apiFuture = new ForwardingApiFuture<>(delegate2);

    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmByIdAsync(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () ->
            EntitiesFieldsAsyncLoader.findAsync(
                ctx, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(ruleEngineAlarmService).findAlarmByIdAsync(isA(TenantId.class), isA(AlarmId.class));
    verify(ctx).getAlarmService();
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findAsync(TbContext, EntityId); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EntitiesFieldsAsyncLoader.findAsync(TbContext, EntityId)"})
  void testFindAsync_thenCallsAddListener() {
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
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    EntitiesFieldsAsyncLoader.findAsync(
        ctx, new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(ruleEngineAlarmService).findAlarmByIdAsync(isA(TenantId.class), isA(AlarmId.class));
    verify(ctx).getAlarmService();
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getDeviceService()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findAsync(TbContext, EntityId); then calls getDeviceService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EntitiesFieldsAsyncLoader.findAsync(TbContext, EntityId)"})
  void testFindAsync_thenCallsGetDeviceService() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenThrow(new NoSuchElementException());

    // Act and Assert
    assertThrows(
        NoSuchElementException.class,
        () ->
            EntitiesFieldsAsyncLoader.findAsync(
                ctx, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(ctx).getDeviceService();
  }

  /**
   * Test {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}.
   *
   * <ul>
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesFieldsAsyncLoader#findAsync(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test findAsync(TbContext, EntityId); then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EntitiesFieldsAsyncLoader.findAsync(TbContext, EntityId)"})
  void testFindAsync_thenReturnDone() {
    // Arrange
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act
    ListenableFuture<EntityFieldsData> actualFindAsyncResult =
        EntitiesFieldsAsyncLoader.findAsync(
            ctx, new ApiUsageStateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    assertTrue(actualFindAsyncResult.isDone());
  }
}
