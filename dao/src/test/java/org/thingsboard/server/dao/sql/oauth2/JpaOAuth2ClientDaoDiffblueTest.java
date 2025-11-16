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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.oauth2.MapperType;
import org.thingsboard.server.common.data.oauth2.OAuth2Client;
import org.thingsboard.server.common.data.oauth2.PlatformType;
import org.thingsboard.server.common.data.oauth2.TenantNameStrategyType;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.OAuth2ClientEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaOAuth2ClientDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaOAuth2ClientDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private JpaExecutorService jpaExecutorService;

  @Autowired private JpaOAuth2ClientDao jpaOAuth2ClientDao;

  @MockBean private OAuth2ClientRepository oAuth2ClientRepository;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaOAuth2ClientDao#getEntityClass()}
   *   <li>{@link JpaOAuth2ClientDao#getEntityType()}
   *   <li>{@link JpaOAuth2ClientDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaOAuth2ClientDao.getEntityClass()",
    "EntityType JpaOAuth2ClientDao.getEntityType()",
    "org.springframework.data.jpa.repository.JpaRepository JpaOAuth2ClientDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    JpaOAuth2ClientDao jpaOAuth2ClientDao =
        new JpaOAuth2ClientDao(mock(OAuth2ClientRepository.class));

    // Act
    Class<OAuth2ClientEntity> actualEntityClass = jpaOAuth2ClientDao.getEntityClass();
    EntityType actualEntityType = jpaOAuth2ClientDao.getEntityType();
    jpaOAuth2ClientDao.getRepository();

    // Assert
    assertEquals(EntityType.OAUTH2_CLIENT, actualEntityType);
    Class<OAuth2ClientEntity> expectedEntityClass = OAuth2ClientEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaOAuth2ClientDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(oAuth2ClientRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<OAuth2Client> actualFindByTenantIdResult =
        jpaOAuth2ClientDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(oAuth2ClientRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>Then return Data size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaOAuth2ClientDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_thenReturnDataSizeIsTwo() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(1L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms(",");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("Authorization Uri");
    oAuth2ClientEntity2.setClientAuthenticationMethod("");
    oAuth2ClientEntity2.setClientId("Client Id");
    oAuth2ClientEntity2.setClientSecret("");
    oAuth2ClientEntity2.setCreatedTime(-1L);
    oAuth2ClientEntity2.setCustomerNamePattern("");
    oAuth2ClientEntity2.setDefaultDashboardName("");
    oAuth2ClientEntity2.setEmailAttributeKey("john.smith@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("John");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("");
    oAuth2ClientEntity2.setLastNameAttributeKey("Smith");
    oAuth2ClientEntity2.setLoginButtonIcon("");
    oAuth2ClientEntity2.setLoginButtonLabel("");
    oAuth2ClientEntity2.setPassword("Password");
    oAuth2ClientEntity2.setPlatforms("");
    oAuth2ClientEntity2.setScope("");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.EMAIL);
    oAuth2ClientEntity2.setTitle("Mr");
    oAuth2ClientEntity2.setTokenUri("Token Uri");
    oAuth2ClientEntity2.setType(MapperType.CUSTOM);
    oAuth2ClientEntity2.setUrl("Url");
    oAuth2ClientEntity2.setUserInfoUri("");
    oAuth2ClientEntity2.setUserNameAttributeName("User Name Attribute Name");
    oAuth2ClientEntity2.setUsername("Username");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientEntity> content = new ArrayList<>();
    content.add(oAuth2ClientEntity2);
    content.addAll(new ArrayList<>());
    content.add(oAuth2ClientEntity);
    when(oAuth2ClientRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<OAuth2Client> actualFindByTenantIdResult =
        jpaOAuth2ClientDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(oAuth2ClientRepository)
        .findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(2, actualFindByTenantIdResult.getData().size());
    assertEquals(2L, actualFindByTenantIdResult.getTotalElements());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByTenantId(UUID, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaOAuth2ClientDao.findByTenantId(UUID, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(oAuth2ClientRepository.findByTenantId(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<OAuth2Client> actualFindByTenantIdResult =
        jpaOAuth2ClientDao.findByTenantId(
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(oAuth2ClientRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findEnabledByDomainName(String)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findEnabledByDomainName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findEnabledByDomainName(String)"})
  public void testFindEnabledByDomainName_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findEnabledByDomainNameAndPlatformType(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindEnabledByDomainNameResult =
        jpaOAuth2ClientDao.findEnabledByDomainName("Domain Name");

    // Assert
    verify(oAuth2ClientRepository).findEnabledByDomainNameAndPlatformType("Domain Name", "WEB");
    assertTrue(actualFindEnabledByDomainNameResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findEnabledByDomainName(String)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findEnabledByDomainName(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findEnabledByDomainName(String)"})
  public void testFindEnabledByDomainName_thenReturnSizeIsOne() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("Authorization Uri");
    oAuth2ClientEntity.setClientAuthenticationMethod("");
    oAuth2ClientEntity.setClientId("Client Id");
    oAuth2ClientEntity.setClientSecret("");
    oAuth2ClientEntity.setCreatedTime(-1L);
    oAuth2ClientEntity.setCustomerNamePattern("");
    oAuth2ClientEntity.setDefaultDashboardName("");
    oAuth2ClientEntity.setEmailAttributeKey("john.smith@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("John");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("");
    oAuth2ClientEntity.setLastNameAttributeKey("Smith");
    oAuth2ClientEntity.setLoginButtonIcon("");
    oAuth2ClientEntity.setLoginButtonLabel("");
    oAuth2ClientEntity.setPassword("Password");
    oAuth2ClientEntity.setPlatforms("");
    oAuth2ClientEntity.setScope("");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.EMAIL);
    oAuth2ClientEntity.setTitle("Mr");
    oAuth2ClientEntity.setTokenUri("Token Uri");
    oAuth2ClientEntity.setType(MapperType.CUSTOM);
    oAuth2ClientEntity.setUrl("Url");
    oAuth2ClientEntity.setUserInfoUri("");
    oAuth2ClientEntity.setUserNameAttributeName("User Name Attribute Name");
    oAuth2ClientEntity.setUsername("Username");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientEntity> oAuth2ClientEntityList = new ArrayList<>();
    oAuth2ClientEntityList.add(oAuth2ClientEntity);
    oAuth2ClientEntityList.addAll(new ArrayList<>());
    when(oAuth2ClientRepository.findEnabledByDomainNameAndPlatformType(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(oAuth2ClientEntityList);

    // Act
    List<OAuth2Client> actualFindEnabledByDomainNameResult =
        jpaOAuth2ClientDao.findEnabledByDomainName("Domain Name");

    // Assert
    verify(oAuth2ClientRepository).findEnabledByDomainNameAndPlatformType("Domain Name", "WEB");
    assertEquals(1, actualFindEnabledByDomainNameResult.size());
    OAuth2Client getResult = actualFindEnabledByDomainNameResult.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("", getResult.getClientAuthenticationMethod());
    assertEquals("", getResult.getClientSecret());
    assertEquals("", getResult.getJwkSetUri());
    assertEquals("", getResult.getLoginButtonIcon());
    assertEquals("", getResult.getLoginButtonLabel());
    assertEquals("", getResult.getUserInfoUri());
    assertEquals("Authorization Uri", getResult.getAuthorizationUri());
    assertEquals("Client Id", getResult.getClientId());
    assertEquals("Mr", getResult.getName());
    assertEquals("Mr", getResult.getTitle());
    assertEquals("Token Uri", getResult.getAccessTokenUri());
    assertEquals("User Name Attribute Name", getResult.getUserNameAttributeName());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, getResult.getScope().size());
    assertTrue(getResult.getPlatforms().isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String, PlatformType)}.
   *
   * <ul>
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String,
   * PlatformType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaOAuth2ClientDao.findEnabledByPkgNameAndPlatformType(String, PlatformType)"
  })
  public void testFindEnabledByPkgNameAndPlatformType_thenReturnSizeIsTwo() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientEntity.setClientAuthenticationMethod("Client Authentication Method");
    oAuth2ClientEntity.setClientId("42");
    oAuth2ClientEntity.setClientSecret("Client Secret");
    oAuth2ClientEntity.setCreatedTime(2L);
    oAuth2ClientEntity.setCustomerNamePattern("Customer Name Pattern");
    oAuth2ClientEntity.setDefaultDashboardName("Default Dashboard Name");
    oAuth2ClientEntity.setEmailAttributeKey("jane.doe@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("Jane");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("Jwk Set Uri");
    oAuth2ClientEntity.setLastNameAttributeKey("Doe");
    oAuth2ClientEntity.setLoginButtonIcon("Login Button Icon");
    oAuth2ClientEntity.setLoginButtonLabel("Login Button Label");
    oAuth2ClientEntity.setPassword("iloveyou");
    oAuth2ClientEntity.setPlatforms(",");
    oAuth2ClientEntity.setScope("Scope");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("Tenant Name Pattern");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.DOMAIN);
    oAuth2ClientEntity.setTitle("Dr");
    oAuth2ClientEntity.setTokenUri("ABC123");
    oAuth2ClientEntity.setType(MapperType.BASIC);
    oAuth2ClientEntity.setUrl("https://example.org/example");
    oAuth2ClientEntity.setUserInfoUri("User Info Uri");
    oAuth2ClientEntity.setUserNameAttributeName("janedoe");
    oAuth2ClientEntity.setUsername("janedoe");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientEntity oAuth2ClientEntity2 = new OAuth2ClientEntity();
    oAuth2ClientEntity2.setActivateUser(true);
    oAuth2ClientEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity2.setAllowUserCreation(true);
    oAuth2ClientEntity2.setAlwaysFullScreen(true);
    oAuth2ClientEntity2.setAuthorizationUri("Authorization Uri");
    oAuth2ClientEntity2.setClientAuthenticationMethod("");
    oAuth2ClientEntity2.setClientId("Client Id");
    oAuth2ClientEntity2.setClientSecret("");
    oAuth2ClientEntity2.setCreatedTime(-1L);
    oAuth2ClientEntity2.setCustomerNamePattern("");
    oAuth2ClientEntity2.setDefaultDashboardName("");
    oAuth2ClientEntity2.setEmailAttributeKey("john.smith@example.org");
    oAuth2ClientEntity2.setFirstNameAttributeKey("John");
    oAuth2ClientEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setJwkSetUri("");
    oAuth2ClientEntity2.setLastNameAttributeKey("Smith");
    oAuth2ClientEntity2.setLoginButtonIcon("");
    oAuth2ClientEntity2.setLoginButtonLabel("");
    oAuth2ClientEntity2.setPassword("Password");
    oAuth2ClientEntity2.setPlatforms("");
    oAuth2ClientEntity2.setScope("");
    oAuth2ClientEntity2.setSendToken(true);
    oAuth2ClientEntity2.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity2.setTenantNamePattern("");
    oAuth2ClientEntity2.setTenantNameStrategy(TenantNameStrategyType.EMAIL);
    oAuth2ClientEntity2.setTitle("Mr");
    oAuth2ClientEntity2.setTokenUri("Token Uri");
    oAuth2ClientEntity2.setType(MapperType.CUSTOM);
    oAuth2ClientEntity2.setUrl("Url");
    oAuth2ClientEntity2.setUserInfoUri("");
    oAuth2ClientEntity2.setUserNameAttributeName("User Name Attribute Name");
    oAuth2ClientEntity2.setUsername("Username");
    oAuth2ClientEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientEntity> oAuth2ClientEntityList = new ArrayList<>();
    oAuth2ClientEntityList.add(oAuth2ClientEntity2);
    oAuth2ClientEntityList.addAll(new ArrayList<>());
    oAuth2ClientEntityList.add(oAuth2ClientEntity);
    when(oAuth2ClientRepository.findEnabledByPkgNameAndPlatformType(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(oAuth2ClientEntityList);

    // Act
    List<OAuth2Client> actualFindEnabledByPkgNameAndPlatformTypeResult =
        jpaOAuth2ClientDao.findEnabledByPkgNameAndPlatformType("Pkg Name", PlatformType.WEB);

    // Assert
    verify(oAuth2ClientRepository).findEnabledByPkgNameAndPlatformType("Pkg Name", "WEB");
    assertEquals(2, actualFindEnabledByPkgNameAndPlatformTypeResult.size());
    OAuth2Client getResult = actualFindEnabledByPkgNameAndPlatformTypeResult.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof ObjectNode);
    assertEquals("", getResult.getClientAuthenticationMethod());
    assertEquals("", getResult.getClientSecret());
    assertEquals("", getResult.getJwkSetUri());
    assertEquals("", getResult.getLoginButtonIcon());
    assertEquals("", getResult.getLoginButtonLabel());
    assertEquals("", getResult.getUserInfoUri());
    OAuth2Client getResult2 = actualFindEnabledByPkgNameAndPlatformTypeResult.get(1);
    assertEquals("42", getResult2.getClientId());
    assertEquals("ABC123", getResult2.getAccessTokenUri());
    assertEquals("Authorization Uri", getResult.getAuthorizationUri());
    assertEquals("Client Authentication Method", getResult2.getClientAuthenticationMethod());
    assertEquals("Client Id", getResult.getClientId());
    assertEquals("Client Secret", getResult2.getClientSecret());
    assertEquals("Dr", getResult2.getName());
    assertEquals("Dr", getResult2.getTitle());
    assertEquals("JaneDoe", getResult2.getAuthorizationUri());
    assertEquals("Jwk Set Uri", getResult2.getJwkSetUri());
    assertEquals("Login Button Icon", getResult2.getLoginButtonIcon());
    assertEquals("Login Button Label", getResult2.getLoginButtonLabel());
    assertEquals("Mr", getResult.getName());
    assertEquals("Mr", getResult.getTitle());
    assertEquals("Token Uri", getResult.getAccessTokenUri());
    assertEquals("User Info Uri", getResult2.getUserInfoUri());
    assertEquals("User Name Attribute Name", getResult.getUserNameAttributeName());
    assertEquals("janedoe", getResult2.getUserNameAttributeName());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, getResult.getScope().size());
    assertEquals(1, getResult2.getScope().size());
    assertEquals(2L, getResult2.getCreatedTime());
    assertTrue(getResult.getPlatforms().isEmpty());
    assertTrue(getResult2.getPlatforms().isEmpty());
    assertSame(additionalInfo, getResult2.getAdditionalInfo());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String, PlatformType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String,
   * PlatformType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaOAuth2ClientDao.findEnabledByPkgNameAndPlatformType(String, PlatformType)"
  })
  public void testFindEnabledByPkgNameAndPlatformType_whenNull_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findEnabledByPkgNameAndPlatformType(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindEnabledByPkgNameAndPlatformTypeResult =
        jpaOAuth2ClientDao.findEnabledByPkgNameAndPlatformType("Pkg Name", null);

    // Assert
    verify(oAuth2ClientRepository).findEnabledByPkgNameAndPlatformType("Pkg Name", null);
    assertTrue(actualFindEnabledByPkgNameAndPlatformTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String, PlatformType)}.
   *
   * <ul>
   *   <li>When {@code WEB}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String,
   * PlatformType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List JpaOAuth2ClientDao.findEnabledByPkgNameAndPlatformType(String, PlatformType)"
  })
  public void testFindEnabledByPkgNameAndPlatformType_whenWeb_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findEnabledByPkgNameAndPlatformType(
            Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindEnabledByPkgNameAndPlatformTypeResult =
        jpaOAuth2ClientDao.findEnabledByPkgNameAndPlatformType("Pkg Name", PlatformType.WEB);

    // Assert
    verify(oAuth2ClientRepository).findEnabledByPkgNameAndPlatformType("Pkg Name", "WEB");
    assertTrue(actualFindEnabledByPkgNameAndPlatformTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByDomainId(UUID)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByDomainId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findByDomainId(UUID)"})
  public void testFindByDomainId_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findByDomainId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindByDomainIdResult =
        jpaOAuth2ClientDao.findByDomainId(ModelConstants.NULL_UUID);

    // Assert
    verify(oAuth2ClientRepository).findByDomainId(isA(UUID.class));
    assertTrue(actualFindByDomainIdResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByDomainId(UUID)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByDomainId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findByDomainId(UUID)"})
  public void testFindByDomainId_thenReturnSizeIsOne() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("Authorization Uri");
    oAuth2ClientEntity.setClientAuthenticationMethod("");
    oAuth2ClientEntity.setClientId("Client Id");
    oAuth2ClientEntity.setClientSecret("");
    oAuth2ClientEntity.setCreatedTime(-1L);
    oAuth2ClientEntity.setCustomerNamePattern("");
    oAuth2ClientEntity.setDefaultDashboardName("");
    oAuth2ClientEntity.setEmailAttributeKey("john.smith@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("John");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("");
    oAuth2ClientEntity.setLastNameAttributeKey("Smith");
    oAuth2ClientEntity.setLoginButtonIcon("");
    oAuth2ClientEntity.setLoginButtonLabel("");
    oAuth2ClientEntity.setPassword("Password");
    oAuth2ClientEntity.setPlatforms("");
    oAuth2ClientEntity.setScope("");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.EMAIL);
    oAuth2ClientEntity.setTitle("Mr");
    oAuth2ClientEntity.setTokenUri("Token Uri");
    oAuth2ClientEntity.setType(MapperType.CUSTOM);
    oAuth2ClientEntity.setUrl("Url");
    oAuth2ClientEntity.setUserInfoUri("");
    oAuth2ClientEntity.setUserNameAttributeName("User Name Attribute Name");
    oAuth2ClientEntity.setUsername("Username");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientEntity> oAuth2ClientEntityList = new ArrayList<>();
    oAuth2ClientEntityList.add(oAuth2ClientEntity);
    oAuth2ClientEntityList.addAll(new ArrayList<>());
    when(oAuth2ClientRepository.findByDomainId(Mockito.<UUID>any()))
        .thenReturn(oAuth2ClientEntityList);
    UUID oauth2ParamsId = ModelConstants.NULL_UUID;

    // Act
    List<OAuth2Client> actualFindByDomainIdResult =
        jpaOAuth2ClientDao.findByDomainId(oauth2ParamsId);

    // Assert
    verify(oAuth2ClientRepository).findByDomainId(isA(UUID.class));
    assertEquals(1, actualFindByDomainIdResult.size());
    OAuth2Client getResult = actualFindByDomainIdResult.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("", getResult.getClientAuthenticationMethod());
    assertEquals("", getResult.getClientSecret());
    assertEquals("", getResult.getJwkSetUri());
    assertEquals("", getResult.getLoginButtonIcon());
    assertEquals("", getResult.getLoginButtonLabel());
    assertEquals("", getResult.getUserInfoUri());
    assertEquals("Authorization Uri", getResult.getAuthorizationUri());
    assertEquals("Client Id", getResult.getClientId());
    assertEquals("Mr", getResult.getName());
    assertEquals("Mr", getResult.getTitle());
    assertEquals("Token Uri", getResult.getAccessTokenUri());
    assertEquals("User Name Attribute Name", getResult.getUserNameAttributeName());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, getResult.getScope().size());
    assertTrue(getResult.getPlatforms().isEmpty());
    assertSame(oauth2ParamsId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByMobileAppId(UUID)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByMobileAppId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findByMobileAppId(UUID)"})
  public void testFindByMobileAppId_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findByMobileAppId(Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindByMobileAppIdResult =
        jpaOAuth2ClientDao.findByMobileAppId(ModelConstants.NULL_UUID);

    // Assert
    verify(oAuth2ClientRepository).findByMobileAppId(isA(UUID.class));
    assertTrue(actualFindByMobileAppIdResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByMobileAppId(UUID)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByMobileAppId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findByMobileAppId(UUID)"})
  public void testFindByMobileAppId_thenReturnSizeIsOne() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(true);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(true);
    oAuth2ClientEntity.setAlwaysFullScreen(true);
    oAuth2ClientEntity.setAuthorizationUri("Authorization Uri");
    oAuth2ClientEntity.setClientAuthenticationMethod("");
    oAuth2ClientEntity.setClientId("Client Id");
    oAuth2ClientEntity.setClientSecret("");
    oAuth2ClientEntity.setCreatedTime(-1L);
    oAuth2ClientEntity.setCustomerNamePattern("");
    oAuth2ClientEntity.setDefaultDashboardName("");
    oAuth2ClientEntity.setEmailAttributeKey("john.smith@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("John");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("");
    oAuth2ClientEntity.setLastNameAttributeKey("Smith");
    oAuth2ClientEntity.setLoginButtonIcon("");
    oAuth2ClientEntity.setLoginButtonLabel("");
    oAuth2ClientEntity.setPassword("Password");
    oAuth2ClientEntity.setPlatforms("");
    oAuth2ClientEntity.setScope("");
    oAuth2ClientEntity.setSendToken(true);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.EMAIL);
    oAuth2ClientEntity.setTitle("Mr");
    oAuth2ClientEntity.setTokenUri("Token Uri");
    oAuth2ClientEntity.setType(MapperType.CUSTOM);
    oAuth2ClientEntity.setUrl("Url");
    oAuth2ClientEntity.setUserInfoUri("");
    oAuth2ClientEntity.setUserNameAttributeName("User Name Attribute Name");
    oAuth2ClientEntity.setUsername("Username");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientEntity> oAuth2ClientEntityList = new ArrayList<>();
    oAuth2ClientEntityList.add(oAuth2ClientEntity);
    oAuth2ClientEntityList.addAll(new ArrayList<>());
    when(oAuth2ClientRepository.findByMobileAppId(Mockito.<UUID>any()))
        .thenReturn(oAuth2ClientEntityList);
    UUID mobileAppId = ModelConstants.NULL_UUID;

    // Act
    List<OAuth2Client> actualFindByMobileAppIdResult =
        jpaOAuth2ClientDao.findByMobileAppId(mobileAppId);

    // Assert
    verify(oAuth2ClientRepository).findByMobileAppId(isA(UUID.class));
    assertEquals(1, actualFindByMobileAppIdResult.size());
    OAuth2Client getResult = actualFindByMobileAppIdResult.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("", getResult.getClientAuthenticationMethod());
    assertEquals("", getResult.getClientSecret());
    assertEquals("", getResult.getJwkSetUri());
    assertEquals("", getResult.getLoginButtonIcon());
    assertEquals("", getResult.getLoginButtonLabel());
    assertEquals("", getResult.getUserInfoUri());
    assertEquals("Authorization Uri", getResult.getAuthorizationUri());
    assertEquals("Client Id", getResult.getClientId());
    assertEquals("Mr", getResult.getName());
    assertEquals("Mr", getResult.getTitle());
    assertEquals("Token Uri", getResult.getAccessTokenUri());
    assertEquals("User Name Attribute Name", getResult.getUserNameAttributeName());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1, getResult.getScope().size());
    assertTrue(getResult.getPlatforms().isEmpty());
    assertSame(mobileAppId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findAppSecret(UUID, String)}.
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findAppSecret(UUID, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JpaOAuth2ClientDao.findAppSecret(UUID, String)"})
  public void testFindAppSecret() {
    // Arrange
    when(oAuth2ClientRepository.findAppSecret(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn("App Secret");

    // Act
    String actualFindAppSecretResult =
        jpaOAuth2ClientDao.findAppSecret(ModelConstants.NULL_UUID, "Pkg Name");

    // Assert
    verify(oAuth2ClientRepository).findAppSecret(isA(UUID.class), eq("Pkg Name"));
    assertEquals("App Secret", actualFindAppSecretResult);
  }

  /**
   * Test {@link JpaOAuth2ClientDao#deleteByTenantId(UUID)}.
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#deleteByTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaOAuth2ClientDao.deleteByTenantId(UUID)"})
  public void testDeleteByTenantId() {
    // Arrange
    doNothing().when(oAuth2ClientRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaOAuth2ClientDao.deleteByTenantId(ModelConstants.NULL_UUID);

    // Assert
    verify(oAuth2ClientRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByIds(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByIds(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findByIds(UUID, List)"})
  public void testFindByIds_givenNull_whenArrayListAddNull_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(null);

    // Act
    List<OAuth2Client> actualFindByIdsResult =
        jpaOAuth2ClientDao.findByIds(ModelConstants.NULL_UUID, oAuth2ClientIds);

    // Assert
    verify(oAuth2ClientRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByIds(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientEntity#OAuth2ClientEntity()} ActivateUser is {@code false}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByIds(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findByIds(UUID, List)"})
  public void testFindByIds_givenOAuth2ClientEntityActivateUserIsFalse_thenReturnSizeIsOne() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = new OAuth2ClientEntity();
    oAuth2ClientEntity.setActivateUser(false);
    oAuth2ClientEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientEntity.setAllowUserCreation(false);
    oAuth2ClientEntity.setAlwaysFullScreen(false);
    oAuth2ClientEntity.setAuthorizationUri("Authorization Uri");
    oAuth2ClientEntity.setClientAuthenticationMethod("");
    oAuth2ClientEntity.setClientId("Client Id");
    oAuth2ClientEntity.setClientSecret("");
    oAuth2ClientEntity.setCreatedTime(2L);
    oAuth2ClientEntity.setCustomerNamePattern("");
    oAuth2ClientEntity.setDefaultDashboardName("");
    oAuth2ClientEntity.setEmailAttributeKey("john.smith@example.org");
    oAuth2ClientEntity.setFirstNameAttributeKey("John");
    oAuth2ClientEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setJwkSetUri("");
    oAuth2ClientEntity.setLastNameAttributeKey("Smith");
    oAuth2ClientEntity.setLoginButtonIcon("");
    oAuth2ClientEntity.setLoginButtonLabel("");
    oAuth2ClientEntity.setPassword("Password");
    oAuth2ClientEntity.setPlatforms("");
    oAuth2ClientEntity.setScope("");
    oAuth2ClientEntity.setSendToken(false);
    oAuth2ClientEntity.setTenantId(ModelConstants.NULL_UUID);
    oAuth2ClientEntity.setTenantNamePattern("");
    oAuth2ClientEntity.setTenantNameStrategy(TenantNameStrategyType.EMAIL);
    oAuth2ClientEntity.setTitle("Mr");
    oAuth2ClientEntity.setTokenUri("Token Uri");
    oAuth2ClientEntity.setType(MapperType.CUSTOM);
    oAuth2ClientEntity.setUrl("Url");
    oAuth2ClientEntity.setUserInfoUri("");
    oAuth2ClientEntity.setUserNameAttributeName("User Name Attribute Name");
    oAuth2ClientEntity.setUsername("Username");
    oAuth2ClientEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientEntity> oAuth2ClientEntityList = new ArrayList<>();
    oAuth2ClientEntityList.add(oAuth2ClientEntity);
    when(oAuth2ClientRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(oAuth2ClientEntityList);
    UUID tenantId = ModelConstants.NULL_UUID;

    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(oAuth2ClientId);

    // Act
    List<OAuth2Client> actualFindByIdsResult =
        jpaOAuth2ClientDao.findByIds(tenantId, oAuth2ClientIds);

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByIdsResult.size());
    OAuth2Client getResult = actualFindByIdsResult.get(0);
    assertTrue(getResult.getAdditionalInfo() instanceof ObjectNode);
    assertEquals("", getResult.getClientAuthenticationMethod());
    assertEquals("", getResult.getClientSecret());
    assertEquals("", getResult.getJwkSetUri());
    assertEquals("", getResult.getLoginButtonIcon());
    assertEquals("", getResult.getLoginButtonLabel());
    assertEquals("", getResult.getUserInfoUri());
    assertEquals("Authorization Uri", getResult.getAuthorizationUri());
    assertEquals("Client Id", getResult.getClientId());
    assertEquals("Mr", getResult.getName());
    assertEquals("Mr", getResult.getTitle());
    assertEquals("Token Uri", getResult.getAccessTokenUri());
    assertEquals("User Name Attribute Name", getResult.getUserNameAttributeName());
    assertEquals(1, getResult.getScope().size());
    assertEquals(2L, getResult.getCreatedTime());
    assertTrue(getResult.getPlatforms().isEmpty());
    assertSame(tenantId, getResult.getUuidId());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByIds(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientId} {@link OAuth2ClientId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link OAuth2ClientId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByIds(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findByIds(UUID, List)"})
  public void testFindByIds_givenOAuth2ClientIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(oAuth2ClientRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    OAuth2ClientId oAuth2ClientId = mock(OAuth2ClientId.class);
    when(oAuth2ClientId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(oAuth2ClientId);

    // Act
    List<OAuth2Client> actualFindByIdsResult =
        jpaOAuth2ClientDao.findByIds(ModelConstants.NULL_UUID, oAuth2ClientIds);

    // Assert
    verify(oAuth2ClientId).getId();
    verify(oAuth2ClientRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByIds(UUID, List)}.
   *
   * <ul>
   *   <li>Given {@link OAuth2ClientId#OAuth2ClientId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByIds(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findByIds(UUID, List)"})
  public void testFindByIds_givenOAuth2ClientIdWithIdIsNull_uuid() {
    // Arrange
    when(oAuth2ClientRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<OAuth2ClientId> oAuth2ClientIds = new ArrayList<>();
    oAuth2ClientIds.add(new OAuth2ClientId(ModelConstants.NULL_UUID));

    // Act
    List<OAuth2Client> actualFindByIdsResult =
        jpaOAuth2ClientDao.findByIds(ModelConstants.NULL_UUID, oAuth2ClientIds);

    // Assert
    verify(oAuth2ClientRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByIds(UUID, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#findByIds(UUID, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaOAuth2ClientDao.findByIds(UUID, List)"})
  public void testFindByIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findByTenantIdAndIdIn(
            Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindByIdsResult =
        jpaOAuth2ClientDao.findByIds(ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(oAuth2ClientRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#isPropagateToEdge(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#isPropagateToEdge(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaOAuth2ClientDao.isPropagateToEdge(TenantId, UUID)"})
  public void testIsPropagateToEdge_givenNull_uuid_thenReturnTrue() {
    // Arrange
    when(oAuth2ClientRepository.isPropagateToEdge(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsPropagateToEdgeResult =
        jpaOAuth2ClientDao.isPropagateToEdge(tenantId, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantId).getId();
    verify(oAuth2ClientRepository).isPropagateToEdge(isA(UUID.class), isA(UUID.class));
    assertTrue(actualIsPropagateToEdgeResult);
  }

  /**
   * Test {@link JpaOAuth2ClientDao#isPropagateToEdge(TenantId, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#isPropagateToEdge(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaOAuth2ClientDao.isPropagateToEdge(TenantId, UUID)"})
  public void testIsPropagateToEdge_thenReturnFalse() {
    // Arrange
    when(oAuth2ClientRepository.isPropagateToEdge(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(false);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualIsPropagateToEdgeResult =
        jpaOAuth2ClientDao.isPropagateToEdge(tenantId, ModelConstants.NULL_UUID);

    // Assert
    verify(tenantId).getId();
    verify(oAuth2ClientRepository).isPropagateToEdge(isA(UUID.class), isA(UUID.class));
    assertFalse(actualIsPropagateToEdgeResult);
  }

  /**
   * Test {@link JpaOAuth2ClientDao#isPropagateToEdge(TenantId, UUID)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JpaOAuth2ClientDao#isPropagateToEdge(TenantId, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JpaOAuth2ClientDao.isPropagateToEdge(TenantId, UUID)"})
  public void testIsPropagateToEdge_whenSystem_tenant_thenReturnTrue() {
    // Arrange
    when(oAuth2ClientRepository.isPropagateToEdge(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(true);

    // Act
    boolean actualIsPropagateToEdgeResult =
        jpaOAuth2ClientDao.isPropagateToEdge(
            ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(oAuth2ClientRepository).isPropagateToEdge(isA(UUID.class), isA(UUID.class));
    assertTrue(actualIsPropagateToEdgeResult);
  }
}
