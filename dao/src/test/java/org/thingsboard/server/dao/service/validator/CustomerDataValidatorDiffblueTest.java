package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {CustomerDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class CustomerDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private CustomerDao customerDao;

  @Autowired
  private CustomerDataValidator customerDataValidator;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link CustomerDataValidator#validateCreate(TenantId, Customer)} with
   * {@code TenantId}, {@code Customer}.
   * <ul>
   *   <li>Then calls
   * {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerDataValidator#validateCreate(TenantId, Customer)}
   */
  @Test
  public void testValidateCreateWithTenantIdCustomer_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any())).thenReturn(true);

    // Act
    customerDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Customer());

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.CUSTOMER));
  }

  /**
   * Test {@link CustomerDataValidator#validateUpdate(TenantId, Customer)} with
   * {@code TenantId}, {@code Customer}.
   * <p>
   * Method under test:
   * {@link CustomerDataValidator#validateUpdate(TenantId, Customer)}
   */
  @Test
  public void testValidateUpdateWithTenantIdCustomer() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Customer customer = new Customer();
    customer.setId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> customerDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, customer));
    verify(customerDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateUpdate(TenantId, Customer)} with
   * {@code TenantId}, {@code Customer}.
   * <ul>
   *   <li>Given {@link CustomerDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerDataValidator#validateUpdate(TenantId, Customer)}
   */
  @Test
  public void testValidateUpdateWithTenantIdCustomer_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    Customer customer = new Customer();
    customer.setId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> customerDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, customer));
    verify(customerDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateUpdate(TenantId, Customer)} with
   * {@code TenantId}, {@code Customer}.
   * <ul>
   *   <li>Then return {@link Customer#Customer()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerDataValidator#validateUpdate(TenantId, Customer)}
   */
  @Test
  public void testValidateUpdateWithTenantIdCustomer_thenReturnCustomer() {
    // Arrange
    Customer customer = new Customer();
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    Customer customer2 = new Customer();
    customer2.setId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    Customer actualValidateUpdateResult = customerDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, customer2);

    // Assert
    verify(customerDao).findById(isNull(), isA(UUID.class));
    assertSame(customer, actualValidateUpdateResult);
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with
   * {@code TenantId}, {@code Customer}.
   * <p>
   * Method under test:
   * {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  public void testValidateDataImplWithTenantIdCustomer() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Customer customer = mock(Customer.class);
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customer.getTitle()).thenReturn("Dr");

    // Act
    customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer);

    // Assert that nothing has changed
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getTenantId();
    verify(customer, atLeast(1)).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with
   * {@code TenantId}, {@code Customer}.
   * <p>
   * Method under test:
   * {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  public void testValidateDataImplWithTenantIdCustomer2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Customer customer = mock(Customer.class);
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customer.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getTenantId();
    verify(customer, atLeast(1)).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with
   * {@code TenantId}, {@code Customer}.
   * <p>
   * Method under test:
   * {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  public void testValidateDataImplWithTenantIdCustomer3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    Customer customer = mock(Customer.class);
    when(customer.getEmail()).thenReturn("jane.doe@example.org");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customer.getTitle()).thenReturn("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
    verify(customer, atLeast(1)).getEmail();
    verify(customer, atLeast(1)).getTenantId();
    verify(customer, atLeast(1)).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with
   * {@code TenantId}, {@code Customer}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  public void testValidateDataImplWithTenantIdCustomer_givenEmptyString() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    Customer customer = mock(Customer.class);
    when(customer.getEmail()).thenReturn("");
    when(customer.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(customer.getTitle()).thenReturn("Dr");

    // Act
    customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer);

    // Assert that nothing has changed
    verify(customer).getEmail();
    verify(customer, atLeast(1)).getTenantId();
    verify(customer, atLeast(1)).getTitle();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with
   * {@code TenantId}, {@code Customer}.
   * <ul>
   *   <li>Given {@code Public}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  public void testValidateDataImplWithTenantIdCustomer_givenPublic() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getTitle()).thenReturn("Public");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
    verify(customer, atLeast(1)).getTitle();
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with
   * {@code TenantId}, {@code Customer}.
   * <ul>
   *   <li>When {@link Customer#Customer()} Title is {@code Dr}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  public void testValidateDataImplWithTenantIdCustomer_whenCustomerTitleIsDr() {
    // Arrange
    Customer customer = new Customer();
    customer.setTitle("Dr");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
  }
}
