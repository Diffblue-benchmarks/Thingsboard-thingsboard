package org.thingsboard.server.transport.snmp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.snmp4j.CommunityTarget;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceTransportType;
import org.thingsboard.server.common.data.device.data.DeviceConfiguration;
import org.thingsboard.server.common.data.device.data.DeviceData;
import org.thingsboard.server.common.data.device.data.DeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.SnmpDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.DeviceUpdatedEvent;
import org.thingsboard.server.common.transport.TransportDeviceProfileCache;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
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
import org.thingsboard.server.transport.snmp.service.PduService;
import org.thingsboard.server.transport.snmp.service.ProtoTransportEntityService;
import org.thingsboard.server.transport.snmp.service.SnmpAuthService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportBalancingService;
import org.thingsboard.server.transport.snmp.service.SnmpTransportService;
import org.thingsboard.server.transport.snmp.session.DeviceSessionContext;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class SnmpTransportContextDiffblueTest {
  @Mock private ProtoTransportEntityService protoTransportEntityService;

  @Mock private SnmpAuthService snmpAuthService;

  @Mock private SnmpTransportBalancingService snmpTransportBalancingService;

  @InjectMocks private SnmpTransportContext snmpTransportContext;

  @Mock private SnmpTransportService snmpTransportService;

  @Mock private TransportDeviceProfileCache transportDeviceProfileCache;

  @Mock private TransportService transportService;

  /**
   * Test {@link SnmpTransportContext#onDeviceUpdatedOrCreated(DeviceUpdatedEvent)}.
   *
   * <p>Method under test: {@link SnmpTransportContext#onDeviceUpdatedOrCreated(DeviceUpdatedEvent)}
   */
  @Test
  @DisplayName("Test onDeviceUpdatedOrCreated(DeviceUpdatedEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpTransportContext.onDeviceUpdatedOrCreated(DeviceUpdatedEvent)"})
  void testOnDeviceUpdatedOrCreated() {
    // Arrange
    DeviceTransportConfiguration transportConfiguration = mock(DeviceTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.DEFAULT);

    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(transportConfiguration);

    Device device = mock(Device.class);
    when(device.getId()).thenReturn(null);
    when(device.getDeviceData()).thenReturn(deviceData);

    // Act
    snmpTransportContext.onDeviceUpdatedOrCreated(new DeviceUpdatedEvent(device));

    // Assert
    verify(device).getDeviceData();
    verify(device).getId();
    verify(transportConfiguration).getType();
  }

  /**
   * Test {@link SnmpTransportContext#onDeviceUpdatedOrCreated(DeviceUpdatedEvent)}.
   *
   * <ul>
   *   <li>Then calls {@link Device#getDeviceProfileId()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportContext#onDeviceUpdatedOrCreated(DeviceUpdatedEvent)}
   */
  @Test
  @DisplayName("Test onDeviceUpdatedOrCreated(DeviceUpdatedEvent); then calls getDeviceProfileId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpTransportContext.onDeviceUpdatedOrCreated(DeviceUpdatedEvent)"})
  void testOnDeviceUpdatedOrCreated_thenCallsGetDeviceProfileId() {
    // Arrange
    when(transportDeviceProfileCache.get(Mockito.<DeviceProfileId>any()))
        .thenReturn(new DeviceProfile());
    when(protoTransportEntityService.getDeviceCredentialsByDeviceId(Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());
    when(snmpTransportBalancingService.isManagedByCurrentTransport(Mockito.<UUID>any()))
        .thenReturn(true);

    DeviceTransportConfiguration transportConfiguration = mock(DeviceTransportConfiguration.class);
    when(transportConfiguration.getType()).thenReturn(DeviceTransportType.SNMP);

    DeviceData deviceData = new DeviceData();
    deviceData.setConfiguration(mock(DeviceConfiguration.class));
    deviceData.setTransportConfiguration(transportConfiguration);

    Device device = mock(Device.class);
    when(device.getDeviceProfileId()).thenReturn(null);
    when(device.getId())
        .thenReturn(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(device.getDeviceData()).thenReturn(deviceData);

    // Act
    snmpTransportContext.onDeviceUpdatedOrCreated(new DeviceUpdatedEvent(device));

    // Assert
    verify(device).getDeviceData();
    verify(device).getDeviceProfileId();
    verify(device, atLeast(1)).getId();
    verify(transportConfiguration).getType();
    verify(transportDeviceProfileCache).get(isNull());
    verify(protoTransportEntityService).getDeviceCredentialsByDeviceId(isA(DeviceId.class));
    verify(snmpTransportBalancingService).isManagedByCurrentTransport(isA(UUID.class));
  }

  /**
   * Test {@link SnmpTransportContext#onDeviceDeleted(DeviceSessionContext)}.
   *
   * <p>Method under test: {@link SnmpTransportContext#onDeviceDeleted(DeviceSessionContext)}
   */
  @Test
  @DisplayName("Test onDeviceDeleted(DeviceSessionContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpTransportContext.onDeviceDeleted(DeviceSessionContext)"})
  void testOnDeviceDeleted() throws Exception {
    // Arrange
    doNothing()
        .when(transportService)
        .lifecycleEvent(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<ComponentLifecycleEvent>any(),
            anyBoolean(),
            Mockito.<Throwable>any());
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing().when(snmpTransportService).cancelQueryingTasks(Mockito.<DeviceSessionContext>any());
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    doNothing().when(snmpAuthService).cleanUpSnmpAuthInfo(Mockito.<DeviceSessionContext>any());

    Device device = mock(Device.class);
    when(device.getId())
        .thenReturn(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceProfile deviceProfile = new DeviceProfile();
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();

    DeviceSessionContext sessionContext =
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile,
            "ABC123",
            profileTransportConfiguration,
            new SnmpDeviceTransportConfiguration(),
            snmpTransportContext);

    // Act
    snmpTransportContext.onDeviceDeleted(sessionContext);

    // Assert
    verify(device, atLeast(1)).getId();
    verify(transportService).deregisterSession(isNull());
    verify(transportService)
        .lifecycleEvent(
            isA(TenantId.class),
            isA(DeviceId.class),
            eq(ComponentLifecycleEvent.STOPPED),
            eq(true),
            isNull());
    verify(snmpAuthService).cleanUpSnmpAuthInfo(isA(DeviceSessionContext.class));
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
    verify(snmpTransportService).cancelQueryingTasks(isA(DeviceSessionContext.class));
    assertFalse(sessionContext.isActive());
  }

  /**
   * Test {@link SnmpTransportContext#onDeviceProfileUpdated(DeviceProfile, DeviceSessionContext)}.
   *
   * <p>Method under test: {@link SnmpTransportContext#onDeviceProfileUpdated(DeviceProfile,
   * DeviceSessionContext)}
   */
  @Test
  @DisplayName("Test onDeviceProfileUpdated(DeviceProfile, DeviceSessionContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportContext.onDeviceProfileUpdated(DeviceProfile, DeviceSessionContext)"
  })
  void testOnDeviceProfileUpdated() throws Exception {
    // Arrange
    doNothing()
        .when(transportService)
        .lifecycleEvent(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<ComponentLifecycleEvent>any(),
            anyBoolean(),
            Mockito.<Throwable>any());
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing().when(snmpTransportService).cancelQueryingTasks(Mockito.<DeviceSessionContext>any());
    when(protoTransportEntityService.getDeviceCredentialsByDeviceId(Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    doNothing().when(snmpAuthService).cleanUpSnmpAuthInfo(Mockito.<DeviceSessionContext>any());
    DeviceProfile deviceProfile = new DeviceProfile();

    Device device = mock(Device.class);
    when(device.getId())
        .thenReturn(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceProfile deviceProfile2 = new DeviceProfile();
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();

    DeviceSessionContext sessionContext =
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile2,
            "ABC123",
            profileTransportConfiguration,
            new SnmpDeviceTransportConfiguration(),
            snmpTransportContext);

    // Act
    snmpTransportContext.onDeviceProfileUpdated(deviceProfile, sessionContext);

    // Assert
    verify(device, atLeast(1)).getId();
    verify(transportService).deregisterSession(isNull());
    verify(transportService)
        .lifecycleEvent(
            isA(TenantId.class),
            isA(DeviceId.class),
            eq(ComponentLifecycleEvent.STOPPED),
            eq(true),
            isNull());
    verify(protoTransportEntityService).getDeviceCredentialsByDeviceId(isA(DeviceId.class));
    verify(snmpAuthService).cleanUpSnmpAuthInfo(isA(DeviceSessionContext.class));
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
    verify(snmpTransportService).cancelQueryingTasks(isA(DeviceSessionContext.class));
    assertFalse(sessionContext.isActive());
  }

  /**
   * Test {@link SnmpTransportContext#onDeviceProfileUpdated(DeviceProfile, DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Given {@link Device#Device()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportContext#onDeviceProfileUpdated(DeviceProfile,
   * DeviceSessionContext)}
   */
  @Test
  @DisplayName("Test onDeviceProfileUpdated(DeviceProfile, DeviceSessionContext); given Device()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportContext.onDeviceProfileUpdated(DeviceProfile, DeviceSessionContext)"
  })
  void testOnDeviceProfileUpdated_givenDevice() throws Exception {
    // Arrange
    doNothing()
        .when(transportService)
        .lifecycleEvent(
            Mockito.<TenantId>any(),
            Mockito.<DeviceId>any(),
            Mockito.<ComponentLifecycleEvent>any(),
            anyBoolean(),
            Mockito.<Throwable>any());
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing().when(snmpTransportService).cancelQueryingTasks(Mockito.<DeviceSessionContext>any());
    when(protoTransportEntityService.getDeviceCredentialsByDeviceId(Mockito.<DeviceId>any()))
        .thenReturn(new DeviceCredentials());
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    doNothing().when(snmpAuthService).cleanUpSnmpAuthInfo(Mockito.<DeviceSessionContext>any());
    DeviceProfile deviceProfile = new DeviceProfile();

    Device device = mock(Device.class);
    when(device.getId())
        .thenReturn(new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceProfile deviceProfile2 = new DeviceProfile();
    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();

    DeviceSessionContext sessionContext =
        new DeviceSessionContext(
            tenantId,
            device,
            deviceProfile2,
            "ABC123",
            profileTransportConfiguration,
            new SnmpDeviceTransportConfiguration(),
            snmpTransportContext);
    sessionContext.setDevice(new Device());

    // Act
    snmpTransportContext.onDeviceProfileUpdated(deviceProfile, sessionContext);

    // Assert
    verify(device).getId();
    verify(transportService).deregisterSession(isNull());
    verify(transportService)
        .lifecycleEvent(
            isA(TenantId.class),
            isA(DeviceId.class),
            eq(ComponentLifecycleEvent.STOPPED),
            eq(true),
            isNull());
    verify(protoTransportEntityService).getDeviceCredentialsByDeviceId(isNull());
    verify(snmpAuthService).cleanUpSnmpAuthInfo(isA(DeviceSessionContext.class));
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
    verify(snmpTransportService).cancelQueryingTasks(isA(DeviceSessionContext.class));
    assertFalse(sessionContext.isActive());
  }

  /**
   * Test {@link SnmpTransportContext#getSessions()}.
   *
   * <p>Method under test: {@link SnmpTransportContext#getSessions()}
   */
  @Test
  @DisplayName("Test getSessions()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.Collection SnmpTransportContext.getSessions()"})
  void testGetSessions() {
    // Arrange
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

    // Act and Assert
    assertTrue(snmpTransportContext.getSessions().isEmpty());
  }
}
