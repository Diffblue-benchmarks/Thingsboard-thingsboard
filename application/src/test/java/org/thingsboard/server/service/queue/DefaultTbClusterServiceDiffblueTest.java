package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasRuleEngineProfile;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.IdBased;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.msg.TbMsg;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueCallback;
import org.thingsboard.server.queue.TbQueueMsgMetadata;
import org.thingsboard.server.queue.common.SimpleTbQueueCallback;
import org.thingsboard.server.queue.common.TbRuleEngineProducerService;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.provider.TbQueueProducerProvider;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.gateway_device.GatewayNotificationsService;
import org.thingsboard.server.service.ota.OtaPackageStateService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.profile.TbAssetProfileCache;
import org.thingsboard.server.service.profile.TbDeviceProfileCache;

@ContextConfiguration(classes = {DefaultTbClusterService.class})
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
class DefaultTbClusterServiceDiffblueTest {
  @Autowired
  private DefaultTbClusterService defaultTbClusterService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private GatewayNotificationsService gatewayNotificationsService;

  @MockBean
  private OtaPackageStateService otaPackageStateService;

  @MockBean
  private PartitionService partitionService;

  @MockBean
  private TbAssetProfileCache tbAssetProfileCache;

  @MockBean
  private TbDeviceProfileCache tbDeviceProfileCache;

  @MockBean
  private TbQueueProducerProvider tbQueueProducerProvider;

  @MockBean
  private TbRuleEngineProducerService tbRuleEngineProducerService;

  @MockBean
  private TbTransactionalCache<EdgeId, String> tbTransactionalCache;

  @MockBean
  private TopicService topicService;

  /**
   * Test
   * {@link DefaultTbClusterService#getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg)}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbClusterService#getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg)}
   */
  @Test
  @DisplayName("Test getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg); given 'TENANT'")
  void testGetRuleEngineProfileForEntityOrElseNull_givenTenant() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    HasRuleEngineProfile actualRuleEngineProfileForEntityOrElseNull = defaultTbClusterService
        .getRuleEngineProfileForEntityOrElseNull(tenantId, entityId, null);

