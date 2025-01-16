package org.thingsboard.server.dao.sql.resource;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.dao.ExportableEntityRepository;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TbResourceEntity;

public class TbResourceRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link TbResourceRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResourceEntity tbResourceEntity = new TbResourceEntity();
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);
    ExportableEntityRepository<TbResourceEntity> exportableEntityRepository = mock(ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(tbResourceEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
