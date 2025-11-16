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
import java.util.List;
import java.util.Optional;
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
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.ReadTsKvQueryResult;
import org.thingsboard.server.common.data.kv.TsKvEntry;
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
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();

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
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", -1L, 1000L));
    queries.add(mock(BaseReadTsKvQuery.class));

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
   * <p>Method under test: {@link BaseTimeseriesService#findAllByQueries(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseTimeseriesService.findAllByQueries(TenantId, EntityId, List)"
  })
  public void testFindAllByQueries6() {
    // Arrange
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", -1L, Long.MAX_VALUE));
    queries.add(mock(BaseReadTsKvQuery.class));

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
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();

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
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();

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
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();

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
   *   <li>Given {@code TENANT}.
   *   <li>When {@link AlarmId} {@link AlarmId#getEntityType()} return {@code TENANT}.
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
  public void testFindAllByQueries_givenTenant_whenAlarmIdGetEntityTypeReturnTenant() {
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
   *   <li>Given {@code TENANT}.
   *   <li>When {@link AlarmId} {@link AlarmId#getEntityType()} return {@code TENANT}.
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
  public void testFindAllByQueries_givenTenant_whenAlarmIdGetEntityTypeReturnTenant2() {
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
   *   <li>Then calls {@link BaseReadTsKvQuery#getAggregation()}.
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
  public void testFindAllByQueries_thenCallsGetAggregation() {
    // Arrange
    BaseTimeseriesService baseTimeseriesService = new BaseTimeseriesService();

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
    ListenableFutureTask<List<ReadTsKvQueryResult>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doThrow(new IncorrectParameterException("An error occurred"))
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        IncorrectParameterException.class,
        () ->
            baseTimeseriesService.findAll(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new ArrayList<>()));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
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
    ListenableFutureTask<List<ReadTsKvQueryResult>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(listenableFutureTask);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    BaseReadTsKvQuery baseReadTsKvQuery = new BaseReadTsKvQuery("Key", 1L, 1L, 1, "Order");
    queries.add(baseReadTsKvQuery);

    // Act
    baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
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
  public void testFindAll4() {
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
    ListenableFutureTask<List<ReadTsKvQueryResult>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(listenableFutureTask);

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
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
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
    ListenableFutureTask<List<ReadTsKvQueryResult>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(listenableFutureTask);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act
    baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
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
    ListenableFutureTask<List<ReadTsKvQueryResult>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(listenableFutureTask);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));
    queries.add(new BaseReadTsKvQuery("Key", 1L, 1L));

    // Act
    baseTimeseriesService.findAll(ModelConstants.SYSTEM_TENANT, entityId, queries);

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
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
   *   <li>Given {@link TimeseriesDao} {@link TimeseriesDao#findAllAsync(TenantId, EntityId, List)}
   *       return create.
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_givenTimeseriesDaoFindAllAsyncReturnCreate_whenNull_customer_id() {
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
   * Test {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseTimeseriesService#findAll(TenantId, EntityId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseTimeseriesService.findAll(TenantId, EntityId, List)"})
  public void testFindAll_whenNull_customer_id_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<List<ReadTsKvQueryResult>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(timeseriesDao.findAllAsync(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<ReadTsKvQuery>>any()))
        .thenReturn(listenableFutureTask);

    // Act
    baseTimeseriesService.findAll(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
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
}
