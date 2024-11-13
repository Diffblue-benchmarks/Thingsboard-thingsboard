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
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.notification.NotificationTargetService;

@ContextConfiguration(classes = {NotificationTargetEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class NotificationTargetEdgeEventFetcherDiffblueTest {
  @Autowired
  private NotificationTargetEdgeEventFetcher notificationTargetEdgeEventFetcher;

  @MockBean
  private NotificationTargetService notificationTargetService;

  /**
   * Test
   * {@link NotificationTargetEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <p>
   * Method under test:
   * {@link NotificationTargetEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink)")
  void testFetchEntities() {
    // Arrange
    PageData<NotificationTarget> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTargetService.findNotificationTargetsByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<NotificationTarget> actualFetchEntitiesResult = notificationTargetEdgeEventFetcher.fetchEntities(tenantId,
        edge, new PageLink(3));

    // Assert
    verify(notificationTargetService).findNotificationTargetsByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test
   * {@link NotificationTargetEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTarget)}
   * with {@code TenantId}, {@code Edge}, {@code NotificationTarget}.
   * <p>
   * Method under test:
   * {@link NotificationTargetEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTarget)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, NotificationTarget) with 'TenantId', 'Edge', 'NotificationTarget'")
  void testConstructEdgeEventWithTenantIdEdgeNotificationTarget() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = notificationTargetEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new NotificationTarget());

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
    assertEquals(EdgeEventType.NOTIFICATION_TARGET, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link NotificationTargetEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTarget)}
   * with {@code TenantId}, {@code Edge}, {@code NotificationTarget}.
   * <p>
   * Method under test:
   * {@link NotificationTargetEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTarget)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, NotificationTarget) with 'TenantId', 'Edge', 'NotificationTarget'")
  void testConstructEdgeEventWithTenantIdEdgeNotificationTarget2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);
    NotificationTarget notificationTarget = mock(NotificationTarget.class);
    UUID id = UUID.randomUUID();
    when(notificationTarget.getId()).thenReturn(new NotificationTargetId(id));

    // Act
    EdgeEvent actualConstructEdgeEventResult = notificationTargetEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        notificationTarget);

    // Assert
    verify(edge).getId();
    verify(notificationTarget).getId();
    assertNull(actualConstructEdgeEventResult.getBody());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.NOTIFICATION_TARGET, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
    assertSame(id, actualConstructEdgeEventResult.getEntityId());
  }

  /**
   * Test
   * {@link NotificationTargetEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTarget)}
   * with {@code TenantId}, {@code Edge}, {@code NotificationTarget}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTarget)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, NotificationTarget) with 'TenantId', 'Edge', 'NotificationTarget'; when Edge()")
  void testConstructEdgeEventWithTenantIdEdgeNotificationTarget_whenEdge() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = notificationTargetEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new NotificationTarget());

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
    assertEquals(EdgeEventType.NOTIFICATION_TARGET, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
