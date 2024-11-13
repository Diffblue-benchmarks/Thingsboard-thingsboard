package org.thingsboard.server.service.notification.channels;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.rule.engine.api.notification.FirebaseService;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.Notification;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.settings.NotificationSettings;
import org.thingsboard.server.common.data.notification.template.MobileAppDeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.DefaultNotificationService;
import org.thingsboard.server.dao.notification.DefaultNotificationSettingsService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.notification.DefaultNotifications;
import org.thingsboard.server.dao.notification.NotificationService;
import org.thingsboard.server.dao.notification.NotificationSettingsService;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTargetDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTargetRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.service.notification.NotificationProcessingContext;

@ContextConfiguration(classes = {MobileAppNotificationChannel.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class MobileAppNotificationChannelDiffblueTest {
  @MockBean
  private FirebaseService firebaseService;

  @Autowired
  private MobileAppNotificationChannel mobileAppNotificationChannel;

  @MockBean
  private NotificationService notificationService;

  @MockBean
  private NotificationSettingsService notificationSettingsService;

  @MockBean
  private UserService userService;

  /**
   * Test
   * {@link MobileAppNotificationChannel#sendNotification(User, MobileAppDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   * with {@code User}, {@code MobileAppDeliveryMethodNotificationTemplate},
   * {@code NotificationProcessingContext}.
   * <p>
   * Method under test:
   * {@link MobileAppNotificationChannel#sendNotification(User, MobileAppDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   */
  @Test
  @DisplayName("Test sendNotification(User, MobileAppDeliveryMethodNotificationTemplate, NotificationProcessingContext) with 'User', 'MobileAppDeliveryMethodNotificationTemplate', 'NotificationProcessingContext'")
  void testSendNotificationWithUserMobileAppDeliveryMethodNotificationTemplateNotificationProcessingContext()
      throws Exception {
    // Arrange
    when(notificationService.saveNotification(Mockito.<TenantId>any(), Mockito.<Notification>any()))
        .thenThrow(new IllegalArgumentException("User doesn't use the mobile app"));
    User recipient = new User();
    MobileAppDeliveryMethodNotificationTemplate processedTemplate = new MobileAppDeliveryMethodNotificationTemplate();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(null);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.randomUUID()));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest.NotificationRequestBuilder templateIdResult = templateResult
        .templateId(new NotificationTemplateId(UUID.randomUUID()));
    NotificationRequest buildResult = templateIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    NotificationProcessingContext ctx = mock(NotificationProcessingContext.class);
    when(ctx.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(ctx.getRequest()).thenReturn(buildResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> mobileAppNotificationChannel.sendNotification(recipient, processedTemplate, ctx));
    verify(notificationRequestBuilder).info(isA(NotificationInfo.class));
    verify(notificationService).saveNotification(isNull(), isA(Notification.class));
    verify(ctx).getNotificationType();
    verify(ctx).getRequest();
  }

  /**
   * Test
   * {@link MobileAppNotificationChannel#sendNotification(User, MobileAppDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   * with {@code User}, {@code MobileAppDeliveryMethodNotificationTemplate},
   * {@code NotificationProcessingContext}.
   * <p>
   * Method under test:
   * {@link MobileAppNotificationChannel#sendNotification(User, MobileAppDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   */
  @Test
  @DisplayName("Test sendNotification(User, MobileAppDeliveryMethodNotificationTemplate, NotificationProcessingContext) with 'User', 'MobileAppDeliveryMethodNotificationTemplate', 'NotificationProcessingContext'")
  void testSendNotificationWithUserMobileAppDeliveryMethodNotificationTemplateNotificationProcessingContext2()
      throws Exception {
    // Arrange
    User recipient = new User();
    MobileAppDeliveryMethodNotificationTemplate processedTemplate = new MobileAppDeliveryMethodNotificationTemplate();
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(null);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.randomUUID()));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest.NotificationRequestBuilder templateIdResult = templateResult
        .templateId(new NotificationTemplateId(UUID.randomUUID()));
    NotificationRequest buildResult = templateIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    NotificationProcessingContext ctx = mock(NotificationProcessingContext.class);
    when(ctx.getNotificationType()).thenThrow(new IllegalArgumentException("User doesn't use the mobile app"));
    when(ctx.getRequest()).thenReturn(buildResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> mobileAppNotificationChannel.sendNotification(recipient, processedTemplate, ctx));
    verify(notificationRequestBuilder).info(isA(NotificationInfo.class));
    verify(ctx).getNotificationType();
    verify(ctx).getRequest();
  }

  /**
   * Test
   * {@link MobileAppNotificationChannel#sendNotification(User, MobileAppDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   * with {@code User}, {@code MobileAppDeliveryMethodNotificationTemplate},
   * {@code NotificationProcessingContext}.
   * <p>
   * Method under test:
   * {@link MobileAppNotificationChannel#sendNotification(User, MobileAppDeliveryMethodNotificationTemplate, NotificationProcessingContext)}
   */
  @Test
  @DisplayName("Test sendNotification(User, MobileAppDeliveryMethodNotificationTemplate, NotificationProcessingContext) with 'User', 'MobileAppDeliveryMethodNotificationTemplate', 'NotificationProcessingContext'")
  void testSendNotificationWithUserMobileAppDeliveryMethodNotificationTemplateNotificationProcessingContext3()
      throws Exception {
    // Arrange
    when(notificationService.saveNotification(Mockito.<TenantId>any(), Mockito.<Notification>any()))
        .thenThrow(new IllegalArgumentException("User doesn't use the mobile app"));
    User recipient = new User();
    MobileAppDeliveryMethodNotificationTemplate processedTemplate = mock(
        MobileAppDeliveryMethodNotificationTemplate.class);
    when(processedTemplate.getAdditionalConfig()).thenReturn(MissingNode.getInstance());
    when(processedTemplate.getBody()).thenReturn("Not all who wander are lost");
    when(processedTemplate.getSubject()).thenReturn("Hello from the Dreaming Spires");
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(null);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(UUID.randomUUID()));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest.NotificationRequestBuilder templateIdResult = templateResult
        .templateId(new NotificationTemplateId(UUID.randomUUID()));
    NotificationRequest buildResult = templateIdResult.tenantId(new TenantId(UUID.randomUUID())).build();
    NotificationProcessingContext ctx = mock(NotificationProcessingContext.class);
    when(ctx.getNotificationType()).thenReturn(NotificationType.GENERAL);
    when(ctx.getRequest()).thenReturn(buildResult);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> mobileAppNotificationChannel.sendNotification(recipient, processedTemplate, ctx));
    verify(notificationRequestBuilder).info(isA(NotificationInfo.class));
    verify(processedTemplate).getBody();
    verify(processedTemplate).getAdditionalConfig();
    verify(processedTemplate).getSubject();
    verify(notificationService).saveNotification(isNull(), isA(Notification.class));
    verify(ctx).getNotificationType();
    verify(ctx).getRequest();
  }

  /**
   * Test {@link MobileAppNotificationChannel#check(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppNotificationChannel#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId); then throw IllegalArgumentException")
  void testCheck_thenThrowIllegalArgumentException() throws Exception {
    // Arrange
    when(notificationSettingsService.findNotificationSettings(Mockito.<TenantId>any()))
        .thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> mobileAppNotificationChannel.check(new TenantId(UUID.randomUUID())));
    verify(notificationSettingsService).findNotificationSettings(isA(TenantId.class));
  }

  /**
   * Test {@link MobileAppNotificationChannel#check(TenantId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppNotificationChannel#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId); then throw RuntimeException")
  void testCheck_thenThrowRuntimeException() throws Exception {
    // Arrange
    NotificationSettings notificationSettings = new NotificationSettings();
    notificationSettings.setDeliveryMethodsConfigs(new HashMap<>());
    when(notificationSettingsService.findNotificationSettings(Mockito.<TenantId>any()))
        .thenReturn(notificationSettings);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> mobileAppNotificationChannel.check(new TenantId(UUID.randomUUID())));
    verify(notificationSettingsService).findNotificationSettings(isA(TenantId.class));
  }

  /**
   * Test {@link MobileAppNotificationChannel#getDeliveryMethod()}.
   * <p>
   * Method under test: {@link MobileAppNotificationChannel#getDeliveryMethod()}
   */
  @Test
  @DisplayName("Test getDeliveryMethod()")
  void testGetDeliveryMethod() {
    // Arrange
    FirebaseService firebaseService = mock(FirebaseService.class);
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
    UserServiceImpl userService = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService2 = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService2 = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService2,
            new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class))));

    // Act and Assert
    assertEquals(NotificationDeliveryMethod.MOBILE_APP, (new MobileAppNotificationChannel(firebaseService, userService,
        notificationService,
        new DefaultNotificationSettingsService(adminSettingsService, notificationTargetService,
            notificationTemplateService, defaultNotifications, new UserSettingsServiceImpl(new JpaUserSettingsDao()))))
        .getDeliveryMethod());
  }
}
