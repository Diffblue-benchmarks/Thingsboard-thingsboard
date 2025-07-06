package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

class TbDeleteRelationNodeDiffblueTest {
  /**
   * Test {@link TbDeleteRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbDeleteRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadEntityNodeActionConfig(TbNodeConfiguration); given 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbDeleteRelationNodeConfiguration TbDeleteRelationNode.loadEntityNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadEntityNodeActionConfig_givenFalse() throws TbNodeException {
    // Arrange
    TbDeleteRelationNode tbDeleteRelationNode = new TbDeleteRelationNode();

    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration =
        new TbDeleteRelationNodeConfiguration();
    tbDeleteRelationNodeConfiguration.setDeleteForSingleEntity(false);

    // Act and Assert
    assertSame(
        tbDeleteRelationNodeConfiguration,
        tbDeleteRelationNode.loadEntityNodeActionConfig(
            new TbNodeConfiguration(new POJONode(tbDeleteRelationNodeConfiguration))));
  }

  /**
   * Test {@link TbDeleteRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbDeleteRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadEntityNodeActionConfig(TbNodeConfiguration); given 'TENANT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbDeleteRelationNodeConfiguration TbDeleteRelationNode.loadEntityNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadEntityNodeActionConfig_givenTenant() throws TbNodeException {
    // Arrange
    TbDeleteRelationNode tbDeleteRelationNode = new TbDeleteRelationNode();

    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration =
        new TbDeleteRelationNodeConfiguration();
    tbDeleteRelationNodeConfiguration.setEntityType(EntityType.TENANT);
    tbDeleteRelationNodeConfiguration.setDeleteForSingleEntity(true);

    // Act and Assert
    assertSame(
        tbDeleteRelationNodeConfiguration,
        tbDeleteRelationNode.loadEntityNodeActionConfig(
            new TbNodeConfiguration(new POJONode(tbDeleteRelationNodeConfiguration))));
  }

  /**
   * Test {@link TbDeleteRelationNode#createEntityIfNotExists()}.
   *
   * <p>Method under test: {@link TbDeleteRelationNode#createEntityIfNotExists()}
   */
  @Test
  @DisplayName("Test createEntityIfNotExists()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbDeleteRelationNode.createEntityIfNotExists()"})
  void testCreateEntityIfNotExists() {
    // Arrange, Act and Assert
    assertFalse(new TbDeleteRelationNode().createEntityIfNotExists());
  }

  /**
   * Test new {@link TbDeleteRelationNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbDeleteRelationNode}
   */
  @Test
  @DisplayName("Test new TbDeleteRelationNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbDeleteRelationNode.<init>()"})
  void testNewTbDeleteRelationNode() {
    // Arrange, Act and Assert
    assertNull(new TbDeleteRelationNode().config);
  }
}
