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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.msg.MsgType;

class RuleNodeUpdatedMsgDiffblueTest {
  /**
   * Test {@link RuleNodeUpdatedMsg#RuleNodeUpdatedMsg(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeUpdatedMsg#RuleNodeUpdatedMsg(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test new RuleNodeUpdatedMsg(TenantId, EntityId); when 'null'; then return EntityId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeUpdatedMsg.<init>(TenantId, EntityId)"})
  void testNewRuleNodeUpdatedMsg_whenNull_thenReturnEntityIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    RuleNodeUpdatedMsg actualRuleNodeUpdatedMsg = new RuleNodeUpdatedMsg(tenantId, null);

    // Assert
    assertNull(actualRuleNodeUpdatedMsg.getEntityId());
    assertEquals(ComponentLifecycleEvent.UPDATED, actualRuleNodeUpdatedMsg.getEvent());
    assertEquals(MsgType.RULE_NODE_UPDATED_MSG, actualRuleNodeUpdatedMsg.getMsgType());
    assertSame(tenantId, actualRuleNodeUpdatedMsg.getTenantId());
  }

  /**
   * Test {@link RuleNodeUpdatedMsg#equals(Object)}, and {@link RuleNodeUpdatedMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeUpdatedMsg#equals(Object)}
   *   <li>{@link RuleNodeUpdatedMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdatedMsg.equals(Object)",
    "int RuleNodeUpdatedMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeUpdatedMsg ruleNodeUpdatedMsg = new RuleNodeUpdatedMsg(new TenantId(null), null);
    RuleNodeUpdatedMsg ruleNodeUpdatedMsg2 = new RuleNodeUpdatedMsg(new TenantId(null), null);

    // Act and Assert
    assertEquals(ruleNodeUpdatedMsg, ruleNodeUpdatedMsg2);
    assertEquals(ruleNodeUpdatedMsg.hashCode(), ruleNodeUpdatedMsg2.hashCode());
  }

  /**
   * Test {@link RuleNodeUpdatedMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeUpdatedMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdatedMsg.equals(Object)",
    "int RuleNodeUpdatedMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeUpdatedMsg ruleNodeUpdatedMsg =
        new RuleNodeUpdatedMsg(new TenantId(UUID.randomUUID()), null);
    RuleNodeUpdatedMsg ruleNodeUpdatedMsg2 =
        new RuleNodeUpdatedMsg(new TenantId(UUID.randomUUID()), null);

    // Act and Assert
    assertNotEquals(ruleNodeUpdatedMsg, ruleNodeUpdatedMsg2);
  }

  /**
   * Test {@link RuleNodeUpdatedMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleNodeUpdatedMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RuleNodeUpdatedMsg.equals(Object)",
    "int RuleNodeUpdatedMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeUpdatedMsg ruleNodeUpdatedMsg =
        new RuleNodeUpdatedMsg(new TenantId(UUID.randomUUID()), null);

    // Act and Assert
    assertNotEquals(ruleNodeUpdatedMsg, 1);
  }
}
