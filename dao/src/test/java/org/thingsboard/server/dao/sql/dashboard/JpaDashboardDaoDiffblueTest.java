package org.thingsboard.server.dao.sql.dashboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.DashboardEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaDashboardDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaDashboardDaoDiffblueTest {
  @MockBean
  private DashboardRepository dashboardRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaDashboardDao jpaDashboardDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaDashboardDao#getEntityClass()}
   *   <li>{@link JpaDashboardDao#getEntityType()}
   *   <li>{@link JpaDashboardDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaDashboardDao jpaDashboardDao = new JpaDashboardDao();

    // Act
    Class<DashboardEntity> actualEntityClass = jpaDashboardDao.getEntityClass();
    EntityType actualEntityType = jpaDashboardDao.getEntityType();

    // Assert
    assertNull(jpaDashboardDao.getRepository());
    assertEquals(EntityType.DASHBOARD, actualEntityType);
    Class<DashboardEntity> expectedEntityClass = DashboardEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaDashboardDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardDao#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(dashboardRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaDashboardDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(dashboardRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then Configuration iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenConfigurationIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    when(dashboardRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(dashboardEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Dashboard actualFindByTenantIdAndExternalIdResult = jpaDashboardDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(dashboardRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    JsonNode configuration = actualFindByTenantIdAndExternalIdResult.getConfiguration();
    Iterator<JsonNode> iteratorResult = configuration.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configuration instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configuration.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getTitle());
    assertEquals("Image", actualFindByTenantIdAndExternalIdResult.getImage());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", configuration.toPrettyString());
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
    assertNull(actualFindByTenantIdAndExternalIdResult.getAssignedCustomers());
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
    assertEquals(1, configuration.size());
    assertEquals(1, actualFindByTenantIdAndExternalIdResult.getMobileOrder().intValue());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getVersion().longValue());
    assertEquals(1L, actualFindByTenantIdAndExternalIdResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configuration.getNodeType());
    DashboardId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.DASHBOARD, externalId2.getEntityType());
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
    assertFalse(configuration.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configuration.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configuration.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configuration.isBinary());
    assertFalse(configuration.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configuration.isDouble());
    assertFalse(configuration.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configuration.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configuration.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configuration.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configuration.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configuration.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configuration.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(configuration.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configuration.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configuration.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configuration.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configuration.isTextual());
    assertFalse(configuration.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(configuration.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(configuration.isObject());
    assertTrue(nextResult.isValueNode());
    List<ObjectNode> entityAliasesConfig = actualFindByTenantIdAndExternalIdResult.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(actualFindByTenantIdAndExternalIdResult.isMobileHide());
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
    assertSame(entityAliasesConfig, actualFindByTenantIdAndExternalIdResult.getWidgetsConfig());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnNotTenantIdNullUid() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    UUID tenantId = UUID.randomUUID();
    dashboardEntity.setTenantId(tenantId);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);
    when(dashboardRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(dashboardEntity);

    // Act
    Dashboard actualFindByTenantIdAndExternalIdResult = jpaDashboardDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(dashboardRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId2 = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test: {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    ArrayList<DashboardEntity> content = new ArrayList<>();
    content.add(dashboardEntity);
    PageImpl<DashboardEntity> pageImpl = new PageImpl<>(content);
    when(dashboardRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<Dashboard> actualFindByTenantIdResult = jpaDashboardDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<Dashboard> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Dashboard getResult = data.get(0);
    JsonNode configuration = getResult.getConfiguration();
    Iterator<JsonNode> iteratorResult = configuration.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configuration instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(configuration.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    DashboardId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Dashboard> actualFindByTenantIdResult = jpaDashboardDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first Image is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstImageIs42() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("42");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(-1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("42");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(-1);
    UUID tenantId = UUID.randomUUID();
    dashboardEntity.setTenantId(tenantId);
    dashboardEntity.setTitle("Prof");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(-1L);

    ArrayList<DashboardEntity> content = new ArrayList<>();
    content.add(dashboardEntity);
    PageImpl<DashboardEntity> pageImpl = new PageImpl<>(content);
    when(dashboardRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Dashboard> actualFindByTenantIdResult = jpaDashboardDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    List<Dashboard> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Dashboard getResult = data.get(0);
    JsonNode configuration = getResult.getConfiguration();
    Iterator<JsonNode> iteratorResult = configuration.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configuration instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(configuration.traverse() instanceof TreeTraversingParser);
    assertEquals("42", getResult.getImage());
    assertEquals("Prof", getResult.getName());
    assertEquals("Prof", getResult.getTitle());
    assertEquals(-1, getResult.getMobileOrder().intValue());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    DashboardId expectedId = getResult.getExternalId();
    assertEquals(expectedId, getResult.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Dashboard> actualFindByTenantIdResult = jpaDashboardDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)} with
   * {@code DashboardId}.
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)}
   */
  @Test
  public void testGetExternalIdByInternalWithDashboardId() {
    // Arrange
    when(dashboardRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    DashboardId internalId = new DashboardId(ModelConstants.NULL_UUID);

    // Act
    DashboardId actualExternalIdByInternal = jpaDashboardDao.getExternalIdByInternal(internalId);

    // Assert
    verify(dashboardRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)} with
   * {@code DashboardId}.
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)}
   */
  @Test
  public void testGetExternalIdByInternalWithDashboardId2() {
    // Arrange
    when(dashboardRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    DashboardId internalId = mock(DashboardId.class);
    when(internalId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    DashboardId actualExternalIdByInternal = jpaDashboardDao.getExternalIdByInternal(internalId);

    // Assert
    verify(internalId).getId();
    verify(dashboardRepository).getExternalIdById(isA(UUID.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalIdByInternal.getId().toString());
    assertEquals(EntityType.DASHBOARD, actualExternalIdByInternal.getEntityType());
    assertTrue(actualExternalIdByInternal.isNullUid());
  }

  /**
   * Test {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)} with
   * {@code DashboardId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#getExternalIdByInternal(DashboardId)}
   */
  @Test
  public void testGetExternalIdByInternalWithDashboardId_thenReturnNull() {
    // Arrange
    when(dashboardRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    DashboardId actualExternalIdByInternal = jpaDashboardDao
        .getExternalIdByInternal(new DashboardId(ModelConstants.NULL_UUID));

    // Assert
    verify(dashboardRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}.
   * <ul>
   *   <li>Then first Configuration iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndTitle_thenFirstConfigurationIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    dashboardEntity.setTenantId(ModelConstants.NULL_UUID);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    ArrayList<DashboardEntity> dashboardEntityList = new ArrayList<>();
    dashboardEntityList.add(dashboardEntity);
    when(dashboardRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardEntityList);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    List<Dashboard> actualFindByTenantIdAndTitleResult = jpaDashboardDao.findByTenantIdAndTitle(tenantId, "Dr");

    // Assert
    verify(dashboardRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    assertEquals(1, actualFindByTenantIdAndTitleResult.size());
    Dashboard getResult = actualFindByTenantIdAndTitleResult.get(0);
    JsonNode configuration = getResult.getConfiguration();
    Iterator<JsonNode> iteratorResult = configuration.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(configuration instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configuration.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    assertEquals("Image", getResult.getImage());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", configuration.toPrettyString());
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
    assertNull(getResult.getAssignedCustomers());
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
    assertEquals(1, configuration.size());
    assertEquals(1, getResult.getMobileOrder().intValue());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configuration.getNodeType());
    DashboardId externalId = getResult.getExternalId();
    assertEquals(EntityType.DASHBOARD, externalId.getEntityType());
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
    assertFalse(configuration.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configuration.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configuration.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configuration.isBinary());
    assertFalse(configuration.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configuration.isDouble());
    assertFalse(configuration.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configuration.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configuration.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configuration.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configuration.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configuration.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configuration.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(configuration.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configuration.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configuration.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configuration.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configuration.isTextual());
    assertFalse(configuration.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(configuration.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(configuration.isObject());
    assertTrue(nextResult.isValueNode());
    List<ObjectNode> entityAliasesConfig = getResult.getEntityAliasesConfig();
    assertTrue(entityAliasesConfig.isEmpty());
    assertTrue(getResult.isMobileHide());
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
    assertSame(entityAliasesConfig, getResult.getWidgetsConfig());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndTitle_thenReturnEmpty() {
    // Arrange
    when(dashboardRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<Dashboard> actualFindByTenantIdAndTitleResult = jpaDashboardDao
        .findByTenantIdAndTitle(ModelConstants.NULL_UUID, "Dr");

    // Assert
    verify(dashboardRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    assertTrue(actualFindByTenantIdAndTitleResult.isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}.
   * <ul>
   *   <li>Then return not first TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#findByTenantIdAndTitle(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndTitle_thenReturnNotFirstTenantIdNullUid() {
    // Arrange
    DashboardEntity dashboardEntity = new DashboardEntity();
    dashboardEntity.setAssignedCustomers("Assigned Customers");
    dashboardEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    dashboardEntity.setCreatedTime(1L);
    dashboardEntity.setExternalId(ModelConstants.NULL_UUID);
    dashboardEntity.setId(ModelConstants.NULL_UUID);
    dashboardEntity.setImage("Image");
    dashboardEntity.setMobileHide(true);
    dashboardEntity.setMobileOrder(1);
    UUID tenantId = UUID.randomUUID();
    dashboardEntity.setTenantId(tenantId);
    dashboardEntity.setTitle("Dr");
    dashboardEntity.setUuid(ModelConstants.NULL_UUID);
    dashboardEntity.setVersion(1L);

    ArrayList<DashboardEntity> dashboardEntityList = new ArrayList<>();
    dashboardEntityList.add(dashboardEntity);
    when(dashboardRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(dashboardEntityList);

    // Act
    List<Dashboard> actualFindByTenantIdAndTitleResult = jpaDashboardDao
        .findByTenantIdAndTitle(ModelConstants.NULL_UUID, "Dr");

    // Assert
    verify(dashboardRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    assertEquals(1, actualFindByTenantIdAndTitleResult.size());
    TenantId tenantId2 = actualFindByTenantIdAndTitleResult.get(0).getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)} with
   * {@code TenantId}, {@code PageLink}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindIdsByTenantIdWithTenantIdPageLink_givenOne_thenCallsGetPage() {
    // Arrange
    when(dashboardRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardId> actualFindIdsByTenantIdResult = jpaDashboardDao
        .findIdsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)} with
   * {@code TenantId}, {@code PageLink}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindIdsByTenantIdWithTenantIdPageLink_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(dashboardRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<DashboardId> actualFindIdsByTenantIdResult = jpaDashboardDao
        .findIdsByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    List<DashboardId> data = actualFindIdsByTenantIdResult.getData();
    assertEquals(1, data.size());
    DashboardId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(EntityType.DASHBOARD, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)} with
   * {@code TenantId}, {@code PageLink}.
   * <ul>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindIdsByTenantIdWithTenantIdPageLink_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(dashboardRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<DashboardId> actualFindIdsByTenantIdResult = jpaDashboardDao
        .findIdsByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    List<DashboardId> data = actualFindIdsByTenantIdResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(data.get(0), data.get(1));
  }

  /**
   * Test {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)} with
   * {@code TenantId}, {@code PageLink}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDashboardDao#findIdsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindIdsByTenantIdWithTenantIdPageLink_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardRepository.findIdsByTenantId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardId> actualFindIdsByTenantIdResult = jpaDashboardDao
        .findIdsByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findIdsByTenantId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindIdsByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindIdsByTenantIdResult.getTotalPages());
    assertFalse(actualFindIdsByTenantIdResult.hasNext());
    assertTrue(actualFindIdsByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findAllIds(PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardDao#findAllIds(PageLink)}
   */
  @Test
  public void testFindAllIds_givenArrayListAddNull_uuid_whenFirst_page_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(dashboardRepository.findAllIds(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<DashboardId> actualFindAllIdsResult = jpaDashboardDao.findAllIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findAllIds(isA(Pageable.class));
    List<DashboardId> data = actualFindAllIdsResult.getData();
    assertEquals(1, data.size());
    DashboardId getResult = data.get(0);
    assertEquals("13814000-1dd2-11b2-8080-808080808080", getResult.getId().toString());
    assertEquals(1L, actualFindAllIdsResult.getTotalElements());
    assertEquals(EntityType.DASHBOARD, getResult.getEntityType());
    assertTrue(getResult.isNullUid());
  }

  /**
   * Test {@link JpaDashboardDao#findAllIds(PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardDao#findAllIds(PageLink)}
   */
  @Test
  public void testFindAllIds_givenArrayListAddNull_uuid_whenFirst_page_thenReturnDataSizeIsTwo() {
    // Arrange
    ArrayList<UUID> content = new ArrayList<>();
    content.add(ModelConstants.NULL_UUID);
    content.add(ModelConstants.NULL_UUID);
    PageImpl<UUID> pageImpl = new PageImpl<>(content);
    when(dashboardRepository.findAllIds(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<DashboardId> actualFindAllIdsResult = jpaDashboardDao.findAllIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findAllIds(isA(Pageable.class));
    List<DashboardId> data = actualFindAllIdsResult.getData();
    assertEquals(2, data.size());
    assertEquals(2L, actualFindAllIdsResult.getTotalElements());
    assertEquals(data.get(0), data.get(1));
  }

  /**
   * Test {@link JpaDashboardDao#findAllIds(PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardDao#findAllIds(PageLink)}
   */
  @Test
  public void testFindAllIds_givenOne_whenPageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(dashboardRepository.findAllIds(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<DashboardId> actualFindAllIdsResult = jpaDashboardDao.findAllIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(dashboardRepository).findAllIds(isA(Pageable.class));
    assertEquals(0L, actualFindAllIdsResult.getTotalElements());
    assertEquals(1, actualFindAllIdsResult.getTotalPages());
    assertFalse(actualFindAllIdsResult.hasNext());
    assertTrue(actualFindAllIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaDashboardDao#findAllIds(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDashboardDao#findAllIds(PageLink)}
   */
  @Test
  public void testFindAllIds_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(dashboardRepository.findAllIds(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<DashboardId> actualFindAllIdsResult = jpaDashboardDao.findAllIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(dashboardRepository).findAllIds(isA(Pageable.class));
    assertEquals(0L, actualFindAllIdsResult.getTotalElements());
    assertEquals(1, actualFindAllIdsResult.getTotalPages());
    assertFalse(actualFindAllIdsResult.hasNext());
    assertTrue(actualFindAllIdsResult.getData().isEmpty());
  }
}
