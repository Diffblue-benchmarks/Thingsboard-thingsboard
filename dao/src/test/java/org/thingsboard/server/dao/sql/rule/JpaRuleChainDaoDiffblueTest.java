package org.thingsboard.server.dao.sql.rule;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
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
import java.util.Collection;
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
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.RuleChainEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaRuleChainDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaRuleChainDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaRuleChainDao jpaRuleChainDao;

  @MockBean
  private RuleChainRepository ruleChainRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaRuleChainDao#getEntityClass()}
   *   <li>{@link JpaRuleChainDao#getEntityType()}
   *   <li>{@link JpaRuleChainDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaRuleChainDao jpaRuleChainDao = new JpaRuleChainDao();

    // Act
    Class<RuleChainEntity> actualEntityClass = jpaRuleChainDao.getEntityClass();
    EntityType actualEntityType = jpaRuleChainDao.getEntityType();

    // Assert
    assertNull(jpaRuleChainDao.getRepository());
    assertEquals(EntityType.RULE_CHAIN, actualEntityType);
    Class<RuleChainEntity> expectedEntityClass = RuleChainEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantId() throws IOException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find rule chains by tenantId [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdResult = jpaRuleChainDao.findRuleChainsByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Try to find rule chains by tenantId [{}] and pageLink [{}]", getResult.getName());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleChainId externalId = getResult.getExternalId();
    assertEquals(EntityType.RULE_CHAIN, externalId.getEntityType());
    RuleNodeId firstRuleNodeId = getResult.getFirstRuleNodeId();
    assertEquals(EntityType.RULE_NODE, firstRuleNodeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertEquals(RuleChainType.CORE, getResult.getType());
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
    assertTrue(firstRuleNodeId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isDefault());
    assertTrue(getResult.isRoot());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firstRuleNodeId.getId());
    assertSame(additionalInfo, getResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdResult = jpaRuleChainDao
        .findRuleChainsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantId_thenReturnDataFirstIsRuleChain() {
    // Arrange
    RuleChainEntity ruleChainEntity = mock(RuleChainEntity.class);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainEntity.toData()).thenReturn(ruleChain);
    doNothing().when(ruleChainEntity).setCreatedTime(anyLong());
    doNothing().when(ruleChainEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setVersion(Mockito.<Long>any());
    doNothing().when(ruleChainEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleChainEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setFirstRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setName(Mockito.<String>any());
    doNothing().when(ruleChainEntity).setRoot(anyBoolean());
    doNothing().when(ruleChainEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setType(Mockito.<RuleChainType>any());
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(-1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("org.thingsboard.server.dao.model.sql.RuleChainEntity");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(-1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdResult = jpaRuleChainDao
        .findRuleChainsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainEntity).setCreatedTime(eq(-1L));
    verify(ruleChainEntity).setId(isA(UUID.class));
    verify(ruleChainEntity).setUuid(isA(UUID.class));
    verify(ruleChainEntity).setVersion(eq(-1L));
    verify(ruleChainEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleChainEntity).setDebugMode(eq(true));
    verify(ruleChainEntity).setExternalId(isA(UUID.class));
    verify(ruleChainEntity).setFirstRuleNodeId(isA(UUID.class));
    verify(ruleChainEntity).setName(eq("org.thingsboard.server.dao.model.sql.RuleChainEntity"));
    verify(ruleChainEntity).setRoot(eq(true));
    verify(ruleChainEntity).setTenantId(isA(UUID.class));
    verify(ruleChainEntity).setType(eq(RuleChainType.CORE));
    verify(ruleChainEntity).toData();
    verify(ruleChainRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(ruleChain, data.get(0));
  }

  /**
   * Test {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdResult = jpaRuleChainDao
        .findRuleChainsByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndType() throws IOException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(3L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find rule chains by tenantId [{}], type [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(3L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndTypeResult = jpaRuleChainDao
        .findRuleChainsByTenantIdAndType(tenantId, RuleChainType.CORE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE), isNull(),
        isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Try to find rule chains by tenantId [{}], type [{}] and pageLink [{}]", getResult.getName());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleChainId externalId = getResult.getExternalId();
    assertEquals(EntityType.RULE_CHAIN, externalId.getEntityType());
    RuleNodeId firstRuleNodeId = getResult.getFirstRuleNodeId();
    assertEquals(EntityType.RULE_NODE, firstRuleNodeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertEquals(RuleChainType.CORE, getResult.getType());
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
    assertTrue(firstRuleNodeId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isDefault());
    assertTrue(getResult.isRoot());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firstRuleNodeId.getId());
    assertSame(additionalInfo, getResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, getResult.getConfigurationBytes());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndTypeResult = jpaRuleChainDao
        .findRuleChainsByTenantIdAndType(ModelConstants.NULL_UUID, RuleChainType.CORE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository).findByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndType_thenReturnDataFirstIsRuleChain() {
    // Arrange
    RuleChainEntity ruleChainEntity = mock(RuleChainEntity.class);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainEntity.toData()).thenReturn(ruleChain);
    doNothing().when(ruleChainEntity).setCreatedTime(anyLong());
    doNothing().when(ruleChainEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setVersion(Mockito.<Long>any());
    doNothing().when(ruleChainEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleChainEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setFirstRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setName(Mockito.<String>any());
    doNothing().when(ruleChainEntity).setRoot(anyBoolean());
    doNothing().when(ruleChainEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setType(Mockito.<RuleChainType>any());
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(2L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("org.thingsboard.server.dao.model.sql.RuleChainEntity");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(2L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndTypeResult = jpaRuleChainDao
        .findRuleChainsByTenantIdAndType(ModelConstants.NULL_UUID, RuleChainType.CORE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainEntity).setCreatedTime(eq(2L));
    verify(ruleChainEntity).setId(isA(UUID.class));
    verify(ruleChainEntity).setUuid(isA(UUID.class));
    verify(ruleChainEntity).setVersion(eq(2L));
    verify(ruleChainEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleChainEntity).setDebugMode(eq(true));
    verify(ruleChainEntity).setExternalId(isA(UUID.class));
    verify(ruleChainEntity).setFirstRuleNodeId(isA(UUID.class));
    verify(ruleChainEntity).setName(eq("org.thingsboard.server.dao.model.sql.RuleChainEntity"));
    verify(ruleChainEntity).setRoot(eq(true));
    verify(ruleChainEntity).setTenantId(isA(UUID.class));
    verify(ruleChainEntity).setType(eq(RuleChainType.CORE));
    verify(ruleChainEntity).toData();
    verify(ruleChainRepository).findByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE), eq("Text Search"),
        isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(ruleChain, data.get(0));
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndType(UUID, RuleChainType, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndTypeResult = jpaRuleChainDao.findRuleChainsByTenantIdAndType(
        ModelConstants.NULL_UUID, RuleChainType.CORE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findRootRuleChainByTenantIdAndType(UUID, RuleChainType)}.
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRootRuleChainByTenantIdAndType(UUID, RuleChainType)}
   */
  @Test
  public void testFindRootRuleChainByTenantIdAndType() throws IOException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndTypeAndRootIsTrue(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChainEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    RuleChain actualFindRootRuleChainByTenantIdAndTypeResult = jpaRuleChainDao
        .findRootRuleChainByTenantIdAndType(tenantId, RuleChainType.CORE);

    // Assert
    verify(ruleChainRepository).findByTenantIdAndTypeAndRootIsTrue(isA(UUID.class), eq(RuleChainType.CORE));
    JsonNode additionalInfo = actualFindRootRuleChainByTenantIdAndTypeResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = actualFindRootRuleChainByTenantIdAndTypeResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Name", actualFindRootRuleChainByTenantIdAndTypeResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindRootRuleChainByTenantIdAndTypeResult.getVersion().longValue());
    assertEquals(1L, actualFindRootRuleChainByTenantIdAndTypeResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleChainId externalId = actualFindRootRuleChainByTenantIdAndTypeResult.getExternalId();
    assertEquals(EntityType.RULE_CHAIN, externalId.getEntityType());
    RuleNodeId firstRuleNodeId = actualFindRootRuleChainByTenantIdAndTypeResult.getFirstRuleNodeId();
    assertEquals(EntityType.RULE_NODE, firstRuleNodeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertEquals(RuleChainType.CORE, actualFindRootRuleChainByTenantIdAndTypeResult.getType());
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
    assertTrue(firstRuleNodeId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertTrue(actualFindRootRuleChainByTenantIdAndTypeResult.isDebugMode());
    assertTrue(actualFindRootRuleChainByTenantIdAndTypeResult.isDefault());
    assertTrue(actualFindRootRuleChainByTenantIdAndTypeResult.isRoot());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, actualFindRootRuleChainByTenantIdAndTypeResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, actualFindRootRuleChainByTenantIdAndTypeResult.getUuidId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firstRuleNodeId.getId());
    assertSame(additionalInfo, actualFindRootRuleChainByTenantIdAndTypeResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes,
        actualFindRootRuleChainByTenantIdAndTypeResult.getConfigurationBytes());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findRootRuleChainByTenantIdAndType(UUID, RuleChainType)}.
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRootRuleChainByTenantIdAndType(UUID, RuleChainType)}
   */
  @Test
  public void testFindRootRuleChainByTenantIdAndType_thenReturnRuleChain() {
    // Arrange
    RuleChainEntity ruleChainEntity = mock(RuleChainEntity.class);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainEntity.toData()).thenReturn(ruleChain);
    doNothing().when(ruleChainEntity).setCreatedTime(anyLong());
    doNothing().when(ruleChainEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setVersion(Mockito.<Long>any());
    doNothing().when(ruleChainEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleChainEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setFirstRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setName(Mockito.<String>any());
    doNothing().when(ruleChainEntity).setRoot(anyBoolean());
    doNothing().when(ruleChainEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setType(Mockito.<RuleChainType>any());
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndTypeAndRootIsTrue(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChainEntity);

    // Act
    RuleChain actualFindRootRuleChainByTenantIdAndTypeResult = jpaRuleChainDao
        .findRootRuleChainByTenantIdAndType(ModelConstants.NULL_UUID, RuleChainType.CORE);

    // Assert
    verify(ruleChainEntity).setCreatedTime(eq(1L));
    verify(ruleChainEntity).setId(isA(UUID.class));
    verify(ruleChainEntity).setUuid(isA(UUID.class));
    verify(ruleChainEntity).setVersion(eq(1L));
    verify(ruleChainEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleChainEntity).setDebugMode(eq(true));
    verify(ruleChainEntity).setExternalId(isA(UUID.class));
    verify(ruleChainEntity).setFirstRuleNodeId(isA(UUID.class));
    verify(ruleChainEntity).setName(eq("Name"));
    verify(ruleChainEntity).setRoot(eq(true));
    verify(ruleChainEntity).setTenantId(isA(UUID.class));
    verify(ruleChainEntity).setType(eq(RuleChainType.CORE));
    verify(ruleChainEntity).toData();
    verify(ruleChainRepository).findByTenantIdAndTypeAndRootIsTrue(isA(UUID.class), eq(RuleChainType.CORE));
    assertSame(ruleChain, actualFindRootRuleChainByTenantIdAndTypeResult);
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndEdgeId() throws IOException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(3L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find rule chains by tenantId [{}], edgeId [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(3L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID edgeId = ModelConstants.NULL_UUID;

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult = jpaRuleChainDao
        .findRuleChainsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Try to find rule chains by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getName());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleChainId externalId = getResult.getExternalId();
    assertEquals(EntityType.RULE_CHAIN, externalId.getEntityType());
    RuleNodeId firstRuleNodeId = getResult.getFirstRuleNodeId();
    assertEquals(EntityType.RULE_NODE, firstRuleNodeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(RuleChainType.CORE, getResult.getType());
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
    assertTrue(firstRuleNodeId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isDefault());
    assertTrue(getResult.isRoot());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(edgeId, getResult.getUuidId());
    assertSame(edgeId, externalId.getId());
    assertSame(edgeId, firstRuleNodeId.getId());
    assertSame(additionalInfo, getResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, getResult.getConfigurationBytes());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndEdgeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult = jpaRuleChainDao
        .findRuleChainsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndEdgeId_thenReturnDataFirstIsRuleChain() {
    // Arrange
    RuleChainEntity ruleChainEntity = mock(RuleChainEntity.class);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainEntity.toData()).thenReturn(ruleChain);
    doNothing().when(ruleChainEntity).setCreatedTime(anyLong());
    doNothing().when(ruleChainEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setVersion(Mockito.<Long>any());
    doNothing().when(ruleChainEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleChainEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setFirstRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setName(Mockito.<String>any());
    doNothing().when(ruleChainEntity).setRoot(anyBoolean());
    doNothing().when(ruleChainEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setType(Mockito.<RuleChainType>any());
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(2L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("org.thingsboard.server.dao.model.sql.RuleChainEntity");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(2L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult = jpaRuleChainDao
        .findRuleChainsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainEntity).setCreatedTime(eq(2L));
    verify(ruleChainEntity).setId(isA(UUID.class));
    verify(ruleChainEntity).setUuid(isA(UUID.class));
    verify(ruleChainEntity).setVersion(eq(2L));
    verify(ruleChainEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleChainEntity).setDebugMode(eq(true));
    verify(ruleChainEntity).setExternalId(isA(UUID.class));
    verify(ruleChainEntity).setFirstRuleNodeId(isA(UUID.class));
    verify(ruleChainEntity).setName(eq("org.thingsboard.server.dao.model.sql.RuleChainEntity"));
    verify(ruleChainEntity).setRoot(eq(true));
    verify(ruleChainEntity).setTenantId(isA(UUID.class));
    verify(ruleChainEntity).setType(eq(RuleChainType.CORE));
    verify(ruleChainEntity).toData();
    verify(ruleChainRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<RuleChain> data = actualFindRuleChainsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    assertSame(ruleChain, data.get(0));
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findRuleChainsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndEdgeId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult = jpaRuleChainDao
        .findRuleChainsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindRuleChainsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindRuleChainsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindRuleChainsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindRuleChainsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAutoAssignToEdgeRuleChainsByTenantId() {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find auto assign to edge rule chains by tenantId [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findAutoAssignByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult = jpaRuleChainDao
        .findAutoAssignToEdgeRuleChainsByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findAutoAssignByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<RuleChain> data = actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    assertEquals("Try to find auto assign to edge rule chains by tenantId [{}]", getResult.getName());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(RuleChainType.CORE, getResult.getType());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isDefault());
    assertTrue(getResult.isRoot());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAutoAssignToEdgeRuleChainsByTenantId_thenReturnDataFirstIsRuleChain() {
    // Arrange
    RuleChainEntity ruleChainEntity = mock(RuleChainEntity.class);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainEntity.toData()).thenReturn(ruleChain);
    doNothing().when(ruleChainEntity).setCreatedTime(anyLong());
    doNothing().when(ruleChainEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setVersion(Mockito.<Long>any());
    doNothing().when(ruleChainEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleChainEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setFirstRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setName(Mockito.<String>any());
    doNothing().when(ruleChainEntity).setRoot(anyBoolean());
    doNothing().when(ruleChainEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setType(Mockito.<RuleChainType>any());
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(-1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("org.thingsboard.server.dao.model.sql.RuleChainEntity");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(-1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findAutoAssignByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult = jpaRuleChainDao
        .findAutoAssignToEdgeRuleChainsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainEntity).setCreatedTime(eq(-1L));
    verify(ruleChainEntity).setId(isA(UUID.class));
    verify(ruleChainEntity).setUuid(isA(UUID.class));
    verify(ruleChainEntity).setVersion(eq(-1L));
    verify(ruleChainEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleChainEntity).setDebugMode(eq(true));
    verify(ruleChainEntity).setExternalId(isA(UUID.class));
    verify(ruleChainEntity).setFirstRuleNodeId(isA(UUID.class));
    verify(ruleChainEntity).setName(eq("org.thingsboard.server.dao.model.sql.RuleChainEntity"));
    verify(ruleChainEntity).setRoot(eq(true));
    verify(ruleChainEntity).setTenantId(isA(UUID.class));
    verify(ruleChainEntity).setType(eq(RuleChainType.CORE));
    verify(ruleChainEntity).toData();
    verify(ruleChainRepository).findAutoAssignByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(ruleChain, data.get(0));
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAutoAssignToEdgeRuleChainsByTenantId_thenReturnDataSizeIsTwo()
      throws UnsupportedEncodingException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find auto assign to edge rule chains by tenantId [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(0L);
    ruleChainEntity2.setDebugMode(false);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("Name");
    ruleChainEntity2.setRoot(false);
    ruleChainEntity2.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setType(RuleChainType.EDGE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(0L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity2);
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findAutoAssignByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult = jpaRuleChainDao
        .findAutoAssignToEdgeRuleChainsByTenantId(tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findAutoAssignByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<RuleChain> data = actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getData();
    assertEquals(2, data.size());
    RuleChain getResult = data.get(0);
    assertEquals("Name", getResult.getName());
    RuleChain getResult2 = data.get(1);
    assertEquals("Try to find auto assign to edge rule chains by tenantId [{}]", getResult2.getName());
    assertEquals(0L, getResult.getVersion().longValue());
    assertEquals(1L, getResult2.getVersion().longValue());
    assertEquals(1L, getResult2.getCreatedTime());
    assertEquals(2L, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalElements());
    assertEquals(RuleChainType.CORE, getResult2.getType());
    assertEquals(RuleChainType.EDGE, getResult.getType());
    assertTrue(getResult2.isDebugMode());
    assertTrue(getResult2.isDefault());
    assertTrue(getResult2.isRoot());
    assertSame(tenantId, getResult2.getUuidId());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, getResult2.getConfigurationBytes());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAutoAssignToEdgeRuleChainsByTenantId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findAutoAssignByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult = jpaRuleChainDao
        .findAutoAssignToEdgeRuleChainsByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findAutoAssignByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.hasNext());
    assertTrue(actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findAutoAssignToEdgeRuleChainsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAutoAssignToEdgeRuleChainsByTenantId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(ruleChainRepository.findAutoAssignByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult = jpaRuleChainDao
        .findAutoAssignToEdgeRuleChainsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository).findAutoAssignByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.hasNext());
    assertTrue(actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)}.
   * <ul>
   *   <li>Then return first is {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)}
   */
  @Test
  public void testFindByTenantIdAndTypeAndName_thenReturnFirstIsRuleChain() {
    // Arrange
    RuleChainEntity ruleChainEntity = mock(RuleChainEntity.class);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainEntity.toData()).thenReturn(ruleChain);
    doNothing().when(ruleChainEntity).setCreatedTime(anyLong());
    doNothing().when(ruleChainEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setVersion(Mockito.<Long>any());
    doNothing().when(ruleChainEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleChainEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setFirstRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setName(Mockito.<String>any());
    doNothing().when(ruleChainEntity).setRoot(anyBoolean());
    doNothing().when(ruleChainEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setType(Mockito.<RuleChainType>any());
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> ruleChainEntityList = new ArrayList<>();
    ruleChainEntityList.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantIdAndTypeAndName(Mockito.<UUID>any(), Mockito.<RuleChainType>any(),
        Mockito.<String>any())).thenReturn(ruleChainEntityList);

    // Act
    Collection<RuleChain> actualFindByTenantIdAndTypeAndNameResult = jpaRuleChainDao
        .findByTenantIdAndTypeAndName(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, "Name");

    // Assert
    verify(ruleChainEntity).setCreatedTime(eq(1L));
    verify(ruleChainEntity).setId(isA(UUID.class));
    verify(ruleChainEntity).setUuid(isA(UUID.class));
    verify(ruleChainEntity).setVersion(eq(1L));
    verify(ruleChainEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleChainEntity).setDebugMode(eq(true));
    verify(ruleChainEntity).setExternalId(isA(UUID.class));
    verify(ruleChainEntity).setFirstRuleNodeId(isA(UUID.class));
    verify(ruleChainEntity).setName(eq("Name"));
    verify(ruleChainEntity).setRoot(eq(true));
    verify(ruleChainEntity).setTenantId(isA(UUID.class));
    verify(ruleChainEntity).setType(eq(RuleChainType.CORE));
    verify(ruleChainEntity).toData();
    verify(ruleChainRepository).findByTenantIdAndTypeAndName(isA(UUID.class), eq(RuleChainType.CORE), eq("Name"));
    assertTrue(actualFindByTenantIdAndTypeAndNameResult instanceof List);
    assertEquals(1, actualFindByTenantIdAndTypeAndNameResult.size());
    assertSame(ruleChain, ((List<RuleChain>) actualFindByTenantIdAndTypeAndNameResult).get(0));
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)}
   */
  @Test
  public void testFindByTenantIdAndTypeAndName_thenReturnSizeIsTwo() {
    // Arrange
    RuleChainEntity ruleChainEntity = mock(RuleChainEntity.class);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainEntity.toData()).thenReturn(ruleChain);
    doNothing().when(ruleChainEntity).setCreatedTime(anyLong());
    doNothing().when(ruleChainEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setVersion(Mockito.<Long>any());
    doNothing().when(ruleChainEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleChainEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setFirstRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setName(Mockito.<String>any());
    doNothing().when(ruleChainEntity).setRoot(anyBoolean());
    doNothing().when(ruleChainEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setType(Mockito.<RuleChainType>any());
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    RuleChainEntity ruleChainEntity2 = new RuleChainEntity();
    ruleChainEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity2.setCreatedTime(-1L);
    ruleChainEntity2.setDebugMode(true);
    ruleChainEntity2.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setId(ModelConstants.NULL_UUID);
    ruleChainEntity2.setName("42");
    ruleChainEntity2.setRoot(true);
    UUID tenantId = UUID.randomUUID();
    ruleChainEntity2.setTenantId(tenantId);
    ruleChainEntity2.setType(RuleChainType.CORE);
    ruleChainEntity2.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity2.setVersion(-1L);

    ArrayList<RuleChainEntity> ruleChainEntityList = new ArrayList<>();
    ruleChainEntityList.add(ruleChainEntity2);
    ruleChainEntityList.add(ruleChainEntity);
    when(ruleChainRepository.findByTenantIdAndTypeAndName(Mockito.<UUID>any(), Mockito.<RuleChainType>any(),
        Mockito.<String>any())).thenReturn(ruleChainEntityList);

    // Act
    Collection<RuleChain> actualFindByTenantIdAndTypeAndNameResult = jpaRuleChainDao
        .findByTenantIdAndTypeAndName(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, "Name");

    // Assert
    verify(ruleChainEntity).setCreatedTime(eq(1L));
    verify(ruleChainEntity).setId(isA(UUID.class));
    verify(ruleChainEntity).setUuid(isA(UUID.class));
    verify(ruleChainEntity).setVersion(eq(1L));
    verify(ruleChainEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleChainEntity).setDebugMode(eq(true));
    verify(ruleChainEntity).setExternalId(isA(UUID.class));
    verify(ruleChainEntity).setFirstRuleNodeId(isA(UUID.class));
    verify(ruleChainEntity).setName(eq("Name"));
    verify(ruleChainEntity).setRoot(eq(true));
    verify(ruleChainEntity).setTenantId(isA(UUID.class));
    verify(ruleChainEntity).setType(eq(RuleChainType.CORE));
    verify(ruleChainEntity).toData();
    verify(ruleChainRepository).findByTenantIdAndTypeAndName(isA(UUID.class), eq(RuleChainType.CORE), eq("Name"));
    assertTrue(actualFindByTenantIdAndTypeAndNameResult instanceof List);
    assertEquals(2, actualFindByTenantIdAndTypeAndNameResult.size());
    RuleChain getResult = ((List<RuleChain>) actualFindByTenantIdAndTypeAndNameResult).get(0);
    assertEquals("42", getResult.getName());
    assertEquals(-1L, getResult.getVersion().longValue());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(ruleChain, ((List<RuleChain>) actualFindByTenantIdAndTypeAndNameResult).get(1));
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findByTenantIdAndTypeAndName(TenantId, RuleChainType, String)}
   */
  @Test
  public void testFindByTenantIdAndTypeAndName_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(ruleChainRepository.findByTenantIdAndTypeAndName(Mockito.<UUID>any(), Mockito.<RuleChainType>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    Collection<RuleChain> actualFindByTenantIdAndTypeAndNameResult = jpaRuleChainDao
        .findByTenantIdAndTypeAndName(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, "Name");

    // Assert
    verify(ruleChainRepository).findByTenantIdAndTypeAndName(isA(UUID.class), eq(RuleChainType.CORE), eq("Name"));
    assertTrue(actualFindByTenantIdAndTypeAndNameResult instanceof List);
    assertTrue(actualFindByTenantIdAndTypeAndNameResult.isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleChainDao#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(ruleChainRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaRuleChainDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ruleChainEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    RuleChain actualFindByTenantIdAndExternalIdResult = jpaRuleChainDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(ruleChainRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    JsonNode additionalInfo = actualFindByTenantIdAndExternalIdResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleChainId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.RULE_CHAIN, externalId2.getEntityType());
    RuleNodeId firstRuleNodeId = actualFindByTenantIdAndExternalIdResult.getFirstRuleNodeId();
    assertEquals(EntityType.RULE_NODE, firstRuleNodeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(RuleChainType.CORE, actualFindByTenantIdAndExternalIdResult.getType());
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
    assertTrue(externalId2.isNullUid());
    assertTrue(firstRuleNodeId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDebugMode());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isDefault());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isRoot());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
    assertSame(externalId, externalId2.getId());
    assertSame(externalId, firstRuleNodeId.getId());
    assertSame(additionalInfo, actualFindByTenantIdAndExternalIdResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualFindByTenantIdAndExternalIdResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnRuleChain() {
    // Arrange
    RuleChainEntity ruleChainEntity = mock(RuleChainEntity.class);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainEntity.toData()).thenReturn(ruleChain);
    doNothing().when(ruleChainEntity).setCreatedTime(anyLong());
    doNothing().when(ruleChainEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setVersion(Mockito.<Long>any());
    doNothing().when(ruleChainEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleChainEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setFirstRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setName(Mockito.<String>any());
    doNothing().when(ruleChainEntity).setRoot(anyBoolean());
    doNothing().when(ruleChainEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setType(Mockito.<RuleChainType>any());
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ruleChainEntity);

    // Act
    RuleChain actualFindByTenantIdAndExternalIdResult = jpaRuleChainDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(ruleChainRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    verify(ruleChainEntity).setCreatedTime(eq(1L));
    verify(ruleChainEntity).setId(isA(UUID.class));
    verify(ruleChainEntity).setUuid(isA(UUID.class));
    verify(ruleChainEntity).setVersion(eq(1L));
    verify(ruleChainEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleChainEntity).setDebugMode(eq(true));
    verify(ruleChainEntity).setExternalId(isA(UUID.class));
    verify(ruleChainEntity).setFirstRuleNodeId(isA(UUID.class));
    verify(ruleChainEntity).setName(eq("Name"));
    verify(ruleChainEntity).setRoot(eq(true));
    verify(ruleChainEntity).setTenantId(isA(UUID.class));
    verify(ruleChainEntity).setType(eq(RuleChainType.CORE));
    verify(ruleChainEntity).toData();
    assertSame(ruleChain, actualFindByTenantIdAndExternalIdResult);
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleChain> actualFindByTenantIdResult = jpaRuleChainDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenDataFirstAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Try to find rule chains by tenantId [{}] and pageLink [{}]");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<RuleChain> actualFindByTenantIdResult = jpaRuleChainDao.findByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<RuleChain> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    RuleChain getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Try to find rule chains by tenantId [{}] and pageLink [{}]", getResult.getName());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleChainId externalId = getResult.getExternalId();
    assertEquals(EntityType.RULE_CHAIN, externalId.getEntityType());
    RuleNodeId firstRuleNodeId = getResult.getFirstRuleNodeId();
    assertEquals(EntityType.RULE_NODE, firstRuleNodeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertEquals(RuleChainType.CORE, getResult.getType());
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
    assertTrue(firstRuleNodeId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertTrue(getResult.isDebugMode());
    assertTrue(getResult.isDefault());
    assertTrue(getResult.isRoot());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firstRuleNodeId.getId());
    assertSame(additionalInfo, getResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, getResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstIsRuleChain() {
    // Arrange
    RuleChainEntity ruleChainEntity = mock(RuleChainEntity.class);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainEntity.toData()).thenReturn(ruleChain);
    doNothing().when(ruleChainEntity).setCreatedTime(anyLong());
    doNothing().when(ruleChainEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setVersion(Mockito.<Long>any());
    doNothing().when(ruleChainEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleChainEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setFirstRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setName(Mockito.<String>any());
    doNothing().when(ruleChainEntity).setRoot(anyBoolean());
    doNothing().when(ruleChainEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setType(Mockito.<RuleChainType>any());
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(-1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("org.thingsboard.server.dao.model.sql.RuleChainEntity");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(-1L);

    ArrayList<RuleChainEntity> content = new ArrayList<>();
    content.add(ruleChainEntity);
    PageImpl<RuleChainEntity> pageImpl = new PageImpl<>(content);
    when(ruleChainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<RuleChain> actualFindByTenantIdResult = jpaRuleChainDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(ruleChainEntity).setCreatedTime(eq(-1L));
    verify(ruleChainEntity).setId(isA(UUID.class));
    verify(ruleChainEntity).setUuid(isA(UUID.class));
    verify(ruleChainEntity).setVersion(eq(-1L));
    verify(ruleChainEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleChainEntity).setDebugMode(eq(true));
    verify(ruleChainEntity).setExternalId(isA(UUID.class));
    verify(ruleChainEntity).setFirstRuleNodeId(isA(UUID.class));
    verify(ruleChainEntity).setName(eq("org.thingsboard.server.dao.model.sql.RuleChainEntity"));
    verify(ruleChainEntity).setRoot(eq(true));
    verify(ruleChainEntity).setTenantId(isA(UUID.class));
    verify(ruleChainEntity).setType(eq(RuleChainType.CORE));
    verify(ruleChainEntity).toData();
    verify(ruleChainRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<RuleChain> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(ruleChain, data.get(0));
  }

  /**
   * Test {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleChainDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(ruleChainRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<RuleChain> actualFindByTenantIdResult = jpaRuleChainDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)} with
   * {@code RuleChainId}.
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)}
   */
  @Test
  public void testGetExternalIdByInternalWithRuleChainId() {
    // Arrange
    when(ruleChainRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    RuleChainId internalId = new RuleChainId(ModelConstants.NULL_UUID);

    // Act
    RuleChainId actualExternalIdByInternal = jpaRuleChainDao.getExternalIdByInternal(internalId);

    // Assert
    verify(ruleChainRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)} with
   * {@code RuleChainId}.
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)}
   */
  @Test
  public void testGetExternalIdByInternalWithRuleChainId2() {
    // Arrange
    when(ruleChainRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    RuleChainId internalId = mock(RuleChainId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    RuleChainId actualExternalIdByInternal = jpaRuleChainDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(ruleChainRepository).getExternalIdById(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.RULE_CHAIN, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)} with
   * {@code RuleChainId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaRuleChainDao#getExternalIdByInternal(RuleChainId)}
   */
  @Test
  public void testGetExternalIdByInternalWithRuleChainId_thenReturnNull() {
    // Arrange
    when(ruleChainRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    RuleChainId actualExternalIdByInternal = jpaRuleChainDao
        .getExternalIdByInternal(new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaRuleChainDao#findDefaultEntityByTenantId(UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleChainDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  public void testFindDefaultEntityByTenantId_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    RuleChainEntity ruleChainEntity = new RuleChainEntity();
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndTypeAndRootIsTrue(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChainEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    RuleChain actualFindDefaultEntityByTenantIdResult = jpaRuleChainDao.findDefaultEntityByTenantId(tenantId);

    // Assert
    verify(ruleChainRepository).findByTenantIdAndTypeAndRootIsTrue(isA(UUID.class), eq(RuleChainType.CORE));
    JsonNode additionalInfo = actualFindDefaultEntityByTenantIdResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = actualFindDefaultEntityByTenantIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Name", actualFindDefaultEntityByTenantIdResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getVersion().longValue());
    assertEquals(1L, actualFindDefaultEntityByTenantIdResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    RuleChainId externalId = actualFindDefaultEntityByTenantIdResult.getExternalId();
    assertEquals(EntityType.RULE_CHAIN, externalId.getEntityType());
    RuleNodeId firstRuleNodeId = actualFindDefaultEntityByTenantIdResult.getFirstRuleNodeId();
    assertEquals(EntityType.RULE_NODE, firstRuleNodeId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertEquals(RuleChainType.CORE, actualFindDefaultEntityByTenantIdResult.getType());
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
    assertTrue(firstRuleNodeId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertTrue(actualFindDefaultEntityByTenantIdResult.isDebugMode());
    assertTrue(actualFindDefaultEntityByTenantIdResult.isDefault());
    assertTrue(actualFindDefaultEntityByTenantIdResult.isRoot());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, actualFindDefaultEntityByTenantIdResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, actualFindDefaultEntityByTenantIdResult.getUuidId());
    assertSame(tenantId, externalId.getId());
    assertSame(tenantId, firstRuleNodeId.getId());
    assertSame(additionalInfo, actualFindDefaultEntityByTenantIdResult.getConfiguration());
    byte[] expectedConfigurationBytes = "{\"isPublic\":true}".getBytes("UTF-8");
    assertArrayEquals(expectedConfigurationBytes, actualFindDefaultEntityByTenantIdResult.getConfigurationBytes());
  }

  /**
   * Test {@link JpaRuleChainDao#findDefaultEntityByTenantId(UUID)}.
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaRuleChainDao#findDefaultEntityByTenantId(UUID)}
   */
  @Test
  public void testFindDefaultEntityByTenantId_thenReturnRuleChain() {
    // Arrange
    RuleChainEntity ruleChainEntity = mock(RuleChainEntity.class);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainEntity.toData()).thenReturn(ruleChain);
    doNothing().when(ruleChainEntity).setCreatedTime(anyLong());
    doNothing().when(ruleChainEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setVersion(Mockito.<Long>any());
    doNothing().when(ruleChainEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setConfiguration(Mockito.<JsonNode>any());
    doNothing().when(ruleChainEntity).setDebugMode(anyBoolean());
    doNothing().when(ruleChainEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setFirstRuleNodeId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setName(Mockito.<String>any());
    doNothing().when(ruleChainEntity).setRoot(anyBoolean());
    doNothing().when(ruleChainEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleChainEntity).setType(Mockito.<RuleChainType>any());
    ruleChainEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainEntity.setCreatedTime(1L);
    ruleChainEntity.setDebugMode(true);
    ruleChainEntity.setExternalId(ModelConstants.NULL_UUID);
    ruleChainEntity.setFirstRuleNodeId(ModelConstants.NULL_UUID);
    ruleChainEntity.setId(ModelConstants.NULL_UUID);
    ruleChainEntity.setName("Name");
    ruleChainEntity.setRoot(true);
    ruleChainEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleChainEntity.setType(RuleChainType.CORE);
    ruleChainEntity.setUuid(ModelConstants.NULL_UUID);
    ruleChainEntity.setVersion(1L);
    when(ruleChainRepository.findByTenantIdAndTypeAndRootIsTrue(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChainEntity);

    // Act
    RuleChain actualFindDefaultEntityByTenantIdResult = jpaRuleChainDao
        .findDefaultEntityByTenantId(ModelConstants.NULL_UUID);

    // Assert
    verify(ruleChainEntity).setCreatedTime(eq(1L));
    verify(ruleChainEntity).setId(isA(UUID.class));
    verify(ruleChainEntity).setUuid(isA(UUID.class));
    verify(ruleChainEntity).setVersion(eq(1L));
    verify(ruleChainEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainEntity).setConfiguration(isA(JsonNode.class));
    verify(ruleChainEntity).setDebugMode(eq(true));
    verify(ruleChainEntity).setExternalId(isA(UUID.class));
    verify(ruleChainEntity).setFirstRuleNodeId(isA(UUID.class));
    verify(ruleChainEntity).setName(eq("Name"));
    verify(ruleChainEntity).setRoot(eq(true));
    verify(ruleChainEntity).setTenantId(isA(UUID.class));
    verify(ruleChainEntity).setType(eq(RuleChainType.CORE));
    verify(ruleChainEntity).toData();
    verify(ruleChainRepository).findByTenantIdAndTypeAndRootIsTrue(isA(UUID.class), eq(RuleChainType.CORE));
    assertSame(ruleChain, actualFindDefaultEntityByTenantIdResult);
  }
}
