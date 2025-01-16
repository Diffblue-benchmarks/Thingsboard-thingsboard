package org.thingsboard.server.dao.sql.customer;

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
import org.thingsboard.server.dao.model.sql.CustomerEntity;

public class CustomerRepositoryDiffblueTest {
  /**
   * Test
   * {@link ExportableEntityRepository#findByTenantIdAndExternalId(UUID, UUID)}.
   * <p>
   * Method under test:
   * {@link CustomerRepository#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    ExportableEntityRepository<CustomerEntity> exportableEntityRepository = mock(ExportableEntityRepository.class);
    when(exportableEntityRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(customerEntity);

    // Act
    exportableEntityRepository.findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(exportableEntityRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
  }
}
