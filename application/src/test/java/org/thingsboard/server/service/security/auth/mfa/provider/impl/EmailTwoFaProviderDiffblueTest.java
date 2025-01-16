package org.thingsboard.server.service.security.auth.mfa.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import freemarker.template.Configuration;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.security.model.mfa.account.EmailTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.EmailTwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.TwoFaProviderType;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.security.model.SecurityUser;

class EmailTwoFaProviderDiffblueTest {
  /**
   * Test
   * {@link EmailTwoFaProvider#generateNewAccountConfig(User, EmailTwoFaProviderConfig)}
   * with {@code User}, {@code EmailTwoFaProviderConfig}.
   * <p>
   * Method under test:
   * {@link EmailTwoFaProvider#generateNewAccountConfig(User, EmailTwoFaProviderConfig)}
   */
  @Test
  @DisplayName("Test generateNewAccountConfig(User, EmailTwoFaProviderConfig) with 'User', 'EmailTwoFaProviderConfig'")
  void testGenerateNewAccountConfigWithUserEmailTwoFaProviderConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    EmailTwoFaProvider emailTwoFaProvider = new EmailTwoFaProvider(cacheManager,
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, new DefaultTbApiUsageReportClient(
            partitionService, serviceInfoProvider2, scheduler, new TbCoreQueueProducerProvider(null))));
    User user = new User();

    EmailTwoFaProviderConfig providerConfig = new EmailTwoFaProviderConfig();
    providerConfig.setVerificationCodeLifetime(1);

    // Act
    EmailTwoFaAccountConfig actualGenerateNewAccountConfigResult = emailTwoFaProvider.generateNewAccountConfig(user,
        providerConfig);

    // Assert
    assertNull(actualGenerateNewAccountConfigResult.getEmail());
    assertEquals(TwoFaProviderType.EMAIL, actualGenerateNewAccountConfigResult.getProviderType());
    assertFalse(actualGenerateNewAccountConfigResult.isSerializeHiddenFields());
    assertFalse(actualGenerateNewAccountConfigResult.isUseByDefault());
  }

  /**
   * Test {@link EmailTwoFaProvider#check(TenantId)}.
   * <ul>
   *   <li>Then calls {@link DefaultMailService#testConnection(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTwoFaProvider#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId); then calls testConnection(TenantId)")
  void testCheck_thenCallsTestConnection() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultMailService mailService = mock(DefaultMailService.class);
    doNothing().when(mailService).testConnection(Mockito.<TenantId>any());
    EmailTwoFaProvider emailTwoFaProvider = new EmailTwoFaProvider(new CaffeineCacheManager(), mailService);

    // Act
    emailTwoFaProvider.check(new TenantId(UUID.randomUUID()));

    // Assert that nothing has changed
    verify(mailService).testConnection(isA(TenantId.class));
  }

  /**
   * Test {@link EmailTwoFaProvider#check(TenantId)}.
   * <ul>
   *   <li>Then throw {@link ThingsboardException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EmailTwoFaProvider#check(TenantId)}
   */
  @Test
  @DisplayName("Test check(TenantId); then throw ThingsboardException")
  void testCheck_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    EmailTwoFaProvider emailTwoFaProvider = new EmailTwoFaProvider(cacheManager,
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, new DefaultTbApiUsageReportClient(
            partitionService, serviceInfoProvider2, scheduler, new TbCoreQueueProducerProvider(null))));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> emailTwoFaProvider.check(new TenantId(UUID.randomUUID())));
  }

  /**
   * Test
   * {@link EmailTwoFaProvider#sendVerificationCode(SecurityUser, String, EmailTwoFaProviderConfig, EmailTwoFaAccountConfig)}
   * with {@code SecurityUser}, {@code String}, {@code EmailTwoFaProviderConfig},
   * {@code EmailTwoFaAccountConfig}.
   * <p>
   * Method under test:
   * {@link EmailTwoFaProvider#sendVerificationCode(SecurityUser, String, EmailTwoFaProviderConfig, EmailTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test sendVerificationCode(SecurityUser, String, EmailTwoFaProviderConfig, EmailTwoFaAccountConfig) with 'SecurityUser', 'String', 'EmailTwoFaProviderConfig', 'EmailTwoFaAccountConfig'")
  void testSendVerificationCodeWithSecurityUserStringEmailTwoFaProviderConfigEmailTwoFaAccountConfig()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    EmailTwoFaProvider emailTwoFaProvider = new EmailTwoFaProvider(cacheManager,
        new DefaultMailService(messages, freemarkerConfig, adminSettingsService, new DefaultTbApiUsageReportClient(
            partitionService, serviceInfoProvider2, scheduler, new TbCoreQueueProducerProvider(null))));
    SecurityUser user = new SecurityUser();

    EmailTwoFaProviderConfig providerConfig = new EmailTwoFaProviderConfig();
    providerConfig.setVerificationCodeLifetime(1);

    EmailTwoFaAccountConfig accountConfig = new EmailTwoFaAccountConfig();
    accountConfig.setEmail("jane.doe@example.org");
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> emailTwoFaProvider.sendVerificationCode(user, "Verification Code", providerConfig, accountConfig));
  }

  /**
   * Test
   * {@link EmailTwoFaProvider#sendVerificationCode(SecurityUser, String, EmailTwoFaProviderConfig, EmailTwoFaAccountConfig)}
   * with {@code SecurityUser}, {@code String}, {@code EmailTwoFaProviderConfig},
   * {@code EmailTwoFaAccountConfig}.
   * <p>
   * Method under test:
   * {@link EmailTwoFaProvider#sendVerificationCode(SecurityUser, String, EmailTwoFaProviderConfig, EmailTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test sendVerificationCode(SecurityUser, String, EmailTwoFaProviderConfig, EmailTwoFaAccountConfig) with 'SecurityUser', 'String', 'EmailTwoFaProviderConfig', 'EmailTwoFaAccountConfig'")
  void testSendVerificationCodeWithSecurityUserStringEmailTwoFaProviderConfigEmailTwoFaAccountConfig2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultMailService mailService = mock(DefaultMailService.class);
    doNothing().when(mailService).sendTwoFaVerificationEmail(Mockito.<String>any(), Mockito.<String>any(), anyInt());
    EmailTwoFaProvider emailTwoFaProvider = new EmailTwoFaProvider(new CaffeineCacheManager(), mailService);
    SecurityUser user = new SecurityUser();

    EmailTwoFaProviderConfig providerConfig = new EmailTwoFaProviderConfig();
    providerConfig.setVerificationCodeLifetime(1);

    EmailTwoFaAccountConfig accountConfig = new EmailTwoFaAccountConfig();
    accountConfig.setEmail("jane.doe@example.org");
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);

    // Act
    emailTwoFaProvider.sendVerificationCode(user, "Verification Code", providerConfig, accountConfig);

    // Assert that nothing has changed
    verify(mailService).sendTwoFaVerificationEmail(eq("jane.doe@example.org"), eq("Verification Code"), eq(1));
  }

  /**
   * Test {@link EmailTwoFaProvider#getType()}.
   * <p>
   * Method under test: {@link EmailTwoFaProvider#getType()}
   */
  @Test
  @DisplayName("Test getType()")
  void testGetType() {
    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertEquals(TwoFaProviderType.EMAIL,
        (new EmailTwoFaProvider(cacheManager,
            new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
                new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                    new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                        ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                        transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))))))
            .getType());
  }
}
