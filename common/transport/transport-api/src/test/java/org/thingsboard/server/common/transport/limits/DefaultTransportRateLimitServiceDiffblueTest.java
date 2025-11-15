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
package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.common.transport.TransportTenantProfileCache;
import org.thingsboard.server.common.transport.profile.TenantProfileUpdateResult;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;

class DefaultTransportRateLimitServiceDiffblueTest {
  /**
   * Method under test: {@link DefaultTransportRateLimitService#update(TenantId)}
   */
  @Test
  void testUpdate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TransportTenantProfileCache tenantProfileCache = mock(TransportTenantProfileCache.class);
    when(tenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    DefaultTransportRateLimitService defaultTransportRateLimitService = new DefaultTransportRateLimitService(
        tenantProfileCache);

    // Act
    defaultTransportRateLimitService.update(new TenantId(UUID.randomUUID()));

    // Assert
    verify(tenantProfileCache, atLeast(1)).get(isA(TenantId.class));
  }

  /**
   * Method under test:
   * {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)}
   */
  @Test
  void testUpdate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportRateLimitService defaultTransportRateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(null);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile profile = mock(TenantProfile.class);
    when(profile.getProfileData()).thenReturn(tenantProfileData);

    // Act
    defaultTransportRateLimitService.update(new TenantProfileUpdateResult(profile, new HashSet<>()));

    // Assert
    verify(profile, atLeast(1)).getProfileData();
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
  }

  /**
   * Method under test:
   * {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)}
   */
  @Test
  void testUpdate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportRateLimitService defaultTransportRateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(new DefaultTenantProfileConfiguration());
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile profile = mock(TenantProfile.class);
    when(profile.getProfileData()).thenReturn(tenantProfileData);

    HashSet<TenantId> affectedTenants = new HashSet<>();
    affectedTenants.add(new TenantId(UUID.randomUUID()));

    // Act
    defaultTransportRateLimitService.update(new TenantProfileUpdateResult(profile, affectedTenants));

    // Assert
    verify(profile, atLeast(1)).getProfileData();
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
  }

  /**
   * Method under test:
   * {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}
   */
  @Test
  void testCheckAddress() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportRateLimitService defaultTransportRateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());

    // Act and Assert
    assertTrue(defaultTransportRateLimitService.checkAddress(InetSocketAddress.createUnresolved("foo", 1)));
  }

  /**
   * Method under test:
   * {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}
   */
  @Test
  void testCheckAddress2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportRateLimitService defaultTransportRateLimitService = new DefaultTransportRateLimitService(
        mock(DefaultTransportTenantProfileCache.class));

    // Act and Assert
    assertTrue(defaultTransportRateLimitService.checkAddress(InetSocketAddress.createUnresolved("foo", 1)));
  }
}
