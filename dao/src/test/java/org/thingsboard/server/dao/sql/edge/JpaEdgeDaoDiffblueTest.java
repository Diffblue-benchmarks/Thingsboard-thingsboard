package org.thingsboard.server.dao.sql.edge;

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
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import jakarta.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
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
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.EdgeEntity;
import org.thingsboard.server.dao.model.sql.EdgeInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaEdgeDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaEdgeDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EdgeRepository edgeRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaEdgeDao jpaEdgeDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaEdgeDao#getEntityClass()}
   *   <li>{@link JpaEdgeDao#getEntityType()}
   *   <li>{@link JpaEdgeDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaEdgeDao jpaEdgeDao = new JpaEdgeDao();

    // Act
    Class<EdgeEntity> actualEntityClass = jpaEdgeDao.getEntityClass();
    EntityType actualEntityType = jpaEdgeDao.getEntityType();

    // Assert
    assertNull(jpaEdgeDao.getRepository());
    assertEquals(EntityType.EDGE, actualEntityType);
    Class<EdgeEntity> expectedEntityClass = EdgeEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Given {@link EdgeInfoEntity} {@link EdgeInfoEntity#toData()} return
   * {@link EdgeInfo#EdgeInfo()}.</li>
   *   <li>Then return {@link EdgeInfo#EdgeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindEdgeInfoById_givenEdgeInfoEntityToDataReturnEdgeInfo_thenReturnEdgeInfo() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = mock(EdgeInfoEntity.class);
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeInfoEntity.toData()).thenReturn(edgeInfo);
    when(edgeRepository.findEdgeInfoById(Mockito.<UUID>any())).thenReturn(edgeInfoEntity);

    // Act
    EdgeInfo actualFindEdgeInfoByIdResult = jpaEdgeDao.findEdgeInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(edgeInfoEntity).toData();
    verify(edgeRepository).findEdgeInfoById(isA(UUID.class));
    assertSame(edgeInfo, actualFindEdgeInfoByIdResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindEdgeInfoById_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    when(edgeRepository.findEdgeInfoById(Mockito.<UUID>any())).thenReturn(new EdgeInfoEntity());

    // Act
    EdgeInfo actualFindEdgeInfoByIdResult = jpaEdgeDao.findEdgeInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(edgeRepository).findEdgeInfoById(isA(UUID.class));
    JsonNode additionalInfo = actualFindEdgeInfoByIdResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    EdgeId id = actualFindEdgeInfoByIdResult.getId();
    assertNull(id.getId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertEquals(EntityType.EDGE, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgeInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindEdgeInfoById_thenReturnNull() {
    // Arrange
    when(edgeRepository.findEdgeInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    EdgeInfo actualFindEdgeInfoByIdResult = jpaEdgeDao.findEdgeInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(edgeRepository).findEdgeInfoById(isA(UUID.class));
    assertNull(actualFindEdgeInfoByIdResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult = jpaEdgeDao.findEdgesByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantId_thenDataFirstAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult = jpaEdgeDao.findEdgesByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
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
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EdgeId id = getResult.getId();
    assertEquals(EntityType.EDGE, id.getEntityType());
    RuleChainId rootRuleChainId = getResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
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
    assertTrue(customerId.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(rootRuleChainId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, id.getId());
    assertSame(tenantId, rootRuleChainId.getId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantId_thenReturnDataFirstIsEdge() {
    // Arrange
    EdgeEntity edgeEntity = mock(EdgeEntity.class);
    Edge edge = new Edge();
    when(edgeEntity.toData()).thenReturn(edge);
    doNothing().when(edgeEntity).setCreatedTime(anyLong());
    doNothing().when(edgeEntity).setId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setVersion(Mockito.<Long>any());
    doNothing().when(edgeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(edgeEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setLabel(Mockito.<String>any());
    doNothing().when(edgeEntity).setName(Mockito.<String>any());
    doNothing().when(edgeEntity).setRootRuleChainId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setRoutingKey(Mockito.<String>any());
    doNothing().when(edgeEntity).setSecret(Mockito.<String>any());
    doNothing().when(edgeEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setType(Mockito.<String>any());
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(-1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("42");
    edgeEntity.setName("42");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("42");
    edgeEntity.setSecret("42");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("42");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(-1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult = jpaEdgeDao.findEdgesByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeEntity).setCreatedTime(eq(-1L));
    verify(edgeEntity).setId(isA(UUID.class));
    verify(edgeEntity).setUuid(isA(UUID.class));
    verify(edgeEntity).setVersion(eq(-1L));
    verify(edgeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(edgeEntity).setCustomerId(isA(UUID.class));
    verify(edgeEntity).setLabel(eq("42"));
    verify(edgeEntity).setName(eq("42"));
    verify(edgeEntity).setRootRuleChainId(isA(UUID.class));
    verify(edgeEntity).setRoutingKey(eq("42"));
    verify(edgeEntity).setSecret(eq("42"));
    verify(edgeEntity).setTenantId(isA(UUID.class));
    verify(edgeEntity).setType(eq("42"));
    verify(edgeEntity).toData();
    verify(edgeRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(edge, data.get(0));
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgesByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult = jpaEdgeDao.findEdgesByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  public void testFindEdgesByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> edgeIds = new ArrayList<>();
    edgeIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdAndIdsAsyncResult = jpaEdgeDao
        .findEdgesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, edgeIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  public void testFindEdgesByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> edgeIds = new ArrayList<>();
    edgeIds.add(ModelConstants.NULL_UUID);
    edgeIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdAndIdsAsyncResult = jpaEdgeDao
        .findEdgesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, edgeIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  public void testFindEdgesByTenantIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdAndIdsAsyncResult = jpaEdgeDao
        .findEdgesByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerId() throws IOException {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult = jpaEdgeDao
        .findEdgesByTenantIdAndCustomerId(ModelConstants.NULL_UUID, customerId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
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
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId2 = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    EdgeId id = getResult.getId();
    assertEquals(EntityType.EDGE, id.getEntityType());
    RuleChainId rootRuleChainId = getResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
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
    assertTrue(customerId2.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(rootRuleChainId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(customerId, getResult.getUuidId());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, id.getId());
    assertSame(customerId, rootRuleChainId.getId());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult = jpaEdgeDao
        .findEdgesByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerId_thenReturnDataFirstIsEdge() {
    // Arrange
    EdgeEntity edgeEntity = mock(EdgeEntity.class);
    Edge edge = new Edge();
    when(edgeEntity.toData()).thenReturn(edge);
    doNothing().when(edgeEntity).setCreatedTime(anyLong());
    doNothing().when(edgeEntity).setId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setVersion(Mockito.<Long>any());
    doNothing().when(edgeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(edgeEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setLabel(Mockito.<String>any());
    doNothing().when(edgeEntity).setName(Mockito.<String>any());
    doNothing().when(edgeEntity).setRootRuleChainId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setRoutingKey(Mockito.<String>any());
    doNothing().when(edgeEntity).setSecret(Mockito.<String>any());
    doNothing().when(edgeEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setType(Mockito.<String>any());
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(-1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("42");
    edgeEntity.setName("42");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("42");
    edgeEntity.setSecret("42");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("42");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(-1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult = jpaEdgeDao
        .findEdgesByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeEntity).setCreatedTime(eq(-1L));
    verify(edgeEntity).setId(isA(UUID.class));
    verify(edgeEntity).setUuid(isA(UUID.class));
    verify(edgeEntity).setVersion(eq(-1L));
    verify(edgeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(edgeEntity).setCustomerId(isA(UUID.class));
    verify(edgeEntity).setLabel(eq("42"));
    verify(edgeEntity).setName(eq("42"));
    verify(edgeEntity).setRootRuleChainId(isA(UUID.class));
    verify(edgeEntity).setRoutingKey(eq("42"));
    verify(edgeEntity).setSecret(eq("42"));
    verify(edgeEntity).setTenantId(isA(UUID.class));
    verify(edgeEntity).setType(eq("42"));
    verify(edgeEntity).toData();
    verify(edgeRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(edge, data.get(0));
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult = jpaEdgeDao.findEdgesByTenantIdAndCustomerId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}
   */
  @Test
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync_givenNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> edgeIds = new ArrayList<>();
    edgeIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult = jpaEdgeDao
        .findEdgesByTenantIdCustomerIdAndIdsAsync(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, edgeIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}
   */
  @Test
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync_givenNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> edgeIds = new ArrayList<>();
    edgeIds.add(ModelConstants.NULL_UUID);
    edgeIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult = jpaEdgeDao
        .findEdgesByTenantIdCustomerIdAndIdsAsync(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, edgeIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdCustomerIdAndIdsAsync(UUID, UUID, List)}
   */
  @Test
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult = jpaEdgeDao
        .findEdgesByTenantIdCustomerIdAndIdsAsync(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then {@link Optional#get()} AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgeByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindEdgeByTenantIdAndName_thenGetAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    when(edgeRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(edgeEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Edge> actualFindEdgeByTenantIdAndNameResult = jpaEdgeDao.findEdgeByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(edgeRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    Edge getResult = actualFindEdgeByTenantIdAndNameResult.get();
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
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EdgeId id = getResult.getId();
    assertEquals(EntityType.EDGE, id.getEntityType());
    RuleChainId rootRuleChainId = getResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
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
    assertTrue(customerId.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(rootRuleChainId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, id.getId());
    assertSame(tenantId, rootRuleChainId.getId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgeByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindEdgeByTenantIdAndName_thenReturnGetIsEdge() {
    // Arrange
    EdgeEntity edgeEntity = mock(EdgeEntity.class);
    Edge edge = new Edge();
    when(edgeEntity.toData()).thenReturn(edge);
    doNothing().when(edgeEntity).setCreatedTime(anyLong());
    doNothing().when(edgeEntity).setId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setVersion(Mockito.<Long>any());
    doNothing().when(edgeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(edgeEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setLabel(Mockito.<String>any());
    doNothing().when(edgeEntity).setName(Mockito.<String>any());
    doNothing().when(edgeEntity).setRootRuleChainId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setRoutingKey(Mockito.<String>any());
    doNothing().when(edgeEntity).setSecret(Mockito.<String>any());
    doNothing().when(edgeEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setType(Mockito.<String>any());
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    when(edgeRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(edgeEntity);

    // Act
    Optional<Edge> actualFindEdgeByTenantIdAndNameResult = jpaEdgeDao
        .findEdgeByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(edgeEntity).setCreatedTime(eq(1L));
    verify(edgeEntity).setId(isA(UUID.class));
    verify(edgeEntity).setUuid(isA(UUID.class));
    verify(edgeEntity).setVersion(eq(1L));
    verify(edgeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(edgeEntity).setCustomerId(isA(UUID.class));
    verify(edgeEntity).setLabel(eq("Label"));
    verify(edgeEntity).setName(eq("Name"));
    verify(edgeEntity).setRootRuleChainId(isA(UUID.class));
    verify(edgeEntity).setRoutingKey(eq("Routing Key"));
    verify(edgeEntity).setSecret(eq("Secret"));
    verify(edgeEntity).setTenantId(isA(UUID.class));
    verify(edgeEntity).setType(eq("Type"));
    verify(edgeEntity).toData();
    verify(edgeRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertSame(edge, actualFindEdgeByTenantIdAndNameResult.get());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndType() throws IOException {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult = jpaEdgeDao.findEdgesByTenantIdAndType(tenantId, "Type",
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
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
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EdgeId id = getResult.getId();
    assertEquals(EntityType.EDGE, id.getEntityType());
    RuleChainId rootRuleChainId = getResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
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
    assertTrue(customerId.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(rootRuleChainId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, id.getId());
    assertSame(tenantId, rootRuleChainId.getId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult = jpaEdgeDao
        .findEdgesByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndType_thenReturnDataFirstIsEdge() {
    // Arrange
    EdgeEntity edgeEntity = mock(EdgeEntity.class);
    Edge edge = new Edge();
    when(edgeEntity.toData()).thenReturn(edge);
    doNothing().when(edgeEntity).setCreatedTime(anyLong());
    doNothing().when(edgeEntity).setId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setVersion(Mockito.<Long>any());
    doNothing().when(edgeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(edgeEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setLabel(Mockito.<String>any());
    doNothing().when(edgeEntity).setName(Mockito.<String>any());
    doNothing().when(edgeEntity).setRootRuleChainId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setRoutingKey(Mockito.<String>any());
    doNothing().when(edgeEntity).setSecret(Mockito.<String>any());
    doNothing().when(edgeEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setType(Mockito.<String>any());
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(-1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("42");
    edgeEntity.setName("42");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("42");
    edgeEntity.setSecret("42");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("42");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(-1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult = jpaEdgeDao
        .findEdgesByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeEntity).setCreatedTime(eq(-1L));
    verify(edgeEntity).setId(isA(UUID.class));
    verify(edgeEntity).setUuid(isA(UUID.class));
    verify(edgeEntity).setVersion(eq(-1L));
    verify(edgeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(edgeEntity).setCustomerId(isA(UUID.class));
    verify(edgeEntity).setLabel(eq("42"));
    verify(edgeEntity).setName(eq("42"));
    verify(edgeEntity).setRootRuleChainId(isA(UUID.class));
    verify(edgeEntity).setRoutingKey(eq("42"));
    verify(edgeEntity).setSecret(eq("42"));
    verify(edgeEntity).setTenantId(isA(UUID.class));
    verify(edgeEntity).setType(eq("42"));
    verify(edgeEntity).toData();
    verify(edgeRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(edge, data.get(0));
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult = jpaEdgeDao
        .findEdgesByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerIdAndType() throws IOException {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult = jpaEdgeDao
        .findEdgesByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, customerId, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
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
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId2 = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    EdgeId id = getResult.getId();
    assertEquals(EntityType.EDGE, id.getEntityType());
    RuleChainId rootRuleChainId = getResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
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
    assertTrue(customerId2.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(rootRuleChainId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(customerId, getResult.getUuidId());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, id.getId());
    assertSame(customerId, rootRuleChainId.getId());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerIdAndType_thenReturnDataFirstIsEdge() {
    // Arrange
    EdgeEntity edgeEntity = mock(EdgeEntity.class);
    Edge edge = new Edge();
    when(edgeEntity.toData()).thenReturn(edge);
    doNothing().when(edgeEntity).setCreatedTime(anyLong());
    doNothing().when(edgeEntity).setId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setVersion(Mockito.<Long>any());
    doNothing().when(edgeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(edgeEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setLabel(Mockito.<String>any());
    doNothing().when(edgeEntity).setName(Mockito.<String>any());
    doNothing().when(edgeEntity).setRootRuleChainId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setRoutingKey(Mockito.<String>any());
    doNothing().when(edgeEntity).setSecret(Mockito.<String>any());
    doNothing().when(edgeEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setType(Mockito.<String>any());
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(-1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("42");
    edgeEntity.setName("42");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("42");
    edgeEntity.setSecret("42");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("42");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(-1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult = jpaEdgeDao
        .findEdgesByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeEntity).setCreatedTime(eq(-1L));
    verify(edgeEntity).setId(isA(UUID.class));
    verify(edgeEntity).setUuid(isA(UUID.class));
    verify(edgeEntity).setVersion(eq(-1L));
    verify(edgeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(edgeEntity).setCustomerId(isA(UUID.class));
    verify(edgeEntity).setLabel(eq("42"));
    verify(edgeEntity).setName(eq("42"));
    verify(edgeEntity).setRootRuleChainId(isA(UUID.class));
    verify(edgeEntity).setRoutingKey(eq("42"));
    verify(edgeEntity).setSecret(eq("42"));
    verify(edgeEntity).setTenantId(isA(UUID.class));
    verify(edgeEntity).setType(eq("42"));
    verify(edgeEntity).toData();
    verify(edgeRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(edge, data.get(0));
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult = jpaEdgeDao
        .findEdgesByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(edgeRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult = jpaEdgeDao
        .findEdgesByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerId() throws IOException {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(new EdgeInfoEntity());
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findEdgeInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    EdgeId id = getResult.getId();
    assertNull(id.getId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertEquals(EntityType.EDGE, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findEdgeInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EdgeInfo#EdgeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenReturnDataFirstIsEdgeInfo() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = mock(EdgeInfoEntity.class);
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeInfoEntity.toData()).thenReturn(edgeInfo);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeInfoEntity).toData();
    verify(edgeRepository).findEdgeInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(edgeInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findEdgeInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertEquals(1L, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findEdgeInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType() throws IOException {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(new EdgeInfoEntity());
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findEdgeInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isNull(), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    EdgeId id = getResult.getId();
    assertNull(id.getId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertEquals(EntityType.EDGE, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EdgeInfo#EdgeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnDataFirstIsEdgeInfo() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = mock(EdgeInfoEntity.class);
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeInfoEntity.toData()).thenReturn(edgeInfo);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeInfoEntity).toData();
    verify(edgeRepository).findEdgeInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(edgeInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findEdgeInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findEdgeInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findEdgeInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findTenantEdgeTypesAsync(UUID)}.
   * <p>
   * Method under test: {@link JpaEdgeDao#findTenantEdgeTypesAsync(UUID)}
   */
  @Test
  public void testFindTenantEdgeTypesAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindTenantEdgeTypesAsyncResult = jpaEdgeDao
        .findTenantEdgeTypesAsync(ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindTenantEdgeTypesAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindTenantEdgeTypesAsyncResult);
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndType_thenDataFirstAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(new EdgeInfoEntity());
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    EdgeId id = getResult.getId();
    assertNull(id.getId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertEquals(EntityType.EDGE, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EdgeInfo#EdgeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndType_thenReturnDataFirstIsEdgeInfo() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = mock(EdgeInfoEntity.class);
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeInfoEntity.toData()).thenReturn(edgeInfo);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeInfoEntity).toData();
    verify(edgeRepository).findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(edgeInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndType_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(1, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalElements());
    assertFalse(actualFindEdgeInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult = jpaEdgeDao
        .findEdgeInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantId_givenArrayListAddNull_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult = jpaEdgeDao
        .findEdgeInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findEdgeInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEdgeInfosByTenantIdResult.getTotalPages());
    assertEquals(1L, actualFindEdgeInfosByTenantIdResult.getTotalElements());
    assertFalse(actualFindEdgeInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult = jpaEdgeDao
        .findEdgeInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findEdgeInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantId_thenDataFirstAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(new EdgeInfoEntity());
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult = jpaEdgeDao
        .findEdgeInfosByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findEdgeInfosByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    EdgeInfo getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", additionalInfo.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    EdgeId id = getResult.getId();
    assertNull(id.getId());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, additionalInfo.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, additionalInfo.getNodeType());
    assertEquals(EntityType.EDGE, id.getEntityType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(additionalInfo.isArray());
    assertFalse(additionalInfo.isBigDecimal());
    assertFalse(additionalInfo.isBigInteger());
    assertFalse(additionalInfo.isBinary());
    assertFalse(additionalInfo.isBoolean());
    assertFalse(additionalInfo.isContainerNode());
    assertFalse(additionalInfo.isDouble());
    assertFalse(additionalInfo.isFloat());
    assertFalse(additionalInfo.isFloatingPointNumber());
    assertFalse(additionalInfo.isInt());
    assertFalse(additionalInfo.isIntegralNumber());
    assertFalse(additionalInfo.isLong());
    assertFalse(additionalInfo.isMissingNode());
    assertFalse(additionalInfo.isNumber());
    assertFalse(additionalInfo.isObject());
    assertFalse(additionalInfo.isPojo());
    assertFalse(additionalInfo.isShort());
    assertFalse(additionalInfo.isTextual());
    assertFalse(additionalInfo.iterator().hasNext());
    assertFalse(id.isNullUid());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EdgeInfo#EdgeInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantId_thenReturnDataFirstIsEdgeInfo() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = mock(EdgeInfoEntity.class);
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeInfoEntity.toData()).thenReturn(edgeInfo);

    ArrayList<EdgeInfoEntity> content = new ArrayList<>();
    content.add(edgeInfoEntity);
    PageImpl<EdgeInfoEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult = jpaEdgeDao
        .findEdgeInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeInfoEntity).toData();
    verify(edgeRepository).findEdgeInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EdgeInfo> data = actualFindEdgeInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(edgeInfo, data.get(0));
  }

  /**
   * Test {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findEdgeInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgeInfosByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult = jpaEdgeDao
        .findEdgeInfosByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findEdgeInfosByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindEdgeInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEdgeInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findByRoutingKey(UUID, String)}.
   * <ul>
   *   <li>Given {@link EdgeEntity} {@link EdgeEntity#toData()} return
   * {@link Edge#Edge()}.</li>
   *   <li>Then return {@link Optional#get()} is {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findByRoutingKey(UUID, String)}
   */
  @Test
  public void testFindByRoutingKey_givenEdgeEntityToDataReturnEdge_thenReturnGetIsEdge() {
    // Arrange
    EdgeEntity edgeEntity = mock(EdgeEntity.class);
    Edge edge = new Edge();
    when(edgeEntity.toData()).thenReturn(edge);
    doNothing().when(edgeEntity).setCreatedTime(anyLong());
    doNothing().when(edgeEntity).setId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setVersion(Mockito.<Long>any());
    doNothing().when(edgeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(edgeEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setLabel(Mockito.<String>any());
    doNothing().when(edgeEntity).setName(Mockito.<String>any());
    doNothing().when(edgeEntity).setRootRuleChainId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setRoutingKey(Mockito.<String>any());
    doNothing().when(edgeEntity).setSecret(Mockito.<String>any());
    doNothing().when(edgeEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setType(Mockito.<String>any());
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    when(edgeRepository.findByRoutingKey(Mockito.<String>any())).thenReturn(edgeEntity);

    // Act
    Optional<Edge> actualFindByRoutingKeyResult = jpaEdgeDao.findByRoutingKey(ModelConstants.NULL_UUID, "Routing Key");

    // Assert
    verify(edgeEntity).setCreatedTime(eq(1L));
    verify(edgeEntity).setId(isA(UUID.class));
    verify(edgeEntity).setUuid(isA(UUID.class));
    verify(edgeEntity).setVersion(eq(1L));
    verify(edgeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(edgeEntity).setCustomerId(isA(UUID.class));
    verify(edgeEntity).setLabel(eq("Label"));
    verify(edgeEntity).setName(eq("Name"));
    verify(edgeEntity).setRootRuleChainId(isA(UUID.class));
    verify(edgeEntity).setRoutingKey(eq("Routing Key"));
    verify(edgeEntity).setSecret(eq("Secret"));
    verify(edgeEntity).setTenantId(isA(UUID.class));
    verify(edgeEntity).setType(eq("Type"));
    verify(edgeEntity).toData();
    verify(edgeRepository).findByRoutingKey(eq("Routing Key"));
    assertSame(edge, actualFindByRoutingKeyResult.get());
  }

  /**
   * Test {@link JpaEdgeDao#findByRoutingKey(UUID, String)}.
   * <ul>
   *   <li>Then {@link Optional#get()} AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEdgeDao#findByRoutingKey(UUID, String)}
   */
  @Test
  public void testFindByRoutingKey_thenGetAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Label");
    edgeEntity.setName("Name");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Routing Key");
    edgeEntity.setSecret("Secret");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Type");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);
    when(edgeRepository.findByRoutingKey(Mockito.<String>any())).thenReturn(edgeEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Edge> actualFindByRoutingKeyResult = jpaEdgeDao.findByRoutingKey(tenantId, "Routing Key");

    // Assert
    verify(edgeRepository).findByRoutingKey(eq("Routing Key"));
    Edge getResult = actualFindByRoutingKeyResult.get();
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
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Routing Key", getResult.getRoutingKey());
    assertEquals("Secret", getResult.getSecret());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EdgeId id = getResult.getId();
    assertEquals(EntityType.EDGE, id.getEntityType());
    RuleChainId rootRuleChainId = getResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
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
    assertTrue(customerId.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(rootRuleChainId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, id.getId());
    assertSame(tenantId, rootRuleChainId.getId());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndEntityId() throws IOException {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(4L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setName("Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setSecret("Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(4L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult = jpaEdgeDao.findEdgesByTenantIdAndEntityId(
        ModelConstants.NULL_UUID, entityId, EntityType.TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class), eq("TENANT"), isNull(),
        isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndEntityIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
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
    assertEquals("Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getLabel());
    assertEquals("Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getName());
    assertEquals("Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getRoutingKey());
    assertEquals("Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getSecret());
    assertEquals("Try to find edges by tenantId [{}], entityId [{}], entityType [{}], pageLink [{}]",
        getResult.getType());
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
    assertEquals(4L, getResult.getVersion().longValue());
    assertEquals(4L, getResult.getCreatedTime());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EdgeId id = getResult.getId();
    assertEquals(EntityType.EDGE, id.getEntityType());
    RuleChainId rootRuleChainId = getResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
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
    assertTrue(customerId.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(rootRuleChainId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(entityId, getResult.getUuidId());
    assertSame(entityId, customerId.getId());
    assertSame(entityId, id.getId());
    assertSame(entityId, rootRuleChainId.getId());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndEntityId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult = jpaEdgeDao.findEdgesByTenantIdAndEntityId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndEntityId_thenReturnDataFirstIsEdge() {
    // Arrange
    EdgeEntity edgeEntity = mock(EdgeEntity.class);
    Edge edge = new Edge();
    when(edgeEntity.toData()).thenReturn(edge);
    doNothing().when(edgeEntity).setCreatedTime(anyLong());
    doNothing().when(edgeEntity).setId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setVersion(Mockito.<Long>any());
    doNothing().when(edgeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(edgeEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setLabel(Mockito.<String>any());
    doNothing().when(edgeEntity).setName(Mockito.<String>any());
    doNothing().when(edgeEntity).setRootRuleChainId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setRoutingKey(Mockito.<String>any());
    doNothing().when(edgeEntity).setSecret(Mockito.<String>any());
    doNothing().when(edgeEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setType(Mockito.<String>any());
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(2L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("org.thingsboard.server.dao.model.sql.EdgeEntity");
    edgeEntity.setName("org.thingsboard.server.dao.model.sql.EdgeEntity");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("org.thingsboard.server.dao.model.sql.EdgeEntity");
    edgeEntity.setSecret("org.thingsboard.server.dao.model.sql.EdgeEntity");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("org.thingsboard.server.dao.model.sql.EdgeEntity");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(2L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult = jpaEdgeDao.findEdgesByTenantIdAndEntityId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeEntity).setCreatedTime(eq(2L));
    verify(edgeEntity).setId(isA(UUID.class));
    verify(edgeEntity).setUuid(isA(UUID.class));
    verify(edgeEntity).setVersion(eq(2L));
    verify(edgeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(edgeEntity).setCustomerId(isA(UUID.class));
    verify(edgeEntity).setLabel(eq("org.thingsboard.server.dao.model.sql.EdgeEntity"));
    verify(edgeEntity).setName(eq("org.thingsboard.server.dao.model.sql.EdgeEntity"));
    verify(edgeEntity).setRootRuleChainId(isA(UUID.class));
    verify(edgeEntity).setRoutingKey(eq("org.thingsboard.server.dao.model.sql.EdgeEntity"));
    verify(edgeEntity).setSecret(eq("org.thingsboard.server.dao.model.sql.EdgeEntity"));
    verify(edgeEntity).setTenantId(isA(UUID.class));
    verify(edgeEntity).setType(eq("org.thingsboard.server.dao.model.sql.EdgeEntity"));
    verify(edgeEntity).toData();
    verify(edgeRepository).findByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class), eq("TENANT"), eq("Text Search"),
        isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantIdAndEntityIdResult.getData();
    assertEquals(1, data.size());
    assertSame(edge, data.get(0));
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantIdAndEntityId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult = jpaEdgeDao.findEdgesByTenantIdAndEntityId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EntityType.TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class), eq("TENANT"), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}
   */
  @Test
  public void testFindEdgeIdsByTenantIdAndEntityId_givenOne_thenCallsGetPage() {
    // Arrange
    when(edgeRepository.findIdsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult = jpaEdgeDao.findEdgeIdsByTenantIdAndEntityId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EntityType.TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findIdsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class), eq("TENANT"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeIdsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeIdsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindEdgeIdsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindEdgeIdsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}
   */
  @Test
  public void testFindEdgeIdsByTenantIdAndEntityId_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findIdsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult = jpaEdgeDao.findEdgeIdsByTenantIdAndEntityId(
        ModelConstants.NULL_UUID, entityId, EntityType.TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findIdsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class), eq("TENANT"), isNull(),
        isA(Pageable.class));
    List<EdgeId> data = actualFindEdgeIdsByTenantIdAndEntityIdResult.getData();
    assertEquals(1, data.size());
    assertEquals(1L, actualFindEdgeIdsByTenantIdAndEntityIdResult.getTotalElements());
    EdgeId getResult = data.get(0);
    assertEquals(EntityType.EDGE, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
    assertSame(entityId, getResult.getId());
  }

  /**
   * Test
   * {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgeIdsByTenantIdAndEntityId(UUID, UUID, EntityType, PageLink)}
   */
  @Test
  public void testFindEdgeIdsByTenantIdAndEntityId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findIdsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult = jpaEdgeDao.findEdgeIdsByTenantIdAndEntityId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EntityType.TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findIdsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class), eq("TENANT"), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindEdgeIdsByTenantIdAndEntityIdResult.getTotalElements());
    assertEquals(1, actualFindEdgeIdsByTenantIdAndEntityIdResult.getTotalPages());
    assertFalse(actualFindEdgeIdsByTenantIdAndEntityIdResult.hasNext());
    assertTrue(actualFindEdgeIdsByTenantIdAndEntityIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantProfileId() throws IOException {
    // Arrange
    EdgeEntity edgeEntity = new EdgeEntity();
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setName("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setSecret("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("Try to find edges by tenantProfileId [{}], pageLink [{}]");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantProfileId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantProfileId = ModelConstants.NULL_UUID;

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult = jpaEdgeDao.findEdgesByTenantProfileId(tenantProfileId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantProfileId(isA(UUID.class), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantProfileIdResult.getData();
    assertEquals(1, data.size());
    Edge getResult = data.get(0);
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
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getLabel());
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getName());
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getRoutingKey());
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getSecret());
    assertEquals("Try to find edges by tenantProfileId [{}], pageLink [{}]", getResult.getType());
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
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EdgeId id = getResult.getId();
    assertEquals(EntityType.EDGE, id.getEntityType());
    RuleChainId rootRuleChainId = getResult.getRootRuleChainId();
    assertEquals(EntityType.RULE_CHAIN, rootRuleChainId.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
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
    assertTrue(customerId.isNullUid());
    assertTrue(id.isNullUid());
    assertTrue(rootRuleChainId.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantProfileId, getResult.getUuidId());
    assertSame(tenantProfileId, customerId.getId());
    assertSame(tenantProfileId, id.getId());
    assertSame(tenantProfileId, rootRuleChainId.getId());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantProfileId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantProfileId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult = jpaEdgeDao
        .findEdgesByTenantProfileId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeRepository).findByTenantProfileId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantProfileIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantProfileIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantProfileIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantProfileId_thenReturnDataFirstIsEdge() {
    // Arrange
    EdgeEntity edgeEntity = mock(EdgeEntity.class);
    Edge edge = new Edge();
    when(edgeEntity.toData()).thenReturn(edge);
    doNothing().when(edgeEntity).setCreatedTime(anyLong());
    doNothing().when(edgeEntity).setId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setVersion(Mockito.<Long>any());
    doNothing().when(edgeEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(edgeEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setLabel(Mockito.<String>any());
    doNothing().when(edgeEntity).setName(Mockito.<String>any());
    doNothing().when(edgeEntity).setRootRuleChainId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setRoutingKey(Mockito.<String>any());
    doNothing().when(edgeEntity).setSecret(Mockito.<String>any());
    doNothing().when(edgeEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(edgeEntity).setType(Mockito.<String>any());
    edgeEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEntity.setCreatedTime(-1L);
    edgeEntity.setCustomerId(ModelConstants.NULL_UUID);
    edgeEntity.setId(ModelConstants.NULL_UUID);
    edgeEntity.setLabel("org.thingsboard.server.dao.model.sql.EdgeEntity");
    edgeEntity.setName("org.thingsboard.server.dao.model.sql.EdgeEntity");
    edgeEntity.setRootRuleChainId(ModelConstants.NULL_UUID);
    edgeEntity.setRoutingKey("org.thingsboard.server.dao.model.sql.EdgeEntity");
    edgeEntity.setSecret("org.thingsboard.server.dao.model.sql.EdgeEntity");
    edgeEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEntity.setType("org.thingsboard.server.dao.model.sql.EdgeEntity");
    edgeEntity.setUuid(ModelConstants.NULL_UUID);
    edgeEntity.setVersion(-1L);

    ArrayList<EdgeEntity> content = new ArrayList<>();
    content.add(edgeEntity);
    PageImpl<EdgeEntity> pageImpl = new PageImpl<>(content);
    when(edgeRepository.findByTenantProfileId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult = jpaEdgeDao
        .findEdgesByTenantProfileId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(edgeEntity).setCreatedTime(eq(-1L));
    verify(edgeEntity).setId(isA(UUID.class));
    verify(edgeEntity).setUuid(isA(UUID.class));
    verify(edgeEntity).setVersion(eq(-1L));
    verify(edgeEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(edgeEntity).setCustomerId(isA(UUID.class));
    verify(edgeEntity).setLabel(eq("org.thingsboard.server.dao.model.sql.EdgeEntity"));
    verify(edgeEntity).setName(eq("org.thingsboard.server.dao.model.sql.EdgeEntity"));
    verify(edgeEntity).setRootRuleChainId(isA(UUID.class));
    verify(edgeEntity).setRoutingKey(eq("org.thingsboard.server.dao.model.sql.EdgeEntity"));
    verify(edgeEntity).setSecret(eq("org.thingsboard.server.dao.model.sql.EdgeEntity"));
    verify(edgeEntity).setTenantId(isA(UUID.class));
    verify(edgeEntity).setType(eq("org.thingsboard.server.dao.model.sql.EdgeEntity"));
    verify(edgeEntity).toData();
    verify(edgeRepository).findByTenantProfileId(isA(UUID.class), isA(Pageable.class));
    List<Edge> data = actualFindEdgesByTenantProfileIdResult.getData();
    assertEquals(1, data.size());
    assertSame(edge, data.get(0));
  }

  /**
   * Test {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEdgeDao#findEdgesByTenantProfileId(UUID, PageLink)}
   */
  @Test
  public void testFindEdgesByTenantProfileId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeRepository.findByTenantProfileId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult = jpaEdgeDao
        .findEdgesByTenantProfileId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeRepository).findByTenantProfileId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindEdgesByTenantProfileIdResult.getTotalElements());
    assertEquals(1, actualFindEdgesByTenantProfileIdResult.getTotalPages());
    assertFalse(actualFindEdgesByTenantProfileIdResult.hasNext());
    assertTrue(actualFindEdgesByTenantProfileIdResult.getData().isEmpty());
  }
}
