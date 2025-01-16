package org.thingsboard.server.service.security.auth.mfa.provider.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import freemarker.template.Configuration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.security.model.mfa.account.EmailTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.OtpBasedTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.account.SmsTwoFaAccountConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.EmailTwoFaProviderConfig;
import org.thingsboard.server.common.data.security.model.mfa.provider.OtpBasedTwoFaProviderConfig;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;
import org.thingsboard.server.service.mail.DefaultMailService;
import org.thingsboard.server.service.security.auth.mfa.provider.impl.OtpBasedTwoFaProvider.Otp;
import org.thingsboard.server.service.security.model.SecurityUser;

class OtpBasedTwoFaProviderDiffblueTest {
  /**
   * Test
   * {@link OtpBasedTwoFaProvider#checkVerificationCode(SecurityUser, String, OtpBasedTwoFaProviderConfig, OtpBasedTwoFaAccountConfig)}
   * with {@code SecurityUser}, {@code String}, {@code EmailTwoFaProviderConfig},
   * {@code EmailTwoFaAccountConfig}.
   * <p>
   * Method under test:
   * {@link OtpBasedTwoFaProvider#checkVerificationCode(SecurityUser, String, OtpBasedTwoFaProviderConfig, OtpBasedTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test checkVerificationCode(SecurityUser, String, OtpBasedTwoFaProviderConfig, OtpBasedTwoFaAccountConfig) with 'SecurityUser', 'String', 'EmailTwoFaProviderConfig', 'EmailTwoFaAccountConfig'")
  void testCheckVerificationCodeWithSecurityUserStringEmailTwoFaProviderConfigEmailTwoFaAccountConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    NoOpCacheManager cacheManager = new NoOpCacheManager();
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

    EmailTwoFaProviderConfig emailTwoFaProviderConfig = new EmailTwoFaProviderConfig();
    emailTwoFaProviderConfig.setVerificationCodeLifetime(1);

    EmailTwoFaAccountConfig emailTwoFaAccountConfig = new EmailTwoFaAccountConfig();
    emailTwoFaAccountConfig.setEmail("jane.doe@example.org");
    emailTwoFaAccountConfig.setSerializeHiddenFields(true);
    emailTwoFaAccountConfig.setUseByDefault(true);

    // Act and Assert
    assertFalse(
        emailTwoFaProvider.checkVerificationCode(user, "Code", emailTwoFaProviderConfig, emailTwoFaAccountConfig));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}, and {@link Otp#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   *   <li>{@link OtpBasedTwoFaProvider.Otp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Otp equals(Object), and hashCode(); when other is equal; then return equal")
  void testOtpEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig());
    OtpBasedTwoFaProvider.Otp otp2 = new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig());

    // Act and Assert
    assertEquals(otp, otp2);
    int expectedHashCodeResult = otp.hashCode();
    assertEquals(expectedHashCodeResult, otp2.hashCode());
  }

  /**
   * Test Otp {@link Otp#equals(Object)}, and {@link Otp#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   *   <li>{@link OtpBasedTwoFaProvider.Otp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Otp equals(Object), and hashCode(); when other is equal; then return equal")
  void testOtpEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(10L, null, new EmailTwoFaAccountConfig());
    OtpBasedTwoFaProvider.Otp otp2 = new OtpBasedTwoFaProvider.Otp(10L, null, new EmailTwoFaAccountConfig());

    // Act and Assert
    assertEquals(otp, otp2);
    int expectedHashCodeResult = otp.hashCode();
    assertEquals(expectedHashCodeResult, otp2.hashCode());
  }

  /**
   * Test Otp {@link Otp#equals(Object)}, and {@link Otp#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   *   <li>{@link OtpBasedTwoFaProvider.Otp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Otp equals(Object), and hashCode(); when other is equal; then return equal")
  void testOtpEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(10L, "42", null);
    OtpBasedTwoFaProvider.Otp otp2 = new OtpBasedTwoFaProvider.Otp(10L, "42", null);

    // Act and Assert
    assertEquals(otp, otp2);
    int expectedHashCodeResult = otp.hashCode();
    assertEquals(expectedHashCodeResult, otp2.hashCode());
  }

  /**
   * Test Otp {@link Otp#equals(Object)}, and {@link Otp#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   *   <li>{@link OtpBasedTwoFaProvider.Otp#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test Otp equals(Object), and hashCode(); when other is same; then return equal")
  void testOtpEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig());

    // Act and Assert
    assertEquals(otp, otp);
    int expectedHashCodeResult = otp.hashCode();
    assertEquals(expectedHashCodeResult, otp.hashCode());
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(1L, "42", new EmailTwoFaAccountConfig());

    // Act and Assert
    assertNotEquals(otp, new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(10L, "Value", new EmailTwoFaAccountConfig());

    // Act and Assert
    assertNotEquals(otp, new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(10L, null, new EmailTwoFaAccountConfig());

    // Act and Assert
    assertNotEquals(otp, new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SmsTwoFaAccountConfig accountConfig = new SmsTwoFaAccountConfig();
    accountConfig.setPhoneNumber("6625550144");
    accountConfig.setSerializeHiddenFields(true);
    accountConfig.setUseByDefault(true);
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(10L, "42", accountConfig);

    // Act and Assert
    assertNotEquals(otp, new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(10L, "42", null);

    // Act and Assert
    assertNotEquals(otp, new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is different; then return not equal")
  void testOtpEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(10L, "42", mock(EmailTwoFaAccountConfig.class));

    // Act and Assert
    assertNotEquals(otp, new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig()));
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is 'null'; then return not equal")
  void testOtpEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig()), null);
  }

  /**
   * Test Otp {@link Otp#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OtpBasedTwoFaProvider.Otp#equals(Object)}
   */
  @Test
  @DisplayName("Test Otp equals(Object); when other is wrong type; then return not equal")
  void testOtpEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtpBasedTwoFaProvider.Otp(10L, "42", new EmailTwoFaAccountConfig()), "Different type to Otp");
  }

  /**
   * Test Otp getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OtpBasedTwoFaProvider.Otp#toString()}
   *   <li>{@link OtpBasedTwoFaProvider.Otp#getAccountConfig()}
   *   <li>{@link OtpBasedTwoFaProvider.Otp#getTimestamp()}
   *   <li>{@link OtpBasedTwoFaProvider.Otp#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test Otp getters and setters")
  void testOtpGettersAndSetters() {
    // Arrange
    EmailTwoFaAccountConfig accountConfig = new EmailTwoFaAccountConfig();
    OtpBasedTwoFaProvider.Otp otp = new OtpBasedTwoFaProvider.Otp(10L, "42", accountConfig);

    // Act
    String actualToStringResult = otp.toString();
    OtpBasedTwoFaAccountConfig actualAccountConfig = otp.getAccountConfig();
    long actualTimestamp = otp.getTimestamp();

    // Assert
    assertEquals("42", otp.getValue());
    assertEquals("OtpBasedTwoFaProvider.Otp(timestamp=10, value=42, accountConfig=EmailTwoFaAccountConfig(email=null))",
        actualToStringResult);
    assertEquals(10L, actualTimestamp);
    assertSame(accountConfig, actualAccountConfig);
  }

  /**
   * Test Otp {@link Otp#Otp(long, String, OtpBasedTwoFaAccountConfig)}.
   * <ul>
   *   <li>Then return AccountConfig is {@link EmailTwoFaAccountConfig} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtpBasedTwoFaProvider.Otp#Otp(long, String, OtpBasedTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test Otp new Otp(long, String, OtpBasedTwoFaAccountConfig); then return AccountConfig is EmailTwoFaAccountConfig (default constructor)")
  void testOtpNewOtp_thenReturnAccountConfigIsEmailTwoFaAccountConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmailTwoFaAccountConfig accountConfig = new EmailTwoFaAccountConfig();

    // Act and Assert
    assertSame(accountConfig, (new OtpBasedTwoFaProvider.Otp(10L, "42", accountConfig)).getAccountConfig());
  }

  /**
   * Test Otp {@link Otp#Otp(long, String, OtpBasedTwoFaAccountConfig)}.
   * <ul>
   *   <li>When {@link EmailTwoFaAccountConfig}.</li>
   *   <li>Then return Value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link OtpBasedTwoFaProvider.Otp#Otp(long, String, OtpBasedTwoFaAccountConfig)}
   */
  @Test
  @DisplayName("Test Otp new Otp(long, String, OtpBasedTwoFaAccountConfig); when EmailTwoFaAccountConfig; then return Value is '42'")
  void testOtpNewOtp_whenEmailTwoFaAccountConfig_thenReturnValueIs42() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EmailTwoFaAccountConfig accountConfig = mock(EmailTwoFaAccountConfig.class);

    // Act
    OtpBasedTwoFaProvider.Otp actualOtp = new OtpBasedTwoFaProvider.Otp(10L, "42", accountConfig);

    // Assert
    assertEquals("42", actualOtp.getValue());
    assertEquals(10L, actualOtp.getTimestamp());
    assertSame(accountConfig, actualOtp.getAccountConfig());
  }
}
