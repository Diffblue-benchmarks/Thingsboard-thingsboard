package org.thingsboard.server.dao.sql.customer;

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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import jakarta.persistence.EntityManagerFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.ShortCustomerInfo;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.CustomerEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaCustomerDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaCustomerDaoDiffblueTest {
  @MockBean
  private CustomerRepository customerRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaCustomerDao jpaCustomerDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaCustomerDao#getEntityClass()}
   *   <li>{@link JpaCustomerDao#getEntityType()}
   *   <li>{@link JpaCustomerDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaCustomerDao jpaCustomerDao = new JpaCustomerDao();

    // Act
    Class<CustomerEntity> actualEntityClass = jpaCustomerDao.getEntityClass();
    EntityType actualEntityType = jpaCustomerDao.getEntityType();

    // Assert
    assertNull(jpaCustomerDao.getRepository());
    assertEquals(EntityType.CUSTOMER, actualEntityType);
    Class<CustomerEntity> expectedEntityClass = CustomerEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindCustomersByTenantId() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    PageImpl<CustomerEntity> pageImpl = new PageImpl<>(content);
    when(customerRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult = jpaCustomerDao
        .findCustomersByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<Customer> data = actualFindCustomersByTenantIdResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("21654", getResult.getZip());
    assertEquals("42 Main St", getResult.getAddress());
    assertEquals("42 Main St", getResult.getAddress2());
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult = getResult.toShortCustomerInfo();
    assertEquals("Dr", toShortCustomerInfoResult.getTitle());
    assertEquals("GB", getResult.getCountry());
    assertEquals("MD", getResult.getState());
    assertEquals("Oxford", getResult.getCity());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    CustomerId expectedId = getResult.getExternalId();
    CustomerId id = getResult.getId();
    assertEquals(expectedId, id);
    assertSame(id, toShortCustomerInfoResult.getCustomerId());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindCustomersByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult = jpaCustomerDao
        .findCustomersByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(customerRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindCustomersByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindCustomersByTenantIdResult.getTotalPages());
    assertFalse(actualFindCustomersByTenantIdResult.hasNext());
    assertTrue(actualFindCustomersByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first Phone is {@code +44 1865 4960636}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindCustomersByTenantId_thenReturnDataFirstPhoneIs4418654960636() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("11 Station Rd");
    customerEntity.setAddress2("11 Station Rd");
    customerEntity.setCity("City");
    customerEntity.setCountry("US");
    customerEntity.setCreatedTime(-1L);
    customerEntity.setEmail("prof.einstein@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("+44 1865 4960636");
    customerEntity.setPublic(true);
    customerEntity.setState("org.thingsboard.server.dao.model.sql.CustomerEntity");
    UUID tenantId = UUID.randomUUID();
    customerEntity.setTenantId(tenantId);
    customerEntity.setTitle("Prof");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(-1L);
    customerEntity.setZip("127.0.0.1");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    PageImpl<CustomerEntity> pageImpl = new PageImpl<>(content);
    when(customerRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult = jpaCustomerDao
        .findCustomersByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(customerRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Customer> data = actualFindCustomersByTenantIdResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
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
    ShortCustomerInfo toShortCustomerInfoResult = getResult.toShortCustomerInfo();
    assertEquals("Prof", toShortCustomerInfoResult.getTitle());
    assertEquals("US", getResult.getCountry());
    assertEquals("org.thingsboard.server.dao.model.sql.CustomerEntity", getResult.getState());
    assertEquals("prof.einstein@example.org", getResult.getEmail());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    CustomerId expectedId = getResult.getExternalId();
    CustomerId id = getResult.getId();
    assertEquals(expectedId, id);
    assertSame(id, toShortCustomerInfoResult.getCustomerId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findCustomersByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindCustomersByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Customer> actualFindCustomersByTenantIdResult = jpaCustomerDao
        .findCustomersByTenantId(ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindCustomersByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindCustomersByTenantIdResult.getTotalPages());
    assertFalse(actualFindCustomersByTenantIdResult.hasNext());
    assertTrue(actualFindCustomersByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomerByTenantIdAndTitle(UUID, String)}.
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findCustomerByTenantIdAndTitle(UUID, String)}
   */
  @Test
  public void testFindCustomerByTenantIdAndTitle() throws IOException {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(customerEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Customer> actualFindCustomerByTenantIdAndTitleResult = jpaCustomerDao
        .findCustomerByTenantIdAndTitle(tenantId, "Dr");

    // Assert
    verify(customerRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    Customer getResult = actualFindCustomerByTenantIdAndTitleResult.get();
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
    assertEquals("21654", getResult.getZip());
    assertEquals("42 Main St", getResult.getAddress());
    assertEquals("42 Main St", getResult.getAddress2());
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult = getResult.toShortCustomerInfo();
    assertEquals("Dr", toShortCustomerInfoResult.getTitle());
    assertEquals("GB", getResult.getCountry());
    assertEquals("MD", getResult.getState());
    assertEquals("Oxford", getResult.getCity());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", getResult.getEmail());
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
    CustomerId externalId = getResult.getExternalId();
    assertEquals(EntityType.CUSTOMER, externalId.getEntityType());
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
    assertTrue(actualFindCustomerByTenantIdAndTitleResult.isPresent());
    assertTrue(toShortCustomerInfoResult.isPublic());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    CustomerId id = getResult.getId();
    assertEquals(externalId, id);
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(id, toShortCustomerInfoResult.getCustomerId());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomerByTenantIdAndTitle(UUID, String)}.
   * <ul>
   *   <li>Then return not {@link Optional#get()} TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findCustomerByTenantIdAndTitle(UUID, String)}
   */
  @Test
  public void testFindCustomerByTenantIdAndTitle_thenReturnNotGetTenantIdNullUid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    UUID tenantId = UUID.randomUUID();
    customerEntity.setTenantId(tenantId);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(customerEntity);

    // Act
    Optional<Customer> actualFindCustomerByTenantIdAndTitleResult = jpaCustomerDao
        .findCustomerByTenantIdAndTitle(ModelConstants.NULL_UUID, "Dr");

    // Assert
    verify(customerRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Dr"));
    TenantId tenantId2 = actualFindCustomerByTenantIdAndTitleResult.get().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaCustomerDao#findPublicCustomerByTenantId(UUID)}.
   * <p>
   * Method under test: {@link JpaCustomerDao#findPublicCustomerByTenantId(UUID)}
   */
  @Test
  public void testFindPublicCustomerByTenantId() throws IOException {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(customerEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Optional<Customer> actualFindPublicCustomerByTenantIdResult = jpaCustomerDao.findPublicCustomerByTenantId(tenantId);

    // Assert
    verify(customerRepository).findPublicCustomerByTenantId(isA(UUID.class));
    Customer getResult = actualFindPublicCustomerByTenantIdResult.get();
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
    assertEquals("21654", getResult.getZip());
    assertEquals("42 Main St", getResult.getAddress());
    assertEquals("42 Main St", getResult.getAddress2());
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult = getResult.toShortCustomerInfo();
    assertEquals("Dr", toShortCustomerInfoResult.getTitle());
    assertEquals("GB", getResult.getCountry());
    assertEquals("MD", getResult.getState());
    assertEquals("Oxford", getResult.getCity());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", getResult.getEmail());
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
    CustomerId externalId = getResult.getExternalId();
    assertEquals(EntityType.CUSTOMER, externalId.getEntityType());
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
    assertTrue(actualFindPublicCustomerByTenantIdResult.isPresent());
    assertTrue(toShortCustomerInfoResult.isPublic());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    CustomerId id = getResult.getId();
    assertEquals(externalId, id);
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(id, toShortCustomerInfoResult.getCustomerId());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaCustomerDao#findPublicCustomerByTenantId(UUID)}.
   * <ul>
   *   <li>Then return not {@link Optional#get()} TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaCustomerDao#findPublicCustomerByTenantId(UUID)}
   */
  @Test
  public void testFindPublicCustomerByTenantId_thenReturnNotGetTenantIdNullUid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    UUID tenantId = UUID.randomUUID();
    customerEntity.setTenantId(tenantId);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findPublicCustomerByTenantId(Mockito.<UUID>any())).thenReturn(customerEntity);

    // Act
    Optional<Customer> actualFindPublicCustomerByTenantIdResult = jpaCustomerDao
        .findPublicCustomerByTenantId(ModelConstants.NULL_UUID);

    // Assert
    verify(customerRepository).findPublicCustomerByTenantId(isA(UUID.class));
    TenantId tenantId2 = actualFindPublicCustomerByTenantIdResult.get().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaCustomerDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaCustomerDao#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(customerRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaCustomerDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(customerRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(customerEntity);
    UUID externalId = ModelConstants.NULL_UUID;

    // Act
    Customer actualFindByTenantIdAndExternalIdResult = jpaCustomerDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, externalId);

    // Assert
    verify(customerRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
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
    assertEquals("21654", actualFindByTenantIdAndExternalIdResult.getZip());
    assertEquals("42 Main St", actualFindByTenantIdAndExternalIdResult.getAddress());
    assertEquals("42 Main St", actualFindByTenantIdAndExternalIdResult.getAddress2());
    assertEquals("6625550144", actualFindByTenantIdAndExternalIdResult.getPhone());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndExternalIdResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult = actualFindByTenantIdAndExternalIdResult.toShortCustomerInfo();
    assertEquals("Dr", toShortCustomerInfoResult.getTitle());
    assertEquals("GB", actualFindByTenantIdAndExternalIdResult.getCountry());
    assertEquals("MD", actualFindByTenantIdAndExternalIdResult.getState());
    assertEquals("Oxford", actualFindByTenantIdAndExternalIdResult.getCity());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", actualFindByTenantIdAndExternalIdResult.getEmail());
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
    CustomerId externalId2 = actualFindByTenantIdAndExternalIdResult.getExternalId();
    assertEquals(EntityType.CUSTOMER, externalId2.getEntityType());
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
    assertTrue(toShortCustomerInfoResult.isPublic());
    assertTrue(externalId2.isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    CustomerId id = actualFindByTenantIdAndExternalIdResult.getId();
    assertEquals(externalId2, id);
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(id, toShortCustomerInfoResult.getCustomerId());
    assertSame(externalId, actualFindByTenantIdAndExternalIdResult.getUuidId());
    assertSame(externalId, externalId2.getId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantIdAndExternalId(UUID, UUID)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findByTenantIdAndExternalId(UUID, UUID)}
   */
  @Test
  public void testFindByTenantIdAndExternalId_thenReturnNotTenantIdNullUid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    UUID tenantId = UUID.randomUUID();
    customerEntity.setTenantId(tenantId);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndExternalId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(customerEntity);

    // Act
    Customer actualFindByTenantIdAndExternalIdResult = jpaCustomerDao
        .findByTenantIdAndExternalId(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(customerRepository).findByTenantIdAndExternalId(isA(UUID.class), isA(UUID.class));
    TenantId tenantId2 = actualFindByTenantIdAndExternalIdResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then AdditionalInfo iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaCustomerDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(customerEntity);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    Customer actualFindByTenantIdAndNameResult = jpaCustomerDao.findByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(customerRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Name"));
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
    assertEquals("21654", actualFindByTenantIdAndNameResult.getZip());
    assertEquals("42 Main St", actualFindByTenantIdAndNameResult.getAddress());
    assertEquals("42 Main St", actualFindByTenantIdAndNameResult.getAddress2());
    assertEquals("6625550144", actualFindByTenantIdAndNameResult.getPhone());
    assertEquals("Dr", actualFindByTenantIdAndNameResult.getName());
    assertEquals("Dr", actualFindByTenantIdAndNameResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult = actualFindByTenantIdAndNameResult.toShortCustomerInfo();
    assertEquals("Dr", toShortCustomerInfoResult.getTitle());
    assertEquals("GB", actualFindByTenantIdAndNameResult.getCountry());
    assertEquals("MD", actualFindByTenantIdAndNameResult.getState());
    assertEquals("Oxford", actualFindByTenantIdAndNameResult.getCity());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", actualFindByTenantIdAndNameResult.getEmail());
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
    CustomerId externalId = actualFindByTenantIdAndNameResult.getExternalId();
    assertEquals(EntityType.CUSTOMER, externalId.getEntityType());
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
    assertTrue(toShortCustomerInfoResult.isPublic());
    assertTrue(externalId.isNullUid());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    CustomerId id = actualFindByTenantIdAndNameResult.getId();
    assertEquals(externalId, id);
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(id, toShortCustomerInfoResult.getCustomerId());
    assertSame(tenantId, actualFindByTenantIdAndNameResult.getUuidId());
    assertSame(tenantId, externalId.getId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantIdAndName(UUID, String)}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaCustomerDao#findByTenantIdAndName(UUID, String)}
   */
  @Test
  public void testFindByTenantIdAndName_thenReturnNotTenantIdNullUid() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    UUID tenantId = UUID.randomUUID();
    customerEntity.setTenantId(tenantId);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");
    when(customerRepository.findByTenantIdAndTitle(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(customerEntity);

    // Act
    Customer actualFindByTenantIdAndNameResult = jpaCustomerDao.findByTenantIdAndName(ModelConstants.NULL_UUID, "Name");

    // Assert
    verify(customerRepository).findByTenantIdAndTitle(isA(UUID.class), eq("Name"));
    TenantId tenantId2 = actualFindByTenantIdAndNameResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}.
   * <p>
   * Method under test: {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    PageImpl<CustomerEntity> pageImpl = new PageImpl<>(content);
    when(customerRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);

    // Act
    PageData<Customer> actualFindByTenantIdResult = jpaCustomerDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<Customer> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("21654", getResult.getZip());
    assertEquals("42 Main St", getResult.getAddress());
    assertEquals("42 Main St", getResult.getAddress2());
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult = getResult.toShortCustomerInfo();
    assertEquals("Dr", toShortCustomerInfoResult.getTitle());
    assertEquals("GB", getResult.getCountry());
    assertEquals("MD", getResult.getState());
    assertEquals("Oxford", getResult.getCity());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    CustomerId expectedId = getResult.getExternalId();
    CustomerId id = getResult.getId();
    assertEquals(expectedId, id);
    assertSame(id, toShortCustomerInfoResult.getCustomerId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Customer> actualFindByTenantIdResult = jpaCustomerDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(customerRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then return Data first Phone is {@code +44 1865 4960636}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstPhoneIs4418654960636() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("11 Station Rd");
    customerEntity.setAddress2("11 Station Rd");
    customerEntity.setCity("City");
    customerEntity.setCountry("US");
    customerEntity.setCreatedTime(-1L);
    customerEntity.setEmail("prof.einstein@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("+44 1865 4960636");
    customerEntity.setPublic(true);
    customerEntity.setState("org.thingsboard.server.dao.model.sql.CustomerEntity");
    UUID tenantId = UUID.randomUUID();
    customerEntity.setTenantId(tenantId);
    customerEntity.setTitle("Prof");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(-1L);
    customerEntity.setZip("127.0.0.1");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    PageImpl<CustomerEntity> pageImpl = new PageImpl<>(content);
    when(customerRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Customer> actualFindByTenantIdResult = jpaCustomerDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(customerRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<Customer> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
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
    ShortCustomerInfo toShortCustomerInfoResult = getResult.toShortCustomerInfo();
    assertEquals("Prof", toShortCustomerInfoResult.getTitle());
    assertEquals("US", getResult.getCountry());
    assertEquals("org.thingsboard.server.dao.model.sql.CustomerEntity", getResult.getState());
    assertEquals("prof.einstein@example.org", getResult.getEmail());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    CustomerId expectedId = getResult.getExternalId();
    CustomerId id = getResult.getId();
    assertEquals(expectedId, id);
    assertSame(id, toShortCustomerInfoResult.getCustomerId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaCustomerDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Customer> actualFindByTenantIdResult = jpaCustomerDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaCustomerDao#getExternalIdByInternal(CustomerId)} with
   * {@code CustomerId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaCustomerDao#getExternalIdByInternal(CustomerId)}
   */
  @Test
  public void testGetExternalIdByInternalWithCustomerId_thenReturnNull() {
    // Arrange
    when(customerRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(null);

    // Act
    CustomerId actualExternalIdByInternal = jpaCustomerDao.getExternalIdByInternal(BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(customerRepository).getExternalIdById(isA(UUID.class));
    assertNull(actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaCustomerDao#getExternalIdByInternal(CustomerId)} with
   * {@code CustomerId}.
   * <ul>
   *   <li>Then return {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaCustomerDao#getExternalIdByInternal(CustomerId)}
   */
  @Test
  public void testGetExternalIdByInternalWithCustomerId_thenReturnNull_customer_id() {
    // Arrange
    when(customerRepository.getExternalIdById(Mockito.<UUID>any())).thenReturn(ModelConstants.NULL_UUID);
    CustomerId internalId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    CustomerId actualExternalIdByInternal = jpaCustomerDao.getExternalIdByInternal(internalId);

    // Assert
    verify(customerRepository).getExternalIdById(isA(UUID.class));
    assertEquals(internalId, actualExternalIdByInternal);
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}
   */
  @Test
  public void testFindCustomersWithTheSameTitle() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("42 Main St");
    customerEntity.setAddress2("42 Main St");
    customerEntity.setCity("Oxford");
    customerEntity.setCountry("GB");
    customerEntity.setCreatedTime(1L);
    customerEntity.setEmail("jane.doe@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("6625550144");
    customerEntity.setPublic(true);
    customerEntity.setState("MD");
    customerEntity.setTenantId(ModelConstants.NULL_UUID);
    customerEntity.setTitle("Dr");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(1L);
    customerEntity.setZip("21654");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    PageImpl<CustomerEntity> pageImpl = new PageImpl<>(content);
    when(customerRepository.findCustomersWithTheSameTitle(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<Customer> actualFindCustomersWithTheSameTitleResult = jpaCustomerDao
        .findCustomersWithTheSameTitle(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerRepository).findCustomersWithTheSameTitle(isA(Pageable.class));
    List<Customer> data = actualFindCustomersWithTheSameTitleResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
    JsonNode additionalInfo = getResult.getAdditionalInfo();
    Iterator<JsonNode> iteratorResult = additionalInfo.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(additionalInfo instanceof ObjectNode);
    assertTrue(nextResult.traverse() instanceof TreeTraversingParser);
    assertTrue(additionalInfo.traverse() instanceof TreeTraversingParser);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("21654", getResult.getZip());
    assertEquals("42 Main St", getResult.getAddress());
    assertEquals("42 Main St", getResult.getAddress2());
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Dr", getResult.getName());
    assertEquals("Dr", getResult.getTitle());
    ShortCustomerInfo toShortCustomerInfoResult = getResult.toShortCustomerInfo();
    assertEquals("Dr", toShortCustomerInfoResult.getTitle());
    assertEquals("GB", getResult.getCountry());
    assertEquals("MD", getResult.getState());
    assertEquals("Oxford", getResult.getCity());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals(1L, getResult.getVersion().longValue());
    assertEquals(1L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    CustomerId expectedId = getResult.getExternalId();
    CustomerId id = getResult.getId();
    assertEquals(expectedId, id);
    assertSame(id, toShortCustomerInfoResult.getCustomerId());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}
   */
  @Test
  public void testFindCustomersWithTheSameTitle_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findCustomersWithTheSameTitle(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Customer> actualFindCustomersWithTheSameTitleResult = jpaCustomerDao
        .findCustomersWithTheSameTitle(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(customerRepository).findCustomersWithTheSameTitle(isA(Pageable.class));
    assertEquals(0L, actualFindCustomersWithTheSameTitleResult.getTotalElements());
    assertEquals(1, actualFindCustomersWithTheSameTitleResult.getTotalPages());
    assertFalse(actualFindCustomersWithTheSameTitleResult.hasNext());
    assertTrue(actualFindCustomersWithTheSameTitleResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}.
   * <ul>
   *   <li>Then return Data first Phone is {@code +44 1865 4960636}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}
   */
  @Test
  public void testFindCustomersWithTheSameTitle_thenReturnDataFirstPhoneIs4418654960636() {
    // Arrange
    CustomerEntity customerEntity = new CustomerEntity();
    customerEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    customerEntity.setAddress("11 Station Rd");
    customerEntity.setAddress2("11 Station Rd");
    customerEntity.setCity("City");
    customerEntity.setCountry("US");
    customerEntity.setCreatedTime(-1L);
    customerEntity.setEmail("prof.einstein@example.org");
    customerEntity.setExternalId(ModelConstants.NULL_UUID);
    customerEntity.setId(ModelConstants.NULL_UUID);
    customerEntity.setPhone("+44 1865 4960636");
    customerEntity.setPublic(true);
    customerEntity.setState("org.thingsboard.server.dao.model.sql.CustomerEntity");
    UUID tenantId = UUID.randomUUID();
    customerEntity.setTenantId(tenantId);
    customerEntity.setTitle("Prof");
    customerEntity.setUuid(ModelConstants.NULL_UUID);
    customerEntity.setVersion(-1L);
    customerEntity.setZip("127.0.0.1");

    ArrayList<CustomerEntity> content = new ArrayList<>();
    content.add(customerEntity);
    PageImpl<CustomerEntity> pageImpl = new PageImpl<>(content);
    when(customerRepository.findCustomersWithTheSameTitle(Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<Customer> actualFindCustomersWithTheSameTitleResult = jpaCustomerDao
        .findCustomersWithTheSameTitle(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(customerRepository).findCustomersWithTheSameTitle(isA(Pageable.class));
    List<Customer> data = actualFindCustomersWithTheSameTitleResult.getData();
    assertEquals(1, data.size());
    Customer getResult = data.get(0);
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
    ShortCustomerInfo toShortCustomerInfoResult = getResult.toShortCustomerInfo();
    assertEquals("Prof", toShortCustomerInfoResult.getTitle());
    assertEquals("US", getResult.getCountry());
    assertEquals("org.thingsboard.server.dao.model.sql.CustomerEntity", getResult.getState());
    assertEquals("prof.einstein@example.org", getResult.getEmail());
    assertEquals(-1L, getResult.getVersion().longValue());
    assertEquals(0L, getResult.getCreatedTime());
    assertFalse(iteratorResult.hasNext());
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    CustomerId expectedId = getResult.getExternalId();
    CustomerId id = getResult.getId();
    assertEquals(expectedId, id);
    assertSame(id, toShortCustomerInfoResult.getCustomerId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaCustomerDao#findCustomersWithTheSameTitle(PageLink)}
   */
  @Test
  public void testFindCustomersWithTheSameTitle_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(customerRepository.findCustomersWithTheSameTitle(Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<Customer> actualFindCustomersWithTheSameTitleResult = jpaCustomerDao
        .findCustomersWithTheSameTitle(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(customerRepository).findCustomersWithTheSameTitle(isA(Pageable.class));
    assertEquals(0L, actualFindCustomersWithTheSameTitleResult.getTotalElements());
    assertEquals(1, actualFindCustomersWithTheSameTitleResult.getTotalPages());
    assertFalse(actualFindCustomersWithTheSameTitleResult.hasNext());
    assertTrue(actualFindCustomersWithTheSameTitleResult.getData().isEmpty());
  }
}
