package org.thingsboard.rule.engine.mail;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbSendEmailNodeDiffblueTest {
  /**
   * Test {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given 'START_OBJECT'; then calls fields()")
  void testInitWithCtxConfiguration_givenStartObject_thenCallsFields() throws TbNodeException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    JsonNode data = mock(JsonNode.class);
    when(data.fields()).thenThrow(new IllegalStateException("foo"));
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbSendEmailNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).fields();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)} with
   * {@code ctx}, {@code configuration}.
   * <ul>
   *   <li>Given {@code VALUE_EMBEDDED_OBJECT}.</li>
   *   <li>Then calls {@link JsonNode#isPojo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbSendEmailNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given 'VALUE_EMBEDDED_OBJECT'; then calls isPojo()")
  void testInitWithCtxConfiguration_givenValueEmbeddedObject_thenCallsIsPojo() throws TbNodeException {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    JsonNode data = mock(JsonNode.class);
    when(data.isPojo()).thenThrow(new IllegalStateException("foo"));
    when(data.asToken()).thenReturn(JsonToken.VALUE_EMBEDDED_OBJECT);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbSendEmailNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data, atLeast(1)).asToken();
    verify(data).isPojo();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbSendEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given IllegalStateException(String) with 'foo'; then throw IllegalStateException")
  void testOnMsg_givenIllegalStateExceptionWithFoo_thenThrowIllegalStateException() {
    // Arrange
    TbSendEmailNode tbSendEmailNode = new TbSendEmailNode();
    TbContext ctx = mock(TbContext.class);
    doThrow(new IllegalStateException("foo")).when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbSendEmailNode.onMsg(ctx, null));
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSendEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) does nothing")
  void testOnMsg_whenTbContextTellFailureDoesNothing() {
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
