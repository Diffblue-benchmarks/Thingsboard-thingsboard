package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.DefaultNotificationRuleRecipientsConfig;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class NotificationRuleImportServiceDiffblueTest {
  @InjectMocks
  private NotificationRuleImportService notificationRuleImportService;

  /**
   * Test {@link NotificationRuleImportService#setOwner(TenantId, NotificationRule, IdProvider)}.
   * <p>
   * Method under test: {@link NotificationRuleImportService#setOwner(TenantId, NotificationRule, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, NotificationRule, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRuleImportService.setOwner(TenantId, NotificationRule, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRule notificationRule = new NotificationRule();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    notificationRuleImportService.setOwner(tenantId, notificationRule,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, notificationRule.getTenantId());
  }

  /**
   * Test {@link NotificationRuleImportService#setOwner(TenantId, NotificationRule, IdProvider)}.
   * <ul>
   *   <li>When {@link NotificationRule} {@link NotificationRule#setTenantId(TenantId)} does nothing.</li>
   *   <li>Then calls {@link NotificationRule#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleImportService#setOwner(TenantId, NotificationRule, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, NotificationRule, IdProvider); when NotificationRule setTenantId(TenantId) does nothing; then calls setTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRuleImportService.setOwner(TenantId, NotificationRule, IdProvider)"})
  void testSetOwner_whenNotificationRuleSetTenantIdDoesNothing_thenCallsSetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRule notificationRule = mock(NotificationRule.class);
    doNothing().when(notificationRule).setTenantId(Mockito.<TenantId>any());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    notificationRuleImportService.setOwner(tenantId, notificationRule,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(notificationRule).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link NotificationRuleImportService#prepare(EntitiesImportCtx, NotificationRule, NotificationRule, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then return {@link NotificationRule}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleImportService#prepare(EntitiesImportCtx, NotificationRule, NotificationRule, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, NotificationRule, NotificationRule, EntityExportData, IdProvider); then return NotificationRule")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "NotificationRule NotificationRuleImportService.prepare(EntitiesImportCtx, NotificationRule, NotificationRule, EntityExportData, IdProvider)"})
  void testPrepare_thenReturnNotificationRule() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    NotificationRuleTriggerConfig notificationRuleTriggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(notificationRuleTriggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);

    DefaultNotificationRuleRecipientsConfig defaultNotificationRuleRecipientsConfig = new DefaultNotificationRuleRecipientsConfig();
    defaultNotificationRuleRecipientsConfig.setTargets(new ArrayList<>());
    NotificationRule notificationRule = mock(NotificationRule.class);
    when(notificationRule.getRecipientsConfig()).thenReturn(defaultNotificationRuleRecipientsConfig);
    when(notificationRule.getTemplateId()).thenReturn(null);
    when(notificationRule.getTriggerConfig()).thenReturn(notificationRuleTriggerConfig);
    doNothing().when(notificationRule).setTemplateId(Mockito.<NotificationTemplateId>any());
    doNothing().when(notificationRule).setTriggerConfig(Mockito.<NotificationRuleTriggerConfig>any());
    notificationRule.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));
    notificationRule.setTemplateId(mock(NotificationTemplateId.class));
    NotificationRule oldNotificationRule = new NotificationRule();
    EntityExportData<NotificationRule> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act
    NotificationRule actualPrepareResult = notificationRuleImportService.prepare(ctx, notificationRule,
        oldNotificationRule, exportData,
        (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult()));

    // Assert
    verify(notificationRule).getRecipientsConfig();
    verify(notificationRule).getTemplateId();
    verify(notificationRule).getTriggerConfig();
    verify(notificationRule, atLeast(1)).setTemplateId(Mockito.<NotificationTemplateId>any());
    verify(notificationRule).setTriggerConfig(isA(NotificationRuleTriggerConfig.class));
    verify(notificationRuleTriggerConfig).getTriggerType();
    assertSame(notificationRule, actualPrepareResult);
  }

  /**
   * Test {@link NotificationRuleImportService#prepare(EntitiesImportCtx, NotificationRule, NotificationRule, EntityExportData, IdProvider)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleImportService#prepare(EntitiesImportCtx, NotificationRule, NotificationRule, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, NotificationRule, NotificationRule, EntityExportData, IdProvider); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "NotificationRule NotificationRuleImportService.prepare(EntitiesImportCtx, NotificationRule, NotificationRule, EntityExportData, IdProvider)"})
  void testPrepare_thenThrowIllegalArgumentException() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    NotificationRuleTriggerConfig notificationRuleTriggerConfig = mock(NotificationRuleTriggerConfig.class);
    when(notificationRuleTriggerConfig.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    NotificationRule notificationRule = mock(NotificationRule.class);
    when(notificationRule.getRecipientsConfig()).thenThrow(new IllegalArgumentException("foo"));
    when(notificationRule.getTemplateId()).thenReturn(null);
    when(notificationRule.getTriggerConfig()).thenReturn(notificationRuleTriggerConfig);
    doNothing().when(notificationRule).setTemplateId(Mockito.<NotificationTemplateId>any());
    doNothing().when(notificationRule).setTriggerConfig(Mockito.<NotificationRuleTriggerConfig>any());
    notificationRule.setTriggerConfig(mock(NotificationRuleTriggerConfig.class));
    notificationRule.setTemplateId(mock(NotificationTemplateId.class));
    NotificationRule oldNotificationRule = new NotificationRule();
    EntityExportData<NotificationRule> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> notificationRuleImportService.prepare(ctx, notificationRule, oldNotificationRule, exportData,
            (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
    verify(notificationRule).getRecipientsConfig();
    verify(notificationRule).getTemplateId();
    verify(notificationRule).getTriggerConfig();
    verify(notificationRule, atLeast(1)).setTemplateId(Mockito.<NotificationTemplateId>any());
    verify(notificationRule).setTriggerConfig(isA(NotificationRuleTriggerConfig.class));
    verify(notificationRuleTriggerConfig).getTriggerType();
  }

  /**
   * Test {@link NotificationRuleImportService#deepCopy(NotificationRule)} with {@code NotificationRule}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleImportService#deepCopy(NotificationRule)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationRule) with 'NotificationRule'; given one; then return Name is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRule NotificationRuleImportService.deepCopy(NotificationRule)"})
  void testDeepCopyWithNotificationRule_givenOne_thenReturnNameIsNull() {
    // Arrange
    NotificationRule notificationRule = mock(NotificationRule.class);
    when(notificationRule.getCreatedTime()).thenReturn(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    NotificationRuleId notificationRuleId = new NotificationRuleId(id);
    when(notificationRule.getId()).thenReturn(notificationRuleId);

    // Act
    NotificationRule actualDeepCopyResult = notificationRuleImportService.deepCopy(notificationRule);

    // Assert
    verify(notificationRule).getCreatedTime();
    verify(notificationRule).getId();
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getTemplateId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertNull(actualDeepCopyResult.getAdditionalConfig());
    assertNull(actualDeepCopyResult.getRecipientsConfig());
    assertNull(actualDeepCopyResult.getTriggerConfig());
    assertNull(actualDeepCopyResult.getTriggerType());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertFalse(actualDeepCopyResult.isEnabled());
    assertSame(notificationRuleId, actualDeepCopyResult.getId());
    assertSame(id, actualDeepCopyResult.getUuidId());
  }

  /**
   * Test {@link NotificationRuleImportService#deepCopy(NotificationRule)} with {@code NotificationRule}.
   * <ul>
   *   <li>When {@link NotificationRule#NotificationRule()}.</li>
   *   <li>Then return {@link NotificationRule#NotificationRule()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleImportService#deepCopy(NotificationRule)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationRule) with 'NotificationRule'; when NotificationRule(); then return NotificationRule()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationRule NotificationRuleImportService.deepCopy(NotificationRule)"})
  void testDeepCopyWithNotificationRule_whenNotificationRule_thenReturnNotificationRule() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();

    // Act and Assert
    assertEquals(notificationRule, notificationRuleImportService.deepCopy(notificationRule));
  }

  /**
   * Test {@link NotificationRuleImportService#getEntityType()}.
   * <p>
   * Method under test: {@link NotificationRuleImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType NotificationRuleImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.NOTIFICATION_RULE,
        (new NotificationRuleImportService(
            new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class)))))
            .getEntityType());
  }
}
