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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.server.cache.CacheSpecsMap;
import org.thingsboard.server.cache.TBRedisClusterConfiguration;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.stats.DefaultCounter;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.dao.cache.CacheExecutorService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.timeseries.TsLatestRedisCache;

public class CachedRedisSqlTimeseriesLatestDaoDiffblueTest {
  /**
   * Test {@link CachedRedisSqlTimeseriesLatestDao#init()}.
   *
   * <p>Method under test: {@link CachedRedisSqlTimeseriesLatestDao#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void CachedRedisSqlTimeseriesLatestDao.init()"})
  public void testInit() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger();
    Id id =
        new Id(
            "Name",
            Tags.empty(),
            "Base Unit",
            "The characteristics of someone or something",
            Type.COUNTER);
    DefaultCounter defaultCounter = new DefaultCounter(aiCounter, new CumulativeCounter(id));
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(defaultCounter);
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    SqlTimeseriesLatestDao sqlDao = new SqlTimeseriesLatestDao();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    TsLatestRedisCache cache =
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());

    CachedRedisSqlTimeseriesLatestDao cachedRedisSqlTimeseriesLatestDao =
        new CachedRedisSqlTimeseriesLatestDao(cacheExecutorService, sqlDao, statsFactory, cache);

    // Act
    cachedRedisSqlTimeseriesLatestDao.init();

    // Assert
    verify(statsFactory, atLeast(1))
        .createDefaultCounter(eq("ts_latest.cache"), isA(String[].class));
    assertEquals(0, cachedRedisSqlTimeseriesLatestDao.hitCounter.get());
    assertEquals(0, cachedRedisSqlTimeseriesLatestDao.missCounter.get());
  }

  /**
   * Test {@link CachedRedisSqlTimeseriesLatestDao#doFindLatest(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Given {@link CacheExecutorService} {@link CacheExecutorService#submit(Callable)} return
   *       create.
   *   <li>Then calls {@link CacheExecutorService#submit(Callable)}.
   * </ul>
   *
   * <p>Method under test: {@link CachedRedisSqlTimeseriesLatestDao#doFindLatest(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture CachedRedisSqlTimeseriesLatestDao.doFindLatest(TenantId, EntityId, String)"
  })
  public void testDoFindLatest_givenCacheExecutorServiceSubmitReturnCreate_thenCallsSubmit() {
    // Arrange
    CacheExecutorService cacheExecutorService = mock(CacheExecutorService.class);
    SettableFuture<Object> createResult = SettableFuture.create();
    when(cacheExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    SqlTimeseriesLatestDao sqlDao = new SqlTimeseriesLatestDao();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    TsLatestRedisCache cache =
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());

    CachedRedisSqlTimeseriesLatestDao cachedRedisSqlTimeseriesLatestDao =
        new CachedRedisSqlTimeseriesLatestDao(cacheExecutorService, sqlDao, statsFactory, cache);

    // Act
    cachedRedisSqlTimeseriesLatestDao.doFindLatest(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(cacheExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test {@link CachedRedisSqlTimeseriesLatestDao#doFindLatest(TenantId, EntityId, String)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link CachedRedisSqlTimeseriesLatestDao#doFindLatest(TenantId, EntityId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "com.google.common.util.concurrent.ListenableFuture CachedRedisSqlTimeseriesLatestDao.doFindLatest(TenantId, EntityId, String)"
  })
  public void testDoFindLatest_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Object> listenableFutureTask = mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());

    CacheExecutorService cacheExecutorService = mock(CacheExecutorService.class);
    when(cacheExecutorService.submit(Mockito.<Callable<Object>>any()))
        .thenReturn(listenableFutureTask);
    SqlTimeseriesLatestDao sqlDao = new SqlTimeseriesLatestDao();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    TsLatestRedisCache cache =
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory());

    CachedRedisSqlTimeseriesLatestDao cachedRedisSqlTimeseriesLatestDao =
        new CachedRedisSqlTimeseriesLatestDao(cacheExecutorService, sqlDao, statsFactory, cache);

    // Act
    cachedRedisSqlTimeseriesLatestDao.doFindLatest(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(cacheExecutorService).submit(isA(Callable.class));
  }
}
