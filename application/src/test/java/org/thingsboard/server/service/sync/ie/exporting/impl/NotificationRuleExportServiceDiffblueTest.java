package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.DefaultNotificationRuleRecipientsConfig;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.trigger.config.DeviceActivityNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.notification.rule.trigger.config.RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.service.sync.vc.data.CommitGitRequest;
import org.thingsboard.server.service.sync.vc.data.ComplexEntitiesExportCtx;
import org.thingsboard.server.service.sync.vc.data.EntitiesExportCtx;

class NotificationRuleExportServiceDiffblueTest {
  /**
   * Test
   * {@link NotificationRuleExportService#setRelatedEntities(EntitiesExportCtx, NotificationRule, EntityExportData)}
   * with {@code EntitiesExportCtx}, {@code NotificationRule},
   * {@code EntityExportData}.
   * <p>
   * Method under test:
   * {@link NotificationRuleExportService#setRelatedEntities(EntitiesExportCtx, NotificationRule, EntityExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, NotificationRule, EntityExportData) with 'EntitiesExportCtx', 'NotificationRule', 'EntityExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxNotificationRuleEntityExportData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRuleExportService<EntityId, ExportableEntity<EntityId>, EntityExportData<ExportableEntity<EntityId>>> notificationRuleExportService = new NotificationRuleExportService<>();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(null,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig triggerConfig = new RuleEngineComponentLifecycleEventNotificationRuleTriggerConfig();
    triggerConfig.setRuleChains(new HashSet<>());

    DefaultNotificationRuleRecipientsConfig recipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    recipientsConfig.setTargets(new ArrayList<>());
    recipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(triggerConfig);
    notificationRule.setRecipientsConfig(recipientsConfig);

    // Act
    notificationRuleExportService.setRelatedEntities(ctx, notificationRule, new EntityExportData<>());

    // Assert
    verify(request).getEntityTypes();
  }

  /**
   * Test
   * {@link NotificationRuleExportService#setRelatedEntities(EntitiesExportCtx, NotificationRule, EntityExportData)}
   * with {@code EntitiesExportCtx}, {@code NotificationRule},
   * {@code EntityExportData}.
   * <p>
   * Method under test:
   * {@link NotificationRuleExportService#setRelatedEntities(EntitiesExportCtx, NotificationRule, EntityExportData)}
   */
  @Test
  @DisplayName("Test setRelatedEntities(EntitiesExportCtx, NotificationRule, EntityExportData) with 'EntitiesExportCtx', 'NotificationRule', 'EntityExportData'")
  void testSetRelatedEntitiesWithEntitiesExportCtxNotificationRuleEntityExportData2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRuleExportService<EntityId, ExportableEntity<EntityId>, EntityExportData<ExportableEntity<EntityId>>> notificationRuleExportService = new NotificationRuleExportService<>();
    ComplexVersionCreateRequest request = mock(ComplexVersionCreateRequest.class);
    when(request.getEntityTypes()).thenReturn(new HashMap<>());
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ComplexEntitiesExportCtx ctx = new ComplexEntitiesExportCtx(null,
        new CommitGitRequest(tenantId, new ComplexVersionCreateRequest()), request);

    DeviceActivityNotificationRuleTriggerConfig triggerConfig = new DeviceActivityNotificationRuleTriggerConfig();
    triggerConfig.setDevices(null);
    triggerConfig.setDeviceProfiles(new HashSet<>());

    DefaultNotificationRuleRecipientsConfig recipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    recipientsConfig.setTargets(new ArrayList<>());
    recipientsConfig.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);

    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTriggerConfig(triggerConfig);
    notificationRule.setRecipientsConfig(recipientsConfig);

    // Act
    notificationRuleExportService.setRelatedEntities(ctx, notificationRule, new EntityExportData<>());

    // Assert
    verify(request).getEntityTypes();
  }

  /**
   * Test {@link NotificationRuleExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test:
   * {@link NotificationRuleExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRuleExportService<EntityId, ExportableEntity<EntityId>, EntityExportData<ExportableEntity<EntityId>>> notificationRuleExportService = new NotificationRuleExportService<>();

    // Act
    Set<EntityType> actualSupportedEntityTypes = notificationRuleExportService.getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.NOTIFICATION_RULE));
  }
}
