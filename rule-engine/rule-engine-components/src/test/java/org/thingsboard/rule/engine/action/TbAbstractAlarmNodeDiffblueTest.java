package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.MissingNode;
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

class TbAbstractAlarmNodeDiffblueTest {
  /**
   * Test {@link TbAbstractAlarmNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>Then {@link TbClearAlarmNode} (default constructor)
   * {@link TbAbstractAlarmNode#config} AlarmDetailsBuildJs is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbAbstractAlarmNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then TbClearAlarmNode (default constructor) config AlarmDetailsBuildJs is 'null'")
  void testInit_givenStartObject_thenTbClearAlarmNodeConfigAlarmDetailsBuildJsIsNull() throws TbNodeException {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbClearAlarmNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration = tbClearAlarmNode.config;
    assertNull(tbClearAlarmNodeConfiguration.getAlarmDetailsBuildJs());
    assertNull(tbClearAlarmNodeConfiguration.getAlarmDetailsBuildTbel());
    assertNull(tbClearAlarmNodeConfiguration.getAlarmType());
    assertNull(tbClearAlarmNodeConfiguration.getScriptLang());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   * <p>
   * Method under test:
   * {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName("Test buildAlarmDetails(TbMsg, JsonNode)")
  void testBuildAlarmDetails() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    // Act and Assert
    assertTrue(tbClearAlarmNode.buildAlarmDetails(null, MissingNode.getInstance()).isDone());
  }
}
