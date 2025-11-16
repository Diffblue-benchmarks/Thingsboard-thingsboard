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
package org.thingsboard.server.dao.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.OAuth2ClientRegistrationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.OAuth2BasicMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientRegistrationTemplate;
import org.thingsboard.server.common.data.oauth2.OAuth2CustomMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig.OAuth2MapperConfigBuilder;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.OAuth2ClientRegistrationTemplateEntity;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.validator.ClientRegistrationTemplateDataValidator;
import org.thingsboard.server.dao.sql.oauth2.JpaOAuth2ClientRegistrationTemplateDao;
import org.thingsboard.server.dao.sql.oauth2.OAuth2ClientRegistrationTemplateRepository;

@ContextConfiguration(classes = {OAuth2ConfigTemplateServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class OAuth2ConfigTemplateServiceImplDiffblueTest {
  @MockBean private DataValidator<OAuth2ClientRegistrationTemplate> dataValidator;

  @MockBean private OAuth2ClientRegistrationTemplateDao oAuth2ClientRegistrationTemplateDao;

  @Autowired private OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl;

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"
  })
  public void testSaveClientRegistrationTemplate() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing saveClientRegistrationTemplate [{}]");
    when(oAuth2ClientRegistrationTemplateDao.save(
            Mockito.<TenantId>any(), Mockito.<OAuth2ClientRegistrationTemplate>any()))
        .thenThrow(constraintViolationException);
    when(dataValidator.validate(
            Mockito.<OAuth2ClientRegistrationTemplate>any(),
            Mockito.<Function<OAuth2ClientRegistrationTemplate, TenantId>>any()))
        .thenReturn(new OAuth2ClientRegistrationTemplate());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(
                new OAuth2ClientRegistrationTemplate()));
    verify(oAuth2ClientRegistrationTemplateDao)
        .save(isA(TenantId.class), isA(OAuth2ClientRegistrationTemplate.class));
    verify(dataValidator)
        .validate(isA(OAuth2ClientRegistrationTemplate.class), isA(Function.class));
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"
  })
  public void testSaveClientRegistrationTemplate2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "oauth2_template_provider_id_unq_key");
    when(oAuth2ClientRegistrationTemplateDao.save(
            Mockito.<TenantId>any(), Mockito.<OAuth2ClientRegistrationTemplate>any()))
        .thenThrow(constraintViolationException);
    when(dataValidator.validate(
            Mockito.<OAuth2ClientRegistrationTemplate>any(),
            Mockito.<Function<OAuth2ClientRegistrationTemplate, TenantId>>any()))
        .thenReturn(new OAuth2ClientRegistrationTemplate());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(
                new OAuth2ClientRegistrationTemplate()));
    verify(oAuth2ClientRegistrationTemplateDao)
        .save(isA(TenantId.class), isA(OAuth2ClientRegistrationTemplate.class));
    verify(dataValidator)
        .validate(isA(OAuth2ClientRegistrationTemplate.class), isA(Function.class));
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"
  })
  public void testSaveClientRegistrationTemplate3() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), null);
    when(oAuth2ClientRegistrationTemplateDao.save(
            Mockito.<TenantId>any(), Mockito.<OAuth2ClientRegistrationTemplate>any()))
        .thenThrow(constraintViolationException);
    when(dataValidator.validate(
            Mockito.<OAuth2ClientRegistrationTemplate>any(),
            Mockito.<Function<OAuth2ClientRegistrationTemplate, TenantId>>any()))
        .thenReturn(new OAuth2ClientRegistrationTemplate());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(
                new OAuth2ClientRegistrationTemplate()));
    verify(oAuth2ClientRegistrationTemplateDao)
        .save(isA(TenantId.class), isA(OAuth2ClientRegistrationTemplate.class));
    verify(dataValidator)
        .validate(isA(OAuth2ClientRegistrationTemplate.class), isA(Function.class));
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"
  })
  public void testSaveClientRegistrationTemplate4() {
    // Arrange
    when(oAuth2ClientRegistrationTemplateDao.save(
            Mockito.<TenantId>any(), Mockito.<OAuth2ClientRegistrationTemplate>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(dataValidator.validate(
            Mockito.<OAuth2ClientRegistrationTemplate>any(),
            Mockito.<Function<OAuth2ClientRegistrationTemplate, TenantId>>any()))
        .thenReturn(new OAuth2ClientRegistrationTemplate());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(
                new OAuth2ClientRegistrationTemplate()));
    verify(oAuth2ClientRegistrationTemplateDao)
        .save(isA(TenantId.class), isA(OAuth2ClientRegistrationTemplate.class));
    verify(dataValidator)
        .validate(isA(OAuth2ClientRegistrationTemplate.class), isA(Function.class));
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"
  })
  public void testSaveClientRegistrationTemplate5() {
    // Arrange
    JpaOAuth2ClientRegistrationTemplateDao clientRegistrationTemplateDao =
        new JpaOAuth2ClientRegistrationTemplateDao(
            mock(OAuth2ClientRegistrationTemplateRepository.class));
    OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl =
        new OAuth2ConfigTemplateServiceImpl(
            clientRegistrationTemplateDao, new ClientRegistrationTemplateDataValidator());

    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        mock(OAuth2ClientRegistrationTemplate.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(clientRegistrationTemplate.getProviderId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(
                clientRegistrationTemplate));
    verify(clientRegistrationTemplate).getProviderId();
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"
  })
  public void testSaveClientRegistrationTemplate6() {
    // Arrange
    JpaOAuth2ClientRegistrationTemplateDao clientRegistrationTemplateDao =
        new JpaOAuth2ClientRegistrationTemplateDao(
            mock(OAuth2ClientRegistrationTemplateRepository.class));
    OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl =
        new OAuth2ConfigTemplateServiceImpl(
            clientRegistrationTemplateDao, new ClientRegistrationTemplateDataValidator());

    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        mock(OAuth2ClientRegistrationTemplate.class);
    when(clientRegistrationTemplate.getProviderId())
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(
                clientRegistrationTemplate));
    verify(clientRegistrationTemplate).getProviderId();
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"
  })
  public void testSaveClientRegistrationTemplate7() {
    // Arrange
    JpaOAuth2ClientRegistrationTemplateDao clientRegistrationTemplateDao =
        new JpaOAuth2ClientRegistrationTemplateDao(
            mock(OAuth2ClientRegistrationTemplateRepository.class));
    OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl =
        new OAuth2ConfigTemplateServiceImpl(
            clientRegistrationTemplateDao, new ClientRegistrationTemplateDataValidator());

    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        mock(OAuth2ClientRegistrationTemplate.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing saveClientRegistrationTemplate [{}]");
    when(clientRegistrationTemplate.getMapperConfig()).thenThrow(constraintViolationException);
    when(clientRegistrationTemplate.getProviderId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(
                clientRegistrationTemplate));
    verify(clientRegistrationTemplate).getMapperConfig();
    verify(clientRegistrationTemplate).getProviderId();
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientRegistrationTemplateDao}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"
  })
  public void testSaveClientRegistrationTemplate_givenOAuth2ClientRegistrationTemplateDao() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing saveClientRegistrationTemplate [{}]");
    when(dataValidator.validate(
            Mockito.<OAuth2ClientRegistrationTemplate>any(),
            Mockito.<Function<OAuth2ClientRegistrationTemplate, TenantId>>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(
                new OAuth2ClientRegistrationTemplate()));
    verify(dataValidator)
        .validate(isA(OAuth2ClientRegistrationTemplate.class), isA(Function.class));
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <ul>
   *   <li>Then calls {@link OAuth2ClientRegistrationTemplate#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"
  })
  public void testSaveClientRegistrationTemplate_thenCallsGetId() {
    // Arrange
    JpaOAuth2ClientRegistrationTemplateDao clientRegistrationTemplateDao =
        new JpaOAuth2ClientRegistrationTemplateDao(
            mock(OAuth2ClientRegistrationTemplateRepository.class));
    OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl =
        new OAuth2ConfigTemplateServiceImpl(
            clientRegistrationTemplateDao, new ClientRegistrationTemplateDataValidator());

    OAuth2ClientRegistrationTemplate clientRegistrationTemplate =
        mock(OAuth2ClientRegistrationTemplate.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing saveClientRegistrationTemplate [{}]");
    when(clientRegistrationTemplate.getId()).thenThrow(constraintViolationException);

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
    when(clientRegistrationTemplate.getMapperConfig())
        .thenReturn(
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
    when(clientRegistrationTemplate.getProviderId()).thenReturn("42");

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(
                clientRegistrationTemplate));
    verify(clientRegistrationTemplate).getId();
    verify(clientRegistrationTemplate, atLeast(1)).getMapperConfig();
    verify(clientRegistrationTemplate).getProviderId();
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}.
   *
   * <ul>
   *   <li>Then return {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(OAuth2ClientRegistrationTemplate)"
  })
  public void testSaveClientRegistrationTemplate_thenReturnOAuth2ClientRegistrationTemplate() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    when(oAuth2ClientRegistrationTemplateDao.save(
            Mockito.<TenantId>any(), Mockito.<OAuth2ClientRegistrationTemplate>any()))
        .thenReturn(oAuth2ClientRegistrationTemplate);
    when(dataValidator.validate(
            Mockito.<OAuth2ClientRegistrationTemplate>any(),
            Mockito.<Function<OAuth2ClientRegistrationTemplate, TenantId>>any()))
        .thenReturn(new OAuth2ClientRegistrationTemplate());

    // Act
    OAuth2ClientRegistrationTemplate actualSaveClientRegistrationTemplateResult =
        oAuth2ConfigTemplateServiceImpl.saveClientRegistrationTemplate(
            new OAuth2ClientRegistrationTemplate());

    // Assert
    verify(oAuth2ClientRegistrationTemplateDao)
        .save(isA(TenantId.class), isA(OAuth2ClientRegistrationTemplate.class));
    verify(dataValidator)
        .validate(isA(OAuth2ClientRegistrationTemplate.class), isA(Function.class));
    assertSame(oAuth2ClientRegistrationTemplate, actualSaveClientRegistrationTemplateResult);
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateByProviderId(String)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateByProviderId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional OAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateByProviderId(String)"
  })
  public void testFindClientRegistrationTemplateByProviderId() {
    // Arrange
    Optional<OAuth2ClientRegistrationTemplate> ofResult =
        Optional.of(new OAuth2ClientRegistrationTemplate());
    when(oAuth2ClientRegistrationTemplateDao.findByProviderId(Mockito.<String>any()))
        .thenReturn(ofResult);

    // Act
    Optional<OAuth2ClientRegistrationTemplate>
        actualFindClientRegistrationTemplateByProviderIdResult =
            oAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateByProviderId("42");

    // Assert
    verify(oAuth2ClientRegistrationTemplateDao).findByProviderId("42");
    assertSame(ofResult, actualFindClientRegistrationTemplateByProviderIdResult);
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateByProviderId(String)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateByProviderId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional OAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateByProviderId(String)"
  })
  public void testFindClientRegistrationTemplateByProviderId2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findClientRegistrationTemplateByProviderId [{}]");
    when(oAuth2ClientRegistrationTemplateDao.findByProviderId(Mockito.<String>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> oAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateByProviderId("42"));
    verify(oAuth2ClientRegistrationTemplateDao).findByProviderId("42");
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateByProviderId(String)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateByProviderId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Optional OAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateByProviderId(String)"
  })
  public void testFindClientRegistrationTemplateByProviderId3() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientRegistrationTemplateRepository repository =
        mock(OAuth2ClientRegistrationTemplateRepository.class);
    when(repository.findByProviderId(Mockito.<String>any()))
        .thenReturn(oAuth2ClientRegistrationTemplateEntity);
    JpaOAuth2ClientRegistrationTemplateDao clientRegistrationTemplateDao =
        new JpaOAuth2ClientRegistrationTemplateDao(repository);
    OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl =
        new OAuth2ConfigTemplateServiceImpl(
            clientRegistrationTemplateDao, new ClientRegistrationTemplateDataValidator());

    // Act
    Optional<OAuth2ClientRegistrationTemplate>
        actualFindClientRegistrationTemplateByProviderIdResult =
            oAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateByProviderId("42");

    // Assert
    verify(repository).findByProviderId("42");
    OAuth2ClientRegistrationTemplate getResult =
        actualFindClientRegistrationTemplateByProviderIdResult.get();
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getProviderId());
    assertEquals("ABC123", getResult.getAccessTokenUri());
    assertEquals("Client Authentication Method", getResult.getClientAuthenticationMethod());
    assertEquals("Comment", getResult.getComment());
    assertEquals("Help Link", getResult.getHelpLink());
    assertEquals("JaneDoe", getResult.getAuthorizationUri());
    assertEquals("Jwk Set Uri", getResult.getJwkSetUri());
    assertEquals("Login Button Icon", getResult.getLoginButtonIcon());
    assertEquals("Login Button Label", getResult.getLoginButtonLabel());
    assertEquals("User Info Uri", getResult.getUserInfoUri());
    assertEquals("janedoe", getResult.getUserNameAttributeName());
    assertEquals(1, getResult.getScope().size());
    assertEquals(1L, getResult.getCreatedTime());
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)"
  })
  public void testFindClientRegistrationTemplateById() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    when(oAuth2ClientRegistrationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(oAuth2ClientRegistrationTemplate);

    // Act
    OAuth2ClientRegistrationTemplate actualFindClientRegistrationTemplateByIdResult =
        oAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateById(
            new OAuth2ClientRegistrationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(oAuth2ClientRegistrationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(oAuth2ClientRegistrationTemplate, actualFindClientRegistrationTemplateByIdResult);
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)"
  })
  public void testFindClientRegistrationTemplateById2() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<OAuth2ClientRegistrationTemplateEntity> ofResult =
        Optional.of(oAuth2ClientRegistrationTemplateEntity);

    OAuth2ClientRegistrationTemplateRepository repository =
        mock(OAuth2ClientRegistrationTemplateRepository.class);
    when(repository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaOAuth2ClientRegistrationTemplateDao clientRegistrationTemplateDao =
        new JpaOAuth2ClientRegistrationTemplateDao(repository);
    OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl =
        new OAuth2ConfigTemplateServiceImpl(
            clientRegistrationTemplateDao, new ClientRegistrationTemplateDataValidator());

    // Act
    OAuth2ClientRegistrationTemplate actualFindClientRegistrationTemplateByIdResult =
        oAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateById(
            new OAuth2ClientRegistrationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(repository).findById(isA(UUID.class));
    JsonNode additionalInfo = actualFindClientRegistrationTemplateByIdResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertFalse(iteratorResult.hasNext());
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)"
  })
  public void testFindClientRegistrationTemplateById_givenNull_uuid() {
    // Arrange
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate =
        new OAuth2ClientRegistrationTemplate();
    when(oAuth2ClientRegistrationTemplateDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(oAuth2ClientRegistrationTemplate);

    OAuth2ClientRegistrationTemplateId templateId = mock(OAuth2ClientRegistrationTemplateId.class);
    when(templateId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    OAuth2ClientRegistrationTemplate actualFindClientRegistrationTemplateByIdResult =
        oAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateById(templateId);

    // Assert
    verify(templateId, atLeast(1)).getId();
    verify(oAuth2ClientRegistrationTemplateDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(oAuth2ClientRegistrationTemplate, actualFindClientRegistrationTemplateByIdResult);
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "OAuth2ClientRegistrationTemplate OAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)"
  })
  public void testFindClientRegistrationTemplateById_thenThrowConstraintViolationException() {
    // Arrange
    OAuth2ClientRegistrationTemplateId templateId = mock(OAuth2ClientRegistrationTemplateId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findClientRegistrationTemplateById [{}]");
    when(templateId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> oAuth2ConfigTemplateServiceImpl.findClientRegistrationTemplateById(templateId));
    verify(templateId).getId();
  }

  /**
   * Test {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates()"})
  public void testFindAllClientRegistrationTemplates_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRegistrationTemplateDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllClientRegistrationTemplatesResult =
        oAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates();

    // Assert
    verify(oAuth2ClientRegistrationTemplateDao).findAll();
    assertTrue(actualFindAllClientRegistrationTemplatesResult.isEmpty());
  }

  /**
   * Test {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates()"})
  public void testFindAllClientRegistrationTemplates_thenReturnSizeIsOne() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setComment(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientRegistrationTemplateEntity> oAuth2ClientRegistrationTemplateEntityList =
        new ArrayList<>();
    oAuth2ClientRegistrationTemplateEntityList.add(oAuth2ClientRegistrationTemplateEntity);

    OAuth2ClientRegistrationTemplateRepository repository =
        mock(OAuth2ClientRegistrationTemplateRepository.class);
    when(repository.findAll()).thenReturn(oAuth2ClientRegistrationTemplateEntityList);
    JpaOAuth2ClientRegistrationTemplateDao clientRegistrationTemplateDao =
        new JpaOAuth2ClientRegistrationTemplateDao(repository);
    OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl =
        new OAuth2ConfigTemplateServiceImpl(
            clientRegistrationTemplateDao, new ClientRegistrationTemplateDataValidator());

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllClientRegistrationTemplatesResult =
        oAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates();

    // Assert
    verify(repository).findAll();
    assertEquals(1, actualFindAllClientRegistrationTemplatesResult.size());
    OAuth2ClientRegistrationTemplate getResult =
        actualFindAllClientRegistrationTemplatesResult.get(0);
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getProviderId());
    assertEquals("ABC123", getResult.getAccessTokenUri());
    assertEquals(
        "Executing findAllClientRegistrationTemplates", getResult.getClientAuthenticationMethod());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult.getComment());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult.getHelpLink());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult.getJwkSetUri());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult.getLoginButtonIcon());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult.getLoginButtonLabel());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult.getUserInfoUri());
    assertEquals("JaneDoe", getResult.getAuthorizationUri());
    assertEquals("janedoe", getResult.getUserNameAttributeName());
    assertEquals(1, getResult.getScope().size());
    assertEquals(1L, getResult.getCreatedTime());
  }

  /**
   * Test {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates()"})
  public void testFindAllClientRegistrationTemplates_thenReturnSizeIsTwo() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setComment(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setCreatedTime(1L);
    oAuth2ClientRegistrationTemplateEntity.setCustomerNamePattern(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setDefaultDashboardName(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientRegistrationTemplateEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientRegistrationTemplateEntity.setHelpLink(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientRegistrationTemplateEntity.setJwkSetUri(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonIcon(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setLoginButtonLabel(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setProviderId("42");
    oAuth2ClientRegistrationTemplateEntity.setScope("Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setTenantNamePattern(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientRegistrationTemplateEntity.setTokenUri("ABC123");
    oAuth2ClientRegistrationTemplateEntity.setType(MapperType.BASIC);
    oAuth2ClientRegistrationTemplateEntity.setUserInfoUri(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientRegistrationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(false);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(",");
    oAuth2ClientRegistrationTemplateEntity2.setComment(",");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(0L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern(",");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName(",");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("john.smith@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("John");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink(",");
    oAuth2ClientRegistrationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri(",");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Smith");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon(",");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel(",");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity2.setScope(",");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern(",");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.EMAIL);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.CUSTOM);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri(",");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName(
        "Executing findAllClientRegistrationTemplates");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientRegistrationTemplateEntity> oAuth2ClientRegistrationTemplateEntityList =
        new ArrayList<>();
    oAuth2ClientRegistrationTemplateEntityList.add(oAuth2ClientRegistrationTemplateEntity2);
    oAuth2ClientRegistrationTemplateEntityList.add(oAuth2ClientRegistrationTemplateEntity);

    OAuth2ClientRegistrationTemplateRepository repository =
        mock(OAuth2ClientRegistrationTemplateRepository.class);
    when(repository.findAll()).thenReturn(oAuth2ClientRegistrationTemplateEntityList);
    JpaOAuth2ClientRegistrationTemplateDao clientRegistrationTemplateDao =
        new JpaOAuth2ClientRegistrationTemplateDao(repository);
    OAuth2ConfigTemplateServiceImpl oAuth2ConfigTemplateServiceImpl =
        new OAuth2ConfigTemplateServiceImpl(
            clientRegistrationTemplateDao, new ClientRegistrationTemplateDataValidator());

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllClientRegistrationTemplatesResult =
        oAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates();

    // Assert
    verify(repository).findAll();
    assertEquals(2, actualFindAllClientRegistrationTemplatesResult.size());
    OAuth2ClientRegistrationTemplate getResult =
        actualFindAllClientRegistrationTemplatesResult.get(0);
    assertEquals(",", getResult.getClientAuthenticationMethod());
    assertEquals(",", getResult.getComment());
    assertEquals(",", getResult.getHelpLink());
    assertEquals(",", getResult.getJwkSetUri());
    assertEquals(",", getResult.getLoginButtonIcon());
    assertEquals(",", getResult.getLoginButtonLabel());
    assertEquals(",", getResult.getUserInfoUri());
    OAuth2ClientRegistrationTemplate getResult2 =
        actualFindAllClientRegistrationTemplatesResult.get(1);
    assertEquals("42", getResult2.getName());
    assertEquals("42", getResult2.getProviderId());
    assertEquals("ABC123", getResult2.getAccessTokenUri());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult.getAccessTokenUri());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult.getAuthorizationUri());
    assertEquals(
        "Executing findAllClientRegistrationTemplates", getResult2.getClientAuthenticationMethod());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult2.getComment());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult2.getHelpLink());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult2.getJwkSetUri());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult2.getLoginButtonIcon());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult2.getLoginButtonLabel());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult.getName());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult.getProviderId());
    assertEquals("Executing findAllClientRegistrationTemplates", getResult2.getUserInfoUri());
    assertEquals(
        "Executing findAllClientRegistrationTemplates", getResult.getUserNameAttributeName());
    assertEquals("JaneDoe", getResult2.getAuthorizationUri());
    assertEquals("janedoe", getResult2.getUserNameAttributeName());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, getResult2.getScope().size());
    assertEquals(1L, getResult2.getCreatedTime());
    assertTrue(getResult.getScope().isEmpty());
  }

  /**
   * Test {@link OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#findAllClientRegistrationTemplates()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List OAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates()"})
  public void testFindAllClientRegistrationTemplates_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findAllClientRegistrationTemplates");
    when(oAuth2ClientRegistrationTemplateDao.findAll()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> oAuth2ConfigTemplateServiceImpl.findAllClientRegistrationTemplates());
    verify(oAuth2ClientRegistrationTemplateDao).findAll();
  }

  /**
   * Test {@link
   * OAuth2ConfigTemplateServiceImpl#deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}.
   *
   * <ul>
   *   <li>Then calls {@link OAuth2ClientRegistrationTemplateDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * OAuth2ConfigTemplateServiceImpl#deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void OAuth2ConfigTemplateServiceImpl.deleteClientRegistrationTemplateById(OAuth2ClientRegistrationTemplateId)"
  })
  public void testDeleteClientRegistrationTemplateById_thenCallsRemoveById() {
    // Arrange
    doNothing()
        .when(oAuth2ClientRegistrationTemplateDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    oAuth2ConfigTemplateServiceImpl.deleteClientRegistrationTemplateById(
        new OAuth2ClientRegistrationTemplateId(ModelConstants.NULL_UUID));

    // Assert
    verify(oAuth2ClientRegistrationTemplateDao).removeById(isA(TenantId.class), isA(UUID.class));
  }
}
