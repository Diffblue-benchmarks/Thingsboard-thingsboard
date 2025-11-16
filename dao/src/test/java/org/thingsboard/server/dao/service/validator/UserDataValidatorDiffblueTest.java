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

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;
import org.thingsboard.server.dao.user.UserDao;

@RunWith(MockitoJUnitRunner.class)
public class UserDataValidatorDiffblueTest {
  @Mock private ApiLimitService apiLimitService;

  @Mock private CustomerDao customerDao;

  @Mock private TenantService tenantService;

  @Mock private UserDao userDao;

  @InjectMocks private UserDataValidator userDataValidator;

  /**
   * Test {@link UserDataValidator#validateCreate(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateCreate(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateCreate(TenantId, User)"})
  public void testValidateCreateWithTenantIdUser_givenSystem_tenant_thenDoesNotThrow() {
    // Arrange
    User user = new User();
    user.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    userDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, user);
  }

  /**
   * Test {@link UserDataValidator#validateCreate(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateCreate(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateCreate(TenantId, User)"})
  public void testValidateCreateWithTenantIdUser_thenCallsGetId() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = new User();
    user.setTenantId(tenantId);

    // Act
    userDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, user);

    // Assert
    verify(tenantId).getId();
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.USER));
  }

  /**
   * Test {@link UserDataValidator#validateCreate(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateCreate(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateCreate(TenantId, User)"})
  public void testValidateCreateWithTenantIdUser_thenThrowDataValidationException() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = new User();
    user.setTenantId(tenantId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, user));
    verify(tenantId).getId();
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.USER));
  }

  /**
   * Test {@link UserDataValidator#validateUpdate(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <p>Method under test: {@link UserDataValidator#validateUpdate(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserDataValidator.validateUpdate(TenantId, User)"})
  public void testValidateUpdateWithTenantIdUser() {
    // Arrange
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    User user = new User();
    user.setId(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, user));
    verify(userDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link UserDataValidator#validateUpdate(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#findById(TenantId, UUID)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateUpdate(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserDataValidator.validateUpdate(TenantId, User)"})
  public void testValidateUpdateWithTenantIdUser_givenUserDaoFindByIdReturnNull() {
    // Arrange
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    User user = new User();
    user.setId(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, user));
    verify(userDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link UserDataValidator#validateUpdate(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link User#User()} TenantId is {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateUpdate(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserDataValidator.validateUpdate(TenantId, User)"})
  public void testValidateUpdateWithTenantIdUser_givenUserTenantIdIsSystem_tenant() {
    // Arrange
    User user = new User();
    user.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);

    User user2 = new User();
    user2.setId(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, user2));
    verify(userDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link UserDataValidator#validateUpdate(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Then calls {@link User#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateUpdate(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserDataValidator.validateUpdate(TenantId, User)"})
  public void testValidateUpdateWithTenantIdUser_thenCallsGetTenantId() {
    // Arrange
    User user = mock(User.class);
    when(user.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);

    User user2 = new User();
    user2.setId(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, user2));
    verify(user).getTenantId();
    verify(userDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    User user = mock(User.class);
    when(user.getAuthority()).thenThrow(new DataValidationException("An error occurred"));
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user, atLeast(1)).getEmail();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser2() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    User user = mock(User.class);
    when(user.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser3() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenThrow(new DataValidationException("An error occurred"));

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(customerId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser4() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(mock(CustomerId.class));
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser5() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(mock(CustomerId.class));
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.TENANT_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser6() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(mock(CustomerId.class));
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.CUSTOMER_USER);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser7() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.TENANT_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user, atLeast(1)).getTenantId();
    verify(customerId).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser8() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.CUSTOMER_USER);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user, atLeast(1)).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user, atLeast(1)).getTenantId();
    verify(tenantId, atLeast(1)).getId();
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#findById(TenantId, UUID)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.CUSTOMER_USER);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user, atLeast(1)).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user, atLeast(1)).getTenantId();
    verify(tenantId, atLeast(1)).getId();
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link CustomerId}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenCustomerId() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(mock(CustomerId.class));
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link CustomerId} {@link CustomerId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenCustomerIdGetIdReturnNull_uuid() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.CUSTOMER_USER);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(customerId).getId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link CustomerId} {@link CustomerId#getId()} return randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenCustomerIdGetIdReturnRandomUUID() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.TENANT_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(customerId).getId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link Customer#Customer()} TenantId is {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenCustomerTenantIdIsSystem_tenant() {
    // Arrange
    Customer customer = new Customer();
    customer.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.CUSTOMER_USER);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user, atLeast(1)).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user, atLeast(1)).getTenantId();
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenEmptyString() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    User user = mock(User.class);
    when(user.getEmail()).thenReturn("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getEmail();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link User} {@link User#getEmail()} return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenFoo_whenUserGetEmailReturnFoo() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    User user = mock(User.class);
    when(user.getEmail()).thenReturn("foo");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user, atLeast(1)).getEmail();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenNull_customer_id() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act
    userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user);

    // Assert
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link User} {@link User#getAuthority()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenNull_whenUserGetAuthorityReturnNull() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    User user = mock(User.class);
    when(user.getAuthority()).thenReturn(null);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user, atLeast(1)).getEmail();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@code REFRESH_TOKEN}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenRefreshToken() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.REFRESH_TOKEN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act
    userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user);

    // Assert
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(customerId).getId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@code REFRESH_TOKEN}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenRefreshToken2() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(mock(CustomerId.class));
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.REFRESH_TOKEN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(customerId).getId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenTenantIdGetIdReturnNull_uuid2() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(mock(CustomerId.class));
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.TENANT_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenTenantIdGetIdReturnNull_uuid3() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(mock(CustomerId.class));
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.CUSTOMER_USER);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenTenantServiceTenantExistsReturnFalse() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.TENANT_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user, atLeast(1)).getTenantId();
    verify(customerId).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Given {@link UserDataValidator} (default constructor).
   *   <li>When {@link User#User()}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenUserDataValidator_whenUser() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new User()));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Then calls {@link Customer#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_thenCallsGetTenantId() {
    // Arrange
    Customer customer = mock(Customer.class);
    when(customer.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(customer);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.CUSTOMER_USER);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(customer).getTenantId();
    verify(user).getAuthority();
    verify(user, atLeast(1)).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user, atLeast(1)).getTenantId();
    verify(tenantId, atLeast(1)).getId();
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Then calls {@link User#setCustomerId(CustomerId)}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_thenCallsSetCustomerId() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(null);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(user).setCustomerId(Mockito.<CustomerId>any());
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act
    userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user);

    // Assert
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(user).setCustomerId(isA(CustomerId.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Then calls {@link User#setTenantId(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_thenCallsSetTenantId() {
    // Arrange
    UserDataValidator userDataValidator = new UserDataValidator();

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user.getTenantId()).thenReturn(null);
    doNothing().when(user).setTenantId(Mockito.<TenantId>any());
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act
    userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user);

    // Assert
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(user).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>Then calls {@link TenantService#tenantExists(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_thenCallsTenantExists() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.randomUUID());

    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(customerId);
    when(user.getTenantId()).thenReturn(tenantId);
    when(user.getAuthority()).thenReturn(Authority.TENANT_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act
    userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user);

    // Assert
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user, atLeast(1)).getTenantId();
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }
}
