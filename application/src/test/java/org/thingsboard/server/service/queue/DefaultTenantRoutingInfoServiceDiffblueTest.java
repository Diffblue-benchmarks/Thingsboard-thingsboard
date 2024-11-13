package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.exception.TenantNotFoundException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantService;

class DefaultTenantRoutingInfoServiceDiffblueTest {
  /**
   * Test {@link DefaultTenantRoutingInfoService#getRoutingInfo(TenantId)}.
   * <ul>
   *   <li>Then throw {@link TenantNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTenantRoutingInfoService#getRoutingInfo(TenantId)}
   */
  @Test
  @DisplayName("Test getRoutingInfo(TenantId); then throw TenantNotFoundException")
  void testGetRoutingInfo_thenThrowTenantNotFoundException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantService tenantService = mock(TenantService.class);
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(null);
    DefaultTenantRoutingInfoService defaultTenantRoutingInfoService = new DefaultTenantRoutingInfoService(
        new DefaultTbTenantProfileCache(new TenantProfileServiceImpl(), tenantService));

    // Act and Assert
    assertThrows(TenantNotFoundException.class,
        () -> defaultTenantRoutingInfoService.getRoutingInfo(new TenantId(UUID.randomUUID())));
    verify(tenantService).findTenantById(isA(TenantId.class));
  }
}
