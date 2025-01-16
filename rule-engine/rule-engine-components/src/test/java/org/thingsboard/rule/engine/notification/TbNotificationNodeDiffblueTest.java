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

class TbNotificationNodeDiffblueTest {
  /**
   * Test {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Then calls {@link TbContext#isExternalNodeForceAck()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then calls isExternalNodeForceAck()")
  void testInitWithCtxConfiguration_thenCallsIsExternalNodeForceAck() throws TbNodeException {
    // Arrange
    TbNotificationNode tbNotificationNode = new TbNotificationNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act
    tbNotificationNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance()));

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data
   * is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbNodeConfiguration(JsonNode) with data is 'null'")
  void testInitWithCtxConfiguration_whenTbNodeConfigurationWithDataIsNull() throws TbNodeException {
    // Arrange
    TbNotificationNode tbNotificationNode = new TbNotificationNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act
    tbNotificationNode.init(ctx, new TbNodeConfiguration(null));

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }
}
