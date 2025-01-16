package org.thingsboard.server.service.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequest.NotificationRequestBuilder;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.info.GeneralNotificationInfo;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilter;
import org.thingsboard.server.common.data.notification.template.DeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.EmailDeliveryMethodNotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplateConfig;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.tools.TbRateLimitsException;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.model.BaseSqlEntity;
import org.thingsboard.server.dao.model.sql.NotificationRequestEntity;
import org.thingsboard.server.dao.model.sql.NotificationTargetEntity;
import org.thingsboard.server.dao.model.sql.NotificationTemplateEntity;
import org.thingsboard.server.dao.notification.DefaultNotificationRequestService;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.DefaultNotificationService;
import org.thingsboard.server.dao.notification.DefaultNotificationSettingsService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.notification.DefaultNotifications;
import org.thingsboard.server.dao.notification.NotificationDao;
import org.thingsboard.server.dao.notification.NotificationRequestService;
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
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.service.executors.NotificationExecutorService;

class DefaultNotificationCenterDiffblueTest {
  /**
   * Test
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}
   */
  @Test
  @DisplayName("Test processNotificationRequest(TenantId, NotificationRequest, FutureCallback)")
  void testProcessNotificationRequest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(UUID.randomUUID());
    notificationTemplateEntity.setId(UUID.randomUUID());
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.randomUUID());
    notificationTemplateEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTemplateEntity> ofResult = Optional.of(notificationTemplateEntity);
    NotificationTemplateRepository notificationTemplateRepository = mock(NotificationTemplateRepository.class);
    when(notificationTemplateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(notificationTemplateRepository);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao2,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, null, null, userSettingsDao2, null, userValidator2,
            userCredentialsValidator2, eventPublisher2, countService2, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(new ArrayList<>());
    when(request.getRuleId()).thenReturn(new NotificationRuleId(UUID.randomUUID()));
    when(request.getTemplateId()).thenReturn(new NotificationTemplateId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationCenter.processNotificationRequest(tenantId, request, mock(FutureCallback.class)));
    verify(notificationTemplateRepository).findById(isA(UUID.class));
    verify(request).getRuleId();
    verify(request).getTargets();
    verify(request, atLeast(1)).getTemplateId();
  }

  /**
   * Test
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}
   */
  @Test
  @DisplayName("Test processNotificationRequest(TenantId, NotificationRequest, FutureCallback)")
  void testProcessNotificationRequest2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.randomUUID());
    notificationTargetEntity.setId(UUID.randomUUID());
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.randomUUID());
    notificationTargetEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTargetEntity> ofResult = Optional.of(notificationTargetEntity);
    NotificationTargetRepository notificationTargetRepository = mock(NotificationTargetRepository.class);
    when(notificationTargetRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(notificationTargetRepository);
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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        new EmailDeliveryMethodNotificationTemplate());
    NotificationTemplateConfig configuration = mock(NotificationTemplateConfig.class);
    when(configuration.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(configuration);
    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    when(notificationTemplateEntity.toData()).thenReturn(notificationTemplate);
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(UUID.randomUUID());
    notificationTemplateEntity.setId(UUID.randomUUID());
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.randomUUID());
    notificationTemplateEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTemplateEntity> ofResult2 = Optional.of(notificationTemplateEntity);
    NotificationTemplateRepository notificationTemplateRepository = mock(NotificationTemplateRepository.class);
    when(notificationTemplateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult2);
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(notificationTemplateRepository);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao2,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, null, null, userSettingsDao2, null, userValidator2,
            userCredentialsValidator2, eventPublisher2, countService2, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(uuidList);
    when(request.getRuleId()).thenReturn(new NotificationRuleId(UUID.randomUUID()));
    when(request.getTemplateId()).thenReturn(new NotificationTemplateId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationCenter.processNotificationRequest(tenantId, request, mock(FutureCallback.class)));
    verify(notificationTargetRepository).findById(isA(UUID.class));
    verify(notificationTemplateRepository).findById(isA(UUID.class));
    verify(request, atLeast(1)).getRuleId();
    verify(request).getTargets();
    verify(request, atLeast(1)).getTemplateId();
    verify(configuration).getDeliveryMethodsTemplates();
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTemplateEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("Name"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.GENERAL));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
  }

  /**
   * Test
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}
   */
  @Test
  @DisplayName("Test processNotificationRequest(TenantId, NotificationRequest, FutureCallback)")
  void testProcessNotificationRequest3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.randomUUID());
    notificationTargetEntity.setId(UUID.randomUUID());
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.randomUUID());
    notificationTargetEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTargetEntity> ofResult = Optional.of(notificationTargetEntity);
    NotificationTargetRepository notificationTargetRepository = mock(NotificationTargetRepository.class);
    when(notificationTargetRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(notificationTargetRepository);
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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    HashMap<NotificationDeliveryMethod, DeliveryMethodNotificationTemplate> notificationDeliveryMethodDeliveryMethodNotificationTemplateMap = new HashMap<>();
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.EMAIL,
        new EmailDeliveryMethodNotificationTemplate());
    notificationDeliveryMethodDeliveryMethodNotificationTemplateMap.put(NotificationDeliveryMethod.WEB,
        new EmailDeliveryMethodNotificationTemplate());
    NotificationTemplateConfig configuration = mock(NotificationTemplateConfig.class);
    when(configuration.getDeliveryMethodsTemplates())
        .thenReturn(notificationDeliveryMethodDeliveryMethodNotificationTemplateMap);

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(configuration);
    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    when(notificationTemplateEntity.toData()).thenReturn(notificationTemplate);
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(UUID.randomUUID());
    notificationTemplateEntity.setId(UUID.randomUUID());
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.randomUUID());
    notificationTemplateEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTemplateEntity> ofResult2 = Optional.of(notificationTemplateEntity);
    NotificationTemplateRepository notificationTemplateRepository = mock(NotificationTemplateRepository.class);
    when(notificationTemplateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult2);
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(notificationTemplateRepository);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao2,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, null, null, userSettingsDao2, null, userValidator2,
            userCredentialsValidator2, eventPublisher2, countService2, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(uuidList);
    when(request.getRuleId()).thenReturn(new NotificationRuleId(UUID.randomUUID()));
    when(request.getTemplateId()).thenReturn(new NotificationTemplateId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationCenter.processNotificationRequest(tenantId, request, mock(FutureCallback.class)));
    verify(notificationTargetRepository).findById(isA(UUID.class));
    verify(notificationTemplateRepository).findById(isA(UUID.class));
    verify(request, atLeast(1)).getRuleId();
    verify(request).getTargets();
    verify(request, atLeast(1)).getTemplateId();
    verify(configuration).getDeliveryMethodsTemplates();
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTemplateEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("Name"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.GENERAL));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
  }

  /**
   * Test
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link BaseSqlEntity#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}
   */
  @Test
  @DisplayName("Test processNotificationRequest(TenantId, NotificationRequest, FutureCallback); given ArrayList(); then calls setCreatedTime(long)")
  void testProcessNotificationRequest_givenArrayList_thenCallsSetCreatedTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    when(notificationTemplateEntity.toData()).thenReturn(new NotificationTemplate());
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(UUID.randomUUID());
    notificationTemplateEntity.setId(UUID.randomUUID());
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.randomUUID());
    notificationTemplateEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTemplateEntity> ofResult = Optional.of(notificationTemplateEntity);
    NotificationTemplateRepository notificationTemplateRepository = mock(NotificationTemplateRepository.class);
    when(notificationTemplateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(notificationTemplateRepository);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao2,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, null, null, userSettingsDao2, null, userValidator2,
            userCredentialsValidator2, eventPublisher2, countService2, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(new ArrayList<>());
    when(request.getRuleId()).thenReturn(new NotificationRuleId(UUID.randomUUID()));
    when(request.getTemplateId()).thenReturn(new NotificationTemplateId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationCenter.processNotificationRequest(tenantId, request, mock(FutureCallback.class)));
    verify(notificationTemplateRepository).findById(isA(UUID.class));
    verify(request).getRuleId();
    verify(request).getTargets();
    verify(request, atLeast(1)).getTemplateId();
    verify(notificationTemplateEntity).setCreatedTime(eq(1L));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("Name"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.GENERAL));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
  }

  /**
   * Test
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}.
   * <ul>
   *   <li>Given {@link NotificationTargetEntity}
   * {@link NotificationTargetEntity#toData()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}
   */
  @Test
  @DisplayName("Test processNotificationRequest(TenantId, NotificationRequest, FutureCallback); given NotificationTargetEntity toData() return 'null'")
  void testProcessNotificationRequest_givenNotificationTargetEntityToDataReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(null);
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.randomUUID());
    notificationTargetEntity.setId(UUID.randomUUID());
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.randomUUID());
    notificationTargetEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTargetEntity> ofResult = Optional.of(notificationTargetEntity);
    NotificationTargetRepository notificationTargetRepository = mock(NotificationTargetRepository.class);
    when(notificationTargetRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(notificationTargetRepository);
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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    when(notificationTemplateEntity.toData()).thenReturn(new NotificationTemplate());
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(UUID.randomUUID());
    notificationTemplateEntity.setId(UUID.randomUUID());
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.randomUUID());
    notificationTemplateEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTemplateEntity> ofResult2 = Optional.of(notificationTemplateEntity);
    NotificationTemplateRepository notificationTemplateRepository = mock(NotificationTemplateRepository.class);
    when(notificationTemplateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult2);
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(notificationTemplateRepository);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao2,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, null, null, userSettingsDao2, null, userValidator2,
            userCredentialsValidator2, eventPublisher2, countService2, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(uuidList);
    when(request.getRuleId()).thenReturn(new NotificationRuleId(UUID.randomUUID()));
    when(request.getTemplateId()).thenReturn(new NotificationTemplateId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationCenter.processNotificationRequest(tenantId, request, mock(FutureCallback.class)));
    verify(notificationTargetRepository).findById(isA(UUID.class));
    verify(notificationTemplateRepository).findById(isA(UUID.class));
    verify(request).getRuleId();
    verify(request).getTargets();
    verify(request, atLeast(1)).getTemplateId();
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTemplateEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("Name"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.GENERAL));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
  }

  /**
   * Test
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}.
   * <ul>
   *   <li>Given {@link NotificationTemplateEntity}
   * {@link NotificationTemplateEntity#toData()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}
   */
  @Test
  @DisplayName("Test processNotificationRequest(TenantId, NotificationRequest, FutureCallback); given NotificationTemplateEntity toData() return 'null'")
  void testProcessNotificationRequest_givenNotificationTemplateEntityToDataReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    when(notificationTemplateEntity.toData()).thenReturn(null);
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(UUID.randomUUID());
    notificationTemplateEntity.setId(UUID.randomUUID());
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.randomUUID());
    notificationTemplateEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTemplateEntity> ofResult = Optional.of(notificationTemplateEntity);
    NotificationTemplateRepository notificationTemplateRepository = mock(NotificationTemplateRepository.class);
    when(notificationTemplateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(notificationTemplateRepository);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao2,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, null, null, userSettingsDao2, null, userValidator2,
            userCredentialsValidator2, eventPublisher2, countService2, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getRuleId()).thenReturn(new NotificationRuleId(UUID.randomUUID()));
    when(request.getTemplateId()).thenReturn(new NotificationTemplateId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationCenter.processNotificationRequest(tenantId, request, mock(FutureCallback.class)));
    verify(notificationTemplateRepository).findById(isA(UUID.class));
    verify(request).getRuleId();
    verify(request, atLeast(1)).getTemplateId();
    verify(notificationTemplateEntity).setCreatedTime(eq(1L));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("Name"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.GENERAL));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
  }

  /**
   * Test
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationTemplateConfig#getDeliveryMethodsTemplates()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}
   */
  @Test
  @DisplayName("Test processNotificationRequest(TenantId, NotificationRequest, FutureCallback); then calls getDeliveryMethodsTemplates()")
  void testProcessNotificationRequest_thenCallsGetDeliveryMethodsTemplates() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetEntity notificationTargetEntity = mock(NotificationTargetEntity.class);
    when(notificationTargetEntity.toData()).thenReturn(new NotificationTarget());
    doNothing().when(notificationTargetEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTargetEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTargetEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTargetEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTargetEntity).setTenantId(Mockito.<UUID>any());
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.randomUUID());
    notificationTargetEntity.setId(UUID.randomUUID());
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.randomUUID());
    notificationTargetEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTargetEntity> ofResult = Optional.of(notificationTargetEntity);
    NotificationTargetRepository notificationTargetRepository = mock(NotificationTargetRepository.class);
    when(notificationTargetRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(notificationTargetRepository);
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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    NotificationTemplateConfig configuration = mock(NotificationTemplateConfig.class);
    when(configuration.getDeliveryMethodsTemplates()).thenReturn(new HashMap<>());

    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(configuration);
    NotificationTemplateEntity notificationTemplateEntity = mock(NotificationTemplateEntity.class);
    when(notificationTemplateEntity.toData()).thenReturn(notificationTemplate);
    doNothing().when(notificationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(notificationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(notificationTemplateEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationTemplateEntity).setName(Mockito.<String>any());
    doNothing().when(notificationTemplateEntity).setNotificationType(Mockito.<NotificationType>any());
    doNothing().when(notificationTemplateEntity).setTenantId(Mockito.<UUID>any());
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(UUID.randomUUID());
    notificationTemplateEntity.setId(UUID.randomUUID());
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.randomUUID());
    notificationTemplateEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTemplateEntity> ofResult2 = Optional.of(notificationTemplateEntity);
    NotificationTemplateRepository notificationTemplateRepository = mock(NotificationTemplateRepository.class);
    when(notificationTemplateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult2);
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(notificationTemplateRepository);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao2,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, null, null, userSettingsDao2, null, userValidator2,
            userCredentialsValidator2, eventPublisher2, countService2, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenReturn(uuidList);
    when(request.getRuleId()).thenReturn(new NotificationRuleId(UUID.randomUUID()));
    when(request.getTemplateId()).thenReturn(new NotificationTemplateId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationCenter.processNotificationRequest(tenantId, request, mock(FutureCallback.class)));
    verify(notificationTargetRepository).findById(isA(UUID.class));
    verify(notificationTemplateRepository).findById(isA(UUID.class));
    verify(request, atLeast(1)).getRuleId();
    verify(request).getTargets();
    verify(request, atLeast(1)).getTemplateId();
    verify(configuration).getDeliveryMethodsTemplates();
    verify(notificationTargetEntity).setCreatedTime(eq(1L));
    verify(notificationTemplateEntity).setCreatedTime(eq(1L));
    verify(notificationTargetEntity).setId(isA(UUID.class));
    verify(notificationTemplateEntity).setId(isA(UUID.class));
    verify(notificationTargetEntity).setUuid(isA(UUID.class));
    verify(notificationTemplateEntity).setUuid(isA(UUID.class));
    verify(notificationTargetEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTargetEntity).setExternalId(isA(UUID.class));
    verify(notificationTargetEntity).setName(eq("Name"));
    verify(notificationTargetEntity).setTenantId(isA(UUID.class));
    verify(notificationTargetEntity).toData();
    verify(notificationTemplateEntity).setConfiguration(isA(JsonNode.class));
    verify(notificationTemplateEntity).setExternalId(isA(UUID.class));
    verify(notificationTemplateEntity).setName(eq("Name"));
    verify(notificationTemplateEntity).setNotificationType(eq(NotificationType.GENERAL));
    verify(notificationTemplateEntity).setTenantId(isA(UUID.class));
    verify(notificationTemplateEntity).toData();
  }

  /**
   * Test
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}.
   * <ul>
   *   <li>Then throw {@link TbRateLimitsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCenter#processNotificationRequest(TenantId, NotificationRequest, FutureCallback)}
   */
  @Test
  @DisplayName("Test processNotificationRequest(TenantId, NotificationRequest, FutureCallback); then throw TbRateLimitsException")
  void testProcessNotificationRequest_thenThrowTbRateLimitsException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(UUID.randomUUID());
    notificationTemplateEntity.setId(UUID.randomUUID());
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.randomUUID());
    notificationTemplateEntity.setUuid(UUID.randomUUID());
    Optional<NotificationTemplateEntity> ofResult = Optional.of(notificationTemplateEntity);
    NotificationTemplateRepository notificationTemplateRepository = mock(NotificationTemplateRepository.class);
    when(notificationTemplateRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(notificationTemplateRepository);
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao2,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, null, null, userSettingsDao2, null, userValidator2,
            userCredentialsValidator2, eventPublisher2, countService2, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    NotificationRequest request = mock(NotificationRequest.class);
    when(request.getTargets()).thenThrow(new TbRateLimitsException("An error occurred"));
    when(request.getRuleId()).thenReturn(new NotificationRuleId(UUID.randomUUID()));
    when(request.getTemplateId()).thenReturn(new NotificationTemplateId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(TbRateLimitsException.class,
        () -> defaultNotificationCenter.processNotificationRequest(tenantId, request, mock(FutureCallback.class)));
    verify(notificationTemplateRepository).findById(isA(UUID.class));
    verify(request).getRuleId();
    verify(request).getTargets();
    verify(request, atLeast(1)).getTemplateId();
  }

  /**
   * Test
   * {@link DefaultNotificationCenter#sendGeneralWebNotification(TenantId, UsersFilter, NotificationTemplate, GeneralNotificationInfo)}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationRequestBuilder#info(NotificationInfo)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCenter#sendGeneralWebNotification(TenantId, UsersFilter, NotificationTemplate, GeneralNotificationInfo)}
   */
  @Test
  @DisplayName("Test sendGeneralWebNotification(TenantId, UsersFilter, NotificationTemplate, GeneralNotificationInfo); then calls info(NotificationInfo)")
  void testSendGeneralWebNotification_thenCallsInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
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
    NotificationRequestService notificationRequestService = mock(NotificationRequestService.class);
    when(
        notificationRequestService.saveNotificationRequest(Mockito.<TenantId>any(), Mockito.<NotificationRequest>any()))
        .thenReturn(buildResult);
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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao2, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, null, null, userSettingsDao2, null, userValidator2,
            userCredentialsValidator2, eventPublisher2, countService2, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UsersFilter recipients = mock(UsersFilter.class);
    NotificationTemplate template = new NotificationTemplate();

    // Act
    defaultNotificationCenter.sendGeneralWebNotification(tenantId, recipients, template, new GeneralNotificationInfo());

    // Assert
    verify(notificationRequestBuilder).info(isA(NotificationInfo.class));
    verify(notificationRequestService).saveNotificationRequest(isA(TenantId.class), isA(NotificationRequest.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotificationCenter#check(TenantId)}
   *   <li>{@link DefaultNotificationCenter#getDeliveryMethod()}
   *   <li>{@link DefaultNotificationCenter#getExecutorPrefix()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() throws Exception {
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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService,
            new JpaExecutorService()));

    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao2,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService2,
            new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    JpaNotificationTemplateDao notificationTemplateDao3 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(
        notificationTemplateDao3, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class))));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act
    defaultNotificationCenter.check(new TenantId(UUID.randomUUID()));
    NotificationDeliveryMethod actualDeliveryMethod = defaultNotificationCenter.getDeliveryMethod();

    // Assert that nothing has changed
    assertEquals("notification", defaultNotificationCenter.getExecutorPrefix());
    assertEquals(NotificationDeliveryMethod.WEB, actualDeliveryMethod);
  }

  /**
   * Test
   * {@link DefaultNotificationCenter#deleteNotificationRequest(TenantId, NotificationRequestId)}.
   * <ul>
   *   <li>Then calls {@link ApplicationEventPublisher#publishEvent(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationCenter#deleteNotificationRequest(TenantId, NotificationRequestId)}
   */
  @Test
  @DisplayName("Test deleteNotificationRequest(TenantId, NotificationRequestId); then calls publishEvent(Object)")
  void testDeleteNotificationRequest_thenCallsPublishEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
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
    NotificationRequestEntity notificationRequestEntity = mock(NotificationRequestEntity.class);
    when(notificationRequestEntity.toData()).thenReturn(buildResult);
    doNothing().when(notificationRequestEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRequestEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setOriginatorEntityType(Mockito.<EntityType>any());
    doNothing().when(notificationRequestEntity).setRuleId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setStats(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setStatus(Mockito.<NotificationRequestStatus>any());
    doNothing().when(notificationRequestEntity).setTargets(Mockito.<String>any());
    doNothing().when(notificationRequestEntity).setTemplate(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRequestEntity).setTenantId(Mockito.<UUID>any());
    notificationRequestEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(UUID.randomUUID());
    notificationRequestEntity.setInfo(MissingNode.getInstance());
    notificationRequestEntity.setOriginatorEntityId(UUID.randomUUID());
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.randomUUID());
    notificationRequestEntity.setStats(MissingNode.getInstance());
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(MissingNode.getInstance());
    notificationRequestEntity.setTemplateId(UUID.randomUUID());
    notificationRequestEntity.setTenantId(UUID.randomUUID());
    notificationRequestEntity.setUuid(UUID.randomUUID());
    Optional<NotificationRequestEntity> ofResult = Optional.of(notificationRequestEntity);
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    doNothing().when(notificationRequestRepository).flush();
    doNothing().when(notificationRequestRepository).deleteById(Mockito.<UUID>any());
    when(notificationRequestRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    NotificationDao notificationDao = mock(NotificationDao.class);
    doNothing().when(notificationDao).deleteByRequestId(Mockito.<TenantId>any(), Mockito.<NotificationRequestId>any());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<Object>any());
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao, notificationDao, eventPublisher);

    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
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
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao2, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
            securitySettingsService, userValidator, userCredentialsValidator, eventPublisher2, countService,
            new JpaExecutorService()));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(
        notificationTargetDao2, notificationRequestDao3, notificationRuleDao2,
        new UserServiceImpl(userDao2, userCredentialsDao2, null, null, userSettingsDao2, null, userValidator2,
            userCredentialsValidator2, eventPublisher3, countService2, new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(null, null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(null));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService, notificationTargetService2, notificationTemplateService2, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    NotificationExecutorService notificationExecutor = new NotificationExecutorService();
    TopicService topicService = new TopicService();
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService2, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DefaultNotificationCenter defaultNotificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    defaultNotificationCenter.deleteNotificationRequest(tenantId, new NotificationRequestId(UUID.randomUUID()));

    // Assert
    verify(eventPublisher).publishEvent(isA(Object.class));
    verify(notificationRequestRepository).flush();
    verify(notificationRequestRepository).deleteById(isNull());
    verify(notificationRequestRepository).findById(isA(UUID.class));
    verify(notificationRequestBuilder).info(isA(NotificationInfo.class));
    verify(notificationRequestEntity).setCreatedTime(eq(1L));
    verify(notificationRequestEntity).setId(isA(UUID.class));
    verify(notificationRequestEntity).setUuid(isA(UUID.class));
    verify(notificationRequestEntity).setAdditionalConfig(isA(JsonNode.class));
    verify(notificationRequestEntity).setInfo(isA(JsonNode.class));
    verify(notificationRequestEntity).setOriginatorEntityId(isA(UUID.class));
    verify(notificationRequestEntity).setOriginatorEntityType(eq(EntityType.TENANT));
    verify(notificationRequestEntity).setRuleId(isA(UUID.class));
    verify(notificationRequestEntity).setStats(isA(JsonNode.class));
    verify(notificationRequestEntity).setStatus(eq(NotificationRequestStatus.PROCESSING));
    verify(notificationRequestEntity).setTargets(eq("Targets"));
    verify(notificationRequestEntity).setTemplate(isA(JsonNode.class));
    verify(notificationRequestEntity).setTemplateId(isA(UUID.class));
    verify(notificationRequestEntity).setTenantId(isA(UUID.class));
    verify(notificationRequestEntity).toData();
    verify(notificationDao).deleteByRequestId(isA(TenantId.class), isNull());
  }
}
