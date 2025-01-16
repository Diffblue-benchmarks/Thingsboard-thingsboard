package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertNull;
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
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.msg.TbMsg;

class TbTransformMsgNodeDiffblueTest {
  /**
   * Test
   * {@link TbTransformMsgNode#transformFailure(TbContext, TbMsg, Throwable)}.
   * <p>
   * Method under test:
   * {@link TbTransformMsgNode#transformFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test transformFailure(TbContext, TbMsg, Throwable)")
  void testTransformFailure() {
    // Arrange
    TbTransformMsgNode tbTransformMsgNode = new TbTransformMsgNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).logJsEvalFailure();
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbTransformMsgNode.transformFailure(ctx, null, new Throwable());

    // Assert
    verify(ctx).logJsEvalFailure();
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test {@link TbTransformMsgNode#destroy()}.
   * <ul>
   *   <li>Given {@link ScriptEngine} {@link ScriptEngine#destroy()} does
   * nothing.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTransformMsgNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given ScriptEngine destroy() does nothing; then calls fields()")
  void testDestroy_givenScriptEngineDestroyDoesNothing_thenCallsFields() throws TbNodeException {
    // Arrange
    ScriptEngine scriptEngine = mock(ScriptEngine.class);
    doNothing().when(scriptEngine).destroy();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(scriptEngine);
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);
    TbNodeConfiguration configuration = new TbNodeConfiguration(data);

    TbTransformMsgNode tbTransformMsgNode = new TbTransformMsgNode();
    tbTransformMsgNode.loadNodeConfiguration(ctx, configuration);

    // Act
    tbTransformMsgNode.destroy();

    // Assert that nothing has changed
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(scriptEngine).destroy();
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
  }

  /**
   * Test new {@link TbTransformMsgNode} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link TbTransformMsgNode}
   */
  @Test
  @DisplayName("Test new TbTransformMsgNode (default constructor)")
  void testNewTbTransformMsgNode() {
    // Arrange, Act and Assert
    assertNull((new TbTransformMsgNode()).config);
  }
}
