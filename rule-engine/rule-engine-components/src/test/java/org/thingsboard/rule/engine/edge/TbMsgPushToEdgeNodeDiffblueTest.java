package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.TenantId;

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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeEventType TbMsgPushToEdgeNode.getAlarmEventType()"})
  void testGetAlarmEventType() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventType.ALARM, new TbMsgPushToEdgeNode().getAlarmEventType());
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
  @Tag("MaintainedByDiffblue")
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
