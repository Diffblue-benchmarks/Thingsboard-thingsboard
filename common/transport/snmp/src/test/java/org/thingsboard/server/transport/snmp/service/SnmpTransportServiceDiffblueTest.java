package org.thingsboard.server.transport.snmp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
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
import org.snmp4j.event.ResponseEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.data.SnmpDeviceTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.SnmpDeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.transport.snmp.config.SnmpCommunicationConfig;
import org.thingsboard.server.common.data.transport.snmp.config.ToServerRpcRequestSnmpCommunicationConfig;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.transport.limits.DefaultEntityLimitsCache;
import org.thingsboard.server.common.transport.limits.DefaultTransportRateLimitService;
import org.thingsboard.server.common.transport.service.DefaultTransportDeviceProfileCache;
import org.thingsboard.server.common.transport.service.DefaultTransportResourceCache;
import org.thingsboard.server.common.transport.service.DefaultTransportService;
import org.thingsboard.server.common.transport.service.DefaultTransportTenantProfileCache;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.AttributeUpdateNotificationMsg;
import org.thingsboard.server.gen.transport.TransportProtos.ToDeviceRpcRequestMsg;
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
import org.thingsboard.server.transport.snmp.session.DeviceSessionContext;

@ExtendWith(MockitoExtension.class)
class SnmpTransportServiceDiffblueTest {
  @Mock private SnmpTransportContext snmpTransportContext;

  @InjectMocks private SnmpTransportService snmpTransportService;

