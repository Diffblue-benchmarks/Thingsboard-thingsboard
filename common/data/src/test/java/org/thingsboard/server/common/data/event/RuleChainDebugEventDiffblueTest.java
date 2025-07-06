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
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
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
import org.thingsboard.server.common.data.event.RuleChainDebugEvent.RuleChainDebugEventBuilder;
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

@ContextConfiguration(classes = {RuleChainDebugEventBuilder.class})
@ExtendWith(SpringExtension.class)
class RuleChainDebugEventDiffblueTest {
  @Autowired private RuleChainDebugEventBuilder ruleChainDebugEventBuilder;

  /**
   * Test RuleChainDebugEventBuilder {@link RuleChainDebugEventBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainDebugEventBuilder#build()}
   *   <li>{@link RuleChainDebugEventBuilder#entityId(UUID)}
   *   <li>{@link RuleChainDebugEventBuilder#error(String)}
   *   <li>{@link RuleChainDebugEventBuilder#id(UUID)}
   *   <li>{@link RuleChainDebugEventBuilder#message(String)}
   *   <li>{@link RuleChainDebugEventBuilder#serviceId(String)}
   *   <li>{@link RuleChainDebugEventBuilder#tenantId(TenantId)}
   *   <li>{@link RuleChainDebugEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test RuleChainDebugEventBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void RuleChainDebugEventBuilder.<init>()",
    "RuleChainDebugEvent RuleChainDebugEventBuilder.build()",
    "RuleChainDebugEventBuilder RuleChainDebugEventBuilder.entityId(UUID)",
    "RuleChainDebugEventBuilder RuleChainDebugEventBuilder.error(String)",
    "RuleChainDebugEventBuilder RuleChainDebugEventBuilder.id(UUID)",
    "RuleChainDebugEventBuilder RuleChainDebugEventBuilder.message(String)",
    "RuleChainDebugEventBuilder RuleChainDebugEventBuilder.serviceId(String)",
    "RuleChainDebugEventBuilder RuleChainDebugEventBuilder.tenantId(TenantId)",
    "String RuleChainDebugEventBuilder.toString()",
    "RuleChainDebugEventBuilder RuleChainDebugEventBuilder.ts(long)"
  })
  void testRuleChainDebugEventBuilderBuild() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleChainDebugEventBuilder errorResult =
        builderResult.entityId(entityId).error("An error occurred");
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    RuleChainDebugEvent actualBuildResult =
        errorResult
            .id(id)
            .message("Not all who wander are lost")
            .serviceId("42")
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
    assertEquals("Not all who wander are lost", actualBuildResult.getMessage());
    assertEquals(1L, actualBuildResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.DEBUG_RULE_CHAIN, actualBuildResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualBuildResult.getId().getId());
  }

  /**
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ALARM'; then EntityId return AlarmId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenAlarm_thenEntityIdReturnAlarmId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code API_USAGE_STATE}.
   *   <li>Then EntityId return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'API_USAGE_STATE'; then EntityId return ApiUsageStateId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenApiUsageState_thenEntityIdReturnApiUsageStateId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.
   *   <li>Then EntityId return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ASSET_PROFILE'; then EntityId return AssetProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenAssetProfile_thenEntityIdReturnAssetProfileId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ASSET}.
   *   <li>Then EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ASSET'; then EntityId return AssetId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenAsset_thenEntityIdReturnAssetId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code CUSTOMER}.
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'CUSTOMER'; then EntityId return CustomerId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenCustomer_thenEntityIdReturnCustomerId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DASHBOARD}.
   *   <li>Then EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DASHBOARD'; then EntityId return DashboardId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenDashboard_thenEntityIdReturnDashboardId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DEVICE_PROFILE}.
   *   <li>Then EntityId return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'DEVICE_PROFILE'; then EntityId return DeviceProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenDeviceProfile_thenEntityIdReturnDeviceProfileId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DEVICE}.
   *   <li>Then EntityId return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DEVICE'; then EntityId return DeviceId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenDevice_thenEntityIdReturnDeviceId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DOMAIN}.
   *   <li>Then EntityId return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DOMAIN'; then EntityId return DomainId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenDomain_thenEntityIdReturnDomainId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code EDGE}.
   *   <li>Then EntityId return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'EDGE'; then EntityId return EdgeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenEdge_thenEntityIdReturnEdgeId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.
   *   <li>Then EntityId return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ENTITY_VIEW'; then EntityId return EntityViewId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenEntityView_thenEntityIdReturnEntityViewId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code MOBILE_APP}.
   *   <li>Then EntityId return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'MOBILE_APP'; then EntityId return MobileAppId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenMobileApp_thenEntityIdReturnMobileAppId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_REQUEST}.
   *   <li>Then EntityId return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'NOTIFICATION_REQUEST'; then EntityId return NotificationRequestId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationRequest_thenEntityIdReturnNotificationRequestId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_RULE}.
   *   <li>Then EntityId return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'NOTIFICATION_RULE'; then EntityId return NotificationRuleId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationRule_thenEntityIdReturnNotificationRuleId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_TARGET}.
   *   <li>Then EntityId return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'NOTIFICATION_TARGET'; then EntityId return NotificationTargetId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationTarget_thenEntityIdReturnNotificationTargetId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_TEMPLATE}.
   *   <li>Then EntityId return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'NOTIFICATION_TEMPLATE'; then EntityId return NotificationTemplateId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationTemplate_thenEntityIdReturnNotificationTemplateId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION}.
   *   <li>Then EntityId return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION'; then EntityId return NotificationId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenNotification_thenEntityIdReturnNotificationId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code OAUTH2_CLIENT}.
   *   <li>Then EntityId return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'OAUTH2_CLIENT'; then EntityId return OAuth2ClientId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenOauth2Client_thenEntityIdReturnOAuth2ClientId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.
   *   <li>Then EntityId return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'OTA_PACKAGE'; then EntityId return OtaPackageId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenOtaPackage_thenEntityIdReturnOtaPackageId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code QUEUE_STATS}.
   *   <li>Then EntityId return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'QUEUE_STATS'; then EntityId return QueueStatsId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenQueueStats_thenEntityIdReturnQueueStatsId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code QUEUE}.
   *   <li>Then EntityId return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'QUEUE'; then EntityId return QueueId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenQueue_thenEntityIdReturnQueueId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code RPC}.
   *   <li>Then EntityId return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RPC'; then EntityId return RpcId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenRpc_thenEntityIdReturnRpcId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code RULE_CHAIN}.
   *   <li>Then EntityId return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RULE_CHAIN'; then EntityId return RuleChainId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenRuleChain_thenEntityIdReturnRuleChainId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code RULE_NODE}.
   *   <li>Then EntityId return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RULE_NODE'; then EntityId return RuleNodeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenRuleNode_thenEntityIdReturnRuleNodeId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TB_RESOURCE}.
   *   <li>Then EntityId return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'TB_RESOURCE'; then EntityId return TbResourceId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenTbResource_thenEntityIdReturnTbResourceId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TENANT_PROFILE}.
   *   <li>Then EntityId return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'TENANT_PROFILE'; then EntityId return TenantProfileId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenTenantProfile_thenEntityIdReturnTenantProfileId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code USER}.
   *   <li>Then EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'USER'; then EntityId return UserId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenUser_thenEntityIdReturnUserId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.
   *   <li>Then EntityId return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'WIDGET_TYPE'; then EntityId return WidgetTypeId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenWidgetType_thenEntityIdReturnWidgetTypeId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code WIDGETS_BUNDLE}.
   *   <li>Then EntityId return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'WIDGETS_BUNDLE'; then EntityId return WidgetsBundleId")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EventInfo RuleChainDebugEvent.toInfo(EntityType)"})
  void testToInfo_whenWidgetsBundle_thenEntityIdReturnWidgetsBundleId() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#equals(Object)}, and {@link RuleChainDebugEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainDebugEvent#equals(Object)}
   *   <li>{@link RuleChainDebugEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainDebugEvent.equals(Object)",
    "int RuleChainDebugEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();
    RuleChainDebugEventBuilder builderResult2 = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult2 =
        builderResult2
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult2 =
        errorResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#equals(Object)}, and {@link RuleChainDebugEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainDebugEvent#equals(Object)}
   *   <li>{@link RuleChainDebugEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainDebugEvent.equals(Object)",
    "int RuleChainDebugEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
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
   * Test {@link RuleChainDebugEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainDebugEvent.equals(Object)",
    "int RuleChainDebugEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventBuilder ruleChainDebugEventBuilder = mock(RuleChainDebugEventBuilder.class);
    when(ruleChainDebugEventBuilder.entityId(Mockito.<UUID>any()))
        .thenReturn(RuleChainDebugEvent.builder());
    RuleChainDebugEventBuilder errorResult =
        ruleChainDebugEventBuilder
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult2 =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult2 =
        errorResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RuleChainDebugEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainDebugEvent.equals(Object)",
    "int RuleChainDebugEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link RuleChainDebugEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RuleChainDebugEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RuleChainDebugEvent.equals(Object)",
    "int RuleChainDebugEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RuleChainDebugEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RuleChainDebugEvent#setError(String)}
   *   <li>{@link RuleChainDebugEvent#setMessage(String)}
   *   <li>{@link RuleChainDebugEvent#toString()}
   *   <li>{@link RuleChainDebugEvent#getError()}
   *   <li>{@link RuleChainDebugEvent#getMessage()}
   *   <li>{@link RuleChainDebugEvent#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "String RuleChainDebugEvent.getError()",
    "String RuleChainDebugEvent.getMessage()",
    "EventType RuleChainDebugEvent.getType()",
    "void RuleChainDebugEvent.setError(String)",
    "void RuleChainDebugEvent.setMessage(String)",
    "String RuleChainDebugEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    RuleChainDebugEventBuilder builderResult = RuleChainDebugEvent.builder();
    RuleChainDebugEventBuilder errorResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .error("An error occurred");
    RuleChainDebugEvent buildResult =
        errorResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .message("Not all who wander are lost")
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    // Act
    buildResult.setError("An error occurred");
    buildResult.setMessage("Not all who wander are lost");
    String actualToStringResult = buildResult.toString();
    String actualError = buildResult.getError();
    String actualMessage = buildResult.getMessage();

    // Assert
    assertEquals("An error occurred", actualError);
    assertEquals("Not all who wander are lost", actualMessage);
    assertEquals(
        "RuleChainDebugEvent(message=Not all who wander are lost, error=An error occurred)",
        actualToStringResult);
    assertEquals(EventType.DEBUG_RULE_CHAIN, buildResult.getType());
  }
}
