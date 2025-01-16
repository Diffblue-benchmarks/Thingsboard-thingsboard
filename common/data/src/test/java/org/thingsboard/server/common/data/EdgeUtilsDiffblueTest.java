package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeUtilsDiffblueTest {
  /**
   * Test {@link EdgeUtils#getEdgeEventTypeByEntityType(EntityType)}.
   * <p>
   * Method under test: {@link EdgeUtils#getEdgeEventTypeByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getEdgeEventTypeByEntityType(EntityType)")
  void testGetEdgeEventTypeByEntityType() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventType.TENANT, EdgeUtils.getEdgeEventTypeByEntityType(EntityType.TENANT));
  }

  /**
   * Test {@link EdgeUtils#getEdgeEventActionTypeByActionType(ActionType)}.
   * <p>
   * Method under test:
   * {@link EdgeUtils#getEdgeEventActionTypeByActionType(ActionType)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByActionType(ActionType)")
  void testGetEdgeEventActionTypeByActionType() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventActionType.ADDED, EdgeUtils.getEdgeEventActionTypeByActionType(ActionType.ADDED));
  }

  /**
   * Test
   * {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)}.
   * <p>
   * Method under test:
   * {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)")
  void testConstructEdgeEvent() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;
    MissingNode body = MissingNode.getInstance();

    // Act
    EdgeEvent actualConstructEdgeEventResult = EdgeUtils.constructEdgeEvent(TenantId.SYS_TENANT_ID, null,
        EdgeEventType.DASHBOARD, EdgeEventActionType.ADDED, entityId, body);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualConstructEdgeEventResult.getEntityId().toString());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, actualConstructEdgeEventResult.getType());
    assertSame(body, actualConstructEdgeEventResult.getBody());
    TenantId expectedTenantId = entityId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode); when 'null'; then return EntityId is 'null'")
  void testConstructEdgeEvent_whenNull_thenReturnEntityIdIsNull() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    MissingNode body = MissingNode.getInstance();

    // Act
    EdgeEvent actualConstructEdgeEventResult = EdgeUtils.constructEdgeEvent(tenantId, null, EdgeEventType.DASHBOARD,
        EdgeEventActionType.ADDED, null, body);

    // Assert
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getEntityId());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, actualConstructEdgeEventResult.getType());
    assertSame(body, actualConstructEdgeEventResult.getBody());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}.
   * <ul>
   *   <li>Then return {@code . ( :17)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}
   */
  @Test
  @DisplayName("Test createErrorMsgFromRootCauseAndStackTrace(Throwable); then return '. ( :17)'")
  void testCreateErrorMsgFromRootCauseAndStackTrace_thenReturn17() {
    // Arrange
    Throwable t = new Throwable();
    t.setStackTrace(new StackTraceElement[]{new StackTraceElement("\n", "\n", "\n", 17)});

    // Act and Assert
    assertEquals("\n\n.\n(\n:17)", EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(t));
  }

  /**
   * Test {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}.
   * <ul>
   *   <li>Then return {@link DataConstants#DEFAULT_SECRET_KEY}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}
   */
  @Test
  @DisplayName("Test createErrorMsgFromRootCauseAndStackTrace(Throwable); then return DEFAULT_SECRET_KEY")
  void testCreateErrorMsgFromRootCauseAndStackTrace_thenReturnDefault_secret_key() {
    // Arrange
    Throwable t = new Throwable();
    t.setStackTrace(new StackTraceElement[]{});

    // Act and Assert
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(t));
  }
}
