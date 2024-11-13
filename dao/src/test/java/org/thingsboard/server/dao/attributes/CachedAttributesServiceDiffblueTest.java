package org.thingsboard.server.dao.attributes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.common.util.ListeningExecutor;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.stats.DefaultCounter;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.dao.cache.CacheExecutorService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;

public class CachedAttributesServiceDiffblueTest {
  /**
   * Test {@link CachedAttributesService#init()}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createDefaultCounter(String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link CachedAttributesService#init()}
   */
  @Test
  public void testInit_givenAtomicIntegerWithOne_thenCallsCreateDefaultCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();

    // Act
    (new CachedAttributesService(attributesDao, jpaExecutorService, statsFactory, cacheExecutorService,
        new AttributeCaffeineCache(new CaffeineCacheManager()))).init();

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
  }

  /**
   * Test
   * {@link CachedAttributesService#getExecutor(String, CacheExecutorService)}.
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.</li>
   *   <li>When {@code Cache Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#getExecutor(String, CacheExecutorService)}
   */
  @Test
  public void testGetExecutor_givenAtomicIntegerWithOne_whenCacheType_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    // Act
    ListeningExecutorService actualExecutor = cachedAttributesService.getExecutor("Cache Type",
        new CacheExecutorService());

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    assertNull(actualExecutor);
  }

  /**
   * Test
   * {@link CachedAttributesService#getExecutor(String, CacheExecutorService)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createDefaultCounter(String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#getExecutor(String, CacheExecutorService)}
   */
  @Test
  public void testGetExecutor_whenEmptyString_thenCallsCreateDefaultCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    // Act
    cachedAttributesService.getExecutor("", new CacheExecutorService());

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
  }

  /**
   * Test
   * {@link CachedAttributesService#getExecutor(String, CacheExecutorService)}.
   * <ul>
   *   <li>When {@link CachedAttributesService#LOCAL_CACHE_TYPE}.</li>
   *   <li>Then calls
   * {@link DefaultStatsFactory#createDefaultCounter(String, String[])}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#getExecutor(String, CacheExecutorService)}
   */
  @Test
  public void testGetExecutor_whenLocal_cache_type_thenCallsCreateDefaultCounter() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    // Act
    cachedAttributesService.getExecutor(CachedAttributesService.LOCAL_CACHE_TYPE, new CacheExecutorService());

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
  }

  /**
   * Test
   * {@link CachedAttributesService#findAll(TenantId, EntityId, AttributeScope)}.
   * <ul>
   *   <li>Given {@link JpaExecutorService}
   * {@link ListeningExecutor#submit(Callable)} return create.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#findAll(TenantId, EntityId, AttributeScope)}
   */
  @Test
  public void testFindAll_givenJpaExecutorServiceSubmitReturnCreate_thenReturnSettableFuture() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaExecutorService jpaExecutorService = mock(JpaExecutorService.class);
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    CacheExecutorService cacheExecutorService = new CacheExecutorService();

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindAllResult = (new CachedAttributesService(attributesDao,
        jpaExecutorService, statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager())))
        .findAll(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    assertTrue(actualFindAllResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllResult);
  }

  /**
   * Test
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   * with {@code tenantId}, {@code entityIds}, {@code scope}.
   * <p>
   * Method under test:
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = cachedAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>(), "Scope");

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   * with {@code tenantId}, {@code entityIds}, {@code scope}.
   * <p>
   * Method under test:
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = cachedAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>(), "");

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   * with {@code tenantId}, {@code entityIds}, {@code scope}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_givenNull_customer_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = cachedAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds, "Scope");

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   * with {@code tenantId}, {@code entityIds}, {@code scope}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_givenNull_customer_id2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = cachedAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds, "Scope");

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)}
   * with {@code tenantId}, {@code entityIds}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_givenNull_customer_id() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = cachedAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)}
   * with {@code tenantId}, {@code entityIds}.
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_givenNull_customer_id2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = cachedAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)}
   * with {@code tenantId}, {@code entityIds}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_whenArrayList() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    // Act
    List<String> actualFindAllKeysByEntityIdsResult = cachedAttributesService
        .findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link CachedAttributesService#save(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Then return {@link Future#get()} Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#save(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testSaveWithTenantIdEntityIdAttributeScopeList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    // Act
    ListenableFuture<List<Long>> actualSaveResult = cachedAttributesService.save(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE, new ArrayList<>());

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    assertTrue(actualSaveResult.get().isEmpty());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test
   * {@link CachedAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_given42_whenArrayListAdd42()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAllWithVersions(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<AttributeScope>any(), Mockito.<List<String>>any())).thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("42");
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult = cachedAttributesService
        .removeAll(ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, attributeKeys);

    // Assert
    verify(entityId).getId();
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).removeAllWithVersions(isA(TenantId.class), isA(EntityId.class),
        eq(AttributeScope.CLIENT_SCOPE), isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test
   * {@link CachedAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_thenCallsGetId()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAllWithVersions(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<AttributeScope>any(), Mockito.<List<String>>any())).thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult = cachedAttributesService
        .removeAll(ModelConstants.SYSTEM_TENANT, entityId, AttributeScope.CLIENT_SCOPE, attributeKeys);

    // Assert
    verify(entityId).getId();
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).removeAllWithVersions(isA(TenantId.class), isA(EntityId.class),
        eq(AttributeScope.CLIENT_SCOPE), isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test
   * {@link CachedAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   * with {@code TenantId}, {@code EntityId}, {@code AttributeScope},
   * {@code List}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)}
   */
  @Test
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_whenNull_customer_id()
      throws InterruptedException, ExecutionException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAllWithVersions(Mockito.<TenantId>any(), Mockito.<EntityId>any(),
        Mockito.<AttributeScope>any(), Mockito.<List<String>>any())).thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();
    CachedAttributesService cachedAttributesService = new CachedAttributesService(attributesDao, jpaExecutorService,
        statsFactory, cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager()));

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult = cachedAttributesService.removeAll(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, AttributeScope.CLIENT_SCOPE,
        new ArrayList<>());

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).removeAllWithVersions(isA(TenantId.class), isA(EntityId.class),
        eq(AttributeScope.CLIENT_SCOPE), isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   * <p>
   * Method under test:
   * {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllByEntityId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Pair<AttributeScope, String>> pairList = new ArrayList<>();
    pairList.add(new ImmutablePair<>(AttributeScope.CLIENT_SCOPE, "Right"));
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(pairList);
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();

    // Act
    int actualRemoveAllByEntityIdResult = (new CachedAttributesService(attributesDao, jpaExecutorService, statsFactory,
        cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager())))
        .removeAllByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(1, actualRemoveAllByEntityIdResult);
  }

  /**
   * Test {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   * <p>
   * Method under test:
   * {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllByEntityId2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Pair<AttributeScope, String>> pairList = new ArrayList<>();
    pairList.add(new ImmutablePair<>(AttributeScope.CLIENT_SCOPE, null));
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(pairList);
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();

    // Act
    int actualRemoveAllByEntityIdResult = (new CachedAttributesService(attributesDao, jpaExecutorService, statsFactory,
        cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager())))
        .removeAllByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(1, actualRemoveAllByEntityIdResult);
  }

  /**
   * Test {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllByEntityId_givenArrayListAddNullPair_thenReturnOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Pair<AttributeScope, String>> pairList = new ArrayList<>();
    ImmutablePair<AttributeScope, String> nullPairResult = ImmutablePair.nullPair();
    pairList.add(nullPairResult);
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(pairList);
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();

    // Act
    int actualRemoveAllByEntityIdResult = (new CachedAttributesService(attributesDao, jpaExecutorService, statsFactory,
        cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager())))
        .removeAllByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(1, actualRemoveAllByEntityIdResult);
  }

  /**
   * Test {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.</li>
   *   <li>Then return two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllByEntityId_givenArrayListAddNullPair_thenReturnTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayList<Pair<AttributeScope, String>> pairList = new ArrayList<>();
    ImmutablePair<AttributeScope, String> nullPairResult = ImmutablePair.nullPair();
    pairList.add(nullPairResult);
    ImmutablePair<AttributeScope, String> nullPairResult2 = ImmutablePair.nullPair();
    pairList.add(nullPairResult2);
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(pairList);
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();

    // Act
    int actualRemoveAllByEntityIdResult = (new CachedAttributesService(attributesDao, jpaExecutorService, statsFactory,
        cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager())))
        .removeAllByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(2, actualRemoveAllByEntityIdResult);
  }

  /**
   * Test {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  public void testRemoveAllByEntityId_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaAttributeDao attributesDao = mock(JpaAttributeDao.class);
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(new DefaultCounter(aiCounter, new CumulativeCounter(new Meter.Id("Name", Tags.empty(), "Base Unit",
            "The characteristics of someone or something", Meter.Type.COUNTER))));
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();

    // Act
    int actualRemoveAllByEntityIdResult = (new CachedAttributesService(attributesDao, jpaExecutorService, statsFactory,
        cacheExecutorService, new AttributeCaffeineCache(new CaffeineCacheManager())))
        .removeAllByEntityId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(statsFactory, atLeast(1)).createDefaultCounter(eq("attributes.cache"), isA(String[].class));
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(0, actualRemoveAllByEntityIdResult);
  }
}
