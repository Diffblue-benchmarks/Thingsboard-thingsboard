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
package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
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
import com.google.common.util.concurrent.SettableFuture;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.AggregationParams;
import org.thingsboard.server.common.data.kv.BaseDeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.DeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.IntervalType;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.dictionary.KeyDictionaryDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sqlts.ts.TsKvEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sqlts.sql.JpaSqlTimeseriesDao;
import org.thingsboard.server.dao.sqlts.ts.TsKvRepository;

@RunWith(MockitoJUnitRunner.class)
public class AbstractChunkedAggregationTimeseriesDaoDiffblueTest {
  @Mock private JpaExecutorService jpaExecutorService;

  @InjectMocks private JpaSqlTimeseriesDao jpaSqlTimeseriesDao;

  @Mock private KeyDictionaryDao keyDictionaryDao;

  @Mock private TsKvRepository tsKvRepository;

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#remove(TenantId, EntityId,
   * DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService} {@link JpaExecutorService#submit(Callable)} return
   *       create.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#remove(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.remove(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testRemove_givenJpaExecutorServiceSubmitReturnCreate_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Void> actualRemoveResult =
        jpaSqlTimeseriesDao.remove(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualRemoveResult instanceof SettableFuture);
    assertSame(createResult, actualRemoveResult);
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#savePartition(TenantId, EntityId, long,
   * String)}.
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#savePartition(TenantId,
   * EntityId, long, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.savePartition(TenantId, EntityId, long, String)"
  })
  public void testSavePartition() throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<Integer> actualSavePartitionResult =
        new JpaSqlTimeseriesDao()
            .savePartition(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, "Key");

    // Assert
    assertNull(actualSavePartitionResult.get());
    assertTrue(actualSavePartitionResult.isDone());
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   * with {@code tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(jpaExecutorService)
        .execute(Mockito.<Runnable>any());

    // Act
    jpaSqlTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   * with {@code tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries2() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", -1L, 1L));

    // Act
    jpaSqlTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, queries);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   * with {@code tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries3() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, Long.MIN_VALUE));

    // Act
    jpaSqlTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, queries);

    // Assert
    verify(jpaExecutorService, atLeast(1)).submit(Mockito.<Callable<Object>>any());
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   * with {@code tenantId}, {@code entityId}, {@code queries}.
   *
   * <ul>
   *   <li>When {@link AlarmId}.
   *   <li>Then calls {@link JpaExecutorService#submit(Callable)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries_whenAlarmId_thenCallsSubmit() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    AlarmId entityId = mock(AlarmId.class);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    BaseReadTsKvQuery baseReadTsKvQuery =
        new BaseReadTsKvQuery("Key", 1L, 1L, 42L, 1, Aggregation.MIN);
    queries.add(baseReadTsKvQuery);
    BaseReadTsKvQuery baseReadTsKvQuery2 =
        new BaseReadTsKvQuery("Key", 1L, 1L, 42L, 1, Aggregation.MIN);
    queries.add(baseReadTsKvQuery2);

    // Act
    jpaSqlTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(jpaExecutorService, atLeast(1)).submit(Mockito.<Callable<Object>>any());
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   * with {@code tenantId}, {@code entityId}, {@code queries}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link JpaExecutorService#execute(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries_whenArrayList_thenCallsExecute() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());

    // Act
    jpaSqlTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)} with {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery() {
    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getStartTs()).thenThrow(new IllegalArgumentException());
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaSqlTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(query).getAggParameters();
    verify(query).getStartTs();
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)} with {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery2() {
    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();

    AggregationParams aggregationParams = mock(AggregationParams.class);
    when(aggregationParams.getTzId()).thenReturn(ZoneOffset.ofTotalSeconds(1));
    when(aggregationParams.getAggregation()).thenReturn(Aggregation.MIN);
    when(aggregationParams.getIntervalType()).thenReturn(IntervalType.WEEK);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getKey()).thenThrow(new IllegalArgumentException());
    when(query.getAggParameters()).thenReturn(aggregationParams);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaSqlTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(aggregationParams).getAggregation();
    verify(aggregationParams).getIntervalType();
    verify(aggregationParams).getTzId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)} with {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery3() {
    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();

    AggregationParams aggregationParams = mock(AggregationParams.class);
    when(aggregationParams.getTzId()).thenReturn(ZoneOffset.ofTotalSeconds(1));
    when(aggregationParams.getAggregation()).thenReturn(Aggregation.MIN);
    when(aggregationParams.getIntervalType()).thenReturn(IntervalType.WEEK_ISO);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getKey()).thenThrow(new IllegalArgumentException());
    when(query.getAggParameters()).thenReturn(aggregationParams);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaSqlTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(aggregationParams).getAggregation();
    verify(aggregationParams).getIntervalType();
    verify(aggregationParams).getTzId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)} with {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery4() {
    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();

    AggregationParams aggregationParams = mock(AggregationParams.class);
    when(aggregationParams.getTzId()).thenReturn(ZoneOffset.ofTotalSeconds(1));
    when(aggregationParams.getAggregation()).thenReturn(Aggregation.MIN);
    when(aggregationParams.getIntervalType()).thenReturn(IntervalType.MONTH);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getKey()).thenThrow(new IllegalArgumentException());
    when(query.getAggParameters()).thenReturn(aggregationParams);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaSqlTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(aggregationParams).getAggregation();
    verify(aggregationParams).getIntervalType();
    verify(aggregationParams).getTzId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)} with {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery5() {
    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();

    AggregationParams aggregationParams = mock(AggregationParams.class);
    when(aggregationParams.getTzId()).thenReturn(ZoneOffset.ofTotalSeconds(1));
    when(aggregationParams.getAggregation()).thenReturn(Aggregation.MIN);
    when(aggregationParams.getIntervalType()).thenReturn(IntervalType.QUARTER);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getKey()).thenThrow(new IllegalArgumentException());
    when(query.getAggParameters()).thenReturn(aggregationParams);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaSqlTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(aggregationParams).getAggregation();
    verify(aggregationParams).getIntervalType();
    verify(aggregationParams).getTzId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)} with {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Given milliseconds {@code MIN} and forty-two.
   * </ul>
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_givenMillisecondsMinAndFortyTwo() {
    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getKey()).thenThrow(new IllegalArgumentException());
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaSqlTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)} with {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Given none.
   * </ul>
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_givenNone() {
    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getKey()).thenThrow(new IllegalArgumentException());
    when(query.getAggParameters()).thenReturn(AggregationParams.none());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaSqlTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(query).getAggParameters();
    verify(query).getKey();
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)} with {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Then calls {@link AggregationParams#getInterval()}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractChunkedAggregationTimeseriesDao#findAllAsync(TenantId,
   * EntityId, ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture AbstractChunkedAggregationTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_thenCallsGetInterval() {
    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();

    AggregationParams aggregationParams = mock(AggregationParams.class);
    when(aggregationParams.getInterval()).thenThrow(new IllegalArgumentException());
    when(aggregationParams.getAggregation()).thenReturn(Aggregation.MIN);
    when(aggregationParams.getIntervalType()).thenReturn(IntervalType.MILLISECONDS);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(aggregationParams);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaSqlTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(aggregationParams).getAggregation();
    verify(aggregationParams).getInterval();
    verify(aggregationParams).getIntervalType();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query, atLeast(1)).getStartTs();
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long,
   * long, Aggregation)}.
   *
   * <p>Method under test: {@link
   * AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long, long,
   * Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntity AbstractChunkedAggregationTimeseriesDao.switchAggregation(EntityId, String, long, long, Aggregation)"
  })
  public void testSwitchAggregation() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(tsKvRepository.findNumericMin(Mockito.<UUID>any(), anyInt(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            jpaSqlTimeseriesDao.switchAggregation(
                BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L, 1L, Aggregation.MIN));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tsKvRepository).findNumericMin(isA(UUID.class), eq(1), eq(1L), eq(1L));
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long,
   * long, Aggregation)}.
   *
   * <p>Method under test: {@link
   * AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long, long,
   * Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntity AbstractChunkedAggregationTimeseriesDao.switchAggregation(EntityId, String, long, long, Aggregation)"
  })
  public void testSwitchAggregation2() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(tsKvRepository.findNumericMax(Mockito.<UUID>any(), anyInt(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaSqlTimeseriesDao.switchAggregation(entityId, "Key", 1L, 1L, Aggregation.MAX));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tsKvRepository).findNumericMax(isA(UUID.class), eq(1), eq(1L), eq(1L));
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long,
   * long, Aggregation)}.
   *
   * <ul>
   *   <li>Given {@link TsKvRepository} {@link TsKvRepository#findAvg(UUID, int, long, long)} return
   *       {@link TsKvEntity#TsKvEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long, long,
   * Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntity AbstractChunkedAggregationTimeseriesDao.switchAggregation(EntityId, String, long, long, Aggregation)"
  })
  public void testSwitchAggregation_givenTsKvRepositoryFindAvgReturnTsKvEntity() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);
    when(tsKvRepository.findAvg(Mockito.<UUID>any(), anyInt(), anyLong(), anyLong()))
        .thenReturn(tsKvEntity);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    TsKvEntity actualSwitchAggregationResult =
        jpaSqlTimeseriesDao.switchAggregation(entityId, "Key", 1L, 1L, Aggregation.AVG);

    // Assert
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tsKvRepository).findAvg(isA(UUID.class), eq(1), eq(1L), eq(1L));
    TsKvEntry toDataResult = actualSwitchAggregationResult.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long,
   * long, Aggregation)}.
   *
   * <ul>
   *   <li>Given {@link TsKvRepository} {@link TsKvRepository#findAvg(UUID, int, long, long)} return
   *       {@link TsKvEntity#TsKvEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long, long,
   * Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntity AbstractChunkedAggregationTimeseriesDao.switchAggregation(EntityId, String, long, long, Aggregation)"
  })
  public void testSwitchAggregation_givenTsKvRepositoryFindAvgReturnTsKvEntity2() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);
    when(tsKvRepository.findAvg(Mockito.<UUID>any(), anyInt(), anyLong(), anyLong()))
        .thenReturn(tsKvEntity);

    // Act
    TsKvEntity actualSwitchAggregationResult =
        jpaSqlTimeseriesDao.switchAggregation(
            BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L, 1L, Aggregation.AVG);

    // Assert
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tsKvRepository).findAvg(isA(UUID.class), eq(1), eq(1L), eq(1L));
    TsKvEntry toDataResult = actualSwitchAggregationResult.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long,
   * long, Aggregation)}.
   *
   * <ul>
   *   <li>Given {@link TsKvRepository} {@link TsKvRepository#findAvg(UUID, int, long, long)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long, long,
   * Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntity AbstractChunkedAggregationTimeseriesDao.switchAggregation(EntityId, String, long, long, Aggregation)"
  })
  public void testSwitchAggregation_givenTsKvRepositoryFindAvgThrowIllegalArgumentException() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(tsKvRepository.findAvg(Mockito.<UUID>any(), anyInt(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaSqlTimeseriesDao.switchAggregation(entityId, "Key", 1L, 1L, Aggregation.AVG));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tsKvRepository).findAvg(isA(UUID.class), eq(1), eq(1L), eq(1L));
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long,
   * long, Aggregation)}.
   *
   * <ul>
   *   <li>Given {@link TsKvRepository} {@link TsKvRepository#findNumericMax(UUID, int, long, long)}
   *       return {@link TsKvEntity#TsKvEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long, long,
   * Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntity AbstractChunkedAggregationTimeseriesDao.switchAggregation(EntityId, String, long, long, Aggregation)"
  })
  public void testSwitchAggregation_givenTsKvRepositoryFindNumericMaxReturnTsKvEntity() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);
    when(tsKvRepository.findNumericMax(Mockito.<UUID>any(), anyInt(), anyLong(), anyLong()))
        .thenReturn(tsKvEntity);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    TsKvEntity actualSwitchAggregationResult =
        jpaSqlTimeseriesDao.switchAggregation(entityId, "Key", 1L, 1L, Aggregation.MAX);

    // Assert
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tsKvRepository).findNumericMax(isA(UUID.class), eq(1), eq(1L), eq(1L));
    TsKvEntry toDataResult = actualSwitchAggregationResult.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long,
   * long, Aggregation)}.
   *
   * <ul>
   *   <li>Given {@link TsKvRepository} {@link TsKvRepository#findSum(UUID, int, long, long)} return
   *       {@link TsKvEntity#TsKvEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long, long,
   * Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntity AbstractChunkedAggregationTimeseriesDao.switchAggregation(EntityId, String, long, long, Aggregation)"
  })
  public void testSwitchAggregation_givenTsKvRepositoryFindSumReturnTsKvEntity() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);
    when(tsKvRepository.findSum(Mockito.<UUID>any(), anyInt(), anyLong(), anyLong()))
        .thenReturn(tsKvEntity);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    TsKvEntity actualSwitchAggregationResult =
        jpaSqlTimeseriesDao.switchAggregation(entityId, "Key", 1L, 1L, Aggregation.SUM);

    // Assert
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tsKvRepository).findSum(isA(UUID.class), eq(1), eq(1L), eq(1L));
    TsKvEntry toDataResult = actualSwitchAggregationResult.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long,
   * long, Aggregation)}.
   *
   * <ul>
   *   <li>Given {@link TsKvRepository} {@link TsKvRepository#findSum(UUID, int, long, long)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long, long,
   * Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntity AbstractChunkedAggregationTimeseriesDao.switchAggregation(EntityId, String, long, long, Aggregation)"
  })
  public void testSwitchAggregation_givenTsKvRepositoryFindSumThrowIllegalArgumentException() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);
    when(tsKvRepository.findSum(Mockito.<UUID>any(), anyInt(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> jpaSqlTimeseriesDao.switchAggregation(entityId, "Key", 1L, 1L, Aggregation.SUM));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tsKvRepository).findSum(isA(UUID.class), eq(1), eq(1L), eq(1L));
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long,
   * long, Aggregation)}.
   *
   * <ul>
   *   <li>Then calls {@link TsKvRepository#findNumericMin(UUID, int, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long, long,
   * Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntity AbstractChunkedAggregationTimeseriesDao.switchAggregation(EntityId, String, long, long, Aggregation)"
  })
  public void testSwitchAggregation_thenCallsFindNumericMin() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);
    when(tsKvRepository.findNumericMin(Mockito.<UUID>any(), anyInt(), anyLong(), anyLong()))
        .thenReturn(tsKvEntity);

    // Act
    TsKvEntity actualSwitchAggregationResult =
        jpaSqlTimeseriesDao.switchAggregation(
            BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L, 1L, Aggregation.MIN);

    // Assert
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tsKvRepository).findNumericMin(isA(UUID.class), eq(1), eq(1L), eq(1L));
    TsKvEntry toDataResult = actualSwitchAggregationResult.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
  }

  /**
   * Test {@link AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long,
   * long, Aggregation)}.
   *
   * <ul>
   *   <li>Then calls {@link TsKvRepository#findNumericMin(UUID, int, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AbstractChunkedAggregationTimeseriesDao#switchAggregation(EntityId, String, long, long,
   * Aggregation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TsKvEntity AbstractChunkedAggregationTimeseriesDao.switchAggregation(EntityId, String, long, long, Aggregation)"
  })
  public void testSwitchAggregation_thenCallsFindNumericMin2() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey("Str Key");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);
    when(tsKvRepository.findNumericMin(Mockito.<UUID>any(), anyInt(), anyLong(), anyLong()))
        .thenReturn(tsKvEntity);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    TsKvEntity actualSwitchAggregationResult =
        jpaSqlTimeseriesDao.switchAggregation(entityId, "Key", 1L, 1L, Aggregation.MIN);

    // Assert
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(tsKvRepository).findNumericMin(isA(UUID.class), eq(1), eq(1L), eq(1L));
    TsKvEntry toDataResult = actualSwitchAggregationResult.toData();
    assertTrue(toDataResult instanceof AggTsKvEntry);
    assertTrue(((AggTsKvEntry) toDataResult).getKv() instanceof StringDataEntry);
  }
}
