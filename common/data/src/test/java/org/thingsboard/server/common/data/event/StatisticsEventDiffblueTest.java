package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.EventInfo;
import org.thingsboard.server.common.data.event.StatisticsEvent.StatisticsEventBuilder;
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

@ContextConfiguration(classes = {StatisticsEventBuilder.class})
@ExtendWith(SpringExtension.class)
class StatisticsEventDiffblueTest {
  @Autowired private StatisticsEventBuilder statisticsEventBuilder;

  /**
   * Test StatisticsEventBuilder {@link StatisticsEventBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatisticsEventBuilder#build()}
   *   <li>{@link StatisticsEventBuilder#entityId(UUID)}
   *   <li>{@link StatisticsEventBuilder#errorsOccurred(long)}
   *   <li>{@link StatisticsEventBuilder#id(UUID)}
   *   <li>{@link StatisticsEventBuilder#messagesProcessed(long)}
   *   <li>{@link StatisticsEventBuilder#serviceId(String)}
   *   <li>{@link StatisticsEventBuilder#tenantId(TenantId)}
   *   <li>{@link StatisticsEventBuilder#ts(long)}
   * </ul>
   */
  @Test
  @DisplayName("Test StatisticsEventBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void StatisticsEventBuilder.<init>()",
    "StatisticsEvent StatisticsEventBuilder.build()",
    "StatisticsEventBuilder StatisticsEventBuilder.entityId(UUID)",
    "StatisticsEventBuilder StatisticsEventBuilder.errorsOccurred(long)",
    "StatisticsEventBuilder StatisticsEventBuilder.id(UUID)",
    "StatisticsEventBuilder StatisticsEventBuilder.messagesProcessed(long)",
    "StatisticsEventBuilder StatisticsEventBuilder.serviceId(String)",
    "StatisticsEventBuilder StatisticsEventBuilder.tenantId(TenantId)",
    "String StatisticsEventBuilder.toString()",
    "StatisticsEventBuilder StatisticsEventBuilder.ts(long)"
  })
  void testStatisticsEventBuilderBuild() {
    // Arrange and Act
    StatisticsEventBuilder actualBuilderResult = StatisticsEvent.builder();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    StatisticsEventBuilder actualErrorsOccurredResult =
        actualBuilderResult.entityId(entityId).errorsOccurred(-1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    StatisticsEvent actualStatisticsEvent =
        actualErrorsOccurredResult
            .id(id)
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    // Assert
    assertEquals("42", actualStatisticsEvent.getServiceId());
    UUID entityId2 = actualStatisticsEvent.getEntityId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", entityId2.toString());
    UUID uuidId = actualStatisticsEvent.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals(-1L, actualStatisticsEvent.getErrorsOccurred());
    assertEquals(1L, actualStatisticsEvent.getCreatedTime());
    assertEquals(1L, actualStatisticsEvent.getMessagesProcessed());
    assertEquals(EventType.STATS, actualStatisticsEvent.getType());
    assertSame(entityId, entityId2);
    assertSame(id, uuidId);
    assertSame(id, actualStatisticsEvent.getId().getId());
    assertSame(TenantId.SYS_TENANT_ID, actualStatisticsEvent.getTenantId());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ALARM}.
   *   <li>Then EntityId return {@link AlarmId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ALARM'; then EntityId return AlarmId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenAlarm_thenEntityIdReturnAlarmId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.ALARM);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof AlarmId);
    assertEquals(EntityType.ALARM, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code API_USAGE_STATE}.
   *   <li>Then EntityId return {@link ApiUsageStateId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'API_USAGE_STATE'; then EntityId return ApiUsageStateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenApiUsageState_thenEntityIdReturnApiUsageStateId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.API_USAGE_STATE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof ApiUsageStateId);
    assertEquals(EntityType.API_USAGE_STATE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ASSET_PROFILE}.
   *   <li>Then EntityId return {@link AssetProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ASSET_PROFILE'; then EntityId return AssetProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenAssetProfile_thenEntityIdReturnAssetProfileId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.ASSET_PROFILE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof AssetProfileId);
    assertEquals(EntityType.ASSET_PROFILE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ASSET}.
   *   <li>Then EntityId return {@link AssetId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ASSET'; then EntityId return AssetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenAsset_thenEntityIdReturnAssetId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.ASSET);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof AssetId);
    assertEquals(EntityType.ASSET, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code CUSTOMER}.
   *   <li>Then EntityId return {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'CUSTOMER'; then EntityId return CustomerId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenCustomer_thenEntityIdReturnCustomerId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.CUSTOMER);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof CustomerId);
    assertEquals(EntityType.CUSTOMER, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DASHBOARD}.
   *   <li>Then EntityId return {@link DashboardId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DASHBOARD'; then EntityId return DashboardId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenDashboard_thenEntityIdReturnDashboardId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.DASHBOARD);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof DashboardId);
    assertEquals(EntityType.DASHBOARD, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DEVICE_PROFILE}.
   *   <li>Then EntityId return {@link DeviceProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'DEVICE_PROFILE'; then EntityId return DeviceProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenDeviceProfile_thenEntityIdReturnDeviceProfileId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.DEVICE_PROFILE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof DeviceProfileId);
    assertEquals(EntityType.DEVICE_PROFILE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DEVICE}.
   *   <li>Then EntityId return {@link DeviceId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DEVICE'; then EntityId return DeviceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenDevice_thenEntityIdReturnDeviceId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.DEVICE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof DeviceId);
    assertEquals(EntityType.DEVICE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code DOMAIN}.
   *   <li>Then EntityId return {@link DomainId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'DOMAIN'; then EntityId return DomainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenDomain_thenEntityIdReturnDomainId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.DOMAIN);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof DomainId);
    assertEquals(EntityType.DOMAIN, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code EDGE}.
   *   <li>Then EntityId return {@link EdgeId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'EDGE'; then EntityId return EdgeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenEdge_thenEntityIdReturnEdgeId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.EDGE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof EdgeId);
    assertEquals(EntityType.EDGE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.
   *   <li>Then EntityId return {@link EntityViewId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'ENTITY_VIEW'; then EntityId return EntityViewId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenEntityView_thenEntityIdReturnEntityViewId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.ENTITY_VIEW);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof EntityViewId);
    assertEquals(EntityType.ENTITY_VIEW, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code MOBILE_APP}.
   *   <li>Then EntityId return {@link MobileAppId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'MOBILE_APP'; then EntityId return MobileAppId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenMobileApp_thenEntityIdReturnMobileAppId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.MOBILE_APP);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof MobileAppId);
    assertEquals(EntityType.MOBILE_APP, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_REQUEST}.
   *   <li>Then EntityId return {@link NotificationRequestId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'NOTIFICATION_REQUEST'; then EntityId return NotificationRequestId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationRequest_thenEntityIdReturnNotificationRequestId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.NOTIFICATION_REQUEST);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof NotificationRequestId);
    assertEquals(EntityType.NOTIFICATION_REQUEST, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_RULE}.
   *   <li>Then EntityId return {@link NotificationRuleId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'NOTIFICATION_RULE'; then EntityId return NotificationRuleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationRule_thenEntityIdReturnNotificationRuleId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.NOTIFICATION_RULE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof NotificationRuleId);
    assertEquals(EntityType.NOTIFICATION_RULE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_TARGET}.
   *   <li>Then EntityId return {@link NotificationTargetId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'NOTIFICATION_TARGET'; then EntityId return NotificationTargetId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationTarget_thenEntityIdReturnNotificationTargetId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.NOTIFICATION_TARGET);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof NotificationTargetId);
    assertEquals(EntityType.NOTIFICATION_TARGET, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION_TEMPLATE}.
   *   <li>Then EntityId return {@link NotificationTemplateId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'NOTIFICATION_TEMPLATE'; then EntityId return NotificationTemplateId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenNotificationTemplate_thenEntityIdReturnNotificationTemplateId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.NOTIFICATION_TEMPLATE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof NotificationTemplateId);
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code NOTIFICATION}.
   *   <li>Then EntityId return {@link NotificationId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'NOTIFICATION'; then EntityId return NotificationId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenNotification_thenEntityIdReturnNotificationId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.NOTIFICATION);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof NotificationId);
    assertEquals(EntityType.NOTIFICATION, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code OAUTH2_CLIENT}.
   *   <li>Then EntityId return {@link OAuth2ClientId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'OAUTH2_CLIENT'; then EntityId return OAuth2ClientId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenOauth2Client_thenEntityIdReturnOAuth2ClientId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.OAUTH2_CLIENT);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof OAuth2ClientId);
    assertEquals(EntityType.OAUTH2_CLIENT, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code OTA_PACKAGE}.
   *   <li>Then EntityId return {@link OtaPackageId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'OTA_PACKAGE'; then EntityId return OtaPackageId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenOtaPackage_thenEntityIdReturnOtaPackageId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.OTA_PACKAGE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof OtaPackageId);
    assertEquals(EntityType.OTA_PACKAGE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code QUEUE_STATS}.
   *   <li>Then EntityId return {@link QueueStatsId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'QUEUE_STATS'; then EntityId return QueueStatsId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenQueueStats_thenEntityIdReturnQueueStatsId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.QUEUE_STATS);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof QueueStatsId);
    assertEquals(EntityType.QUEUE_STATS, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code QUEUE}.
   *   <li>Then EntityId return {@link QueueId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'QUEUE'; then EntityId return QueueId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenQueue_thenEntityIdReturnQueueId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.QUEUE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof QueueId);
    assertEquals(EntityType.QUEUE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code RPC}.
   *   <li>Then EntityId return {@link RpcId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RPC'; then EntityId return RpcId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenRpc_thenEntityIdReturnRpcId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.RPC);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof RpcId);
    assertEquals(EntityType.RPC, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code RULE_CHAIN}.
   *   <li>Then EntityId return {@link RuleChainId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RULE_CHAIN'; then EntityId return RuleChainId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenRuleChain_thenEntityIdReturnRuleChainId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.RULE_CHAIN);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof RuleChainId);
    assertEquals(EntityType.RULE_CHAIN, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code RULE_NODE}.
   *   <li>Then EntityId return {@link RuleNodeId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'RULE_NODE'; then EntityId return RuleNodeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenRuleNode_thenEntityIdReturnRuleNodeId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.RULE_NODE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof RuleNodeId);
    assertEquals(EntityType.RULE_NODE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TB_RESOURCE}.
   *   <li>Then EntityId return {@link TbResourceId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'TB_RESOURCE'; then EntityId return TbResourceId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenTbResource_thenEntityIdReturnTbResourceId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.TB_RESOURCE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof TbResourceId);
    assertEquals(EntityType.TB_RESOURCE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TENANT_PROFILE}.
   *   <li>Then EntityId return {@link TenantProfileId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'TENANT_PROFILE'; then EntityId return TenantProfileId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenTenantProfile_thenEntityIdReturnTenantProfileId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.TENANT_PROFILE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof TenantProfileId);
    assertEquals(EntityType.TENANT_PROFILE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then EntityId return {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'TENANT'; then EntityId return TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenTenant_thenEntityIdReturnTenantId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.TENANT);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertFalse(((TenantId) entityId).isSysTenantId());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code USER}.
   *   <li>Then EntityId return {@link UserId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'USER'; then EntityId return UserId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenUser_thenEntityIdReturnUserId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.USER);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof UserId);
    assertEquals(EntityType.USER, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code WIDGET_TYPE}.
   *   <li>Then EntityId return {@link WidgetTypeId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName("Test toInfo(EntityType); when 'WIDGET_TYPE'; then EntityId return WidgetTypeId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenWidgetType_thenEntityIdReturnWidgetTypeId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.WIDGET_TYPE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof WidgetTypeId);
    assertEquals(EntityType.WIDGET_TYPE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#toInfo(EntityType)}.
   *
   * <ul>
   *   <li>When {@code WIDGETS_BUNDLE}.
   *   <li>Then EntityId return {@link WidgetsBundleId}.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#toInfo(EntityType)}
   */
  @Test
  @DisplayName(
      "Test toInfo(EntityType); when 'WIDGETS_BUNDLE'; then EntityId return WidgetsBundleId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EventInfo StatisticsEvent.toInfo(EntityType)"})
  void testToInfo_whenWidgetsBundle_thenEntityIdReturnWidgetsBundleId() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act
    EventInfo actualToInfoResult =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build()
            .toInfo(EntityType.WIDGETS_BUNDLE);

    // Assert
    JsonNode body = actualToInfoResult.getBody();
    assertTrue(body instanceof ObjectNode);
    assertTrue(body.traverse() instanceof TreeTraversingParser);
    EntityId entityId = actualToInfoResult.getEntityId();
    assertTrue(entityId instanceof WidgetsBundleId);
    assertEquals(EntityType.WIDGETS_BUNDLE, entityId.getEntityType());
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}, and {@link StatisticsEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatisticsEvent#equals(Object)}
   *   <li>{@link StatisticsEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);
    StatisticsEvent statisticsEvent =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    StatisticsEventBuilder builderResult2 = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult2 =
        builderResult2
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);
    StatisticsEvent statisticsEvent2 =
        errorsOccurredResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    // Act and Assert
    assertEquals(statisticsEvent, statisticsEvent2);
    assertEquals(statisticsEvent.hashCode(), statisticsEvent2.hashCode());
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}, and {@link StatisticsEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatisticsEvent#equals(Object)}
   *   <li>{@link StatisticsEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);
    StatisticsEvent statisticsEvent =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    // Act and Assert
    assertEquals(statisticsEvent, statisticsEvent);
    int expectedHashCodeResult = statisticsEvent.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEvent.hashCode());
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StatisticsEventBuilder errorsOccurredResult =
        StatisticsEvent.builder().entityId(EntityId.NULL_UUID).errorsOccurred(-1L);
    StatisticsEvent statisticsEvent =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult2 =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act and Assert
    assertNotEquals(
        statisticsEvent,
        errorsOccurredResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build());
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(1L);
    StatisticsEvent statisticsEvent =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    StatisticsEventBuilder builderResult2 = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult2 =
        builderResult2
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act and Assert
    assertNotEquals(
        statisticsEvent,
        errorsOccurredResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build());
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);
    StatisticsEvent statisticsEvent =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(3L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    StatisticsEventBuilder builderResult2 = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult2 =
        builderResult2
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act and Assert
    assertNotEquals(
        statisticsEvent,
        errorsOccurredResult2
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build());
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act and Assert
    assertNotEquals(
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build(),
        null);
  }

  /**
   * Test {@link StatisticsEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link StatisticsEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean StatisticsEvent.equals(Object)", "int StatisticsEvent.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);

    // Act and Assert
    assertNotEquals(
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build(),
        "Different type to StatisticsEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link StatisticsEvent#toString()}
   *   <li>{@link StatisticsEvent#getErrorsOccurred()}
   *   <li>{@link StatisticsEvent#getMessagesProcessed()}
   *   <li>{@link StatisticsEvent#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long StatisticsEvent.getErrorsOccurred()",
    "long StatisticsEvent.getMessagesProcessed()",
    "EventType StatisticsEvent.getType()",
    "String StatisticsEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    StatisticsEventBuilder builderResult = StatisticsEvent.builder();

    StatisticsEventBuilder errorsOccurredResult =
        builderResult
            .entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .errorsOccurred(-1L);
    StatisticsEvent statisticsEvent =
        errorsOccurredResult
            .id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .messagesProcessed(1L)
            .serviceId("42")
            .tenantId(TenantId.SYS_TENANT_ID)
            .ts(1L)
            .build();

    // Act
    String actualToStringResult = statisticsEvent.toString();
    long actualErrorsOccurred = statisticsEvent.getErrorsOccurred();
    long actualMessagesProcessed = statisticsEvent.getMessagesProcessed();

    // Assert
    assertEquals("StatisticsEvent(messagesProcessed=1, errorsOccurred=-1)", actualToStringResult);
    assertEquals(-1L, actualErrorsOccurred);
    assertEquals(1L, actualMessagesProcessed);
    assertEquals(EventType.STATS, statisticsEvent.getType());
  }
}
