package org.thingsboard.server.common.msg.plugin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
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
   * Method under test:
   * {@link RuleNodeUpdatedMsg#RuleNodeUpdatedMsg(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test new RuleNodeUpdatedMsg(TenantId, EntityId); when 'null'; then return EntityId is 'null'")
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
   * Test {@link RuleNodeUpdatedMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeUpdatedMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeUpdatedMsg ruleNodeUpdatedMsg = new RuleNodeUpdatedMsg(new TenantId(UUID.randomUUID()),
        mock(AlarmId.class));

    // Act and Assert
    assertNotEquals(ruleNodeUpdatedMsg, new RuleNodeUpdatedMsg(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Test {@link RuleNodeUpdatedMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeUpdatedMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new RuleNodeUpdatedMsg(new TenantId(UUID.randomUUID()), mock(AlarmId.class)), "42");
  }
}
