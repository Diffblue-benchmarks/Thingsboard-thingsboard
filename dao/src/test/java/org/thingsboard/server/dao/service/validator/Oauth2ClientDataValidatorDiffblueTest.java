package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.OAuth2BasicMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig.OAuth2MapperConfigBuilder;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {Oauth2ClientDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class Oauth2ClientDataValidatorDiffblueTest {
  @Autowired
  private Oauth2ClientDataValidator oauth2ClientDataValidator;

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client() {
    // Arrange
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
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
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    mapperConfig.setType(MapperType.BASIC);
    mapperConfig.setBasic(null);
    mapperConfig.setCustom(null);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client2() {
    // Arrange
    OAuth2Client oAuth2Client = new OAuth2Client();
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
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
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    oAuth2Client.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client3() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
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
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    mapperConfig.setType(MapperType.CUSTOM);
    mapperConfig.setBasic(null);
    mapperConfig.setCustom(null);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client4() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
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
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    mapperConfig.setType(MapperType.GITHUB);
    mapperConfig.setBasic(null);
    mapperConfig.setCustom(null);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client5() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();
    OAuth2BasicMapperConfig basic = mock(OAuth2BasicMapperConfig.class);
    when(basic.getTenantNameStrategy()).thenThrow(new DataValidationException("An error occurred"));
    when(basic.getEmailAttributeKey()).thenReturn("jane.doe@example.org");
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic2);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    mapperConfig.setType(MapperType.BASIC);
    mapperConfig.setBasic(basic);
    mapperConfig.setCustom(null);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
    verify(basic).getEmailAttributeKey();
    verify(basic).getTenantNameStrategy();
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client6() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();
    OAuth2BasicMapperConfig basic = mock(OAuth2BasicMapperConfig.class);
    when(basic.getEmailAttributeKey()).thenReturn("jane.doe@example.org");
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic2);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    mapperConfig.setType(MapperType.GITHUB);
    mapperConfig.setBasic(basic);
    mapperConfig.setCustom(null);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
    verify(basic).getEmailAttributeKey();
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client7() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();
    OAuth2BasicMapperConfig basic = mock(OAuth2BasicMapperConfig.class);
    when(basic.getTenantNamePattern()).thenReturn("Tenant Name Pattern");
    when(basic.getTenantNameStrategy()).thenReturn(TenantNameStrategyType.CUSTOM);
    when(basic.getEmailAttributeKey()).thenReturn("jane.doe@example.org");
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic2);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    mapperConfig.setType(MapperType.BASIC);
    mapperConfig.setBasic(basic);
    mapperConfig.setCustom(null);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setMapperConfig(mapperConfig);

    // Act
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);

    // Assert
    verify(basic).getEmailAttributeKey();
    verify(basic).getTenantNamePattern();
    verify(basic, atLeast(1)).getTenantNameStrategy();
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client8() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();
    OAuth2BasicMapperConfig basic = mock(OAuth2BasicMapperConfig.class);
    when(basic.getTenantNamePattern()).thenReturn(null);
    when(basic.getTenantNameStrategy()).thenReturn(TenantNameStrategyType.CUSTOM);
    when(basic.getEmailAttributeKey()).thenReturn("jane.doe@example.org");
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic2);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    mapperConfig.setType(MapperType.BASIC);
    mapperConfig.setBasic(basic);
    mapperConfig.setCustom(null);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
    verify(basic).getEmailAttributeKey();
    verify(basic).getTenantNamePattern();
    verify(basic, atLeast(1)).getTenantNameStrategy();
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client9() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();
    OAuth2BasicMapperConfig basic = mock(OAuth2BasicMapperConfig.class);
    when(basic.getTenantNameStrategy()).thenReturn(null);
    when(basic.getEmailAttributeKey()).thenReturn("jane.doe@example.org");
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic2);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    mapperConfig.setType(MapperType.BASIC);
    mapperConfig.setBasic(basic);
    mapperConfig.setCustom(null);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
    verify(basic).getEmailAttributeKey();
    verify(basic).getTenantNameStrategy();
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code TenantId}, {@code OAuth2Client}.
   * <p>
   * Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client10() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();
    OAuth2BasicMapperConfig basic = mock(OAuth2BasicMapperConfig.class);
    when(basic.getTenantNamePattern()).thenThrow(new DataValidationException("An error occurred"));
    when(basic.getTenantNameStrategy()).thenReturn(TenantNameStrategyType.CUSTOM);
    when(basic.getEmailAttributeKey()).thenReturn("jane.doe@example.org");
    OAuth2MapperConfigBuilder allowUserCreationResult = OAuth2MapperConfig.builder()
        .activateUser(true)
        .allowUserCreation(true);
    OAuth2BasicMapperConfig basic2 = OAuth2BasicMapperConfig.builder()
        .alwaysFullScreen(true)
        .customerNamePattern("Customer Name Pattern")
        .defaultDashboardName("Default Dashboard Name")
        .emailAttributeKey("jane.doe@example.org")
        .firstNameAttributeKey("Jane")
        .lastNameAttributeKey("Doe")
        .tenantNamePattern("Tenant Name Pattern")
        .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
        .build();
    OAuth2MapperConfigBuilder basicResult = allowUserCreationResult.basic(basic2);
    OAuth2CustomMapperConfig custom = OAuth2CustomMapperConfig.builder()
        .password("iloveyou")
        .sendToken(true)
        .url("https://example.org/example")
        .username("janedoe")
        .build();
    OAuth2MapperConfig mapperConfig = basicResult.custom(custom).type(MapperType.BASIC).build();
    mapperConfig.setType(MapperType.BASIC);
    mapperConfig.setBasic(basic);
    mapperConfig.setCustom(null);

    OAuth2Client oAuth2Client = new OAuth2Client();
    oAuth2Client.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
    verify(basic).getEmailAttributeKey();
    verify(basic).getTenantNamePattern();
    verify(basic, atLeast(1)).getTenantNameStrategy();
  }
}
