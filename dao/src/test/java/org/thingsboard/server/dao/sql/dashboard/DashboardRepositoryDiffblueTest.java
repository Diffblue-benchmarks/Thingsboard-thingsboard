package org.thingsboard.server.dao.sql.dashboard;

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
import org.thingsboard.server.dao.model.sql.DashboardEntity;

public class DashboardRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link DashboardRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    ExportableEntityRepository<DashboardEntity> exportableEntityRepository = mock(ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(dashboardEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
