package org.thingsboard.server.dao.edge;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.function.Function;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.limits.RateLimitService;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.msg.tools.TbRateLimitsException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseEdgeEventService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseEdgeEventServiceDiffblueTest {
  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseEdgeEventService baseEdgeEventService;

  @MockBean
  private DataValidator<EdgeEvent> dataValidator;

  @MockBean
  private EdgeEventDao edgeEventDao;

  @MockBean
  private RateLimitService rateLimitService;

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   * <p>
   * Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  public void testSaveAsync() {
    // Arrange
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any(), Mockito.<Object>any()))
        .thenReturn(true);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(true);
    when(dataValidator.validate(Mockito.<EdgeEvent>any(), Mockito.<Function<EdgeEvent, TenantId>>any()))
        .thenThrow(new TbRateLimitsException("An error occurred"));

    // Act and Assert
    assertThrows(TbRateLimitsException.class, () -> baseEdgeEventService.saveAsync(new EdgeEvent()));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS_PER_EDGE), (TenantId) isNull(),
        (Object) isNull());
    verify(dataValidator).validate(isA(EdgeEvent.class), isA(Function.class));
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   * <ul>
   *   <li>Given {@link EdgeEventDao} {@link EdgeEventDao#saveAsync(EdgeEvent)}
   * return create.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  public void testSaveAsync_givenEdgeEventDaoSaveAsyncReturnCreate_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(edgeEventDao.saveAsync(Mockito.<EdgeEvent>any())).thenReturn(createResult);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any(), Mockito.<Object>any()))
        .thenReturn(true);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(true);
    when(dataValidator.validate(Mockito.<EdgeEvent>any(), Mockito.<Function<EdgeEvent, TenantId>>any()))
        .thenReturn(new EdgeEvent());

    // Act
    ListenableFuture<Void> actualSaveAsyncResult = baseEdgeEventService.saveAsync(new EdgeEvent());

    // Assert
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS_PER_EDGE), (TenantId) isNull(),
        (Object) isNull());
    verify(edgeEventDao).saveAsync(isA(EdgeEvent.class));
    verify(dataValidator).validate(isA(EdgeEvent.class), isA(Function.class));
    assertTrue(actualSaveAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualSaveAsyncResult);
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   * <ul>
   *   <li>Given {@link RateLimitService}
   * {@link RateLimitService#checkRateLimit(LimitedApi, TenantId, Object)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  public void testSaveAsync_givenRateLimitServiceCheckRateLimitReturnFalse() {
    // Arrange
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any(), Mockito.<Object>any()))
        .thenReturn(false);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(true);

    // Act and Assert
    assertThrows(TbRateLimitsException.class, () -> baseEdgeEventService.saveAsync(new EdgeEvent()));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS_PER_EDGE), (TenantId) isNull(),
        (Object) isNull());
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   * <ul>
   *   <li>Given {@link RateLimitService}
   * {@link RateLimitService#checkRateLimit(LimitedApi, TenantId)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  public void testSaveAsync_givenRateLimitServiceCheckRateLimitReturnFalse2() {
    // Arrange
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(false);

    // Act and Assert
    assertThrows(TbRateLimitsException.class, () -> baseEdgeEventService.saveAsync(new EdgeEvent()));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
  }

  /**
   * Test {@link BaseEdgeEventService#saveAsync(EdgeEvent)}.
   * <ul>
   *   <li>Then calls
   * {@link ListenableFutureTask#addListener(Runnable, Executor)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeEventService#saveAsync(EdgeEvent)}
   */
  @Test
  public void testSaveAsync_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Void> listenableFutureTask = mock(ListenableFutureTask.class);
    doNothing().when(listenableFutureTask).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(edgeEventDao.saveAsync(Mockito.<EdgeEvent>any())).thenReturn(listenableFutureTask);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any(), Mockito.<Object>any()))
        .thenReturn(true);
    when(rateLimitService.checkRateLimit(Mockito.<LimitedApi>any(), Mockito.<TenantId>any())).thenReturn(true);
    when(dataValidator.validate(Mockito.<EdgeEvent>any(), Mockito.<Function<EdgeEvent, TenantId>>any()))
        .thenReturn(new EdgeEvent());

    // Act
    baseEdgeEventService.saveAsync(new EdgeEvent());

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS), isNull());
    verify(rateLimitService).checkRateLimit(eq(LimitedApi.EDGE_EVENTS_PER_EDGE), (TenantId) isNull(),
        (Object) isNull());
    verify(edgeEventDao).saveAsync(isA(EdgeEvent.class));
    verify(dataValidator).validate(isA(EdgeEvent.class), isA(Function.class));
  }

  /**
   * Test
   * {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)}
   */
  @Test
  public void testFindEdgeEvents_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EdgeEvent> emptyPageDataResult = PageData.emptyPageData();
    when(edgeEventDao.findEdgeEvents(Mockito.<UUID>any(), Mockito.<EdgeId>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<TimePageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeEvent> actualFindEdgeEventsResult = baseEdgeEventService.findEdgeEvents(ModelConstants.SYSTEM_TENANT,
        null, 1L, 1L, new TimePageLink(3));

    // Assert
    verify(edgeEventDao).findEdgeEvents(isA(UUID.class), isNull(), eq(1L), eq(1L), isA(TimePageLink.class));
    assertSame(actualFindEdgeEventsResult.EMPTY_PAGE_DATA, actualFindEdgeEventsResult);
  }

  /**
   * Test
   * {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)}.
   * <ul>
   *   <li>Then throw {@link TbRateLimitsException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseEdgeEventService#findEdgeEvents(TenantId, EdgeId, Long, Long, TimePageLink)}
   */
  @Test
  public void testFindEdgeEvents_thenThrowTbRateLimitsException() {
    // Arrange
    when(edgeEventDao.findEdgeEvents(Mockito.<UUID>any(), Mockito.<EdgeId>any(), Mockito.<Long>any(),
        Mockito.<Long>any(), Mockito.<TimePageLink>any())).thenThrow(new TbRateLimitsException("An error occurred"));

    // Act and Assert
    assertThrows(TbRateLimitsException.class,
        () -> baseEdgeEventService.findEdgeEvents(ModelConstants.SYSTEM_TENANT, null, 1L, 1L, new TimePageLink(3)));
    verify(edgeEventDao).findEdgeEvents(isA(UUID.class), isNull(), eq(1L), eq(1L), isA(TimePageLink.class));
  }

  /**
   * Test {@link BaseEdgeEventService#cleanupEvents(long)}.
   * <ul>
   *   <li>Given {@link EdgeEventDao} {@link EdgeEventDao#cleanupEvents(long)} does
   * nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeEventService#cleanupEvents(long)}
   */
  @Test
  public void testCleanupEvents_givenEdgeEventDaoCleanupEventsDoesNothing() {
    // Arrange
    doNothing().when(edgeEventDao).cleanupEvents(anyLong());

    // Act
    baseEdgeEventService.cleanupEvents(1L);

    // Assert that nothing has changed
    verify(edgeEventDao).cleanupEvents(eq(1L));
  }

  /**
   * Test {@link BaseEdgeEventService#cleanupEvents(long)}.
   * <ul>
   *   <li>Then throw {@link TbRateLimitsException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseEdgeEventService#cleanupEvents(long)}
   */
  @Test
  public void testCleanupEvents_thenThrowTbRateLimitsException() {
    // Arrange
    doThrow(new TbRateLimitsException("An error occurred")).when(edgeEventDao).cleanupEvents(anyLong());

    // Act and Assert
    assertThrows(TbRateLimitsException.class, () -> baseEdgeEventService.cleanupEvents(1L));
    verify(edgeEventDao).cleanupEvents(eq(1L));
  }
}
