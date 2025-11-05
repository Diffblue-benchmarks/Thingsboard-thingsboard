package org.thingsboard.server.dao.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.asset.AssetInfo;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.asset.AssetSearchQuery;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityCountService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {BaseAssetService.class})
@DisabledInAotMode
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@PropertySource("classpath:application-test.properties")
class BaseAssetServiceDiffblueTest {
  @MockBean private AssetDao assetDao;

  @MockBean private AssetProfileService assetProfileService;

  @Autowired private BaseAssetService baseAssetService;

  @MockBean private CleanUpService cleanUpService;

  @MockBean private DataValidator<Asset> dataValidator;

  @MockBean private EdgeService edgeService;

  @MockBean private EntityCountService entityCountService;

  @MockBean private EntityViewService entityViewService;

  @MockBean private JpaExecutorService jpaExecutorService;

  @MockBean private RelationService relationService;

  @MockBean private TbTransactionalCache<AssetCacheKey, Asset> tbTransactionalCache;

  /**
   * Test {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)} with {@code
   * AssetCacheEvictEvent}.
   *
   * <p>Method under test: {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)}
   */
  @Test
  @DisplayName("Test handleEvictEvent(AssetCacheEvictEvent) with 'AssetCacheEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.handleEvictEvent(AssetCacheEvictEvent)"})
  void testHandleEvictEventWithAssetCacheEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    AssetCacheEvictEvent event =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name");

    // Act
    baseAssetService.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)} with {@code
   * AssetCacheEvictEvent}.
   *
   * <p>Method under test: {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)}
   */
  @Test
  @DisplayName("Test handleEvictEvent(AssetCacheEvictEvent) with 'AssetCacheEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.handleEvictEvent(AssetCacheEvictEvent)"})
  void testHandleEvictEventWithAssetCacheEvictEvent2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    AssetCacheEvictEvent event =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Old Name", "Old Name");

    // Act
    baseAssetService.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)} with {@code
   * AssetCacheEvictEvent}.
   *
   * <p>Method under test: {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)}
   */
  @Test
  @DisplayName("Test handleEvictEvent(AssetCacheEvictEvent) with 'AssetCacheEvictEvent'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.handleEvictEvent(AssetCacheEvictEvent)"})
  void testHandleEvictEventWithAssetCacheEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    AssetCacheEvictEvent event =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "");

    // Act
    baseAssetService.handleEvictEvent(event);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)} with {@code
   * AssetCacheEvictEvent}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvictEvent(AssetCacheEvictEvent) with 'AssetCacheEvictEvent'; then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.handleEvictEvent(AssetCacheEvictEvent)"})
  void testHandleEvictEventWithAssetCacheEvictEvent_thenThrowDataValidationException() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());
    AssetCacheEvictEvent event =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.handleEvictEvent(event));
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetInfoById(TenantId, AssetId)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfoById(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test findAssetInfoById(TenantId, AssetId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo BaseAssetService.findAssetInfoById(TenantId, AssetId)"})
  void testFindAssetInfoById() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();
    when(assetDao.findAssetInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetInfo);

    // Act
    AssetInfo actualFindAssetInfoByIdResult =
        baseAssetService.findAssetInfoById(
            ModelConstants.SYSTEM_TENANT,
            new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(assetDao).findAssetInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(assetInfo, actualFindAssetInfoByIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfoById(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfoById(TenantId, AssetId)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfoById(TenantId, AssetId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo BaseAssetService.findAssetInfoById(TenantId, AssetId)"})
  void testFindAssetInfoById_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();
    when(assetDao.findAssetInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetInfo);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AssetInfo actualFindAssetInfoByIdResult = baseAssetService.findAssetInfoById(tenantId, assetId);

    // Assert
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findAssetInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(assetInfo, actualFindAssetInfoByIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfoById(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfoById(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test findAssetInfoById(TenantId, AssetId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetInfo BaseAssetService.findAssetInfoById(TenantId, AssetId)"})
  void testFindAssetInfoById_thenThrowDataValidationException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseAssetService.findAssetInfoById(tenantId, assetId));
    verify(assetId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetById(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetById(TenantId, AssetId)}
   */
  @Test
  @DisplayName(
      "Test findAssetById(TenantId, AssetId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.findAssetById(TenantId, AssetId)"})
  void testFindAssetById_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Asset actualFindAssetByIdResult = baseAssetService.findAssetById(tenantId, assetId);

    // Assert
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(asset, actualFindAssetByIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetById(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetById(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test findAssetById(TenantId, AssetId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.findAssetById(TenantId, AssetId)"})
  void testFindAssetById_thenThrowDataValidationException() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseAssetService.findAssetById(tenantId, assetId));
    verify(assetId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetById(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>When {@link AssetId#AssetId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetById(TenantId, AssetId)}
   */
  @Test
  @DisplayName(
      "Test findAssetById(TenantId, AssetId); when AssetId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.findAssetById(TenantId, AssetId)"})
  void testFindAssetById_whenAssetIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act
    Asset actualFindAssetByIdResult =
        baseAssetService.findAssetById(
            ModelConstants.SYSTEM_TENANT,
            new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(asset, actualFindAssetByIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetByIdAsync(TenantId, AssetId)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetByIdAsync(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test findAssetByIdAsync(TenantId, AssetId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseAssetService.findAssetByIdAsync(TenantId, AssetId)"})
  void testFindAssetByIdAsync() {
    // Arrange
    SettableFuture<Asset> createResult = SettableFuture.create();
    when(assetDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Asset> actualFindAssetByIdAsyncResult =
        baseAssetService.findAssetByIdAsync(
            ModelConstants.SYSTEM_TENANT,
            new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(assetDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAssetByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetByIdAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetByIdAsync(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetByIdAsync(TenantId, AssetId)}
   */
  @Test
  @DisplayName(
      "Test findAssetByIdAsync(TenantId, AssetId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseAssetService.findAssetByIdAsync(TenantId, AssetId)"})
  void testFindAssetByIdAsync_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    SettableFuture<Asset> createResult = SettableFuture.create();
    when(assetDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Asset> actualFindAssetByIdAsyncResult =
        baseAssetService.findAssetByIdAsync(ModelConstants.SYSTEM_TENANT, assetId);

    // Assert
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAssetByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetByIdAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetByIdAsync(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetByIdAsync(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test findAssetByIdAsync(TenantId, AssetId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseAssetService.findAssetByIdAsync(TenantId, AssetId)"})
  void testFindAssetByIdAsync_thenThrowDataValidationException() {
    // Arrange
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetByIdAsync(ModelConstants.SYSTEM_TENANT, assetId));
    verify(assetId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}
   */
  @Test
  @DisplayName("Test findAssetByTenantIdAndName(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.findAssetByTenantIdAndName(TenantId, String)"})
  void testFindAssetByTenantIdAndName() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<AssetCacheKey>any(), Mockito.<Supplier<Asset>>any(), anyBoolean()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetByTenantIdAndName(ModelConstants.SYSTEM_TENANT, "Name"));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(AssetCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}
   */
  @Test
  @DisplayName("Test findAssetByTenantIdAndName(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.findAssetByTenantIdAndName(TenantId, String)"})
  void testFindAssetByTenantIdAndName2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetByTenantIdAndName(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test findAssetByTenantIdAndName(TenantId, String); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.findAssetByTenantIdAndName(TenantId, String)"})
  void testFindAssetByTenantIdAndName_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    Asset asset = new Asset();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<AssetCacheKey>any(), Mockito.<Supplier<Asset>>any(), anyBoolean()))
        .thenReturn(asset);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Asset actualFindAssetByTenantIdAndNameResult =
        baseAssetService.findAssetByTenantIdAndName(tenantId, "Name");

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(AssetCacheKey.class), isA(Supplier.class), eq(true));
    verify(tenantId).getId();
    assertSame(asset, actualFindAssetByTenantIdAndNameResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link Asset#Asset()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test findAssetByTenantIdAndName(TenantId, String); when SYSTEM_TENANT; then return Asset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.findAssetByTenantIdAndName(TenantId, String)"})
  void testFindAssetByTenantIdAndName_whenSystem_tenant_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<AssetCacheKey>any(), Mockito.<Supplier<Asset>>any(), anyBoolean()))
        .thenReturn(asset);

    // Act
    Asset actualFindAssetByTenantIdAndNameResult =
        baseAssetService.findAssetByTenantIdAndName(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(AssetCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(asset, actualFindAssetByTenantIdAndNameResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetByTenantIdAndNameAsync(TenantId,
   * String)}
   */
  @Test
  @DisplayName("Test findAssetByTenantIdAndNameAsync(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindAssetByTenantIdAndNameAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Asset> actualFindAssetByTenantIdAndNameAsyncResult =
        baseAssetService.findAssetByTenantIdAndNameAsync(tenantId, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(tenantId).getId();
    assertTrue(actualFindAssetByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetByTenantIdAndNameAsync(TenantId,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findAssetByTenantIdAndNameAsync(TenantId, String); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindAssetByTenantIdAndNameAsync_thenThrowDataValidationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetByTenantIdAndNameAsync(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetByTenantIdAndNameAsync(TenantId,
   * String)}
   */
  @Test
  @DisplayName(
      "Test findAssetByTenantIdAndNameAsync(TenantId, String); when SYSTEM_TENANT; then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindAssetByTenantIdAndNameAsync_whenSystem_tenant_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Asset> actualFindAssetByTenantIdAndNameAsyncResult =
        baseAssetService.findAssetByTenantIdAndNameAsync(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset)} with {@code asset}.
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset)}
   */
  @Test
  @DisplayName("Test saveAsset(Asset) with 'asset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset)"})
  void testSaveAssetWithAsset() {
    // Arrange
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(new Asset()));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset)} with {@code asset}.
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset)}
   */
  @Test
  @DisplayName("Test saveAsset(Asset) with 'asset'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset)"})
  void testSaveAssetWithAsset2() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(asset);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(new Asset()));
    verify(asset).getName();
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset}, {@code doValidate}.
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  @DisplayName("Test saveAsset(Asset, boolean) with 'asset', 'doValidate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset, boolean)"})
  void testSaveAssetWithAssetDoValidate() {
    // Arrange
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseAssetService.saveAsset(new Asset(), true));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset}, {@code doValidate}.
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  @DisplayName("Test saveAsset(Asset, boolean) with 'asset', 'doValidate'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset, boolean)"})
  void testSaveAssetWithAssetDoValidate2() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(asset);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseAssetService.saveAsset(new Asset(), true));
    verify(asset).getName();
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset}, {@code doValidate}.
   *
   * <ul>
   *   <li>Given {@link Asset} {@link Asset#getName()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  @DisplayName(
      "Test saveAsset(Asset, boolean) with 'asset', 'doValidate'; given Asset getName() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset, boolean)"})
  void testSaveAssetWithAssetDoValidate_givenAssetGetNameReturnEmptyString() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(asset);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    Asset asset2 = new Asset();
    asset2.setType("Executing saveAsset [{}]");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(asset2, true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset).getName();
    verify(assetProfileService).findOrCreateAssetProfile(isNull(), eq("Executing saveAsset [{}]"));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset}, {@code doValidate}.
   *
   * <ul>
   *   <li>Given {@link BaseAssetService} (default constructor).
   *   <li>Then calls {@link AssetId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  @DisplayName(
      "Test saveAsset(Asset, boolean) with 'asset', 'doValidate'; given BaseAssetService (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset, boolean)"})
  void testSaveAssetWithAssetDoValidate_givenBaseAssetService_thenCallsGetId() {
    // Arrange
    BaseAssetService baseAssetService = new BaseAssetService();

    AssetId id = mock(AssetId.class);
    when(id.getId()).thenThrow(new DataValidationException("An error occurred"));

    Asset asset = new Asset(id);
    asset.setAssetProfileId(null);
    asset.setType("");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(asset, false));
    verify(id).getId();
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset}, {@code doValidate}.
   *
   * <ul>
   *   <li>Given {@link DataValidator}.
   *   <li>When {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  @DisplayName(
      "Test saveAsset(Asset, boolean) with 'asset', 'doValidate'; given DataValidator; when 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset, boolean)"})
  void testSaveAssetWithAssetDoValidate_givenDataValidator_whenFalse() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    Asset asset = new Asset();
    asset.setType("Executing saveAsset [{}]");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(asset, false));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetProfileService).findOrCreateAssetProfile(isNull(), eq("Executing saveAsset [{}]"));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset}, {@code doValidate}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfileService#findDefaultAssetProfile(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  @DisplayName(
      "Test saveAsset(Asset, boolean) with 'asset', 'doValidate'; then calls findDefaultAssetProfile(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset, boolean)"})
  void testSaveAssetWithAssetDoValidate_thenCallsFindDefaultAssetProfile() {
    // Arrange
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any()))
        .thenReturn(new AssetProfile());
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(new Asset());
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseAssetService.saveAsset(new Asset(), true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetProfileService).findDefaultAssetProfile(isNull());
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset}, {@code doValidate}.
   *
   * <ul>
   *   <li>Then calls {@link Asset#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  @DisplayName("Test saveAsset(Asset, boolean) with 'asset', 'doValidate'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset, boolean)"})
  void testSaveAssetWithAssetDoValidate_thenCallsGetName() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(asset);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    Asset asset2 = new Asset();
    asset2.setType("Executing saveAsset [{}]");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(asset2, true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset).getName();
    verify(assetProfileService).findOrCreateAssetProfile(isNull(), eq("Executing saveAsset [{}]"));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset}, {@code doValidate}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  @DisplayName(
      "Test saveAsset(Asset, boolean) with 'asset', 'doValidate'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset, boolean)"})
  void testSaveAssetWithAssetDoValidate_thenThrowRuntimeException() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(asset);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    Asset asset2 = new Asset();
    asset2.setName("Name");
    asset2.setType("Executing saveAsset [{}]");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseAssetService.saveAsset(asset2, true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset).getName();
    verify(assetProfileService).findOrCreateAssetProfile(isNull(), eq("Executing saveAsset [{}]"));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset)} with {@code asset}.
   *
   * <ul>
   *   <li>Given {@link Asset} {@link Asset#getName()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset)}
   */
  @Test
  @DisplayName("Test saveAsset(Asset) with 'asset'; given Asset getName() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset)"})
  void testSaveAssetWithAsset_givenAssetGetNameReturnEmptyString() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(asset);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    Asset asset2 = new Asset();
    asset2.setType("Executing saveAsset [{}]");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(asset2));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset).getName();
    verify(assetProfileService).findOrCreateAssetProfile(isNull(), eq("Executing saveAsset [{}]"));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset)} with {@code asset}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfileService#findDefaultAssetProfile(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset)}
   */
  @Test
  @DisplayName("Test saveAsset(Asset) with 'asset'; then calls findDefaultAssetProfile(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset)"})
  void testSaveAssetWithAsset_thenCallsFindDefaultAssetProfile() {
    // Arrange
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any()))
        .thenReturn(new AssetProfile());
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(new Asset());
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(new Asset()));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetProfileService).findDefaultAssetProfile(isNull());
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset)} with {@code asset}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfileService#findOrCreateAssetProfile(TenantId, String)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset)}
   */
  @Test
  @DisplayName(
      "Test saveAsset(Asset) with 'asset'; then calls findOrCreateAssetProfile(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset)"})
  void testSaveAssetWithAsset_thenCallsFindOrCreateAssetProfile() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(asset);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    Asset asset2 = new Asset();
    asset2.setType("Executing saveAsset [{}]");

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(asset2));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset).getName();
    verify(assetProfileService).findOrCreateAssetProfile(isNull(), eq("Executing saveAsset [{}]"));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset)} with {@code asset}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#saveAsset(Asset)}
   */
  @Test
  @DisplayName("Test saveAsset(Asset) with 'asset'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.saveAsset(Asset)"})
  void testSaveAssetWithAsset_thenThrowRuntimeException() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException());

    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(asset);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    Asset asset2 = new Asset();
    asset2.setName("Name");
    asset2.setType("Executing saveAsset [{}]");

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseAssetService.saveAsset(asset2));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset).getName();
    verify(assetProfileService).findOrCreateAssetProfile(isNull(), eq("Executing saveAsset [{}]"));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}.
   *
   * <p>Method under test: {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId,
   * CustomerId)}
   */
  @Test
  @DisplayName("Test assignAssetToCustomer(TenantId, AssetId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.assignAssetToCustomer(TenantId, AssetId, CustomerId)"})
  void testAssignAssetToCustomer() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.assignAssetToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}.
   *
   * <p>Method under test: {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId,
   * CustomerId)}
   */
  @Test
  @DisplayName("Test assignAssetToCustomer(TenantId, AssetId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.assignAssetToCustomer(TenantId, AssetId, CustomerId)"})
  void testAssignAssetToCustomer2() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.assignAssetToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link Asset#Asset()} CustomerId is {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@link Asset#Asset()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId,
   * CustomerId)}
   */
  @Test
  @DisplayName(
      "Test assignAssetToCustomer(TenantId, AssetId, CustomerId); given Asset() CustomerId is NULL_CUSTOMER_ID; then return Asset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.assignAssetToCustomer(TenantId, AssetId, CustomerId)"})
  void testAssignAssetToCustomer_givenAssetCustomerIdIsNull_customer_id_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    asset.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act
    Asset actualAssignAssetToCustomerResult =
        baseAssetService.assignAssetToCustomer(
            ModelConstants.SYSTEM_TENANT,
            new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(asset, actualAssignAssetToCustomerResult);
  }

  /**
   * Test {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId,
   * CustomerId)}
   */
  @Test
  @DisplayName(
      "Test assignAssetToCustomer(TenantId, AssetId, CustomerId); then calls evict(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.assignAssetToCustomer(TenantId, AssetId, CustomerId)"})
  void testAssignAssetToCustomer_thenCallsEvict() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any()))
        .thenReturn(new AssetProfile());
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(new Asset());
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.assignAssetToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService).findDefaultAssetProfile(isNull());
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromCustomer(TenantId, AssetId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromCustomer(TenantId, AssetId)"})
  void testUnassignAssetFromCustomer() {
    // Arrange
    Asset asset = mock(Asset.class);
    doThrow(new DataValidationException("An error occurred"))
        .when(asset)
        .setCustomerId(Mockito.<CustomerId>any());
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.unassignAssetFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(asset).getCustomerId();
    verify(asset).setCustomerId(isNull());
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromCustomer(TenantId, AssetId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromCustomer(TenantId, AssetId)"})
  void testUnassignAssetFromCustomer2() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(asset.getAssetProfileId())
        .thenReturn(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    when(assetProfileService.findAssetProfileById(
            Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.unassignAssetFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(asset).setCustomerId(isNull());
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService)
        .findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromCustomer(TenantId, AssetId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromCustomer(TenantId, AssetId)"})
  void testUnassignAssetFromCustomer3() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(asset.getAssetProfileId())
        .thenReturn(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    when(assetProfileService.findAssetProfileById(
            Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(null);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.unassignAssetFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(asset).setCustomerId(isNull());
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService)
        .findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromCustomer(TenantId, AssetId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromCustomer(TenantId, AssetId)"})
  void testUnassignAssetFromCustomer4() {
    // Arrange
    Asset asset = mock(Asset.class);
    doThrow(new DataValidationException("An error occurred"))
        .when(asset)
        .setType(Mockito.<String>any());
    when(asset.getName()).thenReturn("Name");
    when(asset.getAssetProfileId())
        .thenReturn(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(assetProfileService.findAssetProfileById(
            Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(assetProfile);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.unassignAssetFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(asset).setCustomerId(isNull());
    verify(asset).setType(null);
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService)
        .findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromCustomer(TenantId, AssetId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromCustomer(TenantId, AssetId)"})
  void testUnassignAssetFromCustomer5() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(asset.getAssetProfileId())
        .thenReturn(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(assetProfileService.findAssetProfileById(
            Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(assetProfile);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.unassignAssetFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(asset).setCustomerId(isNull());
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService)
        .findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromCustomer(TenantId, AssetId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromCustomer(TenantId, AssetId)"})
  void testUnassignAssetFromCustomer6() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getId())
        .thenReturn(new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(asset).setType(Mockito.<String>any());
    when(asset.getName()).thenReturn("Name");
    when(asset.getAssetProfileId())
        .thenReturn(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    Asset asset2 = new Asset();
    when(assetDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Asset>any())).thenReturn(asset2);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(assetProfileService.findAssetProfileById(
            Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(assetProfile);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act
    Asset actualUnassignAssetFromCustomerResult =
        baseAssetService.unassignAssetFromCustomer(
            ModelConstants.SYSTEM_TENANT,
            new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset).getCustomerId();
    verify(asset, atLeast(1)).getId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(asset).setCustomerId(isNull());
    verify(asset).setType(null);
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).saveAndFlush(isA(TenantId.class), isA(Asset.class));
    verify(assetProfileService)
        .findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
    assertSame(asset2, actualUnassignAssetFromCustomerResult);
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>Given {@link AssetDao} {@link AssetDao#findById(TenantId, UUID)} return {@link
   *       Asset#Asset()}.
   *   <li>Then return {@link Asset#Asset()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  @DisplayName(
      "Test unassignAssetFromCustomer(TenantId, AssetId); given AssetDao findById(TenantId, UUID) return Asset(); then return Asset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromCustomer(TenantId, AssetId)"})
  void testUnassignAssetFromCustomer_givenAssetDaoFindByIdReturnAsset_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act
    Asset actualUnassignAssetFromCustomerResult =
        baseAssetService.unassignAssetFromCustomer(
            ModelConstants.SYSTEM_TENANT,
            new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(asset, actualUnassignAssetFromCustomerResult);
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfile#AssetProfile()} TenantId is {@link TenantId}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  @DisplayName(
      "Test unassignAssetFromCustomer(TenantId, AssetId); given AssetProfile() TenantId is TenantId")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromCustomer(TenantId, AssetId)"})
  void testUnassignAssetFromCustomer_givenAssetProfileTenantIdIsTenantId() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(asset.getAssetProfileId())
        .thenReturn(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setTenantId(mock(TenantId.class));
    when(assetProfileService.findAssetProfileById(
            Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(assetProfile);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.unassignAssetFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(asset).setCustomerId(isNull());
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService)
        .findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>Then calls {@link Asset#getType()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromCustomer(TenantId, AssetId); then calls getType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromCustomer(TenantId, AssetId)"})
  void testUnassignAssetFromCustomer_thenCallsGetType() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(asset.getType()).thenReturn("Type");
    when(asset.getAssetProfileId()).thenReturn(null);
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    when(assetProfileService.findOrCreateAssetProfile(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.unassignAssetFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset).getAssetProfileId();
    verify(asset).getCustomerId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(asset, atLeast(1)).getType();
    verify(asset).setCustomerId(isNull());
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService).findOrCreateAssetProfile(isA(TenantId.class), eq("Type"));
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityCountService#publishCountEntityEvictEvent(TenantId, EntityType)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  @DisplayName(
      "Test unassignAssetFromCustomer(TenantId, AssetId); then calls publishCountEntityEvictEvent(TenantId, EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromCustomer(TenantId, AssetId)"})
  void testUnassignAssetFromCustomer_thenCallsPublishCountEntityEvictEvent() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getId()).thenReturn(null);
    doNothing().when(asset).setType(Mockito.<String>any());
    when(asset.getName()).thenReturn("Name");
    when(asset.getAssetProfileId())
        .thenReturn(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(asset.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(asset).setCustomerId(Mockito.<CustomerId>any());
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    Asset asset2 = new Asset();
    when(assetDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<Asset>any())).thenReturn(asset2);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(assetProfileService.findAssetProfileById(
            Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(assetProfile);
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act
    Asset actualUnassignAssetFromCustomerResult =
        baseAssetService.unassignAssetFromCustomer(
            ModelConstants.SYSTEM_TENANT,
            new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset, atLeast(1)).getAssetProfileId();
    verify(asset).getCustomerId();
    verify(asset, atLeast(1)).getId();
    verify(asset).getName();
    verify(asset, atLeast(1)).getTenantId();
    verify(asset).setCustomerId(isNull());
    verify(asset).setType(null);
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).saveAndFlush(isA(TenantId.class), isA(Asset.class));
    verify(assetProfileService)
        .findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.ASSET));
    assertSame(asset2, actualUnassignAssetFromCustomerResult);
  }

  /**
   * Test {@link BaseAssetService#deleteAsset(TenantId, AssetId)} with {@code tenantId}, {@code
   * assetId}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteAsset(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test deleteAsset(TenantId, AssetId) with 'tenantId', 'assetId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteAsset(TenantId, AssetId)"})
  void testDeleteAssetWithTenantIdAssetId() {
    // Arrange
    when(entityViewService.existsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.deleteAsset(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAsset(TenantId, AssetId)} with {@code tenantId}, {@code
   * assetId}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteAsset(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test deleteAsset(TenantId, AssetId) with 'tenantId', 'assetId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteAsset(TenantId, AssetId)"})
  void testDeleteAssetWithTenantIdAssetId2() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doThrow(new DataValidationException("An error occurred"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    when(entityViewService.existsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(false);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.deleteAsset(
                ModelConstants.SYSTEM_TENANT,
                new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAsset(TenantId, AssetId)} with {@code tenantId}, {@code
   * assetId}.
   *
   * <ul>
   *   <li>Given {@link BaseAssetService} (default constructor).
   *   <li>Then calls {@link AssetId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteAsset(TenantId, AssetId)}
   */
  @Test
  @DisplayName(
      "Test deleteAsset(TenantId, AssetId) with 'tenantId', 'assetId'; given BaseAssetService (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteAsset(TenantId, AssetId)"})
  void testDeleteAssetWithTenantIdAssetId_givenBaseAssetService_thenCallsGetId() {
    // Arrange
    BaseAssetService baseAssetService = new BaseAssetService();

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.deleteAsset(ModelConstants.SYSTEM_TENANT, assetId));
    verify(assetId).getId();
  }

  /**
   * Test {@link BaseAssetService#deleteAsset(TenantId, AssetId)} with {@code tenantId}, {@code
   * assetId}.
   *
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteAsset(TenantId, AssetId)}
   */
  @Test
  @DisplayName(
      "Test deleteAsset(TenantId, AssetId) with 'tenantId', 'assetId'; then calls evict(Collection)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteAsset(TenantId, AssetId)"})
  void testDeleteAssetWithTenantIdAssetId_thenCallsEvict() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    when(entityViewService.existsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(false);

    // Act
    baseAssetService.deleteAsset(
        ModelConstants.SYSTEM_TENANT,
        new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetsByTenantId(TenantId, PageLink)"})
  void testFindAssetsByTenantId() {
    // Arrange
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetsByTenantId(TenantId, PageLink)"})
  void testFindAssetsByTenantId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetsByTenantId(TenantId, PageLink)"})
  void testFindAssetsByTenantId3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetsByTenantId(TenantId, PageLink)"})
  void testFindAssetsByTenantId4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetsByTenantId(TenantId, PageLink)"})
  void testFindAssetsByTenantId5() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantId(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetsByTenantId(TenantId, PageLink)"})
  void testFindAssetsByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult =
        baseAssetService.findAssetsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantId(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetsByTenantId(TenantId, PageLink)"})
  void testFindAssetsByTenantId_thenCallsGetId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult =
        baseAssetService.findAssetsByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantId(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetsByTenantId(TenantId, PageLink)"})
  void testFindAssetsByTenantId_thenCallsGetProperty() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult =
        baseAssetService.findAssetsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantId(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetsByTenantId(TenantId, PageLink)"})
  void testFindAssetsByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult =
        baseAssetService.findAssetsByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetInfosByTenantId(TenantId, PageLink)"})
  void testFindAssetInfosByTenantId() {
    // Arrange
    when(assetDao.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao).findAssetInfosByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetInfosByTenantId(TenantId, PageLink)"})
  void testFindAssetInfosByTenantId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetInfosByTenantId(TenantId, PageLink)"})
  void testFindAssetInfosByTenantId3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetInfosByTenantId(TenantId, PageLink)"})
  void testFindAssetInfosByTenantId4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetInfosByTenantId(TenantId, PageLink)"})
  void testFindAssetInfosByTenantId5() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetInfosByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantId(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetInfosByTenantId(TenantId, PageLink)"})
  void testFindAssetInfosByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        baseAssetService.findAssetInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantId(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetInfosByTenantId(TenantId, PageLink)"})
  void testFindAssetInfosByTenantId_thenCallsGetId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        baseAssetService.findAssetInfosByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao).findAssetInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantId(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetInfosByTenantId(TenantId, PageLink)"})
  void testFindAssetInfosByTenantId_thenCallsGetProperty() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        baseAssetService.findAssetInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao).findAssetInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantId(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseAssetService.findAssetInfosByTenantId(TenantId, PageLink)"})
  void testFindAssetInfosByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult =
        baseAssetService.findAssetInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndType() {
    // Arrange
    when(assetDao.findAssetsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao).findAssetsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndType3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndType4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantIdAndType(tenantId, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndType(TenantId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndType(TenantId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndType_thenCallsGetId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao).findAssetsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndType(TenantId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao).findAssetsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndType(TenantId, String, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndType() {
    // Arrange
    when(assetDao.findAssetInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao)
        .findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndType3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndType4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndType(
                tenantId, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndType(TenantId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        baseAssetService.findAssetInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao)
        .findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndType(TenantId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndType_thenCallsGetId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        baseAssetService.findAssetInfosByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndType(TenantId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        baseAssetService.findAssetInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndType(TenantId, String, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult =
        baseAssetService.findAssetInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao)
        .findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId,
   * AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndAssetProfileId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.SYSTEM_TENANT,
            new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId,
   * AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndAssetProfileId2() {
    // Arrange
    when(assetDao.findAssetInfosByTenantIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndAssetProfileId(
                ModelConstants.SYSTEM_TENANT,
                new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId,
   * AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndAssetProfileId3() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndAssetProfileId(
                ModelConstants.SYSTEM_TENANT, assetProfileId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId,
   * AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndAssetProfileId4() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndAssetProfileId(
                ModelConstants.SYSTEM_TENANT, assetProfileId, pageLink));
    verify(assetProfileId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId,
   * AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndAssetProfileId5() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.SYSTEM_TENANT, assetProfileId, pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId,
   * AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndAssetProfileId6() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndAssetProfileId(
                ModelConstants.SYSTEM_TENANT, assetProfileId, pageLink));
    verify(assetProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId,
   * AssetProfileId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndAssetProfileId_givenBy_created_time_desc() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.SYSTEM_TENANT, assetProfileId, pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId,
   * AssetProfileId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndAssetProfileId_thenCallsGetId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndAssetProfileId(
            tenantId, assetProfileId, pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId,
   * AssetProfileId, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndAssetProfileId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndAssetProfileId(
            ModelConstants.SYSTEM_TENANT, assetProfileId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(assetDao)
        .findAssetInfosByTenantIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetsByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindAssetsByTenantIdAndIdsAsync() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantIdAndIdsAsync(tenantId, new ArrayList<>()));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetsByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindAssetsByTenantIdAndIdsAsync2() {
    // Arrange
    when(assetDao.findAssetsByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<AssetId> assetIds = new ArrayList<>();
    assetIds.add(new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantIdAndIdsAsync(tenantId, assetIds));
    verify(tenantId, atLeast(1)).getId();
    verify(assetDao).findAssetsByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetsByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindAssetsByTenantIdAndIdsAsync3() {
    // Arrange
    SettableFuture<List<Asset>> createResult = SettableFuture.create();
    when(assetDao.findAssetsByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<AssetId> assetIds = new ArrayList<>();
    assetIds.add(assetId);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndIdsAsyncResult =
        baseAssetService.findAssetsByTenantIdAndIdsAsync(tenantId, assetIds);

    // Assert
    verify(assetId).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(assetDao).findAssetsByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
    assertTrue(actualFindAssetsByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetsByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindAssetsByTenantIdAndIdsAsync4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<AssetId> assetIds = new ArrayList<>();
    assetIds.add(assetId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantIdAndIdsAsync(tenantId, assetIds));
    verify(assetId).getId();
    verify(tenantId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndIdsAsync(TenantId, List); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetsByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindAssetsByTenantIdAndIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Asset>> createResult = SettableFuture.create();
    when(assetDao.findAssetsByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<AssetId> assetIds = new ArrayList<>();
    assetIds.add(new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndIdsAsyncResult =
        baseAssetService.findAssetsByTenantIdAndIdsAsync(tenantId, assetIds);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(assetDao).findAssetsByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
    assertTrue(actualFindAssetsByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity2() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(assetDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity3() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity4() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doThrow(new DataValidationException("An error occurred"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AssetDao} {@link AssetDao#findById(TenantId, UUID)} return {@code null}.
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given AssetDao findById(TenantId, UUID) return 'null'; when NULL_CUSTOMER_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenAssetDaoFindByIdReturnNull_whenNull_customer_id() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    baseAssetService.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AssetDao}.
   *   <li>When {@link AssetId}.
   *   <li>Then calls {@link EntityViewService#existsByTenantIdAndEntityId(TenantId, EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given AssetDao; when AssetId; then calls existsByTenantIdAndEntityId(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenAssetDao_whenAssetId_thenCallsExistsByTenantIdAndEntityId() {
    // Arrange
    when(entityViewService.existsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.deleteEntity(
                ModelConstants.SYSTEM_TENANT, mock(AssetId.class), false));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link EntityViewService} {@link
   *       EntityViewService#existsByTenantIdAndEntityId(TenantId, EntityId)} return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given EntityViewService existsByTenantIdAndEntityId(TenantId, EntityId) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenEntityViewServiceExistsByTenantIdAndEntityIdReturnFalse() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    when(entityViewService.existsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(false);

    AssetId id = mock(AssetId.class);
    when(id.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    baseAssetService.deleteEntity(ModelConstants.SYSTEM_TENANT, id, false);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(id).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then calls {@link AssetId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    AssetId id = mock(AssetId.class);
    when(id.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    baseAssetService.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(id).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link EntityCountService#publishCountEntityEvictEvent(TenantId, EntityType)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); then calls publishCountEntityEvictEvent(TenantId, EntityType)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenCallsPublishCountEntityEvictEvent() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act
    baseAssetService.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteAssetsByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteAssetsByTenantId(TenantId)"})
  void testDeleteAssetsByTenantId() {
    // Arrange
    ArrayList<Asset> assetList = new ArrayList<>();
    assetList.add(new Asset());

    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(assetList);
    doThrow(new DataValidationException("An error occurred"))
        .when(assetDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.deleteAssetsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(pageData).getData();
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteAssetsByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteAssetsByTenantId(TenantId)"})
  void testDeleteAssetsByTenantId2() {
    // Arrange
    ArrayList<Asset> assetList = new ArrayList<>();
    assetList.add(new Asset());

    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(assetList);
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.deleteAssetsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(pageData).getData();
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteAssetsByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteAssetsByTenantId(TenantId)"})
  void testDeleteAssetsByTenantId3() {
    // Arrange
    ArrayList<Asset> assetList = new ArrayList<>();
    assetList.add(new Asset());

    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(assetList);
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doThrow(new DataValidationException("An error occurred"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.deleteAssetsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(pageData).getData();
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link AssetDao} {@link AssetDao#findAssetsByTenantId(UUID, PageLink)} return
   *       emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetsByTenantId(TenantId); given AssetDao findAssetsByTenantId(UUID, PageLink) return emptyPageData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteAssetsByTenantId(TenantId)"})
  void testDeleteAssetsByTenantId_givenAssetDaoFindAssetsByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseAssetService.deleteAssetsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetsByTenantId(TenantId); given PageData hasNext() return 'false'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteAssetsByTenantId(TenantId)"})
  void testDeleteAssetsByTenantId_givenPageDataHasNextReturnFalse_thenCallsGetId() {
    // Arrange
    ArrayList<Asset> assetList = new ArrayList<>();
    assetList.add(new Asset());

    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(assetList);
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    baseAssetService.deleteAssetsByTenantId(tenantId);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId() {
    // Arrange
    ArrayList<Asset> assetList = new ArrayList<>();
    assetList.add(new Asset());

    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(assetList);
    doThrow(new DataValidationException("An error occurred"))
        .when(assetDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(pageData).getData();
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId2() {
    // Arrange
    ArrayList<Asset> assetList = new ArrayList<>();
    assetList.add(new Asset());

    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(assetList);
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doThrow(new DataValidationException("An error occurred"))
        .when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(pageData).getData();
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseAssetService#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId3() {
    // Arrange
    ArrayList<Asset> assetList = new ArrayList<>();
    assetList.add(new Asset());

    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(assetList);
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doThrow(new DataValidationException("An error occurred"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(pageData).getData();
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link AssetDao} {@link AssetDao#findAssetsByTenantId(UUID, PageLink)} return
   *       emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); given AssetDao findAssetsByTenantId(UUID, PageLink) return emptyPageData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenAssetDaoFindAssetsByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseAssetService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); given PageData hasNext() return 'false'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenPageDataHasNextReturnFalse_thenCallsGetId() {
    // Arrange
    ArrayList<Asset> assetList = new ArrayList<>();
    assetList.add(new Asset());

    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(assetList);
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    baseAssetService.deleteByTenantId(tenantId);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerId() {
    // Arrange
    when(assetDao.findAssetsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerId3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerId4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult =
        baseAssetService.findAssetsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult =
        baseAssetService.findAssetsByTenantIdAndCustomerId(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerId_thenCallsGetId2() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult =
        baseAssetService.findAssetsByTenantIdAndCustomerId(tenantId, customerId, pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult =
        baseAssetService.findAssetsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult =
        baseAssetService.findAssetsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerId() {
    // Arrange
    when(assetDao.findAssetInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerId3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerId4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerId(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerId_thenCallsGetId2() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerId(tenantId, customerId, pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); when FIRST_PAGE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerId_whenFirst_page() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerIdAndType() {
    // Arrange
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerIdAndType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerIdAndType3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerIdAndType4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerIdAndType5() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerIdAndType_thenCallsGetId2() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(
            tenantId, customerId, "Type", pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); when FIRST_PAGE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndCustomerIdAndType_whenFirst_page() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndType() {
    // Arrange
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndType3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndType4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndType5() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenCallsGetId2() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(
            tenantId, customerId, "Type", pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); when FIRST_PAGE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndType_whenFirst_page() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId2() {
    // Arrange
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId3() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            assetProfileId,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId4() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                assetProfileId,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId5() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                assetProfileId,
                pageLink));
    verify(assetProfileId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId6() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            assetProfileId,
            pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId7() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                assetProfileId,
                pageLink));
    verify(assetProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId8() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            assetProfileId,
            pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId9() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                assetProfileId,
                pageLink));
    verify(assetProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId_thenCallsGetId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, assetProfileId, pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId,
   * CustomerId, AssetProfileId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId,
   * AssetProfileId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)"
  })
  void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId_thenCallsGetId2() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult =
        baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            tenantId, customerId, assetProfileId, pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(
            isA(UUID.class), isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        PageData.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindAssetsByTenantIdCustomerIdAndIdsAsync() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdCustomerIdAndIdsAsync(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>()));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link AssetId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseAssetService#findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindAssetsByTenantIdCustomerIdAndIdsAsync_thenCallsGetId() {
    // Arrange
    BaseAssetService baseAssetService = new BaseAssetService();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenThrow(new DataValidationException("An error occurred"));

    ArrayList<AssetId> assetIds = new ArrayList<>();
    assetIds.add(assetId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdCustomerIdAndIdsAsync(
                tenantId, customerId, assetIds));
    verify(assetId).getId();
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
  }

  /**
   * Test {@link BaseAssetService#unassignCustomerAssets(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link BaseAssetService#unassignCustomerAssets(TenantId, CustomerId)}
   */
  @Test
  @DisplayName("Test unassignCustomerAssets(TenantId, CustomerId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.unassignCustomerAssets(TenantId, CustomerId)"})
  void testUnassignCustomerAssets() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseAssetService.unassignCustomerAssets(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#unassignCustomerAssets(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#unassignCustomerAssets(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test unassignCustomerAssets(TenantId, CustomerId); given PageData hasNext() return 'false'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.unassignCustomerAssets(TenantId, CustomerId)"})
  void testUnassignCustomerAssets_givenPageDataHasNextReturnFalse_thenCallsGetId() {
    // Arrange
    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(assetDao.findAssetsByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    baseAssetService.unassignCustomerAssets(tenantId, customerId);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(assetDao)
        .findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#unassignCustomerAssets(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#unassignCustomerAssets(TenantId, CustomerId)}
   */
  @Test
  @DisplayName(
      "Test unassignCustomerAssets(TenantId, CustomerId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseAssetService.unassignCustomerAssets(TenantId, CustomerId)"})
  void testUnassignCustomerAssets_thenThrowDataValidationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.unassignCustomerAssets(tenantId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByQuery(TenantId, AssetSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link ListenableFutureTask} {@link ListenableFutureTask#addListener(Runnable,
   *       Executor)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByQuery(TenantId, AssetSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByQuery(TenantId, AssetSearchQuery); given ListenableFutureTask addListener(Runnable, Executor) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetsByQuery(TenantId, AssetSearchQuery)"
  })
  void testFindAssetsByQuery_givenListenableFutureTaskAddListenerDoesNothing() {
    // Arrange
    ListenableFutureTask<List<EntityRelation>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(listenableFutureTask);

    // Act
    baseAssetService.findAssetsByQuery(ModelConstants.SYSTEM_TENANT, new AssetSearchQuery());

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByQuery(TenantId, AssetSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link RelationService} {@link RelationService#findByQuery(TenantId,
   *       EntityRelationsQuery)} return create.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByQuery(TenantId, AssetSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByQuery(TenantId, AssetSearchQuery); given RelationService findByQuery(TenantId, EntityRelationsQuery) return create")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetsByQuery(TenantId, AssetSearchQuery)"
  })
  void testFindAssetsByQuery_givenRelationServiceFindByQueryReturnCreate() {
    // Arrange
    SettableFuture<List<EntityRelation>> createResult = SettableFuture.create();
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(createResult);

    // Act
    baseAssetService.findAssetsByQuery(ModelConstants.SYSTEM_TENANT, new AssetSearchQuery());

    // Assert
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByQuery(TenantId, AssetSearchQuery)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByQuery(TenantId, AssetSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByQuery(TenantId, AssetSearchQuery); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAssetService.findAssetsByQuery(TenantId, AssetSearchQuery)"
  })
  void testFindAssetsByQuery_thenThrowDataValidationException() {
    // Arrange
    ListenableFutureTask<List<EntityRelation>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doThrow(new DataValidationException("An error occurred"))
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByQuery(
                ModelConstants.SYSTEM_TENANT, new AssetSearchQuery()));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test findAssetTypesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseAssetService.findAssetTypesByTenantId(TenantId)"})
  void testFindAssetTypesByTenantId() {
    // Arrange
    when(assetDao.findTenantAssetTypesAsync(Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findAssetTypesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(assetDao).findTenantAssetTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test findAssetTypesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseAssetService.findAssetTypesByTenantId(TenantId)"})
  void testFindAssetTypesByTenantId2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseAssetService.findAssetTypesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findAssetTypesByTenantId(TenantId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseAssetService.findAssetTypesByTenantId(TenantId)"})
  void testFindAssetTypesByTenantId_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    SettableFuture<List<EntitySubtype>> createResult = SettableFuture.create();
    when(assetDao.findTenantAssetTypesAsync(Mockito.<UUID>any())).thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindAssetTypesByTenantIdResult =
        baseAssetService.findAssetTypesByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(assetDao).findTenantAssetTypesAsync(isA(UUID.class));
    assertTrue(actualFindAssetTypesByTenantIdResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetTypesByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findAssetTypesByTenantId(TenantId); when SYSTEM_TENANT; then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture BaseAssetService.findAssetTypesByTenantId(TenantId)"})
  void testFindAssetTypesByTenantId_whenSystem_tenant_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<EntitySubtype>> createResult = SettableFuture.create();
    when(assetDao.findTenantAssetTypesAsync(Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindAssetTypesByTenantIdResult =
        baseAssetService.findAssetTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetDao).findTenantAssetTypesAsync(isA(UUID.class));
    assertTrue(actualFindAssetTypesByTenantIdResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetTypesByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}.
   *
   * <p>Method under test: {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  @DisplayName("Test assignAssetToEdge(TenantId, AssetId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.assignAssetToEdge(TenantId, AssetId, EdgeId)"})
  void testAssignAssetToEdge() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.assignAssetToEdge(ModelConstants.SYSTEM_TENANT, assetId, null));
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link Asset#Asset()} TenantId is {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test assignAssetToEdge(TenantId, AssetId, EdgeId); given Asset() TenantId is SYSTEM_TENANT; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.assignAssetToEdge(TenantId, AssetId, EdgeId)"})
  void testAssignAssetToEdge_givenAssetTenantIdIsSystem_tenant_thenCallsGetId() {
    // Arrange
    Asset asset = new Asset();
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    Edge edge = new Edge();
    edge.setTenantId(tenantId);
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(edge);

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.assignAssetToEdge(ModelConstants.SYSTEM_TENANT, assetId, null));
    verify(tenantId).getId();
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link DataValidationException#DataValidationException(String)} with message is
   *       {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test assignAssetToEdge(TenantId, AssetId, EdgeId); given DataValidationException(String) with message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.assignAssetToEdge(TenantId, AssetId, EdgeId)"})
  void testAssignAssetToEdge_givenDataValidationExceptionWithMessageIsAnErrorOccurred() {
    // Arrange
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.assignAssetToEdge(ModelConstants.SYSTEM_TENANT, assetId, null));
    verify(assetId).getId();
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}.
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromEdge(TenantId, AssetId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromEdge(TenantId, AssetId, EdgeId)"})
  void testUnassignAssetFromEdge() {
    // Arrange
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.unassignAssetFromEdge(ModelConstants.SYSTEM_TENANT, assetId, null));
    verify(assetId).getId();
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}.
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromEdge(TenantId, AssetId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromEdge(TenantId, AssetId, EdgeId)"})
  void testUnassignAssetFromEdge2() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.unassignAssetFromEdge(ModelConstants.SYSTEM_TENANT, assetId, null));
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}.
   *
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromEdge(TenantId, AssetId, EdgeId); then return Asset()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromEdge(TenantId, AssetId, EdgeId)"})
  void testUnassignAssetFromEdge_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any()))
        .thenReturn(new Edge());
    when(entityViewService.findEntityViewsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(true);

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Asset actualUnassignAssetFromEdgeResult =
        baseAssetService.unassignAssetFromEdge(ModelConstants.SYSTEM_TENANT, assetId, null);

    // Assert
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
    verify(entityViewService)
        .findEntityViewsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(asset, actualUnassignAssetFromEdgeResult);
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  @DisplayName("Test unassignAssetFromEdge(TenantId, AssetId, EdgeId); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset BaseAssetService.unassignAssetFromEdge(TenantId, AssetId, EdgeId)"})
  void testUnassignAssetFromEdge_thenThrowRuntimeException() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any()))
        .thenReturn(new Edge());
    when(entityViewService.findEntityViewsByTenantIdAndEntityId(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> baseAssetService.unassignAssetFromEdge(ModelConstants.SYSTEM_TENANT, assetId, null));
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
    verify(entityViewService)
        .findEntityViewsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult =
        baseAssetService.findAssetsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeId2() {
    // Arrange
    when(assetDao.findAssetsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeId3() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeId4() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeId5() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeId_givenBy_created_time_desc() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult =
        baseAssetService.findAssetsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); given SortOrder getProperty() return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeId_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult =
        baseAssetService.findAssetsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeId_thenCallsGetId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult =
        baseAssetService.findAssetsByTenantIdAndEdgeId(tenantId, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult =
        baseAssetService.findAssetsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeIdAndType() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeIdAndType2() {
    // Arrange
    when(assetDao.findAssetsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                "Type",
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeIdAndType3() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeId).getId();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeIdAndType4() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeIdAndType5() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeIdAndType6() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findAssetsByTenantIdAndEdgeIdAndType(
                ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeIdAndType_thenCallsGetId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndEdgeIdAndType(tenantId, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId,
   * EdgeId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAssetService.findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)"
  })
  void testFindAssetsByTenantIdAndEdgeIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult =
        baseAssetService.findAssetsByTenantIdAndEdgeIdAndType(
            ModelConstants.SYSTEM_TENANT, edgeId, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(assetDao)
        .findAssetsByTenantIdAndEdgeIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link AssetDao} {@link AssetDao#findById(TenantId, UUID)} return {@link
   *       Asset#Asset()}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findEntity(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntity(TenantId, EntityId); given AssetDao findById(TenantId, UUID) return Asset(); then return Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseAssetService.findEntity(TenantId, EntityId)"})
  void testFindEntity_givenAssetDaoFindByIdReturnAsset_thenReturnPresent() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        baseAssetService.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(asset, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseAssetService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findEntity(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntity(TenantId, EntityId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseAssetService.findEntity(TenantId, EntityId)"})
  void testFindEntity_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.findEntity(ModelConstants.SYSTEM_TENANT, entityId));
    verify(entityId).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#findEntity(TenantId, EntityId)}
   */
  @Test
  @DisplayName(
      "Test findEntity(TenantId, EntityId); when NULL_CUSTOMER_ID; then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseAssetService.findEntity(TenantId, EntityId)"})
  void testFindEntity_whenNull_customer_id_thenThrowDataValidationException() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseAssetService.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link AssetDao} {@link AssetDao#countByTenantId(TenantId)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#countByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test countByTenantId(TenantId); given AssetDao countByTenantId(TenantId) return one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseAssetService.countByTenantId(TenantId)"})
  void testCountByTenantId_givenAssetDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(assetDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult =
        baseAssetService.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAssetService#countByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test countByTenantId(TenantId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseAssetService.countByTenantId(TenantId)"})
  void testCountByTenantId_thenThrowDataValidationException() {
    // Arrange
    when(assetDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseAssetService.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(assetDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseAssetService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseAssetService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType BaseAssetService.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET, new BaseAssetService().getEntityType());
  }
}
