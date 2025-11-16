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
package org.thingsboard.server.dao.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.cache.user.UserCacheEvictEvent;
import org.thingsboard.server.cache.user.UserCacheKey;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserCredentialsId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.mobile.MobileSessionInfo;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.common.data.security.model.SecuritySettings;
import org.thingsboard.server.common.data.security.model.UserPasswordPolicy;
import org.thingsboard.server.common.data.settings.UserSettings;
import org.thingsboard.server.common.data.settings.UserSettingsType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityCountService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.settings.SecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;

@ContextConfiguration(classes = {UserServiceImpl.class})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceImplDiffblueTest {
  @MockBean private DataValidator<User> dataValidator;

  @MockBean private DataValidator<UserCredentials> dataValidator2;

  @MockBean private EntityCountService entityCountService;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private SecuritySettingsService securitySettingsService;

  @MockBean private TbTransactionalCache<UserCacheKey, User> tbTransactionalCache;

  @MockBean private UserAuthSettingsDao userAuthSettingsDao;

  @MockBean private UserCredentialsDao userCredentialsDao;

  @MockBean private UserDao userDao;

  @Autowired private UserServiceImpl userServiceImpl;

  @MockBean private UserSettingsDao userSettingsDao;

  @MockBean private UserSettingsService userSettingsService;

  /**
   * Test {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)} with {@code
   * UserCacheEvictEvent}.
   *
   * <p>Method under test: {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.handleEvictEvent(UserCacheEvictEvent)"})
  public void testHandleEvictEventWithUserCacheEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<UserCacheKey>>any());
    UserCacheEvictEvent event =
        new UserCacheEvictEvent(
            ModelConstants.SYSTEM_TENANT, "jane.doe@example.org", "jane.doe@example.org");

    // Act
    userServiceImpl.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)} with {@code
   * UserCacheEvictEvent}.
   *
   * <p>Method under test: {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.handleEvictEvent(UserCacheEvictEvent)"})
  public void testHandleEvictEventWithUserCacheEvictEvent2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<UserCacheKey>>any());
    UserCacheEvictEvent event =
        new UserCacheEvictEvent(
            ModelConstants.SYSTEM_TENANT, "john.smith@example.org", "jane.doe@example.org");

    // Act
    userServiceImpl.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)} with {@code
   * UserCacheEvictEvent}.
   *
   * <p>Method under test: {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.handleEvictEvent(UserCacheEvictEvent)"})
  public void testHandleEvictEventWithUserCacheEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<UserCacheKey>>any());
    UserCacheEvictEvent event =
        new UserCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org", "");

    // Act
    userServiceImpl.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)} with {@code
   * UserCacheEvictEvent}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.handleEvictEvent(UserCacheEvictEvent)"})
  public void testHandleEvictEventWithUserCacheEvictEvent_thenThrowIncorrectParameterException() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<UserCacheKey>>any());
    UserCacheEvictEvent event =
        new UserCacheEvictEvent(
            ModelConstants.SYSTEM_TENANT, "jane.doe@example.org", "jane.doe@example.org");

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> userServiceImpl.handleEvictEvent(event));
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link UserServiceImpl#findUserByEmail(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link JpaUserDao} {@link JpaUserDao#findByEmail(TenantId, String)} return {@link
   *       User#User()}.
   *   <li>Then calls {@link JpaUserDao#findByEmail(TenantId, String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.findUserByEmail(TenantId, String)"})
  public void testFindUserByEmail_givenJpaUserDaoFindByEmailReturnUser_thenCallsFindByEmail() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    User user = new User();
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(user);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    // Act
    User actualFindUserByEmailResult =
        userServiceImpl.findUserByEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
    assertSame(user, actualFindUserByEmailResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserByEmail(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#findByEmail(TenantId, String)} return {@link
   *       User#User()}.
   *   <li>Then return {@link User#User()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.findUserByEmail(TenantId, String)"})
  public void testFindUserByEmail_givenUserDaoFindByEmailReturnUser_thenReturnUser() {
    // Arrange
    User user = new User();
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(user);

    // Act
    User actualFindUserByEmailResult =
        userServiceImpl.findUserByEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
    assertSame(user, actualFindUserByEmailResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserByEmail(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.findUserByEmail(TenantId, String)"})
  public void testFindUserByEmail_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findUserByEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.findUserByTenantIdAndEmail(TenantId, String)"})
  public void testFindUserByTenantIdAndEmail() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<UserCacheKey>any(), Mockito.<Supplier<User>>any(), anyBoolean()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findUserByTenantIdAndEmail(
                ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(UserCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.findUserByTenantIdAndEmail(TenantId, String)"})
  public void testFindUserByTenantIdAndEmail2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findUserByTenantIdAndEmail(tenantId, "jane.doe@example.org"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.findUserByTenantIdAndEmail(TenantId, String)"})
  public void testFindUserByTenantIdAndEmail_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    User user = new User();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<UserCacheKey>any(), Mockito.<Supplier<User>>any(), anyBoolean()))
        .thenReturn(user);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    User actualFindUserByTenantIdAndEmailResult =
        userServiceImpl.findUserByTenantIdAndEmail(tenantId, "jane.doe@example.org");

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(UserCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantId).getId();
    assertSame(user, actualFindUserByTenantIdAndEmailResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link User#User()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.findUserByTenantIdAndEmail(TenantId, String)"})
  public void testFindUserByTenantIdAndEmail_thenReturnUser() {
    // Arrange
    User user = new User();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<UserCacheKey>any(), Mockito.<Supplier<User>>any(), anyBoolean()))
        .thenReturn(user);

    // Act
    User actualFindUserByTenantIdAndEmailResult =
        userServiceImpl.findUserByTenantIdAndEmail(
            ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(UserCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(user, actualFindUserByTenantIdAndEmailResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserByTenantIdAndEmailAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByTenantIdAndEmailAsync(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture UserServiceImpl.findUserByTenantIdAndEmailAsync(TenantId, String)"
  })
  public void testFindUserByTenantIdAndEmailAsync_givenNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<User> actualFindUserByTenantIdAndEmailAsyncResult =
        userServiceImpl.findUserByTenantIdAndEmailAsync(tenantId, "jane.doe@example.org");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(tenantId).getId();
    assertTrue(actualFindUserByTenantIdAndEmailAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindUserByTenantIdAndEmailAsyncResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserByTenantIdAndEmailAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByTenantIdAndEmailAsync(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture UserServiceImpl.findUserByTenantIdAndEmailAsync(TenantId, String)"
  })
  public void testFindUserByTenantIdAndEmailAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<User> actualFindUserByTenantIdAndEmailAsyncResult =
        userServiceImpl.findUserByTenantIdAndEmailAsync(
            ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindUserByTenantIdAndEmailAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindUserByTenantIdAndEmailAsyncResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserByTenantIdAndEmailAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByTenantIdAndEmailAsync(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture UserServiceImpl.findUserByTenantIdAndEmailAsync(TenantId, String)"
  })
  public void testFindUserByTenantIdAndEmailAsync_thenThrowIncorrectParameterException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findUserByTenantIdAndEmailAsync(tenantId, "jane.doe@example.org"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserServiceImpl#findUserById(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Given {@link JpaUserDao} {@link JpaUserDao#findById(TenantId, UUID)} return {@link
   *       User#User()}.
   *   <li>Then calls {@link JpaUserDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserById(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.findUserById(TenantId, UserId)"})
  public void testFindUserById_givenJpaUserDaoFindByIdReturnUser_thenCallsFindById() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    User user = new User();
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    User actualFindUserByIdResult =
        userServiceImpl.findUserById(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userId, atLeast(1)).getId();
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(user, actualFindUserByIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserById(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#findById(TenantId, UUID)} return {@link
   *       User#User()}.
   *   <li>Then calls {@link UserDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserById(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.findUserById(TenantId, UserId)"})
  public void testFindUserById_givenUserDaoFindByIdReturnUser_thenCallsFindById() {
    // Arrange
    User user = new User();
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);

    // Act
    User actualFindUserByIdResult =
        userServiceImpl.findUserById(
            ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(user, actualFindUserByIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserById(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserById(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.findUserById(TenantId, UserId)"})
  public void testFindUserById_thenThrowIncorrectParameterException() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findUserById(ModelConstants.SYSTEM_TENANT, userId));
    verify(userId).getId();
  }

  /**
   * Test {@link UserServiceImpl#findUserByIdAsync(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserByIdAsync(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture UserServiceImpl.findUserByIdAsync(TenantId, UserId)"})
  public void testFindUserByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<User> createResult = SettableFuture.create();
    when(userDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<User> actualFindUserByIdAsyncResult =
        userServiceImpl.findUserByIdAsync(
            ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindUserByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindUserByIdAsyncResult);
  }

  /**
   * Test {@link UserServiceImpl#saveUser(TenantId, User)}.
   *
   * <p>Method under test: {@link UserServiceImpl#saveUser(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.saveUser(TenantId, User)"})
  public void testSaveUser() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    User user = mock(User.class);
    when(user.getAdditionalInfo()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(user.getTenantId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.saveUser(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAdditionalInfo();
    verify(user).getTenantId();
  }

  /**
   * Test {@link UserServiceImpl#saveUser(TenantId, User)}.
   *
   * <p>Method under test: {@link UserServiceImpl#saveUser(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.saveUser(TenantId, User)"})
  public void testSaveUser2() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    DataValidator<User> userValidator = mock(DataValidator.class);
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    User user = mock(User.class);
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(user)
        .setEmail(Mockito.<String>any());
    when(user.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.saveUser(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getEmail();
    verify(user).setEmail("jane.doe@example.org");
  }

  /**
   * Test {@link UserServiceImpl#saveUser(TenantId, User)}.
   *
   * <ul>
   *   <li>Given {@link CustomerServiceImpl#PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON}.
   *   <li>Then calls {@link User#getAuthority()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#saveUser(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.saveUser(TenantId, User)"})
  public void testSaveUser_givenPublic_customer_additional_info_json_thenCallsGetAuthority() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    User user = mock(User.class);
    when(user.getAuthority()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(user.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.saveUser(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getAdditionalInfo();
    verify(user).getAuthority();
    verify(user, atLeast(1)).getEmail();
    verify(user).getTenantId();
  }

  /**
   * Test {@link UserServiceImpl#saveUser(TenantId, User)}.
   *
   * <ul>
   *   <li>Given {@link UserDao}.
   *   <li>When {@link User#User()}.
   *   <li>Then calls {@link DataValidator#validate(BaseData, Function)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#saveUser(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.saveUser(TenantId, User)"})
  public void testSaveUser_givenUserDao_whenUser_thenCallsValidate() {
    // Arrange
    User user = mock(User.class);
    when(user.getEmail()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(dataValidator.validate(Mockito.<User>any(), Mockito.<Function<User, TenantId>>any()))
        .thenReturn(user);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.saveUser(ModelConstants.SYSTEM_TENANT, new User()));
    verify(user).getEmail();
    verify(dataValidator).validate(isA(User.class), isA(Function.class));
  }

  /**
   * Test {@link UserServiceImpl#saveUser(TenantId, User)}.
   *
   * <ul>
   *   <li>When {@link User} {@link User#setEmail(String)} does nothing.
   *   <li>Then calls {@link User#setEmail(String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#saveUser(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"User UserServiceImpl.saveUser(TenantId, User)"})
  public void testSaveUser_whenUserSetEmailDoesNothing_thenCallsSetEmail() {
    // Arrange
    User user = mock(User.class);
    when(user.getEmail()).thenThrow(new IncorrectParameterException("An error occurred"));

    DataValidator<User> userValidator = mock(DataValidator.class);
    when(userValidator.validate(Mockito.<User>any(), Mockito.<Function<User, TenantId>>any()))
        .thenReturn(user);
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    User user2 = mock(User.class);
    when(user2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(user2).setEmail(Mockito.<String>any());
    when(user2.getEmail()).thenReturn("jane.doe@example.org");

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.saveUser(ModelConstants.SYSTEM_TENANT, user2));
    verify(user).getEmail();
    verify(user2, atLeast(1)).getEmail();
    verify(user2).getTenantId();
    verify(user2).setEmail("jane.doe@example.org");
    verify(userValidator).validate(isA(User.class), isA(Function.class));
  }

  /**
   * Test {@link UserServiceImpl#findUserCredentialsByUserId(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Then calls {@link UserCredentialsDao#findByUserId(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserCredentialsByUserId(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.findUserCredentialsByUserId(TenantId, UserId)"
  })
  public void testFindUserCredentialsByUserId_thenCallsFindByUserId() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(userCredentials);

    // Act
    UserCredentials actualFindUserCredentialsByUserIdResult =
        userServiceImpl.findUserCredentialsByUserId(
            ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
    assertSame(userCredentials, actualFindUserCredentialsByUserIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserCredentialsByUserId(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaUserCredentialsDao#findByUserId(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserCredentialsByUserId(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.findUserCredentialsByUserId(TenantId, UserId)"
  })
  public void testFindUserCredentialsByUserId_thenCallsFindByUserId2() {
    // Arrange
    JpaUserCredentialsDao userCredentialsDao = mock(JpaUserCredentialsDao.class);
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(userCredentials);
    JpaUserDao userDao = new JpaUserDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    UserCredentials actualFindUserCredentialsByUserIdResult =
        userServiceImpl.findUserCredentialsByUserId(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userId, atLeast(1)).getId();
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
    assertSame(userCredentials, actualFindUserCredentialsByUserIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserCredentialsByUserId(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserCredentialsByUserId(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.findUserCredentialsByUserId(TenantId, UserId)"
  })
  public void testFindUserCredentialsByUserId_thenThrowIncorrectParameterException() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findUserCredentialsByUserId(ModelConstants.SYSTEM_TENANT, userId));
    verify(userId).getId();
  }

  /**
   * Test {@link UserServiceImpl#findUserCredentialsByActivateToken(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link UserCredentials#UserCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserCredentialsByActivateToken(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.findUserCredentialsByActivateToken(TenantId, String)"
  })
  public void testFindUserCredentialsByActivateToken_thenReturnUserCredentials() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(userCredentials);

    // Act
    UserCredentials actualFindUserCredentialsByActivateTokenResult =
        userServiceImpl.findUserCredentialsByActivateToken(ModelConstants.SYSTEM_TENANT, "ABC123");

    // Assert
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
    assertSame(userCredentials, actualFindUserCredentialsByActivateTokenResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserCredentialsByActivateToken(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserCredentialsByActivateToken(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.findUserCredentialsByActivateToken(TenantId, String)"
  })
  public void testFindUserCredentialsByActivateToken_thenThrowIncorrectParameterException() {
    // Arrange
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findUserCredentialsByActivateToken(
                ModelConstants.SYSTEM_TENANT, "ABC123"));
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test {@link UserServiceImpl#findUserCredentialsByResetToken(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link UserCredentials#UserCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserCredentialsByResetToken(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.findUserCredentialsByResetToken(TenantId, String)"
  })
  public void testFindUserCredentialsByResetToken_thenReturnUserCredentials() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.findByResetToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(userCredentials);

    // Act
    UserCredentials actualFindUserCredentialsByResetTokenResult =
        userServiceImpl.findUserCredentialsByResetToken(ModelConstants.SYSTEM_TENANT, "ABC123");

    // Assert
    verify(userCredentialsDao).findByResetToken(isA(TenantId.class), eq("ABC123"));
    assertSame(userCredentials, actualFindUserCredentialsByResetTokenResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserCredentialsByResetToken(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUserCredentialsByResetToken(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.findUserCredentialsByResetToken(TenantId, String)"
  })
  public void testFindUserCredentialsByResetToken_thenThrowIncorrectParameterException() {
    // Arrange
    when(userCredentialsDao.findByResetToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findUserCredentialsByResetToken(
                ModelConstants.SYSTEM_TENANT, "ABC123"));
    verify(userCredentialsDao).findByResetToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}.
   *
   * <p>Method under test: {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.saveUserCredentials(TenantId, UserCredentials)"
  })
  public void testSaveUserCredentials() {
    // Arrange
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));
    when(dataValidator2.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.saveUserCredentials(
                ModelConstants.SYSTEM_TENANT, new UserCredentials()));
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
  }

  /**
   * Test {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}.
   *
   * <ul>
   *   <li>Given {@link UserCredentialsDao}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.saveUserCredentials(TenantId, UserCredentials)"
  })
  public void testSaveUserCredentials_givenUserCredentialsDao() {
    // Arrange
    when(dataValidator2.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.saveUserCredentials(
                ModelConstants.SYSTEM_TENANT, new UserCredentials()));
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}.
   *
   * <ul>
   *   <li>Then calls {@link UserCredentials#getUserId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.saveUserCredentials(TenantId, UserCredentials)"
  })
  public void testSaveUserCredentials_thenCallsGetUserId() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getUserId())
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.saveUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getUserId();
  }

  /**
   * Test {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}.
   *
   * <ul>
   *   <li>Then return {@link UserCredentials#UserCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.saveUserCredentials(TenantId, UserCredentials)"
  })
  public void testSaveUserCredentials_thenReturnUserCredentials() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(userCredentials);
    when(dataValidator2.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    // Act
    UserCredentials actualSaveUserCredentialsResult =
        userServiceImpl.saveUserCredentials(ModelConstants.SYSTEM_TENANT, new UserCredentials());

    // Assert
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    assertSame(userCredentials, actualSaveUserCredentialsResult);
  }

  /**
   * Test {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}.
   *
   * <p>Method under test: {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.activateUserCredentials(TenantId, String, String)"
  })
  public void testActivateUserCredentials() {
    // Arrange
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new UserCredentials());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.activateUserCredentials(
                ModelConstants.SYSTEM_TENANT, "ABC123", "iloveyou"));
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}.
   *
   * <p>Method under test: {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.activateUserCredentials(TenantId, String, String)"
  })
  public void testActivateUserCredentials2() {
    // Arrange
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.activateUserCredentials(
                ModelConstants.SYSTEM_TENANT, "ABC123", "iloveyou"));
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}.
   *
   * <ul>
   *   <li>Given {@link UserCredentialsDao} {@link UserCredentialsDao#findByActivateToken(TenantId,
   *       String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.activateUserCredentials(TenantId, String, String)"
  })
  public void testActivateUserCredentials_givenUserCredentialsDaoFindByActivateTokenReturnNull() {
    // Arrange
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.activateUserCredentials(
                ModelConstants.SYSTEM_TENANT, "ABC123", "iloveyou"));
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test {@link UserServiceImpl#requestPasswordReset(TenantId, String)}.
   *
   * <p>Method under test: {@link UserServiceImpl#requestPasswordReset(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials UserServiceImpl.requestPasswordReset(TenantId, String)"})
  public void testRequestPasswordReset() {
    // Arrange
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.requestPasswordReset(
                ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test {@link UserServiceImpl#requestPasswordReset(TenantId, String)}.
   *
   * <p>Method under test: {@link UserServiceImpl#requestPasswordReset(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials UserServiceImpl.requestPasswordReset(TenantId, String)"})
  public void testRequestPasswordReset2() {
    // Arrange
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new User());
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.requestPasswordReset(
                ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isNull());
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test {@link UserServiceImpl#requestPasswordReset(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#findByEmail(TenantId, String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#requestPasswordReset(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials UserServiceImpl.requestPasswordReset(TenantId, String)"})
  public void testRequestPasswordReset_givenUserDaoFindByEmailReturnNull() {
    // Arrange
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () ->
            userServiceImpl.requestPasswordReset(
                ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test {@link UserServiceImpl#requestPasswordReset(TenantId, String)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaUserDao#findByEmail(TenantId, String)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#requestPasswordReset(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials UserServiceImpl.requestPasswordReset(TenantId, String)"})
  public void testRequestPasswordReset_thenCallsFindByEmail() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    // Act and Assert
    assertThrows(
        UsernameNotFoundException.class,
        () ->
            userServiceImpl.requestPasswordReset(
                ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test {@link UserServiceImpl#requestPasswordReset(TenantId, String)}.
   *
   * <ul>
   *   <li>Then calls {@link User#getUuidId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#requestPasswordReset(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials UserServiceImpl.requestPasswordReset(TenantId, String)"})
  public void testRequestPasswordReset_thenCallsGetUuidId() {
    // Arrange
    User user = mock(User.class);
    when(user.getUuidId()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(user);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.requestPasswordReset(
                ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(user).getUuidId();
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test {@link UserServiceImpl#requestPasswordReset(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DisabledException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#requestPasswordReset(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials UserServiceImpl.requestPasswordReset(TenantId, String)"})
  public void testRequestPasswordReset_thenThrowDisabledException() {
    // Arrange
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new User());
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());

    // Act and Assert
    assertThrows(
        DisabledException.class,
        () ->
            userServiceImpl.requestPasswordReset(
                ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isNull());
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test {@link UserServiceImpl#requestExpiredPasswordReset(TenantId, UserCredentialsId)}.
   *
   * <p>Method under test: {@link UserServiceImpl#requestExpiredPasswordReset(TenantId,
   * UserCredentialsId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.requestExpiredPasswordReset(TenantId, UserCredentialsId)"
  })
  public void testRequestExpiredPasswordReset() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.requestExpiredPasswordReset(
                ModelConstants.SYSTEM_TENANT, new UserCredentialsId(ModelConstants.NULL_UUID)));
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#requestExpiredPasswordReset(TenantId, UserCredentialsId)}.
   *
   * <p>Method under test: {@link UserServiceImpl#requestExpiredPasswordReset(TenantId,
   * UserCredentialsId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.requestExpiredPasswordReset(TenantId, UserCredentialsId)"
  })
  public void testRequestExpiredPasswordReset2() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.requestExpiredPasswordReset(
                ModelConstants.SYSTEM_TENANT, new UserCredentialsId(ModelConstants.NULL_UUID)));
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#generatePasswordResetToken(UserCredentials)}.
   *
   * <ul>
   *   <li>Then return {@link UserCredentials#UserCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#generatePasswordResetToken(UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials UserServiceImpl.generatePasswordResetToken(UserCredentials)"})
  public void testGeneratePasswordResetToken_thenReturnUserCredentials() {
    // Arrange
    UserPasswordPolicy passwordPolicy = new UserPasswordPolicy();
    passwordPolicy.setAllowWhitespaces(true);
    passwordPolicy.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy.setMaximumLength(3);
    passwordPolicy.setMinimumDigits(1);
    passwordPolicy.setMinimumLength(3);
    passwordPolicy.setMinimumLowercaseLetters(1);
    passwordPolicy.setMinimumSpecialCharacters(1);
    passwordPolicy.setMinimumUppercaseLetters(1);
    passwordPolicy.setPasswordExpirationPeriodDays(1);
    passwordPolicy.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings = new SecuritySettings();
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);
    UserCredentials userCredentials = new UserCredentials();

    // Act
    UserCredentials actualGeneratePasswordResetTokenResult =
        userServiceImpl.generatePasswordResetToken(userCredentials);

    // Assert
    verify(securitySettingsService).getSecuritySettings();
    assertSame(userCredentials, actualGeneratePasswordResetTokenResult);
  }

  /**
   * Test {@link UserServiceImpl#generatePasswordResetToken(UserCredentials)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#generatePasswordResetToken(UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UserCredentials UserServiceImpl.generatePasswordResetToken(UserCredentials)"})
  public void testGeneratePasswordResetToken_thenThrowIncorrectParameterException() {
    // Arrange
    when(securitySettingsService.getSecuritySettings())
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.generatePasswordResetToken(new UserCredentials()));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test {@link UserServiceImpl#generateUserActivationToken(UserCredentials)}.
   *
   * <ul>
   *   <li>Then return {@link UserCredentials#UserCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#generateUserActivationToken(UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.generateUserActivationToken(UserCredentials)"
  })
  public void testGenerateUserActivationToken_thenReturnUserCredentials() {
    // Arrange
    UserPasswordPolicy passwordPolicy = new UserPasswordPolicy();
    passwordPolicy.setAllowWhitespaces(true);
    passwordPolicy.setForceUserToResetPasswordIfNotValid(true);
    passwordPolicy.setMaximumLength(3);
    passwordPolicy.setMinimumDigits(1);
    passwordPolicy.setMinimumLength(3);
    passwordPolicy.setMinimumLowercaseLetters(1);
    passwordPolicy.setMinimumSpecialCharacters(1);
    passwordPolicy.setMinimumUppercaseLetters(1);
    passwordPolicy.setPasswordExpirationPeriodDays(1);
    passwordPolicy.setPasswordReuseFrequencyDays(1);

    SecuritySettings securitySettings = new SecuritySettings();
    securitySettings.setMaxFailedLoginAttempts(3);
    securitySettings.setMobileSecretKeyLength(3);
    securitySettings.setPasswordPolicy(passwordPolicy);
    securitySettings.setPasswordResetTokenTtl(1);
    securitySettings.setUserActivationTokenTtl(1);
    securitySettings.setUserLockoutNotificationEmail("jane.doe@example.org");
    when(securitySettingsService.getSecuritySettings()).thenReturn(securitySettings);
    UserCredentials userCredentials = new UserCredentials();

    // Act
    UserCredentials actualGenerateUserActivationTokenResult =
        userServiceImpl.generateUserActivationToken(userCredentials);

    // Assert
    verify(securitySettingsService).getSecuritySettings();
    assertSame(userCredentials, actualGenerateUserActivationTokenResult);
  }

  /**
   * Test {@link UserServiceImpl#generateUserActivationToken(UserCredentials)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#generateUserActivationToken(UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.generateUserActivationToken(UserCredentials)"
  })
  public void testGenerateUserActivationToken_thenThrowIncorrectParameterException() {
    // Arrange
    when(securitySettingsService.getSecuritySettings())
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.generateUserActivationToken(new UserCredentials()));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   *
   * <p>Method under test: {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.replaceUserCredentials(TenantId, UserCredentials)"
  })
  public void testReplaceUserCredentials() {
    // Arrange
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(new UserCredentials());
    doNothing().when(userCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(dataValidator2.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    UserCredentials userCredentials =
        new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));
    userCredentials.setPassword("Executing replaceUserCredentials [{}]");

    // Act
    userServiceImpl.replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials);

    // Assert
    verify(userCredentialsDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    assertTrue(userCredentials.getAdditionalInfo() instanceof ObjectNode);
  }

  /**
   * Test {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   *
   * <p>Method under test: {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.replaceUserCredentials(TenantId, UserCredentials)"
  })
  public void testReplaceUserCredentials2() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(userCredentialsDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(dataValidator2.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.replaceUserCredentials(
                ModelConstants.SYSTEM_TENANT, new UserCredentials()));
    verify(userCredentialsDao).removeById(isA(TenantId.class), isNull());
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   *
   * <p>Method under test: {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.replaceUserCredentials(TenantId, UserCredentials)"
  })
  public void testReplaceUserCredentials3() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getUserId())
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getUserId();
  }

  /**
   * Test {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   *
   * <p>Method under test: {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.replaceUserCredentials(TenantId, UserCredentials)"
  })
  public void testReplaceUserCredentials4() {
    // Arrange
    JpaUserCredentialsDao userCredentialsDao = mock(JpaUserCredentialsDao.class);
    doNothing().when(userCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    JpaUserDao userDao = new JpaUserDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    DataValidator<UserCredentials> userCredentialsValidator = mock(DataValidator.class);
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserCredentials userCredentials = mock(UserCredentials.class);
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(userCredentials)
        .setId(Mockito.<UserCredentialsId>any());
    when(userCredentials.getUuidId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getUuidId();
    verify(userCredentials).setId(isNull());
    verify(userCredentialsDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   *
   * <p>Method under test: {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.replaceUserCredentials(TenantId, UserCredentials)"
  })
  public void testReplaceUserCredentials5() {
    // Arrange
    JpaUserCredentialsDao userCredentialsDao = mock(JpaUserCredentialsDao.class);
    doNothing().when(userCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    JpaUserDao userDao = new JpaUserDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    DataValidator<UserCredentials> userCredentialsValidator = mock(DataValidator.class);
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getAdditionalInfo())
        .thenThrow(new IncorrectParameterException("An error occurred"));
    when(userCredentials.getPassword()).thenReturn("iloveyou");
    doNothing().when(userCredentials).setId(Mockito.<UserCredentialsId>any());
    when(userCredentials.getUuidId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getAdditionalInfo();
    verify(userCredentials).getUuidId();
    verify(userCredentials).setId(isNull());
    verify(userCredentials).getPassword();
    verify(userCredentialsDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   *
   * <ul>
   *   <li>Given {@link UserCredentialsDao}.
   *   <li>When {@link UserCredentials#UserCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.replaceUserCredentials(TenantId, UserCredentials)"
  })
  public void testReplaceUserCredentials_givenUserCredentialsDao_whenUserCredentials() {
    // Arrange
    when(dataValidator2.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.replaceUserCredentials(
                ModelConstants.SYSTEM_TENANT, new UserCredentials()));
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
  }

  /**
   * Test {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   *
   * <ul>
   *   <li>Then calls {@link UserCredentials#setAdditionalInfo(JsonNode)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.replaceUserCredentials(TenantId, UserCredentials)"
  })
  public void testReplaceUserCredentials_thenCallsSetAdditionalInfo() {
    // Arrange
    JpaUserCredentialsDao userCredentialsDao = mock(JpaUserCredentialsDao.class);
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(new UserCredentials());
    doNothing().when(userCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    JpaUserDao userDao = new JpaUserDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    DataValidator<UserCredentials> userCredentialsValidator = mock(DataValidator.class);
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    doNothing().when(userCredentials).setAdditionalInfo(Mockito.<JsonNode>any());
    when(userCredentials.getPassword()).thenReturn("iloveyou");
    doNothing().when(userCredentials).setId(Mockito.<UserCredentialsId>any());
    when(userCredentials.getUuidId()).thenReturn(ModelConstants.NULL_UUID);
    when(userCredentials.getUserId())
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials));
    verify(userCredentials).getAdditionalInfo();
    verify(userCredentials).setAdditionalInfo(isA(JsonNode.class));
    verify(userCredentials).getUuidId();
    verify(userCredentials).setId(isNull());
    verify(userCredentials, atLeast(1)).getPassword();
    verify(userCredentials).getUserId();
    verify(userCredentialsDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
  }

  /**
   * Test {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   *
   * <ul>
   *   <li>Then return AdditionalInfo is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.replaceUserCredentials(TenantId, UserCredentials)"
  })
  public void testReplaceUserCredentials_thenReturnAdditionalInfoIsNull() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(userCredentials);
    doNothing().when(userCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(dataValidator2.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());
    UserCredentials userCredentials2 =
        new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));

    // Act
    UserCredentials actualReplaceUserCredentialsResult =
        userServiceImpl.replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials2);

    // Assert
    verify(userCredentialsDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    assertNull(actualReplaceUserCredentialsResult.getAdditionalInfo());
    assertNull(actualReplaceUserCredentialsResult.getFailedLoginAttempts());
    assertNull(actualReplaceUserCredentialsResult.getActivateTokenExpTime());
    assertNull(actualReplaceUserCredentialsResult.getLastLoginTs());
    assertNull(actualReplaceUserCredentialsResult.getResetTokenExpTime());
    assertNull(actualReplaceUserCredentialsResult.getActivateToken());
    assertNull(actualReplaceUserCredentialsResult.getPassword());
    assertNull(actualReplaceUserCredentialsResult.getResetToken());
    assertNull(actualReplaceUserCredentialsResult.getUuidId());
    assertNull(actualReplaceUserCredentialsResult.getId());
    assertNull(actualReplaceUserCredentialsResult.getUserId());
    assertEquals(0L, actualReplaceUserCredentialsResult.getCreatedTime());
    assertEquals(0L, actualReplaceUserCredentialsResult.getActivationTokenTtl());
    assertEquals(0L, actualReplaceUserCredentialsResult.getResetTokenTtl());
    assertFalse(actualReplaceUserCredentialsResult.isEnabled());
    assertTrue(actualReplaceUserCredentialsResult.isActivationTokenExpired());
    assertTrue(actualReplaceUserCredentialsResult.isResetTokenExpired());
    assertEquals(userCredentials, userCredentials2);
  }

  /**
   * Test {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   *
   * <ul>
   *   <li>When {@link UserCredentials#UserCredentials()}.
   *   <li>Then {@link UserCredentials#UserCredentials()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UserCredentials UserServiceImpl.replaceUserCredentials(TenantId, UserCredentials)"
  })
  public void testReplaceUserCredentials_whenUserCredentials_thenUserCredentials() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(userCredentials);
    doNothing().when(userCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(dataValidator2.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());
    UserCredentials userCredentials2 = new UserCredentials();

    // Act
    UserCredentials actualReplaceUserCredentialsResult =
        userServiceImpl.replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials2);

    // Assert
    verify(userCredentialsDao).removeById(isA(TenantId.class), isNull());
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    assertEquals(userCredentials, userCredentials2);
    assertSame(userCredentials, actualReplaceUserCredentialsResult);
  }

  /**
   * Test {@link UserServiceImpl#deleteUser(TenantId, User)} with {@code tenantId}, {@code user}.
   *
   * <p>Method under test: {@link UserServiceImpl#deleteUser(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.deleteUser(TenantId, User)"})
  public void testDeleteUserWithTenantIdUser() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(userCredentialsDao)
        .removeByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.deleteUser(
                ModelConstants.SYSTEM_TENANT, new User(new UserId(ModelConstants.NULL_UUID))));
    verify(userCredentialsDao).removeByUserId(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteUser(TenantId, User)} with {@code tenantId}, {@code user}.
   *
   * <ul>
   *   <li>Then calls {@link User#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#deleteUser(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.deleteUser(TenantId, User)"})
  public void testDeleteUserWithTenantIdUser_thenCallsGetId() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    User user = mock(User.class);
    when(user.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.deleteUser(ModelConstants.SYSTEM_TENANT, user));
    verify(user).getId();
  }

  /**
   * Test {@link UserServiceImpl#deleteUser(TenantId, User)} with {@code tenantId}, {@code user}.
   *
   * <ul>
   *   <li>Then calls {@link UserAuthSettingsDao#removeByUserId(UserId)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#deleteUser(TenantId, User)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.deleteUser(TenantId, User)"})
  public void testDeleteUserWithTenantIdUser_thenCallsRemoveByUserId() {
    // Arrange
    doNothing()
        .when(userCredentialsDao)
        .removeByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any());
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(userAuthSettingsDao)
        .removeByUserId(Mockito.<UserId>any());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.deleteUser(
                ModelConstants.SYSTEM_TENANT, new User(new UserId(ModelConstants.NULL_UUID))));
    verify(userAuthSettingsDao).removeByUserId(isA(UserId.class));
    verify(userCredentialsDao).removeByUserId(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByTenantId(TenantId, PageLink)"})
  public void testFindUsersByTenantId() {
    // Arrange
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findUsersByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByTenantId(TenantId, PageLink)"})
  public void testFindUsersByTenantId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findUsersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByTenantId(TenantId, PageLink)"})
  public void testFindUsersByTenantId3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findUsersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByTenantId(TenantId, PageLink)"})
  public void testFindUsersByTenantId4() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findUsersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByTenantId(TenantId, PageLink)"})
  public void testFindUsersByTenantId5() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findUsersByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByTenantId(TenantId, PageLink)"})
  public void testFindUsersByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<User> actualFindUsersByTenantIdResult =
        userServiceImpl.findUsersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindUsersByTenantIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByTenantId(TenantId, PageLink)"})
  public void testFindUsersByTenantId_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<User> actualFindUsersByTenantIdResult =
        userServiceImpl.findUsersByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindUsersByTenantIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaUserDao#findByTenantId(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByTenantId(TenantId, PageLink)"})
  public void testFindUsersByTenantId_thenCallsFindByTenantId() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<User> actualFindUsersByTenantIdResult =
        userServiceImpl.findUsersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindUsersByTenantIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then calls {@link UserDao#findByTenantId(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByTenantId(TenantId, PageLink)"})
  public void testFindUsersByTenantId_whenFirst_page_thenCallsFindByTenantId() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindUsersByTenantIdResult =
        userServiceImpl.findUsersByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindUsersByTenantIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdmins(TenantId, PageLink)"})
  public void testFindTenantAdmins() {
    // Arrange
    when(userDao.findTenantAdmins(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findTenantAdmins(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdmins(TenantId, PageLink)"})
  public void testFindTenantAdmins2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findTenantAdmins(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdmins(TenantId, PageLink)"})
  public void testFindTenantAdmins3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findTenantAdmins(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdmins(TenantId, PageLink)"})
  public void testFindTenantAdmins4() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findTenantAdmins(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdmins(TenantId, PageLink)"})
  public void testFindTenantAdmins5() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findTenantAdmins(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdmins(TenantId, PageLink)"})
  public void testFindTenantAdmins_givenBy_created_time_desc() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findTenantAdmins(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<User> actualFindTenantAdminsResult =
        userServiceImpl.findTenantAdmins(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdmins(TenantId, PageLink)"})
  public void testFindTenantAdmins_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findTenantAdmins(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<User> actualFindTenantAdminsResult =
        userServiceImpl.findTenantAdmins(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdmins(TenantId, PageLink)"})
  public void testFindTenantAdmins_thenCallsFindTenantAdmins() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findTenantAdmins(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<User> actualFindTenantAdminsResult =
        userServiceImpl.findTenantAdmins(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then calls {@link UserDao#findTenantAdmins(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdmins(TenantId, PageLink)"})
  public void testFindTenantAdmins_whenFirst_page_thenCallsFindTenantAdmins() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findTenantAdmins(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindTenantAdminsResult =
        userServiceImpl.findTenantAdmins(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findSysAdmins(PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findSysAdmins(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findSysAdmins(PageLink)"})
  public void testFindSysAdmins_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findAllByAuthority(Mockito.<Authority>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindSysAdminsResult =
        userServiceImpl.findSysAdmins(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindSysAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findSysAdmins(PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findSysAdmins(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findSysAdmins(PageLink)"})
  public void testFindSysAdmins_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findAllByAuthority(Mockito.<Authority>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findSysAdmins(BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findAllTenantAdmins(PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findAllTenantAdmins(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findAllTenantAdmins(PageLink)"})
  public void testFindAllTenantAdmins_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findAllByAuthority(Mockito.<Authority>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindAllTenantAdminsResult =
        userServiceImpl.findAllTenantAdmins(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findAllByAuthority(eq(Authority.TENANT_ADMIN), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllTenantAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findAllTenantAdmins(PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findAllTenantAdmins(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findAllTenantAdmins(PageLink)"})
  public void testFindAllTenantAdmins_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findAllByAuthority(Mockito.<Authority>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findAllTenantAdmins(BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findAllByAuthority(eq(Authority.TENANT_ADMIN), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdminsByTenantsIds(List, PageLink)"})
  public void testFindTenantAdminsByTenantsIds_givenSystem_tenant() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByAuthorityAndTenantsIds(
            Mockito.<Authority>any(), Mockito.<List<TenantId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<TenantId> tenantsIds = new ArrayList<>();
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<User> actualFindTenantAdminsByTenantsIdsResult =
        userServiceImpl.findTenantAdminsByTenantsIds(
            tenantsIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao)
        .findByAuthorityAndTenantsIds(
            eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantAdminsByTenantsIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdminsByTenantsIds(List, PageLink)"})
  public void testFindTenantAdminsByTenantsIds_givenSystem_tenant2() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByAuthorityAndTenantsIds(
            Mockito.<Authority>any(), Mockito.<List<TenantId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<TenantId> tenantsIds = new ArrayList<>();
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<User> actualFindTenantAdminsByTenantsIdsResult =
        userServiceImpl.findTenantAdminsByTenantsIds(
            tenantsIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao)
        .findByAuthorityAndTenantsIds(
            eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantAdminsByTenantsIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdminsByTenantsIds(List, PageLink)"})
  public void testFindTenantAdminsByTenantsIds_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByAuthorityAndTenantsIds(
            Mockito.<Authority>any(), Mockito.<List<TenantId>>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findTenantAdminsByTenantsIds(
                new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao)
        .findByAuthorityAndTenantsIds(
            eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findTenantAdminsByTenantsIds(List, PageLink)"})
  public void testFindTenantAdminsByTenantsIds_whenArrayList_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByAuthorityAndTenantsIds(
            Mockito.<Authority>any(), Mockito.<List<TenantId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindTenantAdminsByTenantsIdsResult =
        userServiceImpl.findTenantAdminsByTenantsIds(
            new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao)
        .findByAuthorityAndTenantsIds(
            eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantAdminsByTenantsIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdminsByTenantProfilesIds(List, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdminsByTenantProfilesIds(List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData UserServiceImpl.findTenantAdminsByTenantProfilesIds(List, PageLink)"
  })
  public void testFindTenantAdminsByTenantProfilesIds_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByAuthorityAndTenantProfilesIds(
            Mockito.<Authority>any(),
            Mockito.<List<TenantProfileId>>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindTenantAdminsByTenantProfilesIdsResult =
        userServiceImpl.findTenantAdminsByTenantProfilesIds(
            new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao)
        .findByAuthorityAndTenantProfilesIds(
            eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantAdminsByTenantProfilesIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdminsByTenantProfilesIds(List, PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findTenantAdminsByTenantProfilesIds(List,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData UserServiceImpl.findTenantAdminsByTenantProfilesIds(List, PageLink)"
  })
  public void testFindTenantAdminsByTenantProfilesIds_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByAuthorityAndTenantProfilesIds(
            Mockito.<Authority>any(),
            Mockito.<List<TenantProfileId>>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findTenantAdminsByTenantProfilesIds(
                new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao)
        .findByAuthorityAndTenantProfilesIds(
            eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findAllUsers(PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findAllUsers(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findAllUsers(PageLink)"})
  public void testFindAllUsers_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findAll(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindAllUsersResult =
        userServiceImpl.findAllUsers(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findAll(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllUsersResult);
  }

  /**
   * Test {@link UserServiceImpl#findAllUsers(PageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findAllUsers(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findAllUsers(PageLink)"})
  public void testFindAllUsers_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findAll(Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findAllUsers(BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findAll(isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteTenantAdmins(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link UserDao#findTenantAdmins(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#deleteTenantAdmins(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.deleteTenantAdmins(TenantId)"})
  public void testDeleteTenantAdmins_thenCallsFindTenantAdmins() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findTenantAdmins(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    userServiceImpl.deleteTenantAdmins(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteAllByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#findByTenantId(UUID, PageLink)} return
   *       emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#deleteAllByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.deleteAllByTenantId(TenantId)"})
  public void testDeleteAllByTenantId_givenUserDaoFindByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    userServiceImpl.deleteAllByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteAllByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#deleteAllByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.deleteAllByTenantId(TenantId)"})
  public void testDeleteAllByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.deleteAllByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#findByTenantId(UUID, PageLink)} return
   *       emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenUserDaoFindByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    userServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findCustomerUsers(TenantId, CustomerId, PageLink)"})
  public void testFindCustomerUsers() {
    // Arrange
    when(userDao.findCustomerUsers(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findCustomerUsers(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findCustomerUsers(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link UserDao}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findCustomerUsers(TenantId, CustomerId, PageLink)"})
  public void testFindCustomerUsers_givenUserDao() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findCustomerUsers(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return zero.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findCustomerUsers(TenantId, CustomerId, PageLink)"})
  public void testFindCustomerUsers_givenZero_whenPageLinkGetPageReturnZero_thenCallsGetPage() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findCustomerUsers(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<User> actualFindCustomerUsersResult =
        userServiceImpl.findCustomerUsers(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findCustomerUsers(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindCustomerUsersResult);
  }

  /**
   * Test {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findCustomerUsers(TenantId, CustomerId, PageLink)"})
  public void testFindCustomerUsers_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findCustomerUsers(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindCustomerUsersResult =
        userServiceImpl.findCustomerUsers(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findCustomerUsers(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindCustomerUsersResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByCustomerIds(TenantId, List, PageLink)"})
  public void testFindUsersByCustomerIds() {
    // Arrange
    when(userDao.findUsersByCustomerIds(
            Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findUsersByCustomerIds(
                ModelConstants.SYSTEM_TENANT,
                new ArrayList<>(),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByCustomerIds(TenantId, List, PageLink)"})
  public void testFindUsersByCustomerIds2() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    ArrayList<CustomerId> customerIds = new ArrayList<>();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findUsersByCustomerIds(
                ModelConstants.SYSTEM_TENANT, customerIds, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByCustomerIds(TenantId, List, PageLink)"})
  public void testFindUsersByCustomerIds3() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findUsersByCustomerIds(
                tenantId, new ArrayList<>(), mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByCustomerIds(TenantId, List, PageLink)"})
  public void testFindUsersByCustomerIds_givenBy_created_time_desc() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(
            Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    ArrayList<CustomerId> customerIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        userServiceImpl.findUsersByCustomerIds(ModelConstants.SYSTEM_TENANT, customerIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByCustomerIds(TenantId, List, PageLink)"})
  public void testFindUsersByCustomerIds_givenNull_customer_id() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(
            Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<CustomerId> customerIds = new ArrayList<>();
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        userServiceImpl.findUsersByCustomerIds(
            ModelConstants.SYSTEM_TENANT, customerIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByCustomerIds(TenantId, List, PageLink)"})
  public void testFindUsersByCustomerIds_givenNull_customer_id2() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(
            Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<CustomerId> customerIds = new ArrayList<>();
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        userServiceImpl.findUsersByCustomerIds(
            ModelConstants.SYSTEM_TENANT, customerIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByCustomerIds(TenantId, List, PageLink)"})
  public void testFindUsersByCustomerIds_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(
            Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);
    ArrayList<CustomerId> customerIds = new ArrayList<>();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        userServiceImpl.findUsersByCustomerIds(tenantId, customerIds, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link UserDao}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByCustomerIds(TenantId, List, PageLink)"})
  public void testFindUsersByCustomerIds_givenUserDao() {
    // Arrange
    ArrayList<CustomerId> customerIds = new ArrayList<>();

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findUsersByCustomerIds(
                ModelConstants.SYSTEM_TENANT, customerIds, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByCustomerIds(TenantId, List, PageLink)"})
  public void testFindUsersByCustomerIds_thenCallsFindUsersByCustomerIds() {
    // Arrange
    JpaUserDao userDao = mock(JpaUserDao.class);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(
            Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    ArrayList<CustomerId> customerIds = new ArrayList<>();

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        userServiceImpl.findUsersByCustomerIds(ModelConstants.SYSTEM_TENANT, customerIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then calls {@link UserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData UserServiceImpl.findUsersByCustomerIds(TenantId, List, PageLink)"})
  public void testFindUsersByCustomerIds_whenFirst_page_thenCallsFindUsersByCustomerIds() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(
            Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult =
        userServiceImpl.findUsersByCustomerIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#deleteCustomerUsers(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link UserDao#findCustomerUsers(UUID, UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#deleteCustomerUsers(TenantId, CustomerId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.deleteCustomerUsers(TenantId, CustomerId)"})
  public void testDeleteCustomerUsers_thenCallsFindCustomerUsers() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findCustomerUsers(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    userServiceImpl.deleteCustomerUsers(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(userDao).findCustomerUsers(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}.
   *
   * <p>Method under test: {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.setUserCredentialsEnabled(TenantId, UserId, boolean)"})
  public void testSetUserCredentialsEnabled() {
    // Arrange
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.setUserCredentialsEnabled(
                ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), false));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}.
   *
   * <p>Method under test: {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.setUserCredentialsEnabled(TenantId, UserId, boolean)"})
  public void testSetUserCredentialsEnabled2() {
    // Arrange
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());
    when(dataValidator2.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.setUserCredentialsEnabled(
                ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), false));
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}.
   *
   * <p>Method under test: {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.setUserCredentialsEnabled(TenantId, UserId, boolean)"})
  public void testSetUserCredentialsEnabled3() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.setUserCredentialsEnabled(ModelConstants.SYSTEM_TENANT, userId, true));
    verify(userId).getId();
  }

  /**
   * Test {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link UserId} {@link UserId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.setUserCredentialsEnabled(TenantId, UserId, boolean)"})
  public void testSetUserCredentialsEnabled_givenNull_uuid_whenUserIdGetIdReturnNull_uuid() {
    // Arrange
    JpaUserCredentialsDao userCredentialsDao = mock(JpaUserCredentialsDao.class);
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(new UserCredentials());
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());

    DataValidator<UserCredentials> userCredentialsValidator = mock(DataValidator.class);
    when(userCredentialsValidator.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<Object>any());
    JpaUserDao userDao = new JpaUserDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    userServiceImpl.setUserCredentialsEnabled(ModelConstants.SYSTEM_TENANT, userId, true);

    // Assert
    verify(eventPublisher).publishEvent(isA(Object.class));
    verify(userId, atLeast(1)).getId();
    verify(userCredentialsValidator).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationEventPublisher#publishEvent(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.setUserCredentialsEnabled(TenantId, UserId, boolean)"})
  public void testSetUserCredentialsEnabled_thenCallsPublishEvent() {
    // Arrange
    JpaUserCredentialsDao userCredentialsDao = mock(JpaUserCredentialsDao.class);
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(new UserCredentials());
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());

    DataValidator<UserCredentials> userCredentialsValidator = mock(DataValidator.class);
    when(userCredentialsValidator.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<Object>any());
    JpaUserDao userDao = new JpaUserDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    // Act
    userServiceImpl.setUserCredentialsEnabled(
        ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(eventPublisher).publishEvent(isA(Object.class));
    verify(userCredentialsValidator).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link UserCredentialsDao#save(TenantId, UserCredentials)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.setUserCredentialsEnabled(TenantId, UserId, boolean)"})
  public void testSetUserCredentialsEnabled_thenCallsSave() {
    // Arrange
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(new UserCredentials());
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());
    when(dataValidator2.validate(
            Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    // Act
    userServiceImpl.setUserCredentialsEnabled(
        ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), false);

    // Assert
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
  }

  /**
   * Test {@link UserServiceImpl#resetFailedLoginAttempts(TenantId, UserId)}.
   *
   * <p>Method under test: {@link UserServiceImpl#resetFailedLoginAttempts(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.resetFailedLoginAttempts(TenantId, UserId)"})
  public void testResetFailedLoginAttempts() {
    // Arrange
    doNothing()
        .when(userCredentialsDao)
        .setFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any(), anyInt());

    // Act
    userServiceImpl.resetFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(userCredentialsDao).setFailedLoginAttempts(isA(TenantId.class), isNull(), eq(0));
  }

  /**
   * Test {@link UserServiceImpl#resetFailedLoginAttempts(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#resetFailedLoginAttempts(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.resetFailedLoginAttempts(TenantId, UserId)"})
  public void testResetFailedLoginAttempts_thenThrowIncorrectParameterException() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(userCredentialsDao)
        .setFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any(), anyInt());

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.resetFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, null));
    verify(userCredentialsDao).setFailedLoginAttempts(isA(TenantId.class), isNull(), eq(0));
  }

  /**
   * Test {@link UserServiceImpl#saveMobileSession(TenantId, UserId, String, MobileSessionInfo)}.
   *
   * <p>Method under test: {@link UserServiceImpl#saveMobileSession(TenantId, UserId, String,
   * MobileSessionInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserServiceImpl.saveMobileSession(TenantId, UserId, String, MobileSessionInfo)"
  })
  public void testSaveMobileSession() {
    // Arrange
    when(userSettingsDao.findByTypeAndPath(
            Mockito.<TenantId>any(), Mockito.<UserSettingsType>any(), isA(String[].class)))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    MobileSessionInfo sessionInfo = new MobileSessionInfo();
    sessionInfo.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.saveMobileSession(
                ModelConstants.SYSTEM_TENANT, null, "ABC123", sessionInfo));
    verify(userSettingsDao)
        .findByTypeAndPath(isA(TenantId.class), eq(UserSettingsType.MOBILE), isA(String[].class));
  }

  /**
   * Test {@link UserServiceImpl#saveMobileSession(TenantId, UserId, String, MobileSessionInfo)}.
   *
   * <ul>
   *   <li>Then calls {@link UserSettingsService#findUserSettings(TenantId, UserId,
   *       UserSettingsType)}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#saveMobileSession(TenantId, UserId, String,
   * MobileSessionInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void UserServiceImpl.saveMobileSession(TenantId, UserId, String, MobileSessionInfo)"
  })
  public void testSaveMobileSession_thenCallsFindUserSettings() {
    // Arrange
    when(userSettingsService.findUserSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));
    when(userSettingsDao.findByTypeAndPath(
            Mockito.<TenantId>any(), Mockito.<UserSettingsType>any(), isA(String[].class)))
        .thenReturn(new ArrayList<>());

    MobileSessionInfo sessionInfo = new MobileSessionInfo();
    sessionInfo.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.saveMobileSession(
                ModelConstants.SYSTEM_TENANT, null, "ABC123", sessionInfo));
    verify(userSettingsDao)
        .findByTypeAndPath(isA(TenantId.class), eq(UserSettingsType.MOBILE), isA(String[].class));
    verify(userSettingsService)
        .findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
  }

  /**
   * Test {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Map UserServiceImpl.findMobileSessions(TenantId, UserId)"})
  public void testFindMobileSessions_thenThrowIncorrectParameterException() {
    // Arrange
    when(userSettingsService.findUserSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findMobileSessions(ModelConstants.SYSTEM_TENANT, null));
    verify(userSettingsService)
        .findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
  }

  /**
   * Test {@link UserServiceImpl#findMobileSession(TenantId, UserId, String)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findMobileSession(TenantId, UserId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileSessionInfo UserServiceImpl.findMobileSession(TenantId, UserId, String)"
  })
  public void testFindMobileSession_thenReturnNull() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any()))
        .thenReturn(userSettings);

    // Act
    MobileSessionInfo actualFindMobileSessionResult =
        userServiceImpl.findMobileSession(ModelConstants.SYSTEM_TENANT, null, "ABC123");

    // Assert
    verify(userSettingsService)
        .findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
    assertNull(actualFindMobileSessionResult);
  }

  /**
   * Test {@link UserServiceImpl#findMobileSession(TenantId, UserId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findMobileSession(TenantId, UserId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "MobileSessionInfo UserServiceImpl.findMobileSession(TenantId, UserId, String)"
  })
  public void testFindMobileSession_thenThrowIncorrectParameterException() {
    // Arrange
    when(userSettingsService.findUserSettings(
            Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findMobileSession(ModelConstants.SYSTEM_TENANT, null, "ABC123"));
    verify(userSettingsService)
        .findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
  }

  /**
   * Test {@link UserServiceImpl#removeMobileSession(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link UserSettingsDao} {@link UserSettingsDao#findByTypeAndPath(TenantId,
   *       UserSettingsType, String[])} return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#removeMobileSession(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.removeMobileSession(TenantId, String)"})
  public void testRemoveMobileSession_givenUserSettingsDaoFindByTypeAndPathReturnArrayList() {
    // Arrange
    when(userSettingsDao.findByTypeAndPath(
            Mockito.<TenantId>any(), Mockito.<UserSettingsType>any(), isA(String[].class)))
        .thenReturn(new ArrayList<>());

    // Act
    userServiceImpl.removeMobileSession(ModelConstants.SYSTEM_TENANT, "ABC123");

    // Assert
    verify(userSettingsDao)
        .findByTypeAndPath(isA(TenantId.class), eq(UserSettingsType.MOBILE), isA(String[].class));
  }

  /**
   * Test {@link UserServiceImpl#removeMobileSession(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#removeMobileSession(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void UserServiceImpl.removeMobileSession(TenantId, String)"})
  public void testRemoveMobileSession_thenThrowIncorrectParameterException() {
    // Arrange
    when(userSettingsDao.findByTypeAndPath(
            Mockito.<TenantId>any(), Mockito.<UserSettingsType>any(), isA(String[].class)))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.removeMobileSession(ModelConstants.SYSTEM_TENANT, "ABC123"));
    verify(userSettingsDao)
        .findByTypeAndPath(isA(TenantId.class), eq(UserSettingsType.MOBILE), isA(String[].class));
  }

  /**
   * Test {@link UserServiceImpl#increaseFailedLoginAttempts(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#increaseFailedLoginAttempts(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserServiceImpl.increaseFailedLoginAttempts(TenantId, UserId)"})
  public void testIncreaseFailedLoginAttempts_thenReturnOne() {
    // Arrange
    when(userCredentialsDao.incrementFailedLoginAttempts(
            Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(1);

    // Act
    int actualIncreaseFailedLoginAttemptsResult =
        userServiceImpl.increaseFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(userCredentialsDao).incrementFailedLoginAttempts(isA(TenantId.class), isNull());
    assertEquals(1, actualIncreaseFailedLoginAttemptsResult);
  }

  /**
   * Test {@link UserServiceImpl#increaseFailedLoginAttempts(TenantId, UserId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#increaseFailedLoginAttempts(TenantId, UserId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int UserServiceImpl.increaseFailedLoginAttempts(TenantId, UserId)"})
  public void testIncreaseFailedLoginAttempts_thenThrowIncorrectParameterException() {
    // Arrange
    when(userCredentialsDao.incrementFailedLoginAttempts(
            Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.increaseFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, null));
    verify(userCredentialsDao).incrementFailedLoginAttempts(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link UserServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional UserServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT, entityId));
    verify(entityId).getId();
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#findById(TenantId, UUID)} return {@link
   *       User#User()}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional UserServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenUserDaoFindByIdReturnUser_thenReturnPresent() {
    // Arrange
    User user = new User();
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        userServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(user, actualFindEntityResult.get());
  }

  /**
   * Test {@link UserServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional UserServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            userServiceImpl.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#countByTenantId(TenantId)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long UserServiceImpl.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenUserDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(userDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult =
        userServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(userDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link UserServiceImpl#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link UserServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long UserServiceImpl.countByTenantId(TenantId)"})
  public void testCountByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> userServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(userDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link UserServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link UserServiceImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType UserServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userServiceImpl =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    // Act and Assert
    assertEquals(EntityType.USER, userServiceImpl.getEntityType());
  }
}
