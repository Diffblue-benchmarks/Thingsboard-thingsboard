package org.thingsboard.rule.engine.notification;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbSlackNodeDiffblueTest {
  /**
   * Test {@link TbSlackNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link TbContext#isExternalNodeForceAck()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSlackNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given 'true'; then calls isExternalNodeForceAck()")
  void testInitWithCtxConfiguration_givenTrue_thenCallsIsExternalNodeForceAck() throws TbNodeException {
    // Arrange
    TbSlackNode tbSlackNode = new TbSlackNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act
    tbSlackNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance()));

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }
}
