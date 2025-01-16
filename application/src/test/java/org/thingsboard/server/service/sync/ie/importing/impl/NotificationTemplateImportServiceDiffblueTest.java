package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.template.DeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.EmailDeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplateConfig;
import org.thingsboard.server.common.data.notification.template.TemplatableValue;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;

class NotificationTemplateImportServiceDiffblueTest {
  /**
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   * with {@code NotificationTemplate}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'")
  void testDeepCopyWithNotificationTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    NotificationTemplateImportService notificationTemplateImportService = new NotificationTemplateImportService(
        new DefaultNotificationTemplateService(notificationTemplateDao,
            new JpaNotificationRequestDao(mock(NotificationRequestRepository.class))));
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
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   * with {@code NotificationTemplate}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'")
  void testDeepCopyWithNotificationTemplate2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    NotificationTemplateImportService notificationTemplateImportService = new NotificationTemplateImportService(
        new DefaultNotificationTemplateService(notificationTemplateDao,
            new JpaNotificationRequestDao(mock(NotificationRequestRepository.class))));

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
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   * with {@code NotificationTemplate}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'")
  void testDeepCopyWithNotificationTemplate3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    NotificationTemplateImportService notificationTemplateImportService = new NotificationTemplateImportService(
        new DefaultNotificationTemplateService(notificationTemplateDao,
            new JpaNotificationRequestDao(mock(NotificationRequestRepository.class))));

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
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   * with {@code NotificationTemplate}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Configuration is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'; given one; then return Configuration is 'null'")
  void testDeepCopyWithNotificationTemplate_givenOne_thenReturnConfigurationIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    NotificationTemplateImportService notificationTemplateImportService = new NotificationTemplateImportService(
        new DefaultNotificationTemplateService(notificationTemplateDao,
            new JpaNotificationRequestDao(mock(NotificationRequestRepository.class))));
    NotificationTemplate notificationTemplate = mock(NotificationTemplate.class);
    when(notificationTemplate.getCreatedTime()).thenReturn(1L);
    UUID id = UUID.randomUUID();
    NotificationTemplateId notificationTemplateId = new NotificationTemplateId(id);
    when(notificationTemplate.getId()).thenReturn(notificationTemplateId);

    // Act
    NotificationTemplate actualDeepCopyResult = notificationTemplateImportService.deepCopy(notificationTemplate);

    // Assert
    verify(notificationTemplate).getCreatedTime();
    verify(notificationTemplate).getId();
    assertNull(actualDeepCopyResult.getConfiguration());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertSame(notificationTemplateId, actualDeepCopyResult.getId());
    assertSame(id, actualDeepCopyResult.getUuidId());
  }

  /**
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   * with {@code NotificationTemplate}.
   * <ul>
   *   <li>Then return {@link NotificationTemplate#NotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'; then return NotificationTemplate()")
  void testDeepCopyWithNotificationTemplate_thenReturnNotificationTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    NotificationTemplateImportService notificationTemplateImportService = new NotificationTemplateImportService(
        new DefaultNotificationTemplateService(notificationTemplateDao,
            new JpaNotificationRequestDao(mock(NotificationRequestRepository.class))));

    NotificationTemplateConfig configuration = new NotificationTemplateConfig();
    configuration.setDeliveryMethodsTemplates(new HashMap<>());

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(configuration);

    // Act and Assert
    assertEquals(notificationTemplate, notificationTemplateImportService.deepCopy(notificationTemplate));
  }

  /**
   * Test {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   * with {@code NotificationTemplate}.
   * <ul>
   *   <li>When {@link NotificationTemplate#NotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateImportService#deepCopy(NotificationTemplate)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTemplate) with 'NotificationTemplate'; when NotificationTemplate()")
  void testDeepCopyWithNotificationTemplate_whenNotificationTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    NotificationTemplateImportService notificationTemplateImportService = new NotificationTemplateImportService(
        new DefaultNotificationTemplateService(notificationTemplateDao,
            new JpaNotificationRequestDao(mock(NotificationRequestRepository.class))));
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