  /**
   * Test {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}
   */
  @Test
  @DisplayName("Test createQueryingTasks(DeviceSessionContext); given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpTransportService.createQueryingTasks(DeviceSessionContext)"})
  void testCreateQueryingTasks_givenArrayList() throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);

    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    profileTransportConfiguration.setCommunicationConfigs(new ArrayList<>());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();

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
    snmpTransportService.createQueryingTasks(sessionContext);

    // Assert
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then calls {@link SnmpDeviceProfileTransportConfiguration#getCommunicationConfigs()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}
   */
  @Test
  @DisplayName(
      "Test createQueryingTasks(DeviceSessionContext); given ArrayList() add 'null'; then calls getCommunicationConfigs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpTransportService.createQueryingTasks(DeviceSessionContext)"})
  void testCreateQueryingTasks_givenArrayListAddNull_thenCallsGetCommunicationConfigs()
      throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);

    ArrayList<SnmpCommunicationConfig> snmpCommunicationConfigList = new ArrayList<>();
    snmpCommunicationConfigList.add(null);

    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        mock(SnmpDeviceProfileTransportConfiguration.class);
    when(profileTransportConfiguration.getCommunicationConfigs())
        .thenReturn(snmpCommunicationConfigList);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();

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
    snmpTransportService.createQueryingTasks(sessionContext);

    // Assert
    verify(profileTransportConfiguration).getCommunicationConfigs();
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SnmpDeviceProfileTransportConfiguration#getCommunicationConfigs()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#createQueryingTasks(DeviceSessionContext)}
   */
  @Test
  @DisplayName(
      "Test createQueryingTasks(DeviceSessionContext); then calls getCommunicationConfigs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpTransportService.createQueryingTasks(DeviceSessionContext)"})
  void testCreateQueryingTasks_thenCallsGetCommunicationConfigs() throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);

    ArrayList<SnmpCommunicationConfig> snmpCommunicationConfigList = new ArrayList<>();
    snmpCommunicationConfigList.add(new ToServerRpcRequestSnmpCommunicationConfig());
    snmpCommunicationConfigList.add(null);

    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        mock(SnmpDeviceProfileTransportConfiguration.class);
    when(profileTransportConfiguration.getCommunicationConfigs())
        .thenReturn(snmpCommunicationConfigList);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();

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
    snmpTransportService.createQueryingTasks(sessionContext);

    // Assert
    verify(profileTransportConfiguration).getCommunicationConfigs();
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link SnmpTransportService#cancelQueryingTasks(DeviceSessionContext)}.
   *
   * <ul>
   *   <li>Then calls {@link SnmpTransportContext#getSnmpAuthService()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#cancelQueryingTasks(DeviceSessionContext)}
   */
  @Test
  @DisplayName("Test cancelQueryingTasks(DeviceSessionContext); then calls getSnmpAuthService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void SnmpTransportService.cancelQueryingTasks(DeviceSessionContext)"})
  void testCancelQueryingTasks_thenCallsGetSnmpAuthService() throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
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
    snmpTransportService.cancelQueryingTasks(sessionContext);

    // Assert
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link SnmpTransportService#onAttributeUpdate(DeviceSessionContext,
   * AttributeUpdateNotificationMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ToServerRpcRequestSnmpCommunicationConfig}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#onAttributeUpdate(DeviceSessionContext,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test onAttributeUpdate(DeviceSessionContext, AttributeUpdateNotificationMsg); given ArrayList() add ToServerRpcRequestSnmpCommunicationConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportService.onAttributeUpdate(DeviceSessionContext, AttributeUpdateNotificationMsg)"
  })
  void testOnAttributeUpdate_givenArrayListAddToServerRpcRequestSnmpCommunicationConfig()
      throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);

    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(new ToServerRpcRequestSnmpCommunicationConfig());

    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    profileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();

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
    snmpTransportService.onAttributeUpdate(
        sessionContext, AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link SnmpTransportService#onAttributeUpdate(DeviceSessionContext,
   * AttributeUpdateNotificationMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ToServerRpcRequestSnmpCommunicationConfig}
   *       (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#onAttributeUpdate(DeviceSessionContext,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test onAttributeUpdate(DeviceSessionContext, AttributeUpdateNotificationMsg); given ArrayList() add ToServerRpcRequestSnmpCommunicationConfig (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportService.onAttributeUpdate(DeviceSessionContext, AttributeUpdateNotificationMsg)"
  })
  void testOnAttributeUpdate_givenArrayListAddToServerRpcRequestSnmpCommunicationConfig2()
      throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);

    ArrayList<SnmpCommunicationConfig> communicationConfigs = new ArrayList<>();
    communicationConfigs.add(new ToServerRpcRequestSnmpCommunicationConfig());
    communicationConfigs.add(new ToServerRpcRequestSnmpCommunicationConfig());

    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    profileTransportConfiguration.setCommunicationConfigs(communicationConfigs);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();

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
    snmpTransportService.onAttributeUpdate(
        sessionContext, AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link SnmpTransportService#onAttributeUpdate(DeviceSessionContext,
   * AttributeUpdateNotificationMsg)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link SnmpTransportContext#getSnmpAuthService()}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#onAttributeUpdate(DeviceSessionContext,
   * AttributeUpdateNotificationMsg)}
   */
  @Test
  @DisplayName(
      "Test onAttributeUpdate(DeviceSessionContext, AttributeUpdateNotificationMsg); given ArrayList(); then calls getSnmpAuthService()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportService.onAttributeUpdate(DeviceSessionContext, AttributeUpdateNotificationMsg)"
  })
  void testOnAttributeUpdate_givenArrayList_thenCallsGetSnmpAuthService() throws Exception {
    // Arrange
    SnmpAuthService snmpAuthService = mock(SnmpAuthService.class);
    when(snmpAuthService.setUpSnmpTarget(
            Mockito.<SnmpDeviceProfileTransportConfiguration>any(),
            Mockito.<SnmpDeviceTransportConfiguration>any()))
        .thenReturn(new CommunityTarget<>());
    when(snmpTransportContext.getSnmpAuthService()).thenReturn(snmpAuthService);

    SnmpDeviceProfileTransportConfiguration profileTransportConfiguration =
        new SnmpDeviceProfileTransportConfiguration();
    profileTransportConfiguration.setCommunicationConfigs(new ArrayList<>());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Device device = new Device();
    DeviceProfile deviceProfile = new DeviceProfile();

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
    snmpTransportService.onAttributeUpdate(
        sessionContext, AttributeUpdateNotificationMsg.getDefaultInstance());

    // Assert
    verify(snmpTransportContext).getSnmpAuthService();
    verify(snmpAuthService)
        .setUpSnmpTarget(
            isA(SnmpDeviceProfileTransportConfiguration.class),
            isA(SnmpDeviceTransportConfiguration.class));
  }

  /**
   * Test {@link SnmpTransportService#onToDeviceRpcRequest(DeviceSessionContext,
   * ToDeviceRpcRequestMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link SnmpTransportService#onToDeviceRpcRequest(DeviceSessionContext,
   * TransportProtos.ToDeviceRpcRequestMsg)}
   */
  @Test
  @DisplayName(
      "Test onToDeviceRpcRequest(DeviceSessionContext, ToDeviceRpcRequestMsg); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportService.onToDeviceRpcRequest(DeviceSessionContext, TransportProtos.ToDeviceRpcRequestMsg)"
  })
  void testOnToDeviceRpcRequest_thenThrowIllegalArgumentException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
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
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
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
            topicService2,
            serviceInfoProvider5,
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
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);

    ToDeviceRpcRequestMsg toDeviceRpcRequestMsg = mock(ToDeviceRpcRequestMsg.class);
    when(toDeviceRpcRequestMsg.getMethodName()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> snmpTransportService.onToDeviceRpcRequest(sessionContext, toDeviceRpcRequestMsg));
    verify(toDeviceRpcRequestMsg).getMethodName();
  }

  /**
   * Test {@link SnmpTransportService#processResponseEvent(DeviceSessionContext, ResponseEvent)}.
   *
   * <p>Method under test: {@link SnmpTransportService#processResponseEvent(DeviceSessionContext,
   * ResponseEvent)}
   */
  @Test
  @DisplayName("Test processResponseEvent(DeviceSessionContext, ResponseEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SnmpTransportService.processResponseEvent(DeviceSessionContext, ResponseEvent)"
  })
  void testProcessResponseEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

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
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
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
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
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
            topicService2,
            serviceInfoProvider5,
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
    DeviceSessionContext sessionContext = mock(DeviceSessionContext.class);

    ResponseEvent event = mock(ResponseEvent.class);
    when(event.getSource()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> snmpTransportService.processResponseEvent(sessionContext, event));
    verify(event).getSource();
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SnmpTransportService#getName()}
   *   <li>{@link SnmpTransportService#getSnmp()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String SnmpTransportService.getName()",
    "org.snmp4j.Snmp SnmpTransportService.getSnmp()"
  })
  void testGettersAndSetters() {
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
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings2 = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings2 = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings2 =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings2,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider3,
            transportApiSettings2,
            transportNotificationSettings2,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
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
    TbRuleEngineProducerService ruleEngineProducerService =
        new TbRuleEngineProducerService(partitionService2);
    TopicService topicService2 = new TopicService();
    DefaultTbServiceInfoProvider serviceInfoProvider5 = new DefaultTbServiceInfoProvider();
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
            topicService2,
            serviceInfoProvider5,
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

    // Act
    String actualName = snmpTransportService.getName();

    // Assert
    assertEquals("SNMP", actualName);
    assertNull(snmpTransportService.getSnmp());
  }
}
