package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.Iterator;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EventInfo;
import org.thingsboard.server.common.data.event.RuleNodeDebugEvent.RuleNodeDebugEventBuilder;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.ApiUsageStateId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.OtaPackageId;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.id.WidgetsBundleId;

@ContextConfiguration(classes = {RuleNodeDebugEventBuilder.class})
@ExtendWith(SpringExtension.class)
class RuleNodeDebugEventDiffblueTest {
  @Autowired
  private RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder;

  /**
   * Test RuleNodeDebugEventBuilder {@link RuleNodeDebugEventBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RuleNodeDebugEventBuilder#build()}
   *   <li>{@link RuleNodeDebugEventBuilder#data(String)}
   *   <li>{@link RuleNodeDebugEventBuilder#dataType(String)}
   *   <li>{@link RuleNodeDebugEventBuilder#entityId(UUID)}
   *   <li>{@link RuleNodeDebugEventBuilder#error(String)}
   *   <li>{@link RuleNodeDebugEventBuilder#eventEntity(EntityId)}
   *   <li>{@link RuleNodeDebugEventBuilder#eventType(String)}
   *   <li>{@link RuleNodeDebugEventBuilder#id(UUID)}
   *   <li>{@link RuleNodeDebugEventBuilder#metadata(String)}
   *   <li>{@link RuleNodeDebugEventBuilder#msgId(UUID)}
   *   <li>{@link RuleNodeDebugEventBuilder#msgType(String)}
   *   <li>{@link RuleNodeDebugEventBuilder#relationType(String)}
   *   <li>{@link RuleNodeDebugEventBuilder#serviceId(String)}
   *   <li>{@link RuleNodeDebugEventBuilder#tenantId(TenantId)}
   *   <li>{@link RuleNodeDebugEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test RuleNodeDebugEventBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void RuleNodeDebugEventBuilder.<init>()", "RuleNodeDebugEvent RuleNodeDebugEventBuilder.build()",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.data(String)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.dataType(String)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.entityId(UUID)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.error(String)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.eventEntity(EntityId)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.eventType(String)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.id(UUID)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.metadata(String)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.msgId(UUID)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.msgType(String)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.relationType(String)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.serviceId(String)",
      "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.tenantId(TenantId)",
      "String RuleNodeDebugEventBuilder.toString()", "RuleNodeDebugEventBuilder RuleNodeDebugEventBuilder.ts(long)"})
  void testRuleNodeDebugEventBuilderBuild() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult.entityId(entityId)
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult.id(id).metadata("Metadata");
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

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data(null).dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
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
    JsonNode body = buildResult.toInfo(EntityType.TENANT).getBody();
    assertTrue(body instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = body.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n" + "  \"server\" : \"42\",\r\n" + "  \"type\" : \"Event Type\",\r\n"
            + "  \"entityId\" : \"13814000-1dd2-11b2-8080-808080808080\",\r\n" + "  \"entityType\" : \"TENANT\",\r\n"
            + "  \"msgId\" : \"784f394c-42b6-435a-983c-b7beff2784f9\",\r\n" + "  \"msgType\" : \"Msg Type\",\r\n"
            + "  \"dataType\" : \"Data Type\",\r\n" + "  \"relationType\" : \"Relation Type\",\r\n"
            + "  \"metadata\" : \"Metadata\",\r\n" + "  \"error\" : \"An error occurred\"\r\n" + "}",
        body.toPrettyString());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo2() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEvent buildResult = eventTypeResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata")
        .msgId(null)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    JsonNode body = buildResult.toInfo(EntityType.TENANT).getBody();
    assertTrue(body instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = body.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertEquals(
        "{\r\n" + "  \"server\" : \"42\",\r\n" + "  \"type\" : \"Event Type\",\r\n"
            + "  \"entityId\" : \"13814000-1dd2-11b2-8080-808080808080\",\r\n" + "  \"entityType\" : \"TENANT\",\r\n"
            + "  \"msgType\" : \"Msg Type\",\r\n" + "  \"dataType\" : \"Data Type\",\r\n"
            + "  \"relationType\" : \"Relation Type\",\r\n" + "  \"data\" : \"Data\",\r\n"
            + "  \"metadata\" : \"Metadata\",\r\n" + "  \"error\" : \"An error occurred\"\r\n" + "}",
        body.toPrettyString());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>Then return Body size is nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); then return Body size is nine")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_thenReturnBodySizeIsNine() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(null)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
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
    JsonNode body = buildResult.toInfo(EntityType.TENANT).getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertEquals("{\r\n" + "  \"server\" : \"42\",\r\n" + "  \"type\" : \"Event Type\",\r\n"
        + "  \"msgId\" : \"784f394c-42b6-435a-983c-b7beff2784f9\",\r\n" + "  \"msgType\" : \"Msg Type\",\r\n"
        + "  \"dataType\" : \"Data Type\",\r\n" + "  \"relationType\" : \"Relation Type\",\r\n"
        + "  \"data\" : \"Data\",\r\n" + "  \"metadata\" : \"Metadata\",\r\n"
        + "  \"error\" : \"An error occurred\"\r\n" + "}", body.toPrettyString());
    assertEquals(9, body.size());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code ALARM}.</li>
   *   <li>Then EntityId return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ALARM'; then EntityId return AlarmId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenAlarm_thenEntityIdReturnAlarmId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.ALARM);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof AlarmId);
    assertEquals(EntityType.ALARM, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code API_USAGE_STATE}.</li>
   *   <li>Then EntityId return {@link ApiUsageStateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'API_USAGE_STATE'; then EntityId return ApiUsageStateId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenApiUsageState_thenEntityIdReturnApiUsageStateId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.API_USAGE_STATE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof ApiUsageStateId);
    assertEquals(EntityType.API_USAGE_STATE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.</li>
   *   <li>Then EntityId return {@link AssetProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ASSET_PROFILE'; then EntityId return AssetProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenAssetProfile_thenEntityIdReturnAssetProfileId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.ASSET_PROFILE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof AssetProfileId);
    assertEquals(EntityType.ASSET_PROFILE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code ASSET}.</li>
   *   <li>Then EntityId return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ASSET'; then EntityId return AssetId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenAsset_thenEntityIdReturnAssetId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.ASSET);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code CUSTOMER}.</li>
   *   <li>Then EntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'CUSTOMER'; then EntityId return CustomerId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenCustomer_thenEntityIdReturnCustomerId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.CUSTOMER);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code DASHBOARD}.</li>
   *   <li>Then EntityId return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DASHBOARD'; then EntityId return DashboardId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenDashboard_thenEntityIdReturnDashboardId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.DASHBOARD);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code DEVICE_PROFILE}.</li>
   *   <li>Then EntityId return {@link DeviceProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DEVICE_PROFILE'; then EntityId return DeviceProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenDeviceProfile_thenEntityIdReturnDeviceProfileId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.DEVICE_PROFILE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof DeviceProfileId);
    assertEquals(EntityType.DEVICE_PROFILE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code DEVICE}.</li>
   *   <li>Then EntityId return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DEVICE'; then EntityId return DeviceId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenDevice_thenEntityIdReturnDeviceId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.DEVICE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code DOMAIN}.</li>
   *   <li>Then EntityId return {@link DomainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DOMAIN'; then EntityId return DomainId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenDomain_thenEntityIdReturnDomainId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.DOMAIN);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof DomainId);
    assertEquals(EntityType.DOMAIN, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code EDGE}.</li>
   *   <li>Then EntityId return {@link EdgeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'EDGE'; then EntityId return EdgeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenEdge_thenEntityIdReturnEdgeId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.EDGE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof EdgeId);
    assertEquals(EntityType.EDGE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.</li>
   *   <li>Then EntityId return {@link EntityViewId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ENTITY_VIEW'; then EntityId return EntityViewId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenEntityView_thenEntityIdReturnEntityViewId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.ENTITY_VIEW);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code MOBILE_APP}.</li>
   *   <li>Then EntityId return {@link MobileAppId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'MOBILE_APP'; then EntityId return MobileAppId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenMobileApp_thenEntityIdReturnMobileAppId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.MOBILE_APP);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof MobileAppId);
    assertEquals(EntityType.MOBILE_APP, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_REQUEST}.</li>
   *   <li>Then EntityId return {@link NotificationRequestId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION_REQUEST'; then EntityId return NotificationRequestId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationRequest_thenEntityIdReturnNotificationRequestId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.NOTIFICATION_REQUEST);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof NotificationRequestId);
    assertEquals(EntityType.NOTIFICATION_REQUEST, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_RULE}.</li>
   *   <li>Then EntityId return {@link NotificationRuleId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION_RULE'; then EntityId return NotificationRuleId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationRule_thenEntityIdReturnNotificationRuleId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.NOTIFICATION_RULE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof NotificationRuleId);
    assertEquals(EntityType.NOTIFICATION_RULE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_TARGET}.</li>
   *   <li>Then EntityId return {@link NotificationTargetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION_TARGET'; then EntityId return NotificationTargetId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationTarget_thenEntityIdReturnNotificationTargetId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.NOTIFICATION_TARGET);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof NotificationTargetId);
    assertEquals(EntityType.NOTIFICATION_TARGET, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_TEMPLATE}.</li>
   *   <li>Then EntityId return {@link NotificationTemplateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION_TEMPLATE'; then EntityId return NotificationTemplateId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationTemplate_thenEntityIdReturnNotificationTemplateId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.NOTIFICATION_TEMPLATE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof NotificationTemplateId);
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION}.</li>
   *   <li>Then EntityId return {@link NotificationId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION'; then EntityId return NotificationId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenNotification_thenEntityIdReturnNotificationId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.NOTIFICATION);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof NotificationId);
    assertEquals(EntityType.NOTIFICATION, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code OAUTH2_CLIENT}.</li>
   *   <li>Then EntityId return {@link OAuth2ClientId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'OAUTH2_CLIENT'; then EntityId return OAuth2ClientId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenOauth2Client_thenEntityIdReturnOAuth2ClientId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.OAUTH2_CLIENT);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof OAuth2ClientId);
    assertEquals(EntityType.OAUTH2_CLIENT, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.</li>
   *   <li>Then EntityId return {@link OtaPackageId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'OTA_PACKAGE'; then EntityId return OtaPackageId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenOtaPackage_thenEntityIdReturnOtaPackageId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.OTA_PACKAGE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof OtaPackageId);
    assertEquals(EntityType.OTA_PACKAGE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code QUEUE_STATS}.</li>
   *   <li>Then EntityId return {@link QueueStatsId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'QUEUE_STATS'; then EntityId return QueueStatsId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenQueueStats_thenEntityIdReturnQueueStatsId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.QUEUE_STATS);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof QueueStatsId);
    assertEquals(EntityType.QUEUE_STATS, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code QUEUE}.</li>
   *   <li>Then EntityId return {@link QueueId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'QUEUE'; then EntityId return QueueId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenQueue_thenEntityIdReturnQueueId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.QUEUE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof QueueId);
    assertEquals(EntityType.QUEUE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code RPC}.</li>
   *   <li>Then EntityId return {@link RpcId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RPC'; then EntityId return RpcId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenRpc_thenEntityIdReturnRpcId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.RPC);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof RpcId);
    assertEquals(EntityType.RPC, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code RULE_CHAIN}.</li>
   *   <li>Then EntityId return {@link RuleChainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RULE_CHAIN'; then EntityId return RuleChainId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenRuleChain_thenEntityIdReturnRuleChainId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.RULE_CHAIN);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code RULE_NODE}.</li>
   *   <li>Then EntityId return {@link RuleNodeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RULE_NODE'; then EntityId return RuleNodeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenRuleNode_thenEntityIdReturnRuleNodeId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.RULE_NODE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code TB_RESOURCE}.</li>
   *   <li>Then EntityId return {@link TbResourceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'TB_RESOURCE'; then EntityId return TbResourceId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenTbResource_thenEntityIdReturnTbResourceId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.TB_RESOURCE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof TbResourceId);
    assertEquals(EntityType.TB_RESOURCE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code TENANT_PROFILE}.</li>
   *   <li>Then EntityId return {@link TenantProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'TENANT_PROFILE'; then EntityId return TenantProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenTenantProfile_thenEntityIdReturnTenantProfileId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.TENANT_PROFILE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof TenantProfileId);
    assertEquals(EntityType.TENANT_PROFILE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code TENANT}.</li>
   *   <li>Then Body iterator next return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'TENANT'; then Body iterator next return TextNode")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenTenant_thenBodyIteratorNextReturnTextNode() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
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
    JsonNode body = buildResult.toInfo(EntityType.TENANT).getBody();
    assertTrue(body instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = body.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code USER}.</li>
   *   <li>Then EntityId return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'USER'; then EntityId return UserId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenUser_thenEntityIdReturnUserId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.USER);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof UserId);
    assertEquals(EntityType.USER, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.</li>
   *   <li>Then EntityId return {@link WidgetTypeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'WIDGET_TYPE'; then EntityId return WidgetTypeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenWidgetType_thenEntityIdReturnWidgetTypeId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.WIDGET_TYPE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof WidgetTypeId);
    assertEquals(EntityType.WIDGET_TYPE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code WIDGETS_BUNDLE}.</li>
   *   <li>Then EntityId return {@link WidgetsBundleId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link RuleNodeDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'WIDGETS_BUNDLE'; then EntityId return WidgetsBundleId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleNodeDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenWidgetsBundle_thenEntityIdReturnWidgetsBundleId() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    EventInfo actualToInfoResult = buildResult.toInfo(EntityType.WIDGETS_BUNDLE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof WidgetsBundleId);
    assertEquals(EntityType.WIDGETS_BUNDLE, entityId.getEntityType());
  }

  /**
   * Test {@link RuleNodeDebugEvent#equals(Object)}, and {@link RuleNodeDebugEvent#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEvent.equals(Object)", "int RuleNodeDebugEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEventBuilder dataTypeResult2 = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult2 = dataTypeResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult2 = eventTypeResult2
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
   * Test {@link RuleNodeDebugEvent#equals(Object)}, and {@link RuleNodeDebugEvent#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEvent.equals(Object)", "int RuleNodeDebugEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEvent.equals(Object)", "int RuleNodeDebugEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder = mock(RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder.data(Mockito.<String>any())).thenReturn(RuleNodeDebugEvent.builder());
    RuleNodeDebugEventBuilder dataTypeResult = ruleNodeDebugEventBuilder.data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEventBuilder dataTypeResult2 = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult2 = dataTypeResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult2 = eventTypeResult2
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEvent.equals(Object)", "int RuleNodeDebugEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder = mock(RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder.dataType(Mockito.<String>any())).thenReturn(RuleNodeDebugEvent.builder());
    RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder2 = mock(RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder2.data(Mockito.<String>any())).thenReturn(ruleNodeDebugEventBuilder);
    RuleNodeDebugEventBuilder dataTypeResult = ruleNodeDebugEventBuilder2.data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEventBuilder dataTypeResult2 = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult2 = dataTypeResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult2 = eventTypeResult2
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEvent.equals(Object)", "int RuleNodeDebugEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder = mock(RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(RuleNodeDebugEvent.builder());
    RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder2 = mock(RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder2.dataType(Mockito.<String>any())).thenReturn(ruleNodeDebugEventBuilder);
    RuleNodeDebugEventBuilder ruleNodeDebugEventBuilder3 = mock(RuleNodeDebugEventBuilder.class);
    when(ruleNodeDebugEventBuilder3.data(Mockito.<String>any())).thenReturn(ruleNodeDebugEventBuilder2);
    RuleNodeDebugEventBuilder dataTypeResult = ruleNodeDebugEventBuilder3.data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
        .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .metadata("Metadata");
    RuleNodeDebugEvent buildResult = metadataResult.msgId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    RuleNodeDebugEventBuilder dataTypeResult2 = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult2 = dataTypeResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult2 = eventTypeResult2
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEvent.equals(Object)", "int RuleNodeDebugEvent.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean RuleNodeDebugEvent.equals(Object)", "int RuleNodeDebugEvent.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String RuleNodeDebugEvent.getData()", "String RuleNodeDebugEvent.getDataType()",
      "String RuleNodeDebugEvent.getError()", "EntityId RuleNodeDebugEvent.getEventEntity()",
      "String RuleNodeDebugEvent.getEventType()", "String RuleNodeDebugEvent.getMetadata()",
      "UUID RuleNodeDebugEvent.getMsgId()", "String RuleNodeDebugEvent.getMsgType()",
      "String RuleNodeDebugEvent.getRelationType()", "EventType RuleNodeDebugEvent.getType()",
      "void RuleNodeDebugEvent.setData(String)", "void RuleNodeDebugEvent.setError(String)",
      "void RuleNodeDebugEvent.setMetadata(String)", "String RuleNodeDebugEvent.toString()"})
  void testGettersAndSetters() {
    // Arrange
    RuleNodeDebugEventBuilder dataTypeResult = RuleNodeDebugEvent.builder().data("Data").dataType("Data Type");
    RuleNodeDebugEventBuilder eventTypeResult = dataTypeResult
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred")
        .eventEntity(TenantId.SYS_TENANT_ID)
        .eventType("Event Type");
    RuleNodeDebugEventBuilder metadataResult = eventTypeResult
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

    // Assert
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
}
