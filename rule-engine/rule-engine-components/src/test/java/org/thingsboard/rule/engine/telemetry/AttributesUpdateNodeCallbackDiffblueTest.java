package org.thingsboard.rule.engine.telemetry;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.msg.TbMsg;

class AttributesUpdateNodeCallbackDiffblueTest {
  /**
   * Test {@link AttributesUpdateNodeCallback#onSuccess(Void)} with {@code Void}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#attributesUpdatedActionMsg(EntityId, RuleNodeId, String,
   *       List)}.
   * </ul>
   *
   * <p>Method under test: {@link AttributesUpdateNodeCallback#onSuccess(Void)}
   */
  @Test
  @DisplayName(
      "Test onSuccess(Void) with 'Void'; then calls attributesUpdatedActionMsg(EntityId, RuleNodeId, String, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AttributesUpdateNodeCallback.onSuccess(Void)"})
  void testOnSuccessWithVoid_thenCallsAttributesUpdatedActionMsg() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getSelfId())
        .thenReturn(new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TbMsg telemetryMsgResult =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());
    when(ctx.attributesUpdatedActionMsg(
            Mockito.<EntityId>any(),
            Mockito.<RuleNodeId>any(),
            Mockito.<String>any(),
            Mockito.<List<AttributeKvEntry>>any()))
        .thenReturn(telemetryMsgResult);
    doNothing()
        .when(ctx)
        .enqueue(Mockito.<TbMsg>any(), Mockito.<Runnable>any(), Mockito.<Consumer<Throwable>>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    AttributesUpdateNodeCallback attributesUpdateNodeCallback =
        new AttributesUpdateNodeCallback(ctx, msg, "Scope", new ArrayList<>());

    // Act
    attributesUpdateNodeCallback.onSuccess(null);

    // Assert
    verify(ctx)
        .attributesUpdatedActionMsg(isNull(), isA(RuleNodeId.class), eq("Scope"), isA(List.class));
    verify(ctx).enqueue(isA(TbMsg.class), isA(Runnable.class), isA(Consumer.class));
    verify(ctx).getSelfId();
  }
}
