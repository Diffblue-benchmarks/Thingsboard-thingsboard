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
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.widget.WidgetTypeFilter;
import org.thingsboard.server.common.data.widget.WidgetTypeInfo;
import org.thingsboard.server.dao.widget.WidgetTypeService;

@ContextConfiguration(classes = {SystemWidgetTypesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class BaseWidgetTypesEdgeEventFetcherDiffblueTest {
  @Autowired
  private BaseWidgetTypesEdgeEventFetcher baseWidgetTypesEdgeEventFetcher;

  @MockBean
  private WidgetTypeService widgetTypeService;

  /**
   * Test
   * {@link BaseWidgetTypesEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseWidgetTypesEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink)")
  void testFetchEntities() {
    // Arrange
    PageData<WidgetTypeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeService.findSystemWidgetTypesByPageLink(Mockito.<WidgetTypeFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<WidgetTypeInfo> actualFetchEntitiesResult = baseWidgetTypesEdgeEventFetcher.fetchEntities(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(widgetTypeService).findSystemWidgetTypesByPageLink(isA(WidgetTypeFilter.class), isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test
   * {@link BaseWidgetTypesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetTypeInfo)}
   * with {@code TenantId}, {@code Edge}, {@code WidgetTypeInfo}.
   * <p>
   * Method under test:
   * {@link BaseWidgetTypesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetTypeInfo)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, WidgetTypeInfo) with 'TenantId', 'Edge', 'WidgetTypeInfo'")
  void testConstructEdgeEventWithTenantIdEdgeWidgetTypeInfo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);
    UUID id = UUID.randomUUID();

    // Act
    EdgeEvent actualConstructEdgeEventResult = baseWidgetTypesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new WidgetTypeInfo(new WidgetTypeId(id)));

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
    assertEquals(EdgeEventType.WIDGET_TYPE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
    assertSame(id, actualConstructEdgeEventResult.getEntityId());
  }

  /**
   * Test
   * {@link BaseWidgetTypesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetTypeInfo)}
   * with {@code TenantId}, {@code Edge}, {@code WidgetTypeInfo}.
   * <ul>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseWidgetTypesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetTypeInfo)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, WidgetTypeInfo) with 'TenantId', 'Edge', 'WidgetTypeInfo'; then return EntityId is 'null'")
  void testConstructEdgeEventWithTenantIdEdgeWidgetTypeInfo_thenReturnEntityIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = baseWidgetTypesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new WidgetTypeInfo());

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
    assertEquals(EdgeEventType.WIDGET_TYPE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link BaseWidgetTypesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetTypeInfo)}
   * with {@code TenantId}, {@code Edge}, {@code WidgetTypeInfo}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseWidgetTypesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, WidgetTypeInfo)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, WidgetTypeInfo) with 'TenantId', 'Edge', 'WidgetTypeInfo'; when Edge()")
  void testConstructEdgeEventWithTenantIdEdgeWidgetTypeInfo_whenEdge() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = baseWidgetTypesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new WidgetTypeInfo());

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
    assertEquals(EdgeEventType.WIDGET_TYPE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
