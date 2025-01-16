package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.event.RuleNodeDebugEvent.RuleNodeDebugEventBuilder;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class RuleNodeDebugEventDiffblueTest {
  /**
   * Test {@link RuleNodeDebugEvent#equals(Object)}, and
   * {@link RuleNodeDebugEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEvent#equals(Object)}
   *   <li>{@link RuleNodeDebugEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult2 = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult2 = dataTypeResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult2 = eventTypeResult2
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult2 = metadataResult2.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   * Test {@link RuleNodeDebugEvent#equals(Object)}, and
   * {@link RuleNodeDebugEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEvent#equals(Object)}
   *   <li>{@link RuleNodeDebugEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   * Test {@link RuleNodeDebugEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder = mock(
        RuleNodeDebugEvent.RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder.data(Mockito.<String>any())).thenReturn(RuleNodeDebugEvent.builder());
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult = ruleNodeDebugEventBuilder.data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult2 = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult2 = dataTypeResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult2 = eventTypeResult2
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult2 = metadataResult2.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   * Test {@link RuleNodeDebugEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder = mock(
        RuleNodeDebugEvent.RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder.dataType(Mockito.<String>any())).thenReturn(RuleNodeDebugEvent.builder());
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder2 = mock(
        RuleNodeDebugEvent.RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder2.data(Mockito.<String>any())).thenReturn(ruleNodeDebugEventBuilder);
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult = ruleNodeDebugEventBuilder2.data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult2 = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult2 = dataTypeResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult2 = eventTypeResult2
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult2 = metadataResult2.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   * Test {@link RuleNodeDebugEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult = ruleNodeDebugEventBuilder3.data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult2 = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult2 = dataTypeResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult2 = eventTypeResult2
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult2 = metadataResult2.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   * Test {@link RuleNodeDebugEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   * Test {@link RuleNodeDebugEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    UUID msgId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(msgId)
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
    UUID actualMsgId = buildResult.getMsgId();
    String actualMsgType = buildResult.getMsgType();
    String actualRelationType = buildResult.getRelationType();
    EventType actualType = buildResult.getType();

    // Assert that nothing has changed
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualMsgId.toString());
    assertEquals("An error occurred", actualError);
    assertEquals("Data Type", actualDataType);
    assertEquals("Data", actualData);
    assertEquals("Event Type", actualEventType);
    assertEquals("Metadata", actualMetadata);
    assertEquals("Msg Type", actualMsgType);
    assertEquals("Relation Type", actualRelationType);
    assertEquals("RuleNodeDebugEvent(eventType=Event Type, eventEntity=13814000-1dd2-11b2-8080-808080808080, msgId"
        + "=784f394c-42b6-435a-983c-b7beff2784f9, msgType=Msg Type, dataType=Data Type, relationType=Relation"
        + " Type, data=Data, metadata=Metadata, error=An error occurred)", actualToStringResult);
    assertEquals(EventType.DEBUG_RULE_NODE, actualType);
    assertSame(msgId, actualMsgId);
    assertSame(((TenantId) actualEventEntity).SYS_TENANT_ID, actualEventEntity);
  }

  /**
   * Test RuleNodeDebugEventBuilder {@link RuleNodeDebugEventBuilder#build()}.
   * <p>
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
  @DisplayName("Test RuleNodeDebugEventBuilder build()")
  void testRuleNodeDebugEventBuilderBuild() {
    // Arrange
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult.entityId(entityId)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleNodeDebugEvent.RuleNodeDebugEventBuilder metadataResult = eventTypeResult.id(id).metadata("Metadata");
    UUID msgId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    RuleNodeDebugEvent actualBuildResult = metadataResult.msgId(msgId)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Assert
    EntityId eventEntity = actualBuildResult.getEventEntity();
    assertTrue(eventEntity instanceof TenantId);
    assertEquals("42", actualBuildResult.getServiceId());
    UUID entityId2 = actualBuildResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID msgId2 = actualBuildResult.getMsgId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", msgId2.toString());
    UUID uuidId = actualBuildResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Data Type", actualBuildResult.getDataType());
    assertEquals("Data", actualBuildResult.getData());
    assertEquals("Event Type", actualBuildResult.getEventType());
    assertEquals("Metadata", actualBuildResult.getMetadata());
    assertEquals("Msg Type", actualBuildResult.getMsgType());
    assertEquals("Relation Type", actualBuildResult.getRelationType());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    assertEquals(EventType.DEBUG_RULE_NODE, actualBuildResult.getType());
    assertSame(entityId, entityId2);
    assertSame(msgId, msgId2);
    assertSame(id, uuidId);
    assertSame(id, actualBuildResult.getId().getId());
    assertSame(eventEntity, actualBuildResult.getTenantId());
  }
}
