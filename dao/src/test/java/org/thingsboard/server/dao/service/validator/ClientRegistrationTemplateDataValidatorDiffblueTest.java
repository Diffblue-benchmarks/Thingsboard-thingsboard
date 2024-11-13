package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.atLeast;
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
import org.thingsboard.server.common.data.oauth2.OAuth2ClientRegistrationTemplate;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {ClientRegistrationTemplateDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class ClientRegistrationTemplateDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private ClientRegistrationTemplateDataValidator clientRegistrationTemplateDataValidator;

  /**
   * Test
   * {@link ClientRegistrationTemplateDataValidator#validateUpdate(TenantId, OAuth2ClientRegistrationTemplate)}
   * with {@code TenantId}, {@code OAuth2ClientRegistrationTemplate}.
   * <p>
   * Method under test:
   * {@link ClientRegistrationTemplateDataValidator#validateUpdate(TenantId, OAuth2ClientRegistrationTemplate)}
   */
  @Test
  public void testValidateUpdateWithTenantIdOAuth2ClientRegistrationTemplate() {
    // Arrange, Act and Assert
    assertNull(clientRegistrationTemplateDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT,
        new OAuth2ClientRegistrationTemplate()));
    assertNull(clientRegistrationTemplateDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT,
        mock(OAuth2ClientRegistrationTemplate.class)));
  }

  /**
   * Test
   * {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)}
   * with {@code TenantId}, {@code OAuth2ClientRegistrationTemplate}.
   * <p>
   * Method under test:
   * {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> clientRegistrationTemplateDataValidator
        .validateDataImpl(ModelConstants.SYSTEM_TENANT, new OAuth2ClientRegistrationTemplate()));
  }

  /**
   * Test
   * {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)}
   * with {@code TenantId}, {@code OAuth2ClientRegistrationTemplate}.
   * <p>
   * Method under test:
   * {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate2() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate = mock(OAuth2ClientRegistrationTemplate.class);
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
    when(clientRegistrationTemplate.getMapperConfig()).thenReturn(buildResult);
    when(clientRegistrationTemplate.getProviderId()).thenReturn("42");

    // Act
    clientRegistrationTemplateDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate);

    // Assert that nothing has changed
    verify(clientRegistrationTemplate, atLeast(1)).getMapperConfig();
    verify(clientRegistrationTemplate).getProviderId();
  }

  /**
   * Test
   * {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)}
   * with {@code TenantId}, {@code OAuth2ClientRegistrationTemplate}.
   * <p>
   * Method under test:
   * {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate3() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate = mock(OAuth2ClientRegistrationTemplate.class);
    when(clientRegistrationTemplate.getMapperConfig()).thenThrow(new DataValidationException("An error occurred"));
    when(clientRegistrationTemplate.getProviderId()).thenReturn("42");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> clientRegistrationTemplateDataValidator
        .validateDataImpl(ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate));
    verify(clientRegistrationTemplate).getMapperConfig();
    verify(clientRegistrationTemplate).getProviderId();
  }

  /**
   * Test
   * {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)}
   * with {@code TenantId}, {@code OAuth2ClientRegistrationTemplate}.
   * <p>
   * Method under test:
   * {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate4() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate = mock(OAuth2ClientRegistrationTemplate.class);
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
    when(clientRegistrationTemplate.getMapperConfig()).thenReturn(buildResult);
    when(clientRegistrationTemplate.getProviderId()).thenReturn("42");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> clientRegistrationTemplateDataValidator
        .validateDataImpl(ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate));
    verify(clientRegistrationTemplate, atLeast(1)).getMapperConfig();
    verify(clientRegistrationTemplate).getProviderId();
  }

  /**
   * Test
   * {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)}
   * with {@code TenantId}, {@code OAuth2ClientRegistrationTemplate}.
   * <p>
   * Method under test:
   * {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)}
   */
  @Test
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate5() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate = mock(OAuth2ClientRegistrationTemplate.class);
    when(clientRegistrationTemplate.getProviderId()).thenReturn("");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> clientRegistrationTemplateDataValidator
        .validateDataImpl(ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate));
    verify(clientRegistrationTemplate).getProviderId();
  }
}
