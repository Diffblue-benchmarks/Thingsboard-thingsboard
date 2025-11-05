package org.thingsboard.server.dao.edge;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.cache.edge.RelatedEdgesCacheKey;
import org.thingsboard.server.cache.edge.RelatedEdgesCacheValue;
import org.thingsboard.server.cache.edge.RelatedEdgesEvictEvent;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {BaseRelatedEdgesService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class BaseRelatedEdgesServiceDiffblueTest {
  @Autowired private BaseRelatedEdgesService baseRelatedEdgesService;

  @MockBean private EdgeService edgeService;

  @MockBean
  private TbTransactionalCache<RelatedEdgesCacheKey, RelatedEdgesCacheValue> tbTransactionalCache;

  /**
   * Test {@link BaseRelatedEdgesService#handleEvictEvent(RelatedEdgesEvictEvent)} with {@code
   * RelatedEdgesEvictEvent}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelatedEdgesService#handleEvictEvent(RelatedEdgesEvictEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvictEvent(RelatedEdgesEvictEvent) with 'RelatedEdgesEvictEvent'; then calls evict(Serializable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelatedEdgesService.handleEvictEvent(RelatedEdgesEvictEvent)"})
  void testHandleEvictEventWithRelatedEdgesEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<RelatedEdgesCacheKey>any());

    // Act
    baseRelatedEdgesService.handleEvictEvent(
        new RelatedEdgesEvictEvent(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));

    // Assert
    verify(tbTransactionalCache).evict(isA(RelatedEdgesCacheKey.class));
  }

  /**
   * Test {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeIdsByEntityId(TenantId, EntityId, PageLink); when FIRST_PAGE; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRelatedEdgesService.findEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByEntityId_whenFirst_page_thenReturnNull() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelatedEdgesCacheKey>any(),
            Mockito.<Supplier<RelatedEdgesCacheValue>>any(),
            anyBoolean()))
        .thenReturn(new RelatedEdgesCacheValue());

    // Act
    PageData<EdgeId> actualFindEdgeIdsByEntityIdResult =
        baseRelatedEdgesService.findEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(RelatedEdgesCacheKey.class), isA(Supplier.class), eq(false));
    assertNull(actualFindEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link PageLink#PageLink(int)} with pageSize is {@link
   *       BaseRelatedEdgesService#RELATED_EDGES_CACHE_ITEMS}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeIdsByEntityId(TenantId, EntityId, PageLink); when PageLink(int) with pageSize is RELATED_EDGES_CACHE_ITEMS")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRelatedEdgesService.findEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByEntityId_whenPageLinkWithPageSizeIsRelated_edges_cache_items() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelatedEdgesCacheKey>any(),
            Mockito.<Supplier<RelatedEdgesCacheValue>>any(),
            anyBoolean()))
        .thenReturn(new RelatedEdgesCacheValue());

    // Act
    PageData<EdgeId> actualFindEdgeIdsByEntityIdResult =
        baseRelatedEdgesService.findEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new PageLink(BaseRelatedEdgesService.RELATED_EDGES_CACHE_ITEMS));

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(RelatedEdgesCacheKey.class), isA(Supplier.class), eq(false));
    assertNull(actualFindEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link PageLink#PageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeIdsByEntityId(TenantId, EntityId, PageLink); when PageLink(int) with pageSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRelatedEdgesService.findEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByEntityId_whenPageLinkWithPageSizeIsThree() {
    // Arrange
    PageData<EdgeId> emptyPageDataResult = PageData.emptyPageData();
    when(edgeService.findEdgeIdsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeId> actualFindEdgeIdsByEntityIdResult =
        baseRelatedEdgesService.findEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new PageLink(3));

    // Assert
    verify(edgeService)
        .findEdgeIdsByTenantIdAndEntityId(
            isA(TenantId.class), isA(EntityId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeIdsByEntityId(TenantId, EntityId, PageLink); when TimePageLink(int) with pageSize is three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRelatedEdgesService.findEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByEntityId_whenTimePageLinkWithPageSizeIsThree() {
    // Arrange
    PageData<EdgeId> emptyPageDataResult = PageData.emptyPageData();
    when(edgeService.findEdgeIdsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeId> actualFindEdgeIdsByEntityIdResult =
        baseRelatedEdgesService.findEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new TimePageLink(3));

    // Assert
    verify(edgeService)
        .findEdgeIdsByTenantIdAndEntityId(
            isA(TenantId.class), isA(EntityId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link BaseRelatedEdgesService#publishRelatedEdgeIdsEvictEvent(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link BaseRelatedEdgesService#publishRelatedEdgeIdsEvictEvent(TenantId,
   * EntityId)}
   */
  @Test
  @DisplayName("Test publishRelatedEdgeIdsEvictEvent(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelatedEdgesService.publishRelatedEdgeIdsEvictEvent(TenantId, EntityId)"
  })
  void testPublishRelatedEdgeIdsEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<RelatedEdgesCacheKey>any());

    // Act
    baseRelatedEdgesService.publishRelatedEdgeIdsEvictEvent(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(RelatedEdgesCacheKey.class));
  }
}
