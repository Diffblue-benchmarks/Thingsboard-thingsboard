package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.action.TbAlarmMsgFactory;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.RuleEngineDeviceProfileCache;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbDeviceProfileNodeDiffblueTest {
  @Mock private RuleEngineDeviceProfileCache ruleEngineDeviceProfileCache;

  @Mock private TbContext tbContext;

  @InjectMocks private TbDeviceProfileNode tbDeviceProfileNode;

  /**
   * Test {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} iterator.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given ArrayList() iterator; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenArrayListIterator_thenCallsFields() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).clearRuleNodeStates();
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenReturn(true);
    when(ctx.getDeviceProfileCache()).thenReturn(mock(RuleEngineDeviceProfileCache.class));
    when(ctx.getSelfId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing()
        .when(ctx)
        .addDeviceProfileListeners(
            Mockito.<Consumer<DeviceProfile>>any(),
            Mockito.<BiConsumer<DeviceId, DeviceProfile>>any());
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act
    tbDeviceProfileNode.init(ctx, new TbNodeConfiguration(data));

    // Assert
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).addDeviceProfileListeners(isA(Consumer.class), isA(BiConsumer.class));
    verify(ctx).clearRuleNodeStates();
    verify(ctx).getDeviceProfileCache();
    verify(ctx, atLeast(1)).getSelfId();
    verify(ctx).getTenantId();
    verify(ctx).isLocalEntity(isA(EntityId.class));
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
  }

  /**
   * Test {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then calls {@link TbNodeConfiguration#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenCallsGetData() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getEntityType()).thenThrow(new IllegalArgumentException());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDeviceProfileCache()).thenReturn(mock(RuleEngineDeviceProfileCache.class));
    when(ctx.getTenantId()).thenReturn(tenantId);

    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_OBJECT);

    TbNodeConfiguration configuration = mock(TbNodeConfiguration.class);
    when(configuration.getData()).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> tbDeviceProfileNode.init(ctx, configuration));
    verify(arrayNode, atLeast(1)).asToken();
    verify(ctx).getDeviceProfileCache();
    verify(ctx).getTenantId();
    verify(configuration).getData();
    verify(tenantId).getEntityType();
  }

  /**
   * Test {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#clearRuleNodeStates()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when TbContext clearRuleNodeStates() throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenTbContextClearRuleNodeStatesThrowIllegalArgumentException()
      throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new IllegalArgumentException()).when(ctx).clearRuleNodeStates();
    when(ctx.isLocalEntity(Mockito.<EntityId>any())).thenReturn(true);
    when(ctx.getDeviceProfileCache()).thenReturn(mock(RuleEngineDeviceProfileCache.class));
    when(ctx.getSelfId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing()
        .when(ctx)
        .addDeviceProfileListeners(
            Mockito.<Consumer<DeviceProfile>>any(),
            Mockito.<BiConsumer<DeviceId, DeviceProfile>>any());
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    ArrayNode data = mock(ArrayNode.class);

    ArrayList<Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(data.fields()).thenReturn(entryList.iterator());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbDeviceProfileNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
    verify(ctx).addDeviceProfileListeners(isA(Consumer.class), isA(BiConsumer.class));
    verify(ctx).clearRuleNodeStates();
    verify(ctx).getDeviceProfileCache();
    verify(ctx, atLeast(1)).getSelfId();
    verify(ctx).getTenantId();
    verify(ctx).isLocalEntity(isA(EntityId.class));
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); given IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenIllegalArgumentException() throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException());
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.onMsg(ctx, msg));
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbContext} {@link TbContext#ack(TbMsg)} does nothing.
   *   <li>When {@link TbContext}.
   *   <li>Then calls {@link RuleEngineDeviceProfileCache#get(TenantId, DeviceId)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbContext ack(TbMsg) does nothing; when TbContext; then calls get(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbContextAckDoesNothing_whenTbContext_thenCallsGet()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(ruleEngineDeviceProfileCache.get(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);
    doNothing().when(tbContext).ack(Mockito.<TbMsg>any());
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbDeviceProfileNode.onMsg(tbContext, msg);

    // Assert
    verify(ruleEngineDeviceProfileCache).get(isA(TenantId.class), isA(DeviceId.class));
    verify(tbContext).ack(isA(TbMsg.class));
    verify(tbContext).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbContext} {@link TbContext#ack(TbMsg)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then calls {@link RuleEngineDeviceProfileCache#get(TenantId, DeviceId)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbContext ack(TbMsg) throw IllegalArgumentException(); then calls get(TenantId, DeviceId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbContextAckThrowIllegalArgumentException_thenCallsGet()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(ruleEngineDeviceProfileCache.get(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);
    doThrow(new IllegalArgumentException()).when(tbContext).ack(Mockito.<TbMsg>any());
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.onMsg(tbContext, msg));
    verify(ruleEngineDeviceProfileCache).get(isA(TenantId.class), isA(DeviceId.class));
    verify(tbContext).ack(isA(TbMsg.class));
    verify(tbContext).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbContext tellSuccess(TbMsg) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbContextTellSuccessThrowIllegalArgumentException()
      throws InterruptedException, ExecutionException {
    // Arrange
    doThrow(new IllegalArgumentException()).when(tbContext).tellSuccess(Mockito.<TbMsg>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbDeviceProfileNode.onMsg(tbContext, msg));
    verify(tbContext).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbDeviceProfileNode} (default constructor).
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbDeviceProfileNode (default constructor); then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbDeviceProfileNode_thenCallsTellSuccess()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbDeviceProfileNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbDeviceProfileNode#getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#getOrCreateDeviceState(TbContext, DeviceId,
   * RuleNodeState, boolean)}
   */
  @Test
  @DisplayName(
      "Test getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceState TbDeviceProfileNode.getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean)"
  })
  void testGetOrCreateDeviceState_thenReturnNull() {
    // Arrange
    when(ruleEngineDeviceProfileCache.get(Mockito.<TenantId>any(), Mockito.<DeviceId>any()))
        .thenReturn(null);
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    DeviceState actualOrCreateDeviceState =
        tbDeviceProfileNode.getOrCreateDeviceState(tbContext, deviceId, new RuleNodeState(), true);

    // Assert
    verify(ruleEngineDeviceProfileCache).get(isA(TenantId.class), isA(DeviceId.class));
    verify(tbContext).getTenantId();
    assertNull(actualOrCreateDeviceState);
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
    "DeviceState TbDeviceProfileNode.getOrCreateDeviceState(TbContext, DeviceId, RuleNodeState, boolean)"
  })
  void testGetOrCreateDeviceState_thenThrowIllegalArgumentException() {
    // Arrange
    when(tbContext.getTenantId()).thenThrow(new IllegalArgumentException());
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            tbDeviceProfileNode.getOrCreateDeviceState(
                tbContext, deviceId, new RuleNodeState(), true));
    verify(tbContext).getTenantId();
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
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, msg);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
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
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    // Act
    tbDeviceProfileNode.scheduleAlarmHarvesting(
        ctx,
        TbAlarmMsgFactory.alarmMsg(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test scheduleAlarmHarvesting(TbContext, TbMsg); given 'null'; when TbContext getTenantId() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.scheduleAlarmHarvesting(TbContext, TbMsg)"})
  void testScheduleAlarmHarvesting_givenNull_whenTbContextGetTenantIdReturnNull() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenReturn(null);
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, msg);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test scheduleAlarmHarvesting(TbContext, TbMsg); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.scheduleAlarmHarvesting(TbContext, TbMsg)"})
  void testScheduleAlarmHarvesting_thenThrowIllegalArgumentException() {
    // Arrange
    when(tbContext.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbDeviceProfileNode.scheduleAlarmHarvesting(tbContext, null));
    verify(tbContext).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#scheduleAlarmHarvesting(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test scheduleAlarmHarvesting(TbContext, TbMsg); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.scheduleAlarmHarvesting(TbContext, TbMsg)"})
  void testScheduleAlarmHarvesting_whenNull() {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(ctx).tellSelf(Mockito.<TbMsg>any(), anyLong());

    // Act
    tbDeviceProfileNode.scheduleAlarmHarvesting(ctx, null);

    // Assert
    verify(ctx).getTenantId();
    verify(ctx).tellSelf(isA(TbMsg.class), eq(60000L));
  }

  /**
   * Test {@link TbDeviceProfileNode#updateProfile(TbContext, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleEngineDeviceProfileCache#get(TenantId, DeviceProfileId)}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#updateProfile(TbContext, DeviceProfileId)}
   */
  @Test
  @DisplayName(
      "Test updateProfile(TbContext, DeviceProfileId); then calls get(TenantId, DeviceProfileId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.updateProfile(TbContext, DeviceProfileId)"})
  void testUpdateProfile_thenCallsGet() throws InterruptedException, ExecutionException {
    // Arrange
    when(ruleEngineDeviceProfileCache.get(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(new DeviceProfile());
    when(tbContext.getSelfId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(tbContext.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    tbDeviceProfileNode.updateProfile(tbContext, null);

    // Assert
    verify(ruleEngineDeviceProfileCache).get(isA(TenantId.class), (DeviceProfileId) isNull());
    verify(tbContext).getSelfId();
    verify(tbContext).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#onProfileUpdate(DeviceProfile)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#onProfileUpdate(DeviceProfile)}
   */
  @Test
  @DisplayName("Test onProfileUpdate(DeviceProfile); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbDeviceProfileNode.onProfileUpdate(DeviceProfile)"})
  void testOnProfileUpdate_thenThrowIllegalArgumentException() {
    // Arrange
    when(tbContext.getTenantId()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> tbDeviceProfileNode.onProfileUpdate(new DeviceProfile()));
    verify(tbContext).getTenantId();
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link TbDeviceProfileNode} (default constructor).
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given TbDeviceProfileNode (default constructor); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenTbDeviceProfileNode_whenOne_thenReturnSecondIsValueOfTen()
      throws TbNodeException {
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
   *   <li>Given {@link TbDeviceProfileNode} (default constructor).
   *   <li>When valueOf ten.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given TbDeviceProfileNode (default constructor); when valueOf ten; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenTbDeviceProfileNode_whenValueOfTen_thenReturnSecondIsValueOfTen()
      throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(
        oldConfiguration, new TbDeviceProfileNode().upgrade(0, oldConfiguration).getSecond());
  }

  /**
   * Test {@link TbDeviceProfileNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given True.
   *   <li>Then return Second iterator next is {@link BooleanNode#TRUE}.
   * </ul>
   *
   * <p>Method under test: {@link TbDeviceProfileNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName("Test upgrade(int, JsonNode); given True; then return Second iterator next is TRUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair TbDeviceProfileNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenTrue_thenReturnSecondIteratorNextIsTrue() throws TbNodeException {
    // Arrange
    TbDeviceProfileNode tbDeviceProfileNode = new TbDeviceProfileNode();
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode oldConfiguration = new ObjectNode(nc);
    oldConfiguration.put("persistAlarmRulesState", BooleanNode.getTrue());

    // Act and Assert
    JsonNode second = tbDeviceProfileNode.upgrade(0, oldConfiguration).getSecond();
    assertTrue(second instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = second.iterator();
    JsonNode actualNextResult = iteratorResult.next();
    assertFalse(iteratorResult.hasNext());
    assertSame(BooleanNode.TRUE, actualNextResult);
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
    BigInteger v = BigInteger.valueOf(42L);
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
  }
}
