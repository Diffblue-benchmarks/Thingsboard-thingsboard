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
package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.msg.TbMsg;

class TbTransformMsgNodeDiffblueTest {
  /**
   * Test {@link TbTransformMsgNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code TBEL}.
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test loadNodeConfiguration(TbContext, TbNodeConfiguration); given 'TBEL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbTransformMsgNodeConfiguration TbTransformMsgNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_givenTbel() throws TbNodeException {
    // Arrange
    TbTransformMsgNode tbTransformMsgNode = new TbTransformMsgNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();
    tbTransformMsgNodeConfiguration.setScriptLang(ScriptLanguage.TBEL);

    // Act
    TbTransformMsgNodeConfiguration actualLoadNodeConfigurationResult =
        tbTransformMsgNode.loadNodeConfiguration(
            ctx, new TbNodeConfiguration(new POJONode(tbTransformMsgNodeConfiguration)));

    // Assert
    verify(ctx).createScriptEngine(eq(ScriptLanguage.TBEL), isNull(), isA(String[].class));
    assertSame(tbTransformMsgNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbTransformMsgNode#loadNodeConfiguration(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then return {@link TbTransformMsgNodeConfiguration} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbTransformMsgNode#loadNodeConfiguration(TbContext,
   * TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test loadNodeConfiguration(TbContext, TbNodeConfiguration); then return TbTransformMsgNodeConfiguration (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbTransformMsgNodeConfiguration TbTransformMsgNode.loadNodeConfiguration(TbContext, TbNodeConfiguration)"
  })
  void testLoadNodeConfiguration_thenReturnTbTransformMsgNodeConfiguration()
      throws TbNodeException {
    // Arrange
    TbTransformMsgNode tbTransformMsgNode = new TbTransformMsgNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));
    TbTransformMsgNodeConfiguration tbTransformMsgNodeConfiguration =
        new TbTransformMsgNodeConfiguration();

    // Act
    TbTransformMsgNodeConfiguration actualLoadNodeConfigurationResult =
        tbTransformMsgNode.loadNodeConfiguration(
            ctx, new TbNodeConfiguration(new POJONode(tbTransformMsgNodeConfiguration)));

    // Assert
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
    assertSame(tbTransformMsgNodeConfiguration, actualLoadNodeConfigurationResult);
  }

  /**
   * Test {@link TbTransformMsgNode#transformFailure(TbContext, TbMsg, Throwable)}.
   *
   * <p>Method under test: {@link TbTransformMsgNode#transformFailure(TbContext, TbMsg, Throwable)}
   */
  @Test
  @DisplayName("Test transformFailure(TbContext, TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbTransformMsgNode.transformFailure(TbContext, TbMsg, Throwable)"})
  void testTransformFailure() {
    // Arrange
    TbTransformMsgNode tbTransformMsgNode = new TbTransformMsgNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).logJsEvalFailure();
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg = mock(TbMsg.class);

    // Act
    tbTransformMsgNode.transformFailure(ctx, msg, new Throwable());

    // Assert
    verify(ctx).logJsEvalFailure();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test new {@link TbTransformMsgNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbTransformMsgNode}
   */
  @Test
  @DisplayName("Test new TbTransformMsgNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbTransformMsgNode.<init>()"})
  void testNewTbTransformMsgNode() {
    // Arrange, Act and Assert
    assertNull(new TbTransformMsgNode().config);
  }
}
