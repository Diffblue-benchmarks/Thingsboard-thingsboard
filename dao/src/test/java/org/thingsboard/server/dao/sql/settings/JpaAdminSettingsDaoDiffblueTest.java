package org.thingsboard.server.dao.sql.settings;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
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
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AdminSettingsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaAdminSettingsDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaAdminSettingsDaoDiffblueTest {
  @MockBean
  private AdminSettingsRepository adminSettingsRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAdminSettingsDao jpaAdminSettingsDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAdminSettingsDao#getEntityClass()}
   *   <li>{@link JpaAdminSettingsDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaAdminSettingsDao jpaAdminSettingsDao = new JpaAdminSettingsDao();

    // Act
    Class<AdminSettingsEntity> actualEntityClass = jpaAdminSettingsDao.getEntityClass();

    // Assert
    assertNull(jpaAdminSettingsDao.getRepository());
    Class<AdminSettingsEntity> expectedEntityClass = AdminSettingsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaAdminSettingsDao#findByTenantIdAndKey(UUID, String)}.
   * <ul>
   *   <li>Then JsonValue iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAdminSettingsDao#findByTenantIdAndKey(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndKey_thenJsonValueIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    adminSettingsEntity.setTenantId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    when(adminSettingsRepository.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(adminSettingsEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    AdminSettings actualFindByTenantIdAndKeyResult = jpaAdminSettingsDao.findByTenantIdAndKey(tenantId, "Key");

    // Assert
    verify(adminSettingsRepository).findByTenantIdAndKey(isA(UUID.class), eq("Key"));
    JsonNode jsonValue = actualFindByTenantIdAndKeyResult.getJsonValue();
    Iterator<JsonNode> iteratorResult = jsonValue.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(jsonValue instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = jsonValue.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = actualFindByTenantIdAndKeyResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Key", actualFindByTenantIdAndKeyResult.getKey());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", jsonValue.toPrettyString());
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
    assertEquals(1, jsonValue.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByTenantIdAndKeyResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, jsonValue.getNodeType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
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
    assertFalse(jsonValue.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(jsonValue.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(jsonValue.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(jsonValue.isBinary());
    assertFalse(jsonValue.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(jsonValue.isDouble());
    assertFalse(jsonValue.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(jsonValue.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(jsonValue.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(jsonValue.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(jsonValue.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(jsonValue.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(jsonValue.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(jsonValue.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(jsonValue.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(jsonValue.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(jsonValue.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(jsonValue.isTextual());
    assertFalse(jsonValue.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(jsonValue.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(jsonValue.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, actualFindByTenantIdAndKeyResult.getUuidId());
    assertSame(tenantId, actualFindByTenantIdAndKeyResult.getId().getId());
  }

  /**
   * Test {@link JpaAdminSettingsDao#findByTenantIdAndKey(UUID, String)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAdminSettingsDao#findByTenantIdAndKey(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndKey_thenReturnNotTenantIdNullUid() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    adminSettingsEntity.setCreatedTime(1L);
    adminSettingsEntity.setId(ModelConstants.NULL_UUID);
    adminSettingsEntity.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettingsEntity.setKey("Key");
    UUID tenantId = UUID.randomUUID();
    adminSettingsEntity.setTenantId(tenantId);
    adminSettingsEntity.setUuid(ModelConstants.NULL_UUID);
    when(adminSettingsRepository.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(adminSettingsEntity);

    // Act
    AdminSettings actualFindByTenantIdAndKeyResult = jpaAdminSettingsDao.findByTenantIdAndKey(ModelConstants.NULL_UUID,
        "Key");

    // Assert
    verify(adminSettingsRepository).findByTenantIdAndKey(isA(UUID.class), eq("Key"));
    TenantId tenantId2 = actualFindByTenantIdAndKeyResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAdminSettingsDao#removeByTenantIdAndKey(UUID, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAdminSettingsDao#removeByTenantIdAndKey(UUID, String)}
   */
  @Test
  public void testRemoveByTenantIdAndKey_thenReturnFalse() {
    // Arrange
    when(adminSettingsRepository.existsByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualRemoveByTenantIdAndKeyResult = jpaAdminSettingsDao.removeByTenantIdAndKey(ModelConstants.NULL_UUID,
        "Key");

    // Assert
    verify(adminSettingsRepository).existsByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertFalse(actualRemoveByTenantIdAndKeyResult);
  }

  /**
   * Test {@link JpaAdminSettingsDao#removeByTenantIdAndKey(UUID, String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAdminSettingsDao#removeByTenantIdAndKey(UUID, String)}
   */
  @Test
  public void testRemoveByTenantIdAndKey_thenReturnTrue() {
    // Arrange
    doNothing().when(adminSettingsRepository).deleteByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any());
    when(adminSettingsRepository.existsByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualRemoveByTenantIdAndKeyResult = jpaAdminSettingsDao.removeByTenantIdAndKey(ModelConstants.NULL_UUID,
        "Key");

    // Assert
    verify(adminSettingsRepository).deleteByTenantIdAndKey(isA(UUID.class), eq("Key"));
    verify(adminSettingsRepository).existsByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertTrue(actualRemoveByTenantIdAndKeyResult);
  }

  /**
   * Test {@link JpaAdminSettingsDao#removeByTenantId(UUID)}.
   * <p>
   * Method under test: {@link JpaAdminSettingsDao#removeByTenantId(UUID)}
   */
  @Test
  public void testRemoveByTenantId() {
    // Arrange
    doNothing().when(adminSettingsRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaAdminSettingsDao.removeByTenantId(ModelConstants.NULL_UUID);

    // Assert that nothing has changed
    verify(adminSettingsRepository).deleteByTenantId(isA(UUID.class));
  }
}
