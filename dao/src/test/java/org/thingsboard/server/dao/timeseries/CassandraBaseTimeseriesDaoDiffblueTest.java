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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AggTsKvEntry;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.AggregationParams;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.ReadTsKvQueryResult;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

@RunWith(MockitoJUnitRunner.class)
public class CassandraBaseTimeseriesDaoDiffblueTest {
  @InjectMocks private CassandraBaseTimeseriesDao cassandraBaseTimeseriesDao;

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
   * <ul>
   *   <li>Then calls {@link ReadTsKvQuery#getEndTs()}.
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
  public void testFindAllAsyncWithTenantIdEntityIdQueries_thenCallsGetEndTs() {
    // Arrange
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
    // Arrange and Act
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
   * <ul>
   *   <li>Then calls {@link ReadTsKvQuery#getEndTs()}.
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
  public void testFindAllAsyncWithTenantIdEntityIdQuery_thenCallsGetEndTs() {
    // Arrange
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
   *   <li>When {@link AggTsKvEntry} {@link AggTsKvEntry#getJsonValue()} throw {@link
   *       RuntimeException#RuntimeException()}.
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
  public void testSave_whenAggTsKvEntryGetJsonValueThrowRuntimeException_thenCallsGetJsonValue() {
    // Arrange
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
        cassandraBaseTimeseriesDao.calculatePartitions(Long.MAX_VALUE, 1L);

    // Assert
    assertEquals(1, actualCalculatePartitionsResult.size());
    assertEquals(1L, actualCalculatePartitionsResult.get(0).longValue());
  }

  /**
   * Test {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link CassandraBaseTimeseriesDao#calculatePartitions(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List CassandraBaseTimeseriesDao.calculatePartitions(long, long)"})
  public void testCalculatePartitions_whenOne_thenReturnSizeIsOne() {
    // Arrange and Act
    List<Long> actualCalculatePartitionsResult =
        cassandraBaseTimeseriesDao.calculatePartitions(1L, 1L);

    // Assert
    assertEquals(1, actualCalculatePartitionsResult.size());
    assertEquals(1L, actualCalculatePartitionsResult.get(0).longValue());
  }
}
