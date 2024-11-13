package org.thingsboard.server.dao.sql.event;

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
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.BaseData;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.event.ErrorEvent;
import org.thingsboard.server.common.data.event.ErrorEventFilter;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.event.EventFilter;
import org.thingsboard.server.common.data.event.EventType;
import org.thingsboard.server.common.data.event.LifeCycleEventFilter;
import org.thingsboard.server.common.data.event.RuleNodeDebugEvent;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.ErrorEventEntity;
import org.thingsboard.server.dao.model.sql.RuleNodeDebugEventEntity;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaBaseEventDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaBaseEventDaoDiffblueTest {
  @MockBean
  private ErrorEventRepository errorEventRepository;

  @MockBean
  private EventInsertRepository eventInsertRepository;

  @MockBean
  private EventPartitionConfiguration eventPartitionConfiguration;

  @Autowired
  private JpaBaseEventDao jpaBaseEventDao;

  @MockBean
  private LifecycleEventRepository lifecycleEventRepository;

  @MockBean
  private RuleChainDebugEventRepository ruleChainDebugEventRepository;

  @MockBean
  private RuleNodeDebugEventRepository ruleNodeDebugEventRepository;

  @MockBean
  private ScheduledLogExecutorComponent scheduledLogExecutorComponent;

  @MockBean
  private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean
  private StatisticsEventRepository statisticsEventRepository;

  @MockBean
  private StatsFactory statsFactory;

  /**
   * Test {@link JpaBaseEventDao#saveAsync(Event)}.
   * <ul>
   *   <li>Given {@link EventId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#saveAsync(Event)}
   */
  @Test
  public void testSaveAsync_givenEventIdGetIdReturnNull_uuid_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EventPartitionConfiguration partitionConfiguration = mock(EventPartitionConfiguration.class);
    when(partitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any()))
        .thenThrow(new RuntimeException("Save event [{}] "));
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository = mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository = mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEventDao jpaBaseEventDao = new JpaBaseEventDao(partitionConfiguration, partitioningRepository,
        lcEventRepository, statsEventRepository, errorEventRepository, eventInsertRepository,
        ruleNodeDebugEventRepository, ruleChainDebugEventRepository, logExecutor, new DefaultStatsFactory());
    EventId eventId = mock(EventId.class);
    when(eventId.getId()).thenReturn(ModelConstants.NULL_UUID);
    Event event = mock(Event.class);
    when(event.getCreatedTime()).thenReturn(0L);
    when(event.getType()).thenReturn(EventType.ERROR);
    when(event.getId()).thenReturn(eventId);
    doNothing().when(event).setCreatedTime(anyLong());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.saveAsync(event));
    verify(event, atLeast(1)).getCreatedTime();
    verify(event).setCreatedTime(eq(0L));
    verify(event, atLeast(1)).getType();
    verify(event, atLeast(1)).getId();
    verify(eventId).getId();
    verify(partitionConfiguration).getPartitionSizeInMs(eq(EventType.ERROR));
  }

  /**
   * Test {@link JpaBaseEventDao#saveAsync(Event)}.
   * <ul>
   *   <li>Given {@link EventId#EventId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#saveAsync(Event)}
   */
  @Test
  public void testSaveAsync_givenEventIdWithIdIsNull_uuid() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EventPartitionConfiguration partitionConfiguration = mock(EventPartitionConfiguration.class);
    when(partitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any()))
        .thenThrow(new RuntimeException("Save event [{}] "));
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository = mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository = mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEventDao jpaBaseEventDao = new JpaBaseEventDao(partitionConfiguration, partitioningRepository,
        lcEventRepository, statsEventRepository, errorEventRepository, eventInsertRepository,
        ruleNodeDebugEventRepository, ruleChainDebugEventRepository, logExecutor, new DefaultStatsFactory());
    Event event = mock(Event.class);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getType()).thenReturn(EventType.ERROR);
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.saveAsync(event));
    verify(event, atLeast(1)).getCreatedTime();
    verify(event, atLeast(1)).getType();
    verify(event).getId();
    verify(partitionConfiguration).getPartitionSizeInMs(eq(EventType.ERROR));
  }

  /**
   * Test {@link JpaBaseEventDao#saveAsync(Event)}.
   * <ul>
   *   <li>Given {@link EventId#EventId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link BaseData#setCreatedTime(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#saveAsync(Event)}
   */
  @Test
  public void testSaveAsync_givenEventIdWithIdIsNull_uuid_thenCallsSetCreatedTime() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    EventPartitionConfiguration partitionConfiguration = mock(EventPartitionConfiguration.class);
    when(partitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any()))
        .thenThrow(new RuntimeException("Save event [{}] "));
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository = mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository = mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEventDao jpaBaseEventDao = new JpaBaseEventDao(partitionConfiguration, partitioningRepository,
        lcEventRepository, statsEventRepository, errorEventRepository, eventInsertRepository,
        ruleNodeDebugEventRepository, ruleChainDebugEventRepository, logExecutor, new DefaultStatsFactory());
    Event event = mock(Event.class);
    when(event.getCreatedTime()).thenReturn(0L);
    when(event.getType()).thenReturn(EventType.ERROR);
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));
    doNothing().when(event).setCreatedTime(anyLong());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.saveAsync(event));
    verify(event, atLeast(1)).getCreatedTime();
    verify(event).setCreatedTime(eq(0L));
    verify(event, atLeast(1)).getType();
    verify(event, atLeast(1)).getId();
    verify(partitionConfiguration).getPartitionSizeInMs(eq(EventType.ERROR));
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   * <ul>
   *   <li>Given {@link ErrorEventEntity#ErrorEventEntity()} CreatedTime is
   * one.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  public void testFindEvents_givenErrorEventEntityCreatedTimeIsOne_thenReturnDataSizeIsOne() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<ErrorEventEntity> content = new ArrayList<>();
    content.add(errorEventEntity);
    PageImpl<ErrorEventEntity> pageImpl = new PageImpl<>(content);
    when(errorEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    PageData<? extends Event> actualFindEventsResult = jpaBaseEventDao.findEvents(ModelConstants.NULL_UUID, entityId,
        EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(errorEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    List<? extends Event> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    Event getResult = data.get(0);
    assertTrue(getResult instanceof ErrorEvent);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", getResult.getServiceId());
    assertEquals("An error occurred", ((ErrorEvent) getResult).getError());
    assertEquals("Method", ((ErrorEvent) getResult).getMethod());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEventsResult.getTotalElements());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.ERROR, getResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, getResult.getEntityId());
    assertSame(entityId, getResult.getUuidId());
    assertSame(entityId, getResult.getId().getId());
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link TimePageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  public void testFindEvents_givenOne_whenTimePageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(lifecycleEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenThrow(new RuntimeException("foo"));
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.findEvents(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, EventType.LC_EVENT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(lifecycleEventRepository).findEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  public void testFindEvents_thenThrowRuntimeException() {
    // Arrange
    when(lifecycleEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.findEvents(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, EventType.LC_EVENT, new TimePageLink(3)));
    verify(lifecycleEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(),
        isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   * <ul>
   *   <li>When {@code ERROR}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  public void testFindEvents_whenError_thenReturnTotalElementsIsZero() {
    // Arrange
    when(errorEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<? extends Event> actualFindEventsResult = jpaBaseEventDao.findEvents(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, EventType.ERROR, new TimePageLink(3));

    // Assert
    verify(errorEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEventsResult.getTotalElements());
    assertEquals(1, actualFindEventsResult.getTotalPages());
    assertFalse(actualFindEventsResult.hasNext());
    assertTrue(actualFindEventsResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   * with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink() {
    // Arrange
    when(errorEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<? extends Event> actualFindEventByFilterResult = jpaBaseEventDao
        .findEventByFilter(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, new TimePageLink(3));

    // Assert
    verify(errorEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test
   * {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   * with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink2() {
    // Arrange
    when(lifecycleEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenThrow(new RuntimeException("foo"));
    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.findEventByFilter(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, eventFilter, new TimePageLink(3)));
    verify(lifecycleEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(),
        isA(Pageable.class));
  }

  /**
   * Test
   * {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   * with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_thenReturnDataSizeIsOne() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<ErrorEventEntity> content = new ArrayList<>();
    content.add(errorEventEntity);
    PageImpl<ErrorEventEntity> pageImpl = new PageImpl<>(content);
    when(errorEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenReturn(pageImpl);
    UUID entityId = ModelConstants.NULL_UUID;
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<? extends Event> actualFindEventByFilterResult = jpaBaseEventDao
        .findEventByFilter(ModelConstants.NULL_UUID, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(errorEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    List<? extends Event> data = actualFindEventByFilterResult.getData();
    assertEquals(1, data.size());
    Event getResult = data.get(0);
    assertTrue(getResult instanceof ErrorEvent);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", getResult.getServiceId());
    assertEquals("An error occurred", ((ErrorEvent) getResult).getError());
    assertEquals("Method", ((ErrorEvent) getResult).getMethod());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.ERROR, getResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, getResult.getEntityId());
    assertSame(entityId, getResult.getUuidId());
    assertSame(entityId, getResult.getId().getId());
  }

  /**
   * Test
   * {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   * with {@code tenantId}, {@code entityId}, {@code eventFilter},
   * {@code startTime}, {@code endTime}.
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime() {
    // Arrange
    doNothing().when(errorEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act
    jpaBaseEventDao.removeEvents(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, new ErrorEventFilter(), 1L, 1L);

    // Assert that nothing has changed
    verify(errorEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test
   * {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   * with {@code tenantId}, {@code entityId}, {@code eventFilter},
   * {@code startTime}, {@code endTime}.
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime2() {
    // Arrange
    doThrow(new RuntimeException("foo")).when(lifecycleEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.removeEvents(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, new LifeCycleEventFilter(), 1L, 1L));
    verify(lifecycleEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)} with
   * {@code tenantId}, {@code entityId}, {@code startTime}, {@code endTime}.
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)}
   */
  @Test
  public void testRemoveEventsWithTenantIdEntityIdStartTimeEndTime() {
    // Arrange
    doNothing().when(lifecycleEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing().when(statisticsEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing().when(errorEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing().when(ruleNodeDebugEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing().when(ruleChainDebugEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act
    jpaBaseEventDao.removeEvents(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, 1L, 1L);

    // Assert
    verify(errorEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(lifecycleEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(ruleChainDebugEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(ruleNodeDebugEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(statisticsEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)} with
   * {@code tenantId}, {@code entityId}, {@code startTime}, {@code endTime}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)}
   */
  @Test
  public void testRemoveEventsWithTenantIdEntityIdStartTimeEndTime_thenThrowRuntimeException() {
    // Arrange
    doNothing().when(lifecycleEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing().when(statisticsEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing().when(errorEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing().when(ruleNodeDebugEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doThrow(new RuntimeException("[{}][{}] Remove events [{}-{}] ")).when(ruleChainDebugEventRepository)
        .removeEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> jpaBaseEventDao.removeEvents(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, 1L, 1L));
    verify(errorEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(lifecycleEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(ruleChainDebugEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(ruleNodeDebugEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(statisticsEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}.
   * <ul>
   *   <li>Given {@link ErrorEventEntity#ErrorEventEntity()} CreatedTime is
   * one.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}
   */
  @Test
  public void testFindLatestEvents_givenErrorEventEntityCreatedTimeIsOne_thenReturnSizeIsOne() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(ModelConstants.NULL_UUID);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<ErrorEventEntity> errorEventEntityList = new ArrayList<>();
    errorEventEntityList.add(errorEventEntity);
    when(errorEventRepository.findLatestEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), anyInt()))
        .thenReturn(errorEventEntityList);
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    List<? extends Event> actualFindLatestEventsResult = jpaBaseEventDao.findLatestEvents(ModelConstants.NULL_UUID,
        entityId, EventType.ERROR, 1);

    // Assert
    verify(errorEventRepository).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    Event getResult = actualFindLatestEventsResult.get(0);
    assertTrue(getResult instanceof ErrorEvent);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("42", getResult.getServiceId());
    assertEquals("An error occurred", ((ErrorEvent) getResult).getError());
    assertEquals("Method", ((ErrorEvent) getResult).getMethod());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.ERROR, getResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, getResult.getEntityId());
    assertSame(entityId, getResult.getUuidId());
    assertSame(entityId, getResult.getId().getId());
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}.
   * <ul>
   *   <li>Given {@link LifecycleEventRepository}.</li>
   *   <li>When {@code ERROR}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}
   */
  @Test
  public void testFindLatestEvents_givenLifecycleEventRepository_whenError_thenReturnEmpty() {
    // Arrange
    when(errorEventRepository.findLatestEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<? extends Event> actualFindLatestEventsResult = jpaBaseEventDao.findLatestEvents(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, EventType.ERROR, 1);

    // Assert
    verify(errorEventRepository).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(1));
    assertTrue(actualFindLatestEventsResult.isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}
   */
  @Test
  public void testFindLatestEvents_thenThrowRuntimeException() {
    // Arrange
    when(lifecycleEventRepository.findLatestEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), anyInt()))
        .thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.findLatestEvents(ModelConstants.NULL_UUID,
        ModelConstants.NULL_UUID, EventType.LC_EVENT, 1));
    verify(lifecycleEventRepository).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(1));
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}
   */
  @Test
  public void testFindLatestDebugRuleNodeInEvent_thenReturnNull() {
    // Arrange
    Optional<RuleNodeDebugEventEntity> emptyResult = Optional.empty();
    when(ruleNodeDebugEventRepository.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(emptyResult);

    // Act
    Event actualFindLatestDebugRuleNodeInEventResult = jpaBaseEventDao
        .findLatestDebugRuleNodeInEvent(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(ruleNodeDebugEventRepository).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    assertNull(actualFindLatestDebugRuleNodeInEventResult);
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@link RuleNodeDebugEvent}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}
   */
  @Test
  public void testFindLatestDebugRuleNodeInEvent_thenReturnRuleNodeDebugEvent() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = mock(RuleNodeDebugEventEntity.class);
    RuleNodeDebugEvent buildResult = RuleNodeDebugEvent.builder()
        .data("Data")
        .dataType("Data Type")
        .entityId(ModelConstants.NULL_UUID)
        .error("An error occurred")
        .eventEntity(BaseEntityService.NULL_CUSTOMER_ID)
        .eventType("Event Type")
        .id(ModelConstants.NULL_UUID)
        .metadata("Metadata")
        .msgId(ModelConstants.NULL_UUID)
        .msgType("Msg Type")
        .relationType("Relation Type")
        .serviceId("42")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .ts(1L)
        .build();
    when(ruleNodeDebugEventEntity.toData()).thenReturn(buildResult);
    doNothing().when(ruleNodeDebugEventEntity).setCreatedTime(anyLong());
    doNothing().when(ruleNodeDebugEventEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(ruleNodeDebugEventEntity).setId(Mockito.<UUID>any());
    doNothing().when(ruleNodeDebugEventEntity).setServiceId(Mockito.<String>any());
    doNothing().when(ruleNodeDebugEventEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(ruleNodeDebugEventEntity).setTs(anyLong());
    doNothing().when(ruleNodeDebugEventEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(ruleNodeDebugEventEntity).setData(Mockito.<String>any());
    doNothing().when(ruleNodeDebugEventEntity).setDataType(Mockito.<String>any());
    doNothing().when(ruleNodeDebugEventEntity).setError(Mockito.<String>any());
    doNothing().when(ruleNodeDebugEventEntity).setEventEntityId(Mockito.<UUID>any());
    doNothing().when(ruleNodeDebugEventEntity).setEventEntityType(Mockito.<String>any());
    doNothing().when(ruleNodeDebugEventEntity).setEventType(Mockito.<String>any());
    doNothing().when(ruleNodeDebugEventEntity).setMetadata(Mockito.<String>any());
    doNothing().when(ruleNodeDebugEventEntity).setMsgId(Mockito.<UUID>any());
    doNothing().when(ruleNodeDebugEventEntity).setMsgType(Mockito.<String>any());
    doNothing().when(ruleNodeDebugEventEntity).setRelationType(Mockito.<String>any());
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    ruleNodeDebugEventEntity.setTenantId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<RuleNodeDebugEventEntity> ofResult = Optional.of(ruleNodeDebugEventEntity);
    when(ruleNodeDebugEventRepository.findLatestDebugRuleNodeInEvent(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ofResult);
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    Event actualFindLatestDebugRuleNodeInEventResult = jpaBaseEventDao
        .findLatestDebugRuleNodeInEvent(ModelConstants.NULL_UUID, entityId);

    // Assert
    verify(ruleNodeDebugEventEntity).setCreatedTime(eq(1L));
    verify(ruleNodeDebugEventEntity).setEntityId(isA(UUID.class));
    verify(ruleNodeDebugEventEntity).setId(isA(UUID.class));
    verify(ruleNodeDebugEventEntity).setServiceId(eq("42"));
    verify(ruleNodeDebugEventEntity).setTenantId(isA(UUID.class));
    verify(ruleNodeDebugEventEntity).setTs(eq(1L));
    verify(ruleNodeDebugEventEntity).setUuid(isA(UUID.class));
    verify(ruleNodeDebugEventEntity).setData(eq("Data"));
    verify(ruleNodeDebugEventEntity).setDataType(eq("Data Type"));
    verify(ruleNodeDebugEventEntity).setError(eq("An error occurred"));
    verify(ruleNodeDebugEventEntity).setEventEntityId(isA(UUID.class));
    verify(ruleNodeDebugEventEntity).setEventEntityType(eq("Event Entity Type"));
    verify(ruleNodeDebugEventEntity).setEventType(eq("Event Type"));
    verify(ruleNodeDebugEventEntity).setMetadata(eq("Metadata"));
    verify(ruleNodeDebugEventEntity).setMsgId(isA(UUID.class));
    verify(ruleNodeDebugEventEntity).setMsgType(eq("Msg Type"));
    verify(ruleNodeDebugEventEntity).setRelationType(eq("Relation Type"));
    verify(ruleNodeDebugEventEntity).toData();
    verify(ruleNodeDebugEventRepository).findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindLatestDebugRuleNodeInEventResult instanceof RuleNodeDebugEvent);
    EntityId eventEntity = ((RuleNodeDebugEvent) actualFindLatestDebugRuleNodeInEventResult).getEventEntity();
    assertTrue(eventEntity instanceof CustomerId);
    TenantId tenantId = actualFindLatestDebugRuleNodeInEventResult.getTenantId();
    UUID id = tenantId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id.toString());
    assertEquals("42", actualFindLatestDebugRuleNodeInEventResult.getServiceId());
    assertEquals("An error occurred", ((RuleNodeDebugEvent) actualFindLatestDebugRuleNodeInEventResult).getError());
    assertEquals("Data Type", ((RuleNodeDebugEvent) actualFindLatestDebugRuleNodeInEventResult).getDataType());
    assertEquals("Data", ((RuleNodeDebugEvent) actualFindLatestDebugRuleNodeInEventResult).getData());
    assertEquals("Event Type", ((RuleNodeDebugEvent) actualFindLatestDebugRuleNodeInEventResult).getEventType());
    assertEquals("Metadata", ((RuleNodeDebugEvent) actualFindLatestDebugRuleNodeInEventResult).getMetadata());
    assertEquals("Msg Type", ((RuleNodeDebugEvent) actualFindLatestDebugRuleNodeInEventResult).getMsgType());
    assertEquals("Relation Type", ((RuleNodeDebugEvent) actualFindLatestDebugRuleNodeInEventResult).getRelationType());
    assertEquals(1L, actualFindLatestDebugRuleNodeInEventResult.getCreatedTime());
    assertEquals(EntityType.CUSTOMER, eventEntity.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EventType.DEBUG_RULE_NODE, actualFindLatestDebugRuleNodeInEventResult.getType());
    assertTrue(tenantId.isNullUid());
    assertTrue(eventEntity.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(id, eventEntity.getId());
    assertSame(entityId, actualFindLatestDebugRuleNodeInEventResult.getEntityId());
    assertSame(entityId, ((RuleNodeDebugEvent) actualFindLatestDebugRuleNodeInEventResult).getMsgId());
    assertSame(entityId, actualFindLatestDebugRuleNodeInEventResult.getUuidId());
    assertSame(entityId, actualFindLatestDebugRuleNodeInEventResult.getId().getId());
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with
   * {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(1L);

    // Act
    jpaBaseEventDao.cleanupEvents(1L, 1L, true);

    // Assert that nothing has changed
    verify(eventPartitionConfiguration, atLeast(1)).getPartitionSizeInMs(Mockito.<EventType>any());
    verify(sqlPartitioningRepository, atLeast(1)).dropPartitionsBefore(Mockito.<String>any(), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with
   * {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb2() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong()))
        .thenThrow(new RuntimeException("Going to cleanup regular events with exp time: {}"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.cleanupEvents(1L, 1L, true));
    verify(eventPartitionConfiguration).getPartitionSizeInMs(eq(EventType.ERROR));
    verify(sqlPartitioningRepository).dropPartitionsBefore(eq("error_event"), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with
   * {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb3() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(1L);

    // Act
    jpaBaseEventDao.cleanupEvents(0L, 1L, true);

    // Assert that nothing has changed
    verify(eventPartitionConfiguration, atLeast(1)).getPartitionSizeInMs(Mockito.<EventType>any());
    verify(sqlPartitioningRepository, atLeast(1)).dropPartitionsBefore(Mockito.<String>any(), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with
   * {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb4() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(1L);

    // Act
    jpaBaseEventDao.cleanupEvents(1L, 0L, true);

    // Assert that nothing has changed
    verify(eventPartitionConfiguration, atLeast(1)).getPartitionSizeInMs(Mockito.<EventType>any());
    verify(sqlPartitioningRepository, atLeast(1)).dropPartitionsBefore(Mockito.<String>any(), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with
   * {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb5() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    doNothing().when(sqlPartitioningRepository).cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());

    // Act
    jpaBaseEventDao.cleanupEvents(1L, 1L, false);

    // Assert that nothing has changed
    verify(eventPartitionConfiguration, atLeast(1)).getPartitionSizeInMs(Mockito.<EventType>any());
    verify(sqlPartitioningRepository, atLeast(1)).cleanupPartitionsCache(Mockito.<String>any(), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with
   * {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb6() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    doThrow(new RuntimeException("Going to cleanup regular events with exp time: {}")).when(sqlPartitioningRepository)
        .cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.cleanupEvents(1L, 1L, false));
    verify(eventPartitionConfiguration).getPartitionSizeInMs(eq(EventType.ERROR));
    verify(sqlPartitioningRepository).cleanupPartitionsCache(eq("error_event"), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with
   * {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb7() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    doThrow(new RuntimeException("Going to cleanup regular events with exp time: {}")).when(sqlPartitioningRepository)
        .cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.cleanupEvents(0L, 1L, false));
    verify(eventPartitionConfiguration).getPartitionSizeInMs(eq(EventType.DEBUG_RULE_NODE));
    verify(sqlPartitioningRepository).cleanupPartitionsCache(eq("rule_node_debug_event"), eq(1L), eq(3L));
  }
}
