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
import org.junit.jupiter.api.DisplayName;
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
   * Test {@link DefaultTransportRateLimitService#update(TenantId)} with
   * {@code tenantId}.
   * <ul>
   *   <li>Then calls {@link TransportTenantProfileCache#get(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTransportRateLimitService#update(TenantId)}
   */
  @Test
  @DisplayName("Test update(TenantId) with 'tenantId'; then calls get(TenantId)")
  void testUpdateWithTenantId_thenCallsGet() {
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
   * Test
   * {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)}
   * with {@code update}.
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)}
   */
  @Test
  @DisplayName("Test update(TenantProfileUpdateResult) with 'update'; given TenantId(UUID) with id is randomUUID")
  void testUpdateWithUpdate_givenTenantIdWithIdIsRandomUUID() {
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
   * Test
   * {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)}
   * with {@code update}.
   * <ul>
   *   <li>Given {@link TenantProfileData}
   * {@link TenantProfileData#getConfiguration()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)}
   */
  @Test
  @DisplayName("Test update(TenantProfileUpdateResult) with 'update'; given TenantProfileData getConfiguration() return 'null'")
  void testUpdateWithUpdate_givenTenantProfileDataGetConfigurationReturnNull() {
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
   * Test
   * {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}.
   * <p>
   * Method under test:
   * {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test checkAddress(InetSocketAddress)")
  void testCheckAddress() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportRateLimitService defaultTransportRateLimitService = new DefaultTransportRateLimitService(
        new DefaultTransportTenantProfileCache());

    // Act and Assert
    assertTrue(defaultTransportRateLimitService.checkAddress(InetSocketAddress.createUnresolved("foo", 1)));
  }

  /**
   * Test
   * {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}.
   * <p>
   * Method under test:
   * {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test checkAddress(InetSocketAddress)")
  void testCheckAddress2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTransportRateLimitService defaultTransportRateLimitService = new DefaultTransportRateLimitService(
        mock(DefaultTransportTenantProfileCache.class));

    // Act and Assert
    assertTrue(defaultTransportRateLimitService.checkAddress(InetSocketAddress.createUnresolved("foo", 1)));
  }
}
