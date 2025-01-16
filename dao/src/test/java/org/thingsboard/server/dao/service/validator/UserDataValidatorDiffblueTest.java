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
import java.util.UUID;
import org.junit.Test;
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
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;
import org.thingsboard.server.dao.user.UserDao;
import org.thingsboard.server.dao.user.UserService;

@ContextConfiguration(classes = {UserDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class UserDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private CustomerDao customerDao;

  @MockBean
  private TenantService tenantService;

  @MockBean
  private UserDao userDao;

  @Autowired
  private UserDataValidator userDataValidator;

  @MockBean
  private UserService userService;

  /**
   * Test {@link UserDataValidator#validateCreate(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Then calls
   * {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateCreate(TenantId, User)}
   */
  @Test
  public void testValidateCreateWithTenantIdUser_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any())).thenReturn(true);
    User user = mock(User.class);
    when(user.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    userDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, user);

    // Assert
    verify(user).getTenantId();
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.USER));
  }

  /**
   * Test {@link UserDataValidator#validateCreate(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>When {@link User} {@link User#getTenantId()} return
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateCreate(TenantId, User)}
   */
  @Test
  public void testValidateCreateWithTenantIdUser_whenUserGetTenantIdReturnSystem_tenant() {
    // Arrange
    User user = mock(User.class);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    userDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, user);

    // Assert that nothing has changed
    verify(user).getTenantId();
  }

  /**
   * Test {@link UserDataValidator#validateUpdate(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <p>
   * Method under test: {@link UserDataValidator#validateUpdate(TenantId, User)}
   */
  @Test
  public void testValidateUpdateWithTenantIdUser() {
    // Arrange
    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);
    User user2 = mock(User.class);
    when(user2.getCustomerId()).thenThrow(new DataValidationException("An error occurred"));
    when(user2.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user2.getId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, user2));
    verify(user).getAuthority();
    verify(user2).getAuthority();
    verify(user).getCustomerId();
    verify(user2).getCustomerId();
    verify(user2).getId();
    verify(user).getTenantId();
    verify(user2, atLeast(1)).getTenantId();
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserDataValidator#validateUpdate(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then calls {@link User#getCustomerId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateUpdate(TenantId, User)}
   */
  @Test
  public void testValidateUpdateWithTenantIdUser_givenNull_customer_id_thenCallsGetCustomerId() {
    // Arrange
    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);
    User user2 = mock(User.class);
    when(user2.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user2.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user2.getId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act
    userDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, user2);

    // Assert
    verify(user).getAuthority();
    verify(user2).getAuthority();
    verify(user).getCustomerId();
    verify(user2).getCustomerId();
    verify(user2).getId();
    verify(user).getTenantId();
    verify(user2, atLeast(1)).getTenantId();
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserDataValidator#validateUpdate(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link User} {@link User#getTenantId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateUpdate(TenantId, User)}
   */
  @Test
  public void testValidateUpdateWithTenantIdUser_givenNull_whenUserGetTenantIdReturnNull() {
    // Arrange
    User user = mock(User.class);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);
    User user2 = mock(User.class);
    when(user2.getTenantId()).thenReturn(null);
    when(user2.getId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, user2));
    verify(user2).getId();
    verify(user).getTenantId();
    verify(user2, atLeast(1)).getTenantId();
    verify(userDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link UserDataValidator#validateUpdate(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Given {@link UserDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateUpdate(TenantId, User)}
   */
  @Test
  public void testValidateUpdateWithTenantIdUser_givenUserDaoFindByIdReturnNull() {
    // Arrange
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    User user = mock(User.class);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user.getId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getId();
    verify(user).getTenantId();
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserDataValidator#validateUpdate(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Given {@link User} {@link User#getAuthority()} return
   * {@code TENANT_ADMIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateUpdate(TenantId, User)}
   */
  @Test
  public void testValidateUpdateWithTenantIdUser_givenUserGetAuthorityReturnTenantAdmin() {
    // Arrange
    User user = mock(User.class);
    when(user.getAuthority()).thenReturn(Authority.TENANT_ADMIN);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);
    User user2 = mock(User.class);
    when(user2.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user2.getId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, user2));
    verify(user).getAuthority();
    verify(user2).getAuthority();
    verify(user2).getId();
    verify(user).getTenantId();
    verify(user2, atLeast(1)).getTenantId();
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserDataValidator#validateUpdate(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>When {@link User} {@link User#getCustomerId()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateUpdate(TenantId, User)}
   */
  @Test
  public void testValidateUpdateWithTenantIdUser_whenUserGetCustomerIdReturnNull() {
    // Arrange
    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);
    User user2 = mock(User.class);
    when(user2.getCustomerId()).thenReturn(null);
    when(user2.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user2.getId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, user2));
    verify(user).getAuthority();
    verify(user2).getAuthority();
    verify(user).getCustomerId();
    verify(user2).getCustomerId();
    verify(user2).getId();
    verify(user).getTenantId();
    verify(user2, atLeast(1)).getTenantId();
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUser() {
    // Arrange
    User user = mock(User.class);
    when(user.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Given {@code CUSTOMER_USER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUser_givenCustomerUser() {
    // Arrange
    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user.getAuthority()).thenReturn(Authority.CUSTOMER_USER);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUser_givenEmptyString() {
    // Arrange
    User user = mock(User.class);
    when(user.getEmail()).thenReturn("");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getEmail();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link User} {@link User#getAuthority()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUser_givenNull_whenUserGetAuthorityReturnNull() {
    // Arrange
    User user = mock(User.class);
    when(user.getAuthority()).thenReturn(null);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user, atLeast(1)).getEmail();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Given {@code REFRESH_TOKEN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUser_givenRefreshToken() {
    // Arrange
    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user.getAuthority()).thenReturn(Authority.REFRESH_TOKEN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act
    userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user);

    // Assert that nothing has changed
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Given {@code SYS_ADMIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUser_givenSysAdmin() {
    // Arrange
    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act
    userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user);

    // Assert that nothing has changed
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Given {@code TENANT_ADMIN}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUser_givenTenantAdmin() {
    // Arrange
    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user.getAuthority()).thenReturn(Authority.TENANT_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Then calls {@link User#setCustomerId(CustomerId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUser_thenCallsSetCustomerId() {
    // Arrange
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
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>Then calls {@link User#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUser_thenCallsSetTenantId() {
    // Arrange
    User user = mock(User.class);
    when(user.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(user.getTenantId()).thenReturn(null);
    doNothing().when(user).setTenantId(Mockito.<TenantId>any());
    when(user.getAuthority()).thenReturn(Authority.SYS_ADMIN);
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act
    userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, user);

    // Assert that nothing has changed
    verify(user).getAuthority();
    verify(user).getCustomerId();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
    verify(user).setTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link UserDataValidator#validateDataImpl(TenantId, User)} with
   * {@code TenantId}, {@code User}.
   * <ul>
   *   <li>When {@link User#User()}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserDataValidator#validateDataImpl(TenantId, User)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUser_whenUser_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> userDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new User()));
  }
}
