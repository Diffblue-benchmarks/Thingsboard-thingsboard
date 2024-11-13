package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.dashboard.DashboardServiceImpl;
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
import org.thingsboard.server.service.entitiy.dashboard.DefaultTbDashboardService;

class DashboardControllerDiffblueTest {
  /**
   * Test {@link DashboardController#getMaxDatapointsLimit()}.
   * <p>
   * Method under test: {@link DashboardController#getMaxDatapointsLimit()}
   */
  @Test
  @DisplayName("Test getMaxDatapointsLimit()")
  void testGetMaxDatapointsLimit() throws ThingsboardException {
    // Arrange
    DefaultTbDashboardService tbDashboardService = new DefaultTbDashboardService(new DashboardServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act and Assert
    assertEquals(0L,
        (new DashboardController(tbDashboardService,
            new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
                widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao())))
            .getMaxDatapointsLimit());
  }
}
