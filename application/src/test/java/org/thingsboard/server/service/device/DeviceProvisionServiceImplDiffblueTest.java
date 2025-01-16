package org.thingsboard.server.service.device;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.device.credentials.ProvisionDeviceCredentialsData;
import org.thingsboard.server.common.data.device.profile.AllowCreateNewDevicesDeviceProfileProvisionConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileAlarm;
import org.thingsboard.server.common.data.device.profile.DeviceProfileConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileData;
import org.thingsboard.server.common.data.device.profile.DeviceProfileProvisionConfiguration;
import org.thingsboard.server.common.data.device.profile.DeviceProfileTransportConfiguration;
import org.thingsboard.server.common.data.device.profile.ProvisionDeviceProfileCredentials;
import org.thingsboard.server.common.data.device.profile.X509CertificateChainProvisionConfiguration;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.device.provision.ProvisionFailedException;
import org.thingsboard.server.dao.device.provision.ProvisionRequest;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
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

class DeviceProvisionServiceImplDiffblueTest {
  /**
   * Test
   * {@link DeviceProvisionServiceImpl#provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link DeviceProfile#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest); given 'null'; then calls getId()")
  void testProvisionDeviceViaX509Chain_givenNull_thenCallsGetId() throws ProvisionFailedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile targetProfile = mock(DeviceProfile.class);
    when(targetProfile.getId()).thenReturn(null);
    when(targetProfile.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(targetProfile.getProfileData()).thenReturn(deviceProfileData);
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl.provisionDeviceViaX509Chain(targetProfile,
            new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true)));
    verify(targetProfile, atLeast(1)).getId();
    verify(targetProfile, atLeast(1)).getProfileData();
    verify(targetProfile, atLeast(1)).getTenantId();
  }

  /**
   * Test
   * {@link DeviceProvisionServiceImpl#provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest)}.
   * <ul>
   *   <li>Then calls {@link DeviceProfileData#getProvisionConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest); then calls getProvisionConfiguration()")
  void testProvisionDeviceViaX509Chain_thenCallsGetProvisionConfiguration() throws ProvisionFailedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration())
        .thenReturn(new AllowCreateNewDevicesDeviceProfileProvisionConfiguration("Provision Device Secret"));
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile targetProfile = mock(DeviceProfile.class);
    when(targetProfile.getProfileData()).thenReturn(deviceProfileData);
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl.provisionDeviceViaX509Chain(targetProfile,
            new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true)));
    verify(targetProfile).getProfileData();
    verify(deviceProfileData).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test
   * {@link DeviceProvisionServiceImpl#provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest); then throw IllegalArgumentException")
  void testProvisionDeviceViaX509Chain_thenThrowIllegalArgumentException() throws ProvisionFailedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));

    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile targetProfile = mock(DeviceProfile.class);
    when(targetProfile.getTenantId()).thenThrow(new IllegalArgumentException(" "));
    when(targetProfile.getProfileData()).thenReturn(deviceProfileData);
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> deviceProvisionServiceImpl.provisionDeviceViaX509Chain(targetProfile,
            new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true)));
    verify(targetProfile, atLeast(1)).getProfileData();
    verify(targetProfile).getTenantId();
  }

  /**
   * Test
   * {@link DeviceProvisionServiceImpl#provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link ProvisionFailedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDeviceViaX509Chain(DeviceProfile, ProvisionRequest); when 'null'; then throw ProvisionFailedException")
  void testProvisionDeviceViaX509Chain_whenNull_thenThrowProvisionFailedException() throws ProvisionFailedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl.provisionDeviceViaX509Chain(null,
            new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true)));
  }

  /**
   * Test {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}.
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDevice(ProvisionRequest)")
  void testProvisionDevice() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileServiceImpl deviceProfileService = mock(DeviceProfileServiceImpl.class);
    when(deviceProfileService.findDeviceProfileByProvisionDeviceKey(Mockito.<String>any())).thenReturn(null);
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl
            .provisionDevice(new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true)));
    verify(deviceProfileService).findDeviceProfileByProvisionDeviceKey(eq("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}.
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDevice(ProvisionRequest)")
  void testProvisionDevice2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration allowCreateNewDevicesDeviceProfileProvisionConfiguration = mock(
        AllowCreateNewDevicesDeviceProfileProvisionConfiguration.class);
    when(allowCreateNewDevicesDeviceProfileProvisionConfiguration.getProvisionDeviceSecret())
        .thenThrow(new ProvisionFailedException("An error occurred"));
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration())
        .thenReturn(allowCreateNewDevicesDeviceProfileProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    DeviceProfileServiceImpl deviceProfileService = mock(DeviceProfileServiceImpl.class);
    when(deviceProfileService.findDeviceProfileByProvisionDeviceKey(Mockito.<String>any())).thenReturn(deviceProfile);
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl
            .provisionDevice(new ProvisionRequest(null, DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true)));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(allowCreateNewDevicesDeviceProfileProvisionConfiguration).getProvisionDeviceSecret();
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(deviceProfileService).findDeviceProfileByProvisionDeviceKey(eq("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}.
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDevice(ProvisionRequest)")
  void testProvisionDevice3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration allowCreateNewDevicesDeviceProfileProvisionConfiguration = mock(
        AllowCreateNewDevicesDeviceProfileProvisionConfiguration.class);
    when(allowCreateNewDevicesDeviceProfileProvisionConfiguration.getProvisionDeviceSecret())
        .thenThrow(new ProvisionFailedException("An error occurred"));
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration())
        .thenReturn(allowCreateNewDevicesDeviceProfileProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    DeviceProfileServiceImpl deviceProfileService = mock(DeviceProfileServiceImpl.class);
    when(deviceProfileService.findDeviceProfileByProvisionDeviceKey(Mockito.<String>any())).thenReturn(deviceProfile);
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl
            .provisionDevice(new ProvisionRequest("", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true)));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(allowCreateNewDevicesDeviceProfileProvisionConfiguration).getProvisionDeviceSecret();
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(deviceProfileService).findDeviceProfileByProvisionDeviceKey(eq("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}.
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDevice(ProvisionRequest)")
  void testProvisionDevice4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DeviceProfileServiceImpl deviceProfileService = mock(DeviceProfileServiceImpl.class);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl
            .provisionDevice(new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials(null, "Provision Device Secret"), true)));
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}.
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDevice(ProvisionRequest)")
  void testProvisionDevice5() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DeviceProfileServiceImpl deviceProfileService = mock(DeviceProfileServiceImpl.class);
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl
            .provisionDevice(new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", null), true)));
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
  }

  /**
   * Test {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}.
   * <ul>
   *   <li>Given {@link DeviceProfileData} (default constructor) Alarms is
   * {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDevice(ProvisionRequest); given DeviceProfileData (default constructor) Alarms is ArrayList()")
  void testProvisionDevice_givenDeviceProfileDataAlarmsIsArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = new DeviceProfileData();
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    DeviceProfileServiceImpl deviceProfileService = mock(DeviceProfileServiceImpl.class);
    when(deviceProfileService.findDeviceProfileByProvisionDeviceKey(Mockito.<String>any())).thenReturn(deviceProfile);
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl
            .provisionDevice(new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true)));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(deviceProfileService).findDeviceProfileByProvisionDeviceKey(eq("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}.
   * <ul>
   *   <li>Given {@link DeviceProfileData}
   * {@link DeviceProfileData#getProvisionConfiguration()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDevice(ProvisionRequest); given DeviceProfileData getProvisionConfiguration() return 'null'")
  void testProvisionDevice_givenDeviceProfileDataGetProvisionConfigurationReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration()).thenReturn(null);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    DeviceProfileServiceImpl deviceProfileService = mock(DeviceProfileServiceImpl.class);
    when(deviceProfileService.findDeviceProfileByProvisionDeviceKey(Mockito.<String>any())).thenReturn(deviceProfile);
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl
            .provisionDevice(new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true)));
    verify(deviceProfile).getProfileData();
    verify(deviceProfileData).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(deviceProfileService).findDeviceProfileByProvisionDeviceKey(eq("Provision Device Key"));
  }

  /**
   * Test {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}.
   * <ul>
   *   <li>Then calls
   * {@link AllowCreateNewDevicesDeviceProfileProvisionConfiguration#getProvisionDeviceSecret()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#provisionDevice(ProvisionRequest)}
   */
  @Test
  @DisplayName("Test provisionDevice(ProvisionRequest); then calls getProvisionDeviceSecret()")
  void testProvisionDevice_thenCallsGetProvisionDeviceSecret() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AllowCreateNewDevicesDeviceProfileProvisionConfiguration allowCreateNewDevicesDeviceProfileProvisionConfiguration = mock(
        AllowCreateNewDevicesDeviceProfileProvisionConfiguration.class);
    when(allowCreateNewDevicesDeviceProfileProvisionConfiguration.getProvisionDeviceSecret())
        .thenThrow(new ProvisionFailedException("An error occurred"));
    DeviceProfileData deviceProfileData = mock(DeviceProfileData.class);
    when(deviceProfileData.getProvisionConfiguration())
        .thenReturn(allowCreateNewDevicesDeviceProfileProvisionConfiguration);
    doNothing().when(deviceProfileData).setAlarms(Mockito.<List<DeviceProfileAlarm>>any());
    doNothing().when(deviceProfileData).setConfiguration(Mockito.<DeviceProfileConfiguration>any());
    doNothing().when(deviceProfileData).setProvisionConfiguration(Mockito.<DeviceProfileProvisionConfiguration>any());
    doNothing().when(deviceProfileData).setTransportConfiguration(Mockito.<DeviceProfileTransportConfiguration>any());
    deviceProfileData.setAlarms(new ArrayList<>());
    deviceProfileData.setConfiguration(mock(DeviceProfileConfiguration.class));
    deviceProfileData.setProvisionConfiguration(new X509CertificateChainProvisionConfiguration());
    deviceProfileData.setTransportConfiguration(mock(DeviceProfileTransportConfiguration.class));
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getProfileData()).thenReturn(deviceProfileData);
    DeviceProfileServiceImpl deviceProfileService = mock(DeviceProfileServiceImpl.class);
    when(deviceProfileService.findDeviceProfileByProvisionDeviceKey(Mockito.<String>any())).thenReturn(deviceProfile);
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));
    ProvisionDeviceCredentialsData credentialsData = new ProvisionDeviceCredentialsData("ABC123", "42", "janedoe",
        "iloveyou", "X509 Cert Hash");

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl
            .provisionDevice(new ProvisionRequest("Device Name", DeviceCredentialsType.ACCESS_TOKEN, credentialsData,
                new ProvisionDeviceProfileCredentials("Provision Device Key", "Provision Device Secret"), true)));
    verify(deviceProfile, atLeast(1)).getProfileData();
    verify(allowCreateNewDevicesDeviceProfileProvisionConfiguration).getProvisionDeviceSecret();
    verify(deviceProfileData, atLeast(1)).getProvisionConfiguration();
    verify(deviceProfileData).setAlarms(isA(List.class));
    verify(deviceProfileData).setConfiguration(isA(DeviceProfileConfiguration.class));
    verify(deviceProfileData).setProvisionConfiguration(isA(DeviceProfileProvisionConfiguration.class));
    verify(deviceProfileData).setTransportConfiguration(isA(DeviceProfileTransportConfiguration.class));
    verify(deviceProfileService).findDeviceProfileByProvisionDeviceKey(eq("Provision Device Key"));
  }

  /**
   * Test
   * {@link DeviceProvisionServiceImpl#extractDeviceNameFromCNByRegEx(DeviceProfile, String, String)}.
   * <ul>
   *   <li>Then throw {@link ProvisionFailedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#extractDeviceNameFromCNByRegEx(DeviceProfile, String, String)}
   */
  @Test
  @DisplayName("Test extractDeviceNameFromCNByRegEx(DeviceProfile, String, String); then throw ProvisionFailedException")
  void testExtractDeviceNameFromCNByRegEx_thenThrowProvisionFailedException() throws ProvisionFailedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl.extractDeviceNameFromCNByRegEx(new DeviceProfile(), "Common Name", ".*"));
  }

  /**
   * Test
   * {@link DeviceProvisionServiceImpl#extractDeviceNameFromCNByRegEx(DeviceProfile, String, String)}.
   * <ul>
   *   <li>When {@code U}.</li>
   *   <li>Then throw {@link ProvisionFailedException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DeviceProvisionServiceImpl#extractDeviceNameFromCNByRegEx(DeviceProfile, String, String)}
   */
  @Test
  @DisplayName("Test extractDeviceNameFromCNByRegEx(DeviceProfile, String, String); when 'U'; then throw ProvisionFailedException")
  void testExtractDeviceNameFromCNByRegEx_whenU_thenThrowProvisionFailedException() throws ProvisionFailedException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(
        topicService, coreSettings, ruleEngineSettings, vcSettings, serviceInfoProvider, transportApiSettings,
        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()));
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2,
        eventService, tenantService, deviceValidator, countService, new JpaExecutorService());

    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    DeviceProvisionServiceImpl deviceProvisionServiceImpl = new DeviceProvisionServiceImpl(producerProvider,
        deviceProfileService, deviceService, deviceCredentialsService2, attributesService, auditLogService,
        new HashPartitionService(serviceInfoProvider2, tenantRoutingInfoService, applicationEventPublisher,
            queueRoutingInfoService, new TopicService()));

    // Act and Assert
    assertThrows(ProvisionFailedException.class,
        () -> deviceProvisionServiceImpl.extractDeviceNameFromCNByRegEx(new DeviceProfile(), "Common Name", "U"));
  }
}
