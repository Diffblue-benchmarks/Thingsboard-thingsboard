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
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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

@ContextConfiguration(classes = {UserDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDataValidatorDiffblueTest {
  @MockBean private ApiLimitService apiLimitService;

  @MockBean private CustomerDao customerDao;

  @MockBean private TenantService tenantService;

  @MockBean private UserDao userDao;

  @Autowired private UserDataValidator userDataValidator;

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
   *   <li>Given {@link CustomerId} {@link CustomerId#getId()} return randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenCustomerIdGetIdReturnRandomUUID2() {
    // Arrange
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
   *   <li>Given {@code CUSTOMER_USER}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenCustomerUser() {
    // Arrange
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
   *   <li>Given {@code CUSTOMER_USER}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenCustomerUser2() {
    // Arrange
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
   * <ul>
   *   <li>Given {@code CUSTOMER_USER}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenCustomerUser3() {
    // Arrange
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
    User user = new User(new User());
    user.setEmail("");
    user.setAuthority(null);
    user.setTenantId(null);
    user.setCustomerId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
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
   *   <li>Given {@link TenantId} {@link TenantId#getId()} return randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenTenantIdGetIdReturnRandomUUID() {
    // Arrange
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
   *   <li>Given {@code User}.
   *   <li>When {@link User#User(User)} with user is {@link User#User()} Email is {@code User}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_givenUser_whenUserWithUserIsUserEmailIsUser() {
    // Arrange
    User user = new User(new User());
    user.setEmail("User");
    user.setAuthority(null);
    user.setTenantId(null);
    user.setCustomerId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
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
    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(null);
    when(user.getTenantId()).thenReturn(null);
    doNothing().when(user).setCustomerId(Mockito.<CustomerId>any());
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
    verify(user).setCustomerId(isA(CustomerId.class));
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

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with {@code TenantId}, {@code
   * User}.
   *
   * <ul>
   *   <li>When {@link User#User()}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserDataValidator.validateDataImpl(TenantId, User)"})
  public void testValidateDataImplWithTenantIdUser_whenUser_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new User()));
  }
}
