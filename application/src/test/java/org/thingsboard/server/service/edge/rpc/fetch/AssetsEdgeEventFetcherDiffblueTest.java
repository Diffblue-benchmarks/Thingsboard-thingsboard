package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.asset.AssetService;

@ContextConfiguration(classes = {AssetsEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AssetsEdgeEventFetcherDiffblueTest {
  @MockBean
  private AssetService assetService;

  @Autowired
  private AssetsEdgeEventFetcher assetsEdgeEventFetcher;

  /**
   * Test {@link AssetsEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetsEdgeEventFetcher#fetchEntities(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEntities(TenantId, Edge, PageLink); when Edge(); then return EMPTY_PAGE_DATA")
  void testFetchEntities_whenEdge_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetService.findAssetsByTenantIdAndEdgeId(Mockito.<TenantId>any(), Mockito.<EdgeId>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<Asset> actualFetchEntitiesResult = assetsEdgeEventFetcher.fetchEntities(tenantId, edge, new PageLink(3));

    // Assert
    verify(assetService).findAssetsByTenantIdAndEdgeId(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFetchEntitiesResult.EMPTY_PAGE_DATA, actualFetchEntitiesResult);
  }

  /**
   * Test {@link AssetsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Asset)}
   * with {@code TenantId}, {@code Edge}, {@code Asset}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>Then calls {@link Edge#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Asset)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, Asset) with 'TenantId', 'Edge', 'Asset'; given 'null'; then calls getId()")
  void testConstructEdgeEventWithTenantIdEdgeAsset_givenNull_thenCallsGetId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = mock(Edge.class);
    when(edge.getId()).thenReturn(null);

    // Act
    EdgeEvent actualConstructEdgeEventResult = assetsEdgeEventFetcher.constructEdgeEvent(tenantId, edge, new Asset());

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
    assertEquals(EdgeEventType.ASSET, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }

  /**
   * Test {@link AssetsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Asset)}
   * with {@code TenantId}, {@code Edge}, {@code Asset}.
   * <ul>
   *   <li>When {@link Edge#Edge()}.</li>
   *   <li>Then return Body is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetsEdgeEventFetcher#constructEdgeEvent(TenantId, Edge, Asset)}
   */
  @Test
  @DisplayName("Test constructEdgeEvent(TenantId, Edge, Asset) with 'TenantId', 'Edge', 'Asset'; when Edge(); then return Body is 'null'")
  void testConstructEdgeEventWithTenantIdEdgeAsset_whenEdge_thenReturnBodyIsNull() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    EdgeEvent actualConstructEdgeEventResult = assetsEdgeEventFetcher.constructEdgeEvent(tenantId, edge, new Asset());

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
    assertEquals(EdgeEventType.ASSET, actualConstructEdgeEventResult.getType());
    assertSame(tenantId, actualConstructEdgeEventResult.getTenantId());
  }
}
