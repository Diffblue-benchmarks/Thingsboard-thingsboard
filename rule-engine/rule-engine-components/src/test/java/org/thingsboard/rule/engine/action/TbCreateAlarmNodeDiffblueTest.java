package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.script.ScriptLanguage;

class TbCreateAlarmNodeDiffblueTest {
  /**
   * Test {@link TbCreateAlarmNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then throw TbNodeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCreateAlarmNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbCreateAlarmNode tbCreateAlarmNode = new TbCreateAlarmNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        TbNodeException.class, () -> tbCreateAlarmNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbCreateAlarmNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCreateAlarmNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbCreateAlarmNode tbCreateAlarmNode = new TbCreateAlarmNode();
    TbContext ctx = mock(TbContext.class);
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbCreateAlarmNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).asToken();
  }

  /**
   * Test {@link TbCreateAlarmNode#loadAlarmNodeConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>Then return AlarmDetailsBuildJs is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNode#loadAlarmNodeConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadAlarmNodeConfig(TbNodeConfiguration); given 'START_OBJECT'; then return AlarmDetailsBuildJs is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbCreateAlarmNodeConfiguration TbCreateAlarmNode.loadAlarmNodeConfig(TbNodeConfiguration)"
  })
  void testLoadAlarmNodeConfig_givenStartObject_thenReturnAlarmDetailsBuildJsIsNull()
      throws TbNodeException {
    // Arrange
    TbCreateAlarmNode tbCreateAlarmNode = new TbCreateAlarmNode();
    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    TbCreateAlarmNodeConfiguration actualLoadAlarmNodeConfigResult =
        tbCreateAlarmNode.loadAlarmNodeConfig(new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    assertNull(actualLoadAlarmNodeConfigResult.getAlarmDetailsBuildJs());
    assertNull(actualLoadAlarmNodeConfigResult.getAlarmDetailsBuildTbel());
    assertNull(actualLoadAlarmNodeConfigResult.getAlarmType());
    assertNull(actualLoadAlarmNodeConfigResult.getSeverity());
    assertNull(actualLoadAlarmNodeConfigResult.getRelationTypes());
    assertNull(actualLoadAlarmNodeConfigResult.getScriptLang());
    assertFalse(actualLoadAlarmNodeConfigResult.isDynamicSeverity());
    assertFalse(actualLoadAlarmNodeConfigResult.isPropagate());
    assertFalse(actualLoadAlarmNodeConfigResult.isPropagateToOwner());
    assertFalse(actualLoadAlarmNodeConfigResult.isPropagateToTenant());
    assertFalse(actualLoadAlarmNodeConfigResult.isUseMessageAlarmData());
    assertTrue(actualLoadAlarmNodeConfigResult.isOverwriteAlarmDetails());
  }

  /**
   * Test {@link TbCreateAlarmNode#loadAlarmNodeConfig(TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbCreateAlarmNode#loadAlarmNodeConfig(TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadAlarmNodeConfig(TbNodeConfiguration); then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbCreateAlarmNodeConfiguration TbCreateAlarmNode.loadAlarmNodeConfig(TbNodeConfiguration)"
  })
  void testLoadAlarmNodeConfig_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbCreateAlarmNode tbCreateAlarmNode = new TbCreateAlarmNode();
    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbCreateAlarmNode.loadAlarmNodeConfig(new TbNodeConfiguration(data)));
    verify(data).asToken();
  }

  /**
   * Test new {@link TbCreateAlarmNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbCreateAlarmNode}
   */
  @Test
  @DisplayName("Test new TbCreateAlarmNode (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbCreateAlarmNode.<init>()"})
  void testNewTbCreateAlarmNode() {
    // Arrange, Act and Assert
    assertNull(new TbCreateAlarmNode().config);
  }
}
