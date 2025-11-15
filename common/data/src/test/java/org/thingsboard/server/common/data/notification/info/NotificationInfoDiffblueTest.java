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
package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class NotificationInfoDiffblueTest {
  /**
   * Method under test: {@link NotificationInfo#getStateEntityId()}
   */
  @Test
  void testGetStateEntityId() {
    // Arrange, Act and Assert
    assertNull((new ApiUsageLimitNotificationInfo()).getStateEntityId());
  }

  /**
   * Method under test: {@link NotificationInfo#getStateEntityId()}
   */
  @Test
  void testGetStateEntityId2() {
    // Arrange
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getStateEntityId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    notificationInfo.getStateEntityId();

    // Assert
    verify(notificationInfo).getStateEntityId();
  }

  /**
   * Method under test: {@link NotificationInfo#getDashboardId()}
   */
  @Test
  void testGetDashboardId() {
    // Arrange, Act and Assert
    assertNull((new ApiUsageLimitNotificationInfo()).getDashboardId());
  }

  /**
   * Method under test: {@link NotificationInfo#getDashboardId()}
   */
  @Test
  void testGetDashboardId2() {
    // Arrange
    NotificationInfo notificationInfo = mock(NotificationInfo.class);
    when(notificationInfo.getDashboardId()).thenReturn(null);

    // Act
    notificationInfo.getDashboardId();

    // Assert
    verify(notificationInfo).getDashboardId();
  }
}
