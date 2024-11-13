package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserCredentialsId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;
import org.thingsboard.server.dao.user.UserCredentialsDao;
import org.thingsboard.server.dao.user.UserService;

@ContextConfiguration(classes = {UserCredentialsDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class UserCredentialsDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private UserCredentialsDao userCredentialsDao;

  @Autowired
  private UserCredentialsDataValidator userCredentialsDataValidator;

  @MockBean
  private UserService userService;

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateCreate(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateCreate(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateCreateWithTenantIdUserCredentials() {
    // Arrange, Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userCredentialsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new UserCredentials()));
  }

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUserCredentials() {
    // Arrange
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getActivateToken()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(userCredentials.getPassword()).thenReturn("iloveyou");
    when(userCredentials.isEnabled()).thenReturn(true);
    when(userCredentials.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getActivateToken();
    verify(userCredentials).getPassword();
    verify(userCredentials).getUserId();
    verify(userCredentials).isEnabled();
  }

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUserCredentials2() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new UserCredentials());
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(new User());
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getActivateToken()).thenReturn("");
    when(userCredentials.getPassword()).thenReturn("iloveyou");
    when(userCredentials.isEnabled()).thenReturn(true);
    when(userCredentials.getId()).thenReturn(new UserCredentialsId(ModelConstants.NULL_UUID));
    when(userCredentials.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act
    userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, userCredentials);

    // Assert
    verify(userCredentials).getId();
    verify(userCredentials).getActivateToken();
    verify(userCredentials).getPassword();
    verify(userCredentials, atLeast(1)).getUserId();
    verify(userCredentials).isEnabled();
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findUserById(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUserCredentials3() {
    // Arrange
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getPassword()).thenReturn(null);
    when(userCredentials.isEnabled()).thenReturn(true);
    when(userCredentials.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getPassword();
    verify(userCredentials).getUserId();
    verify(userCredentials).isEnabled();
  }

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUserCredentials4() {
    // Arrange
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getPassword()).thenReturn("");
    when(userCredentials.isEnabled()).thenReturn(true);
    when(userCredentials.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getPassword();
    verify(userCredentials).getUserId();
    verify(userCredentials).isEnabled();
  }

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUserCredentials5() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getActivateToken()).thenReturn(null);
    when(userCredentials.getPassword()).thenReturn("iloveyou");
    when(userCredentials.isEnabled()).thenReturn(true);
    when(userCredentials.getId()).thenReturn(new UserCredentialsId(ModelConstants.NULL_UUID));
    when(userCredentials.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getId();
    verify(userCredentials).getActivateToken();
    verify(userCredentials).getPassword();
    verify(userCredentials).getUserId();
    verify(userCredentials).isEnabled();
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUserCredentials6() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new UserCredentials());
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(null);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getActivateToken()).thenReturn(null);
    when(userCredentials.getPassword()).thenReturn("iloveyou");
    when(userCredentials.isEnabled()).thenReturn(true);
    when(userCredentials.getId()).thenReturn(new UserCredentialsId(ModelConstants.NULL_UUID));
    when(userCredentials.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getId();
    verify(userCredentials).getActivateToken();
    verify(userCredentials).getPassword();
    verify(userCredentials, atLeast(1)).getUserId();
    verify(userCredentials).isEnabled();
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findUserById(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <ul>
   *   <li>Given {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUserCredentials_givenAbc123() {
    // Arrange
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getActivateToken()).thenReturn("ABC123");
    when(userCredentials.getPassword()).thenReturn("iloveyou");
    when(userCredentials.isEnabled()).thenReturn(true);
    when(userCredentials.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getActivateToken();
    verify(userCredentials).getPassword();
    verify(userCredentials).getUserId();
    verify(userCredentials).isEnabled();
  }

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUserCredentials_givenFalse() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new UserCredentials());
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(new User());
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(false);
    when(userCredentials.getId()).thenReturn(new UserCredentialsId(ModelConstants.NULL_UUID));
    when(userCredentials.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act
    userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, userCredentials);

    // Assert
    verify(userCredentials).getId();
    verify(userCredentials, atLeast(1)).getUserId();
    verify(userCredentials).isEnabled();
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findUserById(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <ul>
   *   <li>Then calls {@link UserService#findUserById(TenantId, UserId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUserCredentials_thenCallsFindUserById() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new UserCredentials());
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(new User());
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getActivateToken()).thenReturn(null);
    when(userCredentials.getPassword()).thenReturn("iloveyou");
    when(userCredentials.isEnabled()).thenReturn(true);
    when(userCredentials.getId()).thenReturn(new UserCredentialsId(ModelConstants.NULL_UUID));
    when(userCredentials.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act
    userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, userCredentials);

    // Assert
    verify(userCredentials).getId();
    verify(userCredentials).getActivateToken();
    verify(userCredentials).getPassword();
    verify(userCredentials, atLeast(1)).getUserId();
    verify(userCredentials).isEnabled();
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findUserById(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   * with {@code TenantId}, {@code UserCredentials}.
   * <ul>
   *   <li>When {@link UserCredentials#UserCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)}
   */
  @Test
  public void testValidateDataImplWithTenantIdUserCredentials_whenUserCredentials() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new UserCredentials()));
  }
}
