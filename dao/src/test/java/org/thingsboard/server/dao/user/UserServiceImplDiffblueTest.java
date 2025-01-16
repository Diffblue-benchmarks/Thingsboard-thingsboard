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
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.cache.user.UserCacheEvictEvent;
import org.thingsboard.server.cache.user.UserCacheKey;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UUIDBased;
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
import org.thingsboard.server.dao.TenantEntityDao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityCountService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
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

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {UserServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class UserServiceImplDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<User> dataValidator;

  @MockBean
  private DataValidator<UserCredentials> dataValidator2;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityCountService entityCountService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private SecuritySettingsService securitySettingsService;

  @MockBean
  private TbTransactionalCache<UserCacheKey, User> tbTransactionalCache;

  @MockBean
  private UserAuthSettingsDao userAuthSettingsDao;

  @MockBean
  private UserCredentialsDao userCredentialsDao;

  @MockBean
  private UserDao userDao;

  @Autowired
  private UserServiceImpl userServiceImpl;

  @MockBean
  private UserSettingsDao userSettingsDao;

  @MockBean
  private UserSettingsService userSettingsService;

  /**
   * Test {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)} with
   * {@code UserCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithUserCacheEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<UserCacheKey>>any());

    // Act
    userServiceImpl.handleEvictEvent(
        new UserCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org", "jane.doe@example.org"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)} with
   * {@code UserCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithUserCacheEvictEvent2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<UserCacheKey>>any());

    // Act
    userServiceImpl.handleEvictEvent(
        new UserCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "john.smith@example.org", "jane.doe@example.org"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)} with
   * {@code UserCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithUserCacheEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<UserCacheKey>>any());

    // Act
    userServiceImpl.handleEvictEvent(new UserCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org", ""));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)} with
   * {@code UserCacheEvictEvent}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#handleEvictEvent(UserCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithUserCacheEvictEvent_thenThrowIncorrectParameterException() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<UserCacheKey>>any());

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> userServiceImpl.handleEvictEvent(
        new UserCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org", "jane.doe@example.org")));
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link UserServiceImpl#findUserByEmail(TenantId, String)}.
   * <ul>
   *   <li>Given {@link UserDao} {@link UserDao#findByEmail(TenantId, String)}
   * return {@link User#User()}.</li>
   *   <li>Then return {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findUserByEmail(TenantId, String)}
   */
  @Test
  public void testFindUserByEmail_givenUserDaoFindByEmailReturnUser_thenReturnUser() {
    // Arrange
    User user = new User();
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(user);

    // Act
    User actualFindUserByEmailResult = userServiceImpl.findUserByEmail(ModelConstants.SYSTEM_TENANT,
        "jane.doe@example.org");

    // Assert
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
    assertSame(user, actualFindUserByEmailResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserByEmail(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findUserByEmail(TenantId, String)}
   */
  @Test
  public void testFindUserByEmail_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findUserByEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}
   */
  @Test
  public void testFindUserByTenantIdAndEmail_thenThrowIncorrectParameterException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<UserCacheKey>any(), Mockito.<Supplier<User>>any(),
        anyBoolean())).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findUserByTenantIdAndEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(UserCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserByTenantIdAndEmail(TenantId, String)}
   */
  @Test
  public void testFindUserByTenantIdAndEmail_whenSystem_tenant_thenReturnUser() {
    // Arrange
    User user = new User();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<UserCacheKey>any(), Mockito.<Supplier<User>>any(),
        anyBoolean())).thenReturn(user);

    // Act
    User actualFindUserByTenantIdAndEmailResult = userServiceImpl
        .findUserByTenantIdAndEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(UserCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(user, actualFindUserByTenantIdAndEmailResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findUserByTenantIdAndEmailAsync(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserByTenantIdAndEmailAsync(TenantId, String)}
   */
  @Test
  public void testFindUserByTenantIdAndEmailAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<User> actualFindUserByTenantIdAndEmailAsyncResult = userServiceImpl
        .findUserByTenantIdAndEmailAsync(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindUserByTenantIdAndEmailAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindUserByTenantIdAndEmailAsyncResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserById(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link UserId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findUserById(TenantId, UserId)}
   */
  @Test
  public void testFindUserById_givenNull_uuid_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    User user = new User();
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    User actualFindUserByIdResult = userServiceImpl.findUserById(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userId, atLeast(1)).getId();
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(user, actualFindUserByIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserById(TenantId, UserId)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findUserById(TenantId, UserId)}
   */
  @Test
  public void testFindUserById_whenUserIdWithIdIsNull_uuid_thenReturnUser() {
    // Arrange
    User user = new User();
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);

    // Act
    User actualFindUserByIdResult = userServiceImpl.findUserById(ModelConstants.SYSTEM_TENANT,
        new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(user, actualFindUserByIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserByIdAsync(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserByIdAsync(TenantId, UserId)}
   */
  @Test
  public void testFindUserByIdAsync_givenNull_uuid_thenCallsGetId() {
    // Arrange
    SettableFuture<User> createResult = SettableFuture.create();
    when(userDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<User> actualFindUserByIdAsyncResult = userServiceImpl
        .findUserByIdAsync(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userId, atLeast(1)).getId();
    verify(userDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindUserByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindUserByIdAsyncResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserByIdAsync(TenantId, UserId)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserByIdAsync(TenantId, UserId)}
   */
  @Test
  public void testFindUserByIdAsync_whenUserIdWithIdIsNull_uuid_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<User> createResult = SettableFuture.create();
    when(userDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<User> actualFindUserByIdAsyncResult = userServiceImpl
        .findUserByIdAsync(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindUserByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindUserByIdAsyncResult);
  }

  /**
   * Test {@link UserServiceImpl#saveUser(TenantId, User)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#saveUser(TenantId, User)}
   */
  @Test
  public void testSaveUser_thenThrowIncorrectParameterException() {
    // Arrange
    User user = mock(User.class);
    when(user.getEmail()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(dataValidator.validate(Mockito.<User>any(), Mockito.<Function<User, TenantId>>any())).thenReturn(user);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.saveUser(ModelConstants.SYSTEM_TENANT, new User()));
    verify(user).getEmail();
    verify(dataValidator).validate(isA(User.class), isA(Function.class));
  }

  /**
   * Test {@link UserServiceImpl#findUserCredentialsByUserId(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserCredentialsByUserId(TenantId, UserId)}
   */
  @Test
  public void testFindUserCredentialsByUserId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(userCredentials);
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    UserCredentials actualFindUserCredentialsByUserIdResult = userServiceImpl
        .findUserCredentialsByUserId(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userId, atLeast(1)).getId();
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
    assertSame(userCredentials, actualFindUserCredentialsByUserIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUserCredentialsByUserId(TenantId, UserId)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserCredentialsByUserId(TenantId, UserId)}
   */
  @Test
  public void testFindUserCredentialsByUserId_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(userCredentials);

    // Act
    UserCredentials actualFindUserCredentialsByUserIdResult = userServiceImpl
        .findUserCredentialsByUserId(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
    assertSame(userCredentials, actualFindUserCredentialsByUserIdResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findUserCredentialsByActivateToken(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link UserCredentials#UserCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserCredentialsByActivateToken(TenantId, String)}
   */
  @Test
  public void testFindUserCredentialsByActivateToken_thenReturnUserCredentials() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(userCredentials);

    // Act
    UserCredentials actualFindUserCredentialsByActivateTokenResult = userServiceImpl
        .findUserCredentialsByActivateToken(ModelConstants.SYSTEM_TENANT, "ABC123");

    // Assert
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
    assertSame(userCredentials, actualFindUserCredentialsByActivateTokenResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findUserCredentialsByActivateToken(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserCredentialsByActivateToken(TenantId, String)}
   */
  @Test
  public void testFindUserCredentialsByActivateToken_thenThrowIncorrectParameterException() {
    // Arrange
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findUserCredentialsByActivateToken(ModelConstants.SYSTEM_TENANT, "ABC123"));
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test
   * {@link UserServiceImpl#findUserCredentialsByResetToken(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link UserCredentials#UserCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserCredentialsByResetToken(TenantId, String)}
   */
  @Test
  public void testFindUserCredentialsByResetToken_thenReturnUserCredentials() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.findByResetToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(userCredentials);

    // Act
    UserCredentials actualFindUserCredentialsByResetTokenResult = userServiceImpl
        .findUserCredentialsByResetToken(ModelConstants.SYSTEM_TENANT, "ABC123");

    // Assert
    verify(userCredentialsDao).findByResetToken(isA(TenantId.class), eq("ABC123"));
    assertSame(userCredentials, actualFindUserCredentialsByResetTokenResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findUserCredentialsByResetToken(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUserCredentialsByResetToken(TenantId, String)}
   */
  @Test
  public void testFindUserCredentialsByResetToken_thenThrowIncorrectParameterException() {
    // Arrange
    when(userCredentialsDao.findByResetToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findUserCredentialsByResetToken(ModelConstants.SYSTEM_TENANT, "ABC123"));
    verify(userCredentialsDao).findByResetToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}.
   * <ul>
   *   <li>Then return {@link UserCredentials#UserCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  public void testSaveUserCredentials_thenReturnUserCredentials() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any())).thenReturn(userCredentials);
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    // Act
    UserCredentials actualSaveUserCredentialsResult = userServiceImpl.saveUserCredentials(ModelConstants.SYSTEM_TENANT,
        new UserCredentials());

    // Assert
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    assertSame(userCredentials, actualSaveUserCredentialsResult);
  }

  /**
   * Test {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#saveUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  public void testSaveUserCredentials_thenThrowIncorrectParameterException() {
    // Arrange
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.saveUserCredentials(ModelConstants.SYSTEM_TENANT, new UserCredentials()));
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}.
   * <p>
   * Method under test:
   * {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}
   */
  @Test
  public void testActivateUserCredentials() {
    // Arrange
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new UserCredentials());

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.activateUserCredentials(ModelConstants.SYSTEM_TENANT, "ABC123", "iloveyou"));
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test
   * {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}.
   * <ul>
   *   <li>Given {@link UserCredentialsDao}
   * {@link UserCredentialsDao#findByActivateToken(TenantId, String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}
   */
  @Test
  public void testActivateUserCredentials_givenUserCredentialsDaoFindByActivateTokenReturnNull() {
    // Arrange
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.activateUserCredentials(ModelConstants.SYSTEM_TENANT, "ABC123", "iloveyou"));
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test
   * {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}.
   * <ul>
   *   <li>Then calls {@link UserCredentials#isEnabled()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}
   */
  @Test
  public void testActivateUserCredentials_thenCallsIsEnabled() {
    // Arrange
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(userCredentials);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.activateUserCredentials(ModelConstants.SYSTEM_TENANT, "ABC123", "iloveyou"));
    verify(userCredentials).isEnabled();
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test
   * {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}.
   * <ul>
   *   <li>Then throw {@link DisabledException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#activateUserCredentials(TenantId, String, String)}
   */
  @Test
  public void testActivateUserCredentials_thenThrowDisabledException() {
    // Arrange
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled())
        .thenThrow(new DisabledException("Executing activateUserCredentials activateToken [{}], password [{}]"));
    when(userCredentialsDao.findByActivateToken(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(userCredentials);

    // Act and Assert
    assertThrows(DisabledException.class,
        () -> userServiceImpl.activateUserCredentials(ModelConstants.SYSTEM_TENANT, "ABC123", "iloveyou"));
    verify(userCredentials).isEnabled();
    verify(userCredentialsDao).findByActivateToken(isA(TenantId.class), eq("ABC123"));
  }

  /**
   * Test {@link UserServiceImpl#requestPasswordReset(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link DisabledException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#requestPasswordReset(TenantId, String)}
   */
  @Test
  public void testRequestPasswordReset_thenThrowDisabledException() {
    // Arrange
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(new User());
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());

    // Act and Assert
    assertThrows(DisabledException.class,
        () -> userServiceImpl.requestPasswordReset(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isNull());
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test {@link UserServiceImpl#requestPasswordReset(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#requestPasswordReset(TenantId, String)}
   */
  @Test
  public void testRequestPasswordReset_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(new User());
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.requestPasswordReset(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isNull());
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test {@link UserServiceImpl#requestPasswordReset(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link UsernameNotFoundException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#requestPasswordReset(TenantId, String)}
   */
  @Test
  public void testRequestPasswordReset_thenThrowUsernameNotFoundException() {
    // Arrange
    when(userDao.findByEmail(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(UsernameNotFoundException.class,
        () -> userServiceImpl.requestPasswordReset(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org"));
    verify(userDao).findByEmail(isA(TenantId.class), eq("jane.doe@example.org"));
  }

  /**
   * Test
   * {@link UserServiceImpl#requestExpiredPasswordReset(TenantId, UserCredentialsId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#requestExpiredPasswordReset(TenantId, UserCredentialsId)}
   */
  @Test
  public void testRequestExpiredPasswordReset_thenThrowIncorrectParameterException() {
    // Arrange
    when(userCredentialsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new UserCredentials());

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> userServiceImpl
        .requestExpiredPasswordReset(ModelConstants.SYSTEM_TENANT, new UserCredentialsId(ModelConstants.NULL_UUID)));
    verify(userCredentialsDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link UserServiceImpl#generatePasswordResetToken(UserCredentials)}.
   * <ul>
   *   <li>Then return {@link UserCredentials#UserCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#generatePasswordResetToken(UserCredentials)}
   */
  @Test
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
    UserCredentials actualGeneratePasswordResetTokenResult = userServiceImpl
        .generatePasswordResetToken(userCredentials);

    // Assert
    verify(securitySettingsService).getSecuritySettings();
    assertSame(userCredentials, actualGeneratePasswordResetTokenResult);
  }

  /**
   * Test {@link UserServiceImpl#generatePasswordResetToken(UserCredentials)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#generatePasswordResetToken(UserCredentials)}
   */
  @Test
  public void testGeneratePasswordResetToken_thenThrowIncorrectParameterException() {
    // Arrange
    when(securitySettingsService.getSecuritySettings()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.generatePasswordResetToken(new UserCredentials()));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test {@link UserServiceImpl#generateUserActivationToken(UserCredentials)}.
   * <ul>
   *   <li>Then return {@link UserCredentials#UserCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#generateUserActivationToken(UserCredentials)}
   */
  @Test
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
    UserCredentials actualGenerateUserActivationTokenResult = userServiceImpl
        .generateUserActivationToken(userCredentials);

    // Assert
    verify(securitySettingsService).getSecuritySettings();
    assertSame(userCredentials, actualGenerateUserActivationTokenResult);
  }

  /**
   * Test {@link UserServiceImpl#generateUserActivationToken(UserCredentials)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#generateUserActivationToken(UserCredentials)}
   */
  @Test
  public void testGenerateUserActivationToken_thenThrowIncorrectParameterException() {
    // Arrange
    when(securitySettingsService.getSecuritySettings()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.generateUserActivationToken(new UserCredentials()));
    verify(securitySettingsService).getSecuritySettings();
  }

  /**
   * Test
   * {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   * <p>
   * Method under test:
   * {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  public void testReplaceUserCredentials() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any())).thenReturn(userCredentials);
    doNothing().when(userCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());
    UserCredentials userCredentials2 = new UserCredentials(new UserCredentialsId(ModelConstants.NULL_UUID));

    // Act
    userServiceImpl.replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials2);

    // Assert
    verify(userCredentialsDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    assertEquals(userCredentials, userCredentials2);
  }

  /**
   * Test
   * {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   * <ul>
   *   <li>Given {@code iloveyou}.</li>
   *   <li>Then return AdditionalInfo is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  public void testReplaceUserCredentials_givenIloveyou_thenReturnAdditionalInfoIsNull() throws IOException {
    // Arrange
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(new UserCredentials());
    doNothing().when(userCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setPassword("iloveyou");

    // Act
    UserCredentials actualReplaceUserCredentialsResult = userServiceImpl
        .replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials);

    // Assert
    verify(userCredentialsDao).removeById(isA(TenantId.class), isNull());
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    JsonNode additionalInfo = userCredentials.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    JsonNode nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonParser traverseResult = nextResult2.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = additionalInfo.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    assertEquals("\"iloveyou\"", nextResult2.toPrettyString());
    Version versionResult = traverseResult3.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    assertNull(actualReplaceUserCredentialsResult.getAdditionalInfo());
    assertNull(actualReplaceUserCredentialsResult.getFailedLoginAttempts());
    assertNull(actualReplaceUserCredentialsResult.getActivateTokenExpTime());
    assertNull(actualReplaceUserCredentialsResult.getLastLoginTs());
    assertNull(actualReplaceUserCredentialsResult.getResetTokenExpTime());
    JsonLocation currentLocation = traverseResult3.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertNull(actualReplaceUserCredentialsResult.getActivateToken());
    assertNull(actualReplaceUserCredentialsResult.getPassword());
    assertNull(actualReplaceUserCredentialsResult.getResetToken());
    assertNull(userCredentials.getUuidId());
    assertNull(actualReplaceUserCredentialsResult.getUuidId());
    assertNull(userCredentials.getId());
    assertNull(actualReplaceUserCredentialsResult.getId());
    assertNull(actualReplaceUserCredentialsResult.getUserId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult3.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(0L, actualReplaceUserCredentialsResult.getCreatedTime());
    assertEquals(0L, actualReplaceUserCredentialsResult.getActivationTokenTtl());
    assertEquals(0L, actualReplaceUserCredentialsResult.getResetTokenTtl());
    assertEquals(1, nextResult.size());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult2.isArray());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult2.isBinary());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(nextResult2.isBoolean());
    assertFalse(nextResult.isBoolean());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult2.isDouble());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(nextResult.isEmpty());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult2.isFloat());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult2.isInt());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult2.isLong());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult2.isNull());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult2.isNumber());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult2.isPojo());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult2.isShort());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(nextResult.isValueNode());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult2.iterator().hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(actualReplaceUserCredentialsResult.isEnabled());
    assertTrue(nextResult.isContainerNode());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult2.isEmpty());
    assertTrue(nextResult.isObject());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult2.isValueNode());
    assertTrue(actualReplaceUserCredentialsResult.isActivationTokenExpired());
    assertTrue(actualReplaceUserCredentialsResult.isResetTokenExpired());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
  }

  /**
   * Test
   * {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   * <ul>
   *   <li>Given {@link UserCredentialsDao}
   * {@link UserCredentialsDao#save(TenantId, UserCredentials)} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  public void testReplaceUserCredentials_givenUserCredentialsDaoSaveReturnNull_thenReturnNull() throws IOException {
    // Arrange
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any())).thenReturn(null);
    doNothing().when(userCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setPassword("iloveyou");

    // Act
    UserCredentials actualReplaceUserCredentialsResult = userServiceImpl
        .replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials);

    // Assert
    verify(userCredentialsDao).removeById(isA(TenantId.class), isNull());
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    JsonNode additionalInfo = userCredentials.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof ObjectNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult2 = nextResult.iterator();
    JsonNode nextResult2 = iteratorResult2.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonParser traverseResult = nextResult2.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = nextResult.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonParser traverseResult3 = additionalInfo.traverse();
    assertTrue(traverseResult3 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    JsonStreamContext parsingContext3 = traverseResult3.getParsingContext();
    assertEquals("ROOT", parsingContext3.getTypeDesc());
    assertEquals("\"iloveyou\"", nextResult2.toPrettyString());
    Version versionResult = traverseResult3.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult3.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult3.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult3.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult3.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult3.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    assertNull(traverseResult3.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult3.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult3.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult3.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult3.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult3.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(traverseResult3.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(parsingContext3.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult3.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult3.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(traverseResult3.getValueAsString());
    assertNull(userCredentials.getUuidId());
    assertNull(userCredentials.getId());
    assertNull(actualReplaceUserCredentialsResult);
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult3.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult3.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult3.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult3.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, traverseResult3.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext3.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext3.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, parsingContext3.getNestingDepth());
    assertEquals(0, nextResult2.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult3.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(0L, traverseResult3.getValueAsLong());
    assertEquals(1, nextResult.size());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.OBJECT, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult3.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult3.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult3.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult3.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult3.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult3.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult3.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(traverseResult3.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext3.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext3.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(parsingContext3.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult2.isArray());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult2.isBigDecimal());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult2.isBigInteger());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult2.isBinary());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(nextResult2.isBoolean());
    assertFalse(nextResult.isBoolean());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult2.isContainerNode());
    assertFalse(nextResult2.isDouble());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(nextResult.isEmpty());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult2.isFloat());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult2.isFloatingPointNumber());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult2.isInt());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult2.isIntegralNumber());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult2.isLong());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult2.isMissingNode());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult2.isNull());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult2.isNumber());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult2.isObject());
    assertFalse(nextResult2.isPojo());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult2.isShort());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(nextResult.isValueNode());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult2.iterator().hasNext());
    assertFalse(iteratorResult2.hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isContainerNode());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult2.isEmpty());
    assertTrue(nextResult.isObject());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult2.isValueNode());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult2.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(currentLocation, traverseResult3.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(versionResult, traverseResult2.version());
  }

  /**
   * Test
   * {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  public void testReplaceUserCredentials_thenThrowIncorrectParameterException() {
    // Arrange
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.replaceUserCredentials(ModelConstants.SYSTEM_TENANT, new UserCredentials()));
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
  }

  /**
   * Test
   * {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}.
   * <ul>
   *   <li>When {@link UserCredentials#UserCredentials()}.</li>
   *   <li>Then {@link UserCredentials#UserCredentials()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#replaceUserCredentials(TenantId, UserCredentials)}
   */
  @Test
  public void testReplaceUserCredentials_whenUserCredentials_thenUserCredentials() {
    // Arrange
    UserCredentials userCredentials = new UserCredentials();
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any())).thenReturn(userCredentials);
    doNothing().when(userCredentialsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());
    UserCredentials userCredentials2 = new UserCredentials();

    // Act
    UserCredentials actualReplaceUserCredentialsResult = userServiceImpl
        .replaceUserCredentials(ModelConstants.SYSTEM_TENANT, userCredentials2);

    // Assert
    verify(userCredentialsDao).removeById(isA(TenantId.class), isNull());
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
    assertEquals(userCredentials, userCredentials2);
    assertSame(userCredentials, actualReplaceUserCredentialsResult);
  }

  /**
   * Test {@link UserServiceImpl#deleteUser(TenantId, User)} with
   * {@code tenantId}, {@code user}.
   * <ul>
   *   <li>Given {@link UserId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#deleteUser(TenantId, User)}
   */
  @Test
  public void testDeleteUserWithTenantIdUser_givenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<UserCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(userDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(userCredentialsDao).removeByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any());
    doNothing().when(userAuthSettingsDao).removeByUserId(Mockito.<UserId>any());
    doNothing().when(userSettingsDao).removeByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);
    User user = mock(User.class);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user.getId()).thenReturn(userId);

    // Act
    userServiceImpl.deleteUser(ModelConstants.SYSTEM_TENANT, user);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(user).getEmail();
    verify(user).getId();
    verify(user).getTenantId();
    verify(userId, atLeast(1)).getId();
    verify(userDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.USER));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(userAuthSettingsDao).removeByUserId(isA(UserId.class));
    verify(userCredentialsDao).removeByUserId(isA(TenantId.class), isA(UserId.class));
    verify(userSettingsDao).removeByUserId(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteUser(TenantId, User)} with
   * {@code tenantId}, {@code user}.
   * <ul>
   *   <li>Then calls
   * {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#deleteUser(TenantId, User)}
   */
  @Test
  public void testDeleteUserWithTenantIdUser_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<UserCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(userDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(userCredentialsDao).removeByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any());
    doNothing().when(userAuthSettingsDao).removeByUserId(Mockito.<UserId>any());
    doNothing().when(userSettingsDao).removeByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    User user = mock(User.class);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user.getId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act
    userServiceImpl.deleteUser(ModelConstants.SYSTEM_TENANT, user);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(user).getEmail();
    verify(user).getId();
    verify(user).getTenantId();
    verify(userDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.USER));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(userAuthSettingsDao).removeByUserId(isA(UserId.class));
    verify(userCredentialsDao).removeByUserId(isA(TenantId.class), isA(UserId.class));
    verify(userSettingsDao).removeByUserId(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteUser(TenantId, User)} with
   * {@code tenantId}, {@code user}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#deleteUser(TenantId, User)}
   */
  @Test
  public void testDeleteUserWithTenantIdUser_thenThrowIncorrectParameterException() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<UserCacheKey>>any());
    doNothing().when(userDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(userCredentialsDao).removeByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any());
    doNothing().when(userAuthSettingsDao).removeByUserId(Mockito.<UserId>any());
    doNothing().when(userSettingsDao).removeByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any());
    doThrow(new IncorrectParameterException("An error occurred")).when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    User user = mock(User.class);
    when(user.getEmail()).thenReturn("jane.doe@example.org");
    when(user.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(user.getId()).thenReturn(new UserId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.deleteUser(ModelConstants.SYSTEM_TENANT, user));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(user).getEmail();
    verify(user).getId();
    verify(user).getTenantId();
    verify(userDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.USER));
    verify(userAuthSettingsDao).removeByUserId(isA(UserId.class));
    verify(userCredentialsDao).removeByUserId(isA(TenantId.class), isA(UserId.class));
    verify(userSettingsDao).removeByUserId(isA(TenantId.class), isA(UserId.class));
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link DisabledException#DisabledException(String)} with
   * {@code Msg}.</li>
   *   <li>Then throw {@link DisabledException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindUsersByTenantId_givenDisabledExceptionWithMsg_thenThrowDisabledException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DisabledException("Msg"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DisabledException.class,
        () -> userServiceImpl.findUsersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindUsersByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<User> actualFindUsersByTenantIdResult = userServiceImpl.findUsersByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindUsersByTenantIdResult.EMPTY_PAGE_DATA, actualFindUsersByTenantIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is empty string and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindUsersByTenantId_givenSortOrderWithPropertyIsEmptyStringAndDirectionIsAsc() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<User> actualFindUsersByTenantIdResult = userServiceImpl.findUsersByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindUsersByTenantIdResult.EMPTY_PAGE_DATA, actualFindUsersByTenantIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindUsersByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findUsersByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindUsersByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindUsersByTenantIdResult = userServiceImpl.findUsersByTenantId(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindUsersByTenantIdResult.EMPTY_PAGE_DATA, actualFindUsersByTenantIdResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link DisabledException#DisabledException(String)} with
   * {@code Msg}.</li>
   *   <li>Then throw {@link DisabledException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantAdmins_givenDisabledExceptionWithMsg_thenThrowDisabledException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DisabledException("Msg"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DisabledException.class,
        () -> userServiceImpl.findTenantAdmins(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantAdmins_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findTenantAdmins(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<User> actualFindTenantAdminsResult = userServiceImpl.findTenantAdmins(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindTenantAdminsResult.EMPTY_PAGE_DATA, actualFindTenantAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is empty string and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantAdmins_givenSortOrderWithPropertyIsEmptyStringAndDirectionIsAsc() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findTenantAdmins(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<User> actualFindTenantAdminsResult = userServiceImpl.findTenantAdmins(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindTenantAdminsResult.EMPTY_PAGE_DATA, actualFindTenantAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantAdmins_thenThrowIncorrectParameterException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findTenantAdmins(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantAdmins_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findTenantAdmins(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindTenantAdminsResult = userServiceImpl.findTenantAdmins(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindTenantAdminsResult.EMPTY_PAGE_DATA, actualFindTenantAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findSysAdmins(PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findSysAdmins(PageLink)}
   */
  @Test
  public void testFindSysAdmins_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findAllByAuthority(Mockito.<Authority>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindSysAdminsResult = userServiceImpl.findSysAdmins(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(PageLink.class));
    assertSame(actualFindSysAdminsResult.EMPTY_PAGE_DATA, actualFindSysAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findSysAdmins(PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findSysAdmins(PageLink)}
   */
  @Test
  public void testFindSysAdmins_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findAllByAuthority(Mockito.<Authority>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findSysAdmins(BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findAllTenantAdmins(PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findAllTenantAdmins(PageLink)}
   */
  @Test
  public void testFindAllTenantAdmins_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findAllByAuthority(Mockito.<Authority>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindAllTenantAdminsResult = userServiceImpl
        .findAllTenantAdmins(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findAllByAuthority(eq(Authority.TENANT_ADMIN), isA(PageLink.class));
    assertSame(actualFindAllTenantAdminsResult.EMPTY_PAGE_DATA, actualFindAllTenantAdminsResult);
  }

  /**
   * Test {@link UserServiceImpl#findAllTenantAdmins(PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findAllTenantAdmins(PageLink)}
   */
  @Test
  public void testFindAllTenantAdmins_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findAllByAuthority(Mockito.<Authority>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findAllTenantAdmins(BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findAllByAuthority(eq(Authority.TENANT_ADMIN), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}
   */
  @Test
  public void testFindTenantAdminsByTenantsIds_givenSystem_tenant() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByAuthorityAndTenantsIds(Mockito.<Authority>any(), Mockito.<List<TenantId>>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    ArrayList<TenantId> tenantsIds = new ArrayList<>();
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<User> actualFindTenantAdminsByTenantsIdsResult = userServiceImpl.findTenantAdminsByTenantsIds(tenantsIds,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findByAuthorityAndTenantsIds(eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
    assertSame(actualFindTenantAdminsByTenantsIdsResult.EMPTY_PAGE_DATA, actualFindTenantAdminsByTenantsIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}
   */
  @Test
  public void testFindTenantAdminsByTenantsIds_givenSystem_tenant2() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByAuthorityAndTenantsIds(Mockito.<Authority>any(), Mockito.<List<TenantId>>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    ArrayList<TenantId> tenantsIds = new ArrayList<>();
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<User> actualFindTenantAdminsByTenantsIdsResult = userServiceImpl.findTenantAdminsByTenantsIds(tenantsIds,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findByAuthorityAndTenantsIds(eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
    assertSame(actualFindTenantAdminsByTenantsIdsResult.EMPTY_PAGE_DATA, actualFindTenantAdminsByTenantsIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}
   */
  @Test
  public void testFindTenantAdminsByTenantsIds_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByAuthorityAndTenantsIds(Mockito.<Authority>any(), Mockito.<List<TenantId>>any(),
        Mockito.<PageLink>any())).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findTenantAdminsByTenantsIds(new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findByAuthorityAndTenantsIds(eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdminsByTenantsIds(List, PageLink)}
   */
  @Test
  public void testFindTenantAdminsByTenantsIds_whenArrayList_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByAuthorityAndTenantsIds(Mockito.<Authority>any(), Mockito.<List<TenantId>>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindTenantAdminsByTenantsIdsResult = userServiceImpl
        .findTenantAdminsByTenantsIds(new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findByAuthorityAndTenantsIds(eq(Authority.TENANT_ADMIN), isA(List.class), isA(PageLink.class));
    assertSame(actualFindTenantAdminsByTenantsIdsResult.EMPTY_PAGE_DATA, actualFindTenantAdminsByTenantsIdsResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findTenantAdminsByTenantProfilesIds(List, PageLink)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdminsByTenantProfilesIds(List, PageLink)}
   */
  @Test
  public void testFindTenantAdminsByTenantProfilesIds_givenNull_whenArrayListAddNull() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByAuthorityAndTenantProfilesIds(Mockito.<Authority>any(), Mockito.<List<TenantProfileId>>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    ArrayList<TenantProfileId> tenantProfilesIds = new ArrayList<>();
    tenantProfilesIds.add(null);

    // Act
    PageData<User> actualFindTenantAdminsByTenantProfilesIdsResult = userServiceImpl
        .findTenantAdminsByTenantProfilesIds(tenantProfilesIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findByAuthorityAndTenantProfilesIds(eq(Authority.TENANT_ADMIN), isA(List.class),
        isA(PageLink.class));
    assertSame(actualFindTenantAdminsByTenantProfilesIdsResult.EMPTY_PAGE_DATA,
        actualFindTenantAdminsByTenantProfilesIdsResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findTenantAdminsByTenantProfilesIds(List, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdminsByTenantProfilesIds(List, PageLink)}
   */
  @Test
  public void testFindTenantAdminsByTenantProfilesIds_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByAuthorityAndTenantProfilesIds(Mockito.<Authority>any(), Mockito.<List<TenantProfileId>>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindTenantAdminsByTenantProfilesIdsResult = userServiceImpl
        .findTenantAdminsByTenantProfilesIds(new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findByAuthorityAndTenantProfilesIds(eq(Authority.TENANT_ADMIN), isA(List.class),
        isA(PageLink.class));
    assertSame(actualFindTenantAdminsByTenantProfilesIdsResult.EMPTY_PAGE_DATA,
        actualFindTenantAdminsByTenantProfilesIdsResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findTenantAdminsByTenantProfilesIds(List, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findTenantAdminsByTenantProfilesIds(List, PageLink)}
   */
  @Test
  public void testFindTenantAdminsByTenantProfilesIds_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByAuthorityAndTenantProfilesIds(Mockito.<Authority>any(), Mockito.<List<TenantProfileId>>any(),
        Mockito.<PageLink>any())).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> userServiceImpl
        .findTenantAdminsByTenantProfilesIds(new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findByAuthorityAndTenantProfilesIds(eq(Authority.TENANT_ADMIN), isA(List.class),
        isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#findAllUsers(PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findAllUsers(PageLink)}
   */
  @Test
  public void testFindAllUsers_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findAll(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindAllUsersResult = userServiceImpl.findAllUsers(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findAll(isA(PageLink.class));
    assertSame(actualFindAllUsersResult.EMPTY_PAGE_DATA, actualFindAllUsersResult);
  }

  /**
   * Test {@link UserServiceImpl#findAllUsers(PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findAllUsers(PageLink)}
   */
  @Test
  public void testFindAllUsers_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findAll(Mockito.<PageLink>any())).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findAllUsers(BaseRelatedEdgesService.FIRST_PAGE));
    verify(userDao).findAll(isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteTenantAdmins(TenantId)}.
   * <ul>
   *   <li>Then calls {@link UserDao#findTenantAdmins(UUID, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#deleteTenantAdmins(TenantId)}
   */
  @Test
  public void testDeleteTenantAdmins_thenCallsFindTenantAdmins() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findTenantAdmins(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    userServiceImpl.deleteTenantAdmins(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteAllByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link UserDao#findByTenantId(UUID, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#deleteAllByTenantId(TenantId)}
   */
  @Test
  public void testDeleteAllByTenantId_thenCallsFindByTenantId() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    userServiceImpl.deleteAllByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteAllByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#deleteAllByTenantId(TenantId)}
   */
  @Test
  public void testDeleteAllByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.deleteAllByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link UserDao#findByTenantId(UUID, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenCallsFindByTenantId() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    userServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link UserServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.findByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(userDao).findByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindCustomerUsers_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findCustomerUsers(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<User> actualFindCustomerUsersResult = userServiceImpl.findCustomerUsers(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findCustomerUsers(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindCustomerUsersResult.EMPTY_PAGE_DATA, actualFindCustomerUsersResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is empty string and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindCustomerUsers_givenSortOrderWithPropertyIsEmptyStringAndDirectionIsAsc() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findCustomerUsers(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<User> actualFindCustomerUsersResult = userServiceImpl.findCustomerUsers(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findCustomerUsers(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindCustomerUsersResult.EMPTY_PAGE_DATA, actualFindCustomerUsersResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindCustomerUsers_thenThrowIncorrectParameterException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> userServiceImpl
        .findCustomerUsers(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findCustomerUsers(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindCustomerUsers_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findCustomerUsers(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindCustomerUsersResult = userServiceImpl.findCustomerUsers(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findCustomerUsers(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindCustomerUsersResult.EMPTY_PAGE_DATA, actualFindCustomerUsersResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    ArrayList<CustomerId> customerIds = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = userServiceImpl
        .findUsersByCustomerIds(ModelConstants.SYSTEM_TENANT, customerIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(actualFindUsersByCustomerIdsResult.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds_givenNull_customer_id() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<CustomerId> customerIds = new ArrayList<>();
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = userServiceImpl
        .findUsersByCustomerIds(ModelConstants.SYSTEM_TENANT, customerIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(actualFindUsersByCustomerIdsResult.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds_givenNull_customer_id2() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<CustomerId> customerIds = new ArrayList<>();
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = userServiceImpl
        .findUsersByCustomerIds(ModelConstants.SYSTEM_TENANT, customerIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(actualFindUsersByCustomerIdsResult.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    ArrayList<CustomerId> customerIds = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = userServiceImpl
        .findUsersByCustomerIds(ModelConstants.SYSTEM_TENANT, customerIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(actualFindUsersByCustomerIdsResult.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds_thenThrowIncorrectParameterException() {
    // Arrange
    ArrayList<CustomerId> customerIds = new ArrayList<>();
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new IncorrectParameterException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findUsersByCustomerIds(ModelConstants.SYSTEM_TENANT, customerIds, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findUsersByCustomerIds(TenantId, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findUsersByCustomerIds(Mockito.<UUID>any(), Mockito.<List<CustomerId>>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = userServiceImpl
        .findUsersByCustomerIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userDao).findUsersByCustomerIds(isA(UUID.class), isA(List.class), isA(PageLink.class));
    assertSame(actualFindUsersByCustomerIdsResult.EMPTY_PAGE_DATA, actualFindUsersByCustomerIdsResult);
  }

  /**
   * Test {@link UserServiceImpl#deleteCustomerUsers(TenantId, CustomerId)}.
   * <ul>
   *   <li>Then calls {@link UserDao#findCustomerUsers(UUID, UUID, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#deleteCustomerUsers(TenantId, CustomerId)}
   */
  @Test
  public void testDeleteCustomerUsers_thenCallsFindCustomerUsers() {
    // Arrange
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userDao.findCustomerUsers(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    userServiceImpl.deleteCustomerUsers(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(userDao).findCustomerUsers(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}
   */
  @Test
  public void testSetUserCredentialsEnabled_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(new UserCredentials());
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    userServiceImpl.setUserCredentialsEnabled(ModelConstants.SYSTEM_TENANT, userId, true);

    // Assert
    verify(userId, atLeast(1)).getId();
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
  }

  /**
   * Test
   * {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}
   */
  @Test
  public void testSetUserCredentialsEnabled_givenNull_uuid_whenFalse_thenCallsGetId() {
    // Arrange
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(new UserCredentials());
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    userServiceImpl.setUserCredentialsEnabled(ModelConstants.SYSTEM_TENANT, userId, false);

    // Assert
    verify(userId, atLeast(1)).getId();
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
  }

  /**
   * Test
   * {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}
   */
  @Test
  public void testSetUserCredentialsEnabled_thenThrowIncorrectParameterException() {
    // Arrange
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> userServiceImpl
        .setUserCredentialsEnabled(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), true));
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls
   * {@link UserCredentialsDao#save(TenantId, UserCredentials)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#setUserCredentialsEnabled(TenantId, UserId, boolean)}
   */
  @Test
  public void testSetUserCredentialsEnabled_whenUserIdWithIdIsNull_uuid_thenCallsSave() {
    // Arrange
    when(userCredentialsDao.save(Mockito.<TenantId>any(), Mockito.<UserCredentials>any()))
        .thenReturn(new UserCredentials());
    when(userCredentialsDao.findByUserId(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new UserCredentials());
    when(dataValidator2.validate(Mockito.<UserCredentials>any(), Mockito.<Function<UserCredentials, TenantId>>any()))
        .thenReturn(new UserCredentials());

    // Act
    userServiceImpl.setUserCredentialsEnabled(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), true);

    // Assert
    verify(dataValidator2).validate(isA(UserCredentials.class), isA(Function.class));
    verify(userCredentialsDao).findByUserId(isA(TenantId.class), isA(UUID.class));
    verify(userCredentialsDao).save(isA(TenantId.class), isA(UserCredentials.class));
  }

  /**
   * Test {@link UserServiceImpl#resetFailedLoginAttempts(TenantId, UserId)}.
   * <p>
   * Method under test:
   * {@link UserServiceImpl#resetFailedLoginAttempts(TenantId, UserId)}
   */
  @Test
  public void testResetFailedLoginAttempts() {
    // Arrange
    doNothing().when(userCredentialsDao)
        .setFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any(), anyInt());

    // Act
    userServiceImpl.resetFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, null);

    // Assert that nothing has changed
    verify(userCredentialsDao).setFailedLoginAttempts(isA(TenantId.class), isNull(), eq(0));
  }

  /**
   * Test {@link UserServiceImpl#resetFailedLoginAttempts(TenantId, UserId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#resetFailedLoginAttempts(TenantId, UserId)}
   */
  @Test
  public void testResetFailedLoginAttempts_thenThrowIncorrectParameterException() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred")).when(userCredentialsDao)
        .setFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any(), anyInt());

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.resetFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, null));
    verify(userCredentialsDao).setFailedLoginAttempts(isA(TenantId.class), isNull(), eq(0));
  }

  /**
   * Test
   * {@link UserServiceImpl#saveMobileSession(TenantId, UserId, String, MobileSessionInfo)}.
   * <ul>
   *   <li>Then calls {@link UserSettings#getSettings()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#saveMobileSession(TenantId, UserId, String, MobileSessionInfo)}
   */
  @Test
  public void testSaveMobileSession_thenCallsGetSettings() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(null);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);
    doNothing().when(userSettingsService)
        .updateUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<UserSettingsType>any(),
            Mockito.<JsonNode>any());
    when(userSettingsDao.findByTypeAndPath(Mockito.<TenantId>any(), Mockito.<UserSettingsType>any(),
        isA(String[].class))).thenReturn(new ArrayList<>());

    MobileSessionInfo sessionInfo = new MobileSessionInfo();
    sessionInfo.setFcmTokenTimestamp(1L);

    // Act
    userServiceImpl.saveMobileSession(ModelConstants.SYSTEM_TENANT, null, "ABC123", sessionInfo);

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsDao).findByTypeAndPath(isA(TenantId.class), eq(UserSettingsType.MOBILE), isA(String[].class));
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
    verify(userSettingsService).updateUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE),
        isA(JsonNode.class));
  }

  /**
   * Test
   * {@link UserServiceImpl#saveMobileSession(TenantId, UserId, String, MobileSessionInfo)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#saveMobileSession(TenantId, UserId, String, MobileSessionInfo)}
   */
  @Test
  public void testSaveMobileSession_thenThrowIncorrectParameterException() throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsDao.findByTypeAndPath(Mockito.<TenantId>any(), Mockito.<UserSettingsType>any(),
        isA(String[].class))).thenThrow(new IncorrectParameterException("An error occurred"));

    MobileSessionInfo sessionInfo = new MobileSessionInfo();
    sessionInfo.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.saveMobileSession(ModelConstants.SYSTEM_TENANT, null, "ABC123", sessionInfo));
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsDao).findByTypeAndPath(isA(TenantId.class), eq(UserSettingsType.MOBILE), isA(String[].class));
  }

  /**
   * Test {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_ARRAY}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}
   */
  @Test
  public void testFindMobileSessions_givenArrayNodeAsTokenReturnEndArray_thenReturnEmpty()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_ARRAY);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(arrayNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    Map<String, MobileSessionInfo> actualFindMobileSessionsResult = userServiceImpl
        .findMobileSessions(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
    assertTrue(actualFindMobileSessionsResult.isEmpty());
  }

  /**
   * Test {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}
   */
  @Test
  public void testFindMobileSessions_givenArrayNodeAsTokenReturnEndObject_thenReturnEmpty()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_OBJECT);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(arrayNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    Map<String, MobileSessionInfo> actualFindMobileSessionsResult = userServiceImpl
        .findMobileSessions(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
    assertTrue(actualFindMobileSessionsResult.isEmpty());
  }

  /**
   * Test {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code START_OBJECT}.</li>
   *   <li>Then calls {@link JsonNode#fields()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}
   */
  @Test
  public void testFindMobileSessions_givenArrayNodeAsTokenReturnStartObject_thenCallsFields()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);

    ArrayList<Map.Entry<String, JsonNode>> entryList = new ArrayList<>();
    when(arrayNode.fields()).thenReturn(entryList.iterator());
    when(arrayNode.asToken()).thenReturn(JsonToken.START_OBJECT);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(arrayNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    Map<String, MobileSessionInfo> actualFindMobileSessionsResult = userServiceImpl
        .findMobileSessions(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(arrayNode).fields();
    verify(arrayNode, atLeast(1)).asToken();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
    assertTrue(actualFindMobileSessionsResult.isEmpty());
  }

  /**
   * Test {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}
   */
  @Test
  public void testFindMobileSessions_givenUserSettingsGetSettingsReturnNull_thenReturnEmpty()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(null);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    Map<String, MobileSessionInfo> actualFindMobileSessionsResult = userServiceImpl
        .findMobileSessions(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
    assertTrue(actualFindMobileSessionsResult.isEmpty());
  }

  /**
   * Test {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findMobileSessions(TenantId, UserId)}
   */
  @Test
  public void testFindMobileSessions_thenThrowIncorrectParameterException() throws UnsupportedEncodingException {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.elements()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(arrayNode.asToken()).thenReturn(JsonToken.START_ARRAY);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(arrayNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.findMobileSessions(ModelConstants.SYSTEM_TENANT, null));
    verify(arrayNode, atLeast(1)).asToken();
    verify(arrayNode).elements();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
  }

  /**
   * Test {@link UserServiceImpl#findMobileSession(TenantId, UserId, String)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_ARRAY}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findMobileSession(TenantId, UserId, String)}
   */
  @Test
  public void testFindMobileSession_givenArrayNodeAsTokenReturnEndArray_thenCallsAsToken()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_ARRAY);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(arrayNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    MobileSessionInfo actualFindMobileSessionResult = userServiceImpl.findMobileSession(ModelConstants.SYSTEM_TENANT,
        null, "ABC123");

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
    assertNull(actualFindMobileSessionResult);
  }

  /**
   * Test {@link UserServiceImpl#findMobileSession(TenantId, UserId, String)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link ArrayNode#asToken()} return
   * {@code END_OBJECT}.</li>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findMobileSession(TenantId, UserId, String)}
   */
  @Test
  public void testFindMobileSession_givenArrayNodeAsTokenReturnEndObject_thenCallsAsToken()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenReturn(JsonToken.END_OBJECT);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(arrayNode);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    MobileSessionInfo actualFindMobileSessionResult = userServiceImpl.findMobileSession(ModelConstants.SYSTEM_TENANT,
        null, "ABC123");

    // Assert
    verify(arrayNode, atLeast(1)).asToken();
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
    assertNull(actualFindMobileSessionResult);
  }

  /**
   * Test {@link UserServiceImpl#findMobileSession(TenantId, UserId, String)}.
   * <ul>
   *   <li>Given {@link UserSettings} {@link UserSettings#getSettings()} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#findMobileSession(TenantId, UserId, String)}
   */
  @Test
  public void testFindMobileSession_givenUserSettingsGetSettingsReturnNull_thenReturnNull()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(null);
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.findUserSettings(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<UserSettingsType>any())).thenReturn(userSettings);

    // Act
    MobileSessionInfo actualFindMobileSessionResult = userServiceImpl.findMobileSession(ModelConstants.SYSTEM_TENANT,
        null, "ABC123");

    // Assert
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsService).findUserSettings(isA(TenantId.class), isNull(), eq(UserSettingsType.MOBILE));
    assertNull(actualFindMobileSessionResult);
  }

  /**
   * Test {@link UserServiceImpl#removeMobileSession(TenantId, String)}.
   * <p>
   * Method under test:
   * {@link UserServiceImpl#removeMobileSession(TenantId, String)}
   */
  @Test
  public void testRemoveMobileSession() {
    // Arrange
    when(userSettingsDao.findByTypeAndPath(Mockito.<TenantId>any(), Mockito.<UserSettingsType>any(),
        isA(String[].class))).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.removeMobileSession(ModelConstants.SYSTEM_TENANT, "ABC123"));
    verify(userSettingsDao).findByTypeAndPath(isA(TenantId.class), eq(UserSettingsType.MOBILE), isA(String[].class));
  }

  /**
   * Test {@link UserServiceImpl#removeMobileSession(TenantId, String)}.
   * <p>
   * Method under test:
   * {@link UserServiceImpl#removeMobileSession(TenantId, String)}
   */
  @Test
  public void testRemoveMobileSession2() {
    // Arrange
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.get(Mockito.<String>any())).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    UserSettings userSettings = mock(UserSettings.class);
    when(userSettings.getSettings()).thenReturn(jsonNode);
    doNothing().when(userSettings).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings).setType(Mockito.<UserSettingsType>any());
    doNothing().when(userSettings).setUserId(Mockito.<UserId>any());
    userSettings.setSettingsBytes(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);

    ArrayList<UserSettings> userSettingsList = new ArrayList<>();
    userSettingsList.add(userSettings);
    when(userSettingsDao.findByTypeAndPath(Mockito.<TenantId>any(), Mockito.<UserSettingsType>any(),
        isA(String[].class))).thenReturn(userSettingsList);

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.removeMobileSession(ModelConstants.SYSTEM_TENANT, "ABC123"));
    verify(jsonNode).get(eq("sessions"));
    verify(userSettings).getSettings();
    verify(userSettings).setSettingsBytes(isA(byte[].class));
    verify(userSettings).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings).setUserId(isNull());
    verify(userSettingsDao).findByTypeAndPath(isA(TenantId.class), eq(UserSettingsType.MOBILE), isA(String[].class));
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test {@link UserServiceImpl#removeMobileSession(TenantId, String)}.
   * <ul>
   *   <li>Given {@link UserSettingsService}.</li>
   *   <li>Then calls
   * {@link UserSettingsDao#findByTypeAndPath(TenantId, UserSettingsType, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#removeMobileSession(TenantId, String)}
   */
  @Test
  public void testRemoveMobileSession_givenUserSettingsService_thenCallsFindByTypeAndPath() {
    // Arrange
    when(userSettingsDao.findByTypeAndPath(Mockito.<TenantId>any(), Mockito.<UserSettingsType>any(),
        isA(String[].class))).thenReturn(new ArrayList<>());

    // Act
    userServiceImpl.removeMobileSession(ModelConstants.SYSTEM_TENANT, "ABC123");

    // Assert
    verify(userSettingsDao).findByTypeAndPath(isA(TenantId.class), eq(UserSettingsType.MOBILE), isA(String[].class));
  }

  /**
   * Test {@link UserServiceImpl#removeMobileSession(TenantId, String)}.
   * <ul>
   *   <li>Given {@link UserSettings} (default constructor) SettingsBytes is
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#removeMobileSession(TenantId, String)}
   */
  @Test
  public void testRemoveMobileSession_givenUserSettingsSettingsBytesIsAxaxaxaxBytesIsUtf8()
      throws UnsupportedEncodingException {
    // Arrange
    UserSettings userSettings = new UserSettings();
    userSettings.setSettingsBytes("AXAXAXAX".getBytes("UTF-8"));
    userSettings.setType(UserSettingsType.GENERAL);
    userSettings.setUserId(null);
    when(userSettingsService.saveUserSettings(Mockito.<TenantId>any(), Mockito.<UserSettings>any()))
        .thenReturn(userSettings);
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.get(Mockito.<String>any())).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    UserSettings userSettings2 = mock(UserSettings.class);
    when(userSettings2.getSettings()).thenReturn(jsonNode);
    doNothing().when(userSettings2).setSettingsBytes(Mockito.<byte[]>any());
    doNothing().when(userSettings2).setType(Mockito.<UserSettingsType>any());
    doNothing().when(userSettings2).setUserId(Mockito.<UserId>any());
    userSettings2.setSettingsBytes(new byte[]{'A', 2, 'A', 2, 'A', 2, 'A', 2});
    userSettings2.setType(UserSettingsType.GENERAL);
    userSettings2.setUserId(null);

    ArrayList<UserSettings> userSettingsList = new ArrayList<>();
    userSettingsList.add(userSettings2);
    when(userSettingsDao.findByTypeAndPath(Mockito.<TenantId>any(), Mockito.<UserSettingsType>any(),
        isA(String[].class))).thenReturn(userSettingsList);

    // Act
    userServiceImpl.removeMobileSession(ModelConstants.SYSTEM_TENANT, "ABC123");

    // Assert
    verify(jsonNode).get(eq("sessions"));
    verify(userSettings2).getSettings();
    verify(userSettings2).setSettingsBytes(isA(byte[].class));
    verify(userSettings2).setType(eq(UserSettingsType.GENERAL));
    verify(userSettings2).setUserId(isNull());
    verify(userSettingsDao).findByTypeAndPath(isA(TenantId.class), eq(UserSettingsType.MOBILE), isA(String[].class));
    verify(userSettingsService).saveUserSettings(isA(TenantId.class), isA(UserSettings.class));
  }

  /**
   * Test {@link UserServiceImpl#increaseFailedLoginAttempts(TenantId, UserId)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#increaseFailedLoginAttempts(TenantId, UserId)}
   */
  @Test
  public void testIncreaseFailedLoginAttempts_thenReturnOne() {
    // Arrange
    when(userCredentialsDao.incrementFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(1);

    // Act
    int actualIncreaseFailedLoginAttemptsResult = userServiceImpl
        .increaseFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(userCredentialsDao).incrementFailedLoginAttempts(isA(TenantId.class), isNull());
    assertEquals(1, actualIncreaseFailedLoginAttemptsResult);
  }

  /**
   * Test {@link UserServiceImpl#increaseFailedLoginAttempts(TenantId, UserId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link UserServiceImpl#increaseFailedLoginAttempts(TenantId, UserId)}
   */
  @Test
  public void testIncreaseFailedLoginAttempts_thenThrowIncorrectParameterException() {
    // Arrange
    when(userCredentialsDao.incrementFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.increaseFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, null));
    verify(userCredentialsDao).incrementFailedLoginAttempts(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link UserServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    User user = new User();
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = userServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(user, actualFindEntityResult.get());
  }

  /**
   * Test {@link UserServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    User user = new User();
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);

    // Act
    Optional<HasId<?>> actualFindEntityResult = userServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(userDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(user, actualFindEntityResult.get());
  }

  /**
   * Test {@link UserServiceImpl#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link UserDao} {@link TenantEntityDao#countByTenantId(TenantId)}
   * return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_givenUserDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(userDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult = userServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(userDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link UserServiceImpl#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UserServiceImpl#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_thenThrowIncorrectParameterException() {
    // Arrange
    when(userDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(IncorrectParameterException.class,
        () -> userServiceImpl.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(userDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link UserServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link UserServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    // Act and Assert
    assertEquals(EntityType.USER,
        (new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService())).getEntityType());
  }
}
