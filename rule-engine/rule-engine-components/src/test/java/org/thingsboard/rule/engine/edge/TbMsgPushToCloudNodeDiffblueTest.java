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
package org.thingsboard.rule.engine.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.TenantId;

class TbMsgPushToCloudNodeDiffblueTest {
  /**
   * Test {@link TbMsgPushToCloudNode#buildEvent(TenantId, EdgeEventActionType, UUID, Object,
   * JsonNode)} with {@code tenantId}, {@code eventAction}, {@code entityId}, {@code eventType},
   * {@code entityBody}.
   *
   * <p>Method under test: {@link TbMsgPushToCloudNode#buildEvent(TenantId, EdgeEventActionType,
   * UUID, Object, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test buildEvent(TenantId, EdgeEventActionType, UUID, Object, JsonNode) with 'tenantId', 'eventAction', 'entityId', 'eventType', 'entityBody'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Object TbMsgPushToCloudNode.buildEvent(TenantId, EdgeEventActionType, UUID, Object, JsonNode)"
  })
  void testBuildEventWithTenantIdEventActionEntityIdEventTypeEntityBody() {
    // Arrange
    TbMsgPushToCloudNode tbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(
        tbMsgPushToCloudNode.buildEvent(
            tenantId,
            EdgeEventActionType.ADDED,
            UUID.randomUUID(),
            "Event Type",
            DoubleNode.valueOf(10.0d)));
  }

  /**
   * Test {@link TbMsgPushToCloudNode#getEventTypeByEntityType(EntityType)}.
   *
   * <p>Method under test: {@link TbMsgPushToCloudNode#getEventTypeByEntityType(EntityType)}
   */
  @Test
  @DisplayName("Test getEventTypeByEntityType(EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbMsgPushToCloudNode.getEventTypeByEntityType(EntityType)"})
  void testGetEventTypeByEntityType() {
    // Arrange, Act and Assert
    assertNull(new TbMsgPushToCloudNode().getEventTypeByEntityType(EntityType.TENANT));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgPushToCloudNode}
   *   <li>{@link TbMsgPushToCloudNode#getAlarmEventType()}
   *   <li>{@link TbMsgPushToCloudNode#getConfigClazz()}
   *   <li>{@link TbMsgPushToCloudNode#getIgnoredMessageSource()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbMsgPushToCloudNode.<init>()",
    "Object TbMsgPushToCloudNode.getAlarmEventType()",
    "Class TbMsgPushToCloudNode.getConfigClazz()",
    "java.lang.String TbMsgPushToCloudNode.getIgnoredMessageSource()",
    "void TbMsgPushToCloudNode.processMsg(org.thingsboard.rule.engine.api.TbContext, org.thingsboard.server.common.msg.TbMsg)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgPushToCloudNode actualTbMsgPushToCloudNode = new TbMsgPushToCloudNode();
    Object actualAlarmEventType = actualTbMsgPushToCloudNode.getAlarmEventType();
    Class<TbMsgPushToCloudNodeConfiguration> actualConfigClazz =
        actualTbMsgPushToCloudNode.getConfigClazz();

    // Assert
    assertNull(actualAlarmEventType);
    assertNull(actualTbMsgPushToCloudNode.getIgnoredMessageSource());
    Class<TbMsgPushToCloudNodeConfiguration> expectedConfigClazz =
        TbMsgPushToCloudNodeConfiguration.class;
    assertEquals(expectedConfigClazz, actualConfigClazz);
  }
}
