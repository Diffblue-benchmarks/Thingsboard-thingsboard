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
            new TenantId(UUID.randomUUID()), null, null, 0, false);

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
                new TenantId(UUID.randomUUID()), null, null, 0, false));
    verify(transportTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId, DeviceId, int,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is randomUUID.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean); when DeviceId(UUID) with id is randomUUID; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_whenDeviceIdWithIdIsRandomUUID_thenReturnNull() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            tenantId, new DeviceId(UUID.randomUUID()), null, 1, false);

    // Assert
    verify(transportTenantProfileCache, atLeast(1)).get(isA(TenantId.class));
    assertNull(actualCheckLimitsResult);
  }

  /**
   * Test {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId, DeviceId, int,
   * boolean)}.
   *
   * <ul>
   *   <li>When {@link DeviceId#DeviceId(UUID)} with id is randomUUID.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultTransportRateLimitService#checkLimits(TenantId, DeviceId,
   * DeviceId, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkLimits(TenantId, DeviceId, DeviceId, int, boolean); when DeviceId(UUID) with id is randomUUID; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbPair DefaultTransportRateLimitService.checkLimits(TenantId, DeviceId, DeviceId, int, boolean)"
  })
  void testCheckLimits_whenDeviceIdWithIdIsRandomUUID_thenReturnNull2() {
    // Arrange
    when(transportTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            tenantId, null, new DeviceId(UUID.randomUUID()), 1, false);

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
            new TenantId(UUID.randomUUID()), null, null, 1, false);

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
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TbPair<EntityType, Boolean> actualCheckLimitsResult =
        defaultTransportRateLimitService.checkLimits(
            tenantId, null, new DeviceId(UUID.randomUUID()), 1, true);

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
    defaultTransportRateLimitService.update(new TenantId(UUID.randomUUID()));

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
        () -> defaultTransportRateLimitService.update(new TenantId(UUID.randomUUID())));
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
