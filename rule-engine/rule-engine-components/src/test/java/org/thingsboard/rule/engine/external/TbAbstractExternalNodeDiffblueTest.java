package org.thingsboard.rule.engine.external;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.aws.lambda.TbAwsLambdaNode;

class TbAbstractExternalNodeDiffblueTest {
  /**
   * Test {@link TbAbstractExternalNode#init(TbContext)} with {@code ctx}.
   *
   * <p>Method under test: {@link TbAbstractExternalNode#init(TbContext)}
   */
  @Test
  @DisplayName("Test init(TbContext) with 'ctx'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbAbstractExternalNode.init(TbContext)"})
  void testInitWithCtx() {
    // Arrange
    TbAwsLambdaNode tbAwsLambdaNode = new TbAwsLambdaNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act
    tbAwsLambdaNode.init(ctx);

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }
}
