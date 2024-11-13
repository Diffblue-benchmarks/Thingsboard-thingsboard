package org.thingsboard.rule.engine.sms;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;

class TbSendSmsNodeDiffblueTest {
  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link BigIntegerNode#BigIntegerNode(BigInteger)} with v is valueOf
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given 'false'; when BigIntegerNode(BigInteger) with v is valueOf one")
  void testInitWithCtxConfiguration_givenFalse_whenBigIntegerNodeWithVIsValueOfOne() throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(false);

    // Act and Assert
    assertThrows(TbNodeException.class,
        () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(new BigIntegerNode(BigInteger.valueOf(1L)))));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>When {@link BinaryNode#BinaryNode(byte[])} with data is {@code AXAXAXAX}
   * Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when BinaryNode(byte[]) with data is 'AXAXAXAX' Bytes is 'UTF-8'")
  void testInitWithCtxConfiguration_whenBinaryNodeWithDataIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException, TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(false);

    // Act and Assert
    assertThrows(TbNodeException.class,
        () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(new BinaryNode("AXAXAXAX".getBytes("UTF-8")))));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data
   * is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendSmsNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbNodeConfiguration(JsonNode) with data is Instance")
  void testInitWithCtxConfiguration_whenTbNodeConfigurationWithDataIsInstance() throws TbNodeException {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(TbNodeException.class,
        () -> tbSendSmsNode.init(ctx, new TbNodeConfiguration(MissingNode.getInstance())));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TbContext} {@link TbContext#getSmsExecutor()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given 'null'; when TbContext getSmsExecutor() return 'null'")
  void testOnMsg_givenNull_whenTbContextGetSmsExecutorReturnNull() {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(null);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbSendSmsNode.onMsg(ctx, null);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendSmsNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given TestDbCallbackExecutor (default constructor)")
  void testOnMsg_givenTestDbCallbackExecutor() {
    // Arrange
    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSmsExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbSendSmsNode.onMsg(ctx, null);

    // Assert
    verify(ctx).getSmsExecutor();
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendSmsNode#destroy()}.
   * <ul>
   *   <li>Then calls {@link TbContext#isExternalNodeForceAck()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendSmsNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); then calls isExternalNodeForceAck()")
  void testDestroy_thenCallsIsExternalNodeForceAck() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbSendSmsNode tbSendSmsNode = new TbSendSmsNode();
    tbSendSmsNode.init(ctx);

    // Act
    tbSendSmsNode.destroy();

    // Assert that nothing has changed
    verify(ctx).isExternalNodeForceAck();
  }
}
