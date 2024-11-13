package org.thingsboard.server.service.ttl;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.alarm.BaseAlarmService;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.service.validator.AlarmDataValidator;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.action.EntityActionService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;

class AlarmsCleanUpServiceDiffblueTest {
  /**
   * Test {@link AlarmsCleanUpService#cleanUp()}.
   * <ul>
   *   <li>Then calls {@link TenantServiceImpl#findTenantsIds(PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmsCleanUpService#cleanUp()}
   */
  @Test
  @DisplayName("Test cleanUp(); then calls findTenantsIds(PageLink)")
  void testCleanUp_thenCallsFindTenantsIds() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantServiceImpl tenantService = mock(TenantServiceImpl.class);
    PageData<TenantId> emptyPageDataResult = PageData.emptyPageData();
    when(tenantService.findTenantsIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    JpaAlarmDao alarmDao = new JpaAlarmDao();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    JpaAlarmDao alarmDao2 = new JpaAlarmDao();
    BaseEntityService entityService = new BaseEntityService();
    BaseAlarmService alarmService = new BaseAlarmService(tenantService2, alarmDao2, entityService,
        new AlarmDataValidator(new TenantServiceImpl()));

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService tbClusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    EntityActionService entityActionService = new EntityActionService(tbClusterService, new AuditLogServiceImpl(),
        mock(NotificationRuleProcessor.class));

    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();

    // Act
    (new AlarmsCleanUpService(tenantService, alarmDao, alarmService, entityActionService, partitionService,
        new DefaultTbTenantProfileCache(tenantProfileService, new TenantServiceImpl()))).cleanUp();

    // Assert
    verify(tenantService).findTenantsIds(isA(PageLink.class));
  }
}
