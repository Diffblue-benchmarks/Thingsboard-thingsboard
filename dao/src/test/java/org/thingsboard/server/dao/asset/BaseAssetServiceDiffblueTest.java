package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
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
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.asset.AssetInfo;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.asset.AssetSearchQuery;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationsSearchParameters;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.TenantEntityDao;
import org.thingsboard.server.dao.alarm.AlarmService;
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
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class BaseAssetServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private AssetDao assetDao;

  @MockBean
  private AssetProfileService assetProfileService;

  @Autowired
  private BaseAssetService baseAssetService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<Asset> dataValidator;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityCountService entityCountService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTransactionalCache<AssetCacheKey, Asset> tbTransactionalCache;

  /**
   * Test {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)} with
   * {@code AssetCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithAssetCacheEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act
    baseAssetService.handleEvictEvent(new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)} with
   * {@code AssetCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithAssetCacheEvictEvent2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act
    baseAssetService.handleEvictEvent(new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Old Name", "Old Name"));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)} with
   * {@code AssetCacheEvictEvent}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithAssetCacheEvictEvent3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act
    baseAssetService.handleEvictEvent(new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", ""));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)} with
   * {@code AssetCacheEvictEvent}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#handleEvictEvent(AssetCacheEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithAssetCacheEvictEvent_thenThrowDataValidationException() {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService
        .handleEvictEvent(new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name")));
    verify(tbTransactionalCache).evict(isA(Collection.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetInfoById(TenantId, AssetId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfoById(TenantId, AssetId)}
   */
  @Test
  public void testFindAssetInfoById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();
    when(assetDao.findAssetInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(assetInfo);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AssetInfo actualFindAssetInfoByIdResult = baseAssetService.findAssetInfoById(ModelConstants.SYSTEM_TENANT, assetId);

    // Assert
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findAssetInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(assetInfo, actualFindAssetInfoByIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfoById(TenantId, AssetId)}.
   * <ul>
   *   <li>When {@link AssetId#AssetId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link AssetInfo#AssetInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfoById(TenantId, AssetId)}
   */
  @Test
  public void testFindAssetInfoById_whenAssetIdWithIdIsNull_uuid_thenReturnAssetInfo() {
    // Arrange
    AssetInfo assetInfo = new AssetInfo();
    when(assetDao.findAssetInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(assetInfo);

    // Act
    AssetInfo actualFindAssetInfoByIdResult = baseAssetService.findAssetInfoById(ModelConstants.SYSTEM_TENANT,
        new AssetId(ModelConstants.NULL_UUID));

    // Assert
    verify(assetDao).findAssetInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(assetInfo, actualFindAssetInfoByIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetById(TenantId, AssetId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link AssetId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#findAssetById(TenantId, AssetId)}
   */
  @Test
  public void testFindAssetById_givenNull_uuid_whenAssetIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Asset actualFindAssetByIdResult = baseAssetService.findAssetById(ModelConstants.SYSTEM_TENANT, assetId);

    // Assert
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(asset, actualFindAssetByIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetById(TenantId, AssetId)}.
   * <ul>
   *   <li>When {@link AssetId#AssetId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#findAssetById(TenantId, AssetId)}
   */
  @Test
  public void testFindAssetById_whenAssetIdWithIdIsNull_uuid_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act
    Asset actualFindAssetByIdResult = baseAssetService.findAssetById(ModelConstants.SYSTEM_TENANT,
        new AssetId(ModelConstants.NULL_UUID));

    // Assert
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(asset, actualFindAssetByIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetByIdAsync(TenantId, AssetId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetByIdAsync(TenantId, AssetId)}
   */
  @Test
  public void testFindAssetByIdAsync_givenNull_uuid_thenCallsGetId() {
    // Arrange
    SettableFuture<Asset> createResult = SettableFuture.create();
    when(assetDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<Asset> actualFindAssetByIdAsyncResult = baseAssetService
        .findAssetByIdAsync(ModelConstants.SYSTEM_TENANT, assetId);

    // Assert
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAssetByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetByIdAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetByIdAsync(TenantId, AssetId)}.
   * <ul>
   *   <li>When {@link AssetId#AssetId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetByIdAsync(TenantId, AssetId)}
   */
  @Test
  public void testFindAssetByIdAsync_whenAssetIdWithIdIsNull_uuid_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Asset> createResult = SettableFuture.create();
    when(assetDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Asset> actualFindAssetByIdAsyncResult = baseAssetService
        .findAssetByIdAsync(ModelConstants.SYSTEM_TENANT, new AssetId(ModelConstants.NULL_UUID));

    // Assert
    verify(assetDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAssetByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetByIdAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindAssetByTenantIdAndName_thenThrowDataValidationException() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<AssetCacheKey>any(), Mockito.<Supplier<Asset>>any(),
        anyBoolean())).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetByTenantIdAndName(ModelConstants.SYSTEM_TENANT, "Name"));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(AssetCacheKey.class), isA(Supplier.class), eq(true));
  }

  /**
   * Test {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindAssetByTenantIdAndName_whenSystem_tenant_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<AssetCacheKey>any(), Mockito.<Supplier<Asset>>any(),
        anyBoolean())).thenReturn(asset);

    // Act
    Asset actualFindAssetByTenantIdAndNameResult = baseAssetService
        .findAssetByTenantIdAndName(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(AssetCacheKey.class), isA(Supplier.class), eq(true));
    assertSame(asset, actualFindAssetByTenantIdAndNameResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetByTenantIdAndNameAsync(TenantId, String)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  public void testFindAssetByTenantIdAndNameAsync_whenSystem_tenant_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Asset> actualFindAssetByTenantIdAndNameAsyncResult = baseAssetService
        .findAssetByTenantIdAndNameAsync(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindAssetByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset},
   * {@code doValidate}.
   * <ul>
   *   <li>Given {@link Asset} {@link Asset#getName()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  public void testSaveAssetWithAssetDoValidate_givenAssetGetNameReturnEmptyString() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any())).thenReturn(asset);
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
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset},
   * {@code doValidate}.
   * <ul>
   *   <li>Then calls
   * {@link AssetProfileService#findDefaultAssetProfile(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  public void testSaveAssetWithAssetDoValidate_thenCallsFindDefaultAssetProfile() {
    // Arrange
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(new AssetProfile());
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(new Asset());
    doThrow(new DataValidationException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(new Asset(), true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetProfileService).findDefaultAssetProfile(isNull());
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset},
   * {@code doValidate}.
   * <ul>
   *   <li>Then calls {@link Asset#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  public void testSaveAssetWithAssetDoValidate_thenCallsGetName() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any())).thenReturn(asset);
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
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset},
   * {@code doValidate}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  public void testSaveAssetWithAssetDoValidate_thenThrowRuntimeException() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException("Executing saveAsset [{}]"));
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any())).thenReturn(asset);
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
   * Test {@link BaseAssetService#saveAsset(Asset, boolean)} with {@code asset},
   * {@code doValidate}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#saveAsset(Asset, boolean)}
   */
  @Test
  public void testSaveAssetWithAssetDoValidate_whenFalse_thenThrowDataValidationException() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
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
   * Test {@link BaseAssetService#saveAsset(Asset)} with {@code asset}.
   * <ul>
   *   <li>Given {@link Asset} {@link Asset#getName()} return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#saveAsset(Asset)}
   */
  @Test
  public void testSaveAssetWithAsset_givenAssetGetNameReturnEmptyString() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any())).thenReturn(asset);
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
   * <ul>
   *   <li>Then calls
   * {@link AssetProfileService#findDefaultAssetProfile(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#saveAsset(Asset)}
   */
  @Test
  public void testSaveAssetWithAsset_thenCallsFindDefaultAssetProfile() {
    // Arrange
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(new AssetProfile());
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(new Asset());
    doThrow(new DataValidationException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.saveAsset(new Asset()));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetProfileService).findDefaultAssetProfile(isNull());
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#saveAsset(Asset)} with {@code asset}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#saveAsset(Asset)}
   */
  @Test
  public void testSaveAssetWithAsset_thenThrowDataValidationException() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any())).thenReturn(asset);
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
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#saveAsset(Asset)}
   */
  @Test
  public void testSaveAssetWithAsset_thenThrowRuntimeException() {
    // Arrange
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new RuntimeException("Executing saveAsset [{}]"));
    Asset asset = mock(Asset.class);
    when(asset.getName()).thenReturn("Name");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any())).thenReturn(asset);
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
   * Test
   * {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}.
   * <ul>
   *   <li>Given {@link Asset#Asset()} CustomerId is
   * {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}
   */
  @Test
  public void testAssignAssetToCustomer_givenAssetCustomerIdIsNull_customer_id_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    asset.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act
    Asset actualAssignAssetToCustomerResult = baseAssetService.assignAssetToCustomer(ModelConstants.SYSTEM_TENANT,
        new AssetId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(asset, actualAssignAssetToCustomerResult);
  }

  /**
   * Test
   * {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}.
   * <ul>
   *   <li>Given {@link Asset} {@link Asset#getName()} return empty string.</li>
   *   <li>Then calls {@link Asset#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}
   */
  @Test
  public void testAssignAssetToCustomer_givenAssetGetNameReturnEmptyString_thenCallsGetName() {
    // Arrange
    Asset asset = new Asset();
    asset.setType("Executing findAssetById [{}]");
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Asset asset2 = mock(Asset.class);
    when(asset2.getName()).thenReturn("");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any())).thenReturn(asset2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService
        .assignAssetToCustomer(ModelConstants.SYSTEM_TENANT, assetId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset2).getName();
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService).findOrCreateAssetProfile(isNull(), eq("Executing findAssetById [{}]"));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test
   * {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}.
   * <ul>
   *   <li>Then calls
   * {@link AssetProfileService#findDefaultAssetProfile(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}
   */
  @Test
  public void testAssignAssetToCustomer_thenCallsFindDefaultAssetProfile() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(new AssetProfile());
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any()))
        .thenReturn(new Asset());
    doThrow(new DataValidationException("An error occurred")).when(tbTransactionalCache)
        .evict(Mockito.<Collection<AssetCacheKey>>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.assignAssetToCustomer(ModelConstants.SYSTEM_TENANT,
            new AssetId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService).findDefaultAssetProfile(isNull());
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test
   * {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}.
   * <ul>
   *   <li>Then calls {@link Asset#getName()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#assignAssetToCustomer(TenantId, AssetId, CustomerId)}
   */
  @Test
  public void testAssignAssetToCustomer_thenCallsGetName() {
    // Arrange
    Asset asset = new Asset();
    asset.setType("Executing findAssetById [{}]");
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    Asset asset2 = mock(Asset.class);
    when(asset2.getName()).thenReturn("Name");
    when(dataValidator.validate(Mockito.<Asset>any(), Mockito.<Function<Asset, TenantId>>any())).thenReturn(asset2);
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService
        .assignAssetToCustomer(ModelConstants.SYSTEM_TENANT, assetId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(asset2).getName();
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService).findOrCreateAssetProfile(isNull(), eq("Executing findAssetById [{}]"));
    verify(dataValidator).validate(isA(Asset.class), isA(Function.class));
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   * <ul>
   *   <li>Given {@link AssetDao} {@link Dao#findById(TenantId, UUID)} return
   * {@link Asset#Asset()}.</li>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  public void testUnassignAssetFromCustomer_givenAssetDaoFindByIdReturnAsset_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act
    Asset actualUnassignAssetFromCustomerResult = baseAssetService
        .unassignAssetFromCustomer(ModelConstants.SYSTEM_TENANT, new AssetId(ModelConstants.NULL_UUID));

    // Assert
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(asset, actualUnassignAssetFromCustomerResult);
  }

  /**
   * Test {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#unassignAssetFromCustomer(TenantId, AssetId)}
   */
  @Test
  public void testUnassignAssetFromCustomer_thenThrowRuntimeException() {
    // Arrange
    Asset asset = mock(Asset.class);
    doThrow(new RuntimeException("Executing findAssetById [{}]")).when(asset).setCustomerId(Mockito.<CustomerId>any());
    when(asset.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseAssetService.unassignAssetFromCustomer(ModelConstants.SYSTEM_TENANT,
        new AssetId(ModelConstants.NULL_UUID)));
    verify(asset).getCustomerId();
    verify(asset).setCustomerId(isNull());
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAsset(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <ul>
   *   <li>Given {@link AssetDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#deleteAsset(TenantId, AssetId)}
   */
  @Test
  public void testDeleteAssetWithTenantIdAssetId_givenAssetDaoFindByIdReturnNull() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(entityViewService.existsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(false);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseAssetService.deleteAsset(ModelConstants.SYSTEM_TENANT, assetId);

    // Assert
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAsset(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <ul>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#deleteAsset(TenantId, AssetId)}
   */
  @Test
  public void testDeleteAssetWithTenantIdAssetId_thenCallsEvict() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    when(entityViewService.existsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(false);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseAssetService.deleteAsset(ModelConstants.SYSTEM_TENANT, assetId);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAsset(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#deleteAsset(TenantId, AssetId)}
   */
  @Test
  public void testDeleteAssetWithTenantIdAssetId_thenThrowDataValidationException() {
    // Arrange
    when(entityViewService.existsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.deleteAsset(ModelConstants.SYSTEM_TENANT, new AssetId(ModelConstants.NULL_UUID)));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAsset(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#deleteAsset(TenantId, AssetId)}
   */
  @Test
  public void testDeleteAssetWithTenantIdAssetId_thenThrowDataValidationException2() {
    // Arrange
    when(entityViewService.existsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(true);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.deleteAsset(ModelConstants.SYSTEM_TENANT, assetId));
    verify(assetId).getId();
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAsset(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#deleteAsset(TenantId, AssetId)}
   */
  @Test
  public void testDeleteAssetWithTenantIdAssetId_thenThrowRuntimeException() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getId()).thenThrow(new RuntimeException("foo"));
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    when(entityViewService.existsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(false);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseAssetService.deleteAsset(ModelConstants.SYSTEM_TENANT, assetId));
    verify(asset).getId();
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAsset(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <ul>
   *   <li>When {@link AssetId#AssetId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#deleteAsset(TenantId, AssetId)}
   */
  @Test
  public void testDeleteAssetWithTenantIdAssetId_whenAssetIdWithIdIsNull_uuid_thenCallsEvict() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    when(entityViewService.existsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(false);

    // Act
    baseAssetService.deleteAsset(ModelConstants.SYSTEM_TENANT, new AssetId(ModelConstants.NULL_UUID));

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult = baseAssetService
        .findAssetsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult = baseAssetService
        .findAssetsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantId_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantId_thenThrowRuntimeException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new RuntimeException("Executing findAssetsByTenantId, tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseAssetService.findAssetsByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdResult = baseAssetService
        .findAssetsByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult = baseAssetService
        .findAssetInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult = baseAssetService
        .findAssetInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantId_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantId_thenThrowRuntimeException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new RuntimeException("Executing findAssetInfosByTenantId, tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseAssetService.findAssetInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdResult = baseAssetService
        .findAssetInfosByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindAssetInfosByTenantIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndType() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult = baseAssetService
        .findAssetsByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndTypeResult.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndType_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult = baseAssetService
        .findAssetsByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndTypeResult.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndType_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndTypeResult = baseAssetService
        .findAssetsByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetsByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndTypeResult.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndType() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult = baseAssetService
        .findAssetInfosByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndType_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult = baseAssetService
        .findAssetInfosByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndType_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetInfosByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndType(TenantId, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndType(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndTypeResult = baseAssetService
        .findAssetInfosByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndAssetProfileId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult = baseAssetService
        .findAssetInfosByTenantIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT,
            new AssetProfileId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetInfosByTenantIdAndAssetProfileId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndAssetProfileIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndAssetProfileId2() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult = baseAssetService
        .findAssetInfosByTenantIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT, assetProfileId, pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantIdAndAssetProfileId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndAssetProfileIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndAssetProfileId3() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult = baseAssetService
        .findAssetInfosByTenantIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT, assetProfileId, pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantIdAndAssetProfileId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndAssetProfileIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndAssetProfileId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndAssetProfileIdResult = baseAssetService
        .findAssetInfosByTenantIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT, assetProfileId,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(assetDao).findAssetInfosByTenantIdAndAssetProfileId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndAssetProfileIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndAssetProfileIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndAssetProfileId(TenantId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndAssetProfileId_thenThrowDataValidationException() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService
        .findAssetInfosByTenantIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT, assetProfileId, pageLink));
    verify(assetProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}.
   * <ul>
   *   <li>Given {@link AssetId#AssetId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  public void testFindAssetsByTenantIdAndIdsAsync_givenAssetIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<List<Asset>> createResult = SettableFuture.create();
    when(assetDao.findAssetsByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    ArrayList<AssetId> assetIds = new ArrayList<>();
    assetIds.add(new AssetId(ModelConstants.NULL_UUID));

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndIdsAsyncResult = baseAssetService
        .findAssetsByTenantIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, assetIds);

    // Assert
    verify(assetDao).findAssetsByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
    assertTrue(actualFindAssetsByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  public void testFindAssetsByTenantIdAndIdsAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<List<Asset>> createResult = SettableFuture.create();
    when(assetDao.findAssetsByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<AssetId> assetIds = new ArrayList<>();
    assetIds.add(assetId);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdAndIdsAsyncResult = baseAssetService
        .findAssetsByTenantIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, assetIds);

    // Assert
    verify(assetId).getId();
    verify(assetDao).findAssetsByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
    assertTrue(actualFindAssetsByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doThrow(new DataValidationException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link AssetDao} {@link Dao#findById(TenantId, UUID)} return
   * {@link Asset#Asset()}.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Collection)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenAssetDaoFindByIdReturnAsset_thenCallsEvict() {
    // Arrange
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act
    baseAssetService.deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link AssetDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenAssetDaoFindByIdReturnNull_whenNull_customer_id() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    baseAssetService.deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert that nothing has changed
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link EntityViewService}
   * {@link EntityViewService#existsByTenantIdAndEntityId(TenantId, EntityId)}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenEntityViewServiceExistsByTenantIdAndEntityIdReturnFalse() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getId()).thenThrow(new RuntimeException("foo"));
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    when(entityViewService.existsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(false);
    EntityId id = mock(EntityId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseAssetService.deleteEntity(ModelConstants.SYSTEM_TENANT, id, false));
    verify(asset).getId();
    verify(id).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link EntityViewService}
   * {@link EntityViewService#existsByTenantIdAndEntityId(TenantId, EntityId)}
   * return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenEntityViewServiceExistsByTenantIdAndEntityIdReturnTrue() {
    // Arrange
    when(entityViewService.existsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.deleteEntity(ModelConstants.SYSTEM_TENANT, mock(EntityId.class), false));
    verify(entityViewService).existsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getId()).thenThrow(new RuntimeException("foo"));
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    EntityId id = mock(EntityId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseAssetService.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true));
    verify(asset).getId();
    verify(id).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_whenNull_customer_id_thenThrowRuntimeException() {
    // Arrange
    Asset asset = mock(Asset.class);
    when(asset.getId()).thenThrow(new RuntimeException("foo"));
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseAssetService.deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(asset).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link AssetDao}
   * {@link AssetDao#findAssetsByTenantId(UUID, PageLink)} return
   * emptyPageData.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteAssetsByTenantId_givenAssetDaoFindAssetsByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    baseAssetService.deleteAssetsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#deleteAssetsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteAssetsByTenantId_thenThrowDataValidationException() {
    // Arrange
    ArrayList<Asset> assetList = new ArrayList<>();
    assetList.add(new Asset());
    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(assetList);
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doThrow(new DataValidationException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.deleteAssetsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(pageData).getData();
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseAssetService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link AssetDao}
   * {@link AssetDao#findAssetsByTenantId(UUID, PageLink)} return
   * emptyPageData.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_givenAssetDaoFindAssetsByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    baseAssetService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenThrowDataValidationException() {
    // Arrange
    ArrayList<Asset> assetList = new ArrayList<>();
    assetList.add(new Asset());
    PageData<Asset> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(assetList);
    doNothing().when(assetDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetDao.findAssetsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(tbTransactionalCache).evict(Mockito.<Collection<AssetCacheKey>>any());
    doThrow(new DataValidationException("An error occurred")).when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(tbTransactionalCache).evict(isA(Collection.class));
    verify(pageData).getData();
    verify(assetDao).removeById(isA(TenantId.class), isNull());
    verify(assetDao).findAssetsByTenantId(isA(UUID.class), isA(PageLink.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.ASSET));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult = baseAssetService
        .findAssetsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindAssetsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerId2() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult = baseAssetService
        .findAssetsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindAssetsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerId_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService
        .findAssetsByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdResult = baseAssetService.findAssetsByTenantIdAndCustomerId(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindAssetsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult = baseAssetService
        .findAssetInfosByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerId2() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult = baseAssetService
        .findAssetInfosByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdResult = baseAssetService
        .findAssetInfosByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetInfosByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerId_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetInfosByTenantIdAndCustomerId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndType() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult = baseAssetService
        .findAssetsByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndType2() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult = baseAssetService
        .findAssetsByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndCustomerIdAndTypeResult = baseAssetService
        .findAssetsByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetsByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetsByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndType_thenThrowDataValidationException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndCustomerIdAndType_thenThrowRuntimeException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException(
        "Executing findAssetsByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
            + " pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseAssetService.findAssetsByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult = baseAssetService
        .findAssetInfosByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType2() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult = baseAssetService
        .findAssetInfosByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<String>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult = baseAssetService
        .findAssetInfosByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetInfosByTenantIdAndCustomerIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndType_thenThrowRuntimeException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException(
        "Executing findAssetInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
            + " pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndType(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult = baseAssetService
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, new AssetProfileId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId2() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult = baseAssetService
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, assetProfileId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(assetDao).findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId3() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult = baseAssetService
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, assetProfileId, pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId4() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException(
        "Executing findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId, tenantId [{}], customerId [{}],"
            + " assetProfileId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, assetProfileId, pageLink));
    verify(assetProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId5() {
    // Arrange
    PageData<AssetInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<AssetInfo> actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult = baseAssetService
        .findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, assetProfileId, pageLink);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(isA(UUID.class), isA(UUID.class),
        isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult.EMPTY_PAGE_DATA,
        actualFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(TenantId, CustomerId, AssetProfileId, PageLink)}
   */
  @Test
  public void testFindAssetInfosByTenantIdAndCustomerIdAndAssetProfileId6() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetInfosByTenantIdAndCustomerIdAndAssetProfileId(ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID, assetProfileId, pageLink));
    verify(assetProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}.
   * <ul>
   *   <li>Given {@link AssetId#AssetId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  public void testFindAssetsByTenantIdCustomerIdAndIdsAsync_givenAssetIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<List<Asset>> createResult = SettableFuture.create();
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<List<UUID>>any())).thenReturn(createResult);

    ArrayList<AssetId> assetIds = new ArrayList<>();
    assetIds.add(new AssetId(ModelConstants.NULL_UUID));

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdCustomerIdAndIdsAsyncResult = baseAssetService
        .findAssetsByTenantIdCustomerIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            assetIds);

    // Assert
    verify(assetDao).findAssetsByTenantIdAndCustomerIdAndIdsAsync(isA(UUID.class), isA(UUID.class), isA(List.class));
    assertTrue(actualFindAssetsByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)}
   */
  @Test
  public void testFindAssetsByTenantIdCustomerIdAndIdsAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<List<Asset>> createResult = SettableFuture.create();
    when(assetDao.findAssetsByTenantIdAndCustomerIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<List<UUID>>any())).thenReturn(createResult);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    ArrayList<AssetId> assetIds = new ArrayList<>();
    assetIds.add(assetId);

    // Act
    ListenableFuture<List<Asset>> actualFindAssetsByTenantIdCustomerIdAndIdsAsyncResult = baseAssetService
        .findAssetsByTenantIdCustomerIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID,
            assetIds);

    // Assert
    verify(assetId).getId();
    verify(assetDao).findAssetsByTenantIdAndCustomerIdAndIdsAsync(isA(UUID.class), isA(UUID.class), isA(List.class));
    assertTrue(actualFindAssetsByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetsByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link BaseAssetService#unassignCustomerAssets(TenantId, CustomerId)}.
   * <ul>
   *   <li>Then calls
   * {@link AssetDao#findAssetsByTenantIdAndCustomerId(UUID, UUID, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#unassignCustomerAssets(TenantId, CustomerId)}
   */
  @Test
  public void testUnassignCustomerAssets_thenCallsFindAssetsByTenantIdAndCustomerId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndCustomerId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseAssetService.unassignCustomerAssets(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(assetDao).findAssetsByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByQuery(TenantId, AssetSearchQuery)}.
   * <ul>
   *   <li>Then calls {@link AssetSearchQuery#toEntitySearchQuery()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByQuery(TenantId, AssetSearchQuery)}
   */
  @Test
  public void testFindAssetsByQuery_thenCallsToEntitySearchQuery() {
    // Arrange
    SettableFuture<List<EntityRelation>> createResult = SettableFuture.create();
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(createResult);

    EntityRelationsQuery entityRelationsQuery = new EntityRelationsQuery();
    entityRelationsQuery.setFilters(new ArrayList<>());
    entityRelationsQuery.setParameters(
        new RelationsSearchParameters(BaseEntityService.NULL_CUSTOMER_ID, EntitySearchDirection.FROM, 3, true));
    AssetSearchQuery query = mock(AssetSearchQuery.class);
    when(query.toEntitySearchQuery()).thenReturn(entityRelationsQuery);

    // Act
    baseAssetService.findAssetsByQuery(ModelConstants.SYSTEM_TENANT, query);

    // Assert
    verify(query).toEntitySearchQuery();
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetsByQuery(TenantId, AssetSearchQuery)}.
   * <ul>
   *   <li>When {@link AssetSearchQuery} (default constructor).</li>
   *   <li>Then calls
   * {@link RelationService#findByQuery(TenantId, EntityRelationsQuery)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByQuery(TenantId, AssetSearchQuery)}
   */
  @Test
  public void testFindAssetsByQuery_whenAssetSearchQuery_thenCallsFindByQuery() {
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
   * Test {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}
   */
  @Test
  public void testFindAssetTypesByTenantId_thenThrowDataValidationException() {
    // Arrange
    when(assetDao.findTenantAssetTypesAsync(Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetTypesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(assetDao).findTenantAssetTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetTypesByTenantId(TenantId)}
   */
  @Test
  public void testFindAssetTypesByTenantId_whenSystem_tenant_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<EntitySubtype>> createResult = SettableFuture.create();
    when(assetDao.findTenantAssetTypesAsync(Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<List<EntitySubtype>> actualFindAssetTypesByTenantIdResult = baseAssetService
        .findAssetTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetDao).findTenantAssetTypesAsync(isA(UUID.class));
    assertTrue(actualFindAssetTypesByTenantIdResult instanceof SettableFuture);
    assertSame(createResult, actualFindAssetTypesByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}.
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  public void testAssignAssetToEdge_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    Edge edge = new Edge();
    edge.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(edge);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Asset actualAssignAssetToEdgeResult = baseAssetService.assignAssetToEdge(ModelConstants.SYSTEM_TENANT, assetId,
        null);

    // Assert
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(asset, actualAssignAssetToEdgeResult);
  }

  /**
   * Test {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  public void testAssignAssetToEdge_thenThrowDataValidationException() {
    // Arrange
    Asset asset = new Asset();
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    Edge edge = new Edge();
    edge.setTenantId(new TenantId(UUID.randomUUID()));
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(edge);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.assignAssetToEdge(ModelConstants.SYSTEM_TENANT, assetId, null));
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#assignAssetToEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  public void testAssignAssetToEdge_thenThrowRuntimeException() {
    // Arrange
    Asset asset = new Asset();
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    Edge edge = new Edge();
    edge.setTenantId(new TenantId(ModelConstants.NULL_UUID));
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(edge);
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseAssetService.assignAssetToEdge(ModelConstants.SYSTEM_TENANT, assetId, null));
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test
   * {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}.
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  public void testUnassignAssetFromEdge_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(new Edge());
    when(entityViewService.findEntityViewsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(true);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Asset actualUnassignAssetFromEdgeResult = baseAssetService.unassignAssetFromEdge(ModelConstants.SYSTEM_TENANT,
        assetId, null);

    // Assert
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
    verify(entityViewService).findEntityViewsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(asset, actualUnassignAssetFromEdgeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  public void testUnassignAssetFromEdge_thenThrowDataValidationException() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(null);
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.unassignAssetFromEdge(ModelConstants.SYSTEM_TENANT, assetId, null));
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#unassignAssetFromEdge(TenantId, AssetId, EdgeId)}
   */
  @Test
  public void testUnassignAssetFromEdge_thenThrowRuntimeException() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Asset());
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(new Edge());
    when(entityViewService.findEntityViewsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    AssetId assetId = mock(AssetId.class);
    when(assetId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> baseAssetService.unassignAssetFromEdge(ModelConstants.SYSTEM_TENANT, assetId, null));
    verify(assetId, atLeast(1)).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
    verify(entityViewService).findEntityViewsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeId() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult = baseAssetService
        .findAssetsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult = baseAssetService
        .findAssetsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeId_thenThrowDataValidationException() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseAssetService.findAssetsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeId_whenEdgeIdWithIdIsNull_uuid() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult = baseAssetService.findAssetsByTenantIdAndEdgeId(
        ModelConstants.SYSTEM_TENANT, new EdgeId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdResult = baseAssetService
        .findAssetsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(assetDao).findAssetsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA, actualFindAssetsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeIdAndType() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult = baseAssetService
        .findAssetsByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeIdAndType2() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult = baseAssetService
        .findAssetsByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetDao).findAssetsByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult = baseAssetService
        .findAssetsByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(assetDao).findAssetsByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeIdAndType_thenThrowDataValidationException() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService
        .findAssetsByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeIdAndType_thenThrowRuntimeException() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new RuntimeException(
        "Executing findAssetsByTenantIdAndEdgeIdAndType, tenantId [{}], edgeId [{}], type [{}] pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseAssetService
        .findAssetsByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, edgeId, "Type", pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}.
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAssetService#findAssetsByTenantIdAndEdgeIdAndType(TenantId, EdgeId, String, PageLink)}
   */
  @Test
  public void testFindAssetsByTenantIdAndEdgeIdAndType_whenEdgeIdWithIdIsNull_uuid() {
    // Arrange
    PageData<Asset> emptyPageDataResult = PageData.emptyPageData();
    when(assetDao.findAssetsByTenantIdAndEdgeIdAndType(Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<Asset> actualFindAssetsByTenantIdAndEdgeIdAndTypeResult = baseAssetService
        .findAssetsByTenantIdAndEdgeIdAndType(ModelConstants.SYSTEM_TENANT, new EdgeId(ModelConstants.NULL_UUID),
            "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetDao).findAssetsByTenantIdAndEdgeIdAndType(isA(UUID.class), isA(UUID.class), eq("Type"),
        isA(PageLink.class));
    assertSame(actualFindAssetsByTenantIdAndEdgeIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindAssetsByTenantIdAndEdgeIdAndTypeResult);
  }

  /**
   * Test {@link BaseAssetService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseAssetService.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(asset, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseAssetService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseAssetService.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(assetDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(asset, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseAssetService#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link AssetDao} {@link TenantEntityDao#countByTenantId(TenantId)}
   * return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_givenAssetDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(assetDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult = baseAssetService.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link BaseAssetService#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseAssetService#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_thenThrowDataValidationException() {
    // Arrange
    when(assetDao.countByTenantId(Mockito.<TenantId>any())).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseAssetService.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(assetDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseAssetService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseAssetService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET, (new BaseAssetService()).getEntityType());
  }
}
