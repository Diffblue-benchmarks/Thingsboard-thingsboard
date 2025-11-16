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

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Executor;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.kv.BaseReadTsKvQuery;
import org.thingsboard.server.common.data.kv.ReadTsKvQuery;
import org.thingsboard.server.dao.model.sql.AbstractTsKvEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@RunWith(MockitoJUnitRunner.class)
public class BaseAbstractSqlTimeseriesDaoDiffblueTest {
  @Mock private JpaExecutorService jpaExecutorService;

  @InjectMocks private SqlTimeseriesLatestDao sqlTimeseriesLatestDao;

  /**
   * Test {@link BaseAbstractSqlTimeseriesDao#getReadTsKvQueryResultFuture(ReadTsKvQuery,
   * ListenableFuture)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAbstractSqlTimeseriesDao#getReadTsKvQueryResultFuture(ReadTsKvQuery, ListenableFuture)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAbstractSqlTimeseriesDao.getReadTsKvQueryResultFuture(ReadTsKvQuery, ListenableFuture)"
  })
  public void testGetReadTsKvQueryResultFuture_thenCallsAddListener() {
    // Arrange
    BaseReadTsKvQuery query = new BaseReadTsKvQuery("Key", 1L, 1L);

    ListenableFutureTask<List<Optional<? extends AbstractTsKvEntity>>> future =
        mock(ListenableFutureTask.class);
    doNothing().when(future).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    // Act
    sqlTimeseriesLatestDao.getReadTsKvQueryResultFuture(query, future);

    // Assert
    verify(future).addListener(isA(Runnable.class), isA(Executor.class));
  }
}
