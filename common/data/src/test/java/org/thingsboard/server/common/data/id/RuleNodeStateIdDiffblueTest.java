package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RuleNodeStateIdDiffblueTest {
  /**
   * Test {@link RuleNodeStateId#RuleNodeStateId(UUID)}.
   * <p>
   * Method under test: {@link RuleNodeStateId#RuleNodeStateId(UUID)}
   */
  @Test
  @DisplayName("Test new RuleNodeStateId(UUID)")
  void testNewRuleNodeStateId() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act and Assert
    UUID id2 = (new RuleNodeStateId(id)).getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertSame(id, id2);
  }
}
