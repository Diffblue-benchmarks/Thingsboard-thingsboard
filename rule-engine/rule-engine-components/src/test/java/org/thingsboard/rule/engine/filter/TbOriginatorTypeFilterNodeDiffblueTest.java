package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbOriginatorTypeFilterNodeDiffblueTest {
  /**
   * Test {@link TbOriginatorTypeFilterNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@link
   *       POJONode#POJONode(Object)} Data {@link POJONode}.
   * </ul>
   *
   * <p>Method under test: {@link TbOriginatorTypeFilterNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); then TbNodeConfiguration(JsonNode) with data is POJONode(Object) Data POJONode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbOriginatorTypeFilterNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenTbNodeConfigurationWithDataIsPOJONodeDataPOJONode() throws TbNodeException {
    // Arrange
    TbOriginatorTypeFilterNode tbOriginatorTypeFilterNode = new TbOriginatorTypeFilterNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbOriginatorTypeFilterNodeConfiguration tbOriginatorTypeFilterNodeConfiguration =
        new TbOriginatorTypeFilterNodeConfiguration();
    TbNodeConfiguration configuration =
        new TbNodeConfiguration(new POJONode(tbOriginatorTypeFilterNodeConfiguration));

    // Act
    tbOriginatorTypeFilterNode.init(ctx, configuration);

    // Assert
    JsonNode data = configuration.getData();
    assertTrue(data instanceof POJONode);
    Object pojo = ((POJONode) data).getPojo();
    assertTrue(pojo instanceof TbOriginatorTypeFilterNodeConfiguration);
    assertNull(tbOriginatorTypeFilterNode.config.getOriginatorTypes());
    assertSame(tbOriginatorTypeFilterNodeConfiguration, pojo);
  }

  /**
   * Test new {@link TbOriginatorTypeFilterNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link
   * TbOriginatorTypeFilterNode}
   */
  @Test
  @DisplayName("Test new TbOriginatorTypeFilterNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbOriginatorTypeFilterNode.<init>()"})
  void testNewTbOriginatorTypeFilterNode() {
    // Arrange, Act and Assert
    assertNull(new TbOriginatorTypeFilterNode().config);
  }
}
