/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.resource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.HasImage;
import org.thingsboard.server.common.data.ResourceSubType;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbImageDeleteResult;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.TbResourceInfoFilter;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;

@RunWith(MockitoJUnitRunner.class)
public class BaseImageServiceDiffblueTest {
  @InjectMocks private BaseImageService baseImageService;

  @Mock private TbResourceInfoDao tbResourceInfoDao;

  /**
   * Test {@link BaseImageService#getImageInfoByTenantIdAndKey(TenantId, String)}.
   *
   * <p>Method under test: {@link BaseImageService#getImageInfoByTenantIdAndKey(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo BaseImageService.getImageInfoByTenantIdAndKey(TenantId, String)"
  })
  public void testGetImageInfoByTenantIdAndKey() {
    // Arrange
    JpaTbResourceInfoDao resourceInfoDao = mock(JpaTbResourceInfoDao.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(resourceInfoDao.findByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResourceInfo);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    // Act
    TbResourceInfo actualImageInfoByTenantIdAndKey =
        baseImageService.getImageInfoByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, "Key");

    // Assert
    verify(resourceInfoDao)
        .findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.IMAGE), eq("Key"));
    assertSame(tbResourceInfo, actualImageInfoByTenantIdAndKey);
  }

  /**
   * Test {@link BaseImageService#getPublicImageInfoByKey(String)}.
   *
   * <p>Method under test: {@link BaseImageService#getPublicImageInfoByKey(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbResourceInfo BaseImageService.getPublicImageInfoByKey(String)"})
  public void testGetPublicImageInfoByKey() {
    // Arrange
    JpaTbResourceInfoDao resourceInfoDao = mock(JpaTbResourceInfoDao.class);
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(resourceInfoDao.findPublicResourceByKey(
            Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResourceInfo);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    // Act
    TbResourceInfo actualPublicImageInfoByKey =
        baseImageService.getPublicImageInfoByKey("Public Resource Key");

    // Assert
    verify(resourceInfoDao).findPublicResourceByKey(ResourceType.IMAGE, "Public Resource Key");
    assertSame(tbResourceInfo, actualPublicImageInfoByKey);
  }

  /**
   * Test {@link BaseImageService#getImagesByTenantId(TenantId, ResourceSubType, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#getImagesByTenantId(TenantId, ResourceSubType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseImageService.getImagesByTenantId(TenantId, ResourceSubType, PageLink)"
  })
  public void testGetImagesByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    PageData<TbResourceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(resourceInfoDao.findTenantResourcesByTenantId(
            Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    // Act
    PageData<TbResourceInfo> actualImagesByTenantId =
        baseImageService.getImagesByTenantId(
            ModelConstants.SYSTEM_TENANT,
            ResourceSubType.IMAGE,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(resourceInfoDao)
        .findTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualImagesByTenantId);
  }

  /**
   * Test {@link BaseImageService#getAllImagesByTenantId(TenantId, ResourceSubType, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#getAllImagesByTenantId(TenantId, ResourceSubType,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseImageService.getAllImagesByTenantId(TenantId, ResourceSubType, PageLink)"
  })
  public void testGetAllImagesByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    TbResourceInfoDao resourceInfoDao = mock(TbResourceInfoDao.class);
    PageData<TbResourceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(resourceInfoDao.findAllTenantResourcesByTenantId(
            Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    // Act
    PageData<TbResourceInfo> actualAllImagesByTenantId =
        baseImageService.getAllImagesByTenantId(
            ModelConstants.SYSTEM_TENANT,
            ResourceSubType.IMAGE,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(resourceInfoDao)
        .findAllTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualAllImagesByTenantId);
  }

  /**
   * Test {@link BaseImageService#getImageData(TenantId, TbResourceId)}.
   *
   * <p>Method under test: {@link BaseImageService#getImageData(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] BaseImageService.getImageData(TenantId, TbResourceId)"})
  public void testGetImageData() throws UnsupportedEncodingException {
    // Arrange
    TbResourceRepository resourceRepository = mock(TbResourceRepository.class);
    when(resourceRepository.getDataById(Mockito.<UUID>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(resourceRepository);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    // Act
    byte[] actualImageData =
        baseImageService.getImageData(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(resourceRepository).getDataById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualImageData);
  }

  /**
   * Test {@link BaseImageService#getImagePreview(TenantId, TbResourceId)}.
   *
   * <p>Method under test: {@link BaseImageService#getImagePreview(TenantId, TbResourceId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] BaseImageService.getImagePreview(TenantId, TbResourceId)"})
  public void testGetImagePreview() throws UnsupportedEncodingException {
    // Arrange
    TbResourceRepository resourceRepository = mock(TbResourceRepository.class);
    when(resourceRepository.getPreviewById(Mockito.<UUID>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(resourceRepository);
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    // Act
    byte[] actualImagePreview =
        baseImageService.getImagePreview(
            ModelConstants.SYSTEM_TENANT, new TbResourceId(ModelConstants.NULL_UUID));

    // Assert
    verify(resourceRepository).getPreviewById(isA(UUID.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualImagePreview);
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   *
   * <ul>
   *   <li>Given {@link TbResourceDao} {@link TbResourceDao#findById(TenantId, UUID)} return {@code
   *       null}.
   *   <li>Then return References is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage_givenTbResourceDaoFindByIdReturnNull_thenReturnReferencesIsNull() {
    // Arrange
    TbResourceDao resourceDao = mock(TbResourceDao.class);
    when(resourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    ResourceDataValidator resourceValidator = mock(ResourceDataValidator.class);
    doNothing()
        .when(resourceValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(true);

    TbResource imageInfo = new TbResource(new TbResourceId(ModelConstants.NULL_UUID));
    imageInfo.setResourceType(ResourceType.IMAGE);
    imageInfo.setTenantId(tenantId);

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, false);

    // Assert
    verify(tenantId).isSysTenantId();
    verify(resourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(resourceValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#calculateImageEtag(byte[])}.
   *
   * <p>Method under test: {@link BaseImageService#calculateImageEtag(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String BaseImageService.calculateImageEtag(byte[])"})
  public void testCalculateImageEtag() throws UnsupportedEncodingException {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    // Act
    String actualCalculateImageEtagResult =
        baseImageService.calculateImageEtag("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals(
        "5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc",
        actualCalculateImageEtagResult);
  }

  /**
   * Test {@link BaseImageService#findSystemOrTenantImageByEtag(TenantId, String)}.
   *
   * <p>Method under test: {@link BaseImageService#findSystemOrTenantImageByEtag(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbResourceInfo BaseImageService.findSystemOrTenantImageByEtag(TenantId, String)"
  })
  public void testFindSystemOrTenantImageByEtag() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoDao.findSystemOrTenantImageByEtag(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResourceInfo);

    // Act
    TbResourceInfo actualFindSystemOrTenantImageByEtagResult =
        baseImageService.findSystemOrTenantImageByEtag(ModelConstants.SYSTEM_TENANT, "Etag");

    // Assert
    verify(tbResourceInfoDao)
        .findSystemOrTenantImageByEtag(isA(TenantId.class), eq(ResourceType.IMAGE), eq("Etag"));
    assertSame(tbResourceInfo, actualFindSystemOrTenantImageByEtagResult);
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)} with {@code Dashboard}.
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(Dashboard)"})
  public void testReplaceBase64WithImageUrlWithDashboard() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    Dashboard entity = new Dashboard();
    entity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(entity));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)} with {@code Dashboard}.
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(Dashboard)"})
  public void testReplaceBase64WithImageUrlWithDashboard2() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    Dashboard entity = new Dashboard();
    entity.setImage("Executing replaceBase64WithImageUrl [{}] [Dashboard] [{}]");

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(entity));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)} with {@code Dashboard}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(Dashboard)"})
  public void testReplaceBase64WithImageUrlWithDashboard_givenValueOfTen() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    Dashboard entity = new Dashboard();
    entity.setConfiguration(DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(entity));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)} with {@code Dashboard}.
   *
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(Dashboard)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(Dashboard)"})
  public void testReplaceBase64WithImageUrlWithDashboard_whenDashboard_thenReturnFalse() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(new Dashboard()));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)} with {@code
   * HasImage}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code Image}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(HasImage, String)"})
  public void testReplaceBase64WithImageUrlWithHasImageString_givenImage() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    HasImage entity = mock(HasImage.class);
    when(entity.getImage()).thenReturn("Image");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    boolean actualReplaceBase64WithImageUrlResult =
        baseImageService.replaceBase64WithImageUrl(entity, "https://example.org/example");

    // Assert
    verify(entity).getImage();
    verify(entity).setImage("Image");
    verify(entity, atLeast(1)).getName();
    verify(entity, atLeast(1)).getTenantId();
    assertFalse(actualReplaceBase64WithImageUrlResult);
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)} with {@code
   * HasImage}, {@code String}.
   *
   * <ul>
   *   <li>Given space.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(HasImage, String)"})
  public void testReplaceBase64WithImageUrlWithHasImageString_givenSpace() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    HasImage entity = mock(HasImage.class);
    when(entity.getImage()).thenReturn(" ");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    boolean actualReplaceBase64WithImageUrlResult =
        baseImageService.replaceBase64WithImageUrl(entity, "https://example.org/example");

    // Assert
    verify(entity).getImage();
    verify(entity).setImage(" ");
    verify(entity, atLeast(1)).getName();
    verify(entity, atLeast(1)).getTenantId();
    assertFalse(actualReplaceBase64WithImageUrlResult);
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)} with {@code
   * HasImage}, {@code String}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#isSysTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(HasImage, String)"})
  public void testReplaceBase64WithImageUrlWithHasImageString_thenCallsIsSysTenantId() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.isSysTenantId()).thenReturn(false);

    HasImage entity = mock(HasImage.class);
    when(entity.getImage()).thenReturn(" ");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(tenantId);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    boolean actualReplaceBase64WithImageUrlResult =
        baseImageService.replaceBase64WithImageUrl(entity, "https://example.org/example");

    // Assert
    verify(entity).getImage();
    verify(entity).setImage(" ");
    verify(entity, atLeast(1)).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(tenantId).isSysTenantId();
    assertFalse(actualReplaceBase64WithImageUrlResult);
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)} with {@code
   * HasImage}, {@code String}.
   *
   * <ul>
   *   <li>When {@link Dashboard#Dashboard()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(HasImage, String)"})
  public void testReplaceBase64WithImageUrlWithHasImageString_whenDashboard_thenReturnFalse() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    // Act and Assert
    assertFalse(
        baseImageService.replaceBase64WithImageUrl(new Dashboard(), "https://example.org/example"));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)} with {@code
   * WidgetTypeDetails}.
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(WidgetTypeDetails)"})
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    WidgetTypeDetails entity = new WidgetTypeDetails();
    entity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(entity));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)} with {@code
   * WidgetTypeDetails}.
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(WidgetTypeDetails)"})
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails2() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    WidgetTypeDetails entity = mock(WidgetTypeDetails.class);
    when(entity.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(entity.getName()).thenReturn("Name");
    when(entity.getImage()).thenReturn("Image");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entity.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(entity).setImage(Mockito.<String>any());
    entity.setImage("tb-image:U:UU;data:U;U");

    // Act
    boolean actualReplaceBase64WithImageUrlResult =
        baseImageService.replaceBase64WithImageUrl(entity);

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
   * Test {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)} with {@code
   * WidgetTypeDetails}.
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(WidgetTypeDetails)"})
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails3() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    WidgetTypeDetails entity = mock(WidgetTypeDetails.class);
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    when(entity.getDescriptor()).thenReturn(new ArrayNode(nf));
    when(entity.getName()).thenReturn("Name");
    when(entity.getImage()).thenReturn("Image");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entity.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(entity).setImage(Mockito.<String>any());
    entity.setImage("tb-image:U:UU;data:U;U");

    // Act
    boolean actualReplaceBase64WithImageUrlResult =
        baseImageService.replaceBase64WithImageUrl(entity);

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
   * Test {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)} with {@code
   * WidgetTypeDetails}.
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(WidgetTypeDetails)"})
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails4() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    WidgetTypeDetails entity = mock(WidgetTypeDetails.class);
    BigInteger v = BigInteger.valueOf(42L);
    when(entity.getDescriptor()).thenReturn(new BigIntegerNode(v));
    when(entity.getName()).thenReturn("Name");
    when(entity.getImage()).thenReturn("Image");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entity.getId()).thenReturn(new WidgetTypeId(ModelConstants.NULL_UUID));
    doNothing().when(entity).setImage(Mockito.<String>any());
    entity.setImage("tb-image:U:UU;data:U;U");

    // Act
    boolean actualReplaceBase64WithImageUrlResult =
        baseImageService.replaceBase64WithImageUrl(entity);

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
   *
   * <ul>
   *   <li>Given {@code Image}.
   *   <li>When {@link HasImage} {@link HasImage#getImage()} return {@code Image}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImage(HasImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImage(HasImage)"})
  public void testInlineImageWithEntity_givenImage_whenHasImageGetImageReturnImage() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    HasImage entity = mock(HasImage.class);
    when(entity.getImage()).thenReturn("Image");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImage(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).setImage("Image");
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link BaseImageService#inlineImage(HasImage)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/system/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImage(HasImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImage(HasImage)"})
  public void testInlineImageWithEntity_givenTbImageApiImagesSystem() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    HasImage entity = mock(HasImage.class);
    when(entity.getImage()).thenReturn("tb-image;/api/images/system/");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImage(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).setImage("tb-image;/api/images/system/");
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link BaseImageService#inlineImage(HasImage)} with {@code entity}.
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/tenant/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImage(HasImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImage(HasImage)"})
  public void testInlineImageWithEntity_givenTbImageApiImagesTenant() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    HasImage entity = mock(HasImage.class);
    when(entity.getImage()).thenReturn("tb-image;/api/images/tenant/");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImage(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).setImage("tb-image;/api/images/tenant/");
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode descriptor = new ObjectNode(nc);
    descriptor.put("defaultConfig", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setDescriptor(descriptor);

    // Act and Assert
    baseImageService.inlineImages(widgetTypeDetails);
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails2() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    baseImageService.inlineImages(widgetTypeDetails);
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails3() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    ObjectNode descriptor = mock(ObjectNode.class);
    when(descriptor.fieldNames()).thenThrow(new RuntimeException());
    when(descriptor.put(Mockito.<String>any(), Mockito.<JsonNode>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(descriptor.isObject()).thenReturn(true);
    descriptor.put("defaultConfig", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setDescriptor(descriptor);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseImageService.inlineImages(widgetTypeDetails));
    verify(descriptor).fieldNames();
    verify(descriptor).isObject();
    verify(descriptor).put(eq("defaultConfig"), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails4() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    ObjectNode descriptor = mock(ObjectNode.class);
    when(descriptor.get(Mockito.<String>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    ArrayList<String> stringList = new ArrayList<>();
    when(descriptor.fieldNames()).thenReturn(stringList.iterator());
    when(descriptor.has(Mockito.<String>any())).thenReturn(true);
    when(descriptor.put(Mockito.<String>any(), Mockito.<JsonNode>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(descriptor.isObject()).thenReturn(true);
    descriptor.put("defaultConfig", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setDescriptor(descriptor);

    // Act
    baseImageService.inlineImages(widgetTypeDetails);

    // Assert
    verify(descriptor).has("defaultConfig");
    verify(descriptor).fieldNames();
    verify(descriptor).get("defaultConfig");
    verify(descriptor).isObject();
    verify(descriptor).put(eq("defaultConfig"), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails5() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("Executing inlineImage [{}] [WidgetTypeDetails] [{}]");
    Iterator<String> iteratorResult = stringList.iterator();

    ObjectNode descriptor = mock(ObjectNode.class);
    when(descriptor.get(Mockito.<String>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(descriptor.fieldNames()).thenReturn(iteratorResult);
    when(descriptor.has(Mockito.<String>any())).thenReturn(true);
    when(descriptor.put(Mockito.<String>any(), Mockito.<JsonNode>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(descriptor.isObject()).thenReturn(true);
    descriptor.put("defaultConfig", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setDescriptor(descriptor);

    // Act
    baseImageService.inlineImages(widgetTypeDetails);

    // Assert
    verify(descriptor).has("defaultConfig");
    verify(descriptor).fieldNames();
    verify(descriptor, atLeast(1)).get(Mockito.<String>any());
    verify(descriptor).isObject();
    verify(descriptor).put(eq("defaultConfig"), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@code image}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails_givenArrayListAddImage() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("image");
    Iterator<String> iteratorResult = stringList.iterator();

    ObjectNode descriptor = mock(ObjectNode.class);
    when(descriptor.get(Mockito.<String>any())).thenThrow(new RuntimeException());
    when(descriptor.fieldNames()).thenReturn(iteratorResult);
    when(descriptor.put(Mockito.<String>any(), Mockito.<JsonNode>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(descriptor.isObject()).thenReturn(true);
    descriptor.put("defaultConfig", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setDescriptor(descriptor);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseImageService.inlineImages(widgetTypeDetails));
    verify(descriptor).fieldNames();
    verify(descriptor).get("image");
    verify(descriptor).isObject();
    verify(descriptor).put(eq("defaultConfig"), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@code Image}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails_givenImage() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    verify(widgetTypeDetails).setImage("Image");
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@link ObjectNode} {@link ObjectNode#get(String)} return Instance.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails_givenObjectNodeGetReturnInstance() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    ObjectNode descriptor = mock(ObjectNode.class);
    when(descriptor.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());

    ArrayList<String> stringList = new ArrayList<>();
    when(descriptor.fieldNames()).thenReturn(stringList.iterator());
    when(descriptor.has(Mockito.<String>any())).thenReturn(true);
    when(descriptor.put(Mockito.<String>any(), Mockito.<JsonNode>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(descriptor.isObject()).thenReturn(true);
    descriptor.put("defaultConfig", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setDescriptor(descriptor);

    // Act
    baseImageService.inlineImages(widgetTypeDetails);

    // Assert
    verify(descriptor).has("defaultConfig");
    verify(descriptor).fieldNames();
    verify(descriptor).get("defaultConfig");
    verify(descriptor).isObject();
    verify(descriptor).put(eq("defaultConfig"), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@link ObjectNode} {@link ObjectNode#get(String)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails_givenObjectNodeGetThrowRuntimeException() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    ObjectNode descriptor = mock(ObjectNode.class);
    when(descriptor.get(Mockito.<String>any())).thenThrow(new RuntimeException());

    ArrayList<String> stringList = new ArrayList<>();
    when(descriptor.fieldNames()).thenReturn(stringList.iterator());
    when(descriptor.has(Mockito.<String>any())).thenReturn(true);
    when(descriptor.put(Mockito.<String>any(), Mockito.<JsonNode>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(descriptor.isObject()).thenReturn(true);
    descriptor.put("defaultConfig", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setDescriptor(descriptor);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseImageService.inlineImages(widgetTypeDetails));
    verify(descriptor).has("defaultConfig");
    verify(descriptor).fieldNames();
    verify(descriptor).get("defaultConfig");
    verify(descriptor).isObject();
    verify(descriptor).put(eq("defaultConfig"), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/system/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails_givenTbImageApiImagesSystem() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    verify(widgetTypeDetails).setImage("tb-image;/api/images/system/");
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/tenant/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails_givenTbImageApiImagesTenant() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
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
    verify(widgetTypeDetails).setImage("tb-image;/api/images/tenant/");
  }

  /**
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <ul>
   *   <li>Then calls {@link JsonNode#isTextual()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails_thenCallsIsTextual() {
    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.isTextual()).thenReturn(false);

    ObjectNode descriptor = mock(ObjectNode.class);
    when(descriptor.get(Mockito.<String>any())).thenReturn(jsonNode);

    ArrayList<String> stringList = new ArrayList<>();
    when(descriptor.fieldNames()).thenReturn(stringList.iterator());
    when(descriptor.has(Mockito.<String>any())).thenReturn(true);
    when(descriptor.put(Mockito.<String>any(), Mockito.<JsonNode>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(descriptor.isObject()).thenReturn(true);
    descriptor.put("defaultConfig", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    WidgetTypeDetails widgetTypeDetails =
        new WidgetTypeDetails(new WidgetTypeId(ModelConstants.NULL_UUID));
    widgetTypeDetails.setDescriptor(descriptor);

    // Act
    baseImageService.inlineImages(widgetTypeDetails);

    // Assert
    verify(descriptor).has("defaultConfig");
    verify(jsonNode).isTextual();
    verify(descriptor).fieldNames();
    verify(descriptor).get("defaultConfig");
    verify(descriptor).isObject();
    verify(descriptor).put(eq("defaultConfig"), isA(JsonNode.class));
  }

  /**
   * Test {@link BaseImageService#inlineImageForEdge(HasImage)}.
   *
   * <ul>
   *   <li>Given {@code Image}.
   *   <li>When {@link HasImage} {@link HasImage#getImage()} return {@code Image}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImageForEdge(HasImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImageForEdge(HasImage)"})
  public void testInlineImageForEdge_givenImage_whenHasImageGetImageReturnImage() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    HasImage entity = mock(HasImage.class);
    when(entity.getImage()).thenReturn("Image");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImageForEdge(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).setImage("Image");
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link BaseImageService#inlineImageForEdge(HasImage)}.
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/system/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImageForEdge(HasImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImageForEdge(HasImage)"})
  public void testInlineImageForEdge_givenTbImageApiImagesSystem() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    HasImage entity = mock(HasImage.class);
    when(entity.getImage()).thenReturn("tb-image;/api/images/system/");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImageForEdge(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).setImage("tb-image;/api/images/system/");
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
  }

  /**
   * Test {@link BaseImageService#inlineImageForEdge(HasImage)}.
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/tenant/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImageForEdge(HasImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseImageService.inlineImageForEdge(HasImage)"})
  public void testInlineImageForEdge_givenTbImageApiImagesTenant() {
    // Arrange
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService baseImageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    HasImage entity = mock(HasImage.class);
    when(entity.getImage()).thenReturn("tb-image;/api/images/tenant/");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    baseImageService.inlineImageForEdge(entity);

    // Assert
    verify(entity).getImage();
    verify(entity).setImage("tb-image;/api/images/tenant/");
    verify(entity).getName();
    verify(entity, atLeast(1)).getTenantId();
  }
}
