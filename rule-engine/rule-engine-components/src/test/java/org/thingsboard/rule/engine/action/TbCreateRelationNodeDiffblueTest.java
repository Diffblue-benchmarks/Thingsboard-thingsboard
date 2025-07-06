package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.EntityType;

class TbCreateRelationNodeDiffblueTest {
  /**
   * Test {@link TbCreateRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbCreateRelationNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link
   * TbCreateRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadEntityNodeActionConfig(TbNodeConfiguration); then return TbCreateRelationNodeConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbCreateRelationNodeConfiguration TbCreateRelationNode.loadEntityNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadEntityNodeActionConfig_thenReturnTbCreateRelationNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbCreateRelationNode tbCreateRelationNode = new TbCreateRelationNode();

    TbCreateRelationNodeConfiguration tbCreateRelationNodeConfiguration =
        new TbCreateRelationNodeConfiguration();
    tbCreateRelationNodeConfiguration.setEntityType(EntityType.TENANT);

    // Act and Assert
    assertSame(
        tbCreateRelationNodeConfiguration,
        tbCreateRelationNode.loadEntityNodeActionConfig(
            new TbNodeConfiguration(new POJONode(tbCreateRelationNodeConfiguration))));
  }

  /**
   * Test new {@link TbCreateRelationNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbCreateRelationNode}
   */
  @Test
  @DisplayName("Test new TbCreateRelationNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCreateRelationNode.<init>()"})
  void testNewTbCreateRelationNode() {
    // Arrange, Act and Assert
    assertNull(new TbCreateRelationNode().config);
  }
}
