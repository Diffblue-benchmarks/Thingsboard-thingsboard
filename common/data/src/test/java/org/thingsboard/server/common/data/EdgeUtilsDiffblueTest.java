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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
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
   *
   * <p>Method under test: {@link EdgeUtils#getEdgeEventTypeByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getEdgeEventTypeByEntityType(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeEventType EdgeUtils.getEdgeEventTypeByEntityType(EntityType)"})
  void testGetEdgeEventTypeByEntityType() {
    // Arrange, Act and Assert
    assertEquals(EdgeEventType.TENANT, EdgeUtils.getEdgeEventTypeByEntityType(EntityType.TENANT));
  }

  /**
   * Test {@link EdgeUtils#getEdgeEventActionTypeByActionType(ActionType)}.
   *
   * <p>Method under test: {@link EdgeUtils#getEdgeEventActionTypeByActionType(ActionType)}
   */
  @Test
  @DisplayName("Test getEdgeEventActionTypeByActionType(ActionType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEventActionType EdgeUtils.getEdgeEventActionTypeByActionType(ActionType)"
  })
  void testGetEdgeEventActionTypeByActionType() {
    // Arrange, Act and Assert
    assertEquals(
        EdgeEventActionType.ADDED, EdgeUtils.getEdgeEventActionTypeByActionType(ActionType.ADDED));
  }

  /**
   * Test {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType,
   * EntityId, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then Body return {@link DoubleNode}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType,
   * EdgeEventActionType, EntityId, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode); when 'null'; then Body return DoubleNode")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEvent EdgeUtils.constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)"
  })
  void testConstructEdgeEvent_whenNull_thenBodyReturnDoubleNode() {
    // Arrange
    DoubleNode body = DoubleNode.valueOf(10.0d);

    // Act
    EdgeEvent actualConstructEdgeEventResult =
        EdgeUtils.constructEdgeEvent(
            TenantId.SYS_TENANT_ID,
            null,
            EdgeEventType.DASHBOARD,
            EdgeEventActionType.ADDED,
            TenantId.SYS_TENANT_ID,
            body);

    // Assert
    JsonNode body2 = actualConstructEdgeEventResult.getBody();
    assertTrue(body2 instanceof DoubleNode);
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, actualConstructEdgeEventResult.getType());
    assertSame(body, body2);
    assertSame(TenantId.SYS_TENANT_ID, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType,
   * EntityId, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeUtils#constructEdgeEvent(TenantId, EdgeId, EdgeEventType,
   * EdgeEventActionType, EntityId, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode); when 'null'; then return EntityId is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EdgeEvent EdgeUtils.constructEdgeEvent(TenantId, EdgeId, EdgeEventType, EdgeEventActionType, EntityId, JsonNode)"
  })
  void testConstructEdgeEvent_whenNull_thenReturnEntityIdIsNull() {
    // Arrange
    DoubleNode body = DoubleNode.valueOf(10.0d);

    // Act
    EdgeEvent actualConstructEdgeEventResult =
        EdgeUtils.constructEdgeEvent(
            TenantId.SYS_TENANT_ID,
            null,
            EdgeEventType.DASHBOARD,
            EdgeEventActionType.ADDED,
            null,
            body);

    // Assert
    JsonNode body2 = actualConstructEdgeEventResult.getBody();
    assertTrue(body2 instanceof DoubleNode);
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
    assertSame(TenantId.SYS_TENANT_ID, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}.
   *
   * <ul>
   *   <li>Then return {@link DataConstants#DEFAULT_SECRET_KEY}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}
   */
  @Test
  @DisplayName(
      "Test createErrorMsgFromRootCauseAndStackTrace(Throwable); then return DEFAULT_SECRET_KEY")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(Throwable)"
  })
  void testCreateErrorMsgFromRootCauseAndStackTrace_thenReturnDefault_secret_key() {
    // Arrange
    Throwable t = new Throwable();
    t.setStackTrace(new StackTraceElement[] {});

    // Act and Assert
    assertEquals(
        DataConstants.DEFAULT_SECRET_KEY, EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(t));
  }

  /**
   * Test {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}.
   *
   * <ul>
   *   <li>Then return {@code . (foo.txt:2)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeUtils#createErrorMsgFromRootCauseAndStackTrace(Throwable)}
   */
  @Test
  @DisplayName(
      "Test createErrorMsgFromRootCauseAndStackTrace(Throwable); then return '. (foo.txt:2)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "java.lang.String EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(Throwable)"
  })
  void testCreateErrorMsgFromRootCauseAndStackTrace_thenReturnFooTxt2() {
    // Arrange
    Throwable t = new Throwable();
    StackTraceElement stackTraceElement = new StackTraceElement("\n", "\n", "foo.txt", 2);
    t.setStackTrace(new StackTraceElement[] {stackTraceElement});

    // Act and Assert
    assertEquals("\n\n.\n(foo.txt:2)", EdgeUtils.createErrorMsgFromRootCauseAndStackTrace(t));
  }
}
