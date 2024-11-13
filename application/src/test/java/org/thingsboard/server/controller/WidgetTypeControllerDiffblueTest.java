package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
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
   * Test {@link WidgetTypeController#getWidgetType(String)}.
   * <ul>
   *   <li>When {@code Fqn}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeController#getWidgetType(String)}
   */
  @Test
  @DisplayName("Test getWidgetType(String); when 'Fqn'")
  void testGetWidgetType_whenFqn() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultWidgetTypeService tbWidgetTypeService = new DefaultWidgetTypeService(new WidgetTypeServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new WidgetTypeController(tbWidgetTypeService,
            new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
                widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao())))
            .getWidgetType("Fqn"));
  }

  /**
   * Test {@link WidgetTypeController#getWidgetType(String)}.
   * <ul>
   *   <li>When {@code java.util.List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeController#getWidgetType(String)}
   */
  @Test
  @DisplayName("Test getWidgetType(String); when 'java.util.List'")
  void testGetWidgetType_whenJavaUtilList() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultWidgetTypeService tbWidgetTypeService = new DefaultWidgetTypeService(new WidgetTypeServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new WidgetTypeController(tbWidgetTypeService,
            new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
                widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao())))
            .getWidgetType("java.util.List"));
  }
}
