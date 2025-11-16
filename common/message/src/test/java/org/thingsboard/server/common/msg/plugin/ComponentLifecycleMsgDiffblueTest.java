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
package org.thingsboard.server.common.msg.plugin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;

class ComponentLifecycleMsgDiffblueTest {
  /**
   * Test {@link ComponentLifecycleMsg#getRuleChainId()}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link ComponentLifecycleMsg#getRuleChainId()}
   */
  @Test
  @DisplayName(
      "Test getRuleChainId(); given AlarmId(UUID) with id is randomUUID; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ComponentLifecycleMsg.getRuleChainId()"})
  void testGetRuleChainId_givenAlarmIdWithIdIsRandomUUID_thenReturnNotPresent() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleNodeUpdatedMsg ruleNodeUpdatedMsg =
        new RuleNodeUpdatedMsg(tenantId, new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertFalse(ruleNodeUpdatedMsg.getRuleChainId().isPresent());
  }

  /**
   * Test {@link ComponentLifecycleMsg#getRuleChainId()}.
   *
   * <ul>
   *   <li>Given {@link RuleChainId#RuleChainId(UUID)} with id is randomUUID.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link ComponentLifecycleMsg#getRuleChainId()}
   */
  @Test
  @DisplayName(
      "Test getRuleChainId(); given RuleChainId(UUID) with id is randomUUID; then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ComponentLifecycleMsg.getRuleChainId()"})
  void testGetRuleChainId_givenRuleChainIdWithIdIsRandomUUID_thenReturnPresent() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RuleChainId entityId = new RuleChainId(UUID.randomUUID());

    RuleNodeUpdatedMsg ruleNodeUpdatedMsg = new RuleNodeUpdatedMsg(tenantId, entityId);

    // Act
    Optional<RuleChainId> actualRuleChainId = ruleNodeUpdatedMsg.getRuleChainId();

    // Assert
    assertTrue(actualRuleChainId.isPresent());
    assertSame(entityId, actualRuleChainId.get());
  }
}
