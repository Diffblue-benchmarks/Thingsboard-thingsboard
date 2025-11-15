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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeEventType EdgeUtils.getEdgeEventTypeByEntityType(EntityType)"})
  void testGetEdgeEventTypeByEntityType() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventType.TENANT, EdgeUtils.getEdgeEventTypeByEntityType(EntityType.TENANT));
  }

  /**
   * Test {@link EdgeUtils#getEdgeEventActionTypeByActionType(ActionType)}.
   * <p>
   * Method under test: {@link EdgeUtils#getEdgeEventActionTypeByActionType(ActionType)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByActionType(ActionType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeEventActionType EdgeUtils.getEdgeEventActionTypeByActionType(ActionType)"})
  void testGetEdgeEventActionTypeByActionType() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventActionType.ADDED, EdgeUtils.getEdgeEventActionTypeByActionType(ActionType.ADDED));
  }

  /**
   * Test {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then Body return {@link MissingNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode); when 'null'; then Body return MissingNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EdgeEvent EdgeUtils.constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)"})
  void testConstructEdgeEvent_whenNull_thenBodyReturnMissingNode() {
    // Arrange
    TenantId entityId = TenantId.SYS_TENANT_ID;
    MissingNode body = MissingNode.getInstance();

    // Act
    EdgeEvent actualConstructEdgeEventResult = EdgeUtils.constructEdgeEvent(TenantId.SYS_TENANT_ID, null,
        EdgeEventType.DASHBOARD, EdgeEventActionType.ADDED, entityId, body);

    // Assert
    JsonNode body2 = actualConstructEdgeEventResult.getBody();
    assertTrue(body2 instanceof MissingNode);
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, actualConstructEdgeEventResult.getType());
    assertSame(body, body2);
    TenantId expectedTenantId = entityId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode); when 'null'; then return EntityId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "EdgeEvent EdgeUtils.constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)"})
  void testConstructEdgeEvent_whenNull_thenReturnEntityIdIsNull() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    MissingNode body = MissingNode.getInstance();

    // Act
    EdgeEvent actualConstructEdgeEventResult = EdgeUtils.constructEdgeEvent(tenantId, null, EdgeEventType.DASHBOARD,
        EdgeEventActionType.ADDED, null, body);

    // Assert
    JsonNode body2 = actualConstructEdgeEventResult.getBody();
    assertTrue(body2 instanceof MissingNode);
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getEntityId());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, actualConstructEdgeEventResult.getType());
    assertSame(body, body2);
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}.
   * <ul>
   *   <li>Then return {@code . ( :17)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}
   */
  @Test
  @DisplayName("Test createErrorMsgFromRootCauseAndStackTrace(Throwable); then return '. ( :17)'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(Throwable)"})
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
   * Method under test: {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}
   */
  @Test
  @DisplayName("Test createErrorMsgFromRootCauseAndStackTrace(Throwable); then return DEFAULT_SECRET_KEY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(Throwable)"})
  void testCreateErrorMsgFromRootCauseAndStackTrace_thenReturnDefault_secret_key() {
    // Arrange
    Throwable t = new Throwable();
    t.setStackTrace(new StackTraceElement[]{});

    // Act and Assert
    assertEquals(DataConstants.DEFAULT_SECRET_KEY, EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(t));
  }
}
