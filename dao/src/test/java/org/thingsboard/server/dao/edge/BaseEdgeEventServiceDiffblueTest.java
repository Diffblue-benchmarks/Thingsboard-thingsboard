package org.thingsboard.server.dao.edge;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
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
@ExtendWith(SpringExtension.class)
class BaseEdgeEventServiceDiffblueTest {
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
  @DisplayName("Test saveAsync(EdgeEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  void testSaveAsync() {
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
  @DisplayName("Test saveAsync(EdgeEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  void testSaveAsync2() {
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
  @DisplayName("Test saveAsync(EdgeEvent)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  void testSaveAsync3() {
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
  @DisplayName(
      "Test saveAsync(EdgeEvent); given EdgeEventDao saveAsync(EdgeEvent) return create; then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  void testSaveAsync_givenEdgeEventDaoSaveAsyncReturnCreate_thenReturnSettableFuture() {
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
  @DisplayName(
      "Test saveAsync(EdgeEvent); given RateLimitService checkRateLimit(LimitedApi, TenantId, Object) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  void testSaveAsync_givenRateLimitServiceCheckRateLimitReturnFalse() {
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
  @DisplayName(
      "Test saveAsync(EdgeEvent); given RateLimitService checkRateLimit(LimitedApi, TenantId) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  void testSaveAsync_givenRateLimitServiceCheckRateLimitReturnFalse2() {
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
  @DisplayName("Test saveAsync(EdgeEvent); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  void testSaveAsync_thenCallsAddListener() {
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
  @DisplayName("Test saveAsync(EdgeEvent); then calls getEdgeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseEdgeEventService.saveAsync(EdgeEvent)"})
  void testSaveAsync_thenCallsGetEdgeId() {
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEdgeEventService.findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)"
  })
  void testFindEdgeEvents_thenCallsGetId() {
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
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @DisplayName(
      "Test findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEdgeEventService.findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)"
  })
  void testFindEdgeEvents_thenReturnEmpty_page_data() {
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
   *   <li>Then throw {@link TbRateLimitsException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long,
   * TimePageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink); then throw TbRateLimitsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseEdgeEventService.findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)"
  })
  void testFindEdgeEvents_thenThrowTbRateLimitsException() {
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
  @DisplayName("Test cleanupEvents(long); given EdgeEventDao cleanupEvents(long) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEdgeEventService.cleanupEvents(long)"})
  void testCleanupEvents_givenEdgeEventDaoCleanupEventsDoesNothing() {
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
  @DisplayName("Test cleanupEvents(long); then throw TbRateLimitsException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseEdgeEventService.cleanupEvents(long)"})
  void testCleanupEvents_thenThrowTbRateLimitsException() {
    // Arrange
    doThrow(new TbRateLimitsException("An error occurred"))
        .when(edgeEventDao)
        .cleanupEvents(anyLong());

    // Act and Assert
    assertThrows(TbRateLimitsException.class, () -> baseEdgeEventService.cleanupEvents(1L));
    verify(edgeEventDao).cleanupEvents(1L);
  }
}
