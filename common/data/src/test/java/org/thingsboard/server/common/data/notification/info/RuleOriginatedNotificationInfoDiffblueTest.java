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
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleOriginatedNotificationInfoDiffblueTest {
  /**
   * Method under test:
   * {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}
   */
  @Test
  void testGetAffectedCustomerId() {
    // Arrange, Act and Assert
    assertNull((new ApiUsageLimitNotificationInfo()).getAffectedCustomerId());
  }

  /**
   * Method under test:
   * {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}
   */
  @Test
  void testGetAffectedCustomerId2() {
    // Arrange
    RuleOriginatedNotificationInfo ruleOriginatedNotificationInfo = mock(RuleOriginatedNotificationInfo.class);
    when(ruleOriginatedNotificationInfo.getAffectedCustomerId()).thenReturn(new CustomerId(EntityId.NULL_UUID));

    // Act
    ruleOriginatedNotificationInfo.getAffectedCustomerId();

    // Assert
    verify(ruleOriginatedNotificationInfo).getAffectedCustomerId();
  }

  /**
   * Method under test: {@link RuleOriginatedNotificationInfo#getAffectedUserId()}
   */
  @Test
  void testGetAffectedUserId() {
    // Arrange, Act and Assert
    assertNull((new AlarmCommentNotificationInfo()).getAffectedUserId());
  }

  /**
   * Method under test: {@link RuleOriginatedNotificationInfo#getAffectedUserId()}
   */
  @Test
  void testGetAffectedUserId2() {
    // Arrange
    RuleOriginatedNotificationInfo ruleOriginatedNotificationInfo = mock(RuleOriginatedNotificationInfo.class);
    when(ruleOriginatedNotificationInfo.getAffectedUserId()).thenReturn(null);

    // Act
    ruleOriginatedNotificationInfo.getAffectedUserId();

    // Assert
    verify(ruleOriginatedNotificationInfo).getAffectedUserId();
  }

  /**
   * Method under test:
   * {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}
   */
  @Test
  void testGetAffectedTenantId() {
    // Arrange, Act and Assert
    assertNull((new AlarmAssignmentNotificationInfo()).getAffectedTenantId());
  }

  /**
   * Method under test:
   * {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}
   */
  @Test
  void testGetAffectedTenantId2() {
    // Arrange
    RuleOriginatedNotificationInfo ruleOriginatedNotificationInfo = mock(RuleOriginatedNotificationInfo.class);
    when(ruleOriginatedNotificationInfo.getAffectedTenantId()).thenReturn(TenantId.SYS_TENANT_ID);

    // Act
    ruleOriginatedNotificationInfo.getAffectedTenantId();

    // Assert
    verify(ruleOriginatedNotificationInfo).getAffectedTenantId();
  }
}
