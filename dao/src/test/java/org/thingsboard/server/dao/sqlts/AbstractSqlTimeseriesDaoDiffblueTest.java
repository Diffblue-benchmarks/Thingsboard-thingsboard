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

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sqlts.sql.JpaSqlTimeseriesDao;

@RunWith(MockitoJUnitRunner.class)
public class AbstractSqlTimeseriesDaoDiffblueTest {
  @Mock private JpaExecutorService jpaExecutorService;

  @InjectMocks private JpaSqlTimeseriesDao jpaSqlTimeseriesDao;

  /**
   * Test {@link AbstractSqlTimeseriesDao#processFindAllAsync(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>Then calls {@link JpaExecutorService#submit(Callable)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTimeseriesDao#processFindAllAsync(TenantId, EntityId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture AbstractSqlTimeseriesDao.processFindAllAsync(TenantId, EntityId, List)"
  })
  public void testProcessFindAllAsync_thenCallsSubmit() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    ArrayList<ReadTsKvQuery> queries = new ArrayList<>();
    queries.add(new BaseReadTsKvQuery("Key", -1L, 1L));

    // Act
    jpaSqlTimeseriesDao.processFindAllAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, queries);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link AbstractSqlTimeseriesDao#processFindAllAsync(TenantId, EntityId, List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then calls {@link JpaExecutorService#execute(Runnable)}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTimeseriesDao#processFindAllAsync(TenantId, EntityId,
   * List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture AbstractSqlTimeseriesDao.processFindAllAsync(TenantId, EntityId, List)"
  })
  public void testProcessFindAllAsync_whenArrayList_thenCallsExecute() {
    // Arrange
    doNothing().when(jpaExecutorService).execute(Mockito.<Runnable>any());

    // Act
    jpaSqlTimeseriesDao.processFindAllAsync(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>());

    // Assert
    verify(jpaExecutorService).execute(isA(Runnable.class));
  }

  /**
   * Test {@link AbstractSqlTimeseriesDao#computeTtl(long)}.
   *
   * <p>Method under test: {@link AbstractSqlTimeseriesDao#computeTtl(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long AbstractSqlTimeseriesDao.computeTtl(long)"})
  public void testComputeTtl() {
    // Arrange, Act and Assert
    assertEquals(1L, new JpaSqlTimeseriesDao().computeTtl(1L));
  }

  /**
   * Test {@link AbstractSqlTimeseriesDao#getDataPointDays(TsKvEntry, long)}.
   *
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is
   *       {@code 42}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link AbstractSqlTimeseriesDao#getDataPointDays(TsKvEntry, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"int AbstractSqlTimeseriesDao.getDataPointDays(TsKvEntry, long)"})
  public void testGetDataPointDays_whenJsonDataEntryWithKeyAndValueIs42_thenReturnOne() {
    // Arrange
    JpaSqlTimeseriesDao jpaSqlTimeseriesDao = new JpaSqlTimeseriesDao();
    BasicTsKvEntry tsKvEntry = new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42"));

    // Act and Assert
    assertEquals(1, jpaSqlTimeseriesDao.getDataPointDays(tsKvEntry, 1L));
  }
}
