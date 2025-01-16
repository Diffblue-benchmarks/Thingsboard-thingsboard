package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.List;
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
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.notification.NotificationTemplateService;

@ContextConfiguration(classes = {NotificationTemplateEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class NotificationTemplateEdgeEventFetcherDiffblueTest {
  @Autowired
  private NotificationTemplateEdgeEventFetcher notificationTemplateEdgeEventFetcher;

  @MockBean
  private NotificationTemplateService notificationTemplateService;

  /**
   * Test
   * {@link NotificationTemplateEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink)")
  void testFetchEntities() {
    // Arrange
    PageData<NotificationTemplate> emptyPageDataResult = PageData.emptyPageData();
    when(notificationTemplateService.findNotificationTemplatesByTenantIdAndNotificationTypes(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<NotificationTemplate> actualFetchEntitiesResult = notificationTemplateEdgeEventFetcher
        .fetchEntities(tenantId, edge, new PageLink(3));

    // Assert
    verify(notificationTemplateService).findNotificationTemplatesByTenantIdAndNotificationTypes(isA(TenantId.class),
        isA(List.class), isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test
   * {@link NotificationTemplateEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTemplate)}
   * with {@code TenantId}, {@code Edge}, {@code NotificationTemplate}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTemplate)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, NotificationTemplate) with 'TenantId', 'Edge', 'NotificationTemplate'")
  void testConstructEdgeEventWithTenantIdEdgeNotificationTemplate() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = notificationTemplateEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new NotificationTemplate());

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
    assertEquals(EdgeEventType.NOTIFICATION_TEMPLATE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link NotificationTemplateEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTemplate)}
   * with {@code TenantId}, {@code Edge}, {@code NotificationTemplate}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTemplate)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, NotificationTemplate) with 'TenantId', 'Edge', 'NotificationTemplate'")
  void testConstructEdgeEventWithTenantIdEdgeNotificationTemplate2() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);
    NotificationTemplate notificationTemplate = mock(NotificationTemplate.class);
    UUID id = UUID.randomUUID();
    when(notificationTemplate.getId()).thenReturn(new NotificationTemplateId(id));

    // Act
    EdgeEvent actualConstructEdgeEventResult = notificationTemplateEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        notificationTemplate);

    // Assert
    verify(edge).getId();
    verify(notificationTemplate).getId();
    assertNull(actualConstructEdgeEventResult.getBody());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.NOTIFICATION_TEMPLATE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
    assertSame(id, actualConstructEdgeEventResult.getEntityId());
  }

  /**
   * Test
   * {@link NotificationTemplateEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTemplate)}
   * with {@code TenantId}, {@code Edge}, {@code NotificationTemplate}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, NotificationTemplate)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, NotificationTemplate) with 'TenantId', 'Edge', 'NotificationTemplate'; when Edge()")
  void testConstructEdgeEventWithTenantIdEdgeNotificationTemplate_whenEdge() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = notificationTemplateEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new NotificationTemplate());

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
    assertEquals(EdgeEventType.NOTIFICATION_TEMPLATE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
