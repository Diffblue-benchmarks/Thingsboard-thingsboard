package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.POJONode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeConfiguration;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class CalculateDeltaNodeDiffblueTest {
  @InjectMocks private CalculateDeltaNode calculateDeltaNode;

  @Mock private CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration;

  /**
   * Test {@link CalculateDeltaNode#init(TbContext, TbNodeConfiguration)}.
   *
   * <ul>
   *   <li>Then throw {@link TbNodeException}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#init(TbContext, TbNodeConfiguration)}
   */
  @Test
  @DisplayName("Test init(TbContext, TbNodeConfiguration); then throw TbNodeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.init(TbContext, TbNodeConfiguration)"})
  void testInit_thenThrowTbNodeException() throws TbNodeException {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    // Act and Assert
    assertThrows(
        TbNodeException.class,
        () ->
            calculateDeltaNode.init(
                ctx, new TbNodeConfiguration(new POJONode(new CalculateDeltaNodeConfiguration()))));
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    when(calculateDeltaNodeConfiguration.getInputValueKey()).thenThrow(new NumberFormatException());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> calculateDeltaNode.onMsg(ctx, msg));
    verify(calculateDeltaNodeConfiguration).getInputValueKey();
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code 42}.
   *   <li>Then calls {@link CalculateDeltaNodeConfiguration#getInputValueKey()}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given '42'; when TbMsg getData() return '42'; then calls getInputValueKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_given42_whenTbMsgGetDataReturn42_thenCallsGetInputValueKey() {
    // Arrange
    when(calculateDeltaNodeConfiguration.getInputValueKey()).thenReturn("42");

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("42");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    calculateDeltaNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
    verify(calculateDeltaNodeConfiguration).getInputValueKey();
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return empty string.
   *   <li>Then calls {@link TbContext#tellNext(TbMsg, String)}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given empty string; when TbMsg getData() return empty string; then calls tellNext(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenEmptyString_whenTbMsgGetDataReturnEmptyString_thenCallsTellNext() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn("");
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    calculateDeltaNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link TbMsg} {@link TbMsg#isTypeOf(TbMsgType)} return {@code false}.
   *   <li>Then calls {@link TbContext#tellNext(TbMsg, String)}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'false'; when TbMsg isTypeOf(TbMsgType) return 'false'; then calls tellNext(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenFalse_whenTbMsgIsTypeOfReturnFalse_thenCallsTellNext() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);

    // Act
    calculateDeltaNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} return {@code null}.
   *   <li>Then calls {@link TbContext#tellNext(TbMsg, String)}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given 'null'; when TbMsg getData() return 'null'; then calls tellNext(TbMsg, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNull_whenTbMsgGetDataReturnNull_thenCallsTellNext() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellNext(Mockito.<TbMsg>any(), Mockito.<String>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenReturn(null);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act
    calculateDeltaNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellNext(isA(TbMsg.class), eq("Other"));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link NumberFormatException#NumberFormatException()}.
   *   <li>When {@link TbMsg} {@link TbMsg#getData()} throw {@link
   *       NumberFormatException#NumberFormatException()}.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given NumberFormatException(); when TbMsg getData() throw NumberFormatException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void CalculateDeltaNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenNumberFormatException_whenTbMsgGetDataThrowNumberFormatException() {
    // Arrange
    CalculateDeltaNode calculateDeltaNode = new CalculateDeltaNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new NumberFormatException());
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> calculateDeltaNode.onMsg(ctx, msg));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.POST_TELEMETRY_REQUEST);
  }

  /**
   * Test {@link CalculateDeltaNode#upgrade(int, JsonNode)}.
   *
   * <ul>
   *   <li>Given {@link CalculateDeltaNode} (default constructor).
   *   <li>When one.
   *   <li>Then return Second is valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNode#upgrade(int, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test upgrade(int, JsonNode); given CalculateDeltaNode (default constructor); when one; then return Second is valueOf ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.util.TbPair CalculateDeltaNode.upgrade(int, JsonNode)"
  })
  void testUpgrade_givenCalculateDeltaNode_whenOne_thenReturnSecondIsValueOfTen()
      throws TbNodeException {
    // Arrange
    DoubleNode oldConfiguration = DoubleNode.valueOf(10.0d);

    // Act and Assert
    assertSame(oldConfiguration, new CalculateDeltaNode().upgrade(1, oldConfiguration).getSecond());
  }

  /**
   * Test {@link CalculateDeltaNode#processMsgAsync(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link CalculateDeltaNode#processMsgAsync(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsgAsync(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture CalculateDeltaNode.processMsgAsync(TbContext, TbMsg)"
  })
  void testProcessMsgAsync() {
    // Arrange
    when(calculateDeltaNodeConfiguration.isUseCache()).thenThrow(new NumberFormatException());
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> calculateDeltaNode.processMsgAsync(ctx, msg));
    verify(calculateDeltaNodeConfiguration).isUseCache();
  }
}
