package org.thingsboard.rule.engine.delay;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.UUID;
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
import org.thingsboard.server.common.data.msg.TbMsgType;
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbMsgDelayNodeDiffblueTest {
  @Mock private Map<UUID, TbMsg> map;

  @InjectMocks private TbMsgDelayNode tbMsgDelayNode;

  @Mock private TbMsgDelayNodeConfiguration tbMsgDelayNodeConfiguration;

  /**
   * Test {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgDelayNodeConfiguration} {@link
   *       TbMsgDelayNodeConfiguration#getMaxPendingMsgs()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgDelayNodeConfiguration getMaxPendingMsgs() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDelayNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgDelayNodeConfigurationGetMaxPendingMsgsThrowRuntimeException() {
    // Arrange
    when(tbMsgDelayNodeConfiguration.getMaxPendingMsgs()).thenThrow(new RuntimeException());
    when(map.size()).thenReturn(3);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgDelayNode.onMsg(ctx, msg));
    verify(map).size();
    verify(tbMsgDelayNodeConfiguration).getMaxPendingMsgs();
  }

  /**
   * Test {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbMsgDelayNode} (default constructor).
   *   <li>Then calls {@link TbMsg#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbMsgDelayNode (default constructor); then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDelayNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbMsgDelayNode_thenCallsGetData() {
    // Arrange
    TbMsgDelayNode tbMsgDelayNode = new TbMsgDelayNode();
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getData()).thenThrow(new RuntimeException());
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(true);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgDelayNode.onMsg(ctx, msg));
    verify(msg).getData();
    verify(msg).isTypeOf(TbMsgType.DELAY_TIMEOUT_SELF_MSG);
  }

  /**
   * Test {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDelayNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsTellFailure() {
    // Arrange
    when(tbMsgDelayNodeConfiguration.getMaxPendingMsgs()).thenReturn(1);
    when(map.size()).thenReturn(1);

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    TbMsg msg = mock(TbMsg.class);
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);

    // Act
    tbMsgDelayNode.onMsg(ctx, msg);

    // Assert
    verify(map).size();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbMsgDelayNodeConfiguration).getMaxPendingMsgs();
    verify(msg).isTypeOf(TbMsgType.DELAY_TIMEOUT_SELF_MSG);
  }

  /**
   * Test {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbMsg} {@link TbMsg#getId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   *   <li>Then calls {@link TbMsg#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDelayNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); when TbMsg getId() throw RuntimeException(); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgDelayNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_whenTbMsgGetIdThrowRuntimeException_thenCallsGetId() {
    // Arrange
    when(tbMsgDelayNodeConfiguration.getMaxPendingMsgs()).thenReturn(3);
    when(map.size()).thenReturn(1);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();

    TbMsg msg = mock(TbMsg.class);
    when(msg.getId()).thenThrow(new RuntimeException());
    when(msg.isTypeOf(Mockito.<TbMsgType>any())).thenReturn(false);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> tbMsgDelayNode.onMsg(ctx, msg));
    verify(map).size();
    verify(tbMsgDelayNodeConfiguration).getMaxPendingMsgs();
    verify(msg).getId();
    verify(msg).isTypeOf(TbMsgType.DELAY_TIMEOUT_SELF_MSG);
  }
}
