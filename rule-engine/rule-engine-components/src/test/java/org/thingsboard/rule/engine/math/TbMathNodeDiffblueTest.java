package org.thingsboard.rule.engine.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.TestDbCallbackExecutor;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.rule.engine.math.TbMathNodeTest.DBCallbackExecutor;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;

@ExtendWith(MockitoExtension.class)
class TbMathNodeDiffblueTest {
  @InjectMocks private TbMathNode tbMathNode;

  @Mock private TbMathNodeConfiguration tbMathNodeConfiguration;

  /**
   * Test {@link TbMathNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Given {@code START_OBJECT}.
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} return {@code START_OBJECT}.
   *   <li>Then calls {@link ArrayNode#fields()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); given 'START_OBJECT'; when ArrayNode asToken() return 'START_OBJECT'; then calls fields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMathNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_givenStartObject_whenArrayNodeAsTokenReturnStartObject_thenCallsFields()
      throws TbNodeException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.fields()).thenThrow(new RuntimeException());
    when(data.asToken()).thenReturn(JsonToken.START_OBJECT);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMathNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).fields();
    verify(data, atLeast(1)).asToken();
  }

  /**
   * Test {@link TbMathNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>When {@link ArrayNode} {@link ArrayNode#asToken()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName(
      "Test init(TbContext, TbNodeConfiguration); when ArrayNode asToken() throw RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMathNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_whenArrayNodeAsTokenThrowRuntimeException_thenThrowRuntimeException()
      throws TbNodeException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    ArrayNode data = mock(ArrayNode.class);
    when(data.asToken()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMathNode.init(ctx, new TbNodeConfiguration(data)));
    verify(data).asToken();
  }

  /**
   * Test {@link TbMathNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMathNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMathNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsgAsync(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync() {
    // Arrange
    when(tbMathNodeConfiguration.getArguments()).thenThrow(new RuntimeException());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMathNode.processMsgAsync(ctx, msg));
    verify(tbMathNodeConfiguration).getArguments();
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsgAsync(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync2() {
    // Arrange
    when(tbMathNodeConfiguration.getOperation()).thenThrow(new RuntimeException());
    when(tbMathNodeConfiguration.getArguments()).thenReturn(new ArrayList<>());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<TbMsg> actualProcessMsgAsyncResult = tbMathNode.processMsgAsync(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(tbMathNodeConfiguration).getArguments();
    verify(tbMathNodeConfiguration).getOperation();
    assertTrue(actualProcessMsgAsyncResult.isDone());
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsgAsync(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync3() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.MESSAGE_BODY, "Key");
    tbMathArgument.setDefaultValue(10.0d);

    ArrayList<TbMathArgument> tbMathArgumentList = new ArrayList<>();
    tbMathArgumentList.add(tbMathArgument);
    when(tbMathNodeConfiguration.getOperation()).thenReturn(TbRuleNodeMathFunctionType.ADD);
    when(tbMathNodeConfiguration.getArguments()).thenReturn(tbMathArgumentList);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<TbMsg> actualProcessMsgAsyncResult = tbMathNode.processMsgAsync(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(tbMathNodeConfiguration).getArguments();
    verify(tbMathNodeConfiguration).getOperation();
    assertTrue(actualProcessMsgAsyncResult.isDone());
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsgAsync(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync4() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.MESSAGE_METADATA, "Key");
    tbMathArgument.setDefaultValue(10.0d);

    ArrayList<TbMathArgument> tbMathArgumentList = new ArrayList<>();
    tbMathArgumentList.add(tbMathArgument);
    when(tbMathNodeConfiguration.getOperation()).thenReturn(TbRuleNodeMathFunctionType.ADD);
    when(tbMathNodeConfiguration.getArguments()).thenReturn(tbMathArgumentList);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<TbMsg> actualProcessMsgAsyncResult = tbMathNode.processMsgAsync(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(tbMathNodeConfiguration).getArguments();
    verify(tbMathNodeConfiguration).getOperation();
    assertTrue(actualProcessMsgAsyncResult.isDone());
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsgAsync(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync5() {
    // Arrange
    TbMathArgument tbMathArgument = new TbMathArgument(TbMathArgumentType.MESSAGE_BODY, "$[UU]");
    tbMathArgument.setDefaultValue(10.0d);

    ArrayList<TbMathArgument> tbMathArgumentList = new ArrayList<>();
    tbMathArgumentList.add(tbMathArgument);
    when(tbMathNodeConfiguration.getOperation()).thenReturn(TbRuleNodeMathFunctionType.ADD);
    when(tbMathNodeConfiguration.getArguments()).thenReturn(tbMathArgumentList);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<TbMsg> actualProcessMsgAsyncResult = tbMathNode.processMsgAsync(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(tbMathNodeConfiguration).getArguments();
    verify(tbMathNodeConfiguration).getOperation();
    assertTrue(actualProcessMsgAsyncResult.isDone());
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       TbMathArgument#TbMathArgument(TbMathArgumentType, String)} with type is {@code CONSTANT}
   *       and key is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsgAsync(TbContext, TbMsg); given ArrayList() add TbMathArgument(TbMathArgumentType, String) with type is 'CONSTANT' and key is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync_givenArrayListAddTbMathArgumentWithTypeIsConstantAndKeyIs42() {
    // Arrange
    ArrayList<TbMathArgument> tbMathArgumentList = new ArrayList<>();
    tbMathArgumentList.add(new TbMathArgument(TbMathArgumentType.CONSTANT, "42"));
    when(tbMathNodeConfiguration.getOperation()).thenReturn(TbRuleNodeMathFunctionType.ADD);
    when(tbMathNodeConfiguration.getArguments()).thenReturn(tbMathArgumentList);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<TbMsg> actualProcessMsgAsyncResult = tbMathNode.processMsgAsync(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(tbMathNodeConfiguration).getArguments();
    verify(tbMathNodeConfiguration).getOperation();
    assertTrue(actualProcessMsgAsyncResult.isDone());
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link DBCallbackExecutor} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsgAsync(TbContext, TbMsg); given DBCallbackExecutor (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync_givenDBCallbackExecutor() {
    // Arrange
    ArrayList<TbMathArgument> tbMathArgumentList = new ArrayList<>();
    tbMathArgumentList.add(new TbMathArgument(TbMathArgumentType.CONSTANT, "42"));
    when(tbMathNodeConfiguration.getArguments()).thenReturn(tbMathArgumentList);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new DBCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMathNode.processMsgAsync(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(tbMathNodeConfiguration).getArguments();
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMathNodeConfiguration} {@link TbMathNodeConfiguration#getOperation()}
   *       return {@code DIV}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsgAsync(TbContext, TbMsg); given TbMathNodeConfiguration getOperation() return 'DIV'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync_givenTbMathNodeConfigurationGetOperationReturnDiv() {
    // Arrange
    ArrayList<TbMathArgument> tbMathArgumentList = new ArrayList<>();
    tbMathArgumentList.add(new TbMathArgument(TbMathArgumentType.CONSTANT, "42"));
    when(tbMathNodeConfiguration.getOperation()).thenReturn(TbRuleNodeMathFunctionType.DIV);
    when(tbMathNodeConfiguration.getArguments()).thenReturn(tbMathArgumentList);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<TbMsg> actualProcessMsgAsyncResult = tbMathNode.processMsgAsync(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(tbMathNodeConfiguration).getArguments();
    verify(tbMathNodeConfiguration).getOperation();
    assertTrue(actualProcessMsgAsyncResult.isDone());
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMathNodeConfiguration} {@link TbMathNodeConfiguration#getOperation()}
   *       return {@code MULT}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsgAsync(TbContext, TbMsg); given TbMathNodeConfiguration getOperation() return 'MULT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync_givenTbMathNodeConfigurationGetOperationReturnMult() {
    // Arrange
    ArrayList<TbMathArgument> tbMathArgumentList = new ArrayList<>();
    tbMathArgumentList.add(new TbMathArgument(TbMathArgumentType.CONSTANT, "42"));
    when(tbMathNodeConfiguration.getOperation()).thenReturn(TbRuleNodeMathFunctionType.MULT);
    when(tbMathNodeConfiguration.getArguments()).thenReturn(tbMathArgumentList);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<TbMsg> actualProcessMsgAsyncResult = tbMathNode.processMsgAsync(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(tbMathNodeConfiguration).getArguments();
    verify(tbMathNodeConfiguration).getOperation();
    assertTrue(actualProcessMsgAsyncResult.isDone());
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMathNodeConfiguration} {@link TbMathNodeConfiguration#getOperation()}
   *       return {@code SUB}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsgAsync(TbContext, TbMsg); given TbMathNodeConfiguration getOperation() return 'SUB'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync_givenTbMathNodeConfigurationGetOperationReturnSub() {
    // Arrange
    ArrayList<TbMathArgument> tbMathArgumentList = new ArrayList<>();
    tbMathArgumentList.add(new TbMathArgument(TbMathArgumentType.CONSTANT, "42"));
    when(tbMathNodeConfiguration.getOperation()).thenReturn(TbRuleNodeMathFunctionType.SUB);
    when(tbMathNodeConfiguration.getArguments()).thenReturn(tbMathArgumentList);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<TbMsg> actualProcessMsgAsyncResult = tbMathNode.processMsgAsync(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(tbMathNodeConfiguration).getArguments();
    verify(tbMathNodeConfiguration).getOperation();
    assertTrue(actualProcessMsgAsyncResult.isDone());
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsgAsync(TbContext, TbMsg); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync_thenCallsGetTenantId() {
    // Arrange
    ArrayList<TbMathArgument> tbMathArgumentList = new ArrayList<>();
    tbMathArgumentList.add(new TbMathArgument(TbMathArgumentType.TIME_SERIES, "Key"));
    when(tbMathNodeConfiguration.getArguments()).thenReturn(tbMathArgumentList);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTimeseriesService()).thenReturn(new BaseTimeseriesService());
    when(ctx.getTenantId()).thenThrow(new RuntimeException());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMathNode.processMsgAsync(ctx, msg));
    verify(ctx).getTenantId();
    verify(ctx).getTimeseriesService();
    verify(tbMathNodeConfiguration).getArguments();
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then return Done.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsgAsync(TbContext, TbMsg); then return Done")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync_thenReturnDone() {
    // Arrange
    when(tbMathNodeConfiguration.getOperation()).thenReturn(TbRuleNodeMathFunctionType.ADD);
    when(tbMathNodeConfiguration.getArguments()).thenReturn(new ArrayList<>());

    TbContext ctx = mock(TbContext.class);
    when(ctx.getDbCallbackExecutor()).thenReturn(new TestDbCallbackExecutor());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    ListenableFuture<TbMsg> actualProcessMsgAsyncResult = tbMathNode.processMsgAsync(ctx, msg);

    // Assert
    verify(ctx).getDbCallbackExecutor();
    verify(tbMathNodeConfiguration).getArguments();
    verify(tbMathNodeConfiguration).getOperation();
    assertTrue(actualProcessMsgAsyncResult.isDone());
  }

  /**
   * Test {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getTimeseriesService()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsgAsync(TbContext, TbMsg); when TbContext getTimeseriesService() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TbMathNode.processMsgAsync(TbContext, TbMsg)"})
  void testProcessMsgAsync_whenTbContextGetTimeseriesServiceThrowRuntimeException() {
    // Arrange
    ArrayList<TbMathArgument> tbMathArgumentList = new ArrayList<>();
    tbMathArgumentList.add(new TbMathArgument(TbMathArgumentType.TIME_SERIES, "Key"));
    when(tbMathNodeConfiguration.getArguments()).thenReturn(tbMathArgumentList);

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTimeseriesService()).thenThrow(new RuntimeException());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMathNode.processMsgAsync(ctx, msg));
    verify(ctx).getTimeseriesService();
    verify(tbMathNodeConfiguration).getArguments();
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName("Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments() throws InterruptedException, ExecutionException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.MESSAGE_BODY, "Key");
    arg.setDefaultValue(10.0d);
    arg.setAttributeScope("$[UU]");

    // Act
    ListenableFuture<TbMathArgumentValue> actualResolveArgumentsResult =
        tbMathNode.resolveArguments(ctx, msg, msgBodyOpt, arg);

    // Assert
    assertEquals(10.0d, actualResolveArgumentsResult.get().getValue());
    assertTrue(actualResolveArgumentsResult.isDone());
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName("Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments2() throws InterruptedException, ExecutionException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.MESSAGE_METADATA, "Key");
    arg.setDefaultValue(10.0d);
    arg.setAttributeScope("$[UU]");

    // Act
    ListenableFuture<TbMathArgumentValue> actualResolveArgumentsResult =
        tbMathNode.resolveArguments(ctx, msg, msgBodyOpt, arg);

    // Assert
    assertEquals(10.0d, actualResolveArgumentsResult.get().getValue());
    assertTrue(actualResolveArgumentsResult.isDone());
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName("Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments3() throws InterruptedException, ExecutionException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.MESSAGE_BODY, "$[UU]");
    arg.setDefaultValue(10.0d);
    arg.setAttributeScope("$[UU]");

    // Act
    ListenableFuture<TbMathArgumentValue> actualResolveArgumentsResult =
        tbMathNode.resolveArguments(ctx, msg, msgBodyOpt, arg);

    // Assert
    assertEquals(10.0d, actualResolveArgumentsResult.get().getValue());
    assertTrue(actualResolveArgumentsResult.isDone());
  }

  /**
   * Test {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} Value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbMathNode#resolveArguments(TbContext, TbMsg, Optional,
   * TbMathArgument)}
   */
  @Test
  @DisplayName(
      "Test resolveArguments(TbContext, TbMsg, Optional, TbMathArgument); then return get() Value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TbMathNode.resolveArguments(TbContext, TbMsg, Optional, TbMathArgument)"
  })
  void testResolveArguments_thenReturnGetValueIsFortyTwo()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbMathNode tbMathNode = new TbMathNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);
    Optional<ObjectNode> msgBodyOpt = Optional.of(new ObjectNode(nc));

    TbMathArgument arg = new TbMathArgument(TbMathArgumentType.CONSTANT, "42");
    arg.setAttributeScope("$[UU]");

    // Act
    ListenableFuture<TbMathArgumentValue> actualResolveArgumentsResult =
        tbMathNode.resolveArguments(ctx, msg, msgBodyOpt, arg);

    // Assert
    assertEquals(42.0d, actualResolveArgumentsResult.get().getValue());
    assertTrue(actualResolveArgumentsResult.isDone());
  }
}
