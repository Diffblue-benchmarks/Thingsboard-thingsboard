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
package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleNodeDebugEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEvent#equals(Object)}
   *   <li>{@link RuleNodeDebugEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEvent buildResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEvent buildResult2 = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEvent#equals(Object)}
   *   <li>{@link RuleNodeDebugEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEvent buildResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link RuleNodeDebugEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder = mock(
        RuleNodeDebugEvent.RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder.data(Mockito.<String>any())).thenReturn(RuleNodeDebugEvent.builder());
    RuleNodeDebugEvent buildResult = ruleNodeDebugEventBuilder.data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEvent buildResult2 = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder = mock(
        RuleNodeDebugEvent.RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder.dataType(Mockito.<String>any())).thenReturn(RuleNodeDebugEvent.builder());
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder2 = mock(
        RuleNodeDebugEvent.RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder2.data(Mockito.<String>any())).thenReturn(ruleNodeDebugEventBuilder);
    RuleNodeDebugEvent buildResult = ruleNodeDebugEventBuilder2.data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEvent buildResult2 = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder = mock(
        RuleNodeDebugEvent.RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(RuleNodeDebugEvent.builder());
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder2 = mock(
        RuleNodeDebugEvent.RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder2.dataType(Mockito.<String>any())).thenReturn(ruleNodeDebugEventBuilder);
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder3 = mock(
        RuleNodeDebugEvent.RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder3.data(Mockito.<String>any())).thenReturn(ruleNodeDebugEventBuilder2);
    RuleNodeDebugEvent buildResult = ruleNodeDebugEventBuilder3.data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEvent buildResult2 = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link RuleNodeDebugEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEvent buildResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link RuleNodeDebugEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEvent buildResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RuleNodeDebugEvent");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEvent#setData(String)}
   *   <li>{@link RuleNodeDebugEvent#setError(String)}
   *   <li>{@link RuleNodeDebugEvent#setMetadata(String)}
   *   <li>{@link RuleNodeDebugEvent#toString()}
   *   <li>{@link RuleNodeDebugEvent#getData()}
   *   <li>{@link RuleNodeDebugEvent#getDataType()}
   *   <li>{@link RuleNodeDebugEvent#getError()}
   *   <li>{@link RuleNodeDebugEvent#getEventEntity()}
   *   <li>{@link RuleNodeDebugEvent#getEventType()}
   *   <li>{@link RuleNodeDebugEvent#getMetadata()}
   *   <li>{@link RuleNodeDebugEvent#getMsgId()}
   *   <li>{@link RuleNodeDebugEvent#getMsgType()}
   *   <li>{@link RuleNodeDebugEvent#getRelationType()}
   *   <li>{@link RuleNodeDebugEvent#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    RuleNodeDebugEvent buildResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    buildResult.setData("Data");
    buildResult.setError("An error occurred");
    buildResult.setMetadata("Metadata");
    String actualToStringResult = buildResult.toString();
    String actualData = buildResult.getData();
    String actualDataType = buildResult.getDataType();
    String actualError = buildResult.getError();
    EntityId actualEventEntity = buildResult.getEventEntity();
    String actualEventType = buildResult.getEventType();
    String actualMetadata = buildResult.getMetadata();
    buildResult.getMsgId();
    String actualMsgType = buildResult.getMsgType();
    String actualRelationType = buildResult.getRelationType();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualError);
    assertEquals("Data Type", actualDataType);
    assertEquals("Data", actualData);
    assertEquals("Event Type", actualEventType);
    assertEquals("Metadata", actualMetadata);
    assertEquals("Msg Type", actualMsgType);
    assertEquals("Relation Type", actualRelationType);
    assertEquals("RuleNodeDebugEvent(eventType=Event Type, eventEntity=13814000-1dd2-11b2-8080-808080808080, msgId"
        + "=13814000-1dd2-11b2-8080-808080808080, msgType=Msg Type, dataType=Data Type, relationType=Relation"
        + " Type, data=Data, metadata=Metadata, error=An error occurred)", actualToStringResult);
    assertEquals(EventType.DEBUG_RULE_NODE, buildResult.getType());
    assertSame(((TenantId) actualEventEntity).SYS_TENANT_ID, actualEventEntity);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#build()}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#data(String)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#dataType(String)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#entityId(UUID)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#error(String)}
   *   <li>
   * {@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#eventEntity(EntityId)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#eventType(String)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#id(UUID)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#metadata(String)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#msgId(UUID)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#msgType(String)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#relationType(String)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#serviceId(String)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#tenantId(TenantId)}
   *   <li>{@link RuleNodeDebugEvent.RuleNodeDebugEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  void testRuleNodeDebugEventBuilderBuild() {
    // Arrange and Act
    RuleNodeDebugEvent actualBuildResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(EntityId.NULL_UUID)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type")
        .id(EntityId.NULL_UUID)
        .metadata("Metadata")
        .msgId(EntityId.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Assert
    EntityId eventEntity = actualBuildResult.getEventEntity();
    assertTrue(eventEntity instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualBuildResult.getEntityId().toString());
    assertEquals("42", actualBuildResult.getServiceId());
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Data Type", actualBuildResult.getDataType());
    assertEquals("Data", actualBuildResult.getData());
    assertEquals("Event Type", actualBuildResult.getEventType());
    assertEquals("Metadata", actualBuildResult.getMetadata());
    assertEquals("Msg Type", actualBuildResult.getMsgType());
    assertEquals("Relation Type", actualBuildResult.getRelationType());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    assertEquals(EventType.DEBUG_RULE_NODE, actualBuildResult.getType());
    assertSame(eventEntity, actualBuildResult.getTenantId());
  }
}
