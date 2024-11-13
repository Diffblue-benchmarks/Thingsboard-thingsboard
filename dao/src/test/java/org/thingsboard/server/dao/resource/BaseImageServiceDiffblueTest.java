package org.thingsboard.server.dao.resource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.DashboardInfo;
import org.thingsboard.server.common.data.HasImage;
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbImageDeleteResult;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.TbResourceInfoFilter;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.TbResourceEntity;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;

public class BaseImageServiceDiffblueTest {
  /**
   * Test {@link BaseImageService#getImageInfoByTenantIdAndKey(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#getImageInfoByTenantIdAndKey(TenantId, String)}
   */
  @Test
  public void testGetImageInfoByTenantIdAndKey_thenReturnTbResourceInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceInfoDao resourceInfoDao = mock(JpaTbResourceInfoDao.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(resourceInfoDao.findByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(tbResourceInfo);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act
    TbResourceInfo actualImageInfoByTenantIdAndKey = (new BaseImageService(resourceDao, resourceInfoDao,
        resourceValidator, assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao,
        new JpaDashboardInfoDao())).getImageInfoByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, "Key");

    // Assert
    verify(resourceInfoDao).findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.IMAGE), eq("Key"));
    assertSame(tbResourceInfo, actualImageInfoByTenantIdAndKey);
  }

  /**
   * Test {@link BaseImageService#getPublicImageInfoByKey(String)}.
   * <ul>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#getPublicImageInfoByKey(String)}
   */
  @Test
  public void testGetPublicImageInfoByKey_thenReturnTbResourceInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceInfoDao resourceInfoDao = mock(JpaTbResourceInfoDao.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(resourceInfoDao.findPublicResourceByKey(Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResourceInfo);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act
    TbResourceInfo actualPublicImageInfoByKey = (new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao()))
        .getPublicImageInfoByKey("Public Resource Key");

    // Assert
    verify(resourceInfoDao).findPublicResourceByKey(eq(ResourceType.IMAGE), eq("Public Resource Key"));
    assertSame(tbResourceInfo, actualPublicImageInfoByKey);
  }

  /**
   * Test
   * {@link BaseImageService#getImagesByTenantId(TenantId, ResourceSubType, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#getImagesByTenantId(TenantId, ResourceSubType, PageLink)}
   */
  @Test
  public void testGetImagesByTenantId_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    PageData<TbResourceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(resourceInfoDao.findTenantResourcesByTenantId(Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act
    PageData<TbResourceInfo> actualImagesByTenantId = (new BaseImageService(resourceDao, resourceInfoDao,
        resourceValidator, assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao,
        new JpaDashboardInfoDao()))
        .getImagesByTenantId(ModelConstants.SYSTEM_TENANT, ResourceSubType.IMAGE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(resourceInfoDao).findTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
    assertSame(actualImagesByTenantId.EMPTY_PAGE_DATA, actualImagesByTenantId);
  }

  /**
   * Test
   * {@link BaseImageService#getAllImagesByTenantId(TenantId, ResourceSubType, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#getAllImagesByTenantId(TenantId, ResourceSubType, PageLink)}
   */
  @Test
  public void testGetAllImagesByTenantId_thenReturnEmpty_page_data() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    PageData<TbResourceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(resourceInfoDao.findAllTenantResourcesByTenantId(Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act
    PageData<TbResourceInfo> actualAllImagesByTenantId = (new BaseImageService(resourceDao, resourceInfoDao,
        resourceValidator, assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao,
        new JpaDashboardInfoDao())).getAllImagesByTenantId(ModelConstants.SYSTEM_TENANT, ResourceSubType.IMAGE,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(resourceInfoDao).findAllTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
    assertSame(actualAllImagesByTenantId.EMPTY_PAGE_DATA, actualAllImagesByTenantId);
  }

  /**
   * Test {@link BaseImageService#getImageData(TenantId, TbResourceId)}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#getImageData(TenantId, TbResourceId)}
   */
  @Test
  public void testGetImageData_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResourceRepository resourceRepository = mock(TbResourceRepository.class);
    when(resourceRepository.getDataById(Mockito.<UUID>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(resourceRepository);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    // Act
    byte[] actualImageData = baseImageService.getImageData(ModelConstants.SYSTEM_TENANT,
        new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(resourceRepository).getDataById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualImageData);
  }

  /**
   * Test {@link BaseImageService#getImagePreview(TenantId, TbResourceId)}.
   * <ul>
   *   <li>Then return {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#getImagePreview(TenantId, TbResourceId)}
   */
  @Test
  public void testGetImagePreview_thenReturnAxaxaxaxBytesIsUtf8() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResourceRepository resourceRepository = mock(TbResourceRepository.class);
    when(resourceRepository.getPreviewById(Mockito.<UUID>any())).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(resourceRepository);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    // Act
    byte[] actualImagePreview = baseImageService.getImagePreview(ModelConstants.SYSTEM_TENANT,
        new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(resourceRepository).getPreviewById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualImagePreview);
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   * <ul>
   *   <li>Given {@link TbResourceEntity} {@link TbResourceEntity#toData()} return
   * {@code null}.</li>
   *   <li>Then return References is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  public void testDeleteImage_givenTbResourceEntityToDataReturnNull_thenReturnReferencesIsNull()
      throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TbResourceEntity tbResourceEntity = mock(TbResourceEntity.class);
    when(tbResourceEntity.toData()).thenReturn(null);
    doNothing().when(tbResourceEntity).setCreatedTime(anyLong());
    doNothing().when(tbResourceEntity).setId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setData(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setDescriptor(Mockito.<JsonNode>any());
    doNothing().when(tbResourceEntity).setEtag(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setFileName(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setIsPublic(Mockito.<Boolean>any());
    doNothing().when(tbResourceEntity).setPreview(Mockito.<byte[]>any());
    doNothing().when(tbResourceEntity).setPublicResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceKey(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceSubType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setResourceType(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setSearchText(Mockito.<String>any());
    doNothing().when(tbResourceEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(tbResourceEntity).setTitle(Mockito.<String>any());
    tbResourceEntity.setCreatedTime(1L);
    tbResourceEntity.setData("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    tbResourceEntity.setEtag("Etag");
    tbResourceEntity.setExternalId(ModelConstants.NULL_UUID);
    tbResourceEntity.setFileName("foo.txt");
    tbResourceEntity.setId(ModelConstants.NULL_UUID);
    tbResourceEntity.setIsPublic(true);
    tbResourceEntity.setPreview("AXAXAXAX".getBytes("UTF-8"));
    tbResourceEntity.setPublicResourceKey("Public Resource Key");
    tbResourceEntity.setResourceKey("Resource Key");
    tbResourceEntity.setResourceSubType("Resource Sub Type");
    tbResourceEntity.setResourceType("Resource Type");
    tbResourceEntity.setSearchText("Search Text");
    tbResourceEntity.setTenantId(ModelConstants.NULL_UUID);
    tbResourceEntity.setTitle("Dr");
    tbResourceEntity.setUuid(ModelConstants.NULL_UUID);
    Optional<TbResourceEntity> ofResult = Optional.of(tbResourceEntity);
    TbResourceRepository resourceRepository = mock(TbResourceRepository.class);
    when(resourceRepository.findById(Mockito.<UUID>any())).thenReturn(ofResult);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(resourceRepository);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    TbResourceInfo imageInfo = new TbResourceInfo();
    imageInfo.setId(new TbResourceId(ModelConstants.NULL_UUID));

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, true);

    // Assert
    verify(resourceRepository).findById(isA(UUID.class));
    verify(tbResourceEntity).setCreatedTime(eq(1L));
    verify(tbResourceEntity).setId(isA(UUID.class));
    verify(tbResourceEntity).setUuid(isA(UUID.class));
    verify(tbResourceEntity).setData(isA(byte[].class));
    verify(tbResourceEntity).setDescriptor(isA(JsonNode.class));
    verify(tbResourceEntity).setEtag(eq("Etag"));
    verify(tbResourceEntity).setExternalId(isA(UUID.class));
    verify(tbResourceEntity).setFileName(eq("foo.txt"));
    verify(tbResourceEntity).setIsPublic(eq(true));
    verify(tbResourceEntity).setPreview(isA(byte[].class));
    verify(tbResourceEntity).setPublicResourceKey(eq("Public Resource Key"));
    verify(tbResourceEntity).setResourceKey(eq("Resource Key"));
    verify(tbResourceEntity).setResourceSubType(eq("Resource Sub Type"));
    verify(tbResourceEntity).setResourceType(eq("Resource Type"));
    verify(tbResourceEntity).setSearchText(eq("Search Text"));
    verify(tbResourceEntity).setTenantId(isA(UUID.class));
    verify(tbResourceEntity).setTitle(eq("Dr"));
    verify(tbResourceEntity).toData();
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#calculateImageEtag(byte[])}.
   * <p>
   * Method under test: {@link BaseImageService#calculateImageEtag(byte[])}
   */
  @Test
  public void testCalculateImageEtag() throws UnsupportedEncodingException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    // Act and Assert
    assertEquals("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc",
        baseImageService.calculateImageEtag("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test
   * {@link BaseImageService#findSystemOrTenantImageByEtag(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link TbResourceInfo#TbResourceInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#findSystemOrTenantImageByEtag(TenantId, String)}
   */
  @Test
  public void testFindSystemOrTenantImageByEtag_thenReturnTbResourceInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceInfoDao resourceInfoDao = mock(JpaTbResourceInfoDao.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(resourceInfoDao.findSystemOrTenantImageByEtag(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(tbResourceInfo);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    // Act
    TbResourceInfo actualFindSystemOrTenantImageByEtagResult = (new BaseImageService(resourceDao, resourceInfoDao,
        resourceValidator, assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao,
        new JpaDashboardInfoDao())).findSystemOrTenantImageByEtag(ModelConstants.SYSTEM_TENANT, "Etag");

    // Assert
    verify(resourceInfoDao).findSystemOrTenantImageByEtag(isA(TenantId.class), eq(ResourceType.IMAGE), eq("Etag"));
    assertSame(tbResourceInfo, actualFindSystemOrTenantImageByEtagResult);
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)} with
   * {@code Dashboard}.
   * <p>
   * Method under test:
   * {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)}
   */
  @Test
  public void testReplaceBase64WithImageUrlWithDashboard() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    Dashboard entity = new Dashboard();
    entity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(entity));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)} with
   * {@code Dashboard}.
   * <p>
   * Method under test:
   * {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)}
   */
  @Test
  public void testReplaceBase64WithImageUrlWithDashboard2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    Dashboard entity = new Dashboard();
    entity.setImage("Executing replaceBase64WithImageUrl [{}] [Dashboard] [{}]");

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(entity));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)} with
   * {@code Dashboard}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)}
   */
  @Test
  public void testReplaceBase64WithImageUrlWithDashboard_givenInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    Dashboard entity = new Dashboard();
    entity.setConfiguration(MissingNode.getInstance());

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(entity));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)} with
   * {@code Dashboard}.
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)}
   */
  @Test
  public void testReplaceBase64WithImageUrlWithDashboard_whenDashboard_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(new Dashboard()));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   * with {@code HasImage}, {@code String}.
   * <ul>
   *   <li>Given {@code Image}.</li>
   *   <li>Then calls {@link DashboardInfo#getImage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   */
  @Test
  public void testReplaceBase64WithImageUrlWithHasImageString_givenImage_thenCallsGetImage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    Dashboard entity = mock(Dashboard.class);
    when(entity.getImage()).thenReturn("Image");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    boolean actualReplaceBase64WithImageUrlResult = baseImageService.replaceBase64WithImageUrl(entity,
        "https://example.org/example");

    // Assert
    verify(entity).getImage();
    verify(entity, atLeast(1)).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity).setImage(eq("Image"));
    assertFalse(actualReplaceBase64WithImageUrlResult);
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   * with {@code HasImage}, {@code String}.
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   */
  @Test
  public void testReplaceBase64WithImageUrlWithHasImageString_whenDashboard_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(new Dashboard(), "https://example.org/example"));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   * with {@code WidgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   */
  @Test
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());

    WidgetTypeDetails entity = new WidgetTypeDetails();
    entity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(entity));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   * with {@code WidgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   */
  @Test
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    WidgetTypeDetails entity = mock(WidgetTypeDetails.class);
    when(entity.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(entity.getName()).thenReturn("Name");
    when(entity.getImage()).thenReturn("Image");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entity.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(entity).setImage(Mockito.<String>any());
    entity.setImage("tb-image:U:UU;data:U;U");

    // Act
    boolean actualReplaceBase64WithImageUrlResult = baseImageService.replaceBase64WithImageUrl(entity);

    // Assert
    verify(entity).getId();
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity, atLeast(1)).getDescriptor();
    verify(entity).getImage();
    verify(entity, atLeast(1)).setImage(Mockito.<String>any());
    assertFalse(actualReplaceBase64WithImageUrlResult);
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   * with {@code WidgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   */
  @Test
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    WidgetTypeDetails entity = mock(WidgetTypeDetails.class);
    when(entity.getDescriptor()).thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(entity.getName()).thenReturn("Name");
    when(entity.getImage()).thenReturn("Image");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entity.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(entity).setImage(Mockito.<String>any());
    entity.setImage("tb-image:U:UU;data:U;U");

    // Act
    boolean actualReplaceBase64WithImageUrlResult = baseImageService.replaceBase64WithImageUrl(entity);

    // Assert
    verify(entity).getId();
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity, atLeast(1)).getDescriptor();
    verify(entity).getImage();
    verify(entity, atLeast(1)).setImage(Mockito.<String>any());
    assertFalse(actualReplaceBase64WithImageUrlResult);
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   * with {@code WidgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   */
  @Test
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails4() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    WidgetTypeDetails entity = mock(WidgetTypeDetails.class);
    when(entity.getDescriptor()).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));
    when(entity.getName()).thenReturn("Name");
    when(entity.getImage()).thenReturn("Image");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entity.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(entity).setImage(Mockito.<String>any());
    entity.setImage("tb-image:U:UU;data:U;U");

    // Act
    boolean actualReplaceBase64WithImageUrlResult = baseImageService.replaceBase64WithImageUrl(entity);

    // Assert
    verify(entity).getId();
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity, atLeast(1)).getDescriptor();
    verify(entity).getImage();
    verify(entity, atLeast(1)).setImage(Mockito.<String>any());
    assertFalse(actualReplaceBase64WithImageUrlResult);
  }

  /**
   * Test {@link BaseImageService#inlineImage(HasImage)} with {@code entity}.
   * <ul>
   *   <li>Given {@code Image}.</li>
   *   <li>When {@link Dashboard} {@link DashboardInfo#getImage()} return
   * {@code Image}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#inlineImage(HasImage)}
   */
  @Test
  public void testInlineImageWithEntity_givenImage_whenDashboardGetImageReturnImage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    Dashboard entity = mock(Dashboard.class);
    when(entity.getImage()).thenReturn("Image");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImage(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity).setImage(eq("Image"));
  }

  /**
   * Test {@link BaseImageService#inlineImage(HasImage)} with {@code entity}.
   * <ul>
   *   <li>Given {@code tb-image;/api/images/system/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#inlineImage(HasImage)}
   */
  @Test
  public void testInlineImageWithEntity_givenTbImageApiImagesSystem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    Dashboard entity = mock(Dashboard.class);
    when(entity.getImage()).thenReturn("tb-image;/api/images/system/");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImage(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity).setImage(eq("tb-image;/api/images/system/"));
  }

  /**
   * Test {@link BaseImageService#inlineImage(HasImage)} with {@code entity}.
   * <ul>
   *   <li>Given {@code tb-image;/api/images/tenant/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#inlineImage(HasImage)}
   */
  @Test
  public void testInlineImageWithEntity_givenTbImageApiImagesTenant() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    Dashboard entity = mock(Dashboard.class);
    when(entity.getImage()).thenReturn("tb-image;/api/images/tenant/");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImage(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity).setImage(eq("tb-image;/api/images/tenant/"));
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with
   * {@code widgetTypeDetails}.
   * <ul>
   *   <li>Given {@code Image}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  public void testInlineImagesWithWidgetTypeDetails_givenImage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getImage()).thenReturn("Image");
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDetails).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImages(widgetTypeDetails);

    // Assert
    verify(widgetTypeDetails).getId();
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getTenantId();
    verify(widgetTypeDetails).getDescriptor();
    verify(widgetTypeDetails).getImage();
    verify(widgetTypeDetails).setImage(eq("Image"));
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with
   * {@code widgetTypeDetails}.
   * <ul>
   *   <li>Given {@code tb-image;/api/images/system/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  public void testInlineImagesWithWidgetTypeDetails_givenTbImageApiImagesSystem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getImage()).thenReturn("tb-image;/api/images/system/");
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDetails).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImages(widgetTypeDetails);

    // Assert
    verify(widgetTypeDetails).getId();
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getTenantId();
    verify(widgetTypeDetails).getDescriptor();
    verify(widgetTypeDetails).getImage();
    verify(widgetTypeDetails).setImage(eq("tb-image;/api/images/system/"));
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with
   * {@code widgetTypeDetails}.
   * <ul>
   *   <li>Given {@code tb-image;/api/images/tenant/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  public void testInlineImagesWithWidgetTypeDetails_givenTbImageApiImagesTenant() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getImage()).thenReturn("tb-image;/api/images/tenant/");
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDetails).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImages(widgetTypeDetails);

    // Assert
    verify(widgetTypeDetails).getId();
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getTenantId();
    verify(widgetTypeDetails).getDescriptor();
    verify(widgetTypeDetails).getImage();
    verify(widgetTypeDetails).setImage(eq("tb-image;/api/images/tenant/"));
  }

  /**
   * Test {@link BaseImageService#inlineImageForEdge(HasImage)}.
   * <ul>
   *   <li>Given {@code Image}.</li>
   *   <li>When {@link Dashboard} {@link DashboardInfo#getImage()} return
   * {@code Image}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#inlineImageForEdge(HasImage)}
   */
  @Test
  public void testInlineImageForEdge_givenImage_whenDashboardGetImageReturnImage() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    Dashboard entity = mock(Dashboard.class);
    when(entity.getImage()).thenReturn("Image");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImageForEdge(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity).setImage(eq("Image"));
  }

  /**
   * Test {@link BaseImageService#inlineImageForEdge(HasImage)}.
   * <ul>
   *   <li>Given {@code tb-image;/api/images/system/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#inlineImageForEdge(HasImage)}
   */
  @Test
  public void testInlineImageForEdge_givenTbImageApiImagesSystem() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    Dashboard entity = mock(Dashboard.class);
    when(entity.getImage()).thenReturn("tb-image;/api/images/system/");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImageForEdge(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity).setImage(eq("tb-image;/api/images/system/"));
  }

  /**
   * Test {@link BaseImageService#inlineImageForEdge(HasImage)}.
   * <ul>
   *   <li>Given {@code tb-image;/api/images/tenant/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#inlineImageForEdge(HasImage)}
   */
  @Test
  public void testInlineImageForEdge_givenTbImageApiImagesTenant() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    Dashboard entity = mock(Dashboard.class);
    when(entity.getImage()).thenReturn("tb-image;/api/images/tenant/");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImageForEdge(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity).setImage(eq("tb-image;/api/images/tenant/"));
  }

  /**
   * Test {@link BaseImageService#inlineImagesForEdge(WidgetTypeDetails)} with
   * {@code widgetTypeDetails}.
   * <p>
   * Method under test:
   * {@link BaseImageService#inlineImagesForEdge(WidgetTypeDetails)}
   */
  @Test
  public void testInlineImagesForEdgeWithWidgetTypeDetails() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getImage()).thenReturn("Image");
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDetails).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImagesForEdge(widgetTypeDetails);

    // Assert
    verify(widgetTypeDetails).getId();
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getTenantId();
    verify(widgetTypeDetails).getDescriptor();
    verify(widgetTypeDetails).getImage();
    verify(widgetTypeDetails).setImage(eq("Image"));
  }

  /**
   * Test {@link BaseImageService#inlineImagesForEdge(WidgetTypeDetails)} with
   * {@code widgetTypeDetails}.
   * <ul>
   *   <li>Given Instance.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseImageService#inlineImagesForEdge(WidgetTypeDetails)}
   */
  @Test
  public void testInlineImagesForEdgeWithWidgetTypeDetails_givenInstance() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();
    BaseImageService baseImageService = new BaseImageService(resourceDao, resourceInfoDao, resourceValidator,
        assetProfileDao, deviceProfileDao, widgetsBundleDao, widgetTypeDao, new JpaDashboardInfoDao());
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor()).thenReturn(MissingNode.getInstance());
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getImage()).thenReturn("Image");
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(widgetTypeDetails).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImagesForEdge(widgetTypeDetails);

    // Assert
    verify(widgetTypeDetails).getId();
    verify(widgetTypeDetails).getName();
    verify(widgetTypeDetails, atLeast(1)).getTenantId();
    verify(widgetTypeDetails).getDescriptor();
    verify(widgetTypeDetails).getImage();
    verify(widgetTypeDetails).setImage(eq("Image"));
  }
}
