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
package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.transport.TransportTenantProfileCache;
import org.thingsboard.server.queue.discovery.TenantRoutingInfo;

@ExtendWith(MockitoExtension.class)
class TransportTenantRoutingInfoServiceDiffblueTest {
  @Mock private TransportTenantProfileCache transportTenantProfileCache;

  @InjectMocks private TransportTenantRoutingInfoService transportTenantRoutingInfoService;

  /**
   * Test {@link TransportTenantRoutingInfoService#getRoutingInfo(TenantId)}.
   *
   * <ul>
   *   <li>Then return ProfileId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TransportTenantRoutingInfoService#getRoutingInfo(TenantId)}
   */
  @Test
  @DisplayName("Test getRoutingInfo(TenantId); then return ProfileId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantRoutingInfo TransportTenantRoutingInfoService.getRoutingInfo(TenantId)"
  })
  void testGetRoutingInfo_thenReturnProfileIdIsNull() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TenantRoutingInfo actualRoutingInfo =
        transportTenantRoutingInfoService.getRoutingInfo(tenantId);

    // Assert
    verify(transportTenantProfileCache).get(isA(TenantId.class));
    assertNull(actualRoutingInfo.getProfileId());
    assertFalse(actualRoutingInfo.isIsolated());
    assertSame(tenantId, actualRoutingInfo.getTenantId());
  }
}
