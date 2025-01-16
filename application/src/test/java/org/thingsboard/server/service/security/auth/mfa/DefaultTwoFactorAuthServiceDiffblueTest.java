package org.thingsboard.server.service.security.auth.mfa;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import freemarker.template.Configuration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.RateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.common.data.security.model.mfa.PlatformTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.AccountTwoFaSettings;
import org.thingsboard.server.common.data.security.model.mfa.account.BackupCodeTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.TwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.dao.audit.AuditLogServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.service.validator.UserCredentialsDataValidator;
import org.thingsboard.server.dao.service.validator.UserDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.dao.settings.DefaultSecuritySettingsService;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.settings.JpaAdminSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserAuthSettingsDao;
import org.thingsboard.server.dao.sql.user.JpaUserCredentialsDao;
import org.thingsboard.server.dao.sql.user.JpaUserDao;
import org.thingsboard.server.dao.sql.user.JpaUserSettingsDao;
import org.thingsboard.server.dao.sql.user.UserAuthSettingsRepository;
import org.thingsboard.server.dao.user.UserCredentialsDao;
import org.thingsboard.server.dao.user.UserService;
import org.thingsboard.server.dao.user.UserServiceImpl;
import org.thingsboard.server.dao.user.UserSettingsServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.security.auth.mfa.config.DefaultTwoFaConfigManager;
import org.thingsboard.server.service.security.auth.mfa.config.TwoFaConfigManager;
import org.thingsboard.server.service.security.model.SecurityUser;
import org.thingsboard.server.service.security.system.DefaultSystemSecurityService;

class DefaultTwoFactorAuthServiceDiffblueTest {
  /**
   * Test {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test isTwoFaEnabled(TenantId, UserId)")
  void testIsTwoFaEnabled() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTwoFaConfigManager configManager = mock(DefaultTwoFaConfigManager.class);
    Optional<AccountTwoFaSettings> emptyResult = Optional.empty();
    when(configManager.getAccountTwoFaSettings(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(emptyResult);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act
    boolean actualIsTwoFaEnabledResult = defaultTwoFactorAuthService.isTwoFaEnabled(new TenantId(UUID.randomUUID()),
        null);

    // Assert
    verify(configManager).getAccountTwoFaSettings(isA(TenantId.class), isNull());
    assertFalse(actualIsTwoFaEnabledResult);
  }

  /**
   * Test {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test isTwoFaEnabled(TenantId, UserId); then return 'false'")
  void testIsTwoFaEnabled_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(new LinkedHashMap<>());
    Optional<AccountTwoFaSettings> ofResult = Optional.of(accountTwoFaSettings);
    DefaultTwoFaConfigManager configManager = mock(DefaultTwoFaConfigManager.class);
    when(configManager.getAccountTwoFaSettings(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(ofResult);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act
    boolean actualIsTwoFaEnabledResult = defaultTwoFactorAuthService.isTwoFaEnabled(new TenantId(UUID.randomUUID()),
        null);

    // Assert
    verify(configManager).getAccountTwoFaSettings(isA(TenantId.class), isNull());
    assertFalse(actualIsTwoFaEnabledResult);
  }

  /**
   * Test {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#isTwoFaEnabled(TenantId, UserId)}
   */
  @Test
  @DisplayName("Test isTwoFaEnabled(TenantId, UserId); then return 'true'")
  void testIsTwoFaEnabled_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    LinkedHashMap<TwoFaProviderType, TwoFaAccountConfig> configs = new LinkedHashMap<>();
    configs.put(TwoFaProviderType.TOTP, new BackupCodeTwoFaAccountConfig());

