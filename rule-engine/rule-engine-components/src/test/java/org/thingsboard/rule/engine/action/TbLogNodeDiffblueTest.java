/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import com.fasterxml.jackson.databind.node.POJONode;
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
import org.thingsboard.server.common.msg.TbMsgMetaData;

@ExtendWith(MockitoExtension.class)
class TbLogNodeDiffblueTest {
  @Mock private ScriptEngine scriptEngine;

  @InjectMocks private TbLogNode tbLogNode;

  @Mock private TbLogNodeConfiguration tbLogNodeConfiguration;

  /**
   * Test {@link TbLogNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code JS}.
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is {@code JS}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'JS'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'JS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenJs_whenTbLogNodeConfigurationScriptLangIsJs() throws TbNodeException {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();
    tbLogNodeConfiguration.setScriptLang(ScriptLanguage.JS);

    // Act
    tbLogNode.init(ctx, new TbNodeConfiguration(new POJONode(tbLogNodeConfiguration)));

    // Assert
    verify(ctx).createScriptEngine(eq(ScriptLanguage.JS), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code TBEL}.
   *   <li>When {@link TbLogNodeConfiguration} (default constructor) ScriptLang is {@code TBEL}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'TBEL'; when TbLogNodeConfiguration (default constructor) ScriptLang is 'TBEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenTbel_whenTbLogNodeConfigurationScriptLangIsTbel() throws TbNodeException {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbLogNodeConfiguration tbLogNodeConfiguration = new TbLogNodeConfiguration();
    tbLogNodeConfiguration.setScriptLang(ScriptLanguage.TBEL);

    // Act
    tbLogNode.init(ctx, new TbNodeConfiguration(new POJONode(tbLogNodeConfiguration)));

    // Assert
    verify(ctx).createScriptEngine(eq(ScriptLanguage.TBEL), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@link TbLogNodeConfiguration} (default
   *       constructor).
   *   <li>Then calls {@link TbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when POJONode(Object) with v is TbLogNodeConfiguration (default constructor); then calls createScriptEngine(ScriptLanguage, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenPOJONodeWithVIsTbLogNodeConfiguration_thenCallsCreateScriptEngine()
      throws TbNodeException {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    // Act
    tbLogNode.init(ctx, new TbNodeConfiguration(new POJONode(new TbLogNodeConfiguration())));

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link TbLogNodeConfiguration} {@link TbLogNodeConfiguration#getScriptLang()}
   *       return {@code JS}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(TbContext, TbLogNodeConfiguration); given TbLogNodeConfiguration getScriptLang() return 'JS'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScriptEngine TbLogNode.createScriptEngine(TbContext, TbLogNodeConfiguration)"
  })
  void testCreateScriptEngine_givenTbLogNodeConfigurationGetScriptLangReturnJs() {
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

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbLogNode.logStandard(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbLogNode#toLogMessage(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbLogNode} (default constructor).
   *   <li>Then return {@code Incoming message: Data Incoming metadata: {}}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#toLogMessage(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toLogMessage(TbMsg); given TbLogNode (default constructor); then return 'Incoming message: Data Incoming metadata: {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbLogNode.toLogMessage(TbMsg)"})
  void testToLogMessage_givenTbLogNode_thenReturnIncomingMessageDataIncomingMetadata() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    String actualToLogMessageResult = tbLogNode.toLogMessage(msg);

    // Assert
    verify(msg).getData();
    verify(msg).getMetaData();
    assertEquals("\nIncoming message:\nData\nIncoming metadata:\n{}", actualToLogMessageResult);
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
