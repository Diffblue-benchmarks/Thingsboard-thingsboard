package org.thingsboard.server.dao.sql.oauth2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import jakarta.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
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
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaOAuth2ClientRegistrationTemplateDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaOAuth2ClientRegistrationTemplateDao jpaOAuth2ClientRegistrationTemplateDao;

  @MockBean
  private OAuth2ClientRegistrationTemplateRepository oAuth2ClientRegistrationTemplateRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaOAuth2ClientRegistrationTemplateDao#getEntityClass()}
   *   <li>{@link JpaOAuth2ClientRegistrationTemplateDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaOAuth2ClientRegistrationTemplateDao jpaOAuth2ClientRegistrationTemplateDao = new JpaOAuth2ClientRegistrationTemplateDao(
        mock(OAuth2ClientRegistrationTemplateRepository.class));

    // Act
    Class<OAuth2ClientRegistrationTemplateEntity> actualEntityClass = jpaOAuth2ClientRegistrationTemplateDao
        .getEntityClass();
    jpaOAuth2ClientRegistrationTemplateDao.getRepository();

    // Assert
    Class<OAuth2ClientRegistrationTemplateEntity> expectedEntityClass = OAuth2ClientRegistrationTemplateEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaOAuth2ClientRegistrationTemplateDao#findByProviderId(String)}.
   * <ul>
   *   <li>Then {@link Optional#get()} AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOAuth2ClientRegistrationTemplateDao#findByProviderId(String)}
   */
  @Test
  public void testFindByProviderId_thenGetAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity = new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod("Client Authentication Method");
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
    Optional<OAuth2ClientRegistrationTemplate> actualFindByProviderIdResult = jpaOAuth2ClientRegistrationTemplateDao
        .findByProviderId("42");

    // Assert
    verify(oAuth2ClientRegistrationTemplateRepository).findByProviderId(eq("42"));
    OAuth2ClientRegistrationTemplate getResult = actualFindByProviderIdResult.get();
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getProviderId());
    assertEquals("ABC123", getResult.getAccessTokenUri());
    assertEquals("Client Authentication Method", getResult.getClientAuthenticationMethod());
    assertEquals("Comment", getResult.getComment());
    OAuth2MapperConfig mapperConfig = getResult.getMapperConfig();
    OAuth2BasicMapperConfig basic = mapperConfig.getBasic();
    assertEquals("Customer Name Pattern", basic.getCustomerNamePattern());
    assertEquals("Default Dashboard Name", basic.getDefaultDashboardName());
    assertEquals("Doe", basic.getLastNameAttributeKey());
    assertEquals("Help Link", getResult.getHelpLink());
    assertEquals("Jane", basic.getFirstNameAttributeKey());
    assertEquals("JaneDoe", getResult.getAuthorizationUri());
    assertEquals("Jwk Set Uri", getResult.getJwkSetUri());
    assertEquals("Login Button Icon", getResult.getLoginButtonIcon());
    assertEquals("Login Button Label", getResult.getLoginButtonLabel());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    List<String> scope = getResult.getScope();
    assertEquals(1, scope.size());
    assertEquals("Scope", scope.get(0));
    assertEquals("Tenant Name Pattern", basic.getTenantNamePattern());
    assertEquals("User Info Uri", getResult.getUserInfoUri());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", basic.getEmailAttributeKey());
    assertEquals("janedoe", getResult.getUserNameAttributeName());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertNull(mapperConfig.getCustom());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, additionalInfo.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    assertEquals(MapperType.BASIC, mapperConfig.getType());
    assertEquals(TenantNameStrategyType.DOMAIN, basic.getTenantNameStrategy());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(additionalInfo.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(additionalInfo.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(additionalInfo.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(additionalInfo.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(additionalInfo.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(additionalInfo.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(additionalInfo.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(additionalInfo.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertFalse(mapperConfig.isActivateUser());
    assertFalse(mapperConfig.isAllowUserCreation());
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(basic.isAlwaysFullScreen());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, getResult.getId().getId());
  }

  /**
   * Test {@link JpaOAuth2ClientRegistrationTemplateDao#findByProviderId(String)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaOAuth2ClientRegistrationTemplateDao#findByProviderId(String)}
   */
  @Test
  public void testFindByProviderId_thenReturnGetIsOAuth2ClientRegistrationTemplate() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity = mock(
        OAuth2ClientRegistrationTemplateEntity.class);
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    when(oAuth2ClientRegistrationTemplateEntity.toData()).thenReturn(oAuth2ClientRegistrationTemplate);
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setAlwaysFullScreen(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setAuthorizationUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setClientAuthenticationMethod(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setComment(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setCustomerNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setDefaultDashboardName(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setEmailAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setFirstNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setHelpLink(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setJwkSetUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setLastNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setLoginButtonIcon(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setLoginButtonLabel(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setProviderId(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setScope(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setTenantNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity)
        .setTenantNameStrategy(Mockito.<TenantNameStrategyType>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setTokenUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setType(Mockito.<MapperType>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setUserInfoUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setUserNameAttributeName(Mockito.<String>any());
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod("Client Authentication Method");
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
    Optional<OAuth2ClientRegistrationTemplate> actualFindByProviderIdResult = jpaOAuth2ClientRegistrationTemplateDao
        .findByProviderId("42");

    // Assert
    verify(oAuth2ClientRegistrationTemplateEntity).setCreatedTime(eq(1L));
    verify(oAuth2ClientRegistrationTemplateEntity).setId(isA(UUID.class));
    verify(oAuth2ClientRegistrationTemplateEntity).setUuid(isA(UUID.class));
    verify(oAuth2ClientRegistrationTemplateEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(oAuth2ClientRegistrationTemplateEntity).setAlwaysFullScreen(eq(true));
    verify(oAuth2ClientRegistrationTemplateEntity).setAuthorizationUri(eq("JaneDoe"));
    verify(oAuth2ClientRegistrationTemplateEntity).setClientAuthenticationMethod(eq("Client Authentication Method"));
    verify(oAuth2ClientRegistrationTemplateEntity).setComment(eq("Comment"));
    verify(oAuth2ClientRegistrationTemplateEntity).setCustomerNamePattern(eq("Customer Name Pattern"));
    verify(oAuth2ClientRegistrationTemplateEntity).setDefaultDashboardName(eq("Default Dashboard Name"));
    verify(oAuth2ClientRegistrationTemplateEntity).setEmailAttributeKey(eq("jane.doe@example.org"));
    verify(oAuth2ClientRegistrationTemplateEntity).setFirstNameAttributeKey(eq("Jane"));
    verify(oAuth2ClientRegistrationTemplateEntity).setHelpLink(eq("Help Link"));
    verify(oAuth2ClientRegistrationTemplateEntity).setJwkSetUri(eq("Jwk Set Uri"));
    verify(oAuth2ClientRegistrationTemplateEntity).setLastNameAttributeKey(eq("Doe"));
    verify(oAuth2ClientRegistrationTemplateEntity).setLoginButtonIcon(eq("Login Button Icon"));
    verify(oAuth2ClientRegistrationTemplateEntity).setLoginButtonLabel(eq("Login Button Label"));
    verify(oAuth2ClientRegistrationTemplateEntity).setProviderId(eq("42"));
    verify(oAuth2ClientRegistrationTemplateEntity).setScope(eq("Scope"));
    verify(oAuth2ClientRegistrationTemplateEntity).setTenantNamePattern(eq("Tenant Name Pattern"));
    verify(oAuth2ClientRegistrationTemplateEntity).setTenantNameStrategy(eq(TenantNameStrategyType.DOMAIN));
    verify(oAuth2ClientRegistrationTemplateEntity).setTokenUri(eq("ABC123"));
    verify(oAuth2ClientRegistrationTemplateEntity).setType(eq(MapperType.BASIC));
    verify(oAuth2ClientRegistrationTemplateEntity).setUserInfoUri(eq("User Info Uri"));
    verify(oAuth2ClientRegistrationTemplateEntity).setUserNameAttributeName(eq("janedoe"));
    verify(oAuth2ClientRegistrationTemplateEntity).toData();
    verify(oAuth2ClientRegistrationTemplateRepository).findByProviderId(eq("42"));
    assertSame(oAuth2ClientRegistrationTemplate, actualFindByProviderIdResult.get());
  }

  /**
   * Test {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}
   */
  @Test
  public void testFindAll_thenReturnEmpty() {
    // Arrange
    when(oAuth2ClientRegistrationTemplateRepository.findAll()).thenReturn(new ArrayList<>());

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllResult = jpaOAuth2ClientRegistrationTemplateDao.findAll();

    // Assert
    verify(oAuth2ClientRegistrationTemplateRepository).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}.
   * <ul>
   *   <li>Then return first is
   * {@link OAuth2ClientRegistrationTemplate#OAuth2ClientRegistrationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}
   */
  @Test
  public void testFindAll_thenReturnFirstIsOAuth2ClientRegistrationTemplate() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity = mock(
        OAuth2ClientRegistrationTemplateEntity.class);
    OAuth2ClientRegistrationTemplate oAuth2ClientRegistrationTemplate = new OAuth2ClientRegistrationTemplate();
    when(oAuth2ClientRegistrationTemplateEntity.toData()).thenReturn(oAuth2ClientRegistrationTemplate);
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setCreatedTime(anyLong());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setId(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setAlwaysFullScreen(Mockito.<Boolean>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setAuthorizationUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setClientAuthenticationMethod(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setComment(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setCustomerNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setDefaultDashboardName(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setEmailAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setFirstNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setHelpLink(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setJwkSetUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setLastNameAttributeKey(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setLoginButtonIcon(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setLoginButtonLabel(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setProviderId(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setScope(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setTenantNamePattern(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity)
        .setTenantNameStrategy(Mockito.<TenantNameStrategyType>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setTokenUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setType(Mockito.<MapperType>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setUserInfoUri(Mockito.<String>any());
    doNothing().when(oAuth2ClientRegistrationTemplateEntity).setUserNameAttributeName(Mockito.<String>any());
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod("Client Authentication Method");
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

    ArrayList<OAuth2ClientRegistrationTemplateEntity> oAuth2ClientRegistrationTemplateEntityList = new ArrayList<>();
    oAuth2ClientRegistrationTemplateEntityList.add(oAuth2ClientRegistrationTemplateEntity);
    when(oAuth2ClientRegistrationTemplateRepository.findAll()).thenReturn(oAuth2ClientRegistrationTemplateEntityList);

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllResult = jpaOAuth2ClientRegistrationTemplateDao.findAll();

    // Assert
    verify(oAuth2ClientRegistrationTemplateRepository).findAll();
    verify(oAuth2ClientRegistrationTemplateEntity).setCreatedTime(eq(1L));
    verify(oAuth2ClientRegistrationTemplateEntity).setId(isA(UUID.class));
    verify(oAuth2ClientRegistrationTemplateEntity).setUuid(isA(UUID.class));
    verify(oAuth2ClientRegistrationTemplateEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(oAuth2ClientRegistrationTemplateEntity).setAlwaysFullScreen(eq(true));
    verify(oAuth2ClientRegistrationTemplateEntity).setAuthorizationUri(eq("JaneDoe"));
    verify(oAuth2ClientRegistrationTemplateEntity).setClientAuthenticationMethod(eq("Client Authentication Method"));
    verify(oAuth2ClientRegistrationTemplateEntity).setComment(eq("Comment"));
    verify(oAuth2ClientRegistrationTemplateEntity).setCustomerNamePattern(eq("Customer Name Pattern"));
    verify(oAuth2ClientRegistrationTemplateEntity).setDefaultDashboardName(eq("Default Dashboard Name"));
    verify(oAuth2ClientRegistrationTemplateEntity).setEmailAttributeKey(eq("jane.doe@example.org"));
    verify(oAuth2ClientRegistrationTemplateEntity).setFirstNameAttributeKey(eq("Jane"));
    verify(oAuth2ClientRegistrationTemplateEntity).setHelpLink(eq("Help Link"));
    verify(oAuth2ClientRegistrationTemplateEntity).setJwkSetUri(eq("Jwk Set Uri"));
    verify(oAuth2ClientRegistrationTemplateEntity).setLastNameAttributeKey(eq("Doe"));
    verify(oAuth2ClientRegistrationTemplateEntity).setLoginButtonIcon(eq("Login Button Icon"));
    verify(oAuth2ClientRegistrationTemplateEntity).setLoginButtonLabel(eq("Login Button Label"));
    verify(oAuth2ClientRegistrationTemplateEntity).setProviderId(eq("42"));
    verify(oAuth2ClientRegistrationTemplateEntity).setScope(eq("Scope"));
    verify(oAuth2ClientRegistrationTemplateEntity).setTenantNamePattern(eq("Tenant Name Pattern"));
    verify(oAuth2ClientRegistrationTemplateEntity).setTenantNameStrategy(eq(TenantNameStrategyType.DOMAIN));
    verify(oAuth2ClientRegistrationTemplateEntity).setTokenUri(eq("ABC123"));
    verify(oAuth2ClientRegistrationTemplateEntity).setType(eq(MapperType.BASIC));
    verify(oAuth2ClientRegistrationTemplateEntity).setUserInfoUri(eq("User Info Uri"));
    verify(oAuth2ClientRegistrationTemplateEntity).setUserNameAttributeName(eq("janedoe"));
    verify(oAuth2ClientRegistrationTemplateEntity).toData();
    assertEquals(1, actualFindAllResult.size());
    assertSame(oAuth2ClientRegistrationTemplate, actualFindAllResult.get(0));
  }

  /**
   * Test {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}.
   * <ul>
   *   <li>Then return first Name is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}
   */
  @Test
  public void testFindAll_thenReturnFirstNameIs42() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity = new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod("Client Authentication Method");
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

    ArrayList<OAuth2ClientRegistrationTemplateEntity> oAuth2ClientRegistrationTemplateEntityList = new ArrayList<>();
    oAuth2ClientRegistrationTemplateEntityList.add(oAuth2ClientRegistrationTemplateEntity);
    when(oAuth2ClientRegistrationTemplateRepository.findAll()).thenReturn(oAuth2ClientRegistrationTemplateEntityList);

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllResult = jpaOAuth2ClientRegistrationTemplateDao.findAll();

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
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaOAuth2ClientRegistrationTemplateDao#findAll()}
   */
  @Test
  public void testFindAll_thenReturnSizeIsTwo() {
    // Arrange
    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity = new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity.setAlwaysFullScreen(true);
    oAuth2ClientRegistrationTemplateEntity.setAuthorizationUri("JaneDoe");
    oAuth2ClientRegistrationTemplateEntity.setClientAuthenticationMethod("Client Authentication Method");
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

    OAuth2ClientRegistrationTemplateEntity oAuth2ClientRegistrationTemplateEntity2 = new OAuth2ClientRegistrationTemplateEntity();
    oAuth2ClientRegistrationTemplateEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    oAuth2ClientRegistrationTemplateEntity2.setAlwaysFullScreen(false);
    oAuth2ClientRegistrationTemplateEntity2.setAuthorizationUri(",");
    oAuth2ClientRegistrationTemplateEntity2.setClientAuthenticationMethod("Client Authentication Method");
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

    ArrayList<OAuth2ClientRegistrationTemplateEntity> oAuth2ClientRegistrationTemplateEntityList = new ArrayList<>();
    oAuth2ClientRegistrationTemplateEntityList.add(oAuth2ClientRegistrationTemplateEntity2);
    oAuth2ClientRegistrationTemplateEntityList.add(oAuth2ClientRegistrationTemplateEntity);
    when(oAuth2ClientRegistrationTemplateRepository.findAll()).thenReturn(oAuth2ClientRegistrationTemplateEntityList);

    // Act
    List<OAuth2ClientRegistrationTemplate> actualFindAllResult = jpaOAuth2ClientRegistrationTemplateDao.findAll();

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
    OAuth2MapperConfig mapperConfig = getResult2.getMapperConfig();
    OAuth2BasicMapperConfig basic = mapperConfig.getBasic();
    assertEquals("Customer Name Pattern", basic.getCustomerNamePattern());
    assertEquals("Default Dashboard Name", basic.getDefaultDashboardName());
    assertEquals("Doe", basic.getLastNameAttributeKey());
    assertEquals("Help Link", getResult2.getHelpLink());
    assertEquals("Jane", basic.getFirstNameAttributeKey());
    assertEquals("JaneDoe", getResult2.getAuthorizationUri());
    OAuth2MapperConfig mapperConfig2 = getResult.getMapperConfig();
    OAuth2BasicMapperConfig basic2 = mapperConfig2.getBasic();
    assertEquals("John", basic2.getFirstNameAttributeKey());
    assertEquals("Jwk Set Uri", getResult2.getJwkSetUri());
    assertEquals("Login Button Icon", getResult2.getLoginButtonIcon());
    assertEquals("Login Button Label", getResult2.getLoginButtonLabel());
    assertEquals("Smith", basic2.getLastNameAttributeKey());
    assertEquals("Tenant Name Pattern", basic.getTenantNamePattern());
    assertEquals("User Info Uri", getResult2.getUserInfoUri());
    assertEquals("jane.doe@example.org", basic.getEmailAttributeKey());
    assertEquals("janedoe", getResult2.getUserNameAttributeName());
    assertEquals("john.smith@example.org", basic2.getEmailAttributeKey());
    assertNull(mapperConfig.getCustom());
    assertEquals(1L, getResult2.getCreatedTime());
    assertEquals(MapperType.BASIC, mapperConfig.getType());
    assertEquals(MapperType.CUSTOM, mapperConfig2.getType());
    assertEquals(TenantNameStrategyType.DOMAIN, basic.getTenantNameStrategy());
    assertEquals(TenantNameStrategyType.EMAIL, basic2.getTenantNameStrategy());
    assertFalse(basic2.isAlwaysFullScreen());
    assertFalse(mapperConfig.isActivateUser());
    assertFalse(mapperConfig.isAllowUserCreation());
    assertTrue(basic.isAlwaysFullScreen());
  }
}
