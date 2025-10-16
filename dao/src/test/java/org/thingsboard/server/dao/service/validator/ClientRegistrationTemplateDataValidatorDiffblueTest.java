/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.thingsboard.server.common.data.oauth2.OAuth2ClientRegistrationTemplate;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig.OAuth2MapperConfigBuilder;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {ClientRegistrationTemplateDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class ClientRegistrationTemplateDataValidatorDiffblueTest {
  @Autowired
  private ClientRegistrationTemplateDataValidator clientRegistrationTemplateDataValidator;

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateUpdate(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateUpdate(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate ClientRegistrationTemplateDataValidator.validateUpdate(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateUpdateWithTenantIdOAuth2ClientRegistrationTemplate() {
    // Arrange, Act and Assert
    assertNull(
        clientRegistrationTemplateDataValidator.validateUpdate(
            ModelConstants.SYSTEM_TENANT, new OAuth2ClientRegistrationTemplate()));
  }

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClientRegistrationTemplateDataValidator.validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            clientRegistrationTemplateDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new OAuth2ClientRegistrationTemplate()));
  }

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClientRegistrationTemplateDataValidator.validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate2() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    clientRegistrationTemplate.setProviderId("");
    clientRegistrationTemplate.setMapperConfig(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            clientRegistrationTemplateDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate));
  }

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClientRegistrationTemplateDataValidator.validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate3() {
    // Arrange
    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult =
        allowUserCreationResult.basic(
            OAuth2BasicMapperConfig.builder()
                .alwaysFullScreen(true)
                .customerNamePattern("Customer Name Pattern")
                .defaultDashboardName("Default Dashboard Name")
                .emailAttributeKey("jane.doe@example.org")
                .firstNameAttributeKey("Jane")
                .lastNameAttributeKey("Doe")
                .tenantNamePattern("Tenant Name Pattern")
                .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
                .build());

    OAuth2MapperConfig mapperConfig =
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build();
    mapperConfig.setType(null);
    mapperConfig.setBasic(null);

    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    clientRegistrationTemplate.setProviderId("Client Registration Template");
    clientRegistrationTemplate.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            clientRegistrationTemplateDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate));
  }

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClientRegistrationTemplateDataValidator.validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate4() {
    // Arrange
    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult =
        allowUserCreationResult.basic(
            OAuth2BasicMapperConfig.builder()
                .alwaysFullScreen(true)
                .customerNamePattern("Customer Name Pattern")
                .defaultDashboardName("Default Dashboard Name")
                .emailAttributeKey("jane.doe@example.org")
                .firstNameAttributeKey("Jane")
                .lastNameAttributeKey("Doe")
                .tenantNamePattern("Tenant Name Pattern")
                .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
                .build());

    OAuth2MapperConfig mapperConfig =
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build();
    mapperConfig.setType(MapperType.BASIC);
    mapperConfig.setBasic(null);

    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    clientRegistrationTemplate.setProviderId("Client Registration Template");
    clientRegistrationTemplate.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            clientRegistrationTemplateDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate));
  }

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClientRegistrationTemplateDataValidator.validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate5() {
    // Arrange
    OAuth2MapperConfig mapperConfig = mock(OAuth2MapperConfig.class);
    when(mapperConfig.getType()).thenThrow(new DataValidationException("An error occurred"));

    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    clientRegistrationTemplate.setProviderId("Client Registration Template");
    clientRegistrationTemplate.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            clientRegistrationTemplateDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate));
    verify(mapperConfig).getType();
  }

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClientRegistrationTemplateDataValidator.validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate6() {
    // Arrange
    OAuth2MapperConfig mapperConfig = mock(OAuth2MapperConfig.class);
    when(mapperConfig.getBasic()).thenThrow(new DataValidationException("An error occurred"));
    when(mapperConfig.getType()).thenReturn(MapperType.BASIC);

    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    clientRegistrationTemplate.setProviderId("Client Registration Template");
    clientRegistrationTemplate.setMapperConfig(mapperConfig);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            clientRegistrationTemplateDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate));
    verify(mapperConfig).getBasic();
    verify(mapperConfig).getType();
  }

  /**
   * Test {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)} with {@code TenantId}, {@code
   * OAuth2ClientRegistrationTemplate}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ClientRegistrationTemplateDataValidator#validateDataImpl(TenantId,
   * OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClientRegistrationTemplateDataValidator.validateDataImpl(TenantId, OAuth2ClientRegistrationTemplate)"
  })
  public void testValidateDataImplWithTenantIdOAuth2ClientRegistrationTemplate_givenNull() {
    // Arrange
    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate(new OAuth2ClientRegistrationTemplate());
    clientRegistrationTemplate.setProviderId("Client Registration Template");
    clientRegistrationTemplate.setMapperConfig(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            clientRegistrationTemplateDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, clientRegistrationTemplate));
  }
}
