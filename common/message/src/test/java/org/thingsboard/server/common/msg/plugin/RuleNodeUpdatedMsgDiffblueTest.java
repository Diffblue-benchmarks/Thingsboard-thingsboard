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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
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
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeUpdatedMsg#RuleNodeUpdatedMsg(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test new RuleNodeUpdatedMsg(TenantId, EntityId); when 'null'; then return EntityId is 'null'")
  @Tag("MaintainedByDiffblue")
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
}
