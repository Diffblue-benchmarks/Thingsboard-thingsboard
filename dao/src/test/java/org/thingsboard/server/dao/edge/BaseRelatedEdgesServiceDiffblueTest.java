package org.thingsboard.server.dao.edge;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;

@ContextConfiguration(classes = {BaseRelatedEdgesService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseRelatedEdgesServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseRelatedEdgesService baseRelatedEdgesService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTransactionalCache<RelatedEdgesCacheKey, RelatedEdgesCacheValue> tbTransactionalCache;

  /**
   * Test {@link BaseRelatedEdgesService#handleEvictEvent(RelatedEdgesEvictEvent)}
   * with {@code RelatedEdgesEvictEvent}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelatedEdgesService#handleEvictEvent(RelatedEdgesEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithRelatedEdgesEvictEvent_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<RelatedEdgesCacheKey>any());

    // Act
    baseRelatedEdgesService
        .handleEvictEvent(new RelatedEdgesEvictEvent(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));

    // Assert
    verify(tbTransactionalCache).evict(isA(RelatedEdgesCacheKey.class));
  }

  /**
   * Test
   * {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   * <ul>
   *   <li>Given {@link EdgeService}.</li>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindEdgeIdsByEntityId_givenEdgeService_whenFirst_page_thenReturnNull() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelatedEdgesCacheKey>any(),
        Mockito.<Supplier<RelatedEdgesCacheValue>>any(), anyBoolean())).thenReturn(new RelatedEdgesCacheValue());

    // Act
    PageData<EdgeId> actualFindEdgeIdsByEntityIdResult = baseRelatedEdgesService.findEdgeIdsByEntityId(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelatedEdgesCacheKey.class), isA(Supplier.class),
        eq(false));
    assertNull(actualFindEdgeIdsByEntityIdResult);
  }

  /**
   * Test
   * {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   * <ul>
   *   <li>When {@link PageLink#PageLink(int)} with pageSize is
   * {@link BaseRelatedEdgesService#RELATED_EDGES_CACHE_ITEMS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindEdgeIdsByEntityId_whenPageLinkWithPageSizeIsRelated_edges_cache_items() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<RelatedEdgesCacheKey>any(),
        Mockito.<Supplier<RelatedEdgesCacheValue>>any(), anyBoolean())).thenReturn(new RelatedEdgesCacheValue());

    // Act
    PageData<EdgeId> actualFindEdgeIdsByEntityIdResult = baseRelatedEdgesService.findEdgeIdsByEntityId(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        new PageLink(BaseRelatedEdgesService.RELATED_EDGES_CACHE_ITEMS));

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(RelatedEdgesCacheKey.class), isA(Supplier.class),
        eq(false));
    assertNull(actualFindEdgeIdsByEntityIdResult);
  }

  /**
   * Test
   * {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   * <ul>
   *   <li>When {@link PageLink#PageLink(int)} with pageSize is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindEdgeIdsByEntityId_whenPageLinkWithPageSizeIsThree() {
    // Arrange
    PageData<EdgeId> emptyPageDataResult = PageData.emptyPageData();
    when(edgeService.findEdgeIdsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeId> actualFindEdgeIdsByEntityIdResult = baseRelatedEdgesService
        .findEdgeIdsByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new PageLink(3));

    // Assert
    verify(edgeService).findEdgeIdsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class), isA(PageLink.class));
    assertSame(actualFindEdgeIdsByEntityIdResult.EMPTY_PAGE_DATA, actualFindEdgeIdsByEntityIdResult);
  }

  /**
   * Test
   * {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   * <ul>
   *   <li>When {@link TimePageLink#TimePageLink(int)} with pageSize is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelatedEdgesService#findEdgeIdsByEntityId(TenantId, EntityId, PageLink)}
   */
  @Test
  public void testFindEdgeIdsByEntityId_whenTimePageLinkWithPageSizeIsThree() {
    // Arrange
    PageData<EdgeId> emptyPageDataResult = PageData.emptyPageData();
    when(edgeService.findEdgeIdsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeId> actualFindEdgeIdsByEntityIdResult = baseRelatedEdgesService
        .findEdgeIdsByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new TimePageLink(3));

    // Assert
    verify(edgeService).findEdgeIdsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class), isA(PageLink.class));
    assertSame(actualFindEdgeIdsByEntityIdResult.EMPTY_PAGE_DATA, actualFindEdgeIdsByEntityIdResult);
  }

  /**
   * Test
   * {@link BaseRelatedEdgesService#publishRelatedEdgeIdsEvictEvent(TenantId, EntityId)}.
   * <p>
   * Method under test:
   * {@link BaseRelatedEdgesService#publishRelatedEdgeIdsEvictEvent(TenantId, EntityId)}
   */
  @Test
  public void testPublishRelatedEdgeIdsEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<RelatedEdgesCacheKey>any());

    // Act
    baseRelatedEdgesService.publishRelatedEdgeIdsEvictEvent(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(RelatedEdgesCacheKey.class));
  }
}
