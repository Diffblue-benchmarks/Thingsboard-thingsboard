package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.msg.TbMsg;

class TelemetryNodeCallbackDiffblueTest {
  /**
   * Test {@link TelemetryNodeCallback#onSuccess(Void)} with {@code Void}.
   *
   * <ul>
   *   <li>Given {@link TbContext} {@link TbContext#tellSuccess(TbMsg)} does nothing.
   *   <li>Then calls {@link TbContext#tellSuccess(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(Void) with 'Void'; given TbContext tellSuccess(TbMsg) does nothing; then calls tellSuccess(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TelemetryNodeCallback.onSuccess(Void)"})
  void testOnSuccessWithVoid_givenTbContextTellSuccessDoesNothing_thenCallsTellSuccess() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellSuccess(Mockito.<TbMsg>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    TelemetryNodeCallback telemetryNodeCallback = new TelemetryNodeCallback(ctx, msg);

    // Act
    telemetryNodeCallback.onSuccess(null);

    // Assert
    verify(ctx).tellSuccess(isA(TbMsg.class));
  }

  /**
   * Test {@link TelemetryNodeCallback#onFailure(Throwable)}.
   *
   * <ul>
   *   <li>Given {@link TbContext} {@link TbContext#tellFailure(TbMsg, Throwable)} does nothing.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#onFailure(Throwable)}
   */
  @Test
  @DisplayName(
      "Test onFailure(Throwable); given TbContext tellFailure(TbMsg, Throwable) does nothing; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TelemetryNodeCallback.onFailure(Throwable)"})
  void testOnFailure_givenTbContextTellFailureDoesNothing_thenCallsTellFailure() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    TelemetryNodeCallback telemetryNodeCallback = new TelemetryNodeCallback(ctx, msg);

    // Act
    telemetryNodeCallback.onFailure(new Throwable());

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TelemetryNodeCallback#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryNodeCallback.equals(Object)",
    "int TelemetryNodeCallback.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    TelemetryNodeCallback telemetryNodeCallback = new TelemetryNodeCallback(ctx, msg);
    TbContext ctx2 = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg2 =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertNotEquals(telemetryNodeCallback, new TelemetryNodeCallback(ctx2, msg2));
  }

  /**
   * Test {@link TelemetryNodeCallback#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryNodeCallback.equals(Object)",
    "int TelemetryNodeCallback.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    TelemetryNodeCallback telemetryNodeCallback = new TelemetryNodeCallback(ctx, msg);
    TbContext ctx2 = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg2 =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertNotEquals(telemetryNodeCallback, new TelemetryNodeCallback(ctx2, msg2));
  }

  /**
   * Test {@link TelemetryNodeCallback#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryNodeCallback.equals(Object)",
    "int TelemetryNodeCallback.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TelemetryNodeCallback telemetryNodeCallback =
        new TelemetryNodeCallback(TbContextMinimalFactory.minimalForOnMsg(), null);
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertNotEquals(telemetryNodeCallback, new TelemetryNodeCallback(ctx, msg));
  }

  /**
   * Test {@link TelemetryNodeCallback#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryNodeCallback.equals(Object)",
    "int TelemetryNodeCallback.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    TelemetryNodeCallback telemetryNodeCallback = new TelemetryNodeCallback(ctx, msg);
    TbContext ctx2 = mock(TbContext.class);
    TbMsg msg2 =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertNotEquals(telemetryNodeCallback, new TelemetryNodeCallback(ctx2, msg2));
  }

  /**
   * Test {@link TelemetryNodeCallback#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryNodeCallback.equals(Object)",
    "int TelemetryNodeCallback.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act and Assert
    assertNotEquals(new TelemetryNodeCallback(ctx, msg), 1);
  }

  /**
   * Test {@link TelemetryNodeCallback#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryNodeCallback.equals(Object)",
    "int TelemetryNodeCallback.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbContext ctx = TbContextMinimalFactory.minimalForOnMsg();
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    TelemetryNodeCallback telemetryNodeCallback = new TelemetryNodeCallback(ctx, msg);

    AttributesDeleteNodeCallback attributesDeleteNodeCallback =
        mock(AttributesDeleteNodeCallback.class);
    when(attributesDeleteNodeCallback.canEqual(Mockito.<Object>any())).thenReturn(false);

    // Act and Assert
    assertNotEquals(telemetryNodeCallback, attributesDeleteNodeCallback);
  }

  /**
   * Test {@link TelemetryNodeCallback#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryNodeCallback#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryNodeCallback.equals(Object)",
    "int TelemetryNodeCallback.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmId originator = mock(AlarmId.class);
    when(originator.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(originator.getEntityType()).thenReturn(EntityType.CUSTOMER);
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());
    TelemetryNodeCallback telemetryNodeCallback =
        new TelemetryNodeCallback(TbContextMinimalFactory.minimalForOnMsg(), msg);

    AttributesDeleteNodeCallback attributesDeleteNodeCallback =
        mock(AttributesDeleteNodeCallback.class);
    when(attributesDeleteNodeCallback.getCtx())
        .thenReturn(TbContextMinimalFactory.minimalForOnMsg());
    TbMsg telemetryMsgResult =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    when(attributesDeleteNodeCallback.getMsg()).thenReturn(telemetryMsgResult);
    when(attributesDeleteNodeCallback.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(telemetryNodeCallback, attributesDeleteNodeCallback);
  }
}
