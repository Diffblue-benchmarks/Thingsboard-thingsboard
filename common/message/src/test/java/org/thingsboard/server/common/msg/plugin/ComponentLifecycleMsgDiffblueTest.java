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
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link ComponentLifecycleMsg#getRuleChainId()}
   */
  @Test
  @DisplayName("Test getRuleChainId(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ComponentLifecycleMsg.getRuleChainId()"})
  void testGetRuleChainId_thenReturnNotPresent() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    AlarmId entityId = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeUpdatedMsg ruleNodeUpdatedMsg = new RuleNodeUpdatedMsg(tenantId, entityId);

    // Act and Assert
    assertFalse(ruleNodeUpdatedMsg.getRuleChainId().isPresent());
  }

  /**
   * Test {@link ComponentLifecycleMsg#getRuleChainId()}.
   *
   * <ul>
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link ComponentLifecycleMsg#getRuleChainId()}
   */
  @Test
  @DisplayName("Test getRuleChainId(); then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ComponentLifecycleMsg.getRuleChainId()"})
  void testGetRuleChainId_thenReturnPresent() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleChainId entityId = new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    RuleNodeUpdatedMsg ruleNodeUpdatedMsg = new RuleNodeUpdatedMsg(tenantId, entityId);

    // Act
    Optional<RuleChainId> actualRuleChainId = ruleNodeUpdatedMsg.getRuleChainId();

    // Assert
    assertTrue(actualRuleChainId.isPresent());
    assertSame(entityId, actualRuleChainId.get());
  }
}
