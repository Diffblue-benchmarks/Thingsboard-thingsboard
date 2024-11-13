package org.thingsboard.server.dao.sql.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
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
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.asset.AssetInfo;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.util.TbPair;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AssetEntity;
import org.thingsboard.server.dao.model.sql.AssetInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaAssetDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaAssetDaoDiffblueTest {
  @MockBean
  private AssetProfileRepository assetProfileRepository;

  @MockBean
  private AssetRepository assetRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAssetDao jpaAssetDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAssetDao#getEntityClass()}
   *   <li>{@link JpaAssetDao#getEntityType()}
   *   <li>{@link JpaAssetDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaAssetDao jpaAssetDao = new JpaAssetDao();

    // Act
    Class<AssetEntity> actualEntityClass = jpaAssetDao.getEntityClass();
    EntityType actualEntityType = jpaAssetDao.getEntityType();

    // Assert
    assertNull(jpaAssetDao.getRepository());
    assertEquals(EntityType.ASSET, actualEntityType);
    Class<AssetEntity> expectedEntityClass = AssetEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@link AssetInfo#AssetInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindAssetInfoById_thenReturnAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(assetInfoEntity);

    // Act
    AssetInfo actualFindAssetInfoByIdResult = jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(assetInfoEntity).toData();
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    assertSame(assetInfo, actualFindAssetInfoByIdResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return AssetProfileName is {@code foo.txt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindAssetInfoById_thenReturnAssetProfileNameIsFooTxt() throws IOException {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    assetInfoEntity.setAssetProfileName("foo.txt");
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(assetInfoEntity);

    // Act
    AssetInfo actualFindAssetInfoByIdResult = jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    JsonNode additionalInfo = actualFindAssetInfoByIdResult.getAdditionalInfo();
    assertTrue(additionalInfo instanceof NullNode);
    JsonParser traverseResult = additionalInfo.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    Version versionResult = traverseResult.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("foo.txt", actualFindAssetInfoByIdResult.getAssetProfileName());
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
    AssetId id = actualFindAssetInfoByIdResult.getId();
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
    assertEquals(EntityType.ASSET, id.getEntityType());
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
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return AssetProfileName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindAssetInfoById_thenReturnAssetProfileNameIsNull() throws IOException {
    // Arrange
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(new AssetInfoEntity());

    // Act
    AssetInfo actualFindAssetInfoByIdResult = jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    JsonNode additionalInfo = actualFindAssetInfoByIdResult.getAdditionalInfo();
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
    assertNull(actualFindAssetInfoByIdResult.getAssetProfileName());
    AssetId id = actualFindAssetInfoByIdResult.getId();
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
    assertEquals(EntityType.ASSET, id.getEntityType());
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
   * Test {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindAssetInfoById_thenReturnNull() {
    // Arrange
    when(assetRepository.findAssetInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    AssetInfo actualFindAssetInfoByIdResult = jpaAssetDao.findAssetInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(assetRepository).findAssetInfoById(isA(UUID.class));
    assertNull(actualFindAssetInfoByIdResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult = jpaAssetDao.findAssetsByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult = jpaAssetDao.findAssetsByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first Label is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantId_thenReturnDataFirstLabelIs42() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(-1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("42");
    assetEntity.setName("42");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("42");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(-1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult = jpaAssetDao.findAssetsByTenantId(ModelConstants.NULL_UUID,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findAssetsByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult = jpaAssetDao.findAssetsByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantId_givenArrayListAddNull_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult = jpaAssetDao
        .findAssetInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult = jpaAssetDao
        .findAssetInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantId_thenDataFirstAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult = jpaAssetDao
        .findAssetInfosByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
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
    AssetId id = getResult.getId();
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
    assertEquals(EntityType.ASSET, id.getEntityType());
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
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link AssetInfo#AssetInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantId_thenReturnDataFirstIsAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult = jpaAssetDao
        .findAssetInfosByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository).findAssetInfosByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult = jpaAssetDao
        .findAssetInfosByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  public void testFindAssetsByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> assetIds = new ArrayList<>();
    assetIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndIdsAsyncResult = jpaAssetDao
        .findAssetsByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, assetIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  public void testFindAssetsByTenantIdAndIdsAsync_givenNull_uuid_whenArrayListAddNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> assetIds = new ArrayList<>();
    assetIds.add(ModelConstants.NULL_UUID);
    assetIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndIdsAsyncResult = jpaAssetDao
        .findAssetsByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, assetIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndIdsAsync(UUID, List)}
   */
  @Test
  public void testFindAssetsByTenantIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndIdsAsyncResult = jpaAssetDao
        .findAssetsByTenantIdAndIdsAsync(ModelConstants.NULL_UUID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult = jpaAssetDao.findAssetsByTenantIdAndCustomerId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult = jpaAssetDao
        .findAssetsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first Label is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerId_thenReturnDataFirstLabelIs42() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(-1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("42");
    assetEntity.setName("42");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("42");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(-1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult = jpaAssetDao
        .findAssetsByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult = jpaAssetDao.findAssetsByTenantIdAndCustomerId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerId() throws IOException {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
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
    AssetId id = getResult.getId();
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
    assertEquals(EntityType.ASSET, id.getEntityType());
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
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link AssetInfo#AssetInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerId_thenReturnDataFirstIsAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndIdsAsync_givenNull_uuid() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> assetIds = new ArrayList<>();
    assetIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult = jpaAssetDao
        .findAssetsByTenantIdAndCustomerIdAndIdsAsync(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, assetIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndIdsAsync_givenNull_uuid2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<UUID> assetIds = new ArrayList<>();
    assetIds.add(ModelConstants.NULL_UUID);
    assetIds.add(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult = jpaAssetDao
        .findAssetsByTenantIdAndCustomerIdAndIdsAsync(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, assetIds);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndIdsAsync(UUID, UUID, List)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndIdsAsync_whenArrayList() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult = jpaAssetDao
        .findAssetsByTenantIdAndCustomerIdAndIdsAsync(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            new ArrayList<>());

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndName(UUID, String)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindAssetsByTenantIdAndName() throws IOException {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(assetEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Asset> actualFindAssetsByTenantIdAndNameResult = jpaAssetDao.findAssetsByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(assetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    Asset getResult = actualFindAssetsByTenantIdAndNameResult.get();
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
    AssetId externalId = getResult.getExternalId();
    assertEquals(EntityType.ASSET, externalId.getEntityType());
    AssetProfileId assetProfileId = getResult.getAssetProfileId();
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId.getEntityType());
    CustomerId customerId = getResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
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
    assertTrue(actualFindAssetsByTenantIdAndNameResult.isPresent());
    assertTrue(assetProfileId.isNullUid());
    assertTrue(customerId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, getResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, assetProfileId.getId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return not {@link Optional#get()} TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindAssetsByTenantIdAndName_thenReturnNotGetTenantIdNullUid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(assetEntity);

    // Act
    Optional<Asset> actualFindAssetsByTenantIdAndNameResult = jpaAssetDao
        .findAssetsByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(assetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindAssetsByTenantIdAndNameResult.get().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndType() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult = jpaAssetDao
        .findAssetsByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult = jpaAssetDao
        .findAssetsByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first Label is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndType_thenReturnDataFirstLabelIs42() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(-1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("42");
    assetEntity.setName("42");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("42");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(-1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult = jpaAssetDao
        .findAssetsByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult = jpaAssetDao
        .findAssetsByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult = jpaAssetDao
        .findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndType_thenDataFirstAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult = jpaAssetDao
        .findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
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
    AssetId id = getResult.getId();
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
    assertEquals(EntityType.ASSET, id.getEntityType());
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
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link AssetInfo#AssetInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndType_thenReturnDataFirstIsAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult = jpaAssetDao
        .findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository).findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndType_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult = jpaAssetDao
        .findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndTypeResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndType(UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndType_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult = jpaAssetDao
        .findAssetInfosByTenantIdAndType(ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndAssetProfileId() throws IOException {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndAssetProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantIdAndAssetProfileId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
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
    AssetId id = getResult.getId();
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
    assertEquals(EntityType.ASSET, id.getEntityType());
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
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link AssetInfo#AssetInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndAssetProfileId_thenReturnDataFirstIsAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndAssetProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository).findAssetInfosByTenantIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndAssetProfileId_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndAssetProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndAssetProfileId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndAssetProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantIdAndAssetProfileId(isA(UUID.class), isA(UUID.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndAssetProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndAssetProfileId_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndAssetProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndType() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult = jpaAssetDao
        .findAssetsByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first Label is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndType_thenReturnDataFirstLabelIs42() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(-1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("42");
    assetEntity.setName("42");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("42");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(-1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult = jpaAssetDao
        .findAssetsByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult = jpaAssetDao
        .findAssetsByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(assetRepository.findByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
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
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult = jpaAssetDao
        .findAssetsByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType() throws IOException {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isNull(), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
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
    AssetId id = getResult.getId();
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
    assertEquals(EntityType.ASSET, id.getEntityType());
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
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link AssetInfo#AssetInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenReturnDataFirstIsAssetInfo() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenReturnTotalElementsIsZero2() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
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
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type",
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId2() throws IOException {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(new AssetInfoEntity());
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        isA(UUID.class), isNull(), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData();
    assertEquals(1, data.size());
    AssetInfo getResult = data.get(0);
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
    AssetId id = getResult.getId();
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
    assertEquals(EntityType.ASSET, id.getEntityType());
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
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId3() {
    // Arrange
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalElements());
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId4() {
    // Arrange
    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalPages());
    assertEquals(1L, actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getTotalElements());
    assertFalse(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.hasNext());
    assertTrue(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(UUID, UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId5() {
    // Arrange
    AssetInfoEntity assetInfoEntity = mock(AssetInfoEntity.class);
    AssetInfo assetInfo = new AssetInfo();
    when(assetInfoEntity.toData()).thenReturn(assetInfo);

    ArrayList<AssetInfoEntity> content = new ArrayList<>();
    content.add(assetInfoEntity);
    PageImpl<AssetInfoEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult = jpaAssetDao
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetInfoEntity).toData();
    verify(assetRepository).findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<AssetInfo> data = actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.getData();
    assertEquals(1, data.size());
    assertSame(assetInfo, data.get(0));
  }

  /**
   * Test {@link JpaAssetDao#findTenantAssetTypesAsync(UUID)}.
   * <p>
   * Method under test: {@link JpaAssetDao#findTenantAssetTypesAsync(UUID)}
   */
  @Test
  public void testFindTenantAssetTypesAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindTenantAssetTypesAsyncResult = jpaAssetDao
        .findTenantAssetTypesAsync(ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindTenantAssetTypesAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindTenantAssetTypesAsyncResult);
  }

  /**
   * Test {@link JpaAssetDao#countAssetsByAssetProfileId(TenantId, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#countAssetsByAssetProfileId(TenantId, UUID)}
   */
  @Test
  public void testCountAssetsByAssetProfileId() {
    // Arrange
    when(assetRepository.countByAssetProfileId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountAssetsByAssetProfileIdResult = jpaAssetDao.countAssetsByAssetProfileId(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(assetRepository).countByAssetProfileId(isA(UUID.class));
    assertEquals(1L, actualCountAssetsByAssetProfileIdResult.longValue());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndProfileId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndProfileIdResult = jpaAssetDao.findAssetsByTenantIdAndProfileId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndProfileId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndProfileIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndProfileId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndProfileIdResult = jpaAssetDao
        .findAssetsByTenantIdAndProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndProfileId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndProfileIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndProfileIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndProfileIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first Label is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndProfileId_thenReturnDataFirstLabelIs42() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(-1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("42");
    assetEntity.setName("42");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("42");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(-1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndProfileIdResult = jpaAssetDao
        .findAssetsByTenantIdAndProfileId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndProfileId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndProfileIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndProfileId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndProfileId_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndProfileIdResult = jpaAssetDao.findAssetsByTenantIdAndProfileId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndProfileId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndProfileIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndProfileIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndProfileIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndProfileIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(3L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]");
    assetEntity.setName("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(3L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult = jpaAssetDao.findAssetsByTenantIdAndEdgeId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getLabel());
    assertEquals("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getName());
    assertEquals("Try to find assets by tenantId [{}], edgeId [{}] and pageLink [{}]", getResult.getType());
    assertEquals(3L, getResult.getVersion().longValue());
    assertEquals(3L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeId2() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(2L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("org.thingsboard.server.dao.model.sql.AssetEntity");
    assetEntity.setName("org.thingsboard.server.dao.model.sql.AssetEntity");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("org.thingsboard.server.dao.model.sql.AssetEntity");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(2L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult = jpaAssetDao
        .findAssetsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndEdgeIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("org.thingsboard.server.dao.model.sql.AssetEntity", getResult.getLabel());
    assertEquals("org.thingsboard.server.dao.model.sql.AssetEntity", getResult.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.AssetEntity", getResult.getType());
    assertEquals(2L, getResult.getVersion().longValue());
    assertEquals(2L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult = jpaAssetDao
        .findAssetsByTenantIdAndEdgeId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeId(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult = jpaAssetDao.findAssetsByTenantIdAndEdgeId(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndEdgeIdResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndEdgeIdResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndEdgeIdResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndEdgeIdResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeIdAndType() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(4L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    assetEntity.setName("Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(4L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult = jpaAssetDao.findAssetsByTenantIdAndEdgeIdAndType(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]", getResult.getLabel());
    assertEquals("Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]", getResult.getName());
    assertEquals("Try to find assets by tenantId [{}], edgeId [{}], type [{}] and pageLink [{}]", getResult.getType());
    assertEquals(4L, getResult.getVersion().longValue());
    assertEquals(4L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeIdAndType2() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(2L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("org.thingsboard.server.dao.model.sql.AssetEntity");
    assetEntity.setName("org.thingsboard.server.dao.model.sql.AssetEntity");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("org.thingsboard.server.dao.model.sql.AssetEntity");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(2L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult = jpaAssetDao
        .findAssetsByTenantIdAndEdgeIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("org.thingsboard.server.dao.model.sql.AssetEntity", getResult.getLabel());
    assertEquals("org.thingsboard.server.dao.model.sql.AssetEntity", getResult.getName());
    assertEquals("org.thingsboard.server.dao.model.sql.AssetEntity", getResult.getType());
    assertEquals(2L, getResult.getVersion().longValue());
    assertEquals(2L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeIdAndType_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult = jpaAssetDao
        .findAssetsByTenantIdAndEdgeIdAndType(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findAssetsByTenantIdAndEdgeIdAndType(UUID, UUID, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeIdAndType_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult = jpaAssetDao.findAssetsByTenantIdAndEdgeIdAndType(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getTotalElements());
    assertEquals(1, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getTotalPages());
    assertFalse(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.hasNext());
    assertTrue(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#getAllAssetTypes(PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#getAllAssetTypes(PageLink)}
   */
  @Test
  public void testGetAllAssetTypes_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(assetRepository.getAllAssetTypes(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act
    PageData<TbPair<UUID, String>> actualAllAssetTypes = jpaAssetDao.getAllAssetTypes(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(assetRepository).getAllAssetTypes(isA(Pageable.class));
    assertEquals(0L, actualAllAssetTypes.getTotalElements());
    assertEquals(1, actualAllAssetTypes.getTotalPages());
    assertFalse(actualAllAssetTypes.hasNext());
    assertTrue(actualAllAssetTypes.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#getAllAssetTypes(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#getAllAssetTypes(PageLink)}
   */
  @Test
  public void testGetAllAssetTypes_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.getAllAssetTypes(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TbPair<UUID, String>> actualAllAssetTypes = jpaAssetDao
        .getAllAssetTypes(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).getAllAssetTypes(isA(Pageable.class));
    assertEquals(0L, actualAllAssetTypes.getTotalElements());
    assertEquals(1, actualAllAssetTypes.getTotalPages());
    assertFalse(actualAllAssetTypes.hasNext());
    assertTrue(actualAllAssetTypes.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(assetRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaAssetDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(assetEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Asset actualFindByTenantIdAndExternalIdResult = jpaAssetDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID,
        externalId);

    // Assert
    verify(assetRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
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
    assertEquals("Label", actualFindByTenantIdAndExternalIdResult.getLabel());
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
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    AssetId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.ASSET, externalId2.getEntityType());
    AssetProfileId assetProfileId = actualFindByTenantIdAndExternalIdResult.getAssetProfileId();
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId.getEntityType());
    CustomerId customerId = actualFindByTenantIdAndExternalIdResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
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
    assertTrue(assetProfileId.isNullUid());
    assertTrue(customerId.isNullUid());
    assertTrue(externalId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId2, actualFindByTenantIdAndExternalIdResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
    assertSame(externalId, assetProfileId.getId());
    assertSame(externalId, customerId.getId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAssetDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(assetEntity);

    // Act
    Asset actualFindByTenantIdAndExternalIdResult = jpaAssetDao.findByTenantIdAndExternalId(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID);

    // Assert
    verify(assetRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId2 = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(assetEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Asset actualFindByTenantIdAndNameResult = jpaAssetDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(assetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    JsonNode additionalInfo = actualFindByTenantIdAndNameResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = additionalInfo.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Label", actualFindByTenantIdAndNameResult.getLabel());
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
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, additionalInfo.getNodeType());
    AssetId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.ASSET, externalId.getEntityType());
    AssetProfileId assetProfileId = actualFindByTenantIdAndNameResult.getAssetProfileId();
    assertEquals(EntityType.ASSET_PROFILE, assetProfileId.getEntityType());
    CustomerId customerId = actualFindByTenantIdAndNameResult.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
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
    assertTrue(assetProfileId.isNullUid());
    assertTrue(customerId.isNullUid());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertEquals(externalId, actualFindByTenantIdAndNameResult.getId());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
    assertSame(tenantId, assetProfileId.getId());
    assertSame(tenantId, customerId.getId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenReturnNotTenantIdNullUid() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);
    when(assetRepository.findByTenantIdAndName(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(assetEntity);

    // Act
    Asset actualFindByTenantIdAndNameResult = jpaAssetDao.findByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(assetRepository).findByTenantIdAndName(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test: {@link JpaAssetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("Label");
    assetEntity.setName("Name");
    assetEntity.setTenantId(ModelConstants.NULL_UUID);
    assetEntity.setType("Type");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);

    // Act
    PageData<Asset> actualFindByTenantIdResult = jpaAssetDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<Asset> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Label", getResult.getLabel());
    assertEquals("Name", getResult.getName());
    assertEquals("Type", getResult.getType());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindByTenantIdResult = jpaAssetDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first Label is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstLabelIs42() {
    // Arrange
    AssetEntity assetEntity = new AssetEntity();
    assetEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    assetEntity.setAssetProfileId(ModelConstants.NULL_UUID);
    assetEntity.setCreatedTime(-1L);
    assetEntity.setCustomerId(ModelConstants.NULL_UUID);
    assetEntity.setExternalId(ModelConstants.NULL_UUID);
    assetEntity.setId(ModelConstants.NULL_UUID);
    assetEntity.setLabel("42");
    assetEntity.setName("42");
    UUID tenantId = UUID.randomUUID();
    assetEntity.setTenantId(tenantId);
    assetEntity.setType("42");
    assetEntity.setUuid(ModelConstants.NULL_UUID);
    assetEntity.setVersion(-1L);

    ArrayList<AssetEntity> content = new ArrayList<>();
    content.add(assetEntity);
    PageImpl<AssetEntity> pageImpl = new PageImpl<>(content);
    when(assetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Asset> actualFindByTenantIdResult = jpaAssetDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(assetRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Asset> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Asset getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("42", getResult.getLabel());
    assertEquals("42", getResult.getName());
    assertEquals("42", getResult.getType());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    AssetId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaAssetDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(assetRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Asset> actualFindByTenantIdResult = jpaAssetDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAssetDao#getExternalIdByInternal(AssetId)} with
   * {@code AssetId}.
   * <p>
   * Method under test: {@link JpaAssetDao#getExternalIdByInternal(AssetId)}
   */
  @Test
  public void testGetExternalIdByInternalWithAssetId() {
    // Arrange
    when(assetRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    AssetId internalId = mock(AssetId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AssetId actualExternalIdByInternal = jpaAssetDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(assetRepository).getExternalIdById(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.ASSET, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaAssetDao#getExternalIdByInternal(AssetId)} with
   * {@code AssetId}.
   * <ul>
   *   <li>Then return {@link AssetId#AssetId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#getExternalIdByInternal(AssetId)}
   */
  @Test
  public void testGetExternalIdByInternalWithAssetId_thenReturnAssetIdWithIdIsNull_uuid() {
    // Arrange
    when(assetRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    AssetId internalId = new AssetId(ModelConstants.NULL_UUID);

    // Act
    AssetId actualExternalIdByInternal = jpaAssetDao.getExternalIdByInternal(internalId);

    // Assert
    verify(assetRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaAssetDao#getExternalIdByInternal(AssetId)} with
   * {@code AssetId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAssetDao#getExternalIdByInternal(AssetId)}
   */
  @Test
  public void testGetExternalIdByInternalWithAssetId_thenReturnNull() {
    // Arrange
    when(assetRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    AssetId actualExternalIdByInternal = jpaAssetDao.getExternalIdByInternal(new AssetId(ModelConstants.NULL_UUID));

    // Assert
    verify(assetRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }
}
