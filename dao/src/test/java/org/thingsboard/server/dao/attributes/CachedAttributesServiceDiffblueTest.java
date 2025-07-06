package org.thingsboard.server.dao.attributes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.SettableFuture;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.Meter.Id;
import io.micrometer.core.instrument.Meter.Type;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.cumulative.CumulativeCounter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.common.data.AttributeScope;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.stats.DefaultCounter;
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.cache.CacheExecutorService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.attributes.JpaAttributeDao;

@RunWith(MockitoJUnitRunner.class)
public class CachedAttributesServiceDiffblueTest {
  @Mock private AttributesDao attributesDao;

  @Mock private CacheExecutorService cacheExecutorService;

  @InjectMocks private CachedAttributesService cachedAttributesService;

  @Mock private JpaExecutorService jpaExecutorService;

  @Mock private StatsFactory statsFactory;

  /**
   * Test {@link CachedAttributesService#init()}.
   *
   * <ul>
   *   <li>Given {@link AtomicInteger#AtomicInteger(int)} with one.
   *   <li>Then calls {@link DefaultStatsFactory#createDefaultCounter(String, String[])}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#init()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CachedAttributesService.init()"})
  public void testInit_givenAtomicIntegerWithOne_thenCallsCreateDefaultCounter() {
    // Arrange
    DefaultStatsFactory statsFactory = mock(DefaultStatsFactory.class);
    AtomicInteger aiCounter = new AtomicInteger(1);
    when(statsFactory.createDefaultCounter(Mockito.<String>any(), isA(String[].class)))
        .thenReturn(
            new DefaultCounter(
                aiCounter,
                new CumulativeCounter(
                    new Id(
                        "Name",
                        Tags.empty(),
                        "Base Unit",
                        "The characteristics of someone or something",
                        Type.COUNTER))));
    JpaAttributeDao attributesDao = new JpaAttributeDao();
    JpaExecutorService jpaExecutorService = new JpaExecutorService();
    CacheExecutorService cacheExecutorService = new CacheExecutorService();

    // Act
    new CachedAttributesService(
            attributesDao,
            jpaExecutorService,
            statsFactory,
            cacheExecutorService,
            new AttributeCaffeineCache(new CaffeineCacheManager()))
        .init();

    // Assert
    verify(statsFactory, atLeast(1))
        .createDefaultCounter(eq("attributes.cache"), isA(String[].class));
  }

  /**
   * Test {@link CachedAttributesService#getExecutor(String, CacheExecutorService)}.
   *
   * <ul>
   *   <li>Then calls {@link CacheExecutorService#executor()}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#getExecutor(String, CacheExecutorService)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListeningExecutorService CachedAttributesService.getExecutor(String, CacheExecutorService)"
  })
  public void testGetExecutor_thenCallsExecutor() {
    // Arrange
    when(cacheExecutorService.executor()).thenReturn(mock(ListeningExecutorService.class));

    // Act
    cachedAttributesService.getExecutor("Cache Type", cacheExecutorService);

    // Assert
    verify(cacheExecutorService).executor();
  }

  /**
   * Test {@link CachedAttributesService#findAll(TenantId, EntityId, AttributeScope)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#findAll(TenantId, EntityId,
   * AttributeScope)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture CachedAttributesService.findAll(TenantId, EntityId, AttributeScope)"
  })
  public void testFindAll_whenNull_customer_id_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<AttributeKvEntry>> actualFindAllResult =
        cachedAttributesService.findAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAllResult instanceof SettableFuture);
    assertSame(createResult, actualFindAllResult);
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#findAllKeysByDeviceProfileId(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List CachedAttributesService.findAllKeysByDeviceProfileId(TenantId, DeviceProfileId)"
  })
  public void testFindAllKeysByDeviceProfileId_thenReturnEmpty() {
    // Arrange
    when(attributesDao.findAllKeysByDeviceProfileId(
            Mockito.<TenantId>any(), Mockito.<DeviceProfileId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByDeviceProfileIdResult =
        cachedAttributesService.findAllKeysByDeviceProfileId(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(attributesDao).findAllKeysByDeviceProfileId(isA(TenantId.class), isNull());
    assertTrue(actualFindAllKeysByDeviceProfileIdResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <p>Method under test: {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CachedAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        cachedAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>(), "Scope");

    // Assert
    verify(attributesDao)
        .findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CachedAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_givenNull_customer_id() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        cachedAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, entityIds, "Scope");

    // Assert
    verify(attributesDao)
        .findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CachedAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_givenNull_customer_id2() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIdsAndAttributeType(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        cachedAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, entityIds, "Scope");

    // Assert
    verify(attributesDao)
        .findAllKeysByEntityIdsAndAttributeType(isA(TenantId.class), isA(List.class), eq("Scope"));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CachedAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_whenEmptyString() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        cachedAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>(), "");

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List, String)} with {@code
   * tenantId}, {@code entityIds}, {@code scope}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CachedAttributesService.findAllKeysByEntityIds(TenantId, List, String)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIdsScope_whenNull() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        cachedAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>(), null);

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)} with {@code
   * tenantId}, {@code entityIds}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CachedAttributesService.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_givenNull_customer_id() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        cachedAttributesService.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)} with {@code
   * tenantId}, {@code entityIds}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CachedAttributesService.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_givenNull_customer_id2() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<EntityId> entityIds = new ArrayList<>();
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);
    entityIds.add(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        cachedAttributesService.findAllKeysByEntityIds(ModelConstants.SYSTEM_TENANT, entityIds);

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)} with {@code
   * tenantId}, {@code entityIds}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#findAllKeysByEntityIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List CachedAttributesService.findAllKeysByEntityIds(TenantId, List)"})
  public void testFindAllKeysByEntityIdsWithTenantIdEntityIds_whenArrayList() {
    // Arrange
    when(attributesDao.findAllKeysByEntityIds(
            Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<String> actualFindAllKeysByEntityIdsResult =
        cachedAttributesService.findAllKeysByEntityIds(
            ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(attributesDao).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindAllKeysByEntityIdsResult.isEmpty());
  }

  /**
   * Test {@link CachedAttributesService#save(TenantId, EntityId, AttributeScope, List)} with {@code
   * TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#save(TenantId, EntityId, AttributeScope,
   * List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture CachedAttributesService.save(TenantId, EntityId, AttributeScope, List)"
  })
  public void testSaveWithTenantIdEntityIdAttributeScopeList_whenArrayList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange and Act
    ListenableFuture<List<Long>> actualSaveResult =
        cachedAttributesService.save(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            new ArrayList<>());

    // Assert
    assertTrue(actualSaveResult.get().isEmpty());
    assertTrue(actualSaveResult.isDone());
  }

  /**
   * Test {@link CachedAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)} with
   * {@code TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#removeAll(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture CachedAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_given42_whenArrayListAdd42()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(attributesDao.removeAllWithVersions(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("42");
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult =
        cachedAttributesService.removeAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            attributeKeys);

    // Assert
    verify(attributesDao)
        .removeAllWithVersions(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test {@link CachedAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)} with
   * {@code TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#removeAll(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture CachedAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_givenFoo_whenArrayListAddFoo()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(attributesDao.removeAllWithVersions(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<String> attributeKeys = new ArrayList<>();
    attributeKeys.add("foo");

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult =
        cachedAttributesService.removeAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            attributeKeys);

    // Assert
    verify(attributesDao)
        .removeAllWithVersions(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test {@link CachedAttributesService#removeAll(TenantId, EntityId, AttributeScope, List)} with
   * {@code TenantId}, {@code EntityId}, {@code AttributeScope}, {@code List}.
   *
   * <ul>
   *   <li>Then return {@link ListenableFuture#get()} Empty.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#removeAll(TenantId, EntityId,
   * AttributeScope, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture CachedAttributesService.removeAll(TenantId, EntityId, AttributeScope, List)"
  })
  public void testRemoveAllWithTenantIdEntityIdAttributeScopeList_thenReturnGetEmpty()
      throws InterruptedException, ExecutionException {
    // Arrange
    when(attributesDao.removeAllWithVersions(
            Mockito.<TenantId>any(),
            Mockito.<EntityId>any(),
            Mockito.<AttributeScope>any(),
            Mockito.<List<String>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    ListenableFuture<List<String>> actualRemoveAllResult =
        cachedAttributesService.removeAll(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            AttributeScope.CLIENT_SCOPE,
            new ArrayList<>());

    // Assert
    verify(attributesDao)
        .removeAllWithVersions(
            isA(TenantId.class),
            isA(EntityId.class),
            eq(AttributeScope.CLIENT_SCOPE),
            isA(List.class));
    assertTrue(actualRemoveAllResult.get().isEmpty());
    assertTrue(actualRemoveAllResult.isDone());
  }

  /**
   * Test {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CachedAttributesService.removeAllByEntityId(TenantId, EntityId)"})
  public void testRemoveAllByEntityId_givenArrayListAddNullPair_thenReturnOne() {
    // Arrange
    ArrayList<Pair<AttributeScope, String>> pairList = new ArrayList<>();
    ImmutablePair<AttributeScope, String> nullPairResult = ImmutablePair.nullPair();
    pairList.add(nullPairResult);
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(pairList);

    // Act
    int actualRemoveAllByEntityIdResult =
        cachedAttributesService.removeAllByEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(1, actualRemoveAllByEntityIdResult);
  }

  /**
   * Test {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add nullPair.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CachedAttributesService.removeAllByEntityId(TenantId, EntityId)"})
  public void testRemoveAllByEntityId_givenArrayListAddNullPair_thenReturnTwo() {
    // Arrange
    ArrayList<Pair<AttributeScope, String>> pairList = new ArrayList<>();
    ImmutablePair<AttributeScope, String> nullPairResult = ImmutablePair.nullPair();
    pairList.add(nullPairResult);
    ImmutablePair<AttributeScope, String> nullPairResult2 = ImmutablePair.nullPair();
    pairList.add(nullPairResult2);
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(pairList);

    // Act
    int actualRemoveAllByEntityIdResult =
        cachedAttributesService.removeAllByEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(2, actualRemoveAllByEntityIdResult);
  }

  /**
   * Test {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link CachedAttributesService#removeAllByEntityId(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int CachedAttributesService.removeAllByEntityId(TenantId, EntityId)"})
  public void testRemoveAllByEntityId_thenReturnZero() {
    // Arrange
    when(attributesDao.removeAllByEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    int actualRemoveAllByEntityIdResult =
        cachedAttributesService.removeAllByEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(attributesDao).removeAllByEntityId(isA(TenantId.class), isA(EntityId.class));
    assertEquals(0, actualRemoveAllByEntityIdResult);
  }
}
