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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.EmptyNodeConfiguration;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.msg.TbMsg;

class TbAckNodeDiffblueTest {
  /**
   * Test {@link TbAckNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@link
   *       POJONode#POJONode(Object)} Data {@link POJONode}.
   * </ul>
   *
   * <p>Method under test: {@link TbAckNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); then TbNodeConfiguration(JsonNode) with data is POJONode(Object) Data POJONode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAckNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenTbNodeConfigurationWithDataIsPOJONodeDataPOJONode() throws TbNodeException {
    // Arrange
    TbAckNode tbAckNode = new TbAckNode();
    TbContext ctx = mock(TbContext.class);
    EmptyNodeConfiguration emptyNodeConfiguration = new EmptyNodeConfiguration();
    TbNodeConfiguration configuration =
        new TbNodeConfiguration(new POJONode(emptyNodeConfiguration));

    // Act
    tbAckNode.init(ctx, configuration);

    // Assert
    JsonNode data = configuration.getData();
    assertTrue(data instanceof POJONode);
    Object pojo = ((POJONode) data).getPojo();
    assertTrue(pojo instanceof EmptyNodeConfiguration);
    assertEquals(0, tbAckNode.config.getVersion());
    assertSame(emptyNodeConfiguration, pojo);
  }

  /**
   * Test {@link TbAckNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbAckNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAckNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    TbAckNode tbAckNode = new TbAckNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).ack(Mockito.<TbMsg>any());
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    // Act
    tbAckNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(ctx).ack(isA(TbMsg.class));
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test new {@link TbAckNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbAckNode}
   */
  @Test
  @DisplayName("Test new TbAckNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAckNode.<init>()"})
  void testNewTbAckNode() {
    // Arrange, Act and Assert
    assertNull(new TbAckNode().config);
  }
}
