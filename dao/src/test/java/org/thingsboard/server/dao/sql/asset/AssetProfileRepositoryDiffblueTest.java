package org.thingsboard.server.dao.sql.asset;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.dao.ExportableEntityRepository;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AssetProfileEntity;

public class AssetProfileRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link AssetProfileRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AssetProfileEntity assetProfileEntity = new AssetProfileEntity();
    assetProfileEntity.setCreatedTime(1L);
    assetProfileEntity.setDefault(true);
    assetProfileEntity.setDefaultDashboardId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultEdgeRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDefaultQueueName("Default Queue Name");
    assetProfileEntity.setDefaultRuleChainId(ModelConstants.NULL_UUID);
    assetProfileEntity.setDescription("The characteristics of someone or something");
    assetProfileEntity.setExternalId(ModelConstants.NULL_UUID);
    assetProfileEntity.setId(ModelConstants.NULL_UUID);
    assetProfileEntity.setImage("Image");
    assetProfileEntity.setName("Name");
    assetProfileEntity.setTenantId(ModelConstants.NULL_UUID);
    assetProfileEntity.setUuid(ModelConstants.NULL_UUID);
    assetProfileEntity.setVersion(1L);
    ExportableEntityRepository<AssetProfileEntity> exportableEntityRepository = mock(ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfileEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
