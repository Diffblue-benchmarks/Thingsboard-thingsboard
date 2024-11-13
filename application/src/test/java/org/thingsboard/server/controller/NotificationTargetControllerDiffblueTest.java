package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.targets.MicrosoftTeamsNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.UserListFilter;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.NotificationTargetDao;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTargetDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTargetRepository;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.user.UserDao;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.service.security.model.SecurityUser;

class NotificationTargetControllerDiffblueTest {
  /**
   * Test
   * {@link NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)}.
   * <ul>
   *   <li>Then calls {@link Dao#findById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)}
   */
  @Test
  @DisplayName("Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser); then calls findById(TenantId, UUID)")
  void testGetRecipientsForNotificationTargetConfig_thenCallsFindById() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserDao userDao = mock(UserDao.class);
    User user = new User();
    when(userDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(user);
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
    UserServiceImpl userService = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    NotificationTargetController notificationTargetController = new NotificationTargetController(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao,
            new JpaNotificationRuleDao(mock(NotificationRuleRepository.class)), userService));

    ArrayList<UUID> usersIds = new ArrayList<>();
    usersIds.add(UUID.randomUUID());

    UserListFilter usersFilter = new UserListFilter();
    usersFilter.setUsersIds(usersIds);

    PlatformUsersNotificationTargetConfig configuration = new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act
    PageData<User> actualRecipientsForNotificationTargetConfig = notificationTargetController
        .getRecipientsForNotificationTargetConfig(notificationTarget, 3, 1, new SecurityUser());

