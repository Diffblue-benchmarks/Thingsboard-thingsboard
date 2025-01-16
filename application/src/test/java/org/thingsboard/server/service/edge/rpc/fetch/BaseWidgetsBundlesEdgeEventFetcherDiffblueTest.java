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
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.common.data.widget.WidgetsBundleFilter;
import org.thingsboard.server.dao.widget.WidgetsBundleService;

@ContextConfiguration(classes = {SystemWidgetsBundlesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class BaseWidgetsBundlesEdgeEventFetcherDiffblueTest {
  @Autowired
  private BaseWidgetsBundlesEdgeEventFetcher baseWidgetsBundlesEdgeEventFetcher;

  @MockBean
  private WidgetsBundleService widgetsBundleService;

  /**
   * Test
   * {@link BaseWidgetsBundlesEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseWidgetsBundlesEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink)")
  void testFetchEntities() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleService.findSystemWidgetsBundlesByPageLink(Mockito.<WidgetsBundleFilter>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<WidgetsBundle> actualFetchEntitiesResult = baseWidgetsBundlesEdgeEventFetcher.fetchEntities(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(widgetsBundleService).findSystemWidgetsBundlesByPageLink(isA(WidgetsBundleFilter.class),
        isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test
   * {@link BaseWidgetsBundlesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetsBundle)}
   * with {@code TenantId}, {@code Edge}, {@code WidgetsBundle}.
   * <p>
   * Method under test:
   * {@link BaseWidgetsBundlesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetsBundle)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, WidgetsBundle) with 'TenantId', 'Edge', 'WidgetsBundle'")
  void testConstructEdgeEventWithTenantIdEdgeWidgetsBundle() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);
    UUID id = UUID.randomUUID();

    // Act
    EdgeEvent actualConstructEdgeEventResult = baseWidgetsBundlesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new WidgetsBundle(new WidgetsBundleId(id)));

    // Assert
    verify(edge).getId();
    assertNull(actualConstructEdgeEventResult.getBody());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.WIDGETS_BUNDLE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
    assertSame(id, actualConstructEdgeEventResult.getEntityId());
  }

  /**
   * Test
   * {@link BaseWidgetsBundlesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetsBundle)}
   * with {@code TenantId}, {@code Edge}, {@code WidgetsBundle}.
   * <ul>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseWidgetsBundlesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetsBundle)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, WidgetsBundle) with 'TenantId', 'Edge', 'WidgetsBundle'; then return EntityId is 'null'")
  void testConstructEdgeEventWithTenantIdEdgeWidgetsBundle_thenReturnEntityIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = baseWidgetsBundlesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new WidgetsBundle());

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
    assertEquals(EdgeEventType.WIDGETS_BUNDLE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link BaseWidgetsBundlesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetsBundle)}
   * with {@code TenantId}, {@code Edge}, {@code WidgetsBundle}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseWidgetsBundlesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetsBundle)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, WidgetsBundle) with 'TenantId', 'Edge', 'WidgetsBundle'; when Edge()")
  void testConstructEdgeEventWithTenantIdEdgeWidgetsBundle_whenEdge() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = baseWidgetsBundlesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new WidgetsBundle());

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
    assertEquals(EdgeEventType.WIDGETS_BUNDLE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
