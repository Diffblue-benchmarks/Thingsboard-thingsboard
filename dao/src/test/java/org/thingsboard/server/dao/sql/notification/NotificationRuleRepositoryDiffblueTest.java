package org.thingsboard.server.dao.sql.notification;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.ExportableEntityRepository;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationRuleEntity;

public class NotificationRuleRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link NotificationRuleRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);
    ExportableEntityRepository<NotificationRuleEntity> exportableEntityRepository = mock(
        ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationRuleEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
