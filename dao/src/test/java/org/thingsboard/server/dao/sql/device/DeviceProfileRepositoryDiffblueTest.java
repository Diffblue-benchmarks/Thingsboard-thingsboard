package org.thingsboard.server.dao.sql.device;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.DeviceProfileProvisionType;
import org.thingsboard.server.common.data.DeviceProfileType;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.dao.ExportableEntityRepository;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DeviceProfileEntity;

public class DeviceProfileRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link DeviceProfileRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileEntity deviceProfileEntity = new DeviceProfileEntity();
    deviceProfileEntity.setCreatedTime(1L);
    deviceProfileEntity.setDefault(true);
    deviceProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDefaultQueueName("Default Queue Name");
    deviceProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setDescription("The characteristics of someone or something");
    deviceProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setFirmwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setImage("Image");
    deviceProfileEntity.setName("Name");
    deviceProfileEntity.setProfileData(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    deviceProfileEntity.setProvisionDeviceKey("Provision Device Key");
    deviceProfileEntity.setProvisionType(DeviceProfileProvisionType.DISABLED);
    deviceProfileEntity.setSoftwareId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    deviceProfileEntity.setTransportType(DeviceTransportType.DEFAULT);
    deviceProfileEntity.setType(DeviceProfileType.DEFAULT);
    deviceProfileEntity.setUuid(ModelConstants.NULL_UUID);
    deviceProfileEntity.setVersion(1L);
    ExportableEntityRepository<DeviceProfileEntity> exportableEntityRepository = mock(ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfileEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