    AccountTwoFaSettings accountTwoFaSettings = new AccountTwoFaSettings();
    accountTwoFaSettings.setConfigs(configs);
    Optional<AccountTwoFaSettings> ofResult = Optional.of(accountTwoFaSettings);
    DefaultTwoFaConfigManager configManager = mock(DefaultTwoFaConfigManager.class);
    when(configManager.getAccountTwoFaSettings(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(ofResult);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act
    boolean actualIsTwoFaEnabledResult = defaultTwoFactorAuthService.isTwoFaEnabled(new TenantId(UUID.randomUUID()),
        null);

    // Assert
    verify(configManager).getAccountTwoFaSettings(isA(TenantId.class), isNull());
    assertTrue(actualIsTwoFaEnabledResult);
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkProvider(TenantId, TwoFaProviderType)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkProvider(TenantId, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test checkProvider(TenantId, TwoFaProviderType)")
  void testCheckProvider() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTwoFaConfigManager configManager = new DefaultTwoFaConfigManager(userAuthSettingsDao, adminSettingsService,
        new JpaAdminSettingsDao());

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao2,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService3,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService2,
        encoder, userService, mailService, auditLogService,
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService2 = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService2 = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao3,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.checkProvider(new TenantId(UUID.randomUUID()), TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code accountConfig}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean) with 'user', 'accountConfig', 'checkLimits'")
  void testPrepareVerificationCodeWithUserAccountConfigCheckLimits() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    DefaultTwoFaConfigManager configManager = new DefaultTwoFaConfigManager(userAuthSettingsDao, adminSettingsService,
        new JpaAdminSettingsDao());

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao2,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService3,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService2,
        encoder, userService, mailService, auditLogService,
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService2 = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService2 = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao3,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(user, new BackupCodeTwoFaAccountConfig(), true));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code accountConfig}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean) with 'user', 'accountConfig', 'checkLimits'")
  void testPrepareVerificationCodeWithUserAccountConfigCheckLimits2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(user, new BackupCodeTwoFaAccountConfig(), true));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code accountConfig}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean) with 'user', 'accountConfig', 'checkLimits'")
  void testPrepareVerificationCodeWithUserAccountConfigCheckLimits3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(3);
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(user, new BackupCodeTwoFaAccountConfig(), true));
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code accountConfig}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean) with 'user', 'accountConfig', 'checkLimits'")
  void testPrepareVerificationCodeWithUserAccountConfigCheckLimits4() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(59);
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(user, new BackupCodeTwoFaAccountConfig(), true));
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code accountConfig}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean) with 'user', 'accountConfig', 'checkLimits'")
  void testPrepareVerificationCodeWithUserAccountConfigCheckLimits5() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(null);
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(user, new BackupCodeTwoFaAccountConfig(), true));
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code accountConfig}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean) with 'user', 'accountConfig', 'checkLimits'")
  void testPrepareVerificationCodeWithUserAccountConfigCheckLimits6() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(3);
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService2,
            new JpaExecutorService()),
        rateLimitService);
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(user, new BackupCodeTwoFaAccountConfig(), true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_SEND), isA(Object.class),
        (String) isNull());
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code accountConfig}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean) with 'user', 'accountConfig', 'checkLimits'")
  void testPrepareVerificationCodeWithUserAccountConfigCheckLimits7() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(3);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult);
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(false);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService2,
            new JpaExecutorService()),
        rateLimitService);
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(user, new BackupCodeTwoFaAccountConfig(), true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_SEND), isA(Object.class),
        (String) isNull());
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code accountConfig}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaAccountConfig, boolean) with 'user', 'accountConfig', 'checkLimits'")
  void testPrepareVerificationCodeWithUserAccountConfigCheckLimits8() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService2,
            new JpaExecutorService()),
        mock(RateLimitService.class));
    SecurityUser user = new SecurityUser();
    TwoFaAccountConfig accountConfig = mock(TwoFaAccountConfig.class);
    when(accountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(user, accountConfig, false));
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(accountConfig, atLeast(1)).getProviderType();
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult);
    Optional<TwoFaAccountConfig> ofResult2 = Optional.of(new BackupCodeTwoFaAccountConfig());
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult2);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, true));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean()))
        .thenThrow(new LockedException("Msg"));
    Optional<TwoFaAccountConfig> ofResult = Optional.of(new BackupCodeTwoFaAccountConfig());
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(LockedException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, true));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits3() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(3);
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    Optional<TwoFaAccountConfig> ofResult3 = Optional.of(new BackupCodeTwoFaAccountConfig());
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult3);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, true));
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits4() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(59);
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    Optional<TwoFaAccountConfig> ofResult3 = Optional.of(new BackupCodeTwoFaAccountConfig());
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult3);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, true));
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits5() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(null);
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    Optional<TwoFaAccountConfig> ofResult3 = Optional.of(new BackupCodeTwoFaAccountConfig());
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult3);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, true));
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits6() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    Optional<PlatformTwoFaSettings> emptyResult = Optional.empty();
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(emptyResult);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(new BackupCodeTwoFaAccountConfig());
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, true));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits7() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    Optional<TwoFaAccountConfig> emptyResult = Optional.empty();
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(emptyResult);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, true));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits8() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(3);
    Optional<TwoFaProviderConfig> ofResult2 = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult2);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult3 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult3);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService2,
            new JpaExecutorService()),
        rateLimitService);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_SEND), isA(Object.class),
        (String) isNull());
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig, atLeast(1)).getProviderType();
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits9() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(null);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(3);
    Optional<TwoFaProviderConfig> ofResult2 = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult2);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult3 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult3);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService2,
            new JpaExecutorService()),
        rateLimitService);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_SEND), isA(Object.class),
        (String) isNull());
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).getProviderConfig(isNull());
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig, atLeast(1)).getProviderType();
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits10() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMinVerificationCodeSendPeriod()).thenReturn(3);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(false);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService2,
            new JpaExecutorService()),
        rateLimitService);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_SEND), isA(Object.class),
        (String) isNull());
    verify(platformTwoFaSettings).getMinVerificationCodeSendPeriod();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig).getProviderType();
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   * with {@code user}, {@code providerType}, {@code checkLimits}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean)}
   */
  @Test
  @DisplayName("Test prepareVerificationCode(SecurityUser, TwoFaProviderType, boolean) with 'user', 'providerType', 'checkLimits'; when 'false'")
  void testPrepareVerificationCodeWithUserProviderTypeCheckLimits_whenFalse() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    Optional<TwoFaProviderConfig> ofResult2 = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult2);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult3 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult3);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService,
        new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2, userSettingsService2, userSettingsDao2,
            securitySettingsService2, userValidator2, userCredentialsValidator2, eventPublisher2, countService2,
            new JpaExecutorService()),
        mock(DefaultRateLimitService.class));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.prepareVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, false));
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig, atLeast(1)).getProviderType();
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    Optional<TwoFaAccountConfig> emptyResult = Optional.empty();
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(emptyResult);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(new BackupCodeTwoFaAccountConfig());
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(new UserCredentials());
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService2, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", true));
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean()))
        .thenThrow(new LockedException("Msg"));
    Optional<TwoFaAccountConfig> ofResult = Optional.of(new BackupCodeTwoFaAccountConfig());
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService2, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", true));
    verify(userCredentials).isEnabled();
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits4() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("");
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    Optional<TwoFaAccountConfig> ofResult3 = Optional.of(new BackupCodeTwoFaAccountConfig());
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult3);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService2, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", true));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits5() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    Optional<PlatformTwoFaSettings> emptyResult = Optional.empty();
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(emptyResult);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(new BackupCodeTwoFaAccountConfig());
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService2, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", true));
    verify(userCredentials).isEnabled();
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits6() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> emptyResult = Optional.empty();
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(emptyResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(
        configManager, new DefaultSystemSecurityService(adminSettingsService, encoder, userService2, mailService,
            auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl())),
        userService, rateLimitService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig, atLeast(1)).getProviderType();
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits7() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMaxVerificationFailuresBeforeUserLockout()).thenReturn(3);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> ofResult2 = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult2);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult3 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult3);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserCredentialsDao userCredentialsDao = mock(UserCredentialsDao.class);
    when(userCredentialsDao.incrementFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(1);
    JpaUserDao userDao = new JpaUserDao();
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
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService2 = mock(UserService.class);
    when(userService2.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2, rateLimitService);

    // Act
    boolean actualCheckVerificationCodeResult = defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", true);

    // Assert
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getMaxVerificationFailuresBeforeUserLockout();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig, atLeast(1)).getProviderType();
    verify(userCredentialsDao).incrementFailedLoginAttempts(isNull(), isNull());
    verify(userService2).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
    assertFalse(actualCheckVerificationCodeResult);
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits8() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> ofResult2 = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult2);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult3 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult3);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserCredentialsDao userCredentialsDao = mock(UserCredentialsDao.class);
    when(userCredentialsDao.incrementFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new LockedException("Executing increaseFailedLoginAttempts [{}]"));
    JpaUserDao userDao = new JpaUserDao();
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
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService2 = mock(UserService.class);
    when(userService2.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    doNothing().when(rateLimitService).cleanUp(Mockito.<LimitedApi>any(), Mockito.<Object>any());
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2, rateLimitService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(rateLimitService, atLeast(1)).cleanUp(Mockito.<LimitedApi>any(), Mockito.<Object>any());
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig, atLeast(1)).getProviderType();
    verify(userCredentialsDao).incrementFailedLoginAttempts(isNull(), isNull());
    verify(userService2).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits9() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> ofResult2 = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult2);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult3 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult3);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserCredentialsDao userCredentialsDao = mock(UserCredentialsDao.class);
    when(userCredentialsDao.incrementFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new LockedException("Executing increaseFailedLoginAttempts [{}]"));
    JpaUserDao userDao = new JpaUserDao();
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
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService2 = mock(UserService.class);
    when(userService2.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    doThrow(new LockedException("Executing increaseFailedLoginAttempts [{}]")).when(rateLimitService)
        .cleanUp(Mockito.<LimitedApi>any(), Mockito.<Object>any());
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2, rateLimitService);

    // Act and Assert
    assertThrows(LockedException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(rateLimitService).cleanUp(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_SEND), isA(Object.class));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig, atLeast(1)).getProviderType();
    verify(userCredentialsDao).incrementFailedLoginAttempts(isNull(), isNull());
    verify(userService2).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits10() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(false);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    UserCredentialsDao userCredentialsDao = mock(UserCredentialsDao.class);
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(
        configManager, new DefaultSystemSecurityService(adminSettingsService, encoder, userService2, mailService,
            auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl())),
        userService, rateLimitService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig).getProviderType();
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits11() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> ofResult2 = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult2);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult3 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult3);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserCredentialsDao userCredentialsDao = mock(UserCredentialsDao.class);
    when(userCredentialsDao.incrementFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new LockedException("Executing increaseFailedLoginAttempts [{}]"));
    JpaUserDao userDao = new JpaUserDao();
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
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService2 = mock(UserService.class);
    when(userService2.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    doNothing().when(rateLimitService).cleanUp(Mockito.<LimitedApi>any(), Mockito.<Object>any());
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2, rateLimitService);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(), TwoFaProviderType.TOTP, "", true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(rateLimitService, atLeast(1)).cleanUp(Mockito.<LimitedApi>any(), Mockito.<Object>any());
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig, atLeast(1)).getProviderType();
    verify(userCredentialsDao).incrementFailedLoginAttempts(isNull(), isNull());
    verify(userService2).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits12() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    Optional<TwoFaProviderConfig> ofResult2 = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult2);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult3 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult3);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    UserCredentialsDao userCredentialsDao = mock(UserCredentialsDao.class);
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        new DefaultSystemSecurityService(adminSettingsService, encoder, userService2, mailService, auditLogService,
            new DefaultSecuritySettingsService(new AdminSettingsServiceImpl())),
        userService, mock(DefaultRateLimitService.class));

    // Act
    boolean actualCheckVerificationCodeResult = defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "Verification Code", false);

    // Assert
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig, atLeast(1)).getProviderType();
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
    assertFalse(actualCheckVerificationCodeResult);
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   * with {@code user}, {@code providerType}, {@code verificationCode},
   * {@code checkLimits}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, TwoFaProviderType, String, boolean) with 'user', 'providerType', 'verificationCode', 'checkLimits'; when '42'")
  void testCheckVerificationCodeWithUserProviderTypeVerificationCodeCheckLimits_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    BackupCodeTwoFaAccountConfig backupCodeTwoFaAccountConfig = mock(BackupCodeTwoFaAccountConfig.class);
    when(backupCodeTwoFaAccountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);
    Optional<TwoFaAccountConfig> ofResult = Optional.of(backupCodeTwoFaAccountConfig);
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> ofResult2 = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult2);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult3 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult3);
    when(configManager.getTwoFaAccountConfig(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    DefaultRateLimitService rateLimitService = mock(DefaultRateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    UserCredentialsDao userCredentialsDao = mock(UserCredentialsDao.class);
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(
        configManager, new DefaultSystemSecurityService(adminSettingsService, encoder, userService2, mailService,
            auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl())),
        userService, rateLimitService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(new SecurityUser(),
        TwoFaProviderType.TOTP, "42", true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(backupCodeTwoFaAccountConfig, atLeast(1)).getProviderType();
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    verify(configManager).getTwoFaAccountConfig(isNull(), isNull(), eq(TwoFaProviderType.TOTP));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code verificationCode}, {@code accountConfig},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean) with 'user', 'verificationCode', 'accountConfig', 'checkLimits'")
  void testCheckVerificationCodeWithUserVerificationCodeAccountConfigCheckLimits() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(new UserCredentials());
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTwoFaConfigManager configManager = new DefaultTwoFaConfigManager(userAuthSettingsDao, adminSettingsService,
        new JpaAdminSettingsDao());

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao2,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService3,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService2,
        encoder, userService2, mailService, auditLogService,
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(user,
        "Verification Code", new BackupCodeTwoFaAccountConfig(), true));
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code verificationCode}, {@code accountConfig},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean) with 'user', 'verificationCode', 'accountConfig', 'checkLimits'")
  void testCheckVerificationCodeWithUserVerificationCodeAccountConfigCheckLimits2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    DefaultTwoFaConfigManager configManager = new DefaultTwoFaConfigManager(userAuthSettingsDao, adminSettingsService,
        new JpaAdminSettingsDao());

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao2,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService3,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService2,
        encoder, userService2, mailService, auditLogService,
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(user,
        "Verification Code", new BackupCodeTwoFaAccountConfig(), true));
    verify(userCredentials).isEnabled();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code verificationCode}, {@code accountConfig},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean) with 'user', 'verificationCode', 'accountConfig', 'checkLimits'")
  void testCheckVerificationCodeWithUserVerificationCodeAccountConfigCheckLimits3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("");
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService2, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(user,
        "Verification Code", new BackupCodeTwoFaAccountConfig(), true));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code verificationCode}, {@code accountConfig},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean) with 'user', 'verificationCode', 'accountConfig', 'checkLimits'")
  void testCheckVerificationCodeWithUserVerificationCodeAccountConfigCheckLimits4() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(
        configManager, new DefaultSystemSecurityService(adminSettingsService, encoder, userService2, mailService,
            auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl())),
        userService, rateLimitService);
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(user,
        "Verification Code", new BackupCodeTwoFaAccountConfig(), true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code verificationCode}, {@code accountConfig},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean) with 'user', 'verificationCode', 'accountConfig', 'checkLimits'")
  void testCheckVerificationCodeWithUserVerificationCodeAccountConfigCheckLimits5() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> emptyResult = Optional.empty();
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(emptyResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(
        configManager, new DefaultSystemSecurityService(adminSettingsService, encoder, userService2, mailService,
            auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl())),
        userService, rateLimitService);
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(user,
        "Verification Code", new BackupCodeTwoFaAccountConfig(), true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code verificationCode}, {@code accountConfig},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean) with 'user', 'verificationCode', 'accountConfig', 'checkLimits'")
  void testCheckVerificationCodeWithUserVerificationCodeAccountConfigCheckLimits6() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(false);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(
        configManager, new DefaultSystemSecurityService(adminSettingsService, encoder, userService2, mailService,
            auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl())),
        userService, rateLimitService);
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultTwoFactorAuthService.checkVerificationCode(user,
        "Verification Code", new BackupCodeTwoFaAccountConfig(), true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code verificationCode}, {@code accountConfig},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean) with 'user', 'verificationCode', 'accountConfig', 'checkLimits'")
  void testCheckVerificationCodeWithUserVerificationCodeAccountConfigCheckLimits7() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getMaxVerificationFailuresBeforeUserLockout()).thenReturn(3);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    JpaUserCredentialsDao userCredentialsDao = mock(JpaUserCredentialsDao.class);
    when(userCredentialsDao.incrementFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any())).thenReturn(1);
    JpaUserDao userDao = new JpaUserDao();
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
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService2 = mock(UserService.class);
    when(userService2.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2, rateLimitService);
    SecurityUser user = new SecurityUser();
    TwoFaAccountConfig accountConfig = mock(TwoFaAccountConfig.class);
    when(accountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);

    // Act
    boolean actualCheckVerificationCodeResult = defaultTwoFactorAuthService.checkVerificationCode(user,
        "Verification Code", accountConfig, true);

    // Assert
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getMaxVerificationFailuresBeforeUserLockout();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(accountConfig, atLeast(1)).getProviderType();
    verify(userCredentialsDao).incrementFailedLoginAttempts(isNull(), isNull());
    verify(userService2).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
    assertFalse(actualCheckVerificationCodeResult);
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code verificationCode}, {@code accountConfig},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean) with 'user', 'verificationCode', 'accountConfig', 'checkLimits'")
  void testCheckVerificationCodeWithUserVerificationCodeAccountConfigCheckLimits8() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    JpaUserCredentialsDao userCredentialsDao = mock(JpaUserCredentialsDao.class);
    when(userCredentialsDao.incrementFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new LockedException("Executing increaseFailedLoginAttempts [{}]"));
    JpaUserDao userDao = new JpaUserDao();
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
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService2 = mock(UserService.class);
    when(userService2.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    RateLimitService rateLimitService = mock(RateLimitService.class);
    doNothing().when(rateLimitService).cleanUp(Mockito.<LimitedApi>any(), Mockito.<Object>any());
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2, rateLimitService);
    SecurityUser user = new SecurityUser();
    TwoFaAccountConfig accountConfig = mock(TwoFaAccountConfig.class);
    when(accountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.checkVerificationCode(user, "Verification Code", accountConfig, true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(rateLimitService, atLeast(1)).cleanUp(Mockito.<LimitedApi>any(), Mockito.<Object>any());
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(accountConfig, atLeast(1)).getProviderType();
    verify(userCredentialsDao).incrementFailedLoginAttempts(isNull(), isNull());
    verify(userService2).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code verificationCode}, {@code accountConfig},
   * {@code checkLimits}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean) with 'user', 'verificationCode', 'accountConfig', 'checkLimits'")
  void testCheckVerificationCodeWithUserVerificationCodeAccountConfigCheckLimits9() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    JpaUserCredentialsDao userCredentialsDao = mock(JpaUserCredentialsDao.class);
    when(userCredentialsDao.incrementFailedLoginAttempts(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenThrow(new LockedException("Executing increaseFailedLoginAttempts [{}]"));
    JpaUserDao userDao = new JpaUserDao();
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
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService2 = mock(UserService.class);
    when(userService2.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    RateLimitService rateLimitService = mock(RateLimitService.class);
    doThrow(new LockedException("Executing increaseFailedLoginAttempts [{}]")).when(rateLimitService)
        .cleanUp(Mockito.<LimitedApi>any(), Mockito.<Object>any());
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2, rateLimitService);
    SecurityUser user = new SecurityUser();
    TwoFaAccountConfig accountConfig = mock(TwoFaAccountConfig.class);
    when(accountConfig.getProviderType()).thenReturn(TwoFaProviderType.TOTP);

    // Act and Assert
    assertThrows(LockedException.class,
        () -> defaultTwoFactorAuthService.checkVerificationCode(user, "Verification Code", accountConfig, true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(rateLimitService).cleanUp(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_SEND), isA(Object.class));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(accountConfig, atLeast(1)).getProviderType();
    verify(userCredentialsDao).incrementFailedLoginAttempts(isNull(), isNull());
    verify(userService2).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   * with {@code user}, {@code verificationCode}, {@code accountConfig},
   * {@code checkLimits}.
   * <ul>
   *   <li>When {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, TwoFaAccountConfig, boolean) with 'user', 'verificationCode', 'accountConfig', 'checkLimits'; when '42'")
  void testCheckVerificationCodeWithUserVerificationCodeAccountConfigCheckLimits_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    when(platformTwoFaSettings.getVerificationCodeCheckRateLimit()).thenReturn("Verification Code Check Rate Limit");
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    UserCredentials userCredentials = mock(UserCredentials.class);
    when(userCredentials.isEnabled()).thenReturn(true);
    UserService userService = mock(UserService.class);
    when(userService.findUserCredentialsByUserId(Mockito.<TenantId>any(), Mockito.<UserId>any()))
        .thenReturn(userCredentials);
    RateLimitService rateLimitService = mock(RateLimitService.class);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<Object>any(), Mockito.<String>any()))
        .thenReturn(true);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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
    UserServiceImpl userService2 = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(
        configManager, new DefaultSystemSecurityService(adminSettingsService, encoder, userService2, mailService,
            auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl())),
        userService, rateLimitService);
    SecurityUser user = new SecurityUser();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.checkVerificationCode(user, "42", new BackupCodeTwoFaAccountConfig(), true));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.TWO_FA_VERIFICATION_CODE_CHECK), isA(Object.class),
        eq("Verification Code Check Rate Limit"));
    verify(userCredentials).isEnabled();
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.BACKUP_CODE));
    verify(platformTwoFaSettings).getVerificationCodeCheckRateLimit();
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(userService).findUserCredentialsByUserId(isNull(), isNull());
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}.
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, TwoFaProviderType)")
  void testGenerateNewAccountConfig() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = new PlatformTwoFaSettings();
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.generateNewAccountConfig(new User(), TwoFaProviderType.TOTP));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}.
   * <ul>
   *   <li>Then calls
   * {@link AdminSettingsServiceImpl#findAdminSettingsByKey(TenantId, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, TwoFaProviderType); then calls findAdminSettingsByKey(TenantId, String)")
  void testGenerateNewAccountConfig_thenCallsFindAdminSettingsByKey() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    JpaUserAuthSettingsDao userAuthSettingsDao = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    DefaultTwoFaConfigManager configManager = new DefaultTwoFaConfigManager(userAuthSettingsDao, adminSettingsService,
        new JpaAdminSettingsDao());

    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    JpaUserDao userDao = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao2 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService = new BaseEntityCountService();
    UserServiceImpl userService = new UserServiceImpl(userDao, userCredentialsDao, userAuthSettingsDao2,
        userSettingsService, userSettingsDao, securitySettingsService, userValidator, userCredentialsValidator,
        eventPublisher, countService, new JpaExecutorService());

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService3 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService3,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService2,
        encoder, userService, mailService, auditLogService,
        new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

    JpaUserDao userDao2 = new JpaUserDao();
    JpaUserCredentialsDao userCredentialsDao2 = new JpaUserCredentialsDao();
    JpaUserAuthSettingsDao userAuthSettingsDao3 = new JpaUserAuthSettingsDao(mock(UserAuthSettingsRepository.class));
    UserSettingsServiceImpl userSettingsService2 = new UserSettingsServiceImpl(new JpaUserSettingsDao());
    JpaUserSettingsDao userSettingsDao2 = new JpaUserSettingsDao();
    DefaultSecuritySettingsService securitySettingsService2 = new DefaultSecuritySettingsService(
        new AdminSettingsServiceImpl());
    UserDataValidator userValidator2 = new UserDataValidator();
    UserCredentialsDataValidator userCredentialsValidator2 = new UserCredentialsDataValidator();
    ApplicationEventPublisher eventPublisher2 = mock(ApplicationEventPublisher.class);
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao3,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.generateNewAccountConfig(new User(), TwoFaProviderType.TOTP));
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("twoFaSettings"));
  }

  /**
   * Test
   * {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}.
   * <ul>
   *   <li>Then calls
   * {@link PlatformTwoFaSettings#getProviderConfig(TwoFaProviderType)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTwoFactorAuthService#generateNewAccountConfig(User, TwoFaProviderType)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, TwoFaProviderType); then calls getProviderConfig(TwoFaProviderType)")
  void testGenerateNewAccountConfig_thenCallsGetProviderConfig() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PlatformTwoFaSettings platformTwoFaSettings = mock(PlatformTwoFaSettings.class);
    Optional<TwoFaProviderConfig> ofResult = Optional.of(mock(TwoFaProviderConfig.class));
    when(platformTwoFaSettings.getProviderConfig(Mockito.<TwoFaProviderType>any())).thenReturn(ofResult);
    doNothing().when(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setMinVerificationCodeSendPeriod(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setProviders(Mockito.<List<TwoFaProviderConfig>>any());
    doNothing().when(platformTwoFaSettings).setTotalAllowedTimeForVerification(Mockito.<Integer>any());
    doNothing().when(platformTwoFaSettings).setVerificationCodeCheckRateLimit(Mockito.<String>any());
    platformTwoFaSettings.setMaxVerificationFailuresBeforeUserLockout(3);
    platformTwoFaSettings.setMinVerificationCodeSendPeriod(3);
    platformTwoFaSettings.setProviders(new ArrayList<>());
    platformTwoFaSettings.setTotalAllowedTimeForVerification(1);
    platformTwoFaSettings.setVerificationCodeCheckRateLimit("Verification Code Check Rate Limit");
    Optional<PlatformTwoFaSettings> ofResult2 = Optional.of(platformTwoFaSettings);
    TwoFaConfigManager configManager = mock(TwoFaConfigManager.class);
    when(configManager.getPlatformTwoFaSettings(Mockito.<TenantId>any(), anyBoolean())).thenReturn(ofResult2);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
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

    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService2 = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    DefaultMailService mailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService2,
        new DefaultTbApiUsageReportClient(null, serviceInfoProvider, new DefaultSchedulerComponent(), null));

    AuditLogServiceImpl auditLogService = new AuditLogServiceImpl();
    DefaultSystemSecurityService systemSecurityService = new DefaultSystemSecurityService(adminSettingsService, encoder,
        userService, mailService, auditLogService, new DefaultSecuritySettingsService(new AdminSettingsServiceImpl()));

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
    BaseEntityCountService countService2 = new BaseEntityCountService();
    UserServiceImpl userService2 = new UserServiceImpl(userDao2, userCredentialsDao2, userAuthSettingsDao2,
        userSettingsService2, userSettingsDao2, securitySettingsService2, userValidator2, userCredentialsValidator2,
        eventPublisher2, countService2, new JpaExecutorService());

    DefaultTwoFactorAuthService defaultTwoFactorAuthService = new DefaultTwoFactorAuthService(configManager,
        systemSecurityService, userService2,
        new DefaultRateLimitService(mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultTwoFactorAuthService.generateNewAccountConfig(new User(), TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).getProviderConfig(eq(TwoFaProviderType.TOTP));
    verify(platformTwoFaSettings).setMaxVerificationFailuresBeforeUserLockout(eq(3));
    verify(platformTwoFaSettings).setMinVerificationCodeSendPeriod(eq(3));
    verify(platformTwoFaSettings).setProviders(isA(List.class));
    verify(platformTwoFaSettings).setTotalAllowedTimeForVerification(eq(1));
    verify(platformTwoFaSettings).setVerificationCodeCheckRateLimit(eq("Verification Code Check Rate Limit"));
    verify(configManager).getPlatformTwoFaSettings(isNull(), eq(true));
  }
}
