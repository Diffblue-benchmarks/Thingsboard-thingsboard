package org.thingsboard.rule.engine.mail;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;

class TbSendEmailNodeDiffblueTest {
  /**
   * Test {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then calls {@link JsonNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenCallsAsToken() throws TbNodeException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    JsonNode data = mock(JsonNode.class);
    when(data.fields()).thenThrow(new IllegalStateException());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        IllegalStateException.class,
        () -> tbSendEmailNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).fields();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then calls {@link ArrayNode#isPojo()}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then calls isPojo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenCallsIsPojo() throws TbNodeException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isPojo()).thenThrow(new IllegalStateException());
    when(arrayNode.asToken()).thenReturn(JsonToken.VALUE_EMBEDDED_OBJECT);
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    when(arrayNode.addObject()).thenReturn(new ObjectNode(nc));
    arrayNode.addObject();

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbSendEmailNode.init(ctx, configuration));
    verify(arrayNode).isPojo();
    verify(arrayNode).addObject();
    verify(arrayNode, atLeast(1)).asToken();
    verify(ctx).isExternalNodeForceAck();
    verify(configuration).getData();
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbSendEmailNode} (default constructor).
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbSendEmailNode (default constructor); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbSendEmailNode_thenCallsTellFailure() {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbSendEmailNode} (default constructor).
   *   <li>When {@code null}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbSendEmailNode (default constructor); when 'null'; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbSendEmailNode_whenNull_thenCallsTellFailure() {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbSendEmailNode.onMsg(ctx, null);

    // Assert
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }
}
