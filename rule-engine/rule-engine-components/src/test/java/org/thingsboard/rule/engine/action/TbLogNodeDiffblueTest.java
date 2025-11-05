package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
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
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbLogNodeDiffblueTest {
  @Mock private ScriptEngine scriptEngine;

  @InjectMocks private TbLogNode tbLogNode;

  @Mock private TbLogNodeConfiguration tbLogNodeConfiguration;

  /**
   * Test {@link TbLogNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ArrayList() iterator; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenArrayListIterator_thenCallsFields() throws TbNodeException {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbLogNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link POJONode#POJONode(Object)} with v is {@link TbLogNodeConfiguration} (default
   *       constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given POJONode(Object) with v is TbLogNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenPOJONodeWithVIsTbLogNodeConfiguration() throws TbNodeException {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(new TbLogNodeConfiguration()));

    // Act
    tbLogNode.init(ctx, configuration);

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
    verify(configuration).getData();
  }

  /**
   * Test {@link TbLogNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link TbLogNodeConfiguration} (default constructor) ScriptLang is {@code JS}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given TbLogNodeConfiguration (default constructor) ScriptLang is 'JS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenTbLogNodeConfigurationScriptLangIsJs() throws TbNodeException {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();
    tbLogNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbLogNodeConfiguration));

    // Act
    tbLogNode.init(ctx, configuration);

    // Assert
    verify(ctx).createScriptEngine(eq(ScriptLanguage.JS), isNull(), isA(String[].class));
    verify(configuration).getData();
  }

  /**
   * Test {@link TbLogNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link TbLogNodeConfiguration#getJsScript()}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then calls getJsScript()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenCallsGetJsScript() throws TbNodeException {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbLogNodeConfiguration tbLogNodeConfiguration = mock(TbLogNodeConfiguration.class);
    when(tbLogNodeConfiguration.getJsScript()).thenReturn("Js Script");
    when(tbLogNodeConfiguration.getScriptLang()).thenReturn(ScriptLanguage.JS);

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(new POJONode(tbLogNodeConfiguration));

    // Act
    tbLogNode.init(ctx, configuration);

    // Assert
    verify(tbLogNodeConfiguration, atLeast(1)).getJsScript();
    verify(tbLogNodeConfiguration, atLeast(1)).getScriptLang();
    verify(ctx).createScriptEngine(eq(ScriptLanguage.JS), eq("Js Script"), isA(String[].class));
    verify(configuration).getData();
  }

  /**
   * Test {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link TbLogNode} (default constructor).
   *   <li>When {@link TbLogNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(TbContext, TbLogNodeConfiguration); given TbLogNode (default constructor); when TbLogNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScriptEngine TbLogNode.createScriptEngine(TbContext, TbLogNodeConfiguration)"
  })
  void testCreateScriptEngine_givenTbLogNode_whenTbLogNodeConfiguration() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    // Act
    tbLogNode.createScriptEngine(ctx, new TbLogNodeConfiguration());

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code TBEL}.
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is {@code TBEL}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(TbContext, TbLogNodeConfiguration); given 'TBEL'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'TBEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScriptEngine TbLogNode.createScriptEngine(TbContext, TbLogNodeConfiguration)"
  })
  void testCreateScriptEngine_givenTbel_whenTbLogNodeConfigurationScriptLangIsTbel() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbLogNodeConfiguration config = new TbLogNodeConfiguration();
    config.setScriptLang(ScriptLanguage.TBEL);

    // Act
    tbLogNode.createScriptEngine(ctx, config);

    // Assert
    verify(ctx).createScriptEngine(eq(ScriptLanguage.TBEL), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link TbLogNodeConfiguration#getJsScript()}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(TbContext, TbLogNodeConfiguration); then calls getJsScript()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScriptEngine TbLogNode.createScriptEngine(TbContext, TbLogNodeConfiguration)"
  })
  void testCreateScriptEngine_thenCallsGetJsScript() {
    // Arrange
    when(tbLogNodeConfiguration.getJsScript()).thenReturn("Js Script");
    when(tbLogNodeConfiguration.getScriptLang()).thenReturn(ScriptLanguage.JS);

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    // Act
    tbLogNode.createScriptEngine(ctx, tbLogNodeConfiguration);

    // Assert
    verify(tbLogNodeConfiguration).getJsScript();
    verify(tbLogNodeConfiguration, atLeast(1)).getScriptLang();
    verify(ctx).createScriptEngine(eq(ScriptLanguage.JS), eq("Js Script"), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#isStandard(TbLogNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code JS}.
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is {@code JS}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test isStandard(TbLogNodeConfiguration); given 'JS'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'JS'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbLogNode.isStandard(TbLogNodeConfiguration)"})
  void testIsStandard_givenJs_whenTbLogNodeConfigurationScriptLangIsJs_thenReturnFalse() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbLogNodeConfiguration conf = new TbLogNodeConfiguration();
    conf.setScriptLang(ScriptLanguage.JS);

    // Act and Assert
    assertFalse(tbLogNode.isStandard(conf));
  }

  /**
   * Test {@link TbLogNode#isStandard(TbLogNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link TbLogNodeConfiguration} {@link TbLogNodeConfiguration#getJsScript()} return
   *       {@code Js Script}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test isStandard(TbLogNodeConfiguration); given TbLogNodeConfiguration getJsScript() return 'Js Script'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbLogNode.isStandard(TbLogNodeConfiguration)"})
  void testIsStandard_givenTbLogNodeConfigurationGetJsScriptReturnJsScript() {
    // Arrange
    when(tbLogNodeConfiguration.getJsScript()).thenReturn("Js Script");
    when(tbLogNodeConfiguration.getScriptLang()).thenReturn(ScriptLanguage.JS);

    // Act
    boolean actualIsStandardResult = tbLogNode.isStandard(tbLogNodeConfiguration);

    // Assert
    verify(tbLogNodeConfiguration).getJsScript();
    verify(tbLogNodeConfiguration, atLeast(1)).getScriptLang();
    assertFalse(actualIsStandardResult);
  }

  /**
   * Test {@link TbLogNode#isStandard(TbLogNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link TbLogNode} (default constructor).
   *   <li>When {@link TbLogNodeConfiguration} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test isStandard(TbLogNodeConfiguration); given TbLogNode (default constructor); when TbLogNodeConfiguration (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbLogNode.isStandard(TbLogNodeConfiguration)"})
  void testIsStandard_givenTbLogNode_whenTbLogNodeConfiguration_thenReturnFalse() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    // Act and Assert
    assertFalse(tbLogNode.isStandard(new TbLogNodeConfiguration()));
  }

  /**
   * Test {@link TbLogNode#isStandard(TbLogNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code TBEL}.
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is {@code TBEL}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test isStandard(TbLogNodeConfiguration); given 'TBEL'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'TBEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbLogNode.isStandard(TbLogNodeConfiguration)"})
  void testIsStandard_givenTbel_whenTbLogNodeConfigurationScriptLangIsTbel() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbLogNodeConfiguration conf = new TbLogNodeConfiguration();
    conf.setScriptLang(ScriptLanguage.TBEL);

    // Act and Assert
    assertFalse(tbLogNode.isStandard(conf));
  }

  /**
   * Test {@link TbLogNode#isStandard(TbLogNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test isStandard(TbLogNodeConfiguration); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbLogNode.isStandard(TbLogNodeConfiguration)"})
  void testIsStandard_thenReturnTrue() {
    // Arrange
    when(tbLogNodeConfiguration.getJsScript())
        .thenReturn(
            "return '\\nIncoming message:\\n' + JSON.stringify(msg) + '\\nIncoming metadata:\\n' + JSON.stringify"
                + "(metadata);");
    when(tbLogNodeConfiguration.getScriptLang()).thenReturn(ScriptLanguage.JS);

    // Act
    boolean actualIsStandardResult = tbLogNode.isStandard(tbLogNodeConfiguration);

    // Assert
    verify(tbLogNodeConfiguration).getJsScript();
    verify(tbLogNodeConfiguration, atLeast(1)).getScriptLang();
    assertTrue(actualIsStandardResult);
  }

  /**
   * Test {@link TbLogNode#logStandard(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbLogNode} (default constructor).
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#logStandard(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test logStandard(TbContext, TbMsg); given TbLogNode (default constructor); then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.logStandard(TbContext, TbMsg)"})
  void testLogStandard_givenTbLogNode_thenCallsTellSuccess() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbLogNode.logStandard(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbLogNode#toLogMessage(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbLogNode} (default constructor).
   *   <li>Then return {@code Incoming message: {"Key":"null"} Incoming metadata: {}}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#toLogMessage(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toLogMessage(TbMsg); given TbLogNode (default constructor); then return 'Incoming message: {\"Key\":\"null\"} Incoming metadata: {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbLogNode.toLogMessage(TbMsg)"})
  void testToLogMessage_givenTbLogNode_thenReturnIncomingMessageKeyNullIncomingMetadata() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertEquals(
        "\nIncoming message:\n{\"Key\":\"null\"}\nIncoming metadata:\n{}",
        tbLogNode.toLogMessage(msg));
  }

  /**
   * Test {@link TbLogNode#destroy()}.
   *
   * <p>Method under test: {@link TbLogNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.destroy()"})
  void testDestroy() {
    // Arrange
    doNothing().when(scriptEngine).destroy();

    // Act
    tbLogNode.destroy();

    // Assert
    verify(scriptEngine).destroy();
  }
}
