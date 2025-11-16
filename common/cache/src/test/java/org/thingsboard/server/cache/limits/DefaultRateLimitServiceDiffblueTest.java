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
package org.thingsboard.server.cache.limits;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.exception.TenantProfileNotFoundException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;

@ContextConfiguration(classes = {DefaultRateLimitService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class DefaultRateLimitServiceDiffblueTest {
  @Autowired private DefaultRateLimitService defaultRateLimitService;

  @MockBean private TenantProfileProvider tenantProfileProvider;

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, Object, String)} with {@code
   * api}, {@code level}, {@code rateLimitConfig}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, Object,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, Object, String) with 'api', 'level', 'rateLimitConfig'; when empty string; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRateLimitService.checkRateLimit(LimitedApi, Object, String)"})
  void testCheckRateLimitWithApiLevelRateLimitConfig_whenEmptyString_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT, "Level", ""));
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, Object, String)} with {@code
   * api}, {@code level}, {@code rateLimitConfig}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, Object,
   * String)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, Object, String) with 'api', 'level', 'rateLimitConfig'; when 'null'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRateLimitService.checkRateLimit(LimitedApi, Object, String)"})
  void testCheckRateLimitWithApiLevelRateLimitConfig_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT, "Level", null));
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)} with {@code api},
   * {@code tenantId}.
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)}
   */
  @Test
  @DisplayName("Test checkRateLimit(LimitedApi, TenantId) with 'api', 'tenantId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId)"})
  void testCheckRateLimitWithApiTenantId() {
    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any()))
        .thenThrow(new TenantProfileNotFoundException(new TenantId(UUID.randomUUID())));
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            tenantProfileProvider, mock(NotificationRuleProcessor.class), 1, 3);

    // Act and Assert
    assertThrows(
        TenantProfileNotFoundException.class,
        () ->
            defaultRateLimitService.checkRateLimit(
                LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID())));
    verify(tenantProfileProvider).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object, boolean)} with
   * {@code api}, {@code tenantId}, {@code level}, {@code ignoreTenantNotFound}.
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId,
   * Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId, Object, boolean) with 'api', 'tenantId', 'level', 'ignoreTenantNotFound'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId, Object, boolean)"
  })
  void testCheckRateLimitWithApiTenantIdLevelIgnoreTenantNotFound() {
    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any()))
        .thenThrow(new TenantProfileNotFoundException(new TenantId(UUID.randomUUID())));
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            tenantProfileProvider, mock(NotificationRuleProcessor.class), 1, 3);

    // Act and Assert
    assertThrows(
        TenantProfileNotFoundException.class,
        () ->
            defaultRateLimitService.checkRateLimit(
                LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID()), "Level", true));
    verify(tenantProfileProvider).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object, boolean)} with
   * {@code api}, {@code tenantId}, {@code level}, {@code ignoreTenantNotFound}.
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId,
   * Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId, Object, boolean) with 'api', 'tenantId', 'level', 'ignoreTenantNotFound'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId, Object, boolean)"
  })
  void testCheckRateLimitWithApiTenantIdLevelIgnoreTenantNotFound2() {
    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(null);
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            tenantProfileProvider, mock(NotificationRuleProcessor.class), 1, 3);

    // Act
    boolean actualCheckRateLimitResult =
        defaultRateLimitService.checkRateLimit(
            LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID()), "Level", true);

    // Assert
    verify(tenantProfileProvider).get(isA(TenantId.class));
    assertTrue(actualCheckRateLimitResult);
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object, boolean)} with
   * {@code api}, {@code tenantId}, {@code level}, {@code ignoreTenantNotFound}.
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId,
   * Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId, Object, boolean) with 'api', 'tenantId', 'level', 'ignoreTenantNotFound'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId, Object, boolean)"
  })
  void testCheckRateLimitWithApiTenantIdLevelIgnoreTenantNotFound3() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileConfiguration())
        .thenThrow(new TenantProfileNotFoundException(new TenantId(UUID.randomUUID())));

    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            tenantProfileProvider, mock(NotificationRuleProcessor.class), 1, 3);

    // Act and Assert
    assertThrows(
        TenantProfileNotFoundException.class,
        () ->
            defaultRateLimitService.checkRateLimit(
                LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID()), "Level", true));
    verify(tenantProfileProvider).get(isA(TenantId.class));
    verify(tenantProfile).getProfileConfiguration();
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object, boolean)} with
   * {@code api}, {@code tenantId}, {@code level}, {@code ignoreTenantNotFound}.
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId,
   * Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId, Object, boolean) with 'api', 'tenantId', 'level', 'ignoreTenantNotFound'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId, Object, boolean)"
  })
  void testCheckRateLimitWithApiTenantIdLevelIgnoreTenantNotFound4() {
    // Arrange
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(true);

    // Act
    boolean actualCheckRateLimitResult =
        defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT, tenantId, "Level", true);

    // Assert
    verify(tenantId).isSysTenantId();
    assertTrue(actualCheckRateLimitResult);
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object, boolean)} with
   * {@code api}, {@code tenantId}, {@code level}, {@code ignoreTenantNotFound}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId,
   * Object, boolean)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId, Object, boolean) with 'api', 'tenantId', 'level', 'ignoreTenantNotFound'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId, Object, boolean)"
  })
  void testCheckRateLimitWithApiTenantIdLevelIgnoreTenantNotFound_thenReturnTrue() {
    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            tenantProfileProvider, mock(NotificationRuleProcessor.class), 1, 3);

    // Act
    boolean actualCheckRateLimitResult =
        defaultRateLimitService.checkRateLimit(
            LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID()), "Level", true);

    // Assert
    verify(tenantProfileProvider).get(isA(TenantId.class));
    assertTrue(actualCheckRateLimitResult);
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object)} with {@code
   * api}, {@code tenantId}, {@code level}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link TenantId#isSysTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId, Object) with 'api', 'tenantId', 'level'; given 'true'; then calls isSysTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId, Object)"
  })
  void testCheckRateLimitWithApiTenantIdLevel_givenTrue_thenCallsIsSysTenantId() {
    // Arrange
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(true);

    // Act
    boolean actualCheckRateLimitResult =
        defaultRateLimitService.checkRateLimit(
            LimitedApi.ENTITY_EXPORT, tenantId, (Object) "Level");

    // Assert
    verify(tenantId).isSysTenantId();
    assertTrue(actualCheckRateLimitResult);
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object)} with {@code
   * api}, {@code tenantId}, {@code level}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId,
   * Object)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId, Object) with 'api', 'tenantId', 'level'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId, Object)"
  })
  void testCheckRateLimitWithApiTenantIdLevel_thenReturnTrue() {
    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            tenantProfileProvider, mock(NotificationRuleProcessor.class), 1, 3);

    // Act
    boolean actualCheckRateLimitResult =
        defaultRateLimitService.checkRateLimit(
            LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID()), (Object) "Level");

    // Assert
    verify(tenantProfileProvider).get(isA(TenantId.class));
    assertTrue(actualCheckRateLimitResult);
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)} with {@code api},
   * {@code tenantId}.
   *
   * <ul>
   *   <li>Given {@link TenantProfileProvider} {@link TenantProfileProvider#get(TenantId)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId) with 'api', 'tenantId'; given TenantProfileProvider get(TenantId) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId)"})
  void testCheckRateLimitWithApiTenantId_givenTenantProfileProviderGetReturnNull() {
    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(null);
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            tenantProfileProvider, mock(NotificationRuleProcessor.class), 1, 3);

    // Act and Assert
    assertThrows(
        TenantProfileNotFoundException.class,
        () ->
            defaultRateLimitService.checkRateLimit(
                LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID())));
    verify(tenantProfileProvider).get(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)} with {@code api},
   * {@code tenantId}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then calls {@link TenantId#isSysTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId) with 'api', 'tenantId'; given 'true'; then calls isSysTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId)"})
  void testCheckRateLimitWithApiTenantId_givenTrue_thenCallsIsSysTenantId() {
    // Arrange
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(true);

    // Act
    boolean actualCheckRateLimitResult =
        defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT, tenantId);

    // Assert
    verify(tenantId).isSysTenantId();
    assertTrue(actualCheckRateLimitResult);
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)} with {@code api},
   * {@code tenantId}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfile#getProfileConfiguration()}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId) with 'api', 'tenantId'; then calls getProfileConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId)"})
  void testCheckRateLimitWithApiTenantId_thenCallsGetProfileConfiguration() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileConfiguration())
        .thenThrow(new TenantProfileNotFoundException(new TenantId(UUID.randomUUID())));

    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            tenantProfileProvider, mock(NotificationRuleProcessor.class), 1, 3);

    // Act and Assert
    assertThrows(
        TenantProfileNotFoundException.class,
        () ->
            defaultRateLimitService.checkRateLimit(
                LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID())));
    verify(tenantProfileProvider).get(isA(TenantId.class));
    verify(tenantProfile).getProfileConfiguration();
  }

  /**
   * Test {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)} with {@code api},
   * {@code tenantId}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)}
   */
  @Test
  @DisplayName(
      "Test checkRateLimit(LimitedApi, TenantId) with 'api', 'tenantId'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DefaultRateLimitService.checkRateLimit(LimitedApi, TenantId)"})
  void testCheckRateLimitWithApiTenantId_thenReturnTrue() {
    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    DefaultRateLimitService defaultRateLimitService =
        new DefaultRateLimitService(
            tenantProfileProvider, mock(NotificationRuleProcessor.class), 1, 3);

    // Act
    boolean actualCheckRateLimitResult =
        defaultRateLimitService.checkRateLimit(
            LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID()));

    // Assert
    verify(tenantProfileProvider).get(isA(TenantId.class));
    assertTrue(actualCheckRateLimitResult);
  }
}
