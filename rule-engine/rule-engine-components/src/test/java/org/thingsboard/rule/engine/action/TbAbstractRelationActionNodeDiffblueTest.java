package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;

class TbAbstractRelationActionNodeDiffblueTest {
  /**
   * Test {@link TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}
   */
  @Test
  @DisplayName(
      "Test checkIfConfigEntityTypeIsSupported(EntityType); when 'ALARM'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractRelationActionNode.checkIfConfigEntityTypeIsSupported(EntityType)"
  })
  void testCheckIfConfigEntityTypeIsSupported_whenAlarm_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange, Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> new TbCreateRelationNode().checkIfConfigEntityTypeIsSupported(EntityType.ALARM));
  }

  /**
   * Test {@link TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbAbstractRelationActionNode#checkIfConfigEntityTypeIsSupported(EntityType)}
   */
  @Test
  @DisplayName(
      "Test checkIfConfigEntityTypeIsSupported(EntityType); when 'TENANT'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractRelationActionNode.checkIfConfigEntityTypeIsSupported(EntityType)"
  })
  void testCheckIfConfigEntityTypeIsSupported_whenTenant_thenDoesNotThrow() throws TbNodeException {
    // Arrange, Act and Assert
    assertDoesNotThrow(
        () -> new TbCreateRelationNode().checkIfConfigEntityTypeIsSupported(EntityType.TENANT));
  }
}
