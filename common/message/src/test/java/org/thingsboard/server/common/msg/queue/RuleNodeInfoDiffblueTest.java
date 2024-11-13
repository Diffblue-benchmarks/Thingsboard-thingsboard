package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.RuleNodeId;

class RuleNodeInfoDiffblueTest {
  /**
   * Test {@link RuleNodeInfo#RuleNodeInfo(RuleNodeId, String, String)}.
   * <p>
   * Method under test:
   * {@link RuleNodeInfo#RuleNodeInfo(RuleNodeId, String, String)}
   */
  @Test
  @DisplayName("Test new RuleNodeInfo(RuleNodeId, String, String)")
  void testNewRuleNodeInfo() {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.randomUUID());

    // Act and Assert
    assertSame(id, (new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name")).getRuleNodeId());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeInfo#getRuleNodeId()}
   *   <li>{@link RuleNodeInfo#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    RuleNodeId id = new RuleNodeId(UUID.randomUUID());
    RuleNodeInfo ruleNodeInfo = new RuleNodeInfo(id, "Rule Chain Name", "Rule Node Name");

    // Act
    RuleNodeId actualRuleNodeId = ruleNodeInfo.getRuleNodeId();
    ruleNodeInfo.toString();

    // Assert
    assertSame(id, actualRuleNodeId);
  }
}
