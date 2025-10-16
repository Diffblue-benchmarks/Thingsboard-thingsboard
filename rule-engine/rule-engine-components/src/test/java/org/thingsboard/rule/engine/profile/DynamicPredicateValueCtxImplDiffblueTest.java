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
package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.device.DeviceServiceImpl;

class DynamicPredicateValueCtxImplDiffblueTest {
  /**
   * Test {@link DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId,
   * TbContext)}.
   *
   * <p>Method under test: {@link
   * DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)}
   */
  @Test
  @DisplayName("Test new DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicPredicateValueCtxImpl.<init>(TenantId, DeviceId, TbContext)"})
  void testNewDynamicPredicateValueCtxImpl() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new Device());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);

    // Act
    DynamicPredicateValueCtxImpl actualDynamicPredicateValueCtxImpl =
        new DynamicPredicateValueCtxImpl(tenantId, null, ctx);

    // Assert
    verify(ctx).getDeviceService();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isNull());
    assertNull(actualDynamicPredicateValueCtxImpl.getCustomerValue("Key"));
  }

  /**
   * Test {@link DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId,
   * TbContext)}.
   *
   * <p>Method under test: {@link
   * DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)}
   */
  @Test
  @DisplayName("Test new DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicPredicateValueCtxImpl.<init>(TenantId, DeviceId, TbContext)"})
  void testNewDynamicPredicateValueCtxImpl2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);

    // Act
    DynamicPredicateValueCtxImpl actualDynamicPredicateValueCtxImpl =
        new DynamicPredicateValueCtxImpl(tenantId, null, ctx);

    // Assert
    verify(ctx).getDeviceService();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isNull());
    assertNull(actualDynamicPredicateValueCtxImpl.getCustomerValue("Key"));
  }
}
