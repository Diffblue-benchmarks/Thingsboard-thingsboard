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
package org.thingsboard.rule.engine.mqtt;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.mqtt.MqttClientConfig;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNode;

class TbMqttNodeDiffblueTest {
  /**
   * Test {@link TbMqttNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMqttNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenThrow(new RuntimeException());
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbMqttNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMqttNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new RuntimeException());
    when(ctx.isExternalNodeForceAck()).thenReturn(true);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbMqttNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new TbMqttNodeConfiguration()))));
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   *
   * <ul>
   *   <li>Given {@link RuleNode#RuleNode()} Id is {@link RuleNodeId#RuleNodeId(UUID)} with id is
   *       randomUUID.
   *   <li>Then calls {@link TbContext#getSelf()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName(
      "Test getOwnerId(TbContext); given RuleNode() Id is RuleNodeId(UUID) with id is randomUUID; then calls getSelf()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TbMqttNode.getOwnerId(TbContext)"})
  void testGetOwnerId_givenRuleNodeIdIsRuleNodeIdWithIdIsRandomUUID_thenCallsGetSelf() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    RuleNode ruleNode = new RuleNode();
    ruleNode.setId(new RuleNodeId(UUID.randomUUID()));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenReturn(ruleNode);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    tbMqttNode.getOwnerId(ctx);

    // Assert
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getSelf()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName("Test getOwnerId(TbContext); when TbContext getSelf() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TbMqttNode.getOwnerId(TbContext)"})
  void testGetOwnerId_whenTbContextGetSelfThrowRuntimeException() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelf()).thenThrow(new RuntimeException());
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.getOwnerId(ctx));
    verify(ctx).getSelf();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMqttNode#getOwnerId(TbContext)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getOwnerId(TbContext)}
   */
  @Test
  @DisplayName("Test getOwnerId(TbContext); when TbContext getTenantId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String TbMqttNode.getOwnerId(TbContext)"})
  void testGetOwnerId_whenTbContextGetTenantIdThrowRuntimeException() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMqttNode.getOwnerId(ctx));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}
   */
  @Test
  @DisplayName(
      "Test getMqttClient(TbContext, MqttClientConfig); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.mqtt.MqttClient TbMqttNode.getMqttClient(TbContext, MqttClientConfig)"
  })
  void testGetMqttClient_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbMqttNode.getMqttClient(ctx, new MqttClientConfig()));
    verify(ctx).getExternalCallExecutor();
  }

  /**
   * Test {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}.
   *
   * <ul>
   *   <li>Given {@link TestDbCallbackExecutor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#getMqttClient(TbContext, MqttClientConfig)}
   */
  @Test
  @DisplayName(
      "Test getMqttClient(TbContext, MqttClientConfig); given TestDbCallbackExecutor (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.mqtt.MqttClient TbMqttNode.getMqttClient(TbContext, MqttClientConfig)"
  })
  void testGetMqttClient_givenTestDbCallbackExecutor() {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getExternalCallExecutor()).thenReturn(new TestDbCallbackExecutor());

    // Act
    tbMqttNode.getMqttClient(ctx, new MqttClientConfig());

    // Assert
    verify(ctx).getExternalCallExecutor();
  }

  /**
   * Test {@link TbMqttNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbMqttNode} (default constructor).
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given TbMqttNode (default constructor); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMqttNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenTbMqttNode_whenOne_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(oldConfiguration, new TbMqttNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbMqttNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second is {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is
   *       withExactBigDecimals {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbMqttNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then return Second is ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbMqttNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_thenReturnSecondIsObjectNodeWithNcIsWithExactBigDecimalsTrue()
      throws TbNodeException {
    // Arrange
    TbMqttNode tbMqttNode = new TbMqttNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("parseToPlainText", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertSame(oldConfiguration, tbMqttNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test new {@link TbMqttNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbMqttNode}
   */
  @Test
  @DisplayName("Test new TbMqttNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMqttNode.<init>()"})
  void testNewTbMqttNode() {
    // Arrange and Act
    TbMqttNode actualTbMqttNode = new TbMqttNode();

    // Assert
    assertNull(actualTbMqttNode.mqttClient);
    assertNull(actualTbMqttNode.mqttNodeConfiguration);
  }
}
