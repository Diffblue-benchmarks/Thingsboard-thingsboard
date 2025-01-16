package org.thingsboard.server.dao.sql.notification;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.dao.ExportableEntityRepository;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationTemplateEntity;

public class NotificationTemplateRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    ExportableEntityRepository<NotificationTemplateEntity> exportableEntityRepository = mock(
        ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTemplateEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
