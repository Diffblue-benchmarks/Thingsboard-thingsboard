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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class RuleOriginatedNotificationInfoDiffblueTest {
  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}.
   *
   * <p>Method under test: {@link RuleOriginatedNotificationInfo#getAffectedCustomerId()}
   */
  @Test
  @DisplayName("Test getAffectedCustomerId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.CustomerId RuleOriginatedNotificationInfo.getAffectedCustomerId()"
  })
  void testGetAffectedCustomerId() {
    // Arrange, Act and Assert
    assertNull(new ApiUsageLimitNotificationInfo().getAffectedCustomerId());
  }

  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedUserId()}.
   *
   * <p>Method under test: {@link RuleOriginatedNotificationInfo#getAffectedUserId()}
   */
  @Test
  @DisplayName("Test getAffectedUserId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.UserId RuleOriginatedNotificationInfo.getAffectedUserId()"
  })
  void testGetAffectedUserId() {
    // Arrange, Act and Assert
    assertNull(new AlarmCommentNotificationInfo().getAffectedUserId());
  }

  /**
   * Test {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}.
   *
   * <p>Method under test: {@link RuleOriginatedNotificationInfo#getAffectedTenantId()}
   */
  @Test
  @DisplayName("Test getAffectedTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.id.TenantId RuleOriginatedNotificationInfo.getAffectedTenantId()"
  })
  void testGetAffectedTenantId() {
    // Arrange, Act and Assert
    assertNull(new AlarmAssignmentNotificationInfo().getAffectedTenantId());
  }
}
