package org.thingsboard.rule.engine.filter;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.script.ScriptLanguage;

class TbJsSwitchNodeDiffblueTest {
  /**
   * Test {@link TbJsSwitchNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ScriptEngine}.
   *   <li>Then calls {@link TbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsSwitchNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ScriptEngine; then calls createScriptEngine(ScriptLanguage, String, String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbJsSwitchNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenScriptEngine_thenCallsCreateScriptEngine() throws TbNodeException {
    // Arrange
    TbJsSwitchNode tbJsSwitchNode = new TbJsSwitchNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    // Act
    tbJsSwitchNode.init(
        ctx, new TbNodeConfiguration(new POJONode(new TbJsSwitchNodeConfiguration())));

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbJsSwitchNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code TBEL}.
   *   <li>When {@link TbJsSwitchNodeConfiguration} (default constructor) ScriptLang is {@code
   *       TBEL}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsSwitchNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'TBEL'; when TbJsSwitchNodeConfiguration (default constructor) ScriptLang is 'TBEL'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbJsSwitchNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenTbel_whenTbJsSwitchNodeConfigurationScriptLangIsTbel() throws TbNodeException {
    // Arrange
    TbJsSwitchNode tbJsSwitchNode = new TbJsSwitchNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbJsSwitchNodeConfiguration tbJsSwitchNodeConfiguration = new TbJsSwitchNodeConfiguration();
    tbJsSwitchNodeConfiguration.setScriptLang(ScriptLanguage.TBEL);

    // Act
    tbJsSwitchNode.init(ctx, new TbNodeConfiguration(new POJONode(tbJsSwitchNodeConfiguration)));

    // Assert
    verify(ctx).createScriptEngine(eq(ScriptLanguage.TBEL), isNull(), isA(String[].class));
  }
}
