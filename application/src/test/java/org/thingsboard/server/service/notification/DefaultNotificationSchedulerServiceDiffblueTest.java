package org.thingsboard.server.service.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.notification.DefaultNotificationRequestService;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.DefaultNotificationService;
import org.thingsboard.server.dao.notification.DefaultNotificationSettingsService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.notification.DefaultNotifications;
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

class DefaultNotificationSchedulerServiceDiffblueTest {
  /**
   * Test {@link DefaultNotificationSchedulerService#onAddedPartitions(Set)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSchedulerService#onAddedPartitions(Set)}
   */
  @Test
  @DisplayName("Test onAddedPartitions(Set)")
  void testOnAddedPartitions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.findAllByStatus(Mockito.<NotificationRequestStatus>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
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
        notificationTargetDao, notificationRequestDao2, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService2 = new DefaultNotificationRequestService(
        notificationRequestDao3,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(null, null);

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
    DefaultNotificationCenter notificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService2, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationSchedulerService defaultNotificationSchedulerService = new DefaultNotificationSchedulerService(
        notificationCenter, notificationRequestService, new NotificationExecutorService());

    HashSet<TopicPartitionInfo> addedPartitions = new HashSet<>();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    addedPartitions.add(buildResult);

    // Act
    Map<TopicPartitionInfo, List<ListenableFuture<?>>> actualOnAddedPartitionsResult = defaultNotificationSchedulerService
        .onAddedPartitions(addedPartitions);

    // Assert
    verify(notificationRequestRepository).findAllByStatus(eq(NotificationRequestStatus.SCHEDULED), isA(Pageable.class));
    assertTrue(actualOnAddedPartitionsResult.isEmpty());
  }

  /**
   * Test {@link DefaultNotificationSchedulerService#onAddedPartitions(Set)}.
   * <p>
   * Method under test:
   * {@link DefaultNotificationSchedulerService#onAddedPartitions(Set)}
   */
  @Test
  @DisplayName("Test onAddedPartitions(Set)")
  void testOnAddedPartitions2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.findAllByStatus(Mockito.<NotificationRequestStatus>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
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
        notificationTargetDao, notificationRequestDao2, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService2 = new DefaultNotificationRequestService(
        notificationRequestDao3,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(null, null);

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
    DefaultNotificationCenter notificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService2, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationSchedulerService defaultNotificationSchedulerService = new DefaultNotificationSchedulerService(
        notificationCenter, notificationRequestService, new NotificationExecutorService());

    HashSet<TopicPartitionInfo> addedPartitions = new HashSet<>();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    addedPartitions.add(buildResult);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    addedPartitions.add(buildResult2);

    // Act
    Map<TopicPartitionInfo, List<ListenableFuture<?>>> actualOnAddedPartitionsResult = defaultNotificationSchedulerService
        .onAddedPartitions(addedPartitions);

    // Assert
    verify(notificationRequestRepository).findAllByStatus(eq(NotificationRequestStatus.SCHEDULED), isA(Pageable.class));
    assertTrue(actualOnAddedPartitionsResult.isEmpty());
  }

  /**
   * Test {@link DefaultNotificationSchedulerService#onAddedPartitions(Set)}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultNotificationSchedulerService#onAddedPartitions(Set)}
   */
  @Test
  @DisplayName("Test onAddedPartitions(Set); when HashSet(); then return Empty")
  void testOnAddedPartitions_whenHashSet_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationRequestRepository notificationRequestRepository = mock(NotificationRequestRepository.class);
    when(notificationRequestRepository.findAllByStatus(Mockito.<NotificationRequestStatus>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(notificationRequestRepository);
    DefaultNotificationRequestService notificationRequestService = new DefaultNotificationRequestService(
        notificationRequestDao,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
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
        notificationTargetDao, notificationRequestDao2, notificationRuleDao,
        new UserServiceImpl(userDao, userCredentialsDao, null, null, userSettingsDao, null, userValidator,
            userCredentialsValidator, eventPublisher, countService, new JpaExecutorService()));

    JpaNotificationRequestDao notificationRequestDao3 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService2 = new DefaultNotificationRequestService(
        notificationRequestDao3,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationService notificationService = new DefaultNotificationService(
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)));
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultNotificationTargetService notificationTargetService2 = new DefaultNotificationTargetService(null, null, null,
        null);

    DefaultNotificationTemplateService notificationTemplateService2 = new DefaultNotificationTemplateService(null,
        null);

    DefaultNotifications defaultNotifications = new DefaultNotifications(null, null);

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
    DefaultNotificationCenter notificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService2, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    DefaultNotificationSchedulerService defaultNotificationSchedulerService = new DefaultNotificationSchedulerService(
        notificationCenter, notificationRequestService, new NotificationExecutorService());

    // Act
    Map<TopicPartitionInfo, List<ListenableFuture<?>>> actualOnAddedPartitionsResult = defaultNotificationSchedulerService
        .onAddedPartitions(new HashSet<>());

    // Assert
    verify(notificationRequestRepository).findAllByStatus(eq(NotificationRequestStatus.SCHEDULED), isA(Pageable.class));
    assertTrue(actualOnAddedPartitionsResult.isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DefaultNotificationSchedulerService#getSchedulerExecutorName()}
   *   <li>{@link DefaultNotificationSchedulerService#getServiceName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
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
    DefaultNotificationCenter notificationCenter = new DefaultNotificationCenter(notificationTargetService,
        notificationRequestService, notificationService, notificationTemplateService, notificationSettingsService,
        notificationExecutor, topicService, producerProvider,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    JpaNotificationRequestDao notificationRequestDao4 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    DefaultNotificationRequestService notificationRequestService2 = new DefaultNotificationRequestService(
        notificationRequestDao4,
        new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
        mock(ApplicationEventPublisher.class));

    DefaultNotificationSchedulerService defaultNotificationSchedulerService = new DefaultNotificationSchedulerService(
        notificationCenter, notificationRequestService2, new NotificationExecutorService());

    // Act
    String actualSchedulerExecutorName = defaultNotificationSchedulerService.getSchedulerExecutorName();

    // Assert
    assertEquals("Notifications scheduler", defaultNotificationSchedulerService.getServiceName());
    assertEquals("notifications-scheduler", actualSchedulerExecutorName);
  }
}
