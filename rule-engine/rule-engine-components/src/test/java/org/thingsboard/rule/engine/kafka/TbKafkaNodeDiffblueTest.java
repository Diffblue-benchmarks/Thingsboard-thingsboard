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
package org.thingsboard.rule.engine.kafka;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbKafkaNodeDiffblueTest {
  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration() throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.isExternalNodeForceAck()).thenThrow(new RuntimeException());
    DoubleNode data = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbKafkaNode.init(ctx, new TbNodeConfiguration(data)));
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getServiceId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; then calls getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_thenCallsGetServiceId() throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getServiceId()).thenThrow(new RuntimeException());
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbKafkaNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance())));
    verify(ctx).getSelfId();
    verify(ctx).getServiceId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getSelfId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbContext getSelfId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenTbContextGetSelfIdThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenThrow(new RuntimeException());
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbKafkaNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance())));
    verify(ctx).getSelfId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName("Test publish(TbContext, TbMsg, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish() {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx(3));

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));

    // Act
    tbKafkaNode.publish(
        ctx,
        ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build(),
        "Topic",
        "Key");

    // Assert
    verify(ctx).getSelfId();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName(
      "Test publish(TbContext, TbMsg, String, String); given 'Data'; when 'null'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish_givenData_whenNull_thenCallsGetData() {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act
    tbKafkaNode.publish(ctx, msg, null, "Key");

    // Assert
    verify(ctx).getSelfId();
    verify(msg).getData();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName(
      "Test publish(TbContext, TbMsg, String, String); given 'Data'; when TbMsg getData() return 'Data'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish_givenData_whenTbMsgGetDataReturnData_thenCallsGetData() {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act
    tbKafkaNode.publish(ctx, msg, "Topic", "Key");

    // Assert
    verify(ctx).getSelfId();
    verify(msg).getData();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName(
      "Test publish(TbContext, TbMsg, String, String); given RuntimeException(); when TbMsg getData() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish_givenRuntimeException_whenTbMsgGetDataThrowRuntimeException() {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(UUID.randomUUID()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new RuntimeException());

    // Act
    tbKafkaNode.publish(ctx, msg, "Topic", "Key");

    // Assert
    verify(ctx).getSelfId();
    verify(msg).getData();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName("Test publish(TbContext, TbMsg, String, String); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish_thenThrowRuntimeException() {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId()).thenThrow(new RuntimeException());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbKafkaNode.publish(ctx, msg, "Topic", "Key"));
    verify(ctx).getSelfId();
    verify(msg).getData();
  }
}
