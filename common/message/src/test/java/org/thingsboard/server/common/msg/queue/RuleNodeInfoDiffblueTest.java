package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleNodeId;

class RuleNodeInfoDiffblueTest {
  /**
   * Test {@link RuleNodeInfo#RuleNodeInfo(RuleNodeId, String, String)}.
   *
   * <p>Method under test: {@link RuleNodeInfo#RuleNodeInfo(RuleNodeId, String, String)}
   */
  @Test
  @DisplayName("Test new RuleNodeInfo(RuleNodeId, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void RuleNodeInfo.<init>(RuleNodeId, String, String)"})
  void testNewRuleNodeInfo() {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    RuleNodeInfo actualRuleNodeInfo = new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name");

    // Assert
    assertEquals(
        "[RuleChain: Rule Chain Name|RuleNode: Rule Node Name(784f394c-42b6-435a-983c-b7beff2784f9)]",
        actualRuleNodeInfo.toString());
    assertSame(id, actualRuleNodeInfo.getRuleNodeId());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleNodeInfo#getRuleNodeId()}
   *   <li>{@link RuleNodeInfo#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeId RuleNodeInfo.getRuleNodeId()", "String RuleNodeInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    RuleNodeInfo ruleNodeInfo = new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name");

    // Act
    RuleNodeId actualRuleNodeId = ruleNodeInfo.getRuleNodeId();

    // Assert
    assertEquals(
        "[RuleChain: Rule Chain Name|RuleNode: Rule Node Name(784f394c-42b6-435a-983c-b7beff2784f9)]",
        ruleNodeInfo.toString());
    assertSame(id, actualRuleNodeId);
  }
}
