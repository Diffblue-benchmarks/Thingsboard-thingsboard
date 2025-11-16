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
package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.AggregationParams;
import org.thingsboard.server.common.data.kv.BaseDeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.DeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.ReadTsKvQueryResult;
import org.thingsboard.server.common.data.kv.StringDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@RunWith(MockitoJUnitRunner.class)
public class CassandraBaseTimeseriesDaoDiffblueTest {
  @InjectMocks private CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao;

  @Mock private CassandraTsPartitionsCache cassandraTsPartitionsCache;

  @Mock private ConcurrentMap<String, PreparedStatement> concurrentMap;

  @Mock private NoSqlTsPartitionDate noSqlTsPartitionDate;

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    ReadTsKvQuery readTsKvQuery = mock(ReadTsKvQuery.class);
    when(readTsKvQuery.getStartTs()).thenThrow(new RuntimeException());
    when(readTsKvQuery.getAggParameters()).thenReturn(AggregationParams.none());

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(readTsKvQuery);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, queries));
    verify(readTsKvQuery).getAggParameters();
    verify(readTsKvQuery).getStartTs();
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries2() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    ReadTsKvQuery readTsKvQuery = mock(ReadTsKvQuery.class);
    when(readTsKvQuery.getEndTs()).thenThrow(new RuntimeException());
    when(readTsKvQuery.getStartTs()).thenReturn(1L);
    when(readTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(readTsKvQuery);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, queries));
    verify(readTsKvQuery).getAggParameters();
    verify(readTsKvQuery).getEndTs();
    verify(readTsKvQuery, atLeast(1)).getStartTs();
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries3() {
    // Arrange
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenThrow(new RuntimeException());

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, queries));
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <ul>
   *   <li>Then calls {@link ReadTsKvQuery#getInterval()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries_thenCallsGetInterval() {
    // Arrange
    ReadTsKvQuery readTsKvQuery = mock(ReadTsKvQuery.class);
    when(readTsKvQuery.getInterval()).thenThrow(new RuntimeException());
    when(readTsKvQuery.getEndTs()).thenReturn(1L);
    when(readTsKvQuery.getStartTs()).thenReturn(1L);
    when(readTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(readTsKvQuery);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, queries));
    verify(readTsKvQuery).getAggParameters();
    verify(readTsKvQuery).getInterval();
    verify(readTsKvQuery).getEndTs();
    verify(readTsKvQuery, atLeast(1)).getStartTs();
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <ul>
   *   <li>Then calls {@link NoSqlTsPartitionDate#getTruncateUnit()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries_thenCallsGetTruncateUnit() {
    // Arrange
    when(noSqlTsPartitionDate.getTruncateUnit()).thenThrow(new RuntimeException());
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, queries));
    verify(noSqlTsPartitionDate).getTruncateUnit();
    verify(noSqlTsPartitionDate, atLeast(1)).truncatedTo(Mockito.<LocalDateTime>any());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllAsyncResult =
        cassandraBaseTimeseriesDao.findAllAsync(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    assertTrue(actualFindAllAsyncResult.get().isEmpty());
    assertTrue(actualFindAllAsyncResult.isDone());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with
   * {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    ReadTsKvQuery query = mock(ReadTsKvQuery.class);
    when(query.getStartTs()).thenThrow(new RuntimeException());
    when(query.getAggParameters()).thenReturn(AggregationParams.none());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(query).getAggParameters();
    verify(query).getStartTs();
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with
   * {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery2() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    ReadTsKvQuery query = mock(ReadTsKvQuery.class);
    when(query.getEndTs()).thenThrow(new RuntimeException());
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query, atLeast(1)).getStartTs();
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with
   * {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery3() {
    // Arrange
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new BaseReadTsKvQuery("Key", 1L, 1L)));
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with
   * {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Then calls {@link ReadTsKvQuery#getInterval()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_thenCallsGetInterval() {
    // Arrange
    ReadTsKvQuery query = mock(ReadTsKvQuery.class);
    when(query.getInterval()).thenThrow(new RuntimeException());
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, query));
    verify(query).getAggParameters();
    verify(query).getInterval();
    verify(query).getEndTs();
    verify(query, atLeast(1)).getStartTs();
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with
   * {@code tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Then calls {@link NoSqlTsPartitionDate#getTruncateUnit()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_thenCallsGetTruncateUnit() {
    // Arrange
    when(noSqlTsPartitionDate.getTruncateUnit()).thenThrow(new RuntimeException());
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new BaseReadTsKvQuery("Key", 1L, 1L)));
    verify(noSqlTsPartitionDate).getTruncateUnit();
    verify(noSqlTsPartitionDate, atLeast(1)).truncatedTo(Mockito.<LocalDateTime>any());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>Given {@code BOOLEAN}.
   *   <li>When {@link KvEntry} {@link KvEntry#getDataType()} return {@code BOOLEAN}.
   *   <li>Then calls {@link KvEntry#getDataType()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_givenBoolean_whenKvEntryGetDataTypeReturnBoolean_thenCallsGetDataType() {
    // Arrange
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new RuntimeException());
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    KvEntry kv = mock(KvEntry.class);
    when(kv.getDataType()).thenReturn(DataType.BOOLEAN);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.save(ModelConstants.SYSTEM_TENANT, entityId, tsKvEntry, 1L));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(kv).getDataType();
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>Given {@code JSON}.
   *   <li>Then calls {@link AggTsKvEntry#getJsonValue()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_givenJson_thenCallsGetJsonValue() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    AggTsKvEntry kv = mock(AggTsKvEntry.class);
    when(kv.getJsonValue()).thenThrow(new RuntimeException());
    when(kv.getDataType()).thenReturn(DataType.JSON);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry, 0L));
    verify(kv).getDataType();
    verify(kv).getJsonValue();
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>Given {@link NoSqlTsPartitionDate} {@link
   *       NoSqlTsPartitionDate#truncatedTo(LocalDateTime)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_givenNoSqlTsPartitionDateTruncatedToThrowRuntimeException() {
    // Arrange
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenThrow(new RuntimeException());
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry, 1L));
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link AggTsKvEntry} {@link AggTsKvEntry#getDataPoints()} return one.
   *   <li>Then calls {@link AggTsKvEntry#getDataPoints()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_givenOne_whenAggTsKvEntryGetDataPointsReturnOne_thenCallsGetDataPoints() {
    // Arrange
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new RuntimeException());
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    AggTsKvEntry tsKvEntry = mock(AggTsKvEntry.class);
    when(tsKvEntry.getDataPoints()).thenReturn(1);
    when(tsKvEntry.getTs()).thenReturn(1L);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.save(ModelConstants.SYSTEM_TENANT, entityId, tsKvEntry, 1L));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tsKvEntry).getDataPoints();
    verify(tsKvEntry).getTs();
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>Given {@code STRING}.
   *   <li>Then calls {@link AggTsKvEntry#getStrValue()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_givenString_thenCallsGetStrValue() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    AggTsKvEntry kv = mock(AggTsKvEntry.class);
    when(kv.getStrValue()).thenThrow(new RuntimeException());
    when(kv.getDataType()).thenReturn(DataType.STRING);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, kv);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry, 0L));
    verify(kv).getDataType();
    verify(kv).getStrValue();
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_givenTenant_thenCallsGetEntityType() {
    // Arrange
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new RuntimeException());
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.save(ModelConstants.SYSTEM_TENANT, entityId, tsKvEntry, 1L));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then calls {@link ConcurrentMap#computeIfAbsent(Object, Function)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_whenJsonDataEntryWithKeyAndValueIs42_thenCallsComputeIfAbsent() {
    // Arrange
    when(concurrentMap.computeIfAbsent(
            Mockito.<String>any(), Mockito.<Function<String, PreparedStatement>>any()))
        .thenThrow(new RuntimeException());
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry, 1L));
    verify(concurrentMap)
        .computeIfAbsent(
            eq(
                "INSERT INTO ts_kv_cf(entity_type,entity_id,key,partition,ts,bool_v) VALUES(?, ?, ?, ?, ?, ?) USING TTL ?"),
            isA(Function.class));
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then calls {@link ConcurrentMap#computeIfAbsent(Object, Function)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_whenJsonDataEntryWithKeyAndValueIs42_thenCallsComputeIfAbsent2() {
    // Arrange
    when(concurrentMap.computeIfAbsent(
            Mockito.<String>any(), Mockito.<Function<String, PreparedStatement>>any()))
        .thenThrow(new RuntimeException());
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.save(
                ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, tsKvEntry, 1L));
    verify(concurrentMap)
        .computeIfAbsent(
            eq(
                "INSERT INTO ts_kv_cf(entity_type,entity_id,key,partition,ts,bool_v) VALUES(?, ?, ?, ?, ?, ?) USING TTL ?"),
            isA(Function.class));
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with key is {@code bool_v}
   *       and value is {@code 42}.
   *   <li>Then calls {@link ConcurrentMap#computeIfAbsent(Object, Function)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_whenStringDataEntryWithKeyIsBoolVAndValueIs42_thenCallsComputeIfAbsent() {
    // Arrange
    when(concurrentMap.computeIfAbsent(
            Mockito.<String>any(), Mockito.<Function<String, PreparedStatement>>any()))
        .thenThrow(new RuntimeException());
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new StringDataEntry("bool_v", "42"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry, 1L));
    verify(concurrentMap)
        .computeIfAbsent(
            eq(
                "INSERT INTO ts_kv_cf(entity_type,entity_id,key,partition,ts,bool_v) VALUES(?, ?, ?, ?, ?, ?) USING TTL ?"),
            isA(Function.class));
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   *
   * <ul>
   *   <li>Given {@link CassandraTsPartitionsCache} {@link
   *       CassandraTsPartitionsCache#has(CassandraPartitionCacheKey)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.savePartition(TenantId, EntityId, long, String)"
  })
  public void testSavePartition_givenCassandraTsPartitionsCacheHasThrowRuntimeException() {
    // Arrange
    when(cassandraTsPartitionsCache.has(Mockito.<CassandraPartitionCacheKey>any()))
        .thenThrow(new RuntimeException());
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);
    when(noSqlTsPartitionDate.getTruncateUnit()).thenReturn(ChronoUnit.NANOS);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.savePartition(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, "Key"));
    verify(cassandraTsPartitionsCache).has(isA(CassandraPartitionCacheKey.class));
    verify(noSqlTsPartitionDate).getTruncateUnit();
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   *
   * <ul>
   *   <li>Given {@link NoSqlTsPartitionDate} {@link NoSqlTsPartitionDate#getTruncateUnit()} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.savePartition(TenantId, EntityId, long, String)"
  })
  public void testSavePartition_givenNoSqlTsPartitionDateGetTruncateUnitThrowRuntimeException() {
    // Arrange
    when(noSqlTsPartitionDate.getTruncateUnit()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.savePartition(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, "Key"));
    verify(noSqlTsPartitionDate).getTruncateUnit();
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   *
   * <ul>
   *   <li>Given {@link NoSqlTsPartitionDate} {@link
   *       NoSqlTsPartitionDate#truncatedTo(LocalDateTime)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.savePartition(TenantId, EntityId, long, String)"
  })
  public void testSavePartition_givenNoSqlTsPartitionDateTruncatedToThrowRuntimeException() {
    // Arrange
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenThrow(new RuntimeException());
    when(noSqlTsPartitionDate.getTruncateUnit()).thenReturn(ChronoUnit.NANOS);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.savePartition(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, "Key"));
    verify(noSqlTsPartitionDate).getTruncateUnit();
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ConcurrentMap#computeIfAbsent(Object, Function)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.savePartition(TenantId, EntityId, long, String)"
  })
  public void testSavePartition_thenCallsComputeIfAbsent() {
    // Arrange
    when(concurrentMap.computeIfAbsent(
            Mockito.<String>any(), Mockito.<Function<String, PreparedStatement>>any()))
        .thenThrow(new RuntimeException());
    when(cassandraTsPartitionsCache.has(Mockito.<CassandraPartitionCacheKey>any()))
        .thenReturn(false);
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);
    when(noSqlTsPartitionDate.getTruncateUnit()).thenReturn(ChronoUnit.NANOS);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.savePartition(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, "Key"));
    verify(concurrentMap)
        .computeIfAbsent(
            eq(
                "INSERT INTO ts_kv_partitions_cf(entity_type,entity_id,partition,key) VALUES(?, ?, ?, ?)"),
            isA(Function.class));
    verify(cassandraTsPartitionsCache).has(isA(CassandraPartitionCacheKey.class));
    verify(noSqlTsPartitionDate).getTruncateUnit();
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ConcurrentMap#computeIfAbsent(Object, Function)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.savePartition(TenantId, EntityId, long, String)"
  })
  public void testSavePartition_thenCallsComputeIfAbsent2() {
    // Arrange
    when(concurrentMap.computeIfAbsent(
            Mockito.<String>any(), Mockito.<Function<String, PreparedStatement>>any()))
        .thenThrow(new RuntimeException());
    when(cassandraTsPartitionsCache.has(Mockito.<CassandraPartitionCacheKey>any()))
        .thenReturn(false);
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);
    when(noSqlTsPartitionDate.getTruncateUnit()).thenReturn(ChronoUnit.NANOS);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.savePartition(
                ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT, 1L, "Key"));
    verify(concurrentMap)
        .computeIfAbsent(
            eq(
                "INSERT INTO ts_kv_partitions_cf(entity_type,entity_id,partition,key) VALUES(?, ?, ?, ?)"),
            isA(Function.class));
    verify(cassandraTsPartitionsCache).has(isA(CassandraPartitionCacheKey.class));
    verify(noSqlTsPartitionDate).getTruncateUnit();
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.savePartition(TenantId, EntityId, long, String)"
  })
  public void testSavePartition_thenReturnGetIntValueIsZero()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(cassandraTsPartitionsCache.has(Mockito.<CassandraPartitionCacheKey>any()))
        .thenReturn(true);
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);
    when(noSqlTsPartitionDate.getTruncateUnit()).thenReturn(ChronoUnit.NANOS);

    // Act
    ListenableFuture<Integer> actualSavePartitionResult =
        cassandraBaseTimeseriesDao.savePartition(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, "Key");

    // Assert
    verify(cassandraTsPartitionsCache).has(isA(CassandraPartitionCacheKey.class));
    verify(noSqlTsPartitionDate).getTruncateUnit();
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
    assertEquals(0, actualSavePartitionResult.get().intValue());
    assertTrue(actualSavePartitionResult.isDone());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#savePartition(TenantId, EntityId, long,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.savePartition(TenantId, EntityId, long, String)"
  })
  public void testSavePartition_thenReturnGetIsNull()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(noSqlTsPartitionDate.getTruncateUnit()).thenReturn(ChronoUnit.FOREVER);

    // Act
    ListenableFuture<Integer> actualSavePartitionResult =
        cassandraBaseTimeseriesDao.savePartition(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, "Key");

    // Assert
    verify(noSqlTsPartitionDate).getTruncateUnit();
    assertNull(actualSavePartitionResult.get());
    assertTrue(actualSavePartitionResult.isDone());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#remove(TenantId, EntityId, DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Given {@link NoSqlTsPartitionDate} {@link
   *       NoSqlTsPartitionDate#truncatedTo(LocalDateTime)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#remove(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.remove(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testRemove_givenNoSqlTsPartitionDateTruncatedToThrowRuntimeException() {
    // Arrange
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.remove(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new BaseDeleteTsKvQuery("Key", 1L, 1L)));
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#remove(TenantId, EntityId, DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link NoSqlTsPartitionDate#getTruncateUnit()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#remove(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture CassandraBaseTimeseriesDao.remove(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testRemove_thenCallsGetTruncateUnit() {
    // Arrange
    when(noSqlTsPartitionDate.getTruncateUnit()).thenThrow(new RuntimeException());
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            cassandraBaseTimeseriesDao.remove(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new BaseDeleteTsKvQuery("Key", 1L, 1L)));
    verify(noSqlTsPartitionDate).getTruncateUnit();
    verify(noSqlTsPartitionDate, atLeast(1)).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraBaseTimeseriesDao#cleanup(long)}
   *   <li>{@link CassandraBaseTimeseriesDao#getPartitioning()}
   *   <li>{@link CassandraBaseTimeseriesDao#isUseTsKeyValuePartitioningOnRead()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CassandraBaseTimeseriesDao.cleanup(long)",
    "String CassandraBaseTimeseriesDao.getPartitioning()",
    "boolean CassandraBaseTimeseriesDao.isUseTsKeyValuePartitioningOnRead()"
  })
  public void testGettersAndSetters() {
    // Arrange
    CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao = new CassandraBaseTimeseriesDao();

    // Act
    cassandraBaseTimeseriesDao.cleanup(1L);
    String actualPartitioning = cassandraBaseTimeseriesDao.getPartitioning();

    // Assert
    assertNull(actualPartitioning);
    assertFalse(cassandraBaseTimeseriesDao.isUseTsKeyValuePartitioningOnRead());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#toPartitionTs(long)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#toPartitionTs(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long CassandraBaseTimeseriesDao.toPartitionTs(long)"})
  public void testToPartitionTs_thenReturnZero() {
    // Arrange
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenReturn(NoSqlTsPartitionDate.EPOCH_START);

    // Act
    long actualToPartitionTsResult = cassandraBaseTimeseriesDao.toPartitionTs(1L);

    // Assert
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
    assertEquals(0L, actualToPartitionTsResult);
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#toPartitionTs(long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#toPartitionTs(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long CassandraBaseTimeseriesDao.toPartitionTs(long)"})
  public void testToPartitionTs_thenThrowRuntimeException() {
    // Arrange
    when(noSqlTsPartitionDate.truncatedTo(Mockito.<LocalDateTime>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> cassandraBaseTimeseriesDao.toPartitionTs(1L));
    verify(noSqlTsPartitionDate).truncatedTo(isA(LocalDateTime.class));
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}.
   *
   * <ul>
   *   <li>Given {@link CassandraBaseTimeseriesDao} (default constructor).
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CassandraBaseTimeseriesDao.calculatePartitions(long, long)"})
  public void testCalculatePartitions_givenCassandraBaseTimeseriesDao_thenReturnSizeIsOne() {
    // Arrange and Act
    List<Long> actualCalculatePartitionsResult =
        new CassandraBaseTimeseriesDao().calculatePartitions(1L, 1L);

    // Assert
    assertEquals(1, actualCalculatePartitionsResult.size());
    assertEquals(1L, actualCalculatePartitionsResult.get(0).longValue());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CassandraBaseTimeseriesDao.calculatePartitions(long, long)"})
  public void testCalculatePartitions_thenThrowRuntimeException() {
    // Arrange
    when(noSqlTsPartitionDate.getTruncateUnit()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> cassandraBaseTimeseriesDao.calculatePartitions(0L, 1L));
    verify(noSqlTsPartitionDate).getTruncateUnit();
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CassandraBaseTimeseriesDao.calculatePartitions(long, long)"})
  public void testCalculatePartitions_whenMax_value_thenReturnSizeIsOne() {
    // Arrange and Act
    List<Long> actualCalculatePartitionsResult =
        new CassandraBaseTimeseriesDao().calculatePartitions(Long.MAX_VALUE, 1L);

    // Assert
    assertEquals(1, actualCalculatePartitionsResult.size());
    assertEquals(1L, actualCalculatePartitionsResult.get(0).longValue());
  }
}
