package org.thingsboard.server.transport.snmp.session;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.snmp4j.CommunityTarget;
import org.snmp4j.Target;
import org.snmp4j.smi.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.SnmpDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.queue.common.TbRuleEngineProducerService;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.InMemoryTbTransportQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.transport.snmp.SnmpTransportContext;
import org.thingsboard.server.transport.snmp.service.PduService;
import org.thingsboard.server.transport.snmp.service.ProtoTransportEntityService;
import org.thingsboard.server.transport.snmp.service.SnmpAuthService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportBalancingService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportService;
import org.thingsboard.server.transport.snmp.session.DeviceSessionContext.DeviceSessionContextBuilder;

@ContextConfiguration(classes = {DeviceSessionContextBuilder.class})
@ExtendWith(SpringExtension.class)
class DeviceSessionContextDiffblueTest {
  @Autowired private DeviceSessionContextBuilder deviceSessionContextBuilder;

  /**
   * Test {@link DeviceSessionContext#builder()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceSessionContext#builder()}
   *   <li>{@link DeviceSessionContext#device(Device)}
   *   <li>{@link DeviceSessionContext#deviceProfile(DeviceProfile)}
   *   <li>{@link
   *       DeviceSessionContext#deviceTransportConfiguration(SnmpDeviceTransportConfiguration)}
   *   <li>{@link
   *       DeviceSessionContext#profileTransportConfiguration(SnmpDeviceProfileTransportConfiguration)}
   *   <li>{@link DeviceSessionContext#snmpTransportContext(SnmpTransportContext)}
   *   <li>{@link DeviceSessionContext#tenantId(TenantId)}
   *   <li>{@link DeviceSessionContext#token(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceSessionContextBuilder.<init>()",
    "DeviceSessionContext DeviceSessionContextBuilder.build()",
    "DeviceSessionContextBuilder DeviceSessionContextBuilder.device(Device)",
    "DeviceSessionContextBuilder DeviceSessionContextBuilder.deviceProfile(DeviceProfile)",
    "DeviceSessionContextBuilder DeviceSessionContextBuilder.deviceTransportConfiguration(SnmpDeviceTransportConfiguration)",
    "DeviceSessionContextBuilder DeviceSessionContextBuilder.profileTransportConfiguration(SnmpDeviceProfileTransportConfiguration)",
    "DeviceSessionContextBuilder DeviceSessionContextBuilder.snmpTransportContext(SnmpTransportContext)",
    "DeviceSessionContextBuilder DeviceSessionContextBuilder.tenantId(TenantId)",
    "String DeviceSessionContextBuilder.toString()",
    "DeviceSessionContextBuilder DeviceSessionContextBuilder.token(String)"
  })
  void testBuilder() {
    // Arrange and Act
    DeviceSessionContextBuilder actualBuilderResult = DeviceSessionContext.builder();
    DeviceSessionContextBuilder actualDeviceResult = actualBuilderResult.device(new Device());
    DeviceSessionContextBuilder actualDeviceProfileResult =
        actualDeviceResult.deviceProfile(new DeviceProfile());
    DeviceSessionContextBuilder actualDeviceTransportConfigurationResult =
        actualDeviceProfileResult.deviceTransportConfiguration(
            new SnmpDeviceTransportConfiguration());
    DeviceSessionContextBuilder actualProfileTransportConfigurationResult =
        actualDeviceTransportConfigurationResult.profileTransportConfiguration(
            new SnmpDeviceProfileTransportConfiguration());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    DefaultTransportDeviceProfileCache deviceProfileCache2 =
        new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage2 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider2 =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings2,
            transportNotificationSettings2,
            serviceInfoProvider5,
            coreSettings2,
            storage2,
            new TopicService());
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings3 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings3 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings3 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService2,
            coreSettings3,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider6,
            transportApiSettings3,
            transportNotificationSettings3,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider2 =
        new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService3 =
        new HashPartitionService(
            serviceInfoProvider7,
            tenantRoutingInfoService3,
            applicationEventPublisher3,
            queueRoutingInfoService3,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService2 =
        new TbRuleEngineProducerService(partitionService3);
    TopicService topicService3 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache3 =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService2 =
        new DefaultTransportService(
            partitionService2,
            queueProvider2,
            producerProvider2,
            ruleEngineProducerService2,
            topicService3,
            serviceInfoProvider8,
            statsFactory2,
            deviceProfileCache3,
            tenantProfileCache2,
            rateLimitService2,
            scheduler2,
            eventPublisher2,
            transportResourceCache2,
            notificationRuleProcessor2,
            new DefaultEntityLimitsCache(1, 3));
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService4 =
        new HashPartitionService(
            serviceInfoProvider9,
            tenantRoutingInfoService4,
            applicationEventPublisher4,
            queueRoutingInfoService4,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage3 = new DefaultInMemoryStorage();
    InMemoryTbTransportQueueFactory queueProvider3 =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings4,
            transportNotificationSettings4,
            serviceInfoProvider10,
            coreSettings4,
            storage3,
            new TopicService());
    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService3 = new TbRuleEngineProducerService(null);
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory3 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache4 =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache3 =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService3 =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler3 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache3 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor3 = mock(NotificationRuleProcessor.class);
    DefaultTransportService transportService3 =
        new DefaultTransportService(
            partitionService4,
            queueProvider3,
            producerProvider3,
            ruleEngineProducerService3,
            topicService4,
            serviceInfoProvider11,
            statsFactory3,
            deviceProfileCache4,
            tenantProfileCache3,
            rateLimitService3,
            scheduler3,
            eventPublisher3,
            transportResourceCache3,
            notificationRuleProcessor3,
            new DefaultEntityLimitsCache(1, 3));
    ProtoTransportEntityService protoEntityService =
        new ProtoTransportEntityService(transportService3);
    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService5 =
        new HashPartitionService(
            serviceInfoProvider12,
            tenantRoutingInfoService5,
            applicationEventPublisher5,
            queueRoutingInfoService5,
            new TopicService());
    ApplicationEventPublisher eventPublisher4 = mock(ApplicationEventPublisher.class);
    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory4 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache5 =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache4 =
        new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService4 =
        new DefaultTransportService(
            null,
            null,
            null,
            null,
            topicService5,
            serviceInfoProvider13,
            statsFactory4,
            deviceProfileCache5,
            tenantProfileCache4,
            null,
            new DefaultSchedulerComponent(),
            mock(ApplicationEventPublisher.class),
            null,
            mock(NotificationRuleProcessor.class),
            null);
    SnmpTransportService snmpTransportService2 =
        new SnmpTransportService(transportService4, new PduService());
    SnmpTransportBalancingService balancingService =
        new SnmpTransportBalancingService(
            partitionService5, eventPublisher4, snmpTransportService2);
    TopicService topicService6 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider14 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory5 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache6 =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache5 =
        new DefaultTransportTenantProfileCache();
    DefaultTransportService transportService5 =
        new DefaultTransportService(
            null,
            null,
            null,
            null,
            topicService6,
            serviceInfoProvider14,
            statsFactory5,
            deviceProfileCache6,
            tenantProfileCache5,
            null,
            new DefaultSchedulerComponent(),
            mock(ApplicationEventPublisher.class),
            null,
            mock(NotificationRuleProcessor.class),
            null);
    SnmpTransportService snmpTransportService3 =
        new SnmpTransportService(transportService5, new PduService());
    SnmpTransportContext snmpTransportContext =
        new SnmpTransportContext(
            snmpTransportService,
            deviceProfileCache2,
            transportService2,
            protoEntityService,
            balancingService,
            new SnmpAuthService(snmpTransportService3));
    DeviceSessionContextBuilder actualSnmpTransportContextResult =
        actualProfileTransportConfigurationResult.snmpTransportContext(snmpTransportContext);
    DeviceSessionContextBuilder actualTenantIdResult =
        actualSnmpTransportContextResult.tenantId(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceSessionContextBuilder actualTokenResult = actualTenantIdResult.token("ABC123");

    // Assert
    assertSame(actualTenantIdResult, actualTokenResult);
  }

  /**
   * Test {@link DeviceSessionContext#DeviceSessionContext(TenantId, Device, DeviceProfile, String,
   * SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration,
   * SnmpTransportContext)}.
   *
   * <ul>
   *   <li>Given {@link CommunityTarget#CommunityTarget()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionContext#DeviceSessionContext(TenantId, Device,
   * DeviceProfile, String, SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration, SnmpTransportContext)}
   */
  @Test
  @DisplayName(
      "Test new DeviceSessionContext(TenantId, Device, DeviceProfile, String, SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration, SnmpTransportContext); given CommunityTarget()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceSessionContext.<init>(TenantId, Device, DeviceProfile, String, SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration, SnmpTransportContext)"
  })
  void testNewDeviceSessionContext_givenCommunityTarget() throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceTransportConfiguration deviceTransportConfiguration =
        mock(SnmpDeviceTransportConfiguration.class);

    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    CommunityTarget<Address> communityTarget = new CommunityTarget<>();
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(communityTarget);
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings,
            transportNotificationSettings,
            serviceInfoProvider2,
            coreSettings,
            storage,
            new TopicService());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService = new TbRuleEngineProducerService(null);
    TopicService topicService = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService =
        new DefaultTransportService(
            partitionService,
            queueProvider,
            producerProvider,
            ruleEngineProducerService,
            topicService,
            serviceInfoProvider3,
            statsFactory,
            deviceProfileCache,
            tenantProfileCache,
            rateLimitService,
            scheduler,
            eventPublisher,
            transportResourceCache,
            notificationRuleProcessor,
            new DefaultEntityLimitsCache(1, 3));
    SnmpTransportService snmpTransportService =
        new SnmpTransportService(transportService, new PduService());
    DefaultTransportDeviceProfileCache deviceProfileCache2 =
        new DefaultTransportDeviceProfileCache();
    DefaultTbServiceInfoProvider serviceInfoProvider4 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService2 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher2 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService2 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService2 =
        new HashPartitionService(
            serviceInfoProvider4,
            tenantRoutingInfoService2,
            applicationEventPublisher2,
            queueRoutingInfoService2,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage2 = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider2 =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings2,
            transportNotificationSettings2,
            serviceInfoProvider5,
            coreSettings2,
            storage2,
            new TopicService());
    TopicService topicService2 = new TopicService();
    TbQueueCoreSettings coreSettings3 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider6 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings3 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings3 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService2,
            coreSettings3,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider6,
            transportApiSettings3,
            transportNotificationSettings3,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider2 =
        new TbCoreQueueProducerProvider(tbQueueProvider);
    DefaultTbServiceInfoProvider serviceInfoProvider7 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService3 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher3 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService3 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService3 =
        new HashPartitionService(
            serviceInfoProvider7,
            tenantRoutingInfoService3,
            applicationEventPublisher3,
            queueRoutingInfoService3,
            new TopicService());
    TbRuleEngineProducerService ruleEngineProducerService2 =
        new TbRuleEngineProducerService(partitionService3);
    TopicService topicService3 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider8 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory2 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache3 =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache2 =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService2 =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler2 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache2 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor2 = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService2 =
        new DefaultTransportService(
            partitionService2,
            queueProvider2,
            producerProvider2,
            ruleEngineProducerService2,
            topicService3,
            serviceInfoProvider8,
            statsFactory2,
            deviceProfileCache3,
            tenantProfileCache2,
            rateLimitService2,
            scheduler2,
            eventPublisher2,
            transportResourceCache2,
            notificationRuleProcessor2,
            new DefaultEntityLimitsCache(1, 3));
    DefaultTbServiceInfoProvider serviceInfoProvider9 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService4 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher4 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService4 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService4 =
        new HashPartitionService(
            serviceInfoProvider9,
            tenantRoutingInfoService4,
            applicationEventPublisher4,
            queueRoutingInfoService4,
            new TopicService());
    TbQueueTransportApiSettings transportApiSettings4 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings4 =
        new TbQueueTransportNotificationSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider10 = new DefaultTbServiceInfoProvider();
    TbQueueCoreSettings coreSettings4 = new TbQueueCoreSettings();
    DefaultInMemoryStorage storage3 = new DefaultInMemoryStorage();

    InMemoryTbTransportQueueFactory queueProvider3 =
        new InMemoryTbTransportQueueFactory(
            transportApiSettings4,
            transportNotificationSettings4,
            serviceInfoProvider10,
            coreSettings4,
            storage3,
            new TopicService());
    TbCoreQueueProducerProvider producerProvider3 = new TbCoreQueueProducerProvider(null);
    TbRuleEngineProducerService ruleEngineProducerService3 = new TbRuleEngineProducerService(null);
    TopicService topicService4 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider11 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory3 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache4 =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache3 =
        new DefaultTransportTenantProfileCache();
    DefaultTransportRateLimitService rateLimitService3 =
        new DefaultTransportRateLimitService(new DefaultTransportTenantProfileCache());
    DefaultSchedulerComponent scheduler3 = new DefaultSchedulerComponent();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    DefaultTransportResourceCache transportResourceCache3 = new DefaultTransportResourceCache(null);
    NotificationRuleProcessor notificationRuleProcessor3 = mock(NotificationRuleProcessor.class);

    DefaultTransportService transportService3 =
        new DefaultTransportService(
            partitionService4,
            queueProvider3,
            producerProvider3,
            ruleEngineProducerService3,
            topicService4,
            serviceInfoProvider11,
            statsFactory3,
            deviceProfileCache4,
            tenantProfileCache3,
            rateLimitService3,
            scheduler3,
            eventPublisher3,
            transportResourceCache3,
            notificationRuleProcessor3,
            new DefaultEntityLimitsCache(1, 3));
    ProtoTransportEntityService protoEntityService =
        new ProtoTransportEntityService(transportService3);
    DefaultTbServiceInfoProvider serviceInfoProvider12 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService5 = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher5 = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService5 = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService5 =
        new HashPartitionService(
            serviceInfoProvider12,
            tenantRoutingInfoService5,
            applicationEventPublisher5,
            queueRoutingInfoService5,
            new TopicService());
    ApplicationEventPublisher eventPublisher4 = mock(ApplicationEventPublisher.class);
    TopicService topicService5 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider13 = new DefaultTbServiceInfoProvider();
    DefaultStatsFactory statsFactory4 = new DefaultStatsFactory();
    DefaultTransportDeviceProfileCache deviceProfileCache5 =
        new DefaultTransportDeviceProfileCache();
    DefaultTransportTenantProfileCache tenantProfileCache4 =
        new DefaultTransportTenantProfileCache();

    DefaultTransportService transportService4 =
        new DefaultTransportService(
            null,
            null,
            null,
            null,
            topicService5,
            serviceInfoProvider13,
            statsFactory4,
            deviceProfileCache5,
            tenantProfileCache4,
            null,
            new DefaultSchedulerComponent(),
            mock(ApplicationEventPublisher.class),
            null,
            mock(NotificationRuleProcessor.class),
            null);
    SnmpTransportService snmpTransportService2 =
        new SnmpTransportService(transportService4, new PduService());

    SnmpTransportBalancingService balancingService =
        new SnmpTransportBalancingService(
            partitionService5, eventPublisher4, snmpTransportService2);

    SnmpTransportContext snmpTransportContext =
        new SnmpTransportContext(
            snmpTransportService,
            deviceProfileCache2,
            transportService2,
            protoEntityService,
            balancingService,
            snmpAuthService);

    // Act
    DeviceSessionContext actualDeviceSessionContext =
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile,
            "ABC123",
            profileTransportConfiguration,
            deviceTransportConfiguration,
            snmpTransportContext);

    // Assert
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
    Target target = actualDeviceSessionContext.getTarget();
    assertTrue(target instanceof CommunityTarget);
    assertEquals("ABC123", actualDeviceSessionContext.getToken());
    assertNull(actualDeviceSessionContext.getDeviceId());
    assertNull(actualDeviceSessionContext.getDeviceInfo());
    assertNull(actualDeviceSessionContext.getSessionInfo());
    assertFalse(actualDeviceSessionContext.isConnected());
    assertTrue(actualDeviceSessionContext.getQueryingTasks().isEmpty());
    assertTrue(actualDeviceSessionContext.isActive());
    assertSame(communityTarget, target);
    assertSame(device, actualDeviceSessionContext.getDevice());
    assertSame(deviceProfile, actualDeviceSessionContext.getDeviceProfile());
    assertSame(
        profileTransportConfiguration,
        actualDeviceSessionContext.getProfileTransportConfiguration());
    assertSame(tenantId, actualDeviceSessionContext.getTenantId());
    assertSame(
        deviceTransportConfiguration, actualDeviceSessionContext.getDeviceTransportConfiguration());
  }

  /**
   * Test {@link DeviceSessionContext#DeviceSessionContext(TenantId, Device, DeviceProfile, String,
   * SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration,
   * SnmpTransportContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SnmpTransportContext#getSnmpAuthService()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceSessionContext#DeviceSessionContext(TenantId, Device,
   * DeviceProfile, String, SnmpDeviceProfileTransportConfiguration,
   * SnmpDeviceTransportConfiguration, SnmpTransportContext)}
   */
  @Test
  @DisplayName(
      "Test new DeviceSessionContext(TenantId, Device, DeviceProfile, String, SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration, SnmpTransportContext); then calls getSnmpAuthService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceSessionContext.<init>(TenantId, Device, DeviceProfile, String, SnmpDeviceProfileTransportConfiguration, SnmpDeviceTransportConfiguration, SnmpTransportContext)"
  })
  void testNewDeviceSessionContext_thenCallsGetSnmpAuthService() throws Exception {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    SnmpDeviceTransportConfiguration deviceTransportConfiguration =
        mock(SnmpDeviceTransportConfiguration.class);

    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    CommunityTarget<Address> communityTarget = new CommunityTarget<>();
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(communityTarget);

    SnmpTransportContext snmpTransportContext = mock(SnmpTransportContext.class);
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);

    // Act
    DeviceSessionContext actualDeviceSessionContext =
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile,
            "ABC123",
            profileTransportConfiguration,
            deviceTransportConfiguration,
            snmpTransportContext);

    // Assert
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
    Target target = actualDeviceSessionContext.getTarget();
    assertTrue(target instanceof CommunityTarget);
    assertEquals("ABC123", actualDeviceSessionContext.getToken());
    assertNull(actualDeviceSessionContext.getDeviceId());
    assertNull(actualDeviceSessionContext.getDeviceInfo());
    assertNull(actualDeviceSessionContext.getSessionInfo());
    assertFalse(actualDeviceSessionContext.isConnected());
    assertTrue(actualDeviceSessionContext.getQueryingTasks().isEmpty());
    assertTrue(actualDeviceSessionContext.isActive());
    assertSame(communityTarget, target);
    assertSame(device, actualDeviceSessionContext.getDevice());
    assertSame(deviceProfile, actualDeviceSessionContext.getDeviceProfile());
    assertSame(
        profileTransportConfiguration,
        actualDeviceSessionContext.getProfileTransportConfiguration());
    assertSame(tenantId, actualDeviceSessionContext.getTenantId());
    assertSame(
        deviceTransportConfiguration, actualDeviceSessionContext.getDeviceTransportConfiguration());
  }
}
