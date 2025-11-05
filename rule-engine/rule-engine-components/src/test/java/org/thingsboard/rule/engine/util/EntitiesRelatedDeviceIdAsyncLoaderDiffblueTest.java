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
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.data.DeviceRelationsQuery;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.device.DeviceSearchQuery;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.dao.device.DeviceServiceImpl;

class EntitiesRelatedDeviceIdAsyncLoaderDiffblueTest {
  /**
   * Test {@link EntitiesRelatedDeviceIdAsyncLoader#findDeviceAsync(TbContext, EntityId,
   * DeviceRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureToApiFuture#ListenableFutureToApiFuture(ListenableFuture)}
   *       with delegate is create.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesRelatedDeviceIdAsyncLoader#findDeviceAsync(TbContext,
   * EntityId, DeviceRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findDeviceAsync(TbContext, EntityId, DeviceRelationsQuery); given ListenableFutureToApiFuture(ListenableFuture) with delegate is create")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EntitiesRelatedDeviceIdAsyncLoader.findDeviceAsync(TbContext, EntityId, DeviceRelationsQuery)"
  })
  void testFindDeviceAsync_givenListenableFutureToApiFutureWithDelegateIsCreate() {
    // Arrange
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    SettableFuture<List<Device>> delegate = SettableFuture.create();
    ForwardingApiFuture<List<Device>> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));
    when(deviceServiceImpl.findDevicesByQuery(
            Mockito.<TenantId>any(), Mockito.<DeviceSearchQuery>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    // Act
    EntitiesRelatedDeviceIdAsyncLoader.findDeviceAsync(ctx, originator, deviceRelationsQuery);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getDeviceService();
    verify(ctx).getTenantId();
    verify(deviceServiceImpl).findDevicesByQuery(isA(TenantId.class), isA(DeviceSearchQuery.class));
  }

  /**
   * Test {@link EntitiesRelatedDeviceIdAsyncLoader#findDeviceAsync(TbContext, EntityId,
   * DeviceRelationsQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesRelatedDeviceIdAsyncLoader#findDeviceAsync(TbContext,
   * EntityId, DeviceRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findDeviceAsync(TbContext, EntityId, DeviceRelationsQuery); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EntitiesRelatedDeviceIdAsyncLoader.findDeviceAsync(TbContext, EntityId, DeviceRelationsQuery)"
  })
  void testFindDeviceAsync_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<List<Device>> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<List<Device>> delegate2 =
        new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<List<Device>> apiFuture = new ForwardingApiFuture<>(delegate2);

    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDevicesByQuery(
            Mockito.<TenantId>any(), Mockito.<DeviceSearchQuery>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceRelationsQuery deviceRelationsQuery = new DeviceRelationsQuery();
    deviceRelationsQuery.setDeviceTypes(new ArrayList<>());
    deviceRelationsQuery.setDirection(EntitySearchDirection.FROM);
    deviceRelationsQuery.setFetchLastLevelOnly(true);
    deviceRelationsQuery.setMaxLevel(3);
    deviceRelationsQuery.setRelationType("Relation Type");

    // Act
    EntitiesRelatedDeviceIdAsyncLoader.findDeviceAsync(ctx, originator, deviceRelationsQuery);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getDeviceService();
    verify(ctx).getTenantId();
    verify(deviceServiceImpl).findDevicesByQuery(isA(TenantId.class), isA(DeviceSearchQuery.class));
  }
}
