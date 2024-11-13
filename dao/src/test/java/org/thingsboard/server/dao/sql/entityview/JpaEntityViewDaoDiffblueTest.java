package org.thingsboard.server.dao.sql.entityview;

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
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.EntityViewInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EntityViewId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.EntityViewEntity;
import org.thingsboard.server.dao.model.sql.EntityViewInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaEntityViewDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaEntityViewDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private EntityViewRepository entityViewRepository;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaEntityViewDao jpaEntityViewDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaEntityViewDao#getEntityClass()}
   *   <li>{@link JpaEntityViewDao#getEntityType()}
   *   <li>{@link JpaEntityViewDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaEntityViewDao jpaEntityViewDao = new JpaEntityViewDao();

    // Act
    Class<EntityViewEntity> actualEntityClass = jpaEntityViewDao.getEntityClass();
    EntityType actualEntityType = jpaEntityViewDao.getEntityType();

    // Assert
    assertNull(jpaEntityViewDao.getRepository());
    assertEquals(EntityType.ENTITY_VIEW, actualEntityType);
    Class<EntityViewEntity> expectedEntityClass = EntityViewEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindEntityViewInfoById_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    when(entityViewRepository.findEntityViewInfoById(Mockito.<UUID>any())).thenReturn(new EntityViewInfoEntity());

    // Act
    EntityViewInfo actualFindEntityViewInfoByIdResult = jpaEntityViewDao
        .findEntityViewInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findEntityViewInfoById(isA(UUID.class));
    JsonNode additionalInfo = actualFindEntityViewInfoByIdResult.getAdditionalInfo();
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
    EntityViewId id = actualFindEntityViewInfoByIdResult.getId();
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
    assertEquals(EntityType.ENTITY_VIEW, id.getEntityType());
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
   * Test {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@link EntityViewInfo#EntityViewInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindEntityViewInfoById_thenReturnEntityViewInfo() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = mock(EntityViewInfoEntity.class);
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewInfoEntity.toData()).thenReturn(entityViewInfo);
    when(entityViewRepository.findEntityViewInfoById(Mockito.<UUID>any())).thenReturn(entityViewInfoEntity);

    // Act
    EntityViewInfo actualFindEntityViewInfoByIdResult = jpaEntityViewDao
        .findEntityViewInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewInfoEntity).toData();
    verify(entityViewRepository).findEntityViewInfoById(isA(UUID.class));
    assertSame(entityViewInfo, actualFindEntityViewInfoByIdResult);
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindEntityViewInfoById_thenReturnNull() {
    // Arrange
    when(entityViewRepository.findEntityViewInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    EntityViewInfo actualFindEntityViewInfoByIdResult = jpaEntityViewDao
        .findEntityViewInfoById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findEntityViewInfoById(isA(UUID.class));
    assertNull(actualFindEntityViewInfoByIdResult);
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantId() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdResult = jpaEntityViewDao.findEntityViewsByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Name", getResult.getName());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getEndTimeMs());
    assertEquals(1L, getResult.getStartTimeMs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EntityViewId externalId = getResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
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
    assertTrue(entityId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdResult = jpaEntityViewDao
        .findEntityViewsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantId_thenReturnDataFirstIsEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(-1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(-1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("42");
    entityViewEntity.setName("42");
    entityViewEntity.setStartTs(-1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("42");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(-1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdResult = jpaEntityViewDao
        .findEntityViewsByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewEntity).setCreatedTime(eq(-1L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(-1L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(-1L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.USER));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("42"));
    verify(entityViewEntity).setName(eq("42"));
    verify(entityViewEntity).setStartTs(eq(-1L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("42"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(entityView, data.get(0));
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdResult = jpaEntityViewDao
        .findEntityViewsByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult = jpaEntityViewDao
        .findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findEntityViewInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantId_thenDataFirstAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(new EntityViewInfoEntity());
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult = jpaEntityViewDao
        .findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findEntityViewInfosByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
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
    EntityViewId id = getResult.getId();
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
    assertEquals(EntityType.ENTITY_VIEW, id.getEntityType());
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
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EntityViewInfo#EntityViewInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantId_thenReturnDataFirstIsEntityViewInfo() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = mock(EntityViewInfoEntity.class);
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewInfoEntity.toData()).thenReturn(entityViewInfo);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult = jpaEntityViewDao
        .findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewInfoEntity).toData();
    verify(entityViewRepository).findEntityViewInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(entityViewInfo, data.get(0));
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantId_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult = jpaEntityViewDao
        .findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findEntityViewInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEntityViewInfosByTenantIdResult.getTotalPages());
    assertEquals(1L, actualFindEntityViewInfosByTenantIdResult.getTotalElements());
    assertFalse(actualFindEntityViewInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdResult = jpaEntityViewDao
        .findEntityViewInfosByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findEntityViewInfosByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndType() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndType(tenantId, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Name", getResult.getName());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getEndTimeMs());
    assertEquals(1L, getResult.getStartTimeMs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EntityViewId externalId = getResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
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
    assertTrue(entityId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndType_thenReturnDataFirstIsEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(-1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(-1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("42");
    entityViewEntity.setName("42");
    entityViewEntity.setStartTs(-1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("42");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(-1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewEntity).setCreatedTime(eq(-1L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(-1L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(-1L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.USER));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("42"));
    verify(entityViewEntity).setName(eq("42"));
    verify(entityViewEntity).setStartTs(eq(-1L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("42"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(entityView, data.get(0));
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndType() throws IOException {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(new EntityViewInfoEntity());
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
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
    EntityViewId id = getResult.getId();
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
    assertEquals(EntityType.ENTITY_VIEW, id.getEntityType());
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
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EntityViewInfo#EntityViewInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndType_thenReturnDataFirstIsEntityViewInfo() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = mock(EntityViewInfoEntity.class);
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewInfoEntity.toData()).thenReturn(entityViewInfo);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewInfoEntity).toData();
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(entityViewInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndType_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalElements());
    assertFalse(actualFindEntityViewInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndTypeResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewByTenantIdAndName(UUID, String)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindEntityViewByTenantIdAndName() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(entityViewEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<EntityView> actualFindEntityViewByTenantIdAndNameResult = jpaEntityViewDao
        .findEntityViewByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(entityViewRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    EntityView getResult = actualFindEntityViewByTenantIdAndNameResult.get();
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Name", getResult.getName());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getEndTimeMs());
    assertEquals(1L, getResult.getStartTimeMs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EntityViewId externalId = getResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
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
    assertTrue(entityId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findEntityViewByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return {@link Optional#get()} is
   * {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindEntityViewByTenantIdAndName_thenReturnGetIsEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(entityViewEntity);

    // Act
    Optional<EntityView> actualFindEntityViewByTenantIdAndNameResult = jpaEntityViewDao
        .findEntityViewByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(entityViewEntity).setCreatedTime(eq(1L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(1L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(1L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.TENANT));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("Keys"));
    verify(entityViewEntity).setName(eq("Name"));
    verify(entityViewEntity).setStartTs(eq(1L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("Type"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertSame(entityView, actualFindEntityViewByTenantIdAndNameResult.get());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerId() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, customerId,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Name", getResult.getName());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getEndTimeMs());
    assertEquals(1L, getResult.getStartTimeMs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId2 = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    EntityViewId externalId = getResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
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
    assertTrue(entityId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(customerId, getResult.getUuidId());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, externalId.getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerId_thenReturnDataFirstIsEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(-1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(-1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("42");
    entityViewEntity.setName("42");
    entityViewEntity.setStartTs(-1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("42");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(-1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewEntity).setCreatedTime(eq(-1L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(-1L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(-1L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.USER));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("42"));
    verify(entityViewEntity).setName(eq("42"));
    verify(entityViewEntity).setStartTs(eq(-1L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("42"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(entityView, data.get(0));
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerId() throws IOException {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(new EntityViewInfoEntity());
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
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
    EntityViewId id = getResult.getId();
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
    assertEquals(EntityType.ENTITY_VIEW, id.getEntityType());
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
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerId2() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = mock(EntityViewInfoEntity.class);
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewInfoEntity.toData()).thenReturn(entityViewInfo);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewInfoEntity).toData();
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(entityViewInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertEquals(1L, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, customerId, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isNull(), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Name", getResult.getName());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getEndTimeMs());
    assertEquals(1L, getResult.getStartTimeMs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId2 = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    EntityViewId externalId = getResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
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
    assertTrue(entityId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(customerId, getResult.getUuidId());
    assertSame(customerId, customerId2.getId());
    assertSame(customerId, externalId.getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType2() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(-1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(-1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("42");
    entityViewEntity.setName("42");
    entityViewEntity.setStartTs(-1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("42");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(-1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewEntity).setCreatedTime(eq(-1L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(-1L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(-1L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.USER));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("42"));
    verify(entityViewEntity).setName(eq("42"));
    verify(entityViewEntity).setStartTs(eq(-1L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("42"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(entityView, data.get(0));
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
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
    PageData<EntityView> actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class),
        eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType2() throws IOException {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(new EntityViewInfoEntity());
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class),
        eq("Type"), isNull(), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityViewInfo getResult = data.get(0);
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
    EntityViewId id = getResult.getId();
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
    assertEquals(EntityType.ENTITY_VIEW, id.getEntityType());
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
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType3() {
    // Arrange
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class),
        eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType4() {
    // Arrange
    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class),
        eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertFalse(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewInfosByTenantIdAndCustomerIdAndType5() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = mock(EntityViewInfoEntity.class);
    EntityViewInfo entityViewInfo = new EntityViewInfo();
    when(entityViewInfoEntity.toData()).thenReturn(entityViewInfo);

    ArrayList<EntityViewInfoEntity> content = new ArrayList<>();
    content.add(entityViewInfoEntity);
    PageImpl<EntityViewInfoEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findEntityViewInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityViewInfo> actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult = jpaEntityViewDao
        .findEntityViewInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewInfoEntity).toData();
    verify(entityViewRepository).findEntityViewInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class),
        eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<EntityViewInfo> data = actualFindEntityViewInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(entityViewInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}.
   * <ul>
   *   <li>Then first EntityId return {@link TenantId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEntityId_thenFirstEntityIdReturnTenantId() {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> entityViewEntityList = new ArrayList<>();
    entityViewEntityList.add(entityViewEntity);
    when(entityViewRepository.findAllByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewEntityList);

    // Act
    List<EntityView> actualFindEntityViewsByTenantIdAndEntityIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEntityId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findAllByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertEquals(1, actualFindEntityViewsByTenantIdAndEntityIdResult.size());
    EntityView getResult = actualFindEntityViewsByTenantIdAndEntityIdResult.get(0);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getEndTimeMs());
    assertEquals(1L, getResult.getStartTimeMs());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
    assertTrue(((TenantId) entityId).isSysTenantId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEntityId_thenReturnEmpty() {
    // Arrange
    when(entityViewRepository.findAllByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityView> actualFindEntityViewsByTenantIdAndEntityIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEntityId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findAllByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindEntityViewsByTenantIdAndEntityIdResult.isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}.
   * <ul>
   *   <li>Then return first is {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEntityId_thenReturnFirstIsEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> entityViewEntityList = new ArrayList<>();
    entityViewEntityList.add(entityViewEntity);
    when(entityViewRepository.findAllByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewEntityList);

    // Act
    List<EntityView> actualFindEntityViewsByTenantIdAndEntityIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEntityId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewEntity).setCreatedTime(eq(1L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(1L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(1L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.TENANT));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("Keys"));
    verify(entityViewEntity).setName(eq("Name"));
    verify(entityViewEntity).setStartTs(eq(1L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("Type"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findAllByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertEquals(1, actualFindEntityViewsByTenantIdAndEntityIdResult.size());
    assertSame(entityView, actualFindEntityViewsByTenantIdAndEntityIdResult.get(0));
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEntityId_thenReturnSizeIsTwo() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    EntityViewEntity entityViewEntity2 = new EntityViewEntity();
    entityViewEntity2.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity2.setCreatedTime(-1L);
    entityViewEntity2.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEndTs(-1L);
    entityViewEntity2.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity2.setEntityType(EntityType.USER);
    entityViewEntity2.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity2.setId(ModelConstants.NULL_UUID);
    entityViewEntity2.setKeys("42");
    entityViewEntity2.setName("42");
    entityViewEntity2.setStartTs(-1L);
    UUID tenantId = UUID.randomUUID();
    entityViewEntity2.setTenantId(tenantId);
    entityViewEntity2.setType("42");
    entityViewEntity2.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity2.setVersion(-1L);

    ArrayList<EntityViewEntity> entityViewEntityList = new ArrayList<>();
    entityViewEntityList.add(entityViewEntity2);
    entityViewEntityList.add(entityViewEntity);
    when(entityViewRepository.findAllByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewEntityList);
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    List<EntityView> actualFindEntityViewsByTenantIdAndEntityIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEntityId(ModelConstants.NULL_UUID, entityId);

    // Assert
    verify(entityViewEntity).setCreatedTime(eq(1L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(1L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(1L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.TENANT));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("Keys"));
    verify(entityViewEntity).setName(eq("Name"));
    verify(entityViewEntity).setStartTs(eq(1L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("Type"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findAllByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertEquals(2, actualFindEntityViewsByTenantIdAndEntityIdResult.size());
    EntityView getResult = actualFindEntityViewsByTenantIdAndEntityIdResult.get(0);
    EntityId entityId2 = getResult.getEntityId();
    assertTrue(entityId2 instanceof UserId);
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(-1L, getResult.getEndTimeMs());
    assertEquals(-1L, getResult.getStartTimeMs());
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertEquals(EntityType.USER, entityId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(entityView, actualFindEntityViewsByTenantIdAndEntityIdResult.get(1));
    assertSame(tenantId, tenantId2.getId());
    assertSame(entityId, entityId2.getId());
  }

  /**
   * Test {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  public void testExistsByTenantIdAndEntityId_thenReturnFalse() {
    // Arrange
    when(entityViewRepository.existsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndEntityIdResult = jpaEntityViewDao
        .existsByTenantIdAndEntityId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).existsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertFalse(actualExistsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  public void testExistsByTenantIdAndEntityId_thenReturnTrue() {
    // Arrange
    when(entityViewRepository.existsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndEntityIdResult = jpaEntityViewDao
        .existsByTenantIdAndEntityId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).existsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link JpaEntityViewDao#findTenantEntityViewTypesAsync(UUID)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findTenantEntityViewTypesAsync(UUID)}
   */
  @Test
  public void testFindTenantEntityViewTypesAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindTenantEntityViewTypesAsyncResult = jpaEntityViewDao
        .findTenantEntityViewTypesAsync(ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindTenantEntityViewTypesAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindTenantEntityViewTypesAsyncResult);
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeId() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(3L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(3L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]");
    entityViewEntity.setName("Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]");
    entityViewEntity.setStartTs(3L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(3L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID edgeId = ModelConstants.NULL_UUID;

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getName());
    assertEquals("Try to find entity views by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getType());
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
    assertEquals(3L, getResult.getEndTimeMs());
    assertEquals(3L, getResult.getStartTimeMs());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EntityViewId externalId = getResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
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
    assertTrue(entityId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(edgeId, getResult.getUuidId());
    assertSame(edgeId, customerId.getId());
    assertSame(edgeId, externalId.getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeId_thenReturnDataFirstIsEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(2L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(2L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("org.thingsboard.server.dao.model.sql.EntityViewEntity");
    entityViewEntity.setName("org.thingsboard.server.dao.model.sql.EntityViewEntity");
    entityViewEntity.setStartTs(2L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("org.thingsboard.server.dao.model.sql.EntityViewEntity");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(2L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewEntity).setCreatedTime(eq(2L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(2L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(2L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.USER));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("org.thingsboard.server.dao.model.sql.EntityViewEntity"));
    verify(entityViewEntity).setName(eq("org.thingsboard.server.dao.model.sql.EntityViewEntity"));
    verify(entityViewEntity).setStartTs(eq(2L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("org.thingsboard.server.dao.model.sql.EntityViewEntity"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    assertSame(entityView, data.get(0));
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(4L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(4L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    entityViewEntity.setName("Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    entityViewEntity.setStartTs(4L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(4L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID edgeId = ModelConstants.NULL_UUID;

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEdgeIdAndType(ModelConstants.NULL_UUID, edgeId, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
        getResult.getName());
    assertEquals("Try to find entity views by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]",
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
    assertEquals(4L, getResult.getEndTimeMs());
    assertEquals(4L, getResult.getStartTimeMs());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EntityViewId externalId = getResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
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
    assertTrue(entityId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(edgeId, getResult.getUuidId());
    assertSame(edgeId, customerId.getId());
    assertSame(edgeId, externalId.getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenReturnDataFirstIsEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(2L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(2L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("org.thingsboard.server.dao.model.sql.EntityViewEntity");
    entityViewEntity.setName("org.thingsboard.server.dao.model.sql.EntityViewEntity");
    entityViewEntity.setStartTs(2L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("org.thingsboard.server.dao.model.sql.EntityViewEntity");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(2L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEdgeIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewEntity).setCreatedTime(eq(2L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(2L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(2L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.USER));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("org.thingsboard.server.dao.model.sql.EntityViewEntity"));
    verify(entityViewEntity).setName(eq("org.thingsboard.server.dao.model.sql.EntityViewEntity"));
    verify(entityViewEntity).setStartTs(eq(2L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("org.thingsboard.server.dao.model.sql.EntityViewEntity"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(entityView, data.get(0));
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEdgeIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findEntityViewsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindEntityViewsByTenantIdAndEdgeIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(entityViewRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
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
    PageData<EntityView> actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult = jpaEntityViewDao
        .findEntityViewsByTenantIdAndEdgeIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindEntityViewsByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    EntityView actualFindByTenantIdAndExternalIdResult = jpaEntityViewDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(entityViewRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    JsonNode additionalInfo = actualFindByTenantIdAndExternalIdResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = actualFindByTenantIdAndExternalIdResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Name", actualFindByTenantIdAndExternalIdResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", actualFindByTenantIdAndExternalIdResult.getType());
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
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getEndTimeMs());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getStartTimeMs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = actualFindByTenantIdAndExternalIdResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EntityViewId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId2.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
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
    assertTrue(entityId.isNullUid());
    assertTrue(externalId2.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
    assertSame(externalId, customerId.getId());
    assertSame(externalId, externalId2.getId());
    assertSame(entityId, actualFindByTenantIdAndExternalIdResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(entityViewEntity);

    // Act
    EntityView actualFindByTenantIdAndExternalIdResult = jpaEntityViewDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(entityViewRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    verify(entityViewEntity).setCreatedTime(eq(1L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(1L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(1L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.TENANT));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("Keys"));
    verify(entityViewEntity).setName(eq("Name"));
    verify(entityViewEntity).setStartTs(eq(1L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("Type"));
    verify(entityViewEntity).toData();
    assertSame(entityView, actualFindByTenantIdAndExternalIdResult);
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindByTenantIdResult = jpaEntityViewDao.findByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenDataFirstAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<EntityView> actualFindByTenantIdResult = jpaEntityViewDao.findByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<EntityView> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    EntityView getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = getResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Name", getResult.getName());
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
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getEndTimeMs());
    assertEquals(1L, getResult.getStartTimeMs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EntityViewId externalId = getResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
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
    assertTrue(entityId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(entityId, getResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstIsEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(-1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(-1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.USER);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("42");
    entityViewEntity.setName("42");
    entityViewEntity.setStartTs(-1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("42");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(-1L);

    ArrayList<EntityViewEntity> content = new ArrayList<>();
    content.add(entityViewEntity);
    PageImpl<EntityViewEntity> pageImpl = new PageImpl<>(content);
    when(entityViewRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EntityView> actualFindByTenantIdResult = jpaEntityViewDao.findByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(entityViewEntity).setCreatedTime(eq(-1L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(-1L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(-1L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.USER));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("42"));
    verify(entityViewEntity).setName(eq("42"));
    verify(entityViewEntity).setStartTs(eq(-1L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("42"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<EntityView> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(entityView, data.get(0));
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEntityViewDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(entityViewRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<EntityView> actualFindByTenantIdResult = jpaEntityViewDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityViewRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaEntityViewDao#getExternalIdByInternal(EntityViewId)} with
   * {@code EntityViewId}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#getExternalIdByInternal(EntityViewId)}
   */
  @Test
  public void testGetExternalIdByInternalWithEntityViewId() {
    // Arrange
    when(entityViewRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    EntityViewId internalId = new EntityViewId(ModelConstants.NULL_UUID);

    // Act
    EntityViewId actualExternalIdByInternal = jpaEntityViewDao.getExternalIdByInternal(internalId);

    // Assert
    verify(entityViewRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaEntityViewDao#getExternalIdByInternal(EntityViewId)} with
   * {@code EntityViewId}.
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#getExternalIdByInternal(EntityViewId)}
   */
  @Test
  public void testGetExternalIdByInternalWithEntityViewId2() {
    // Arrange
    when(entityViewRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    EntityViewId internalId = mock(EntityViewId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    EntityViewId actualExternalIdByInternal = jpaEntityViewDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(entityViewRepository).getExternalIdById(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.ENTITY_VIEW, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaEntityViewDao#getExternalIdByInternal(EntityViewId)} with
   * {@code EntityViewId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#getExternalIdByInternal(EntityViewId)}
   */
  @Test
  public void testGetExternalIdByInternalWithEntityViewId_thenReturnNull() {
    // Arrange
    when(entityViewRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    EntityViewId actualExternalIdByInternal = jpaEntityViewDao
        .getExternalIdByInternal(new EntityViewId(ModelConstants.NULL_UUID));

    // Assert
    verify(entityViewRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    EntityViewEntity entityViewEntity = new EntityViewEntity();
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(entityViewEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    EntityView actualFindByTenantIdAndNameResult = jpaEntityViewDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(entityViewRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    JsonNode additionalInfo = actualFindByTenantIdAndNameResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    EntityId entityId = actualFindByTenantIdAndNameResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", entityId.getId().toString());
    assertEquals("Name", actualFindByTenantIdAndNameResult.getName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    assertEquals("Type", actualFindByTenantIdAndNameResult.getType());
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
    assertEquals(1L, actualFindByTenantIdAndNameResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getCreatedTime());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getEndTimeMs());
    assertEquals(1L, actualFindByTenantIdAndNameResult.getStartTimeMs());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    CustomerId customerId = actualFindByTenantIdAndNameResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    EntityViewId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.ENTITY_VIEW, externalId.getEntityType());
    assertEquals(EntityType.TENANT, entityId.getEntityType());
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
    assertTrue(entityId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(((TenantId) entityId).isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, externalId.getId());
    assertSame(entityId, actualFindByTenantIdAndNameResult.getTenantId());
  }

  /**
   * Test {@link JpaEntityViewDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return {@link EntityView#EntityView()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaEntityViewDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenReturnEntityView() {
    // Arrange
    EntityViewEntity entityViewEntity = mock(EntityViewEntity.class);
    EntityView entityView = new EntityView();
    when(entityViewEntity.toData()).thenReturn(entityView);
    doNothing().when(entityViewEntity).setCreatedTime(anyLong());
    doNothing().when(entityViewEntity).setId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setVersion(Mockito.<Long>any());
    doNothing().when(entityViewEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(entityViewEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEndTs(anyLong());
    doNothing().when(entityViewEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setEntityType(Mockito.<EntityType>any());
    doNothing().when(entityViewEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setKeys(Mockito.<String>any());
    doNothing().when(entityViewEntity).setName(Mockito.<String>any());
    doNothing().when(entityViewEntity).setStartTs(anyLong());
    doNothing().when(entityViewEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entityViewEntity).setType(Mockito.<String>any());
    entityViewEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entityViewEntity.setCreatedTime(1L);
    entityViewEntity.setCustomerId(ModelConstants.NULL_UUID);
    entityViewEntity.setEndTs(1L);
    entityViewEntity.setEntityId(ModelConstants.NULL_UUID);
    entityViewEntity.setEntityType(EntityType.TENANT);
    entityViewEntity.setExternalId(ModelConstants.NULL_UUID);
    entityViewEntity.setId(ModelConstants.NULL_UUID);
    entityViewEntity.setKeys("Keys");
    entityViewEntity.setName("Name");
    entityViewEntity.setStartTs(1L);
    entityViewEntity.setTenantId(ModelConstants.NULL_UUID);
    entityViewEntity.setType("Type");
    entityViewEntity.setUuid(ModelConstants.NULL_UUID);
    entityViewEntity.setVersion(1L);
    when(entityViewRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(entityViewEntity);

    // Act
    EntityView actualFindByTenantIdAndNameResult = jpaEntityViewDao.findByTenantIdAndName(ModelConstants.NULL_UUID,
        "Name");

    // Assert
    verify(entityViewEntity).setCreatedTime(eq(1L));
    verify(entityViewEntity).setId(isA(UUID.class));
    verify(entityViewEntity).setUuid(isA(UUID.class));
    verify(entityViewEntity).setVersion(eq(1L));
    verify(entityViewEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(entityViewEntity).setCustomerId(isA(UUID.class));
    verify(entityViewEntity).setEndTs(eq(1L));
    verify(entityViewEntity).setEntityId(isA(UUID.class));
    verify(entityViewEntity).setEntityType(eq(EntityType.TENANT));
    verify(entityViewEntity).setExternalId(isA(UUID.class));
    verify(entityViewEntity).setKeys(eq("Keys"));
    verify(entityViewEntity).setName(eq("Name"));
    verify(entityViewEntity).setStartTs(eq(1L));
    verify(entityViewEntity).setTenantId(isA(UUID.class));
    verify(entityViewEntity).setType(eq("Type"));
    verify(entityViewEntity).toData();
    verify(entityViewRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    assertSame(entityView, actualFindByTenantIdAndNameResult);
  }
}
