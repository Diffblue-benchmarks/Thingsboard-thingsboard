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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
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
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.EdgeEventId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.EdgeEventEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaBaseEdgeEventDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaBaseEdgeEventDaoDiffblueTest {
  @MockBean private DataSource dataSource;

  @MockBean private EdgeEventInsertRepository edgeEventInsertRepository;

  @MockBean private EdgeEventRepository edgeEventRepository;

  @MockBean private EntityManagerFactory entityManagerFactory;

  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private JpaBaseEdgeEventDao jpaBaseEdgeEventDao;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private ScheduledLogExecutorComponent scheduledLogExecutorComponent;

  @MockBean private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean private StatsFactory statsFactory;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JpaBaseEdgeEventDao#getEntityClass()}
   *   <li>{@link JpaBaseEdgeEventDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Class JpaBaseEdgeEventDao.getEntityClass()",
    "org.springframework.data.jpa.repository.JpaRepository JpaBaseEdgeEventDao.getRepository()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao jpaBaseEdgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            mock(EdgeEventRepository.class),
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
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
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaBaseEdgeEventDao.saveAsync(EdgeEvent)"
  })
  public void testSaveAsync_givenRuntimeException() {
    // Arrange
    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getCreatedTime()).thenThrow(new RuntimeException());
    when(edgeEvent.getId()).thenReturn(new EdgeEventId(ModelConstants.NULL_UUID));
    doNothing().when(edgeEvent).setAction(Mockito.<EdgeEventActionType>any());
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEdgeEventDao.saveAsync(edgeEvent));
    verify(edgeEvent).getCreatedTime();
    verify(edgeEvent).setAction(EdgeEventActionType.ADDED);
    verify(edgeEvent).getId();
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#saveAsync(EdgeEvent)}.
   *
   * <ul>
   *   <li>Given {@code Save edge event [{}]}.
   *   <li>When {@link EdgeEvent} {@link EdgeEvent#getUid()} return {@code Save edge event [{}]}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaBaseEdgeEventDao.saveAsync(EdgeEvent)"
  })
  public void testSaveAsync_givenSaveEdgeEvent_whenEdgeEventGetUidReturnSaveEdgeEvent() {
    // Arrange
    EdgeEventId edgeEventId = mock(EdgeEventId.class);
    when(edgeEventId.getId()).thenThrow(new RuntimeException());

    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getCreatedTime()).thenReturn(1L);
    when(edgeEvent.getUid()).thenReturn("Save edge event [{}] ");
    when(edgeEvent.getId()).thenReturn(edgeEventId);
    doNothing().when(edgeEvent).setAction(Mockito.<EdgeEventActionType>any());
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEdgeEventDao.saveAsync(edgeEvent));
    verify(edgeEvent).getCreatedTime();
    verify(edgeEvent).getUid();
    verify(edgeEvent).setAction(EdgeEventActionType.ADDED);
    verify(edgeEvent, atLeast(1)).getId();
    verify(edgeEventId).getId();
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#saveAsync(EdgeEvent)}.
   *
   * <ul>
   *   <li>When {@link EdgeEvent} {@link EdgeEvent#getCreatedTime()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture JpaBaseEdgeEventDao.saveAsync(EdgeEvent)"
  })
  public void testSaveAsync_whenEdgeEventGetCreatedTimeReturnZero() {
    // Arrange
    EdgeEventId edgeEventId = mock(EdgeEventId.class);
    when(edgeEventId.getId()).thenThrow(new RuntimeException());

    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getCreatedTime()).thenReturn(0L);
    when(edgeEvent.getId()).thenReturn(edgeEventId);
    doNothing().when(edgeEvent).setAction(Mockito.<EdgeEventActionType>any());
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEdgeEventDao.saveAsync(edgeEvent));
    verify(edgeEvent).getCreatedTime();
    verify(edgeEvent).setAction(EdgeEventActionType.ADDED);
    verify(edgeEvent, atLeast(1)).getId();
    verify(edgeEventId).getId();
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEdgeEventDao.findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents() {
    // Arrange
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenThrow(new RuntimeException());
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEdgeEventDao.findEdgeEvents(
                ModelConstants.NULL_UUID, edgeId, 1L, 1L, new TimePageLink(3)));
    verify(edgeEventRepository)
        .findEdgeEventsByTenantIdAndEdgeId(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            eq(1L),
            eq(1L),
            isA(Pageable.class));
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEdgeEventDao.findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents2() {
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

    EdgeEventRepository edgeEventRepository = mock(EdgeEventRepository.class);
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEdgeEventDao jpaBaseEdgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            edgeEventRepository,
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
            mock(JdbcTemplate.class));
    UUID tenantId = ModelConstants.NULL_UUID;

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult =
        jpaBaseEdgeEventDao.findEdgeEvents(tenantId, edgeId, 1L, 1L, pageLink);

    // Assert
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(edgeEventRepository)
        .findEdgeEventsByTenantIdAndEdgeId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            eq(1L),
            eq(1L),
            isA(Pageable.class));
    List<EdgeEvent> data = actualFindEdgeEventsResult.getData();
    assertEquals(1, data.size());
    EdgeEvent getResult = data.get(0);
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId2.getId().toString());
    assertTrue(tenantId2.isNullUid());
    assertTrue(tenantId2.isSysTenantId());
    UUID entityId = getResult.getEntityId();
    assertSame(entityId, getResult.getUuidId());
    assertSame(entityId, getResult.getEdgeId().getId());
    assertSame(entityId, getResult.getId().getId());
    assertSame(tenantId, entityId);
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEdgeEventDao.findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents_givenNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult =
        jpaBaseEdgeEventDao.findEdgeEvents(
            ModelConstants.NULL_UUID, edgeId, 1L, 1L, new TimePageLink(3));

    // Assert
    verify(edgeId).getId();
    verify(edgeEventRepository)
        .findEdgeEventsByTenantIdAndEdgeId(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            eq(1L),
            eq(1L),
            isA(Pageable.class));
    assertEquals(0L, actualFindEdgeEventsResult.getTotalElements());
    assertEquals(1, actualFindEdgeEventsResult.getTotalPages());
    assertFalse(actualFindEdgeEventsResult.hasNext());
    assertTrue(actualFindEdgeEventsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException()}.
   *   <li>When {@link EdgeId} {@link EdgeId#getId()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEdgeEventDao.findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents_givenRuntimeException_whenEdgeIdGetIdThrowRuntimeException() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenThrow(new RuntimeException());

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            jpaBaseEdgeEventDao.findEdgeEvents(ModelConstants.NULL_UUID, edgeId, 1L, 1L, pageLink));
    verify(edgeId).getId();
    verify(pageLink, atLeast(1)).getSortOrder();
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   *
   * <ul>
   *   <li>Then return Data first EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEdgeEventDao.findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents_thenReturnDataFirstEntityIdIsNull() {
    // Arrange
    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(null);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<EdgeEventEntity> content = new ArrayList<>();
    content.add(edgeEventEntity);

    EdgeEventRepository edgeEventRepository = mock(EdgeEventRepository.class);
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEdgeEventDao jpaBaseEdgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            edgeEventRepository,
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
            mock(JdbcTemplate.class));

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult =
        jpaBaseEdgeEventDao.findEdgeEvents(ModelConstants.NULL_UUID, edgeId, 1L, 1L, pageLink);

    // Assert
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(edgeEventRepository)
        .findEdgeEventsByTenantIdAndEdgeId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            eq(1L),
            eq(1L),
            isA(Pageable.class));
    List<EdgeEvent> data = actualFindEdgeEventsResult.getData();
    assertEquals(1, data.size());
    EdgeEvent getResult = data.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(getResult.getEntityId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   *
   * <ul>
   *   <li>Then return not Data first TenantId NullUid.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEdgeEventDao.findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents_thenReturnNotDataFirstTenantIdNullUid() {
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
    UUID tenantId = UUID.randomUUID();
    edgeEventEntity.setTenantId(tenantId);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<EdgeEventEntity> content = new ArrayList<>();
    content.add(edgeEventEntity);

    EdgeEventRepository edgeEventRepository = mock(EdgeEventRepository.class);
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(content));
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEdgeEventDao jpaBaseEdgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            edgeEventRepository,
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
            mock(JdbcTemplate.class));
    UUID tenantId2 = ModelConstants.NULL_UUID;

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult =
        jpaBaseEdgeEventDao.findEdgeEvents(tenantId2, edgeId, 1L, 1L, pageLink);

    // Assert
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(edgeEventRepository)
        .findEdgeEventsByTenantIdAndEdgeId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            eq(1L),
            eq(1L),
            isA(Pageable.class));
    List<EdgeEvent> data = actualFindEdgeEventsResult.getData();
    assertEquals(1, data.size());
    EdgeEvent getResult = data.get(0);
    TenantId tenantId3 = getResult.getTenantId();
    assertFalse(tenantId3.isNullUid());
    assertFalse(tenantId3.isSysTenantId());
    UUID entityId = getResult.getEntityId();
    assertSame(entityId, getResult.getUuidId());
    assertSame(entityId, getResult.getEdgeId().getId());
    assertSame(entityId, getResult.getId().getId());
    assertSame(tenantId, tenantId3.getId());
    assertSame(tenantId2, entityId);
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEdgeEventDao.findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents_thenReturnTotalElementsIsZero() {
    // Arrange
    EdgeEventRepository edgeEventRepository = mock(EdgeEventRepository.class);
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();

    JpaBaseEdgeEventDao jpaBaseEdgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            edgeEventRepository,
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
            mock(JdbcTemplate.class));

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    TimePageLink pageLink = mock(TimePageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getEndTime()).thenReturn(1L);
    when(pageLink.getStartTime()).thenReturn(1L);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(
            Mockito.<List<SortOrder>>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult =
        jpaBaseEdgeEventDao.findEdgeEvents(ModelConstants.NULL_UUID, edgeId, 1L, 1L, pageLink);

    // Assert
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(List.class), isA(Map.class), eq(true));
    verify(pageLink).getEndTime();
    verify(pageLink).getStartTime();
    verify(edgeEventRepository)
        .findEdgeEventsByTenantIdAndEdgeId(
            isA(UUID.class),
            isA(UUID.class),
            eq("Text Search"),
            eq(1L),
            eq(1L),
            eq(1L),
            eq(1L),
            isA(Pageable.class));
    assertEquals(0L, actualFindEdgeEventsResult.getTotalElements());
    assertEquals(1, actualFindEdgeEventsResult.getTotalPages());
    assertFalse(actualFindEdgeEventsResult.hasNext());
    assertTrue(actualFindEdgeEventsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#findEdgeEvents(UUID, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData JpaBaseEdgeEventDao.findEdgeEvents(UUID, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents_whenEdgeIdWithIdIsNull_uuid_thenReturnTotalElementsIsZero() {
    // Arrange
    when(edgeEventRepository.findEdgeEventsByTenantIdAndEdgeId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult =
        jpaBaseEdgeEventDao.findEdgeEvents(
            ModelConstants.NULL_UUID, edgeId, 1L, 1L, new TimePageLink(3));

    // Assert
    verify(edgeEventRepository)
        .findEdgeEventsByTenantIdAndEdgeId(
            isA(UUID.class),
            isA(UUID.class),
            isNull(),
            isNull(),
            isNull(),
            eq(1L),
            eq(1L),
            isA(Pageable.class));
    assertEquals(0L, actualFindEdgeEventsResult.getTotalElements());
    assertEquals(1, actualFindEdgeEventsResult.getTotalPages());
    assertFalse(actualFindEdgeEventsResult.hasNext());
    assertTrue(actualFindEdgeEventsResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#cleanupEvents(long)}.
   *
   * <ul>
   *   <li>Given {@link SqlPartitioningRepository} {@link
   *       SqlPartitioningRepository#dropPartitionsBefore(String, long, long)} return one.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#cleanupEvents(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEdgeEventDao.cleanupEvents(long)"})
  public void testCleanupEvents_givenSqlPartitioningRepositoryDropPartitionsBeforeReturnOne() {
    // Arrange
    when(sqlPartitioningRepository.dropPartitionsBefore(
            Mockito.<String>any(), anyLong(), anyLong()))
        .thenReturn(1L);

    // Act
    jpaBaseEdgeEventDao.cleanupEvents(1L);

    // Assert
    verify(sqlPartitioningRepository).dropPartitionsBefore("edge_event", 1L, 604800000L);
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#cleanupEvents(long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#cleanupEvents(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEdgeEventDao.cleanupEvents(long)"})
  public void testCleanupEvents_thenThrowRuntimeException() {
    // Arrange
    when(sqlPartitioningRepository.dropPartitionsBefore(
            Mockito.<String>any(), anyLong(), anyLong()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEdgeEventDao.cleanupEvents(1L));
    verify(sqlPartitioningRepository).dropPartitionsBefore("edge_event", 1L, 604800000L);
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#migrateEdgeEvents()}.
   *
   * <ul>
   *   <li>Given {@link JdbcTemplate} {@link JdbcTemplate#update(String, Object[])} return one.
   *   <li>Then calls {@link JdbcTemplate#execute(String)}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#migrateEdgeEvents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEdgeEventDao.migrateEdgeEvents()"})
  public void testMigrateEdgeEvents_givenJdbcTemplateUpdateReturnOne_thenCallsExecute()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.update(Mockito.<String>any(), isA(Object[].class))).thenReturn(1);
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());

    // Act
    jpaBaseEdgeEventDao.migrateEdgeEvents();

    // Assert
    verify(jdbcTemplate).execute("DROP TABLE IF EXISTS old_edge_event");
    verify(jdbcTemplate, atLeast(1))
        .update(eq("CALL migrate_edge_event(?, ?, ?)"), isA(Object[].class));
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#migrateEdgeEvents()}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#migrateEdgeEvents()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEdgeEventDao.migrateEdgeEvents()"})
  public void testMigrateEdgeEvents_thenThrowRuntimeException() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.update(Mockito.<String>any(), isA(Object[].class)))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEdgeEventDao.migrateEdgeEvents());
    verify(jdbcTemplate).update(eq("CALL migrate_edge_event(?, ?, ?)"), isA(Object[].class));
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#createPartition(EdgeEventEntity)} with {@code EdgeEventEntity}.
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#createPartition(EdgeEventEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEdgeEventDao.createPartition(EdgeEventEntity)"})
  public void testCreatePartitionWithEdgeEventEntity() {
    // Arrange
    doNothing()
        .when(sqlPartitioningRepository)
        .createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());

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

    // Assert
    verify(sqlPartitioningRepository).createPartitionIfNotExists("edge_event", 1L, 604800000L);
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#createPartition(EdgeEventEntity)} with {@code EdgeEventEntity}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link JpaBaseEdgeEventDao#createPartition(EdgeEventEntity)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void JpaBaseEdgeEventDao.createPartition(EdgeEventEntity)"})
  public void testCreatePartitionWithEdgeEventEntity_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException())
        .when(sqlPartitioningRepository)
        .createPartitionIfNotExists(Mockito.<String>any(), anyLong(), anyLong());

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

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEdgeEventDao.createPartition(entity));
    verify(sqlPartitioningRepository).createPartitionIfNotExists("edge_event", 1L, 604800000L);
  }
}
