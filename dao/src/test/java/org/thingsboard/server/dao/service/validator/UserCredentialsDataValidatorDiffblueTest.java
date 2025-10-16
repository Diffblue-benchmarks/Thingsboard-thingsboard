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
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserCredentialsId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.user.UserCredentialsDao;
import org.thingsboard.server.dao.user.UserService;

@ContextConfiguration(classes = {UserCredentialsDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class UserCredentialsDataValidatorDiffblueTest {
  @MockBean private UserCredentialsDao userCredentialsDao;

  @Autowired private UserCredentialsDataValidator userCredentialsDataValidator;

  @MockBean private UserService userService;

  /**
   * Test {@link UserCredentialsDataValidator#validateCreate(TenantId, UserCredentials)} with {@code
   * TenantId}, {@code UserCredentials}.
   *
   * <p>Method under test: {@link UserCredentialsDataValidator#validateCreate(TenantId,
   * UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserCredentialsDataValidator.validateCreate(TenantId, UserCredentials)"})
  public void testValidateCreateWithTenantIdUserCredentials() {
    // Arrange, Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userCredentialsDataValidator.validateCreate(
                ModelConstants.SYSTEM_TENANT, new UserCredentials()));
  }

  /**
   * Test {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)} with
   * {@code TenantId}, {@code UserCredentials}.
   *
   * <p>Method under test: {@link UserCredentialsDataValidator#validateDataImpl(TenantId,
   * UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentialsDataValidator.validateDataImpl(TenantId, UserCredentials)"
  })
  public void testValidateDataImplWithTenantIdUserCredentials() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    UserCredentials userCredentials =
        new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));
    userCredentials.setUserId(new UserId(ModelConstants.NULL_UUID));
    userCredentials.setEnabled(false);
    userCredentials.setPassword("");
    userCredentials.setActivateToken("User credentials should be assigned to user!");

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)} with
   * {@code TenantId}, {@code UserCredentials}.
   *
   * <p>Method under test: {@link UserCredentialsDataValidator#validateDataImpl(TenantId,
   * UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentialsDataValidator.validateDataImpl(TenantId, UserCredentials)"
  })
  public void testValidateDataImplWithTenantIdUserCredentials2() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(null);

    UserCredentials userCredentials =
        new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));
    userCredentials.setUserId(new UserId(ModelConstants.NULL_UUID));
    userCredentials.setEnabled(false);
    userCredentials.setPassword("");
    userCredentials.setActivateToken("User credentials should be assigned to user!");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            userCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)} with
   * {@code TenantId}, {@code UserCredentials}.
   *
   * <p>Method under test: {@link UserCredentialsDataValidator#validateDataImpl(TenantId,
   * UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentialsDataValidator.validateDataImpl(TenantId, UserCredentials)"
  })
  public void testValidateDataImplWithTenantIdUserCredentials3() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(null);

    UserCredentials userCredentials =
        new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));
    userCredentials.setUserId(new UserId(ModelConstants.NULL_UUID));
    userCredentials.setEnabled(false);
    userCredentials.setPassword("");
    userCredentials.setActivateToken("User credentials should be assigned to user!");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            userCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findUserById(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)} with
   * {@code TenantId}, {@code UserCredentials}.
   *
   * <ul>
   *   <li>Given {@code iloveyou}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsDataValidator#validateDataImpl(TenantId,
   * UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentialsDataValidator.validateDataImpl(TenantId, UserCredentials)"
  })
  public void testValidateDataImplWithTenantIdUserCredentials_givenIloveyou() {
    // Arrange
    UserCredentialsDataValidator userCredentialsDataValidator = new UserCredentialsDataValidator();

    UserCredentials userCredentials =
        new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));
    userCredentials.setUserId(new UserId(ModelConstants.NULL_UUID));
    userCredentials.setEnabled(true);
    userCredentials.setPassword("iloveyou");
    userCredentials.setActivateToken("User credentials should be assigned to user!");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            userCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, userCredentials));
  }

  /**
   * Test {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)} with
   * {@code TenantId}, {@code UserCredentials}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsDataValidator#validateDataImpl(TenantId,
   * UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentialsDataValidator.validateDataImpl(TenantId, UserCredentials)"
  })
  public void testValidateDataImplWithTenantIdUserCredentials_givenNull() {
    // Arrange
    UserCredentialsDataValidator userCredentialsDataValidator = new UserCredentialsDataValidator();

    UserCredentials userCredentials =
        new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));
    userCredentials.setUserId(new UserId(ModelConstants.NULL_UUID));
    userCredentials.setEnabled(true);
    userCredentials.setPassword(null);
    userCredentials.setActivateToken("User credentials should be assigned to user!");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            userCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, userCredentials));
  }

  /**
   * Test {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)} with
   * {@code TenantId}, {@code UserCredentials}.
   *
   * <ul>
   *   <li>Given {@link UserCredentialsDao}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsDataValidator#validateDataImpl(TenantId,
   * UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentialsDataValidator.validateDataImpl(TenantId, UserCredentials)"
  })
  public void testValidateDataImplWithTenantIdUserCredentials_givenUserCredentialsDao() {
    // Arrange
    UserCredentials userCredentials =
        new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));
    userCredentials.setUserId(new UserId(ModelConstants.NULL_UUID));
    userCredentials.setEnabled(true);
    userCredentials.setPassword("");
    userCredentials.setActivateToken("User credentials should be assigned to user!");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            userCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, userCredentials));
  }

  /**
   * Test {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)} with
   * {@code TenantId}, {@code UserCredentials}.
   *
   * <ul>
   *   <li>Then calls {@link UserService#findUserById(TenantId, UserId)}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsDataValidator#validateDataImpl(TenantId,
   * UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentialsDataValidator.validateDataImpl(TenantId, UserCredentials)"
  })
  public void testValidateDataImplWithTenantIdUserCredentials_thenCallsFindUserById() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(new User());

    UserCredentials userCredentials =
        new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));
    userCredentials.setUserId(new UserId(ModelConstants.NULL_UUID));
    userCredentials.setEnabled(false);
    userCredentials.setPassword("");
    userCredentials.setActivateToken("User credentials should be assigned to user!");

    // Act
    userCredentialsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, userCredentials);

    // Assert
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(userService).findUserById(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test {@link UserCredentialsDataValidator#validateDataImpl(TenantId, UserCredentials)} with
   * {@code TenantId}, {@code UserCredentials}.
   *
   * <ul>
   *   <li>When {@link UserCredentials#UserCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link UserCredentialsDataValidator#validateDataImpl(TenantId,
   * UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserCredentialsDataValidator.validateDataImpl(TenantId, UserCredentials)"
  })
  public void testValidateDataImplWithTenantIdUserCredentials_whenUserCredentials() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            userCredentialsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new UserCredentials()));
  }
}
