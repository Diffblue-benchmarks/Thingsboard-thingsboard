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
package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.POJONode;
import java.util.UUID;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.TenantProfile;
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

class TbMsgTimeseriesNodeDiffblueTest {
  /**
   * Test {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenIllegalArgumentException_thenThrowIllegalArgumentException()
      throws TbNodeException {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new IllegalArgumentException())
        .when(ctx)
        .addTenantProfileListener(Mockito.<Consumer<TenantProfile>>any());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbMsgTimeseriesNode.init(ctx, new TbNodeConfiguration(new POJONode(null))));
    verify(ctx).addTenantProfileListener(isA(Consumer.class));
  }

  /**
   * Test {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getTenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then calls getTenantProfile()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenCallsGetTenantProfile() throws TbNodeException {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();

    TenantProfile tenantProfile = new TenantProfile(new TenantProfile());
    tenantProfile.setProfileDataBytes(null);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantProfile()).thenReturn(tenantProfile);
    doNothing().when(ctx).addTenantProfileListener(Mockito.<Consumer<TenantProfile>>any());

    // Act
    tbMsgTimeseriesNode.init(ctx, new TbNodeConfiguration(new POJONode(null)));

    // Assert
    verify(ctx).addTenantProfileListener(isA(Consumer.class));
    verify(ctx).getTenantProfile();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

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
    tbMsgTimeseriesNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} return {@code false}.
   *   <li>Then calls {@link TbMsg#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'false'; when TbMsg isTypeOf(TbMsgType) return 'false'; then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFalse_whenTbMsgIsTypeOfReturnFalse_thenCallsGetType() {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getType()).thenReturn("Type");

    // Act
    tbMsgTimeseriesNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getType();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellFailureThrowIllegalArgumentException() {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new IllegalArgumentException())
        .when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getType()).thenReturn("Type");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbMsgTimeseriesNode.onMsg(ctx, msg));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(msg).getType();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); when TbContext; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgTimeseriesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContext_thenThrowIllegalArgumentException() {
    // Arrange
    TbMsgTimeseriesNode tbMsgTimeseriesNode = new TbMsgTimeseriesNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbMsgTimeseriesNode.onMsg(ctx, msg));
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link TbMsgTimeseriesNode#computeTs(TbMsg, boolean)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#computeTs(TbMsg, boolean)}
   */
  @Test
  @DisplayName(
      "Test computeTs(TbMsg, boolean); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbMsgTimeseriesNode.computeTs(TbMsg, boolean)"})
  void testComputeTs_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaDataTs()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbMsgTimeseriesNode.computeTs(msg, false));
    verify(msg).getMetaDataTs();
  }

  /**
   * Test {@link TbMsgTimeseriesNode#computeTs(TbMsg, boolean)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link TbMsg} {@link TbMsg#getMetaDataTs()} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNode#computeTs(TbMsg, boolean)}
   */
  @Test
  @DisplayName(
      "Test computeTs(TbMsg, boolean); given one; when TbMsg getMetaDataTs() return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbMsgTimeseriesNode.computeTs(TbMsg, boolean)"})
  void testComputeTs_givenOne_whenTbMsgGetMetaDataTsReturnOne_thenReturnOne() {
    // Arrange
    TbMsg msg = mock(TbMsg.class);
    when(msg.getMetaDataTs()).thenReturn(1L);

    // Act
    long actualComputeTsResult = TbMsgTimeseriesNode.computeTs(msg, false);

    // Assert
    verify(msg).getMetaDataTs();
    assertEquals(1L, actualComputeTsResult);
  }
}
