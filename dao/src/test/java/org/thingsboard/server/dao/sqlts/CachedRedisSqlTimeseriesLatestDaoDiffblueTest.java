package org.thingsboard.server.dao.sqlts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.thingsboard.common.util.ListeningExecutor;
import org.thingsboard.server.cache.CacheSpecsMap;
import org.thingsboard.server.cache.TBRedisClusterConfiguration;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.BaseDeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.BasicTsKvEntry;
import org.thingsboard.server.common.data.kv.DeleteTsKvQuery;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.kv.TsKvLatestRemovingResult;
import org.thingsboard.server.common.stats.DefaultCounter;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.dao.cache.CacheExecutorService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.timeseries.TsLatestRedisCache;

public class CachedRedisSqlTimeseriesLatestDaoDiffblueTest {
  /**
   * Test {@link CachedRedisSqlTimeseriesLatestDao#init()}.
   * <p>
   * Method under test: {@link CachedRedisSqlTimeseriesLatestDao#init()}
   */
  @Test
  public void testInit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    SqlTimeseriesLatestDao sqlDao = new SqlTimeseriesLatestDao();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CachedRedisSqlTimeseriesLatestDao cachedRedisSqlTimeseriesLatestDao = new CachedRedisSqlTimeseriesLatestDao(
        cacheExecutorService, sqlDao, statsFactory,
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory()));

    // Act
    cachedRedisSqlTimeseriesLatestDao.init();

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("ts_latest.cache"), isA(String[].class));
    assertEquals(1, cachedRedisSqlTimeseriesLatestDao.hitCounter.get());
    assertEquals(1, cachedRedisSqlTimeseriesLatestDao.missCounter.get());
  }

  /**
   * Test
   * {@link CachedRedisSqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}.
   * <ul>
   *   <li>Then calls
   * {@link SqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedRedisSqlTimeseriesLatestDao#saveLatest(TenantId, EntityId, TsKvEntry)}
   */
  @Test
  public void testSaveLatest_thenCallsSaveLatest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlTimeseriesLatestDao sqlDao = mock(SqlTimeseriesLatestDao.class);
    SettableFuture<Long> createResult = SettableFuture.create();
    when(sqlDao.saveLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<TsKvEntry>any()))
        .thenReturn(createResult);
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CachedRedisSqlTimeseriesLatestDao cachedRedisSqlTimeseriesLatestDao = new CachedRedisSqlTimeseriesLatestDao(
        cacheExecutorService, sqlDao, statsFactory,
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory()));

    // Act
    cachedRedisSqlTimeseriesLatestDao.saveLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        new BasicTsKvEntry(1L, new JsonDataEntry("Key", "42")));

    // Assert
    verify(sqlDao).saveLatest(isA(TenantId.class), isA(EntityId.class), isA(TsKvEntry.class));
  }

  /**
   * Test
   * {@link CachedRedisSqlTimeseriesLatestDao#removeLatest(TenantId, EntityId, DeleteTsKvQuery)}.
   * <ul>
   *   <li>Then calls
   * {@link SqlTimeseriesLatestDao#removeLatest(TenantId, EntityId, DeleteTsKvQuery)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedRedisSqlTimeseriesLatestDao#removeLatest(TenantId, EntityId, DeleteTsKvQuery)}
   */
  @Test
  public void testRemoveLatest_thenCallsRemoveLatest() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlTimeseriesLatestDao sqlDao = mock(SqlTimeseriesLatestDao.class);
    SettableFuture<TsKvLatestRemovingResult> createResult = SettableFuture.create();
    when(sqlDao.removeLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<DeleteTsKvQuery>any()))
        .thenReturn(createResult);
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CachedRedisSqlTimeseriesLatestDao cachedRedisSqlTimeseriesLatestDao = new CachedRedisSqlTimeseriesLatestDao(
        cacheExecutorService, sqlDao, statsFactory,
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory()));

    // Act
    cachedRedisSqlTimeseriesLatestDao.removeLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
        new BaseDeleteTsKvQuery("Key", 1L, 1L));

    // Assert
    verify(sqlDao).removeLatest(isA(TenantId.class), isA(EntityId.class), isA(DeleteTsKvQuery.class));
  }

  /**
   * Test
   * {@link CachedRedisSqlTimeseriesLatestDao#findLatestOpt(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Given {@link CacheExecutorService}
   * {@link ListeningExecutor#submit(Callable)} return create.</li>
   *   <li>Then calls {@link ListeningExecutor#submit(Callable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedRedisSqlTimeseriesLatestDao#findLatestOpt(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatestOpt_givenCacheExecutorServiceSubmitReturnCreate_thenCallsSubmit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CacheExecutorService cacheExecutorService = mock(CacheExecutorService.class);
    SettableFuture<Object> createResult = SettableFuture.create();
    when(cacheExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    SqlTimeseriesLatestDao sqlDao = new SqlTimeseriesLatestDao();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act
    (new CachedRedisSqlTimeseriesLatestDao(cacheExecutorService, sqlDao, statsFactory,
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory())))
        .findLatestOpt(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(cacheExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test
   * {@link CachedRedisSqlTimeseriesLatestDao#findLatest(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Given {@link CacheExecutorService}
   * {@link ListeningExecutor#submit(Callable)} return create.</li>
   *   <li>Then calls {@link ListeningExecutor#submit(Callable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedRedisSqlTimeseriesLatestDao#findLatest(TenantId, EntityId, String)}
   */
  @Test
  public void testFindLatest_givenCacheExecutorServiceSubmitReturnCreate_thenCallsSubmit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CacheExecutorService cacheExecutorService = mock(CacheExecutorService.class);
    SettableFuture<Object> createResult = SettableFuture.create();
    when(cacheExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    SqlTimeseriesLatestDao sqlDao = new SqlTimeseriesLatestDao();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act
    (new CachedRedisSqlTimeseriesLatestDao(cacheExecutorService, sqlDao, statsFactory,
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory())))
        .findLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(cacheExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test
   * {@link CachedRedisSqlTimeseriesLatestDao#doFindLatest(TenantId, EntityId, String)}.
   * <ul>
   *   <li>Given {@link CacheExecutorService}
   * {@link ListeningExecutor#submit(Callable)} return create.</li>
   *   <li>Then calls {@link ListeningExecutor#submit(Callable)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedRedisSqlTimeseriesLatestDao#doFindLatest(TenantId, EntityId, String)}
   */
  @Test
  public void testDoFindLatest_givenCacheExecutorServiceSubmitReturnCreate_thenCallsSubmit() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CacheExecutorService cacheExecutorService = mock(CacheExecutorService.class);
    SettableFuture<Object> createResult = SettableFuture.create();
    when(cacheExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    SqlTimeseriesLatestDao sqlDao = new SqlTimeseriesLatestDao();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act
    (new CachedRedisSqlTimeseriesLatestDao(cacheExecutorService, sqlDao, statsFactory,
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory())))
        .doFindLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Assert
    verify(cacheExecutorService).submit(isA(Callable.class));
  }

  /**
   * Test
   * {@link CachedRedisSqlTimeseriesLatestDao#findAllLatest(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedRedisSqlTimeseriesLatestDao#findAllLatest(TenantId, EntityId)}
   */
  @Test
  public void testFindAllLatest_thenReturnSettableFuture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlTimeseriesLatestDao sqlDao = mock(SqlTimeseriesLatestDao.class);
    SettableFuture<List<TsKvEntry>> createResult = SettableFuture.create();
    when(sqlDao.findAllLatest(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(createResult);
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();

    // Act
    ListenableFuture<List<TsKvEntry>> actualFindAllLatestResult = (new CachedRedisSqlTimeseriesLatestDao(
        cacheExecutorService, sqlDao, statsFactory,
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory())))
        .findAllLatest(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(sqlDao).findAllLatest(isA(TenantId.class), isA(EntityId.class));
    assertTrue(actualFindAllLatestResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllLatestResult);
  }

  /**
   * Test
   * {@link CachedRedisSqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedRedisSqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenNull_customer_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlTimeseriesLatestDao sqlDao = mock(SqlTimeseriesLatestDao.class);
    when(sqlDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CachedRedisSqlTimeseriesLatestDao cachedRedisSqlTimeseriesLatestDao = new CachedRedisSqlTimeseriesLatestDao(
        cacheExecutorService, sqlDao, statsFactory,
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory()));

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = cachedRedisSqlTimeseriesLatestDao
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(sqlDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link CachedRedisSqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedRedisSqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_givenNull_customer_id2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlTimeseriesLatestDao sqlDao = mock(SqlTimeseriesLatestDao.class);
    when(sqlDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CachedRedisSqlTimeseriesLatestDao cachedRedisSqlTimeseriesLatestDao = new CachedRedisSqlTimeseriesLatestDao(
        cacheExecutorService, sqlDao, statsFactory,
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory()));

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = cachedRedisSqlTimeseriesLatestDao
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(sqlDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link CachedRedisSqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedRedisSqlTimeseriesLatestDao#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIds_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlTimeseriesLatestDao sqlDao = mock(SqlTimeseriesLatestDao.class);
    when(sqlDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    DefaultStatsFactory statsFactory = new DefaultStatsFactory();
    TBRedisClusterConfiguration configuration = new TBRedisClusterConfiguration();
    CacheSpecsMap cacheSpecsMap = new CacheSpecsMap();
    CachedRedisSqlTimeseriesLatestDao cachedRedisSqlTimeseriesLatestDao = new CachedRedisSqlTimeseriesLatestDao(
        cacheExecutorService, sqlDao, statsFactory,
        new TsLatestRedisCache(configuration, cacheSpecsMap, new JedisConnectionFactory()));

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = cachedRedisSqlTimeseriesLatestDao
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(sqlDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }
}
