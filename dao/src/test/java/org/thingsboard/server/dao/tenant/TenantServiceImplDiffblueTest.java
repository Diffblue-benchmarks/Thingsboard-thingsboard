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
package org.thingsboard.server.dao.tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantInfo;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.mobile.MobileAppSettingsService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.notification.NotificationSettingsService;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;
import org.thingsboard.server.dao.service.validator.TenantDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateService;
import org.thingsboard.server.dao.user.UserService;

@ContextConfiguration(classes = {TenantServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class TenantServiceImplDiffblueTest {
  @MockBean private AdminSettingsService adminSettingsService;

  @MockBean private ApiUsageStateService apiUsageStateService;

  @MockBean private AssetProfileService assetProfileService;

  @MockBean private CleanUpService cleanUpService;

  @MockBean private DeviceProfileService deviceProfileService;

  @MockBean private MobileAppSettingsService mobileAppSettingsService;

  @MockBean private NotificationSettingsService notificationSettingsService;

  @MockBean private TbTransactionalCache<TenantId, Tenant> tbTransactionalCache;

  @MockBean private TbTransactionalCache<TenantId, Boolean> tbTransactionalCache2;

  @MockBean private TenantDao tenantDao;

  @MockBean private TenantDataValidator tenantDataValidator;

  @MockBean private TenantProfileService tenantProfileService;

  @Autowired private TenantServiceImpl tenantServiceImpl;

  @MockBean private UserService userService;

  /**
   * Test {@link TenantServiceImpl#handleEvictEvent(TenantEvictEvent)} with {@code
   * TenantEvictEvent}.
   *
   * <p>Method under test: {@link TenantServiceImpl#handleEvictEvent(TenantEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantServiceImpl.handleEvictEvent(TenantEvictEvent)"})
  public void testHandleEvictEventWithTenantEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());

    // Act
    tenantServiceImpl.handleEvictEvent(new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true));

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
    verify(tbTransactionalCache2).evict(isA(TenantId.class));
  }

  /**
   * Test {@link TenantServiceImpl#handleEvictEvent(TenantEvictEvent)} with {@code
   * TenantEvictEvent}.
   *
   * <ul>
   *   <li>Given {@link TbTransactionalCache}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#handleEvictEvent(TenantEvictEvent)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantServiceImpl.handleEvictEvent(TenantEvictEvent)"})
  public void testHandleEvictEventWithTenantEvictEvent_givenTbTransactionalCache() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());

    // Act
    tenantServiceImpl.handleEvictEvent(new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, false));

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
  }

  /**
   * Test {@link TenantServiceImpl#findTenantById(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link Tenant#Tenant()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenantById(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantServiceImpl.findTenantById(TenantId)"})
  public void testFindTenantById_whenSystem_tenant_thenReturnTenant() {
    // Arrange
    Tenant tenant = new Tenant();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantId>any(), Mockito.<Supplier<Tenant>>any(), anyBoolean()))
        .thenReturn(tenant);

    // Act
    Tenant actualFindTenantByIdResult =
        tenantServiceImpl.findTenantById(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    assertSame(tenant, actualFindTenantByIdResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantInfoById(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link TenantInfo#TenantInfo()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenantInfoById(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantInfo TenantServiceImpl.findTenantInfoById(TenantId)"})
  public void testFindTenantInfoById_whenSystem_tenant_thenReturnTenantInfo() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo();
    when(tenantDao.findTenantInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(tenantInfo);

    // Act
    TenantInfo actualFindTenantInfoByIdResult =
        tenantServiceImpl.findTenantInfoById(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantDao).findTenantInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(tenantInfo, actualFindTenantInfoByIdResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantByIdAsync(TenantId, TenantId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenantByIdAsync(TenantId, TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture TenantServiceImpl.findTenantByIdAsync(TenantId, TenantId)"})
  public void testFindTenantByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Tenant> createResult = SettableFuture.create();
    when(tenantDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Tenant> actualFindTenantByIdAsyncResult =
        tenantServiceImpl.findTenantByIdAsync(
            ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindTenantByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindTenantByIdAsyncResult);
  }

  /**
   * Test {@link TenantServiceImpl#saveTenant(Tenant, Consumer)} with {@code tenant}, {@code
   * defaultEntitiesCreator}.
   *
   * <p>Method under test: {@link TenantServiceImpl#saveTenant(Tenant, Consumer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantServiceImpl.saveTenant(Tenant, Consumer)"})
  public void testSaveTenantWithTenantDefaultEntitiesCreator() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    Tenant tenant = new Tenant();
    when(tenantDao.save(Mockito.<TenantId>any(), Mockito.<Tenant>any())).thenReturn(tenant);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));
    when(tenantDataValidator.validate(
            Mockito.<Tenant>any(), Mockito.<Function<Tenant, TenantId>>any()))
        .thenReturn(new Tenant());

    Tenant tenant2 = new Tenant(ModelConstants.SYSTEM_TENANT);
    tenant2.setTenantProfileId(null);

    // Act
    Tenant actualSaveTenantResult = tenantServiceImpl.saveTenant(tenant2, null);

    // Assert
    verify(tbTransactionalCache).evict((TenantId) isNull());
    verify(tenantDataValidator).validate(isA(Tenant.class), isA(Function.class));
    verify(tenantDao).save(isA(TenantId.class), isA(Tenant.class));
    verify(tenantProfileService).findOrCreateDefaultTenantProfile(isA(TenantId.class));
    assertEquals("Global", tenant2.getRegion());
    assertSame(tenant, actualSaveTenantResult);
  }

  /**
   * Test {@link TenantServiceImpl#saveTenant(Tenant, Consumer)} with {@code tenant}, {@code
   * defaultEntitiesCreator}.
   *
   * <p>Method under test: {@link TenantServiceImpl#saveTenant(Tenant, Consumer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantServiceImpl.saveTenant(Tenant, Consumer)"})
  public void testSaveTenantWithTenantDefaultEntitiesCreator2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    when(apiUsageStateService.createDefaultApiUsageState(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ApiUsageState());
    when(assetProfileService.createDefaultAssetProfile(Mockito.<TenantId>any()))
        .thenReturn(new AssetProfile());
    when(deviceProfileService.createDefaultDeviceProfile(Mockito.<TenantId>any()))
        .thenReturn(new DeviceProfile());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());
    doNothing()
        .when(notificationSettingsService)
        .createDefaultNotificationConfigs(Mockito.<TenantId>any());
    Tenant tenant = new Tenant();
    when(tenantDao.save(Mockito.<TenantId>any(), Mockito.<Tenant>any())).thenReturn(tenant);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));
    when(tenantDataValidator.validate(
            Mockito.<Tenant>any(), Mockito.<Function<Tenant, TenantId>>any()))
        .thenReturn(new Tenant());

    Tenant tenant2 = new Tenant((TenantId) null);
    tenant2.setTenantProfileId(null);

    // Act
    Tenant actualSaveTenantResult = tenantServiceImpl.saveTenant(tenant2, null);

    // Assert
    verify(tbTransactionalCache).evict((TenantId) isNull());
    verify(tbTransactionalCache2).evict((TenantId) isNull());
    verify(assetProfileService).createDefaultAssetProfile(isNull());
    verify(deviceProfileService).createDefaultDeviceProfile(isNull());
    verify(notificationSettingsService).createDefaultNotificationConfigs(isNull());
    verify(tenantDataValidator).validate(isA(Tenant.class), isA(Function.class));
    verify(tenantDao).save(isNull(), isA(Tenant.class));
    verify(tenantProfileService).findOrCreateDefaultTenantProfile(isA(TenantId.class));
    verify(apiUsageStateService).createDefaultApiUsageState(isNull(), isNull());
    assertEquals("Global", tenant2.getRegion());
    assertSame(tenant, actualSaveTenantResult);
  }

  /**
   * Test {@link TenantServiceImpl#saveTenant(Tenant, Consumer)} with {@code tenant}, {@code
   * defaultEntitiesCreator}.
   *
   * <p>Method under test: {@link TenantServiceImpl#saveTenant(Tenant, Consumer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantServiceImpl.saveTenant(Tenant, Consumer)"})
  public void testSaveTenantWithTenantDefaultEntitiesCreator3() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    when(apiUsageStateService.createDefaultApiUsageState(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ApiUsageState());
    when(assetProfileService.createDefaultAssetProfile(Mockito.<TenantId>any()))
        .thenReturn(new AssetProfile());
    when(deviceProfileService.createDefaultDeviceProfile(Mockito.<TenantId>any()))
        .thenReturn(new DeviceProfile());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());
    doNothing()
        .when(notificationSettingsService)
        .createDefaultNotificationConfigs(Mockito.<TenantId>any());
    Tenant tenant = new Tenant();
    when(tenantDao.save(Mockito.<TenantId>any(), Mockito.<Tenant>any())).thenReturn(tenant);
    when(tenantDataValidator.validate(
            Mockito.<Tenant>any(), Mockito.<Function<Tenant, TenantId>>any()))
        .thenReturn(new Tenant());

    Tenant tenant2 = new Tenant((TenantId) null);
    tenant2.setTenantProfileId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Act
    Tenant actualSaveTenantResult = tenantServiceImpl.saveTenant(tenant2, null);

    // Assert
    verify(tbTransactionalCache).evict((TenantId) isNull());
    verify(tbTransactionalCache2).evict((TenantId) isNull());
    verify(assetProfileService).createDefaultAssetProfile(isNull());
    verify(deviceProfileService).createDefaultDeviceProfile(isNull());
    verify(notificationSettingsService).createDefaultNotificationConfigs(isNull());
    verify(tenantDataValidator).validate(isA(Tenant.class), isA(Function.class));
    verify(tenantDao).save(isNull(), isA(Tenant.class));
    verify(apiUsageStateService).createDefaultApiUsageState(isNull(), isNull());
    assertEquals("Global", tenant2.getRegion());
    assertSame(tenant, actualSaveTenantResult);
  }

  /**
   * Test {@link TenantServiceImpl#saveTenant(Tenant, Consumer)} with {@code tenant}, {@code
   * defaultEntitiesCreator}.
   *
   * <ul>
   *   <li>Then calls {@link Consumer#accept(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#saveTenant(Tenant, Consumer)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantServiceImpl.saveTenant(Tenant, Consumer)"})
  public void testSaveTenantWithTenantDefaultEntitiesCreator_thenCallsAccept() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    when(apiUsageStateService.createDefaultApiUsageState(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ApiUsageState());
    when(assetProfileService.createDefaultAssetProfile(Mockito.<TenantId>any()))
        .thenReturn(new AssetProfile());
    when(deviceProfileService.createDefaultDeviceProfile(Mockito.<TenantId>any()))
        .thenReturn(new DeviceProfile());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());
    doNothing()
        .when(notificationSettingsService)
        .createDefaultNotificationConfigs(Mockito.<TenantId>any());
    Tenant tenant = new Tenant();
    when(tenantDao.save(Mockito.<TenantId>any(), Mockito.<Tenant>any())).thenReturn(tenant);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));
    when(tenantDataValidator.validate(
            Mockito.<Tenant>any(), Mockito.<Function<Tenant, TenantId>>any()))
        .thenReturn(new Tenant());

    Tenant tenant2 = new Tenant((TenantId) null);
    tenant2.setTenantProfileId(null);

    Consumer<TenantId> defaultEntitiesCreator = mock(Consumer.class);
    doNothing().when(defaultEntitiesCreator).accept(Mockito.<TenantId>any());

    // Act
    Tenant actualSaveTenantResult = tenantServiceImpl.saveTenant(tenant2, defaultEntitiesCreator);

    // Assert
    verify(defaultEntitiesCreator).accept(isNull());
    verify(tbTransactionalCache).evict((TenantId) isNull());
    verify(tbTransactionalCache2).evict((TenantId) isNull());
    verify(assetProfileService).createDefaultAssetProfile(isNull());
    verify(deviceProfileService).createDefaultDeviceProfile(isNull());
    verify(notificationSettingsService).createDefaultNotificationConfigs(isNull());
    verify(tenantDataValidator).validate(isA(Tenant.class), isA(Function.class));
    verify(tenantDao).save(isNull(), isA(Tenant.class));
    verify(tenantProfileService).findOrCreateDefaultTenantProfile(isA(TenantId.class));
    verify(apiUsageStateService).createDefaultApiUsageState(isNull(), isNull());
    assertEquals("Global", tenant2.getRegion());
    assertSame(tenant, actualSaveTenantResult);
  }

  /**
   * Test {@link TenantServiceImpl#saveTenant(Tenant)} with {@code tenant}.
   *
   * <ul>
   *   <li>Then {@link Tenant#Tenant(TenantId)} with id is {@link ModelConstants#SYSTEM_TENANT}
   *       Region is {@code Global}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#saveTenant(Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantServiceImpl.saveTenant(Tenant)"})
  public void testSaveTenantWithTenant_thenTenantWithIdIsSystem_tenantRegionIsGlobal() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    Tenant tenant = new Tenant();
    when(tenantDao.save(Mockito.<TenantId>any(), Mockito.<Tenant>any())).thenReturn(tenant);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));
    when(tenantDataValidator.validate(
            Mockito.<Tenant>any(), Mockito.<Function<Tenant, TenantId>>any()))
        .thenReturn(new Tenant());
    Tenant tenant2 = new Tenant(ModelConstants.SYSTEM_TENANT);

    // Act
    Tenant actualSaveTenantResult = tenantServiceImpl.saveTenant(tenant2);

    // Assert
    verify(tbTransactionalCache).evict((TenantId) isNull());
    verify(tenantDataValidator).validate(isA(Tenant.class), isA(Function.class));
    verify(tenantDao).save(isA(TenantId.class), isA(Tenant.class));
    verify(tenantProfileService).findOrCreateDefaultTenantProfile(isA(TenantId.class));
    assertEquals("Global", tenant2.getRegion());
    assertSame(tenant, actualSaveTenantResult);
  }

  /**
   * Test {@link TenantServiceImpl#saveTenant(Tenant)} with {@code tenant}.
   *
   * <ul>
   *   <li>When {@link Tenant#Tenant()}.
   *   <li>Then {@link Tenant#Tenant()} Region is {@code Global}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#saveTenant(Tenant)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Tenant TenantServiceImpl.saveTenant(Tenant)"})
  public void testSaveTenantWithTenant_whenTenant_thenTenantRegionIsGlobal() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    when(apiUsageStateService.createDefaultApiUsageState(
            Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ApiUsageState());
    when(assetProfileService.createDefaultAssetProfile(Mockito.<TenantId>any()))
        .thenReturn(new AssetProfile());
    when(deviceProfileService.createDefaultDeviceProfile(Mockito.<TenantId>any()))
        .thenReturn(new DeviceProfile());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());
    doNothing()
        .when(notificationSettingsService)
        .createDefaultNotificationConfigs(Mockito.<TenantId>any());
    Tenant tenant = new Tenant();
    when(tenantDao.save(Mockito.<TenantId>any(), Mockito.<Tenant>any())).thenReturn(tenant);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));
    when(tenantDataValidator.validate(
            Mockito.<Tenant>any(), Mockito.<Function<Tenant, TenantId>>any()))
        .thenReturn(new Tenant());
    Tenant tenant2 = new Tenant();

    // Act
    Tenant actualSaveTenantResult = tenantServiceImpl.saveTenant(tenant2);

    // Assert
    verify(tbTransactionalCache).evict((TenantId) isNull());
    verify(tbTransactionalCache2).evict((TenantId) isNull());
    verify(assetProfileService).createDefaultAssetProfile(isNull());
    verify(deviceProfileService).createDefaultDeviceProfile(isNull());
    verify(notificationSettingsService).createDefaultNotificationConfigs(isNull());
    verify(tenantDataValidator).validate(isA(Tenant.class), isA(Function.class));
    verify(tenantDao).save(isNull(), isA(Tenant.class));
    verify(tenantProfileService).findOrCreateDefaultTenantProfile(isA(TenantId.class));
    verify(apiUsageStateService).createDefaultApiUsageState(isNull(), isNull());
    assertEquals("Global", tenant2.getRegion());
    assertSame(tenant, actualSaveTenantResult);
  }

  /**
   * Test {@link TenantServiceImpl#deleteTenant(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#deleteTenant(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantServiceImpl.deleteTenant(TenantId)"})
  public void testDeleteTenant_whenSystem_tenant_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantId>any(), Mockito.<Supplier<Tenant>>any(), anyBoolean()))
        .thenReturn(new Tenant());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing()
        .when(cleanUpService)
        .removeTenantEntities(Mockito.<TenantId>any(), isA(EntityType[].class));
    doNothing().when(adminSettingsService).deleteAdminSettingsByTenantId(Mockito.<TenantId>any());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());
    doNothing().when(mobileAppSettingsService).deleteByTenantId(Mockito.<TenantId>any());
    doNothing()
        .when(notificationSettingsService)
        .deleteNotificationSettings(Mockito.<TenantId>any());
    doNothing().when(tenantDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(userService).deleteAllByTenantId(Mockito.<TenantId>any());

    // Act
    tenantServiceImpl.deleteTenant(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
    verify(tbTransactionalCache2).evict(isA(TenantId.class));
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(tenantDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(cleanUpService).removeTenantEntities(isA(TenantId.class), isA(EntityType[].class));
    verify(mobileAppSettingsService).deleteByTenantId(isA(TenantId.class));
    verify(notificationSettingsService).deleteNotificationSettings(isA(TenantId.class));
    verify(adminSettingsService).deleteAdminSettingsByTenantId(isA(TenantId.class));
    verify(userService).deleteAllByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link TenantServiceImpl#findTenants(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenants(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantServiceImpl.findTenants(PageLink)"})
  public void testFindTenants_givenBy_created_time_desc_thenCallsGetPage() {
    // Arrange
    PageData<Tenant> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenants(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Tenant> actualFindTenantsResult = tenantServiceImpl.findTenants(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantDao).findTenants(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenants(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenants(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantServiceImpl.findTenants(PageLink)"})
  public void testFindTenants_givenSortOrderGetPropertyReturnEmptyString_thenCallsGetProperty() {
    // Arrange
    PageData<Tenant> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenants(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Tenant> actualFindTenantsResult = tenantServiceImpl.findTenants(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(tenantDao).findTenants(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenants(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenants(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantServiceImpl.findTenants(PageLink)"})
  public void testFindTenants_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Tenant> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenants(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Tenant> actualFindTenantsResult =
        tenantServiceImpl.findTenants(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantDao).findTenants(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantInfos(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenantInfos(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantServiceImpl.findTenantInfos(PageLink)"})
  public void testFindTenantInfos_givenBy_created_time_desc_thenCallsGetPage() {
    // Arrange
    PageData<TenantInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult = tenantServiceImpl.findTenantInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantDao).findTenantInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantInfosResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantInfos(PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenantInfos(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantServiceImpl.findTenantInfos(PageLink)"})
  public void testFindTenantInfos_thenCallsGetProperty() {
    // Arrange
    PageData<TenantInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult = tenantServiceImpl.findTenantInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(tenantDao).findTenantInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantInfosResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantInfos(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenantInfos(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantServiceImpl.findTenantInfos(PageLink)"})
  public void testFindTenantInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TenantInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult =
        tenantServiceImpl.findTenantInfos(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantDao).findTenantInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantInfosResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantIdsByTenantProfileId(TenantProfileId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List TenantServiceImpl.findTenantIdsByTenantProfileId(TenantProfileId)"})
  public void testFindTenantIdsByTenantProfileId_thenReturnEmpty() {
    // Arrange
    when(tenantDao.findTenantIdsByTenantProfileId(Mockito.<TenantProfileId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult =
        tenantServiceImpl.findTenantIdsByTenantProfileId(null);

    // Assert
    verify(tenantDao).findTenantIdsByTenantProfileId(isNull());
    assertTrue(actualFindTenantIdsByTenantProfileIdResult.isEmpty());
  }

  /**
   * Test {@link TenantServiceImpl#deleteTenants()}.
   *
   * <ul>
   *   <li>Then calls {@link TenantDao#findTenants(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#deleteTenants()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantServiceImpl.deleteTenants()"})
  public void testDeleteTenants_thenCallsFindTenants() {
    // Arrange
    PageData<Tenant> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenants(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    tenantServiceImpl.deleteTenants();

    // Assert
    verify(tenantDao).findTenants(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link TenantServiceImpl#findTenantsIds(PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenantsIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantServiceImpl.findTenantsIds(PageLink)"})
  public void testFindTenantsIds_givenBy_created_time_desc_thenCallsGetPage() {
    // Arrange
    PageData<TenantId> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantsIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = tenantServiceImpl.findTenantsIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantDao).findTenantsIds(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantsIdsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantsIds(PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenantsIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantServiceImpl.findTenantsIds(PageLink)"})
  public void testFindTenantsIds_thenCallsGetProperty() {
    // Arrange
    PageData<TenantId> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantsIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = tenantServiceImpl.findTenantsIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(tenantDao).findTenantsIds(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantsIdsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantsIds(PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findTenantsIds(PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData TenantServiceImpl.findTenantsIds(PageLink)"})
  public void testFindTenantsIds_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TenantId> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantsIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<TenantId> actualFindTenantsIdsResult =
        tenantServiceImpl.findTenantsIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantDao).findTenantsIds(isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantsIdsResult);
  }

  /**
   * Test {@link TenantServiceImpl#tenantExists(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#tenantExists(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantServiceImpl.tenantExists(TenantId)"})
  public void testTenantExists_thenReturnFalse() {
    // Arrange
    when(tbTransactionalCache2.getAndPutInTransaction(
            Mockito.<TenantId>any(), Mockito.<Supplier<Boolean>>any(), anyBoolean()))
        .thenReturn(false);

    // Act
    boolean actualTenantExistsResult = tenantServiceImpl.tenantExists(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache2)
        .getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(false));
    assertFalse(actualTenantExistsResult);
  }

  /**
   * Test {@link TenantServiceImpl#tenantExists(TenantId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#tenantExists(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TenantServiceImpl.tenantExists(TenantId)"})
  public void testTenantExists_thenReturnTrue() {
    // Arrange
    when(tbTransactionalCache2.getAndPutInTransaction(
            Mockito.<TenantId>any(), Mockito.<Supplier<Boolean>>any(), anyBoolean()))
        .thenReturn(true);

    // Act
    boolean actualTenantExistsResult = tenantServiceImpl.tenantExists(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache2)
        .getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(false));
    assertTrue(actualTenantExistsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link TenantServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional TenantServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Tenant tenant = new Tenant();
    when(tbTransactionalCache.getAndPutInTransaction(
            Mockito.<TenantId>any(), Mockito.<Supplier<Tenant>>any(), anyBoolean()))
        .thenReturn(tenant);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        tenantServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache)
        .getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(tenant, actualFindEntityResult.get());
  }

  /**
   * Test {@link TenantServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link TenantServiceImpl#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType TenantServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.TENANT, new TenantServiceImpl().getEntityType());
  }
}
