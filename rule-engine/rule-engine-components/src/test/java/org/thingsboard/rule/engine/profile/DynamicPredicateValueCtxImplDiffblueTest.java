package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.device.DeviceServiceImpl;

class DynamicPredicateValueCtxImplDiffblueTest {
  /**
   * Test
   * {@link DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)}.
   * <p>
   * Method under test:
   * {@link DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)}
   */
  @Test
  @DisplayName("Test new DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)")
  void testNewDynamicPredicateValueCtxImpl() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(new Device());
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);

    // Act
    DynamicPredicateValueCtxImpl actualDynamicPredicateValueCtxImpl = new DynamicPredicateValueCtxImpl(tenantId, null,
        ctx);

    // Assert
    verify(ctx).getDeviceService();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isNull());
    assertNull(actualDynamicPredicateValueCtxImpl.getCustomerValue("Key"));
  }

  /**
   * Test
   * {@link DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)}.
   * <p>
   * Method under test:
   * {@link DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)}
   */
  @Test
  @DisplayName("Test new DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)")
  void testNewDynamicPredicateValueCtxImpl2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceServiceImpl deviceServiceImpl = mock(DeviceServiceImpl.class);
    when(deviceServiceImpl.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any())).thenReturn(null);
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceServiceImpl);

    // Act
    DynamicPredicateValueCtxImpl actualDynamicPredicateValueCtxImpl = new DynamicPredicateValueCtxImpl(tenantId, null,
        ctx);

    // Assert
    verify(ctx).getDeviceService();
    verify(deviceServiceImpl).findDeviceById(isA(TenantId.class), isNull());
    assertNull(actualDynamicPredicateValueCtxImpl.getCustomerValue("Key"));
  }
}
