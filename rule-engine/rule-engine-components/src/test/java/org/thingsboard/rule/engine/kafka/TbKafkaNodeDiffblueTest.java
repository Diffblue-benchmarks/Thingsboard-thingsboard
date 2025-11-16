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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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

@ExtendWith(MockitoExtension.class)
class TbKafkaNodeDiffblueTest {
  @Mock private Producer<String, String> producer;

  @InjectMocks private TbKafkaNode tbKafkaNode;

  @Mock private TbKafkaNodeConfiguration tbKafkaNodeConfiguration;

  @Mock private Throwable throwable;

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
   *   <li>Given {@code Acks}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given 'Acks'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenAcks_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getServiceId()).thenReturn("42");
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(new UUID(12L, 12L)));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setAcks("Acks");
    tbKafkaNodeConfiguration.setKeySerializer("bootstrap.servers");
    tbKafkaNodeConfiguration.setValueSerializer("42");
    tbKafkaNodeConfiguration.setBootstrapServers("bootstrap.servers");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbKafkaNode.init(ctx, new TbNodeConfiguration(new POJONode(tbKafkaNodeConfiguration))));
    verify(ctx).getSelfId();
    verify(ctx).getServiceId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code bootstrap.servers} is {@code client.id}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given HashMap() 'bootstrap.servers' is 'client.id'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenHashMapBootstrapServersIsClientId()
      throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getServiceId()).thenReturn("42");
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(new UUID(12L, 12L)));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    HashMap<String, String> otherProperties = new HashMap<>();
    otherProperties.put("bootstrap.servers", "client.id");
    otherProperties.put("client.id", "42");

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setOtherProperties(otherProperties);
    tbKafkaNodeConfiguration.setAcks("Acks");
    tbKafkaNodeConfiguration.setKeySerializer("bootstrap.servers");
    tbKafkaNodeConfiguration.setValueSerializer("42");
    tbKafkaNodeConfiguration.setBootstrapServers("bootstrap.servers");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbKafkaNode.init(ctx, new TbNodeConfiguration(new POJONode(tbKafkaNodeConfiguration))));
    verify(ctx).getSelfId();
    verify(ctx).getServiceId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code client.id} is {@code 42}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given HashMap() 'client.id' is '42'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenHashMapClientIdIs42_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getServiceId()).thenReturn("42");
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(new UUID(12L, 12L)));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    HashMap<String, String> otherProperties = new HashMap<>();
    otherProperties.put("client.id", "42");

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setOtherProperties(otherProperties);
    tbKafkaNodeConfiguration.setAcks("Acks");
    tbKafkaNodeConfiguration.setKeySerializer("bootstrap.servers");
    tbKafkaNodeConfiguration.setValueSerializer("42");
    tbKafkaNodeConfiguration.setBootstrapServers("bootstrap.servers");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbKafkaNode.init(ctx, new TbNodeConfiguration(new POJONode(tbKafkaNodeConfiguration))));
    verify(ctx).getSelfId();
    verify(ctx).getServiceId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given HashMap(); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenHashMap_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getServiceId()).thenReturn("42");
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(new UUID(12L, 12L)));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setOtherProperties(new HashMap<>());
    tbKafkaNodeConfiguration.setAcks("Acks");
    tbKafkaNodeConfiguration.setKeySerializer("bootstrap.servers");
    tbKafkaNodeConfiguration.setValueSerializer("42");
    tbKafkaNodeConfiguration.setBootstrapServers("bootstrap.servers");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbKafkaNode.init(ctx, new TbNodeConfiguration(new POJONode(tbKafkaNodeConfiguration))));
    verify(ctx).getSelfId();
    verify(ctx).getServiceId();
    verify(ctx).isExternalNodeForceAck();
  }

  /**
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>Given {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; given 'UTF-8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_givenUtf8() throws TbNodeException {
    // Arrange
    TbKafkaNode tbKafkaNode = new TbKafkaNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getServiceId()).thenReturn("42");
    when(ctx.getSelfId()).thenReturn(new RuleNodeId(new UUID(12L, 12L)));
    when(ctx.isExternalNodeForceAck()).thenReturn(true);

    HashMap<String, String> otherProperties = new HashMap<>();
    otherProperties.put("client.id", "42");

    TbKafkaNodeConfiguration tbKafkaNodeConfiguration = new TbKafkaNodeConfiguration();
    tbKafkaNodeConfiguration.setKafkaHeadersCharset("UTF-8");
    tbKafkaNodeConfiguration.setOtherProperties(otherProperties);
    tbKafkaNodeConfiguration.setAcks("Acks");
    tbKafkaNodeConfiguration.setKeySerializer("bootstrap.servers");
    tbKafkaNodeConfiguration.setValueSerializer("42");
    tbKafkaNodeConfiguration.setBootstrapServers("bootstrap.servers");

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            tbKafkaNode.init(ctx, new TbNodeConfiguration(new POJONode(tbKafkaNodeConfiguration))));
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
   * Test {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)} with {@code ctx}, {@code
   * configuration}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getServiceId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration) with 'ctx', 'configuration'; when TbContext getServiceId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.init(TbContext, TbNodeConfiguration)"})
  void testInitWithCtxConfiguration_whenTbContextGetServiceIdThrowRuntimeException()
      throws TbNodeException {
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
   * Test {@link TbKafkaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaNodeConfiguration} {@link TbKafkaNodeConfiguration#getKeyPattern()}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbKafkaNodeConfiguration getKeyPattern() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbKafkaNodeConfigurationGetKeyPatternThrowRuntimeException() {
    // Arrange
    when(tbKafkaNodeConfiguration.getKeyPattern()).thenThrow(new RuntimeException());
    when(tbKafkaNodeConfiguration.getTopicPattern()).thenReturn("Topic Pattern");
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbKafkaNode.onMsg(ctx, msg));
    verify(tbKafkaNodeConfiguration).getKeyPattern();
    verify(tbKafkaNodeConfiguration).getTopicPattern();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbKafkaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbKafkaNodeConfiguration} {@link TbKafkaNodeConfiguration#getTopicPattern()}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbKafkaNodeConfiguration getTopicPattern() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbKafkaNodeConfigurationGetTopicPatternThrowRuntimeException() {
    // Arrange
    when(tbKafkaNodeConfiguration.getTopicPattern()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbKafkaNode.onMsg(mock(TbContext.class), mock(TbMsg.class)));
    verify(tbKafkaNodeConfiguration).getTopicPattern();
  }

  /**
   * Test {@link TbKafkaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Key} is {@code 42}.
   *   <li>Then calls {@link Throwable#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData() Value 'Key' is '42'; then calls getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataValueKeyIs42_thenCallsGetMessage() {
    // Arrange
    when(tbKafkaNodeConfiguration.getKeyPattern()).thenReturn("Key Pattern");
    when(tbKafkaNodeConfiguration.getTopicPattern()).thenReturn("Topic Pattern");
    when(throwable.getMessage()).thenReturn("Not all who wander are lost");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbKafkaNode.onMsg(ctx, msg);

    // Assert
    verify(throwable).getMessage();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbKafkaNodeConfiguration).getKeyPattern();
    verify(tbKafkaNodeConfiguration).getTopicPattern();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbKafkaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link Throwable} {@link Throwable#getMessage()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link Throwable#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given Throwable getMessage() throw RuntimeException(); then calls getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenThrowableGetMessageThrowRuntimeException_thenCallsGetMessage() {
    // Arrange
    when(tbKafkaNodeConfiguration.getKeyPattern()).thenReturn("Key Pattern");
    when(tbKafkaNodeConfiguration.getTopicPattern()).thenReturn("Topic Pattern");
    when(throwable.getMessage()).thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbKafkaNode.onMsg(ctx, msg);

    // Assert
    verify(throwable).getMessage();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbKafkaNodeConfiguration).getKeyPattern();
    verify(tbKafkaNodeConfiguration).getTopicPattern();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbKafkaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link Throwable#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls getMessage()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsGetMessage() {
    // Arrange
    when(tbKafkaNodeConfiguration.getKeyPattern()).thenReturn("Key Pattern");
    when(tbKafkaNodeConfiguration.getTopicPattern()).thenReturn("Topic Pattern");
    when(throwable.getMessage()).thenReturn("Not all who wander are lost");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbKafkaNode.onMsg(ctx, msg);

    // Assert
    verify(throwable).getMessage();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbKafkaNodeConfiguration).getKeyPattern();
    verify(tbKafkaNodeConfiguration).getTopicPattern();
    verify(msg).getData();
    verify(msg).getMetaData();
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

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

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
   *   <li>Given {@link Producer} {@link Producer#send(ProducerRecord, Callback)} return {@link
   *       CompletableFuture#CompletableFuture()}.
   *   <li>When {@link TbContext}.
   *   <li>Then calls {@link Producer#send(ProducerRecord, Callback)}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName(
      "Test publish(TbContext, TbMsg, String, String); given Producer send(ProducerRecord, Callback) return CompletableFuture(); when TbContext; then calls send(ProducerRecord, Callback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish_givenProducerSendReturnCompletableFuture_whenTbContext_thenCallsSend() {
    // Arrange
    when(producer.send(Mockito.<ProducerRecord<String, String>>any(), Mockito.<Callback>any()))
        .thenReturn(new CompletableFuture<>());
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act
    tbKafkaNode.publish(ctx, msg, "[{}] Failed to process message: {}", "Key");

    // Assert
    verify(producer).send(isA(ProducerRecord.class), isA(Callback.class));
    verify(msg).getData();
  }

  /**
   * Test {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName(
      "Test publish(TbContext, TbMsg, String, String); given RuleNodeId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish_givenRuleNodeIdWithIdIsRandomUUID() {
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
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is randomUUID.
   *   <li>When {@code null}.
   *   <li>Then calls {@link TbContext#getSelfId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#publish(TbContext, TbMsg, String, String)}
   */
  @Test
  @DisplayName(
      "Test publish(TbContext, TbMsg, String, String); given RuleNodeId(UUID) with id is randomUUID; when 'null'; then calls getSelfId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.publish(TbContext, TbMsg, String, String)"})
  void testPublish_givenRuleNodeIdWithIdIsRandomUUID_whenNull_thenCallsGetSelfId() {
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

  /**
   * Test {@link TbKafkaNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Producer} {@link Producer#close()} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given Producer close() does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.destroy()"})
  void testDestroy_givenProducerCloseDoesNothing() {
    // Arrange
    doNothing().when(producer).close();

    // Act
    tbKafkaNode.destroy();

    // Assert
    verify(producer).close();
  }

  /**
   * Test {@link TbKafkaNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link Producer} {@link Producer#close()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbKafkaNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given Producer close() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbKafkaNode.destroy()"})
  void testDestroy_givenProducerCloseThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(producer).close();

    // Act
    tbKafkaNode.destroy();

    // Assert
    verify(producer).close();
  }
}
