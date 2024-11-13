package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
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
import org.thingsboard.server.common.msg.TbMsgDataType;
import org.thingsboard.server.common.msg.TbMsgMetaData;
import org.thingsboard.server.common.msg.TbMsgProcessingCtx;
import org.thingsboard.server.common.msg.queue.TbMsgCallback;

class TbDeviceProfileNodeDiffblueTest {
  /**
   * Test {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw IllegalArgumentException")
  void testInit_thenThrowIllegalArgumentException() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenThrow(new IllegalArgumentException("{}"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.init(ctx, new TbNodeConfiguration(null)));
    verify(ctx).getDeviceProfileCache();
  }

  /**
   * Test {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw IllegalArgumentException")
  void testInit_thenThrowIllegalArgumentException2() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenThrow(new IllegalArgumentException("{}"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> tbDeviceProfileNode.init(ctx, new TbNodeConfiguration(NullNode.getInstance())));
    verify(ctx).getDeviceProfileCache();
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg() throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new AlarmId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbDeviceProfileNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   * <p>
   * Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  void testOnMsg2() throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID()).internalType(TbMsgType.ENTITY_UPDATED);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new DeviceId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbDeviceProfileNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then throw IllegalArgumentException")
  void testOnMsg_thenThrowIllegalArgumentException() throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException("foo"));
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder metaDataResult = internalTypeResult.metaData(new TbMsgMetaData());
    TbMsg.TbMsgBuilder queueNameResult = metaDataResult.originator(new DeviceId(UUID.randomUUID()))
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.onMsg(ctx, msg));
    verify(ctx).getTenantId();
  }

  /**
   * Test
   * {@link TbDeviceProfileNode#getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeviceProfileNode#getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean)}
   */
  @Test
  @DisplayName("Test getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean); then throw IllegalArgumentException")
  void testGetOrCreateDeviceState_thenThrowIllegalArgumentException() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException("foo"));
    DeviceId deviceId = new DeviceId(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> tbDeviceProfileNode.getOrCreateDeviceState(ctx, deviceId, new RuleNodeState(), true));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   * <p>
   * Method under test:
   * {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test scheduleAlarmHarvesting(TbContext, TbMsg)")
  void testScheduleAlarmHarvesting() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());
    TbMsg.TbMsgBuilder callbackResult = TbMsg.builder().callback(mock(TbMsgCallback.class));
    TbMsg.TbMsgBuilder correlationIdResult = callbackResult.correlationId(UUID.randomUUID());
    TbMsg.TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());
    TbMsg.TbMsgBuilder dataTypeResult = ctxResult.customerId(new CustomerId(UUID.randomUUID()))
        .data("Data")
        .dataType(TbMsgDataType.JSON);
    TbMsg.TbMsgBuilder internalTypeResult = dataTypeResult.id(UUID.randomUUID())
        .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);
    TbMsg.TbMsgBuilder queueNameResult = internalTypeResult.metaData(new TbMsgMetaData())
        .originator(null)
        .partition(1)
        .queueName("Queue Name");
    TbMsg.TbMsgBuilder ruleChainIdResult = queueNameResult.ruleChainId(new RuleChainId(UUID.randomUUID()));
    TbMsg msg = ruleChainIdResult.ruleNodeId(new RuleNodeId(UUID.randomUUID())).ts(1L).type("Type").build();

    // Act
    tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, msg);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test scheduleAlarmHarvesting(TbContext, TbMsg); given 'null'; when TbContext getTenantId() return 'null'")
  void testScheduleAlarmHarvesting_givenNull_whenTbContextGetTenantIdReturnNull() {
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
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test scheduleAlarmHarvesting(TbContext, TbMsg); given TenantId(UUID) with id is randomUUID")
  void testScheduleAlarmHarvesting_givenTenantIdWithIdIsRandomUUID() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    // Act
    tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, null);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test scheduleAlarmHarvesting(TbContext, TbMsg); then throw IllegalArgumentException")
  void testScheduleAlarmHarvesting_thenThrowIllegalArgumentException() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException("{}"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, null));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#updateProfile(TbContext, DeviceProfileId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbDeviceProfileNode#updateProfile(TbContext, DeviceProfileId)}
   */
  @Test
  @DisplayName("Test updateProfile(TbContext, DeviceProfileId); then throw IllegalArgumentException")
  void testUpdateProfile_thenThrowIllegalArgumentException() throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.updateProfile(ctx, null));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Then return Second is {@link ArrayNode#ArrayNode(JsonNodeFactory)} with
   * nf is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second is ArrayNode(JsonNodeFactory) with nf is withExactBigDecimals 'true'")
  void testUpgrade_thenReturnSecondIsArrayNodeWithNfIsWithExactBigDecimalsTrue() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    ArrayNode oldConfiguration = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertSame(oldConfiguration, tbDeviceProfileNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>Then return Second is {@link ObjectNode#ObjectNode(JsonNodeFactory)} with
   * nc is withExactBigDecimals {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); then return Second is ObjectNode(JsonNodeFactory) with nc is withExactBigDecimals 'true'")
  void testUpgrade_thenReturnSecondIsObjectNodeWithNcIsWithExactBigDecimalsTrue() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    ObjectNode oldConfiguration = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));

    // Act and Assert
    assertSame(oldConfiguration, tbDeviceProfileNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when Instance; then return Second is Instance")
  void testUpgrade_whenInstance_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbDeviceProfileNode.upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return Second is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); when one; then return Second is Instance")
  void testUpgrade_whenOne_thenReturnSecondIsInstance() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    MissingNode oldConfiguration = MissingNode.getInstance();

    // Act and Assert
    assertSame(oldConfiguration, tbDeviceProfileNode.upgrade(1, oldConfiguration).getSecond());
  }
}
