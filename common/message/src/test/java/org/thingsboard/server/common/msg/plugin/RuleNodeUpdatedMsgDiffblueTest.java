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
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    RuleNodeUpdatedMsg actualRuleNodeUpdatedMsg = new RuleNodeUpdatedMsg(tenantId, null);

    // Assert
    assertNull(actualRuleNodeUpdatedMsg.getEntityId());
    assertEquals(ComponentLifecycleEvent.UPDATED, actualRuleNodeUpdatedMsg.getEvent());
    assertEquals(MsgType.RULE_NODE_UPDATED_MSG, actualRuleNodeUpdatedMsg.getMsgType());
    assertSame(tenantId, actualRuleNodeUpdatedMsg.getTenantId());
  }
}
