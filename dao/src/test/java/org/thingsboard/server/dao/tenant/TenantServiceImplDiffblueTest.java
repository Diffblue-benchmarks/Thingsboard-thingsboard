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
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.cache.TbTransactionalCache;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantInfo;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.device.DeviceProfileService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.mobile.MobileAppSettingsService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.notification.NotificationSettingsService;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.validator.TenantDataValidator;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.dao.usagerecord.ApiUsageStateService;
import org.thingsboard.server.dao.user.UserService;

@ContextConfiguration(classes = {TenantServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class TenantServiceImplDiffblueTest {
  @MockBean
  private AdminSettingsService adminSettingsService;

  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApiUsageStateService apiUsageStateService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private AssetProfileService assetProfileService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DeviceProfileService deviceProfileService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private MobileAppSettingsService mobileAppSettingsService;

  @MockBean
  private NotificationSettingsService notificationSettingsService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTransactionalCache<TenantId, Tenant> tbTransactionalCache;

  @MockBean
  private TbTransactionalCache<TenantId, Boolean> tbTransactionalCache2;

  @MockBean
  private TenantDao tenantDao;

  @MockBean
  private TenantDataValidator tenantDataValidator;

  @MockBean
  private TenantProfileService tenantProfileService;

  @Autowired
  private TenantServiceImpl tenantServiceImpl;

  @MockBean
  private UserService userService;

  /**
   * Test {@link TenantServiceImpl#handleEvictEvent(TenantEvictEvent)} with
   * {@code TenantEvictEvent}.
   * <p>
   * Method under test:
   * {@link TenantServiceImpl#handleEvictEvent(TenantEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithTenantEvictEvent() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());

    // Act
    tenantServiceImpl.handleEvictEvent(new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict(isA(TenantId.class));
    verify(tbTransactionalCache2).evict(isA(TenantId.class));
  }

  /**
   * Test {@link TenantServiceImpl#handleEvictEvent(TenantEvictEvent)} with
   * {@code TenantEvictEvent}.
   * <p>
   * Method under test:
   * {@link TenantServiceImpl#handleEvictEvent(TenantEvictEvent)}
   */
  @Test
  public void testHandleEvictEventWithTenantEvictEvent2() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());

    // Act
    tenantServiceImpl.handleEvictEvent(new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, false));

    // Assert that nothing has changed
    verify(tbTransactionalCache).evict(isA(TenantId.class));
  }

  /**
   * Test {@link TenantServiceImpl#findTenantById(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link Tenant#Tenant()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenantById(TenantId)}
   */
  @Test
  public void testFindTenantById_whenSystem_tenant_thenReturnTenant() {
    // Arrange
    Tenant tenant = new Tenant();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<Tenant>>any(),
        anyBoolean())).thenReturn(tenant);

    // Act
    Tenant actualFindTenantByIdResult = tenantServiceImpl.findTenantById(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    assertSame(tenant, actualFindTenantByIdResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantInfoById(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link TenantInfo#TenantInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenantInfoById(TenantId)}
   */
  @Test
  public void testFindTenantInfoById_whenSystem_tenant_thenReturnTenantInfo() {
    // Arrange
    TenantInfo tenantInfo = new TenantInfo();
    when(tenantDao.findTenantInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tenantInfo);

    // Act
    TenantInfo actualFindTenantInfoByIdResult = tenantServiceImpl.findTenantInfoById(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantDao).findTenantInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(tenantInfo, actualFindTenantInfoByIdResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantByIdAsync(TenantId, TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantServiceImpl#findTenantByIdAsync(TenantId, TenantId)}
   */
  @Test
  public void testFindTenantByIdAsync_whenSystem_tenant_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Tenant> createResult = SettableFuture.create();
    when(tenantDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Tenant> actualFindTenantByIdAsyncResult = tenantServiceImpl
        .findTenantByIdAsync(ModelConstants.SYSTEM_TENANT, ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tenantDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindTenantByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindTenantByIdAsyncResult);
  }

  /**
   * Test {@link TenantServiceImpl#saveTenant(Tenant, Consumer)} with
   * {@code tenant}, {@code defaultEntitiesCreator}.
   * <p>
   * Method under test: {@link TenantServiceImpl#saveTenant(Tenant, Consumer)}
   */
  @Test
  public void testSaveTenantWithTenantDefaultEntitiesCreator() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());

    Tenant tenant = new Tenant();
    tenant.setId(ModelConstants.SYSTEM_TENANT);
    when(tenantDao.save(Mockito.<TenantId>any(), Mockito.<Tenant>any())).thenReturn(tenant);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(new TenantProfile());
    when(tenantDataValidator.validate(Mockito.<Tenant>any(), Mockito.<Function<Tenant, TenantId>>any()))
        .thenReturn(new Tenant());
    Tenant tenant2 = new Tenant(ModelConstants.SYSTEM_TENANT);

    // Act
    Tenant actualSaveTenantResult = tenantServiceImpl.saveTenant(tenant2, tenantServiceImpl::deleteTenant);

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
    verify(tenantDataValidator).validate(isA(Tenant.class), isA(Function.class));
    verify(tenantDao).save(isA(TenantId.class), isA(Tenant.class));
    verify(tenantProfileService).findOrCreateDefaultTenantProfile(isA(TenantId.class));
    assertEquals("Global", tenant2.getRegion());
    assertSame(tenant, actualSaveTenantResult);
  }

  /**
   * Test {@link TenantServiceImpl#saveTenant(Tenant, Consumer)} with
   * {@code tenant}, {@code defaultEntitiesCreator}.
   * <ul>
   *   <li>Then {@link Tenant#Tenant()} Region is {@code Global}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#saveTenant(Tenant, Consumer)}
   */
  @Test
  public void testSaveTenantWithTenantDefaultEntitiesCreator_thenTenantRegionIsGlobal() {
    // Arrange
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<Tenant>>any(),
        anyBoolean())).thenReturn(new Tenant());
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(cleanUpService).removeTenantEntities(Mockito.<TenantId>any(), isA(EntityType[].class));
    doNothing().when(adminSettingsService).deleteAdminSettingsByTenantId(Mockito.<TenantId>any());
    when(apiUsageStateService.createDefaultApiUsageState(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ApiUsageState());
    when(assetProfileService.createDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(new AssetProfile());
    when(deviceProfileService.createDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(new DeviceProfile());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());
    doNothing().when(mobileAppSettingsService).deleteByTenantId(Mockito.<TenantId>any());
    doNothing().when(notificationSettingsService).createDefaultNotificationConfigs(Mockito.<TenantId>any());
    doNothing().when(notificationSettingsService).deleteNotificationSettings(Mockito.<TenantId>any());

    Tenant tenant = new Tenant();
    tenant.setId(ModelConstants.SYSTEM_TENANT);
    doNothing().when(tenantDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(tenantDao.save(Mockito.<TenantId>any(), Mockito.<Tenant>any())).thenReturn(tenant);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(new TenantProfile());
    when(tenantDataValidator.validate(Mockito.<Tenant>any(), Mockito.<Function<Tenant, TenantId>>any()))
        .thenReturn(new Tenant());
    doNothing().when(userService).deleteAllByTenantId(Mockito.<TenantId>any());
    Tenant tenant2 = new Tenant();

    // Act
    Tenant actualSaveTenantResult = tenantServiceImpl.saveTenant(tenant2, tenantServiceImpl::deleteTenant);

    // Assert
    verify(tbTransactionalCache, atLeast(1)).evict(isA(TenantId.class));
    verify(tbTransactionalCache2, atLeast(1)).evict(isA(TenantId.class));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    verify(tenantDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileService).createDefaultAssetProfile(isA(TenantId.class));
    verify(deviceProfileService).createDefaultDeviceProfile(isA(TenantId.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(cleanUpService).removeTenantEntities(isA(TenantId.class), isA(EntityType[].class));
    verify(mobileAppSettingsService).deleteByTenantId(isA(TenantId.class));
    verify(notificationSettingsService).createDefaultNotificationConfigs(isA(TenantId.class));
    verify(notificationSettingsService).deleteNotificationSettings(isA(TenantId.class));
    verify(tenantDataValidator).validate(isA(Tenant.class), isA(Function.class));
    verify(adminSettingsService).deleteAdminSettingsByTenantId(isA(TenantId.class));
    verify(tenantDao).save(isNull(), isA(Tenant.class));
    verify(tenantProfileService).findOrCreateDefaultTenantProfile(isA(TenantId.class));
    verify(apiUsageStateService).createDefaultApiUsageState(isA(TenantId.class), isNull());
    verify(userService).deleteAllByTenantId(isA(TenantId.class));
    assertEquals("Global", tenant2.getRegion());
    assertSame(tenant, actualSaveTenantResult);
  }

  /**
   * Test {@link TenantServiceImpl#saveTenant(Tenant)} with {@code tenant}.
   * <ul>
   *   <li>Then {@link Tenant#Tenant(TenantId)} with id is
   * {@link ModelConstants#SYSTEM_TENANT} Region is {@code Global}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#saveTenant(Tenant)}
   */
  @Test
  public void testSaveTenantWithTenant_thenTenantWithIdIsSystem_tenantRegionIsGlobal() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());
    Tenant tenant = new Tenant();
    when(tenantDao.save(Mockito.<TenantId>any(), Mockito.<Tenant>any())).thenReturn(tenant);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(new TenantProfile());
    when(tenantDataValidator.validate(Mockito.<Tenant>any(), Mockito.<Function<Tenant, TenantId>>any()))
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
   * <ul>
   *   <li>When {@link Tenant#Tenant()}.</li>
   *   <li>Then {@link Tenant#Tenant()} Region is {@code Global}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#saveTenant(Tenant)}
   */
  @Test
  public void testSaveTenantWithTenant_whenTenant_thenTenantRegionIsGlobal() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    when(apiUsageStateService.createDefaultApiUsageState(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ApiUsageState());
    when(assetProfileService.createDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(new AssetProfile());
    when(deviceProfileService.createDefaultDeviceProfile(Mockito.<TenantId>any())).thenReturn(new DeviceProfile());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());
    doNothing().when(notificationSettingsService).createDefaultNotificationConfigs(Mockito.<TenantId>any());
    Tenant tenant = new Tenant();
    when(tenantDao.save(Mockito.<TenantId>any(), Mockito.<Tenant>any())).thenReturn(tenant);
    when(tenantProfileService.findOrCreateDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(new TenantProfile());
    when(tenantDataValidator.validate(Mockito.<Tenant>any(), Mockito.<Function<Tenant, TenantId>>any()))
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
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link TbTransactionalCache#evict(Serializable)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#deleteTenant(TenantId)}
   */
  @Test
  public void testDeleteTenant_whenSystem_tenant_thenCallsEvict() {
    // Arrange
    doNothing().when(tbTransactionalCache).evict(Mockito.<TenantId>any());
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<Tenant>>any(),
        anyBoolean())).thenReturn(new Tenant());
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(cleanUpService).removeTenantEntities(Mockito.<TenantId>any(), isA(EntityType[].class));
    doNothing().when(adminSettingsService).deleteAdminSettingsByTenantId(Mockito.<TenantId>any());
    doNothing().when(tbTransactionalCache2).evict(Mockito.<TenantId>any());
    doNothing().when(mobileAppSettingsService).deleteByTenantId(Mockito.<TenantId>any());
    doNothing().when(notificationSettingsService).deleteNotificationSettings(Mockito.<TenantId>any());
    doNothing().when(tenantDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    doNothing().when(userService).deleteAllByTenantId(Mockito.<TenantId>any());

    // Act
    tenantServiceImpl.deleteTenant(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache).evict(isA(TenantId.class));
    verify(tbTransactionalCache2).evict(isA(TenantId.class));
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
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
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenants(PageLink)}
   */
  @Test
  public void testFindTenants_givenSortOrderWithPropertyAndDirectionIsAsc_thenCallsGetPage() {
    // Arrange
    PageData<Tenant> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenants(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Tenant> actualFindTenantsResult = tenantServiceImpl.findTenants(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantDao).findTenants(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantsResult.EMPTY_PAGE_DATA, actualFindTenantsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenants(PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is empty string and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenants(PageLink)}
   */
  @Test
  public void testFindTenants_givenSortOrderWithPropertyIsEmptyStringAndDirectionIsAsc() {
    // Arrange
    PageData<Tenant> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenants(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Tenant> actualFindTenantsResult = tenantServiceImpl.findTenants(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantDao).findTenants(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantsResult.EMPTY_PAGE_DATA, actualFindTenantsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenants(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenants(PageLink)}
   */
  @Test
  public void testFindTenants_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Tenant> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenants(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<Tenant> actualFindTenantsResult = tenantServiceImpl.findTenants(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantDao).findTenants(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantsResult.EMPTY_PAGE_DATA, actualFindTenantsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantInfos(PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenantInfos(PageLink)}
   */
  @Test
  public void testFindTenantInfos_givenSortOrderWithPropertyAndDirectionIsAsc_thenCallsGetPage() {
    // Arrange
    PageData<TenantInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult = tenantServiceImpl.findTenantInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantDao).findTenantInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantInfosResult.EMPTY_PAGE_DATA, actualFindTenantInfosResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantInfos(PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is empty string and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenantInfos(PageLink)}
   */
  @Test
  public void testFindTenantInfos_givenSortOrderWithPropertyIsEmptyStringAndDirectionIsAsc() {
    // Arrange
    PageData<TenantInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult = tenantServiceImpl.findTenantInfos(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantDao).findTenantInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantInfosResult.EMPTY_PAGE_DATA, actualFindTenantInfosResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantInfos(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenantInfos(PageLink)}
   */
  @Test
  public void testFindTenantInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TenantInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<TenantInfo> actualFindTenantInfosResult = tenantServiceImpl
        .findTenantInfos(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantDao).findTenantInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindTenantInfosResult.EMPTY_PAGE_DATA, actualFindTenantInfosResult);
  }

  /**
   * Test
   * {@link TenantServiceImpl#findTenantIdsByTenantProfileId(TenantProfileId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantServiceImpl#findTenantIdsByTenantProfileId(TenantProfileId)}
   */
  @Test
  public void testFindTenantIdsByTenantProfileId_thenReturnEmpty() {
    // Arrange
    when(tenantDao.findTenantIdsByTenantProfileId(Mockito.<TenantProfileId>any())).thenReturn(new ArrayList<>());

    // Act
    List<TenantId> actualFindTenantIdsByTenantProfileIdResult = tenantServiceImpl.findTenantIdsByTenantProfileId(null);

    // Assert
    verify(tenantDao).findTenantIdsByTenantProfileId(isNull());
    assertTrue(actualFindTenantIdsByTenantProfileIdResult.isEmpty());
  }

  /**
   * Test {@link TenantServiceImpl#deleteTenants()}.
   * <ul>
   *   <li>Then calls {@link TenantDao#findTenants(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#deleteTenants()}
   */
  @Test
  public void testDeleteTenants_thenCallsFindTenants() {
    // Arrange
    PageData<Tenant> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenants(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    tenantServiceImpl.deleteTenants();

    // Assert
    verify(tenantDao).findTenants(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link TenantServiceImpl#findTenantsIds(PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenantsIds(PageLink)}
   */
  @Test
  public void testFindTenantsIds_givenSortOrderWithPropertyAndDirectionIsAsc_thenCallsGetPage() {
    // Arrange
    PageData<TenantId> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantsIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = tenantServiceImpl.findTenantsIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantDao).findTenantsIds(isA(PageLink.class));
    assertSame(actualFindTenantsIdsResult.EMPTY_PAGE_DATA, actualFindTenantsIdsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantsIds(PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is empty string and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenantsIds(PageLink)}
   */
  @Test
  public void testFindTenantsIds_givenSortOrderWithPropertyIsEmptyStringAndDirectionIsAsc() {
    // Arrange
    PageData<TenantId> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantsIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = tenantServiceImpl.findTenantsIds(pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(tenantDao).findTenantsIds(isA(PageLink.class));
    assertSame(actualFindTenantsIdsResult.EMPTY_PAGE_DATA, actualFindTenantsIdsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findTenantsIds(PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findTenantsIds(PageLink)}
   */
  @Test
  public void testFindTenantsIds_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TenantId> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantsIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<TenantId> actualFindTenantsIdsResult = tenantServiceImpl
        .findTenantsIds(BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantDao).findTenantsIds(isA(PageLink.class));
    assertSame(actualFindTenantsIdsResult.EMPTY_PAGE_DATA, actualFindTenantsIdsResult);
  }

  /**
   * Test {@link TenantServiceImpl#tenantExists(TenantId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#tenantExists(TenantId)}
   */
  @Test
  public void testTenantExists_thenReturnFalse() {
    // Arrange
    when(tbTransactionalCache2.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<Boolean>>any(),
        anyBoolean())).thenReturn(false);

    // Act
    boolean actualTenantExistsResult = tenantServiceImpl.tenantExists(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache2).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(false));
    assertFalse(actualTenantExistsResult);
  }

  /**
   * Test {@link TenantServiceImpl#tenantExists(TenantId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#tenantExists(TenantId)}
   */
  @Test
  public void testTenantExists_thenReturnTrue() {
    // Arrange
    when(tbTransactionalCache2.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<Boolean>>any(),
        anyBoolean())).thenReturn(true);

    // Act
    boolean actualTenantExistsResult = tenantServiceImpl.tenantExists(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(tbTransactionalCache2).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(false));
    assertTrue(actualTenantExistsResult);
  }

  /**
   * Test {@link TenantServiceImpl#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Tenant tenant = new Tenant();
    when(tbTransactionalCache.getAndPutInTransaction(Mockito.<TenantId>any(), Mockito.<Supplier<Tenant>>any(),
        anyBoolean())).thenReturn(tenant);

    // Act
    Optional<HasId<?>> actualFindEntityResult = tenantServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(tbTransactionalCache).getAndPutInTransaction(isA(TenantId.class), isA(Supplier.class), eq(true));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(tenant, actualFindEntityResult.get());
  }

  /**
   * Test {@link TenantServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link TenantServiceImpl#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.TENANT, (new TenantServiceImpl()).getEntityType());
  }
}
