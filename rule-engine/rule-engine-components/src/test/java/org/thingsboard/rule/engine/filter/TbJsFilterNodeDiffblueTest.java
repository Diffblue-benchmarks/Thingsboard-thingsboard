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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbJsFilterNodeDiffblueTest {
  @Mock private ScriptEngine scriptEngine;

  @InjectMocks private TbJsFilterNode tbJsFilterNode;

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

  /**
   * Test {@link TbJsFilterNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#createScriptEngine(ScriptLanguage, String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); then calls createScriptEngine(ScriptLanguage, String, String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsFilterNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenCallsCreateScriptEngine() throws TbNodeException {
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
   * Test {@link TbJsFilterNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ListenableFutureTask addListener(Runnable, Executor) does nothing; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsFilterNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListenableFutureTaskAddListenerDoesNothing_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Boolean> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Boolean> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Boolean> apiFuture = new ForwardingApiFuture<>(delegate2);
    when(scriptEngine.executeFilterAsync(Mockito.<TbMsg>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    doNothing().when(ctx).logJsEvalRequest();

    // Act
    tbJsFilterNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(scriptEngine).executeFilterAsync(isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).logJsEvalRequest();
  }

  /**
   * Test {@link TbJsFilterNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link TbJsFilterNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ListenableFutureTask addListener(Runnable, Executor) does nothing; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsFilterNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListenableFutureTaskAddListenerDoesNothing_thenCallsAddListener2() {
    // Arrange
    ListenableFutureTask<Boolean> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Boolean> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Boolean> apiFuture = new ForwardingApiFuture<>(delegate2);
    when(scriptEngine.executeFilterAsync(Mockito.<TbMsg>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(null);
    doNothing().when(ctx).logJsEvalRequest();

    // Act
    tbJsFilterNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(scriptEngine).executeFilterAsync(isA(TbMsg.class));
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).logJsEvalRequest();
  }

  /**
   * Test {@link TbJsFilterNode#destroy()}.
   *
   * <p>Method under test: {@link TbJsFilterNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbJsFilterNode.destroy()"})
  void testDestroy() {
    // Arrange
    doNothing().when(scriptEngine).destroy();

    // Act
    tbJsFilterNode.destroy();

    // Assert
    verify(scriptEngine).destroy();
  }
}
