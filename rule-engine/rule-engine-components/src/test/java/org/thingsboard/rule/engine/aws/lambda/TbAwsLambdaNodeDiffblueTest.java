package org.thingsboard.rule.engine.aws.lambda;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.exception.DataValidationException;

class TbAwsLambdaNodeDiffblueTest {
  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration() throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf())
        .thenReturn(
            new RuleNode(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbAwsLambdaNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowDataValidationException() throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> tbAwsLambdaNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when POJONode(Object) with v is 'null'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenPOJONodeWithVIsNull_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbAwsLambdaNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@link TbAwsLambdaNodeConfiguration}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when POJONode(Object) with v is TbAwsLambdaNodeConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAwsLambdaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenPOJONodeWithVIsTbAwsLambdaNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbAwsLambdaNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbAwsLambdaNodeConfiguration()))));
    verify(ctx).getSelf();
  }
}
