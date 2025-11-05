package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.net.InetSocketAddress;
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
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.transport.TransportTenantProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class DefaultTransportRateLimitServiceDiffblueTest {
  @InjectMocks private DefaultTransportRateLimitService defaultTransportRateLimitService;

  @Mock private TransportTenantProfileCache transportTenantProfileCache;

  /**
   * Test {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId, DeviceId, int,
   * boolean)}.
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName("Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits() {
    // Arrange
    TransportTenantProfileCache tenantProfileCache = mock(TransportTenantProfileCache.class);
    when(tenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    DefaultTransportRateLimitService defaultTransportRateLimitService =
        new DefaultTransportRateLimitService(tenantProfileCache);

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            null,
            null,
            0,
            false);

    // Assert
    verify(tenantProfileCache).get(isA(TenantId.class));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_thenThrowIllegalStateException() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenThrow(new IllegalStateException());

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
            1,
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
            1,
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
   *   <li>When one.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean); when one; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_whenOne_thenReturnNull() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            null,
            null,
            1,
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
   *   <li>When {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean); when 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_whenTrue_thenReturnNull() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            tenantId,
            null,
            new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            1,
            true);

    // Assert
    verify(transportTenantProfileCache, atLeast(1)).get(isA(TenantId.class));
    assertNull(actualCheckLimitsResult);
  }

  /**
   * Test {@link DefaultTransportRateLimitService#update(TenantId)} with {@code tenantId}.
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#update(TenantId)}
   */
  @Test
  @DisplayName("Test update(TenantId) with 'tenantId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTransportRateLimitService.update(TenantId)"})
  void testUpdateWithTenantId() {
    // Arrange
    TransportTenantProfileCache tenantProfileCache = mock(TransportTenantProfileCache.class);
    when(tenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    DefaultTransportRateLimitService defaultTransportRateLimitService =
        new DefaultTransportRateLimitService(tenantProfileCache);

    // Act
    defaultTransportRateLimitService.update(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tenantProfileCache, atLeast(1)).get(isA(TenantId.class));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultTransportRateLimitService.update(TenantId)"})
  void testUpdateWithTenantId_thenThrowIllegalStateException() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () ->
            defaultTransportRateLimitService.update(
                new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(transportTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}.
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkAddress(InetSocketAddress)}
   */
  @Test
  @DisplayName("Test checkAddress(InetSocketAddress)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultTransportRateLimitService.checkAddress(InetSocketAddress)"})
  void testCheckAddress() {
    // Arrange
    DefaultTransportRateLimitService defaultTransportRateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());

    // Act and Assert
    assertTrue(
        defaultTransportRateLimitService.checkAddress(
            InetSocketAddress.createUnresolved("localhost", 8080)));
  }
}
