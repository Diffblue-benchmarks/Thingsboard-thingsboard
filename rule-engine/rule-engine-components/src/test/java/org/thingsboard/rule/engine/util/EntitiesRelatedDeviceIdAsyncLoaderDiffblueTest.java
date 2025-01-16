package org.thingsboard.rule.engine.util;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
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
   * Test
   * {@link EntitiesRelatedDeviceIdAsyncLoader#findDeviceAsync(TbContext, EntityId, DeviceRelationsQuery)}.
   * <ul>
   *   <li>Then calls {@link TbContext#getDbCallbackExecutor()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesRelatedDeviceIdAsyncLoader#findDeviceAsync(TbContext, EntityId, DeviceRelationsQuery)}
   */
  @Test
  @DisplayName("Test findDeviceAsync(TbContext, EntityId, DeviceRelationsQuery); then calls getDbCallbackExecutor()")
  void testFindDeviceAsync_thenCallsGetDbCallbackExecutor() {
    // Arrange
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    SettableFuture<List<Device>> delegate = SettableFuture.create();
    when(deviceServiceImpl.findDevicesByQuery(Mockito.<TenantId>any(), Mockito.<DeviceSearchQuery>any())).thenReturn(
        new ApiFutureToListenableFuture<>(new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate))));
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);
    AlarmId originator = new AlarmId(UUID.randomUUID());

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
}
