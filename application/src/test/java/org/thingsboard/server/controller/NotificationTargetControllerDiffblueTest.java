package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.targets.MicrosoftTeamsNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetType;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.TenantAdministratorsFilter;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.NotificationTargetService;
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
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.service.security.model.SecurityUser;

@ExtendWith(MockitoExtension.class)
class NotificationTargetControllerDiffblueTest {
  @InjectMocks private NotificationTargetController notificationTargetController;

  @Mock private NotificationTargetService notificationTargetService;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link NotificationTargetController#saveNotificationTarget(NotificationTarget,
   * SecurityUser)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetController#saveNotificationTarget(NotificationTarget, SecurityUser)}
   */
  @Test
  @DisplayName("Test saveNotificationTarget(NotificationTarget, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget NotificationTargetController.saveNotificationTarget(NotificationTarget, SecurityUser)"
  })
  void testSaveNotificationTarget() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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

    UserServiceImpl userService =
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

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);

    NotificationTargetId notificationTargetId = mock(NotificationTargetId.class);
    when(notificationTargetId.getId()).thenThrow(new IllegalArgumentException());

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig configuration =
        new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = new NotificationTarget(new NotificationTarget());
    notificationTarget.setId(notificationTargetId);
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationTargetController.saveNotificationTarget(
                notificationTarget, new SecurityUser()));
    verify(notificationTargetId).getId();
  }

  /**
   * Test {@link NotificationTargetController#saveNotificationTarget(NotificationTarget,
   * SecurityUser)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetController#saveNotificationTarget(NotificationTarget, SecurityUser)}
   */
  @Test
  @DisplayName("Test saveNotificationTarget(NotificationTarget, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget NotificationTargetController.saveNotificationTarget(NotificationTarget, SecurityUser)"
  })
  void testSaveNotificationTarget2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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

    UserServiceImpl userService =
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

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);

    NotificationTargetId notificationTargetId = mock(NotificationTargetId.class);
    when(notificationTargetId.getEntityType()).thenThrow(new IllegalArgumentException());
    when(notificationTargetId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig configuration =
        new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = new NotificationTarget(new NotificationTarget());
    notificationTarget.setId(notificationTargetId);
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationTargetController.saveNotificationTarget(
                notificationTarget, new SecurityUser()));
    verify(notificationTargetId).getEntityType();
    verify(notificationTargetId).getId();
  }

  /**
   * Test {@link NotificationTargetController#saveNotificationTarget(NotificationTarget,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Given {@link NotificationTargetId} {@link NotificationTargetId#getEntityType()} return
   *       {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#saveNotificationTarget(NotificationTarget, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test saveNotificationTarget(NotificationTarget, SecurityUser); given NotificationTargetId getEntityType() return 'TENANT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget NotificationTargetController.saveNotificationTarget(NotificationTarget, SecurityUser)"
  })
  void testSaveNotificationTarget_givenNotificationTargetIdGetEntityTypeReturnTenant()
      throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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

    UserServiceImpl userService =
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

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);

    NotificationTargetId notificationTargetId = mock(NotificationTargetId.class);
    when(notificationTargetId.getEntityType()).thenReturn(EntityType.TENANT);
    when(notificationTargetId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig configuration =
        new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = new NotificationTarget(new NotificationTarget());
    notificationTarget.setId(notificationTargetId);
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationTargetController.saveNotificationTarget(
                notificationTarget, new SecurityUser()));
    verify(notificationTargetId).getEntityType();
    verify(notificationTargetId, atLeast(1)).getId();
  }

  /**
   * Test {@link NotificationTargetController#saveNotificationTarget(NotificationTarget,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Given {@link NotificationTargetId} {@link NotificationTargetId#getId()} return
   *       randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#saveNotificationTarget(NotificationTarget, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test saveNotificationTarget(NotificationTarget, SecurityUser); given NotificationTargetId getId() return randomUUID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget NotificationTargetController.saveNotificationTarget(NotificationTarget, SecurityUser)"
  })
  void testSaveNotificationTarget_givenNotificationTargetIdGetIdReturnRandomUUID()
      throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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

    UserServiceImpl userService =
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

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);

    NotificationTargetId notificationTargetId = mock(NotificationTargetId.class);
    when(notificationTargetId.getEntityType()).thenReturn(EntityType.TENANT);
    when(notificationTargetId.getId()).thenReturn(UUID.randomUUID());

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig configuration =
        new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = new NotificationTarget(new NotificationTarget());
    notificationTarget.setId(notificationTargetId);
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationTargetController.saveNotificationTarget(
                notificationTarget, new SecurityUser()));
    verify(notificationTargetId).getEntityType();
    verify(notificationTargetId, atLeast(1)).getId();
  }

  /**
   * Test {@link NotificationTargetController#saveNotificationTarget(NotificationTarget,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>Given {@link NotificationTargetId#NotificationTargetId(UUID)} with id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#saveNotificationTarget(NotificationTarget, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test saveNotificationTarget(NotificationTarget, SecurityUser); given NotificationTargetId(UUID) with id is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget NotificationTargetController.saveNotificationTarget(NotificationTarget, SecurityUser)"
  })
  void testSaveNotificationTarget_givenNotificationTargetIdWithIdIsNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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

    UserServiceImpl userService =
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

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig configuration =
        new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = new NotificationTarget(new NotificationTarget());
    notificationTarget.setId(new NotificationTargetId(null));
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationTargetController.saveNotificationTarget(
                notificationTarget, new SecurityUser()));
  }

  /**
   * Test {@link NotificationTargetController#saveNotificationTarget(NotificationTarget,
   * SecurityUser)}.
   *
   * <ul>
   *   <li>When {@link NotificationTarget#NotificationTarget()}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#saveNotificationTarget(NotificationTarget, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test saveNotificationTarget(NotificationTarget, SecurityUser); when NotificationTarget(); then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget NotificationTargetController.saveNotificationTarget(NotificationTarget, SecurityUser)"
  })
  void testSaveNotificationTarget_whenNotificationTarget_thenThrowThingsboardException()
      throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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

    UserServiceImpl userService =
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

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);
    NotificationTarget notificationTarget = new NotificationTarget();

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationTargetController.saveNotificationTarget(
                notificationTarget, new SecurityUser()));
  }

  /**
   * Test {@link NotificationTargetController#getNotificationTargetById(UUID)}.
   *
   * <p>Method under test: {@link NotificationTargetController#getNotificationTargetById(UUID)}
   */
  @Test
  @DisplayName("Test getNotificationTargetById(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "NotificationTarget NotificationTargetController.getNotificationTargetById(UUID)"
  })
  void testGetNotificationTargetById() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/target/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)"
  })
  void testGetRecipientsForNotificationTargetConfig() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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

    UserServiceImpl userService =
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

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            notificationTargetController.getRecipientsForNotificationTargetConfig(
                notificationTarget, 3, 1, new SecurityUser()));
  }

  /**
   * Test {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)"
  })
  void testGetRecipientsForNotificationTargetConfig2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultNotificationTargetService notificationTargetService =
        mock(DefaultNotificationTargetService.class);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetService.findRecipientsForNotificationTargetConfig(
            Mockito.<TenantId>any(),
            Mockito.<PlatformUsersNotificationTargetConfig>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    doNothing().when(notificationTarget).setConfiguration(Mockito.<NotificationTargetConfig>any());
    notificationTarget.setConfiguration(mock(MicrosoftTeamsNotificationTargetConfig.class));

    SecurityUser user = mock(SecurityUser.class);
    when(user.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(user.isSystemAdmin()).thenReturn(false);

    // Act
    PageData<User> actualRecipientsForNotificationTargetConfig =
        notificationTargetController.getRecipientsForNotificationTargetConfig(
            notificationTarget, 3, 1, user);

    // Assert
    verify(user).getTenantId();
    verify(user).isSystemAdmin();
    verify(notificationTarget, atLeast(1)).getConfiguration();
    verify(notificationTarget).setConfiguration(isA(NotificationTargetConfig.class));
    verify(notificationTargetService)
        .findRecipientsForNotificationTargetConfig(
            isA(TenantId.class),
            isA(PlatformUsersNotificationTargetConfig.class),
            isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualRecipientsForNotificationTargetConfig);
  }

  /**
   * Test {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)"
  })
  void testGetRecipientsForNotificationTargetConfig3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    when(notificationTargetService.findRecipientsForNotificationTargetConfig(
            Mockito.<TenantId>any(),
            Mockito.<PlatformUsersNotificationTargetConfig>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new IllegalArgumentException());

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig configuration =
        new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = new NotificationTarget(new NotificationTarget());
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            notificationTargetController.getRecipientsForNotificationTargetConfig(
                notificationTarget, 3, 1, new SecurityUser()));
    verify(notificationTargetService)
        .findRecipientsForNotificationTargetConfig(
            isNull(), isA(PlatformUsersNotificationTargetConfig.class), isA(PageLink.class));
  }

  /**
   * Test {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}.
   *
   * <ul>
   *   <li>Then calls {@link UserDao#findTenantAdmins(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser); then calls findTenantAdmins(UUID, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)"
  })
  void testGetRecipientsForNotificationTargetConfig_thenCallsFindTenantAdmins()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    UserDao userDao = mock(UserDao.class);
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

    UserServiceImpl userService =
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
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    doNothing().when(notificationTarget).setConfiguration(Mockito.<NotificationTargetConfig>any());
    notificationTarget.setConfiguration(mock(MicrosoftTeamsNotificationTargetConfig.class));

    SecurityUser user = mock(SecurityUser.class);
    when(user.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(user.isSystemAdmin()).thenReturn(true);

    // Act
    PageData<User> actualRecipientsForNotificationTargetConfig =
        notificationTargetController.getRecipientsForNotificationTargetConfig(
            notificationTarget, 3, 1, user);

    // Assert
    verify(user).getTenantId();
    verify(user).isSystemAdmin();
    verify(notificationTarget, atLeast(1)).getConfiguration();
    verify(notificationTarget).setConfiguration(isA(NotificationTargetConfig.class));
    verify(userDao).findTenantAdmins(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualRecipientsForNotificationTargetConfig);
  }

  /**
   * Test {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}.
   *
   * <ul>
   *   <li>Then calls {@link UserServiceImpl#findTenantAdmins(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser); then calls findTenantAdmins(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)"
  })
  void testGetRecipientsForNotificationTargetConfig_thenCallsFindTenantAdmins2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    UserServiceImpl userService = mock(UserServiceImpl.class);
    PageData<User> emptyPageDataResult = PageData.emptyPageData();
    when(userService.findTenantAdmins(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    doNothing().when(notificationTarget).setConfiguration(Mockito.<NotificationTargetConfig>any());
    notificationTarget.setConfiguration(mock(MicrosoftTeamsNotificationTargetConfig.class));

    SecurityUser user = mock(SecurityUser.class);
    when(user.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(user.isSystemAdmin()).thenReturn(true);

    // Act
    PageData<User> actualRecipientsForNotificationTargetConfig =
        notificationTargetController.getRecipientsForNotificationTargetConfig(
            notificationTarget, 3, 1, user);

    // Assert
    verify(user).getTenantId();
    verify(user).isSystemAdmin();
    verify(notificationTarget, atLeast(1)).getConfiguration();
    verify(notificationTarget).setConfiguration(isA(NotificationTargetConfig.class));
    verify(userService).findTenantAdmins(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualRecipientsForNotificationTargetConfig);
  }

  /**
   * Test {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}.
   *
   * <ul>
   *   <li>Then calls {@link MicrosoftTeamsNotificationTargetConfig#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser); then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)"
  })
  void testGetRecipientsForNotificationTargetConfig_thenCallsGetType() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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

    UserServiceImpl userService =
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

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(notificationTargetService);

    MicrosoftTeamsNotificationTargetConfig configuration =
        mock(MicrosoftTeamsNotificationTargetConfig.class);
    when(configuration.getType()).thenReturn(NotificationTargetType.PLATFORM_USERS);

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    SecurityUser user = mock(SecurityUser.class);
    when(user.getTenantId()).thenThrow(new IllegalArgumentException());
    when(user.isSystemAdmin()).thenReturn(true);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            notificationTargetController.getRecipientsForNotificationTargetConfig(
                notificationTarget, 3, 1, user));
    verify(user).getTenantId();
    verify(user).isSystemAdmin();
    verify(configuration).getType();
  }

  /**
   * Test {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}.
   *
   * <ul>
   *   <li>Then throw {@link AccessDeniedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser); then throw AccessDeniedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)"
  })
  void testGetRecipientsForNotificationTargetConfig_thenThrowAccessDeniedException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(mock(DefaultNotificationTargetService.class));

    HashSet<UUID> tenantsIds = new HashSet<>();
    tenantsIds.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(tenantsIds);
    usersFilter.setTenantProfilesIds(new HashSet<>());

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    doNothing().when(notificationTarget).setConfiguration(Mockito.<NotificationTargetConfig>any());
    notificationTarget.setConfiguration(mock(MicrosoftTeamsNotificationTargetConfig.class));

    SecurityUser user = mock(SecurityUser.class);
    when(user.isSystemAdmin()).thenReturn(false);

    // Act and Assert
    assertThrows(
        AccessDeniedException.class,
        () ->
            notificationTargetController.getRecipientsForNotificationTargetConfig(
                notificationTarget, 3, 1, user));
    verify(user).isSystemAdmin();
    verify(notificationTarget).getConfiguration();
    verify(notificationTarget).setConfiguration(isA(NotificationTargetConfig.class));
  }

  /**
   * Test {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}.
   *
   * <ul>
   *   <li>Then throw {@link AccessDeniedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#getRecipientsForNotificationTargetConfig(NotificationTarget, int,
   * int, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser); then throw AccessDeniedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getRecipientsForNotificationTargetConfig(NotificationTarget, int, int, SecurityUser)"
  })
  void testGetRecipientsForNotificationTargetConfig_thenThrowAccessDeniedException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    NotificationTargetController notificationTargetController =
        new NotificationTargetController(mock(DefaultNotificationTargetService.class));

    HashSet<UUID> tenantProfilesIds = new HashSet<>();
    tenantProfilesIds.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    TenantAdministratorsFilter usersFilter = new TenantAdministratorsFilter();
    usersFilter.setTenantsIds(new HashSet<>());
    usersFilter.setTenantProfilesIds(tenantProfilesIds);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig =
        new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription(
        "The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(usersFilter);

    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getConfiguration()).thenReturn(platformUsersNotificationTargetConfig);
    doNothing().when(notificationTarget).setConfiguration(Mockito.<NotificationTargetConfig>any());
    notificationTarget.setConfiguration(mock(MicrosoftTeamsNotificationTargetConfig.class));

    SecurityUser user = mock(SecurityUser.class);
    when(user.isSystemAdmin()).thenReturn(false);

    // Act and Assert
    assertThrows(
        AccessDeniedException.class,
        () ->
            notificationTargetController.getRecipientsForNotificationTargetConfig(
                notificationTarget, 3, 1, user));
    verify(user).isSystemAdmin();
    verify(notificationTarget).getConfiguration();
    verify(notificationTarget).setConfiguration(isA(NotificationTargetConfig.class));
  }

  /**
   * Test {@link NotificationTargetController#getNotificationTargetsByIds(UUID[], SecurityUser)}.
   *
   * <ul>
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetController#getNotificationTargetsByIds(UUID[],
   * SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTargetsByIds(UUID[], SecurityUser); then status four hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List NotificationTargetController.getNotificationTargetsByIds(UUID[], SecurityUser)"
  })
  void testGetNotificationTargetsByIds_thenStatusFourHundred() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/notification/targets");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param(
            "ids",
            String.valueOf(new UUID[] {UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")}));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link NotificationTargetController#getNotificationTargetsByIds(UUID[], SecurityUser)}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetController#getNotificationTargetsByIds(UUID[],
   * SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationTargetsByIds(UUID[], SecurityUser); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List NotificationTargetController.getNotificationTargetsByIds(UUID[], SecurityUser)"
  })
  void testGetNotificationTargetsByIds_thenStatusFourHundredSix() throws Exception {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndIds(
            Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/notification/targets");
    getResult.accept("Media Types");

    MockHttpServletRequestBuilder requestBuilder = getResult.param("ids", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link NotificationTargetController#getNotificationTargetsByIds(UUID[], SecurityUser)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetController#getNotificationTargetsByIds(UUID[],
   * SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTargetsByIds(UUID[], SecurityUser); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List NotificationTargetController.getNotificationTargetsByIds(UUID[], SecurityUser)"
  })
  void testGetNotificationTargetsByIds_thenStatusIsOk() throws Exception {
    // Arrange
    when(notificationTargetService.findNotificationTargetsByTenantIdAndIds(
            Mockito.<TenantId>any(), Mockito.<List<NotificationTargetId>>any()))
        .thenReturn(new ArrayList<>());

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/targets").param("ids", "");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(content().string("[]"));
  }

  /**
   * Test {@link NotificationTargetController#getNotificationTargets(int, int, String, String,
   * String, SecurityUser)}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetController#getNotificationTargets(int, int,
   * String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationTargets(int, int, String, String, String, SecurityUser); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getNotificationTargets(int, int, String, String, String, SecurityUser)"
  })
  void testGetNotificationTargets_thenStatusFourHundredSix() throws Exception {
    // Arrange
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetService.findNotificationTargetsByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/notification/targets");
    getResult.accept("Media Types");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("page", String.valueOf(1)).param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link NotificationTargetController#getNotificationTargets(int, int, String, String,
   * String, SecurityUser)}.
   *
   * <ul>
   *   <li>When {@code foo}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetController#getNotificationTargets(int, int,
   * String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationTargets(int, int, String, String, String, SecurityUser); when 'foo'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getNotificationTargets(int, int, String, String, String, SecurityUser)"
  })
  void testGetNotificationTargets_whenFoo_thenStatusIsOk() throws Exception {
    // Arrange
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetService.findNotificationTargetsByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/targets")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1))
            .param("sortProperty", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string("{\"data\":[],\"totalPages\":0,\"totalElements\":0,\"hasNext\":false}"));
  }

  /**
   * Test {@link NotificationTargetController#getNotificationTargets(int, int, String, String,
   * String, SecurityUser)}.
   *
   * <ul>
   *   <li>When {@link MockMvcRequestBuilders#get(String, Object[])} {@code
   *       /api/notification/targets}.
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetController#getNotificationTargets(int, int,
   * String, String, String, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationTargets(int, int, String, String, String, SecurityUser); when get(String, Object[]) '/api/notification/targets'; then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getNotificationTargets(int, int, String, String, String, SecurityUser)"
  })
  void testGetNotificationTargets_whenGetApiNotificationTargets_thenStatusIsOk() throws Exception {
    // Arrange
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetService.findNotificationTargetsByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/targets")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string("{\"data\":[],\"totalPages\":0,\"totalElements\":0,\"hasNext\":false}"));
  }

  /**
   * Test {@link NotificationTargetController#getNotificationTargetsBySupportedNotificationType(int,
   * int, String, String, String, NotificationType, SecurityUser)}.
   *
   * <ul>
   *   <li>Then status four hundred six.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#getNotificationTargetsBySupportedNotificationType(int, int,
   * String, String, String, NotificationType, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationTargetsBySupportedNotificationType(int, int, String, String, String, NotificationType, SecurityUser); then status four hundred six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getNotificationTargetsBySupportedNotificationType(int, int, String, String, String, NotificationType, SecurityUser)"
  })
  void testGetNotificationTargetsBySupportedNotificationType_thenStatusFourHundredSix()
      throws Exception {
    // Arrange
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetService.findNotificationTargetsByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get("/api/notification/targets");
    getResult.accept("Media Types");

    MockHttpServletRequestBuilder requestBuilder =
        getResult.param("page", String.valueOf(1)).param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(406));
  }

  /**
   * Test {@link NotificationTargetController#getNotificationTargetsBySupportedNotificationType(int,
   * int, String, String, String, NotificationType, SecurityUser)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetController#getNotificationTargetsBySupportedNotificationType(int, int,
   * String, String, String, NotificationType, SecurityUser)}
   */
  @Test
  @DisplayName(
      "Test getNotificationTargetsBySupportedNotificationType(int, int, String, String, String, NotificationType, SecurityUser); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData NotificationTargetController.getNotificationTargetsBySupportedNotificationType(int, int, String, String, String, NotificationType, SecurityUser)"
  })
  void testGetNotificationTargetsBySupportedNotificationType_thenStatusIsOk() throws Exception {
    // Arrange
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetService.findNotificationTargetsByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/notification/targets")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"))
        .andExpect(
            content()
                .string("{\"data\":[],\"totalPages\":0,\"totalElements\":0,\"hasNext\":false}"));
  }

  /**
   * Test {@link NotificationTargetController#deleteNotificationTargetById(UUID)}.
   *
   * <p>Method under test: {@link NotificationTargetController#deleteNotificationTargetById(UUID)}
   */
  @Test
  @DisplayName("Test deleteNotificationTargetById(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTargetController.deleteNotificationTargetById(UUID)"})
  void testDeleteNotificationTargetById() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.delete("/api/notification/target/{id}", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(notificationTargetController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }
}
