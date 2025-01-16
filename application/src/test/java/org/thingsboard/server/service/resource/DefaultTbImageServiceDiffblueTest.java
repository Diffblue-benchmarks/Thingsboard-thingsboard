package org.thingsboard.server.service.resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.thingsboard.server.common.data.TbImageDeleteResult;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
import org.thingsboard.server.dao.asset.BaseAssetService;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.device.DeviceServiceImpl;
import org.thingsboard.server.dao.edge.EdgeServiceImpl;
import org.thingsboard.server.dao.edge.EdgeSessionCaffeineCache;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.dao.resource.BaseImageService;
import org.thingsboard.server.dao.resource.ImageCacheKey;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.service.validator.DeviceDataValidator;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.service.gateway_device.DefaultGatewayNotificationsService;
import org.thingsboard.server.service.profile.DefaultTbAssetProfileCache;
import org.thingsboard.server.service.profile.DefaultTbDeviceProfileCache;
import org.thingsboard.server.service.queue.DefaultTbClusterService;

class DefaultTbImageServiceDiffblueTest {
  /**
   * Test {@link DefaultTbImageService#getETag(ImageCacheKey)}.
   * <p>
   * Method under test: {@link DefaultTbImageService#getETag(ImageCacheKey)}
   */
  @Test
  @DisplayName("Test getETag(ImageCacheKey)")
  void testGetETag() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setAsyncCacheMode(true);
    EdgeSessionCaffeineCache edgeIdServiceIdCache = new EdgeSessionCaffeineCache(cacheManager);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(null, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, new EdgeServiceImpl(), edgeIdServiceIdCache);

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService defaultTbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    defaultTbImageService.putETag(ImageCacheKey.forPublicImage("Public Key"), "Etag");

