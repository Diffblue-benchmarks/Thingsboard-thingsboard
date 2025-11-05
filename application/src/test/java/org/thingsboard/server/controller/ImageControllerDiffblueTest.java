package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.thingsboard.server.common.data.ImageExportData;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.resource.BaseImageService;
import org.thingsboard.server.dao.resource.ImageCacheKey;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;
import org.thingsboard.server.service.resource.DefaultTbImageService;

@ExtendWith(MockitoExtension.class)
class ImageControllerDiffblueTest {
  @InjectMocks private ImageController imageController;

  @Mock private ImageService imageService;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link ImageController#uploadImage(MultipartFile, String, String)}.
   *
   * <ul>
   *   <li>Then status {@link StatusResultMatchers#isOk()}.
   * </ul>
   *
   * <p>Method under test: {@link ImageController#uploadImage(MultipartFile, String, String)}
   */
  @Test
  @DisplayName("Test uploadImage(MultipartFile, String, String); then status isOk()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceInfo ImageController.uploadImage(MultipartFile, String, String)"})
  void testUploadImage_thenStatusIsOk() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link ImageController#uploadImage(MultipartFile, String, String)}.
   *
   * <ul>
   *   <li>When multipart {@code /api/image} and.
   *   <li>Then status four hundred.
   * </ul>
   *
   * <p>Method under test: {@link ImageController#uploadImage(MultipartFile, String, String)}
   */
  @Test
  @DisplayName(
      "Test uploadImage(MultipartFile, String, String); when multipart '/api/image' and; then status four hundred")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceInfo ImageController.uploadImage(MultipartFile, String, String)"})
  void testUploadImage_whenMultipartApiImageAnd_thenStatusFourHundred() throws Exception {
    // Arrange
    MockMultipartHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.multipart("/api/image");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   *
   * <p>Method under test: {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName("Test updateImage(String, String, MultipartFile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceInfo ImageController.updateImage(String, String, MultipartFile)"})
  void testUpdateImage() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    MockMultipartHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.multipart("/api/images/{type}/{key}", "Type", "Key");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link ImageController#updateImage(String, String, MultipartFile)}.
   *
   * <ul>
   *   <li>Then content contentType {@code text/plain;charset=ISO-8859-1}.
   * </ul>
   *
   * <p>Method under test: {@link ImageController#updateImage(String, String, MultipartFile)}
   */
  @Test
  @DisplayName(
      "Test updateImage(String, String, MultipartFile); then content contentType 'text/plain;charset=ISO-8859-1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceInfo ImageController.updateImage(String, String, MultipartFile)"})
  void testUpdateImage_thenContentContentTypeTextPlainCharsetIso88591() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    MockMultipartHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.multipart("/api/images/{type}/{key}", "Type", "Key");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}.
   *
   * <p>Method under test: {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}
   */
  @Test
  @DisplayName("Test updateImageInfo(String, String, TbResourceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo ImageController.updateImageInfo(String, String, TbResourceInfo)"
  })
  void testUpdateImageInfo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
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
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache =
        new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(), null);
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService clusterService =
        new DefaultTbClusterService(
            topicService,
            deviceProfileCache,
            assetProfileCache,
            gatewayNotificationsService,
            new EdgeServiceImpl(),
            null);
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();

    BaseImageService imageService2 =
        new BaseImageService(
            resourceDao2,
            resourceInfoDao2,
            resourceValidator2,
            assetProfileDao2,
            deviceProfileDao2,
            widgetsBundleDao2,
            widgetTypeDao2,
            new JpaDashboardInfoDao());

    DefaultTbImageService tbImageService =
        new DefaultTbImageService(clusterService, imageService2, 1, 3);

