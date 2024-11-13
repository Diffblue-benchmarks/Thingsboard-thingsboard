package org.thingsboard.server.dao.sql.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
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
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaOAuth2ClientDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaOAuth2ClientDao jpaOAuth2ClientDao;

  @MockBean
  private OAuth2ClientRepository oAuth2ClientRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaOAuth2ClientDao#getEntityClass()}
   *   <li>{@link JpaOAuth2ClientDao#getEntityType()}
   *   <li>{@link JpaOAuth2ClientDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaOAuth2ClientDao jpaOAuth2ClientDao = new JpaOAuth2ClientDao(mock(OAuth2ClientRepository.class));

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
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(oAuth2ClientRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<OAuth2Client> actualFindByTenantIdResult = jpaOAuth2ClientDao.findByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(oAuth2ClientRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(oAuth2ClientRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<OAuth2Client> actualFindByTenantIdResult = jpaOAuth2ClientDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(oAuth2ClientRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findEnabledByDomainName(String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findEnabledByDomainName(String)}
   */
  @Test
  public void testFindEnabledByDomainName_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findEnabledByDomainNameAndPlatformType(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindEnabledByDomainNameResult = jpaOAuth2ClientDao.findEnabledByDomainName("Domain Name");

    // Assert
    verify(oAuth2ClientRepository).findEnabledByDomainNameAndPlatformType(eq("Domain Name"), eq("WEB"));
    assertTrue(actualFindEnabledByDomainNameResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findEnabledByDomainName(String)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findEnabledByDomainName(String)}
   */
  @Test
  public void testFindEnabledByDomainName_thenReturnSizeIsOne() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = mock(OAuth2ClientEntity.class);
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientEntity.toData()).thenReturn(oAuth2Client);
    doNothing().when(oAuth2ClientEntity).setCreatedTime(anyLong());
    doNothing().when(oAuth2ClientEntity).setId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setActivateUser(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(oAuth2ClientEntity).setAllowUserCreation(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAlwaysFullScreen(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAuthorizationUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientAuthenticationMethod(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientId(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientSecret(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setCustomerNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setDefaultDashboardName(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setEmailAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setFirstNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setJwkSetUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLastNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLoginButtonIcon(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLoginButtonLabel(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setPassword(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setPlatforms(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setScope(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setSendToken(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setTenantNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setTenantNameStrategy(Mockito.<TenantNameStrategyType>any());
    doNothing().when(oAuth2ClientEntity).setTitle(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setTokenUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setType(Mockito.<MapperType>any());
    doNothing().when(oAuth2ClientEntity).setUrl(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUserInfoUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUserNameAttributeName(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUsername(Mockito.<String>any());
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
    oAuth2ClientEntity.setPlatforms("Platforms");
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

    ArrayList<OAuth2ClientEntity> oAuth2ClientEntityList = new ArrayList<>();
    oAuth2ClientEntityList.add(oAuth2ClientEntity);
    when(oAuth2ClientRepository.findEnabledByDomainNameAndPlatformType(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(oAuth2ClientEntityList);

    // Act
    List<OAuth2Client> actualFindEnabledByDomainNameResult = jpaOAuth2ClientDao.findEnabledByDomainName("Domain Name");

    // Assert
    verify(oAuth2ClientEntity).setCreatedTime(eq(1L));
    verify(oAuth2ClientEntity).setId(isA(UUID.class));
    verify(oAuth2ClientEntity).setUuid(isA(UUID.class));
    verify(oAuth2ClientEntity).setActivateUser(eq(true));
    verify(oAuth2ClientEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(oAuth2ClientEntity).setAllowUserCreation(eq(true));
    verify(oAuth2ClientEntity).setAlwaysFullScreen(eq(true));
    verify(oAuth2ClientEntity).setAuthorizationUri(eq("JaneDoe"));
    verify(oAuth2ClientEntity).setClientAuthenticationMethod(eq("Client Authentication Method"));
    verify(oAuth2ClientEntity).setClientId(eq("42"));
    verify(oAuth2ClientEntity).setClientSecret(eq("Client Secret"));
    verify(oAuth2ClientEntity).setCustomerNamePattern(eq("Customer Name Pattern"));
    verify(oAuth2ClientEntity).setDefaultDashboardName(eq("Default Dashboard Name"));
    verify(oAuth2ClientEntity).setEmailAttributeKey(eq("jane.doe@example.org"));
    verify(oAuth2ClientEntity).setFirstNameAttributeKey(eq("Jane"));
    verify(oAuth2ClientEntity).setJwkSetUri(eq("Jwk Set Uri"));
    verify(oAuth2ClientEntity).setLastNameAttributeKey(eq("Doe"));
    verify(oAuth2ClientEntity).setLoginButtonIcon(eq("Login Button Icon"));
    verify(oAuth2ClientEntity).setLoginButtonLabel(eq("Login Button Label"));
    verify(oAuth2ClientEntity).setPassword(eq("iloveyou"));
    verify(oAuth2ClientEntity).setPlatforms(eq("Platforms"));
    verify(oAuth2ClientEntity).setScope(eq("Scope"));
    verify(oAuth2ClientEntity).setSendToken(eq(true));
    verify(oAuth2ClientEntity).setTenantId(isA(UUID.class));
    verify(oAuth2ClientEntity).setTenantNamePattern(eq("Tenant Name Pattern"));
    verify(oAuth2ClientEntity).setTenantNameStrategy(eq(TenantNameStrategyType.DOMAIN));
    verify(oAuth2ClientEntity).setTitle(eq("Dr"));
    verify(oAuth2ClientEntity).setTokenUri(eq("ABC123"));
    verify(oAuth2ClientEntity).setType(eq(MapperType.BASIC));
    verify(oAuth2ClientEntity).setUrl(eq("https://example.org/example"));
    verify(oAuth2ClientEntity).setUserInfoUri(eq("User Info Uri"));
    verify(oAuth2ClientEntity).setUserNameAttributeName(eq("janedoe"));
    verify(oAuth2ClientEntity).setUsername(eq("janedoe"));
    verify(oAuth2ClientEntity).toData();
    verify(oAuth2ClientRepository).findEnabledByDomainNameAndPlatformType(eq("Domain Name"), eq("WEB"));
    assertEquals(1, actualFindEnabledByDomainNameResult.size());
    assertSame(oAuth2Client, actualFindEnabledByDomainNameResult.get(0));
  }

  /**
   * Test
   * {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String, PlatformType)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String, PlatformType)}
   */
  @Test
  public void testFindEnabledByPkgNameAndPlatformType_thenReturnSizeIsOne() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = mock(OAuth2ClientEntity.class);
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientEntity.toData()).thenReturn(oAuth2Client);
    doNothing().when(oAuth2ClientEntity).setCreatedTime(anyLong());
    doNothing().when(oAuth2ClientEntity).setId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setActivateUser(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(oAuth2ClientEntity).setAllowUserCreation(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAlwaysFullScreen(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAuthorizationUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientAuthenticationMethod(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientId(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientSecret(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setCustomerNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setDefaultDashboardName(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setEmailAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setFirstNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setJwkSetUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLastNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLoginButtonIcon(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLoginButtonLabel(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setPassword(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setPlatforms(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setScope(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setSendToken(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setTenantNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setTenantNameStrategy(Mockito.<TenantNameStrategyType>any());
    doNothing().when(oAuth2ClientEntity).setTitle(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setTokenUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setType(Mockito.<MapperType>any());
    doNothing().when(oAuth2ClientEntity).setUrl(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUserInfoUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUserNameAttributeName(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUsername(Mockito.<String>any());
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
    oAuth2ClientEntity.setPlatforms("Platforms");
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

    ArrayList<OAuth2ClientEntity> oAuth2ClientEntityList = new ArrayList<>();
    oAuth2ClientEntityList.add(oAuth2ClientEntity);
    when(oAuth2ClientRepository.findEnabledByPkgNameAndPlatformType(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(oAuth2ClientEntityList);

    // Act
    List<OAuth2Client> actualFindEnabledByPkgNameAndPlatformTypeResult = jpaOAuth2ClientDao
        .findEnabledByPkgNameAndPlatformType("Pkg Name", PlatformType.WEB);

    // Assert
    verify(oAuth2ClientEntity).setCreatedTime(eq(1L));
    verify(oAuth2ClientEntity).setId(isA(UUID.class));
    verify(oAuth2ClientEntity).setUuid(isA(UUID.class));
    verify(oAuth2ClientEntity).setActivateUser(eq(true));
    verify(oAuth2ClientEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(oAuth2ClientEntity).setAllowUserCreation(eq(true));
    verify(oAuth2ClientEntity).setAlwaysFullScreen(eq(true));
    verify(oAuth2ClientEntity).setAuthorizationUri(eq("JaneDoe"));
    verify(oAuth2ClientEntity).setClientAuthenticationMethod(eq("Client Authentication Method"));
    verify(oAuth2ClientEntity).setClientId(eq("42"));
    verify(oAuth2ClientEntity).setClientSecret(eq("Client Secret"));
    verify(oAuth2ClientEntity).setCustomerNamePattern(eq("Customer Name Pattern"));
    verify(oAuth2ClientEntity).setDefaultDashboardName(eq("Default Dashboard Name"));
    verify(oAuth2ClientEntity).setEmailAttributeKey(eq("jane.doe@example.org"));
    verify(oAuth2ClientEntity).setFirstNameAttributeKey(eq("Jane"));
    verify(oAuth2ClientEntity).setJwkSetUri(eq("Jwk Set Uri"));
    verify(oAuth2ClientEntity).setLastNameAttributeKey(eq("Doe"));
    verify(oAuth2ClientEntity).setLoginButtonIcon(eq("Login Button Icon"));
    verify(oAuth2ClientEntity).setLoginButtonLabel(eq("Login Button Label"));
    verify(oAuth2ClientEntity).setPassword(eq("iloveyou"));
    verify(oAuth2ClientEntity).setPlatforms(eq("Platforms"));
    verify(oAuth2ClientEntity).setScope(eq("Scope"));
    verify(oAuth2ClientEntity).setSendToken(eq(true));
    verify(oAuth2ClientEntity).setTenantId(isA(UUID.class));
    verify(oAuth2ClientEntity).setTenantNamePattern(eq("Tenant Name Pattern"));
    verify(oAuth2ClientEntity).setTenantNameStrategy(eq(TenantNameStrategyType.DOMAIN));
    verify(oAuth2ClientEntity).setTitle(eq("Dr"));
    verify(oAuth2ClientEntity).setTokenUri(eq("ABC123"));
    verify(oAuth2ClientEntity).setType(eq(MapperType.BASIC));
    verify(oAuth2ClientEntity).setUrl(eq("https://example.org/example"));
    verify(oAuth2ClientEntity).setUserInfoUri(eq("User Info Uri"));
    verify(oAuth2ClientEntity).setUserNameAttributeName(eq("janedoe"));
    verify(oAuth2ClientEntity).setUsername(eq("janedoe"));
    verify(oAuth2ClientEntity).toData();
    verify(oAuth2ClientRepository).findEnabledByPkgNameAndPlatformType(eq("Pkg Name"), eq("WEB"));
    assertEquals(1, actualFindEnabledByPkgNameAndPlatformTypeResult.size());
    assertSame(oAuth2Client, actualFindEnabledByPkgNameAndPlatformTypeResult.get(0));
  }

  /**
   * Test
   * {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String, PlatformType)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String, PlatformType)}
   */
  @Test
  public void testFindEnabledByPkgNameAndPlatformType_whenNull_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findEnabledByPkgNameAndPlatformType(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindEnabledByPkgNameAndPlatformTypeResult = jpaOAuth2ClientDao
        .findEnabledByPkgNameAndPlatformType("Pkg Name", null);

    // Assert
    verify(oAuth2ClientRepository).findEnabledByPkgNameAndPlatformType(eq("Pkg Name"), isNull());
    assertTrue(actualFindEnabledByPkgNameAndPlatformTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String, PlatformType)}.
   * <ul>
   *   <li>When {@code WEB}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOAuth2ClientDao#findEnabledByPkgNameAndPlatformType(String, PlatformType)}
   */
  @Test
  public void testFindEnabledByPkgNameAndPlatformType_whenWeb_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findEnabledByPkgNameAndPlatformType(Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindEnabledByPkgNameAndPlatformTypeResult = jpaOAuth2ClientDao
        .findEnabledByPkgNameAndPlatformType("Pkg Name", PlatformType.WEB);

    // Assert
    verify(oAuth2ClientRepository).findEnabledByPkgNameAndPlatformType(eq("Pkg Name"), eq("WEB"));
    assertTrue(actualFindEnabledByPkgNameAndPlatformTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByDomainId(UUID)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findByDomainId(UUID)}
   */
  @Test
  public void testFindByDomainId_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findByDomainId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindByDomainIdResult = jpaOAuth2ClientDao.findByDomainId(ModelConstants.NULL_UUID);

    // Assert
    verify(oAuth2ClientRepository).findByDomainId(isA(UUID.class));
    assertTrue(actualFindByDomainIdResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByDomainId(UUID)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findByDomainId(UUID)}
   */
  @Test
  public void testFindByDomainId_thenReturnSizeIsOne() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = mock(OAuth2ClientEntity.class);
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientEntity.toData()).thenReturn(oAuth2Client);
    doNothing().when(oAuth2ClientEntity).setCreatedTime(anyLong());
    doNothing().when(oAuth2ClientEntity).setId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setActivateUser(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(oAuth2ClientEntity).setAllowUserCreation(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAlwaysFullScreen(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAuthorizationUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientAuthenticationMethod(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientId(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientSecret(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setCustomerNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setDefaultDashboardName(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setEmailAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setFirstNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setJwkSetUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLastNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLoginButtonIcon(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLoginButtonLabel(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setPassword(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setPlatforms(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setScope(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setSendToken(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setTenantNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setTenantNameStrategy(Mockito.<TenantNameStrategyType>any());
    doNothing().when(oAuth2ClientEntity).setTitle(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setTokenUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setType(Mockito.<MapperType>any());
    doNothing().when(oAuth2ClientEntity).setUrl(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUserInfoUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUserNameAttributeName(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUsername(Mockito.<String>any());
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
    oAuth2ClientEntity.setPlatforms("Platforms");
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

    ArrayList<OAuth2ClientEntity> oAuth2ClientEntityList = new ArrayList<>();
    oAuth2ClientEntityList.add(oAuth2ClientEntity);
    when(oAuth2ClientRepository.findByDomainId(Mockito.<UUID>any())).thenReturn(oAuth2ClientEntityList);

    // Act
    List<OAuth2Client> actualFindByDomainIdResult = jpaOAuth2ClientDao.findByDomainId(ModelConstants.NULL_UUID);

    // Assert
    verify(oAuth2ClientEntity).setCreatedTime(eq(1L));
    verify(oAuth2ClientEntity).setId(isA(UUID.class));
    verify(oAuth2ClientEntity).setUuid(isA(UUID.class));
    verify(oAuth2ClientEntity).setActivateUser(eq(true));
    verify(oAuth2ClientEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(oAuth2ClientEntity).setAllowUserCreation(eq(true));
    verify(oAuth2ClientEntity).setAlwaysFullScreen(eq(true));
    verify(oAuth2ClientEntity).setAuthorizationUri(eq("JaneDoe"));
    verify(oAuth2ClientEntity).setClientAuthenticationMethod(eq("Client Authentication Method"));
    verify(oAuth2ClientEntity).setClientId(eq("42"));
    verify(oAuth2ClientEntity).setClientSecret(eq("Client Secret"));
    verify(oAuth2ClientEntity).setCustomerNamePattern(eq("Customer Name Pattern"));
    verify(oAuth2ClientEntity).setDefaultDashboardName(eq("Default Dashboard Name"));
    verify(oAuth2ClientEntity).setEmailAttributeKey(eq("jane.doe@example.org"));
    verify(oAuth2ClientEntity).setFirstNameAttributeKey(eq("Jane"));
    verify(oAuth2ClientEntity).setJwkSetUri(eq("Jwk Set Uri"));
    verify(oAuth2ClientEntity).setLastNameAttributeKey(eq("Doe"));
    verify(oAuth2ClientEntity).setLoginButtonIcon(eq("Login Button Icon"));
    verify(oAuth2ClientEntity).setLoginButtonLabel(eq("Login Button Label"));
    verify(oAuth2ClientEntity).setPassword(eq("iloveyou"));
    verify(oAuth2ClientEntity).setPlatforms(eq("Platforms"));
    verify(oAuth2ClientEntity).setScope(eq("Scope"));
    verify(oAuth2ClientEntity).setSendToken(eq(true));
    verify(oAuth2ClientEntity).setTenantId(isA(UUID.class));
    verify(oAuth2ClientEntity).setTenantNamePattern(eq("Tenant Name Pattern"));
    verify(oAuth2ClientEntity).setTenantNameStrategy(eq(TenantNameStrategyType.DOMAIN));
    verify(oAuth2ClientEntity).setTitle(eq("Dr"));
    verify(oAuth2ClientEntity).setTokenUri(eq("ABC123"));
    verify(oAuth2ClientEntity).setType(eq(MapperType.BASIC));
    verify(oAuth2ClientEntity).setUrl(eq("https://example.org/example"));
    verify(oAuth2ClientEntity).setUserInfoUri(eq("User Info Uri"));
    verify(oAuth2ClientEntity).setUserNameAttributeName(eq("janedoe"));
    verify(oAuth2ClientEntity).setUsername(eq("janedoe"));
    verify(oAuth2ClientEntity).toData();
    verify(oAuth2ClientRepository).findByDomainId(isA(UUID.class));
    assertEquals(1, actualFindByDomainIdResult.size());
    assertSame(oAuth2Client, actualFindByDomainIdResult.get(0));
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByMobileAppId(UUID)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findByMobileAppId(UUID)}
   */
  @Test
  public void testFindByMobileAppId_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findByMobileAppId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindByMobileAppIdResult = jpaOAuth2ClientDao.findByMobileAppId(ModelConstants.NULL_UUID);

    // Assert
    verify(oAuth2ClientRepository).findByMobileAppId(isA(UUID.class));
    assertTrue(actualFindByMobileAppIdResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByMobileAppId(UUID)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findByMobileAppId(UUID)}
   */
  @Test
  public void testFindByMobileAppId_thenReturnSizeIsOne() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = mock(OAuth2ClientEntity.class);
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientEntity.toData()).thenReturn(oAuth2Client);
    doNothing().when(oAuth2ClientEntity).setCreatedTime(anyLong());
    doNothing().when(oAuth2ClientEntity).setId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setActivateUser(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(oAuth2ClientEntity).setAllowUserCreation(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAlwaysFullScreen(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAuthorizationUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientAuthenticationMethod(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientId(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientSecret(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setCustomerNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setDefaultDashboardName(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setEmailAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setFirstNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setJwkSetUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLastNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLoginButtonIcon(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLoginButtonLabel(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setPassword(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setPlatforms(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setScope(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setSendToken(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setTenantNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setTenantNameStrategy(Mockito.<TenantNameStrategyType>any());
    doNothing().when(oAuth2ClientEntity).setTitle(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setTokenUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setType(Mockito.<MapperType>any());
    doNothing().when(oAuth2ClientEntity).setUrl(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUserInfoUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUserNameAttributeName(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUsername(Mockito.<String>any());
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
    oAuth2ClientEntity.setPlatforms("Platforms");
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

    ArrayList<OAuth2ClientEntity> oAuth2ClientEntityList = new ArrayList<>();
    oAuth2ClientEntityList.add(oAuth2ClientEntity);
    when(oAuth2ClientRepository.findByMobileAppId(Mockito.<UUID>any())).thenReturn(oAuth2ClientEntityList);

    // Act
    List<OAuth2Client> actualFindByMobileAppIdResult = jpaOAuth2ClientDao.findByMobileAppId(ModelConstants.NULL_UUID);

    // Assert
    verify(oAuth2ClientEntity).setCreatedTime(eq(1L));
    verify(oAuth2ClientEntity).setId(isA(UUID.class));
    verify(oAuth2ClientEntity).setUuid(isA(UUID.class));
    verify(oAuth2ClientEntity).setActivateUser(eq(true));
    verify(oAuth2ClientEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(oAuth2ClientEntity).setAllowUserCreation(eq(true));
    verify(oAuth2ClientEntity).setAlwaysFullScreen(eq(true));
    verify(oAuth2ClientEntity).setAuthorizationUri(eq("JaneDoe"));
    verify(oAuth2ClientEntity).setClientAuthenticationMethod(eq("Client Authentication Method"));
    verify(oAuth2ClientEntity).setClientId(eq("42"));
    verify(oAuth2ClientEntity).setClientSecret(eq("Client Secret"));
    verify(oAuth2ClientEntity).setCustomerNamePattern(eq("Customer Name Pattern"));
    verify(oAuth2ClientEntity).setDefaultDashboardName(eq("Default Dashboard Name"));
    verify(oAuth2ClientEntity).setEmailAttributeKey(eq("jane.doe@example.org"));
    verify(oAuth2ClientEntity).setFirstNameAttributeKey(eq("Jane"));
    verify(oAuth2ClientEntity).setJwkSetUri(eq("Jwk Set Uri"));
    verify(oAuth2ClientEntity).setLastNameAttributeKey(eq("Doe"));
    verify(oAuth2ClientEntity).setLoginButtonIcon(eq("Login Button Icon"));
    verify(oAuth2ClientEntity).setLoginButtonLabel(eq("Login Button Label"));
    verify(oAuth2ClientEntity).setPassword(eq("iloveyou"));
    verify(oAuth2ClientEntity).setPlatforms(eq("Platforms"));
    verify(oAuth2ClientEntity).setScope(eq("Scope"));
    verify(oAuth2ClientEntity).setSendToken(eq(true));
    verify(oAuth2ClientEntity).setTenantId(isA(UUID.class));
    verify(oAuth2ClientEntity).setTenantNamePattern(eq("Tenant Name Pattern"));
    verify(oAuth2ClientEntity).setTenantNameStrategy(eq(TenantNameStrategyType.DOMAIN));
    verify(oAuth2ClientEntity).setTitle(eq("Dr"));
    verify(oAuth2ClientEntity).setTokenUri(eq("ABC123"));
    verify(oAuth2ClientEntity).setType(eq(MapperType.BASIC));
    verify(oAuth2ClientEntity).setUrl(eq("https://example.org/example"));
    verify(oAuth2ClientEntity).setUserInfoUri(eq("User Info Uri"));
    verify(oAuth2ClientEntity).setUserNameAttributeName(eq("janedoe"));
    verify(oAuth2ClientEntity).setUsername(eq("janedoe"));
    verify(oAuth2ClientEntity).toData();
    verify(oAuth2ClientRepository).findByMobileAppId(isA(UUID.class));
    assertEquals(1, actualFindByMobileAppIdResult.size());
    assertSame(oAuth2Client, actualFindByMobileAppIdResult.get(0));
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findAppSecret(UUID, String)}.
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findAppSecret(UUID, String)}
   */
  @Test
  public void testFindAppSecret() {
    // Arrange
    when(oAuth2ClientRepository.findAppSecret(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn("App Secret");

    // Act
    String actualFindAppSecretResult = jpaOAuth2ClientDao.findAppSecret(ModelConstants.NULL_UUID, "Pkg Name");

    // Assert
    verify(oAuth2ClientRepository).findAppSecret(isA(UUID.class), eq("Pkg Name"));
    assertEquals("App Secret", actualFindAppSecretResult);
  }

  /**
   * Test {@link JpaOAuth2ClientDao#deleteByTenantId(UUID)}.
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#deleteByTenantId(UUID)}
   */
  @Test
  public void testDeleteByTenantId() {
    // Arrange
    doNothing().when(oAuth2ClientRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaOAuth2ClientDao.deleteByTenantId(ModelConstants.NULL_UUID);

    // Assert that nothing has changed
    verify(oAuth2ClientRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByIds(UUID, List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findByIds(UUID, List)}
   */
  @Test
  public void testFindByIds_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<OAuth2Client> actualFindByIdsResult = jpaOAuth2ClientDao.findByIds(ModelConstants.NULL_UUID,
        new ArrayList<>());

    // Assert
    verify(oAuth2ClientRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientDao#findByIds(UUID, List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientDao#findByIds(UUID, List)}
   */
  @Test
  public void testFindByIds_thenReturnSizeIsOne() {
    // Arrange
    OAuth2ClientEntity oAuth2ClientEntity = mock(OAuth2ClientEntity.class);
    OAuth2Client oAuth2Client = new OAuth2Client();
    when(oAuth2ClientEntity.toData()).thenReturn(oAuth2Client);
    doNothing().when(oAuth2ClientEntity).setCreatedTime(anyLong());
    doNothing().when(oAuth2ClientEntity).setId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setActivateUser(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(oAuth2ClientEntity).setAllowUserCreation(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAlwaysFullScreen(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setAuthorizationUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientAuthenticationMethod(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientId(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setClientSecret(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setCustomerNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setDefaultDashboardName(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setEmailAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setFirstNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setJwkSetUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLastNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLoginButtonIcon(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setLoginButtonLabel(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setPassword(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setPlatforms(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setScope(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setSendToken(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientEntity).setTenantNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setTenantNameStrategy(Mockito.<TenantNameStrategyType>any());
    doNothing().when(oAuth2ClientEntity).setTitle(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setTokenUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setType(Mockito.<MapperType>any());
    doNothing().when(oAuth2ClientEntity).setUrl(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUserInfoUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUserNameAttributeName(Mockito.<String>any());
    doNothing().when(oAuth2ClientEntity).setUsername(Mockito.<String>any());
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
    oAuth2ClientEntity.setPlatforms("Platforms");
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

    ArrayList<OAuth2ClientEntity> oAuth2ClientEntityList = new ArrayList<>();
    oAuth2ClientEntityList.add(oAuth2ClientEntity);
    when(oAuth2ClientRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(oAuth2ClientEntityList);

    // Act
    List<OAuth2Client> actualFindByIdsResult = jpaOAuth2ClientDao.findByIds(ModelConstants.NULL_UUID,
        new ArrayList<>());

    // Assert
    verify(oAuth2ClientEntity).setCreatedTime(eq(1L));
    verify(oAuth2ClientEntity).setId(isA(UUID.class));
    verify(oAuth2ClientEntity).setUuid(isA(UUID.class));
    verify(oAuth2ClientEntity).setActivateUser(eq(true));
    verify(oAuth2ClientEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(oAuth2ClientEntity).setAllowUserCreation(eq(true));
    verify(oAuth2ClientEntity).setAlwaysFullScreen(eq(true));
    verify(oAuth2ClientEntity).setAuthorizationUri(eq("JaneDoe"));
    verify(oAuth2ClientEntity).setClientAuthenticationMethod(eq("Client Authentication Method"));
    verify(oAuth2ClientEntity).setClientId(eq("42"));
    verify(oAuth2ClientEntity).setClientSecret(eq("Client Secret"));
    verify(oAuth2ClientEntity).setCustomerNamePattern(eq("Customer Name Pattern"));
    verify(oAuth2ClientEntity).setDefaultDashboardName(eq("Default Dashboard Name"));
    verify(oAuth2ClientEntity).setEmailAttributeKey(eq("jane.doe@example.org"));
    verify(oAuth2ClientEntity).setFirstNameAttributeKey(eq("Jane"));
    verify(oAuth2ClientEntity).setJwkSetUri(eq("Jwk Set Uri"));
    verify(oAuth2ClientEntity).setLastNameAttributeKey(eq("Doe"));
    verify(oAuth2ClientEntity).setLoginButtonIcon(eq("Login Button Icon"));
    verify(oAuth2ClientEntity).setLoginButtonLabel(eq("Login Button Label"));
    verify(oAuth2ClientEntity).setPassword(eq("iloveyou"));
    verify(oAuth2ClientEntity).setPlatforms(eq("Platforms"));
    verify(oAuth2ClientEntity).setScope(eq("Scope"));
    verify(oAuth2ClientEntity).setSendToken(eq(true));
    verify(oAuth2ClientEntity).setTenantId(isA(UUID.class));
    verify(oAuth2ClientEntity).setTenantNamePattern(eq("Tenant Name Pattern"));
    verify(oAuth2ClientEntity).setTenantNameStrategy(eq(TenantNameStrategyType.DOMAIN));
    verify(oAuth2ClientEntity).setTitle(eq("Dr"));
    verify(oAuth2ClientEntity).setTokenUri(eq("ABC123"));
    verify(oAuth2ClientEntity).setType(eq(MapperType.BASIC));
    verify(oAuth2ClientEntity).setUrl(eq("https://example.org/example"));
    verify(oAuth2ClientEntity).setUserInfoUri(eq("User Info Uri"));
    verify(oAuth2ClientEntity).setUserNameAttributeName(eq("janedoe"));
    verify(oAuth2ClientEntity).setUsername(eq("janedoe"));
    verify(oAuth2ClientEntity).toData();
    verify(oAuth2ClientRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByIdsResult.size());
    assertSame(oAuth2Client, actualFindByIdsResult.get(0));
  }

  /**
   * Test {@link JpaOAuth2ClientDao#isPropagateToEdge(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOAuth2ClientDao#isPropagateToEdge(TenantId, UUID)}
   */
  @Test
  public void testIsPropagateToEdge_thenReturnFalse() {
    // Arrange
    when(oAuth2ClientRepository.isPropagateToEdge(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualIsPropagateToEdgeResult = jpaOAuth2ClientDao.isPropagateToEdge(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(oAuth2ClientRepository).isPropagateToEdge(isA(UUID.class), isA(UUID.class));
    assertFalse(actualIsPropagateToEdgeResult);
  }

  /**
   * Test {@link JpaOAuth2ClientDao#isPropagateToEdge(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOAuth2ClientDao#isPropagateToEdge(TenantId, UUID)}
   */
  @Test
  public void testIsPropagateToEdge_thenReturnTrue() {
    // Arrange
    when(oAuth2ClientRepository.isPropagateToEdge(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualIsPropagateToEdgeResult = jpaOAuth2ClientDao.isPropagateToEdge(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(oAuth2ClientRepository).isPropagateToEdge(isA(UUID.class), isA(UUID.class));
    assertTrue(actualIsPropagateToEdgeResult);
  }
}
