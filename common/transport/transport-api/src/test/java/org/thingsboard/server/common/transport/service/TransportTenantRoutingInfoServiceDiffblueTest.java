package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.transport.TransportTenantProfileCache;
import org.thingsboard.server.queue.discovery.TenantRoutingInfo;

class TransportTenantRoutingInfoServiceDiffblueTest {
  /**
   * Test {@link TransportTenantRoutingInfoService#getRoutingInfo(TenantId)}.
   * <ul>
   *   <li>Then return ProfileId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TransportTenantRoutingInfoService#getRoutingInfo(TenantId)}
   */
  @Test
  @DisplayName("Test getRoutingInfo(TenantId); then return ProfileId is 'null'")
  void testGetRoutingInfo_thenReturnProfileIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportTenantProfileCache tenantProfileCache = mock(TransportTenantProfileCache.class);
    when(tenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TransportTenantRoutingInfoService transportTenantRoutingInfoService = new TransportTenantRoutingInfoService(
        tenantProfileCache);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TenantRoutingInfo actualRoutingInfo = transportTenantRoutingInfoService.getRoutingInfo(tenantId);

    // Assert
    verify(tenantProfileCache).get(isA(TenantId.class));
    assertNull(actualRoutingInfo.getProfileId());
    assertFalse(actualRoutingInfo.isIsolated());
    assertSame(tenantId, actualRoutingInfo.getTenantId());
  }
}
