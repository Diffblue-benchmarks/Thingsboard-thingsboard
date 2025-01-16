package org.thingsboard.server.dao.sql.alarm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmCommentInfo;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AlarmCommentEntity;
import org.thingsboard.server.dao.model.sql.AlarmCommentInfoEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaAlarmCommentDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaAlarmCommentDaoDiffblueTest {
  @MockBean
  private AlarmCommentRepository alarmCommentRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAlarmCommentDao jpaAlarmCommentDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return TotalElements is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  public void testFindAlarmComments_givenArrayListAddNull_thenReturnTotalElementsIsOne() {
    // Arrange
    ArrayList<AlarmCommentInfoEntity> content = new ArrayList<>();
    content.add(null);
    PageImpl<AlarmCommentInfoEntity> pageImpl = new PageImpl<>(content);
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult = jpaAlarmCommentDao
        .findAlarmComments(ModelConstants.SYSTEM_TENANT, id, pageLink);

    // Assert
    verify(id).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    assertEquals(1, actualFindAlarmCommentsResult.getTotalPages());
    assertEquals(1L, actualFindAlarmCommentsResult.getTotalElements());
    assertFalse(actualFindAlarmCommentsResult.hasNext());
    assertTrue(actualFindAlarmCommentsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  public void testFindAlarmComments_givenNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult = jpaAlarmCommentDao
        .findAlarmComments(ModelConstants.SYSTEM_TENANT, id, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(id).getId();
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmCommentsResult.getTotalElements());
    assertEquals(1, actualFindAlarmCommentsResult.getTotalPages());
    assertFalse(actualFindAlarmCommentsResult.hasNext());
    assertTrue(actualFindAlarmCommentsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  public void testFindAlarmComments_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult = jpaAlarmCommentDao
        .findAlarmComments(ModelConstants.SYSTEM_TENANT, id, pageLink);

    // Assert
    verify(id).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmCommentsResult.getTotalElements());
    assertEquals(1, actualFindAlarmCommentsResult.getTotalPages());
    assertFalse(actualFindAlarmCommentsResult.hasNext());
    assertTrue(actualFindAlarmCommentsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   * <ul>
   *   <li>Then return Data first AlarmId Id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  public void testFindAlarmComments_thenReturnDataFirstAlarmIdIdIsNull() {
    // Arrange
    ArrayList<AlarmCommentInfoEntity> content = new ArrayList<>();
    content.add(new AlarmCommentInfoEntity());
    PageImpl<AlarmCommentInfoEntity> pageImpl = new PageImpl<>(content);
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult = jpaAlarmCommentDao.findAlarmComments(
        ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    List<AlarmCommentInfo> data = actualFindAlarmCommentsResult.getData();
    assertEquals(1, data.size());
    AlarmCommentInfo getResult = data.get(0);
    AlarmId alarmId = getResult.getAlarmId();
    assertNull(alarmId.getId());
    assertNull(getResult.getId().getId());
    assertEquals(EntityType.ALARM, alarmId.getEntityType());
    assertFalse(alarmId.isNullUid());
  }

  /**
   * Test
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   * <ul>
   *   <li>Then return Data first is
   * {@link AlarmCommentInfo#AlarmCommentInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  public void testFindAlarmComments_thenReturnDataFirstIsAlarmCommentInfo() {
    // Arrange
    AlarmCommentInfoEntity alarmCommentInfoEntity = mock(AlarmCommentInfoEntity.class);
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    when(alarmCommentInfoEntity.toData()).thenReturn(alarmCommentInfo);

    ArrayList<AlarmCommentInfoEntity> content = new ArrayList<>();
    content.add(alarmCommentInfoEntity);
    PageImpl<AlarmCommentInfoEntity> pageImpl = new PageImpl<>(content);
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult = jpaAlarmCommentDao
        .findAlarmComments(ModelConstants.SYSTEM_TENANT, id, pageLink);

    // Assert
    verify(id).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(alarmCommentInfoEntity).toData();
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    List<AlarmCommentInfo> data = actualFindAlarmCommentsResult.getData();
    assertEquals(1, data.size());
    assertSame(alarmCommentInfo, data.get(0));
  }

  /**
   * Test
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmCommentDao#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  public void testFindAlarmComments_whenAlarmIdWithIdIsNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(alarmCommentRepository.findAllByAlarmId(Mockito.<UUID>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult = jpaAlarmCommentDao.findAlarmComments(
        ModelConstants.SYSTEM_TENANT, new AlarmId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmCommentRepository).findAllByAlarmId(isA(UUID.class), isA(Pageable.class));
    assertEquals(0L, actualFindAlarmCommentsResult.getTotalElements());
    assertEquals(1, actualFindAlarmCommentsResult.getTotalPages());
    assertFalse(actualFindAlarmCommentsResult.hasNext());
    assertTrue(actualFindAlarmCommentsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmCommentById(TenantId, UUID)}.
   * <ul>
   *   <li>Then Comment iterator next return {@link BooleanNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmCommentDao#findAlarmCommentById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmCommentById_thenCommentIteratorNextReturnBooleanNode() throws IOException {
    // Arrange
    AlarmCommentEntity alarmCommentEntity = new AlarmCommentEntity();
    alarmCommentEntity.setAlarmId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    alarmCommentEntity.setCreatedTime(1L);
    alarmCommentEntity.setId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setType(AlarmCommentType.SYSTEM);
    alarmCommentEntity.setUserId(ModelConstants.NULL_UUID);
    alarmCommentEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<AlarmCommentEntity> ofResult = Optional.of(alarmCommentEntity);
    when(alarmCommentRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    UUID key = ModelConstants.NULL_UUID;

    // Act
    AlarmComment actualFindAlarmCommentByIdResult = jpaAlarmCommentDao
        .findAlarmCommentById(ModelConstants.SYSTEM_TENANT, key);

    // Assert
    verify(alarmCommentRepository).findById(isA(UUID.class));
    JsonNode comment = actualFindAlarmCommentByIdResult.getComment();
    Iterator<JsonNode> iteratorResult = comment.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(comment instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = comment.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\"isPublic\":true}", actualFindAlarmCommentByIdResult.getName());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", comment.toPrettyString());
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
    assertEquals(1, comment.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, actualFindAlarmCommentByIdResult.getCreatedTime());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, comment.getNodeType());
    AlarmId alarmId = actualFindAlarmCommentByIdResult.getAlarmId();
    assertEquals(EntityType.ALARM, alarmId.getEntityType());
    UserId userId = actualFindAlarmCommentByIdResult.getUserId();
    assertEquals(EntityType.USER, userId.getEntityType());
    assertEquals(AlarmCommentType.SYSTEM, actualFindAlarmCommentByIdResult.getType());
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
    assertFalse(comment.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(comment.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(comment.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(comment.isBinary());
    assertFalse(comment.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(comment.isDouble());
    assertFalse(comment.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(comment.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(comment.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(comment.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(comment.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(comment.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(comment.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(comment.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(comment.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(comment.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(comment.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(comment.isTextual());
    assertFalse(comment.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(comment.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(comment.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(alarmId.isNullUid());
    assertTrue(userId.isNullUid());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(key, actualFindAlarmCommentByIdResult.getUuidId());
    assertSame(key, alarmId.getId());
    assertSame(key, actualFindAlarmCommentByIdResult.getId().getId());
    assertSame(key, userId.getId());
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmCommentById(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaAlarmCommentDao#findAlarmCommentById(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmCommentById_thenReturnNull() {
    // Arrange
    Optional<AlarmCommentEntity> emptyResult = Optional.empty();
    when(alarmCommentRepository.findById(Mockito.<UUID>any())).thenReturn(emptyResult);

    // Act
    AlarmComment actualFindAlarmCommentByIdResult = jpaAlarmCommentDao
        .findAlarmCommentById(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(alarmCommentRepository).findById(isA(UUID.class));
    assertNull(actualFindAlarmCommentByIdResult);
  }

  /**
   * Test {@link JpaAlarmCommentDao#findAlarmCommentByIdAsync(TenantId, UUID)}.
   * <p>
   * Method under test:
   * {@link JpaAlarmCommentDao#findAlarmCommentByIdAsync(TenantId, UUID)}
   */
  @Test
  public void testFindAlarmCommentByIdAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<AlarmComment> actualFindAlarmCommentByIdAsyncResult = jpaAlarmCommentDao
        .findAlarmCommentByIdAsync(ModelConstants.SYSTEM_TENANT, ModelConstants.NULL_UUID);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAlarmCommentByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmCommentByIdAsyncResult);
  }

  /**
   * Test {@link JpaAlarmCommentDao#createPartition(AlarmCommentEntity)} with
   * {@code AlarmCommentEntity}.
   * <p>
   * Method under test:
   * {@link JpaAlarmCommentDao#createPartition(AlarmCommentEntity)}
   */
  @Test
  public void testCreatePartitionWithAlarmCommentEntity() {
    // Arrange
    doNothing().when(sqlPartitioningRepository).createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());

    AlarmCommentEntity entity = new AlarmCommentEntity();
    entity.setAlarmId(ModelConstants.NULL_UUID);
    entity.setComment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entity.setCreatedTime(1L);
    entity.setId(ModelConstants.NULL_UUID);
    entity.setType(AlarmCommentType.SYSTEM);
    entity.setUserId(ModelConstants.NULL_UUID);
    entity.setUuid(ModelConstants.NULL_UUID);

    // Act
    jpaAlarmCommentDao.createPartition(entity);

    // Assert that nothing has changed
    verify(sqlPartitioningRepository).createPartitionIfNotExists(eq("alarm_comment"), eq(1L), eq(604800000L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAlarmCommentDao#getEntityClass()}
   *   <li>{@link JpaAlarmCommentDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaAlarmCommentDao jpaAlarmCommentDao = new JpaAlarmCommentDao(mock(SqlPartitioningRepository.class));

    // Act
    Class<AlarmCommentEntity> actualEntityClass = jpaAlarmCommentDao.getEntityClass();

    // Assert
    assertNull(jpaAlarmCommentDao.getRepository());
    Class<AlarmCommentEntity> expectedEntityClass = AlarmCommentEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
