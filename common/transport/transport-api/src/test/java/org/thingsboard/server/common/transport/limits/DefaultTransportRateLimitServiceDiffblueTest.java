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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.common.transport.TransportTenantProfileCache;
import org.thingsboard.server.common.transport.profile.TenantProfileUpdateResult;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class DefaultTransportRateLimitServiceDiffblueTest {
  @InjectMocks
  private DefaultTransportRateLimitService defaultTransportRateLimitService;

  @Mock
  private TransportTenantProfileCache transportTenantProfileCache;

  /**
   * Test {@link DefaultTransportRateLimitService#update(TenantId)} with {@code tenantId}.
   * <ul>
   *   <li>Given {@link TransportTenantProfileCache} {@link TransportTenantProfileCache#get(TenantId)} return {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTransportRateLimitService#update(TenantId)}
   */
  @Test
  @DisplayName("Test update(TenantId) with 'tenantId'; given TransportTenantProfileCache get(TenantId) return TenantProfile()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTransportRateLimitService.update(TenantId)"})
  void testUpdateWithTenantId_givenTransportTenantProfileCacheGetReturnTenantProfile() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act
    defaultTransportRateLimitService.update(new TenantId(UUID.randomUUID()));

    // Assert
    verify(transportTenantProfileCache, atLeast(1)).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTransportRateLimitService#update(TenantId)} with {@code tenantId}.
   * <ul>
   *   <li>Then calls {@link TenantProfile#getProfileData()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTransportRateLimitService#update(TenantId)}
   */
  @Test
  @DisplayName("Test update(TenantId) with 'tenantId'; then calls getProfileData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTransportRateLimitService.update(TenantId)"})
  void testUpdateWithTenantId_thenCallsGetProfileData() {
    // Arrange
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(null);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    // Act
    defaultTransportRateLimitService.update(new TenantId(UUID.randomUUID()));

    // Assert
    verify(tenantProfile, atLeast(1)).getProfileData();
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    verify(transportTenantProfileCache, atLeast(1)).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)} with {@code update}.
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)}
   */
  @Test
  @DisplayName("Test update(TenantProfileUpdateResult) with 'update'; given TenantId(UUID) with id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTransportRateLimitService.update(TenantProfileUpdateResult)"})
  void testUpdateWithUpdate_givenTenantIdWithIdIsRandomUUID() {
    // Arrange
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
   * Test {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)} with {@code update}.
   * <ul>
   *   <li>Given {@link TenantProfileData} {@link TenantProfileData#getConfiguration()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)}
   */
  @Test
  @DisplayName("Test update(TenantProfileUpdateResult) with 'update'; given TenantProfileData getConfiguration() return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTransportRateLimitService.update(TenantProfileUpdateResult)"})
  void testUpdateWithUpdate_givenTenantProfileDataGetConfigurationReturnNull() {
    // Arrange
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
   * Test {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}.
   * <p>
   * Method under test: {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test checkAddress(InetSocketAddress)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTransportRateLimitService.checkAddress(InetSocketAddress)"})
  void testCheckAddress() {
    // Arrange, Act and Assert
    assertTrue(defaultTransportRateLimitService.checkAddress(InetSocketAddress.createUnresolved("foo", 1)));
  }
}
