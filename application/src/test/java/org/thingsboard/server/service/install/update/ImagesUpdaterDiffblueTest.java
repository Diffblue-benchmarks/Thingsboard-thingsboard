package org.thingsboard.server.service.install.update;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.dao.asset.AssetProfileDao;
import org.thingsboard.server.dao.dashboard.DashboardDao;
import org.thingsboard.server.dao.device.DeviceProfileDao;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.tenant.TenantDao;
import org.thingsboard.server.dao.widget.WidgetTypeDao;
import org.thingsboard.server.dao.widget.WidgetsBundleDao;

@ContextConfiguration(classes = {ImagesUpdater.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ImagesUpdaterDiffblueTest {
  @MockBean
  private AssetProfileDao assetProfileDao;

  @MockBean
  private DashboardDao dashboardDao;

  @MockBean
  private DeviceProfileDao deviceProfileDao;

  @MockBean
  private ImageService imageService;

  @Autowired
  private ImagesUpdater imagesUpdater;

  @MockBean
  private TenantDao tenantDao;

  @MockBean
  private WidgetTypeDao widgetTypeDao;

  @MockBean
  private WidgetsBundleDao widgetsBundleDao;

  /**
   * Test {@link ImagesUpdater#updateWidgetsBundlesImages()}.
   * <ul>
   *   <li>Given {@link ImageService}.</li>
   *   <li>Then calls {@link WidgetsBundleDao#findAllWidgetsBundles(PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImagesUpdater#updateWidgetsBundlesImages()}
   */
  @Test
  @DisplayName("Test updateWidgetsBundlesImages(); given ImageService; then calls findAllWidgetsBundles(PageLink)")
  void testUpdateWidgetsBundlesImages_givenImageService_thenCallsFindAllWidgetsBundles() {
    // Arrange
    PageData<WidgetsBundle> emptyPageDataResult = PageData.emptyPageData();
    when(widgetsBundleDao.findAllWidgetsBundles(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    imagesUpdater.updateWidgetsBundlesImages();

    // Assert
    verify(widgetsBundleDao).findAllWidgetsBundles(isA(PageLink.class));
  }

  /**
   * Test {@link ImagesUpdater#updateWidgetTypesImages()}.
   * <ul>
   *   <li>Given {@link ImageService}.</li>
   *   <li>Then calls {@link WidgetTypeDao#findAllWidgetTypesIds(PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImagesUpdater#updateWidgetTypesImages()}
   */
  @Test
  @DisplayName("Test updateWidgetTypesImages(); given ImageService; then calls findAllWidgetTypesIds(PageLink)")
  void testUpdateWidgetTypesImages_givenImageService_thenCallsFindAllWidgetTypesIds() {
    // Arrange
    PageData<WidgetTypeId> emptyPageDataResult = PageData.emptyPageData();
    when(widgetTypeDao.findAllWidgetTypesIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    imagesUpdater.updateWidgetTypesImages();

    // Assert
    verify(widgetTypeDao).findAllWidgetTypesIds(isA(PageLink.class));
  }

  /**
   * Test {@link ImagesUpdater#updateDashboardsImages()}.
   * <ul>
   *   <li>Then calls {@link TenantDao#findTenantsIds(PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImagesUpdater#updateDashboardsImages()}
   */
  @Test
  @DisplayName("Test updateDashboardsImages(); then calls findTenantsIds(PageLink)")
  void testUpdateDashboardsImages_thenCallsFindTenantsIds() {
    // Arrange
    PageData<TenantId> emptyPageDataResult = PageData.emptyPageData();
    when(tenantDao.findTenantsIds(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    imagesUpdater.updateDashboardsImages();

    // Assert
    verify(tenantDao).findTenantsIds(isA(PageLink.class));
  }

  /**
   * Test {@link ImagesUpdater#createSystemImages(Dashboard)}.
   * <p>
   * Method under test: {@link ImagesUpdater#createSystemImages(Dashboard)}
   */
  @Test
  @DisplayName("Test createSystemImages(Dashboard)")
  void testCreateSystemImages() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(true);
    Dashboard defaultDashboard = new Dashboard();

    // Act
    imagesUpdater.createSystemImages(defaultDashboard);

    // Assert
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    TenantId tenantId = defaultDashboard.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link ImagesUpdater#createSystemImages(Dashboard)}.
   * <ul>
   *   <li>Given {@link ImageService}
   * {@link ImageService#replaceBase64WithImageUrl(Dashboard)} return
   * {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImagesUpdater#createSystemImages(Dashboard)}
   */
  @Test
  @DisplayName("Test createSystemImages(Dashboard); given ImageService replaceBase64WithImageUrl(Dashboard) return 'false'")
  void testCreateSystemImages_givenImageServiceReplaceBase64WithImageUrlReturnFalse() {
    // Arrange
    when(imageService.replaceBase64WithImageUrl(Mockito.<Dashboard>any())).thenReturn(false);
    Dashboard defaultDashboard = new Dashboard();

    // Act
    imagesUpdater.createSystemImages(defaultDashboard);

    // Assert
    verify(imageService).replaceBase64WithImageUrl(isA(Dashboard.class));
    TenantId tenantId = defaultDashboard.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link ImagesUpdater#updateDeviceProfilesImages()}.
   * <ul>
   *   <li>Given {@link ImageService}.</li>
   *   <li>Then calls {@link DeviceProfileDao#findAllWithImages(PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImagesUpdater#updateDeviceProfilesImages()}
   */
  @Test
  @DisplayName("Test updateDeviceProfilesImages(); given ImageService; then calls findAllWithImages(PageLink)")
  void testUpdateDeviceProfilesImages_givenImageService_thenCallsFindAllWithImages() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findAllWithImages(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    imagesUpdater.updateDeviceProfilesImages();

    // Assert
    verify(deviceProfileDao).findAllWithImages(isA(PageLink.class));
  }

  /**
   * Test {@link ImagesUpdater#updateAssetProfilesImages()}.
   * <ul>
   *   <li>Given {@link ImageService}.</li>
   *   <li>Then calls {@link AssetProfileDao#findAllWithImages(PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImagesUpdater#updateAssetProfilesImages()}
   */
  @Test
  @DisplayName("Test updateAssetProfilesImages(); given ImageService; then calls findAllWithImages(PageLink)")
  void testUpdateAssetProfilesImages_givenImageService_thenCallsFindAllWithImages() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAllWithImages(Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    imagesUpdater.updateAssetProfilesImages();

    // Assert
    verify(assetProfileDao).findAllWithImages(isA(PageLink.class));
  }
}
