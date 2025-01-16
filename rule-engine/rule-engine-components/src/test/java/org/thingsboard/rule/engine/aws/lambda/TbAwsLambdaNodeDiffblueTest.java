package org.thingsboard.rule.engine.aws.lambda;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.exception.DataValidationException;

class TbAwsLambdaNodeDiffblueTest {
  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given RuleNodeId(UUID) with id is randomUUID")
  void testInitWithCtxConfiguration_givenRuleNodeIdWithIdIsRandomUUID() throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(new RuleNode(new RuleNodeId(UUID.randomUUID())));

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbAwsLambdaNode.init(ctx, new TbNodeConfiguration(null)));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()}.</li>
   *   <li>Then throw {@link TbNodeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given RuleNode(); then throw TbNodeException")
  void testInitWithCtxConfiguration_givenRuleNode_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(new RuleNode());

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbAwsLambdaNode.init(ctx, new TbNodeConfiguration(null)));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAwsLambdaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw DataValidationException")
  void testInitWithCtxConfiguration_thenThrowDataValidationException() throws TbNodeException {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> tbAwsLambdaNode.init(ctx, new TbNodeConfiguration(null)));
    verify(ctx).getSelf();
  }

  /**
   * Test {@link TbAwsLambdaNode#destroy()}.
   * <ul>
   *   <li>Then calls {@link TbContext#isExternalNodeForceAck()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); then calls isExternalNodeForceAck()")
  void testDestroy_thenCallsIsExternalNodeForceAck() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    tbAwsLambdaNode.init(ctx);

    // Act
    tbAwsLambdaNode.destroy();

    // Assert that nothing has changed
    verify(ctx).isExternalNodeForceAck();
  }
}
