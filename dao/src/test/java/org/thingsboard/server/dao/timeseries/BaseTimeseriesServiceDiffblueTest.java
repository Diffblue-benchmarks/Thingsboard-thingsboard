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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.Aggregation;
import org.thingsboard.server.common.data.kv.BaseDeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.ReadTsKvQueryResult;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.kv.TsKvLatestRemovingResult;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {BaseTimeseriesService.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseTimeseriesServiceDiffblueTest {
  @Autowired private BaseTimeseriesService baseTimeseriesService;

  @MockBean private EntityViewService entityViewService;

  @MockBean private TimeseriesDao timeseriesDao;

  @MockBean private TimeseriesLatestDao timeseriesLatestDao;

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries() {
    // Arrange
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllByQueries(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new ArrayList<>()));
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries2() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllByQueries(
                ModelConstants.SYSTEM_TENANT, entityId, new ArrayList<>()));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries3() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenThrow(new IncorrectParameterException("An error occurred"));
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllByQueries(
                ModelConstants.SYSTEM_TENANT, entityId, new ArrayList<>()));
    verify(entityId).getEntityType();
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries4() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(createResult);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L, 1, "Order");
    queries.add(baseReadTsKvQuery);

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllByQueriesResult =
        baseTimeseriesService.findAllByQueries(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
    assertTrue(actualFindAllByQueriesResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllByQueriesResult);
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries5() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getKey())
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllByQueries(
                ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getKey();
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getAggregation()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries_givenBaseReadTsKvQueryGetAggregationReturnNull() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getAggregation()).thenReturn(null);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllByQueries(
                ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery).getAggregation();
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getEndTs()} return {@link
   *       Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries_givenBaseReadTsKvQueryGetEndTsReturnMax_value() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(Long.MAX_VALUE);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MIN);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllByQueries(
                ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getEndTs()} return one.
   *   <li>Then calls {@link BaseReadTsKvQuery#getEndTs()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries_givenBaseReadTsKvQueryGetEndTsReturnOne_thenCallsGetEndTs() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(createResult);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MIN);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllByQueriesResult =
        baseTimeseriesService.findAllByQueries(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
    assertTrue(actualFindAllByQueriesResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllByQueriesResult);
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getKey()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries_givenBaseReadTsKvQueryGetKeyReturnEmptyString() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getKey()).thenReturn("");

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllByQueries(
                ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getKey();
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getKey()} return {@code null}.
   *   <li>Then calls {@link BaseReadTsKvQuery#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries_givenBaseReadTsKvQueryGetKeyReturnNull_thenCallsGetKey() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getKey()).thenReturn(null);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllByQueries(
                ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getKey();
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getStartTs()} return {@link
   *       Long#MAX_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries_givenBaseReadTsKvQueryGetStartTsReturnMax_value() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(Long.MAX_VALUE);
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MIN);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllByQueries(
                ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long)} with {@code Key}
   *       and startTs is one and endTs is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries_givenBaseReadTsKvQueryWithKeyAndStartTsIsOneAndEndTsIsOne() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(createResult);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllByQueriesResult =
        baseTimeseriesService.findAllByQueries(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
    assertTrue(actualFindAllByQueriesResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllByQueriesResult);
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long)} with {@code Key}
   *       and startTs is one and endTs is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries_givenBaseReadTsKvQueryWithKeyAndStartTsIsOneAndEndTsIsOne2() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(createResult);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllByQueriesResult =
        baseTimeseriesService.findAllByQueries(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
    assertTrue(actualFindAllByQueriesResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllByQueriesResult);
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries_givenNull_whenArrayListAddNull() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(null);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllByQueries(
                ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries_whenNull_customer_id_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<List<ReadTsKvQueryResult>> actualFindAllByQueriesResult =
        baseTimeseriesService.findAllByQueries(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
    assertTrue(actualFindAllByQueriesResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllByQueriesResult);
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll() {
    // Arrange
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAll(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new ArrayList<>()));
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll2() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(createResult);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L, 1, "Order");
    queries.add(baseReadTsKvQuery);

    // Act
    baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll3() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getKey())
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getKey();
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getAggregation()} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_givenBaseReadTsKvQueryGetAggregationReturnNull() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getAggregation()).thenReturn(null);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery).getAggregation();
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getEndTs()} return {@link
   *       Long#MAX_VALUE}.
   *   <li>Then calls {@link BaseReadTsKvQuery#getEndTs()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_givenBaseReadTsKvQueryGetEndTsReturnMax_value_thenCallsGetEndTs() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(Long.MAX_VALUE);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MIN);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getEndTs()} return one.
   *   <li>Then calls {@link BaseReadTsKvQuery#getEndTs()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_givenBaseReadTsKvQueryGetEndTsReturnOne_thenCallsGetEndTs() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(createResult);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MIN);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act
    baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getKey()} return empty string.
   *   <li>Then calls {@link BaseReadTsKvQuery#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_givenBaseReadTsKvQueryGetKeyReturnEmptyString_thenCallsGetKey() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getKey()).thenReturn("");

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getKey();
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getKey()} return {@code null}.
   *   <li>Then calls {@link BaseReadTsKvQuery#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_givenBaseReadTsKvQueryGetKeyReturnNull_thenCallsGetKey() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getKey()).thenReturn(null);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getKey();
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery} {@link BaseReadTsKvQuery#getStartTs()} return {@link
   *       Long#MAX_VALUE}.
   *   <li>Then calls {@link BaseReadTsKvQuery#getEndTs()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_givenBaseReadTsKvQueryGetStartTsReturnMax_value_thenCallsGetEndTs() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    BaseReadTsKvQuery baseReadTsKvQuery = mock(BaseReadTsKvQuery.class);
    when(baseReadTsKvQuery.getInterval()).thenReturn(42L);
    when(baseReadTsKvQuery.getEndTs()).thenReturn(1L);
    when(baseReadTsKvQuery.getStartTs()).thenReturn(Long.MAX_VALUE);
    when(baseReadTsKvQuery.getAggregation()).thenReturn(Aggregation.MIN);
    when(baseReadTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(baseReadTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
    verify(baseReadTsKvQuery).getEndTs();
    verify(baseReadTsKvQuery).getKey();
    verify(baseReadTsKvQuery).getStartTs();
    verify(baseReadTsKvQuery, atLeast(1)).getAggregation();
    verify(baseReadTsKvQuery).getInterval();
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long)} with {@code Key}
   *       and startTs is one and endTs is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_givenBaseReadTsKvQueryWithKeyAndStartTsIsOneAndEndTsIsOne() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(createResult);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act
    baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseReadTsKvQuery#BaseReadTsKvQuery(String, long, long)} with {@code Key}
   *       and startTs is one and endTs is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_givenBaseReadTsKvQueryWithKeyAndStartTsIsOneAndEndTsIsOne2() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(createResult);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act
    baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_givenNull_whenArrayListAddNull_thenThrowIncorrectParameterException() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(null);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then calls {@link TimeseriesDao#findAllAsync(TenantId, EntityId, List)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_whenNull_customer_id_thenCallsFindAllAsync() {
    // Arrange
    SettableFuture<List<ReadTsKvQueryResult>> createResult = SettableFuture.create();
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(createResult);

    // Act
    baseTimeseriesService.findAll(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    verify(timeseriesDao).findAllAsync(isA(TenantId.class), isA(EntityId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, String)} with {@code
   * tenantId}, {@code entityId}, {@code key}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findLatest(TenantId, EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findLatest(TenantId, EntityId, String)"
  })
  public void testFindLatestWithTenantIdEntityIdKey() {
    // Arrange
    when(timeseriesLatestDao.findLatestOpt(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findLatest(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Key"));
    verify(timeseriesLatestDao).findLatestOpt(isA(TenantId.class), isA(EntityId.class), eq("Key"));
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, String)} with {@code
   * tenantId}, {@code entityId}, {@code key}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findLatest(TenantId, EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findLatest(TenantId, EntityId, String)"
  })
  public void testFindLatestWithTenantIdEntityIdKey_thenCallsGetId() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.findLatest(ModelConstants.SYSTEM_TENANT, entityId, "Key"));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, String)} with {@code
   * tenantId}, {@code entityId}, {@code key}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findLatest(TenantId, EntityId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findLatest(TenantId, EntityId, String)"
  })
  public void testFindLatestWithTenantIdEntityIdKey_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Optional<TsKvEntry>> createResult = SettableFuture.create();
    when(timeseriesLatestDao.findLatestOpt(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Optional<TsKvEntry>> actualFindLatestResult =
        baseTimeseriesService.findLatest(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(timeseriesLatestDao).findLatestOpt(isA(TenantId.class), isA(EntityId.class), eq("Key"));
    assertTrue(actualFindLatestResult instanceof SettableFuture);
    assertSame(createResult, actualFindLatestResult);
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code keys}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findLatest(TenantId, EntityId, Collection)"
  })
  public void testFindLatestWithTenantIdEntityIdKeys() {
    // Arrange
    SettableFuture<TsKvEntry> createResult = SettableFuture.create();
    when(timeseriesLatestDao.findLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any()))
        .thenReturn(createResult);

    LinkedHashSet<String> keys = new LinkedHashSet<>();
    keys.add("Keys");

    // Act
    baseTimeseriesService.findLatest(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, keys);

    // Assert
    verify(timeseriesLatestDao).findLatest(isA(TenantId.class), isA(EntityId.class), eq("Keys"));
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code keys}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findLatest(TenantId, EntityId, Collection)"
  })
  public void testFindLatestWithTenantIdEntityIdKeys2() {
    // Arrange
    when(timeseriesLatestDao.findLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    LinkedHashSet<String> keys = new LinkedHashSet<>();
    keys.add("Keys");

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findLatest(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, keys));
    verify(timeseriesLatestDao).findLatest(isA(TenantId.class), isA(EntityId.class), eq("Keys"));
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code keys}.
   *
   * <ul>
   *   <li>Given {@link BaseTimeseriesService} (default constructor).
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findLatest(TenantId, EntityId, Collection)"
  })
  public void testFindLatestWithTenantIdEntityIdKeys_givenBaseTimeseriesService_thenCallsGetId() {
    // Arrange
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.findLatest(ModelConstants.SYSTEM_TENANT, entityId, keys));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)} with {@code
   * tenantId}, {@code entityId}, {@code keys}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findLatest(TenantId, EntityId, Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findLatest(TenantId, EntityId, Collection)"
  })
  public void testFindLatestWithTenantIdEntityIdKeys_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<List<TsKvEntry>> actualFindLatestResult =
        baseTimeseriesService.findLatest(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    assertTrue(actualFindLatestResult.get().isEmpty());
    assertTrue(actualFindLatestResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#findAllLatest(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllLatest(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAllLatest(TenantId, EntityId)"})
  public void testFindAllLatest() {
    // Arrange
    when(timeseriesLatestDao.findAllLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllLatest(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(timeseriesLatestDao).findAllLatest(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAllLatest(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllLatest(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAllLatest(TenantId, EntityId)"})
  public void testFindAllLatest_thenCallsGetId() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.findAllLatest(ModelConstants.SYSTEM_TENANT, entityId));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#findAllLatest(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllLatest(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAllLatest(TenantId, EntityId)"})
  public void testFindAllLatest_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<TsKvEntry>> createResult = SettableFuture.create();
    when(timeseriesLatestDao.findAllLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<List<TsKvEntry>> actualFindAllLatestResult =
        baseTimeseriesService.findAllLatest(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(timeseriesLatestDao).findAllLatest(isA(TenantId.class), isA(EntityId.class));
    assertTrue(actualFindAllLatestResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllLatestResult);
  }

  /**
   * Test {@link BaseTimeseriesService#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseTimeseriesService.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_thenReturnEmpty() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByDeviceProfileId(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        baseTimeseriesService.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(timeseriesLatestDao).findAllKeysByDeviceProfileId(isA(TenantId.class), isNull());
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link BaseTimeseriesService#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseTimeseriesService.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_thenThrowIncorrectParameterException() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByDeviceProfileId(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null));
    verify(timeseriesLatestDao).findAllKeysByDeviceProfileId(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseTimeseriesService.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_givenNull_customer_id() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseTimeseriesService.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(timeseriesLatestDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseTimeseriesService.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_givenNull_customer_id2() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseTimeseriesService.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(timeseriesLatestDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseTimeseriesService.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_thenThrowIncorrectParameterException() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAllKeysByEntityIds(
                ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(timeseriesLatestDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseTimeseriesService.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIds_whenArrayList_thenReturnEmpty() {
    // Arrange
    when(timeseriesLatestDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        baseTimeseriesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(timeseriesLatestDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseTimeseriesService#cleanup(long)}.
   *
   * <ul>
   *   <li>Given {@link TimeseriesDao} {@link TimeseriesDao#cleanup(long)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseTimeseriesService.cleanup(long)"})
  public void testCleanup_givenTimeseriesDaoCleanupDoesNothing() {
    // Arrange
    doNothing().when(timeseriesDao).cleanup(anyLong());

    // Act
    baseTimeseriesService.cleanup(1L);

    // Assert
    verify(timeseriesDao).cleanup(1L);
  }

  /**
   * Test {@link BaseTimeseriesService#cleanup(long)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#cleanup(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseTimeseriesService.cleanup(long)"})
  public void testCleanup_thenThrowIncorrectParameterException() {
    // Arrange
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(timeseriesDao)
        .cleanup(anyLong());

    // Act and Assert
    assertThrows(IncorrectParameterException.class, () -> baseTimeseriesService.cleanup(1L));
    verify(timeseriesDao).cleanup(1L);
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)} with {@code tenantId},
   * {@code entityId}, {@code tsKvEntries}, {@code ttl}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.save(TenantId, EntityId, List, long)"})
  public void testSaveWithTenantIdEntityIdTsKvEntriesTtl() {
    // Arrange
    when(timeseriesDao.savePartition(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    tsKvEntries.add(basicTsKvEntry);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntries, 1L));
    verify(timeseriesDao)
        .savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)} with {@code tenantId},
   * {@code entityId}, {@code tsKvEntries}, {@code ttl}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.save(TenantId, EntityId, List, long)"})
  public void testSaveWithTenantIdEntityIdTsKvEntriesTtl2() {
    // Arrange
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesDao.save(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(createResult);
    SettableFuture<Integer> createResult2 = SettableFuture.create();
    when(timeseriesDao.savePartition(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult2);
    when(timeseriesLatestDao.saveLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    tsKvEntries.add(basicTsKvEntry);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntries, 1L));
    verify(timeseriesDao)
        .save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(1L));
    verify(timeseriesDao)
        .savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
    verify(timeseriesLatestDao)
        .saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)} with {@code tenantId},
   * {@code entityId}, {@code tsKvEntries}, {@code ttl}.
   *
   * <ul>
   *   <li>Then calls {@link TimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.save(TenantId, EntityId, List, long)"})
  public void testSaveWithTenantIdEntityIdTsKvEntriesTtl_thenCallsSave() {
    // Arrange
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesDao.save(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(createResult);
    SettableFuture<Integer> createResult2 = SettableFuture.create();
    when(timeseriesDao.savePartition(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult2);
    SettableFuture<Long> createResult3 = SettableFuture.create();
    when(timeseriesLatestDao.saveLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenReturn(createResult3);

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    tsKvEntries.add(basicTsKvEntry);

    // Act
    baseTimeseriesService.save(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntries, 1L);

    // Assert
    verify(timeseriesDao)
        .save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(1L));
    verify(timeseriesDao)
        .savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
    verify(timeseriesLatestDao)
        .saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)} with {@code tenantId},
   * {@code entityId}, {@code tsKvEntries}, {@code ttl}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#save(TenantId, EntityId, List, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.save(TenantId, EntityId, List, long)"})
  public void testSaveWithTenantIdEntityIdTsKvEntriesTtl_thenReturnGetIntValueIsZero()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<Integer> actualSaveResult =
        baseTimeseriesService.save(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new ArrayList<>(),
            1L);

    // Assert
    assertEquals(0, actualSaveResult.get().intValue());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)} with {@code tenantId},
   * {@code entityId}, {@code tsKvEntry}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.save(TenantId, EntityId, TsKvEntry)"})
  public void testSaveWithTenantIdEntityIdTsKvEntry() {
    // Arrange
    when(timeseriesDao.savePartition(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry));
    verify(timeseriesDao)
        .savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)} with {@code tenantId},
   * {@code entityId}, {@code tsKvEntry}.
   *
   * <ul>
   *   <li>Given {@link TimeseriesDao} {@link TimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   *       long)} return create.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.save(TenantId, EntityId, TsKvEntry)"})
  public void testSaveWithTenantIdEntityIdTsKvEntry_givenTimeseriesDaoSaveReturnCreate() {
    // Arrange
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesDao.save(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(createResult);
    SettableFuture<Integer> createResult2 = SettableFuture.create();
    when(timeseriesDao.savePartition(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult2);
    SettableFuture<Long> createResult3 = SettableFuture.create();
    when(timeseriesLatestDao.saveLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenReturn(createResult3);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act
    baseTimeseriesService.save(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry);

    // Assert
    verify(timeseriesDao)
        .save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(0L));
    verify(timeseriesDao)
        .savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
    verify(timeseriesLatestDao)
        .saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)} with {@code tenantId},
   * {@code entityId}, {@code tsKvEntry}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#save(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.save(TenantId, EntityId, TsKvEntry)"})
  public void testSaveWithTenantIdEntityIdTsKvEntry_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Integer> listenableFutureTask = mock(ListenableFutureTask.class);
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(timeseriesDao.save(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(listenableFutureTask);
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesDao.savePartition(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult);
    SettableFuture<Long> createResult2 = SettableFuture.create();
    when(timeseriesLatestDao.saveLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenReturn(createResult2);
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.save(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntry));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(timeseriesDao)
        .save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(0L));
    verify(timeseriesDao)
        .savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
    verify(timeseriesLatestDao)
        .saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List, long)}.
   *
   * <ul>
   *   <li>Given {@link TimeseriesDao} {@link TimeseriesDao#save(TenantId, EntityId, TsKvEntry,
   *       long)} return create.
   *   <li>Then calls {@link TimeseriesDao#save(TenantId, EntityId, TsKvEntry, long)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.saveWithoutLatest(TenantId, EntityId, List, long)"
  })
  public void testSaveWithoutLatest_givenTimeseriesDaoSaveReturnCreate_thenCallsSave() {
    // Arrange
    SettableFuture<Integer> createResult = SettableFuture.create();
    when(timeseriesDao.save(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any(), anyLong()))
        .thenReturn(createResult);
    SettableFuture<Integer> createResult2 = SettableFuture.create();
    when(timeseriesDao.savePartition(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenReturn(createResult2);

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    tsKvEntries.add(basicTsKvEntry);

    // Act
    baseTimeseriesService.saveWithoutLatest(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntries, 1L);

    // Assert
    verify(timeseriesDao)
        .save(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class), eq(1L));
    verify(timeseriesDao)
        .savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
  }

  /**
   * Test {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List, long)}.
   *
   * <ul>
   *   <li>Given {@link TimeseriesDao}.
   *   <li>Then return {@link ListenableFuture#get()} intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.saveWithoutLatest(TenantId, EntityId, List, long)"
  })
  public void testSaveWithoutLatest_givenTimeseriesDao_thenReturnGetIntValueIsZero()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<Integer> actualSaveWithoutLatestResult =
        baseTimeseriesService.saveWithoutLatest(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new ArrayList<>(),
            1L);

    // Assert
    assertEquals(0, actualSaveWithoutLatestResult.get().intValue());
    assertTrue(actualSaveWithoutLatestResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List, long)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#saveWithoutLatest(TenantId, EntityId, List,
   * long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.saveWithoutLatest(TenantId, EntityId, List, long)"
  })
  public void testSaveWithoutLatest_thenThrowIncorrectParameterException() {
    // Arrange
    when(timeseriesDao.savePartition(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(), Mockito.<String>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    tsKvEntries.add(basicTsKvEntry);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.saveWithoutLatest(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntries, 1L));
    verify(timeseriesDao)
        .savePartition(isA(TenantId.class), isA(EntityId.class), eq(1L), eq("Key"));
  }

  /**
   * Test {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link TimeseriesLatestDao} {@link TimeseriesLatestDao#saveLatest(TenantId,
   *       EntityId, TsKvEntry)} return create.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.saveLatest(TenantId, EntityId, List)"})
  public void testSaveLatest_givenTimeseriesLatestDaoSaveLatestReturnCreate() {
    // Arrange
    SettableFuture<Long> createResult = SettableFuture.create();
    when(timeseriesLatestDao.saveLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenReturn(createResult);

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    tsKvEntries.add(basicTsKvEntry);

    // Act
    baseTimeseriesService.saveLatest(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntries);

    // Assert
    verify(timeseriesLatestDao)
        .saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link TimeseriesLatestDao}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.saveLatest(TenantId, EntityId, List)"})
  public void testSaveLatest_givenTimeseriesLatestDao_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<List<Long>> actualSaveLatestResult =
        baseTimeseriesService.saveLatest(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    assertTrue(actualSaveLatestResult.get().isEmpty());
    assertTrue(actualSaveLatestResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#saveLatest(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.saveLatest(TenantId, EntityId, List)"})
  public void testSaveLatest_thenThrowIncorrectParameterException() {
    // Arrange
    when(timeseriesLatestDao.saveLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<TsKvEntry> tsKvEntries = new ArrayList<>();
    BasicTsKvEntry basicTsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));
    tsKvEntries.add(basicTsKvEntry);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.saveLatest(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, tsKvEntries));
    verify(timeseriesLatestDao)
        .saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove() {
    // Arrange
    when(timeseriesDao.remove(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.remove(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                deleteTsKvQueries));
    verify(timeseriesDao)
        .remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove2() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);
    when(timeseriesLatestDao.removeLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.remove(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                deleteTsKvQueries));
    verify(timeseriesDao)
        .remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
    verify(timeseriesLatestDao)
        .removeLatest(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove3() {
    // Arrange
    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("", 1L, 1L));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.remove(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                deleteTsKvQueries));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove4() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);

    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getDeleteLatest())
        .thenThrow(new IncorrectParameterException("An error occurred"));
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(baseDeleteTsKvQuery);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.remove(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                deleteTsKvQueries));
    verify(baseDeleteTsKvQuery).getDeleteLatest();
    verify(baseDeleteTsKvQuery).getKey();
    verify(timeseriesDao)
        .remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseDeleteTsKvQuery} {@link BaseDeleteTsKvQuery#getDeleteLatest()} return
   *       {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove_givenBaseDeleteTsKvQueryGetDeleteLatestReturnFalse() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);

    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getDeleteLatest()).thenReturn(false);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(baseDeleteTsKvQuery);

    // Act
    baseTimeseriesService.remove(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, deleteTsKvQueries);

    // Assert
    verify(baseDeleteTsKvQuery).getDeleteLatest();
    verify(baseDeleteTsKvQuery).getKey();
    verify(timeseriesDao)
        .remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseDeleteTsKvQuery} {@link BaseDeleteTsKvQuery#getDeleteLatest()} return
   *       {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove_givenBaseDeleteTsKvQueryGetDeleteLatestReturnTrue() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);
    SettableFuture<TsKvLatestRemovingResult> createResult2 = SettableFuture.create();
    when(timeseriesLatestDao.removeLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult2);

    BaseDeleteTsKvQuery baseDeleteTsKvQuery = mock(BaseDeleteTsKvQuery.class);
    when(baseDeleteTsKvQuery.getDeleteLatest()).thenReturn(true);
    when(baseDeleteTsKvQuery.getKey()).thenReturn("Key");

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(baseDeleteTsKvQuery);

    // Act
    baseTimeseriesService.remove(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, deleteTsKvQueries);

    // Assert
    verify(baseDeleteTsKvQuery).getDeleteLatest();
    verify(baseDeleteTsKvQuery).getKey();
    verify(timeseriesDao)
        .remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
    verify(timeseriesLatestDao)
        .removeLatest(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseDeleteTsKvQuery#BaseDeleteTsKvQuery(String, long, long)} with key is
   *       {@code null} and startTs is one and endTs is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove_givenBaseDeleteTsKvQueryWithKeyIsNullAndStartTsIsOneAndEndTsIsOne() {
    // Arrange
    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery(null, 1L, 1L));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.remove(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                deleteTsKvQueries));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link BaseTimeseriesService} (default constructor).
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove_givenBaseTimeseriesService_thenCallsGetId() {
    // Arrange
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 1L, 1L));
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.remove(
                ModelConstants.SYSTEM_TENANT, entityId, deleteTsKvQueries));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove_givenNull_whenArrayListAddNull_thenThrowIncorrectParameterException() {
    // Arrange
    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(null);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.remove(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                deleteTsKvQueries));
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Given {@link TimeseriesDao}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove_givenTimeseriesDao_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<List<TsKvLatestRemovingResult>> actualRemoveResult =
        baseTimeseriesService.remove(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    assertTrue(actualRemoveResult.get().isEmpty());
    assertTrue(actualRemoveResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Then calls {@link TimeseriesLatestDao#removeLatest(TenantId, EntityId, DeleteTsKvQuery)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#remove(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.remove(TenantId, EntityId, List)"})
  public void testRemove_thenCallsRemoveLatest() {
    // Arrange
    SettableFuture<Void> createResult = SettableFuture.create();
    when(timeseriesDao.remove(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);
    SettableFuture<TsKvLatestRemovingResult> createResult2 = SettableFuture.create();
    when(timeseriesLatestDao.removeLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult2);

    ArrayList<DeleteTsKvQuery> deleteTsKvQueries = new ArrayList<>();
    deleteTsKvQueries.add(new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Act
    baseTimeseriesService.remove(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, deleteTsKvQueries);

    // Assert
    verify(timeseriesDao)
        .remove(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
    verify(timeseriesLatestDao)
        .removeLatest(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#removeLatest(TenantId, EntityId, Collection)}.
   *
   * <p>Method under test: {@link BaseTimeseriesService#removeLatest(TenantId, EntityId,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.removeLatest(TenantId, EntityId, Collection)"
  })
  public void testRemoveLatest() {
    // Arrange
    when(timeseriesLatestDao.removeLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    LinkedHashSet<String> keys = new LinkedHashSet<>();
    keys.add("Keys");

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.removeLatest(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, keys));
    verify(timeseriesLatestDao)
        .removeLatest(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#removeLatest(TenantId, EntityId, Collection)}.
   *
   * <ul>
   *   <li>Given {@link BaseTimeseriesService} (default constructor).
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#removeLatest(TenantId, EntityId,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.removeLatest(TenantId, EntityId, Collection)"
  })
  public void testRemoveLatest_givenBaseTimeseriesService_thenCallsGetId() {
    // Arrange
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new IncorrectParameterException("An error occurred"));

    ArrayList<String> keys = new ArrayList<>();
    keys.add("42");
    keys.add("foo");

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () -> baseTimeseriesService.removeLatest(ModelConstants.SYSTEM_TENANT, entityId, keys));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseTimeseriesService#removeLatest(TenantId, EntityId, Collection)}.
   *
   * <ul>
   *   <li>Given {@link TimeseriesLatestDao} {@link TimeseriesLatestDao#removeLatest(TenantId,
   *       EntityId, DeleteTsKvQuery)} return create.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#removeLatest(TenantId, EntityId,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.removeLatest(TenantId, EntityId, Collection)"
  })
  public void testRemoveLatest_givenTimeseriesLatestDaoRemoveLatestReturnCreate() {
    // Arrange
    SettableFuture<TsKvLatestRemovingResult> createResult = SettableFuture.create();
    when(timeseriesLatestDao.removeLatest(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);

    LinkedHashSet<String> keys = new LinkedHashSet<>();
    keys.add("Keys");

    // Act
    baseTimeseriesService.removeLatest(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, keys);

    // Assert
    verify(timeseriesLatestDao)
        .removeLatest(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test {@link BaseTimeseriesService#removeLatest(TenantId, EntityId, Collection)}.
   *
   * <ul>
   *   <li>Given {@link TimeseriesLatestDao}.
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#removeLatest(TenantId, EntityId,
   * Collection)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.removeLatest(TenantId, EntityId, Collection)"
  })
  public void testRemoveLatest_givenTimeseriesLatestDao_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<List<TsKvLatestRemovingResult>> actualRemoveLatestResult =
        baseTimeseriesService.removeLatest(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    assertTrue(actualRemoveLatestResult.get().isEmpty());
    assertTrue(actualRemoveLatestResult.isDone());
  }

  /**
   * Test {@link BaseTimeseriesService#removeAllLatest(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link TimeseriesLatestDao} {@link TimeseriesLatestDao#findAllLatest(TenantId,
   *       EntityId)} return create.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#removeAllLatest(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.removeAllLatest(TenantId, EntityId)"})
  public void testRemoveAllLatest_givenTimeseriesLatestDaoFindAllLatestReturnCreate() {
    // Arrange
    SettableFuture<List<TsKvEntry>> createResult = SettableFuture.create();
    when(timeseriesLatestDao.findAllLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(createResult);

    // Act
    baseTimeseriesService.removeAllLatest(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(timeseriesLatestDao).findAllLatest(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseTimeseriesService#removeAllLatest(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link IncorrectParameterException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#removeAllLatest(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.removeAllLatest(TenantId, EntityId)"})
  public void testRemoveAllLatest_thenThrowIncorrectParameterException() {
    // Arrange
    when(timeseriesLatestDao.findAllLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenThrow(new IncorrectParameterException("An error occurred"));

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.removeAllLatest(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(timeseriesLatestDao).findAllLatest(isA(TenantId.class), isA(EntityId.class));
  }
}
