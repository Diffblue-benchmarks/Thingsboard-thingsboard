package org.thingsboard.server.dao.sql.event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import org.thingsboard.server.common.data.event.DebugEventFilter;
import org.thingsboard.server.common.data.event.ErrorEvent;
import org.thingsboard.server.common.data.event.ErrorEventFilter;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.event.EventFilter;
import org.thingsboard.server.common.data.event.EventType;
import org.thingsboard.server.common.data.event.LifeCycleEventFilter;
import org.thingsboard.server.common.data.event.LifecycleEvent;
import org.thingsboard.server.common.data.event.LifecycleEvent.LifecycleEventBuilder;
import org.thingsboard.server.common.data.event.RuleNodeDebugEventFilter;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.SortOrder.Direction;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.ErrorEventEntity;
import org.thingsboard.server.dao.model.sql.LifecycleEventEntity;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;
import org.thingsboard.server.dao.sqlts.insert.sql.DedicatedEventsSqlPartitioningRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaBaseEventDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
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
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEvents(UUID, UUID, EventType, TimePageLink)"})
  public void testFindEvents() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
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
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> jpaBaseEventDao.findEvents(tenantId, entityId, EventType.ERROR, new TimePageLink(3)));
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   * <ul>
   *   <li>Given {@link ErrorEventEntity#ErrorEventEntity()} CreatedTime is one.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEvents(UUID, UUID, EventType, TimePageLink)"})
  public void testFindEvents_givenErrorEventEntityCreatedTimeIsOne_thenReturnDataSizeIsOne() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    errorEventEntity.setEntityId(entityId);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    errorEventEntity.setUuid(id);

    ArrayList<ErrorEventEntity> content = new ArrayList<>();
    content.add(errorEventEntity);
    when(errorEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(content));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    PageData<? extends Event> actualFindEventsResult = jpaBaseEventDao.findEvents(tenantId, entityId2, EventType.ERROR,
        new TimePageLink(3));

    // Assert
    verify(errorEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    List<? extends Event> data = actualFindEventsResult.getData();
    assertEquals(1, data.size());
    Event getResult = data.get(0);
    assertTrue(getResult instanceof ErrorEvent);
    assertEquals("42", getResult.getServiceId());
    assertEquals("An error occurred", ((ErrorEvent) getResult).getError());
    assertEquals("Method", ((ErrorEvent) getResult).getMethod());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEventsResult.getTotalElements());
    assertEquals(EventType.ERROR, getResult.getType());
    assertSame(entityId, getResult.getEntityId());
    assertSame(id, getResult.getUuidId());
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   * <ul>
   *   <li>Given {@link ErrorEventRepository}.</li>
   *   <li>When {@code LC_EVENT}.</li>
   *   <li>Then calls {@link LifecycleEventRepository#findEvents(UUID, UUID, Long, Long, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEvents(UUID, UUID, EventType, TimePageLink)"})
  public void testFindEvents_givenErrorEventRepository_whenLcEvent_thenCallsFindEvents() {
    // Arrange
    when(lifecycleEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenThrow(new RuntimeException("foo"));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> jpaBaseEventDao.findEvents(tenantId, entityId, EventType.LC_EVENT, new TimePageLink(3)));
    verify(lifecycleEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(),
        isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   * <ul>
   *   <li>Given {@link LifecycleEventRepository}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEvents(UUID, UUID, EventType, TimePageLink)"})
  public void testFindEvents_givenLifecycleEventRepository_thenReturnTotalElementsIsZero() {
    // Arrange
    when(errorEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    PageData<? extends Event> actualFindEventsResult = jpaBaseEventDao.findEvents(tenantId, entityId, EventType.ERROR,
        new TimePageLink(3));

    // Assert
    verify(errorEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEventsResult.getTotalElements());
    assertEquals(1, actualFindEventsResult.getTotalPages());
    assertFalse(actualFindEventsResult.hasNext());
    assertTrue(actualFindEventsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@link TimePageLink} {@link PageLink#getPage()} return one.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEvents(UUID, UUID, EventType, TimePageLink)"})
  public void testFindEvents_givenOne_whenTimePageLinkGetPageReturnOne_thenCallsGetPage() {
    // Arrange
    when(lifecycleEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenThrow(new RuntimeException("foo"));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.by(new ArrayList<>()));
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> jpaBaseEventDao.findEvents(tenantId, entityId, EventType.LC_EVENT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(lifecycleEventRepository).findEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleNodeDebugEventFilter eventFilter = new RuleNodeDebugEventFilter();
    eventFilter.setDataSearch("Data Search");
    eventFilter.setEntityType("Entity Type");
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setIsError(true);
    eventFilter.setMetadataSearch("Metadata Search");
    eventFilter.setMsgDirectionType("Msg Direction Type");
    eventFilter.setMsgType("Msg Type");
    eventFilter.setRelationType("Relation Type");
    eventFilter.setServer("Server");
    eventFilter.setMsgId("");
    eventFilter.setEntityId("Event Filter");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> jpaBaseEventDao.findEventByFilter(tenantId, entityId, eventFilter, new TimePageLink(3)));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink2() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleNodeDebugEventFilter eventFilter = new RuleNodeDebugEventFilter();
    eventFilter.setDataSearch("Data Search");
    eventFilter.setEntityType("Entity Type");
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setIsError(true);
    eventFilter.setMetadataSearch("Metadata Search");
    eventFilter.setMsgDirectionType("Msg Direction Type");
    eventFilter.setMsgType("Msg Type");
    eventFilter.setRelationType("Relation Type");
    eventFilter.setServer("Server");
    eventFilter.setMsgId("Event Filter");
    eventFilter.setEntityId("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> jpaBaseEventDao.findEventByFilter(tenantId, entityId, eventFilter, new TimePageLink(3)));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink3() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleNodeDebugEventFilter eventFilter = new RuleNodeDebugEventFilter();
    eventFilter.setDataSearch("Data Search");
    eventFilter.setEntityType("Entity Type");
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setIsError(true);
    eventFilter.setMetadataSearch("Metadata Search");
    eventFilter.setMsgDirectionType("Msg Direction Type");
    eventFilter.setMsgType("Msg Type");
    eventFilter.setRelationType("Relation Type");
    eventFilter.setServer("Server");
    eventFilter.setMsgId("Event Filter");
    eventFilter.setEntityId(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> jpaBaseEventDao.findEventByFilter(tenantId, entityId, eventFilter, new TimePageLink(3)));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink4() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<ErrorEventEntity> content = new ArrayList<>();
    content.add(errorEventEntity);
    when(errorEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(content));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<? extends Event> actualFindEventByFilterResult = jpaBaseEventDao.findEventByFilter(tenantId, entityId,
        eventFilter, new TimePageLink(3));

    // Assert
    verify(errorEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    List<? extends Event> data = actualFindEventByFilterResult.getData();
    assertEquals(1, data.size());
    Event getResult = data.get(0);
    assertTrue(getResult instanceof ErrorEvent);
    assertEquals("42", getResult.getServiceId());
    assertEquals("An error occurred", ((ErrorEvent) getResult).getError());
    assertEquals("Method", ((ErrorEvent) getResult).getMethod());
    assertEquals(1L, getResult.getCreatedTime());
    assertEquals(1L, actualFindEventByFilterResult.getTotalElements());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink5() {
    // Arrange
    when(lifecycleEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<String>any(), Mockito.<String>any(), anyBoolean(), anyBoolean(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus(null);

    // Act
    PageData<? extends Event> actualFindEventByFilterResult = jpaBaseEventDao.findEventByFilter(tenantId, entityId,
        eventFilter, new TimePageLink(3));

    // Assert
    verify(lifecycleEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), eq("Server"),
        eq("Event"), eq(false), eq(false), eq("An error occurred"), isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink6() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
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
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> jpaBaseEventDao.findEventByFilter(tenantId, entityId, eventFilter, new TimePageLink(3)));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink7() {
    // Arrange
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<String>any(), Mockito.<String>any(), anyBoolean(), anyBoolean(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenThrow(new RuntimeException("foo"));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository = mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository = mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEventDao jpaBaseEventDao = new JpaBaseEventDao(partitionConfiguration, partitioningRepository,
        lcEventRepository, statsEventRepository, errorEventRepository, eventInsertRepository,
        ruleNodeDebugEventRepository, ruleChainDebugEventRepository, logExecutor, new DefaultStatsFactory());
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus(null);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> jpaBaseEventDao.findEventByFilter(tenantId, entityId, eventFilter, new TimePageLink(3)));
    verify(lcEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), eq("Server"),
        eq("Event"), eq(false), eq(false), eq("An error occurred"), isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink8() {
    // Arrange
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository = mock(RuleNodeDebugEventRepository.class);
    when(ruleNodeDebugEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), anyBoolean(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenThrow(new RuntimeException("Entity Id"));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository = mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEventDao jpaBaseEventDao = new JpaBaseEventDao(partitionConfiguration, partitioningRepository,
        lcEventRepository, statsEventRepository, errorEventRepository, eventInsertRepository,
        ruleNodeDebugEventRepository, ruleChainDebugEventRepository, logExecutor, new DefaultStatsFactory());
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleNodeDebugEventFilter eventFilter = new RuleNodeDebugEventFilter();
    eventFilter.setDataSearch("Data Search");
    eventFilter.setEntityType("Entity Type");
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setIsError(true);
    eventFilter.setMetadataSearch("Metadata Search");
    eventFilter.setMsgDirectionType("Msg Direction Type");
    eventFilter.setMsgType("Msg Type");
    eventFilter.setRelationType("Relation Type");
    eventFilter.setServer("Server");
    eventFilter.setMsgId("");
    eventFilter.setEntityId("");

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> jpaBaseEventDao.findEventByFilter(tenantId, entityId, eventFilter, new TimePageLink(3)));
    verify(ruleNodeDebugEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), eq("Server"),
        eq("Msg Direction Type"), eq(""), eq("Entity Type"), eq(""), eq("Msg Type"), eq("Relation Type"),
        eq("Data Search"), eq("Metadata Search"), eq(true), eq("An error occurred"), isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink9() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = mock(LifecycleEventEntity.class);
    LifecycleEventBuilder builderResult = LifecycleEvent.builder();
    LifecycleEventBuilder errorResult = builderResult.entityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .error("An error occurred");
    LifecycleEvent buildResult = errorResult.id(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .lcEventType("Lc Event Type")
        .serviceId("42")
        .success(true)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .ts(1L)
        .build();
    when(lifecycleEventEntity.toData()).thenReturn(buildResult);
    doNothing().when(lifecycleEventEntity).setCreatedTime(anyLong());
    doNothing().when(lifecycleEventEntity).setEntityId(Mockito.<UUID>any());
    doNothing().when(lifecycleEventEntity).setId(Mockito.<UUID>any());
    doNothing().when(lifecycleEventEntity).setServiceId(Mockito.<String>any());
    doNothing().when(lifecycleEventEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(lifecycleEventEntity).setTs(anyLong());
    doNothing().when(lifecycleEventEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(lifecycleEventEntity).setError(Mockito.<String>any());
    doNothing().when(lifecycleEventEntity).setEventType(Mockito.<String>any());
    doNothing().when(lifecycleEventEntity).setSuccess(anyBoolean());
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<LifecycleEventEntity> content = new ArrayList<>();
    content.add(lifecycleEventEntity);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<String>any(), Mockito.<String>any(), anyBoolean(), anyBoolean(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(content));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository = mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository = mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEventDao jpaBaseEventDao = new JpaBaseEventDao(partitionConfiguration, partitioningRepository,
        lcEventRepository, statsEventRepository, errorEventRepository, eventInsertRepository,
        ruleNodeDebugEventRepository, ruleChainDebugEventRepository, logExecutor, new DefaultStatsFactory());
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus(null);

    // Act
    PageData<? extends Event> actualFindEventByFilterResult = jpaBaseEventDao.findEventByFilter(tenantId, entityId,
        eventFilter, new TimePageLink(3));

    // Assert
    verify(lifecycleEventEntity).setCreatedTime(eq(1L));
    verify(lifecycleEventEntity).setEntityId(isA(UUID.class));
    verify(lifecycleEventEntity).setId(isA(UUID.class));
    verify(lifecycleEventEntity).setServiceId(eq("42"));
    verify(lifecycleEventEntity).setTenantId(isA(UUID.class));
    verify(lifecycleEventEntity).setTs(eq(1L));
    verify(lifecycleEventEntity).setUuid(isA(UUID.class));
    verify(lifecycleEventEntity).setError(eq("An error occurred"));
    verify(lifecycleEventEntity).setEventType(eq("Event Type"));
    verify(lifecycleEventEntity).setSuccess(eq(true));
    verify(lifecycleEventEntity).toData();
    verify(lcEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), eq("Server"),
        eq("Event"), eq(false), eq(false), eq("An error occurred"), isA(Pageable.class));
    List<? extends Event> data = actualFindEventByFilterResult.getData();
    assertEquals(1, data.size());
    Event getResult = data.get(0);
    assertTrue(getResult instanceof LifecycleEvent);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertEquals("Lc Event Type", ((LifecycleEvent) getResult).getLcEventType());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <ul>
   *   <li>Given {@code Status}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_givenStatus() {
    // Arrange
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<String>any(), Mockito.<String>any(), anyBoolean(), anyBoolean(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository = mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository = mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEventDao jpaBaseEventDao = new JpaBaseEventDao(partitionConfiguration, partitioningRepository,
        lcEventRepository, statsEventRepository, errorEventRepository, eventInsertRepository,
        ruleNodeDebugEventRepository, ruleChainDebugEventRepository, logExecutor, new DefaultStatsFactory());
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("Status");

    // Act
    PageData<? extends Event> actualFindEventByFilterResult = jpaBaseEventDao.findEventByFilter(tenantId, entityId,
        eventFilter, new TimePageLink(3));

    // Assert
    verify(lcEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), eq("Server"),
        eq("Event"), eq(true), eq(false), eq("An error occurred"), isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <ul>
   *   <li>Given {@code Success}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_givenSuccess() {
    // Arrange
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<String>any(), Mockito.<String>any(), anyBoolean(), anyBoolean(),
        Mockito.<String>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository = mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository = mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEventDao jpaBaseEventDao = new JpaBaseEventDao(partitionConfiguration, partitioningRepository,
        lcEventRepository, statsEventRepository, errorEventRepository, eventInsertRepository,
        ruleNodeDebugEventRepository, ruleChainDebugEventRepository, logExecutor, new DefaultStatsFactory());
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("Success");

    // Act
    PageData<? extends Event> actualFindEventByFilterResult = jpaBaseEventDao.findEventByFilter(tenantId, entityId,
        eventFilter, new TimePageLink(3));

    // Assert
    verify(lcEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), eq("Server"),
        eq("Event"), eq(true), eq(true), eq("An error occurred"), isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <ul>
   *   <li>Then calls {@link ErrorEventRepository#findEvents(UUID, UUID, Long, Long, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_thenCallsFindEvents() {
    // Arrange
    when(errorEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<? extends Event> actualFindEventByFilterResult = jpaBaseEventDao.findEventByFilter(tenantId, entityId,
        eventFilter, new TimePageLink(3));

    // Assert
    verify(errorEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <ul>
   *   <li>Then calls {@link LifecycleEventRepository#findEvents(UUID, UUID, Long, Long, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_thenCallsFindEvents2() {
    // Arrange
    when(lifecycleEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenThrow(new RuntimeException("foo"));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> jpaBaseEventDao.findEventByFilter(tenantId, entityId, eventFilter, new TimePageLink(3)));
    verify(lifecycleEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(),
        isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <ul>
   *   <li>Then calls {@link RuleNodeDebugEventRepository#findEvents(UUID, UUID, Long, Long, String, String, String, String, String, String, String, String, String, boolean, String, Pageable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_thenCallsFindEvents3() {
    // Arrange
    when(ruleNodeDebugEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(), Mockito.<String>any(),
        Mockito.<String>any(), anyBoolean(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    RuleNodeDebugEventFilter eventFilter = new RuleNodeDebugEventFilter();
    eventFilter.setDataSearch("Data Search");
    eventFilter.setEntityType("Entity Type");
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setIsError(true);
    eventFilter.setMetadataSearch("Metadata Search");
    eventFilter.setMsgDirectionType("Msg Direction Type");
    eventFilter.setMsgType("Msg Type");
    eventFilter.setRelationType("Relation Type");
    eventFilter.setServer("Server");
    eventFilter.setMsgId("");
    eventFilter.setEntityId("");

    // Act
    PageData<? extends Event> actualFindEventByFilterResult = jpaBaseEventDao.findEventByFilter(tenantId, entityId,
        eventFilter, new TimePageLink(3));

    // Assert
    verify(ruleNodeDebugEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), eq("Server"),
        eq("Msg Direction Type"), eq(""), eq("Entity Type"), eq(""), eq("Msg Type"), eq("Relation Type"),
        eq("Data Search"), eq("Metadata Search"), eq(true), eq("An error occurred"), isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <ul>
   *   <li>Then calls {@link DebugEventFilter#setErrorStr(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_thenCallsSetErrorStr() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    RuleNodeDebugEventFilter eventFilter = mock(RuleNodeDebugEventFilter.class);
    when(eventFilter.getEntityId()).thenReturn("42");
    when(eventFilter.isNotEmpty()).thenReturn(true);
    when(eventFilter.getEventType()).thenReturn(EventType.DEBUG_RULE_NODE);
    doNothing().when(eventFilter).setErrorStr(Mockito.<String>any());
    doNothing().when(eventFilter).setIsError(anyBoolean());
    doNothing().when(eventFilter).setServer(Mockito.<String>any());
    doNothing().when(eventFilter).setDataSearch(Mockito.<String>any());
    doNothing().when(eventFilter).setEntityId(Mockito.<String>any());
    doNothing().when(eventFilter).setEntityType(Mockito.<String>any());
    doNothing().when(eventFilter).setMetadataSearch(Mockito.<String>any());
    doNothing().when(eventFilter).setMsgDirectionType(Mockito.<String>any());
    doNothing().when(eventFilter).setMsgId(Mockito.<String>any());
    doNothing().when(eventFilter).setMsgType(Mockito.<String>any());
    doNothing().when(eventFilter).setRelationType(Mockito.<String>any());
    eventFilter.setDataSearch("Data Search");
    eventFilter.setEntityType("Entity Type");
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setIsError(true);
    eventFilter.setMetadataSearch("Metadata Search");
    eventFilter.setMsgDirectionType("Msg Direction Type");
    eventFilter.setMsgType("Msg Type");
    eventFilter.setRelationType("Relation Type");
    eventFilter.setServer("Server");
    eventFilter.setMsgId("");
    eventFilter.setEntityId("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> jpaBaseEventDao.findEventByFilter(tenantId, entityId, eventFilter, new TimePageLink(3)));
    verify(eventFilter).setErrorStr(eq("An error occurred"));
    verify(eventFilter).setIsError(eq(true));
    verify(eventFilter).setServer(eq("Server"));
    verify(eventFilter).getEntityId();
    verify(eventFilter).getEventType();
    verify(eventFilter).isNotEmpty();
    verify(eventFilter).setDataSearch(eq("Data Search"));
    verify(eventFilter).setEntityId(eq(""));
    verify(eventFilter).setEntityType(eq("Entity Type"));
    verify(eventFilter).setMetadataSearch(eq("Metadata Search"));
    verify(eventFilter).setMsgDirectionType(eq("Msg Direction Type"));
    verify(eventFilter).setMsgId(eq(""));
    verify(eventFilter).setMsgType(eq("Msg Type"));
    verify(eventFilter).setRelationType(eq("Relation Type"));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   * <ul>
   *   <li>Then return Data size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"})
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_thenReturnDataSizeIsTwo() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    errorEventEntity.setEntityId(entityId);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    errorEventEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity.setTs(1L);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    errorEventEntity.setUuid(id);

    ErrorEventEntity errorEventEntity2 = new ErrorEventEntity();
    errorEventEntity2.setCreatedTime(0L);
    errorEventEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setError("Error");
    errorEventEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setMethod("org.thingsboard.server.dao.model.sql.ErrorEventEntity");
    errorEventEntity2.setServiceId("Service Id");
    errorEventEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    errorEventEntity2.setTs(0L);
    errorEventEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<ErrorEventEntity> content = new ArrayList<>();
    content.add(errorEventEntity2);
    content.add(errorEventEntity);
    when(errorEventRepository.findEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<Pageable>any())).thenReturn(new PageImpl<>(content));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID entityId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<? extends Event> actualFindEventByFilterResult = jpaBaseEventDao.findEventByFilter(tenantId, entityId2,
        eventFilter, new TimePageLink(3));

    // Assert
    verify(errorEventRepository).findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    List<? extends Event> data = actualFindEventByFilterResult.getData();
    assertEquals(2, data.size());
    Event getResult = data.get(0);
    assertTrue(getResult instanceof ErrorEvent);
    Event getResult2 = data.get(1);
    assertTrue(getResult2 instanceof ErrorEvent);
    assertEquals("42", getResult2.getServiceId());
    assertEquals("An error occurred", ((ErrorEvent) getResult2).getError());
    assertEquals("Error", ((ErrorEvent) getResult).getError());
    assertEquals("Method", ((ErrorEvent) getResult2).getMethod());
    assertEquals("Service Id", getResult.getServiceId());
    assertEquals("org.thingsboard.server.dao.model.sql.ErrorEventEntity", ((ErrorEvent) getResult).getMethod());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(1L, getResult2.getCreatedTime());
    assertEquals(2L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(EventType.ERROR, getResult2.getType());
    assertSame(entityId, getResult2.getEntityId());
    assertSame(id, getResult2.getUuidId());
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(1L);

    // Act
    jpaBaseEventDao.cleanupEvents(1L, 1L, true);

    // Assert
    verify(eventPartitionConfiguration, atLeast(1)).getPartitionSizeInMs(Mockito.<EventType>any());
    verify(sqlPartitioningRepository, atLeast(1)).dropPartitionsBefore(Mockito.<String>any(), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
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
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb3() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    doNothing().when(sqlPartitioningRepository).cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());

    // Act
    jpaBaseEventDao.cleanupEvents(1L, 1L, false);

    // Assert
    verify(eventPartitionConfiguration, atLeast(1)).getPartitionSizeInMs(Mockito.<EventType>any());
    verify(sqlPartitioningRepository, atLeast(1)).cleanupPartitionsCache(Mockito.<String>any(), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb4() {
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
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb5() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    doThrow(new RuntimeException("Going to cleanup regular events with exp time: {}")).when(sqlPartitioningRepository)
        .cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.cleanupEvents(0L, 1L, false));
    verify(eventPartitionConfiguration).getPartitionSizeInMs(eq(EventType.DEBUG_RULE_NODE));
    verify(sqlPartitioningRepository).cleanupPartitionsCache(eq("rule_node_debug_event"), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb6() {
    // Arrange
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    when(partitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(1L);
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository = mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository = mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    // Act
    (new JpaBaseEventDao(partitionConfiguration, partitioningRepository, lcEventRepository, statsEventRepository,
        errorEventRepository, eventInsertRepository, ruleNodeDebugEventRepository, ruleChainDebugEventRepository,
        logExecutor, new DefaultStatsFactory())).cleanupEvents(1L, 1L, true);

    // Assert
    verify(partitioningRepository, atLeast(1)).dropPartitionsBefore(Mockito.<String>any(), eq(1L), eq(0L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs}, {@code debugEventExpTs}, {@code cleanupDb}.
   * <p>
   * Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb7() {
    // Arrange
    DedicatedEventsSqlPartitioningRepository partitioningRepository = mock(
        DedicatedEventsSqlPartitioningRepository.class);
    doNothing().when(partitioningRepository).cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    DedicatedEventInsertRepository eventInsertRepository = mock(DedicatedEventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository = mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository = mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    // Act
    (new DedicatedJpaEventDao(partitionConfiguration, partitioningRepository, lcEventRepository, statsEventRepository,
        errorEventRepository, eventInsertRepository, ruleNodeDebugEventRepository, ruleChainDebugEventRepository,
        logExecutor, new DefaultStatsFactory())).cleanupEvents(1L, 1L, false);

    // Assert
    verify(partitioningRepository, atLeast(1)).cleanupPartitionsCache(Mockito.<String>any(), eq(1L), eq(0L));
  }
}
