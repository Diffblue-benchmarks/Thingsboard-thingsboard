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
package org.thingsboard.server.dao.relation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.CacheSpecsMap;
import org.thingsboard.server.cache.TBRedisClusterConfiguration;
import org.thingsboard.server.cache.TbCacheValueWrapper;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationEntityTypeFilter;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationCacheValue.RelationCacheValueBuilder;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.relation.JpaRelationDao;
import org.thingsboard.server.dao.sql.relation.JpaRelationQueryExecutorService;

@ContextConfiguration(classes = {BaseRelationService.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseRelationServiceDiffblueTest {
  @Autowired private BaseRelationService baseRelationService;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private JpaRelationQueryExecutorService jpaRelationQueryExecutorService;

  @MockBean private RelationDao relationDao;

  @MockBean private TbTransactionalCache<RelationCacheKey, RelationCacheValue> tbTransactionalCache;

  /**
   * Test {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelationAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Boolean> createResult = SettableFuture.create();
    when(relationDao.checkRelationAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Boolean> actualCheckRelationAsyncResult =
        baseRelationService.checkRelationAsync(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .checkRelationAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
    assertTrue(actualCheckRelationAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualCheckRelationAsyncResult);
  }

  /**
   * Test {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelationAsync_thenThrowRuntimeException() {
    // Arrange
    when(relationDao.checkRelationAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.checkRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(relationDao)
        .checkRelationAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelationAsync_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.checkRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelationAsync_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.checkRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelationAsync_whenNull_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.checkRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                null,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelationAsync_whenNull_thenThrowDataValidationException3() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.checkRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                "Relation Type",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#checkRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.checkRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelationAsync_whenNull_thenThrowDataValidationException4() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.checkRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                null));
  }

  /**
   * Test {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao} {@link RelationDao#checkRelation(TenantId, EntityId, EntityId,
   *       String, RelationTypeGroup)} return {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRelationService.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_givenRelationDaoCheckRelationReturnFalse_thenReturnFalse() {
    // Arrange
    when(relationDao.checkRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(false);

    // Act
    boolean actualCheckRelationResult =
        baseRelationService.checkRelation(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .checkRelation(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
    assertFalse(actualCheckRelationResult);
  }

  /**
   * Test {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao} {@link RelationDao#checkRelation(TenantId, EntityId, EntityId,
   *       String, RelationTypeGroup)} return {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRelationService.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_givenRelationDaoCheckRelationReturnTrue_thenReturnTrue() {
    // Arrange
    when(relationDao.checkRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(true);

    // Act
    boolean actualCheckRelationResult =
        baseRelationService.checkRelation(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .checkRelation(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
    assertTrue(actualCheckRelationResult);
  }

  /**
   * Test {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRelationService.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_givenRelationDao_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.checkRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRelationService.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_givenRelationDao_whenNull_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.checkRelation(
                ModelConstants.SYSTEM_TENANT,
                null,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRelationService.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_givenRelationDao_whenNull_thenThrowDataValidationException3() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.checkRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                "Relation Type",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRelationService.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_givenRelationDao_whenNull_thenThrowDataValidationException4() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.checkRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                null));
  }

  /**
   * Test {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRelationService.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_thenThrowRuntimeException() {
    // Arrange
    when(relationDao.checkRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.checkRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(relationDao)
        .checkRelation(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#checkRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRelationService.checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testCheckRelation_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.checkRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <p>Method under test: {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenReturn(entityRelation);

    // Act
    EntityRelation actualRelation =
        baseRelationService.getRelation(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
    assertSame(entityRelation, actualRelation);
  }

  /**
   * Test {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaRelationDao#getRelation(TenantId, EntityId, EntityId, String,
   *       RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation_thenCallsGetRelation() {
    // Arrange
    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    EntityRelation entityRelation = new EntityRelation();
    when(relationDao.getRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelation);
    BaseEntityService entityService = new BaseEntityService();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    RelationRedisCache cache =
        new RelationRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    EntityRelation actualRelation =
        baseRelationService.getRelation(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .getRelation(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
    assertSame(entityRelation, actualRelation);
  }

  /**
   * Test {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.getRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
  }

  /**
   * Test {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.getRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.getRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation_whenNull_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.getRelation(
                ModelConstants.SYSTEM_TENANT,
                null,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation_whenNull_thenThrowDataValidationException3() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.getRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                "Relation Type",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#getRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.getRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testGetRelation_whenNull_thenThrowDataValidationException4() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.getRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                null));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(null, BaseEntityService.NULL_CUSTOMER_ID, "Executing saveRelation [{}]");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation2() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, null, "Executing saveRelation [{}]");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation3() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relationDao.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(entityRelation);
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing saveRelation [{}]");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation_givenEmptyString() {
    // Arrange
    EntityRelation relation = new EntityRelation(new EntityRelation());
    relation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    relation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    relation.setType("");
    relation.setTypeGroup(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getFrom()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation_givenEntityRelationGetFromThrowRuntimeException() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getFrom()).thenThrow(new RuntimeException());
    when(relationDao.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(entityRelation);

    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(entityRelation).getFrom();
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
    verify(relationDao).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation_givenNull_whenEntityRelationGetTypeGroupReturnNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao} {@link RelationDao#saveRelation(TenantId, EntityRelation)}
   *       throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation_givenRelationDaoSaveRelationThrowRuntimeException() {
    // Arrange
    when(relationDao.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new RuntimeException());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing saveRelation [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relationDao).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@link EntityRelation#EntityRelation()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation_givenRelationDao_whenEntityRelation() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation()));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation_givenRelationDao_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache} {@link TbTransactionalCache#evict(Collection)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation_givenTbTransactionalCacheEvictThrowRuntimeException() {
    // Arrange
    when(relationDao.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());
    doThrow(new RuntimeException())
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing saveRelation [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationEventPublisher#publishEvent(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation_thenCallsPublishEvent() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    RelationDao relationDao = mock(RelationDao.class);
    when(relationDao.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(entityRelation);

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doThrow(new RuntimeException()).when(eventPublisher).publishEvent(Mockito.<Object>any());
    BaseEntityService entityService = new BaseEntityService();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    RelationRedisCache cache =
        new RelationRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing saveRelation [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(eventPublisher).publishEvent(isA(Object.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Then return {@link EntityRelation#EntityRelation()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelation BaseRelationService.saveRelation(TenantId, EntityRelation)"})
  public void testSaveRelation_thenReturnEntityRelation() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(relationDao.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(entityRelation);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing saveRelation [{}]");

    // Act
    EntityRelation actualSaveRelationResult =
        baseRelationService.saveRelation(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(entityRelation, actualSaveRelationResult);
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation(new EntityRelation());
    entityRelation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setType("");
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations2() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation(new EntityRelation());
    entityRelation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setType(null);
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link EntityRelation#EntityRelation()}.
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenArrayListAddEntityRelation_thenCallsEvict() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.saveRelations(Mockito.<TenantId>any(), Mockito.<List<EntityRelation>>any()))
        .thenReturn(entityRelationList);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    doNothing().when(entityRelation).setFrom(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setTo(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setType(Mockito.<String>any());
    doNothing().when(entityRelation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    entityRelation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setType("");
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act
    baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(entityRelation).setFrom(isA(EntityId.class));
    verify(entityRelation).setTo(isA(EntityId.class));
    verify(entityRelation).setType("");
    verify(entityRelation).setTypeGroup(RelationTypeGroup.COMMON);
    verify(relationDao).saveRelations(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link EntityRelation}.
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenArrayListAddEntityRelation_thenCallsEvict2() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationDao.saveRelations(Mockito.<TenantId>any(), Mockito.<List<EntityRelation>>any()))
        .thenReturn(entityRelationList);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    EntityRelation entityRelation2 = mock(EntityRelation.class);
    when(entityRelation2.getType()).thenReturn("Type");
    when(entityRelation2.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation2.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation2.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    doNothing().when(entityRelation2).setFrom(Mockito.<EntityId>any());
    doNothing().when(entityRelation2).setTo(Mockito.<EntityId>any());
    doNothing().when(entityRelation2).setType(Mockito.<String>any());
    doNothing().when(entityRelation2).setTypeGroup(Mockito.<RelationTypeGroup>any());
    entityRelation2.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation2.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation2.setType("");
    entityRelation2.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation2);

    // Act
    baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation2).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation2).getTo();
    verify(entityRelation).getType();
    verify(entityRelation2).getType();
    verify(entityRelation).getTypeGroup();
    verify(entityRelation2).getTypeGroup();
    verify(entityRelation2).setFrom(isA(EntityId.class));
    verify(entityRelation2).setTo(isA(EntityId.class));
    verify(entityRelation2).setType("");
    verify(entityRelation2).setTypeGroup(RelationTypeGroup.COMMON);
    verify(relationDao).saveRelations(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getFrom()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenEntityRelationGetFromReturnNull() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(null);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    doNothing().when(entityRelation).setFrom(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setTo(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setType(Mockito.<String>any());
    doNothing().when(entityRelation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    entityRelation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setType("");
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(entityRelation).setFrom(isA(EntityId.class));
    verify(entityRelation).setTo(isA(EntityId.class));
    verify(entityRelation).setType("");
    verify(entityRelation).setTypeGroup(RelationTypeGroup.COMMON);
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getTo()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenEntityRelationGetToReturnNull() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(null);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    doNothing().when(entityRelation).setFrom(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setTo(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setType(Mockito.<String>any());
    doNothing().when(entityRelation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    entityRelation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setType("");
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(entityRelation).setFrom(isA(EntityId.class));
    verify(entityRelation).setTo(isA(EntityId.class));
    verify(entityRelation).setType("");
    verify(entityRelation).setTypeGroup(RelationTypeGroup.COMMON);
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenEntityRelationGetTypeGroupReturnNull() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(null);
    doNothing().when(entityRelation).setFrom(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setTo(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setType(Mockito.<String>any());
    doNothing().when(entityRelation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    entityRelation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setType("");
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(entityRelation).setFrom(isA(EntityId.class));
    verify(entityRelation).setTo(isA(EntityId.class));
    verify(entityRelation).setType("");
    verify(entityRelation).setTypeGroup(RelationTypeGroup.COMMON);
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao} {@link RelationDao#saveRelations(TenantId, List)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenRelationDaoSaveRelationsThrowRuntimeException() {
    // Arrange
    when(relationDao.saveRelations(Mockito.<TenantId>any(), Mockito.<List<EntityRelation>>any()))
        .thenThrow(new RuntimeException());

    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    doNothing().when(entityRelation).setFrom(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setTo(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setType(Mockito.<String>any());
    doNothing().when(entityRelation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    entityRelation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setType("");
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(entityRelation).setFrom(isA(EntityId.class));
    verify(entityRelation).setTo(isA(EntityId.class));
    verify(entityRelation).setType("");
    verify(entityRelation).setTypeGroup(RelationTypeGroup.COMMON);
    verify(relationDao).saveRelations(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenRelationDao_whenArrayList_thenDoesNotThrow() {
    // Arrange, Act and Assert
    baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, new ArrayList<>());
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache} {@link TbTransactionalCache#evict(Collection)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations_givenTbTransactionalCacheEvictThrowRuntimeException() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.saveRelations(Mockito.<TenantId>any(), Mockito.<List<EntityRelation>>any()))
        .thenReturn(entityRelationList);
    doThrow(new RuntimeException())
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());

    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    doNothing().when(entityRelation).setFrom(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setTo(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setType(Mockito.<String>any());
    doNothing().when(entityRelation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    entityRelation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setType("");
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(entityRelation).setFrom(isA(EntityId.class));
    verify(entityRelation).setTo(isA(EntityId.class));
    verify(entityRelation).setType("");
    verify(entityRelation).setTypeGroup(RelationTypeGroup.COMMON);
    verify(relationDao).saveRelations(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelations(TenantId, List)}.
   *
   * <ul>
   *   <li>Then calls {@link RelationDao#saveRelations(TenantId, List)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelations(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.saveRelations(TenantId, List)"})
  public void testSaveRelations_thenCallsSaveRelations() {
    // Arrange
    when(relationDao.saveRelations(Mockito.<TenantId>any(), Mockito.<List<EntityRelation>>any()))
        .thenReturn(new ArrayList<>());

    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    doNothing().when(entityRelation).setFrom(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setTo(Mockito.<EntityId>any());
    doNothing().when(entityRelation).setType(Mockito.<String>any());
    doNothing().when(entityRelation).setTypeGroup(Mockito.<RelationTypeGroup>any());
    entityRelation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    entityRelation.setType("");
    entityRelation.setTypeGroup(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(entityRelation);

    // Act
    baseRelationService.saveRelations(ModelConstants.SYSTEM_TENANT, relations);

    // Assert
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(entityRelation).setFrom(isA(EntityId.class));
    verify(entityRelation).setTo(isA(EntityId.class));
    verify(entityRelation).setType("");
    verify(entityRelation).setTypeGroup(RelationTypeGroup.COMMON);
    verify(relationDao).saveRelations(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <p>Method under test: {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.saveRelationAsync(TenantId, EntityRelation)"
  })
  public void testSaveRelationAsync() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            null, BaseEntityService.NULL_CUSTOMER_ID, "Executing saveRelationAsync [{}]");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <p>Method under test: {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.saveRelationAsync(TenantId, EntityRelation)"
  })
  public void testSaveRelationAsync2() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, null, "Executing saveRelationAsync [{}]");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <p>Method under test: {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.saveRelationAsync(TenantId, EntityRelation)"
  })
  public void testSaveRelationAsync3() {
    // Arrange
    when(relationDao.saveRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
    verify(relationDao).saveRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.saveRelationAsync(TenantId, EntityRelation)"
  })
  public void testSaveRelationAsync_givenEmptyString() {
    // Arrange
    EntityRelation relation = new EntityRelation(new EntityRelation());
    relation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    relation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    relation.setType("");
    relation.setTypeGroup(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link EntityRelation} {@link EntityRelation#getTypeGroup()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.saveRelationAsync(TenantId, EntityRelation)"
  })
  public void testSaveRelationAsync_givenNull_whenEntityRelationGetTypeGroupReturnNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao} {@link RelationDao#saveRelationAsync(TenantId, EntityRelation)}
   *       return create.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.saveRelationAsync(TenantId, EntityRelation)"
  })
  public void testSaveRelationAsync_givenRelationDaoSaveRelationAsyncReturnCreate() {
    // Arrange
    SettableFuture<EntityRelation> createResult = SettableFuture.create();
    when(relationDao.saveRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(createResult);
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing saveRelationAsync [{}]");

    // Act
    baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(relationDao).saveRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@link EntityRelation#EntityRelation()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.saveRelationAsync(TenantId, EntityRelation)"
  })
  public void testSaveRelationAsync_givenRelationDao_whenEntityRelation() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.saveRelationAsync(
                ModelConstants.SYSTEM_TENANT, new EntityRelation()));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.saveRelationAsync(TenantId, EntityRelation)"
  })
  public void testSaveRelationAsync_givenRelationDao_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFuture#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.saveRelationAsync(TenantId, EntityRelation)"
  })
  public void testSaveRelationAsync_thenCallsAddListener() {
    // Arrange
    ListenableFuture<EntityRelation> listenableFuture = mock(ListenableFuture.class);
    doNothing()
        .when(listenableFuture)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    RelationDao relationDao = mock(RelationDao.class);
    when(relationDao.saveRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(listenableFuture);
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing saveRelationAsync [{}]");

    // Act
    baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(listenableFuture).addListener(isA(Runnable.class), isA(Executor.class));
    verify(relationDao).saveRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#saveRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.saveRelationAsync(TenantId, EntityRelation)"
  })
  public void testSaveRelationAsync_thenThrowRuntimeException() {
    // Arrange
    when(relationDao.saveRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new RuntimeException());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing saveRelationAsync [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.saveRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relationDao).saveRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup() {
    // Arrange
    when(relationDao.deleteRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteRelation(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup2() {
    // Arrange
    EntityRelation entityRelation = new EntityRelation();
    when(relationDao.deleteRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelation);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    EntityRelation actualDeleteRelationResult =
        baseRelationService.deleteRelation(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao)
        .deleteRelation(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
    assertSame(entityRelation, actualDeleteRelationResult);
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup3() {
    // Arrange
    when(relationDao.deleteRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(new EntityRelation());
    doThrow(new RuntimeException())
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao)
        .deleteRelation(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup4() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getFrom()).thenThrow(new RuntimeException());
    when(relationDao.deleteRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelation);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(entityRelation).getFrom();
    verify(relationDao)
        .deleteRelation(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>Then calls {@link EntityRelation#getTo()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_thenCallsGetTo() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relationDao.deleteRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelation);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteRelation(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        BaseEntityService.NULL_CUSTOMER_ID,
        "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao)
        .deleteRelation(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_thenReturnNull() {
    // Arrange
    when(relationDao.deleteRelation(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(null);

    // Act
    EntityRelation actualDeleteRelationResult =
        baseRelationService.deleteRelation(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .deleteRelation(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
    assertNull(actualDeleteRelationResult);
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_whenNull2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                null,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_whenNull3() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                "Relation Type",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityRelation BaseRelationService.deleteRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationWithTenantIdFromToRelationTypeTypeGroup_whenNull4() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelation(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                null));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation() {
    // Arrange
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new RuntimeException());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing DeleteRelation [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation2() {
    // Arrange
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());
    doThrow(new RuntimeException())
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing DeleteRelation [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation3() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            null, BaseEntityService.NULL_CUSTOMER_ID, "Executing DeleteRelation [{}]");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation4() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, null, "Executing DeleteRelation [{}]");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation5() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(entityRelation);
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing DeleteRelation [{}]");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation6() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getFrom()).thenThrow(new RuntimeException());
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(entityRelation);
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing DeleteRelation [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(entityRelation).getFrom();
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation7() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(entityRelation);
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());

    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(relation).getFrom();
    verify(entityRelation).getTo();
    verify(relation).getTo();
    verify(entityRelation).getType();
    verify(relation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relation).getTypeGroup();
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation_givenEmptyString() {
    // Arrange
    EntityRelation relation = new EntityRelation(new EntityRelation());
    relation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    relation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    relation.setType("");
    relation.setTypeGroup(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation_givenNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@link EntityRelation#EntityRelation()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation_givenRelationDao_whenEntityRelation() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation()));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation_givenRelationDao_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationEventPublisher#publishEvent(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation_thenCallsPublishEvent() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    RelationDao relationDao = mock(RelationDao.class);
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(entityRelation);

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doThrow(new RuntimeException()).when(eventPublisher).publishEvent(Mockito.<Object>any());
    BaseEntityService entityService = new BaseEntityService();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    RelationRedisCache cache =
        new RelationRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing DeleteRelation [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation));
    verify(eventPublisher).publishEvent(isA(Object.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation_thenReturnFalse() {
    // Arrange
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(null);
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing DeleteRelation [{}]");

    // Act
    boolean actualDeleteRelationResult =
        baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertFalse(actualDeleteRelationResult);
  }

  /**
   * Test {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRelationService.deleteRelation(TenantId, EntityRelation)"})
  public void testDeleteRelationWithTenantIdRelation_thenReturnTrue() {
    // Arrange
    when(relationDao.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing DeleteRelation [{}]");

    // Act
    boolean actualDeleteRelationResult =
        baseRelationService.deleteRelation(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertTrue(actualDeleteRelationResult);
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup() {
    // Arrange
    SettableFuture<EntityRelation> createResult = SettableFuture.create();
    when(relationDao.deleteRelationAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(createResult);

    // Act
    baseRelationService.deleteRelationAsync(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        BaseEntityService.NULL_CUSTOMER_ID,
        "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .deleteRelationAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup2() {
    // Arrange
    when(relationDao.deleteRelationAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteRelationAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup3() {
    // Arrange
    ListenableFutureTask<EntityRelation> listenableFutureTask = mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(relationDao.deleteRelationAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(listenableFutureTask);

    // Act
    baseRelationService.deleteRelationAsync(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        BaseEntityService.NULL_CUSTOMER_ID,
        "Relation Type",
        RelationTypeGroup.COMMON);

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(relationDao)
        .deleteRelationAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup4() {
    // Arrange
    ListenableFutureTask<EntityRelation> listenableFutureTask = mock(ListenableFutureTask.class);
    doThrow(new RuntimeException())
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(relationDao.deleteRelationAsync(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(relationDao)
        .deleteRelationAsync(
            isA(TenantId.class),
            isA(EntityId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup_whenNull2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                null,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup_whenNull3() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                "Relation Type",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId, EntityId, String,
   * RelationTypeGroup)} with {@code tenantId}, {@code from}, {@code to}, {@code relationType},
   * {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityId,
   * EntityId, String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testDeleteRelationAsyncWithTenantIdFromToRelationTypeTypeGroup_whenNull4() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelationAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                null));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation() {
    // Arrange
    SettableFuture<EntityRelation> createResult = SettableFuture.create();
    when(relationDao.deleteRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(createResult);
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing deleteRelationAsync [{}]");

    // Act
    baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(relationDao).deleteRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation2() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            null, BaseEntityService.NULL_CUSTOMER_ID, "Executing deleteRelationAsync [{}]");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation3() {
    // Arrange
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, null, "Executing deleteRelationAsync [{}]");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation4() {
    // Arrange
    when(relationDao.deleteRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
    verify(relationDao).deleteRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation_givenEmptyString() {
    // Arrange
    EntityRelation relation = new EntityRelation(new EntityRelation());
    relation.setFrom(BaseEntityService.NULL_CUSTOMER_ID);
    relation.setTo(BaseEntityService.NULL_CUSTOMER_ID);
    relation.setType("");
    relation.setTypeGroup(RelationTypeGroup.COMMON);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation_givenNull() {
    // Arrange
    EntityRelation relation = mock(EntityRelation.class);
    when(relation.getType()).thenReturn("Type");
    when(relation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(relation.getTypeGroup()).thenReturn(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relation).getFrom();
    verify(relation).getTo();
    verify(relation).getType();
    verify(relation).getTypeGroup();
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@link EntityRelation#EntityRelation()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation_givenRelationDao_whenEntityRelation() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteRelationAsync(
                ModelConstants.SYSTEM_TENANT, new EntityRelation()));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation_givenRelationDao_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFuture#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation_thenCallsAddListener() {
    // Arrange
    ListenableFuture<EntityRelation> listenableFuture = mock(ListenableFuture.class);
    doNothing()
        .when(listenableFuture)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    RelationDao relationDao = mock(RelationDao.class);
    when(relationDao.deleteRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(listenableFuture);
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing deleteRelationAsync [{}]");

    // Act
    baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation);

    // Assert
    verify(listenableFuture).addListener(isA(Runnable.class), isA(Executor.class));
    verify(relationDao).deleteRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)} with {@code
   * tenantId}, {@code relation}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteRelationAsync(TenantId, EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.deleteRelationAsync(TenantId, EntityRelation)"
  })
  public void testDeleteRelationAsyncWithTenantIdRelation_thenThrowRuntimeException() {
    // Arrange
    when(relationDao.deleteRelationAsync(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new RuntimeException());
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Executing deleteRelationAsync [{}]");

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.deleteRelationAsync(ModelConstants.SYSTEM_TENANT, relation));
    verify(relationDao).deleteRelationAsync(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityCommonRelations(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityCommonRelations(TenantId, EntityId)"})
  public void testDeleteEntityCommonRelations() {
    // Arrange
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteEntityCommonRelations(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityCommonRelations(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityCommonRelations(TenantId, EntityId)"})
  public void testDeleteEntityCommonRelations2() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    doThrow(new RuntimeException())
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteEntityCommonRelations(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link RelationDao#deleteOutboundRelations(TenantId, EntityId,
   *       RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityCommonRelations(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityCommonRelations(TenantId, EntityId)"})
  public void testDeleteEntityCommonRelations_thenCallsDeleteOutboundRelations() {
    // Arrange
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    // Act
    baseRelationService.deleteEntityCommonRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityCommonRelations(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityCommonRelations(TenantId, EntityId)"})
  public void testDeleteEntityCommonRelations_thenCallsEvict() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityCommonRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityCommonRelations(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityCommonRelations(TenantId, EntityId)"})
  public void testDeleteEntityCommonRelations_thenCallsGetFrom() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);

    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<Object>any());
    BaseEntityService entityService = new BaseEntityService();
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    baseRelationService.deleteEntityCommonRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(eventPublisher).publishEvent(isA(Object.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityCommonRelations(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityCommonRelations(TenantId, EntityId)"})
  public void testDeleteEntityCommonRelations_thenCallsGetFrom2() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);

    ArrayList<EntityRelation> entityRelationList2 = new ArrayList<>();
    entityRelationList2.add(new EntityRelation());

    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList2);

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<Object>any());
    BaseEntityService entityService = new BaseEntityService();
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    baseRelationService.deleteEntityCommonRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(eventPublisher, atLeast(1)).publishEvent(Mockito.<Object>any());
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationEventPublisher#publishEvent(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityCommonRelations(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityCommonRelations(TenantId, EntityId)"})
  public void testDeleteEntityCommonRelations_thenCallsPublishEvent() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());

    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<Object>any());
    BaseEntityService entityService = new BaseEntityService();
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    baseRelationService.deleteEntityCommonRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(eventPublisher).publishEvent(isA(Object.class));
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityCommonRelations(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityCommonRelations(TenantId,
   * EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityCommonRelations(TenantId, EntityId)"})
  public void testDeleteEntityCommonRelations_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteEntityCommonRelations(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)} with {@code
   * tenantId}, {@code entityId}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityRelations(TenantId, EntityId)"})
  public void testDeleteEntityRelationsWithTenantIdEntityId() {
    // Arrange
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteEntityRelations(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)} with {@code
   * tenantId}, {@code entityId}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityRelations(TenantId, EntityId)"})
  public void testDeleteEntityRelationsWithTenantIdEntityId2() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList);
    doThrow(new RuntimeException())
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteEntityRelations(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.deleteEntityRelations(
                ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup2() {
    // Arrange
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup3() {
    // Arrange
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteEntityRelations(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup4() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    doThrow(new RuntimeException())
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteEntityRelations(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup5() {
    // Arrange
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null);

    // Assert
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup6() {
    // Arrange
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.deleteEntityRelations(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup7() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());

    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<Object>any());
    BaseEntityService entityService = new BaseEntityService();
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(eventPublisher).publishEvent(isA(Object.class));
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup8() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);

    ArrayList<EntityRelation> entityRelationList2 = new ArrayList<>();
    entityRelationList2.add(new EntityRelation());

    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList2);

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<Object>any());
    BaseEntityService entityService = new BaseEntityService();
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(eventPublisher, atLeast(1)).publishEvent(Mockito.<Object>any());
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup_thenCallsEvict() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup_thenCallsGetFrom() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)}
   * with {@code tenantId}, {@code entityId}, {@code relationTypeGroup}.
   *
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.deleteEntityRelations(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testDeleteEntityRelationsWithTenantIdEntityIdRelationTypeGroup_thenCallsGetFrom2() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);

    ArrayList<EntityRelation> entityRelationList2 = new ArrayList<>();
    entityRelationList2.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<Collection<RelationCacheKey>>any());
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao)
        .deleteInboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    verify(relationDao)
        .deleteOutboundRelations(
            isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)} with {@code
   * tenantId}, {@code entityId}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityRelations(TenantId, EntityId)"})
  public void testDeleteEntityRelationsWithTenantIdEntityId_givenTbTransactionalCache() {
    // Arrange
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)} with {@code
   * tenantId}, {@code entityId}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityRelations(TenantId, EntityId)"})
  public void testDeleteEntityRelationsWithTenantIdEntityId_thenCallsEvict() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)} with {@code
   * tenantId}, {@code entityId}.
   *
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityRelations(TenantId, EntityId)"})
  public void testDeleteEntityRelationsWithTenantIdEntityId_thenCallsGetFrom() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)} with {@code
   * tenantId}, {@code entityId}.
   *
   * <ul>
   *   <li>Then calls {@link EntityRelation#getFrom()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityRelations(TenantId, EntityId)"})
  public void testDeleteEntityRelationsWithTenantIdEntityId_thenCallsGetFrom2() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);

    ArrayList<EntityRelation> entityRelationList2 = new ArrayList<>();
    entityRelationList2.add(new EntityRelation());
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<RelationCacheKey>>any());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache, atLeast(1)).evict(Mockito.<Collection<RelationCacheKey>>any());
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)} with {@code
   * tenantId}, {@code entityId}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationEventPublisher#publishEvent(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityRelations(TenantId, EntityId)"})
  public void testDeleteEntityRelationsWithTenantIdEntityId_thenCallsPublishEvent() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());

    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<Object>any());
    BaseEntityService entityService = new BaseEntityService();
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(eventPublisher).publishEvent(isA(Object.class));
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)} with {@code
   * tenantId}, {@code entityId}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationEventPublisher#publishEvent(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityRelations(TenantId, EntityId)"})
  public void testDeleteEntityRelationsWithTenantIdEntityId_thenCallsPublishEvent2() {
    // Arrange
    EntityRelation entityRelation = mock(EntityRelation.class);
    when(entityRelation.getType()).thenReturn("Type");
    when(entityRelation.getFrom()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTo()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(entityRelation.getTypeGroup()).thenReturn(RelationTypeGroup.COMMON);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);

    ArrayList<EntityRelation> entityRelationList2 = new ArrayList<>();
    entityRelationList2.add(new EntityRelation());

    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.deleteInboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList);
    when(relationDao.deleteOutboundRelations(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityRelationList2);

    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    doNothing().when(eventPublisher).publishEvent(Mockito.<Object>any());
    BaseEntityService entityService = new BaseEntityService();
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            null,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    baseRelationService.deleteEntityRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(eventPublisher, atLeast(1)).publishEvent(Mockito.<Object>any());
    verify(entityRelation).getFrom();
    verify(entityRelation).getTo();
    verify(entityRelation).getType();
    verify(entityRelation).getTypeGroup();
    verify(relationDao).deleteInboundRelations(isA(TenantId.class), isA(EntityId.class));
    verify(relationDao).deleteOutboundRelations(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)} with {@code
   * tenantId}, {@code entityId}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#deleteEntityRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.deleteEntityRelations(TenantId, EntityId)"})
  public void testDeleteEntityRelationsWithTenantIdEntityId_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.deleteEntityRelations(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache} {@link
   *       TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function,
   *       boolean)} return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRelationService.findByFrom(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindByFrom_givenTbTransactionalCacheGetAndPutInTransactionReturnArrayList() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindByFromResult =
        baseRelationService.findByFrom(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
    assertTrue(actualFindByFromResult.isEmpty());
  }

  /**
   * Test {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRelationService.findByFrom(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindByFrom_givenTbTransactionalCache_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByFrom(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRelationService.findByFrom(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindByFrom_givenTbTransactionalCache_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByFrom(
                ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaRelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRelationService.findByFrom(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindByFrom_thenCallsFindAllByFrom() {
    // Arrange
    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.findAllByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    BaseEntityService entityService = new BaseEntityService();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    RelationRedisCache cache =
        new RelationRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    List<EntityRelation> actualFindByFromResult =
        baseRelationService.findByFrom(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .findAllByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    assertTrue(actualFindByFromResult.isEmpty());
  }

  /**
   * Test {@link BaseRelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRelationService.findByFrom(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindByFrom_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.findByFrom(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
  }

  /**
   * Test {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAsync(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByFromAsync(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindByFromAsync_givenRelationDao_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByFromAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link RelationDao}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAsync(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByFromAsync(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindByFromAsync_givenRelationDao_whenNull_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByFromAsync(
                ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAsync(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByFromAsync(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindByFromAsync_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    TbCacheValueWrapper<RelationCacheValue> tbCacheValueWrapper = mock(TbCacheValueWrapper.class);

    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();

    RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    when(tbCacheValueWrapper.get()).thenReturn(relationResult.relations(new ArrayList<>()).build());

    TbTransactionalCache<RelationCacheKey, RelationCacheValue> cache =
        mock(TbTransactionalCache.class);
    when(cache.get(Mockito.<RelationCacheKey>any())).thenReturn(tbCacheValueWrapper);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = mock(JpaExecutorService.class);

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    ListenableFuture<List<EntityRelation>> actualFindByFromAsyncResult =
        baseRelationService.findByFromAsync(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(tbCacheValueWrapper, atLeast(1)).get();
    verify(cache).get(isA(RelationCacheKey.class));
    assertTrue(actualFindByFromAsyncResult.get().isEmpty());
    assertTrue(actualFindByFromAsyncResult.isDone());
  }

  /**
   * Test {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAsync(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByFromAsync(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindByFromAsync_thenReturnSettableFuture() {
    // Arrange
    JpaExecutorService executor = mock(JpaExecutorService.class);
    SettableFuture<Object> createResult = SettableFuture.create();
    when(executor.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    RelationRedisCache cache =
        new RelationRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    ListenableFuture<List<EntityRelation>> actualFindByFromAsyncResult =
        baseRelationService.findByFromAsync(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(executor).submit(isA(Callable.class));
    assertTrue(actualFindByFromAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindByFromAsyncResult);
  }

  /**
   * Test {@link BaseRelationService#findByFromAsync(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAsync(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByFromAsync(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindByFromAsync_thenThrowRuntimeException() {
    // Arrange
    TbCacheValueWrapper<RelationCacheValue> tbCacheValueWrapper = mock(TbCacheValueWrapper.class);
    when(tbCacheValueWrapper.get()).thenThrow(new RuntimeException());

    TbTransactionalCache<RelationCacheKey, RelationCacheValue> cache =
        mock(TbTransactionalCache.class);
    when(cache.get(Mockito.<RelationCacheKey>any())).thenReturn(tbCacheValueWrapper);
    JpaRelationDao relationDao = new JpaRelationDao();
    BaseEntityService entityService = new BaseEntityService();
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = mock(JpaExecutorService.class);

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.findByFromAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(tbCacheValueWrapper).get();
    verify(cache).get(isA(RelationCacheKey.class));
  }

  /**
   * Test {@link BaseRelationService#findInfoByFrom(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService} {@link JpaExecutorService#submit(Callable)} return
   *       create.
   *   <li>Then calls {@link JpaExecutorService#submit(Callable)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByFrom(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindInfoByFrom_givenJpaExecutorServiceSubmitReturnCreate_thenCallsSubmit() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    baseRelationService.findInfoByFrom(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link BaseRelationService#findInfoByFrom(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByFrom(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindInfoByFrom_givenJpaExecutorService_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findInfoByFrom(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test {@link BaseRelationService#findInfoByFrom(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByFrom(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindInfoByFrom_givenJpaExecutorService_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findInfoByFrom(
                ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findInfoByFrom(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByFrom(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindInfoByFrom_givenListenableFutureTaskAddListenerDoesNothing() {
    // Arrange
    ListenableFutureTask<Object> listenableFutureTask = mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any()))
        .thenReturn(listenableFutureTask);

    // Act
    baseRelationService.findInfoByFrom(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link BaseRelationService#findInfoByFrom(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByFrom(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByFrom(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindInfoByFrom_thenThrowRuntimeException() {
    // Arrange
    ListenableFutureTask<Object> listenableFutureTask = mock(ListenableFutureTask.class);
    doThrow(new RuntimeException())
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any()))
        .thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.findInfoByFrom(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link BaseRelationService#findByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRelationService.findByFromAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByFromAndType() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindByFromAndTypeResult =
        baseRelationService.findByFromAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
    assertTrue(actualFindByFromAndTypeResult.isEmpty());
  }

  /**
   * Test {@link BaseRelationService#findByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaRelationDao#findAllByFromAndType(TenantId, EntityId, String,
   *       RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRelationService.findByFromAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByFromAndType_thenCallsFindAllByFromAndType() {
    // Arrange
    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.findAllByFromAndType(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    BaseEntityService entityService = new BaseEntityService();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    RelationRedisCache cache =
        new RelationRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    List<EntityRelation> actualFindByFromAndTypeResult =
        baseRelationService.findByFromAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .findAllByFromAndType(
            isA(TenantId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
    assertTrue(actualFindByFromAndTypeResult.isEmpty());
  }

  /**
   * Test {@link BaseRelationService#findByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRelationService.findByFromAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByFromAndType_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.findByFromAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
  }

  /**
   * Test {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByFromAndTypeAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntityRelation>> actualFindByFromAndTypeAsyncResult =
        baseRelationService.findByFromAndTypeAsync(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindByFromAndTypeAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindByFromAndTypeAsyncResult);
  }

  /**
   * Test {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByFromAndTypeAsync_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByFromAndTypeAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByFromAndTypeAsync_whenEmptyString_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByFromAndTypeAsync(
                ModelConstants.SYSTEM_TENANT, null, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByFromAndTypeAsync_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByFromAndTypeAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code Relation Type}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByFromAndTypeAsync(TenantId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByFromAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByFromAndTypeAsync_whenRelationType_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByFromAndTypeAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                null));
  }

  /**
   * Test {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link JpaRelationDao} {@link JpaRelationDao#findAllByTo(TenantId, EntityId,
   *       RelationTypeGroup)} return {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link JpaRelationDao#findAllByTo(TenantId, EntityId, RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByTo(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRelationService.findByTo(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindByTo_givenJpaRelationDaoFindAllByToReturnArrayList_thenCallsFindAllByTo() {
    // Arrange
    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.findAllByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    BaseEntityService entityService = new BaseEntityService();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    RelationRedisCache cache =
        new RelationRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    List<EntityRelation> actualFindByToResult =
        baseRelationService.findByTo(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .findAllByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.COMMON));
    assertTrue(actualFindByToResult.isEmpty());
  }

  /**
   * Test {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache} {@link
   *       TbTransactionalCache#getAndPutInTransaction(Serializable, Supplier, Function, Function,
   *       boolean)} return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByTo(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRelationService.findByTo(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindByTo_givenTbTransactionalCacheGetAndPutInTransactionReturnArrayList() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindByToResult =
        baseRelationService.findByTo(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
    assertTrue(actualFindByToResult.isEmpty());
  }

  /**
   * Test {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByTo(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRelationService.findByTo(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindByTo_givenTbTransactionalCache_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByTo(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByTo(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRelationService.findByTo(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindByTo_givenTbTransactionalCache_whenNull_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByTo(
                ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByTo(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByTo(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRelationService.findByTo(TenantId, EntityId, RelationTypeGroup)"})
  public void testFindByTo_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.findByTo(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
  }

  /**
   * Test {@link BaseRelationService#findByToAsync(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAsync(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByToAsync(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindByToAsync_givenJpaExecutorService_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByToAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test {@link BaseRelationService#findByToAsync(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAsync(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByToAsync(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindByToAsync_givenJpaExecutorService_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByToAsync(
                ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByToAsync(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAsync(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByToAsync(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindByToAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntityRelation>> actualFindByToAsyncResult =
        baseRelationService.findByToAsync(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindByToAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindByToAsyncResult);
  }

  /**
   * Test {@link BaseRelationService#findInfoByTo(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService} {@link JpaExecutorService#submit(Callable)} return
   *       create.
   *   <li>Then calls {@link JpaExecutorService#submit(Callable)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByTo(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByTo(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindInfoByTo_givenJpaExecutorServiceSubmitReturnCreate_thenCallsSubmit() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    baseRelationService.findInfoByTo(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link BaseRelationService#findInfoByTo(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByTo(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByTo(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindInfoByTo_givenJpaExecutorService_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findInfoByTo(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, null));
  }

  /**
   * Test {@link BaseRelationService#findInfoByTo(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByTo(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByTo(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindInfoByTo_givenJpaExecutorService_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findInfoByTo(
                ModelConstants.SYSTEM_TENANT, null, RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findInfoByTo(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByTo(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByTo(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindInfoByTo_givenListenableFutureTaskAddListenerDoesNothing() {
    // Arrange
    ListenableFutureTask<Object> listenableFutureTask = mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any()))
        .thenReturn(listenableFutureTask);

    // Act
    baseRelationService.findInfoByTo(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, RelationTypeGroup.COMMON);

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link BaseRelationService#findInfoByTo(TenantId, EntityId, RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByTo(TenantId, EntityId,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByTo(TenantId, EntityId, RelationTypeGroup)"
  })
  public void testFindInfoByTo_thenThrowRuntimeException() {
    // Arrange
    ListenableFutureTask<Object> listenableFutureTask = mock(ListenableFutureTask.class);
    doThrow(new RuntimeException())
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any()))
        .thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.findInfoByTo(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                RelationTypeGroup.COMMON));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRelationService.findByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndType() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualFindByToAndTypeResult =
        baseRelationService.findByToAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
    assertTrue(actualFindByToAndTypeResult.isEmpty());
  }

  /**
   * Test {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaRelationDao#findAllByToAndType(TenantId, EntityId, String,
   *       RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRelationService.findByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndType_thenCallsFindAllByToAndType() {
    // Arrange
    JpaRelationDao relationDao = mock(JpaRelationDao.class);
    when(relationDao.findAllByToAndType(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<String>any(),
            Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    BaseEntityService entityService = new BaseEntityService();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    RelationRedisCache cache =
        new RelationRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    List<EntityRelation> actualFindByToAndTypeResult =
        baseRelationService.findByToAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(relationDao)
        .findAllByToAndType(
            isA(TenantId.class),
            isA(EntityId.class),
            eq("Relation Type"),
            eq(RelationTypeGroup.COMMON));
    assertTrue(actualFindByToAndTypeResult.isEmpty());
  }

  /**
   * Test {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRelationService.findByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndType_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.findByToAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                RelationTypeGroup.COMMON));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
  }

  /**
   * Test {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRelationService.findByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndType_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByToAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRelationService.findByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndType_whenEmptyString_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByToAndType(
                ModelConstants.SYSTEM_TENANT, null, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRelationService.findByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndType_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByToAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndType(TenantId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRelationService.findByToAndType(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndType_whenNull_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByToAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                null));
  }

  /**
   * Test {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndTypeAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntityRelation>> actualFindByToAndTypeAsyncResult =
        baseRelationService.findByToAndTypeAsync(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Relation Type",
            RelationTypeGroup.COMMON);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindByToAndTypeAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindByToAndTypeAsyncResult);
  }

  /**
   * Test {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndTypeAsync_whenEmptyString_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByToAndTypeAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndTypeAsync_whenEmptyString_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByToAndTypeAsync(
                ModelConstants.SYSTEM_TENANT, null, "", RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndTypeAsync_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByToAndTypeAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId, String,
   * RelationTypeGroup)}.
   *
   * <ul>
   *   <li>When {@code Relation Type}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByToAndTypeAsync(TenantId, EntityId,
   * String, RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByToAndTypeAsync(TenantId, EntityId, String, RelationTypeGroup)"
  })
  public void testFindByToAndTypeAsync_whenRelationType_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.findByToAndTypeAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Relation Type",
                null));
  }

  /**
   * Test {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}.
   *
   * <p>Method under test: {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByQuery(TenantId, EntityRelationsQuery)"
  })
  public void testFindByQuery() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(
            jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(
            BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act
    baseRelationService.findByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}.
   *
   * <p>Method under test: {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByQuery(TenantId, EntityRelationsQuery)"
  })
  public void testFindByQuery2() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(
            jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(
            BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 0, true));

    // Act
    baseRelationService.findByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       RelationEntityTypeFilter#RelationEntityTypeFilter()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByQuery(TenantId, EntityRelationsQuery)"
  })
  public void testFindByQuery_givenArrayListAddRelationEntityTypeFilter() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(
            jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);

    ArrayList<RelationEntityTypeFilter> filters = new ArrayList<>();
    filters.add(new RelationEntityTypeFilter());

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(filters);
    query.setParameters(
        new RelationsSearchParameters(
            BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act
    baseRelationService.findByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findByQuery(TenantId, EntityRelationsQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findByQuery(TenantId, EntityRelationsQuery)"
  })
  public void testFindByQuery_thenThrowRuntimeException() {
    // Arrange
    Mockito.<ListenableFuture<?>>when(
            jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenThrow(new RuntimeException());

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(
            BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.findByQuery(ModelConstants.SYSTEM_TENANT, query));
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link BaseRelationService#findInfoByQuery(TenantId, EntityRelationsQuery)}.
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByQuery(TenantId,
   * EntityRelationsQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByQuery(TenantId, EntityRelationsQuery)"
  })
  public void testFindInfoByQuery() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(
            jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(
            BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act
    baseRelationService.findInfoByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link BaseRelationService#findInfoByQuery(TenantId, EntityRelationsQuery)}.
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByQuery(TenantId,
   * EntityRelationsQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByQuery(TenantId, EntityRelationsQuery)"
  })
  public void testFindInfoByQuery2() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(
            jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(
            BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 0, true));

    // Act
    baseRelationService.findInfoByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link BaseRelationService#findInfoByQuery(TenantId, EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link
   *       RelationEntityTypeFilter#RelationEntityTypeFilter()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByQuery(TenantId,
   * EntityRelationsQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByQuery(TenantId, EntityRelationsQuery)"
  })
  public void testFindInfoByQuery_givenArrayListAddRelationEntityTypeFilter() {
    // Arrange
    SettableFuture<?> createResult = SettableFuture.create();
    Mockito.<ListenableFuture<?>>when(
            jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenReturn(createResult);

    ArrayList<RelationEntityTypeFilter> filters = new ArrayList<>();
    filters.add(new RelationEntityTypeFilter());

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(filters);
    query.setParameters(
        new RelationsSearchParameters(
            BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act
    baseRelationService.findInfoByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link BaseRelationService#findInfoByQuery(TenantId, EntityRelationsQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#findInfoByQuery(TenantId,
   * EntityRelationsQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRelationService.findInfoByQuery(TenantId, EntityRelationsQuery)"
  })
  public void testFindInfoByQuery_thenThrowRuntimeException() {
    // Arrange
    Mockito.<ListenableFuture<?>>when(
            jpaRelationQueryExecutorService.submit(Mockito.<Runnable>any()))
        .thenThrow(new RuntimeException());

    EntityRelationsQuery query = new EntityRelationsQuery();
    query.setFilters(new ArrayList<>());
    query.setParameters(
        new RelationsSearchParameters(
            BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseRelationService.findInfoByQuery(ModelConstants.SYSTEM_TENANT, query));
    verify(jpaRelationQueryExecutorService).submit(isA(Runnable.class));
  }

  /**
   * Test {@link BaseRelationService#removeRelations(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link BaseRelationService#removeRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.removeRelations(TenantId, EntityId)"})
  public void testRemoveRelations() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    baseRelationService.removeRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache, atLeast(1))
        .getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            eq(false));
  }

  /**
   * Test {@link BaseRelationService#removeRelations(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link EntityRelation#EntityRelation()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#removeRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.removeRelations(TenantId, EntityId)"})
  public void testRemoveRelations_givenArrayListAddEntityRelation() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(new EntityRelation());

    RelationDao relationDao = mock(RelationDao.class);
    when(relationDao.findAllByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(relationDao.findAllByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    BaseEntityService entityService = new BaseEntityService();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    RelationRedisCache cache =
        new RelationRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.removeRelations(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(relationDao, atLeast(1))
        .findAllByFrom(isA(TenantId.class), isA(EntityId.class), Mockito.<RelationTypeGroup>any());
    verify(relationDao, atLeast(1))
        .findAllByTo(isA(TenantId.class), isA(EntityId.class), Mockito.<RelationTypeGroup>any());
  }

  /**
   * Test {@link BaseRelationService#removeRelations(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#removeRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.removeRelations(TenantId, EntityId)"})
  public void testRemoveRelations_givenTbTransactionalCache_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRelationService.removeRelations(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRelationService#removeRelations(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link RelationDao#findAllByFrom(TenantId, EntityId, RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#removeRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.removeRelations(TenantId, EntityId)"})
  public void testRemoveRelations_thenCallsFindAllByFrom() {
    // Arrange
    RelationDao relationDao = mock(RelationDao.class);
    when(relationDao.findAllByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(relationDao.findAllByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    BaseEntityService entityService = new BaseEntityService();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    RelationRedisCache cache =
        new RelationRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());
    ApplicationEventPublisher eventPublisher = mock(ApplicationEventPublisher.class);
    JpaExecutorService executor = new JpaExecutorService();

    BaseRelationService baseRelationService =
        new BaseRelationService(
            relationDao,
            entityService,
            cache,
            eventPublisher,
            executor,
            new JpaRelationQueryExecutorService());

    // Act
    baseRelationService.removeRelations(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(relationDao, atLeast(1))
        .findAllByFrom(isA(TenantId.class), isA(EntityId.class), Mockito.<RelationTypeGroup>any());
    verify(relationDao, atLeast(1))
        .findAllByTo(isA(TenantId.class), isA(EntityId.class), Mockito.<RelationTypeGroup>any());
  }

  /**
   * Test {@link BaseRelationService#removeRelations(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#removeRelations(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.removeRelations(TenantId, EntityId)"})
  public void testRemoveRelations_thenThrowRuntimeException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<RelationCacheKey>any(),
            Mockito.<Supplier<Object>>any(),
            Mockito.<Function<RelationCacheValue, Object>>any(),
            Mockito.<Function<Object, RelationCacheValue>>any(),
            anyBoolean()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRelationService.removeRelations(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(
            isA(RelationCacheKey.class),
            isA(Supplier.class),
            isA(Function.class),
            isA(Function.class),
            eq(false));
  }

  /**
   * Test {@link BaseRelationService#validate(EntityId)} with {@code entity}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#validate(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.validate(EntityId)"})
  public void testValidateWithEntity_whenNull_customer_id_thenDoesNotThrow() {
    // Arrange, Act and Assert
    baseRelationService.validate(BaseEntityService.NULL_CUSTOMER_ID);
  }

  /**
   * Test {@link BaseRelationService#validate(EntityId)} with {@code entity}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#validate(EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRelationService.validate(EntityId)"})
  public void testValidateWithEntity_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseRelationService.validate((EntityId) null));
  }

  /**
   * Test {@link BaseRelationService#validate(EntityId, EntityId, String, RelationTypeGroup)} with
   * {@code from}, {@code to}, {@code type}, {@code typeGroup}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#validate(EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.validate(EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testValidateWithFromToTypeTypeGroup_whenEmptyString() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.validate(
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "",
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#validate(EntityId, EntityId, String, RelationTypeGroup)} with
   * {@code from}, {@code to}, {@code type}, {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#validate(EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.validate(EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testValidateWithFromToTypeTypeGroup_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.validate(
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                null,
                RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#validate(EntityId, EntityId, String, RelationTypeGroup)} with
   * {@code from}, {@code to}, {@code type}, {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#validate(EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.validate(EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testValidateWithFromToTypeTypeGroup_whenNull_thenThrowDataValidationException2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.validate(
                null, BaseEntityService.NULL_CUSTOMER_ID, "Type", RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#validate(EntityId, EntityId, String, RelationTypeGroup)} with
   * {@code from}, {@code to}, {@code type}, {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#validate(EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.validate(EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testValidateWithFromToTypeTypeGroup_whenNull_thenThrowDataValidationException3() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.validate(
                BaseEntityService.NULL_CUSTOMER_ID, null, "Type", RelationTypeGroup.COMMON));
  }

  /**
   * Test {@link BaseRelationService#validate(EntityId, EntityId, String, RelationTypeGroup)} with
   * {@code from}, {@code to}, {@code type}, {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#validate(EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.validate(EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testValidateWithFromToTypeTypeGroup_whenType_thenDoesNotThrow() {
    // Arrange, Act and Assert
    baseRelationService.validate(
        BaseEntityService.NULL_CUSTOMER_ID,
        BaseEntityService.NULL_CUSTOMER_ID,
        "Type",
        RelationTypeGroup.COMMON);
  }

  /**
   * Test {@link BaseRelationService#validate(EntityId, EntityId, String, RelationTypeGroup)} with
   * {@code from}, {@code to}, {@code type}, {@code typeGroup}.
   *
   * <ul>
   *   <li>When {@code Type}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRelationService#validate(EntityId, EntityId, String,
   * RelationTypeGroup)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRelationService.validate(EntityId, EntityId, String, RelationTypeGroup)"
  })
  public void testValidateWithFromToTypeTypeGroup_whenType_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRelationService.validate(
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                null));
  }
}
