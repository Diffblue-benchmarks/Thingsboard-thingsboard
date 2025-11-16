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
package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class AbstractTbMsgPushNodeDiffblueTest {
  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then {@link TbMsgPushToCloudNode} (default constructor) {@link
   *       AbstractTbMsgPushNode#config} Scope is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ArrayList() iterator; then TbMsgPushToCloudNode (default constructor) config Scope is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenArrayListIterator_thenTbMsgPushToCloudNodeConfigScopeIsNull()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    assertNull(tbMsgPushToCloudNode.config.getScope());
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code END_ARRAY}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_ARRAY}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'END_ARRAY'; when ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndArray_whenArrayNodeAsTokenReturnEndArray_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_ARRAY);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code END_OBJECT}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_OBJECT}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'END_OBJECT'; when ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndObject_whenArrayNodeAsTokenReturnEndObject_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_OBJECT);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code VALUE_NULL}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code VALUE_NULL}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'VALUE_NULL'; when ArrayNode asToken() return 'VALUE_NULL'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenValueNull_whenArrayNodeAsTokenReturnValueNull_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.VALUE_NULL);

    // Act
    tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when ArrayNode asToken() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenArrayNodeAsTokenThrowRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#fields()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when ArrayNode fields() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenArrayNodeFieldsThrowRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);
    when(data.fields()).thenThrow(new RuntimeException());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link POJONode#POJONode(Object)} with v is {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when POJONode(Object) with v is 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenPOJONodeWithVIsNull_thenDoesNotThrow() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertDoesNotThrow(
        () -> tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenTbNodeConfigurationWithDataIsNull_thenDoesNotThrow() throws TbNodeException {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertDoesNotThrow(() -> tbMsgPushToCloudNode.init(ctx, new TbNodeConfiguration(null)));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AbstractTbMsgPushNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgPushToCloudNode.onMsg(ctx, msg));
    verify(msg).getMetaData();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; given AlarmId(UUID) with id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_givenAlarmIdWithIdIsNull() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaDataTs()).thenReturn(1L);
    when(msg.getOriginator()).thenReturn(new AlarmId(null));
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);
    when(msg.getData()).thenReturn(" ");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    Object actualBuildEventResult = tbMsgPushToCloudNode.buildEvent(msg, ctx);

    // Assert
    verify(ctx).getTenantId();
    verify(msg).getData();
    verify(msg).getMetaData();
    verify(msg).getMetaDataTs();
    verify(msg, atLeast(1)).getOriginator();
    verify(msg).isTypeOf(TbMsgType.ALARM);
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
    assertNull(actualBuildEventResult);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; given AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_givenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaDataTs()).thenReturn(1L);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);
    when(msg.getData()).thenReturn("42");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    Object actualBuildEventResult = tbMsgPushToCloudNode.buildEvent(msg, ctx);

    // Assert
    verify(ctx).getTenantId();
    verify(msg).getData();
    verify(msg).getMetaData();
    verify(msg).getMetaDataTs();
    verify(msg, atLeast(1)).getOriginator();
    verify(msg).isTypeOf(TbMsgType.ALARM);
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
    assertNull(actualBuildEventResult);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; given AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_givenAlarmIdWithIdIsRandomUUID2() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaDataTs()).thenReturn(1L);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);
    when(msg.getData()).thenReturn(" ");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    Object actualBuildEventResult = tbMsgPushToCloudNode.buildEvent(msg, ctx);

    // Assert
    verify(ctx).getTenantId();
    verify(msg).getData();
    verify(msg).getMetaData();
    verify(msg).getMetaDataTs();
    verify(msg, atLeast(1)).getOriginator();
    verify(msg).isTypeOf(TbMsgType.ALARM);
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
    assertNull(actualBuildEventResult);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>Given {@link ApiUsageStateId#ApiUsageStateId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; given ApiUsageStateId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_givenApiUsageStateIdWithIdIsRandomUUID() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaDataTs()).thenReturn(1L);
    when(msg.getOriginator()).thenReturn(new ApiUsageStateId(UUID.randomUUID()));
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);
    when(msg.getData()).thenReturn("42");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    Object actualBuildEventResult = tbMsgPushToCloudNode.buildEvent(msg, ctx);

    // Assert
    verify(ctx).getTenantId();
    verify(msg).getData();
    verify(msg).getMetaData();
    verify(msg).getMetaDataTs();
    verify(msg, atLeast(1)).getOriginator();
    verify(msg).isTypeOf(TbMsgType.ALARM);
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
    assertNull(actualBuildEventResult);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName("Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_givenEmptyString() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaDataTs()).thenThrow(new RuntimeException());
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);
    when(msg.getData()).thenReturn("");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbMsgPushToCloudNode.buildEvent(msg, mock(TbContext.class)));
    verify(msg).getData();
    verify(msg).getMetaData();
    verify(msg).getMetaDataTs();
    verify(msg).isTypeOf(TbMsgType.ALARM);
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_thenThrowIllegalArgumentException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(false);
    when(msg.getType()).thenReturn("Type");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbMsgPushToCloudNode.buildEvent(msg, mock(TbContext.class)));
    verify(msg).getMetaData();
    verify(msg).getType();
    verify(msg, atLeast(1)).isTypeOf(Mockito.<TbMsgType>any());
    verify(msg, atLeast(1)).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; when TbContext getTenantId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_whenTbContextGetTenantIdThrowRuntimeException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgPushToCloudNode.buildEvent(msg, ctx));
    verify(ctx).getTenantId();
    verify(msg, atLeast(1)).getMetaData();
    verify(msg).isTypeOf(TbMsgType.ALARM);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; when TbMsg getData() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_whenTbMsgGetDataThrowRuntimeException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new RuntimeException());
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgPushToCloudNode.buildEvent(msg, ctx));
    verify(ctx).getTenantId();
    verify(msg).getData();
    verify(msg, atLeast(1)).getMetaData();
    verify(msg).isTypeOf(TbMsgType.ALARM);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getMetaDataTs()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; when TbMsg getMetaDataTs() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_whenTbMsgGetMetaDataTsThrowRuntimeException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaDataTs()).thenThrow(new RuntimeException());
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);
    when(msg.getData()).thenReturn("42");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbMsgPushToCloudNode.buildEvent(msg, mock(TbContext.class)));
    verify(msg).getData();
    verify(msg).getMetaData();
    verify(msg).getMetaDataTs();
    verify(msg).isTypeOf(TbMsgType.ALARM);
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)} with {@code msg}, {@code ctx}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#buildEvent(TbMsg, TbContext)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TbMsg, TbContext) with 'msg', 'ctx'; when TbMsg isTypeOf(TbMsgType) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object AbstractTbMsgPushNode.buildEvent(TbMsg, TbContext)"})
  void testBuildEventWithMsgCtx_whenTbMsgIsTypeOfThrowRuntimeException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbMsgPushToCloudNode.buildEvent(msg, mock(TbContext.class)));
    verify(msg).isTypeOf(TbMsgType.ALARM);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getUUIDFromMsgData(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getUUIDFromMsgData(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test getUUIDFromMsgData(TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID AbstractTbMsgPushNode.getUUIDFromMsgData(TbMsg)"})
  void testGetUUIDFromMsgData_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgPushToCloudNode.getUUIDFromMsgData(msg));
    verify(msg).getData();
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getScope(Map)}.
   *
   * <ul>
   *   <li>Given {@code Metadata}.
   *   <li>When {@link HashMap#HashMap()} {@code scope} is {@code Metadata}.
   *   <li>Then return {@code Metadata}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getScope(Map)}
   */
  @Test
  @DisplayName(
      "Test getScope(Map); given 'Metadata'; when HashMap() 'scope' is 'Metadata'; then return 'Metadata'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String AbstractTbMsgPushNode.getScope(Map)"})
  void testGetScope_givenMetadata_whenHashMapScopeIsMetadata_thenReturnMetadata() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    HashMap<String, String> metadata = new HashMap<>();
    metadata.put("scope", "Metadata");

    // Act and Assert
    assertEquals("Metadata", tbMsgPushToCloudNode.getScope(metadata));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.POST_TELEMETRY_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));

    // Act
    EdgeEventActionType actualEdgeEventActionTypeByMsgType =
        tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());

    // Assert
    assertEquals(EdgeEventActionType.TIMESERIES_UPDATED, actualEdgeEventActionTypeByMsgType);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType2() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.TO_SERVER_RPC_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(
                ruleChainIdResult
                    .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                    .ts(1L)
                    .type("Type")
                    .build()));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType3() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.ACTIVITY_EVENT);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));

    // Act
    EdgeEventActionType actualEdgeEventActionTypeByMsgType =
        tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());

    // Assert
    assertEquals(EdgeEventActionType.TIMESERIES_UPDATED, actualEdgeEventActionTypeByMsgType);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOneOf(TbMsgType[])} return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test getEdgeEventActionTypeByMsgType(TbMsg); given 'true'; when TbMsg isTypeOneOf(TbMsgType[]) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType_givenTrue_whenTbMsgIsTypeOneOfReturnTrue() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);

    // Act
    EdgeEventActionType actualEdgeEventActionTypeByMsgType =
        tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(msg);

    // Assert
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
    assertEquals(EdgeEventActionType.TIMESERIES_UPDATED, actualEdgeEventActionTypeByMsgType);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Type}.
   *   <li>Then calls {@link TbMsg#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg); given 'Type'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType_givenType_thenCallsGetType() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(false);
    when(msg.getType()).thenReturn("Type");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(msg));
    verify(msg).getType();
    verify(msg, atLeast(1)).isTypeOf(Mockito.<TbMsgType>any());
    verify(msg, atLeast(1)).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>Then return {@code ATTRIBUTES_UPDATED}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg); then return 'ATTRIBUTES_UPDATED'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType_thenReturnAttributesUpdated() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(false);

    // Act
    EdgeEventActionType actualEdgeEventActionTypeByMsgType =
        tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(msg);

    // Assert
    verify(msg).isTypeOf(TbMsgType.ATTRIBUTES_UPDATED);
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
    assertEquals(EdgeEventActionType.ATTRIBUTES_UPDATED, actualEdgeEventActionTypeByMsgType);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>Then return {@code POST_ATTRIBUTES}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg); then return 'POST_ATTRIBUTES'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType_thenReturnPostAttributes() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

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
    EdgeEventActionType actualEdgeEventActionTypeByMsgType =
        tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());

    // Assert
    assertEquals(EdgeEventActionType.POST_ATTRIBUTES, actualEdgeEventActionTypeByMsgType);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#getEdgeEventActionTypeByMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByMsgType(TbMsg); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType AbstractTbMsgPushNode.getEdgeEventActionTypeByMsgType(TbMsg)"
  })
  void testGetEdgeEventActionTypeByMsgType_thenThrowRuntimeException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> tbMsgPushToCloudNode.getEdgeEventActionTypeByMsgType(msg));
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}.
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test isSupportedMsgType(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbMsgPushNode.isSupportedMsgType(TbMsg)"})
  void testIsSupportedMsgType() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

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
    boolean actualIsSupportedMsgTypeResult =
        tbMsgPushToCloudNode.isSupportedMsgType(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());

    // Assert
    assertTrue(actualIsSupportedMsgTypeResult);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}.
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}
   */
  @Test
  @DisplayName("Test isSupportedMsgType(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbMsgPushNode.isSupportedMsgType(TbMsg)"})
  void testIsSupportedMsgType2() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.randomUUID()))
            .data("Data")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.ENTITY_CREATED);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));

    // Act
    boolean actualIsSupportedMsgTypeResult =
        tbMsgPushToCloudNode.isSupportedMsgType(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());

    // Assert
    assertFalse(actualIsSupportedMsgTypeResult);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOneOf(TbMsgType[])} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test isSupportedMsgType(TbMsg); given 'false'; when TbMsg isTypeOneOf(TbMsgType[]) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbMsgPushNode.isSupportedMsgType(TbMsg)"})
  void testIsSupportedMsgType_givenFalse_whenTbMsgIsTypeOneOfReturnFalse() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(false);

    // Act
    boolean actualIsSupportedMsgTypeResult = tbMsgPushToCloudNode.isSupportedMsgType(msg);

    // Assert
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
    assertFalse(actualIsSupportedMsgTypeResult);
  }

  /**
   * Test {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test isSupportedMsgType(TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbMsgPushNode.isSupportedMsgType(TbMsg)"})
  void testIsSupportedMsgType_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgPushToCloudNode.isSupportedMsgType(msg));
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
  }

  /**
   * Test {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOneOf(TbMsgType[])} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractTbMsgPushNode#isSupportedMsgType(TbMsg)}
   */
  @Test
  @DisplayName(
      "Test isSupportedMsgType(TbMsg); given 'true'; when TbMsg isTypeOneOf(TbMsgType[]) return 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AbstractTbMsgPushNode.isSupportedMsgType(TbMsg)"})
  void testIsSupportedMsgType_givenTrue_whenTbMsgIsTypeOneOfReturnTrue_thenReturnTrue() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOneOf(isA(TbMsgType[].class))).thenReturn(true);

    // Act
    boolean actualIsSupportedMsgTypeResult = tbMsgPushToCloudNode.isSupportedMsgType(msg);

    // Assert
    verify(msg).isTypeOneOf(isA(TbMsgType[].class));
    assertTrue(actualIsSupportedMsgTypeResult);
  }
}
