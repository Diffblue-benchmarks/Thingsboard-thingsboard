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
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsgMetaData;

class TbLogNodeDiffblueTest {
  /**
   * Test {@link TbLogNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code START_OBJECT}.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; when ArrayNode asToken() return 'START_OBJECT'; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_whenArrayNodeAsTokenReturnStartObject_thenCallsFields()
      throws TbNodeException {
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
   *   <li>When {@link TbLogNodeConfiguration} (default constructor).
   *   <li>Then calls {@link TbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#createScriptEngine(TbContext, TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test createScriptEngine(TbContext, TbLogNodeConfiguration); when TbLogNodeConfiguration (default constructor); then calls createScriptEngine(ScriptLanguage, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScriptEngine TbLogNode.createScriptEngine(TbContext, TbLogNodeConfiguration)"
  })
  void testCreateScriptEngine_whenTbLogNodeConfiguration_thenCallsCreateScriptEngine() {
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
   *   <li>When {@link TbLogNodeConfiguration} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#isStandard(TbLogNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test isStandard(TbLogNodeConfiguration); when TbLogNodeConfiguration (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbLogNode.isStandard(TbLogNodeConfiguration)"})
  void testIsStandard_whenTbLogNodeConfiguration_thenReturnFalse() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    // Act and Assert
    assertFalse(tbLogNode.isStandard(new TbLogNodeConfiguration()));
  }

  /**
   * Test {@link TbLogNode#logStandard(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Key} is {@code 42}.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#logStandard(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test logStandard(TbContext, TbMsg); given TbMsgMetaData() Value 'Key' is '42'; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.logStandard(TbContext, TbMsg)"})
  void testLogStandard_givenTbMsgMetaDataValueKeyIs42_thenCallsTellSuccess() {
    // Arrange
    TbLogNode tbLogNode = new TbLogNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbLogNode.logStandard(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbLogNode#logStandard(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()}.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#logStandard(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test logStandard(TbContext, TbMsg); given TbMsgMetaData(); then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbLogNode.logStandard(TbContext, TbMsg)"})
  void testLogStandard_givenTbMsgMetaData_thenCallsTellSuccess() {
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
   *   <li>Then return {@code Incoming message: Data Incoming metadata: {}}.
   * </ul>
   *
   * <p>Method under test: {@link TbLogNode#toLogMessage(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toLogMessage(TbMsg); then return 'Incoming message: Data Incoming metadata: {}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbLogNode.toLogMessage(TbMsg)"})
  void testToLogMessage_thenReturnIncomingMessageDataIncomingMetadata() {
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
}
