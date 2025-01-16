package org.thingsboard.server.service.sync.ie.importing.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
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
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;

class NotificationTargetImportServiceDiffblueTest {
  /**
   * Test {@link NotificationTargetImportService#deepCopy(NotificationTarget)}
   * with {@code NotificationTarget}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetImportService#deepCopy(NotificationTarget)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTarget) with 'NotificationTarget'; given one; then return Name is 'null'")
  void testDeepCopyWithNotificationTarget_givenOne_thenReturnNameIsNull() {
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
    NotificationTargetImportService notificationTargetImportService = new NotificationTargetImportService(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
            new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
                securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
                new JpaExecutorService())));
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    when(notificationTarget.getCreatedTime()).thenReturn(1L);
    UUID id = UUID.randomUUID();
    NotificationTargetId notificationTargetId = new NotificationTargetId(id);
    when(notificationTarget.getId()).thenReturn(notificationTargetId);

    // Act
    NotificationTarget actualDeepCopyResult = notificationTargetImportService.deepCopy(notificationTarget);

    // Assert
    verify(notificationTarget).getCreatedTime();
    verify(notificationTarget).getId();
    assertNull(actualDeepCopyResult.getName());
    assertNull(actualDeepCopyResult.getExternalId());
    assertNull(actualDeepCopyResult.getTenantId());
    assertNull(actualDeepCopyResult.getConfiguration());
    assertEquals(1L, actualDeepCopyResult.getCreatedTime());
    assertSame(notificationTargetId, actualDeepCopyResult.getId());
    assertSame(id, actualDeepCopyResult.getUuidId());
  }

  /**
   * Test {@link NotificationTargetImportService#deepCopy(NotificationTarget)}
   * with {@code NotificationTarget}.
   * <ul>
   *   <li>Then return {@link NotificationTarget#NotificationTarget()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetImportService#deepCopy(NotificationTarget)}
   */
  @Test
  @DisplayName("Test deepCopy(NotificationTarget) with 'NotificationTarget'; then return NotificationTarget()")
  void testDeepCopyWithNotificationTarget_thenReturnNotificationTarget() {
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
    NotificationTargetImportService notificationTargetImportService = new NotificationTargetImportService(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
            new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
                securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
                new JpaExecutorService())));
    NotificationTarget notificationTarget = new NotificationTarget();

    // Act and Assert
    assertEquals(notificationTarget, notificationTargetImportService.deepCopy(notificationTarget));
  }

  /**
   * Test {@link NotificationTargetImportService#getEntityType()}.
   * <p>
   * Method under test: {@link NotificationTargetImportService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  void testGetEntityType() {
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

    // Act and Assert
    assertEquals(EntityType.NOTIFICATION_TARGET,
        (new NotificationTargetImportService(
            new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
                new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService,
                    userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator, eventPublisher,
                    countService, new JpaExecutorService()))))
            .getEntityType());
  }
}
