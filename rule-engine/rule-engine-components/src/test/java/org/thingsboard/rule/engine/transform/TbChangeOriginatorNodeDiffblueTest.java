package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.data.RelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;

class TbChangeOriginatorNodeDiffblueTest {
  /**
   * Test {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <p>Method under test: {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbContext, TbNodeConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbChangeOriginatorNodeConfiguration TbChangeOriginatorNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration() throws TbNodeException {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setOriginatorSource(null);
    tbChangeOriginatorNodeConfiguration.setRelationsQuery(relationsQuery);
    tbChangeOriginatorNodeConfiguration.setEntityType("foo");
    tbChangeOriginatorNodeConfiguration.setEntityNamePattern("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbChangeOriginatorNode.loadNodeConfiguration(
                ctx, new TbNodeConfiguration(new POJONode(tbChangeOriginatorNodeConfiguration))));
  }

  /**
   * Test {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <p>Method under test: {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbContext, TbNodeConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbChangeOriginatorNodeConfiguration TbChangeOriginatorNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration2() throws TbNodeException {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setOriginatorSource(OriginatorSource.ENTITY);
    tbChangeOriginatorNodeConfiguration.setRelationsQuery(relationsQuery);
    tbChangeOriginatorNodeConfiguration.setEntityType(null);
    tbChangeOriginatorNodeConfiguration.setEntityNamePattern("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbChangeOriginatorNode.loadNodeConfiguration(
                ctx, new TbNodeConfiguration(new POJONode(tbChangeOriginatorNodeConfiguration))));
  }

  /**
   * Test {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <p>Method under test: {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbContext, TbNodeConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbChangeOriginatorNodeConfiguration TbChangeOriginatorNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration3() throws TbNodeException {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setOriginatorSource(OriginatorSource.ENTITY);
    tbChangeOriginatorNodeConfiguration.setRelationsQuery(relationsQuery);
    tbChangeOriginatorNodeConfiguration.setEntityType("foo");
    tbChangeOriginatorNodeConfiguration.setEntityNamePattern(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbChangeOriginatorNode.loadNodeConfiguration(
                ctx, new TbNodeConfiguration(new POJONode(tbChangeOriginatorNodeConfiguration))));
  }

  /**
   * Test {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <p>Method under test: {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbContext, TbNodeConfiguration)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbChangeOriginatorNodeConfiguration TbChangeOriginatorNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration4() throws TbNodeException {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setOriginatorSource(OriginatorSource.RELATED);
    tbChangeOriginatorNodeConfiguration.setRelationsQuery(null);
    tbChangeOriginatorNodeConfiguration.setEntityType("foo");
    tbChangeOriginatorNodeConfiguration.setEntityNamePattern("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbChangeOriginatorNode.loadNodeConfiguration(
                ctx, new TbNodeConfiguration(new POJONode(tbChangeOriginatorNodeConfiguration))));
  }

  /**
   * Test {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbContext, TbNodeConfiguration); given 'CUSTOMER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbChangeOriginatorNodeConfiguration TbChangeOriginatorNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_givenCustomer() throws TbNodeException {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setOriginatorSource(OriginatorSource.CUSTOMER);
    tbChangeOriginatorNodeConfiguration.setRelationsQuery(relationsQuery);
    tbChangeOriginatorNodeConfiguration.setEntityType("foo");
    tbChangeOriginatorNodeConfiguration.setEntityNamePattern("");

    // Act and Assert
    assertSame(
        tbChangeOriginatorNodeConfiguration,
        tbChangeOriginatorNode.loadNodeConfiguration(
            ctx, new TbNodeConfiguration(new POJONode(tbChangeOriginatorNodeConfiguration))));
  }

  /**
   * Test {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code ENTITY}.
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbContext, TbNodeConfiguration); given 'ENTITY'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbChangeOriginatorNodeConfiguration TbChangeOriginatorNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_givenEntity() throws TbNodeException {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setOriginatorSource(OriginatorSource.ENTITY);
    tbChangeOriginatorNodeConfiguration.setRelationsQuery(relationsQuery);
    tbChangeOriginatorNodeConfiguration.setEntityType("foo");
    tbChangeOriginatorNodeConfiguration.setEntityNamePattern("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbChangeOriginatorNode.loadNodeConfiguration(
                ctx, new TbNodeConfiguration(new POJONode(tbChangeOriginatorNodeConfiguration))));
  }

  /**
   * Test {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbChangeOriginatorNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbChangeOriginatorNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbContext, TbNodeConfiguration); then return TbChangeOriginatorNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbChangeOriginatorNodeConfiguration TbChangeOriginatorNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbChangeOriginatorNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbChangeOriginatorNode tbChangeOriginatorNode = new TbChangeOriginatorNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    TbChangeOriginatorNodeConfiguration tbChangeOriginatorNodeConfiguration =
        new TbChangeOriginatorNodeConfiguration();
    tbChangeOriginatorNodeConfiguration.setOriginatorSource(OriginatorSource.RELATED);
    tbChangeOriginatorNodeConfiguration.setRelationsQuery(relationsQuery);
    tbChangeOriginatorNodeConfiguration.setEntityType("foo");
    tbChangeOriginatorNodeConfiguration.setEntityNamePattern("");

    // Act and Assert
    assertSame(
        tbChangeOriginatorNodeConfiguration,
        tbChangeOriginatorNode.loadNodeConfiguration(
            ctx, new TbNodeConfiguration(new POJONode(tbChangeOriginatorNodeConfiguration))));
  }

  /**
   * Test new {@link TbChangeOriginatorNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbChangeOriginatorNode}
   */
  @Test
  @DisplayName("Test new TbChangeOriginatorNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbChangeOriginatorNode.<init>()"})
  void testNewTbChangeOriginatorNode() {
    // Arrange, Act and Assert
    assertNull(new TbChangeOriginatorNode().config);
  }
}
