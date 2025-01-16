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
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.notification.NotificationRuleService;

@ContextConfiguration(classes = {NotificationRuleEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class NotificationRuleEdgeEventFetcherDiffblueTest {
  @Autowired
  private NotificationRuleEdgeEventFetcher notificationRuleEdgeEventFetcher;

  @MockBean
  private NotificationRuleService notificationRuleService;

  /**
   * Test
   * {@link NotificationRuleEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <p>
   * Method under test:
   * {@link NotificationRuleEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink)")
  void testFetchEntities() {
    // Arrange
    PageData<NotificationRule> emptyPageDataResult = PageData.emptyPageData();
    when(notificationRuleService.findNotificationRulesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<NotificationRule> actualFetchEntitiesResult = notificationRuleEdgeEventFetcher.fetchEntities(tenantId,
        edge, new PageLink(3));

    // Assert
    verify(notificationRuleService).findNotificationRulesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test
   * {@link NotificationRuleEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationRule)}
   * with {@code TenantId}, {@code Edge}, {@code NotificationRule}.
   * <p>
   * Method under test:
   * {@link NotificationRuleEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationRule)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, NotificationRule) with 'TenantId', 'Edge', 'NotificationRule'")
  void testConstructEdgeEventWithTenantIdEdgeNotificationRule() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);
    NotificationRule notificationRule = mock(NotificationRule.class);
    UUID id = UUID.randomUUID();
    when(notificationRule.getId()).thenReturn(new NotificationRuleId(id));

    // Act
    EdgeEvent actualConstructEdgeEventResult = notificationRuleEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        notificationRule);

    // Assert
    verify(edge).getId();
    verify(notificationRule).getId();
    assertNull(actualConstructEdgeEventResult.getBody());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.NOTIFICATION_RULE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
    assertSame(id, actualConstructEdgeEventResult.getEntityId());
  }

  /**
   * Test
   * {@link NotificationRuleEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationRule)}
   * with {@code TenantId}, {@code Edge}, {@code NotificationRule}.
   * <ul>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationRule)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, NotificationRule) with 'TenantId', 'Edge', 'NotificationRule'; then return EntityId is 'null'")
  void testConstructEdgeEventWithTenantIdEdgeNotificationRule_thenReturnEntityIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = notificationRuleEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new NotificationRule());

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
    assertEquals(EdgeEventType.NOTIFICATION_RULE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link NotificationRuleEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationRule)}
   * with {@code TenantId}, {@code Edge}, {@code NotificationRule}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationRule)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, NotificationRule) with 'TenantId', 'Edge', 'NotificationRule'; when Edge()")
  void testConstructEdgeEventWithTenantIdEdgeNotificationRule_whenEdge() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = notificationRuleEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new NotificationRule());

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
    assertEquals(EdgeEventType.NOTIFICATION_RULE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
