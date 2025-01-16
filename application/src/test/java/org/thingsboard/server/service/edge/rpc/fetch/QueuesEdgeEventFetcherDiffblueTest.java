package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.queue.QueueService;

@ContextConfiguration(classes = {QueuesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class QueuesEdgeEventFetcherDiffblueTest {
  @MockBean
  private QueueService queueService;

  @Autowired
  private QueuesEdgeEventFetcher queuesEdgeEventFetcher;

  /**
   * Test {@link QueuesEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <p>
   * Method under test:
   * {@link QueuesEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink)")
  void testFetchEntities() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueService.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<Queue> actualFetchEntitiesResult = queuesEdgeEventFetcher.fetchEntities(tenantId, edge, new PageLink(3));

    // Assert
    verify(queueService).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test {@link QueuesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Queue)}
   * with {@code TenantId}, {@code Edge}, {@code Queue}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link Edge#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueuesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Queue)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, Queue) with 'TenantId', 'Edge', 'Queue'; given 'null'; then calls getId()")
  void testConstructEdgeEventWithTenantIdEdgeQueue_givenNull_thenCallsGetId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = queuesEdgeEventFetcher.constructEdgeEvent(tenantId, edge, new Queue());

    // Assert
    verify(edge).getId();
    assertNull(actualConstructEdgeEventResult.getBody());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getEntityId());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.QUEUE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test {@link QueuesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Queue)}
   * with {@code TenantId}, {@code Edge}, {@code Queue}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueuesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Queue)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, Queue) with 'TenantId', 'Edge', 'Queue'; when Edge(); then return Body is 'null'")
  void testConstructEdgeEventWithTenantIdEdgeQueue_whenEdge_thenReturnBodyIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = queuesEdgeEventFetcher.constructEdgeEvent(tenantId, edge, new Queue());

    // Assert
    assertNull(actualConstructEdgeEventResult.getBody());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getEntityId());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.QUEUE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
