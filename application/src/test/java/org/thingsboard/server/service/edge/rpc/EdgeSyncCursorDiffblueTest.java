package org.thingsboard.server.service.edge.rpc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.cache.ota.CaffeineOtaPackageCache;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.dashboard.DashboardServiceImpl;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.domain.DomainServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entityview.EntityViewServiceImpl;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.ota.BaseOtaPackageService;
import org.thingsboard.server.dao.queue.BaseQueueService;
import org.thingsboard.server.dao.resource.BaseResourceService;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.service.validator.OtaPackageDataValidator;
import org.thingsboard.server.dao.service.validator.OtaPackageInfoDataValidator;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTargetDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTargetRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;
import org.thingsboard.server.dao.sql.ota.JpaOtaPackageDao;
import org.thingsboard.server.dao.sql.ota.JpaOtaPackageInfoDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.dao.widget.WidgetsBundleServiceImpl;
import org.thingsboard.server.service.edge.EdgeContextComponent;

class EdgeSyncCursorDiffblueTest {
  /**
   * Test {@link EdgeSyncCursor#hasNext()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeSyncCursor#hasNext()}
   */
  @Test
  @DisplayName("Test hasNext(); then return 'true'")
  void testHasNext_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CustomerServiceImpl customerServiceImpl = mock(CustomerServiceImpl.class);
    when(customerServiceImpl.findOrCreatePublicCustomer(Mockito.<TenantId>any())).thenReturn(new Customer());
    EdgeContextComponent ctx = mock(EdgeContextComponent.class);
    when(ctx.getAssetProfileService()).thenReturn(new AssetProfileServiceImpl());
    when(ctx.getAssetService()).thenReturn(new BaseAssetService());
    when(ctx.getDashboardService()).thenReturn(new DashboardServiceImpl());
    when(ctx.getDeviceProfileService()).thenReturn(new DeviceProfileServiceImpl());
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    when(ctx.getDeviceService()).thenReturn(new DeviceServiceImpl(deviceDao, deviceCredentialsService,
        deviceProfileService, eventService, tenantService, deviceValidator, countService, new JpaExecutorService()));
    when(ctx.getDomainService()).thenReturn(new DomainServiceImpl());
    when(ctx.getEntityViewService()).thenReturn(new EntityViewServiceImpl());
    when(ctx.getNotificationRuleService()).thenReturn(
        new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class))));
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    when(ctx.getNotificationTargetService()).thenReturn(
        new DefaultNotificationTargetService(notificationTargetDao, notificationRequestDao, notificationRuleDao,
            new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao, userSettingsService, userSettingsDao,
                securitySettingsService, userValidator, userCredentialsValidator, eventPublisher, countService2,
                new JpaExecutorService())));
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    when(ctx.getNotificationTemplateService()).thenReturn(new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class))));
    JpaOtaPackageDao otaPackageDao = new JpaOtaPackageDao();
    JpaOtaPackageInfoDao otaPackageInfoDao = new JpaOtaPackageInfoDao();
    CaffeineOtaPackageCache otaPackageDataCache = new CaffeineOtaPackageCache(new CaffeineCacheManager());
    OtaPackageInfoDataValidator otaPackageInfoValidator = new OtaPackageInfoDataValidator();
    when(ctx.getOtaPackageService()).thenReturn(new BaseOtaPackageService(otaPackageDao, otaPackageInfoDao,
        otaPackageDataCache, otaPackageInfoValidator, new OtaPackageDataValidator()));
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    when(ctx.getResourceService())
        .thenReturn(new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator()));
    when(ctx.getWidgetTypeService()).thenReturn(new WidgetTypeServiceImpl());
    when(ctx.getWidgetsBundleService()).thenReturn(new WidgetsBundleServiceImpl());
    when(ctx.getCustomerService()).thenReturn(customerServiceImpl);
    when(ctx.getQueueService()).thenReturn(new BaseQueueService());
    when(ctx.getRuleChainService()).thenReturn(new BaseRuleChainService());
    when(ctx.getAdminSettingsService()).thenReturn(new AdminSettingsServiceImpl());
    when(ctx.getTenantService()).thenReturn(new TenantServiceImpl());
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService2 = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService2 = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService3 = new BaseEntityCountService();
    when(ctx.getUserService()).thenReturn(new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService3, new JpaExecutorService()));

    // Act
    boolean actualHasNextResult = (new EdgeSyncCursor(ctx, new Edge(), true)).hasNext();

    // Assert
    verify(customerServiceImpl).findOrCreatePublicCustomer(isNull());
    verify(ctx).getAdminSettingsService();
    verify(ctx, atLeast(1)).getAssetProfileService();
    verify(ctx).getAssetService();
    verify(ctx).getCustomerService();
    verify(ctx).getDashboardService();
    verify(ctx, atLeast(1)).getDeviceProfileService();
    verify(ctx).getDeviceService();
    verify(ctx).getDomainService();
    verify(ctx).getEntityViewService();
    verify(ctx).getNotificationRuleService();
    verify(ctx).getNotificationTargetService();
    verify(ctx).getNotificationTemplateService();
    verify(ctx).getOtaPackageService();
    verify(ctx).getQueueService();
    verify(ctx).getResourceService();
    verify(ctx).getRuleChainService();
    verify(ctx).getTenantService();
    verify(ctx).getUserService();
    verify(ctx, atLeast(1)).getWidgetTypeService();
    verify(ctx, atLeast(1)).getWidgetsBundleService();
    assertTrue(actualHasNextResult);
  }
}
