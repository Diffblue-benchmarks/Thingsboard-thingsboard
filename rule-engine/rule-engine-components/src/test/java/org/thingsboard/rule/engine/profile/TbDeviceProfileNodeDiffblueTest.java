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
package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.TbMsg.TbMsgBuilder;
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbDeviceProfileNodeDiffblueTest {
  /**
   * Test {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowIllegalArgumentException() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbDeviceProfileNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance())));
    verify(ctx).getDeviceProfileCache();
  }

  /**
   * Test {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbNodeConfiguration#TbNodeConfiguration(JsonNode)} with data is {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when TbNodeConfiguration(JsonNode) with data is 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenTbNodeConfigurationWithDataIsNull_thenThrowIllegalArgumentException()
      throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbDeviceProfileNode.init(ctx, new TbNodeConfiguration(null)));
    verify(ctx).getDeviceProfileCache();
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenCustomerIdWithIdIsRandomUUID()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbDeviceProfileNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
    verify(msg).getCustomerId();
    verify(msg).getOriginator();
    verify(msg).isTypeOf(TbMsgType.DEVICE_PROFILE_PERIODIC_SELF_MSG);
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} does nothing.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'false'; when TbContext tellSuccess(TbMsg) does nothing; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFalse_whenTbContextTellSuccessDoesNothing_thenCallsTellSuccess()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbDeviceProfileNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
    verify(msg).getOriginator();
    verify(msg, atLeast(1)).isTypeOf(Mockito.<TbMsgType>any());
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} return {@code null}.
   *   <li>Then calls {@link TbContext#tellSelf(TbMsg, long)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'null'; when TbContext getTenantId() return 'null'; then calls tellSelf(TbMsg, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNull_whenTbContextGetTenantIdReturnNull_thenCallsTellSelf()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(null);
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenReturn(null);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbDeviceProfileNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
    verify(msg).getCustomerId();
    verify(msg).getOriginator();
    verify(msg).isTypeOf(TbMsgType.DEVICE_PROFILE_PERIODIC_SELF_MSG);
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext getTenantId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextGetTenantIdThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.onMsg(ctx, msg));
    verify(ctx).getTenantId();
    verify(msg).getOriginator();
    verify(msg).isTypeOf(TbMsgType.DEVICE_PROFILE_PERIODIC_SELF_MSG);
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getCustomerId()} return {@code null}.
   *   <li>Then calls {@link TbContext#tellSelf(TbMsg, long)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg getCustomerId() return 'null'; then calls tellSelf(TbMsg, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgGetCustomerIdReturnNull_thenCallsTellSelf()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenReturn(null);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    tbDeviceProfileNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
    verify(msg).getCustomerId();
    verify(msg).getOriginator();
    verify(msg).isTypeOf(TbMsgType.DEVICE_PROFILE_PERIODIC_SELF_MSG);
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getOriginator()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg getOriginator() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgGetOriginatorThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getOriginator()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.onMsg(ctx, msg));
    verify(msg).getOriginator();
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg isTypeOf(TbMsgType) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgIsTypeOfThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenThrow(new IllegalArgumentException());
    when(msg.getOriginator()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.onMsg(ctx, msg));
    verify(msg).getOriginator();
    verify(msg).isTypeOf(TbMsgType.DEVICE_PROFILE_PERIODIC_SELF_MSG);
  }

  /**
   * Test {@link TbDeviceProfileNode#getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#getOrCreateDeviceState(TbContext, DeviceId,
   * RuleNodeState, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.rule.engine.profile.DeviceState TbDeviceProfileNode.getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean)"
  })
  void testGetOrCreateDeviceState_thenThrowIllegalArgumentException() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException());
    DeviceId deviceId = new DeviceId(UUID.randomUUID());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbDeviceProfileNode.getOrCreateDeviceState(ctx, deviceId, new RuleNodeState(), true));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test scheduleAlarmHarvesting(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.scheduleAlarmHarvesting(TbContext, TbMsg)"})
  void testScheduleAlarmHarvesting() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, mock(TbMsg.class)));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test scheduleAlarmHarvesting(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.scheduleAlarmHarvesting(TbContext, TbMsg)"})
  void testScheduleAlarmHarvesting2() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(null);
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

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
    tbDeviceProfileNode.scheduleAlarmHarvesting(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.randomUUID()))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link CustomerId#CustomerId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test scheduleAlarmHarvesting(TbContext, TbMsg); given CustomerId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.scheduleAlarmHarvesting(TbContext, TbMsg)"})
  void testScheduleAlarmHarvesting_givenCustomerIdWithIdIsRandomUUID() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(null);
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenReturn(new CustomerId(UUID.randomUUID()));

    // Act
    tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, msg);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
    verify(msg).getCustomerId();
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@code null}.
   *   <li>Then calls {@link TbContext#tellSelf(TbMsg, long)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test scheduleAlarmHarvesting(TbContext, TbMsg); given 'null'; when 'null'; then calls tellSelf(TbMsg, long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.scheduleAlarmHarvesting(TbContext, TbMsg)"})
  void testScheduleAlarmHarvesting_givenNull_whenNull_thenCallsTellSelf() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(null);
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    // Act
    tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, null);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test scheduleAlarmHarvesting(TbContext, TbMsg); given TenantId(UUID) with id is randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.scheduleAlarmHarvesting(TbContext, TbMsg)"})
  void testScheduleAlarmHarvesting_givenTenantIdWithIdIsRandomUUID() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenReturn(null);

    // Act
    tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, msg);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
    verify(msg).getCustomerId();
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getCustomerId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test scheduleAlarmHarvesting(TbContext, TbMsg); when TbMsg getCustomerId() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.scheduleAlarmHarvesting(TbContext, TbMsg)"})
  void testScheduleAlarmHarvesting_whenTbMsgGetCustomerIdReturnNull() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(null);
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenReturn(null);

    // Act
    tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, msg);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
    verify(msg).getCustomerId();
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getCustomerId()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test scheduleAlarmHarvesting(TbContext, TbMsg); when TbMsg getCustomerId() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.scheduleAlarmHarvesting(TbContext, TbMsg)"})
  void testScheduleAlarmHarvesting_whenTbMsgGetCustomerIdThrowIllegalArgumentException() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(null);

    TbMsg msg = mock(TbMsg.class);
    when(msg.getCustomerId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, msg));
    verify(ctx).getTenantId();
    verify(msg).getCustomerId();
  }

  /**
   * Test {@link TbDeviceProfileNode#updateProfile(TbContext, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#updateProfile(TbContext, DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test updateProfile(TbContext, DeviceProfileId); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.updateProfile(TbContext, DeviceProfileId)"})
  void testUpdateProfile_thenThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tbDeviceProfileNode.updateProfile(ctx, null));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given True.
   *   <li>Then return Second toPrettyString is {@code { "persistAlarmRulesState" : true }}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given True; then return Second toPrettyString is '{ \"persistAlarmRulesState\" : true }'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenTrue_thenReturnSecondToPrettyStringIsPersistAlarmRulesStateTrue()
      throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("persistAlarmRulesState", BooleanNode.getTrue());

    // Act and Assert
    JsonNode second = tbDeviceProfileNode.upgrade(0, oldConfiguration).getSecond();
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(second instanceof ObjectNode);
    assertEquals("{\n  \"persistAlarmRulesState\" : true\n}", second.toPrettyString());
    assertFalse(iteratorResult.hasNext());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(BooleanNode.TRUE, nextResult);
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second is {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   *       withExactBigDecimals {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then return Second is ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_thenReturnSecondIsArrayNodeWithNfIsWithExactBigDecimalsTrue()
      throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode oldConfiguration = new ArrayNode(nf);

    // Act and Assert
    assertSame(oldConfiguration, tbDeviceProfileNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second is {@link ObjectNode#ObjectNode(JsonNodeFactory)} with nc is
   *       withExactBigDecimals {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); then return Second is ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_thenReturnSecondIsObjectNodeWithNcIsWithExactBigDecimalsFalse()
      throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(false);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    BigInteger v = BigInteger.valueOf(1L);
    oldConfiguration.put("persistAlarmRulesState", new BigIntegerNode(v));

    // Act and Assert
    assertSame(oldConfiguration, tbDeviceProfileNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Then return Second iterator next is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second iterator next is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_thenReturnSecondIteratorNextIsValueOfTen() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    DoubleNode value = DoubleNode.valueOf(10.0d);
    oldConfiguration.put("fetchAlarmRulesStateOnStart", value);

    // Act and Assert
    JsonNode second = tbDeviceProfileNode.upgrade(0, oldConfiguration).getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(value, actualNextResult);
    assertEquals("{\n  \"fetchAlarmRulesStateOnStart\" : 10.0\n}", second.toPrettyString());
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenOne_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbDeviceProfileNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>When valueOf ten.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when valueOf ten; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_whenValueOfTen_thenReturnSecondIsValueOfTen() throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbDeviceProfileNode().upgrade(0, oldConfiguration).getSecond());
  }
}
