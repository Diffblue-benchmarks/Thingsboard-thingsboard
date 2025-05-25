package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.template.DeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.EmailDeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplateConfig;
import org.thingsboard.server.common.data.notification.template.TemplatableValue;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportResult;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;
import org.thingsboard.server.service.sync.ie.importing.impl.BaseEntityImportService.IdProvider;
import org.thingsboard.server.service.sync.vc.data.EntitiesImportCtx;

@ExtendWith(MockitoExtension.class)
class NotificationTemplateImportServiceDiffblueTest {
  @InjectMocks
  private NotificationTemplateImportService notificationTemplateImportService;

  /**
   * Test {@link NotificationTemplateImportService#setOwner(TenantId, NotificationTemplate, IdProvider)}.
   * <p>
   * Method under test: {@link NotificationTemplateImportService#setOwner(TenantId, NotificationTemplate, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, NotificationTemplate, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTemplateImportService.setOwner(TenantId, NotificationTemplate, IdProvider)"})
  void testSetOwner() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    notificationTemplateImportService.setOwner(tenantId, notificationTemplate,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    assertSame(tenantId, notificationTemplate.getTenantId());
  }

  /**
   * Test {@link NotificationTemplateImportService#setOwner(TenantId, NotificationTemplate, IdProvider)}.
   * <ul>
   *   <li>When {@link NotificationTemplate} {@link NotificationTemplate#setTenantId(TenantId)} does nothing.</li>
   *   <li>Then calls {@link NotificationTemplate#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateImportService#setOwner(TenantId, NotificationTemplate, IdProvider)}
   */
  @Test
  @DisplayName("Test setOwner(TenantId, NotificationTemplate, IdProvider); when NotificationTemplate setTenantId(TenantId) does nothing; then calls setTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationTemplateImportService.setOwner(TenantId, NotificationTemplate, IdProvider)"})
  void testSetOwner_whenNotificationTemplateSetTenantIdDoesNothing_thenCallsSetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationTemplate notificationTemplate = mock(NotificationTemplate.class);
    doNothing().when(notificationTemplate).setTenantId(Mockito.<TenantId>any());
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    // Act
    notificationTemplateImportService.setOwner(tenantId, notificationTemplate,
        (IdProvider) assetImportService.new IdProvider(ctx, new EntityImportResult()));

    // Assert
    verify(notificationTemplate).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link NotificationTemplateImportService#prepare(EntitiesImportCtx, NotificationTemplate, NotificationTemplate, EntityExportData, IdProvider)}.
   * <p>
   * Method under test: {@link NotificationTemplateImportService#prepare(EntitiesImportCtx, NotificationTemplate, NotificationTemplate, EntityExportData, IdProvider)}
   */
  @Test
  @DisplayName("Test prepare(EntitiesImportCtx, NotificationTemplate, NotificationTemplate, EntityExportData, IdProvider)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "NotificationTemplate NotificationTemplateImportService.prepare(EntitiesImportCtx, NotificationTemplate, NotificationTemplate, EntityExportData, IdProvider)"})
  void testPrepare() {
    // Arrange
    UUID requestId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx = new EntitiesImportCtx(requestId, new User(), "42");

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    NotificationTemplate oldEntity = new NotificationTemplate();
    EntityExportData<NotificationTemplate> exportData = new EntityExportData<>();
    AssetImportService assetImportService = new AssetImportService(new BaseAssetService());
    UUID requestId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntitiesImportCtx ctx2 = new EntitiesImportCtx(requestId2, new User(), "42");

    // Act and Assert
    assertSame(notificationTemplate, notificationTemplateImportService.prepare(ctx, notificationTemplate, oldEntity,
        exportData, (IdProvider) assetImportService.new IdProvider(ctx2, new EntityImportResult())));
  }

  /**
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)} with {@code NotificationTemplate}.
   * <p>
   * Method under test: {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateImportService.deepCopy(NotificationTemplate)"})
  void testDeepCopyWithNotificationTemplate() {
    // Arrange
    NotificationTemplate notificationTemplate = mock(NotificationTemplate.class);
    when(notificationTemplate.getCreatedTime()).thenReturn(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    NotificationTemplateId notificationTemplateId = new NotificationTemplateId(id);
    when(notificationTemplate.getId()).thenReturn(notificationTemplateId);

    // Act
    NotificationTemplate actualDeepCopyResult = notificationTemplateImportService.deepCopy(notificationTemplate);

    // Assert
    verify(notificationTemplate).getCreatedTime();
    verify(notificationTemplate).getId();
    UUID uuidId = actualDeepCopyResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertNull(actualDeepCopyResult.getConfiguration());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertSame(notificationTemplateId, actualDeepCopyResult.getId());
    assertSame(id, uuidId);
  }

  /**
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)} with {@code NotificationTemplate}.
   * <p>
   * Method under test: {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateImportService.deepCopy(NotificationTemplate)"})
  void testDeepCopyWithNotificationTemplate2() {
    // Arrange
    NotificationTemplateConfig configuration = mock(NotificationTemplateConfig.class);
    NotificationTemplateConfig notificationTemplateConfig = new NotificationTemplateConfig();
    when(configuration.copy()).thenReturn(notificationTemplateConfig);

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(configuration);

    // Act
    NotificationTemplate actualDeepCopyResult = notificationTemplateImportService.deepCopy(notificationTemplate);

    // Assert
    verify(configuration).copy();
    NotificationTemplateConfig configuration2 = actualDeepCopyResult.getConfiguration();
    assertNull(configuration2.getDeliveryMethodsTemplates());
    assertNull(actualDeepCopyResult.getUuidId());
    assertNull(actualDeepCopyResult.getId());
    assertEquals(0L, actualDeepCopyResult.getCreatedTime());
    assertSame(notificationTemplateConfig, configuration2);
  }

  /**
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)} with {@code NotificationTemplate}.
   * <p>
   * Method under test: {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateImportService.deepCopy(NotificationTemplate)"})
  void testDeepCopyWithNotificationTemplate3() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig configuration = new NotificationTemplateConfig();
    configuration.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(configuration);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = notificationTemplateImportService
        .deepCopy(notificationTemplate)
        .getConfiguration()
        .getDeliveryMethodsTemplates();
    assertEquals(1, deliveryMethodsTemplates2.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates2.get(NotificationDeliveryMethod.WEB);
    assertTrue(getResult instanceof EmailDeliveryMethodNotificationTemplate);
    assertNull(getResult.getBody());
    assertNull(((EmailDeliveryMethodNotificationTemplate) getResult).getSubject());
    List<TemplatableValue> templatableValues = getResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, getResult.getMethod());
    assertFalse(getResult.isEnabled());
  }

  /**
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)} with {@code NotificationTemplate}.
   * <p>
   * Method under test: {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateImportService.deepCopy(NotificationTemplate)"})
  void testDeepCopyWithNotificationTemplate4() {
    // Arrange
    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates = new HashMap<>();
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.EMAIL, new EmailDeliveryMethodNotificationTemplate());
    deliveryMethodsTemplates.put(NotificationDeliveryMethod.WEB, new EmailDeliveryMethodNotificationTemplate());

    NotificationTemplateConfig configuration = new NotificationTemplateConfig();
    configuration.setDeliveryMethodsTemplates(deliveryMethodsTemplates);

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(configuration);

    // Act and Assert
    Map<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> deliveryMethodsTemplates2 = notificationTemplateImportService
        .deepCopy(notificationTemplate)
        .getConfiguration()
        .getDeliveryMethodsTemplates();
    assertEquals(2, deliveryMethodsTemplates2.size());
    DeliveryMethodNotificationTemplate getResult = deliveryMethodsTemplates2.get(NotificationDeliveryMethod.EMAIL);
    assertTrue(getResult instanceof EmailDeliveryMethodNotificationTemplate);
    assertNull(getResult.getBody());
    assertNull(((EmailDeliveryMethodNotificationTemplate) getResult).getSubject());
    List<TemplatableValue> templatableValues = getResult.getTemplatableValues();
    assertEquals(2, templatableValues.size());
    assertNull(templatableValues.get(0).get());
    assertNull(templatableValues.get(1).get());
    assertEquals(NotificationDeliveryMethod.EMAIL, getResult.getMethod());
    assertFalse(getResult.isEnabled());
    assertTrue(deliveryMethodsTemplates2.containsKey(NotificationDeliveryMethod.WEB));
  }

  /**
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)} with {@code NotificationTemplate}.
   * <ul>
   *   <li>Then return {@link NotificationTemplate#NotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'; then return NotificationTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateImportService.deepCopy(NotificationTemplate)"})
  void testDeepCopyWithNotificationTemplate_thenReturnNotificationTemplate() {
    // Arrange
    NotificationTemplateConfig configuration = new NotificationTemplateConfig();
    configuration.setDeliveryMethodsTemplates(new HashMap<>());

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(configuration);

    // Act and Assert
    assertEquals(notificationTemplate, notificationTemplateImportService.deepCopy(notificationTemplate));
  }

  /**
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)} with {@code NotificationTemplate}.
   * <ul>
   *   <li>When {@link NotificationTemplate#NotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'; when NotificationTemplate()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTemplate NotificationTemplateImportService.deepCopy(NotificationTemplate)"})
  void testDeepCopyWithNotificationTemplate_whenNotificationTemplate() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();

    // Act and Assert
    assertEquals(notificationTemplate, notificationTemplateImportService.deepCopy(notificationTemplate));
  }

  /**
   * Test {@link NotificationTemplateImportService#getEntityType()}.
   * <p>
   * Method under test: {@link NotificationTemplateImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType NotificationTemplateImportService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));

    // Act and Assert
    assertEquals(EntityType.NOTIFICATION_TEMPLATE,
        (new NotificationTemplateImportService(new DefaultNotificationTemplateService(notificationTemplateDao,
            new JpaNotificationRequestDao(mock(NotificationRequestRepository.class))))).getEntityType());
  }
}
