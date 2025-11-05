package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbDeleteRelationNodeConfiguration TbDeleteRelationNode.loadEntityNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadEntityNodeActionConfig_givenFalse() throws TbNodeException {
    // Arrange
    TbDeleteRelationNode tbDeleteRelationNode = new TbDeleteRelationNode();

    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration =
        new TbDeleteRelationNodeConfiguration();
    tbDeleteRelationNodeConfiguration.setDeleteForSingleEntity(false);

    // Act
    TbDeleteRelationNodeConfiguration actualLoadEntityNodeActionConfigResult =
        tbDeleteRelationNode.loadEntityNodeActionConfig(
            new TbNodeConfiguration(new POJONode(tbDeleteRelationNodeConfiguration)));

    // Assert
    assertSame(tbDeleteRelationNodeConfiguration, actualLoadEntityNodeActionConfigResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

    // Act
    TbDeleteRelationNodeConfiguration actualLoadEntityNodeActionConfigResult =
        tbDeleteRelationNode.loadEntityNodeActionConfig(
            new TbNodeConfiguration(new POJONode(tbDeleteRelationNodeConfiguration)));

    // Assert
    assertSame(tbDeleteRelationNodeConfiguration, actualLoadEntityNodeActionConfigResult);
  }

  /**
   * Test {@link TbDeleteRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * TbDeleteRelationNode#loadEntityNodeActionConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadEntityNodeActionConfig(TbNodeConfiguration); given 'true'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbDeleteRelationNodeConfiguration TbDeleteRelationNode.loadEntityNodeActionConfig(TbNodeConfiguration)"
  })
  void testLoadEntityNodeActionConfig_givenTrue_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbDeleteRelationNode tbDeleteRelationNode = new TbDeleteRelationNode();

    TbDeleteRelationNodeConfiguration tbDeleteRelationNodeConfiguration =
        new TbDeleteRelationNodeConfiguration();
    tbDeleteRelationNodeConfiguration.setDeleteForSingleEntity(true);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeleteRelationNode.<init>()"})
  void testNewTbDeleteRelationNode() {
    // Arrange, Act and Assert
    assertNull(new TbDeleteRelationNode().config);
  }
}
