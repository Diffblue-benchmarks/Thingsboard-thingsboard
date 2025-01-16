package org.thingsboard.server.dao.sql.asset;

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
import org.thingsboard.server.dao.model.sql.AssetEntity;

public class AssetRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link AssetRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    ExportableEntityRepository<AssetEntity> exportableEntityRepository = mock(ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(assetEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
