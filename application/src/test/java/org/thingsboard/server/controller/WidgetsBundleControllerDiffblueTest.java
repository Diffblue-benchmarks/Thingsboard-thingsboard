package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.resource.BaseImageService;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;
import org.thingsboard.server.dao.widget.WidgetTypeServiceImpl;
import org.thingsboard.server.dao.widget.WidgetsBundleServiceImpl;
import org.thingsboard.server.service.entitiy.widgets.bundle.DefaultWidgetsBundleService;

class WidgetsBundleControllerDiffblueTest {
  /**
   * Test {@link WidgetsBundleController#deleteWidgetsBundle(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleController#deleteWidgetsBundle(String)}
   */
  @Test
  @DisplayName("Test deleteWidgetsBundle(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleController.deleteWidgetsBundle(String)"})
  void testDeleteWidgetsBundle_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    WidgetsBundleServiceImpl widgetsBundleService = new WidgetsBundleServiceImpl();
    DefaultWidgetsBundleService tbWidgetsBundleService =
        new DefaultWidgetsBundleService(widgetsBundleService, new WidgetTypeServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    WidgetsBundleController widgetsBundleController =
        new WidgetsBundleController(tbWidgetsBundleService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> widgetsBundleController.deleteWidgetsBundle("42"));
  }

  /**
   * Test {@link WidgetsBundleController#deleteWidgetsBundle(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleController#deleteWidgetsBundle(String)}
   */
  @Test
  @DisplayName("Test deleteWidgetsBundle(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetsBundleController.deleteWidgetsBundle(String)"})
  void testDeleteWidgetsBundle_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    WidgetsBundleServiceImpl widgetsBundleService = new WidgetsBundleServiceImpl();
    DefaultWidgetsBundleService tbWidgetsBundleService =
        new DefaultWidgetsBundleService(widgetsBundleService, new WidgetTypeServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    WidgetsBundleController widgetsBundleController =
        new WidgetsBundleController(tbWidgetsBundleService, imageService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> widgetsBundleController.deleteWidgetsBundle(""));
  }
}