    ImageController imageController =
        new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> imageController.updateImageInfo("Type", "Key", new TbResourceInfo()));
  }

  /**
   * Test {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}.
   *
   * <p>Method under test: {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}
   */
  @Test
  @DisplayName("Test updateImageInfo(String, String, TbResourceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo ImageController.updateImageInfo(String, String, TbResourceInfo)"
  })
  void testUpdateImageInfo2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache =
        new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(), null);
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService clusterService =
        new DefaultTbClusterService(
            topicService,
            deviceProfileCache,
            assetProfileCache,
            gatewayNotificationsService,
            new EdgeServiceImpl(),
            null);
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

    DefaultTbImageService tbImageService =
        new DefaultTbImageService(clusterService, imageService, 1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "java.lang.String");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();

    BaseImageService imageService2 =
        new BaseImageService(
            resourceDao2,
            resourceInfoDao2,
            resourceValidator2,
            assetProfileDao2,
            deviceProfileDao2,
            widgetsBundleDao2,
            widgetTypeDao2,
            new JpaDashboardInfoDao());

    ImageController imageController =
        new ImageController(imageService2, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> imageController.updateImageInfo("Type", "Key", new TbResourceInfo()));
  }

  /**
   * Test {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}.
   *
   * <p>Method under test: {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}
   */
  @Test
  @DisplayName("Test updateImageInfo(String, String, TbResourceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo ImageController.updateImageInfo(String, String, TbResourceInfo)"
  })
  void testUpdateImageInfo3() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache =
        new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(), null);
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService clusterService =
        new DefaultTbClusterService(
            topicService,
            deviceProfileCache,
            assetProfileCache,
            gatewayNotificationsService,
            new EdgeServiceImpl(),
            null);
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

    DefaultTbImageService tbImageService =
        new DefaultTbImageService(clusterService, imageService, 1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "java.lang.String");
    BaseImageService imageService2 = mock(BaseImageService.class);

    ImageController imageController =
        new ImageController(imageService2, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> imageController.updateImageInfo("Type", "Key", new TbResourceInfo()));
  }

  /**
   * Test {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}.
   *
   * <p>Method under test: {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}
   */
  @Test
  @DisplayName("Test updateImageInfo(String, String, TbResourceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo ImageController.updateImageInfo(String, String, TbResourceInfo)"
  })
  void testUpdateImageInfo4() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache =
        new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(), null);
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    DefaultGatewayNotificationsService gatewayNotificationsService =
        mock(DefaultGatewayNotificationsService.class);

    DefaultTbClusterService clusterService =
        new DefaultTbClusterService(
            topicService,
            deviceProfileCache,
            assetProfileCache,
            gatewayNotificationsService,
            new EdgeServiceImpl(),
            null);
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

    DefaultTbImageService tbImageService =
        new DefaultTbImageService(clusterService, imageService, 1, 3);
    tbImageService.putETag(ImageCacheKey.forPublicImage("tenant"), "java.lang.String");
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();

    BaseImageService imageService2 =
        new BaseImageService(
            resourceDao2,
            resourceInfoDao2,
            resourceValidator2,
            assetProfileDao2,
            deviceProfileDao2,
            widgetsBundleDao2,
            widgetTypeDao2,
            new JpaDashboardInfoDao());

    ImageController imageController =
        new ImageController(imageService2, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> imageController.updateImageInfo("Type", "Key", new TbResourceInfo()));
  }

  /**
   * Test {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}.
   *
   * <p>Method under test: {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}
   */
  @Test
  @DisplayName("Test updateImageInfo(String, String, TbResourceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo ImageController.updateImageInfo(String, String, TbResourceInfo)"
  })
  void testUpdateImageInfo5() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    when(imageService.getImageInfoByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new TbResourceInfo());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> imageController.updateImageInfo("system", "Key", new TbResourceInfo()));
    verify(imageService).getImageInfoByTenantIdAndKey(isA(TenantId.class), eq("Key"));
  }

  /**
   * Test {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}.
   *
   * <p>Method under test: {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}
   */
  @Test
  @DisplayName("Test updateImageInfo(String, String, TbResourceInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo ImageController.updateImageInfo(String, String, TbResourceInfo)"
  })
  void testUpdateImageInfo6() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    when(imageService.getImageInfoByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> imageController.updateImageInfo("system", "Key", new TbResourceInfo()));
    verify(imageService).getImageInfoByTenantIdAndKey(isA(TenantId.class), eq("Key"));
  }

  /**
   * Test {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}.
   *
   * <ul>
   *   <li>When {@code tenant}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link ImageController#updateImageInfo(String, String, TbResourceInfo)}
   */
  @Test
  @DisplayName(
      "Test updateImageInfo(String, String, TbResourceInfo); when 'tenant'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo ImageController.updateImageInfo(String, String, TbResourceInfo)"
  })
  void testUpdateImageInfo_whenTenant_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
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
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache =
        new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(), null);
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService clusterService =
        new DefaultTbClusterService(
            topicService,
            deviceProfileCache,
            assetProfileCache,
            gatewayNotificationsService,
            new EdgeServiceImpl(),
            null);
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();

    BaseImageService imageService2 =
        new BaseImageService(
            resourceDao2,
            resourceInfoDao2,
            resourceValidator2,
            assetProfileDao2,
            deviceProfileDao2,
            widgetsBundleDao2,
            widgetTypeDao2,
            new JpaDashboardInfoDao());

    DefaultTbImageService tbImageService =
        new DefaultTbImageService(clusterService, imageService2, 1, 3);

    ImageController imageController =
        new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> imageController.updateImageInfo("tenant", "Key", new TbResourceInfo()));
  }

  /**
   * Test {@link ImageController#updateImagePublicStatus(String, String, boolean)}.
   *
   * <p>Method under test: {@link ImageController#updateImagePublicStatus(String, String, boolean)}
   */
  @Test
  @DisplayName("Test updateImagePublicStatus(String, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo ImageController.updateImagePublicStatus(String, String, boolean)"
  })
  void testUpdateImagePublicStatus() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link ImageController#updateImagePublicStatus(String, String, boolean)}.
   *
   * <p>Method under test: {@link ImageController#updateImagePublicStatus(String, String, boolean)}
   */
  @Test
  @DisplayName("Test updateImagePublicStatus(String, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo ImageController.updateImagePublicStatus(String, String, boolean)"
  })
  void testUpdateImagePublicStatus2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link ImageController#downloadImage(String, String, String)}.
   *
   * <p>Method under test: {@link ImageController#downloadImage(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImage(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity ImageController.downloadImage(String, String, String)"})
  void testDownloadImage() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link ImageController#downloadImage(String, String, String)}.
   *
   * <p>Method under test: {@link ImageController#downloadImage(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImage(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity ImageController.downloadImage(String, String, String)"})
  void testDownloadImage2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link ImageController#exportImage(String, String)}.
   *
   * <p>Method under test: {@link ImageController#exportImage(String, String)}
   */
  @Test
  @DisplayName("Test exportImage(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImageExportData ImageController.exportImage(String, String)"})
  void testExportImage() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link ImageController#exportImage(String, String)}.
   *
   * <p>Method under test: {@link ImageController#exportImage(String, String)}
   */
  @Test
  @DisplayName("Test exportImage(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImageExportData ImageController.exportImage(String, String)"})
  void testExportImage2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link ImageController#importImage(ImageExportData)}.
   *
   * <p>Method under test: {@link ImageController#importImage(ImageExportData)}
   */
  @Test
  @DisplayName("Test importImage(ImageExportData)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceInfo ImageController.importImage(ImageExportData)"})
  void testImportImage() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
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
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache =
        new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(), null);
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService clusterService =
        new DefaultTbClusterService(
            topicService,
            deviceProfileCache,
            assetProfileCache,
            gatewayNotificationsService,
            new EdgeServiceImpl(),
            null);
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();

    BaseImageService imageService2 =
        new BaseImageService(
            resourceDao2,
            resourceInfoDao2,
            resourceValidator2,
            assetProfileDao2,
            deviceProfileDao2,
            widgetsBundleDao2,
            widgetTypeDao2,
            new JpaDashboardInfoDao());

    DefaultTbImageService tbImageService =
        new DefaultTbImageService(clusterService, imageService2, 1, 3);

    ImageController imageController =
        new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> imageController.importImage(new ImageExportData()));
  }

  /**
   * Test {@link ImageController#downloadImagePreview(String, String, String)}.
   *
   * <p>Method under test: {@link ImageController#downloadImagePreview(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImagePreview(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity ImageController.downloadImagePreview(String, String, String)"})
  void testDownloadImagePreview() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link ImageController#downloadImagePreview(String, String, String)}.
   *
   * <p>Method under test: {@link ImageController#downloadImagePreview(String, String, String)}
   */
  @Test
  @DisplayName("Test downloadImagePreview(String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity ImageController.downloadImagePreview(String, String, String)"})
  void testDownloadImagePreview2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link ImageController#getImageInfo(String, String)}.
   *
   * <p>Method under test: {@link ImageController#getImageInfo(String, String)}
   */
  @Test
  @DisplayName("Test getImageInfo(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceInfo ImageController.getImageInfo(String, String)"})
  void testGetImageInfo() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link ImageController#getImageInfo(String, String)}.
   *
   * <p>Method under test: {@link ImageController#getImageInfo(String, String)}
   */
  @Test
  @DisplayName("Test getImageInfo(String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceInfo ImageController.getImageInfo(String, String)"})
  void testGetImageInfo2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }

  /**
   * Test {@link ImageController#getImages(int, int, String, boolean, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ImageController}.
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link ImageController#getImages(int, int, String, boolean, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getImages(int, int, String, boolean, String, String, String); given ImageController; when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData ImageController.getImages(int, int, String, boolean, String, String, String)"
  })
  void testGetImages_givenImageController_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> imageController.getImages(3, 1, "Image Sub Type", true, "Text Search", "", "asc"));
  }

  /**
   * Test {@link ImageController#getImages(int, int, String, boolean, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ImageController}.
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link ImageController#getImages(int, int, String, boolean, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getImages(int, int, String, boolean, String, String, String); given ImageController; when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData ImageController.getImages(int, int, String, boolean, String, String, String)"
  })
  void testGetImages_givenImageController_whenEmptyString_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> imageController.getImages(3, 1, "Image Sub Type", true, "Text Search", "U", ""));
  }

  /**
   * Test {@link ImageController#getImages(int, int, String, boolean, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ImageController}.
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link ImageController#getImages(int, int, String, boolean, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getImages(int, int, String, boolean, String, String, String); given ImageController; when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData ImageController.getImages(int, int, String, boolean, String, String, String)"
  })
  void testGetImages_givenImageController_whenU_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> imageController.getImages(3, 1, "Image Sub Type", true, "Text Search", "U", "asc"));
  }

  /**
   * Test {@link ImageController#getImages(int, int, String, boolean, String, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ImageController}.
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link ImageController#getImages(int, int, String, boolean, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getImages(int, int, String, boolean, String, String, String); given ImageController; when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData ImageController.getImages(int, int, String, boolean, String, String, String)"
  })
  void testGetImages_givenImageController_whenU_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> imageController.getImages(3, 1, "Image Sub Type", true, "Text Search", "U", "U"));
  }

  /**
   * Test {@link ImageController#getImages(int, int, String, boolean, String, String, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ImageController#getImages(int, int, String, boolean, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getImages(int, int, String, boolean, String, String, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData ImageController.getImages(int, int, String, boolean, String, String, String)"
  })
  void testGetImages_thenThrowIllegalArgumentException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
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
    TopicService topicService = new TopicService();
    DefaultTbDeviceProfileCache deviceProfileCache =
        new DefaultTbDeviceProfileCache(new DeviceProfileServiceImpl(), null);
    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache =
        new DefaultTbAssetProfileCache(assetProfileService, new BaseAssetService());
    DefaultGatewayNotificationsService gatewayNotificationsService =
        new DefaultGatewayNotificationsService();

    DefaultTbClusterService clusterService =
        new DefaultTbClusterService(
            topicService,
            deviceProfileCache,
            assetProfileCache,
            gatewayNotificationsService,
            new EdgeServiceImpl(),
            null);
    JpaTbResourceDao resourceDao2 = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao2 = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator2 = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao2 = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao2 = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao2 = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao2 = new JpaWidgetTypeDao();

    BaseImageService imageService2 =
        new BaseImageService(
            resourceDao2,
            resourceInfoDao2,
            resourceValidator2,
            assetProfileDao2,
            deviceProfileDao2,
            widgetsBundleDao2,
            widgetTypeDao2,
            new JpaDashboardInfoDao());

    DefaultTbImageService tbImageService =
        new DefaultTbImageService(clusterService, imageService2, 1, 3);

    ImageController imageController =
        new ImageController(imageService, tbImageService, new ResourceDataValidator());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            imageController.getImages(
                3, 1, "Image Sub Type", true, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link ImageController#deleteImage(String, String, boolean)}.
   *
   * <p>Method under test: {@link ImageController#deleteImage(String, String, boolean)}
   */
  @Test
  @DisplayName("Test deleteImage(String, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity ImageController.deleteImage(String, String, boolean)"})
  void testDeleteImage() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>(HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk());
  }

  /**
   * Test {@link ImageController#deleteImage(String, String, boolean)}.
   *
   * <p>Method under test: {@link ImageController#deleteImage(String, String, boolean)}
   */
  @Test
  @DisplayName("Test deleteImage(String, String, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ResponseEntity ImageController.deleteImage(String, String, boolean)"})
  void testDeleteImage2() throws Exception {
    // Arrange
    when(thingsboardErrorResponseHandler.handleException(
            Mockito.<Exception>any(), Mockito.<WebRequest>any()))
        .thenReturn(new ResponseEntity<>("Body", HttpStatus.OK));

    FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();

    // Act and Assert
    MockMvcBuilders.standaloneSetup(imageController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/x-www-form-urlencoded;charset=ISO-8859-1"))
        .andExpect(content().string("Body"));
  }
}