    // Act and Assert
    assertEquals("Etag", defaultTbImageService.getETag(ImageCacheKey.forPublicImage("Public Key")));
  }

  /**
   * Test {@link DefaultTbImageService#getETag(ImageCacheKey)}.
   * <p>
   * Method under test: {@link DefaultTbImageService#getETag(ImageCacheKey)}
   */
  @Test
  @DisplayName("Test getETag(ImageCacheKey)")
  void testGetETag2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setAsyncCacheMode(true);
    EdgeSessionCaffeineCache edgeIdServiceIdCache = new EdgeSessionCaffeineCache(cacheManager);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, new EdgeServiceImpl(), edgeIdServiceIdCache);

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService defaultTbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, null, resourceValidator, assetProfileDao, deviceProfileDao, widgetsBundleDao,
            widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    defaultTbImageService.putETag(ImageCacheKey.forPublicImage("Public Key"), "Etag");

    // Act and Assert
    assertEquals("Etag", defaultTbImageService.getETag(ImageCacheKey.forPublicImage("Public Key")));
  }

  /**
   * Test {@link DefaultTbImageService#getETag(ImageCacheKey)}.
   * <ul>
   *   <li>Given {@link CaffeineCacheManager#CaffeineCacheManager()} AsyncCacheMode
   * is {@code true}.</li>
   *   <li>Then return {@code Etag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbImageService#getETag(ImageCacheKey)}
   */
  @Test
  @DisplayName("Test getETag(ImageCacheKey); given CaffeineCacheManager() AsyncCacheMode is 'true'; then return 'Etag'")
  void testGetETag_givenCaffeineCacheManagerAsyncCacheModeIsTrue_thenReturnEtag() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    CaffeineCacheManager cacheManager = new CaffeineCacheManager();
    cacheManager.setAsyncCacheMode(true);
    EdgeSessionCaffeineCache edgeIdServiceIdCache = new EdgeSessionCaffeineCache(cacheManager);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    DefaultTbClusterService clusterService = new DefaultTbClusterService(topicService, deviceProfileCache,
        assetProfileCache, gatewayNotificationsService, new EdgeServiceImpl(), edgeIdServiceIdCache);

    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    DefaultTbImageService defaultTbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    defaultTbImageService.putETag(ImageCacheKey.forPublicImage("Public Key"), "Etag");

    // Act and Assert
    assertEquals("Etag", defaultTbImageService.getETag(ImageCacheKey.forPublicImage("Public Key")));
  }

  /**
   * Test {@link DefaultTbImageService#getETag(ImageCacheKey)}.
   * <ul>
   *   <li>Then return {@code Etag}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbImageService#getETag(ImageCacheKey)}
   */
  @Test
  @DisplayName("Test getETag(ImageCacheKey); then return 'Etag'")
  void testGetETag_thenReturnEtag() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

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

    DefaultTbImageService defaultTbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    defaultTbImageService.putETag(ImageCacheKey.forPublicImage("Public Key"), "Etag");

    // Act and Assert
    assertEquals("Etag", defaultTbImageService.getETag(ImageCacheKey.forPublicImage("Public Key")));
  }

  /**
   * Test {@link DefaultTbImageService#getETag(ImageCacheKey)}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbImageService#getETag(ImageCacheKey)}
   */
  @Test
  @DisplayName("Test getETag(ImageCacheKey); then return 'null'")
  void testGetETag_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

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
    DefaultTbImageService defaultTbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);

    // Act and Assert
    assertNull(defaultTbImageService.getETag(ImageCacheKey.forPublicImage("Public Key")));
  }

  /**
   * Test {@link DefaultTbImageService#getETag(ImageCacheKey)}.
   * <ul>
   *   <li>When {@link ImageCacheKey}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbImageService#getETag(ImageCacheKey)}
   */
  @Test
  @DisplayName("Test getETag(ImageCacheKey); when ImageCacheKey; then return 'null'")
  void testGetETag_whenImageCacheKey_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

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

    // Act and Assert
    assertNull(
        (new DefaultTbImageService(clusterService, new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
            assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()), 1, 3))
            .getETag(mock(ImageCacheKey.class)));
  }

  /**
   * Test {@link DefaultTbImageService#evictETags(ImageCacheKey)}.
   * <ul>
   *   <li>Given forPublicImage {@code Public Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbImageService#evictETags(ImageCacheKey)}
   */
  @Test
  @DisplayName("Test evictETags(ImageCacheKey); given forPublicImage 'Public Key'")
  void testEvictETags_givenForPublicImagePublicKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

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
    DefaultTbImageService defaultTbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    ImageCacheKey imageCacheKey = mock(ImageCacheKey.class);
    when(imageCacheKey.getPublicResourceKey()).thenReturn(null);
    when(imageCacheKey.withPreview(anyBoolean())).thenReturn(ImageCacheKey.forPublicImage("Public Key"));

    // Act
    defaultTbImageService.evictETags(imageCacheKey);

    // Assert
    verify(imageCacheKey).getPublicResourceKey();
    verify(imageCacheKey).withPreview(eq(true));
  }

  /**
   * Test {@link DefaultTbImageService#evictETags(ImageCacheKey)}.
   * <ul>
   *   <li>Given {@link ImageCacheKey}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbImageService#evictETags(ImageCacheKey)}
   */
  @Test
  @DisplayName("Test evictETags(ImageCacheKey); given ImageCacheKey")
  void testEvictETags_givenImageCacheKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

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
    DefaultTbImageService defaultTbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    ImageCacheKey imageCacheKey = mock(ImageCacheKey.class);
    when(imageCacheKey.getPublicResourceKey()).thenReturn(null);
    when(imageCacheKey.withPreview(anyBoolean())).thenReturn(mock(ImageCacheKey.class));

    // Act
    defaultTbImageService.evictETags(imageCacheKey);

    // Assert
    verify(imageCacheKey).getPublicResourceKey();
    verify(imageCacheKey).withPreview(eq(true));
  }

  /**
   * Test {@link DefaultTbImageService#evictETags(ImageCacheKey)}.
   * <ul>
   *   <li>Given {@code Public Resource Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultTbImageService#evictETags(ImageCacheKey)}
   */
  @Test
  @DisplayName("Test evictETags(ImageCacheKey); given 'Public Resource Key'")
  void testEvictETags_givenPublicResourceKey() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

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
    DefaultTbImageService defaultTbImageService = new DefaultTbImageService(clusterService,
        new BaseImageService(resourceDao, resourceInfoDao, resourceValidator, assetProfileDao, deviceProfileDao,
            widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()),
        1, 3);
    ImageCacheKey imageCacheKey = mock(ImageCacheKey.class);
    when(imageCacheKey.getPublicResourceKey()).thenReturn("Public Resource Key");

    // Act
    defaultTbImageService.evictETags(imageCacheKey);

    // Assert
    verify(imageCacheKey).getPublicResourceKey();
  }

  /**
   * Test {@link DefaultTbImageService#delete(TbResourceInfo, User, boolean)}.
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   *   <li>Then calls {@link TbResourceInfo#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbImageService#delete(TbResourceInfo, User, boolean)}
   */
  @Test
  @DisplayName("Test delete(TbResourceInfo, User, boolean); given TenantId(UUID) with id is randomUUID; then calls getId()")
  void testDelete_givenTenantIdWithIdIsRandomUUID_thenCallsGetId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ImageService imageService = mock(ImageService.class);
    TbImageDeleteResult.TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult = builderResult.references(new HashMap<>()).success(false).build();
    when(imageService.deleteImage(Mockito.<TbResourceInfo>any(), anyBoolean())).thenReturn(buildResult);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbImageService defaultTbImageService = new DefaultTbImageService(
        new DefaultTbClusterService(topicService, deviceProfileCache, assetProfileCache, gatewayNotificationsService,
            edgeService, new EdgeSessionCaffeineCache(new CaffeineCacheManager())),
        imageService, 1, 3);
    TbResourceInfo imageInfo = mock(TbResourceInfo.class);
    when(imageInfo.getId()).thenReturn(new TbResourceId(UUID.randomUUID()));
    when(imageInfo.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    doNothing().when(imageInfo).setId(Mockito.<TbResourceId>any());
    imageInfo.setId(new TbResourceId(null));

    // Act
    TbImageDeleteResult actualDeleteResult = defaultTbImageService.delete(imageInfo, new User(), true);

    // Assert
    verify(imageInfo).getId();
    verify(imageInfo).getTenantId();
    verify(imageInfo).setId(isA(TbResourceId.class));
    verify(imageService).deleteImage(isA(TbResourceInfo.class), eq(true));
    assertFalse(actualDeleteResult.isSuccess());
    assertTrue(actualDeleteResult.getReferences().isEmpty());
  }

  /**
   * Test {@link DefaultTbImageService#delete(TbResourceInfo, User, boolean)}.
   * <ul>
   *   <li>When {@link TbResourceInfo#TbResourceInfo()} Id is
   * {@link TbResourceId#TbResourceId(UUID)} with id is {@code null}.</li>
   *   <li>Then return not Success.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultTbImageService#delete(TbResourceInfo, User, boolean)}
   */
  @Test
  @DisplayName("Test delete(TbResourceInfo, User, boolean); when TbResourceInfo() Id is TbResourceId(UUID) with id is 'null'; then return not Success")
  void testDelete_whenTbResourceInfoIdIsTbResourceIdWithIdIsNull_thenReturnNotSuccess() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ImageService imageService = mock(ImageService.class);
    TbImageDeleteResult.TbImageDeleteResultBuilder builderResult = TbImageDeleteResult.builder();
    TbImageDeleteResult buildResult = builderResult.references(new HashMap<>()).success(false).build();
    when(imageService.deleteImage(Mockito.<TbResourceInfo>any(), anyBoolean())).thenReturn(buildResult);
    TopicService topicService = new TopicService();
    DeviceProfileServiceImpl deviceProfileService = new DeviceProfileServiceImpl();
    JpaDeviceDao deviceDao = new JpaDeviceDao();
    DeviceProfileServiceImpl deviceProfileService2 = new DeviceProfileServiceImpl();
    BaseEventService eventService = new BaseEventService();
    TenantServiceImpl tenantService = new TenantServiceImpl();
    DeviceDataValidator deviceValidator = new DeviceDataValidator();
    BaseEntityCountService countService = new BaseEntityCountService();
    DefaultTbDeviceProfileCache deviceProfileCache = new DefaultTbDeviceProfileCache(deviceProfileService,
        new DeviceServiceImpl(deviceDao, null, deviceProfileService2, eventService, tenantService, deviceValidator,
            countService, new JpaExecutorService()));

    AssetProfileServiceImpl assetProfileService = new AssetProfileServiceImpl();
    DefaultTbAssetProfileCache assetProfileCache = new DefaultTbAssetProfileCache(assetProfileService,
        new BaseAssetService());

    DefaultGatewayNotificationsService gatewayNotificationsService = new DefaultGatewayNotificationsService();
    EdgeServiceImpl edgeService = new EdgeServiceImpl();
    DefaultTbImageService defaultTbImageService = new DefaultTbImageService(
        new DefaultTbClusterService(topicService, deviceProfileCache, assetProfileCache, gatewayNotificationsService,
            edgeService, new EdgeSessionCaffeineCache(new CaffeineCacheManager())),
        imageService, 1, 3);

    TbResourceInfo imageInfo = new TbResourceInfo();
    imageInfo.setId(new TbResourceId(null));

    // Act
    TbImageDeleteResult actualDeleteResult = defaultTbImageService.delete(imageInfo, new User(), true);

    // Assert
    verify(imageService).deleteImage(isA(TbResourceInfo.class), eq(true));
    assertFalse(actualDeleteResult.isSuccess());
    assertTrue(actualDeleteResult.getReferences().isEmpty());
  }
}
