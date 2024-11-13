package org.thingsboard.server.dao.sql.user;

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
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.security.Authority;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.UserEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaUserDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaUserDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaUserDao jpaUserDao;

  @MockBean
  private TransactionTemplate transactionTemplate;

  @MockBean
  private UserRepository userRepository;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaUserDao#getEntityClass()}
   *   <li>{@link JpaUserDao#getEntityType()}
   *   <li>{@link JpaUserDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaUserDao jpaUserDao = new JpaUserDao();

    // Act
    Class<UserEntity> actualEntityClass = jpaUserDao.getEntityClass();
    EntityType actualEntityType = jpaUserDao.getEntityType();

    // Assert
    assertNull(jpaUserDao.getRepository());
    assertEquals(EntityType.USER, actualEntityType);
    Class<UserEntity> expectedEntityClass = UserEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaUserDao#findByEmail(TenantId, String)}.
   * <ul>
   *   <li>Given {@link UserEntity} {@link UserEntity#toData()} return
   * {@link User#User()}.</li>
   *   <li>Then return {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findByEmail(TenantId, String)}
   */
  @Test
  public void testFindByEmail_givenUserEntityToDataReturnUser_thenReturnUser() {
    // Arrange
    UserEntity userEntity = mock(UserEntity.class);
    User user = new User();
    when(userEntity.toData()).thenReturn(user);
    doNothing().when(userEntity).setCreatedTime(anyLong());
    doNothing().when(userEntity).setId(Mockito.<UUID>any());
    doNothing().when(userEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userEntity).setVersion(Mockito.<Long>any());
    doNothing().when(userEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(userEntity).setAuthority(Mockito.<Authority>any());
    doNothing().when(userEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(userEntity).setEmail(Mockito.<String>any());
    doNothing().when(userEntity).setFirstName(Mockito.<String>any());
    doNothing().when(userEntity).setLastName(Mockito.<String>any());
    doNothing().when(userEntity).setPhone(Mockito.<String>any());
    doNothing().when(userEntity).setTenantId(Mockito.<UUID>any());
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);
    when(userRepository.findByEmail(Mockito.<String>any())).thenReturn(userEntity);

    // Act
    User actualFindByEmailResult = jpaUserDao.findByEmail(ModelConstants.SYSTEM_TENANT, "jane.doe@example.org");

    // Assert
    verify(userEntity).setCreatedTime(eq(1L));
    verify(userEntity).setId(isA(UUID.class));
    verify(userEntity).setUuid(isA(UUID.class));
    verify(userEntity).setVersion(eq(1L));
    verify(userEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(userEntity).setAuthority(eq(Authority.SYS_ADMIN));
    verify(userEntity).setCustomerId(isA(UUID.class));
    verify(userEntity).setEmail(eq("jane.doe@example.org"));
    verify(userEntity).setFirstName(eq("Jane"));
    verify(userEntity).setLastName(eq("Doe"));
    verify(userEntity).setPhone(eq("6625550144"));
    verify(userEntity).setTenantId(isA(UUID.class));
    verify(userEntity).toData();
    verify(userRepository).findByEmail(eq("jane.doe@example.org"));
    assertSame(user, actualFindByEmailResult);
  }

  /**
   * Test {@link JpaUserDao#findByTenantIdAndEmail(TenantId, String)}.
   * <ul>
   *   <li>Given {@link UserEntity} {@link UserEntity#toData()} return
   * {@link User#User()}.</li>
   *   <li>Then return {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByTenantIdAndEmail(TenantId, String)}
   */
  @Test
  public void testFindByTenantIdAndEmail_givenUserEntityToDataReturnUser_thenReturnUser() {
    // Arrange
    UserEntity userEntity = mock(UserEntity.class);
    User user = new User();
    when(userEntity.toData()).thenReturn(user);
    doNothing().when(userEntity).setCreatedTime(anyLong());
    doNothing().when(userEntity).setId(Mockito.<UUID>any());
    doNothing().when(userEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userEntity).setVersion(Mockito.<Long>any());
    doNothing().when(userEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(userEntity).setAuthority(Mockito.<Authority>any());
    doNothing().when(userEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(userEntity).setEmail(Mockito.<String>any());
    doNothing().when(userEntity).setFirstName(Mockito.<String>any());
    doNothing().when(userEntity).setLastName(Mockito.<String>any());
    doNothing().when(userEntity).setPhone(Mockito.<String>any());
    doNothing().when(userEntity).setTenantId(Mockito.<UUID>any());
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);
    when(userRepository.findByTenantIdAndEmail(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(userEntity);

    // Act
    User actualFindByTenantIdAndEmailResult = jpaUserDao.findByTenantIdAndEmail(ModelConstants.SYSTEM_TENANT,
        "jane.doe@example.org");

    // Assert
    verify(userEntity).setCreatedTime(eq(1L));
    verify(userEntity).setId(isA(UUID.class));
    verify(userEntity).setUuid(isA(UUID.class));
    verify(userEntity).setVersion(eq(1L));
    verify(userEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(userEntity).setAuthority(eq(Authority.SYS_ADMIN));
    verify(userEntity).setCustomerId(isA(UUID.class));
    verify(userEntity).setEmail(eq("jane.doe@example.org"));
    verify(userEntity).setFirstName(eq("Jane"));
    verify(userEntity).setLastName(eq("Doe"));
    verify(userEntity).setPhone(eq("6625550144"));
    verify(userEntity).setTenantId(isA(UUID.class));
    verify(userEntity).toData();
    verify(userRepository).findByTenantIdAndEmail(isA(UUID.class), eq("jane.doe@example.org"));
    assertSame(user, actualFindByTenantIdAndEmailResult);
  }

  /**
   * Test {@link JpaUserDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindByTenantIdResult = jpaUserDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Given {@link UserEntity} {@link UserEntity#toData()} return
   * {@link User#User()}.</li>
   *   <li>Then return Data first is {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenUserEntityToDataReturnUser_thenReturnDataFirstIsUser() {
    // Arrange
    UserEntity userEntity = mock(UserEntity.class);
    User user = new User();
    when(userEntity.toData()).thenReturn(user);
    doNothing().when(userEntity).setCreatedTime(anyLong());
    doNothing().when(userEntity).setId(Mockito.<UUID>any());
    doNothing().when(userEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userEntity).setVersion(Mockito.<Long>any());
    doNothing().when(userEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(userEntity).setAuthority(Mockito.<Authority>any());
    doNothing().when(userEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(userEntity).setEmail(Mockito.<String>any());
    doNothing().when(userEntity).setFirstName(Mockito.<String>any());
    doNothing().when(userEntity).setLastName(Mockito.<String>any());
    doNothing().when(userEntity).setPhone(Mockito.<String>any());
    doNothing().when(userEntity).setTenantId(Mockito.<UUID>any());
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.CUSTOMER_USER);
    userEntity.setCreatedTime(-1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("prof.einstein@example.org");
    userEntity.setFirstName("Albert");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Einstein");
    userEntity.setPhone("+44 1865 4960636");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(-1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindByTenantIdResult = jpaUserDao.findByTenantId(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userEntity).setCreatedTime(eq(-1L));
    verify(userEntity).setId(isA(UUID.class));
    verify(userEntity).setUuid(isA(UUID.class));
    verify(userEntity).setVersion(eq(-1L));
    verify(userEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(userEntity).setAuthority(eq(Authority.CUSTOMER_USER));
    verify(userEntity).setCustomerId(isA(UUID.class));
    verify(userEntity).setEmail(eq("prof.einstein@example.org"));
    verify(userEntity).setFirstName(eq("Albert"));
    verify(userEntity).setLastName(eq("Einstein"));
    verify(userEntity).setPhone(eq("+44 1865 4960636"));
    verify(userEntity).setTenantId(isA(UUID.class));
    verify(userEntity).toData();
    verify(userRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<User> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(user, data.get(0));
  }

  /**
   * Test {@link JpaUserDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenDataFirstAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<User> actualFindByTenantIdResult = jpaUserDao.findByTenantId(tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<User> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
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
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Doe", getResult.getLastName());
    assertEquals("Jane Doe", getResult.getTitle());
    assertEquals("Jane", getResult.getFirstName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals("jane.doe@example.org", getResult.getName());
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
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    UserId id = getResult.getId();
    assertEquals(EntityType.USER, id.getEntityType());
    assertEquals(Authority.SYS_ADMIN, getResult.getAuthority());
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
  }

  /**
   * Test {@link JpaUserDao#findByTenantId(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findByTenantId(UUID, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindByTenantIdResult = jpaUserDao.findByTenantId(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}
   */
  @Test
  public void testFindTenantAdmins_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findUsersByAuthority(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Authority>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindTenantAdminsResult = jpaUserDao.findTenantAdmins(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userRepository).findUsersByAuthority(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        eq(Authority.TENANT_ADMIN), isA(Pageable.class));
    assertEquals(0L, actualFindTenantAdminsResult.getTotalElements());
    assertEquals(1, actualFindTenantAdminsResult.getTotalPages());
    assertFalse(actualFindTenantAdminsResult.hasNext());
    assertTrue(actualFindTenantAdminsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}.
   * <ul>
   *   <li>Given {@link UserEntity} {@link UserEntity#toData()} return
   * {@link User#User()}.</li>
   *   <li>Then return Data first is {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}
   */
  @Test
  public void testFindTenantAdmins_givenUserEntityToDataReturnUser_thenReturnDataFirstIsUser() {
    // Arrange
    UserEntity userEntity = mock(UserEntity.class);
    User user = new User();
    when(userEntity.toData()).thenReturn(user);
    doNothing().when(userEntity).setCreatedTime(anyLong());
    doNothing().when(userEntity).setId(Mockito.<UUID>any());
    doNothing().when(userEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userEntity).setVersion(Mockito.<Long>any());
    doNothing().when(userEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(userEntity).setAuthority(Mockito.<Authority>any());
    doNothing().when(userEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(userEntity).setEmail(Mockito.<String>any());
    doNothing().when(userEntity).setFirstName(Mockito.<String>any());
    doNothing().when(userEntity).setLastName(Mockito.<String>any());
    doNothing().when(userEntity).setPhone(Mockito.<String>any());
    doNothing().when(userEntity).setTenantId(Mockito.<UUID>any());
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.CUSTOMER_USER);
    userEntity.setCreatedTime(-1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("prof.einstein@example.org");
    userEntity.setFirstName("Albert");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Einstein");
    userEntity.setPhone("+44 1865 4960636");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(-1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findUsersByAuthority(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Authority>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindTenantAdminsResult = jpaUserDao.findTenantAdmins(ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userEntity).setCreatedTime(eq(-1L));
    verify(userEntity).setId(isA(UUID.class));
    verify(userEntity).setUuid(isA(UUID.class));
    verify(userEntity).setVersion(eq(-1L));
    verify(userEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(userEntity).setAuthority(eq(Authority.CUSTOMER_USER));
    verify(userEntity).setCustomerId(isA(UUID.class));
    verify(userEntity).setEmail(eq("prof.einstein@example.org"));
    verify(userEntity).setFirstName(eq("Albert"));
    verify(userEntity).setLastName(eq("Einstein"));
    verify(userEntity).setPhone(eq("+44 1865 4960636"));
    verify(userEntity).setTenantId(isA(UUID.class));
    verify(userEntity).toData();
    verify(userRepository).findUsersByAuthority(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        eq(Authority.TENANT_ADMIN), isA(Pageable.class));
    List<User> data = actualFindTenantAdminsResult.getData();
    assertEquals(1, data.size());
    assertSame(user, data.get(0));
  }

  /**
   * Test {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}
   */
  @Test
  public void testFindTenantAdmins_thenDataFirstAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findUsersByAuthority(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Authority>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<User> actualFindTenantAdminsResult = jpaUserDao.findTenantAdmins(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findUsersByAuthority(isA(UUID.class), isA(UUID.class), isNull(), eq(Authority.TENANT_ADMIN),
        isA(Pageable.class));
    List<User> data = actualFindTenantAdminsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
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
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Doe", getResult.getLastName());
    assertEquals("Jane Doe", getResult.getTitle());
    assertEquals("Jane", getResult.getFirstName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals("jane.doe@example.org", getResult.getName());
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
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    UserId id = getResult.getId();
    assertEquals(EntityType.USER, id.getEntityType());
    assertEquals(Authority.SYS_ADMIN, getResult.getAuthority());
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
  }

  /**
   * Test {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findTenantAdmins(UUID, PageLink)}
   */
  @Test
  public void testFindTenantAdmins_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findUsersByAuthority(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Authority>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindTenantAdminsResult = jpaUserDao.findTenantAdmins(ModelConstants.NULL_UUID,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findUsersByAuthority(isA(UUID.class), isA(UUID.class), isNull(), eq(Authority.TENANT_ADMIN),
        isA(Pageable.class));
    assertEquals(0L, actualFindTenantAdminsResult.getTotalElements());
    assertEquals(1, actualFindTenantAdminsResult.getTotalPages());
    assertFalse(actualFindTenantAdminsResult.hasNext());
    assertTrue(actualFindTenantAdminsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindCustomerUsers_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findUsersByAuthority(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Authority>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindCustomerUsersResult = jpaUserDao.findCustomerUsers(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userRepository).findUsersByAuthority(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        eq(Authority.CUSTOMER_USER), isA(Pageable.class));
    assertEquals(0L, actualFindCustomerUsersResult.getTotalElements());
    assertEquals(1, actualFindCustomerUsersResult.getTotalPages());
    assertFalse(actualFindCustomerUsersResult.hasNext());
    assertTrue(actualFindCustomerUsersResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Given {@link UserEntity} {@link UserEntity#toData()} return
   * {@link User#User()}.</li>
   *   <li>Then return Data first is {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindCustomerUsers_givenUserEntityToDataReturnUser_thenReturnDataFirstIsUser() {
    // Arrange
    UserEntity userEntity = mock(UserEntity.class);
    User user = new User();
    when(userEntity.toData()).thenReturn(user);
    doNothing().when(userEntity).setCreatedTime(anyLong());
    doNothing().when(userEntity).setId(Mockito.<UUID>any());
    doNothing().when(userEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userEntity).setVersion(Mockito.<Long>any());
    doNothing().when(userEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(userEntity).setAuthority(Mockito.<Authority>any());
    doNothing().when(userEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(userEntity).setEmail(Mockito.<String>any());
    doNothing().when(userEntity).setFirstName(Mockito.<String>any());
    doNothing().when(userEntity).setLastName(Mockito.<String>any());
    doNothing().when(userEntity).setPhone(Mockito.<String>any());
    doNothing().when(userEntity).setTenantId(Mockito.<UUID>any());
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.CUSTOMER_USER);
    userEntity.setCreatedTime(-1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("prof.einstein@example.org");
    userEntity.setFirstName("Albert");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Einstein");
    userEntity.setPhone("+44 1865 4960636");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(-1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findUsersByAuthority(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Authority>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindCustomerUsersResult = jpaUserDao.findCustomerUsers(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userEntity).setCreatedTime(eq(-1L));
    verify(userEntity).setId(isA(UUID.class));
    verify(userEntity).setUuid(isA(UUID.class));
    verify(userEntity).setVersion(eq(-1L));
    verify(userEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(userEntity).setAuthority(eq(Authority.CUSTOMER_USER));
    verify(userEntity).setCustomerId(isA(UUID.class));
    verify(userEntity).setEmail(eq("prof.einstein@example.org"));
    verify(userEntity).setFirstName(eq("Albert"));
    verify(userEntity).setLastName(eq("Einstein"));
    verify(userEntity).setPhone(eq("+44 1865 4960636"));
    verify(userEntity).setTenantId(isA(UUID.class));
    verify(userEntity).toData();
    verify(userRepository).findUsersByAuthority(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        eq(Authority.CUSTOMER_USER), isA(Pageable.class));
    List<User> data = actualFindCustomerUsersResult.getData();
    assertEquals(1, data.size());
    assertSame(user, data.get(0));
  }

  /**
   * Test {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindCustomerUsers_thenDataFirstAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findUsersByAuthority(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Authority>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID customerId = ModelConstants.NULL_UUID;

    // Act
    PageData<User> actualFindCustomerUsersResult = jpaUserDao.findCustomerUsers(ModelConstants.NULL_UUID, customerId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findUsersByAuthority(isA(UUID.class), isA(UUID.class), isNull(), eq(Authority.CUSTOMER_USER),
        isA(Pageable.class));
    List<User> data = actualFindCustomerUsersResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
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
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Doe", getResult.getLastName());
    assertEquals("Jane Doe", getResult.getTitle());
    assertEquals("Jane", getResult.getFirstName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals("jane.doe@example.org", getResult.getName());
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
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    UserId id = getResult.getId();
    assertEquals(EntityType.USER, id.getEntityType());
    assertEquals(Authority.SYS_ADMIN, getResult.getAuthority());
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
  }

  /**
   * Test {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findCustomerUsers(UUID, UUID, PageLink)}
   */
  @Test
  public void testFindCustomerUsers_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findUsersByAuthority(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<Authority>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindCustomerUsersResult = jpaUserDao.findCustomerUsers(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findUsersByAuthority(isA(UUID.class), isA(UUID.class), isNull(), eq(Authority.CUSTOMER_USER),
        isA(Pageable.class));
    assertEquals(0L, actualFindCustomerUsersResult.getTotalElements());
    assertEquals(1, actualFindCustomerUsersResult.getTotalPages());
    assertFalse(actualFindCustomerUsersResult.hasNext());
    assertTrue(actualFindCustomerUsersResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds() throws IOException {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findTenantAndCustomerUsers(Mockito.<UUID>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = jpaUserDao.findUsersByCustomerIds(tenantId, new ArrayList<>(),
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findTenantAndCustomerUsers(isA(UUID.class), isA(Collection.class), isNull(),
        isA(Pageable.class));
    List<User> data = actualFindUsersByCustomerIdsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
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
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Doe", getResult.getLastName());
    assertEquals("Jane Doe", getResult.getTitle());
    assertEquals("Jane", getResult.getFirstName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals("jane.doe@example.org", getResult.getName());
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
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    UserId id = getResult.getId();
    assertEquals(EntityType.USER, id.getEntityType());
    assertEquals(Authority.SYS_ADMIN, getResult.getAuthority());
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
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds_givenNull_customer_id() {
    // Arrange
    when(userRepository.findTenantAndCustomerUsers(Mockito.<UUID>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<CustomerId> customerIds = new ArrayList<>();
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = jpaUserDao.findUsersByCustomerIds(ModelConstants.NULL_UUID,
        customerIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findTenantAndCustomerUsers(isA(UUID.class), isA(Collection.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindUsersByCustomerIdsResult.getTotalElements());
    assertEquals(1, actualFindUsersByCustomerIdsResult.getTotalPages());
    assertFalse(actualFindUsersByCustomerIdsResult.hasNext());
    assertTrue(actualFindUsersByCustomerIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds_givenNull_customer_id2() {
    // Arrange
    when(userRepository.findTenantAndCustomerUsers(Mockito.<UUID>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<CustomerId> customerIds = new ArrayList<>();
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    customerIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = jpaUserDao.findUsersByCustomerIds(ModelConstants.NULL_UUID,
        customerIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findTenantAndCustomerUsers(isA(UUID.class), isA(Collection.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindUsersByCustomerIdsResult.getTotalElements());
    assertEquals(1, actualFindUsersByCustomerIdsResult.getTotalPages());
    assertFalse(actualFindUsersByCustomerIdsResult.hasNext());
    assertTrue(actualFindUsersByCustomerIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds_givenOne_thenCallsGetPage() {
    // Arrange
    when(userRepository.findTenantAndCustomerUsers(Mockito.<UUID>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<CustomerId> customerIds = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = jpaUserDao.findUsersByCustomerIds(ModelConstants.NULL_UUID,
        customerIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userRepository).findTenantAndCustomerUsers(isA(UUID.class), isA(Collection.class), eq("Text Search"),
        isA(Pageable.class));
    assertEquals(0L, actualFindUsersByCustomerIdsResult.getTotalElements());
    assertEquals(1, actualFindUsersByCustomerIdsResult.getTotalPages());
    assertFalse(actualFindUsersByCustomerIdsResult.hasNext());
    assertTrue(actualFindUsersByCustomerIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds_thenReturnDataFirstIsUser() {
    // Arrange
    UserEntity userEntity = mock(UserEntity.class);
    User user = new User();
    when(userEntity.toData()).thenReturn(user);
    doNothing().when(userEntity).setCreatedTime(anyLong());
    doNothing().when(userEntity).setId(Mockito.<UUID>any());
    doNothing().when(userEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userEntity).setVersion(Mockito.<Long>any());
    doNothing().when(userEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(userEntity).setAuthority(Mockito.<Authority>any());
    doNothing().when(userEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(userEntity).setEmail(Mockito.<String>any());
    doNothing().when(userEntity).setFirstName(Mockito.<String>any());
    doNothing().when(userEntity).setLastName(Mockito.<String>any());
    doNothing().when(userEntity).setPhone(Mockito.<String>any());
    doNothing().when(userEntity).setTenantId(Mockito.<UUID>any());
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.CUSTOMER_USER);
    userEntity.setCreatedTime(-1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("prof.einstein@example.org");
    userEntity.setFirstName("Albert");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Einstein");
    userEntity.setPhone("+44 1865 4960636");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(-1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findTenantAndCustomerUsers(Mockito.<UUID>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    ArrayList<CustomerId> customerIds = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = jpaUserDao.findUsersByCustomerIds(ModelConstants.NULL_UUID,
        customerIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userEntity).setCreatedTime(eq(-1L));
    verify(userEntity).setId(isA(UUID.class));
    verify(userEntity).setUuid(isA(UUID.class));
    verify(userEntity).setVersion(eq(-1L));
    verify(userEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(userEntity).setAuthority(eq(Authority.CUSTOMER_USER));
    verify(userEntity).setCustomerId(isA(UUID.class));
    verify(userEntity).setEmail(eq("prof.einstein@example.org"));
    verify(userEntity).setFirstName(eq("Albert"));
    verify(userEntity).setLastName(eq("Einstein"));
    verify(userEntity).setPhone(eq("+44 1865 4960636"));
    verify(userEntity).setTenantId(isA(UUID.class));
    verify(userEntity).toData();
    verify(userRepository).findTenantAndCustomerUsers(isA(UUID.class), isA(Collection.class), eq("Text Search"),
        isA(Pageable.class));
    List<User> data = actualFindUsersByCustomerIdsResult.getData();
    assertEquals(1, data.size());
    assertSame(user, data.get(0));
  }

  /**
   * Test {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findUsersByCustomerIds(UUID, List, PageLink)}
   */
  @Test
  public void testFindUsersByCustomerIds_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findTenantAndCustomerUsers(Mockito.<UUID>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindUsersByCustomerIdsResult = jpaUserDao.findUsersByCustomerIds(ModelConstants.NULL_UUID,
        new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findTenantAndCustomerUsers(isA(UUID.class), isA(Collection.class), isNull(),
        isA(Pageable.class));
    assertEquals(0L, actualFindUsersByCustomerIdsResult.getTotalElements());
    assertEquals(1, actualFindUsersByCustomerIdsResult.getTotalPages());
    assertFalse(actualFindUsersByCustomerIdsResult.hasNext());
    assertTrue(actualFindUsersByCustomerIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findAll(PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link PageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findAll(PageLink)}
   */
  @Test
  public void testFindAll_givenOne_whenPageLinkGetPageReturnOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findAll(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindAllResult = jpaUserDao.findAll(pageLink);

    // Assert
    verify(userRepository).findAll(isA(Pageable.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    assertEquals(0L, actualFindAllResult.getTotalElements());
    assertEquals(1, actualFindAllResult.getTotalPages());
    assertFalse(actualFindAllResult.hasNext());
    assertTrue(actualFindAllResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findAll(PageLink)}.
   * <ul>
   *   <li>Given {@link UserEntity} {@link UserEntity#toData()} return
   * {@link User#User()}.</li>
   *   <li>Then return Data first is {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findAll(PageLink)}
   */
  @Test
  public void testFindAll_givenUserEntityToDataReturnUser_thenReturnDataFirstIsUser() {
    // Arrange
    UserEntity userEntity = mock(UserEntity.class);
    User user = new User();
    when(userEntity.toData()).thenReturn(user);
    doNothing().when(userEntity).setCreatedTime(anyLong());
    doNothing().when(userEntity).setId(Mockito.<UUID>any());
    doNothing().when(userEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userEntity).setVersion(Mockito.<Long>any());
    doNothing().when(userEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(userEntity).setAuthority(Mockito.<Authority>any());
    doNothing().when(userEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(userEntity).setEmail(Mockito.<String>any());
    doNothing().when(userEntity).setFirstName(Mockito.<String>any());
    doNothing().when(userEntity).setLastName(Mockito.<String>any());
    doNothing().when(userEntity).setPhone(Mockito.<String>any());
    doNothing().when(userEntity).setTenantId(Mockito.<UUID>any());
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.CUSTOMER_USER);
    userEntity.setCreatedTime(-1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("prof.einstein@example.org");
    userEntity.setFirstName("Albert");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Einstein");
    userEntity.setPhone("+44 1865 4960636");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(-1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindAllResult = jpaUserDao.findAll(pageLink);

    // Assert
    verify(userRepository).findAll(isA(Pageable.class));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userEntity).setCreatedTime(eq(-1L));
    verify(userEntity).setId(isA(UUID.class));
    verify(userEntity).setUuid(isA(UUID.class));
    verify(userEntity).setVersion(eq(-1L));
    verify(userEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(userEntity).setAuthority(eq(Authority.CUSTOMER_USER));
    verify(userEntity).setCustomerId(isA(UUID.class));
    verify(userEntity).setEmail(eq("prof.einstein@example.org"));
    verify(userEntity).setFirstName(eq("Albert"));
    verify(userEntity).setLastName(eq("Einstein"));
    verify(userEntity).setPhone(eq("+44 1865 4960636"));
    verify(userEntity).setTenantId(isA(UUID.class));
    verify(userEntity).toData();
    List<User> data = actualFindAllResult.getData();
    assertEquals(1, data.size());
    assertSame(user, data.get(0));
  }

  /**
   * Test {@link JpaUserDao#findAll(PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findAll(PageLink)}
   */
  @Test
  public void testFindAll_thenDataFirstAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findAll(Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<User> actualFindAllResult = jpaUserDao.findAll(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findAll(isA(Pageable.class));
    List<User> data = actualFindAllResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
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
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Doe", getResult.getLastName());
    assertEquals("Jane Doe", getResult.getTitle());
    assertEquals("Jane", getResult.getFirstName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals("jane.doe@example.org", getResult.getName());
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
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    UserId id = getResult.getId();
    assertEquals(EntityType.USER, id.getEntityType());
    assertEquals(Authority.SYS_ADMIN, getResult.getAuthority());
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
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, customerId.getId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link JpaUserDao#findAll(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findAll(PageLink)}
   */
  @Test
  public void testFindAll_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findAll(Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindAllResult = jpaUserDao.findAll(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findAll(isA(Pageable.class));
    assertEquals(0L, actualFindAllResult.getTotalElements());
    assertEquals(1, actualFindAllResult.getTotalPages());
    assertFalse(actualFindAllResult.hasNext());
    assertTrue(actualFindAllResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}
   */
  @Test
  public void testFindAllByAuthority_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findAllByAuthority(Mockito.<Authority>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindAllByAuthorityResult = jpaUserDao.findAllByAuthority(Authority.SYS_ADMIN, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userRepository).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(Pageable.class));
    assertEquals(0L, actualFindAllByAuthorityResult.getTotalElements());
    assertEquals(1, actualFindAllByAuthorityResult.getTotalPages());
    assertFalse(actualFindAllByAuthorityResult.hasNext());
    assertTrue(actualFindAllByAuthorityResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}.
   * <ul>
   *   <li>Given {@link UserEntity} {@link UserEntity#toData()} return
   * {@link User#User()}.</li>
   *   <li>Then return Data first is {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}
   */
  @Test
  public void testFindAllByAuthority_givenUserEntityToDataReturnUser_thenReturnDataFirstIsUser() {
    // Arrange
    UserEntity userEntity = mock(UserEntity.class);
    User user = new User();
    when(userEntity.toData()).thenReturn(user);
    doNothing().when(userEntity).setCreatedTime(anyLong());
    doNothing().when(userEntity).setId(Mockito.<UUID>any());
    doNothing().when(userEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userEntity).setVersion(Mockito.<Long>any());
    doNothing().when(userEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(userEntity).setAuthority(Mockito.<Authority>any());
    doNothing().when(userEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(userEntity).setEmail(Mockito.<String>any());
    doNothing().when(userEntity).setFirstName(Mockito.<String>any());
    doNothing().when(userEntity).setLastName(Mockito.<String>any());
    doNothing().when(userEntity).setPhone(Mockito.<String>any());
    doNothing().when(userEntity).setTenantId(Mockito.<UUID>any());
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.CUSTOMER_USER);
    userEntity.setCreatedTime(-1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("prof.einstein@example.org");
    userEntity.setFirstName("Albert");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Einstein");
    userEntity.setPhone("+44 1865 4960636");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(-1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findAllByAuthority(Mockito.<Authority>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindAllByAuthorityResult = jpaUserDao.findAllByAuthority(Authority.SYS_ADMIN, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userEntity).setCreatedTime(eq(-1L));
    verify(userEntity).setId(isA(UUID.class));
    verify(userEntity).setUuid(isA(UUID.class));
    verify(userEntity).setVersion(eq(-1L));
    verify(userEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(userEntity).setAuthority(eq(Authority.CUSTOMER_USER));
    verify(userEntity).setCustomerId(isA(UUID.class));
    verify(userEntity).setEmail(eq("prof.einstein@example.org"));
    verify(userEntity).setFirstName(eq("Albert"));
    verify(userEntity).setLastName(eq("Einstein"));
    verify(userEntity).setPhone(eq("+44 1865 4960636"));
    verify(userEntity).setTenantId(isA(UUID.class));
    verify(userEntity).toData();
    verify(userRepository).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(Pageable.class));
    List<User> data = actualFindAllByAuthorityResult.getData();
    assertEquals(1, data.size());
    assertSame(user, data.get(0));
  }

  /**
   * Test {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}.
   * <ul>
   *   <li>Then Data first AdditionalInfo iterator next return
   * {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}
   */
  @Test
  public void testFindAllByAuthority_thenDataFirstAdditionalInfoIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findAllByAuthority(Mockito.<Authority>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<User> actualFindAllByAuthorityResult = jpaUserDao.findAllByAuthority(Authority.SYS_ADMIN,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(Pageable.class));
    List<User> data = actualFindAllByAuthorityResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
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
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Doe", getResult.getLastName());
    assertEquals("Jane Doe", getResult.getTitle());
    assertEquals("Jane", getResult.getFirstName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals("jane.doe@example.org", getResult.getName());
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
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    UserId id = getResult.getId();
    assertEquals(EntityType.USER, id.getEntityType());
    assertEquals(Authority.SYS_ADMIN, getResult.getAuthority());
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
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, customerId.getId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#findAllByAuthority(Authority, PageLink)}
   */
  @Test
  public void testFindAllByAuthority_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findAllByAuthority(Mockito.<Authority>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindAllByAuthorityResult = jpaUserDao.findAllByAuthority(Authority.SYS_ADMIN,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findAllByAuthority(eq(Authority.SYS_ADMIN), isA(Pageable.class));
    assertEquals(0L, actualFindAllByAuthorityResult.getTotalElements());
    assertEquals(1, actualFindAllByAuthorityResult.getTotalPages());
    assertFalse(actualFindAllByAuthorityResult.hasNext());
    assertTrue(actualFindAllByAuthorityResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}
   */
  @Test
  public void testFindByAuthorityAndTenantsIds() throws IOException {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findByAuthorityAndTenantIdIn(Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult = jpaUserDao
        .findByAuthorityAndTenantsIds(Authority.SYS_ADMIN, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findByAuthorityAndTenantIdIn(eq(Authority.SYS_ADMIN), isA(Collection.class),
        isA(Pageable.class));
    List<User> data = actualFindByAuthorityAndTenantsIdsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
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
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Doe", getResult.getLastName());
    assertEquals("Jane Doe", getResult.getTitle());
    assertEquals("Jane", getResult.getFirstName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals("jane.doe@example.org", getResult.getName());
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
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    UserId id = getResult.getId();
    assertEquals(EntityType.USER, id.getEntityType());
    assertEquals(Authority.SYS_ADMIN, getResult.getAuthority());
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
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, customerId.getId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}
   */
  @Test
  public void testFindByAuthorityAndTenantsIds_givenOne_thenCallsGetPage() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantIdIn(Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<TenantId> tenantsIds = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult = jpaUserDao
        .findByAuthorityAndTenantsIds(Authority.SYS_ADMIN, tenantsIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userRepository).findByAuthorityAndTenantIdIn(eq(Authority.SYS_ADMIN), isA(Collection.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantsIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantsIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}
   */
  @Test
  public void testFindByAuthorityAndTenantsIds_givenSystem_tenant() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantIdIn(Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<TenantId> tenantsIds = new ArrayList<>();
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult = jpaUserDao
        .findByAuthorityAndTenantsIds(Authority.SYS_ADMIN, tenantsIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findByAuthorityAndTenantIdIn(eq(Authority.SYS_ADMIN), isA(Collection.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantsIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantsIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}
   */
  @Test
  public void testFindByAuthorityAndTenantsIds_givenSystem_tenant2() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantIdIn(Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    ArrayList<TenantId> tenantsIds = new ArrayList<>();
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);
    tenantsIds.add(ModelConstants.SYSTEM_TENANT);

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult = jpaUserDao
        .findByAuthorityAndTenantsIds(Authority.SYS_ADMIN, tenantsIds, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findByAuthorityAndTenantIdIn(eq(Authority.SYS_ADMIN), isA(Collection.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantsIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantsIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}
   */
  @Test
  public void testFindByAuthorityAndTenantsIds_thenReturnDataFirstIsUser() {
    // Arrange
    UserEntity userEntity = mock(UserEntity.class);
    User user = new User();
    when(userEntity.toData()).thenReturn(user);
    doNothing().when(userEntity).setCreatedTime(anyLong());
    doNothing().when(userEntity).setId(Mockito.<UUID>any());
    doNothing().when(userEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userEntity).setVersion(Mockito.<Long>any());
    doNothing().when(userEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(userEntity).setAuthority(Mockito.<Authority>any());
    doNothing().when(userEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(userEntity).setEmail(Mockito.<String>any());
    doNothing().when(userEntity).setFirstName(Mockito.<String>any());
    doNothing().when(userEntity).setLastName(Mockito.<String>any());
    doNothing().when(userEntity).setPhone(Mockito.<String>any());
    doNothing().when(userEntity).setTenantId(Mockito.<UUID>any());
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.CUSTOMER_USER);
    userEntity.setCreatedTime(-1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("prof.einstein@example.org");
    userEntity.setFirstName("Albert");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Einstein");
    userEntity.setPhone("+44 1865 4960636");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(-1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findByAuthorityAndTenantIdIn(Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    ArrayList<TenantId> tenantsIds = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult = jpaUserDao
        .findByAuthorityAndTenantsIds(Authority.SYS_ADMIN, tenantsIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userEntity).setCreatedTime(eq(-1L));
    verify(userEntity).setId(isA(UUID.class));
    verify(userEntity).setUuid(isA(UUID.class));
    verify(userEntity).setVersion(eq(-1L));
    verify(userEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(userEntity).setAuthority(eq(Authority.CUSTOMER_USER));
    verify(userEntity).setCustomerId(isA(UUID.class));
    verify(userEntity).setEmail(eq("prof.einstein@example.org"));
    verify(userEntity).setFirstName(eq("Albert"));
    verify(userEntity).setLastName(eq("Einstein"));
    verify(userEntity).setPhone(eq("+44 1865 4960636"));
    verify(userEntity).setTenantId(isA(UUID.class));
    verify(userEntity).toData();
    verify(userRepository).findByAuthorityAndTenantIdIn(eq(Authority.SYS_ADMIN), isA(Collection.class),
        isA(Pageable.class));
    List<User> data = actualFindByAuthorityAndTenantsIdsResult.getData();
    assertEquals(1, data.size());
    assertSame(user, data.get(0));
  }

  /**
   * Test
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByAuthorityAndTenantsIds(Authority, List, PageLink)}
   */
  @Test
  public void testFindByAuthorityAndTenantsIds_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantIdIn(Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindByAuthorityAndTenantsIdsResult = jpaUserDao
        .findByAuthorityAndTenantsIds(Authority.SYS_ADMIN, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findByAuthorityAndTenantIdIn(eq(Authority.SYS_ADMIN), isA(Collection.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantsIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantsIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantsIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantsIdsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}
   */
  @Test
  public void testFindByAuthorityAndTenantProfilesIds() throws IOException {
    // Arrange
    UserEntity userEntity = new UserEntity();
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.SYS_ADMIN);
    userEntity.setCreatedTime(1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("jane.doe@example.org");
    userEntity.setFirstName("Jane");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Doe");
    userEntity.setPhone("6625550144");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findByAuthorityAndTenantProfilesIds(Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<User> actualFindByAuthorityAndTenantProfilesIdsResult = jpaUserDao.findByAuthorityAndTenantProfilesIds(
        Authority.SYS_ADMIN, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findByAuthorityAndTenantProfilesIds(eq(Authority.SYS_ADMIN), isA(Collection.class),
        isA(Pageable.class));
    List<User> data = actualFindByAuthorityAndTenantProfilesIdsResult.getData();
    assertEquals(1, data.size());
    User getResult = data.get(0);
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
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("6625550144", getResult.getPhone());
    assertEquals("Doe", getResult.getLastName());
    assertEquals("Jane Doe", getResult.getTitle());
    assertEquals("Jane", getResult.getFirstName());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("jane.doe@example.org", getResult.getEmail());
    assertEquals("jane.doe@example.org", getResult.getName());
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
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    UserId id = getResult.getId();
    assertEquals(EntityType.USER, id.getEntityType());
    assertEquals(Authority.SYS_ADMIN, getResult.getAuthority());
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
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(uuidId, customerId.getId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test
   * {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}
   */
  @Test
  public void testFindByAuthorityAndTenantProfilesIds_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantProfilesIds(Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    ArrayList<TenantProfileId> tenantProfilesIds = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindByAuthorityAndTenantProfilesIdsResult = jpaUserDao
        .findByAuthorityAndTenantProfilesIds(Authority.SYS_ADMIN, tenantProfilesIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userRepository).findByAuthorityAndTenantProfilesIds(eq(Authority.SYS_ADMIN), isA(Collection.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantProfilesIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantProfilesIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantProfilesIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantProfilesIdsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link User#User()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}
   */
  @Test
  public void testFindByAuthorityAndTenantProfilesIds_thenReturnDataFirstIsUser() {
    // Arrange
    UserEntity userEntity = mock(UserEntity.class);
    User user = new User();
    when(userEntity.toData()).thenReturn(user);
    doNothing().when(userEntity).setCreatedTime(anyLong());
    doNothing().when(userEntity).setId(Mockito.<UUID>any());
    doNothing().when(userEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(userEntity).setVersion(Mockito.<Long>any());
    doNothing().when(userEntity).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(userEntity).setAuthority(Mockito.<Authority>any());
    doNothing().when(userEntity).setCustomerId(Mockito.<UUID>any());
    doNothing().when(userEntity).setEmail(Mockito.<String>any());
    doNothing().when(userEntity).setFirstName(Mockito.<String>any());
    doNothing().when(userEntity).setLastName(Mockito.<String>any());
    doNothing().when(userEntity).setPhone(Mockito.<String>any());
    doNothing().when(userEntity).setTenantId(Mockito.<UUID>any());
    userEntity.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    userEntity.setAuthority(Authority.CUSTOMER_USER);
    userEntity.setCreatedTime(-1L);
    userEntity.setCustomerId(ModelConstants.NULL_UUID);
    userEntity.setEmail("prof.einstein@example.org");
    userEntity.setFirstName("Albert");
    userEntity.setId(ModelConstants.NULL_UUID);
    userEntity.setLastName("Einstein");
    userEntity.setPhone("+44 1865 4960636");
    userEntity.setTenantId(ModelConstants.NULL_UUID);
    userEntity.setUuid(ModelConstants.NULL_UUID);
    userEntity.setVersion(-1L);

    ArrayList<UserEntity> content = new ArrayList<>();
    content.add(userEntity);
    PageImpl<UserEntity> pageImpl = new PageImpl<>(content);
    when(userRepository.findByAuthorityAndTenantProfilesIds(Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    ArrayList<TenantProfileId> tenantProfilesIds = new ArrayList<>();
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<User> actualFindByAuthorityAndTenantProfilesIdsResult = jpaUserDao
        .findByAuthorityAndTenantProfilesIds(Authority.SYS_ADMIN, tenantProfilesIds, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(userEntity).setCreatedTime(eq(-1L));
    verify(userEntity).setId(isA(UUID.class));
    verify(userEntity).setUuid(isA(UUID.class));
    verify(userEntity).setVersion(eq(-1L));
    verify(userEntity).setAdditionalInfo(isA(JsonNode.class));
    verify(userEntity).setAuthority(eq(Authority.CUSTOMER_USER));
    verify(userEntity).setCustomerId(isA(UUID.class));
    verify(userEntity).setEmail(eq("prof.einstein@example.org"));
    verify(userEntity).setFirstName(eq("Albert"));
    verify(userEntity).setLastName(eq("Einstein"));
    verify(userEntity).setPhone(eq("+44 1865 4960636"));
    verify(userEntity).setTenantId(isA(UUID.class));
    verify(userEntity).toData();
    verify(userRepository).findByAuthorityAndTenantProfilesIds(eq(Authority.SYS_ADMIN), isA(Collection.class),
        isA(Pageable.class));
    List<User> data = actualFindByAuthorityAndTenantProfilesIdsResult.getData();
    assertEquals(1, data.size());
    assertSame(user, data.get(0));
  }

  /**
   * Test
   * {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}.
   * <ul>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaUserDao#findByAuthorityAndTenantProfilesIds(Authority, List, PageLink)}
   */
  @Test
  public void testFindByAuthorityAndTenantProfilesIds_thenReturnTotalElementsIsZero() {
    // Arrange
    when(userRepository.findByAuthorityAndTenantProfilesIds(Mockito.<Authority>any(), Mockito.<Collection<UUID>>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<User> actualFindByAuthorityAndTenantProfilesIdsResult = jpaUserDao.findByAuthorityAndTenantProfilesIds(
        Authority.SYS_ADMIN, new ArrayList<>(), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(userRepository).findByAuthorityAndTenantProfilesIds(eq(Authority.SYS_ADMIN), isA(Collection.class),
        isA(Pageable.class));
    assertEquals(0L, actualFindByAuthorityAndTenantProfilesIdsResult.getTotalElements());
    assertEquals(1, actualFindByAuthorityAndTenantProfilesIdsResult.getTotalPages());
    assertFalse(actualFindByAuthorityAndTenantProfilesIdsResult.hasNext());
    assertTrue(actualFindByAuthorityAndTenantProfilesIdsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaUserDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaUserDao#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(userRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaUserDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(userRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }
}
