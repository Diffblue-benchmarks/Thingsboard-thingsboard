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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
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
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.device.DeviceDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {DeviceDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DeviceDataValidatorDiffblueTest {
  @MockBean private ApiLimitService apiLimitService;

  @MockBean private CustomerDao customerDao;

  @MockBean private DeviceDao deviceDao;

  @Autowired private DeviceDataValidator deviceDataValidator;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link DeviceDataValidator#validateCreate(TenantId, Device)} with {@code TenantId}, {@code
   * Device}.
   *
   * <ul>
   *   <li>Then calls {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDataValidator#validateCreate(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateCreate(TenantId, Device)"})
  public void testValidateCreateWithTenantIdDevice_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenReturn(true);

    // Act
    deviceDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Device());

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.DEVICE));
  }

  /**
   * Test {@link DeviceDataValidator#validateUpdate(TenantId, Device)} with {@code TenantId}, {@code
   * Device}.
   *
   * <p>Method under test: {@link DeviceDataValidator#validateUpdate(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceDataValidator.validateUpdate(TenantId, Device)"})
  public void testValidateUpdateWithTenantIdDevice() {
    // Arrange
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Device device = new Device();
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, device));
    verify(deviceDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateUpdate(TenantId, Device)} with {@code TenantId}, {@code
   * Device}.
   *
   * <ul>
   *   <li>Given {@link DeviceDao} {@link DeviceDao#findById(TenantId, UUID)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDataValidator#validateUpdate(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceDataValidator.validateUpdate(TenantId, Device)"})
  public void testValidateUpdateWithTenantIdDevice_givenDeviceDaoFindByIdReturnNull() {
    // Arrange
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    Device device = new Device();
    device.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, device));
    verify(deviceDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateUpdate(TenantId, Device)} with {@code TenantId}, {@code
   * Device}.
   *
   * <ul>
   *   <li>Then return {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDataValidator#validateUpdate(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Device DeviceDataValidator.validateUpdate(TenantId, Device)"})
  public void testValidateUpdateWithTenantIdDevice_thenReturnDevice() {
    // Arrange
    Device device = new Device();
    when(deviceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(device);

    Device device2 = new Device();
    device2.setId(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    Device actualValidateUpdateResult =
        deviceDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, device2);

    // Assert
    verify(deviceDao).findById(isNull(), isA(UUID.class));
    assertSame(device, actualValidateUpdateResult);
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    Device device = new Device();
    device.setTenantId(ModelConstants.SYSTEM_TENANT);
    device.setName("Device name");

    // Act
    deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
    CustomerId customerId = device.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Device device = new Device();
    device.setTenantId(ModelConstants.SYSTEM_TENANT);
    device.setName("Device name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenThrow(new DataValidationException("An error occurred"));

    Device device = new Device();
    device.setCustomerId(customerId);
    device.setTenantId(ModelConstants.SYSTEM_TENANT);
    device.setName("Device name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device));
    verify(customerId).getId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice4() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    Device device = new Device();
    device.setCustomerId(customerId);
    device.setTenantId(ModelConstants.SYSTEM_TENANT);
    device.setName("Device name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device));
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#findById(TenantId, UUID)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    Device device = new Device();
    device.setCustomerId(customerId);
    device.setTenantId(ModelConstants.SYSTEM_TENANT);
    device.setName("Device name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device));
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer()} TenantId is {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice_givenCustomerTenantIdIsSystem_tenant() {
    // Arrange
    Customer customer = new Customer();
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    Device device = new Device();
    device.setCustomerId(customerId);
    device.setTenantId(ModelConstants.SYSTEM_TENANT);
    device.setName("Device name");

    // Act
    deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice_givenNull_customer_id() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    Device device = new Device();
    device.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    device.setTenantId(ModelConstants.SYSTEM_TENANT);
    device.setName("Device name");

    // Act
    deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device);

    // Assert that nothing has changed
    verify(tenantService).tenantExists(isA(TenantId.class));
    CustomerId customerId = device.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice_givenTenantService() {
    // Arrange
    Device device = new Device();
    device.setName("Device name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device));
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice_givenTenantServiceTenantExistsReturnFalse() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    Device device = new Device();
    device.setTenantId(ModelConstants.SYSTEM_TENANT);
    device.setName("Device name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   *   <li>When {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice_givenTenantService_whenDevice() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new Device()));
  }

  /**
   * Test {@link DeviceDataValidator#validateDataImpl(TenantId, Device)} with {@code TenantId},
   * {@code Device}.
   *
   * <ul>
   *   <li>Then calls {@link Customer#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDataValidator#validateDataImpl(TenantId, Device)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceDataValidator.validateDataImpl(TenantId, Device)"})
  public void testValidateDataImplWithTenantIdDevice_thenCallsGetTenantId() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    Device device = new Device();
    device.setCustomerId(customerId);
    device.setTenantId(ModelConstants.SYSTEM_TENANT);
    device.setName("Device name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, device));
    verify(customer).getTenantId();
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }
}
