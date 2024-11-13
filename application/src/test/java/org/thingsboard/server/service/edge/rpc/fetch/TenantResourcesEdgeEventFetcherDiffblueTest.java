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
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.resource.ResourceService;

@ContextConfiguration(classes = {TenantResourcesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TenantResourcesEdgeEventFetcherDiffblueTest {
  @MockBean
  private ResourceService resourceService;

  @Autowired
  private TenantResourcesEdgeEventFetcher tenantResourcesEdgeEventFetcher;

  /**
   * Test
   * {@link TenantResourcesEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <p>
   * Method under test:
   * {@link TenantResourcesEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink)")
  void testFetchEntities() {
    // Arrange
    PageData<TbResource> emptyPageDataResult = PageData.emptyPageData();
    when(resourceService.findAllTenantResources(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<TbResource> actualFetchEntitiesResult = tenantResourcesEdgeEventFetcher.fetchEntities(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(resourceService).findAllTenantResources(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test
   * {@link TenantResourcesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, TbResource)}
   * with {@code TenantId}, {@code Edge}, {@code TbResource}.
   * <ul>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantResourcesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, TbResource)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, TbResource) with 'TenantId', 'Edge', 'TbResource'; then return EntityId is 'null'")
  void testConstructEdgeEventWithTenantIdEdgeTbResource_thenReturnEntityIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = tenantResourcesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new TbResource());

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
    assertEquals(EdgeEventType.TB_RESOURCE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link TenantResourcesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, TbResource)}
   * with {@code TenantId}, {@code Edge}, {@code TbResource}.
   * <ul>
   *   <li>Then return EntityId is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantResourcesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, TbResource)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, TbResource) with 'TenantId', 'Edge', 'TbResource'; then return EntityId is randomUUID")
  void testConstructEdgeEventWithTenantIdEdgeTbResource_thenReturnEntityIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);
    UUID id = UUID.randomUUID();

    // Act
    EdgeEvent actualConstructEdgeEventResult = tenantResourcesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new TbResource(new TbResourceId(id)));

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
    assertEquals(EdgeEventType.TB_RESOURCE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
    assertSame(id, actualConstructEdgeEventResult.getEntityId());
  }

  /**
   * Test
   * {@link TenantResourcesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, TbResource)}
   * with {@code TenantId}, {@code Edge}, {@code TbResource}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantResourcesEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, TbResource)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, TbResource) with 'TenantId', 'Edge', 'TbResource'; when Edge()")
  void testConstructEdgeEventWithTenantIdEdgeTbResource_whenEdge() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = tenantResourcesEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new TbResource());

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
    assertEquals(EdgeEventType.TB_RESOURCE, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
