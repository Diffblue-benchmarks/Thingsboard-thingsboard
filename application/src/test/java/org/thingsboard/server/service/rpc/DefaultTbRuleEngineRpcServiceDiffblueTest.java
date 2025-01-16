package org.thingsboard.server.service.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.rpc.Rpc;
import org.thingsboard.server.common.data.rpc.RpcStatus;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.model.sql.RpcEntity;
import org.thingsboard.server.dao.rpc.BaseRpcService;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.sql.rpc.JpaRpcDao;
import org.thingsboard.server.dao.sql.rpc.RpcRepository;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.queue.TbQueueCallback;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;

class DefaultTbRuleEngineRpcServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultTbRuleEngineRpcService#sendRpcReplyToDevice(String, UUID, int, String)}.
   * <ul>
   *   <li>Then calls
   * {@link TbClusterService#pushNotificationToTransport(String, ToTransportMsg, TbQueueCallback)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineRpcService#sendRpcReplyToDevice(String, UUID, int, String)}
   */
  @Test
  @DisplayName("Test sendRpcReplyToDevice(String, UUID, int, String); then calls pushNotificationToTransport(String, ToTransportMsg, TbQueueCallback)")
  void testSendRpcReplyToDevice_thenCallsPushNotificationToTransport() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbClusterService clusterService = mock(TbClusterService.class);
    doNothing().when(clusterService)
        .pushNotificationToTransport(Mockito.<String>any(), Mockito.<TransportProtos.ToTransportMsg>any(),
            Mockito.<TbQueueCallback>any());
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultTbRuleEngineRpcService defaultTbRuleEngineRpcService = new DefaultTbRuleEngineRpcService(partitionService,
        clusterService, serviceInfoProvider2, new BaseRpcService(new JpaRpcDao(mock(RpcRepository.class))));

    // Act
    defaultTbRuleEngineRpcService.sendRpcReplyToDevice("42", UUID.randomUUID(), 1, "Not all who wander are lost");

    // Assert
    verify(clusterService).pushNotificationToTransport(eq("42"), isA(TransportProtos.ToTransportMsg.class), isNull());
  }

  /**
   * Test {@link DefaultTbRuleEngineRpcService#findRpcById(TenantId, RpcId)}.
   * <ul>
   *   <li>Then return CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbRuleEngineRpcService#findRpcById(TenantId, RpcId)}
   */
  @Test
  @DisplayName("Test findRpcById(TenantId, RpcId); then return CreatedTime is one")
  void testFindRpcById_thenReturnCreatedTimeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RpcEntity rpcEntity = new RpcEntity();
    rpcEntity.setAdditionalInfo(MissingNode.getInstance());
    rpcEntity.setCreatedTime(1L);
    UUID deviceId = UUID.randomUUID();
    rpcEntity.setDeviceId(deviceId);
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.randomUUID());
    rpcEntity.setRequest(MissingNode.getInstance());
    MissingNode response = MissingNode.getInstance();
    rpcEntity.setResponse(response);
    rpcEntity.setStatus(RpcStatus.QUEUED);
    UUID tenantId = UUID.randomUUID();
    rpcEntity.setTenantId(tenantId);
    UUID id = UUID.randomUUID();
    rpcEntity.setUuid(id);
    Optional<RpcEntity> ofResult = Optional.of(rpcEntity);
    RpcRepository rpcRepository = mock(RpcRepository.class);
    when(rpcRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    BaseRpcService rpcService = new BaseRpcService(new JpaRpcDao(rpcRepository));
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

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
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    DefaultTbRuleEngineRpcService defaultTbRuleEngineRpcService = new DefaultTbRuleEngineRpcService(partitionService,
        clusterService, new DefaultTbServiceInfoProvider(), rpcService);
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act
    Rpc actualFindRpcByIdResult = defaultTbRuleEngineRpcService.findRpcById(tenantId2, new RpcId(UUID.randomUUID()));

    // Assert
    verify(rpcRepository).findById(isA(UUID.class));
    assertEquals(1L, actualFindRpcByIdResult.getCreatedTime());
    assertEquals(1L, actualFindRpcByIdResult.getExpirationTime());
    DeviceId deviceId2 = actualFindRpcByIdResult.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    RpcId id2 = actualFindRpcByIdResult.getId();
    assertEquals(EntityType.RPC, id2.getEntityType());
    TenantId tenantId3 = actualFindRpcByIdResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId3.getEntityType());
    assertEquals(RpcStatus.QUEUED, actualFindRpcByIdResult.getStatus());
    assertFalse(deviceId2.isNullUid());
    assertFalse(id2.isNullUid());
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    assertSame(response, actualFindRpcByIdResult.getAdditionalInfo());
    assertSame(response, actualFindRpcByIdResult.getRequest());
    assertSame(response, actualFindRpcByIdResult.getResponse());
    assertSame(id, actualFindRpcByIdResult.getUuidId());
    assertSame(deviceId, deviceId2.getId());
    assertSame(id, id2.getId());
    assertSame(tenantId, tenantId3.getId());
  }
}
