/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.edge;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
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
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {BaseRelatedEdgesService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseRelatedEdgesServiceDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelatedEdgesService.handleEvictEvent(RelatedEdgesEvictEvent)"})
  public void testHandleEvictEventWithRelatedEdgesEvictEvent_thenCallsEvict() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRelatedEdgesService.findEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByEntityId_whenFirst_page_thenReturnNull() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRelatedEdgesService.findEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByEntityId_whenPageLinkWithPageSizeIsRelated_edges_cache_items() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRelatedEdgesService.findEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByEntityId_whenPageLinkWithPageSizeIsThree() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRelatedEdgesService.findEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByEntityId_whenTimePageLinkWithPageSizeIsThree() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelatedEdgesService.publishRelatedEdgeIdsEvictEvent(TenantId, EntityId)"
  })
  public void testPublishRelatedEdgeIdsEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<RelatedEdgesCacheKey>any());

    // Act
    baseRelatedEdgesService.publishRelatedEdgeIdsEvictEvent(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(RelatedEdgesCacheKey.class));
  }
}
