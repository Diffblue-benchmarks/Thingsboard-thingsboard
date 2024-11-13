package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import org.thingsboard.server.common.data.ImageDescriptor;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.resource.BaseImageService;
import org.thingsboard.server.dao.resource.ImageCacheKey;
import org.thingsboard.server.dao.resource.TbResourceDao;
import org.thingsboard.server.dao.resource.TbResourceInfoDao;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.resource.DefaultTbImageService;
import org.thingsboard.server.service.resource.TbImageService;

class ImageControllerDiffblueTest {
  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   * <p>
   * Method under test:
   * {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName("Test updateImage(String, String, MultipartFile)")
  void testUpdateImage() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2, assetProfileDao2, deviceProfileDao2,
            widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao()),
        1, 3);

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> imageController.updateImage("Type", "Key",
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   * <p>
   * Method under test:
   * {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName("Test updateImage(String, String, MultipartFile)")
  void testUpdateImage2() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "Etag");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> imageController.updateImage("Type", "Key",
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   * <p>
   * Method under test:
   * {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName("Test updateImage(String, String, MultipartFile)")
  void testUpdateImage3() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "java.lang.String");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> imageController.updateImage("Type", "Key",
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   * <p>
   * Method under test:
   * {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName("Test updateImage(String, String, MultipartFile)")
  void testUpdateImage4() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        0, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "Etag");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> imageController.updateImage("Type", "Key",
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AX;XAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName("Test updateImage(String, String, MultipartFile); when ByteArrayInputStream(byte[]) with 'AX;XAXAX' Bytes is 'UTF-8'")
  void testUpdateImage_whenByteArrayInputStreamWithAxXaxaxBytesIsUtf8() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "Etag");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> imageController.updateImage("Type", "Key",
        new MockMultipartFile("Name", new ByteArrayInputStream("AX;XAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXXXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName("Test updateImage(String, String, MultipartFile); when ByteArrayInputStream(byte[]) with 'AXAXXXAX' Bytes is 'UTF-8'")
  void testUpdateImage_whenByteArrayInputStreamWithAxaxxxaxBytesIsUtf8() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "Etag");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> imageController.updateImage("Type", "Key",
        new MockMultipartFile("Name", new ByteArrayInputStream("AXAXXXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code ;XAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName("Test updateImage(String, String, MultipartFile); when ByteArrayInputStream(byte[]) with ';XAXAXAX' Bytes is 'UTF-8'")
  void testUpdateImage_whenByteArrayInputStreamWithXaxaxaxBytesIsUtf8() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "Etag");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> imageController.updateImage("Type", "Key",
        new MockMultipartFile("Name", new ByteArrayInputStream(";XAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code XXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName("Test updateImage(String, String, MultipartFile); when ByteArrayInputStream(byte[]) with 'XXAXAXAX' Bytes is 'UTF-8'")
  void testUpdateImage_whenByteArrayInputStreamWithXxaxaxaxBytesIsUtf8() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "Etag");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> imageController.updateImage("Type", "Key",
        new MockMultipartFile("Name", new ByteArrayInputStream("XXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   * <ul>
   *   <li>When {@code org.springframework.http.ResponseEntity$BodyBuilder}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName("Test updateImage(String, String, MultipartFile); when 'org.springframework.http.ResponseEntity$BodyBuilder'")
  void testUpdateImage_whenOrgSpringframeworkHttpResponseEntityBodyBuilder() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "Etag");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> imageController.updateImage("Type", "org.springframework.http.ResponseEntity$BodyBuilder",
            new MockMultipartFile("Name", new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")))));
  }

  /**
   * Test {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}.
   * <p>
   * Method under test:
   * {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}
   */
  @Test
  @DisplayName("Test updateImageInfo(String, String, TbResourceInfo)")
  void testUpdateImageInfo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "tenant");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> imageController.updateImageInfo("Type", "Key", new TbResourceInfo()));
  }

  /**
   * Test {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}.
   * <p>
   * Method under test:
   * {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}
   */
  @Test
  @DisplayName("Test updateImageInfo(String, String, TbResourceInfo)")
  void testUpdateImageInfo2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "Etag");
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "tenant");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> imageController.updateImageInfo("Type", "Key", new TbResourceInfo()));
  }

  /**
   * Test {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}
   */
  @Test
  @DisplayName("Test updateImageInfo(String, String, TbResourceInfo); when 'Type'; then throw IllegalArgumentException")
  void testUpdateImageInfo_whenType_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2, assetProfileDao2, deviceProfileDao2,
            widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao()),
        1, 3);

    ImageController imageController = new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> imageController.updateImageInfo("Type", "Key", new TbResourceInfo()));
  }

  /**
   * Test
   * {@link ImageController#updateImagePublicStatus(String, String, boolean)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#updateImagePublicStatus(String, String, boolean)}
   */
  @Test
  @DisplayName("Test updateImagePublicStatus(String, String, boolean); when 'Type'; then throw IllegalArgumentException")
  void testUpdateImagePublicStatus_whenType_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2, assetProfileDao2, deviceProfileDao2,
            widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao()),
        1, 3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImageController(imageService, tbImageService, new ResourceDataValidator()))
            .updateImagePublicStatus("Type", "Key", true));
  }

  /**
   * Test {@link ImageController#downloadImage(String, String, String)}.
   * <ul>
   *   <li>Then StatusCode return {@link HttpStatus}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#downloadImage(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImage(String, String, String); then StatusCode return HttpStatus")
  void testDownloadImage_thenStatusCodeReturnHttpStatus() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbImageService tbImageService = mock(TbImageService.class);
    when(tbImageService.getETag(Mockito.<ImageCacheKey>any())).thenReturn("Etag");
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    // Act
    ResponseEntity<ByteArrayResource> actualDownloadImageResult = (new ImageController(imageService, tbImageService,
        new ResourceDataValidator())).downloadImage("system", "Key", "Etag");

    // Assert
    verify(tbImageService).getETag(isA(ImageCacheKey.class));
    HttpStatusCode statusCode = actualDownloadImageResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(actualDownloadImageResult.getBody());
    assertEquals(304, actualDownloadImageResult.getStatusCodeValue());
    assertEquals(HttpStatus.NOT_MODIFIED, statusCode);
    assertFalse(actualDownloadImageResult.hasBody());
    assertTrue(actualDownloadImageResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link ImageController#downloadImage(String, String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#downloadImage(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImage(String, String, String); when 'Type'; then throw IllegalArgumentException")
  void testDownloadImage_whenType_thenThrowIllegalArgumentException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2, assetProfileDao2, deviceProfileDao2,
            widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao()),
        1, 3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImageController(imageService, tbImageService, new ResourceDataValidator())).downloadImage("Type",
            "Key", "Etag"));
  }

  /**
   * Test {@link ImageController#downloadPublicImage(String, String)}.
   * <ul>
   *   <li>Then StatusCode return {@link HttpStatus}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#downloadPublicImage(String, String)}
   */
  @Test
  @DisplayName("Test downloadPublicImage(String, String); then StatusCode return HttpStatus")
  void testDownloadPublicImage_thenStatusCodeReturnHttpStatus() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResourceDao resourceDao = mock(TbResourceDao.class);
    when(resourceDao.getResourceData(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);

    ImageDescriptor imageDescriptor = new ImageDescriptor();
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getDescriptor(Mockito.<Class<ImageDescriptor>>any())).thenReturn(imageDescriptor);
    when(tbResource.getFileName()).thenReturn("foo.txt");
    when(tbResource.getId()).thenReturn(new TbResourceId(UUID.randomUUID()));
    when(tbResource.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    when(resourceInfoDao.findPublicResourceByKey(Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2, assetProfileDao2, deviceProfileDao2,
            widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao()),
        1, 3);

    // Act
    ResponseEntity<ByteArrayResource> actualDownloadPublicImageResult = (new ImageController(imageService,
        tbImageService, new ResourceDataValidator())).downloadPublicImage("Public Resource Key", "Etag");

    // Assert
    verify(tbResource).getDescriptor(isA(Class.class));
    verify(tbResource).getFileName();
    verify(tbResource).getId();
    verify(tbResource).getTenantId();
    verify(resourceDao).getResourceData(isA(TenantId.class), isA(TbResourceId.class));
    verify(resourceInfoDao).findPublicResourceByKey(eq(ResourceType.IMAGE), eq("Public Resource Key"));
    HttpStatusCode statusCode = actualDownloadPublicImageResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    HttpHeaders headers = actualDownloadPublicImageResult.getHeaders();
    assertEquals(4, headers.size());
    List<String> getResult = headers.get(HttpHeaders.CONTENT_LENGTH);
    assertEquals(1, getResult.size());
    assertEquals("8", getResult.get(0));
    ByteArrayResource body = actualDownloadPublicImageResult.getBody();
    assertEquals("Byte array resource [resource loaded from byte array]", body.getDescription());
    List<String> getResult2 = headers.get(HttpHeaders.CONTENT_TYPE);
    assertEquals(1, getResult2.size());
    assertEquals("Media Type", getResult2.get(0));
    List<String> getResult3 = headers.get(HttpHeaders.ETAG);
    assertEquals(1, getResult3.size());
    assertEquals("\"Etag\"", getResult3.get(0));
    List<String> getResult4 = headers.get(HttpHeaders.CACHE_CONTROL);
    assertEquals(1, getResult4.size());
    assertEquals("no-cache", getResult4.get(0));
    assertNull(body.getFilename());
    assertEquals(200, actualDownloadPublicImageResult.getStatusCodeValue());
    byte[] byteArray = new byte[8];
    assertEquals(8, body.getInputStream().read(byteArray));
    assertEquals(HttpStatus.OK, statusCode);
    assertFalse(body.isFile());
    assertFalse(body.isOpen());
    assertTrue(actualDownloadPublicImageResult.hasBody());
    byte[] expectedByteArray = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedByteArray, body.getByteArray());
    byte[] expectedContentAsByteArray = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedContentAsByteArray, body.getContentAsByteArray());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), byteArray);
  }

  /**
   * Test {@link ImageController#downloadPublicImage(String, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#downloadPublicImage(String, String)}
   */
  @Test
  @DisplayName("Test downloadPublicImage(String, String); then throw IllegalArgumentException")
  void testDownloadPublicImage_thenThrowIllegalArgumentException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResourceDao resourceDao = mock(TbResourceDao.class);
    when(resourceDao.getResourceData(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    ImageDescriptor previewDescriptor = new ImageDescriptor();
    previewDescriptor.setEtag("Etag");
    previewDescriptor.setHeight(1);
    previewDescriptor.setMediaType("Media Type");
    previewDescriptor.setPreviewDescriptor(new ImageDescriptor());
    previewDescriptor.setSize(3L);
    previewDescriptor.setWidth(1);

    ImageDescriptor previewDescriptor2 = new ImageDescriptor();
    previewDescriptor2.setEtag("Etag");
    previewDescriptor2.setHeight(1);
    previewDescriptor2.setMediaType("Media Type");
    previewDescriptor2.setPreviewDescriptor(previewDescriptor);
    previewDescriptor2.setSize(3L);
    previewDescriptor2.setWidth(1);

    ImageDescriptor previewDescriptor3 = new ImageDescriptor();
    previewDescriptor3.setEtag("Etag");
    previewDescriptor3.setHeight(1);
    previewDescriptor3.setMediaType("Media Type");
    previewDescriptor3.setPreviewDescriptor(previewDescriptor2);
    previewDescriptor3.setSize(3L);
    previewDescriptor3.setWidth(1);

    ImageDescriptor previewDescriptor4 = new ImageDescriptor();
    previewDescriptor4.setEtag("Etag");
    previewDescriptor4.setHeight(1);
    previewDescriptor4.setMediaType("Media Type");
    previewDescriptor4.setPreviewDescriptor(previewDescriptor3);
    previewDescriptor4.setSize(3L);
    previewDescriptor4.setWidth(1);
    ImageDescriptor imageDescriptor = mock(ImageDescriptor.class);
    when(imageDescriptor.getMediaType()).thenThrow(new IllegalArgumentException("foo"));
    when(imageDescriptor.getEtag()).thenReturn("Etag");
    doNothing().when(imageDescriptor).setEtag(Mockito.<String>any());
    doNothing().when(imageDescriptor).setHeight(anyInt());
    doNothing().when(imageDescriptor).setMediaType(Mockito.<String>any());
    doNothing().when(imageDescriptor).setPreviewDescriptor(Mockito.<ImageDescriptor>any());
    doNothing().when(imageDescriptor).setSize(anyLong());
    doNothing().when(imageDescriptor).setWidth(anyInt());
    imageDescriptor.setEtag("Etag");
    imageDescriptor.setHeight(1);
    imageDescriptor.setMediaType("Media Type");
    imageDescriptor.setPreviewDescriptor(previewDescriptor4);
    imageDescriptor.setSize(3L);
    imageDescriptor.setWidth(1);
    TbResource tbResource = mock(TbResource.class);
    when(tbResource.getDescriptor(Mockito.<Class<ImageDescriptor>>any())).thenReturn(imageDescriptor);
    when(tbResource.getFileName()).thenReturn("foo.txt");
    when(tbResource.getId()).thenReturn(new TbResourceId(UUID.randomUUID()));
    when(tbResource.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    when(resourceInfoDao.findPublicResourceByKey(Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResource);
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2, assetProfileDao2, deviceProfileDao2,
            widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao()),
        1, 3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImageController(imageService, tbImageService, new ResourceDataValidator()))
            .downloadPublicImage("Public Resource Key", "Etag"));
    verify(imageDescriptor).getEtag();
    verify(imageDescriptor).getMediaType();
    verify(imageDescriptor).setEtag(eq("Etag"));
    verify(imageDescriptor).setHeight(eq(1));
    verify(imageDescriptor).setMediaType(eq("Media Type"));
    verify(imageDescriptor).setPreviewDescriptor(isA(ImageDescriptor.class));
    verify(imageDescriptor).setSize(eq(3L));
    verify(imageDescriptor).setWidth(eq(1));
    verify(tbResource).getDescriptor(isA(Class.class));
    verify(tbResource).getFileName();
    verify(tbResource).getId();
    verify(tbResource).getTenantId();
    verify(resourceDao).getResourceData(isA(TenantId.class), isA(TbResourceId.class));
    verify(resourceInfoDao).findPublicResourceByKey(eq(ResourceType.IMAGE), eq("Public Resource Key"));
  }

  /**
   * Test {@link ImageController#exportImage(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageController#exportImage(String, String)}
   */
  @Test
  @DisplayName("Test exportImage(String, String); when 'Type'; then throw IllegalArgumentException")
  void testExportImage_whenType_thenThrowIllegalArgumentException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2, assetProfileDao2, deviceProfileDao2,
            widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao()),
        1, 3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImageController(imageService, tbImageService, new ResourceDataValidator())).exportImage("Type",
            "Key"));
  }

  /**
   * Test {@link ImageController#downloadImagePreview(String, String, String)}.
   * <ul>
   *   <li>Then StatusCode return {@link HttpStatus}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#downloadImagePreview(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImagePreview(String, String, String); then StatusCode return HttpStatus")
  void testDownloadImagePreview_thenStatusCodeReturnHttpStatus() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbImageService tbImageService = mock(TbImageService.class);
    when(tbImageService.getETag(Mockito.<ImageCacheKey>any())).thenReturn("Etag");
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    // Act
    ResponseEntity<ByteArrayResource> actualDownloadImagePreviewResult = (new ImageController(imageService,
        tbImageService, new ResourceDataValidator())).downloadImagePreview("system", "Key", "Etag");

    // Assert
    verify(tbImageService).getETag(isA(ImageCacheKey.class));
    HttpStatusCode statusCode = actualDownloadImagePreviewResult.getStatusCode();
    assertTrue(statusCode instanceof HttpStatus);
    assertNull(actualDownloadImagePreviewResult.getBody());
    assertEquals(304, actualDownloadImagePreviewResult.getStatusCodeValue());
    assertEquals(HttpStatus.NOT_MODIFIED, statusCode);
    assertFalse(actualDownloadImagePreviewResult.hasBody());
    assertTrue(actualDownloadImagePreviewResult.getHeaders().isEmpty());
  }

  /**
   * Test {@link ImageController#downloadImagePreview(String, String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#downloadImagePreview(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImagePreview(String, String, String); when 'Type'; then throw IllegalArgumentException")
  void testDownloadImagePreview_whenType_thenThrowIllegalArgumentException() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2, assetProfileDao2, deviceProfileDao2,
            widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao()),
        1, 3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImageController(imageService, tbImageService, new ResourceDataValidator()))
            .downloadImagePreview("Type", "Key", "Etag"));
  }

  /**
   * Test {@link ImageController#getImageInfo(String, String)}.
   * <p>
   * Method under test: {@link ImageController#getImageInfo(String, String)}
   */
  @Test
  @DisplayName("Test getImageInfo(String, String)")
  void testGetImageInfo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "Etag");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImageController(imageService, tbImageService, new ResourceDataValidator())).getImageInfo("Type",
            "Key"));
  }

  /**
   * Test {@link ImageController#getImageInfo(String, String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageController#getImageInfo(String, String)}
   */
  @Test
  @DisplayName("Test getImageInfo(String, String); when 'Type'; then throw IllegalArgumentException")
  void testGetImageInfo_whenType_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2, assetProfileDao2, deviceProfileDao2,
            widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao()),
        1, 3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImageController(imageService, tbImageService, new ResourceDataValidator())).getImageInfo("Type",
            "Key"));
  }

  /**
   * Test {@link ImageController#deleteImage(String, String, boolean)}.
   * <p>
   * Method under test:
   * {@link ImageController#deleteImage(String, String, boolean)}
   */
  @Test
  @DisplayName("Test deleteImage(String, String, boolean)")
  void testDeleteImage() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "java.lang.String");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImageController(imageService, tbImageService, new ResourceDataValidator())).deleteImage("Type",
            "Key", true));
  }

  /**
   * Test {@link ImageController#deleteImage(String, String, boolean)}.
   * <p>
   * Method under test:
   * {@link ImageController#deleteImage(String, String, boolean)}
   */
  @Test
  @DisplayName("Test deleteImage(String, String, boolean)")
  void testDeleteImage2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache, null,
        gatewayNotificationsService, edgeService, new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "java.lang.String");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2,
        assetProfileDao2, deviceProfileDao2, widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImageController(imageService, tbImageService, new ResourceDataValidator())).deleteImage("Type",
            "Key", true));
  }

  /**
   * Test {@link ImageController#deleteImage(String, String, boolean)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageController#deleteImage(String, String, boolean)}
   */
  @Test
  @DisplayName("Test deleteImage(String, String, boolean); when 'Type'; then throw IllegalArgumentException")
  void testDeleteImage_whenType_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService imageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(),
        null);

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, edgeService,
        new EdgeSessionCaffeineCache(new CaffeineCacheManager()));

    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();
    DefaultTbImageService tbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao2, resourceInfoDao2, resourceValidator2, assetProfileDao2, deviceProfileDao2,
            widgetsBundleDao2, widgetTypeDao2, new JpaDashboardInfoDao()),
        1, 3);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> (new ImageController(imageService, tbImageService, new ResourceDataValidator())).deleteImage("Type",
            "Key", true));
  }
}