    // Assert
    verify(userDao).findById(isNull(), isA(UUID.class));
    List<User> data = actualRecipientsForNotificationTargetConfig.getData();
    assertEquals(1, data.size());
    assertEquals(1, actualRecipientsForNotificationTargetConfig.getTotalPages());
    assertEquals(1L, actualRecipientsForNotificationTargetConfig.getTotalElements());
    assertFalse(actualRecipientsForNotificationTargetConfig.hasNext());
    assertSame(user, data.get(0));
  }

  /**
   * Test
   * {@link NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)}.
   * <ul>
   *   <li>Then calls {@link UserService#findUserById(TenantId, UserId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)}
   */
  @Test
  @DisplayName("Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser); then calls findUserById(TenantId, UserId)")
  void testGetRecipientsForNotificationTargetConfig_thenCallsFindUserById() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserService userService = mock(UserService.class);
    User user = new User();
    when(userService.findUserById(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(user);
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    NotificationTargetController notificationTargetController = new NotificationTargetController(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao,
            new JpaNotificationRuleDao(mock(NotificationRuleRepository.class)), userService));

    ArrayList<UUID> usersIds = new ArrayList<>();
    usersIds.add(UUID.randomUUID());

    UserListFilter usersFilter = new UserListFilter();
    usersFilter.setUsersIds(usersIds);

    PlatformUsersNotificationTargetConfig configuration = new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act
    PageData<User> actualRecipientsForNotificationTargetConfig = notificationTargetController
        .getRecipientsForNotificationTargetConfig(notificationTarget, 3, 1, new SecurityUser());

    // Assert
    verify(userService).findUserById(isNull(), isA(UserId.class));
    List<User> data = actualRecipientsForNotificationTargetConfig.getData();
    assertEquals(1, data.size());
    assertEquals(1, actualRecipientsForNotificationTargetConfig.getTotalPages());
    assertEquals(1L, actualRecipientsForNotificationTargetConfig.getTotalElements());
    assertFalse(actualRecipientsForNotificationTargetConfig.hasNext());
    assertSame(user, data.get(0));
  }

  /**
   * Test
   * {@link NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)}
   */
  @Test
  @DisplayName("Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser); then throw IllegalArgumentException")
  void testGetRecipientsForNotificationTargetConfig_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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
    NotificationTargetController notificationTargetController = new NotificationTargetController(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
            new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
                securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
                new JpaExecutorService())));

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> notificationTargetController
        .getRecipientsForNotificationTargetConfig(notificationTarget, 3, 1, new SecurityUser()));
  }

  /**
   * Test
   * {@link NotificationTargetController#getNotificationTargetsByIds(UUID[], SecurityUser)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetController#getNotificationTargetsByIds(UUID[], SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTargetsByIds(UUID[], SecurityUser); then return Empty")
  void testGetNotificationTargetsByIds_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetDao notificationTargetDao = mock(NotificationTargetDao.class);
    when(notificationTargetDao.findByTenantIdAndIds(Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenReturn(new ArrayList<>());
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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
    NotificationTargetController notificationTargetController = new NotificationTargetController(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
            new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
                securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
                new JpaExecutorService())));

    // Act
    List<NotificationTarget> actualNotificationTargetsByIds = notificationTargetController
        .getNotificationTargetsByIds(new UUID[]{UUID.randomUUID()}, new SecurityUser());

    // Assert
    verify(notificationTargetDao).findByTenantIdAndIds(isNull(), isA(List.class));
    assertTrue(actualNotificationTargetsByIds.isEmpty());
  }

  /**
   * Test
   * {@link NotificationTargetController#getNotificationTargets(int, int, String, String, String, SecurityUser)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetController#getNotificationTargets(int, int, String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTargets(int, int, String, String, String, SecurityUser); then return EMPTY_PAGE_DATA")
  void testGetNotificationTargets_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetDao notificationTargetDao = mock(NotificationTargetDao.class);
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetDao.findByTenantIdAndPageLink(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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
    NotificationTargetController notificationTargetController = new NotificationTargetController(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
            new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
                securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
                new JpaExecutorService())));

    // Act
    PageData<NotificationTarget> actualNotificationTargets = notificationTargetController.getNotificationTargets(3, 1,
        "Text Search", "U", "asc", new SecurityUser());

    // Assert
    verify(notificationTargetDao).findByTenantIdAndPageLink(isNull(), isA(PageLink.class));
    assertSame(actualNotificationTargets.EMPTY_PAGE_DATA, actualNotificationTargets);
  }

  /**
   * Test
   * {@link NotificationTargetController#getNotificationTargets(int, int, String, String, String, SecurityUser)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetController#getNotificationTargets(int, int, String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTargets(int, int, String, String, String, SecurityUser); when empty string; then return EMPTY_PAGE_DATA")
  void testGetNotificationTargets_whenEmptyString_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetDao notificationTargetDao = mock(NotificationTargetDao.class);
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetDao.findByTenantIdAndPageLink(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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
    NotificationTargetController notificationTargetController = new NotificationTargetController(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
            new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
                securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
                new JpaExecutorService())));

    // Act
    PageData<NotificationTarget> actualNotificationTargets = notificationTargetController.getNotificationTargets(3, 1,
        "Text Search", "U", "", new SecurityUser());

    // Assert
    verify(notificationTargetDao).findByTenantIdAndPageLink(isNull(), isA(PageLink.class));
    assertSame(actualNotificationTargets.EMPTY_PAGE_DATA, actualNotificationTargets);
  }

  /**
   * Test
   * {@link NotificationTargetController#getNotificationTargetsBySupportedNotificationType(int, int, String, String, String, NotificationType, SecurityUser)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetController#getNotificationTargetsBySupportedNotificationType(int, int, String, String, String, NotificationType, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTargetsBySupportedNotificationType(int, int, String, String, String, NotificationType, SecurityUser); then return EMPTY_PAGE_DATA")
  void testGetNotificationTargetsBySupportedNotificationType_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetDao notificationTargetDao = mock(NotificationTargetDao.class);
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(Mockito.<TenantId>any(),
        Mockito.<NotificationType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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
    NotificationTargetController notificationTargetController = new NotificationTargetController(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
            new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
                securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
                new JpaExecutorService())));

    // Act
    PageData<NotificationTarget> actualNotificationTargetsBySupportedNotificationType = notificationTargetController
        .getNotificationTargetsBySupportedNotificationType(3, 1, "Text Search", "U", "asc", NotificationType.GENERAL,
            new SecurityUser());

    // Assert
    verify(notificationTargetDao).findByTenantIdAndSupportedNotificationTypeAndPageLink(isNull(),
        eq(NotificationType.GENERAL), isA(PageLink.class));
    assertSame(actualNotificationTargetsBySupportedNotificationType.EMPTY_PAGE_DATA,
        actualNotificationTargetsBySupportedNotificationType);
  }

  /**
   * Test
   * {@link NotificationTargetController#getNotificationTargetsBySupportedNotificationType(int, int, String, String, String, NotificationType, SecurityUser)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetController#getNotificationTargetsBySupportedNotificationType(int, int, String, String, String, NotificationType, SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTargetsBySupportedNotificationType(int, int, String, String, String, NotificationType, SecurityUser); then return EMPTY_PAGE_DATA")
  void testGetNotificationTargetsBySupportedNotificationType_thenReturnEmpty_page_data2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetDao notificationTargetDao = mock(NotificationTargetDao.class);
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetDao.findByTenantIdAndSupportedNotificationTypeAndPageLink(Mockito.<TenantId>any(),
        Mockito.<NotificationType>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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
    NotificationTargetController notificationTargetController = new NotificationTargetController(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
            new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
                securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
                new JpaExecutorService())));

    // Act
    PageData<NotificationTarget> actualNotificationTargetsBySupportedNotificationType = notificationTargetController
        .getNotificationTargetsBySupportedNotificationType(3, 1, "Text Search", "U", "", NotificationType.GENERAL,
            new SecurityUser());

    // Assert
    verify(notificationTargetDao).findByTenantIdAndSupportedNotificationTypeAndPageLink(isNull(),
        eq(NotificationType.GENERAL), isA(PageLink.class));
    assertSame(actualNotificationTargetsBySupportedNotificationType.EMPTY_PAGE_DATA,
        actualNotificationTargetsBySupportedNotificationType);
  }
}
