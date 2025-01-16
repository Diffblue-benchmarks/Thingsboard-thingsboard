package org.thingsboard.rule.engine.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.rule.engine.data.RelationsQuery;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.relation.RelationCaffeineCache;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;

class EntitiesRelatedEntityIdAsyncLoaderDiffblueTest {
  /**
   * Test
   * {@link EntitiesRelatedEntityIdAsyncLoader#findEntityAsync(TbContext, EntityId, RelationsQuery)}.
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException(String)} with
   * {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesRelatedEntityIdAsyncLoader#findEntityAsync(TbContext, EntityId, RelationsQuery)}
   */
  @Test
  @DisplayName("Test findEntityAsync(TbContext, EntityId, RelationsQuery); given IllegalStateException(String) with 'foo'")
  void testFindEntityAsync_givenIllegalStateExceptionWithFoo() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getRelationService()).thenThrow(new IllegalStateException("foo"));

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> EntitiesRelatedEntityIdAsyncLoader.findEntityAsync(ctx, null, relationsQuery));
    verify(ctx).getRelationService();
  }

  /**
   * Test
   * {@link EntitiesRelatedEntityIdAsyncLoader#findEntityAsync(TbContext, EntityId, RelationsQuery)}.
   * <ul>
   *   <li>Then calls {@link TbContext#getTenantId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntitiesRelatedEntityIdAsyncLoader#findEntityAsync(TbContext, EntityId, RelationsQuery)}
   */
  @Test
  @DisplayName("Test findEntityAsync(TbContext, EntityId, RelationsQuery); then calls getTenantId()")
  void testFindEntityAsync_thenCallsGetTenantId() {
    // Arrange
    TbContext ctx = mock(TbContext.class);
    when(ctx.getTenantId()).thenThrow(new IllegalStateException("_"));
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    when(ctx.getRelationService()).thenReturn(new BaseRelationService(relationDao, entityService, cache, eventPublisher,
        executor, new JpaRelationQueryExecutorService()));
    AlarmId originator = new AlarmId(UUID.randomUUID());

    RelationsQuery relationsQuery = new RelationsQuery();
    relationsQuery.setDirection(EntitySearchDirection.FROM);
    relationsQuery.setFetchLastLevelOnly(true);
    relationsQuery.setFilters(new ArrayList<>());
    relationsQuery.setMaxLevel(3);

    // Act and Assert
    assertThrows(IllegalStateException.class,
        () -> EntitiesRelatedEntityIdAsyncLoader.findEntityAsync(ctx, originator, relationsQuery));
    verify(ctx).getRelationService();
    verify(ctx).getTenantId();
  }
}
