package org.thingsboard.server.service.partition;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.QueueKey;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;

class TbCoreStartupServiceDiffblueTest {
  /**
   * Test {@link TbCoreStartupService#onApplicationEvent(ApplicationReadyEvent)}.
   * <ul>
   *   <li>Then calls
   * {@link TbClusterService#broadcastToCore(ToCoreNotificationMsg)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoreStartupService#onApplicationEvent(ApplicationReadyEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(ApplicationReadyEvent); then calls broadcastToCore(ToCoreNotificationMsg)")
  void testOnApplicationEvent_thenCallsBroadcastToCore() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Integer> integerList = new ArrayList<>();
    integerList.add(2);
    PartitionService partitionService = mock(PartitionService.class);
    when(partitionService.getMyPartitions(Mockito.<QueueKey>any())).thenReturn(integerList);
    TbServiceInfoProvider serviceInfoProvider = mock(TbServiceInfoProvider.class);
    when(serviceInfoProvider.getServiceId()).thenReturn("42");
    TbClusterService clusterService = mock(TbClusterService.class);
    doNothing().when(clusterService).broadcastToCore(Mockito.<TransportProtos.ToCoreNotificationMsg>any());
    TbCoreStartupService tbCoreStartupService = new TbCoreStartupService(partitionService, serviceInfoProvider,
        clusterService);
    Class<Object> forNameResult = Object.class;
    SpringApplication application = new SpringApplication(forNameResult);

    // Act
    tbCoreStartupService.onApplicationEvent(new ApplicationReadyEvent(application, new String[]{"Args"},
        new AnnotationConfigReactiveWebApplicationContext(), null));

    // Assert
    verify(clusterService).broadcastToCore(isA(TransportProtos.ToCoreNotificationMsg.class));
    verify(partitionService).getMyPartitions(isA(QueueKey.class));
    verify(serviceInfoProvider).getServiceId();
  }

  /**
   * Test {@link TbCoreStartupService#onApplicationEvent(ApplicationReadyEvent)}.
   * <ul>
   *   <li>Then calls {@link PartitionService#getMyPartitions(QueueKey)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbCoreStartupService#onApplicationEvent(ApplicationReadyEvent)}
   */
  @Test
  @DisplayName("Test onApplicationEvent(ApplicationReadyEvent); then calls getMyPartitions(QueueKey)")
  void testOnApplicationEvent_thenCallsGetMyPartitions() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PartitionService partitionService = mock(PartitionService.class);
    when(partitionService.getMyPartitions(Mockito.<QueueKey>any())).thenReturn(new ArrayList<>());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    TbCoreStartupService tbCoreStartupService = new TbCoreStartupService(partitionService, serviceInfoProvider,
        new DefaultTbClusterService(topicService, deviceProfileCache, assetProfileCache, gatewayNotificationsService,
            edgeService, new EdgeSessionCaffeineCache(new CaffeineCacheManager())));
    Class<Object> forNameResult = Object.class;
    SpringApplication application = new SpringApplication(forNameResult);

    // Act
    tbCoreStartupService.onApplicationEvent(new ApplicationReadyEvent(application, new String[]{"Args"},
        new AnnotationConfigReactiveWebApplicationContext(), null));

    // Assert
    verify(partitionService).getMyPartitions(isA(QueueKey.class));
  }
}
