package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;

class NotificationRuleImportServiceDiffblueTest {
  /**
   * Test {@link NotificationRuleImportService#deepCopy(NotificationRule)} with
   * {@code NotificationRule}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleImportService#deepCopy(NotificationRule)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationRule) with 'NotificationRule'; given one; then return Name is 'null'")
  void testDeepCopyWithNotificationRule_givenOne_thenReturnNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRuleImportService notificationRuleImportService = new NotificationRuleImportService(
        new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class))));
    NotificationRule notificationRule = mock(NotificationRule.class);
    when(notificationRule.getCreatedTime()).thenReturn(1L);
    UUID id = UUID.randomUUID();
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
   * Test {@link NotificationRuleImportService#deepCopy(NotificationRule)} with
   * {@code NotificationRule}.
   * <ul>
   *   <li>When {@link NotificationRule#NotificationRule()}.</li>
   *   <li>Then return {@link NotificationRule#NotificationRule()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleImportService#deepCopy(NotificationRule)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationRule) with 'NotificationRule'; when NotificationRule(); then return NotificationRule()")
  void testDeepCopyWithNotificationRule_whenNotificationRule_thenReturnNotificationRule() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRuleImportService notificationRuleImportService = new NotificationRuleImportService(
        new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class))));
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
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.NOTIFICATION_RULE,
        (new NotificationRuleImportService(
            new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class)))))
            .getEntityType());
  }
}
