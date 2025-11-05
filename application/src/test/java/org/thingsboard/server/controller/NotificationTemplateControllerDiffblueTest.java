package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.DefaultNotificationSettingsService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.notification.DefaultNotifications;
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

class NotificationTemplateControllerDiffblueTest {
  /**
   * Test {@link NotificationTemplateController#deleteNotificationTemplateById(UUID)}.
   *
   * <p>Method under test: {@link
   * NotificationTemplateController#deleteNotificationTemplateById(UUID)}
   */
  @Test
  @DisplayName("Test deleteNotificationTemplateById(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTemplateController.deleteNotificationTemplateById(UUID)"})
  void testDeleteNotificationTemplateById() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService notificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            null,
            null,
            userSettingsDao,
            null,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao2, notificationRuleDao, userService);
    JpaNotificationTemplateDao notificationTemplateDao2 =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService notificationTemplateService2 =
        new DefaultNotificationTemplateService(notificationTemplateDao2, notificationRequestDao3);
    DefaultNotificationTemplateService templateService =
        new DefaultNotificationTemplateService(null, null);
    DefaultNotifications defaultNotifications =
        new DefaultNotifications(templateService, new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService =
        new DefaultNotificationSettingsService(
            adminSettingsService,
            notificationTargetService,
            notificationTemplateService2,
            defaultNotifications,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 =
        new DefaultNotificationTargetService(null, null, null, null);
    DefaultNotificationTemplateService notificationTemplateService3 =
        new DefaultNotificationTemplateService(null, null);
    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    DefaultNotificationSettingsService notificationSettingsService2 =
        new DefaultNotificationSettingsService(
            adminSettingsService2,
            notificationTargetService2,
            notificationTemplateService3,
            defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationTemplateController notificationTemplateController =
        new NotificationTemplateController(
            notificationTemplateService,
            notificationSettingsService,
            new DefaultSlackService(notificationSettingsService2));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            notificationTemplateController.deleteNotificationTemplateById(
                UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link NotificationTemplateController#deleteNotificationTemplateById(UUID)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTemplateController#deleteNotificationTemplateById(UUID)}
   */
  @Test
  @DisplayName("Test deleteNotificationTemplateById(UUID); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void NotificationTemplateController.deleteNotificationTemplateById(UUID)"})
  void testDeleteNotificationTemplateById_whenNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService notificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            null,
            null,
            userSettingsDao,
            null,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao2, notificationRuleDao, userService);
    JpaNotificationTemplateDao notificationTemplateDao2 =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService notificationTemplateService2 =
        new DefaultNotificationTemplateService(notificationTemplateDao2, notificationRequestDao3);
    DefaultNotificationTemplateService templateService =
        new DefaultNotificationTemplateService(null, null);
    DefaultNotifications defaultNotifications =
        new DefaultNotifications(templateService, new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService =
        new DefaultNotificationSettingsService(
            adminSettingsService,
            notificationTargetService,
            notificationTemplateService2,
            defaultNotifications,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()));
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 =
        new DefaultNotificationTargetService(null, null, null, null);
    DefaultNotificationTemplateService notificationTemplateService3 =
        new DefaultNotificationTemplateService(null, null);
    DefaultNotifications defaultNotifications2 = new DefaultNotifications(null, null);

    DefaultNotificationSettingsService notificationSettingsService2 =
        new DefaultNotificationSettingsService(
            adminSettingsService2,
            notificationTargetService2,
            notificationTemplateService3,
            defaultNotifications2,
            new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationTemplateController notificationTemplateController =
        new NotificationTemplateController(
            notificationTemplateService,
            notificationSettingsService,
            new DefaultSlackService(notificationSettingsService2));

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> notificationTemplateController.deleteNotificationTemplateById(null));
  }
}
