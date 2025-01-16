package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.thingsboard.server.cache.limits.DefaultRateLimitService;
import org.thingsboard.server.cache.limits.TenantProfileProvider;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.common.msg.notification.NotificationRuleProcessor;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.dao.edge.BaseEdgeEventService;
import org.thingsboard.server.dao.edge.EdgeEventService;
import org.thingsboard.server.dao.service.validator.EdgeEventDataValidator;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;
import org.thingsboard.server.dao.sql.edge.EdgeEventInsertRepository;
import org.thingsboard.server.dao.sql.edge.EdgeEventRepository;
import org.thingsboard.server.dao.sql.edge.JpaBaseEdgeEventDao;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

class GeneralEdgeEventFetcherDiffblueTest {
  /**
   * Test {@link GeneralEdgeEventFetcher#getPageLink(int)}.
   * <p>
   * Method under test: {@link GeneralEdgeEventFetcher#getPageLink(int)}
   */
  @Test
  @DisplayName("Test getPageLink(int)")
  void testGetPageLink() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao edgeEventDao = new JpaBaseEdgeEventDao(logExecutor, new DefaultStatsFactory(),
        mock(EdgeEventRepository.class), mock(EdgeEventInsertRepository.class), mock(SqlPartitioningRepository.class),
        mock(JdbcTemplate.class));

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act
    PageLink actualPageLink = (new GeneralEdgeEventFetcher(1L, 1L, 1L, true, 3L, new BaseEdgeEventService(edgeEventDao,
        rateLimitService, new EdgeEventDataValidator(), mock(ApplicationEventPublisher.class)))).getPageLink(3);

    // Assert
    assertTrue(actualPageLink instanceof TimePageLink);
    assertNull(actualPageLink.getTextSearch());
    assertNull(actualPageLink.getSortOrder());
    assertEquals(0, actualPageLink.getPage());
    assertEquals(1L, ((TimePageLink) actualPageLink).getStartTime().longValue());
    assertEquals(3, actualPageLink.getPageSize());
  }

  /**
   * Test
   * {@link GeneralEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GeneralEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink); when Edge(); then return EMPTY_PAGE_DATA")
  void testFetchEdgeEvents_whenEdge_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao edgeEventDao = new JpaBaseEdgeEventDao(logExecutor, new DefaultStatsFactory(),
        mock(EdgeEventRepository.class), mock(EdgeEventInsertRepository.class), mock(SqlPartitioningRepository.class),
        mock(JdbcTemplate.class));

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    GeneralEdgeEventFetcher generalEdgeEventFetcher = new GeneralEdgeEventFetcher(1L, 1L, 1L, true, 3L,
        new BaseEdgeEventService(edgeEventDao, rateLimitService, new EdgeEventDataValidator(),
            mock(ApplicationEventPublisher.class)));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = generalEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new PageLink(3));

    // Assert
    assertEquals(actualFetchEdgeEventsResult.EMPTY_PAGE_DATA, actualFetchEdgeEventsResult);
  }

  /**
   * Test
   * {@link GeneralEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link GeneralEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink); when TimePageLink(int) with pageSize is three")
  void testFetchEdgeEvents_whenTimePageLinkWithPageSizeIsThree() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao edgeEventDao = new JpaBaseEdgeEventDao(logExecutor, new DefaultStatsFactory(),
        mock(EdgeEventRepository.class), mock(EdgeEventInsertRepository.class), mock(SqlPartitioningRepository.class),
        mock(JdbcTemplate.class));

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    GeneralEdgeEventFetcher generalEdgeEventFetcher = new GeneralEdgeEventFetcher(1L, 1L, 1L, true, 3L,
        new BaseEdgeEventService(edgeEventDao, rateLimitService, new EdgeEventDataValidator(),
            mock(ApplicationEventPublisher.class)));
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = generalEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new TimePageLink(3));

    // Assert
    assertEquals(actualFetchEdgeEventsResult.EMPTY_PAGE_DATA, actualFetchEdgeEventsResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link GeneralEdgeEventFetcher#GeneralEdgeEventFetcher(Long, Long, Long, boolean, Long, EdgeEventService)}
   *   <li>{@link GeneralEdgeEventFetcher#getSeqIdEnd()}
   *   <li>{@link GeneralEdgeEventFetcher#isSeqIdNewCycleStarted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao edgeEventDao = new JpaBaseEdgeEventDao(logExecutor, new DefaultStatsFactory(),
        mock(EdgeEventRepository.class), mock(EdgeEventInsertRepository.class), mock(SqlPartitioningRepository.class),
        mock(JdbcTemplate.class));

    DefaultRateLimitService rateLimitService = new DefaultRateLimitService(mock(TenantProfileProvider.class),
        mock(NotificationRuleProcessor.class), 1, 3);

    // Act
    GeneralEdgeEventFetcher actualGeneralEdgeEventFetcher = new GeneralEdgeEventFetcher(1L, 1L, 1L, true, 3L,
        new BaseEdgeEventService(edgeEventDao, rateLimitService, new EdgeEventDataValidator(),
            mock(ApplicationEventPublisher.class)));
    Long actualSeqIdEnd = actualGeneralEdgeEventFetcher.getSeqIdEnd();
    boolean actualIsSeqIdNewCycleStartedResult = actualGeneralEdgeEventFetcher.isSeqIdNewCycleStarted();

    // Assert
    assertEquals(1L, actualSeqIdEnd.longValue());
    assertTrue(actualIsSeqIdNewCycleStartedResult);
  }
}
