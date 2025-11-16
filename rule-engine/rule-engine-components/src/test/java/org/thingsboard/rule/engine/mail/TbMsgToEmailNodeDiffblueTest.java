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
package org.thingsboard.rule.engine.mail;

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
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
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
class TbMsgToEmailNodeDiffblueTest {
  @InjectMocks private TbMsgToEmailNode tbMsgToEmailNode;

  @Mock private TbMsgToEmailNodeConfiguration tbMsgToEmailNodeConfiguration;

  /**
   * Test {@link TbMsgToEmailNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code START_OBJECT}.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; when ArrayNode asToken() return 'START_OBJECT'; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_whenArrayNodeAsTokenReturnStartObject_thenCallsFields()
      throws TbNodeException {
    // Arrange
    TbMsgToEmailNode tbMsgToEmailNode = new TbMsgToEmailNode();
    TbContext ctx = mock(TbContext.class);

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbMsgToEmailNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code Data}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code Data}.
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'Data'; when TbMsg getData() return 'Data'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenData_whenTbMsgGetDataReturnData_thenCallsGetData() {
    // Arrange
    when(tbMsgToEmailNodeConfiguration.getFromTemplate()).thenReturn("jane.doe@example.org");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbMsgToEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbMsgToEmailNodeConfiguration).getFromTemplate();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbMsg} {@link TbMsg#getMetaData()} return {@code null}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'null'; when TbMsg getMetaData() return 'null'; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNull_whenTbMsgGetMetaDataReturnNull_thenCallsTellFailure() {
    // Arrange
    when(tbMsgToEmailNodeConfiguration.getFromTemplate()).thenReturn("jane.doe@example.org");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaData()).thenReturn(null);

    // Act
    tbMsgToEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbMsgToEmailNodeConfiguration).getFromTemplate();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgMetaData#TbMsgMetaData()} Value {@code Failed to process pattern!} is
   *       {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgMetaData() Value 'Failed to process pattern!' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgMetaDataValueFailedToProcessPatternIs42() {
    // Arrange
    when(tbMsgToEmailNodeConfiguration.getFromTemplate()).thenReturn("jane.doe@example.org");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsgMetaData tbMsgMetaData = new TbMsgMetaData();
    tbMsgMetaData.putValue("Failed to process pattern!", "42");

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(tbMsgMetaData);

    // Act
    tbMsgToEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbMsgToEmailNodeConfiguration).getFromTemplate();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgToEmailNodeConfiguration} {@link
   *       TbMsgToEmailNodeConfiguration#getFromTemplate()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgToEmailNodeConfiguration getFromTemplate() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgToEmailNodeConfigurationGetFromTemplateReturnEmptyString() {
    // Arrange
    when(tbMsgToEmailNodeConfiguration.getFromTemplate()).thenReturn("");
    when(tbMsgToEmailNodeConfiguration.getToTemplate()).thenReturn("To Template");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("Data");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbMsgToEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbMsgToEmailNodeConfiguration).getFromTemplate();
    verify(tbMsgToEmailNodeConfiguration).getToTemplate();
    verify(msg).getData();
    verify(msg).getMetaData();
  }

  /**
   * Test {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgToEmailNode} (default constructor).
   *   <li>When {@link TbMsg}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgToEmailNode (default constructor); when TbMsg; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgToEmailNode_whenTbMsg_thenCallsTellFailure() {
    // Arrange
    TbMsgToEmailNode tbMsgToEmailNode = new TbMsgToEmailNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbMsgToEmailNode.onMsg(ctx, mock(TbMsg.class));

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#tellNext(TbMsg, String)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgToEmailNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls tellNext(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgToEmailNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsTellNext() {
    // Arrange
    when(tbMsgToEmailNodeConfiguration.getBccTemplate()).thenReturn("mary.somerville@example.org");
    when(tbMsgToEmailNodeConfiguration.getBodyTemplate()).thenReturn("Not all who wander are lost");
    when(tbMsgToEmailNodeConfiguration.getCcTemplate()).thenReturn("Cc Template");
    when(tbMsgToEmailNodeConfiguration.getFromTemplate()).thenReturn("jane.doe@example.org");
    when(tbMsgToEmailNodeConfiguration.getMailBodyType()).thenReturn("Not all who wander are lost");
    when(tbMsgToEmailNodeConfiguration.getSubjectTemplate())
        .thenReturn("Hello from the Dreaming Spires");
    when(tbMsgToEmailNodeConfiguration.getToTemplate()).thenReturn("To Template");

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

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

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
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenReturn(null);
    when(msg.getData()).thenReturn("42");
    when(msg.getMetaData()).thenReturn(new TbMsgMetaData());

    // Act
    tbMsgToEmailNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Success"));
    verify(ctx)
        .transformMsg(
            isA(TbMsg.class),
            eq(TbMsgType.SEND_EMAIL),
            (EntityId) isNull(),
            isA(TbMsgMetaData.class),
            eq(
                "{\"from\":\"jane.doe@example.org\",\"to\":\"To Template\",\"cc\":\"Cc Template\",\"bcc\":\"mary.somerville@example.org\",\"subject\":\"Hello from the Dreaming Spires\",\"body\":\"Not all who wander are lost\",\"images\":null,\"html\":false}"));
    verify(tbMsgToEmailNodeConfiguration).getBccTemplate();
    verify(tbMsgToEmailNodeConfiguration).getBodyTemplate();
    verify(tbMsgToEmailNodeConfiguration).getCcTemplate();
    verify(tbMsgToEmailNodeConfiguration).getFromTemplate();
    verify(tbMsgToEmailNodeConfiguration).getMailBodyType();
    verify(tbMsgToEmailNodeConfiguration).getSubjectTemplate();
    verify(tbMsgToEmailNodeConfiguration).getToTemplate();
    verify(msg, atLeast(1)).getData();
    verify(msg, atLeast(1)).getMetaData();
    verify(msg).getOriginator();
  }
}
