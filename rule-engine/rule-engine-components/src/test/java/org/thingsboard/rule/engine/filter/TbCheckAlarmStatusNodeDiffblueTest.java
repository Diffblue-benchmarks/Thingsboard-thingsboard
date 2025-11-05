package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.RuleEngineAlarmService;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.id.AlarmId;
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
    TbContext tbContext = TbContextMinimalFactory.minimalForOnMsg();

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
    TbContext tbContext = TbContextMinimalFactory.minimalForOnMsg();

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
    TbContext tbContext = TbContextMinimalFactory.minimalForOnMsg();

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
    TbContext tbContext = TbContextMinimalFactory.minimalForOnMsg();

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
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmByIdAsync(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenThrow(new IllegalArgumentException());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ruleEngineAlarmService).findAlarmByIdAsync(isA(TenantId.class), isNull());
    verify(ctx).getAlarmService();
    verify(ctx).getRuleChainName();
    verify(ctx, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenIllegalArgumentException_thenThrowIllegalArgumentException()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getAlarmService()).thenThrow(new IllegalArgumentException());
    when(ctx.getTenantId()).thenThrow(new IllegalArgumentException());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ctx).getAlarmService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ListenableFutureTask addListener(Runnable, Executor) does nothing; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListenableFutureTaskAddListenerDoesNothing_thenCallsAddListener()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    ListenableFutureTask<Alarm> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Alarm> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Alarm> apiFuture = new ForwardingApiFuture<>(delegate2);

    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmByIdAsync(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCheckAlarmStatusNode.onMsg(ctx, msg);

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(ruleEngineAlarmService).findAlarmByIdAsync(isA(TenantId.class), isNull());
    verify(ctx).getAlarmService();
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} throw {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ListenableFutureTask addListener(Runnable, Executor) throw IllegalArgumentException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenListenableFutureTaskAddListenerThrowIllegalArgumentException()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    ListenableFutureTask<Alarm> delegate = mock(ListenableFutureTask.class);
    doThrow(new IllegalArgumentException())
        .when(delegate)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Alarm> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Alarm> apiFuture = new ForwardingApiFuture<>(delegate2);

    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmByIdAsync(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenReturn(new ApiFutureToListenableFuture<>(apiFuture));

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    verify(ruleEngineAlarmService).findAlarmByIdAsync(isA(TenantId.class), isNull());
    verify(ctx).getAlarmService();
    verify(ctx).getDbCallbackExecutor();
    verify(ctx).getRuleChainName();
    verify(ctx, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuleEngineAlarmService} {@link
   *       RuleEngineAlarmService#findAlarmByIdAsync(TenantId, AlarmId)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckAlarmStatusNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuleEngineAlarmService findAlarmByIdAsync(TenantId, AlarmId) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckAlarmStatusNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuleEngineAlarmServiceFindAlarmByIdAsyncThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbCheckAlarmStatusNode tbCheckAlarmStatusNode = new TbCheckAlarmStatusNode();

    RuleEngineAlarmService ruleEngineAlarmService = mock(RuleEngineAlarmService.class);
    when(ruleEngineAlarmService.findAlarmByIdAsync(Mockito.<TenantId>any(), Mockito.<AlarmId>any()))
        .thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getRuleChainName()).thenReturn("Rule Chain Name");
    when(ctx.getAlarmService()).thenReturn(ruleEngineAlarmService);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(TbNodeException.class, () -> tbCheckAlarmStatusNode.onMsg(ctx, msg));
    verify(ruleEngineAlarmService).findAlarmByIdAsync(isA(TenantId.class), isNull());
    verify(ctx).getAlarmService();
    verify(ctx).getRuleChainName();
    verify(ctx, atLeast(1)).getTenantId();
  }
}
