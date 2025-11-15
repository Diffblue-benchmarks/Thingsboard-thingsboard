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
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.exception.TenantProfileNotFoundException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;

class DefaultRateLimitServiceDiffblueTest {
  /**
   * Method under test:
   * {@link DefaultRateLimitService#checkRateLimit(LimitedApi, Object, String)}
   */
  @Test
  void testCheckRateLimit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange, Act and Assert
    assertTrue(
        (new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3))
            .checkRateLimit(LimitedApi.ENTITY_EXPORT, "Level", null));
    assertTrue(
        (new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3))
            .checkRateLimit(LimitedApi.ENTITY_EXPORT, "Level", ""));
  }

  /**
   * Method under test:
   * {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)}
   */
  @Test
  void testCheckRateLimit2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    DefaultRateLimitService defaultRateLimitService = new DefaultRateLimitService(tenantProfileProvider,
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act
    boolean actualCheckRateLimitResult = defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT,
        new TenantId(UUID.randomUUID()));

    // Assert
    verify(tenantProfileProvider).get(isA(TenantId.class));
    assertTrue(actualCheckRateLimitResult);
  }

  /**
   * Method under test:
   * {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)}
   */
  @Test
  void testCheckRateLimit3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(null);
    DefaultRateLimitService defaultRateLimitService = new DefaultRateLimitService(tenantProfileProvider,
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act and Assert
    assertThrows(TenantProfileNotFoundException.class,
        () -> defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID())));
    verify(tenantProfileProvider).get(isA(TenantId.class));
  }

  /**
   * Method under test:
   * {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId)}
   */
  @Test
  void testCheckRateLimit4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileConfiguration())
        .thenThrow(new TenantProfileNotFoundException(new TenantId(UUID.randomUUID())));
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    DefaultRateLimitService defaultRateLimitService = new DefaultRateLimitService(tenantProfileProvider,
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act and Assert
    assertThrows(TenantProfileNotFoundException.class,
        () -> defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID())));
    verify(tenantProfileProvider).get(isA(TenantId.class));
    verify(tenantProfile).getProfileConfiguration();
  }

  /**
   * Method under test:
   * {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object)}
   */
  @Test
  void testCheckRateLimit5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    DefaultRateLimitService defaultRateLimitService = new DefaultRateLimitService(tenantProfileProvider,
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act
    boolean actualCheckRateLimitResult = defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT,
        new TenantId(UUID.randomUUID()), (Object) "Level");

    // Assert
    verify(tenantProfileProvider).get(isA(TenantId.class));
    assertTrue(actualCheckRateLimitResult);
  }

  /**
   * Method under test:
   * {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object)}
   */
  @Test
  void testCheckRateLimit6() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(null);
    DefaultRateLimitService defaultRateLimitService = new DefaultRateLimitService(tenantProfileProvider,
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act and Assert
    assertThrows(TenantProfileNotFoundException.class, () -> defaultRateLimitService
        .checkRateLimit(LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID()), (Object) "Level"));
    verify(tenantProfileProvider).get(isA(TenantId.class));
  }

  /**
   * Method under test:
   * {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object)}
   */
  @Test
  void testCheckRateLimit7() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileConfiguration())
        .thenThrow(new TenantProfileNotFoundException(new TenantId(UUID.randomUUID())));
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    DefaultRateLimitService defaultRateLimitService = new DefaultRateLimitService(tenantProfileProvider,
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act and Assert
    assertThrows(TenantProfileNotFoundException.class, () -> defaultRateLimitService
        .checkRateLimit(LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID()), (Object) "Level"));
    verify(tenantProfileProvider).get(isA(TenantId.class));
    verify(tenantProfile).getProfileConfiguration();
  }

  /**
   * Method under test:
   * {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object, boolean)}
   */
  @Test
  void testCheckRateLimit8() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    DefaultRateLimitService defaultRateLimitService = new DefaultRateLimitService(tenantProfileProvider,
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act
    boolean actualCheckRateLimitResult = defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT,
        new TenantId(UUID.randomUUID()), "Level", true);

    // Assert
    verify(tenantProfileProvider).get(isA(TenantId.class));
    assertTrue(actualCheckRateLimitResult);
  }

  /**
   * Method under test:
   * {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object, boolean)}
   */
  @Test
  void testCheckRateLimit9() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(null);
    DefaultRateLimitService defaultRateLimitService = new DefaultRateLimitService(tenantProfileProvider,
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act
    boolean actualCheckRateLimitResult = defaultRateLimitService.checkRateLimit(LimitedApi.ENTITY_EXPORT,
        new TenantId(UUID.randomUUID()), "Level", true);

    // Assert
    verify(tenantProfileProvider).get(isA(TenantId.class));
    assertTrue(actualCheckRateLimitResult);
  }

  /**
   * Method under test:
   * {@link DefaultRateLimitService#checkRateLimit(LimitedApi, TenantId, Object, boolean)}
   */
  @Test
  void testCheckRateLimit10() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileConfiguration())
        .thenThrow(new TenantProfileNotFoundException(new TenantId(UUID.randomUUID())));
    TenantProfileProvider tenantProfileProvider = mock(TenantProfileProvider.class);
    when(tenantProfileProvider.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    DefaultRateLimitService defaultRateLimitService = new DefaultRateLimitService(tenantProfileProvider,
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act and Assert
    assertThrows(TenantProfileNotFoundException.class, () -> defaultRateLimitService
        .checkRateLimit(LimitedApi.ENTITY_EXPORT, new TenantId(UUID.randomUUID()), "Level", true));
    verify(tenantProfileProvider).get(isA(TenantId.class));
    verify(tenantProfile).getProfileConfiguration();
  }
}
