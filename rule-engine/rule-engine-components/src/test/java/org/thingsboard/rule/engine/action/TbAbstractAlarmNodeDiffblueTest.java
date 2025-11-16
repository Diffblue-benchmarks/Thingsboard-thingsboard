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
package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.api.ScriptEngine;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.script.ScriptLanguage;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

@ExtendWith(MockitoExtension.class)
class TbAbstractAlarmNodeDiffblueTest {
  @Mock private ScriptEngine scriptEngine;

  @InjectMocks private TbClearAlarmNode tbClearAlarmNode;

  /**
   * Test {@link TbAbstractAlarmNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>Then {@link TbClearAlarmNode} (default constructor) {@link TbAbstractAlarmNode#config}
   *       AlarmDetailsBuildJs is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; then TbClearAlarmNode (default constructor) config AlarmDetailsBuildJs is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractAlarmNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_thenTbClearAlarmNodeConfigAlarmDetailsBuildJsIsNull()
      throws TbNodeException {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.createScriptEngine(
            Mockito.<ScriptLanguage>any(), Mockito.<String>any(), isA(String[].class)))
        .thenReturn(mock(ScriptEngine.class));

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbClearAlarmNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).createScriptEngine(isNull(), isNull(), isA(String[].class));
    TbClearAlarmNodeConfiguration tbClearAlarmNodeConfiguration = tbClearAlarmNode.config;
    assertNull(tbClearAlarmNodeConfiguration.getAlarmDetailsBuildJs());
    assertNull(tbClearAlarmNodeConfiguration.getAlarmDetailsBuildTbel());
    assertNull(tbClearAlarmNodeConfiguration.getAlarmType());
    assertNull(tbClearAlarmNodeConfiguration.getScriptLang());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given Instance.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName("Test buildAlarmDetails(TbMsg, JsonNode); given Instance")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenInstance() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode previousDetails = new ArrayNode(nf);
    previousDetails.add(MissingNode.getInstance());

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, previousDetails);

    // Assert
    verify(msg).getMetaData();
    assertTrue(actualBuildAlarmDetailsResult.isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbMsg} {@link TbMsg#getMetaData()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); given 'null'; when TbMsg getMetaData() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenNull_whenTbMsgGetMetaDataReturnNull() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(null);

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, DoubleNode.valueOf(10.0d));

    // Assert
    verify(msg).getMetaData();
    assertTrue(actualBuildAlarmDetailsResult.isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName("Test buildAlarmDetails(TbMsg, JsonNode); given RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenRuntimeException() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenThrow(new RuntimeException());

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, DoubleNode.valueOf(10.0d));

    // Assert
    verify(msg).getMetaData();
    assertTrue(actualBuildAlarmDetailsResult.isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbClearAlarmNode} (default constructor).
   *   <li>When {@link TbMsg}.
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); given TbClearAlarmNode (default constructor); when TbMsg; then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenTbClearAlarmNode_whenTbMsg_thenReturnDone() {
    // Arrange, Act and Assert
    assertTrue(new TbClearAlarmNode().buildAlarmDetails(mock(TbMsg.class), null).isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Key} is {@code
   *       prevAlarmDetails}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); given TbMsgMetaData() Value 'Key' is 'prevAlarmDetails'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenTbMsgMetaDataValueKeyIsPrevAlarmDetails() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Key", "prevAlarmDetails");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, new ArrayNode(nf));

    // Assert
    verify(msg).getMetaData();
    assertTrue(actualBuildAlarmDetailsResult.isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()}.
   *   <li>When Instance.
   *   <li>Then calls {@link TbMsg#getMetaData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); given TbMsgMetaData(); when Instance; then calls getMetaData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenTbMsgMetaData_whenInstance_thenCallsGetMetaData() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, MissingNode.getInstance());

    // Assert
    verify(msg).getMetaData();
    assertTrue(actualBuildAlarmDetailsResult.isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()}.
   *   <li>When valueOf ten.
   *   <li>Then calls {@link TbMsg#getMetaData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); given TbMsgMetaData(); when valueOf ten; then calls getMetaData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenTbMsgMetaData_whenValueOfTen_thenCallsGetMetaData() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, DoubleNode.valueOf(10.0d));

    // Assert
    verify(msg).getMetaData();
    assertTrue(actualBuildAlarmDetailsResult.isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName("Test buildAlarmDetails(TbMsg, JsonNode); given valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_givenValueOfTen() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode previousDetails = new ArrayNode(nf);
    previousDetails.add(DoubleNode.valueOf(10.0d));

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, previousDetails);

    // Assert
    verify(msg).getMetaData();
    assertTrue(actualBuildAlarmDetailsResult.isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>Then return {@link ApiFutureToListenableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName("Test buildAlarmDetails(TbMsg, JsonNode); then return ApiFutureToListenableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_thenReturnApiFutureToListenableFuture() {
    // Arrange
    ListenableFutureToApiFuture<JsonNode> delegate =
        new ListenableFutureToApiFuture<>(mock(ListenableFutureTask.class));
    ForwardingApiFuture<JsonNode> apiFuture = new ForwardingApiFuture<>(delegate);
    ApiFutureToListenableFuture<JsonNode> apiFutureToListenableFuture =
        new ApiFutureToListenableFuture<>(apiFuture);
    when(scriptEngine.executeJsonAsync(Mockito.<TbMsg>any()))
        .thenReturn(apiFutureToListenableFuture);

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(mock(TbMsg.class), null);

    // Assert
    verify(scriptEngine).executeJsonAsync(isA(TbMsg.class));
    assertTrue(actualBuildAlarmDetailsResult instanceof ApiFutureToListenableFuture);
    assertSame(apiFutureToListenableFuture, actualBuildAlarmDetailsResult);
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_whenArrayNodeWithNfIsWithExactBigDecimalsTrue() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, new ArrayNode(nf));

    // Assert
    verify(msg).getMetaData();
    assertTrue(actualBuildAlarmDetailsResult.isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addArray.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addArray")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddArray() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode previousDetails = new ArrayNode(nf);
    previousDetails.addArray();
    previousDetails.add(DoubleNode.valueOf(10.0d));

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, previousDetails);

    // Assert
    verify(msg).getMetaData();
    assertTrue(actualBuildAlarmDetailsResult.isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is withExactBigDecimals {@code
   *       true} addObject.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#buildAlarmDetails(TbMsg, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildAlarmDetails(TbMsg, JsonNode); when ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true' addObject")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbAbstractAlarmNode.buildAlarmDetails(TbMsg, JsonNode)"})
  void testBuildAlarmDetails_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAddObject() {
    // Arrange
    TbClearAlarmNode tbClearAlarmNode = new TbClearAlarmNode();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    ArrayNode previousDetails = new ArrayNode(nf);
    previousDetails.addObject();
    previousDetails.add(DoubleNode.valueOf(10.0d));

    // Act
    ListenableFuture<JsonNode> actualBuildAlarmDetailsResult =
        tbClearAlarmNode.buildAlarmDetails(msg, previousDetails);

    // Assert
    verify(msg).getMetaData();
    assertTrue(actualBuildAlarmDetailsResult.isDone());
  }

  /**
   * Test {@link TbAbstractAlarmNode#toAlarmMsg(TbContext, TbAlarmResult, TbMsg)}.
   *
   * <ul>
   *   <li>Then return Originator is {@link AlarmId#AlarmId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#toAlarmMsg(TbContext, TbAlarmResult, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test toAlarmMsg(TbContext, TbAlarmResult, TbMsg); then return Originator is AlarmId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbMsg TbAbstractAlarmNode.toAlarmMsg(TbContext, TbAlarmResult, TbMsg)"})
  void testToAlarmMsg_thenReturnOriginatorIsAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TbContext ctx = mock(TbContext.class);

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

    TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    AlarmId originator = new AlarmId(UUID.randomUUID());

    TbMsgBuilder queueNameResult =
        metaDataResult.originator(originator).partition(1).queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    when(ctx.transformMsg(
            Mockito.<TbMsg>any(),
            Mockito.<TbMsgType>any(),
            Mockito.<EntityId>any(),
            Mockito.<TbMsgMetaData>any(),
            Mockito.<String>any()))
        .thenReturn(
            ruleChainIdResult
                .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
                .ts(1L)
                .type("Type")
                .build());

    TbAlarmResult alarmResult = new TbAlarmResult(false, false, false, null);
    alarmResult.setSeverityUpdated(false);

    TbMsg originalMsg = mock(TbMsg.class);
    when(originalMsg.getOriginator()).thenReturn(null);
    when(originalMsg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    TbMsg actualToAlarmMsgResult = TbAbstractAlarmNode.toAlarmMsg(ctx, alarmResult, originalMsg);

    // Assert
    verify(ctx)
        .transformMsg(
            isA(TbMsg.class),
            eq(TbMsgType.ALARM),
            (EntityId) isNull(),
            isA(TbMsgMetaData.class),
            eq("null"));
    verify(originalMsg).getMetaData();
    verify(originalMsg).getOriginator();
    assertSame(originator, actualToAlarmMsgResult.getOriginator());
  }

  /**
   * Test {@link TbAbstractAlarmNode#destroy()}.
   *
   * <ul>
   *   <li>Given {@link ScriptEngine} {@link ScriptEngine#destroy()} does nothing.
   *   <li>Then calls {@link ScriptEngine#destroy()}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractAlarmNode#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); given ScriptEngine destroy() does nothing; then calls destroy()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbAbstractAlarmNode.destroy()"})
  void testDestroy_givenScriptEngineDestroyDoesNothing_thenCallsDestroy() {
    // Arrange
    doNothing().when(scriptEngine).destroy();

    // Act
    tbClearAlarmNode.destroy();

    // Assert
    verify(scriptEngine).destroy();
  }
}
