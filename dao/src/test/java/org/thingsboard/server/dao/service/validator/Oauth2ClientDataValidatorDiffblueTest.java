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

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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

public class Oauth2ClientDataValidatorDiffblueTest {
  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code
   * TenantId}, {@code OAuth2Client}.
   *
   * <p>Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId,
   * OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();

    OAuth2Client oAuth2Client = new OAuth2Client();

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
    oAuth2Client.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());

    // Act and Assert
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code
   * TenantId}, {@code OAuth2Client}.
   *
   * <p>Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId,
   * OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client2() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();

    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult =
        allowUserCreationResult.basic(
            OAuth2BasicMapperConfig.builder()
                .alwaysFullScreen(true)
                .customerNamePattern("Customer Name Pattern")
                .defaultDashboardName("Default Dashboard Name")
                .emailAttributeKey(null)
                .firstNameAttributeKey("Jane")
                .lastNameAttributeKey("Doe")
                .tenantNamePattern("Tenant Name Pattern")
                .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
                .build());
    oAuth2Client.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code
   * TenantId}, {@code OAuth2Client}.
   *
   * <p>Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId,
   * OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client3() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();

    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult =
        allowUserCreationResult.basic(
            OAuth2BasicMapperConfig.builder()
                .alwaysFullScreen(true)
                .customerNamePattern("Customer Name Pattern")
                .defaultDashboardName("Default Dashboard Name")
                .emailAttributeKey("")
                .firstNameAttributeKey("Jane")
                .lastNameAttributeKey("Doe")
                .tenantNamePattern("Tenant Name Pattern")
                .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
                .build());
    oAuth2Client.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code
   * TenantId}, {@code OAuth2Client}.
   *
   * <p>Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId,
   * OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client4() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();

    OAuth2Client oAuth2Client = new OAuth2Client();

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
                .tenantNameStrategy(null)
                .build());
    oAuth2Client.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code
   * TenantId}, {@code OAuth2Client}.
   *
   * <p>Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId,
   * OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client5() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();

    OAuth2Client oAuth2Client = new OAuth2Client();

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
                .tenantNameStrategy(TenantNameStrategyType.CUSTOM)
                .build());
    oAuth2Client.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());

    // Act and Assert
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code
   * TenantId}, {@code OAuth2Client}.
   *
   * <p>Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId,
   * OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client6() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();

    OAuth2Client oAuth2Client = new OAuth2Client();

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
    oAuth2Client.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(null)
            .build());

    // Act and Assert
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code
   * TenantId}, {@code OAuth2Client}.
   *
   * <p>Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId,
   * OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client7() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();

    OAuth2Client oAuth2Client = new OAuth2Client();

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
    oAuth2Client.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.CUSTOM)
            .build());

    // Act and Assert
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code
   * TenantId}, {@code OAuth2Client}.
   *
   * <p>Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId,
   * OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client8() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();

    OAuth2Client oAuth2Client = new OAuth2Client();

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
    oAuth2Client.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.GITHUB)
            .build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code
   * TenantId}, {@code OAuth2Client}.
   *
   * <p>Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId,
   * OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client9() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();

    OAuth2Client oAuth2Client = new OAuth2Client();

    OAuth2MapperConfigBuilder allowUserCreationResult =
        OAuth2MapperConfig.builder().activateUser(true).allowUserCreation(true);

    OAuth2MapperConfigBuilder basicResult =
        allowUserCreationResult.basic(
            OAuth2BasicMapperConfig.builder()
                .alwaysFullScreen(true)
                .customerNamePattern("Customer Name Pattern")
                .defaultDashboardName("Default Dashboard Name")
                .emailAttributeKey(null)
                .firstNameAttributeKey("Jane")
                .lastNameAttributeKey("Doe")
                .tenantNamePattern("Tenant Name Pattern")
                .tenantNameStrategy(TenantNameStrategyType.DOMAIN)
                .build());
    oAuth2Client.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.GITHUB)
            .build());

    // Act and Assert
    oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client);
  }

  /**
   * Test {@link Oauth2ClientDataValidator#validateDataImpl(TenantId, OAuth2Client)} with {@code
   * TenantId}, {@code OAuth2Client}.
   *
   * <p>Method under test: {@link Oauth2ClientDataValidator#validateDataImpl(TenantId,
   * OAuth2Client)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void Oauth2ClientDataValidator.validateDataImpl(TenantId, OAuth2Client)"})
  public void testValidateDataImplWithTenantIdOAuth2Client10() {
    // Arrange
    Oauth2ClientDataValidator oauth2ClientDataValidator = new Oauth2ClientDataValidator();

    OAuth2Client oAuth2Client = new OAuth2Client();

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
                .tenantNamePattern(null)
                .tenantNameStrategy(TenantNameStrategyType.CUSTOM)
                .build());
    oAuth2Client.setMapperConfig(
        basicResult
            .custom(
                OAuth2CustomMapperConfig.builder()
                    .password("iloveyou")
                    .sendToken(true)
                    .url("https://example.org/example")
                    .username("janedoe")
                    .build())
            .type(MapperType.BASIC)
            .build());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            oauth2ClientDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, oAuth2Client));
  }
}
