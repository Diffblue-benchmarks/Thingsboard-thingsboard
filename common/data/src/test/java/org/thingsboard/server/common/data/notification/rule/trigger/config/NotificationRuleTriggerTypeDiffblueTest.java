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
package org.thingsboard.server.common.data.notification.rule.trigger.config;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NotificationRuleTriggerTypeDiffblueTest {
  /**
   * Test {@link NotificationRuleTriggerType#isTenantLevel()}.
   *
   * <p>Method under test: {@link NotificationRuleTriggerType#isTenantLevel()}
   */
  @Test
  @DisplayName("Test isTenantLevel()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NotificationRuleTriggerType.isTenantLevel()"})
  void testIsTenantLevel() {
    // Arrange, Act and Assert
    assertTrue(NotificationRuleTriggerType.valueOf("ENTITY_ACTION").isTenantLevel());
  }
}
