package org.thingsboard.server.dao.sql.notification;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.dao.ExportableEntityRepository;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationTargetEntity;

public class NotificationTargetRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link NotificationTargetRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);
    ExportableEntityRepository<NotificationTargetEntity> exportableEntityRepository = mock(
        ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(notificationTargetEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
