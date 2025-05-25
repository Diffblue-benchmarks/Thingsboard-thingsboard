package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
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
import org.thingsboard.server.common.data.event.LifecycleEvent.LifecycleEventBuilder;
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

@ContextConfiguration(classes = {LifecycleEventBuilder.class})
@ExtendWith(SpringExtension.class)
class LifecycleEventDiffblueTest {
  @Autowired
  private LifecycleEventBuilder lifecycleEventBuilder;

  /**
   * Test LifecycleEventBuilder {@link LifecycleEventBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEventBuilder#build()}
   *   <li>{@link LifecycleEventBuilder#entityId(UUID)}
   *   <li>{@link LifecycleEventBuilder#error(String)}
   *   <li>{@link LifecycleEventBuilder#id(UUID)}
   *   <li>{@link LifecycleEventBuilder#lcEventType(String)}
   *   <li>{@link LifecycleEventBuilder#serviceId(String)}
   *   <li>{@link LifecycleEventBuilder#success(boolean)}
   *   <li>{@link LifecycleEventBuilder#tenantId(TenantId)}
   *   <li>{@link LifecycleEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test LifecycleEventBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LifecycleEventBuilder.<init>()", "LifecycleEvent LifecycleEventBuilder.build()",
      "LifecycleEventBuilder LifecycleEventBuilder.entityId(UUID)",
      "LifecycleEventBuilder LifecycleEventBuilder.error(String)",
      "LifecycleEventBuilder LifecycleEventBuilder.id(UUID)",
      "LifecycleEventBuilder LifecycleEventBuilder.lcEventType(String)",
      "LifecycleEventBuilder LifecycleEventBuilder.serviceId(String)",
      "LifecycleEventBuilder LifecycleEventBuilder.success(boolean)",
      "LifecycleEventBuilder LifecycleEventBuilder.tenantId(TenantId)", "String LifecycleEventBuilder.toString()",
      "LifecycleEventBuilder LifecycleEventBuilder.ts(long)"})
  void testLifecycleEventBuilderBuild() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    LifecycleEventBuilder errorResult = builderResult.entityId(entityId).error("An error occurred");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    LifecycleEvent actualBuildResult = errorResult.id(id)
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Assert
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", actualBuildResult.getServiceId());
    UUID entityId2 = actualBuildResult.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualBuildResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Lc Event Type", actualBuildResult.getLcEventType());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.LC_EVENT, actualBuildResult.getType());
    assertTrue(actualBuildResult.isSuccess());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualBuildResult.getId().getId());
  }

  /**
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>Then return Body toPrettyString is {@code { "server" : "42", "event" : "Lc Event Type", "success" : true }}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); then return Body toPrettyString is '{ \"server\" : \"42\", \"event\" : \"Lc Event Type\", \"success\" : true }'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_thenReturnBodyToPrettyStringIsServer42EventLcEventTypeSuccessTrue() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error(null);
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    JsonNode body = buildResult.toInfo(EntityType.TENANT).getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    assertEquals("{\r\n  \"server\" : \"42\",\r\n  \"event\" : \"Lc Event Type\",\r\n  \"success\" : true\r\n}",
        body.toPrettyString());
    assertEquals(3, body.size());
  }

  /**
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code ALARM}.</li>
   *   <li>Then EntityId return {@link AlarmId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ALARM'; then EntityId return AlarmId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenAlarm_thenEntityIdReturnAlarmId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code API_USAGE_STATE}.</li>
   *   <li>Then EntityId return {@link ApiUsageStateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'API_USAGE_STATE'; then EntityId return ApiUsageStateId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenApiUsageState_thenEntityIdReturnApiUsageStateId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.</li>
   *   <li>Then EntityId return {@link AssetProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ASSET_PROFILE'; then EntityId return AssetProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenAssetProfile_thenEntityIdReturnAssetProfileId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code ASSET}.</li>
   *   <li>Then EntityId return {@link AssetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ASSET'; then EntityId return AssetId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenAsset_thenEntityIdReturnAssetId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code CUSTOMER}.</li>
   *   <li>Then EntityId return {@link CustomerId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'CUSTOMER'; then EntityId return CustomerId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenCustomer_thenEntityIdReturnCustomerId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code DASHBOARD}.</li>
   *   <li>Then EntityId return {@link DashboardId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DASHBOARD'; then EntityId return DashboardId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenDashboard_thenEntityIdReturnDashboardId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code DEVICE_PROFILE}.</li>
   *   <li>Then EntityId return {@link DeviceProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DEVICE_PROFILE'; then EntityId return DeviceProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenDeviceProfile_thenEntityIdReturnDeviceProfileId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code DEVICE}.</li>
   *   <li>Then EntityId return {@link DeviceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DEVICE'; then EntityId return DeviceId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenDevice_thenEntityIdReturnDeviceId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code DOMAIN}.</li>
   *   <li>Then EntityId return {@link DomainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DOMAIN'; then EntityId return DomainId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenDomain_thenEntityIdReturnDomainId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code EDGE}.</li>
   *   <li>Then EntityId return {@link EdgeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'EDGE'; then EntityId return EdgeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenEdge_thenEntityIdReturnEdgeId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.</li>
   *   <li>Then EntityId return {@link EntityViewId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ENTITY_VIEW'; then EntityId return EntityViewId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenEntityView_thenEntityIdReturnEntityViewId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code MOBILE_APP}.</li>
   *   <li>Then EntityId return {@link MobileAppId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'MOBILE_APP'; then EntityId return MobileAppId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenMobileApp_thenEntityIdReturnMobileAppId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_REQUEST}.</li>
   *   <li>Then EntityId return {@link NotificationRequestId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION_REQUEST'; then EntityId return NotificationRequestId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationRequest_thenEntityIdReturnNotificationRequestId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_RULE}.</li>
   *   <li>Then EntityId return {@link NotificationRuleId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION_RULE'; then EntityId return NotificationRuleId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationRule_thenEntityIdReturnNotificationRuleId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_TARGET}.</li>
   *   <li>Then EntityId return {@link NotificationTargetId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION_TARGET'; then EntityId return NotificationTargetId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationTarget_thenEntityIdReturnNotificationTargetId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION_TEMPLATE}.</li>
   *   <li>Then EntityId return {@link NotificationTemplateId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION_TEMPLATE'; then EntityId return NotificationTemplateId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationTemplate_thenEntityIdReturnNotificationTemplateId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code NOTIFICATION}.</li>
   *   <li>Then EntityId return {@link NotificationId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION'; then EntityId return NotificationId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenNotification_thenEntityIdReturnNotificationId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code OAUTH2_CLIENT}.</li>
   *   <li>Then EntityId return {@link OAuth2ClientId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'OAUTH2_CLIENT'; then EntityId return OAuth2ClientId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenOauth2Client_thenEntityIdReturnOAuth2ClientId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.</li>
   *   <li>Then EntityId return {@link OtaPackageId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'OTA_PACKAGE'; then EntityId return OtaPackageId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenOtaPackage_thenEntityIdReturnOtaPackageId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code QUEUE_STATS}.</li>
   *   <li>Then EntityId return {@link QueueStatsId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'QUEUE_STATS'; then EntityId return QueueStatsId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenQueueStats_thenEntityIdReturnQueueStatsId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code QUEUE}.</li>
   *   <li>Then EntityId return {@link QueueId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'QUEUE'; then EntityId return QueueId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenQueue_thenEntityIdReturnQueueId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code RPC}.</li>
   *   <li>Then EntityId return {@link RpcId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RPC'; then EntityId return RpcId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenRpc_thenEntityIdReturnRpcId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code RULE_CHAIN}.</li>
   *   <li>Then EntityId return {@link RuleChainId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RULE_CHAIN'; then EntityId return RuleChainId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenRuleChain_thenEntityIdReturnRuleChainId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code RULE_NODE}.</li>
   *   <li>Then EntityId return {@link RuleNodeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RULE_NODE'; then EntityId return RuleNodeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenRuleNode_thenEntityIdReturnRuleNodeId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code TB_RESOURCE}.</li>
   *   <li>Then EntityId return {@link TbResourceId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'TB_RESOURCE'; then EntityId return TbResourceId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenTbResource_thenEntityIdReturnTbResourceId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code TENANT_PROFILE}.</li>
   *   <li>Then EntityId return {@link TenantProfileId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'TENANT_PROFILE'; then EntityId return TenantProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenTenantProfile_thenEntityIdReturnTenantProfileId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code TENANT}.</li>
   *   <li>Then return Body iterator hasNext.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'TENANT'; then return Body iterator hasNext")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenTenant_thenReturnBodyIteratorHasNext() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    JsonNode body = buildResult.toInfo(EntityType.TENANT).getBody();
    assertTrue(body instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = body.iterator();
    assertTrue(iteratorResult.hasNext());
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    assertTrue(nextResult2.traverse() instanceof TreeTraversingParser);
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof BooleanNode);
    assertTrue(nextResult3.traverse() instanceof TreeTraversingParser);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
  }

  /**
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code USER}.</li>
   *   <li>Then EntityId return {@link UserId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'USER'; then EntityId return UserId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenUser_thenEntityIdReturnUserId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.</li>
   *   <li>Then EntityId return {@link WidgetTypeId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'WIDGET_TYPE'; then EntityId return WidgetTypeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenWidgetType_thenEntityIdReturnWidgetTypeId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#toInfo(EntityType)}.
   * <ul>
   *   <li>When {@code WIDGETS_BUNDLE}.</li>
   *   <li>Then EntityId return {@link WidgetsBundleId}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'WIDGETS_BUNDLE'; then EntityId return WidgetsBundleId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo LifecycleEvent.toInfo(EntityType)"})
  void testToInfo_whenWidgetsBundle_thenEntityIdReturnWidgetsBundleId() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
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
   * Test {@link LifecycleEvent#equals(Object)}, and {@link LifecycleEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEvent#equals(Object)}
   *   <li>{@link LifecycleEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifecycleEvent.equals(Object)", "int LifecycleEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    LifecycleEventBuilder builderResult2 = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult2 = builderResult2
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult2 = errorResult2.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link LifecycleEvent#equals(Object)}, and {@link LifecycleEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEvent#equals(Object)}
   *   <li>{@link LifecycleEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifecycleEvent.equals(Object)", "int LifecycleEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link LifecycleEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifecycleEvent.equals(Object)", "int LifecycleEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LifecycleEventBuilder lifecycleEventBuilder = mock(LifecycleEventBuilder.class);
    when(lifecycleEventBuilder.entityId(Mockito.<UUID>any())).thenReturn(LifecycleEvent.builder());
    LifecycleEventBuilder errorResult = lifecycleEventBuilder
        .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult2 = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult2 = errorResult2.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link LifecycleEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifecycleEvent.equals(Object)", "int LifecycleEvent.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link LifecycleEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LifecycleEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LifecycleEvent.equals(Object)", "int LifecycleEvent.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to LifecycleEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LifecycleEvent#setError(String)}
   *   <li>{@link LifecycleEvent#toString()}
   *   <li>{@link LifecycleEvent#getError()}
   *   <li>{@link LifecycleEvent#getLcEventType()}
   *   <li>{@link LifecycleEvent#getType()}
   *   <li>{@link LifecycleEvent#isSuccess()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String LifecycleEvent.getError()", "String LifecycleEvent.getLcEventType()",
      "EventType LifecycleEvent.getType()", "boolean LifecycleEvent.isSuccess()",
      "void LifecycleEvent.setError(String)", "String LifecycleEvent.toString()"})
  void testGettersAndSetters() {
    // Arrange
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(TenantId.SYS_TENANT_ID)
        .ts(1L)
        .build();

    // Act
    buildResult.setError("An error occurred");
    String actualToStringResult = buildResult.toString();
    String actualError = buildResult.getError();
    String actualLcEventType = buildResult.getLcEventType();
    EventType actualType = buildResult.getType();

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals("Lc Event Type", actualLcEventType);
    assertEquals("LifecycleEvent(lcEventType=Lc Event Type, success=true, error=An error occurred)",
        actualToStringResult);
    assertEquals(EventType.LC_EVENT, actualType);
    assertTrue(buildResult.isSuccess());
  }
}
