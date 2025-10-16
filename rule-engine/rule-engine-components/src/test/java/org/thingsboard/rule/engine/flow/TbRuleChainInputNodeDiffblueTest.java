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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.msg.TbMsg;

class TbRuleChainInputNodeDiffblueTest {
  /**
   * Test {@link TbRuleChainInputNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link TbRuleChainInputNodeConfiguration} (default constructor) RuleChainId is
   *       {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'foo'; when TbRuleChainInputNodeConfiguration (default constructor) RuleChainId is 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRuleChainInputNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenFoo_whenTbRuleChainInputNodeConfigurationRuleChainIdIsFoo()
      throws TbNodeException {
    // Arrange
    TbRuleChainInputNode tbRuleChainInputNode = new TbRuleChainInputNode();
    TbContext ctx = mock(TbContext.class);

    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();
    tbRuleChainInputNodeConfiguration.setRuleChainId("foo");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbRuleChainInputNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbRuleChainInputNodeConfiguration))));
  }

  /**
   * Test {@link TbRuleChainInputNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbRuleChainInputNodeConfiguration} (default constructor) RuleChainId is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'null'; when TbRuleChainInputNodeConfiguration (default constructor) RuleChainId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRuleChainInputNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenNull_whenTbRuleChainInputNodeConfigurationRuleChainIdIsNull()
      throws TbNodeException {
    // Arrange
    TbRuleChainInputNode tbRuleChainInputNode = new TbRuleChainInputNode();
    TbContext ctx = mock(TbContext.class);

    TbRuleChainInputNodeConfiguration tbRuleChainInputNodeConfiguration =
        new TbRuleChainInputNodeConfiguration();
    tbRuleChainInputNodeConfiguration.setRuleChainId(null);

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbRuleChainInputNode.init(
                ctx, new TbNodeConfiguration(new POJONode(tbRuleChainInputNodeConfiguration))));
  }

  /**
   * Test {@link TbRuleChainInputNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbRuleChainInputNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbRuleChainInputNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() throws TbNodeException {
    // Arrange
    TbRuleChainInputNode tbRuleChainInputNode = new TbRuleChainInputNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).input(Mockito.<TbMsg>any(), Mockito.<RuleChainId>any());

    // Act
    tbRuleChainInputNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(ctx).input(isA(TbMsg.class), isNull());
  }

  /**
   * Test {@link TbRuleChainInputNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbRuleChainInputNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbRuleChainInputNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenOne_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbRuleChainInputNode().upgrade(1, oldConfiguration).getSecond());
  }
}
