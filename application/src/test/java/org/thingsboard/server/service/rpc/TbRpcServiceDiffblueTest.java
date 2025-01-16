package org.thingsboard.server.service.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.RpcId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
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
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;

class TbRpcServiceDiffblueTest {
  /**
   * Test {@link TbRpcService#save(TenantId, RpcId, RpcStatus, JsonNode)} with
   * {@code tenantId}, {@code rpcId}, {@code newStatus}, {@code response}.
   * <ul>
   *   <li>Then calls {@link CrudRepository#findById(Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRpcService#save(TenantId, RpcId, RpcStatus, JsonNode)}
   */
  @Test
  @DisplayName("Test save(TenantId, RpcId, RpcStatus, JsonNode) with 'tenantId', 'rpcId', 'newStatus', 'response'; then calls findById(Object)")
  void testSaveWithTenantIdRpcIdNewStatusResponse_thenCallsFindById() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RpcEntity rpcEntity = mock(RpcEntity.class);
    when(rpcEntity.toData()).thenReturn(null);
    doNothing().when(rpcEntity).setCreatedTime(anyLong());
    doNothing().when(rpcEntity).setId(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setDeviceId(Mockito.<UUID>any());
    doNothing().when(rpcEntity).setExpirationTime(anyLong());
    doNothing().when(rpcEntity).setRequest(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setResponse(Mockito.<JsonNode>any());
    doNothing().when(rpcEntity).setStatus(Mockito.<RpcStatus>any());
    doNothing().when(rpcEntity).setTenantId(Mockito.<UUID>any());
    rpcEntity.setAdditionalInfo(MissingNode.getInstance());
    rpcEntity.setCreatedTime(1L);
    rpcEntity.setDeviceId(UUID.randomUUID());
    rpcEntity.setExpirationTime(1L);
    rpcEntity.setId(UUID.randomUUID());
    rpcEntity.setRequest(MissingNode.getInstance());
    rpcEntity.setResponse(MissingNode.getInstance());
    rpcEntity.setStatus(RpcStatus.QUEUED);
    rpcEntity.setTenantId(UUID.randomUUID());
    rpcEntity.setUuid(UUID.randomUUID());
    Optional<RpcEntity> ofResult = Optional.of(rpcEntity);
    RpcRepository rpcRepository = mock(RpcRepository.class);
    when(rpcRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    BaseRpcService rpcService = new BaseRpcService(new JpaRpcDao(rpcRepository));
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
    TbRpcService tbRpcService = new TbRpcService(rpcService,
        new DefaultTbClusterService(topicService, deviceProfileCache, assetProfileCache, gatewayNotificationsService,
            edgeService, new EdgeSessionCaffeineCache(new CaffeineCacheManager())));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    RpcId rpcId = new RpcId(UUID.randomUUID());

    // Act
    tbRpcService.save(tenantId, rpcId, RpcStatus.QUEUED, MissingNode.getInstance());

    // Assert
    verify(rpcRepository).findById(isA(UUID.class));
    verify(rpcEntity).setCreatedTime(eq(1L));
    verify(rpcEntity).setId(isA(UUID.class));
    verify(rpcEntity).setUuid(isA(UUID.class));
    verify(rpcEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(rpcEntity).setDeviceId(isA(UUID.class));
    verify(rpcEntity).setExpirationTime(eq(1L));
    verify(rpcEntity).setRequest(isA(JsonNode.class));
    verify(rpcEntity).setResponse(isA(JsonNode.class));
    verify(rpcEntity).setStatus(eq(RpcStatus.QUEUED));
    verify(rpcEntity).setTenantId(isA(UUID.class));
    verify(rpcEntity).toData();
  }

  /**
   * Test {@link TbRpcService#findRpcById(TenantId, RpcId)}.
   * <ul>
   *   <li>Then return CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbRpcService#findRpcById(TenantId, RpcId)}
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
    TbRpcService tbRpcService = new TbRpcService(rpcService,
        new DefaultTbClusterService(topicService, deviceProfileCache, assetProfileCache, gatewayNotificationsService,
            edgeService, new EdgeSessionCaffeineCache(new CaffeineCacheManager())));
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act
    Rpc actualFindRpcByIdResult = tbRpcService.findRpcById(tenantId2, new RpcId(UUID.randomUUID()));

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

  /**
   * Test
   * {@link TbRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbRpcService#findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink)}
   */
  @Test
  @DisplayName("Test findAllByDeviceIdAndStatus(TenantId, DeviceId, RpcStatus, PageLink); then return TotalElements is zero")
  void testFindAllByDeviceIdAndStatus_thenReturnTotalElementsIsZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RpcRepository rpcRepository = mock(RpcRepository.class);
    when(rpcRepository.findAllByTenantIdAndDeviceIdAndStatus(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<RpcStatus>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    BaseRpcService rpcService = new BaseRpcService(new JpaRpcDao(rpcRepository));
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
    TbRpcService tbRpcService = new TbRpcService(rpcService,
        new DefaultTbClusterService(topicService, deviceProfileCache, assetProfileCache, gatewayNotificationsService,
            edgeService, new EdgeSessionCaffeineCache(new CaffeineCacheManager())));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    DeviceId deviceId = new DeviceId(UUID.randomUUID());

    // Act
    PageData<Rpc> actualFindAllByDeviceIdAndStatusResult = tbRpcService.findAllByDeviceIdAndStatus(tenantId, deviceId,
        RpcStatus.QUEUED, new PageLink(3));

    // Assert
    verify(rpcRepository).findAllByTenantIdAndDeviceIdAndStatus(isA(UUID.class), isA(UUID.class), eq(RpcStatus.QUEUED),
        isA(Pageable.class));
    assertEquals(0L, actualFindAllByDeviceIdAndStatusResult.getTotalElements());
    assertEquals(1, actualFindAllByDeviceIdAndStatusResult.getTotalPages());
    assertFalse(actualFindAllByDeviceIdAndStatusResult.hasNext());
    assertTrue(actualFindAllByDeviceIdAndStatusResult.getData().isEmpty());
  }
}
