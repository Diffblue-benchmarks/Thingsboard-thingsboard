package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.relation.BaseRelationService;
import org.thingsboard.server.dao.relation.RelationCaffeineCache;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;
import org.thingsboard.server.service.entitiy.entity.relation.DefaultTbEntityRelationService;

class EntityRelationControllerDiffblueTest {
  /**
   * Test {@link EntityRelationController#saveRelation(EntityRelation)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityRelationController#saveRelation(EntityRelation)}
   */
  @Test
  @DisplayName("Test saveRelation(EntityRelation); then throw IllegalArgumentException")
  void testSaveRelation_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    EntityRelationController entityRelationController = new EntityRelationController(
        new DefaultTbEntityRelationService(new BaseRelationService(relationDao, entityService, cache, eventPublisher,
            executor, new JpaRelationQueryExecutorService())));
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getFrom()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityRelationController.saveRelation(relation));
    verify(relation).getFrom();
  }

  /**
   * Test {@link EntityRelationController#saveRelationV2(EntityRelation)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EntityRelationController#saveRelationV2(EntityRelation)}
   */
  @Test
  @DisplayName("Test saveRelationV2(EntityRelation); then throw IllegalArgumentException")
  void testSaveRelationV2_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    RelationCaffeineCache cache = new RelationCaffeineCache(new CaffeineCacheManager());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();
    EntityRelationController entityRelationController = new EntityRelationController(
        new DefaultTbEntityRelationService(new BaseRelationService(relationDao, entityService, cache, eventPublisher,
            executor, new JpaRelationQueryExecutorService())));
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getFrom()).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> entityRelationController.saveRelationV2(relation));
    verify(relation).getFrom();
  }
}
