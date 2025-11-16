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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.TbMsg;

class TbCheckAlarmStatusNodeDiffblueTest {
  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ArrayList() iterator; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenArrayListIterator_thenCallsFields() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code END_ARRAY}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_ARRAY}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'END_ARRAY'; when ArrayNode asToken() return 'END_ARRAY'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndArray_whenArrayNodeAsTokenReturnEndArray_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_ARRAY);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code END_OBJECT}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code END_OBJECT}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'END_OBJECT'; when ArrayNode asToken() return 'END_OBJECT'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenEndObject_whenArrayNodeAsTokenReturnEndObject_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.END_OBJECT);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code VALUE_NULL}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code VALUE_NULL}.
   *   <li>Then calls {@link ArrayNode#asToken()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'VALUE_NULL'; when ArrayNode asToken() return 'VALUE_NULL'; then calls asToken()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenValueNull_whenArrayNodeAsTokenReturnValueNull_thenCallsAsToken()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();
    TbContext tbContext = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenReturn(JsonToken.VALUE_NULL);

    // Act
    tbCheckAlarmStatusNode.init(tbContext, new TbNodeConfiguration(data));

    // Assert
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'Data'; when TbContext getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenData_whenTbContextGetTenantIdThrowIllegalArgumentException()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getTenantId();
    verify(msg).getData();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'Data'; when TbMsg getData() return 'Data'; then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenData_whenTbMsgGetDataReturnData_thenThrowTbNodeException()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getRuleChainName();
    verify(ctx).getTenantId();
    verify(msg, atLeast(1)).getData();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given empty string; when TbMsg getData() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenEmptyString_whenTbMsgGetDataReturnEmptyString() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getRuleChainName();
    verify(ctx).getTenantId();
    verify(msg, atLeast(1)).getData();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code [{}][{}] Failed to parse alarm: [{}] error [{}]}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given '[{}][{}] Failed to parse alarm: [{}] error [{}]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFailedToParseAlarmError() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("[{}][{}] Failed to parse alarm: [{}] error [{}]");

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getRuleChainName();
    verify(ctx).getTenantId();
    verify(msg, atLeast(1)).getData();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getTenantId();
    verify(msg).getData();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_thenThrowRuntimeException() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getRuleChainName();
    verify(ctx).getTenantId();
    verify(msg, atLeast(1)).getData();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg getData() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgGetDataThrowIllegalArgumentException() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getRuleChainName();
    verify(ctx).getTenantId();
    verify(msg, atLeast(1)).getData();
  }
}
