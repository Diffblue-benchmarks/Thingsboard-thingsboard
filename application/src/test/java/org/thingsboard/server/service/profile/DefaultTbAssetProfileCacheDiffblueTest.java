package org.thingsboard.server.service.profile;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.asset.AssetService;

@ContextConfiguration(classes = {DefaultTbAssetProfileCache.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
class DefaultTbAssetProfileCacheDiffblueTest {
  @MockBean
  private AssetProfileService assetProfileService;

  @MockBean
  private AssetService assetService;

  @Autowired
  private DefaultTbAssetProfileCache defaultTbAssetProfileCache;

  /**
   * Test {@link DefaultTbAssetProfileCache#get(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <p>
   * Method under test: {@link DefaultTbAssetProfileCache#get(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test get(TenantId, AssetId) with 'tenantId', 'assetId'")
  void testGetWithTenantIdAssetId() {
    // Arrange
    when(assetProfileService.findAssetProfileById(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(null);

    Asset asset = new Asset();
    asset.setAssetProfileId(new AssetProfileId(UUID.randomUUID()));
    when(assetService.findAssetById(Mockito.<TenantId>any(), Mockito.<AssetId>any())).thenReturn(asset);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    AssetProfile actualGetResult = defaultTbAssetProfileCache.get(tenantId, new AssetId(UUID.randomUUID()));

    // Assert
    verify(assetProfileService).findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
    verify(assetService).findAssetById(isA(TenantId.class), isA(AssetId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbAssetProfileCache#get(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <ul>
   *   <li>Given {@link Asset#Asset()} AssetProfileId is
   * {@link AssetProfileId#AssetProfileId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbAssetProfileCache#get(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test get(TenantId, AssetId) with 'tenantId', 'assetId'; given Asset() AssetProfileId is AssetProfileId(UUID) with id is 'null'")
  void testGetWithTenantIdAssetId_givenAssetAssetProfileIdIsAssetProfileIdWithIdIsNull() {
    // Arrange
    when(assetProfileService.findAssetProfileById(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(null);

    Asset asset = new Asset();
    asset.setAssetProfileId(new AssetProfileId(null));
    when(assetService.findAssetById(Mockito.<TenantId>any(), Mockito.<AssetId>any())).thenReturn(asset);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    AssetProfile actualGetResult = defaultTbAssetProfileCache.get(tenantId, new AssetId(UUID.randomUUID()));

    // Assert
    verify(assetProfileService).findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
    verify(assetService).findAssetById(isA(TenantId.class), isA(AssetId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbAssetProfileCache#get(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <ul>
   *   <li>Given {@link AssetService}
   * {@link AssetService#findAssetById(TenantId, AssetId)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbAssetProfileCache#get(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test get(TenantId, AssetId) with 'tenantId', 'assetId'; given AssetService findAssetById(TenantId, AssetId) return 'null'")
  void testGetWithTenantIdAssetId_givenAssetServiceFindAssetByIdReturnNull() {
    // Arrange
    when(assetService.findAssetById(Mockito.<TenantId>any(), Mockito.<AssetId>any())).thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    AssetProfile actualGetResult = defaultTbAssetProfileCache.get(tenantId, new AssetId(UUID.randomUUID()));

    // Assert
    verify(assetService).findAssetById(isA(TenantId.class), isA(AssetId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbAssetProfileCache#get(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <ul>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbAssetProfileCache#get(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test get(TenantId, AssetId) with 'tenantId', 'assetId'; then return AssetProfile()")
  void testGetWithTenantIdAssetId_thenReturnAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    when(assetProfileService.findAssetProfileById(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(assetProfile);

    Asset asset = new Asset();
    asset.setAssetProfileId(new AssetProfileId(UUID.randomUUID()));
    when(assetService.findAssetById(Mockito.<TenantId>any(), Mockito.<AssetId>any())).thenReturn(asset);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    AssetProfile actualGetResult = defaultTbAssetProfileCache.get(tenantId, new AssetId(UUID.randomUUID()));

    // Assert
    verify(assetProfileService).findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
    verify(assetService).findAssetById(isA(TenantId.class), isA(AssetId.class));
    assertSame(assetProfile, actualGetResult);
  }

  /**
   * Test {@link DefaultTbAssetProfileCache#get(TenantId, AssetId)} with
   * {@code tenantId}, {@code assetId}.
   * <ul>
   *   <li>When {@link AssetId#AssetId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbAssetProfileCache#get(TenantId, AssetId)}
   */
  @Test
  @DisplayName("Test get(TenantId, AssetId) with 'tenantId', 'assetId'; when AssetId(UUID) with id is 'null'")
  void testGetWithTenantIdAssetId_whenAssetIdWithIdIsNull() {
    // Arrange
    when(assetProfileService.findAssetProfileById(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(null);

    Asset asset = new Asset();
    asset.setAssetProfileId(new AssetProfileId(UUID.randomUUID()));
    when(assetService.findAssetById(Mockito.<TenantId>any(), Mockito.<AssetId>any())).thenReturn(asset);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    AssetProfile actualGetResult = defaultTbAssetProfileCache.get(tenantId, new AssetId(null));

    // Assert
    verify(assetProfileService).findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
    verify(assetService).findAssetById(isA(TenantId.class), isA(AssetId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbAssetProfileCache#get(TenantId, AssetProfileId)} with
   * {@code tenantId}, {@code assetProfileId}.
   * <ul>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbAssetProfileCache#get(TenantId, AssetProfileId)}
   */
  @Test
  @DisplayName("Test get(TenantId, AssetProfileId) with 'tenantId', 'assetProfileId'; then return AssetProfile()")
  void testGetWithTenantIdAssetProfileId_thenReturnAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    when(assetProfileService.findAssetProfileById(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(assetProfile);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    AssetProfile actualGetResult = defaultTbAssetProfileCache.get(tenantId, new AssetProfileId(UUID.randomUUID()));

    // Assert
    verify(assetProfileService).findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
    assertSame(assetProfile, actualGetResult);
  }

  /**
   * Test {@link DefaultTbAssetProfileCache#get(TenantId, AssetProfileId)} with
   * {@code tenantId}, {@code assetProfileId}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbAssetProfileCache#get(TenantId, AssetProfileId)}
   */
  @Test
  @DisplayName("Test get(TenantId, AssetProfileId) with 'tenantId', 'assetProfileId'; then return 'null'")
  void testGetWithTenantIdAssetProfileId_thenReturnNull() {
    // Arrange
    when(assetProfileService.findAssetProfileById(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    AssetProfile actualGetResult = defaultTbAssetProfileCache.get(tenantId, new AssetProfileId(UUID.randomUUID()));

    // Assert
    verify(assetProfileService).findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbAssetProfileCache#get(TenantId, AssetProfileId)} with
   * {@code tenantId}, {@code assetProfileId}.
   * <ul>
   *   <li>When {@link AssetProfileId#AssetProfileId(UUID)} with id is
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbAssetProfileCache#get(TenantId, AssetProfileId)}
   */
  @Test
  @DisplayName("Test get(TenantId, AssetProfileId) with 'tenantId', 'assetProfileId'; when AssetProfileId(UUID) with id is 'null'; then return 'null'")
  void testGetWithTenantIdAssetProfileId_whenAssetProfileIdWithIdIsNull_thenReturnNull() {
    // Arrange
    when(assetProfileService.findAssetProfileById(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    AssetProfile actualGetResult = defaultTbAssetProfileCache.get(tenantId, new AssetProfileId(null));

    // Assert
    verify(assetProfileService).findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
    assertNull(actualGetResult);
  }

  /**
   * Test {@link DefaultTbAssetProfileCache#evict(TenantId, AssetProfileId)} with
   * {@code tenantId}, {@code profileId}.
   * <p>
   * Method under test:
   * {@link DefaultTbAssetProfileCache#evict(TenantId, AssetProfileId)}
   */
  @Test
  @DisplayName("Test evict(TenantId, AssetProfileId) with 'tenantId', 'profileId'")
  void testEvictWithTenantIdProfileId() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setTenantId(new TenantId(UUID.randomUUID()));
    when(assetProfileService.findAssetProfileById(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(assetProfile);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    defaultTbAssetProfileCache.evict(tenantId, new AssetProfileId(UUID.randomUUID()));

    // Assert
    verify(assetProfileService).findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
  }

  /**
   * Test {@link DefaultTbAssetProfileCache#evict(TenantId, AssetProfileId)} with
   * {@code tenantId}, {@code profileId}.
   * <p>
   * Method under test:
   * {@link DefaultTbAssetProfileCache#evict(TenantId, AssetProfileId)}
   */
  @Test
  @DisplayName("Test evict(TenantId, AssetProfileId) with 'tenantId', 'profileId'")
  void testEvictWithTenantIdProfileId2() {
    // Arrange
    when(assetProfileService.findAssetProfileById(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    defaultTbAssetProfileCache.evict(tenantId, new AssetProfileId(UUID.randomUUID()));

    // Assert
    verify(assetProfileService).findAssetProfileById(isA(TenantId.class), isA(AssetProfileId.class));
  }

  /**
   * Test {@link DefaultTbAssetProfileCache#find(AssetProfileId)}.
   * <ul>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbAssetProfileCache#find(AssetProfileId)}
   */
  @Test
  @DisplayName("Test find(AssetProfileId); then return AssetProfile()")
  void testFind_thenReturnAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    when(assetProfileService.findAssetProfileById(Mockito.<TenantId>any(), Mockito.<AssetProfileId>any()))
        .thenReturn(assetProfile);

    // Act
    AssetProfile actualFindResult = defaultTbAssetProfileCache.find(null);

    // Assert
    verify(assetProfileService).findAssetProfileById(isA(TenantId.class), isNull());
    assertSame(assetProfile, actualFindResult);
  }

  /**
   * Test
   * {@link DefaultTbAssetProfileCache#findOrCreateAssetProfile(TenantId, String)}.
   * <p>
   * Method under test:
   * {@link DefaultTbAssetProfileCache#findOrCreateAssetProfile(TenantId, String)}
   */
  @Test
  @DisplayName("Test findOrCreateAssetProfile(TenantId, String)")
  void testFindOrCreateAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    when(assetProfileService.findOrCreateAssetProfile(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(assetProfile);

    // Act
    AssetProfile actualFindOrCreateAssetProfileResult = defaultTbAssetProfileCache
        .findOrCreateAssetProfile(new TenantId(UUID.randomUUID()), "foo.txt");

    // Assert
    verify(assetProfileService).findOrCreateAssetProfile(isA(TenantId.class), eq("foo.txt"));
    assertSame(assetProfile, actualFindOrCreateAssetProfileResult);
  }
}
