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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).
   *   <li>Then calls {@link TbContext#getDbCallbackExecutor()}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesRelatedDeviceIdAsyncLoader#findDeviceAsync(TbContext,
   * EntityId, DeviceRelationsQuery)}
   */
  @Test
  @DisplayName(
      "Test findDeviceAsync(TbContext, EntityId, DeviceRelationsQuery); given TestDbCallbackExecutor (default constructor); then calls getDbCallbackExecutor()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture EntitiesRelatedDeviceIdAsyncLoader.findDeviceAsync(TbContext, EntityId, DeviceRelationsQuery)"
  })
  void testFindDeviceAsync_givenTestDbCallbackExecutor_thenCallsGetDbCallbackExecutor() {
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
