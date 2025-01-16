package org.thingsboard.server.service.edge.rpc.fetch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
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
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.asset.AssetProfileService;

@ContextConfiguration(classes = {AssetProfilesEdgeEventFetcher.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class BasePageableEdgeEventFetcherDiffblueTest {
  @MockBean
  private AssetProfileService assetProfileService;

  @Autowired
  private BasePageableEdgeEventFetcher<AssetProfile> basePageableEdgeEventFetcher;

  /**
   * Test {@link BasePageableEdgeEventFetcher#getPageLink(int)}.
   * <p>
   * Method under test: {@link BasePageableEdgeEventFetcher#getPageLink(int)}
   */
  @Test
  @DisplayName("Test getPageLink(int)")
  void testGetPageLink() {
    // Arrange and Act
    PageLink actualPageLink = basePageableEdgeEventFetcher.getPageLink(3);

    // Assert
    assertNull(actualPageLink.getTextSearch());
    assertNull(actualPageLink.getSortOrder());
    assertEquals(0, actualPageLink.getPage());
    assertEquals(3, actualPageLink.getPageSize());
  }

  /**
   * Test
   * {@link BasePageableEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <p>
   * Method under test:
   * {@link BasePageableEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink)")
  void testFetchEdgeEvents() {
    // Arrange
    PageData<AssetProfile> pageData = new PageData<>(new ArrayList<>(), 4, 4L, true);

    when(assetProfileService.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = basePageableEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(assetProfileService).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    assertEquals(pageData, actualFetchEdgeEventsResult);
  }

  /**
   * Test
   * {@link BasePageableEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add
   * {@link AssetProfile#AssetProfile()}.</li>
   *   <li>Then return Data size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasePageableEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink); given ArrayList() add AssetProfile(); then return Data size is one")
  void testFetchEdgeEvents_givenArrayListAddAssetProfile_thenReturnDataSizeIsOne() {
    // Arrange
    ArrayList<AssetProfile> assetProfileList = new ArrayList<>();
    assetProfileList.add(new AssetProfile());
    PageData<AssetProfile> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    when(pageData.getData()).thenReturn(assetProfileList);
    when(pageData.getTotalElements()).thenReturn(1L);
    when(assetProfileService.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = basePageableEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(assetProfileService).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    List<EdgeEvent> data = actualFetchEdgeEventsResult.getData();
    assertEquals(1, data.size());
    EdgeEvent getResult = data.get(0);
    assertNull(getResult.getBody());
    assertNull(getResult.getUid());
    assertNull(getResult.getEntityId());
    assertNull(getResult.getUuidId());
    assertNull(getResult.getId());
    assertNull(getResult.getEdgeId());
    assertEquals(0L, getResult.getCreatedTime());
    assertEquals(0L, getResult.getSeqId());
    assertEquals(EdgeEventActionType.ADDED, getResult.getAction());
    assertEquals(EdgeEventType.ASSET_PROFILE, getResult.getType());
    assertSame(tenantId, getResult.getTenantId());
  }

  /**
   * Test
   * {@link BasePageableEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return
   * {@code true}.</li>
   *   <li>Then return TotalPages is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasePageableEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink); given PageData hasNext() return 'true'; then return TotalPages is one")
  void testFetchEdgeEvents_givenPageDataHasNextReturnTrue_thenReturnTotalPagesIsOne() {
    // Arrange
    PageData<AssetProfile> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(pageData.getTotalElements()).thenReturn(1L);
    when(assetProfileService.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = basePageableEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(pageData).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(assetProfileService).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    assertEquals(1, actualFetchEdgeEventsResult.getTotalPages());
    assertEquals(1L, actualFetchEdgeEventsResult.getTotalElements());
    assertTrue(actualFetchEdgeEventsResult.getData().isEmpty());
    assertTrue(actualFetchEdgeEventsResult.hasNext());
  }

  /**
   * Test
   * {@link BasePageableEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BasePageableEdgeEventFetcher#fetchEdgeEvents(TenantId, Edge, PageLink)}
   */
  @Test
  @DisplayName("Test fetchEdgeEvents(TenantId, Edge, PageLink); then return EMPTY_PAGE_DATA")
  void testFetchEdgeEvents_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileService.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    Edge edge = new Edge();

    // Act
    PageData<EdgeEvent> actualFetchEdgeEventsResult = basePageableEdgeEventFetcher.fetchEdgeEvents(tenantId, edge,
        new PageLink(3));

    // Assert
    verify(assetProfileService).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    assertEquals(actualFetchEdgeEventsResult.EMPTY_PAGE_DATA, actualFetchEdgeEventsResult);
  }
}
