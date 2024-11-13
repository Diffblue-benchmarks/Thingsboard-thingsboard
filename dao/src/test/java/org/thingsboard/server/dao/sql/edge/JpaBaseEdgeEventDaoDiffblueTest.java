package org.thingsboard.server.dao.sql.edge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.EdgeEventId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.BaseSqlEntity;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.EdgeEventEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaBaseEdgeEventDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaBaseEdgeEventDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EdgeEventInsertRepository edgeEventInsertRepository;

  @MockBean
  private EdgeEventRepository edgeEventRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaBaseEdgeEventDao jpaBaseEdgeEventDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private ScheduledLogExecutorComponent scheduledLogExecutorComponent;

  @MockBean
  private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean
  private StatsFactory statsFactory;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaBaseEdgeEventDao#getEntityClass()}
   *   <li>{@link JpaBaseEdgeEventDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao jpaBaseEdgeEventDao = new JpaBaseEdgeEventDao(logExecutor, new DefaultStatsFactory(),
        mock(EdgeEventRepository.class), mock(EdgeEventInsertRepository.class), mock(SqlPartitioningRepository.class),
        mock(JdbcTemplate.class));

    // Act
    Class<EdgeEventEntity> actualEntityClass = jpaBaseEdgeEventDao.getEntityClass();
    jpaBaseEdgeEventDao.getRepository();

    // Assert
    Class<EdgeEventEntity> expectedEntityClass = EdgeEventEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#saveAsync(EdgeEvent)}.
   * <ul>
   *   <li>When {@link EdgeEvent#EdgeEvent()} Id is
   * {@link EdgeEventId#EdgeEventId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEdgeEventDao#saveAsync(EdgeEvent)}
   */
  @Test
  public void testSaveAsync_whenEdgeEventIdIsEdgeEventIdWithIdIsNull_uuid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    doThrow(new RuntimeException("Save edge event [{}] ")).when(partitioningRepository)
        .createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao jpaBaseEdgeEventDao = new JpaBaseEdgeEventDao(logExecutor, new DefaultStatsFactory(),
        mock(EdgeEventRepository.class), mock(EdgeEventInsertRepository.class), partitioningRepository,
        mock(JdbcTemplate.class));

    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setId(new EdgeEventId(ModelConstants.NULL_UUID));
    edgeEvent.setCreatedTime(0L);
    edgeEvent.setUid(null);
    edgeEvent.setTenantId(null);
    edgeEvent.setEdgeId(null);
    edgeEvent.setEntityId(null);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEdgeEventDao.saveAsync(edgeEvent));
    verify(partitioningRepository).createPartitionIfNotExists(eq("edge_event"), eq(0L), eq(0L));
  }

  /**
   * Test
   * {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   * <ul>
   *   <li>Given {@link EdgeEventEntity#EdgeEventEntity()} CreatedTime is one.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}
   */
  @Test
  public void testFindEdgeEvents_givenEdgeEventEntityCreatedTimeIsOne_thenReturnDataSizeIsOne() throws IOException {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<EdgeEventEntity> content = new ArrayList<>();
    content.add(edgeEventEntity);
    PageImpl<EdgeEventEntity> pageImpl = new PageImpl<>(content);
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID tenantId = ModelConstants.NULL_UUID;
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult = jpaBaseEdgeEventDao.findEdgeEvents(tenantId, edgeId, 1L, 1L,
        new TimePageLink(3));

    // Assert
    verify(edgeEventRepository).findEdgeEventsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isNull(),
        isNull(), eq(1L), eq(1L), isA(Pageable.class));
    List<EdgeEvent> data = actualFindEdgeEventsResult.getData();
    assertEquals(1, data.size());
    EdgeEvent getResult = data.get(0);
    JsonNode body = getResult.getBody();
    Iterator<JsonNode> iteratorResult = body.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof BooleanNode);
    assertTrue(body instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = body.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    assertEquals("1234", getResult.getUid());
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("{\r\n  \"isPublic\" : true\r\n}", body.toPrettyString());
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
    assertEquals(1, body.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, getResult.getSeqId());
    assertEquals(1L, actualFindEdgeEventsResult.getTotalElements());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.BOOLEAN, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, body.getNodeType());
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertEquals(EdgeEventActionType.ADDED, getResult.getAction());
    assertEquals(EdgeEventType.DASHBOARD, getResult.getType());
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
    assertFalse(body.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(body.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(body.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(body.isBinary());
    assertFalse(body.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(body.isDouble());
    assertFalse(body.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(body.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(body.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(body.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(body.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(body.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(body.isMissingNode());
    assertFalse(nextResult.isNull());
    assertFalse(body.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(body.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(body.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(body.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(body.isTextual());
    assertFalse(body.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(nextResult.isBoolean());
    assertTrue(body.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(body.isObject());
    assertTrue(nextResult.isValueNode());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    assertEquals(edgeId, getResult.getEdgeId());
    String expectedToPrettyStringResult = Boolean.TRUE.toString();
    assertEquals(expectedToPrettyStringResult, nextResult.toPrettyString());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
    assertSame(tenantId, getResult.getEntityId());
    assertSame(tenantId, getResult.getUuidId());
    assertSame(tenantId, getResult.getId().getId());
  }

  /**
   * Test
   * {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EdgeId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}
   */
  @Test
  public void testFindEdgeEvents_givenNull_uuid_whenEdgeIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult = jpaBaseEdgeEventDao.findEdgeEvents(ModelConstants.NULL_UUID,
        edgeId, 1L, 1L, new TimePageLink(3));

    // Assert
    verify(edgeId).getId();
    verify(edgeEventRepository).findEdgeEventsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isNull(),
        isNull(), eq(1L), eq(1L), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeEventsResult.getTotalElements());
    assertEquals(1, actualFindEdgeEventsResult.getTotalPages());
    assertFalse(actualFindEdgeEventsResult.hasNext());
    assertTrue(actualFindEdgeEventsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link TimePageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}
   */
  @Test
  public void testFindEdgeEvents_givenOne_whenTimePageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult = jpaBaseEdgeEventDao.findEdgeEvents(ModelConstants.NULL_UUID,
        edgeId, 1L, 1L, pageLink);

    // Assert
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(edgeEventRepository).findEdgeEventsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), eq("Text Search"),
        eq(1L), eq(1L), eq(1L), eq(1L), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeEventsResult.getTotalElements());
    assertEquals(1, actualFindEdgeEventsResult.getTotalPages());
    assertFalse(actualFindEdgeEventsResult.hasNext());
    assertTrue(actualFindEdgeEventsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}
   */
  @Test
  public void testFindEdgeEvents_whenEdgeIdWithIdIsNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any(), Mockito.<Long>any(),
        Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult = jpaBaseEdgeEventDao.findEdgeEvents(ModelConstants.NULL_UUID,
        edgeId, 1L, 1L, new TimePageLink(3));

    // Assert
    verify(edgeEventRepository).findEdgeEventsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isNull(), isNull(),
        isNull(), eq(1L), eq(1L), isA(Pageable.class));
    assertEquals(0L, actualFindEdgeEventsResult.getTotalElements());
    assertEquals(1, actualFindEdgeEventsResult.getTotalPages());
    assertFalse(actualFindEdgeEventsResult.hasNext());
    assertTrue(actualFindEdgeEventsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#cleanupEvents(long)}.
   * <ul>
   *   <li>Given {@link SqlPartitioningRepository}
   * {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)}
   * return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEdgeEventDao#cleanupEvents(long)}
   */
  @Test
  public void testCleanupEvents_givenSqlPartitioningRepositoryDropPartitionsBeforeReturnOne() {
    // Arrange
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(1L);

    // Act
    jpaBaseEdgeEventDao.cleanupEvents(1L);

    // Assert that nothing has changed
    verify(sqlPartitioningRepository).dropPartitionsBefore(eq("edge_event"), eq(1L), eq(604800000L));
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#cleanupEvents(long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEdgeEventDao#cleanupEvents(long)}
   */
  @Test
  public void testCleanupEvents_thenThrowRuntimeException() {
    // Arrange
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong()))
        .thenThrow(new RuntimeException("edge_event"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEdgeEventDao.cleanupEvents(1L));
    verify(sqlPartitioningRepository).dropPartitionsBefore(eq("edge_event"), eq(1L), eq(604800000L));
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#migrateEdgeEvents()}.
   * <ul>
   *   <li>Given {@link JdbcTemplate} {@link JdbcTemplate#update(String, Object[])}
   * return one.</li>
   *   <li>Then calls {@link JdbcTemplate#execute(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEdgeEventDao#migrateEdgeEvents()}
   */
  @Test
  public void testMigrateEdgeEvents_givenJdbcTemplateUpdateReturnOne_thenCallsExecute() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.update(Mockito.<String>any(), isA(Object[].class))).thenReturn(1);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());

    // Act
    jpaBaseEdgeEventDao.migrateEdgeEvents();

    // Assert
    verify(jdbcTemplate).execute(eq("DROP TABLE IF EXISTS old_edge_event"));
    verify(jdbcTemplate, atLeast(1)).update(eq("CALL migrate_edge_event(?, ?, ?)"), isA(Object[].class));
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#migrateEdgeEvents()}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEdgeEventDao#migrateEdgeEvents()}
   */
  @Test
  public void testMigrateEdgeEvents_thenThrowRuntimeException() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.update(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new RuntimeException("Migrating edge event for time period: {} - {}"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEdgeEventDao.migrateEdgeEvents());
    verify(jdbcTemplate).update(eq("CALL migrate_edge_event(?, ?, ?)"), isA(Object[].class));
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#createPartition(EdgeEventEntity)} with
   * {@code EdgeEventEntity}.
   * <ul>
   *   <li>Then calls {@link BaseSqlEntity#getCreatedTime()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEdgeEventDao#createPartition(EdgeEventEntity)}
   */
  @Test
  public void testCreatePartitionWithEdgeEventEntity_thenCallsGetCreatedTime() {
    // Arrange
    doNothing().when(sqlPartitioningRepository).createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());
    EdgeEventEntity entity = mock(EdgeEventEntity.class);
    when(entity.getCreatedTime()).thenReturn(1L);
    doNothing().when(entity).setCreatedTime(anyLong());
    doNothing().when(entity).setId(Mockito.<UUID>any());
    doNothing().when(entity).setUuid(Mockito.<UUID>any());
    doNothing().when(entity).setEdgeEventAction(Mockito.<EdgeEventActionType>any());
    doNothing().when(entity).setEdgeEventType(Mockito.<EdgeEventType>any());
    doNothing().when(entity).setEdgeEventUid(Mockito.<String>any());
    doNothing().when(entity).setEdgeId(Mockito.<UUID>any());
    doNothing().when(entity).setEntityBody(Mockito.<JsonNode>any());
    doNothing().when(entity).setEntityId(Mockito.<UUID>any());
    doNothing().when(entity).setSeqId(anyLong());
    doNothing().when(entity).setTenantId(Mockito.<UUID>any());
    doNothing().when(entity).setTs(anyLong());
    entity.setCreatedTime(1L);
    entity.setEdgeEventAction(EdgeEventActionType.ADDED);
    entity.setEdgeEventType(EdgeEventType.DASHBOARD);
    entity.setEdgeEventUid("1234");
    entity.setEdgeId(ModelConstants.NULL_UUID);
    entity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entity.setEntityId(ModelConstants.NULL_UUID);
    entity.setId(ModelConstants.NULL_UUID);
    entity.setSeqId(1L);
    entity.setTenantId(ModelConstants.NULL_UUID);
    entity.setTs(1L);
    entity.setUuid(ModelConstants.NULL_UUID);

    // Act
    jpaBaseEdgeEventDao.createPartition(entity);

    // Assert that nothing has changed
    verify(entity).getCreatedTime();
    verify(entity).setCreatedTime(eq(1L));
    verify(entity).setId(isA(UUID.class));
    verify(entity).setUuid(isA(UUID.class));
    verify(entity).setEdgeEventAction(eq(EdgeEventActionType.ADDED));
    verify(entity).setEdgeEventType(eq(EdgeEventType.DASHBOARD));
    verify(entity).setEdgeEventUid(eq("1234"));
    verify(entity).setEdgeId(isA(UUID.class));
    verify(entity).setEntityBody(isA(JsonNode.class));
    verify(entity).setEntityId(isA(UUID.class));
    verify(entity).setSeqId(eq(1L));
    verify(entity).setTenantId(isA(UUID.class));
    verify(entity).setTs(eq(1L));
    verify(sqlPartitioningRepository).createPartitionIfNotExists(eq("edge_event"), eq(1L), eq(604800000L));
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#createPartition(EdgeEventEntity)} with
   * {@code EdgeEventEntity}.
   * <ul>
   *   <li>When {@link EdgeEventEntity#EdgeEventEntity()} CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEdgeEventDao#createPartition(EdgeEventEntity)}
   */
  @Test
  public void testCreatePartitionWithEdgeEventEntity_whenEdgeEventEntityCreatedTimeIsOne() {
    // Arrange
    doNothing().when(sqlPartitioningRepository).createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());

    EdgeEventEntity entity = new EdgeEventEntity();
    entity.setCreatedTime(1L);
    entity.setEdgeEventAction(EdgeEventActionType.ADDED);
    entity.setEdgeEventType(EdgeEventType.DASHBOARD);
    entity.setEdgeEventUid("1234");
    entity.setEdgeId(ModelConstants.NULL_UUID);
    entity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    entity.setEntityId(ModelConstants.NULL_UUID);
    entity.setId(ModelConstants.NULL_UUID);
    entity.setSeqId(1L);
    entity.setTenantId(ModelConstants.NULL_UUID);
    entity.setTs(1L);
    entity.setUuid(ModelConstants.NULL_UUID);

    // Act
    jpaBaseEdgeEventDao.createPartition(entity);

    // Assert that nothing has changed
    verify(sqlPartitioningRepository).createPartitionIfNotExists(eq("edge_event"), eq(1L), eq(604800000L));
  }
}
