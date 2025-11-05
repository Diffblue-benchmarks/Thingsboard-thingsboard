package org.thingsboard.rule.engine.rpc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbAlarmMsgFactory;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.api.TbNodeException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.common.msg.TbMsg;

class TbSendRPCRequestNodeDiffblueTest {
  /**
   * Test {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendRPCRequestNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg() {
    // Arrange
    TbSendRPCRequestNode tbSendRPCRequestNode = new TbSendRPCRequestNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendRPCRequestNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendRPCRequestNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg2() {
    // Arrange
    TbSendRPCRequestNode tbSendRPCRequestNode = new TbSendRPCRequestNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "method", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendRPCRequestNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendRPCRequestNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_thenThrowRuntimeException() {
    // Arrange
    TbSendRPCRequestNode tbSendRPCRequestNode = new TbSendRPCRequestNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException())
        .when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbSendRPCRequestNode.onMsg(ctx, msg));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given RuntimeException(); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendRPCRequestNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenRuntimeException_thenThrowRuntimeException2() {
    // Arrange
    TbSendRPCRequestNode tbSendRPCRequestNode = new TbSendRPCRequestNode();

    TbContext ctx = mock(TbContext.class);
    doThrow(new RuntimeException())
        .when(ctx)
        .tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    DeviceId originator = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "method", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbSendRPCRequestNode.onMsg(ctx, msg));
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When alarmMsg {@link AlarmId#AlarmId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when alarmMsg AlarmId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendRPCRequestNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenAlarmMsgAlarmIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    TbSendRPCRequestNode tbSendRPCRequestNode = new TbSendRPCRequestNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbSendRPCRequestNode.onMsg(
        ctx,
        TbAlarmMsgFactory.alarmMsg(
            new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@link AlarmId#AlarmId(UUID)} and {@code Key} and value is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is AlarmId(UUID) and 'Key' and value is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendRPCRequestNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsAlarmIdAndKeyAndValueIsFortyTwo() {
    // Arrange
    TbSendRPCRequestNode tbSendRPCRequestNode = new TbSendRPCRequestNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Key", 42);

    // Act
    tbSendRPCRequestNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@link AlarmId#AlarmId(UUID)} and {@code Key} and value is minimalForOnMsg.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is AlarmId(UUID) and 'Key' and value is minimalForOnMsg")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendRPCRequestNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsAlarmIdAndKeyAndValueIsMinimalForOnMsg() {
    // Arrange
    TbSendRPCRequestNode tbSendRPCRequestNode = new TbSendRPCRequestNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbSendRPCRequestNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@link AlarmId#AlarmId(UUID)} and {@code Key} and value is minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is AlarmId(UUID) and 'Key' and value is minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendRPCRequestNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsAlarmIdAndKeyAndValueIsMinusOne() {
    // Arrange
    TbSendRPCRequestNode tbSendRPCRequestNode = new TbSendRPCRequestNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Key", -1);

    // Act
    tbSendRPCRequestNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbTelemetryMsgFactory#telemetryMsg(EntityId, String, Object)} with originator
   *       is {@link AlarmId#AlarmId(UUID)} and {@code Key} and value is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRPCRequestNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when telemetryMsg(EntityId, String, Object) with originator is AlarmId(UUID) and 'Key' and value is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendRPCRequestNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTelemetryMsgWithOriginatorIsAlarmIdAndKeyAndValueIsZero() {
    // Arrange
    TbSendRPCRequestNode tbSendRPCRequestNode = new TbSendRPCRequestNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Key", 0);

    // Act
    tbSendRPCRequestNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test new {@link TbSendRPCRequestNode} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link TbSendRPCRequestNode}
   */
  @Test
  @DisplayName("Test new TbSendRPCRequestNode (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbSendRPCRequestNode.<init>()"})
  void testNewTbSendRPCRequestNode() throws TbNodeException {
    // Arrange, Act and Assert
    TbPair<Boolean, JsonNode> upgradeResult = new TbSendRPCRequestNode().upgrade(1, null);
    assertNull(upgradeResult.getSecond());
    assertFalse(upgradeResult.getFirst());
  }
}
