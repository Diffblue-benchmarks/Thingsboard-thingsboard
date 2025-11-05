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
import org.thingsboard.server.service.entitiy.widgets.type.DefaultWidgetTypeService;

class WidgetTypeControllerDiffblueTest {
  /**
   * Test {@link WidgetTypeController#deleteWidgetType(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeController#deleteWidgetType(String)}
   */
  @Test
  @DisplayName("Test deleteWidgetType(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeController.deleteWidgetType(String)"})
  void testDeleteWidgetType_when42() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultWidgetTypeService tbWidgetTypeService =
        new DefaultWidgetTypeService(new WidgetTypeServiceImpl());
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

    WidgetTypeController widgetTypeController =
        new WidgetTypeController(tbWidgetTypeService, imageService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> widgetTypeController.deleteWidgetType("42"));
  }

  /**
   * Test {@link WidgetTypeController#deleteWidgetType(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeController#deleteWidgetType(String)}
   */
  @Test
  @DisplayName("Test deleteWidgetType(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WidgetTypeController.deleteWidgetType(String)"})
  void testDeleteWidgetType_whenEmptyString() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultWidgetTypeService tbWidgetTypeService =
        new DefaultWidgetTypeService(new WidgetTypeServiceImpl());
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

    WidgetTypeController widgetTypeController =
        new WidgetTypeController(tbWidgetTypeService, imageService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> widgetTypeController.deleteWidgetType(""));
  }
}
