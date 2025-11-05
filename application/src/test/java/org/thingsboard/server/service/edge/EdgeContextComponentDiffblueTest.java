package org.thingsboard.server.service.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.RateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.AssetService;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.dashboard.DashboardServiceImpl;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.domain.DomainService;
import org.thingsboard.server.dao.domain.DomainServiceImpl;
import org.thingsboard.server.dao.edge.BaseEdgeEventService;
import org.thingsboard.server.dao.edge.EdgeEventService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.entityview.EntityViewServiceImpl;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.notification.NotificationRuleService;
import org.thingsboard.server.dao.notification.NotificationTargetService;
import org.thingsboard.server.dao.notification.NotificationTemplateService;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.queue.BaseQueueService;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.resource.BaseResourceService;
import org.thingsboard.server.dao.resource.ResourceService;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.service.validator.EdgeEventDataValidator;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.sql.edge.EdgeEventInsertRepository;
import org.thingsboard.server.dao.sql.edge.EdgeEventRepository;
import org.thingsboard.server.dao.sql.edge.JpaBaseEdgeEventDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTargetDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTargetRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;
import org.thingsboard.server.dao.tenant.TenantProfileService;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.dao.widget.WidgetTypeService;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.dao.widget.WidgetsBundleService;
import org.thingsboard.server.dao.widget.WidgetsBundleServiceImpl;
import org.thingsboard.server.service.edge.rpc.EdgeEventStorageSettings;
import org.thingsboard.server.service.edge.rpc.EdgeGrpcService;
import org.thingsboard.server.service.edge.rpc.EdgeRpcService;
import org.thingsboard.server.service.edge.rpc.constructor.edge.EdgeMsgConstructor;
import org.thingsboard.server.service.edge.rpc.processor.alarm.AlarmEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.alarm.AlarmEdgeProcessorFactory;
import org.thingsboard.server.service.edge.rpc.processor.alarm.AlarmEdgeProcessorV1;
import org.thingsboard.server.service.edge.rpc.processor.asset.AssetEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.asset.AssetEdgeProcessorFactory;
import org.thingsboard.server.service.edge.rpc.processor.asset.AssetEdgeProcessorV1;
import org.thingsboard.server.service.edge.rpc.processor.asset.profile.AssetProfileEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.asset.profile.AssetProfileEdgeProcessorFactory;
import org.thingsboard.server.service.edge.rpc.processor.asset.profile.AssetProfileEdgeProcessorV1;
import org.thingsboard.server.service.edge.rpc.processor.customer.CustomerEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.dashboard.DashboardEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.dashboard.DashboardEdgeProcessorFactory;
import org.thingsboard.server.service.edge.rpc.processor.dashboard.DashboardEdgeProcessorV1;
import org.thingsboard.server.service.edge.rpc.processor.device.DeviceEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.device.DeviceEdgeProcessorFactory;
import org.thingsboard.server.service.edge.rpc.processor.device.DeviceEdgeProcessorV1;
import org.thingsboard.server.service.edge.rpc.processor.device.profile.DeviceProfileEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.device.profile.DeviceProfileEdgeProcessorFactory;
import org.thingsboard.server.service.edge.rpc.processor.device.profile.DeviceProfileEdgeProcessorV1;
import org.thingsboard.server.service.edge.rpc.processor.edge.EdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.entityview.EntityViewEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.entityview.EntityViewProcessorFactory;
import org.thingsboard.server.service.edge.rpc.processor.entityview.EntityViewProcessorV1;
import org.thingsboard.server.service.edge.rpc.processor.notification.NotificationEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.oauth2.OAuth2EdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.ota.OtaPackageEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.queue.QueueEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.relation.RelationEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.relation.RelationEdgeProcessorFactory;
import org.thingsboard.server.service.edge.rpc.processor.relation.RelationEdgeProcessorV1;
import org.thingsboard.server.service.edge.rpc.processor.resource.ResourceEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.resource.ResourceEdgeProcessorFactory;
import org.thingsboard.server.service.edge.rpc.processor.resource.ResourceEdgeProcessorV1;
import org.thingsboard.server.service.edge.rpc.processor.rule.RuleChainEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.settings.AdminSettingsEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.telemetry.TelemetryEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.tenant.TenantEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.tenant.TenantProfileEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.user.UserEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.widget.WidgetBundleEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.processor.widget.WidgetTypeEdgeProcessor;
import org.thingsboard.server.service.edge.rpc.sync.DefaultEdgeRequestsService;
import org.thingsboard.server.service.edge.rpc.sync.EdgeRequestsService;
import org.thingsboard.server.service.executors.DbCallbackExecutorService;
import org.thingsboard.server.service.executors.GrpcCallbackExecutorService;

