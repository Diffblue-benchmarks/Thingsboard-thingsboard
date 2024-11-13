package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.OAuth2BasicMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {Oauth2ClientDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class Oauth2ClientDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private Oauth2ClientDataValidator oauth2ClientDataValidator;

  /**
   * Test
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   * with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test:
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2Client() {
    // Arrange
    OAuth2Client oAuth2Client = mock(OAuth2Client.class);
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();
    when(oAuth2Client.getMapperConfig()).thenReturn(buildResult);

    // Act
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);

    // Assert that nothing has changed
    verify(oAuth2Client).getMapperConfig();
  }

  /**
   * Test
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   * with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test:
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2Client2() {
    // Arrange
    OAuth2Client oAuth2Client = mock(OAuth2Client.class);
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey(null)
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();
    when(oAuth2Client.getMapperConfig()).thenReturn(buildResult);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
    verify(oAuth2Client).getMapperConfig();
  }

  /**
   * Test
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   * with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test:
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2Client3() {
    // Arrange
    OAuth2Client oAuth2Client = mock(OAuth2Client.class);
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();
    when(oAuth2Client.getMapperConfig()).thenReturn(buildResult);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
    verify(oAuth2Client).getMapperConfig();
  }

  /**
   * Test
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   * with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test:
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2Client4() {
    // Arrange
    OAuth2Client oAuth2Client = mock(OAuth2Client.class);
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(null)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();
    when(oAuth2Client.getMapperConfig()).thenReturn(buildResult);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
    verify(oAuth2Client).getMapperConfig();
  }

  /**
   * Test
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   * with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test:
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2Client5() {
    // Arrange
    OAuth2Client oAuth2Client = mock(OAuth2Client.class);
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.CUSTOM)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.BASIC).build();
    when(oAuth2Client.getMapperConfig()).thenReturn(buildResult);

    // Act
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);

    // Assert that nothing has changed
    verify(oAuth2Client).getMapperConfig();
  }

  /**
   * Test
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   * with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test:
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2Client6() {
    // Arrange
    OAuth2Client oAuth2Client = mock(OAuth2Client.class);
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(null).build();
    when(oAuth2Client.getMapperConfig()).thenReturn(buildResult);

    // Act
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);

    // Assert that nothing has changed
    verify(oAuth2Client).getMapperConfig();
  }

  /**
   * Test
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   * with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test:
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2Client7() {
    // Arrange
    OAuth2Client oAuth2Client = mock(OAuth2Client.class);
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.CUSTOM).build();
    when(oAuth2Client.getMapperConfig()).thenReturn(buildResult);

    // Act
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);

    // Assert that nothing has changed
    verify(oAuth2Client).getMapperConfig();
  }

  /**
   * Test
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   * with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test:
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2Client8() {
    // Arrange
    OAuth2Client oAuth2Client = mock(OAuth2Client.class);
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.GITHUB).build();
    when(oAuth2Client.getMapperConfig()).thenReturn(buildResult);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
    verify(oAuth2Client).getMapperConfig();
  }

  /**
   * Test
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   * with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test:
   * {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2Client9() {
    // Arrange
    OAuth2Client oAuth2Client = mock(OAuth2Client.class);
    OAuth2MapperConfig.OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey(null)
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfig.OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig buildResult = basicResult.custom(custom).type(MapperType.GITHUB).build();
    when(oAuth2Client.getMapperConfig()).thenReturn(buildResult);

    // Act
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);

    // Assert that nothing has changed
    verify(oAuth2Client).getMapperConfig();
  }
}
