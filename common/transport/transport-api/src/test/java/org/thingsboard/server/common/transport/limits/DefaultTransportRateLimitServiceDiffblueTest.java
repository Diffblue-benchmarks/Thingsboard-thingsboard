package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.transport.TransportTenantProfileCache;
import org.thingsboard.server.common.transport.profile.TenantProfileUpdateResult;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultTransportRateLimitServiceDiffblueTest {
  @InjectMocks private DefaultTransportRateLimitService defaultTransportRateLimitService;

  @Mock private TransportTenantProfileCache transportTenantProfileCache;

  /**
   * Test {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId, DeviceId, int,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName("Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_thenReturnNull() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            null,
            null,
            0,
            false);

    // Assert
    verify(transportTenantProfileCache).get(isA(TenantId.class));
    assertNull(actualCheckLimitsResult);
  }

  /**
   * Test {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId, DeviceId, int,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean); then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_thenThrowIllegalStateException() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultTransportRateLimitService.checkLimits(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                null,
                null,
                0,
                false));
    verify(transportTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId, DeviceId, int,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean); when DeviceId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_whenDeviceIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            tenantId,
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            null,
            0,
            false);

    // Assert
    verify(transportTenantProfileCache, atLeast(1)).get(isA(TenantId.class));
    assertNull(actualCheckLimitsResult);
  }

  /**
   * Test {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId, DeviceId, int,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean); when DeviceId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_whenDeviceIdWithIdIsFromString784f394c42b6435a983cB7beff2784f92() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            tenantId,
            null,
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            0,
            false);

    // Assert
    verify(transportTenantProfileCache, atLeast(1)).get(isA(TenantId.class));
    assertNull(actualCheckLimitsResult);
  }

  /**
   * Test {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId, DeviceId, int,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean); when DeviceId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_whenDeviceIdWithIdIsFromString784f394c42b6435a983cB7beff2784f93() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            tenantId,
            null,
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            0,
            true);

    // Assert
    verify(transportTenantProfileCache, atLeast(1)).get(isA(TenantId.class));
    assertNull(actualCheckLimitsResult);
  }

  /**
   * Test {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId, DeviceId, int,
   * boolean)}.
   *
   * <ul>
   *   <li>When thirty-one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean); when thirty-one; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_whenThirtyOne_thenReturnNull() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            null,
            null,
            31,
            false);

    // Assert
    verify(transportTenantProfileCache).get(isA(TenantId.class));
    assertNull(actualCheckLimitsResult);
  }

  /**
   * Test {@link DefaultTransportRateLimitService#update(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>Then calls {@link TransportTenantProfileCache#get(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#update(TenantId)}
   */
  @Test
  @DisplayName("Test update(TenantId) with 'tenantId'; then calls get(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTransportRateLimitService.update(TenantId)"})
  void testUpdateWithTenantId_thenCallsGet() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act
    defaultTransportRateLimitService.update(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(transportTenantProfileCache, atLeast(1)).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTransportRateLimitService#update(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#update(TenantId)}
   */
  @Test
  @DisplayName("Test update(TenantId) with 'tenantId'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTransportRateLimitService.update(TenantId)"})
  void testUpdateWithTenantId_thenThrowIllegalStateException() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenThrow(new IllegalStateException("foo"));

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultTransportRateLimitService.update(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(transportTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTransportRateLimitService#update(TenantProfileUpdateResult)} with {@code
   * update}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfile#getProfileData()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultTransportRateLimitService#update(TenantProfileUpdateResult)}
   */
  @Test
  @DisplayName("Test update(TenantProfileUpdateResult) with 'update'; then calls getProfileData()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DefaultTransportRateLimitService.update(TenantProfileUpdateResult)"})
  void testUpdateWithUpdate_thenCallsGetProfileData() {
    // Arrange
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(null);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile profile = mock(TenantProfile.class);
    when(profile.getProfileData()).thenReturn(tenantProfileData);

    // Act
    defaultTransportRateLimitService.update(
        new TenantProfileUpdateResult(profile, new HashSet<>()));

    // Assert
    verify(profile, atLeast(1)).getProfileData();
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
  }

  /**
   * Test {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}.
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test checkAddress(InetSocketAddress)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DefaultTransportRateLimitService.checkAddress(InetSocketAddress)"})
  void testCheckAddress() {
    // Arrange, Act and Assert
    assertTrue(
        defaultTransportRateLimitService.checkAddress(
            InetSocketAddress.createUnresolved("foo", 1)));
  }
}
