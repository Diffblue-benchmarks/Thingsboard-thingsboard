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
package org.thingsboard.server.dao.edge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.RateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.msg.tools.TbRateLimitsException;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.validator.EdgeEventDataValidator;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;
import org.thingsboard.server.dao.sql.edge.EdgeEventInsertRepository;
import org.thingsboard.server.dao.sql.edge.EdgeEventRepository;
import org.thingsboard.server.dao.sql.edge.JpaBaseEdgeEventDao;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {BaseEdgeEventService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseEdgeEventServiceDiffblueTest {
  @Autowired private BaseEdgeEventService baseEdgeEventService;

  @MockBean private DataValidator<EdgeEvent> dataValidator;

  @MockBean private EdgeEventDao edgeEventDao;

  @MockBean private RateLimitService rateLimitService;

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   *
   * <p>Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  public void testSaveAsync() {
    // Arrange
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any()))
        .thenThrow(new TbRateLimitsException("An error occurred"));

    // Act and Assert
    assertThrows(
        TbRateLimitsException.class, () -> baseEdgeEventService.saveAsync(new EdgeEvent()));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   *
   * <p>Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  public void testSaveAsync2() {
    // Arrange
    when(rateLimitService.checkRateLimit(
            Mockito.<LimitedApi>any(), Mockito.<TenantId>any(), Mockito.<Object>any()))
        .thenThrow(new TbRateLimitsException("An error occurred"));
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        TbRateLimitsException.class, () -> baseEdgeEventService.saveAsync(new EdgeEvent()));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
    verify(rateLimitService)
        .checkRateLimit(
            eq(LimitedApi.EDGE_EVENTS_PER_EDGE), (TenantId) isNull(), (Object) isNull());
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   *
   * <p>Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  public void testSaveAsync3() {
    // Arrange
    when(rateLimitService.checkRateLimit(
            Mockito.<LimitedApi>any(), Mockito.<TenantId>any(), Mockito.<Object>any()))
        .thenReturn(true);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<EdgeEvent>any(), Mockito.<Function<EdgeEvent, TenantId>>any()))
        .thenThrow(new TbRateLimitsException("An error occurred"));

    // Act and Assert
    assertThrows(
        TbRateLimitsException.class, () -> baseEdgeEventService.saveAsync(new EdgeEvent()));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
    verify(rateLimitService)
        .checkRateLimit(
            eq(LimitedApi.EDGE_EVENTS_PER_EDGE), (TenantId) isNull(), (Object) isNull());
    verify(dataValidator).validate(isA(EdgeEvent.class), isA(Function.class));
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEventDao} {@link EdgeEventDao#saveAsync(EdgeEvent)} return create.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  public void testSaveAsync_givenEdgeEventDaoSaveAsyncReturnCreate_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(edgeEventDao.saveAsync(Mockito.<EdgeEvent>any())).thenReturn(createResult);
    when(rateLimitService.checkRateLimit(
            Mockito.<LimitedApi>any(), Mockito.<TenantId>any(), Mockito.<Object>any()))
        .thenReturn(true);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<EdgeEvent>any(), Mockito.<Function<EdgeEvent, TenantId>>any()))
        .thenReturn(new EdgeEvent());

    // Act
    ListenableFuture<Void> actualSaveAsyncResult = baseEdgeEventService.saveAsync(new EdgeEvent());

    // Assert
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
    verify(rateLimitService)
        .checkRateLimit(
            eq(LimitedApi.EDGE_EVENTS_PER_EDGE), (TenantId) isNull(), (Object) isNull());
    verify(edgeEventDao).saveAsync(isA(EdgeEvent.class));
    verify(dataValidator).validate(isA(EdgeEvent.class), isA(Function.class));
    assertTrue(actualSaveAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualSaveAsyncResult);
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   *
   * <ul>
   *   <li>Given {@link RateLimitService} {@link RateLimitService#checkRateLimit(LimitedApi,
   *       TenantId, Object)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  public void testSaveAsync_givenRateLimitServiceCheckRateLimitReturnFalse() {
    // Arrange
    when(rateLimitService.checkRateLimit(
            Mockito.<LimitedApi>any(), Mockito.<TenantId>any(), Mockito.<Object>any()))
        .thenReturn(false);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        TbRateLimitsException.class, () -> baseEdgeEventService.saveAsync(new EdgeEvent()));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
    verify(rateLimitService)
        .checkRateLimit(
            eq(LimitedApi.EDGE_EVENTS_PER_EDGE), (TenantId) isNull(), (Object) isNull());
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   *
   * <ul>
   *   <li>Given {@link RateLimitService} {@link RateLimitService#checkRateLimit(LimitedApi,
   *       TenantId)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  public void testSaveAsync_givenRateLimitServiceCheckRateLimitReturnFalse2() {
    // Arrange
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        TbRateLimitsException.class, () -> baseEdgeEventService.saveAsync(new EdgeEvent()));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  public void testSaveAsync_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Void> listenableFutureTask = mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(edgeEventDao.saveAsync(Mockito.<EdgeEvent>any())).thenReturn(listenableFutureTask);
    when(rateLimitService.checkRateLimit(
            Mockito.<LimitedApi>any(), Mockito.<TenantId>any(), Mockito.<Object>any()))
        .thenReturn(true);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<EdgeEvent>any(), Mockito.<Function<EdgeEvent, TenantId>>any()))
        .thenReturn(new EdgeEvent());

    // Act
    baseEdgeEventService.saveAsync(new EdgeEvent());

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
    verify(rateLimitService)
        .checkRateLimit(
            eq(LimitedApi.EDGE_EVENTS_PER_EDGE), (TenantId) isNull(), (Object) isNull());
    verify(edgeEventDao).saveAsync(isA(EdgeEvent.class));
    verify(dataValidator).validate(isA(EdgeEvent.class), isA(Function.class));
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeEvent#getEdgeId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  public void testSaveAsync_thenCallsGetEdgeId() {
    // Arrange
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao edgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            mock(EdgeEventRepository.class),
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
            mock(JdbcTemplate.class));
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    BaseEdgeEventService baseEdgeEventService =
        new BaseEdgeEventService(
            edgeEventDao,
            rateLimitService,
            new EdgeEventDataValidator(),
            mock(ApplicationEventPublisher.class));

    EdgeEvent edgeEvent = mock(EdgeEvent.class);
    when(edgeEvent.getEdgeId()).thenThrow(new TbRateLimitsException("An error occurred"));
    when(edgeEvent.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(TbRateLimitsException.class, () -> baseEdgeEventService.saveAsync(edgeEvent));
    verify(edgeEvent).getEdgeId();
    verify(edgeEvent, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEdgeEventService.findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<EdgeEvent> emptyPageDataResult = PageData.emptyPageData();
    when(edgeEventDao.findEdgeEvents(
            Mockito.<UUID>any(),
            Mockito.<EdgeId>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult =
        baseEdgeEventService.findEdgeEvents(tenantId, null, 1L, 1L, new TimePageLink(3));

    // Assert
    verify(tenantId).getId();
    verify(edgeEventDao)
        .findEdgeEvents(isA(UUID.class), isNull(), eq(1L), eq(1L), isA(TimePageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeEventsResult);
  }

  /**
   * Test {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEdgeEventService.findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EdgeEvent> emptyPageDataResult = PageData.emptyPageData();
    when(edgeEventDao.findEdgeEvents(
            Mockito.<UUID>any(),
            Mockito.<EdgeId>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult =
        baseEdgeEventService.findEdgeEvents(
            ModelConstants.SYSTEM_TENANT, null, 1L, 1L, new TimePageLink(3));

    // Assert
    verify(edgeEventDao)
        .findEdgeEvents(isA(UUID.class), isNull(), eq(1L), eq(1L), isA(TimePageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeEventsResult);
  }

  /**
   * Test {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)}.
   *
   * <ul>
   *   <li>Then return TotalElements is zero.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEdgeEventService.findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)"
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

    JpaBaseEdgeEventDao edgeEventDao =
        new JpaBaseEdgeEventDao(
            logExecutor,
            new DefaultStatsFactory(),
            edgeEventRepository,
            mock(EdgeEventInsertRepository.class),
            mock(SqlPartitioningRepository.class),
            mock(JdbcTemplate.class));
    DefaultRateLimitService rateLimitService =
        new DefaultRateLimitService(
            mock(TenantProfileProvider.class), mock(NotificationRuleProcessor.class), 1, 3);

    BaseEdgeEventService baseEdgeEventService =
        new BaseEdgeEventService(
            edgeEventDao,
            rateLimitService,
            new EdgeEventDataValidator(),
            mock(ApplicationEventPublisher.class));
    EdgeId edgeId = new EdgeId(ModelConstants.NULL_UUID);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult =
        baseEdgeEventService.findEdgeEvents(
            ModelConstants.SYSTEM_TENANT, edgeId, 1L, 1L, new TimePageLink(3));

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
   * Test {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)}.
   *
   * <ul>
   *   <li>Then throw {@link TbRateLimitsException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEdgeEventService.findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)"
  })
  public void testFindEdgeEvents_thenThrowTbRateLimitsException() {
    // Arrange
    when(edgeEventDao.findEdgeEvents(
            Mockito.<UUID>any(),
            Mockito.<EdgeId>any(),
            Mockito.<Long>any(),
            Mockito.<Long>any(),
            Mockito.<TimePageLink>any()))
        .thenThrow(new TbRateLimitsException("An error occurred"));

    // Act and Assert
    assertThrows(
        TbRateLimitsException.class,
        () ->
            baseEdgeEventService.findEdgeEvents(
                ModelConstants.SYSTEM_TENANT, null, 1L, 1L, new TimePageLink(3)));
    verify(edgeEventDao)
        .findEdgeEvents(isA(UUID.class), isNull(), eq(1L), eq(1L), isA(TimePageLink.class));
  }

  /**
   * Test {@link BaseEdgeEventService#cleanupEvents(long)}.
   *
   * <ul>
   *   <li>Given {@link EdgeEventDao} {@link EdgeEventDao#cleanupEvents(long)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#cleanupEvents(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEdgeEventService.cleanupEvents(long)"})
  public void testCleanupEvents_givenEdgeEventDaoCleanupEventsDoesNothing() {
    // Arrange
    doNothing().when(edgeEventDao).cleanupEvents(anyLong());

    // Act
    baseEdgeEventService.cleanupEvents(1L);

    // Assert
    verify(edgeEventDao).cleanupEvents(1L);
  }

  /**
   * Test {@link BaseEdgeEventService#cleanupEvents(long)}.
   *
   * <ul>
   *   <li>Then throw {@link TbRateLimitsException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#cleanupEvents(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEdgeEventService.cleanupEvents(long)"})
  public void testCleanupEvents_thenThrowTbRateLimitsException() {
    // Arrange
    doThrow(new TbRateLimitsException("An error occurred"))
        .when(edgeEventDao)
        .cleanupEvents(anyLong());

    // Act and Assert
    assertThrows(TbRateLimitsException.class, () -> baseEdgeEventService.cleanupEvents(1L));
    verify(edgeEventDao).cleanupEvents(1L);
  }
}
