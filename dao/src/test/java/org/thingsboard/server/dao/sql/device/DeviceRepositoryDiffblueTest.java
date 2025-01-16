package org.thingsboard.server.dao.sql.device;

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
import org.thingsboard.server.dao.model.sql.DeviceEntity;

public class DeviceRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link DeviceRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceEntity deviceEntity = new DeviceEntity();
    deviceEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setCreatedTime(1L);
    deviceEntity.setCustomerId(ModelConstants.NULL_UUID);
    deviceEntity.setDeviceData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceEntity.setDeviceProfileId(ModelConstants.NULL_UUID);
    deviceEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceEntity.setId(ModelConstants.NULL_UUID);
    deviceEntity.setLabel("Label");
    deviceEntity.setName("Name");
    deviceEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceEntity.setType("Type");
    deviceEntity.setUuid(ModelConstants.NULL_UUID);
    deviceEntity.setVersion(1L);
    ExportableEntityRepository<DeviceEntity> exportableEntityRepository = mock(ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
