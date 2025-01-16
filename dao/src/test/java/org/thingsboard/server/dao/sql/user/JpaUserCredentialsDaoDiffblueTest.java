package org.thingsboard.server.dao.sql.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
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
import java.util.Iterator;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.security.UserCredentials;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.UserCredentialsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaUserCredentialsDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaUserCredentialsDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaUserCredentialsDao jpaUserCredentialsDao;

  @MockBean
  private TransactionTemplate transactionTemplate;

  @MockBean
  private UserCredentialsRepository userCredentialsRepository;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaUserCredentialsDao#getEntityClass()}
   *   <li>{@link JpaUserCredentialsDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaUserCredentialsDao jpaUserCredentialsDao = new JpaUserCredentialsDao();

    // Act
    Class<UserCredentialsEntity> actualEntityClass = jpaUserCredentialsDao.getEntityClass();

    // Assert
    assertNull(jpaUserCredentialsDao.getRepository());
    Class<UserCredentialsEntity> expectedEntityClass = UserCredentialsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaUserCredentialsDao#findByUserId(TenantId, UUID)}.
   * <p>
   * Method under test: {@link JpaUserCredentialsDao#findByUserId(TenantId, UUID)}
   */
  @Test
  public void testFindByUserId() throws IOException {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    when(userCredentialsRepository.findByUserId(Mockito.<UUID>any())).thenReturn(userCredentialsEntity);
    UUID userId = ModelConstants.NULL_UUID;

    // Act
    UserCredentials actualFindByUserIdResult = jpaUserCredentialsDao.findByUserId(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userCredentialsRepository).findByUserId(isA(UUID.class));
    JsonNode additionalInfo = actualFindByUserIdResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    assertEquals("ABC123", actualFindByUserIdResult.getActivateToken());
    assertEquals("ABC123", actualFindByUserIdResult.getResetToken());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("iloveyou", actualFindByUserIdResult.getPassword());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertEquals(1, actualFindByUserIdResult.getFailedLoginAttempts().intValue());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByUserIdResult.getActivateTokenExpTime().longValue());
    assertEquals(1L, actualFindByUserIdResult.getLastLoginTs().longValue());
    assertEquals(1L, actualFindByUserIdResult.getResetTokenExpTime().longValue());
    assertEquals(1L, actualFindByUserIdResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    UserId userId2 = actualFindByUserIdResult.getUserId();
    assertEquals(EntityType.USER, userId2.getEntityType());
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
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(userId2.isNullUid());
    assertTrue(actualFindByUserIdResult.isEnabled());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(userId, actualFindByUserIdResult.getUuidId());
    assertSame(userId, actualFindByUserIdResult.getId().getId());
    assertSame(userId, userId2.getId());
  }

  /**
   * Test {@link JpaUserCredentialsDao#findByActivateToken(TenantId, String)}.
   * <p>
   * Method under test:
   * {@link JpaUserCredentialsDao#findByActivateToken(TenantId, String)}
   */
  @Test
  public void testFindByActivateToken() throws IOException {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    when(userCredentialsRepository.findByActivateToken(Mockito.<String>any())).thenReturn(userCredentialsEntity);

    // Act
    UserCredentials actualFindByActivateTokenResult = jpaUserCredentialsDao
        .findByActivateToken(ModelConstants.SYSTEM_TENANT, "ABC123");

    // Assert
    verify(userCredentialsRepository).findByActivateToken(eq("ABC123"));
    JsonNode additionalInfo = actualFindByActivateTokenResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = actualFindByActivateTokenResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("ABC123", actualFindByActivateTokenResult.getActivateToken());
    assertEquals("ABC123", actualFindByActivateTokenResult.getResetToken());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("iloveyou", actualFindByActivateTokenResult.getPassword());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertEquals(1, actualFindByActivateTokenResult.getFailedLoginAttempts().intValue());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByActivateTokenResult.getActivateTokenExpTime().longValue());
    assertEquals(1L, actualFindByActivateTokenResult.getLastLoginTs().longValue());
    assertEquals(1L, actualFindByActivateTokenResult.getResetTokenExpTime().longValue());
    assertEquals(1L, actualFindByActivateTokenResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    UserId userId = actualFindByActivateTokenResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
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
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(userId.isNullUid());
    assertTrue(actualFindByActivateTokenResult.isEnabled());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, actualFindByActivateTokenResult.getId().getId());
    assertSame(uuidId, userId.getId());
  }

  /**
   * Test {@link JpaUserCredentialsDao#findByResetToken(TenantId, String)}.
   * <p>
   * Method under test:
   * {@link JpaUserCredentialsDao#findByResetToken(TenantId, String)}
   */
  @Test
  public void testFindByResetToken() throws IOException {
    // Arrange
    UserCredentialsEntity userCredentialsEntity = new UserCredentialsEntity();
    userCredentialsEntity.setActivateToken("ABC123");
    userCredentialsEntity.setActivateTokenExpTime(1L);
    userCredentialsEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userCredentialsEntity.setCreatedTime(1L);
    userCredentialsEntity.setEnabled(true);
    userCredentialsEntity.setFailedLoginAttempts(1);
    userCredentialsEntity.setId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setLastLoginTs(1L);
    userCredentialsEntity.setPassword("iloveyou");
    userCredentialsEntity.setResetToken("ABC123");
    userCredentialsEntity.setResetTokenExpTime(1L);
    userCredentialsEntity.setUserId(ModelConstants.NULL_UUID);
    userCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    when(userCredentialsRepository.findByResetToken(Mockito.<String>any())).thenReturn(userCredentialsEntity);

    // Act
    UserCredentials actualFindByResetTokenResult = jpaUserCredentialsDao.findByResetToken(ModelConstants.SYSTEM_TENANT,
        "ABC123");

    // Assert
    verify(userCredentialsRepository).findByResetToken(eq("ABC123"));
    JsonNode additionalInfo = actualFindByResetTokenResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    UUID uuidId = actualFindByResetTokenResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("ABC123", actualFindByResetTokenResult.getActivateToken());
    assertEquals("ABC123", actualFindByResetTokenResult.getResetToken());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("iloveyou", actualFindByResetTokenResult.getPassword());
    assertEquals("jackson-databind", versionResult.getArtifactId());
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
    assertEquals(1, actualFindByResetTokenResult.getFailedLoginAttempts().intValue());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByResetTokenResult.getActivateTokenExpTime().longValue());
    assertEquals(1L, actualFindByResetTokenResult.getLastLoginTs().longValue());
    assertEquals(1L, actualFindByResetTokenResult.getResetTokenExpTime().longValue());
    assertEquals(1L, actualFindByResetTokenResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    UserId userId = actualFindByResetTokenResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
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
    assertTrue(nextResult.isBoolean());
    assertTrue(additionalInfo.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(additionalInfo.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(userId.isNullUid());
    assertTrue(actualFindByResetTokenResult.isEnabled());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, actualFindByResetTokenResult.getId().getId());
    assertSame(uuidId, userId.getId());
  }

  /**
   * Test {@link JpaUserCredentialsDao#removeByUserId(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link UserId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserCredentialsDao#removeByUserId(TenantId, UserId)}
   */
  @Test
  public void testRemoveByUserId_givenNull_uuid_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(userCredentialsRepository).removeByUserId(Mockito.<UUID>any());
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserCredentialsDao.removeByUserId(ModelConstants.SYSTEM_TENANT, userId);

    // Assert that nothing has changed
    verify(userId).getId();
    verify(userCredentialsRepository).removeByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserCredentialsDao#removeByUserId(TenantId, UserId)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UserCredentialsRepository#removeByUserId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserCredentialsDao#removeByUserId(TenantId, UserId)}
   */
  @Test
  public void testRemoveByUserId_whenUserIdWithIdIsNull_uuid_thenCallsRemoveByUserId() {
    // Arrange
    doNothing().when(userCredentialsRepository).removeByUserId(Mockito.<UUID>any());

    // Act
    jpaUserCredentialsDao.removeByUserId(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(userCredentialsRepository).removeByUserId(isA(UUID.class));
  }

  /**
   * Test {@link JpaUserCredentialsDao#setLastLoginTs(TenantId, UserId, long)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link UserId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserCredentialsDao#setLastLoginTs(TenantId, UserId, long)}
   */
  @Test
  public void testSetLastLoginTs_givenNull_uuid_whenUserIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(userCredentialsRepository).updateLastLoginTsByUserId(Mockito.<UUID>any(), anyLong());
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserCredentialsDao.setLastLoginTs(ModelConstants.SYSTEM_TENANT, userId, 1L);

    // Assert that nothing has changed
    verify(userId).getId();
    verify(userCredentialsRepository).updateLastLoginTsByUserId(isA(UUID.class), eq(1L));
  }

  /**
   * Test {@link JpaUserCredentialsDao#setLastLoginTs(TenantId, UserId, long)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserCredentialsDao#setLastLoginTs(TenantId, UserId, long)}
   */
  @Test
  public void testSetLastLoginTs_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(userCredentialsRepository).updateLastLoginTsByUserId(Mockito.<UUID>any(), anyLong());

    // Act
    jpaUserCredentialsDao.setLastLoginTs(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), 1L);

    // Assert that nothing has changed
    verify(userCredentialsRepository).updateLastLoginTsByUserId(isA(UUID.class), eq(1L));
  }

  /**
   * Test
   * {@link JpaUserCredentialsDao#incrementFailedLoginAttempts(TenantId, UserId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserCredentialsDao#incrementFailedLoginAttempts(TenantId, UserId)}
   */
  @Test
  public void testIncrementFailedLoginAttempts_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(userCredentialsRepository.incrementFailedLoginAttemptsByUserId(Mockito.<UUID>any())).thenReturn(1);
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    int actualIncrementFailedLoginAttemptsResult = jpaUserCredentialsDao
        .incrementFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, userId);

    // Assert
    verify(userId).getId();
    verify(userCredentialsRepository).incrementFailedLoginAttemptsByUserId(isA(UUID.class));
    assertEquals(1, actualIncrementFailedLoginAttemptsResult);
  }

  /**
   * Test
   * {@link JpaUserCredentialsDao#incrementFailedLoginAttempts(TenantId, UserId)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserCredentialsDao#incrementFailedLoginAttempts(TenantId, UserId)}
   */
  @Test
  public void testIncrementFailedLoginAttempts_whenUserIdWithIdIsNull_uuid_thenReturnOne() {
    // Arrange
    when(userCredentialsRepository.incrementFailedLoginAttemptsByUserId(Mockito.<UUID>any())).thenReturn(1);

    // Act
    int actualIncrementFailedLoginAttemptsResult = jpaUserCredentialsDao
        .incrementFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID));

    // Assert
    verify(userCredentialsRepository).incrementFailedLoginAttemptsByUserId(isA(UUID.class));
    assertEquals(1, actualIncrementFailedLoginAttemptsResult);
  }

  /**
   * Test
   * {@link JpaUserCredentialsDao#setFailedLoginAttempts(TenantId, UserId, int)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserCredentialsDao#setFailedLoginAttempts(TenantId, UserId, int)}
   */
  @Test
  public void testSetFailedLoginAttempts_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(userCredentialsRepository).updateFailedLoginAttemptsByUserId(Mockito.<UUID>any(), anyInt());
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    jpaUserCredentialsDao.setFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, userId, 1);

    // Assert that nothing has changed
    verify(userId).getId();
    verify(userCredentialsRepository).updateFailedLoginAttemptsByUserId(isA(UUID.class), eq(1));
  }

  /**
   * Test
   * {@link JpaUserCredentialsDao#setFailedLoginAttempts(TenantId, UserId, int)}.
   * <ul>
   *   <li>When {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserCredentialsDao#setFailedLoginAttempts(TenantId, UserId, int)}
   */
  @Test
  public void testSetFailedLoginAttempts_whenUserIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(userCredentialsRepository).updateFailedLoginAttemptsByUserId(Mockito.<UUID>any(), anyInt());

    // Act
    jpaUserCredentialsDao.setFailedLoginAttempts(ModelConstants.SYSTEM_TENANT, new UserId(ModelConstants.NULL_UUID), 1);

    // Assert that nothing has changed
    verify(userCredentialsRepository).updateFailedLoginAttemptsByUserId(isA(UUID.class), eq(1));
  }
}
