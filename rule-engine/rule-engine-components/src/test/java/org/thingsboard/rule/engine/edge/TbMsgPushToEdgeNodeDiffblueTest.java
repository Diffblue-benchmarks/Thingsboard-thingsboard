package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.action.TbContextMinimalFactory;
import org.thingsboard.rule.engine.action.TbTelemetryMsgFactory;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;

class TbMsgPushToEdgeNodeDiffblueTest {
  /**
   * Test {@link TbMsgPushToEdgeNode#buildEvent(TenantId, EdgeEventActionType, UUID, EdgeEventType,
   * JsonNode)} with {@code TenantId}, {@code EdgeEventActionType}, {@code UUID}, {@code
   * EdgeEventType}, {@code JsonNode}.
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNode#buildEvent(TenantId, EdgeEventActionType,
   * UUID, EdgeEventType, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TenantId, EdgeEventActionType, UUID, EdgeEventType, JsonNode) with 'TenantId', 'EdgeEventActionType', 'UUID', 'EdgeEventType', 'JsonNode'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEvent TbMsgPushToEdgeNode.buildEvent(TenantId, EdgeEventActionType, UUID, EdgeEventType, JsonNode)"
  })
  void testBuildEventWithTenantIdEdgeEventActionTypeUuidEdgeEventTypeJsonNode() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DoubleNode entityBody = DoubleNode.valueOf(10.0d);

    // Act
    EdgeEvent actualBuildEventResult =
        tbMsgPushToEdgeNode.buildEvent(
            tenantId, EdgeEventActionType.ADDED, entityId, EdgeEventType.DASHBOARD, entityBody);

    // Assert
    JsonNode body = actualBuildEventResult.getBody();
    assertTrue(body instanceof DoubleNode);
    assertNull(actualBuildEventResult.getUid());
    assertNull(actualBuildEventResult.getUuidId());
    assertNull(actualBuildEventResult.getId());
    assertNull(actualBuildEventResult.getEdgeId());
    assertEquals(0L, actualBuildEventResult.getCreatedTime());
    assertEquals(0L, actualBuildEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualBuildEventResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, actualBuildEventResult.getType());
    assertSame(tenantId, actualBuildEventResult.getTenantId());
    assertSame(entityBody, body);
    assertSame(entityId, actualBuildEventResult.getEntityId());
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#getEventTypeByEntityType(EntityType)}.
   *
   * <ul>
   *   <li>When {@code CUSTOMER}.
   *   <li>Then return {@code CUSTOMER}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNode#getEventTypeByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getEventTypeByEntityType(EntityType); when 'CUSTOMER'; then return 'CUSTOMER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeEventType TbMsgPushToEdgeNode.getEventTypeByEntityType(EntityType)"})
  void testGetEventTypeByEntityType_whenCustomer_thenReturnCustomer() {
    // Arrange, Act and Assert
    assertEquals(
        EdgeEventType.CUSTOMER,
        new TbMsgPushToEdgeNode().getEventTypeByEntityType(EntityType.CUSTOMER));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#getEventTypeByEntityType(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then return {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNode#getEventTypeByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getEventTypeByEntityType(EntityType); when 'TENANT'; then return 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeEventType TbMsgPushToEdgeNode.getEventTypeByEntityType(EntityType)"})
  void testGetEventTypeByEntityType_whenTenant_thenReturnTenant() {
    // Arrange, Act and Assert
    assertEquals(
        EdgeEventType.TENANT,
        new TbMsgPushToEdgeNode().getEventTypeByEntityType(EntityType.TENANT));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#getAlarmEventType()}.
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNode#getAlarmEventType()}
   */
  @Test
  @DisplayName("Test getAlarmEventType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeEventType TbMsgPushToEdgeNode.getAlarmEventType()"})
  void testGetAlarmEventType() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventType.ALARM, new TbMsgPushToEdgeNode().getAlarmEventType());
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsg(TbContext, TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgPushToEdgeNode.processMsg(TbContext, TbMsg)"})
  void testProcessMsg() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(null, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgPushToEdgeNode.processMsg(ctx, msg);

    // Assert
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TbContext} {@link TbContext#getEdgeService()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsg(TbContext, TbMsg); given 'null'; when TbContext getEdgeService() return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgPushToEdgeNode.processMsg(TbContext, TbMsg)"})
  void testProcessMsg_givenNull_whenTbContextGetEdgeServiceReturnNull() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getEdgeService()).thenReturn(null);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgPushToEdgeNode.processMsg(ctx, msg);

    // Assert
    verify(ctx).getEdgeService();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>Then calls {@link TbContext#ack(TbMsg)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName("Test processMsg(TbContext, TbMsg); then calls ack(TbMsg)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgPushToEdgeNode.processMsg(TbContext, TbMsg)"})
  void testProcessMsg_thenCallsAck() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(ctx).ack(Mockito.<TbMsg>any());
    when(ctx.getEdgeService()).thenReturn(new EdgeServiceImpl());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgPushToEdgeNode.processMsg(ctx, msg);

    // Assert
    verify(ctx).ack(isA(TbMsg.class));
    verify(ctx).getEdgeService();
    verify(ctx).getTenantId();
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then calls {@link TbContext#tellFailure(TbMsg, Throwable)}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsg(TbContext, TbMsg); when 'null'; then calls tellFailure(TbMsg, Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgPushToEdgeNode.processMsg(TbContext, TbMsg)"})
  void testProcessMsg_whenNull_thenCallsTellFailure() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();

    TbContext ctx = mock(TbContext.class);
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());

    // Act
    tbMsgPushToEdgeNode.processMsg(ctx, null);

    // Assert
    verify(ctx).tellFailure(isNull(), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getEdgeService()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsg(TbContext, TbMsg); when TbContext getEdgeService() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgPushToEdgeNode.processMsg(TbContext, TbMsg)"})
  void testProcessMsg_whenTbContextGetEdgeServiceThrowRuntimeException() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getEdgeService()).thenThrow(new RuntimeException());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgPushToEdgeNode.processMsg(ctx, msg);

    // Assert
    verify(ctx).getEdgeService();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}.
   *
   * <ul>
   *   <li>When {@link TbContext} {@link TbContext#getTenantId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgPushToEdgeNode#processMsg(TbContext, TbMsg)}
   */
  @Test
  @DisplayName(
      "Test processMsg(TbContext, TbMsg); when TbContext getTenantId() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbMsgPushToEdgeNode.processMsg(TbContext, TbMsg)"})
  void testProcessMsg_whenTbContextGetTenantIdThrowRuntimeException() {
    // Arrange
    TbMsgPushToEdgeNode tbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();

    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new RuntimeException());
    when(ctx.getEdgeService()).thenReturn(new EdgeServiceImpl());
    doNothing().when(ctx).tellFailure(Mockito.<TbMsg>any(), Mockito.<Throwable>any());
    AlarmId originator = new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    TbMsg msg =
        TbTelemetryMsgFactory.telemetryMsg(
            originator, "Key", TbContextMinimalFactory.minimalForOnMsg());

    // Act
    tbMsgPushToEdgeNode.processMsg(ctx, msg);

    // Assert
    verify(ctx).getEdgeService();
    verify(ctx).getTenantId();
    verify(ctx).tellFailure(isA(TbMsg.class), isA(Throwable.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgPushToEdgeNode}
   *   <li>{@link TbMsgPushToEdgeNode#getConfigClazz()}
   *   <li>{@link TbMsgPushToEdgeNode#getIgnoredMessageSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbMsgPushToEdgeNode.<init>()",
    "Class TbMsgPushToEdgeNode.getConfigClazz()",
    "java.lang.String TbMsgPushToEdgeNode.getIgnoredMessageSource()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgPushToEdgeNode actualTbMsgPushToEdgeNode = new TbMsgPushToEdgeNode();
    Class<TbMsgPushToEdgeNodeConfiguration> actualConfigClazz =
        actualTbMsgPushToEdgeNode.getConfigClazz();

    // Assert
    assertEquals("edge", actualTbMsgPushToEdgeNode.getIgnoredMessageSource());
    Class<TbMsgPushToEdgeNodeConfiguration> expectedConfigClazz =
        TbMsgPushToEdgeNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }
}