class EdgeContextComponentDiffblueTest {
  /**
   * Test {@link EdgeContextComponent#equals(Object)}, and {@link EdgeContextComponent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeContextComponent#equals(Object)}
   *   <li>{@link EdgeContextComponent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();

    // Act and Assert
    assertEquals(edgeContextComponent, edgeContextComponent2);
    assertEquals(edgeContextComponent.hashCode(), edgeContextComponent2.hashCode());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}, and {@link EdgeContextComponent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeContextComponent#equals(Object)}
   *   <li>{@link EdgeContextComponent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    // Act and Assert
    assertEquals(edgeContextComponent, edgeContextComponent);
    int expectedHashCodeResult = edgeContextComponent.hashCode();
    assertEquals(expectedHashCodeResult, edgeContextComponent.hashCode());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeContextComponent(), 1);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setEdgeService(new EdgeServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setEdgeRpcService(new EdgeGrpcService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao edgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            mock(EdgeEventRepository.class),
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
            mock(JdbcTemplate.class));
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    BaseEdgeEventService edgeEventService =
        new BaseEdgeEventService(
            edgeEventDao,
            rateLimitService,
            new EdgeEventDataValidator(),
            mock(ApplicationEventPublisher.class));
    edgeContextComponent.setEdgeEventService(edgeEventService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAdminSettingsService(new AdminSettingsServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    DeviceServiceImpl deviceService =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService,
            eventService,
            tenantService,
            deviceValidator,
            countService,
            new JpaExecutorService());
    edgeContextComponent.setDeviceService(deviceService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAssetService(new BaseAssetService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setEntityViewService(new EntityViewServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setDeviceProfileService(new DeviceProfileServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAssetProfileService(new AssetProfileServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAttributesService(new BaseAttributesService(new JpaAttributeDao()));

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setDashboardService(new DashboardServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setRuleChainService(new BaseRuleChainService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    edgeContextComponent.setUserService(userService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setCustomerService(new CustomerServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setWidgetTypeService(new WidgetTypeServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setWidgetsBundleService(new WidgetsBundleServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setEdgeRequestsService(new DefaultEdgeRequestsService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setTenantService(new TenantServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setTenantProfileService(new TenantProfileServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setQueueService(new BaseQueueService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService resourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());
    edgeContextComponent.setResourceService(resourceService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    edgeContextComponent.setNotificationRuleService(
        new DefaultNotificationRuleService(notificationRuleDao));

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    edgeContextComponent.setNotificationTargetService(notificationTargetService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService notificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao);
    edgeContextComponent.setNotificationTemplateService(notificationTemplateService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setDomainService(new DomainServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);
    edgeContextComponent.setRateLimitService(rateLimitService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setNotificationRuleProcessor(mock(NotificationRuleProcessor.class));

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual29() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAlarmProcessor(new AlarmEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual30() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setDeviceProfileProcessor(new DeviceProfileEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual31() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAssetProfileProcessor(new AssetProfileEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual32() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setEdgeProcessor(new EdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual33() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setDeviceProcessor(new DeviceEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual34() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAssetProcessor(new AssetEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual35() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setEntityViewProcessor(new EntityViewProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual36() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setUserProcessor(new UserEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual37() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setRelationProcessor(new RelationEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual38() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setTelemetryProcessor(new TelemetryEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual39() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setDashboardProcessor(new DashboardEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual40() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setRuleChainProcessor(new RuleChainEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual41() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setCustomerProcessor(new CustomerEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual42() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setWidgetBundleProcessor(new WidgetBundleEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual43() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setWidgetTypeProcessor(new WidgetTypeEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual44() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAdminSettingsProcessor(new AdminSettingsEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual45() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setOtaPackageProcessor(new OtaPackageEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual46() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setQueueProcessor(new QueueEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual47() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setTenantProcessor(new TenantEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual48() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setTenantProfileProcessor(new TenantProfileEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual49() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setResourceProcessor(new ResourceEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual50() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setNotificationEdgeProcessor(new NotificationEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual51() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setOAuth2EdgeProcessor(new OAuth2EdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual52() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setEdgeMsgConstructor(new EdgeMsgConstructor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual53() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAlarmEdgeProcessorFactory(new AlarmEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual54() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAssetEdgeProcessorFactory(new AssetEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual55() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setAssetProfileEdgeProcessorFactory(
        new AssetProfileEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual56() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setDashboardEdgeProcessorFactory(new DashboardEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual57() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setDeviceEdgeProcessorFactory(new DeviceEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual58() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setDeviceProfileEdgeProcessorFactory(
        new DeviceProfileEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual59() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setEntityViewProcessorFactory(new EntityViewProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual60() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setRelationEdgeProcessorFactory(new RelationEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual61() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setResourceEdgeProcessorFactory(new ResourceEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual62() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setEdgeEventStorageSettings(new EdgeEventStorageSettings());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual63() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setDbCallbackExecutor(new DbCallbackExecutorService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual64() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    edgeContextComponent.setGrpcCallbackExecutorService(new GrpcCallbackExecutorService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, new EdgeContextComponent());
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual65() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setEdgeService(new EdgeServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual66() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setEdgeRpcService(new EdgeGrpcService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual67() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao edgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            mock(EdgeEventRepository.class),
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
            mock(JdbcTemplate.class));
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    BaseEdgeEventService edgeEventService =
        new BaseEdgeEventService(
            edgeEventDao,
            rateLimitService,
            new EdgeEventDataValidator(),
            mock(ApplicationEventPublisher.class));
    edgeContextComponent2.setEdgeEventService(edgeEventService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual68() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAdminSettingsService(new AdminSettingsServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual69() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService =
        new DeviceCredentialsServiceImpl(
            deviceCredentialsDao, new DeviceCredentialsDataValidator());
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();

    DeviceServiceImpl deviceService =
        new DeviceServiceImpl(
            deviceDao,
            deviceCredentialsService,
            deviceProfileService,
            eventService,
            tenantService,
            deviceValidator,
            countService,
            new JpaExecutorService());
    edgeContextComponent2.setDeviceService(deviceService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual70() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAssetService(new BaseAssetService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual71() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setEntityViewService(new EntityViewServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual72() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setDeviceProfileService(new DeviceProfileServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual73() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAssetProfileService(new AssetProfileServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual74() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAttributesService(new BaseAttributesService(new JpaAttributeDao()));

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual75() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setDashboardService(new DashboardServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual76() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setRuleChainService(new BaseRuleChainService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual77() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());
    edgeContextComponent2.setUserService(userService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual78() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setCustomerService(new CustomerServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual79() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setWidgetTypeService(new WidgetTypeServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual80() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setWidgetsBundleService(new WidgetsBundleServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual81() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setEdgeRequestsService(new DefaultEdgeRequestsService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual82() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setTenantService(new TenantServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual83() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setTenantProfileService(new TenantProfileServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual84() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setQueueService(new BaseQueueService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual85() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();

    BaseResourceService resourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());
    edgeContextComponent2.setResourceService(resourceService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual86() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    edgeContextComponent2.setNotificationRuleService(
        new DefaultNotificationRuleService(notificationRuleDao));

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual87() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();

    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService,
            new JpaExecutorService());

    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao, userService);
    edgeContextComponent2.setNotificationTargetService(notificationTargetService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual88() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    DefaultNotificationTemplateService notificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao);
    edgeContextComponent2.setNotificationTemplateService(notificationTemplateService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual89() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setDomainService(new DomainServiceImpl());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual90() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);
    edgeContextComponent2.setRateLimitService(rateLimitService);

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual91() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setNotificationRuleProcessor(mock(NotificationRuleProcessor.class));

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual92() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAlarmProcessor(new AlarmEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual93() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setDeviceProfileProcessor(new DeviceProfileEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual94() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAssetProfileProcessor(new AssetProfileEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual95() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setEdgeProcessor(new EdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual96() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setDeviceProcessor(new DeviceEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual97() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAssetProcessor(new AssetEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual98() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setEntityViewProcessor(new EntityViewProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual99() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setUserProcessor(new UserEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual100() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setRelationProcessor(new RelationEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual101() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setTelemetryProcessor(new TelemetryEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual102() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setDashboardProcessor(new DashboardEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual103() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setRuleChainProcessor(new RuleChainEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual104() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setCustomerProcessor(new CustomerEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual105() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setWidgetBundleProcessor(new WidgetBundleEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual106() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setWidgetTypeProcessor(new WidgetTypeEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual107() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAdminSettingsProcessor(new AdminSettingsEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual108() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setOtaPackageProcessor(new OtaPackageEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual109() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setQueueProcessor(new QueueEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual110() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setTenantProcessor(new TenantEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual111() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setTenantProfileProcessor(new TenantProfileEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual112() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setResourceProcessor(new ResourceEdgeProcessorV1());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual113() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setNotificationEdgeProcessor(new NotificationEdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual114() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setOAuth2EdgeProcessor(new OAuth2EdgeProcessor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual115() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setEdgeMsgConstructor(new EdgeMsgConstructor());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual116() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAlarmEdgeProcessorFactory(new AlarmEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual117() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAssetEdgeProcessorFactory(new AssetEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual118() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setAssetProfileEdgeProcessorFactory(
        new AssetProfileEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual119() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setDashboardEdgeProcessorFactory(new DashboardEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual120() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setDeviceEdgeProcessorFactory(new DeviceEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual121() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setDeviceProfileEdgeProcessorFactory(
        new DeviceProfileEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual122() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setEntityViewProcessorFactory(new EntityViewProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual123() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setRelationEdgeProcessorFactory(new RelationEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual124() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setResourceEdgeProcessorFactory(new ResourceEdgeProcessorFactory());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual125() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setEdgeEventStorageSettings(new EdgeEventStorageSettings());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual126() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setDbCallbackExecutor(new DbCallbackExecutorService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual127() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();

    EdgeContextComponent edgeContextComponent2 = new EdgeContextComponent();
    edgeContextComponent2.setGrpcCallbackExecutorService(new GrpcCallbackExecutorService());

    // Act and Assert
    assertNotEquals(edgeContextComponent, edgeContextComponent2);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeContextComponent(), null);
  }

  /**
   * Test {@link EdgeContextComponent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeContextComponent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeContextComponent.equals(Object)",
    "int EdgeContextComponent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeContextComponent(), "Different type to EdgeContextComponent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeContextComponent#setAdminSettingsProcessor(AdminSettingsEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setAdminSettingsService(AdminSettingsService)}
   *   <li>{@link EdgeContextComponent#setAlarmEdgeProcessorFactory(AlarmEdgeProcessorFactory)}
   *   <li>{@link EdgeContextComponent#setAlarmProcessor(AlarmEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setAssetEdgeProcessorFactory(AssetEdgeProcessorFactory)}
   *   <li>{@link EdgeContextComponent#setAssetProcessor(AssetEdgeProcessor)}
   *   <li>{@link
   *       EdgeContextComponent#setAssetProfileEdgeProcessorFactory(AssetProfileEdgeProcessorFactory)}
   *   <li>{@link EdgeContextComponent#setAssetProfileProcessor(AssetProfileEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setAssetProfileService(AssetProfileService)}
   *   <li>{@link EdgeContextComponent#setAssetService(AssetService)}
   *   <li>{@link EdgeContextComponent#setAttributesService(AttributesService)}
   *   <li>{@link EdgeContextComponent#setCustomerProcessor(CustomerEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setCustomerService(CustomerService)}
   *   <li>{@link
   *       EdgeContextComponent#setDashboardEdgeProcessorFactory(DashboardEdgeProcessorFactory)}
   *   <li>{@link EdgeContextComponent#setDashboardProcessor(DashboardEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setDashboardService(DashboardService)}
   *   <li>{@link EdgeContextComponent#setDbCallbackExecutor(DbCallbackExecutorService)}
   *   <li>{@link EdgeContextComponent#setDeviceEdgeProcessorFactory(DeviceEdgeProcessorFactory)}
   *   <li>{@link EdgeContextComponent#setDeviceProcessor(DeviceEdgeProcessor)}
   *   <li>{@link
   *       EdgeContextComponent#setDeviceProfileEdgeProcessorFactory(DeviceProfileEdgeProcessorFactory)}
   *   <li>{@link EdgeContextComponent#setDeviceProfileProcessor(DeviceProfileEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setDeviceProfileService(DeviceProfileService)}
   *   <li>{@link EdgeContextComponent#setDeviceService(DeviceService)}
   *   <li>{@link EdgeContextComponent#setDomainService(DomainService)}
   *   <li>{@link EdgeContextComponent#setEdgeEventService(EdgeEventService)}
   *   <li>{@link EdgeContextComponent#setEdgeEventStorageSettings(EdgeEventStorageSettings)}
   *   <li>{@link EdgeContextComponent#setEdgeMsgConstructor(EdgeMsgConstructor)}
   *   <li>{@link EdgeContextComponent#setEdgeProcessor(EdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setEdgeRequestsService(EdgeRequestsService)}
   *   <li>{@link EdgeContextComponent#setEdgeRpcService(EdgeRpcService)}
   *   <li>{@link EdgeContextComponent#setEdgeService(EdgeService)}
   *   <li>{@link EdgeContextComponent#setEntityViewProcessor(EntityViewEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setEntityViewProcessorFactory(EntityViewProcessorFactory)}
   *   <li>{@link EdgeContextComponent#setEntityViewService(EntityViewService)}
   *   <li>{@link EdgeContextComponent#setGrpcCallbackExecutorService(GrpcCallbackExecutorService)}
   *   <li>{@link EdgeContextComponent#setNotificationEdgeProcessor(NotificationEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setNotificationRuleProcessor(NotificationRuleProcessor)}
   *   <li>{@link EdgeContextComponent#setNotificationRuleService(NotificationRuleService)}
   *   <li>{@link EdgeContextComponent#setNotificationTargetService(NotificationTargetService)}
   *   <li>{@link EdgeContextComponent#setNotificationTemplateService(NotificationTemplateService)}
   *   <li>{@link EdgeContextComponent#setOAuth2EdgeProcessor(OAuth2EdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setOtaPackageProcessor(OtaPackageEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setQueueProcessor(QueueEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setQueueService(QueueService)}
   *   <li>{@link EdgeContextComponent#setRateLimitService(RateLimitService)}
   *   <li>{@link
   *       EdgeContextComponent#setRelationEdgeProcessorFactory(RelationEdgeProcessorFactory)}
   *   <li>{@link EdgeContextComponent#setRelationProcessor(RelationEdgeProcessor)}
   *   <li>{@link
   *       EdgeContextComponent#setResourceEdgeProcessorFactory(ResourceEdgeProcessorFactory)}
   *   <li>{@link EdgeContextComponent#setResourceProcessor(ResourceEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setResourceService(ResourceService)}
   *   <li>{@link EdgeContextComponent#setRuleChainProcessor(RuleChainEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setRuleChainService(RuleChainService)}
   *   <li>{@link EdgeContextComponent#setTelemetryProcessor(TelemetryEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setTenantProcessor(TenantEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setTenantProfileProcessor(TenantProfileEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setTenantProfileService(TenantProfileService)}
   *   <li>{@link EdgeContextComponent#setTenantService(TenantService)}
   *   <li>{@link EdgeContextComponent#setUserProcessor(UserEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setUserService(UserService)}
   *   <li>{@link EdgeContextComponent#setWidgetBundleProcessor(WidgetBundleEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setWidgetTypeProcessor(WidgetTypeEdgeProcessor)}
   *   <li>{@link EdgeContextComponent#setWidgetTypeService(WidgetTypeService)}
   *   <li>{@link EdgeContextComponent#setWidgetsBundleService(WidgetsBundleService)}
   *   <li>{@link EdgeContextComponent#toString()}
   *   <li>{@link EdgeContextComponent#getAdminSettingsProcessor()}
   *   <li>{@link EdgeContextComponent#getAdminSettingsService()}
   *   <li>{@link EdgeContextComponent#getAlarmEdgeProcessorFactory()}
   *   <li>{@link EdgeContextComponent#getAlarmProcessor()}
   *   <li>{@link EdgeContextComponent#getAssetEdgeProcessorFactory()}
   *   <li>{@link EdgeContextComponent#getAssetProcessor()}
   *   <li>{@link EdgeContextComponent#getAssetProfileEdgeProcessorFactory()}
   *   <li>{@link EdgeContextComponent#getAssetProfileProcessor()}
   *   <li>{@link EdgeContextComponent#getAssetProfileService()}
   *   <li>{@link EdgeContextComponent#getAssetService()}
   *   <li>{@link EdgeContextComponent#getAttributesService()}
   *   <li>{@link EdgeContextComponent#getClusterService()}
   *   <li>{@link EdgeContextComponent#getCustomerProcessor()}
   *   <li>{@link EdgeContextComponent#getCustomerService()}
   *   <li>{@link EdgeContextComponent#getDashboardEdgeProcessorFactory()}
   *   <li>{@link EdgeContextComponent#getDashboardProcessor()}
   *   <li>{@link EdgeContextComponent#getDashboardService()}
   *   <li>{@link EdgeContextComponent#getDbCallbackExecutor()}
   *   <li>{@link EdgeContextComponent#getDeviceEdgeProcessorFactory()}
   *   <li>{@link EdgeContextComponent#getDeviceProcessor()}
   *   <li>{@link EdgeContextComponent#getDeviceProfileEdgeProcessorFactory()}
   *   <li>{@link EdgeContextComponent#getDeviceProfileProcessor()}
   *   <li>{@link EdgeContextComponent#getDeviceProfileService()}
   *   <li>{@link EdgeContextComponent#getDeviceService()}
   *   <li>{@link EdgeContextComponent#getDomainService()}
   *   <li>{@link EdgeContextComponent#getEdgeEventService()}
   *   <li>{@link EdgeContextComponent#getEdgeEventStorageSettings()}
   *   <li>{@link EdgeContextComponent#getEdgeMsgConstructor()}
   *   <li>{@link EdgeContextComponent#getEdgeProcessor()}
   *   <li>{@link EdgeContextComponent#getEdgeRequestsService()}
   *   <li>{@link EdgeContextComponent#getEdgeRpcService()}
   *   <li>{@link EdgeContextComponent#getEdgeService()}
   *   <li>{@link EdgeContextComponent#getEntityViewProcessor()}
   *   <li>{@link EdgeContextComponent#getEntityViewProcessorFactory()}
   *   <li>{@link EdgeContextComponent#getEntityViewService()}
   *   <li>{@link EdgeContextComponent#getGrpcCallbackExecutorService()}
   *   <li>{@link EdgeContextComponent#getNotificationEdgeProcessor()}
   *   <li>{@link EdgeContextComponent#getNotificationRuleProcessor()}
   *   <li>{@link EdgeContextComponent#getNotificationRuleService()}
   *   <li>{@link EdgeContextComponent#getNotificationTargetService()}
   *   <li>{@link EdgeContextComponent#getNotificationTemplateService()}
   *   <li>{@link EdgeContextComponent#getOAuth2EdgeProcessor()}
   *   <li>{@link EdgeContextComponent#getOtaPackageProcessor()}
   *   <li>{@link EdgeContextComponent#getOtaPackageService()}
   *   <li>{@link EdgeContextComponent#getQueueProcessor()}
   *   <li>{@link EdgeContextComponent#getQueueService()}
   *   <li>{@link EdgeContextComponent#getRateLimitService()}
   *   <li>{@link EdgeContextComponent#getRelationEdgeProcessorFactory()}
   *   <li>{@link EdgeContextComponent#getRelationProcessor()}
   *   <li>{@link EdgeContextComponent#getResourceEdgeProcessorFactory()}
   *   <li>{@link EdgeContextComponent#getResourceProcessor()}
   *   <li>{@link EdgeContextComponent#getResourceService()}
   *   <li>{@link EdgeContextComponent#getRuleChainProcessor()}
   *   <li>{@link EdgeContextComponent#getRuleChainService()}
   *   <li>{@link EdgeContextComponent#getTelemetryProcessor()}
   *   <li>{@link EdgeContextComponent#getTenantProcessor()}
   *   <li>{@link EdgeContextComponent#getTenantProfileProcessor()}
   *   <li>{@link EdgeContextComponent#getTenantProfileService()}
   *   <li>{@link EdgeContextComponent#getTenantService()}
   *   <li>{@link EdgeContextComponent#getUserProcessor()}
   *   <li>{@link EdgeContextComponent#getUserService()}
   *   <li>{@link EdgeContextComponent#getWidgetBundleProcessor()}
   *   <li>{@link EdgeContextComponent#getWidgetTypeProcessor()}
   *   <li>{@link EdgeContextComponent#getWidgetTypeService()}
   *   <li>{@link EdgeContextComponent#getWidgetsBundleService()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettingsEdgeProcessor EdgeContextComponent.getAdminSettingsProcessor()",
    "AdminSettingsService EdgeContextComponent.getAdminSettingsService()",
    "AlarmEdgeProcessorFactory EdgeContextComponent.getAlarmEdgeProcessorFactory()",
    "AlarmEdgeProcessor EdgeContextComponent.getAlarmProcessor()",
    "AssetEdgeProcessorFactory EdgeContextComponent.getAssetEdgeProcessorFactory()",
    "AssetEdgeProcessor EdgeContextComponent.getAssetProcessor()",
    "AssetProfileEdgeProcessorFactory EdgeContextComponent.getAssetProfileEdgeProcessorFactory()",
    "AssetProfileEdgeProcessor EdgeContextComponent.getAssetProfileProcessor()",
    "AssetProfileService EdgeContextComponent.getAssetProfileService()",
    "AssetService EdgeContextComponent.getAssetService()",
    "AttributesService EdgeContextComponent.getAttributesService()",
    "TbClusterService EdgeContextComponent.getClusterService()",
    "CustomerEdgeProcessor EdgeContextComponent.getCustomerProcessor()",
    "CustomerService EdgeContextComponent.getCustomerService()",
    "DashboardEdgeProcessorFactory EdgeContextComponent.getDashboardEdgeProcessorFactory()",
    "DashboardEdgeProcessor EdgeContextComponent.getDashboardProcessor()",
    "DashboardService EdgeContextComponent.getDashboardService()",
    "DbCallbackExecutorService EdgeContextComponent.getDbCallbackExecutor()",
    "DeviceEdgeProcessorFactory EdgeContextComponent.getDeviceEdgeProcessorFactory()",
    "DeviceEdgeProcessor EdgeContextComponent.getDeviceProcessor()",
    "DeviceProfileEdgeProcessorFactory EdgeContextComponent.getDeviceProfileEdgeProcessorFactory()",
    "DeviceProfileEdgeProcessor EdgeContextComponent.getDeviceProfileProcessor()",
    "DeviceProfileService EdgeContextComponent.getDeviceProfileService()",
    "DeviceService EdgeContextComponent.getDeviceService()",
    "DomainService EdgeContextComponent.getDomainService()",
    "EdgeEventService EdgeContextComponent.getEdgeEventService()",
    "EdgeEventStorageSettings EdgeContextComponent.getEdgeEventStorageSettings()",
    "EdgeMsgConstructor EdgeContextComponent.getEdgeMsgConstructor()",
    "EdgeProcessor EdgeContextComponent.getEdgeProcessor()",
    "EdgeRequestsService EdgeContextComponent.getEdgeRequestsService()",
    "EdgeRpcService EdgeContextComponent.getEdgeRpcService()",
    "EdgeService EdgeContextComponent.getEdgeService()",
    "EntityViewEdgeProcessor EdgeContextComponent.getEntityViewProcessor()",
    "EntityViewProcessorFactory EdgeContextComponent.getEntityViewProcessorFactory()",
    "EntityViewService EdgeContextComponent.getEntityViewService()",
    "GrpcCallbackExecutorService EdgeContextComponent.getGrpcCallbackExecutorService()",
    "NotificationEdgeProcessor EdgeContextComponent.getNotificationEdgeProcessor()",
    "NotificationRuleProcessor EdgeContextComponent.getNotificationRuleProcessor()",
    "NotificationRuleService EdgeContextComponent.getNotificationRuleService()",
    "NotificationTargetService EdgeContextComponent.getNotificationTargetService()",
    "NotificationTemplateService EdgeContextComponent.getNotificationTemplateService()",
    "OAuth2EdgeProcessor EdgeContextComponent.getOAuth2EdgeProcessor()",
    "OtaPackageEdgeProcessor EdgeContextComponent.getOtaPackageProcessor()",
    "OtaPackageService EdgeContextComponent.getOtaPackageService()",
    "QueueEdgeProcessor EdgeContextComponent.getQueueProcessor()",
    "QueueService EdgeContextComponent.getQueueService()",
    "RateLimitService EdgeContextComponent.getRateLimitService()",
    "RelationEdgeProcessorFactory EdgeContextComponent.getRelationEdgeProcessorFactory()",
    "RelationEdgeProcessor EdgeContextComponent.getRelationProcessor()",
    "ResourceEdgeProcessorFactory EdgeContextComponent.getResourceEdgeProcessorFactory()",
    "ResourceEdgeProcessor EdgeContextComponent.getResourceProcessor()",
    "ResourceService EdgeContextComponent.getResourceService()",
    "RuleChainEdgeProcessor EdgeContextComponent.getRuleChainProcessor()",
    "RuleChainService EdgeContextComponent.getRuleChainService()",
    "TelemetryEdgeProcessor EdgeContextComponent.getTelemetryProcessor()",
    "TenantEdgeProcessor EdgeContextComponent.getTenantProcessor()",
    "TenantProfileEdgeProcessor EdgeContextComponent.getTenantProfileProcessor()",
    "TenantProfileService EdgeContextComponent.getTenantProfileService()",
    "TenantService EdgeContextComponent.getTenantService()",
    "UserEdgeProcessor EdgeContextComponent.getUserProcessor()",
    "UserService EdgeContextComponent.getUserService()",
    "WidgetBundleEdgeProcessor EdgeContextComponent.getWidgetBundleProcessor()",
    "WidgetTypeEdgeProcessor EdgeContextComponent.getWidgetTypeProcessor()",
    "WidgetTypeService EdgeContextComponent.getWidgetTypeService()",
    "WidgetsBundleService EdgeContextComponent.getWidgetsBundleService()",
    "void EdgeContextComponent.setAdminSettingsProcessor(AdminSettingsEdgeProcessor)",
    "void EdgeContextComponent.setAdminSettingsService(AdminSettingsService)",
    "void EdgeContextComponent.setAlarmEdgeProcessorFactory(AlarmEdgeProcessorFactory)",
    "void EdgeContextComponent.setAlarmProcessor(AlarmEdgeProcessor)",
    "void EdgeContextComponent.setAssetEdgeProcessorFactory(AssetEdgeProcessorFactory)",
    "void EdgeContextComponent.setAssetProcessor(AssetEdgeProcessor)",
    "void EdgeContextComponent.setAssetProfileEdgeProcessorFactory(AssetProfileEdgeProcessorFactory)",
    "void EdgeContextComponent.setAssetProfileProcessor(AssetProfileEdgeProcessor)",
    "void EdgeContextComponent.setAssetProfileService(AssetProfileService)",
    "void EdgeContextComponent.setAssetService(AssetService)",
    "void EdgeContextComponent.setAttributesService(AttributesService)",
    "void EdgeContextComponent.setClusterService(TbClusterService)",
    "void EdgeContextComponent.setCustomerProcessor(CustomerEdgeProcessor)",
    "void EdgeContextComponent.setCustomerService(CustomerService)",
    "void EdgeContextComponent.setDashboardEdgeProcessorFactory(DashboardEdgeProcessorFactory)",
    "void EdgeContextComponent.setDashboardProcessor(DashboardEdgeProcessor)",
    "void EdgeContextComponent.setDashboardService(DashboardService)",
    "void EdgeContextComponent.setDbCallbackExecutor(DbCallbackExecutorService)",
    "void EdgeContextComponent.setDeviceEdgeProcessorFactory(DeviceEdgeProcessorFactory)",
    "void EdgeContextComponent.setDeviceProcessor(DeviceEdgeProcessor)",
    "void EdgeContextComponent.setDeviceProfileEdgeProcessorFactory(DeviceProfileEdgeProcessorFactory)",
    "void EdgeContextComponent.setDeviceProfileProcessor(DeviceProfileEdgeProcessor)",
    "void EdgeContextComponent.setDeviceProfileService(DeviceProfileService)",
    "void EdgeContextComponent.setDeviceService(DeviceService)",
    "void EdgeContextComponent.setDomainService(DomainService)",
    "void EdgeContextComponent.setEdgeEventService(EdgeEventService)",
    "void EdgeContextComponent.setEdgeEventStorageSettings(EdgeEventStorageSettings)",
    "void EdgeContextComponent.setEdgeMsgConstructor(EdgeMsgConstructor)",
    "void EdgeContextComponent.setEdgeProcessor(EdgeProcessor)",
    "void EdgeContextComponent.setEdgeRequestsService(EdgeRequestsService)",
    "void EdgeContextComponent.setEdgeRpcService(EdgeRpcService)",
    "void EdgeContextComponent.setEdgeService(EdgeService)",
    "void EdgeContextComponent.setEntityViewProcessor(EntityViewEdgeProcessor)",
    "void EdgeContextComponent.setEntityViewProcessorFactory(EntityViewProcessorFactory)",
    "void EdgeContextComponent.setEntityViewService(EntityViewService)",
    "void EdgeContextComponent.setGrpcCallbackExecutorService(GrpcCallbackExecutorService)",
    "void EdgeContextComponent.setNotificationEdgeProcessor(NotificationEdgeProcessor)",
    "void EdgeContextComponent.setNotificationRuleProcessor(NotificationRuleProcessor)",
    "void EdgeContextComponent.setNotificationRuleService(NotificationRuleService)",
    "void EdgeContextComponent.setNotificationTargetService(NotificationTargetService)",
    "void EdgeContextComponent.setNotificationTemplateService(NotificationTemplateService)",
    "void EdgeContextComponent.setOAuth2EdgeProcessor(OAuth2EdgeProcessor)",
    "void EdgeContextComponent.setOtaPackageProcessor(OtaPackageEdgeProcessor)",
    "void EdgeContextComponent.setOtaPackageService(OtaPackageService)",
    "void EdgeContextComponent.setQueueProcessor(QueueEdgeProcessor)",
    "void EdgeContextComponent.setQueueService(QueueService)",
    "void EdgeContextComponent.setRateLimitService(RateLimitService)",
    "void EdgeContextComponent.setRelationEdgeProcessorFactory(RelationEdgeProcessorFactory)",
    "void EdgeContextComponent.setRelationProcessor(RelationEdgeProcessor)",
    "void EdgeContextComponent.setResourceEdgeProcessorFactory(ResourceEdgeProcessorFactory)",
    "void EdgeContextComponent.setResourceProcessor(ResourceEdgeProcessor)",
    "void EdgeContextComponent.setResourceService(ResourceService)",
    "void EdgeContextComponent.setRuleChainProcessor(RuleChainEdgeProcessor)",
    "void EdgeContextComponent.setRuleChainService(RuleChainService)",
    "void EdgeContextComponent.setTelemetryProcessor(TelemetryEdgeProcessor)",
    "void EdgeContextComponent.setTenantProcessor(TenantEdgeProcessor)",
    "void EdgeContextComponent.setTenantProfileProcessor(TenantProfileEdgeProcessor)",
    "void EdgeContextComponent.setTenantProfileService(TenantProfileService)",
    "void EdgeContextComponent.setTenantService(TenantService)",
    "void EdgeContextComponent.setUserProcessor(UserEdgeProcessor)",
    "void EdgeContextComponent.setUserService(UserService)",
    "void EdgeContextComponent.setWidgetBundleProcessor(WidgetBundleEdgeProcessor)",
    "void EdgeContextComponent.setWidgetTypeProcessor(WidgetTypeEdgeProcessor)",
    "void EdgeContextComponent.setWidgetTypeService(WidgetTypeService)",
    "void EdgeContextComponent.setWidgetsBundleService(WidgetsBundleService)",
    "java.lang.String EdgeContextComponent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    EdgeContextComponent edgeContextComponent = new EdgeContextComponent();
    AdminSettingsEdgeProcessor adminSettingsProcessor = new AdminSettingsEdgeProcessor();

    // Act
    edgeContextComponent.setAdminSettingsProcessor(adminSettingsProcessor);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    edgeContextComponent.setAdminSettingsService(adminSettingsService);
    AlarmEdgeProcessorFactory alarmEdgeProcessorFactory = new AlarmEdgeProcessorFactory();
    edgeContextComponent.setAlarmEdgeProcessorFactory(alarmEdgeProcessorFactory);
    AlarmEdgeProcessorV1 alarmProcessor = new AlarmEdgeProcessorV1();
    edgeContextComponent.setAlarmProcessor(alarmProcessor);
    AssetEdgeProcessorFactory assetEdgeProcessorFactory = new AssetEdgeProcessorFactory();
    edgeContextComponent.setAssetEdgeProcessorFactory(assetEdgeProcessorFactory);
    AssetEdgeProcessorV1 assetProcessor = new AssetEdgeProcessorV1();
    edgeContextComponent.setAssetProcessor(assetProcessor);
    AssetProfileEdgeProcessorFactory assetProfileEdgeProcessorFactory =
        new AssetProfileEdgeProcessorFactory();
    edgeContextComponent.setAssetProfileEdgeProcessorFactory(assetProfileEdgeProcessorFactory);
    AssetProfileEdgeProcessorV1 assetProfileProcessor = new AssetProfileEdgeProcessorV1();
    edgeContextComponent.setAssetProfileProcessor(assetProfileProcessor);
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    edgeContextComponent.setAssetProfileService(assetProfileService);
    BaseAssetService assetService = new BaseAssetService();
    edgeContextComponent.setAssetService(assetService);
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    edgeContextComponent.setAttributesService(attributesService);
    CustomerEdgeProcessor customerProcessor = new CustomerEdgeProcessor();
    edgeContextComponent.setCustomerProcessor(customerProcessor);
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    edgeContextComponent.setCustomerService(customerService);
    DashboardEdgeProcessorFactory dashboardEdgeProcessorFactory =
        new DashboardEdgeProcessorFactory();
    edgeContextComponent.setDashboardEdgeProcessorFactory(dashboardEdgeProcessorFactory);
    DashboardEdgeProcessorV1 dashboardProcessor = new DashboardEdgeProcessorV1();
    edgeContextComponent.setDashboardProcessor(dashboardProcessor);
    DashboardServiceImpl dashboardService = new DashboardServiceImpl();
    edgeContextComponent.setDashboardService(dashboardService);
    DbCallbackExecutorService dbCallbackExecutor = new DbCallbackExecutorService();
    edgeContextComponent.setDbCallbackExecutor(dbCallbackExecutor);
    DeviceEdgeProcessorFactory deviceEdgeProcessorFactory = new DeviceEdgeProcessorFactory();
    edgeContextComponent.setDeviceEdgeProcessorFactory(deviceEdgeProcessorFactory);
    DeviceEdgeProcessorV1 deviceProcessor = new DeviceEdgeProcessorV1();
    edgeContextComponent.setDeviceProcessor(deviceProcessor);
    DeviceProfileEdgeProcessorFactory deviceProfileEdgeProcessorFactory =
        new DeviceProfileEdgeProcessorFactory();
    edgeContextComponent.setDeviceProfileEdgeProcessorFactory(deviceProfileEdgeProcessorFactory);
    DeviceProfileEdgeProcessorV1 deviceProfileProcessor = new DeviceProfileEdgeProcessorV1();
    edgeContextComponent.setDeviceProfileProcessor(deviceProfileProcessor);
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    edgeContextComponent.setDeviceProfileService(deviceProfileService);
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
    edgeContextComponent.setDeviceService(deviceService);
    DomainServiceImpl domainService = new DomainServiceImpl();
    edgeContextComponent.setDomainService(domainService);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao edgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            mock(EdgeEventRepository.class),
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
            mock(JdbcTemplate.class));
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);
    BaseEdgeEventService edgeEventService =
        new BaseEdgeEventService(
            edgeEventDao,
            rateLimitService,
            new EdgeEventDataValidator(),
            mock(ApplicationEventPublisher.class));
    edgeContextComponent.setEdgeEventService(edgeEventService);
    EdgeEventStorageSettings edgeEventStorageSettings = new EdgeEventStorageSettings();
    edgeContextComponent.setEdgeEventStorageSettings(edgeEventStorageSettings);
    EdgeMsgConstructor edgeMsgConstructor = new EdgeMsgConstructor();
    edgeContextComponent.setEdgeMsgConstructor(edgeMsgConstructor);
    EdgeProcessor edgeProcessor = new EdgeProcessor();
    edgeContextComponent.setEdgeProcessor(edgeProcessor);
    DefaultEdgeRequestsService edgeRequestsService = new DefaultEdgeRequestsService();
    edgeContextComponent.setEdgeRequestsService(edgeRequestsService);
    EdgeGrpcService edgeRpcService = new EdgeGrpcService();
    edgeContextComponent.setEdgeRpcService(edgeRpcService);
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    edgeContextComponent.setEdgeService(edgeService);
    EntityViewProcessorV1 entityViewProcessor = new EntityViewProcessorV1();
    edgeContextComponent.setEntityViewProcessor(entityViewProcessor);
    EntityViewProcessorFactory entityViewProcessorFactory = new EntityViewProcessorFactory();
    edgeContextComponent.setEntityViewProcessorFactory(entityViewProcessorFactory);
    EntityViewServiceImpl entityViewService = new EntityViewServiceImpl();
    edgeContextComponent.setEntityViewService(entityViewService);
    GrpcCallbackExecutorService grpcCallbackExecutorService = new GrpcCallbackExecutorService();
    edgeContextComponent.setGrpcCallbackExecutorService(grpcCallbackExecutorService);
    NotificationEdgeProcessor notificationEdgeProcessor = new NotificationEdgeProcessor();
    edgeContextComponent.setNotificationEdgeProcessor(notificationEdgeProcessor);
    NotificationRuleProcessor notificationRuleProcessor = mock(NotificationRuleProcessor.class);
    edgeContextComponent.setNotificationRuleProcessor(notificationRuleProcessor);
    JpaNotificationRuleDao notificationRuleDao =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    DefaultNotificationRuleService notificationRuleService =
        new DefaultNotificationRuleService(notificationRuleDao);
    edgeContextComponent.setNotificationRuleService(notificationRuleService);
    JpaNotificationTargetDao notificationTargetDao =
        new JpaNotificationTargetDao(mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 =
        new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService =
        new UserServiceImpl(
            userDao,
            userCredentialsDao,
            userAuthSettingsDao,
            userSettingsService,
            userSettingsDao,
            securitySettingsService,
            userValidator,
            userCredentialsValidator,
            eventPublisher,
            countService2,
            new JpaExecutorService());
    DefaultNotificationTargetService notificationTargetService =
        new DefaultNotificationTargetService(
            notificationTargetDao, notificationRequestDao, notificationRuleDao2, userService);
    edgeContextComponent.setNotificationTargetService(notificationTargetService);
    JpaNotificationTemplateDao notificationTemplateDao =
        new JpaNotificationTemplateDao(mock(NotificationTemplateRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));
    DefaultNotificationTemplateService notificationTemplateService =
        new DefaultNotificationTemplateService(notificationTemplateDao, notificationRequestDao2);
    edgeContextComponent.setNotificationTemplateService(notificationTemplateService);
    OAuth2EdgeProcessor oAuth2EdgeProcessor = new OAuth2EdgeProcessor();
    edgeContextComponent.setOAuth2EdgeProcessor(oAuth2EdgeProcessor);
    OtaPackageEdgeProcessor otaPackageProcessor = new OtaPackageEdgeProcessor();
    edgeContextComponent.setOtaPackageProcessor(otaPackageProcessor);
    QueueEdgeProcessor queueProcessor = new QueueEdgeProcessor();
    edgeContextComponent.setQueueProcessor(queueProcessor);
    BaseQueueService queueService = new BaseQueueService();
    edgeContextComponent.setQueueService(queueService);
    DefaultRateLimitService rateLimitService2 =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);
    edgeContextComponent.setRateLimitService(rateLimitService2);
    RelationEdgeProcessorFactory relationEdgeProcessorFactory = new RelationEdgeProcessorFactory();
    edgeContextComponent.setRelationEdgeProcessorFactory(relationEdgeProcessorFactory);
    RelationEdgeProcessorV1 relationProcessor = new RelationEdgeProcessorV1();
    edgeContextComponent.setRelationProcessor(relationProcessor);
    ResourceEdgeProcessorFactory resourceEdgeProcessorFactory = new ResourceEdgeProcessorFactory();
    edgeContextComponent.setResourceEdgeProcessorFactory(resourceEdgeProcessorFactory);
    ResourceEdgeProcessorV1 resourceProcessor = new ResourceEdgeProcessorV1();
    edgeContextComponent.setResourceProcessor(resourceProcessor);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    BaseResourceService resourceService =
        new BaseResourceService(resourceDao, resourceInfoDao, new ResourceDataValidator());
    edgeContextComponent.setResourceService(resourceService);
    RuleChainEdgeProcessor ruleChainProcessor = new RuleChainEdgeProcessor();
    edgeContextComponent.setRuleChainProcessor(ruleChainProcessor);
    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    edgeContextComponent.setRuleChainService(ruleChainService);
    TelemetryEdgeProcessor telemetryProcessor = new TelemetryEdgeProcessor();
    edgeContextComponent.setTelemetryProcessor(telemetryProcessor);
    TenantEdgeProcessor tenantProcessor = new TenantEdgeProcessor();
    edgeContextComponent.setTenantProcessor(tenantProcessor);
    TenantProfileEdgeProcessor tenantProfileProcessor = new TenantProfileEdgeProcessor();
    edgeContextComponent.setTenantProfileProcessor(tenantProfileProcessor);
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    edgeContextComponent.setTenantProfileService(tenantProfileService);
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    edgeContextComponent.setTenantService(tenantService2);
    UserEdgeProcessor userProcessor = new UserEdgeProcessor();
    edgeContextComponent.setUserProcessor(userProcessor);
    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 =
        new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService2 =
        new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService2 =
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService3 = new BaseEntityCountService();
    UserServiceImpl userService2 =
        new UserServiceImpl(
            userDao2,
            userCredentialsDao2,
            userAuthSettingsDao2,
            userSettingsService2,
            userSettingsDao2,
            securitySettingsService2,
            userValidator2,
            userCredentialsValidator2,
            eventPublisher2,
            countService3,
            new JpaExecutorService());
    edgeContextComponent.setUserService(userService2);
    WidgetBundleEdgeProcessor widgetBundleProcessor = new WidgetBundleEdgeProcessor();
    edgeContextComponent.setWidgetBundleProcessor(widgetBundleProcessor);
    WidgetTypeEdgeProcessor widgetTypeProcessor = new WidgetTypeEdgeProcessor();
    edgeContextComponent.setWidgetTypeProcessor(widgetTypeProcessor);
    WidgetTypeServiceImpl widgetTypeService = new WidgetTypeServiceImpl();
    edgeContextComponent.setWidgetTypeService(widgetTypeService);
    WidgetsBundleServiceImpl widgetsBundleService = new WidgetsBundleServiceImpl();
    edgeContextComponent.setWidgetsBundleService(widgetsBundleService);
    edgeContextComponent.toString();
    AdminSettingsEdgeProcessor actualAdminSettingsProcessor =
        edgeContextComponent.getAdminSettingsProcessor();
    AdminSettingsService actualAdminSettingsService =
        edgeContextComponent.getAdminSettingsService();
    AlarmEdgeProcessorFactory actualAlarmEdgeProcessorFactory =
        edgeContextComponent.getAlarmEdgeProcessorFactory();
    AlarmEdgeProcessor actualAlarmProcessor = edgeContextComponent.getAlarmProcessor();
    AssetEdgeProcessorFactory actualAssetEdgeProcessorFactory =
        edgeContextComponent.getAssetEdgeProcessorFactory();
    AssetEdgeProcessor actualAssetProcessor = edgeContextComponent.getAssetProcessor();
    AssetProfileEdgeProcessorFactory actualAssetProfileEdgeProcessorFactory =
        edgeContextComponent.getAssetProfileEdgeProcessorFactory();
    AssetProfileEdgeProcessor actualAssetProfileProcessor =
        edgeContextComponent.getAssetProfileProcessor();
    AssetProfileService actualAssetProfileService = edgeContextComponent.getAssetProfileService();
    AssetService actualAssetService = edgeContextComponent.getAssetService();
    AttributesService actualAttributesService = edgeContextComponent.getAttributesService();
    TbClusterService actualClusterService = edgeContextComponent.getClusterService();
    CustomerEdgeProcessor actualCustomerProcessor = edgeContextComponent.getCustomerProcessor();
    CustomerService actualCustomerService = edgeContextComponent.getCustomerService();
    DashboardEdgeProcessorFactory actualDashboardEdgeProcessorFactory =
        edgeContextComponent.getDashboardEdgeProcessorFactory();
    DashboardEdgeProcessor actualDashboardProcessor = edgeContextComponent.getDashboardProcessor();
    DashboardService actualDashboardService = edgeContextComponent.getDashboardService();
    DbCallbackExecutorService actualDbCallbackExecutor =
        edgeContextComponent.getDbCallbackExecutor();
    DeviceEdgeProcessorFactory actualDeviceEdgeProcessorFactory =
        edgeContextComponent.getDeviceEdgeProcessorFactory();
    DeviceEdgeProcessor actualDeviceProcessor = edgeContextComponent.getDeviceProcessor();
    DeviceProfileEdgeProcessorFactory actualDeviceProfileEdgeProcessorFactory =
        edgeContextComponent.getDeviceProfileEdgeProcessorFactory();
    DeviceProfileEdgeProcessor actualDeviceProfileProcessor =
        edgeContextComponent.getDeviceProfileProcessor();
    DeviceProfileService actualDeviceProfileService =
        edgeContextComponent.getDeviceProfileService();
    DeviceService actualDeviceService = edgeContextComponent.getDeviceService();
    DomainService actualDomainService = edgeContextComponent.getDomainService();
    EdgeEventService actualEdgeEventService = edgeContextComponent.getEdgeEventService();
    EdgeEventStorageSettings actualEdgeEventStorageSettings =
        edgeContextComponent.getEdgeEventStorageSettings();
    EdgeMsgConstructor actualEdgeMsgConstructor = edgeContextComponent.getEdgeMsgConstructor();
    EdgeProcessor actualEdgeProcessor = edgeContextComponent.getEdgeProcessor();
    EdgeRequestsService actualEdgeRequestsService = edgeContextComponent.getEdgeRequestsService();
    EdgeRpcService actualEdgeRpcService = edgeContextComponent.getEdgeRpcService();
    EdgeService actualEdgeService = edgeContextComponent.getEdgeService();
    EntityViewEdgeProcessor actualEntityViewProcessor =
        edgeContextComponent.getEntityViewProcessor();
    EntityViewProcessorFactory actualEntityViewProcessorFactory =
        edgeContextComponent.getEntityViewProcessorFactory();
    EntityViewService actualEntityViewService = edgeContextComponent.getEntityViewService();
    GrpcCallbackExecutorService actualGrpcCallbackExecutorService =
        edgeContextComponent.getGrpcCallbackExecutorService();
    NotificationEdgeProcessor actualNotificationEdgeProcessor =
        edgeContextComponent.getNotificationEdgeProcessor();
    NotificationRuleProcessor actualNotificationRuleProcessor =
        edgeContextComponent.getNotificationRuleProcessor();
    NotificationRuleService actualNotificationRuleService =
        edgeContextComponent.getNotificationRuleService();
    NotificationTargetService actualNotificationTargetService =
        edgeContextComponent.getNotificationTargetService();
    NotificationTemplateService actualNotificationTemplateService =
        edgeContextComponent.getNotificationTemplateService();
    OAuth2EdgeProcessor actualOAuth2EdgeProcessor = edgeContextComponent.getOAuth2EdgeProcessor();
    OtaPackageEdgeProcessor actualOtaPackageProcessor =
        edgeContextComponent.getOtaPackageProcessor();
    OtaPackageService actualOtaPackageService = edgeContextComponent.getOtaPackageService();
    QueueEdgeProcessor actualQueueProcessor = edgeContextComponent.getQueueProcessor();
    QueueService actualQueueService = edgeContextComponent.getQueueService();
    RateLimitService actualRateLimitService = edgeContextComponent.getRateLimitService();
    RelationEdgeProcessorFactory actualRelationEdgeProcessorFactory =
        edgeContextComponent.getRelationEdgeProcessorFactory();
    RelationEdgeProcessor actualRelationProcessor = edgeContextComponent.getRelationProcessor();
    ResourceEdgeProcessorFactory actualResourceEdgeProcessorFactory =
        edgeContextComponent.getResourceEdgeProcessorFactory();
    ResourceEdgeProcessor actualResourceProcessor = edgeContextComponent.getResourceProcessor();
    ResourceService actualResourceService = edgeContextComponent.getResourceService();
    RuleChainEdgeProcessor actualRuleChainProcessor = edgeContextComponent.getRuleChainProcessor();
    RuleChainService actualRuleChainService = edgeContextComponent.getRuleChainService();
    TelemetryEdgeProcessor actualTelemetryProcessor = edgeContextComponent.getTelemetryProcessor();
    TenantEdgeProcessor actualTenantProcessor = edgeContextComponent.getTenantProcessor();
    TenantProfileEdgeProcessor actualTenantProfileProcessor =
        edgeContextComponent.getTenantProfileProcessor();
    TenantProfileService actualTenantProfileService =
        edgeContextComponent.getTenantProfileService();
    TenantService actualTenantService = edgeContextComponent.getTenantService();
    UserEdgeProcessor actualUserProcessor = edgeContextComponent.getUserProcessor();
    UserService actualUserService = edgeContextComponent.getUserService();
    WidgetBundleEdgeProcessor actualWidgetBundleProcessor =
        edgeContextComponent.getWidgetBundleProcessor();
    WidgetTypeEdgeProcessor actualWidgetTypeProcessor =
        edgeContextComponent.getWidgetTypeProcessor();
    WidgetTypeService actualWidgetTypeService = edgeContextComponent.getWidgetTypeService();
    WidgetsBundleService actualWidgetsBundleService =
        edgeContextComponent.getWidgetsBundleService();

    // Assert
    assertTrue(actualRateLimitService instanceof DefaultRateLimitService);
    assertTrue(actualAssetProfileService instanceof AssetProfileServiceImpl);
    assertTrue(actualAssetService instanceof BaseAssetService);
    assertTrue(actualAttributesService instanceof BaseAttributesService);
    assertTrue(actualCustomerService instanceof CustomerServiceImpl);
    assertTrue(actualDashboardService instanceof DashboardServiceImpl);
    assertTrue(actualDeviceProfileService instanceof DeviceProfileServiceImpl);
    assertTrue(actualDeviceService instanceof DeviceServiceImpl);
    assertTrue(actualDomainService instanceof DomainServiceImpl);
    assertTrue(actualEdgeEventService instanceof BaseEdgeEventService);
    assertTrue(actualEntityViewService instanceof EntityViewServiceImpl);
    assertTrue(actualNotificationRuleService instanceof DefaultNotificationRuleService);
    assertTrue(actualNotificationTargetService instanceof DefaultNotificationTargetService);
    assertTrue(actualNotificationTemplateService instanceof DefaultNotificationTemplateService);
    assertTrue(actualQueueService instanceof BaseQueueService);
    assertTrue(actualResourceService instanceof BaseResourceService);
    assertTrue(actualRuleChainService instanceof BaseRuleChainService);
    assertTrue(actualAdminSettingsService instanceof AdminSettingsServiceImpl);
    assertTrue(actualTenantProfileService instanceof TenantProfileServiceImpl);
    assertTrue(actualTenantService instanceof TenantServiceImpl);
    assertTrue(actualUserService instanceof UserServiceImpl);
    assertTrue(actualWidgetTypeService instanceof WidgetTypeServiceImpl);
    assertTrue(actualWidgetsBundleService instanceof WidgetsBundleServiceImpl);
    assertTrue(actualEdgeRpcService instanceof EdgeGrpcService);
    assertTrue(actualAlarmProcessor instanceof AlarmEdgeProcessorV1);
    assertTrue(actualAssetProcessor instanceof AssetEdgeProcessorV1);
    assertTrue(actualAssetProfileProcessor instanceof AssetProfileEdgeProcessorV1);
    assertTrue(actualDashboardProcessor instanceof DashboardEdgeProcessorV1);
    assertTrue(actualDeviceProcessor instanceof DeviceEdgeProcessorV1);
    assertTrue(actualDeviceProfileProcessor instanceof DeviceProfileEdgeProcessorV1);
    assertTrue(actualEntityViewProcessor instanceof EntityViewProcessorV1);
    assertTrue(actualRelationProcessor instanceof RelationEdgeProcessorV1);
    assertTrue(actualResourceProcessor instanceof ResourceEdgeProcessorV1);
    assertTrue(actualEdgeRequestsService instanceof DefaultEdgeRequestsService);
    assertNull(actualDbCallbackExecutor.executor());
    assertNull(actualGrpcCallbackExecutorService.executor());
    assertNull(actualClusterService);
    assertNull(actualOtaPackageService);
    assertSame(rateLimitService2, actualRateLimitService);
    assertSame(assetProfileService, actualAssetProfileService);
    assertSame(assetService, actualAssetService);
    assertSame(attributesService, actualAttributesService);
    assertSame(customerService, actualCustomerService);
    assertSame(dashboardService, actualDashboardService);
    assertSame(deviceProfileService, actualDeviceProfileService);
    assertSame(deviceService, actualDeviceService);
    assertSame(domainService, actualDomainService);
    assertSame(edgeEventService, actualEdgeEventService);
    assertSame(edgeService, actualEdgeService);
    assertSame(entityViewService, actualEntityViewService);
    assertSame(notificationRuleService, actualNotificationRuleService);
    assertSame(notificationTargetService, actualNotificationTargetService);
    assertSame(notificationTemplateService, actualNotificationTemplateService);
    assertSame(queueService, actualQueueService);
    assertSame(resourceService, actualResourceService);
    assertSame(ruleChainService, actualRuleChainService);
    assertSame(adminSettingsService, actualAdminSettingsService);
    assertSame(tenantProfileService, actualTenantProfileService);
    assertSame(tenantService2, actualTenantService);
    assertSame(userService2, actualUserService);
    assertSame(widgetTypeService, actualWidgetTypeService);
    assertSame(widgetsBundleService, actualWidgetsBundleService);
    assertSame(edgeEventStorageSettings, actualEdgeEventStorageSettings);
    assertSame(edgeRpcService, actualEdgeRpcService);
    assertSame(edgeMsgConstructor, actualEdgeMsgConstructor);
    assertSame(alarmEdgeProcessorFactory, actualAlarmEdgeProcessorFactory);
    assertSame(alarmProcessor, actualAlarmProcessor);
    assertSame(assetEdgeProcessorFactory, actualAssetEdgeProcessorFactory);
    assertSame(assetProcessor, actualAssetProcessor);
    assertSame(assetProfileEdgeProcessorFactory, actualAssetProfileEdgeProcessorFactory);
    assertSame(assetProfileProcessor, actualAssetProfileProcessor);
    assertSame(customerProcessor, actualCustomerProcessor);
    assertSame(dashboardEdgeProcessorFactory, actualDashboardEdgeProcessorFactory);
    assertSame(dashboardProcessor, actualDashboardProcessor);
    assertSame(deviceEdgeProcessorFactory, actualDeviceEdgeProcessorFactory);
    assertSame(deviceProcessor, actualDeviceProcessor);
    assertSame(deviceProfileEdgeProcessorFactory, actualDeviceProfileEdgeProcessorFactory);
    assertSame(deviceProfileProcessor, actualDeviceProfileProcessor);
    assertSame(edgeProcessor, actualEdgeProcessor);
    assertSame(entityViewProcessorFactory, actualEntityViewProcessorFactory);
    assertSame(entityViewProcessor, actualEntityViewProcessor);
    assertSame(notificationEdgeProcessor, actualNotificationEdgeProcessor);
    assertSame(oAuth2EdgeProcessor, actualOAuth2EdgeProcessor);
    assertSame(otaPackageProcessor, actualOtaPackageProcessor);
    assertSame(queueProcessor, actualQueueProcessor);
    assertSame(relationEdgeProcessorFactory, actualRelationEdgeProcessorFactory);
    assertSame(relationProcessor, actualRelationProcessor);
    assertSame(resourceEdgeProcessorFactory, actualResourceEdgeProcessorFactory);
    assertSame(resourceProcessor, actualResourceProcessor);
    assertSame(ruleChainProcessor, actualRuleChainProcessor);
    assertSame(adminSettingsProcessor, actualAdminSettingsProcessor);
    assertSame(telemetryProcessor, actualTelemetryProcessor);
    assertSame(tenantProcessor, actualTenantProcessor);
    assertSame(tenantProfileProcessor, actualTenantProfileProcessor);
    assertSame(userProcessor, actualUserProcessor);
    assertSame(widgetBundleProcessor, actualWidgetBundleProcessor);
    assertSame(widgetTypeProcessor, actualWidgetTypeProcessor);
    assertSame(edgeRequestsService, actualEdgeRequestsService);
    assertSame(dbCallbackExecutor, actualDbCallbackExecutor);
    assertSame(grpcCallbackExecutorService, actualGrpcCallbackExecutorService);
    assertSame(notificationRuleProcessor, actualNotificationRuleProcessor);
  }
}
