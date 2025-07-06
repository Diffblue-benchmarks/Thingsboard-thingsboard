package org.thingsboard.rule.engine.sms;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;

class TbSendSmsNodeDiffblueTest {
  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link BinaryNode#BinaryNode(byte[])} with data is {@code AXAXAXAX} Bytes is {@code
   *       UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when BinaryNode(byte[]) with data is 'AXAXAXAX' Bytes is 'UTF-8'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenBinaryNodeWithDataIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbSendSmsNode.init(
                ctx, new TbNodeConfiguration(new BinaryNode("AXAXAXAX".getBytes("UTF-8")))));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code 42}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when POJONode(Object) with v is '42'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenPOJONodeWithVIs42_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(new POJONode("42"))));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is False.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbNodeConfiguration(JsonNode) with data is False")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenTbNodeConfigurationWithDataIsFalse()
      throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(BooleanNode.getFalse())));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbNodeConfiguration(JsonNode) with data is valueOf ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbSendSmsNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenTbNodeConfigurationWithDataIsValueOfTen()
      throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(DoubleNode.valueOf(10.0d))));
    verify(ctx).isExternalNodeForceAck();
  }
}
