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
package org.thingsboard.rule.engine.filter;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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

class TbJsFilterNodeDiffblueTest {
  /**
   * Test {@link TbJsFilterNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ScriptEngine}.
   *   <li>Then calls {@link TbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ScriptEngine; then calls createScriptEngine(ScriptLanguage, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsFilterNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenScriptEngine_thenCallsCreateScriptEngine() throws TbNodeException {
    // Arrange
    TbJsFilterNode tbJsFilterNode = new TbJsFilterNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    // Act
    tbJsFilterNode.init(
        ctx, new TbNodeConfiguration(new POJONode(new TbJsFilterNodeConfiguration())));

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
  }

  /**
   * Test {@link TbJsFilterNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code TBEL}.
   *   <li>When {@link TbJsFilterNodeConfiguration} (default constructor) ScriptLang is {@code
   *       TBEL}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'TBEL'; when TbJsFilterNodeConfiguration (default constructor) ScriptLang is 'TBEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsFilterNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenTbel_whenTbJsFilterNodeConfigurationScriptLangIsTbel() throws TbNodeException {
    // Arrange
    TbJsFilterNode tbJsFilterNode = new TbJsFilterNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbJsFilterNodeConfiguration tbJsFilterNodeConfiguration = new TbJsFilterNodeConfiguration();
    tbJsFilterNodeConfiguration.setScriptLang(ScriptLanguage.TBEL);

    // Act
    tbJsFilterNode.init(ctx, new TbNodeConfiguration(new POJONode(tbJsFilterNodeConfiguration)));

    // Assert
    verify(ctx).createScriptEngine(eq(ScriptLanguage.TBEL), isNull(), isA(String[].class));
  }
}
