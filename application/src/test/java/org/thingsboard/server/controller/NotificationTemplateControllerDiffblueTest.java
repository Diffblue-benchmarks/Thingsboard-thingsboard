package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversation;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversationType;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.DefaultNotificationSettingsService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.notification.DefaultNotifications;
import org.thingsboard.server.dao.notification.NotificationTemplateDao;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTargetDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTargetRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.service.notification.provider.DefaultSlackService;
import org.thingsboard.server.service.security.model.SecurityUser;

class NotificationTemplateControllerDiffblueTest {
  /**
   * Test
   * {@link NotificationTemplateController#getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateController#getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser); then return EMPTY_PAGE_DATA")
  void testGetNotificationTemplates_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTemplateDao notificationTemplateDao = mock(NotificationTemplateDao.class);
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService3 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    NotificationTemplateController notificationTemplateController = new NotificationTemplateController(
        notificationTemplateService, notificationSettingsService,
        new DefaultSlackService(new DefaultNotificationSettingsService(adminSettingsService2,
            notificationTargetService2, notificationTemplateService3, defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()))));

    // Act
    PageData<NotificationTemplate> actualNotificationTemplates = notificationTemplateController
        .getNotificationTemplates(3, 1, "Text Search", "U", "asc", new NotificationType[]{NotificationType.GENERAL},
            new SecurityUser());

    // Assert
    verify(notificationTemplateDao).findByTenantIdAndNotificationTypesAndPageLink(isNull(), isA(List.class),
        isA(PageLink.class));
    assertSame(actualNotificationTemplates.EMPTY_PAGE_DATA, actualNotificationTemplates);
  }

  /**
   * Test
   * {@link NotificationTemplateController#getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser)}.
   * <ul>
   *   <li>When empty array of {@link NotificationType}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateController#getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser); when empty array of NotificationType")
  void testGetNotificationTemplates_whenEmptyArrayOfNotificationType() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTemplateDao notificationTemplateDao = mock(NotificationTemplateDao.class);
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService3 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    NotificationTemplateController notificationTemplateController = new NotificationTemplateController(
        notificationTemplateService, notificationSettingsService,
        new DefaultSlackService(new DefaultNotificationSettingsService(adminSettingsService2,
            notificationTargetService2, notificationTemplateService3, defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()))));

    // Act
    PageData<NotificationTemplate> actualNotificationTemplates = notificationTemplateController
        .getNotificationTemplates(3, 1, "Text Search", "U", "asc", new NotificationType[]{}, new SecurityUser());

    // Assert
    verify(notificationTemplateDao).findByTenantIdAndNotificationTypesAndPageLink(isNull(), isA(List.class),
        isA(PageLink.class));
    assertSame(actualNotificationTemplates.EMPTY_PAGE_DATA, actualNotificationTemplates);
  }

  /**
   * Test
   * {@link NotificationTemplateController#getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateController#getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser); when 'null'; then return EMPTY_PAGE_DATA")
  void testGetNotificationTemplates_whenNull_thenReturnEmpty_page_data() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTemplateDao notificationTemplateDao = mock(NotificationTemplateDao.class);
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService3 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    NotificationTemplateController notificationTemplateController = new NotificationTemplateController(
        notificationTemplateService, notificationSettingsService,
        new DefaultSlackService(new DefaultNotificationSettingsService(adminSettingsService2,
            notificationTargetService2, notificationTemplateService3, defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()))));

    // Act
    PageData<NotificationTemplate> actualNotificationTemplates = notificationTemplateController
        .getNotificationTemplates(3, 1, "Text Search", null, "asc", new NotificationType[]{NotificationType.GENERAL},
            new SecurityUser());

    // Assert
    verify(notificationTemplateDao).findByTenantIdAndNotificationTypesAndPageLink(isNull(), isA(List.class),
        isA(PageLink.class));
    assertSame(actualNotificationTemplates.EMPTY_PAGE_DATA, actualNotificationTemplates);
  }

  /**
   * Test
   * {@link NotificationTemplateController#getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateController#getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser); when 'null'; then return EMPTY_PAGE_DATA")
  void testGetNotificationTemplates_whenNull_thenReturnEmpty_page_data2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTemplateDao notificationTemplateDao = mock(NotificationTemplateDao.class);
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService3 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    NotificationTemplateController notificationTemplateController = new NotificationTemplateController(
        notificationTemplateService, notificationSettingsService,
        new DefaultSlackService(new DefaultNotificationSettingsService(adminSettingsService2,
            notificationTargetService2, notificationTemplateService3, defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()))));

    // Act
    PageData<NotificationTemplate> actualNotificationTemplates = notificationTemplateController
        .getNotificationTemplates(3, 1, "Text Search", "U", null, new NotificationType[]{NotificationType.GENERAL},
            new SecurityUser());

    // Assert
    verify(notificationTemplateDao).findByTenantIdAndNotificationTypesAndPageLink(isNull(), isA(List.class),
        isA(PageLink.class));
    assertSame(actualNotificationTemplates.EMPTY_PAGE_DATA, actualNotificationTemplates);
  }

  /**
   * Test
   * {@link NotificationTemplateController#getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateController#getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser)}
   */
  @Test
  @DisplayName("Test getNotificationTemplates(int, int, String, String, String, NotificationType[], SecurityUser); when 'null'; then return EMPTY_PAGE_DATA")
  void testGetNotificationTemplates_whenNull_thenReturnEmpty_page_data3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTemplateDao notificationTemplateDao = mock(NotificationTemplateDao.class);
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateDao.findByTenantIdAndNotificationTypesAndPageLink(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService3 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    NotificationTemplateController notificationTemplateController = new NotificationTemplateController(
        notificationTemplateService, notificationSettingsService,
        new DefaultSlackService(new DefaultNotificationSettingsService(adminSettingsService2,
            notificationTargetService2, notificationTemplateService3, defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()))));

