package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {TenantEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TenantEdgeEventFetcherDiffblueTest {
  @Autowired
  private TenantEdgeEventFetcher tenantEdgeEventFetcher;

  @MockBean
  private TenantService tenantService;

  /**
   * Test {@link TenantEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink); then return Data size is one")
  void testFetchEntities_thenReturnDataSizeIsOne() {
    // Arrange
    Tenant tenant = new Tenant();
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(tenant);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<Tenant> actualFetchEntitiesResult = tenantEdgeEventFetcher.fetchEntities(tenantId, edge, new PageLink(3));

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
    List<Tenant> data = actualFetchEntitiesResult.getData();
    assertEquals(1, data.size());
    assertEquals(1, actualFetchEntitiesResult.getTotalPages());
    assertEquals(1L, actualFetchEntitiesResult.getTotalElements());
    assertFalse(actualFetchEntitiesResult.hasNext());
    assertSame(tenant, data.get(0));
  }

  /**
   * Test
   * {@link TenantEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Tenant)}
   * with {@code TenantId}, {@code Edge}, {@code Tenant}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Tenant)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, Tenant) with 'TenantId', 'Edge', 'Tenant'; given 'null'; then return EntityId is 'null'")
  void testConstructEdgeEventWithTenantIdEdgeTenant_givenNull_thenReturnEntityIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = tenantEdgeEventFetcher.constructEdgeEvent(tenantId, edge, new Tenant());

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
    assertEquals(EdgeEventActionType.UPDATED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.TENANT, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test
   * {@link TenantEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Tenant)}
   * with {@code TenantId}, {@code Edge}, {@code Tenant}.
   * <ul>
   *   <li>Then return EntityId is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Tenant)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, Tenant) with 'TenantId', 'Edge', 'Tenant'; then return EntityId is randomUUID")
  void testConstructEdgeEventWithTenantIdEdgeTenant_thenReturnEntityIdIsRandomUUID() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);
    UUID id = UUID.randomUUID();

    // Act
    EdgeEvent actualConstructEdgeEventResult = tenantEdgeEventFetcher.constructEdgeEvent(tenantId, edge,
        new Tenant(new TenantId(id)));

    // Assert
    verify(edge).getId();
    assertNull(actualConstructEdgeEventResult.getBody());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.UPDATED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.TENANT, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
    assertSame(id, actualConstructEdgeEventResult.getEntityId());
  }

  /**
   * Test
   * {@link TenantEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Tenant)}
   * with {@code TenantId}, {@code Edge}, {@code Tenant}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return EntityId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Tenant)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, Tenant) with 'TenantId', 'Edge', 'Tenant'; when Edge(); then return EntityId is 'null'")
  void testConstructEdgeEventWithTenantIdEdgeTenant_whenEdge_thenReturnEntityIdIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = tenantEdgeEventFetcher.constructEdgeEvent(tenantId, edge, new Tenant());

    // Assert
    assertNull(actualConstructEdgeEventResult.getBody());
    assertNull(actualConstructEdgeEventResult.getUid());
    assertNull(actualConstructEdgeEventResult.getEntityId());
    assertNull(actualConstructEdgeEventResult.getUuidId());
    assertNull(actualConstructEdgeEventResult.getId());
    assertNull(actualConstructEdgeEventResult.getEdgeId());
    assertEquals(0L, actualConstructEdgeEventResult.getCreatedTime());
    assertEquals(0L, actualConstructEdgeEventResult.getSeqId());
    assertEquals(EdgeEventActionType.UPDATED, actualConstructEdgeEventResult.getAction());
    assertEquals(EdgeEventType.TENANT, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