    // Assert
    verify(entityId, atLeast(1)).getEntityType();
    assertNull(actualRuleEngineProfileForEntityOrElseNull);
  }

  /**
   * Test
   * {@link DefaultTbClusterService#getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg)}.
   * <ul>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbClusterService#getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg)}
   */
  @Test
  @DisplayName("Test getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg); then return AssetProfile()")
  void testGetRuleEngineProfileForEntityOrElseNull_thenReturnAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    when(tbAssetProfileCache.get(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any())).thenReturn(assetProfile);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.ASSET_PROFILE);

    // Act
    HasRuleEngineProfile actualRuleEngineProfileForEntityOrElseNull = defaultTbClusterService
        .getRuleEngineProfileForEntityOrElseNull(tenantId, entityId, null);

    // Assert
    verify(tbAssetProfileCache).get(isA(TenantId.class), isA(AssetProfileId.class));
    verify(entityId, atLeast(1)).getEntityType();
    verify(entityId).getId();
    assertSame(assetProfile, actualRuleEngineProfileForEntityOrElseNull);
  }

  /**
   * Test
   * {@link DefaultTbClusterService#getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg)}.
   * <ul>
   *   <li>Then return {@link DeviceProfile#DeviceProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbClusterService#getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg)}
   */
  @Test
  @DisplayName("Test getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg); then return DeviceProfile()")
  void testGetRuleEngineProfileForEntityOrElseNull_thenReturnDeviceProfile() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    when(tbDeviceProfileCache.get(Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any())).thenReturn(deviceProfile);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.randomUUID());
    when(entityId.getEntityType()).thenReturn(EntityType.DEVICE_PROFILE);

    // Act
    HasRuleEngineProfile actualRuleEngineProfileForEntityOrElseNull = defaultTbClusterService
        .getRuleEngineProfileForEntityOrElseNull(tenantId, entityId, null);

    // Assert
    verify(tbDeviceProfileCache).get(isA(TenantId.class), isA(DeviceProfileId.class));
    verify(entityId, atLeast(1)).getEntityType();
    verify(entityId).getId();
    assertSame(deviceProfile, actualRuleEngineProfileForEntityOrElseNull);
  }

  /**
   * Test
   * {@link DefaultTbClusterService#getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbClusterService#getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg)}
   */
  @Test
  @DisplayName("Test getRuleEngineProfileForEntityOrElseNull(TenantId, EntityId, TbMsg); when AlarmId(UUID) with id is randomUUID")
  void testGetRuleEngineProfileForEntityOrElseNull_whenAlarmIdWithIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(defaultTbClusterService.getRuleEngineProfileForEntityOrElseNull(tenantId, new AlarmId(UUID.randomUUID()),
        null));
  }

  /**
   * Test
   * {@link DefaultTbClusterService#pushNotificationToTransport(String, ToTransportMsg, TbQueueCallback)}.
   * <ul>
   *   <li>When {@link Consumer} {@link Consumer#accept(Object)} does nothing.</li>
   *   <li>Then calls {@link Consumer#accept(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbClusterService#pushNotificationToTransport(String, TransportProtos.ToTransportMsg, TbQueueCallback)}
   */
  @Test
  @DisplayName("Test pushNotificationToTransport(String, ToTransportMsg, TbQueueCallback); when Consumer accept(Object) does nothing; then calls accept(Object)")
  void testPushNotificationToTransport_whenConsumerAcceptDoesNothing_thenCallsAccept() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
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
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService2, eventService, tenantService,
            deviceValidator, countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService defaultTbClusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));
    TransportProtos.ToTransportMsg response = TransportProtos.ToTransportMsg.getDefaultInstance();
    Consumer<TbQueueMsgMetadata> onSuccess = mock(Consumer.class);
    doNothing().when(onSuccess).accept(Mockito.<TbQueueMsgMetadata>any());

    // Act
    defaultTbClusterService.pushNotificationToTransport(null, response,
        new SimpleTbQueueCallback(onSuccess, mock(Consumer.class)));

    // Assert that nothing has changed
    verify(onSuccess).accept(isNull());
  }

  /**
   * Test {@link DefaultTbClusterService#onQueuesUpdate(List)}.
   * <ul>
   *   <li>Given {@link Queue} {@link IdBased#getId()} return
   * {@link QueueId#QueueId(UUID)} with id is randomUUID.</li>
   *   <li>Then calls {@link IdBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbClusterService#onQueuesUpdate(List)}
   */
  @Test
  @DisplayName("Test onQueuesUpdate(List); given Queue getId() return QueueId(UUID) with id is randomUUID; then calls getId()")
  void testOnQueuesUpdate_givenQueueGetIdReturnQueueIdWithIdIsRandomUUID_thenCallsGetId() {
    // Arrange
    when(partitionService.getAllServiceIds(Mockito.<ServiceType>any())).thenReturn(new HashSet<>());
    Queue queue = mock(Queue.class);
    when(queue.isDuplicateMsgToAllPartitions()).thenReturn(true);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");
    when(queue.getId()).thenReturn(new QueueId(UUID.randomUUID()));
    when(queue.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(queue).setTenantId(Mockito.<TenantId>any());
    queue.setTenantId(new TenantId(null));

    ArrayList<Queue> queues = new ArrayList<>();
    queues.add(queue);

    // Act
    defaultTbClusterService.onQueuesUpdate(queues);

    // Assert
    verify(queue, atLeast(1)).getId();
    verify(queue).getName();
    verify(queue).getPartitions();
    verify(queue, atLeast(1)).getTenantId();
    verify(queue).getTopic();
    verify(queue).isDuplicateMsgToAllPartitions();
    verify(queue).setTenantId(isA(TenantId.class));
    verify(partitionService, atLeast(1)).getAllServiceIds(Mockito.<ServiceType>any());
  }

  /**
   * Test {@link DefaultTbClusterService#onQueuesUpdate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link PartitionService#getAllServiceIds(ServiceType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbClusterService#onQueuesUpdate(List)}
   */
  @Test
  @DisplayName("Test onQueuesUpdate(List); when ArrayList(); then calls getAllServiceIds(ServiceType)")
  void testOnQueuesUpdate_whenArrayList_thenCallsGetAllServiceIds() {
    // Arrange
    when(partitionService.getAllServiceIds(Mockito.<ServiceType>any())).thenReturn(new HashSet<>());

    // Act
    defaultTbClusterService.onQueuesUpdate(new ArrayList<>());

    // Assert
    verify(partitionService, atLeast(1)).getAllServiceIds(Mockito.<ServiceType>any());
  }

  /**
   * Test {@link DefaultTbClusterService#onQueuesDelete(List)}.
   * <ul>
   *   <li>Given {@link Queue} {@link IdBased#getId()} return
   * {@link QueueId#QueueId(UUID)} with id is randomUUID.</li>
   *   <li>Then calls {@link IdBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbClusterService#onQueuesDelete(List)}
   */
  @Test
  @DisplayName("Test onQueuesDelete(List); given Queue getId() return QueueId(UUID) with id is randomUUID; then calls getId()")
  void testOnQueuesDelete_givenQueueGetIdReturnQueueIdWithIdIsRandomUUID_thenCallsGetId() {
    // Arrange
    when(partitionService.getAllServiceIds(Mockito.<ServiceType>any())).thenReturn(new HashSet<>());
    Queue queue = mock(Queue.class);
    when(queue.getName()).thenReturn("Name");
    when(queue.getId()).thenReturn(new QueueId(UUID.randomUUID()));
    when(queue.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(queue).setTenantId(Mockito.<TenantId>any());
    queue.setTenantId(new TenantId(null));

    ArrayList<Queue> queues = new ArrayList<>();
    queues.add(queue);

    // Act
    defaultTbClusterService.onQueuesDelete(queues);

    // Assert
    verify(queue, atLeast(1)).getId();
    verify(queue).getName();
    verify(queue, atLeast(1)).getTenantId();
    verify(queue).setTenantId(isA(TenantId.class));
    verify(partitionService, atLeast(1)).getAllServiceIds(Mockito.<ServiceType>any());
  }

  /**
   * Test {@link DefaultTbClusterService#onQueuesDelete(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link PartitionService#getAllServiceIds(ServiceType)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbClusterService#onQueuesDelete(List)}
   */
  @Test
  @DisplayName("Test onQueuesDelete(List); when ArrayList(); then calls getAllServiceIds(ServiceType)")
  void testOnQueuesDelete_whenArrayList_thenCallsGetAllServiceIds() {
    // Arrange
    when(partitionService.getAllServiceIds(Mockito.<ServiceType>any())).thenReturn(new HashSet<>());

    // Act
    defaultTbClusterService.onQueuesDelete(new ArrayList<>());

    // Assert
    verify(partitionService, atLeast(1)).getAllServiceIds(Mockito.<ServiceType>any());
  }
}
