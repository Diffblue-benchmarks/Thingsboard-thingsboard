/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {CustomerDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerDataValidatorDiffblueTest {
  @MockBean private ApiLimitService apiLimitService;

  @MockBean private CustomerDao customerDao;

  @Autowired private CustomerDataValidator customerDataValidator;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link CustomerDataValidator#validateCreate(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <ul>
   *   <li>Then calls {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerDataValidator#validateCreate(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateCreate(TenantId, Customer)"})
  public void testValidateCreateWithTenantIdCustomer_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenReturn(true);

    // Act
    customerDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Customer());

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.CUSTOMER));
  }

  /**
   * Test {@link CustomerDataValidator#validateUpdate(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <p>Method under test: {@link CustomerDataValidator#validateUpdate(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerDataValidator.validateUpdate(TenantId, Customer)"})
  public void testValidateUpdateWithTenantIdCustomer() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Customer customer = new Customer(new Customer());
    customer.setId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> customerDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, customer));
    verify(customerDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateUpdate(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#findById(TenantId, UUID)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerDataValidator#validateUpdate(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerDataValidator.validateUpdate(TenantId, Customer)"})
  public void testValidateUpdateWithTenantIdCustomer_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    Customer customer = new Customer(new Customer());
    customer.setId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> customerDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, customer));
    verify(customerDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateUpdate(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <ul>
   *   <li>Then return {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerDataValidator#validateUpdate(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Customer CustomerDataValidator.validateUpdate(TenantId, Customer)"})
  public void testValidateUpdateWithTenantIdCustomer_thenReturnCustomer() {
    // Arrange
    Customer customer = new Customer();
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);

    Customer customer2 = new Customer(new Customer());
    customer2.setId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    Customer actualValidateUpdateResult =
        customerDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, customer2);

    // Assert
    verify(customerDao).findById(isNull(), isA(UUID.class));
    assertSame(customer, actualValidateUpdateResult);
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <p>Method under test: {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateDataImpl(TenantId, Customer)"})
  public void testValidateDataImplWithTenantIdCustomer() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    Customer customer = new Customer();
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);
    customer.setTitle("Dr");

    // Act
    customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <p>Method under test: {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateDataImpl(TenantId, Customer)"})
  public void testValidateDataImplWithTenantIdCustomer2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Customer customer = new Customer();
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);
    customer.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <p>Method under test: {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateDataImpl(TenantId, Customer)"})
  public void testValidateDataImplWithTenantIdCustomer3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    Customer customer = new Customer();
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);
    customer.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <ul>
   *   <li>Given {@link CustomerDataValidator} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateDataImpl(TenantId, Customer)"})
  public void testValidateDataImplWithTenantIdCustomer_givenCustomerDataValidator() {
    // Arrange
    CustomerDataValidator customerDataValidator = new CustomerDataValidator();

    Customer customer = new Customer();
    customer.setTitle("Dr\u0000");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <ul>
   *   <li>Given {@code Customer title}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateDataImpl(TenantId, Customer)"})
  public void testValidateDataImplWithTenantIdCustomer_givenCustomerTitle() {
    // Arrange
    Customer customer = new Customer(new Customer());
    customer.setEmail("Customer title");
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);
    customer.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <ul>
   *   <li>Given {@code jane.doe@example.org}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateDataImpl(TenantId, Customer)"})
  public void testValidateDataImplWithTenantIdCustomer_givenJaneDoeExampleOrg() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    Customer customer = new Customer();
    customer.setEmail("jane.doe@example.org");
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);
    customer.setTitle("Dr");

    // Act
    customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <ul>
   *   <li>Given {@code Public}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateDataImpl(TenantId, Customer)"})
  public void testValidateDataImplWithTenantIdCustomer_givenPublic() {
    // Arrange
    Customer customer = new Customer(new Customer());
    customer.setTitle("Public");
    customer.setEmail("");
    customer.setTenantId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateDataImpl(TenantId, Customer)"})
  public void testValidateDataImplWithTenantIdCustomer_givenTenantService() {
    // Arrange
    Customer customer = new Customer();
    customer.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   *   <li>When {@link Customer#Customer()}.
   * </ul>
   *
   * <p>Method under test: {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateDataImpl(TenantId, Customer)"})
  public void testValidateDataImplWithTenantIdCustomer_givenTenantService_whenCustomer() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new Customer()));
  }

  /**
   * Test {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)} with {@code TenantId},
   * {@code Customer}.
   *
   * <ul>
   *   <li>When {@link Customer#Customer()} Title is empty string.
   * </ul>
   *
   * <p>Method under test: {@link CustomerDataValidator#validateDataImpl(TenantId, Customer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CustomerDataValidator.validateDataImpl(TenantId, Customer)"})
  public void testValidateDataImplWithTenantIdCustomer_whenCustomerTitleIsEmptyString() {
    // Arrange
    Customer customer = new Customer();
    customer.setTitle("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> customerDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, customer));
  }
}
