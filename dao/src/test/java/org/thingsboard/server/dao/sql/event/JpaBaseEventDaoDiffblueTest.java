/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
import org.thingsboard.server.common.data.event.ErrorEvent;
import org.thingsboard.server.common.data.event.ErrorEvent.ErrorEventBuilder;
import org.thingsboard.server.common.data.event.ErrorEventFilter;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.event.EventFilter;
import org.thingsboard.server.common.data.event.EventType;
import org.thingsboard.server.common.data.event.LifeCycleEventFilter;
import org.thingsboard.server.common.data.event.LifecycleEvent;
import org.thingsboard.server.common.data.event.RuleNodeDebugEvent;
import org.thingsboard.server.common.data.event.RuleNodeDebugEventFilter;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.ErrorEventEntity;
import org.thingsboard.server.dao.model.sql.LifecycleEventEntity;
import org.thingsboard.server.dao.model.sql.RuleNodeDebugEventEntity;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;
import org.thingsboard.server.dao.sqlts.insert.sql.DedicatedEventsSqlPartitioningRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaBaseEventDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaBaseEventDaoDiffblueTest {
  @MockBean private ErrorEventRepository errorEventRepository;

  @MockBean private EventInsertRepository eventInsertRepository;

  @MockBean private EventPartitionConfiguration eventPartitionConfiguration;

  @Autowired private JpaBaseEventDao jpaBaseEventDao;

  @MockBean private LifecycleEventRepository lifecycleEventRepository;

  @MockBean private RuleChainDebugEventRepository ruleChainDebugEventRepository;

  @MockBean private RuleNodeDebugEventRepository ruleNodeDebugEventRepository;

  @MockBean private ScheduledLogExecutorComponent scheduledLogExecutorComponent;

  @MockBean private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean private StatisticsEventRepository statisticsEventRepository;

  @MockBean private StatsFactory statsFactory;

  /**
   * Test {@link JpaBaseEventDao#saveAsync(Event)}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#saveAsync(Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaBaseEventDao.saveAsync(Event)"
  })
  public void testSaveAsync() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.saveAsync(
                ErrorEvent.builder()
                    .entityId(ModelConstants.NULL_UUID)
                    .error("An error occurred")
                    .id(ModelConstants.NULL_UUID)
                    .method("Method")
                    .serviceId("42")
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .ts(1L)
                    .build()));
    verify(eventPartitionConfiguration).getPartitionSizeInMs(EventType.ERROR);
  }

  /**
   * Test {@link JpaBaseEventDao#saveAsync(Event)}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#saveAsync(Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaBaseEventDao.saveAsync(Event)"
  })
  public void testSaveAsync2() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = mock(EventPartitionConfiguration.class);
    when(partitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any()))
        .thenThrow(new RuntimeException());
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.saveAsync(
                ErrorEvent.builder()
                    .entityId(ModelConstants.NULL_UUID)
                    .error("An error occurred")
                    .id(ModelConstants.NULL_UUID)
                    .method("Method")
                    .serviceId("42")
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .ts(0L)
                    .build()));
    verify(partitionConfiguration).getPartitionSizeInMs(EventType.ERROR);
  }

  /**
   * Test {@link JpaBaseEventDao#saveAsync(Event)}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#saveAsync(Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaBaseEventDao.saveAsync(Event)"
  })
  public void testSaveAsync3() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = mock(EventPartitionConfiguration.class);
    when(partitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any()))
        .thenThrow(new RuntimeException());
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    ErrorEventBuilder errorResult =
        ErrorEvent.builder().entityId(ModelConstants.NULL_UUID).error("An error occurred");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.saveAsync(
                errorResult
                    .id(UUID.randomUUID())
                    .method("Method")
                    .serviceId("42")
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .ts(0L)
                    .build()));
    verify(partitionConfiguration).getPartitionSizeInMs(EventType.ERROR);
  }

  /**
   * Test {@link JpaBaseEventDao#saveAsync(Event)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link Event} {@link Event#getCreatedTime()} return one.
   *   <li>Then calls {@link Event#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#saveAsync(Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaBaseEventDao.saveAsync(Event)"
  })
  public void testSaveAsync_givenOne_whenEventGetCreatedTimeReturnOne_thenCallsGetType() {
    // Arrange
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    doThrow(new RuntimeException())
        .when(partitioningRepository)
        .createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    Event event = mock(Event.class);
    when(event.getCreatedTime()).thenReturn(1L);
    when(event.getType()).thenReturn(EventType.ERROR);
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.saveAsync(event));
    verify(event, atLeast(1)).getCreatedTime();
    verify(event, atLeast(1)).getType();
    verify(event).getId();
    verify(partitioningRepository).createPartitionIfNotExists("error_event", 1L, 0L);
  }

  /**
   * Test {@link JpaBaseEventDao#saveAsync(Event)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link Event} {@link Event#getCreatedTime()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#saveAsync(Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaBaseEventDao.saveAsync(Event)"
  })
  public void testSaveAsync_givenRuntimeException_whenEventGetCreatedTimeThrowRuntimeException() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    Event event = mock(Event.class);
    when(event.getCreatedTime()).thenThrow(new RuntimeException());
    when(event.getId()).thenReturn(new EventId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.saveAsync(event));
    verify(event).getCreatedTime();
    verify(event).getId();
  }

  /**
   * Test {@link JpaBaseEventDao#saveAsync(Event)}.
   *
   * <ul>
   *   <li>Then calls {@link SqlPartitioningRepository#createPartitionIfNotExists(String, long,
   *       long)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#saveAsync(Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaBaseEventDao.saveAsync(Event)"
  })
  public void testSaveAsync_thenCallsCreatePartitionIfNotExists() {
    // Arrange
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    doThrow(new RuntimeException())
        .when(partitioningRepository)
        .createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.saveAsync(
                ErrorEvent.builder()
                    .entityId(ModelConstants.NULL_UUID)
                    .error("An error occurred")
                    .id(ModelConstants.NULL_UUID)
                    .method("Method")
                    .serviceId("42")
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .ts(1L)
                    .build()));
    verify(partitioningRepository).createPartitionIfNotExists("error_event", 1L, 0L);
  }

  /**
   * Test {@link JpaBaseEventDao#saveAsync(Event)}.
   *
   * <ul>
   *   <li>Then calls {@link EventPartitionConfiguration#getPartitionSizeInMs(EventType)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#saveAsync(Event)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaBaseEventDao.saveAsync(Event)"
  })
  public void testSaveAsync_thenCallsGetPartitionSizeInMs() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    doThrow(new RuntimeException())
        .when(sqlPartitioningRepository)
        .createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.saveAsync(
                ErrorEvent.builder()
                    .entityId(ModelConstants.NULL_UUID)
                    .error("An error occurred")
                    .id(ModelConstants.NULL_UUID)
                    .method("Method")
                    .serviceId("42")
                    .tenantId(ModelConstants.SYSTEM_TENANT)
                    .ts(1L)
                    .build()));
    verify(eventPartitionConfiguration).getPartitionSizeInMs(EventType.ERROR);
    verify(sqlPartitioningRepository).createPartitionIfNotExists("error_event", 1L, 3L);
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEvents(UUID, UUID, EventType, TimePageLink)"})
  public void testFindEvents() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findEvents(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                EventType.ERROR,
                new TimePageLink(3)));
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link TimePageLink} {@link TimePageLink#getSortOrder()} return {@code null}.
   *   <li>Then calls {@link TimePageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEvents(UUID, UUID, EventType, TimePageLink)"})
  public void testFindEvents_givenNull_whenTimePageLinkGetSortOrderReturnNull_thenCallsGetPage() {
    // Arrange
    when(errorEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenThrow(new RuntimeException());

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EventType.ERROR, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort((SortOrder) isNull(), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(errorEventRepository)
        .findEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEvents(UUID, UUID, EventType, TimePageLink)"})
  public void testFindEvents_thenReturnTotalElementsIsZero() {
    // Arrange
    when(errorEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<? extends Event> actualFindEventsResult =
        jpaBaseEventDao.findEvents(
            ModelConstants.NULL_UUID,
            ModelConstants.NULL_UUID,
            EventType.ERROR,
            new TimePageLink(3));

    // Assert
    verify(errorEventRepository)
        .findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEventsResult.getTotalElements());
    assertEquals(1, actualFindEventsResult.getTotalPages());
    assertFalse(actualFindEventsResult.hasNext());
    assertTrue(actualFindEventsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEvents(UUID, UUID, EventType, TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData JpaBaseEventDao.findEvents(UUID, UUID, EventType, TimePageLink)"})
  public void testFindEvents_thenThrowRuntimeException() {
    // Arrange
    when(errorEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findEvents(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                EventType.ERROR,
                new TimePageLink(3)));
    verify(errorEventRepository)
        .findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink() {
    // Arrange
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
    eventFilter.setEntityId("");
    eventFilter.setMsgId("Event Filter");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaBaseEventDao.findEventByFilter(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                eventFilter,
                new TimePageLink(3)));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink2() {
    // Arrange
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
    eventFilter.setEntityId("Event Filter");
    eventFilter.setMsgId("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaBaseEventDao.findEventByFilter(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                eventFilter,
                new TimePageLink(3)));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink3() {
    // Arrange
    when(errorEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenThrow(new RuntimeException());
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findEventByFilter(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                eventFilter,
                new TimePageLink(3)));
    verify(errorEventRepository)
        .findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink4() {
    // Arrange
    when(ruleNodeDebugEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

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
    eventFilter.setEntityId("");
    eventFilter.setMsgId("");

    // Act
    PageData<? extends Event> actualFindEventByFilterResult =
        jpaBaseEventDao.findEventByFilter(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, new TimePageLink(3));

    // Assert
    verify(ruleNodeDebugEventRepository)
        .findEvents(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Server"),
            eq("Msg Direction Type"),
            eq(""),
            eq("Entity Type"),
            eq(""),
            eq("Msg Type"),
            eq("Relation Type"),
            eq("Data Search"),
            eq("Metadata Search"),
            eq(true),
            eq("An error occurred"),
            isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink5() {
    // Arrange
    when(ruleNodeDebugEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenThrow(new RuntimeException());

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
    eventFilter.setEntityId("");
    eventFilter.setMsgId("");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findEventByFilter(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                eventFilter,
                new TimePageLink(3)));
    verify(ruleNodeDebugEventRepository)
        .findEvents(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Server"),
            eq("Msg Direction Type"),
            eq(""),
            eq("Entity Type"),
            eq(""),
            eq("Msg Type"),
            eq("Relation Type"),
            eq("Data Search"),
            eq("Metadata Search"),
            eq(true),
            eq("An error occurred"),
            isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink6() {
    // Arrange
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("");

    // Act
    PageData<? extends Event> actualFindEventByFilterResult =
        jpaBaseEventDao.findEventByFilter(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, new TimePageLink(3));

    // Assert
    verify(lcEventRepository)
        .findEvents(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Server"),
            eq("Event"),
            eq(false),
            eq(false),
            eq("An error occurred"),
            isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink7() {
    // Arrange
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenThrow(new RuntimeException());
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findEventByFilter(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                eventFilter,
                new TimePageLink(3)));
    verify(lcEventRepository)
        .findEvents(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Server"),
            eq("Event"),
            eq(false),
            eq(false),
            eq("An error occurred"),
            isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink8() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<LifecycleEventEntity> content = new ArrayList<>();
    content.add(lifecycleEventEntity);

    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());
    UUID entityId = ModelConstants.NULL_UUID;

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("");

    // Act
    PageData<? extends Event> actualFindEventByFilterResult =
        jpaBaseEventDao.findEventByFilter(
            ModelConstants.NULL_UUID, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(lcEventRepository)
        .findEvents(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Server"),
            eq("Event"),
            eq(false),
            eq(false),
            eq("An error occurred"),
            isA(Pageable.class));
    List<? extends Event> data = actualFindEventByFilterResult.getData();
    assertEquals(1, data.size());
    Event getResult = data.get(0);
    assertTrue(getResult instanceof LifecycleEvent);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, getResult.getUuidId());
    assertSame(entityId, getResult.getId().getId());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink9() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    UUID tenantId = UUID.randomUUID();
    lifecycleEventEntity.setTenantId(tenantId);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<LifecycleEventEntity> content = new ArrayList<>();
    content.add(lifecycleEventEntity);

    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());
    UUID entityId = ModelConstants.NULL_UUID;

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("");

    // Act
    PageData<? extends Event> actualFindEventByFilterResult =
        jpaBaseEventDao.findEventByFilter(
            ModelConstants.NULL_UUID, entityId, eventFilter, new TimePageLink(3));

    // Assert
    verify(lcEventRepository)
        .findEvents(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Server"),
            eq("Event"),
            eq(false),
            eq(false),
            eq("An error occurred"),
            isA(Pageable.class));
    List<? extends Event> data = actualFindEventByFilterResult.getData();
    assertEquals(1, data.size());
    Event getResult = data.get(0);
    assertTrue(getResult instanceof LifecycleEvent);
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertSame(entityId, getResult.getUuidId());
    assertSame(entityId, getResult.getId().getId());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink10() {
    // Arrange
    LifecycleEventEntity lifecycleEventEntity = new LifecycleEventEntity();
    lifecycleEventEntity.setCreatedTime(1L);
    lifecycleEventEntity.setEntityId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setError("An error occurred");
    lifecycleEventEntity.setEventType("Event Type");
    lifecycleEventEntity.setId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setServiceId("42");
    lifecycleEventEntity.setSuccess(true);
    lifecycleEventEntity.setTenantId(ModelConstants.NULL_UUID);
    lifecycleEventEntity.setTs(1L);
    lifecycleEventEntity.setUuid(null);

    ArrayList<LifecycleEventEntity> content = new ArrayList<>();
    content.add(lifecycleEventEntity);

    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("");

    // Act
    PageData<? extends Event> actualFindEventByFilterResult =
        jpaBaseEventDao.findEventByFilter(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, new TimePageLink(3));

    // Assert
    verify(lcEventRepository)
        .findEvents(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Server"),
            eq("Event"),
            eq(false),
            eq(false),
            eq("An error occurred"),
            isA(Pageable.class));
    List<? extends Event> data = actualFindEventByFilterResult.getData();
    assertEquals(1, data.size());
    Event getResult = data.get(0);
    assertTrue(getResult instanceof LifecycleEvent);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(getResult.getUuidId());
    assertNull(getResult.getId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_givenNull() {
    // Arrange
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
    eventFilter.setEntityId(null);
    eventFilter.setMsgId("Event Filter");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaBaseEventDao.findEventByFilter(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                eventFilter,
                new TimePageLink(3)));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <ul>
   *   <li>Given {@code Status}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_givenStatus() {
    // Arrange
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("Status");

    // Act
    PageData<? extends Event> actualFindEventByFilterResult =
        jpaBaseEventDao.findEventByFilter(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, new TimePageLink(3));

    // Assert
    verify(lcEventRepository)
        .findEvents(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Server"),
            eq("Event"),
            eq(true),
            eq(false),
            eq("An error occurred"),
            isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <ul>
   *   <li>Given {@code Success}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_givenSuccess() {
    // Arrange
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    when(lcEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("Success");

    // Act
    PageData<? extends Event> actualFindEventByFilterResult =
        jpaBaseEventDao.findEventByFilter(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, new TimePageLink(3));

    // Assert
    verify(lcEventRepository)
        .findEvents(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            eq("Server"),
            eq("Event"),
            eq(true),
            eq(true),
            eq("An error occurred"),
            isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <ul>
   *   <li>Then calls {@link ErrorEventRepository#findEvents(UUID, UUID, Long, Long, Pageable)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_thenCallsFindEvents() {
    // Arrange
    when(errorEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act
    PageData<? extends Event> actualFindEventByFilterResult =
        jpaBaseEventDao.findEventByFilter(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, new TimePageLink(3));

    // Assert
    verify(errorEventRepository)
        .findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <ul>
   *   <li>Then calls {@link LifecycleEventRepository#findEvents(UUID, UUID, Long, Long, Pageable)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_thenCallsFindEvents2() {
    // Arrange
    when(lifecycleEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();

    // Act
    PageData<? extends Event> actualFindEventByFilterResult =
        jpaBaseEventDao.findEventByFilter(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, new TimePageLink(3));

    // Assert
    verify(lifecycleEventRepository)
        .findEvents(isA(UUID.class), isA(UUID.class), isNull(), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindEventByFilterResult.getTotalElements());
    assertEquals(1, actualFindEventByFilterResult.getTotalPages());
    assertFalse(actualFindEventByFilterResult.hasNext());
    assertTrue(actualFindEventByFilterResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <ul>
   *   <li>Then calls {@link TimePageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_thenCallsGetPage() {
    // Arrange
    when(ruleNodeDebugEventRepository.findEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<String>any(),
            Mockito.<Pageable>any()))
        .thenThrow(new RuntimeException());

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
    eventFilter.setEntityId("");
    eventFilter.setMsgId("");

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.toSort(
            Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findEventByFilter(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(ruleNodeDebugEventRepository)
        .findEvents(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq("Server"),
            eq("Msg Direction Type"),
            eq(""),
            eq("Entity Type"),
            eq(""),
            eq("Msg Type"),
            eq("Relation Type"),
            eq("Data Search"),
            eq("Metadata Search"),
            eq(true),
            eq("An error occurred"),
            isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter, TimePageLink)} with
   * {@code UUID}, {@code UUID}, {@code EventFilter}, {@code TimePageLink}.
   *
   * <ul>
   *   <li>When {@link ErrorEventFilter} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findEventByFilter(UUID, UUID, EventFilter,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEventDao.findEventByFilter(UUID, UUID, EventFilter, TimePageLink)"
  })
  public void testFindEventByFilterWithUuidUuidEventFilterTimePageLink_whenErrorEventFilter() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());
    ErrorEventFilter eventFilter = new ErrorEventFilter();

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findEventByFilter(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                eventFilter,
                new TimePageLink(3)));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime() {
    // Arrange
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
    eventFilter.setEntityId("");
    eventFilter.setMsgId("Event Filter");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime2() {
    // Arrange
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
    eventFilter.setEntityId("Event Filter");
    eventFilter.setMsgId("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime3() {
    // Arrange
    doNothing()
        .when(errorEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act
    jpaBaseEventDao.removeEvents(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, new ErrorEventFilter(), 1L, 1L);

    // Assert
    verify(errorEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime4() {
    // Arrange
    doThrow(new RuntimeException())
        .when(errorEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                new ErrorEventFilter(),
                1L,
                1L));
    verify(errorEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime5() {
    // Arrange
    doNothing()
        .when(lifecycleEventRepository)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any());

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("");

    // Act
    jpaBaseEventDao.removeEvents(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L);

    // Assert
    verify(lifecycleEventRepository)
        .removeEvents(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq("Server"),
            eq("Event"),
            eq(false),
            eq(false),
            eq("An error occurred"));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime6() {
    // Arrange
    doThrow(new RuntimeException())
        .when(lifecycleEventRepository)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any());

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L));
    verify(lifecycleEventRepository)
        .removeEvents(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq("Server"),
            eq("Event"),
            eq(false),
            eq(false),
            eq("An error occurred"));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime7() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID,
                ModelConstants.NULL_UUID,
                new ErrorEventFilter(),
                1L,
                1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime8() {
    // Arrange
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    doNothing()
        .when(ruleNodeDebugEventRepository)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<String>any());
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

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
    eventFilter.setEntityId("");
    eventFilter.setMsgId("");

    // Act
    jpaBaseEventDao.removeEvents(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L);

    // Assert
    verify(ruleNodeDebugEventRepository)
        .removeEvents(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq("Server"),
            eq("Msg Direction Type"),
            eq(""),
            eq("Entity Type"),
            eq(""),
            eq("Msg Type"),
            eq("Relation Type"),
            eq("Data Search"),
            eq("Metadata Search"),
            eq(true),
            eq("An error occurred"));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime9() {
    // Arrange
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    doThrow(new RuntimeException())
        .when(ruleNodeDebugEventRepository)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            Mockito.<String>any());
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

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
    eventFilter.setEntityId("");
    eventFilter.setMsgId("");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L));
    verify(ruleNodeDebugEventRepository)
        .removeEvents(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq("Server"),
            eq("Msg Direction Type"),
            eq(""),
            eq("Entity Type"),
            eq(""),
            eq("Msg Type"),
            eq("Relation Type"),
            eq("Data Search"),
            eq("Metadata Search"),
            eq(true),
            eq("An error occurred"));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime10() {
    // Arrange
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    doNothing()
        .when(errorEventRepository)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    ErrorEventFilter eventFilter = new ErrorEventFilter();
    eventFilter.setServer("Server");

    // Act
    jpaBaseEventDao.removeEvents(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L);

    // Assert
    verify(errorEventRepository)
        .removeEvents(
            isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), eq("Server"), isNull(), isNull());
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime11() {
    // Arrange
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    doThrow(new RuntimeException())
        .when(errorEventRepository)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    ErrorEventFilter eventFilter = new ErrorEventFilter();
    eventFilter.setServer("Server");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L));
    verify(errorEventRepository)
        .removeEvents(
            isA(UUID.class), isA(UUID.class), eq(1L), eq(1L), eq("Server"), isNull(), isNull());
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime12() {
    // Arrange
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    doNothing()
        .when(errorEventRepository)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            Mockito.<String>any());
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    ErrorEventFilter eventFilter = mock(ErrorEventFilter.class);
    when(eventFilter.getErrorStr()).thenReturn("An error occurred");
    when(eventFilter.getMethod()).thenReturn("Method");
    when(eventFilter.getServer()).thenReturn("Server");
    when(eventFilter.isNotEmpty()).thenReturn(true);
    when(eventFilter.getEventType()).thenReturn(EventType.ERROR);
    doNothing().when(eventFilter).setServer(Mockito.<String>any());
    eventFilter.setServer("Server");

    // Act
    jpaBaseEventDao.removeEvents(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L);

    // Assert
    verify(eventFilter).getErrorStr();
    verify(eventFilter).getEventType();
    verify(eventFilter).getMethod();
    verify(eventFilter).getServer();
    verify(eventFilter).isNotEmpty();
    verify(eventFilter).setServer("Server");
    verify(errorEventRepository)
        .removeEvents(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq("Server"),
            eq("Method"),
            eq("An error occurred"));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime13() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    ErrorEventFilter eventFilter = mock(ErrorEventFilter.class);
    when(eventFilter.getServer()).thenThrow(new RuntimeException());
    when(eventFilter.isNotEmpty()).thenReturn(true);
    when(eventFilter.getEventType()).thenReturn(EventType.ERROR);
    doNothing().when(eventFilter).setServer(Mockito.<String>any());
    eventFilter.setServer("Server");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L));
    verify(eventFilter).getEventType();
    verify(eventFilter).getServer();
    verify(eventFilter).isNotEmpty();
    verify(eventFilter).setServer("Server");
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime_givenNull() {
    // Arrange
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
    eventFilter.setEntityId(null);
    eventFilter.setMsgId("Event Filter");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <ul>
   *   <li>Given {@code Status}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime_givenStatus() {
    // Arrange
    doNothing()
        .when(lifecycleEventRepository)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any());

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("Status");

    // Act
    jpaBaseEventDao.removeEvents(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L);

    // Assert
    verify(lifecycleEventRepository)
        .removeEvents(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq("Server"),
            eq("Event"),
            eq(true),
            eq(false),
            eq("An error occurred"));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)} with {@code
   * tenantId}, {@code entityId}, {@code eventFilter}, {@code startTime}, {@code endTime}.
   *
   * <ul>
   *   <li>Given {@code Success}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, EventFilter, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, EventFilter, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdEventFilterStartTimeEndTime_givenSuccess() {
    // Arrange
    doNothing()
        .when(lifecycleEventRepository)
        .removeEvents(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<String>any(),
            Mockito.<String>any(),
            anyBoolean(),
            anyBoolean(),
            Mockito.<String>any());

    LifeCycleEventFilter eventFilter = new LifeCycleEventFilter();
    eventFilter.setErrorStr("An error occurred");
    eventFilter.setEvent("Event");
    eventFilter.setServer("Server");
    eventFilter.setStatus("Success");

    // Act
    jpaBaseEventDao.removeEvents(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, eventFilter, 1L, 1L);

    // Assert
    verify(lifecycleEventRepository)
        .removeEvents(
            isA(UUID.class),
            isA(UUID.class),
            eq(1L),
            eq(1L),
            eq("Server"),
            eq("Event"),
            eq(true),
            eq(true),
            eq("An error occurred"));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)} with {@code tenantId}, {@code
   * entityId}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdStartTimeEndTime() {
    // Arrange
    doThrow(new RuntimeException())
        .when(errorEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, 1L, 1L));
    verify(errorEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)} with {@code tenantId}, {@code
   * entityId}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdStartTimeEndTime2() {
    // Arrange
    doNothing()
        .when(lifecycleEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing()
        .when(statisticsEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing()
        .when(errorEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doThrow(new RuntimeException())
        .when(ruleNodeDebugEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, 1L, 1L));
    verify(errorEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(lifecycleEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(ruleNodeDebugEventRepository)
        .removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(statisticsEventRepository)
        .removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)} with {@code tenantId}, {@code
   * entityId}, {@code startTime}, {@code endTime}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdStartTimeEndTime3() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.removeEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, 1L, 1L));
  }

  /**
   * Test {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)} with {@code tenantId}, {@code
   * entityId}, {@code startTime}, {@code endTime}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChainDebugEventRepository#removeEvents(UUID, UUID, Long, Long)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#removeEvents(UUID, UUID, Long, Long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.removeEvents(UUID, UUID, Long, Long)"})
  public void testRemoveEventsWithTenantIdEntityIdStartTimeEndTime_thenCallsRemoveEvents() {
    // Arrange
    doNothing()
        .when(lifecycleEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing()
        .when(statisticsEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing()
        .when(errorEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing()
        .when(ruleNodeDebugEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());
    doNothing()
        .when(ruleChainDebugEventRepository)
        .removeEvents(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<Long>any(), Mockito.<Long>any());

    // Act
    jpaBaseEventDao.removeEvents(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, 1L, 1L);

    // Assert
    verify(errorEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(lifecycleEventRepository).removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(ruleChainDebugEventRepository)
        .removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(ruleNodeDebugEventRepository)
        .removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
    verify(statisticsEventRepository)
        .removeEvents(isA(UUID.class), isA(UUID.class), eq(1L), eq(1L));
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaBaseEventDao.findLatestEvents(UUID, UUID, EventType, int)"})
  public void testFindLatestEvents() {
    // Arrange
    when(errorEventRepository.findLatestEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), anyInt()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findLatestEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EventType.ERROR, 1));
    verify(errorEventRepository).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(1));
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaBaseEventDao.findLatestEvents(UUID, UUID, EventType, int)"})
  public void testFindLatestEvents2() {
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
    List<? extends Event> actualFindLatestEventsResult =
        jpaBaseEventDao.findLatestEvents(ModelConstants.NULL_UUID, entityId, EventType.ERROR, 1);

    // Assert
    verify(errorEventRepository).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    Event getResult = actualFindLatestEventsResult.get(0);
    assertTrue(getResult instanceof ErrorEvent);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, getResult.getUuidId());
    assertSame(entityId, getResult.getId().getId());
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaBaseEventDao.findLatestEvents(UUID, UUID, EventType, int)"})
  public void testFindLatestEvents3() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findLatestEvents(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EventType.ERROR, 1));
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}.
   *
   * <ul>
   *   <li>Given {@link ErrorEventEntity#ErrorEventEntity()} Uuid is {@code null}.
   *   <li>Then return first UuidId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaBaseEventDao.findLatestEvents(UUID, UUID, EventType, int)"})
  public void testFindLatestEvents_givenErrorEventEntityUuidIsNull_thenReturnFirstUuidIdIsNull() {
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
    errorEventEntity.setUuid(null);

    ArrayList<ErrorEventEntity> errorEventEntityList = new ArrayList<>();
    errorEventEntityList.add(errorEventEntity);
    when(errorEventRepository.findLatestEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), anyInt()))
        .thenReturn(errorEventEntityList);

    // Act
    List<? extends Event> actualFindLatestEventsResult =
        jpaBaseEventDao.findLatestEvents(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EventType.ERROR, 1);

    // Assert
    verify(errorEventRepository).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    Event getResult = actualFindLatestEventsResult.get(0);
    assertTrue(getResult instanceof ErrorEvent);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(getResult.getUuidId());
    assertNull(getResult.getId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaBaseEventDao.findLatestEvents(UUID, UUID, EventType, int)"})
  public void testFindLatestEvents_thenReturnEmpty() {
    // Arrange
    when(errorEventRepository.findLatestEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), anyInt()))
        .thenReturn(new ArrayList<>());

    // Act
    List<? extends Event> actualFindLatestEventsResult =
        jpaBaseEventDao.findLatestEvents(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID, EventType.ERROR, 1);

    // Assert
    verify(errorEventRepository).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(1));
    assertTrue(actualFindLatestEventsResult.isEmpty());
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}.
   *
   * <ul>
   *   <li>Then return not first TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestEvents(UUID, UUID, EventType, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List JpaBaseEventDao.findLatestEvents(UUID, UUID, EventType, int)"})
  public void testFindLatestEvents_thenReturnNotFirstTenantIdNullUid() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    errorEventEntity.setCreatedTime(1L);
    errorEventEntity.setEntityId(ModelConstants.NULL_UUID);
    errorEventEntity.setError("An error occurred");
    errorEventEntity.setId(ModelConstants.NULL_UUID);
    errorEventEntity.setMethod("Method");
    errorEventEntity.setServiceId("42");
    UUID tenantId = UUID.randomUUID();
    errorEventEntity.setTenantId(tenantId);
    errorEventEntity.setTs(1L);
    errorEventEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<ErrorEventEntity> errorEventEntityList = new ArrayList<>();
    errorEventEntityList.add(errorEventEntity);
    when(errorEventRepository.findLatestEvents(Mockito.<UUID>any(), Mockito.<UUID>any(), anyInt()))
        .thenReturn(errorEventEntityList);
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    List<? extends Event> actualFindLatestEventsResult =
        jpaBaseEventDao.findLatestEvents(ModelConstants.NULL_UUID, entityId, EventType.ERROR, 1);

    // Assert
    verify(errorEventRepository).findLatestEvents(isA(UUID.class), isA(UUID.class), eq(1));
    assertEquals(1, actualFindLatestEventsResult.size());
    Event getResult = actualFindLatestEventsResult.get(0);
    assertTrue(getResult instanceof ErrorEvent);
    TenantId tenantId2 = getResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertSame(entityId, getResult.getUuidId());
    assertSame(entityId, getResult.getId().getId());
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Event JpaBaseEventDao.findLatestDebugRuleNodeInEvent(UUID, UUID)"})
  public void testFindLatestDebugRuleNodeInEvent() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(null);
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
    when(ruleNodeDebugEventRepository.findLatestDebugRuleNodeInEvent(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ofResult);
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    Event actualFindLatestDebugRuleNodeInEventResult =
        jpaBaseEventDao.findLatestDebugRuleNodeInEvent(ModelConstants.NULL_UUID, entityId);

    // Assert
    verify(ruleNodeDebugEventRepository)
        .findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindLatestDebugRuleNodeInEventResult instanceof RuleNodeDebugEvent);
    TenantId tenantId = actualFindLatestDebugRuleNodeInEventResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertSame(entityId, actualFindLatestDebugRuleNodeInEventResult.getUuidId());
    assertSame(entityId, actualFindLatestDebugRuleNodeInEventResult.getId().getId());
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return not TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Event JpaBaseEventDao.findLatestDebugRuleNodeInEvent(UUID, UUID)"})
  public void testFindLatestDebugRuleNodeInEvent_thenReturnNotTenantIdNullUid() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(null);
    ruleNodeDebugEventEntity.setEventEntityType("Event Entity Type");
    ruleNodeDebugEventEntity.setEventType("Event Type");
    ruleNodeDebugEventEntity.setId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMetadata("Metadata");
    ruleNodeDebugEventEntity.setMsgId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setMsgType("Msg Type");
    ruleNodeDebugEventEntity.setRelationType("Relation Type");
    ruleNodeDebugEventEntity.setServiceId("42");
    UUID tenantId = UUID.randomUUID();
    ruleNodeDebugEventEntity.setTenantId(tenantId);
    ruleNodeDebugEventEntity.setTs(1L);
    ruleNodeDebugEventEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<RuleNodeDebugEventEntity> ofResult = Optional.of(ruleNodeDebugEventEntity);
    when(ruleNodeDebugEventRepository.findLatestDebugRuleNodeInEvent(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ofResult);
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    Event actualFindLatestDebugRuleNodeInEventResult =
        jpaBaseEventDao.findLatestDebugRuleNodeInEvent(ModelConstants.NULL_UUID, entityId);

    // Assert
    verify(ruleNodeDebugEventRepository)
        .findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindLatestDebugRuleNodeInEventResult instanceof RuleNodeDebugEvent);
    TenantId tenantId2 = actualFindLatestDebugRuleNodeInEventResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
    assertSame(entityId, actualFindLatestDebugRuleNodeInEventResult.getUuidId());
    assertSame(entityId, actualFindLatestDebugRuleNodeInEventResult.getId().getId());
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Event JpaBaseEventDao.findLatestDebugRuleNodeInEvent(UUID, UUID)"})
  public void testFindLatestDebugRuleNodeInEvent_thenReturnNull() {
    // Arrange
    Optional<RuleNodeDebugEventEntity> emptyResult = Optional.empty();
    when(ruleNodeDebugEventRepository.findLatestDebugRuleNodeInEvent(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(emptyResult);

    // Act
    Event actualFindLatestDebugRuleNodeInEventResult =
        jpaBaseEventDao.findLatestDebugRuleNodeInEvent(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(ruleNodeDebugEventRepository)
        .findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    assertNull(actualFindLatestDebugRuleNodeInEventResult);
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then return UuidId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Event JpaBaseEventDao.findLatestDebugRuleNodeInEvent(UUID, UUID)"})
  public void testFindLatestDebugRuleNodeInEvent_thenReturnUuidIdIsNull() {
    // Arrange
    RuleNodeDebugEventEntity ruleNodeDebugEventEntity = new RuleNodeDebugEventEntity();
    ruleNodeDebugEventEntity.setCreatedTime(1L);
    ruleNodeDebugEventEntity.setData("Data");
    ruleNodeDebugEventEntity.setDataType("Data Type");
    ruleNodeDebugEventEntity.setEntityId(ModelConstants.NULL_UUID);
    ruleNodeDebugEventEntity.setError("An error occurred");
    ruleNodeDebugEventEntity.setEventEntityId(null);
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
    ruleNodeDebugEventEntity.setUuid(null);
    Optional<RuleNodeDebugEventEntity> ofResult = Optional.of(ruleNodeDebugEventEntity);
    when(ruleNodeDebugEventRepository.findLatestDebugRuleNodeInEvent(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ofResult);

    // Act
    Event actualFindLatestDebugRuleNodeInEventResult =
        jpaBaseEventDao.findLatestDebugRuleNodeInEvent(
            ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Assert
    verify(ruleNodeDebugEventRepository)
        .findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
    assertTrue(actualFindLatestDebugRuleNodeInEventResult instanceof RuleNodeDebugEvent);
    TenantId tenantId = actualFindLatestDebugRuleNodeInEventResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualFindLatestDebugRuleNodeInEventResult.getUuidId());
    assertNull(actualFindLatestDebugRuleNodeInEventResult.getId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEventDao#findLatestDebugRuleNodeInEvent(UUID, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Event JpaBaseEventDao.findLatestDebugRuleNodeInEvent(UUID, UUID)"})
  public void testFindLatestDebugRuleNodeInEvent_thenThrowRuntimeException() {
    // Arrange
    when(ruleNodeDebugEventRepository.findLatestDebugRuleNodeInEvent(
            Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEventDao.findLatestDebugRuleNodeInEvent(
                ModelConstants.NULL_UUID, ModelConstants.NULL_UUID));
    verify(ruleNodeDebugEventRepository)
        .findLatestDebugRuleNodeInEvent(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs},
   * {@code debugEventExpTs}, {@code cleanupDb}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.cleanupEvents(1L, 1L, true));
    verify(eventPartitionConfiguration).getPartitionSizeInMs(EventType.ERROR);
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs},
   * {@code debugEventExpTs}, {@code cleanupDb}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb2() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    when(sqlPartitioningRepository.dropPartitionsBefore(
            Mockito.<String>any(), anyLong(), anyLong()))
        .thenReturn(1L);

    // Act
    jpaBaseEventDao.cleanupEvents(1L, 1L, true);

    // Assert
    verify(eventPartitionConfiguration, atLeast(1)).getPartitionSizeInMs(Mockito.<EventType>any());
    verify(sqlPartitioningRepository, atLeast(1))
        .dropPartitionsBefore(Mockito.<String>any(), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs},
   * {@code debugEventExpTs}, {@code cleanupDb}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb3() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    when(sqlPartitioningRepository.dropPartitionsBefore(
            Mockito.<String>any(), anyLong(), anyLong()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.cleanupEvents(1L, 1L, true));
    verify(eventPartitionConfiguration).getPartitionSizeInMs(EventType.ERROR);
    verify(sqlPartitioningRepository).dropPartitionsBefore("error_event", 1L, 3L);
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs},
   * {@code debugEventExpTs}, {@code cleanupDb}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb4() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    doNothing()
        .when(sqlPartitioningRepository)
        .cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());

    // Act
    jpaBaseEventDao.cleanupEvents(1L, 1L, false);

    // Assert
    verify(eventPartitionConfiguration, atLeast(1)).getPartitionSizeInMs(Mockito.<EventType>any());
    verify(sqlPartitioningRepository, atLeast(1))
        .cleanupPartitionsCache(Mockito.<String>any(), eq(1L), eq(3L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs},
   * {@code debugEventExpTs}, {@code cleanupDb}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb5() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    doThrow(new RuntimeException())
        .when(sqlPartitioningRepository)
        .cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.cleanupEvents(1L, 1L, false));
    verify(eventPartitionConfiguration).getPartitionSizeInMs(EventType.ERROR);
    verify(sqlPartitioningRepository).cleanupPartitionsCache("error_event", 1L, 3L);
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs},
   * {@code debugEventExpTs}, {@code cleanupDb}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb6() {
    // Arrange
    when(eventPartitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);
    doThrow(new RuntimeException())
        .when(sqlPartitioningRepository)
        .cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEventDao.cleanupEvents(0L, 1L, false));
    verify(eventPartitionConfiguration).getPartitionSizeInMs(EventType.DEBUG_RULE_NODE);
    verify(sqlPartitioningRepository).cleanupPartitionsCache("rule_node_debug_event", 1L, 3L);
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs},
   * {@code debugEventExpTs}, {@code cleanupDb}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb7() {
    // Arrange
    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    when(partitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong()))
        .thenReturn(1L);
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    // Act
    jpaBaseEventDao.cleanupEvents(1L, 1L, true);

    // Assert
    verify(partitioningRepository, atLeast(1))
        .dropPartitionsBefore(Mockito.<String>any(), eq(1L), eq(0L));
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs},
   * {@code debugEventExpTs}, {@code cleanupDb}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb8() {
    // Arrange
    EventPartitionConfiguration partitionConfiguration = mock(EventPartitionConfiguration.class);
    when(partitionConfiguration.getPartitionSizeInMs(Mockito.<EventType>any())).thenReturn(3L);

    SqlPartitioningRepository partitioningRepository = mock(SqlPartitioningRepository.class);
    when(partitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    EventInsertRepository eventInsertRepository = mock(EventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEventDao jpaBaseEventDao =
        new JpaBaseEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> jpaBaseEventDao.cleanupEvents(0L, 1L, true));
    verify(partitionConfiguration).getPartitionSizeInMs(EventType.DEBUG_RULE_NODE);
    verify(partitioningRepository).dropPartitionsBefore("rule_node_debug_event", 1L, 3L);
  }

  /**
   * Test {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)} with {@code regularEventExpTs},
   * {@code debugEventExpTs}, {@code cleanupDb}.
   *
   * <p>Method under test: {@link JpaBaseEventDao#cleanupEvents(long, long, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEventDao.cleanupEvents(long, long, boolean)"})
  public void testCleanupEventsWithRegularEventExpTsDebugEventExpTsCleanupDb9() {
    // Arrange
    DedicatedEventsSqlPartitioningRepository partitioningRepository =
        mock(DedicatedEventsSqlPartitioningRepository.class);
    doNothing()
        .when(partitioningRepository)
        .cleanupPartitionsCache(Mockito.<String>any(), anyLong(), anyLong());
    EventPartitionConfiguration partitionConfiguration = new EventPartitionConfiguration();
    LifecycleEventRepository lcEventRepository = mock(LifecycleEventRepository.class);
    StatisticsEventRepository statsEventRepository = mock(StatisticsEventRepository.class);
    ErrorEventRepository errorEventRepository = mock(ErrorEventRepository.class);
    DedicatedEventInsertRepository eventInsertRepository =
        mock(DedicatedEventInsertRepository.class);
    RuleNodeDebugEventRepository ruleNodeDebugEventRepository =
        mock(RuleNodeDebugEventRepository.class);
    RuleChainDebugEventRepository ruleChainDebugEventRepository =
        mock(RuleChainDebugEventRepository.class);
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    DedicatedJpaEventDao dedicatedJpaEventDao =
        new DedicatedJpaEventDao(
            partitionConfiguration,
            partitioningRepository,
            lcEventRepository,
            statsEventRepository,
            errorEventRepository,
            eventInsertRepository,
            ruleNodeDebugEventRepository,
            ruleChainDebugEventRepository,
            logExecutor,
            new DefaultStatsFactory());

    // Act
    dedicatedJpaEventDao.cleanupEvents(1L, 1L, false);

    // Assert
    verify(partitioningRepository, atLeast(1))
        .cleanupPartitionsCache(Mockito.<String>any(), eq(1L), eq(0L));
  }
}
