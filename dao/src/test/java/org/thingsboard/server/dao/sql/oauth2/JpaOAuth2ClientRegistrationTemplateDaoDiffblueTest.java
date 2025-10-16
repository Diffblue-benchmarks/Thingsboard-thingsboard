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
package org.thingsboard.server.dao.sql.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.OAuth2BasicMapperConfig;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientRegistrationTemplate;
import org.thingsboard.server.common.data.oauth2.OAuth2MapperConfig;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.OAuth2ClientRegistrationTemplateEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaOAuth2ClientRegistrationTemplateDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaOAuth2ClientRegistrationTemplateDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaOAuth2ClientRegistrationTemplateDao jpaOAuth2ClientRegistrationTemplateDao;

  @MockBean
  private OAuth2ClientRegistrationTemplateRepository oAuth2ClientRegistrationTemplateRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaOAuth2ClientRegistrationTemplateDao#getEntityClass()}
   *   <li>{@link JpaOAuth2ClientRegistrationTemplateDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaOAuth2ClientRegistrationTemplateDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaOAuth2ClientRegistrationTemplateDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaOAuth2ClientRegistrationTemplateDao jpaOAuth2ClientRegistrationTemplateDao =
        new JpaOAuth2ClientRegistrationTemplateDao(
            mock(OAuth2ClientRegistrationTemplateRepository.class));

    // Act
    Class<OAuth2ClientRegistrationTemplateEntity> actualEntityClass =
        jpaOAuth2ClientRegistrationTemplateDao.getEntityClass();
    jpaOAuth2ClientRegistrationTemplateDao.getRepository();

    // Assert
    Class<OAuth2ClientRegistrationTemplateEntity> expectedEntityClass =
        OAuth2ClientRegistrationTemplateEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaOAuth2ClientRegistrationTemplateDao#findByProviderId(String)}.
   *
   * <ul>
   *   <li>Then {@link Optional#get()} AdditionalInfo return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientRegistrationTemplateDao#findByProviderId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional JpaOAuth2ClientRegistrationTemplateDao.findByProviderId(String)"})
  public void testFindByProviderId_thenGetAdditionalInfoReturnObjectNode() {
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
    when(oAuth2ClientRegistrationTemplateRepository.findByProviderId(Mockito.<String>any()))
        .thenReturn(oAuth2ClientRegistrationTemplateEntity);

    // Act
    Optional<OAuth2ClientRegistrationTemplate> actualFindByProviderIdResult =
        jpaOAuth2ClientRegistrationTemplateDao.findByProviderId("42");

    // Assert
    verify(oAuth2ClientRegistrationTemplateRepository).findByProviderId("42");
    OAuth2ClientRegistrationTemplate getResult = actualFindByProviderIdResult.get();
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
    assertTrue(actualFindByProviderIdResult.isPresent());
  }

  /**
   * Test {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientRegistrationTemplateDao.findAll()"})
  public void testFindAll_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRegistrationTemplateRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllResult =
        jpaOAuth2ClientRegistrationTemplateDao.findAll();

    // Assert
    verify(oAuth2ClientRegistrationTemplateRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientRegistrationTemplateDao.findAll()"})
  public void testFindAll_thenReturnSizeIsOne() {
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

    ArrayList<OAuth2ClientRegistrationTemplateEntity> oAuth2ClientRegistrationTemplateEntityList =
        new ArrayList<>();
    oAuth2ClientRegistrationTemplateEntityList.add(oAuth2ClientRegistrationTemplateEntity);
    when(oAuth2ClientRegistrationTemplateRepository.findAll())
        .thenReturn(oAuth2ClientRegistrationTemplateEntityList);

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllResult =
        jpaOAuth2ClientRegistrationTemplateDao.findAll();

    // Assert
    verify(oAuth2ClientRegistrationTemplateRepository).findAll();
    assertEquals(1, actualFindAllResult.size());
    OAuth2ClientRegistrationTemplate getResult = actualFindAllResult.get(0);
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getProviderId());
    assertEquals("ABC123", getResult.getAccessTokenUri());
    OAuth2MapperConfig mapperConfig = getResult.getMapperConfig();
    OAuth2BasicMapperConfig basic = mapperConfig.getBasic();
    assertEquals("Doe", basic.getLastNameAttributeKey());
    assertEquals("Jane", basic.getFirstNameAttributeKey());
    assertEquals("JaneDoe", getResult.getAuthorizationUri());
    assertEquals("jane.doe@example.org", basic.getEmailAttributeKey());
    assertEquals("janedoe", getResult.getUserNameAttributeName());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(MapperType.BASIC, mapperConfig.getType());
    assertEquals(TenantNameStrategyType.DOMAIN, basic.getTenantNameStrategy());
    assertTrue(basic.isAlwaysFullScreen());
  }

  /**
   * Test {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientRegistrationTemplateDao.findAll()"})
  public void testFindAll_thenReturnSizeIsTwo() {
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

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 =
        new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(false);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri(",");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod(
        "Client Authentication Method");
    oAuth2ClientRegistrationTemplateEntity2.setComment("Comment");
    oAuth2ClientRegistrationTemplateEntity2.setCreatedTime(0L);
    oAuth2ClientRegistrationTemplateEntity2.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientRegistrationTemplateEntity2.setEmailAttributeKey("john.smith@example.org");
    oAuth2ClientRegistrationTemplateEntity2.setFirstNameAttributeKey("John");
    oAuth2ClientRegistrationTemplateEntity2.setHelpLink("Help Link");
    oAuth2ClientRegistrationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientRegistrationTemplateEntity2.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientRegistrationTemplateEntity2.setLastNameAttributeKey("Smith");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientRegistrationTemplateEntity2.setLoginButtonLabel("Login Button Label");
    oAuth2ClientRegistrationTemplateEntity2.setProviderId(",");
    oAuth2ClientRegistrationTemplateEntity2.setScope("Scope");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientRegistrationTemplateEntity2.setTenantNameStrategy(TenantNameStrategyType.EMAIL);
    oAuth2ClientRegistrationTemplateEntity2.setTokenUri(",");
    oAuth2ClientRegistrationTemplateEntity2.setType(MapperType.CUSTOM);
    oAuth2ClientRegistrationTemplateEntity2.setUserInfoUri("User Info Uri");
    oAuth2ClientRegistrationTemplateEntity2.setUserNameAttributeName(",");
    oAuth2ClientRegistrationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientRegistrationTemplateEntity> oAuth2ClientRegistrationTemplateEntityList =
        new ArrayList<>();
    oAuth2ClientRegistrationTemplateEntityList.add(oAuth2ClientRegistrationTemplateEntity2);
    oAuth2ClientRegistrationTemplateEntityList.add(oAuth2ClientRegistrationTemplateEntity);
    when(oAuth2ClientRegistrationTemplateRepository.findAll())
        .thenReturn(oAuth2ClientRegistrationTemplateEntityList);

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllResult =
        jpaOAuth2ClientRegistrationTemplateDao.findAll();

    // Assert
    verify(oAuth2ClientRegistrationTemplateRepository).findAll();
    assertEquals(2, actualFindAllResult.size());
    OAuth2ClientRegistrationTemplate getResult = actualFindAllResult.get(0);
    assertEquals(",", getResult.getAccessTokenUri());
    assertEquals(",", getResult.getAuthorizationUri());
    assertEquals(",", getResult.getName());
    assertEquals(",", getResult.getProviderId());
    assertEquals(",", getResult.getUserNameAttributeName());
    OAuth2ClientRegistrationTemplate getResult2 = actualFindAllResult.get(1);
    assertEquals("42", getResult2.getName());
    assertEquals("42", getResult2.getProviderId());
    assertEquals("ABC123", getResult2.getAccessTokenUri());
    assertEquals("Client Authentication Method", getResult2.getClientAuthenticationMethod());
    assertEquals("Comment", getResult2.getComment());
    assertEquals("Help Link", getResult2.getHelpLink());
    assertEquals("JaneDoe", getResult2.getAuthorizationUri());
    assertEquals("Jwk Set Uri", getResult2.getJwkSetUri());
    assertEquals("Login Button Icon", getResult2.getLoginButtonIcon());
    assertEquals("Login Button Label", getResult2.getLoginButtonLabel());
    assertEquals("User Info Uri", getResult2.getUserInfoUri());
    assertEquals("janedoe", getResult2.getUserNameAttributeName());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1L, getResult2.getCreatedTime());
  }
}
