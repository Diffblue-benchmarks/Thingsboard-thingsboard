package org.thingsboard.server.dao.sql.tenant;

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
import jakarta.persistence.EntityManagerFactory;
import java.io.IOException;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantInfo;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TenantEntity;
import org.thingsboard.server.dao.model.sql.TenantInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaTenantDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaTenantDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaTenantDao jpaTenantDao;

  @MockBean
  private TenantRepository tenantRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaTenantDao#getEntityClass()}
   *   <li>{@link JpaTenantDao#getEntityType()}
   *   <li>{@link JpaTenantDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaTenantDao jpaTenantDao = new JpaTenantDao();

    // Act
    Class<TenantEntity> actualEntityClass = jpaTenantDao.getEntityClass();
    EntityType actualEntityType = jpaTenantDao.getEntityType();

    // Assert
    assertNull(jpaTenantDao.getRepository());
    assertEquals(EntityType.TENANT, actualEntityType);
    Class<TenantEntity> expectedEntityClass = TenantEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindTenantInfoById_thenAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    when(tenantRepository.findTenantInfoById(Mockito.<UUID>any())).thenReturn(new TenantInfoEntity());

    // Act
    TenantInfo actualFindTenantInfoByIdResult = jpaTenantDao.findTenantInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(tenantRepository).findTenantInfoById(isA(UUID.class));
    JsonNode additionalInfo = actualFindTenantInfoByIdResult.getAdditionalInfo();
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
    TenantId id = actualFindTenantInfoByIdResult.getId();
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
    assertEquals(EntityType.TENANT, id.getEntityType());
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
    assertFalse(id.isSysTenantId());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(id, actualFindTenantInfoByIdResult.getTenantId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindTenantInfoById_thenReturnNull() {
    // Arrange
    when(tenantRepository.findTenantInfoById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    TenantInfo actualFindTenantInfoByIdResult = jpaTenantDao.findTenantInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(tenantRepository).findTenantInfoById(isA(UUID.class));
    assertNull(actualFindTenantInfoByIdResult);
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@link TenantInfo#TenantInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantInfoById(TenantId, UUID)}
   */
  @Test
  public void testFindTenantInfoById_thenReturnTenantInfo() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = mock(TenantInfoEntity.class);
    TenantInfo tenantInfo = new TenantInfo();
    when(tenantInfoEntity.toData()).thenReturn(tenantInfo);
    when(tenantRepository.findTenantInfoById(Mockito.<UUID>any())).thenReturn(tenantInfoEntity);

    // Act
    TenantInfo actualFindTenantInfoByIdResult = jpaTenantDao.findTenantInfoById(ModelConstants.SYSTEM_TENANT,
        ModelConstants.NULL_UUID);

    // Assert
    verify(tenantInfoEntity).toData();
    verify(tenantRepository).findTenantInfoById(isA(UUID.class));
    assertSame(tenantInfo, actualFindTenantInfoByIdResult);
  }

  /**
   * Test {@link JpaTenantDao#findTenants(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenants(TenantId, PageLink)}
   */
  @Test
  public void testFindTenants_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantsNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Tenant> actualFindTenantsResult = jpaTenantDao.findTenants(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsNextPage(eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantsResult.getTotalElements());
    assertEquals(1, actualFindTenantsResult.getTotalPages());
    assertFalse(actualFindTenantsResult.hasNext());
    assertTrue(actualFindTenantsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenants(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data first Phone is {@code +44 1865 4960636}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenants(TenantId, PageLink)}
   */
  @Test
  public void testFindTenants_thenReturnDataFirstPhoneIs4418654960636() {
    // Arrange
    TenantEntity tenantEntity = new TenantEntity();
    tenantEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tenantEntity.setAddress("11 Station Rd");
    tenantEntity.setAddress2("11 Station Rd");
    tenantEntity.setCity("City");
    tenantEntity.setCountry("US");
    tenantEntity.setCreatedTime(-1L);
    tenantEntity.setEmail("prof.einstein@example.org");
    tenantEntity.setId(ModelConstants.NULL_UUID);
    tenantEntity.setPhone("+44 1865 4960636");
    tenantEntity.setRegion("org.thingsboard.server.dao.model.sql.TenantEntity");
    tenantEntity.setState("org.thingsboard.server.dao.model.sql.TenantEntity");
    tenantEntity.setTenantProfileId(ModelConstants.NULL_UUID);
    tenantEntity.setTitle("Prof");
    UUID id = UUID.randomUUID();
    tenantEntity.setUuid(id);
    tenantEntity.setVersion(-1L);
    tenantEntity.setZip("127.0.0.1");

    ArrayList<TenantEntity> content = new ArrayList<>();
    content.add(tenantEntity);
    PageImpl<TenantEntity> pageImpl = new PageImpl<>(content);
    when(tenantRepository.findTenantsNextPage(Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Tenant> actualFindTenantsResult = jpaTenantDao.findTenants(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsNextPage(eq("Text Search"), isA(Pageable.class));
    List<Tenant> data = actualFindTenantsResult.getData();
    assertEquals(1, data.size());
    Tenant getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    assertEquals("+44 1865 4960636", getResult.getPhone());
    assertEquals("11 Station Rd", getResult.getAddress());
    assertEquals("11 Station Rd", getResult.getAddress2());
    assertEquals("City", getResult.getCity());
    assertEquals("Prof", getResult.getName());
    assertEquals("Prof", getResult.getTitle());
    assertEquals("US", getResult.getCountry());
    assertEquals("org.thingsboard.server.dao.model.sql.TenantEntity", getResult.getRegion());
    assertEquals("org.thingsboard.server.dao.model.sql.TenantEntity", getResult.getState());
    assertEquals("prof.einstein@example.org", getResult.getEmail());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId id2 = getResult.getId();
    assertFalse(id2.isNullUid());
    assertFalse(id2.isSysTenantId());
    assertSame(id2, getResult.getTenantId());
    assertSame(id, getResult.getUuidId());
    assertSame(id, id2.getId());
  }

  /**
   * Test {@link JpaTenantDao#findTenants(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenants(TenantId, PageLink)}
   */
  @Test
  public void testFindTenants_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantsNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Tenant> actualFindTenantsResult = jpaTenantDao.findTenants(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantRepository).findTenantsNextPage(isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantsResult.getTotalElements());
    assertEquals(1, actualFindTenantsResult.getTotalPages());
    assertFalse(actualFindTenantsResult.hasNext());
    assertTrue(actualFindTenantsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantInfos_givenArrayListAddNull_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<TenantInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<TenantInfoEntity> pageImpl = new PageImpl<>(content);
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult = jpaTenantDao.findTenantInfos(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantInfosNextPage(eq("Text Search"), isA(Pageable.class));
    assertEquals(1, actualFindTenantInfosResult.getTotalPages());
    assertEquals(1L, actualFindTenantInfosResult.getTotalElements());
    assertFalse(actualFindTenantInfosResult.hasNext());
    assertTrue(actualFindTenantInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantInfos_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult = jpaTenantDao.findTenantInfos(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantInfosNextPage(eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindTenantInfosResult.getTotalElements());
    assertEquals(1, actualFindTenantInfosResult.getTotalPages());
    assertFalse(actualFindTenantInfosResult.hasNext());
    assertTrue(actualFindTenantInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantInfos_thenDataFirstAdditionalInfoReturnNullNode() throws IOException {
    // Arrange
    ArrayList<TenantInfoEntity> content = new ArrayList<>();
    content.add(new TenantInfoEntity());
    PageImpl<TenantInfoEntity> pageImpl = new PageImpl<>(content);
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult = jpaTenantDao.findTenantInfos(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantRepository).findTenantInfosNextPage(isNull(), isA(Pageable.class));
    List<TenantInfo> data = actualFindTenantInfosResult.getData();
    assertEquals(1, data.size());
    TenantInfo getResult = data.get(0);
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
    TenantId id = getResult.getId();
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
    assertEquals(EntityType.TENANT, id.getEntityType());
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
    assertFalse(id.isSysTenantId());
    assertTrue(additionalInfo.isEmpty());
    assertTrue(additionalInfo.isNull());
    assertTrue(additionalInfo.isValueNode());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(id, getResult.getTenantId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link TenantInfo#TenantInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantInfos_thenReturnDataFirstIsTenantInfo() {
    // Arrange
    TenantInfoEntity tenantInfoEntity = mock(TenantInfoEntity.class);
    TenantInfo tenantInfo = new TenantInfo();
    when(tenantInfoEntity.toData()).thenReturn(tenantInfo);

    ArrayList<TenantInfoEntity> content = new ArrayList<>();
    content.add(tenantInfoEntity);
    PageImpl<TenantInfoEntity> pageImpl = new PageImpl<>(content);
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult = jpaTenantDao.findTenantInfos(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantInfoEntity).toData();
    verify(tenantRepository).findTenantInfosNextPage(eq("Text Search"), isA(Pageable.class));
    List<TenantInfo> data = actualFindTenantInfosResult.getData();
    assertEquals(1, data.size());
    assertSame(tenantInfo, data.get(0));
  }

  /**
   * Test {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantInfos(TenantId, PageLink)}
   */
  @Test
  public void testFindTenantInfos_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantInfosNextPage(Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult = jpaTenantDao.findTenantInfos(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantRepository).findTenantInfosNextPage(isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindTenantInfosResult.getTotalElements());
    assertEquals(1, actualFindTenantInfosResult.getTotalPages());
    assertFalse(actualFindTenantInfosResult.hasNext());
    assertTrue(actualFindTenantInfosResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantsIds(PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantsIds(PageLink)}
   */
  @Test
  public void testFindTenantsIds_givenArrayListAddNull_uuid_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(tenantRepository.findTenantsIds(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = jpaTenantDao.findTenantsIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantRepository).findTenantsIds(isA(Pageable.class));
    List<TenantId> data = actualFindTenantsIdsResult.getData();
    assertEquals(2, data.size());
    TenantId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(2L, actualFindTenantsIdsResult.getTotalElements());
    assertTrue(getResult.isNullUid());
    assertTrue(getResult.isSysTenantId());
    assertSame(getResult, data.get(1));
  }

  /**
   * Test {@link JpaTenantDao#findTenantsIds(PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantsIds(PageLink)}
   */
  @Test
  public void testFindTenantsIds_givenArrayListAddNull_uuid_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(tenantRepository.findTenantsIds(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = jpaTenantDao.findTenantsIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantRepository).findTenantsIds(isA(Pageable.class));
    List<TenantId> data = actualFindTenantsIdsResult.getData();
    assertEquals(1, data.size());
    TenantId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindTenantsIdsResult.getTotalElements());
    assertTrue(getResult.isNullUid());
    assertTrue(getResult.isSysTenantId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantsIds(PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add randomUUID.</li>
   *   <li>Then return not Data first NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantsIds(PageLink)}
   */
  @Test
  public void testFindTenantsIds_givenArrayListAddRandomUUID_thenReturnNotDataFirstNullUid() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    UUID randomUUIDResult = UUID.randomUUID();
    content.add(randomUUIDResult);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(tenantRepository.findTenantsIds(Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = jpaTenantDao.findTenantsIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsIds(isA(Pageable.class));
    List<TenantId> data = actualFindTenantsIdsResult.getData();
    assertEquals(1, data.size());
    TenantId getResult = data.get(0);
    assertFalse(getResult.isNullUid());
    assertFalse(getResult.isSysTenantId());
    assertSame(randomUUIDResult, getResult.getId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantsIds(PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantsIds(PageLink)}
   */
  @Test
  public void testFindTenantsIds_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantsIds(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = jpaTenantDao.findTenantsIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(tenantRepository).findTenantsIds(isA(Pageable.class));
    assertEquals(0L, actualFindTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindTenantsIdsResult.getTotalPages());
    assertFalse(actualFindTenantsIdsResult.hasNext());
    assertTrue(actualFindTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantsIds(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaTenantDao#findTenantsIds(PageLink)}
   */
  @Test
  public void testFindTenantsIds_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(tenantRepository.findTenantsIds(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = jpaTenantDao.findTenantsIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantRepository).findTenantsIds(isA(Pageable.class));
    assertEquals(0L, actualFindTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindTenantsIdsResult.getTotalPages());
    assertFalse(actualFindTenantsIdsResult.hasNext());
    assertTrue(actualFindTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  public void testFindTenantIdsByTenantProfileId_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = jpaTenantDao
        .findTenantIdsByTenantProfileId(tenantProfileId);

    // Assert
    verify(tenantProfileId).getId();
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertTrue(actualFindTenantIdsByTenantProfileIdResult.isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  public void testFindTenantIdsByTenantProfileId_thenReturnEmpty() {
    // Arrange
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(new ArrayList<>());

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = jpaTenantDao
        .findTenantIdsByTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertTrue(actualFindTenantIdsByTenantProfileIdResult.isEmpty());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Then return not first NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  public void testFindTenantIdsByTenantProfileId_thenReturnNotFirstNullUid() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    UUID randomUUIDResult = UUID.randomUUID();
    uuidList.add(randomUUIDResult);
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(uuidList);
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = jpaTenantDao
        .findTenantIdsByTenantProfileId(tenantProfileId);

    // Assert
    verify(tenantProfileId).getId();
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertEquals(1, actualFindTenantIdsByTenantProfileIdResult.size());
    TenantId getResult = actualFindTenantIdsByTenantProfileIdResult.get(0);
    assertFalse(getResult.isNullUid());
    assertFalse(getResult.isSysTenantId());
    assertSame(randomUUIDResult, getResult.getId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  public void testFindTenantIdsByTenantProfileId_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(ModelConstants.NULL_UUID);
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(uuidList);

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = jpaTenantDao
        .findTenantIdsByTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertEquals(1, actualFindTenantIdsByTenantProfileIdResult.size());
    TenantId getResult = actualFindTenantIdsByTenantProfileIdResult.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertTrue(getResult.isNullUid());
    assertTrue(getResult.isSysTenantId());
  }

  /**
   * Test {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaTenantDao#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  public void testFindTenantIdsByTenantProfileId_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<UUID> uuidList = new ArrayList<>();
    uuidList.add(ModelConstants.NULL_UUID);
    uuidList.add(ModelConstants.NULL_UUID);
    when(tenantRepository.findTenantIdsByTenantProfileId(Mockito.<UUID>any())).thenReturn(uuidList);

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = jpaTenantDao
        .findTenantIdsByTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Assert
    verify(tenantRepository).findTenantIdsByTenantProfileId(isA(UUID.class));
    assertEquals(2, actualFindTenantIdsByTenantProfileIdResult.size());
    TenantId getResult = actualFindTenantIdsByTenantProfileIdResult.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertTrue(getResult.isNullUid());
    assertTrue(getResult.isSysTenantId());
    assertSame(getResult, actualFindTenantIdsByTenantProfileIdResult.get(1));
  }
}
