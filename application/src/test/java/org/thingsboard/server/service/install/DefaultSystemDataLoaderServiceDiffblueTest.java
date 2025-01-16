package org.thingsboard.server.service.install;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.cluster.TbClusterService;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.mobile.MobileApp;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.security.model.JwtSettings;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.attributes.AttributesService;
import org.thingsboard.server.dao.attributes.BaseAttributesService;
import org.thingsboard.server.dao.customer.CustomerService;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.device.DeviceConnectivityConfiguration;
import org.thingsboard.server.dao.device.DeviceConnectivityInfo;
import org.thingsboard.server.dao.device.DeviceCredentialsService;
import org.thingsboard.server.dao.device.DeviceCredentialsServiceImpl;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceService;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.mobile.MobileAppDao;
import org.thingsboard.server.dao.notification.DefaultNotificationRuleService;
import org.thingsboard.server.dao.notification.DefaultNotificationSettingsService;
import org.thingsboard.server.dao.notification.DefaultNotificationTargetService;
import org.thingsboard.server.dao.notification.DefaultNotificationTemplateService;
import org.thingsboard.server.dao.notification.DefaultNotifications;
import org.thingsboard.server.dao.notification.NotificationSettingsService;
import org.thingsboard.server.dao.notification.NotificationTargetService;
import org.thingsboard.server.dao.queue.BaseQueueService;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.rule.BaseRuleChainService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.service.validator.DeviceCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceCredentialsDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.sql.mobile.JpaMobileAppDao;
import org.thingsboard.server.dao.sql.mobile.MobileAppOauth2ClientRepository;
import org.thingsboard.server.dao.sql.mobile.MobileAppRepository;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRuleDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTargetDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRuleRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTargetRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.tenant.TenantProfileService;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.timeseries.TimeseriesService;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.security.auth.jwt.settings.DefaultJwtSettingsService;
import org.thingsboard.server.service.security.auth.jwt.settings.JwtSettingsService;
import org.thingsboard.server.service.security.auth.jwt.settings.JwtSettingsValidator;
import org.thingsboard.server.service.security.model.token.JwtTokenFactory;

