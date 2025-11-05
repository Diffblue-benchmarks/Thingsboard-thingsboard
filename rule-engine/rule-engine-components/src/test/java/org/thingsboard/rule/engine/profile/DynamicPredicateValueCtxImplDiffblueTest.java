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
import org.thingsboard.server.dao.device.DeviceService;

class DynamicPredicateValueCtxImplDiffblueTest {
  /**
   * Test {@link DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId,
   * TbContext)}.
   *
   * <ul>
   *   <li>Given {@link DeviceService} {@link DeviceService#findDeviceById(TenantId, DeviceId)}
   *       return {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)}
   */
  @Test
  @DisplayName(
      "Test new DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext); given DeviceService findDeviceById(TenantId, DeviceId) return Device()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicPredicateValueCtxImpl.<init>(TenantId, DeviceId, TbContext)"})
  void testNewDynamicPredicateValueCtxImpl_givenDeviceServiceFindDeviceByIdReturnDevice() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(new Device());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceService);

    // Act
    DynamicPredicateValueCtxImpl actualDynamicPredicateValueCtxImpl =
        new DynamicPredicateValueCtxImpl(tenantId, null, ctx);

    // Assert
    verify(ctx).getDeviceService();
    verify(deviceService).findDeviceById(isA(TenantId.class), isNull());
    assertNull(actualDynamicPredicateValueCtxImpl.getCustomerValue("Key"));
  }

  /**
   * Test {@link DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId,
   * TbContext)}.
   *
   * <ul>
   *   <li>Given {@link DeviceService} {@link DeviceService#findDeviceById(TenantId, DeviceId)}
   *       return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DynamicPredicateValueCtxImpl#DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext)}
   */
  @Test
  @DisplayName(
      "Test new DynamicPredicateValueCtxImpl(TenantId, DeviceId, TbContext); given DeviceService findDeviceById(TenantId, DeviceId) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DynamicPredicateValueCtxImpl.<init>(TenantId, DeviceId, TbContext)"})
  void testNewDynamicPredicateValueCtxImpl_givenDeviceServiceFindDeviceByIdReturnNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceService deviceService = mock(DeviceService.class);
    when(deviceService.findDeviceById(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceService()).thenReturn(deviceService);

    // Act
    DynamicPredicateValueCtxImpl actualDynamicPredicateValueCtxImpl =
        new DynamicPredicateValueCtxImpl(tenantId, null, ctx);

    // Assert
    verify(ctx).getDeviceService();
    verify(deviceService).findDeviceById(isA(TenantId.class), isNull());
    assertNull(actualDynamicPredicateValueCtxImpl.getCustomerValue("Key"));
  }
}
