package org.thingsboard.server.service.device;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.device.provision.ProvisionFailedException;
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
   * Test {@link DeviceProvisionServiceImpl#extractDeviceNameFromCNByRegEx(DeviceProfile, String,
   * String)}.
   *
   * <ul>
   *   <li>Then throw {@link ProvisionFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceProvisionServiceImpl#extractDeviceNameFromCNByRegEx(DeviceProfile, String, String)}
   */
  @Test
  @DisplayName(
      "Test extractDeviceNameFromCNByRegEx(DeviceProfile, String, String); then throw ProvisionFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceProvisionServiceImpl.extractDeviceNameFromCNByRegEx(DeviceProfile, String, String)"
  })
  void testExtractDeviceNameFromCNByRegEx_thenThrowProvisionFailedException()
      throws ProvisionFailedException {
    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    DeviceServiceImpl deviceService =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService2,
            eventService,
            tenantService,
            deviceValidator,
            countService,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    DeviceProvisionServiceImpl deviceProvisionServiceImpl =
        new DeviceProvisionServiceImpl(
            producerProvider,
            deviceProfileService,
            deviceService,
            deviceCredentialsService2,
            attributesService,
            auditLogService,
            partitionService);

    // Act and Assert
    assertThrows(
        ProvisionFailedException.class,
        () ->
            deviceProvisionServiceImpl.extractDeviceNameFromCNByRegEx(
                new DeviceProfile(), "Common Name", ".*"));
  }

  /**
   * Test {@link DeviceProvisionServiceImpl#extractDeviceNameFromCNByRegEx(DeviceProfile, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ProvisionFailedException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceProvisionServiceImpl#extractDeviceNameFromCNByRegEx(DeviceProfile, String, String)}
   */
  @Test
  @DisplayName(
      "Test extractDeviceNameFromCNByRegEx(DeviceProfile, String, String); when 'U'; then throw ProvisionFailedException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String DeviceProvisionServiceImpl.extractDeviceNameFromCNByRegEx(DeviceProfile, String, String)"
  })
  void testExtractDeviceNameFromCNByRegEx_whenU_thenThrowProvisionFailedException()
      throws ProvisionFailedException {
    // Arrange
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings =
        new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    InMemoryMonolithQueueFactory tbQueueProvider =
        new InMemoryMonolithQueueFactory(
            topicService,
            coreSettings,
            ruleEngineSettings,
            vcSettings,
            serviceInfoProvider,
            transportApiSettings,
            transportNotificationSettings,
            edgeSettings,
            new DefaultInMemoryStorage());
    TbCoreQueueProducerProvider producerProvider = new TbCoreQueueProducerProvider(tbQueueProvider);
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    DeviceServiceImpl deviceService =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService2,
            eventService,
            tenantService,
            deviceValidator,
            countService,
            new JpaExecutorService());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao2, new DeviceCredentialsDataValidator());
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);

    HashPartitionService partitionService =
        new HashPartitionService(
            serviceInfoProvider2,
            tenantRoutingInfoService,
            applicationEventPublisher,
            queueRoutingInfoService,
            new TopicService());

    DeviceProvisionServiceImpl deviceProvisionServiceImpl =
        new DeviceProvisionServiceImpl(
            producerProvider,
            deviceProfileService,
            deviceService,
            deviceCredentialsService2,
            attributesService,
            auditLogService,
            partitionService);

    // Act and Assert
    assertThrows(
        ProvisionFailedException.class,
        () ->
            deviceProvisionServiceImpl.extractDeviceNameFromCNByRegEx(
                new DeviceProfile(), "Common Name", "U"));
  }
}