class DefaultSystemDataLoaderServiceDiffblueTest {
  /**
   * Test {@link DefaultSystemDataLoaderService#createSysAdmin()}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#createSysAdmin()}
   */
  @Test
  @DisplayName("Test createSysAdmin(); then throw DataValidationException")
  void testCreateSysAdmin_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(userService.saveUser(Mockito.<TenantId>any(), Mockito.<User>any())).thenReturn(new User());
    InstallScripts installScripts = mock(InstallScripts.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
            mock(NotificationSettingsService.class), mock(NotificationTargetService.class))).createSysAdmin());
    verify(userService).findUserCredentialsByUserId(isA(TenantId.class), isNull());
    verify(userService).saveUser(isNull(), isA(User.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createDefaultTenantProfiles()}.
   * <ul>
   *   <li>Then calls
   * {@link TenantProfileService#saveTenantProfile(TenantId, TenantProfile)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createDefaultTenantProfiles()}
   */
  @Test
  @DisplayName("Test createDefaultTenantProfiles(); then calls saveTenantProfile(TenantId, TenantProfile)")
  void testCreateDefaultTenantProfiles_thenCallsSaveTenantProfile() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(new TenantProfile());
    when(tenantProfileService.saveTenantProfile(Mockito.<TenantId>any(), Mockito.<TenantProfile>any()))
        .thenReturn(new TenantProfile());
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
        mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
        mock(NotificationSettingsService.class), mock(NotificationTargetService.class))).createDefaultTenantProfiles();

    // Assert
    verify(tenantProfileService).findOrCreateDefaultTenantProfile(isA(TenantId.class));
    verify(tenantProfileService).saveTenantProfile(isA(TenantId.class), isA(TenantProfile.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createDefaultTenantProfiles()}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createDefaultTenantProfiles()}
   */
  @Test
  @DisplayName("Test createDefaultTenantProfiles(); then throw DataValidationException")
  void testCreateDefaultTenantProfiles_thenThrowDataValidationException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
            mock(NotificationSettingsService.class), mock(NotificationTargetService.class)))
            .createDefaultTenantProfiles());
    verify(tenantProfileService).findOrCreateDefaultTenantProfile(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createAdminSettings()}.
   * <ul>
   *   <li>Given {@link DeviceConnectivityInfo} (default constructor) Enabled is
   * {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createAdminSettings()}
   */
  @Test
  @DisplayName("Test createAdminSettings(); given DeviceConnectivityInfo (default constructor) Enabled is 'true'")
  void testCreateAdminSettings_givenDeviceConnectivityInfoEnabledIsTrue() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());

    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();
    connectivity.put("foo", deviceConnectivityInfo);

    DeviceConnectivityConfiguration connectivityConfiguration = new DeviceConnectivityConfiguration();
    connectivityConfiguration.setConnectivity(connectivity);

    // Act
    (new DefaultSystemDataLoaderService(mock(InstallScripts.class), mock(UserService.class), adminSettingsService,
        mock(TenantService.class), mock(TenantProfileService.class), mock(CustomerService.class),
        mock(DeviceService.class), mock(DeviceProfileService.class), mock(AttributesService.class),
        mock(DeviceCredentialsService.class), mock(RuleChainService.class), mock(TimeseriesService.class),
        connectivityConfiguration, mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
        mock(NotificationSettingsService.class), mock(NotificationTargetService.class))).createAdminSettings();

    // Assert
    verify(adminSettingsService, atLeast(1)).saveAdminSettings(isA(TenantId.class), Mockito.<AdminSettings>any());
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createAdminSettings()}.
   * <ul>
   *   <li>Then calls
   * {@link AdminSettingsService#saveAdminSettings(TenantId, AdminSettings)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createAdminSettings()}
   */
  @Test
  @DisplayName("Test createAdminSettings(); then calls saveAdminSettings(TenantId, AdminSettings)")
  void testCreateAdminSettings_thenCallsSaveAdminSettings() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(new AdminSettings());
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
        mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
        mock(NotificationSettingsService.class), mock(NotificationTargetService.class))).createAdminSettings();

    // Assert
    verify(adminSettingsService, atLeast(1)).saveAdminSettings(isA(TenantId.class), Mockito.<AdminSettings>any());
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createAdminSettings()}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createAdminSettings()}
   */
  @Test
  @DisplayName("Test createAdminSettings(); then throw DataValidationException")
  void testCreateAdminSettings_thenThrowDataValidationException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.saveAdminSettings(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
            mock(NotificationSettingsService.class), mock(NotificationTargetService.class))).createAdminSettings());
    verify(adminSettingsService).saveAdminSettings(isA(TenantId.class), isA(AdminSettings.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createRandomJwtSettings()}.
   * <ul>
   *   <li>Then calls {@link JwtSettingsService#getJwtSettings()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createRandomJwtSettings()}
   */
  @Test
  @DisplayName("Test createRandomJwtSettings(); then calls getJwtSettings()")
  void testCreateRandomJwtSettings_thenCallsGetJwtSettings() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JwtSettingsService jwtSettingsService = mock(JwtSettingsService.class);
    when(jwtSettingsService.getJwtSettings()).thenReturn(new JwtSettings());
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
        mock(QueueService.class), jwtSettingsService, mock(MobileAppDao.class), mock(NotificationSettingsService.class),
        mock(NotificationTargetService.class))).createRandomJwtSettings();

    // Assert that nothing has changed
    verify(jwtSettingsService).getJwtSettings();
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#updateSecuritySettings()}.
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#updateSecuritySettings()}
   */
  @Test
  @DisplayName("Test updateSecuritySettings()")
  void testUpdateSecuritySettings() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("thingsboardDefaultSigningKey");
    JwtSettingsService jwtSettingsService = mock(JwtSettingsService.class);
    when(jwtSettingsService.saveJwtSettings(Mockito.<JwtSettings>any())).thenReturn(new JwtSettings());
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);
    MobileAppDao mobileAppDao = mock(MobileAppDao.class);
    PageData<MobileApp> emptyPageDataResult = PageData.emptyPageData();
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
        mock(QueueService.class), jwtSettingsService, mobileAppDao, mock(NotificationSettingsService.class),
        mock(NotificationTargetService.class))).updateSecuritySettings();

    // Assert
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(jwtSettingsService).getJwtSettings();
    verify(jwtSettingsService).saveJwtSettings(isA(JwtSettings.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#updateSecuritySettings()}.
   * <ul>
   *   <li>Given {@link MobileAppDao}
   * {@link MobileAppDao#findByTenantId(TenantId, PageLink)} return
   * emptyPageData.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#updateSecuritySettings()}
   */
  @Test
  @DisplayName("Test updateSecuritySettings(); given MobileAppDao findByTenantId(TenantId, PageLink) return emptyPageData")
  void testUpdateSecuritySettings_givenMobileAppDaoFindByTenantIdReturnEmptyPageData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("ABC123");
    JwtSettingsService jwtSettingsService = mock(JwtSettingsService.class);
    when(jwtSettingsService.saveJwtSettings(Mockito.<JwtSettings>any())).thenReturn(new JwtSettings());
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);
    MobileAppDao mobileAppDao = mock(MobileAppDao.class);
    PageData<MobileApp> emptyPageDataResult = PageData.emptyPageData();
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
        mock(QueueService.class), jwtSettingsService, mobileAppDao, mock(NotificationSettingsService.class),
        mock(NotificationTargetService.class))).updateSecuritySettings();

    // Assert
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(jwtSettingsService).getJwtSettings();
    verify(jwtSettingsService).saveJwtSettings(isA(JwtSettings.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#updateSecuritySettings()}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#updateSecuritySettings()}
   */
  @Test
  @DisplayName("Test updateSecuritySettings(); then throw DataValidationException")
  void testUpdateSecuritySettings_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JwtSettings jwtSettings = new JwtSettings();
    jwtSettings.setTokenSigningKey("ABC123");
    JwtSettingsService jwtSettingsService = mock(JwtSettingsService.class);
    when(jwtSettingsService.saveJwtSettings(Mockito.<JwtSettings>any())).thenReturn(new JwtSettings());
    when(jwtSettingsService.getJwtSettings()).thenReturn(jwtSettings);
    MobileAppDao mobileAppDao = mock(MobileAppDao.class);
    when(mobileAppDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), jwtSettingsService, mobileAppDao, mock(NotificationSettingsService.class),
            mock(NotificationTargetService.class))).updateSecuritySettings());
    verify(mobileAppDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(jwtSettingsService).getJwtSettings();
    verify(jwtSettingsService).saveJwtSettings(isA(JwtSettings.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createOAuth2Templates()}.
   * <ul>
   *   <li>Given {@link InstallScripts}
   * {@link InstallScripts#createOAuth2Templates()} does nothing.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createOAuth2Templates()}
   */
  @Test
  @DisplayName("Test createOAuth2Templates(); given InstallScripts createOAuth2Templates() does nothing")
  void testCreateOAuth2Templates_givenInstallScriptsCreateOAuth2TemplatesDoesNothing() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    doNothing().when(installScripts).createOAuth2Templates();
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
        mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
        mock(NotificationSettingsService.class), mock(NotificationTargetService.class))).createOAuth2Templates();

    // Assert that nothing has changed
    verify(installScripts).createOAuth2Templates();
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createOAuth2Templates()}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createOAuth2Templates()}
   */
  @Test
  @DisplayName("Test createOAuth2Templates(); then throw DataValidationException")
  void testCreateOAuth2Templates_thenThrowDataValidationException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    doThrow(new DataValidationException("An error occurred")).when(installScripts).createOAuth2Templates();
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
            mock(NotificationSettingsService.class), mock(NotificationTargetService.class))).createOAuth2Templates());
    verify(installScripts).createOAuth2Templates();
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#loadSystemWidgets()}.
   * <ul>
   *   <li>Given {@link InstallScripts} {@link InstallScripts#loadSystemWidgets()}
   * does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#loadSystemWidgets()}
   */
  @Test
  @DisplayName("Test loadSystemWidgets(); given InstallScripts loadSystemWidgets() does nothing")
  void testLoadSystemWidgets_givenInstallScriptsLoadSystemWidgetsDoesNothing() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    doNothing().when(installScripts).loadSystemWidgets();
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
        mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
        mock(NotificationSettingsService.class), mock(NotificationTargetService.class))).loadSystemWidgets();

    // Assert that nothing has changed
    verify(installScripts).loadSystemWidgets();
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#loadSystemWidgets()}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#loadSystemWidgets()}
   */
  @Test
  @DisplayName("Test loadSystemWidgets(); then throw DataValidationException")
  void testLoadSystemWidgets_thenThrowDataValidationException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    InstallScripts installScripts = mock(InstallScripts.class);
    doThrow(new DataValidationException("An error occurred")).when(installScripts).loadSystemWidgets();
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
            mock(NotificationSettingsService.class), mock(NotificationTargetService.class))).loadSystemWidgets());
    verify(installScripts).loadSystemWidgets();
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createQueues()}.
   * <ul>
   *   <li>Given {@link QueueService}
   * {@link QueueService#findQueueByTenantIdAndName(TenantId, String)} return
   * {@link Queue#Queue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#createQueues()}
   */
  @Test
  @DisplayName("Test createQueues(); given QueueService findQueueByTenantIdAndName(TenantId, String) return Queue()")
  void testCreateQueues_givenQueueServiceFindQueueByTenantIdAndNameReturnQueue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    QueueService queueService = mock(QueueService.class);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(), queueService,
        mock(JwtSettingsService.class), mock(MobileAppDao.class), mock(NotificationSettingsService.class),
        mock(NotificationTargetService.class))).createQueues();

    // Assert
    verify(queueService, atLeast(1)).findQueueByTenantIdAndName(isA(TenantId.class), Mockito.<String>any());
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createQueues()}.
   * <ul>
   *   <li>Then calls {@link QueueService#saveQueue(Queue)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#createQueues()}
   */
  @Test
  @DisplayName("Test createQueues(); then calls saveQueue(Queue)")
  void testCreateQueues_thenCallsSaveQueue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    QueueService queueService = mock(QueueService.class);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    when(queueService.saveQueue(Mockito.<Queue>any())).thenReturn(new Queue());
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(), queueService,
        mock(JwtSettingsService.class), mock(MobileAppDao.class), mock(NotificationSettingsService.class),
        mock(NotificationTargetService.class))).createQueues();

    // Assert
    verify(queueService, atLeast(1)).findQueueByTenantIdAndName(isA(TenantId.class), Mockito.<String>any());
    verify(queueService, atLeast(1)).saveQueue(Mockito.<Queue>any());
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#createQueues()}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemDataLoaderService#createQueues()}
   */
  @Test
  @DisplayName("Test createQueues(); then throw DataValidationException")
  void testCreateQueues_thenThrowDataValidationException() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    QueueService queueService = mock(QueueService.class);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(), queueService,
            mock(JwtSettingsService.class), mock(MobileAppDao.class), mock(NotificationSettingsService.class),
            mock(NotificationTargetService.class))).createQueues());
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Main"));
  }

  /**
   * Test
   * {@link DefaultSystemDataLoaderService#createDefaultNotificationConfigs()}.
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createDefaultNotificationConfigs()}
   */
  @Test
  @DisplayName("Test createDefaultNotificationConfigs()")
  void testCreateDefaultNotificationConfigs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantService tenantService = mock(TenantService.class);
    PageData<TenantId> emptyPageDataResult = PageData.emptyPageData();
    when(tenantService.findTenantsIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    NotificationTargetService notificationTargetService = mock(NotificationTargetService.class);
    when(notificationTargetService.countNotificationTargetsByTenantId(Mockito.<TenantId>any())).thenReturn(1L);
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
        mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
        mock(NotificationSettingsService.class), notificationTargetService)).createDefaultNotificationConfigs();

    // Assert
    verify(notificationTargetService).countNotificationTargetsByTenantId(isA(TenantId.class));
    verify(tenantService).findTenantsIds(isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultSystemDataLoaderService#createDefaultNotificationConfigs()}.
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createDefaultNotificationConfigs()}
   */
  @Test
  @DisplayName("Test createDefaultNotificationConfigs()")
  void testCreateDefaultNotificationConfigs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationTargetService notificationTargetService = mock(NotificationTargetService.class);
    when(notificationTargetService.countNotificationTargetsByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
            mock(NotificationSettingsService.class), notificationTargetService)).createDefaultNotificationConfigs());
    verify(notificationTargetService).countNotificationTargetsByTenantId(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultSystemDataLoaderService#createDefaultNotificationConfigs()}.
   * <ul>
   *   <li>Then calls
   * {@link NotificationSettingsService#createDefaultNotificationConfigs(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createDefaultNotificationConfigs()}
   */
  @Test
  @DisplayName("Test createDefaultNotificationConfigs(); then calls createDefaultNotificationConfigs(TenantId)")
  void testCreateDefaultNotificationConfigs_thenCallsCreateDefaultNotificationConfigs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageData<TenantId> pageData = mock(PageData.class);
    when(pageData.getData()).thenThrow(new DataValidationException("An error occurred"));
    TenantService tenantService = mock(TenantService.class);
    when(tenantService.findTenantsIds(Mockito.<PageLink>any())).thenReturn(pageData);
    NotificationSettingsService notificationSettingsService = mock(NotificationSettingsService.class);
    doNothing().when(notificationSettingsService).createDefaultNotificationConfigs(Mockito.<TenantId>any());
    NotificationTargetService notificationTargetService = mock(NotificationTargetService.class);
    when(notificationTargetService.countNotificationTargetsByTenantId(Mockito.<TenantId>any())).thenReturn(0L);
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
            notificationSettingsService, notificationTargetService)).createDefaultNotificationConfigs());
    verify(pageData).getData();
    verify(notificationSettingsService).createDefaultNotificationConfigs(isA(TenantId.class));
    verify(notificationTargetService).countNotificationTargetsByTenantId(isA(TenantId.class));
    verify(tenantService).findTenantsIds(isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultSystemDataLoaderService#createDefaultNotificationConfigs()}.
   * <ul>
   *   <li>Then calls {@link PageData#getData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#createDefaultNotificationConfigs()}
   */
  @Test
  @DisplayName("Test createDefaultNotificationConfigs(); then calls getData()")
  void testCreateDefaultNotificationConfigs_thenCallsGetData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageData<TenantId> pageData = mock(PageData.class);
    when(pageData.getData()).thenThrow(new DataValidationException("An error occurred"));
    TenantService tenantService = mock(TenantService.class);
    when(tenantService.findTenantsIds(Mockito.<PageLink>any())).thenReturn(pageData);
    NotificationTargetService notificationTargetService = mock(NotificationTargetService.class);
    when(notificationTargetService.countNotificationTargetsByTenantId(Mockito.<TenantId>any())).thenReturn(1L);
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
            mock(NotificationSettingsService.class), notificationTargetService)).createDefaultNotificationConfigs());
    verify(pageData).getData();
    verify(notificationTargetService).countNotificationTargetsByTenantId(isA(TenantId.class));
    verify(tenantService).findTenantsIds(isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultSystemDataLoaderService#updateDefaultNotificationConfigs(boolean)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#updateDefaultNotificationConfigs(boolean)}
   */
  @Test
  @DisplayName("Test updateDefaultNotificationConfigs(boolean)")
  void testUpdateDefaultNotificationConfigs() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantService tenantService = mock(TenantService.class);
    PageData<TenantId> emptyPageDataResult = PageData.emptyPageData();
    when(tenantService.findTenantsIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    NotificationSettingsService notificationSettingsService = mock(NotificationSettingsService.class);
    doNothing().when(notificationSettingsService).updateDefaultNotificationConfigs(Mockito.<TenantId>any());
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
        mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class), notificationSettingsService,
        mock(NotificationTargetService.class))).updateDefaultNotificationConfigs(true);

    // Assert
    verify(notificationSettingsService).updateDefaultNotificationConfigs(isA(TenantId.class));
    verify(tenantService).findTenantsIds(isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultSystemDataLoaderService#updateDefaultNotificationConfigs(boolean)}.
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#updateDefaultNotificationConfigs(boolean)}
   */
  @Test
  @DisplayName("Test updateDefaultNotificationConfigs(boolean)")
  void testUpdateDefaultNotificationConfigs2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationSettingsService notificationSettingsService = mock(NotificationSettingsService.class);
    doThrow(new DataValidationException("An error occurred")).when(notificationSettingsService)
        .updateDefaultNotificationConfigs(Mockito.<TenantId>any());
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
            notificationSettingsService, mock(NotificationTargetService.class)))
            .updateDefaultNotificationConfigs(true));
    verify(notificationSettingsService).updateDefaultNotificationConfigs(isA(TenantId.class));
  }

  /**
   * Test
   * {@link DefaultSystemDataLoaderService#updateDefaultNotificationConfigs(boolean)}.
   * <ul>
   *   <li>Then calls {@link PageData#getData()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#updateDefaultNotificationConfigs(boolean)}
   */
  @Test
  @DisplayName("Test updateDefaultNotificationConfigs(boolean); then calls getData()")
  void testUpdateDefaultNotificationConfigs_thenCallsGetData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PageData<TenantId> pageData = mock(PageData.class);
    when(pageData.getData()).thenThrow(new DataValidationException("An error occurred"));
    TenantService tenantService = mock(TenantService.class);
    when(tenantService.findTenantsIds(Mockito.<PageLink>any())).thenReturn(pageData);
    NotificationSettingsService notificationSettingsService = mock(NotificationSettingsService.class);
    doNothing().when(notificationSettingsService).updateDefaultNotificationConfigs(Mockito.<TenantId>any());
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
            tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
            deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
            mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class),
            notificationSettingsService, mock(NotificationTargetService.class)))
            .updateDefaultNotificationConfigs(true));
    verify(pageData).getData();
    verify(notificationSettingsService).updateDefaultNotificationConfigs(isA(TenantId.class));
    verify(tenantService).findTenantsIds(isA(PageLink.class));
  }

  /**
   * Test
   * {@link DefaultSystemDataLoaderService#updateDefaultNotificationConfigs(boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#updateDefaultNotificationConfigs(boolean)}
   */
  @Test
  @DisplayName("Test updateDefaultNotificationConfigs(boolean); when 'false'")
  void testUpdateDefaultNotificationConfigs_whenFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NotificationSettingsService notificationSettingsService = mock(NotificationSettingsService.class);
    doNothing().when(notificationSettingsService).updateDefaultNotificationConfigs(Mockito.<TenantId>any());
    InstallScripts installScripts = mock(InstallScripts.class);
    UserService userService = mock(UserService.class);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    TenantService tenantService = mock(TenantService.class);
    TenantProfileService tenantProfileService = mock(TenantProfileService.class);
    CustomerService customerService = mock(CustomerService.class);
    DeviceService deviceService = mock(DeviceService.class);
    DeviceProfileService deviceProfileService = mock(DeviceProfileService.class);
    AttributesService attributesService = mock(AttributesService.class);
    DeviceCredentialsService deviceCredentialsService = mock(DeviceCredentialsService.class);
    RuleChainService ruleChainService = mock(RuleChainService.class);
    TimeseriesService tsService = mock(TimeseriesService.class);

    // Act
    (new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService, attributesService,
        deviceCredentialsService, ruleChainService, tsService, new DeviceConnectivityConfiguration(),
        mock(QueueService.class), mock(JwtSettingsService.class), mock(MobileAppDao.class), notificationSettingsService,
        mock(NotificationTargetService.class))).updateDefaultNotificationConfigs(false);

    // Assert
    verify(notificationSettingsService).updateDefaultNotificationConfigs(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultSystemDataLoaderService#isPersistActivityToTelemetry()}.
   * <p>
   * Method under test:
   * {@link DefaultSystemDataLoaderService#isPersistActivityToTelemetry()}
   */
  @Test
  @DisplayName("Test isPersistActivityToTelemetry()")
  void testIsPersistActivityToTelemetry() {
    // Arrange
    DeviceConnectivityConfiguration connectivityConfiguration = new DeviceConnectivityConfiguration();
    connectivityConfiguration.setConnectivity(new HashMap<>());
    InstallScripts installScripts = new InstallScripts();
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
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    CustomerServiceImpl customerService = new CustomerServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    JpaDeviceCredentialsDao deviceCredentialsDao = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService = new DeviceCredentialsServiceImpl(deviceCredentialsDao,
        new DeviceCredentialsDataValidator());

    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService2 = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DeviceServiceImpl deviceService = new DeviceServiceImpl(deviceDao, deviceCredentialsService, deviceProfileService,
        eventService, tenantService2, deviceValidator, countService2, new JpaExecutorService());

    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseAttributesService attributesService = new BaseAttributesService(new JpaAttributeDao());
    JpaDeviceCredentialsDao deviceCredentialsDao2 = new JpaDeviceCredentialsDao();
    DeviceCredentialsServiceImpl deviceCredentialsService2 = new DeviceCredentialsServiceImpl(deviceCredentialsDao2,
        new DeviceCredentialsDataValidator());

    BaseRuleChainService ruleChainService = new BaseRuleChainService();
    BaseTimeseriesService tsService = new BaseTimeseriesService();
    BaseQueueService queueService = new BaseQueueService();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    Optional<TbClusterService> tbClusterService = Optional
        .of(new DefaultTbClusterService(topicService, deviceProfileCache, assetProfileCache,
            gatewayNotificationsService, edgeService, new EdgeSessionCaffeineCache(new CaffeineCacheManager())));
    JwtSettingsValidator jwtSettingsValidator = mock(JwtSettingsValidator.class);
    Optional<JwtTokenFactory> jwtTokenFactory = Optional.of(new JwtTokenFactory(null));
    DefaultJwtSettingsService jwtSettingsService = new DefaultJwtSettingsService(adminSettingsService2,
        tbClusterService, jwtSettingsValidator, jwtTokenFactory);

    JpaMobileAppDao mobileAppDao = new JpaMobileAppDao(mock(MobileAppRepository.class),
        mock(MobileAppOauth2ClientRepository.class));

    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    JpaNotificationTargetDao notificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
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
    DefaultNotificationTargetService notificationTargetService = new DefaultNotificationTargetService(
        notificationTargetDao, notificationRequestDao, notificationRuleDao,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService3,
            new JpaExecutorService()));

    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService notificationTemplateService = new DefaultNotificationTemplateService(
        notificationTemplateDao, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    JpaNotificationTemplateDao notificationTemplateDao2 = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));
    DefaultNotificationTemplateService templateService = new DefaultNotificationTemplateService(
        notificationTemplateDao2, new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)));

    DefaultNotifications defaultNotifications = new DefaultNotifications(templateService,
        new DefaultNotificationRuleService(new JpaNotificationRuleDao(mock(NotificationRuleRepository.class))));

    DefaultNotificationSettingsService notificationSettingsService = new DefaultNotificationSettingsService(
        adminSettingsService3, notificationTargetService, notificationTemplateService, defaultNotifications,
        new UserSettingsServiceImpl(new JpaUserSettingsDao()));

    JpaNotificationTargetDao notificationTargetDao2 = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));
    JpaNotificationRequestDao notificationRequestDao2 = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));
    JpaNotificationRuleDao notificationRuleDao2 = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));
    JpaUserDao userDao3 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao3 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService3 = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao3 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService3 = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator3 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator3 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher3 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService4 = new BaseEntityCountService();

    // Act and Assert
    assertFalse((new DefaultSystemDataLoaderService(installScripts, userService, adminSettingsService, tenantService,
        tenantProfileService, customerService, deviceService, deviceProfileService2, attributesService,
        deviceCredentialsService2, ruleChainService, tsService, connectivityConfiguration, queueService,
        jwtSettingsService, mobileAppDao, notificationSettingsService,
        new DefaultNotificationTargetService(notificationTargetDao2, notificationRequestDao2, notificationRuleDao2,
            new UserServiceImpl(userDao3, userCredentialsDao3, userAuthSettingsDao3, userSettingsService3,
                userSettingsDao3, securitySettingsService3, userValidator3, userCredentialsValidator3, eventPublisher3,
                countService4, new JpaExecutorService()))))
        .isPersistActivityToTelemetry());
  }
}
