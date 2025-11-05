package org.thingsboard.rule.engine.filter;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
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
import org.thingsboard.server.common.msg.TbMsg;

@ExtendWith(MockitoExtension.class)
class TbCheckMessageNodeDiffblueTest {
  @Mock private List<String> list;

  @InjectMocks private TbCheckMessageNode tbCheckMessageNode;

  @Mock private TbCheckMessageNodeConfiguration tbCheckMessageNodeConfiguration;

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbCheckMessageNodeConfiguration} {@link
   *       TbCheckMessageNodeConfiguration#isCheckAllKeys()} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbCheckMessageNodeConfiguration isCheckAllKeys() return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbCheckMessageNodeConfigurationIsCheckAllKeysReturnFalse() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(false);
    when(list.isEmpty()).thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(list).isEmpty();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@link TbCheckMessageNode} (default constructor).
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test onMsg(TbContext, TbMsg); given TbCheckMessageNode (default constructor); then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_givenTbCheckMessageNode_thenCallsTellFailure() {
    // Arrange
    TbCheckMessageNode tbCheckMessageNode = new TbCheckMessageNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link List#isEmpty()}.
   * </ul>
   *
   * <p>Method under test: {@link TbCheckMessageNode#onMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test onMsg(TbContext, TbMsg); then calls isEmpty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbCheckMessageNode.onMsg(TbContext, TbMsg)"})
  void testOnMsg_thenCallsIsEmpty() {
    // Arrange
    when(tbCheckMessageNodeConfiguration.isCheckAllKeys()).thenReturn(true);
    when(list.isEmpty()).thenThrow(new RuntimeException());

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbCheckMessageNode.onMsg(ctx, msg);

    // Assert
    verify(list).isEmpty();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
    verify(tbCheckMessageNodeConfiguration).isCheckAllKeys();
  }
}
