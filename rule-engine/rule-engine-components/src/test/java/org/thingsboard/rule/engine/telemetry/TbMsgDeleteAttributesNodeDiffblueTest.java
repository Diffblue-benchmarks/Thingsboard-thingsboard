package org.thingsboard.rule.engine.telemetry;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;
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
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
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

@ExtendWith(MockitoExtension.class)
class TbMsgDeleteAttributesNodeDiffblueTest {
  @Mock private List<String> list;

  @InjectMocks private TbMsgDeleteAttributesNode tbMsgDeleteAttributesNode;

  /**
   * Test {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeleteAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    Stream<String> streamResult = stringList.stream();
    when(list.stream()).thenReturn(streamResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    TbMsgBuilder callbackResult = TbMsg.builder().callback(TbMsgCallback.EMPTY);

    TbMsgBuilder correlationIdResult =
        callbackResult.correlationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TbMsgBuilder ctxResult = correlationIdResult.ctx(new TbMsgProcessingCtx());

    TbMsgBuilder dataTypeResult =
        ctxResult
            .customerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .data("42")
            .dataType(TbMsgDataType.JSON);

    TbMsgBuilder internalTypeResult =
        dataTypeResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .internalType(TbMsgType.POST_ATTRIBUTES_REQUEST);

    TbMsgBuilder queueNameResult =
        internalTypeResult
            .metaData(new TbMsgMetaData())
            .originator(null)
            .partition(1)
            .queueName("Queue Name");

    TbMsgBuilder ruleChainIdResult =
        queueNameResult.ruleChainId(
            new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    tbMsgDeleteAttributesNode.onMsg(
        ctx,
        ruleChainIdResult
            .ruleNodeId(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .ts(1L)
            .type("Type")
            .build());

    // Assert
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} addAll {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ArrayList() addAll ArrayList(); then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeleteAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenArrayListAddAllArrayList_thenCallsStream()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    stringList.addAll(new ArrayList<>());
    stringList.add("");
    Stream<String> streamResult = stringList.stream();
    when(list.stream()).thenReturn(streamResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgDeleteAttributesNode.onMsg(ctx, msg);

    // Assert
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add empty string.
   *   <li>When alarmMsg {@code null}.
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given ArrayList() add empty string; when alarmMsg 'null'; then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeleteAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenArrayListAddEmptyString_whenAlarmMsgNull_thenCallsStream()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    Stream<String> streamResult = stringList.stream();
    when(list.stream()).thenReturn(streamResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());

    // Act
    tbMsgDeleteAttributesNode.onMsg(ctx, TbAlarmMsgFactory.alarmMsg(null));

    // Assert
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link List#stream()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeleteAttributesNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls stream()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDeleteAttributesNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsStream()
      throws InterruptedException, ExecutionException, TbNodeException {
    // Arrange
    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("");
    Stream<String> streamResult = stringList.stream();
    when(list.stream()).thenReturn(streamResult);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgDeleteAttributesNode.onMsg(ctx, msg);

    // Assert
    verify(list).stream();
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }
}