    // Act
    PageData<NotificationTemplate> actualNotificationTemplates = notificationTemplateController
        .getNotificationTemplates(3, 1, "Text Search", "U", "asc", null, new SecurityUser());

    // Assert
    verify(notificationTemplateDao).findByTenantIdAndNotificationTypesAndPageLink(isNull(), isA(List.class),
        isA(PageLink.class));
    assertSame(actualNotificationTemplates.EMPTY_PAGE_DATA, actualNotificationTemplates);
  }

  /**
   * Test
   * {@link NotificationTemplateController#listSlackConversations(SlackConversationType, String, SecurityUser)}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateController#listSlackConversations(SlackConversationType, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test listSlackConversations(SlackConversationType, String, SecurityUser)")
  void testListSlackConversations() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService, notificationTemplateService, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService3 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    NotificationTemplateController notificationTemplateController = new NotificationTemplateController(
        notificationTemplateService2, notificationSettingsService,
        new DefaultSlackService(new DefaultNotificationSettingsService(adminSettingsService2,
            notificationTargetService2, notificationTemplateService3, defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()))));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> notificationTemplateController
        .listSlackConversations(SlackConversationType.DIRECT, null, new SecurityUser()));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isNull(), eq("notifications"));
  }

  /**
   * Test
   * {@link NotificationTemplateController#listSlackConversations(SlackConversationType, String, SecurityUser)}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateController#listSlackConversations(SlackConversationType, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test listSlackConversations(SlackConversationType, String, SecurityUser)")
  void testListSlackConversations2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService, notificationTemplateService, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(null,
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService3 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    NotificationTemplateController notificationTemplateController = new NotificationTemplateController(
        notificationTemplateService2, notificationSettingsService,
        new DefaultSlackService(new DefaultNotificationSettingsService(adminSettingsService2,
            notificationTargetService2, notificationTemplateService3, defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()))));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> notificationTemplateController
        .listSlackConversations(SlackConversationType.DIRECT, null, new SecurityUser()));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isNull(), eq("notifications"));
  }

  /**
   * Test
   * {@link NotificationTemplateController#listSlackConversations(SlackConversationType, String, SecurityUser)}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateController#listSlackConversations(SlackConversationType, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test listSlackConversations(SlackConversationType, String, SecurityUser)")
  void testListSlackConversations3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService, notificationTemplateService, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService3 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    NotificationTemplateController notificationTemplateController = new NotificationTemplateController(
        notificationTemplateService2, notificationSettingsService,
        new DefaultSlackService(new DefaultNotificationSettingsService(adminSettingsService2,
            notificationTargetService2, notificationTemplateService3, defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()))));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> notificationTemplateController
        .listSlackConversations(SlackConversationType.DIRECT, null, new SecurityUser()));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isNull(), eq("notifications"));
  }

  /**
   * Test
   * {@link NotificationTemplateController#listSlackConversations(SlackConversationType, String, SecurityUser)}.
   * <ul>
   *   <li>Then calls {@link ArrayNode#asToken()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateController#listSlackConversations(SlackConversationType, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test listSlackConversations(SlackConversationType, String, SecurityUser); then calls asToken()")
  void testListSlackConversations_thenCallsAsToken() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asToken()).thenThrow(new IllegalArgumentException("foo"));
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(arrayNode);
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService, notificationTemplateService, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService3 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    NotificationTemplateController notificationTemplateController = new NotificationTemplateController(
        notificationTemplateService2, notificationSettingsService,
        new DefaultSlackService(new DefaultNotificationSettingsService(adminSettingsService2,
            notificationTargetService2, notificationTemplateService3, defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()))));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> notificationTemplateController
        .listSlackConversations(SlackConversationType.DIRECT, null, new SecurityUser()));
    verify(arrayNode).asToken();
    verify(adminSettings).getJsonValue();
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isNull(), eq("notifications"));
  }

  /**
   * Test
   * {@link NotificationTemplateController#listSlackConversations(SlackConversationType, String, SecurityUser)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateController#listSlackConversations(SlackConversationType, String, SecurityUser)}
   */
  @Test
  @DisplayName("Test listSlackConversations(SlackConversationType, String, SecurityUser); then return Empty")
  void testListSlackConversations_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultSlackService slackService = mock(DefaultSlackService.class);
    when(slackService.listConversations(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<SlackConversationType>any())).thenReturn(new ArrayList<>());
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    NotificationTemplateController notificationTemplateController = new NotificationTemplateController(
        notificationTemplateService,
        new DefaultNotificationSettingsService(adminSettingsService, notificationTargetService,
            notificationTemplateService2, defaultNotifications, new UserSettingsServiceImpl(new JpaUserSettingsDao())),
        slackService);

    // Act
    List<SlackConversation> actualListSlackConversationsResult = notificationTemplateController
        .listSlackConversations(SlackConversationType.DIRECT, "ABC123", new SecurityUser());

    // Assert
    verify(slackService).listConversations(isNull(), eq("ABC123"), eq(SlackConversationType.DIRECT));
    assertTrue(actualListSlackConversationsResult.isEmpty());
  }
}
