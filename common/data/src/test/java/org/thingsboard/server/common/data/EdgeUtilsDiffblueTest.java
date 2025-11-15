/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
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
   * Method under test: {@link EdgeUtils#getEdgeEventTypeByEntityType(EntityType)}
   */
  @Test
  void testGetEdgeEventTypeByEntityType() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventType.TENANT, EdgeUtils.getEdgeEventTypeByEntityType(EntityType.TENANT));
  }

  /**
   * Method under test:
   * {@link EdgeUtils#getEdgeEventActionTypeByActionType(ActionType)}
   */
  @Test
  void testGetEdgeEventActionTypeByActionType() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventActionType.ADDED, EdgeUtils.getEdgeEventActionTypeByActionType(ActionType.ADDED));
  }

  /**
   * Method under test:
   * {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)}
   */
  @Test
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
   * Method under test:
   * {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)}
   */
  @Test
  void testConstructEdgeEvent2() {
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
   * Method under test:
   * {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}
   */
  @Test
  void testCreateErrorMsgFromRootCauseAndStackTrace() {
    // Arrange
    Throwable t = new Throwable();
    t.setStackTrace(new StackTraceElement[]{new StackTraceElement("\n", "\n", "\n", 17)});

    // Act and Assert
    assertEquals("\n\n.\n(\n:17)", EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(t));
  }

  /**
   * Method under test:
   * {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}
   */
  @Test
  void testCreateErrorMsgFromRootCauseAndStackTrace2() {
    // Arrange
    Throwable t = new Throwable();
    t.setStackTrace(new StackTraceElement[]{});

    // Act and Assert
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(t));
  }
}
