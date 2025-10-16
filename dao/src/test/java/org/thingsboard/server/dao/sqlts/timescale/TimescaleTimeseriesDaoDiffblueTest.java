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
package org.thingsboard.server.dao.sqlts.timescale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import javax.sql.DataSource;
import oracle.jdbc.rowset.OracleCachedRowSet;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.postgresql.util.PSQLWarning;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.AggregationParams;
import org.thingsboard.server.common.data.kv.BaseDeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.IntervalType;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.dictionary.KeyDictionaryDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sqlts.timescale.ts.TimescaleTsKvEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueParams;
import org.thingsboard.server.dao.sql.TbSqlBlockingQueueWrapper;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(MockitoJUnitRunner.class)
public class TimescaleTimeseriesDaoDiffblueTest {
  @Mock private AggregationRepository aggregationRepository;

  @Mock private DataSource dataSource;

  @Mock private JpaExecutorService jpaExecutorService;

  @Mock private KeyDictionaryDao keyDictionaryDao;

  @InjectMocks private TimescaleTimeseriesDao timescaleTimeseriesDao;

  /**
   * Test {@link TimescaleTimeseriesDao#init()}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimescaleTimeseriesDao.init()"})
  public void testInit() {
    // Arrange and Act
    timescaleTimeseriesDao.init();

    // Assert
    TbSqlBlockingQueueWrapper<TimescaleTsKvEntity, Void> tbSqlBlockingQueueWrapper =
        timescaleTimeseriesDao.tsQueue;
    TbSqlBlockingQueueParams params = tbSqlBlockingQueueWrapper.getParams();
    assertEquals("TS Timescale", params.getLogName());
    assertEquals("ts.timescale", params.getStatsNamePrefix());
    assertEquals(0, params.getBatchSize());
    assertEquals(0, tbSqlBlockingQueueWrapper.getMaxThreads());
    assertEquals(0L, params.getMaxDelay());
    assertEquals(0L, params.getStatsPrintIntervalMs());
    assertFalse(params.isBatchSortEnabled());
    assertFalse(params.isWithResponse());
    assertTrue(tbSqlBlockingQueueWrapper.getQueues().isEmpty());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries() {
    // Arrange
    doThrow(new IllegalArgumentException())
        .when(jpaExecutorService)
        .execute(Mockito.<Runnable>any());

    // Act
    timescaleTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries2() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findMin(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    BaseReadTsKvQuery baseReadTsKvQuery =
        new BaseReadTsKvQuery("Key", 1L, 1L, 42L, 1, Aggregation.MIN);
    queries.add(baseReadTsKvQuery);

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findMin(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries3() {
    // Arrange
    when(aggregationRepository.findMin(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    BaseReadTsKvQuery baseReadTsKvQuery =
        new BaseReadTsKvQuery("Key", 1L, 1L, 42L, 1, Aggregation.MIN);
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findMin(isA(UUID.class), eq(1), eq(42L), eq(1L), eq(1L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries4() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());

    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity.setJsonValue("42");
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setLongValue(42L);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setStrValue("42");
    timescaleTsKvEntity.setTs(1L);

    ArrayList<TimescaleTsKvEntity> timescaleTsKvEntityList = new ArrayList<>();
    timescaleTsKvEntityList.add(timescaleTsKvEntity);
    when(aggregationRepository.findMin(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(timescaleTsKvEntityList);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    BaseReadTsKvQuery baseReadTsKvQuery =
        new BaseReadTsKvQuery("Key", 1L, 1L, 42L, 1, Aggregation.MIN);
    queries.add(baseReadTsKvQuery);

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findMin(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries5() {
    // Arrange
    when(aggregationRepository.findMin(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MIN);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findMin(isA(UUID.class), eq(1), eq(42L), eq(1L), eq(1L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries6() {
    // Arrange
    when(aggregationRepository.findMin(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(1L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MIN);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findMin(isA(UUID.class), eq(1), eq(1L), eq(1L), eq(2L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries7() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findMax(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MAX);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findMax(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries8() {
    // Arrange
    when(aggregationRepository.findMax(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MAX);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findMax(isA(UUID.class), eq(1), eq(42L), eq(1L), eq(1L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries9() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findMax(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(1L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MAX);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findMax(isA(UUID.class), eq(1), eq(1L), eq(1L), eq(2L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries10() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findAvg(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.AVG);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findAvg(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries11() {
    // Arrange
    when(aggregationRepository.findAvg(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.AVG);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findAvg(isA(UUID.class), eq(1), eq(42L), eq(1L), eq(1L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries12() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findSum(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.SUM);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findSum(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries13() {
    // Arrange
    when(aggregationRepository.findSum(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.SUM);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findSum(isA(UUID.class), eq(1), eq(42L), eq(1L), eq(1L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries14() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findCount(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.COUNT);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findCount(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries15() {
    // Arrange
    when(aggregationRepository.findCount(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.COUNT);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery, atLeast(1)).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findCount(isA(UUID.class), eq(1), eq(42L), eq(1L), eq(1L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <ul>
   *   <li>Then calls {@link BaseReadTsKvQuery#getLimit()}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries_thenCallsGetLimit() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getLimit()).thenThrow(new IllegalArgumentException());
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.NONE);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggParameters())
        .thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getAggParameters();
    verify(baseReadTsKvQuery).getLimit();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery).getStartTs();
    verify(baseReadTsKvQuery).getAggregation();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)} with {@code
   * tenantId}, {@code entityId}, {@code queries}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link JpaExecutorService#execute(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, List)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQueries_whenArrayList_thenCallsExecute() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());

    // Act
    timescaleTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            timescaleTimeseriesDao.findAllAsync(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new BaseReadTsKvQuery("Key", 2L, 1L)));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery2() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());

    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity.setJsonValue("42");
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setLongValue(42L);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setStrValue("42");
    timescaleTsKvEntity.setTs(1L);

    ArrayList<TimescaleTsKvEntity> timescaleTsKvEntityList = new ArrayList<>();
    timescaleTsKvEntityList.add(timescaleTsKvEntity);
    when(aggregationRepository.findAvg(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(timescaleTsKvEntityList);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    // Act
    timescaleTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new BaseReadTsKvQuery("Key", 2L, 1L));

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findAvg(isA(UUID.class), eq(1), eq(-1L), eq(2L), eq(3L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery3() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());

    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity.setJsonValue("42");
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setLongValue(42L);
    timescaleTsKvEntity.setStrKey("Str Key");
    timescaleTsKvEntity.setStrValue("42");
    timescaleTsKvEntity.setTs(1L);

    TimescaleTsKvEntity timescaleTsKvEntity2 = new TimescaleTsKvEntity();
    timescaleTsKvEntity2.setAggValuesCount(42L);
    timescaleTsKvEntity2.setAggValuesLastTs(1L);
    timescaleTsKvEntity2.setBooleanValue(false);
    timescaleTsKvEntity2.setDoubleValue(1.0d);
    timescaleTsKvEntity2.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity2.setJsonValue("Json Value");
    timescaleTsKvEntity2.setKey(2);
    timescaleTsKvEntity2.setLongValue(1L);
    timescaleTsKvEntity2.setStrKey("AVG");
    timescaleTsKvEntity2.setStrValue("Str Value");
    timescaleTsKvEntity2.setTs(2L);

    ArrayList<TimescaleTsKvEntity> timescaleTsKvEntityList = new ArrayList<>();
    timescaleTsKvEntityList.add(timescaleTsKvEntity2);
    timescaleTsKvEntityList.add(timescaleTsKvEntity);
    when(aggregationRepository.findAvg(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(timescaleTsKvEntityList);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    // Act
    timescaleTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new BaseReadTsKvQuery("Key", 2L, 1L));

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findAvg(isA(UUID.class), eq(1), eq(-1L), eq(2L), eq(3L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery4() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());

    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(1L);
    timescaleTsKvEntity.setAggValuesLastTs(2L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(0.5d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity.setJsonValue("AVG");
    timescaleTsKvEntity.setKey(3);
    timescaleTsKvEntity.setLongValue(2L);
    timescaleTsKvEntity.setStrKey("42");
    timescaleTsKvEntity.setStrValue("AVG");
    timescaleTsKvEntity.setTs(3L);

    ArrayList<TimescaleTsKvEntity> timescaleTsKvEntityList = new ArrayList<>();
    timescaleTsKvEntityList.add(timescaleTsKvEntity);
    when(aggregationRepository.findAvg(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(timescaleTsKvEntityList);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    timescaleTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT, entityId, new BaseReadTsKvQuery("Key", 2L, 1L));

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findAvg(isA(UUID.class), eq(1), eq(-1L), eq(2L), eq(3L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery5() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findAvg(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    timescaleTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT, entityId, new BaseReadTsKvQuery("Key", 3L, 1L));

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findAvg(isA(UUID.class), eq(1), anyLong(), eq(3L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery6() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findMin(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    BaseReadTsKvQuery query = new BaseReadTsKvQuery("Key", 1L, 1L, 42L, 1, Aggregation.MIN);

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findMin(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery7() {
    // Arrange
    when(aggregationRepository.findMin(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    BaseReadTsKvQuery query = new BaseReadTsKvQuery("Key", 1L, 1L, 42L, 1, Aggregation.MIN);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findMin(isA(UUID.class), eq(1), eq(42L), eq(1L), eq(1L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery8() {
    // Arrange
    when(aggregationRepository.findMax(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getInterval()).thenReturn(42L);
    when(query.getKey()).thenReturn("Key");
    when(query.getAggregation()).thenReturn(Aggregation.MAX);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query));
    verify(entityId).getId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
    verify(query, atLeast(1)).getAggregation();
    verify(query).getInterval();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findMax(isA(UUID.class), eq(1), eq(42L), eq(1L), eq(1L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery9() {
    // Arrange
    when(aggregationRepository.findSum(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getInterval()).thenReturn(42L);
    when(query.getKey()).thenReturn("Key");
    when(query.getAggregation()).thenReturn(Aggregation.SUM);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query));
    verify(entityId).getId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
    verify(query, atLeast(1)).getAggregation();
    verify(query).getInterval();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findSum(isA(UUID.class), eq(1), eq(42L), eq(1L), eq(1L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery10() {
    // Arrange
    when(aggregationRepository.findCount(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenThrow(new IllegalArgumentException());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getInterval()).thenReturn(42L);
    when(query.getKey()).thenReturn("Key");
    when(query.getAggregation()).thenReturn(Aggregation.COUNT);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query));
    verify(entityId).getId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
    verify(query, atLeast(1)).getAggregation();
    verify(query).getInterval();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findCount(isA(UUID.class), eq(1), eq(42L), eq(1L), eq(1L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Given {@code MAX}.
   *   <li>Then calls {@link AggregationRepository#findMax(UUID, int, long, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_givenMax_thenCallsFindMax() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findMax(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getInterval()).thenReturn(42L);
    when(query.getKey()).thenReturn("Key");
    when(query.getAggregation()).thenReturn(Aggregation.MAX);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
    verify(query, atLeast(1)).getAggregation();
    verify(query).getInterval();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findMax(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Given {@code MIN}.
   *   <li>Then calls {@link AggregationRepository#findMin(UUID, int, long, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_givenMin_thenCallsFindMin() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findMin(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getInterval()).thenReturn(42L);
    when(query.getKey()).thenReturn("Key");
    when(query.getAggregation()).thenReturn(Aggregation.MIN);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
    verify(query, atLeast(1)).getAggregation();
    verify(query).getInterval();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findMin(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Given {@code SUM}.
   *   <li>Then calls {@link AggregationRepository#findSum(UUID, int, long, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_givenSum_thenCallsFindSum() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findSum(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getInterval()).thenReturn(42L);
    when(query.getKey()).thenReturn("Key");
    when(query.getAggregation()).thenReturn(Aggregation.SUM);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
    verify(query, atLeast(1)).getAggregation();
    verify(query).getInterval();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findSum(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTimeseriesDao} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_givenTimescaleTimeseriesDao() {
    // Arrange
    TimescaleTimeseriesDao timescaleTimeseriesDao = new TimescaleTimeseriesDao();

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new IllegalArgumentException());

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getKey()).thenReturn("Key");
    when(query.getAggregation()).thenReturn(Aggregation.MIN);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters())
        .thenReturn(
            new AggregationParams(
                Aggregation.MIN, IntervalType.WEEK, ZoneOffset.ofTotalSeconds(1), 42L));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query));
    verify(entityId).getId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
    verify(query, atLeast(1)).getAggregation();
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Then calls {@link AggregationRepository#findAvg(UUID, int, long, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_thenCallsFindAvg() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findAvg(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    timescaleTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT, entityId, new BaseReadTsKvQuery("Key", 2L, 1L));

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId).getId();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findAvg(isA(UUID.class), eq(1), eq(-1L), eq(2L), eq(3L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Then calls {@link AggregationRepository#findCount(UUID, int, long, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_thenCallsFindCount() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findCount(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getInterval()).thenReturn(42L);
    when(query.getKey()).thenReturn("Key");
    when(query.getAggregation()).thenReturn(Aggregation.COUNT);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters()).thenReturn(AggregationParams.milliseconds(Aggregation.MIN, 42L));

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId, atLeast(1)).getId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query).getKey();
    verify(query, atLeast(1)).getStartTs();
    verify(query, atLeast(1)).getAggregation();
    verify(query).getInterval();
    verify(keyDictionaryDao, atLeast(1)).getOrSaveKeyId("Key");
    verify(aggregationRepository, atLeast(1))
        .findCount(isA(UUID.class), eq(1), anyLong(), eq(1L), anyLong());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>Then calls {@link AggregationRepository#findCount(UUID, int, long, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_thenCallsFindCount2() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findCount(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery query = mock(BaseReadTsKvQuery.class);
    when(query.getKey()).thenReturn("Key");
    when(query.getAggregation()).thenReturn(Aggregation.COUNT);
    when(query.getEndTs()).thenReturn(1L);
    when(query.getStartTs()).thenReturn(1L);
    when(query.getAggParameters())
        .thenReturn(
            new AggregationParams(
                Aggregation.MIN, IntervalType.WEEK, ZoneOffset.ofTotalSeconds(1), 42L));

    // Act
    timescaleTimeseriesDao.findAllAsync(ModelConstants.SYSTEM_TENANT, entityId, query);

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(entityId).getId();
    verify(query).getAggParameters();
    verify(query).getEndTs();
    verify(query, atLeast(1)).getKey();
    verify(query, atLeast(1)).getStartTs();
    verify(query, atLeast(1)).getAggregation();
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findCount(isA(UUID.class), eq(1), eq(1L), eq(1L), eq(2L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId, ReadTsKvQuery)} with {@code
   * tenantId}, {@code entityId}, {@code query}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then calls {@link AggregationRepository#findAvg(UUID, int, long, long, long)}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#findAllAsync(TenantId, EntityId,
   * ReadTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.findAllAsync(TenantId, EntityId, ReadTsKvQuery)"
  })
  public void testFindAllAsyncWithTenantIdEntityIdQuery_whenNull_customer_id_thenCallsFindAvg() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());
    when(aggregationRepository.findAvg(
            Mockito.<UUID>any(), anyInt(), anyLong(), anyLong(), anyLong()))
        .thenReturn(new ArrayList<>());
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    // Act
    timescaleTimeseriesDao.findAllAsync(
        ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID,
        new BaseReadTsKvQuery("Key", 2L, 1L));

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    verify(aggregationRepository).findAvg(isA(UUID.class), eq(1), eq(-1L), eq(2L), eq(3L));
  }

  /**
   * Test {@link TimescaleTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.save(TenantId, EntityId, TsKvEntry, long)"
  })
  public void testSave_thenThrowIllegalArgumentException() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            timescaleTimeseriesDao.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry, 1L));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
  }

  /**
   * Test {@link TimescaleTimeseriesDao#savePartition(TenantId, EntityId, long, String)}.
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#savePartition(TenantId, EntityId, long,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.savePartition(TenantId, EntityId, long, String)"
  })
  public void testSavePartition() throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<Integer> actualSavePartitionResult =
        timescaleTimeseriesDao.savePartition(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, 1L, "Key");

    // Assert
    assertEquals(0, actualSavePartitionResult.get().intValue());
    assertTrue(actualSavePartitionResult.isDone());
  }

  /**
   * Test {@link TimescaleTimeseriesDao#remove(TenantId, EntityId, DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Given {@link JpaExecutorService} {@link JpaExecutorService#submit(Callable)} return
   *       create.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#remove(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.remove(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testRemove_givenJpaExecutorServiceSubmitReturnCreate_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any())).thenReturn(1);

    // Act
    ListenableFuture<Void> actualRemoveResult =
        timescaleTimeseriesDao.remove(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
    assertTrue(actualRemoveResult instanceof SettableFuture);
    assertSame(createResult, actualRemoveResult);
  }

  /**
   * Test {@link TimescaleTimeseriesDao#remove(TenantId, EntityId, DeleteTsKvQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#remove(TenantId, EntityId,
   * DeleteTsKvQuery)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture TimescaleTimeseriesDao.remove(TenantId, EntityId, DeleteTsKvQuery)"
  })
  public void testRemove_thenThrowIllegalArgumentException() {
    // Arrange
    when(keyDictionaryDao.getOrSaveKeyId(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            timescaleTimeseriesDao.remove(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new BaseDeleteTsKvQuery("Key", 1L, 1L)));
    verify(keyDictionaryDao).getOrSaveKeyId("Key");
  }

  /**
   * Test {@link TimescaleTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Given {@link Connection} {@link Connection#prepareStatement(String)} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimescaleTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenConnectionPrepareStatementThrowIllegalArgumentException()
      throws SQLException {
    // Arrange
    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());
    doThrow(new IllegalArgumentException()).when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> timescaleTimeseriesDao.cleanup(1L));
    verify(connection).close();
    verify(connection).prepareStatement("call cleanup_timeseries_by_ttl(?,?,?)");
    verify(dataSource).getConnection();
  }

  /**
   * Test {@link TimescaleTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Given {@link DataSource} {@link DataSource#getConnection()} throw {@link
   *       IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimescaleTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenDataSourceGetConnectionThrowIllegalArgumentException()
      throws SQLException {
    // Arrange
    when(dataSource.getConnection()).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> timescaleTimeseriesDao.cleanup(1L));
    verify(dataSource).getConnection();
  }

  /**
   * Test {@link TimescaleTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#getResultSet()} return {@link
   *       OracleCachedRowSet#OracleCachedRowSet()}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimescaleTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenPreparedStatementGetResultSetReturnOracleCachedRowSet()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getResultSet()).thenReturn(new OracleCachedRowSet());
    when(preparedStatement.getWarnings()).thenReturn(new SQLWarning());
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(preparedStatement).close();
    doNothing().when(preparedStatement).setQueryTimeout(anyInt());

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act
    timescaleTimeseriesDao.cleanup(1L);

    // Assert
    verify(connection).close();
    verify(connection).prepareStatement("call cleanup_timeseries_by_ttl(?,?,?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setObject(eq(1), isA(Object.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getResultSet();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement).setQueryTimeout(3600);
    verify(dataSource).getConnection();
  }

  /**
   * Test {@link TimescaleTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Given {@link PreparedStatement} {@link PreparedStatement#setObject(int, Object)} throw
   *       {@link IllegalArgumentException#IllegalArgumentException()}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimescaleTimeseriesDao.cleanup(long)"})
  public void testCleanup_givenPreparedStatementSetObjectThrowIllegalArgumentException()
      throws SQLException {
    // Arrange
    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    doThrow(new IllegalArgumentException())
        .when(preparedStatement)
        .setObject(anyInt(), Mockito.<Object>any());
    doThrow(new IllegalArgumentException()).when(preparedStatement).close();

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> timescaleTimeseriesDao.cleanup(1L));
    verify(connection).close();
    verify(connection).prepareStatement("call cleanup_timeseries_by_ttl(?,?,?)");
    verify(preparedStatement).setObject(eq(1), isA(Object.class));
    verify(preparedStatement).close();
    verify(dataSource).getConnection();
  }

  /**
   * Test {@link TimescaleTimeseriesDao#cleanup(long)}.
   *
   * <ul>
   *   <li>Then calls {@link PSQLWarning#getMessage()}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleTimeseriesDao#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimescaleTimeseriesDao.cleanup(long)"})
  public void testCleanup_thenCallsGetMessage() throws SQLException {
    // Arrange
    PSQLWarning psqlWarning = mock(PSQLWarning.class);
    when(psqlWarning.getMessage()).thenThrow(new IllegalArgumentException());

    PreparedStatement preparedStatement = mock(PreparedStatement.class);
    when(preparedStatement.execute()).thenReturn(true);
    when(preparedStatement.getWarnings()).thenReturn(psqlWarning);
    doNothing().when(preparedStatement).setLong(anyInt(), anyLong());
    doNothing().when(preparedStatement).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(preparedStatement).close();
    doNothing().when(preparedStatement).setQueryTimeout(anyInt());

    Connection connection = mock(Connection.class);
    when(connection.prepareStatement(Mockito.<String>any())).thenReturn(preparedStatement);
    doNothing().when(connection).close();
    when(dataSource.getConnection()).thenReturn(connection);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> timescaleTimeseriesDao.cleanup(1L));
    verify(connection).close();
    verify(connection).prepareStatement("call cleanup_timeseries_by_ttl(?,?,?)");
    verify(preparedStatement).execute();
    verify(preparedStatement, atLeast(1)).setLong(anyInt(), anyLong());
    verify(preparedStatement).setObject(eq(1), isA(Object.class));
    verify(preparedStatement).close();
    verify(preparedStatement).getWarnings();
    verify(preparedStatement).setQueryTimeout(3600);
    verify(dataSource).getConnection();
    verify(psqlWarning).getMessage();
  }
}
