package org.thingsboard.server.dao.sql.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
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
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.RuleNodeEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRuleNodeDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaRuleNodeDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaRuleNodeDao jpaRuleNodeDao;

  @MockBean
  private RuleNodeRepository ruleNodeRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaRuleNodeDao#getEntityClass()}
   *   <li>{@link JpaRuleNodeDao#getEntityType()}
   *   <li>{@link JpaRuleNodeDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaRuleNodeDao jpaRuleNodeDao = new JpaRuleNodeDao();

    // Act
    Class<RuleNodeEntity> actualEntityClass = jpaRuleNodeDao.getEntityClass();
    EntityType actualEntityType = jpaRuleNodeDao.getEntityType();

    // Assert
    assertNull(jpaRuleNodeDao.getRepository());
    assertEquals(EntityType.RULE_NODE, actualEntityType);
    Class<RuleNodeEntity> expectedEntityClass = RuleNodeEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String, String)}.
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String, String)}
   */
  @Test
  public void testFindRuleNodesByTenantIdAndType() throws IOException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findRuleNodesByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(ruleNodeEntityList);

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult = jpaRuleNodeDao
        .findRuleNodesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", "Configuration Search");

    // Assert
    verify(ruleNodeRepository).findRuleNodesByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Configuration Search"));
    assertEquals(1, actualFindRuleNodesByTenantIdAndTypeResult.size());
    RuleNode getResult = actualFindRuleNodesByTenantIdAndTypeResult.get(0);
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
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", getResult.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
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
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleChainId ruleChainId = getResult.getRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId externalId = getResult.getExternalId();
    assertEquals(EntityType.RULE_NODE, externalId.getEntityType());
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
    assertTrue(externalId.isNullUid());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, externalId.getId());
    assertSame(uuidId, ruleChainId.getId());
    assertSame(additionalInfo, getResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, getResult.getConfigurationBytes());
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String, String)}.
   * <ul>
   *   <li>Then return first is {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String, String)}
   */
  @Test
  public void testFindRuleNodesByTenantIdAndType_thenReturnFirstIsRuleNode() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = mock(RuleNodeEntity.class);
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeEntity.toData()).thenReturn(ruleNode);
    doNothing().when(ruleNodeEntity).setCreatedTime(anyLong());
    doNothing().when(ruleNodeEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleNodeEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleNodeEntity).setConfigurationVersion(anyInt());
    doNothing().when(ruleNodeEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleNodeEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setName(Mockito.<String>any());
    doNothing().when(ruleNodeEntity).setQueueName(Mockito.<String>any());
    doNothing().when(ruleNodeEntity).setRuleChainId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setSingletonMode(anyBoolean());
    doNothing().when(ruleNodeEntity).setType(Mockito.<String>any());
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findRuleNodesByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(ruleNodeEntityList);

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult = jpaRuleNodeDao
        .findRuleNodesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", "Configuration Search");

    // Assert
    verify(ruleNodeEntity).setCreatedTime(eq(1L));
    verify(ruleNodeEntity).setId(isA(UUID.class));
    verify(ruleNodeEntity).setUuid(isA(UUID.class));
    verify(ruleNodeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleNodeEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleNodeEntity).setConfigurationVersion(eq(1));
    verify(ruleNodeEntity).setDebugMode(eq(true));
    verify(ruleNodeEntity).setExternalId(isA(UUID.class));
    verify(ruleNodeEntity).setName(eq("Name"));
    verify(ruleNodeEntity).setQueueName(eq("Queue Name"));
    verify(ruleNodeEntity).setRuleChainId(isA(UUID.class));
    verify(ruleNodeEntity).setSingletonMode(eq(true));
    verify(ruleNodeEntity).setType(eq("Type"));
    verify(ruleNodeEntity).toData();
    verify(ruleNodeRepository).findRuleNodesByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Configuration Search"));
    assertEquals(1, actualFindRuleNodesByTenantIdAndTypeResult.size());
    assertSame(ruleNode, actualFindRuleNodesByTenantIdAndTypeResult.get(0));
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String, String)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findRuleNodesByTenantIdAndType(TenantId, String, String)}
   */
  @Test
  public void testFindRuleNodesByTenantIdAndType_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult = jpaRuleNodeDao
        .findRuleNodesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", "Configuration Search");

    // Assert
    verify(ruleNodeRepository).findRuleNodesByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Configuration Search"));
    assertTrue(actualFindRuleNodesByTenantIdAndTypeResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByType() throws IOException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> content = new ArrayList<>();
    content.add(ruleNodeEntity);
    PageImpl<RuleNodeEntity> pageImpl = new PageImpl<>(content);
    when(ruleNodeRepository.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult = jpaRuleNodeDao.findAllRuleNodesByType("Type",
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository).findAllRuleNodesByType(eq("Type"), eq(""), isA(Pageable.class));
    List<RuleNode> data = actualFindAllRuleNodesByTypeResult.getData();
    assertEquals(1, data.size());
    RuleNode getResult = data.get(0);
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
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", getResult.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
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
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleChainId ruleChainId = getResult.getRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId externalId = getResult.getExternalId();
    assertEquals(EntityType.RULE_NODE, externalId.getEntityType());
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
    assertTrue(externalId.isNullUid());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, externalId.getId());
    assertSame(uuidId, ruleChainId.getId());
    assertSame(additionalInfo, getResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult = jpaRuleNodeDao.findAllRuleNodesByType("Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeRepository).findAllRuleNodesByType(eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodesByTypeResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodesByTypeResult.getTotalPages());
    assertFalse(actualFindAllRuleNodesByTypeResult.hasNext());
    assertTrue(actualFindAllRuleNodesByTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByType_thenReturnDataFirstIsRuleNode() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = mock(RuleNodeEntity.class);
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeEntity.toData()).thenReturn(ruleNode);
    doNothing().when(ruleNodeEntity).setCreatedTime(anyLong());
    doNothing().when(ruleNodeEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleNodeEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleNodeEntity).setConfigurationVersion(anyInt());
    doNothing().when(ruleNodeEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleNodeEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setName(Mockito.<String>any());
    doNothing().when(ruleNodeEntity).setQueueName(Mockito.<String>any());
    doNothing().when(ruleNodeEntity).setRuleChainId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setSingletonMode(anyBoolean());
    doNothing().when(ruleNodeEntity).setType(Mockito.<String>any());
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(-1);
    ruleNodeEntity.setCreatedTime(-1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity.setQueueName("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> content = new ArrayList<>();
    content.add(ruleNodeEntity);
    PageImpl<RuleNodeEntity> pageImpl = new PageImpl<>(content);
    when(ruleNodeRepository.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult = jpaRuleNodeDao.findAllRuleNodesByType("Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeEntity).setCreatedTime(eq(-1L));
    verify(ruleNodeEntity).setId(isA(UUID.class));
    verify(ruleNodeEntity).setUuid(isA(UUID.class));
    verify(ruleNodeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleNodeEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleNodeEntity).setConfigurationVersion(eq(-1));
    verify(ruleNodeEntity).setDebugMode(eq(true));
    verify(ruleNodeEntity).setExternalId(isA(UUID.class));
    verify(ruleNodeEntity).setName(eq("org.thingsboard.server.dao.model.sql.RuleNodeEntity"));
    verify(ruleNodeEntity).setQueueName(eq("org.thingsboard.server.dao.model.sql.RuleNodeEntity"));
    verify(ruleNodeEntity).setRuleChainId(isA(UUID.class));
    verify(ruleNodeEntity).setSingletonMode(eq(true));
    verify(ruleNodeEntity).setType(eq("org.thingsboard.server.dao.model.sql.RuleNodeEntity"));
    verify(ruleNodeEntity).toData();
    verify(ruleNodeRepository).findAllRuleNodesByType(eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<RuleNode> data = actualFindAllRuleNodesByTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(ruleNode, data.get(0));
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult = jpaRuleNodeDao.findAllRuleNodesByType("Type",
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository).findAllRuleNodesByType(eq("Type"), eq(""), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodesByTypeResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodesByTypeResult.getTotalPages());
    assertFalse(actualFindAllRuleNodesByTypeResult.hasNext());
    assertTrue(actualFindAllRuleNodesByTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByTypeAndVersionLessThan() throws IOException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> content = new ArrayList<>();
    content.add(ruleNodeEntity);
    PageImpl<RuleNodeEntity> pageImpl = new PageImpl<>(content);
    when(ruleNodeRepository.findAllRuleNodesByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult = jpaRuleNodeDao
        .findAllRuleNodesByTypeAndVersionLessThan("Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository).findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), eq(""), isA(Pageable.class));
    List<RuleNode> data = actualFindAllRuleNodesByTypeAndVersionLessThanResult.getData();
    assertEquals(1, data.size());
    RuleNode getResult = data.get(0);
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
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", getResult.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
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
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleChainId ruleChainId = getResult.getRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, ruleChainId.getEntityType());
    RuleNodeId externalId = getResult.getExternalId();
    assertEquals(EntityType.RULE_NODE, externalId.getEntityType());
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
    assertTrue(externalId.isNullUid());
    assertTrue(ruleChainId.isNullUid());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, externalId.getId());
    assertSame(uuidId, ruleChainId.getId());
    assertSame(additionalInfo, getResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, getResult.getConfigurationBytes());
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByTypeAndVersionLessThan_thenReturnDataFirstIsRuleNode() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = mock(RuleNodeEntity.class);
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeEntity.toData()).thenReturn(ruleNode);
    doNothing().when(ruleNodeEntity).setCreatedTime(anyLong());
    doNothing().when(ruleNodeEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleNodeEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleNodeEntity).setConfigurationVersion(anyInt());
    doNothing().when(ruleNodeEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleNodeEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setName(Mockito.<String>any());
    doNothing().when(ruleNodeEntity).setQueueName(Mockito.<String>any());
    doNothing().when(ruleNodeEntity).setRuleChainId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setSingletonMode(anyBoolean());
    doNothing().when(ruleNodeEntity).setType(Mockito.<String>any());
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(-1);
    ruleNodeEntity.setCreatedTime(-1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity.setQueueName("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> content = new ArrayList<>();
    content.add(ruleNodeEntity);
    PageImpl<RuleNodeEntity> pageImpl = new PageImpl<>(content);
    when(ruleNodeRepository.findAllRuleNodesByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult = jpaRuleNodeDao
        .findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeEntity).setCreatedTime(eq(-1L));
    verify(ruleNodeEntity).setId(isA(UUID.class));
    verify(ruleNodeEntity).setUuid(isA(UUID.class));
    verify(ruleNodeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleNodeEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleNodeEntity).setConfigurationVersion(eq(-1));
    verify(ruleNodeEntity).setDebugMode(eq(true));
    verify(ruleNodeEntity).setExternalId(isA(UUID.class));
    verify(ruleNodeEntity).setName(eq("org.thingsboard.server.dao.model.sql.RuleNodeEntity"));
    verify(ruleNodeEntity).setQueueName(eq("org.thingsboard.server.dao.model.sql.RuleNodeEntity"));
    verify(ruleNodeEntity).setRuleChainId(isA(UUID.class));
    verify(ruleNodeEntity).setSingletonMode(eq(true));
    verify(ruleNodeEntity).setType(eq("org.thingsboard.server.dao.model.sql.RuleNodeEntity"));
    verify(ruleNodeEntity).toData();
    verify(ruleNodeRepository).findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), eq("Text Search"),
        isA(Pageable.class));
    List<RuleNode> data = actualFindAllRuleNodesByTypeAndVersionLessThanResult.getData();
    assertEquals(1, data.size());
    assertSame(ruleNode, data.get(0));
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByTypeAndVersionLessThan_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodesByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult = jpaRuleNodeDao
        .findAllRuleNodesByTypeAndVersionLessThan("Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository).findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), eq(""), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodesByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodesByTypeAndVersionLessThanResult.getTotalPages());
    assertFalse(actualFindAllRuleNodesByTypeAndVersionLessThanResult.hasNext());
    assertTrue(actualFindAllRuleNodesByTypeAndVersionLessThanResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByTypeAndVersionLessThan_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodesByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult = jpaRuleNodeDao
        .findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeRepository).findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodesByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodesByTypeAndVersionLessThanResult.getTotalPages());
    assertFalse(actualFindAllRuleNodesByTypeAndVersionLessThanResult.hasNext());
    assertTrue(actualFindAllRuleNodesByTypeAndVersionLessThanResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_givenOne_thenCallsGetPage() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodeIdsByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult = jpaRuleNodeDao
        .findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleNodeRepository).findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalPages());
    assertFalse(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.hasNext());
    assertTrue(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(ruleNodeRepository.findAllRuleNodeIdsByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult = jpaRuleNodeDao
        .findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository).findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(Pageable.class));
    List<RuleNodeId> data = actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getData();
    assertEquals(1, data.size());
    RuleNodeId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(EntityType.RULE_NODE, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   * <ul>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(ruleNodeRepository.findAllRuleNodeIdsByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult = jpaRuleNodeDao
        .findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository).findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(Pageable.class));
    List<RuleNodeId> data = actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(data.get(0), data.get(1));
  }

  /**
   * Test
   * {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleNodeRepository.findAllRuleNodeIdsByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult = jpaRuleNodeDao
        .findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeRepository).findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(Pageable.class));
    assertEquals(0L, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalElements());
    assertEquals(1, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getTotalPages());
    assertFalse(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.hasNext());
    assertTrue(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  public void testFindAllRuleNodeByIds_givenRuleNodeIdWithIdIsNull_uuid() {
    // Arrange
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any())).thenReturn(new ArrayList<>());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult = jpaRuleNodeDao.findAllRuleNodeByIds(ruleNodeIds);

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertTrue(actualFindAllRuleNodeByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  public void testFindAllRuleNodeByIds_givenRuleNodeIdWithIdIsNull_uuid2() {
    // Arrange
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any())).thenReturn(new ArrayList<>());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult = jpaRuleNodeDao.findAllRuleNodeByIds(ruleNodeIds);

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertTrue(actualFindAllRuleNodeByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   * <ul>
   *   <li>Then return first is {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  public void testFindAllRuleNodeByIds_thenReturnFirstIsRuleNode() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = mock(RuleNodeEntity.class);
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeEntity.toData()).thenReturn(ruleNode);
    doNothing().when(ruleNodeEntity).setCreatedTime(anyLong());
    doNothing().when(ruleNodeEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleNodeEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleNodeEntity).setConfigurationVersion(anyInt());
    doNothing().when(ruleNodeEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleNodeEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setName(Mockito.<String>any());
    doNothing().when(ruleNodeEntity).setQueueName(Mockito.<String>any());
    doNothing().when(ruleNodeEntity).setRuleChainId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setSingletonMode(anyBoolean());
    doNothing().when(ruleNodeEntity).setType(Mockito.<String>any());
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any())).thenReturn(ruleNodeEntityList);

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult = jpaRuleNodeDao.findAllRuleNodeByIds(new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    verify(ruleNodeEntity).setCreatedTime(eq(1L));
    verify(ruleNodeEntity).setId(isA(UUID.class));
    verify(ruleNodeEntity).setUuid(isA(UUID.class));
    verify(ruleNodeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleNodeEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleNodeEntity).setConfigurationVersion(eq(1));
    verify(ruleNodeEntity).setDebugMode(eq(true));
    verify(ruleNodeEntity).setExternalId(isA(UUID.class));
    verify(ruleNodeEntity).setName(eq("Name"));
    verify(ruleNodeEntity).setQueueName(eq("Queue Name"));
    verify(ruleNodeEntity).setRuleChainId(isA(UUID.class));
    verify(ruleNodeEntity).setSingletonMode(eq(true));
    verify(ruleNodeEntity).setType(eq("Type"));
    verify(ruleNodeEntity).toData();
    assertEquals(1, actualFindAllRuleNodeByIdsResult.size());
    assertSame(ruleNode, actualFindAllRuleNodeByIdsResult.get(0));
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   * <ul>
   *   <li>Then return first Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  public void testFindAllRuleNodeByIds_thenReturnFirstNameIsName() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any())).thenReturn(ruleNodeEntityList);

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult = jpaRuleNodeDao.findAllRuleNodeByIds(new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertEquals(1, actualFindAllRuleNodeByIdsResult.size());
    RuleNode getResult = actualFindAllRuleNodeByIdsResult.get(0);
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals("Type", getResult.getType());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  public void testFindAllRuleNodeByIds_thenReturnSizeIsTwo() throws UnsupportedEncodingException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    RuleNodeEntity ruleNodeEntity2 = new RuleNodeEntity();
    ruleNodeEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity2.setConfigurationVersion(0);
    ruleNodeEntity2.setCreatedTime(0L);
    ruleNodeEntity2.setDebugMode(false);
    ruleNodeEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setName("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity2.setQueueName("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity2.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity2.setSingletonMode(false);
    ruleNodeEntity2.setType("org.thingsboard.server.dao.model.sql.RuleNodeEntity");
    ruleNodeEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity2);
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any())).thenReturn(ruleNodeEntityList);

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult = jpaRuleNodeDao.findAllRuleNodeByIds(new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertEquals(2, actualFindAllRuleNodeByIdsResult.size());
    RuleNode getResult = actualFindAllRuleNodeByIdsResult.get(1);
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals("Type", getResult.getType());
    RuleNode getResult2 = actualFindAllRuleNodeByIdsResult.get(0);
    assertEquals("org.thingsboard.server.dao.model.sql.RuleNodeEntity", getResult2.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.RuleNodeEntity", getResult2.getQueueName());
    assertEquals("org.thingsboard.server.dao.model.sql.RuleNodeEntity", getResult2.getType());
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#findAllRuleNodeByIds(List)}
   */
  @Test
  public void testFindAllRuleNodeByIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(ruleNodeRepository.findAllById(Mockito.<Iterable<UUID>>any())).thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualFindAllRuleNodeByIdsResult = jpaRuleNodeDao.findAllRuleNodeByIds(new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).findAllById(isA(Iterable.class));
    assertTrue(actualFindAllRuleNodeByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  public void testFindByExternalIds_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualFindByExternalIdsResult = jpaRuleNodeDao.findByExternalIds(ruleChainId, new ArrayList<>());

    // Assert
    verify(ruleChainId).getId();
    verify(ruleNodeRepository).findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByExternalIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  public void testFindByExternalIds_givenRuleNodeIdWithIdIsNull_uuid() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeId> externalIds = new ArrayList<>();
    externalIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindByExternalIdsResult = jpaRuleNodeDao.findByExternalIds(ruleChainId, externalIds);

    // Assert
    verify(ruleChainId).getId();
    verify(ruleNodeRepository).findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByExternalIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  public void testFindByExternalIds_givenRuleNodeIdWithIdIsNull_uuid2() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeId> externalIds = new ArrayList<>();
    externalIds.add(new RuleNodeId(ModelConstants.NULL_UUID));
    externalIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindByExternalIdsResult = jpaRuleNodeDao.findByExternalIds(ruleChainId, externalIds);

    // Assert
    verify(ruleChainId).getId();
    verify(ruleNodeRepository).findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByExternalIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   * <ul>
   *   <li>Then first AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  public void testFindByExternalIds_thenFirstAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    RuleNodeEntity ruleNodeEntity = new RuleNodeEntity();
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(1);
    ruleNodeEntity.setCreatedTime(1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("Name");
    ruleNodeEntity.setQueueName("Queue Name");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("Type");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(ruleNodeEntityList);
    RuleChainId ruleChainId = new RuleChainId(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualFindByExternalIdsResult = jpaRuleNodeDao.findByExternalIds(ruleChainId, new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByExternalIdsResult.size());
    RuleNode getResult = actualFindByExternalIdsResult.get(0);
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
    assertEquals("Name", getResult.getName());
    assertEquals("Queue Name", getResult.getQueueName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", getResult.getType());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
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
    assertEquals(1, getResult.getConfigurationVersion());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleNodeId externalId = getResult.getExternalId();
    assertEquals(EntityType.RULE_NODE, externalId.getEntityType());
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
    assertTrue(externalId.isNullUid());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isSingletonMode());
    assertEquals(ruleChainId, getResult.getRuleChainId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, externalId.getId());
    assertSame(additionalInfo, getResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   * <ul>
   *   <li>Then return first is {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  public void testFindByExternalIds_thenReturnFirstIsRuleNode() {
    // Arrange
    RuleNodeEntity ruleNodeEntity = mock(RuleNodeEntity.class);
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeEntity.toData()).thenReturn(ruleNode);
    doNothing().when(ruleNodeEntity).setCreatedTime(anyLong());
    doNothing().when(ruleNodeEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleNodeEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleNodeEntity).setConfigurationVersion(anyInt());
    doNothing().when(ruleNodeEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleNodeEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setName(Mockito.<String>any());
    doNothing().when(ruleNodeEntity).setQueueName(Mockito.<String>any());
    doNothing().when(ruleNodeEntity).setRuleChainId(Mockito.<UUID>any());
    doNothing().when(ruleNodeEntity).setSingletonMode(anyBoolean());
    doNothing().when(ruleNodeEntity).setType(Mockito.<String>any());
    ruleNodeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleNodeEntity.setConfigurationVersion(-1);
    ruleNodeEntity.setCreatedTime(-1L);
    ruleNodeEntity.setDebugMode(true);
    ruleNodeEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setName("42");
    ruleNodeEntity.setQueueName("42");
    ruleNodeEntity.setRuleChainId(ModelConstants.NULL_UUID);
    ruleNodeEntity.setSingletonMode(true);
    ruleNodeEntity.setType("42");
    ruleNodeEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<RuleNodeEntity> ruleNodeEntityList = new ArrayList<>();
    ruleNodeEntityList.add(ruleNodeEntity);
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(ruleNodeEntityList);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualFindByExternalIdsResult = jpaRuleNodeDao.findByExternalIds(ruleChainId, new ArrayList<>());

    // Assert
    verify(ruleChainId).getId();
    verify(ruleNodeEntity).setCreatedTime(eq(-1L));
    verify(ruleNodeEntity).setId(isA(UUID.class));
    verify(ruleNodeEntity).setUuid(isA(UUID.class));
    verify(ruleNodeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleNodeEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleNodeEntity).setConfigurationVersion(eq(-1));
    verify(ruleNodeEntity).setDebugMode(eq(true));
    verify(ruleNodeEntity).setExternalId(isA(UUID.class));
    verify(ruleNodeEntity).setName(eq("42"));
    verify(ruleNodeEntity).setQueueName(eq("42"));
    verify(ruleNodeEntity).setRuleChainId(isA(UUID.class));
    verify(ruleNodeEntity).setSingletonMode(eq(true));
    verify(ruleNodeEntity).setType(eq("42"));
    verify(ruleNodeEntity).toData();
    verify(ruleNodeRepository).findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByExternalIdsResult.size());
    assertSame(ruleNode, actualFindByExternalIdsResult.get(0));
  }

  /**
   * Test {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}.
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleNodeDao#findByExternalIds(RuleChainId, List)}
   */
  @Test
  public void testFindByExternalIds_whenRuleChainIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(ruleNodeRepository.findRuleNodesByRuleChainIdAndExternalIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());
    RuleChainId ruleChainId = new RuleChainId(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualFindByExternalIdsResult = jpaRuleNodeDao.findByExternalIds(ruleChainId, new ArrayList<>());

    // Assert
    verify(ruleNodeRepository).findRuleNodesByRuleChainIdAndExternalIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByExternalIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleNodeDao#deleteByIdIn(List)}.
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#deleteByIdIn(List)}
   */
  @Test
  public void testDeleteByIdIn_givenRuleNodeIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(ruleNodeRepository).deleteAllById(Mockito.<Iterable<UUID>>any());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    jpaRuleNodeDao.deleteByIdIn(ruleNodeIds);

    // Assert that nothing has changed
    verify(ruleNodeRepository).deleteAllById(isA(Iterable.class));
  }

  /**
   * Test {@link JpaRuleNodeDao#deleteByIdIn(List)}.
   * <ul>
   *   <li>Given {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#deleteByIdIn(List)}
   */
  @Test
  public void testDeleteByIdIn_givenRuleNodeIdWithIdIsNull_uuid2() {
    // Arrange
    doNothing().when(ruleNodeRepository).deleteAllById(Mockito.<Iterable<UUID>>any());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    jpaRuleNodeDao.deleteByIdIn(ruleNodeIds);

    // Assert that nothing has changed
    verify(ruleNodeRepository).deleteAllById(isA(Iterable.class));
  }

  /**
   * Test {@link JpaRuleNodeDao#deleteByIdIn(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link CrudRepository#deleteAllById(Iterable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleNodeDao#deleteByIdIn(List)}
   */
  @Test
  public void testDeleteByIdIn_whenArrayList_thenCallsDeleteAllById() {
    // Arrange
    doNothing().when(ruleNodeRepository).deleteAllById(Mockito.<Iterable<UUID>>any());

    // Act
    jpaRuleNodeDao.deleteByIdIn(new ArrayList<>());

    // Assert that nothing has changed
    verify(ruleNodeRepository).deleteAllById(isA(Iterable.class));
  }
}
