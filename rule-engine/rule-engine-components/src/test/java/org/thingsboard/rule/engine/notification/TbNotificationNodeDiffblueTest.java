package org.thingsboard.rule.engine.notification;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbNotificationNodeDiffblueTest {
  /**
   * Test {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when POJONode(Object) with v is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbNotificationNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenPOJONodeWithVIsNull() throws TbNodeException {
    // Arrange
    TbNotificationNode tbNotificationNode = new TbNotificationNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act
    tbNotificationNode.init(ctx, new TbNodeConfiguration(new POJONode(null)));

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@link TbNotificationNodeConfiguration}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when POJONode(Object) with v is TbNotificationNodeConfiguration (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbNotificationNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenPOJONodeWithVIsTbNotificationNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbNotificationNode tbNotificationNode = new TbNotificationNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act
    tbNotificationNode.init(
        ctx, new TbNodeConfiguration(new POJONode(new TbNotificationNodeConfiguration())));

    // Assert
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is Instance.
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbNodeConfiguration(JsonNode) with data is Instance")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbNotificationNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenTbNodeConfigurationWithDataIsInstance()
      throws TbNodeException {
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
   * Test {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbNotificationNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbNodeConfiguration(JsonNode) with data is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbNotificationNode.init(TbContext, TbNodeConfiguration)"})
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
