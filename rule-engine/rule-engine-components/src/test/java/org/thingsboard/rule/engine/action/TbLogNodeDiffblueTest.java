package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.eq;
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

class TbLogNodeDiffblueTest {
  /**
   * Test {@link TbLogNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code START_OBJECT}.</li>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code START_OBJECT}.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; when ArrayNode asToken() return 'START_OBJECT'; then calls fields()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbLogNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_whenArrayNodeAsTokenReturnStartObject_thenCallsFields() throws TbNodeException {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
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
   * Test {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code TBEL}.</li>
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is {@code TBEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test createScriptEngine(TbContext, TbLogNodeConfiguration); given 'TBEL'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'TBEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ScriptEngine TbLogNode.createScriptEngine(TbContext, TbLogNodeConfiguration)"})
  void testCreateScriptEngine_givenTbel_whenTbLogNodeConfigurationScriptLangIsTbel() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
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
   * <ul>
   *   <li>When {@link TbLogNodeConfiguration} (default constructor).</li>
   *   <li>Then calls {@link TbContext#createScriptEngine(ScriptLanguage, String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test createScriptEngine(TbContext, TbLogNodeConfiguration); when TbLogNodeConfiguration (default constructor); then calls createScriptEngine(ScriptLanguage, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ScriptEngine TbLogNode.createScriptEngine(TbContext, TbLogNodeConfiguration)"})
  void testCreateScriptEngine_whenTbLogNodeConfiguration_thenCallsCreateScriptEngine() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    // Act
    tbLogNode.createScriptEngine(ctx, new TbLogNodeConfiguration());

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#isStandard(TbLogNodeConfiguration)}.
   * <ul>
   *   <li>Given {@code JS}.</li>
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is {@code JS}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test isStandard(TbLogNodeConfiguration); given 'JS'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'JS'; then return 'false'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@code TBEL}.</li>
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is {@code TBEL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test isStandard(TbLogNodeConfiguration); given 'TBEL'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'TBEL'")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>When {@link TbLogNodeConfiguration} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName("Test isStandard(TbLogNodeConfiguration); when TbLogNodeConfiguration (default constructor); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbLogNode.isStandard(TbLogNodeConfiguration)"})
  void testIsStandard_whenTbLogNodeConfiguration_thenReturnFalse() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    // Act and Assert
    assertFalse(tbLogNode.isStandard(new TbLogNodeConfiguration()));
  }
}
