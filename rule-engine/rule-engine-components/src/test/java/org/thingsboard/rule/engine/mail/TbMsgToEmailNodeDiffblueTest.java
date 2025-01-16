package org.thingsboard.rule.engine.mail;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;

class TbMsgToEmailNodeDiffblueTest {
  /**
   * Test {@link TbMsgToEmailNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code START_OBJECT}.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbMsgToEmailNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; when ArrayNode asToken() return 'START_OBJECT'; then calls fields()")
  void testInit_givenStartObject_whenArrayNodeAsTokenReturnStartObject_thenCallsFields() throws TbNodeException {
    // Arrange
    TbMsgToEmailNode tbMsgToEmailNode = new TbMsgToEmailNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbMsgToEmailNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() {
    // Arrange
    TbMsgToEmailNode tbMsgToEmailNode = new TbMsgToEmailNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbMsgToEmailNode.onMsg(ctx, null);

    // Assert
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }
}
