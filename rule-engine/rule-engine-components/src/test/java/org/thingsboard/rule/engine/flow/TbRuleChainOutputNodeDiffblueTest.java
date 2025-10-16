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
package org.thingsboard.rule.engine.flow;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.common.msg.TbMsg;

class TbRuleChainOutputNodeDiffblueTest {
  /**
   * Test {@link TbRuleChainOutputNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()}.
   *   <li>When {@link TbContext} {@link TbContext#getSelf()} return {@link RuleNode#RuleNode()}.
   *   <li>Then calls {@link TbContext#getSelf()}.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainOutputNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuleNode(); when TbContext getSelf() return RuleNode(); then calls getSelf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRuleChainOutputNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuleNode_whenTbContextGetSelfReturnRuleNode_thenCallsGetSelf() {
    // Arrange
    TbRuleChainOutputNode tbRuleChainOutputNode = new TbRuleChainOutputNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).output(Mockito.<TbMsg>any(), Mockito.<String>any());
    when(ctx.getSelf()).thenReturn(new RuleNode());

    // Act
    tbRuleChainOutputNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(ctx).getSelf();
    verify(ctx).output(isA(TbMsg.class), isNull());
  }
}
