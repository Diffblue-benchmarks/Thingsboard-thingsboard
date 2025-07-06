package org.thingsboard.server.dao.resource;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
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

@RunWith(MockitoJUnitRunner.class)
public class BaseImageServiceDiffblueTest {
  @InjectMocks private BaseImageService baseImageService;

  @Mock private ResourceDataValidator resourceDataValidator;

  @Mock private TbResourceDao tbResourceDao;

  @Mock private TbResourceInfoDao tbResourceInfoDao;

  /**
   * Test {@link BaseImageService#getImageInfoByTenantIdAndKey(TenantId, String)}.
   *
   * <p>Method under test: {@link BaseImageService#getImageInfoByTenantIdAndKey(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "TbResourceInfo BaseImageService.getImageInfoByTenantIdAndKey(TenantId, String)"
  })
  public void testGetImageInfoByTenantIdAndKey() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoDao.findByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResourceInfo);

    // Act
    TbResourceInfo actualImageInfoByTenantIdAndKey =
        baseImageService.getImageInfoByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, "Key");

    // Assert
    verify(tbResourceInfoDao)
        .findByTenantIdAndKey(isA(TenantId.class), eq(ResourceType.IMAGE), eq("Key"));
    assertSame(tbResourceInfo, actualImageInfoByTenantIdAndKey);
  }

  /**
   * Test {@link BaseImageService#getPublicImageInfoByKey(String)}.
   *
   * <p>Method under test: {@link BaseImageService#getPublicImageInfoByKey(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbResourceInfo BaseImageService.getPublicImageInfoByKey(String)"})
  public void testGetPublicImageInfoByKey() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoDao.findPublicResourceByKey(
            Mockito.<ResourceType>any(), Mockito.<String>any()))
        .thenReturn(tbResourceInfo);

    // Act
    TbResourceInfo actualPublicImageInfoByKey =
        baseImageService.getPublicImageInfoByKey("Public Resource Key");

    // Assert
    verify(tbResourceInfoDao)
        .findPublicResourceByKey(eq(ResourceType.IMAGE), eq("Public Resource Key"));
    assertSame(tbResourceInfo, actualPublicImageInfoByKey);
  }

  /**
   * Test {@link BaseImageService#getImagesByTenantId(TenantId, ResourceSubType, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#getImagesByTenantId(TenantId, ResourceSubType,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseImageService.getImagesByTenantId(TenantId, ResourceSubType, PageLink)"
  })
  public void testGetImagesByTenantId_whenSystem_tenant_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TbResourceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceInfoDao.findTenantResourcesByTenantId(
            Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<TbResourceInfo> actualImagesByTenantId =
        baseImageService.getImagesByTenantId(
            ModelConstants.SYSTEM_TENANT,
            ResourceSubType.IMAGE,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoDao)
        .findTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
    assertSame(actualImagesByTenantId.EMPTY_PAGE_DATA, actualImagesByTenantId);
  }

  /**
   * Test {@link BaseImageService#getAllImagesByTenantId(TenantId, ResourceSubType, PageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#getAllImagesByTenantId(TenantId, ResourceSubType,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseImageService.getAllImagesByTenantId(TenantId, ResourceSubType, PageLink)"
  })
  public void testGetAllImagesByTenantId_whenSystem_tenant_thenReturnEmpty_page_data() {
    // Arrange
    PageData<TbResourceInfo> emptyPageDataResult = PageData.emptyPageData();
    when(tbResourceInfoDao.findAllTenantResourcesByTenantId(
            Mockito.<TbResourceInfoFilter>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<TbResourceInfo> actualAllImagesByTenantId =
        baseImageService.getAllImagesByTenantId(
            ModelConstants.SYSTEM_TENANT,
            ResourceSubType.IMAGE,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tbResourceInfoDao)
        .findAllTenantResourcesByTenantId(isA(TbResourceInfoFilter.class), isA(PageLink.class));
    assertSame(actualAllImagesByTenantId.EMPTY_PAGE_DATA, actualAllImagesByTenantId);
  }

  /**
   * Test {@link BaseImageService#getImageData(TenantId, TbResourceId)}.
   *
   * <p>Method under test: {@link BaseImageService#getImageData(TenantId, TbResourceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] BaseImageService.getImageData(TenantId, TbResourceId)"})
  public void testGetImageData() throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceDao.getResourceData(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualImageData =
        baseImageService.getImageData(
            ModelConstants.SYSTEM_TENANT,
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tbResourceDao).getResourceData(isA(TenantId.class), isA(TbResourceId.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualImageData);
  }

  /**
   * Test {@link BaseImageService#getImagePreview(TenantId, TbResourceId)}.
   *
   * <p>Method under test: {@link BaseImageService#getImagePreview(TenantId, TbResourceId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] BaseImageService.getImagePreview(TenantId, TbResourceId)"})
  public void testGetImagePreview() throws UnsupportedEncodingException {
    // Arrange
    when(tbResourceDao.getResourcePreview(Mockito.<TenantId>any(), Mockito.<TbResourceId>any()))
        .thenReturn("AXAXAXAX".getBytes("UTF-8"));

    // Act
    byte[] actualImagePreview =
        baseImageService.getImagePreview(
            ModelConstants.SYSTEM_TENANT,
            new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(tbResourceDao).getResourcePreview(isA(TenantId.class), isA(TbResourceId.class));
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualImagePreview);
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   *
   * <p>Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    doNothing()
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    TbResourceInfo imageInfo = new TbResourceInfo(new TbResourceInfo());
    imageInfo.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    imageInfo.setResourceType(ResourceType.IMAGE);
    imageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, false);

    // Assert
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ResourceType#IMAGE}.
   *   <li>Then calls {@link ResourceDataValidator#validateDelete(TenantId, EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage_givenImage_thenCallsValidateDelete() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    doNothing()
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    TbResourceInfo imageInfo = new TbResourceInfo(new TbResourceInfo());
    imageInfo.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    imageInfo.setResourceType(ResourceType.IMAGE);
    imageInfo.setTenantId(null);

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, false);

    // Assert
    verify(tbResourceDao).findById(isNull(), isA(UUID.class));
    verify(resourceDataValidator).validateDelete((TenantId) isNull(), isA(EntityId.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ResourceType#IMAGE}.
   *   <li>When {@code true}.
   *   <li>Then return References is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage_givenImage_whenTrue_thenReturnReferencesIsNull() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    TbResourceInfo imageInfo = new TbResourceInfo(new TbResourceInfo());
    imageInfo.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    imageInfo.setResourceType(ResourceType.IMAGE);
    imageInfo.setTenantId(null);

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, true);

    // Assert
    verify(tbResourceDao).findById(isNull(), isA(UUID.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   *
   * <ul>
   *   <li>Given {@code Link}.
   *   <li>When {@link TbResourceInfo} {@link TbResourceInfo#getLink()} return {@code Link}.
   *   <li>Then calls {@link TbResourceInfo#getLink()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage_givenLink_whenTbResourceInfoGetLinkReturnLink_thenCallsGetLink() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    doNothing()
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());
    TbResourceInfo imageInfo = mock(TbResourceInfo.class);
    when(imageInfo.getLink()).thenReturn("Link");
    when(imageInfo.getId())
        .thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(imageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, false);

    // Assert
    verify(imageInfo).getId();
    verify(imageInfo).getLink();
    verify(imageInfo).getTenantId();
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   *
   * <ul>
   *   <li>Given {@code LWM2M_MODEL}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage_givenLwm2mModel() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    doNothing()
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    TbResourceInfo imageInfo = new TbResourceInfo(new TbResourceInfo());
    imageInfo.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    imageInfo.setResourceType(ResourceType.LWM2M_MODEL);
    imageInfo.setTenantId(null);

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, false);

    // Assert
    verify(tbResourceDao).findById(isNull(), isA(UUID.class));
    verify(resourceDataValidator).validateDelete((TenantId) isNull(), isA(EntityId.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   *
   * <ul>
   *   <li>Given {@link TenantId#TenantId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage_givenTenantIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    doNothing()
        .when(resourceDataValidator)
        .validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    TbResourceInfo imageInfo = new TbResourceInfo(new TbResourceInfo());
    imageInfo.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    imageInfo.setResourceType(ResourceType.IMAGE);
    imageInfo.setTenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, false);

    // Assert
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link TbResourceInfo#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage_thenCallsGetId() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    TbResourceInfo imageInfo = mock(TbResourceInfo.class);
    when(imageInfo.getId())
        .thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(imageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, true);

    // Assert
    verify(imageInfo).getId();
    verify(imageInfo).getTenantId();
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#calculateImageEtag(byte[])}.
   *
   * <p>Method under test: {@link BaseImageService#calculateImageEtag(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BaseImageService.calculateImageEtag(byte[])"})
  public void testCalculateImageEtag() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc",
        baseImageService.calculateImageEtag("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BaseImageService#calculateImageEtag(byte[])}.
   *
   * <p>Method under test: {@link BaseImageService#calculateImageEtag(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BaseImageService.calculateImageEtag(byte[])"})
  public void testCalculateImageEtag2() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        "b3b8e9bb377ea61eeb38b29303ca700c2abe0289b83f742f1b4aa1ee3fec5938",
        baseImageService.calculateImageEtag("XXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BaseImageService#findSystemOrTenantImageByEtag(TenantId, String)}.
   *
   * <p>Method under test: {@link BaseImageService#findSystemOrTenantImageByEtag(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(Dashboard)"})
  public void testReplaceBase64WithImageUrlWithDashboard() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(Dashboard)"})
  public void testReplaceBase64WithImageUrlWithDashboard2() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(Dashboard)"})
  public void testReplaceBase64WithImageUrlWithDashboard_givenValueOfTen() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(Dashboard)"})
  public void testReplaceBase64WithImageUrlWithDashboard_whenDashboard_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(new Dashboard()));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)} with {@code
   * HasImage}, {@code String}.
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(HasImage, String)"})
  public void testReplaceBase64WithImageUrlWithHasImageString() {
    // Arrange
    Dashboard entity = new Dashboard(new Dashboard());
    entity.setTenantId(ModelConstants.SYSTEM_TENANT);
    entity.setImage(" ");

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(entity, "https://example.org/example"));
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)} with {@code
   * HasImage}, {@code String}.
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(HasImage, String)"})
  public void testReplaceBase64WithImageUrlWithHasImageString2() {
    // Arrange
    Dashboard entity = mock(Dashboard.class);
    when(entity.getImage()).thenReturn("Image");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId())
        .thenReturn(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    boolean actualReplaceBase64WithImageUrlResult =
        baseImageService.replaceBase64WithImageUrl(entity, "https://example.org/example");

    // Assert
    verify(entity).getImage();
    verify(entity, atLeast(1)).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity).setImage(eq("Image"));
    assertFalse(actualReplaceBase64WithImageUrlResult);
  }

  /**
   * Test {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)} with {@code
   * HasImage}, {@code String}.
   *
   * <ul>
   *   <li>Given {@code Image}.
   *   <li>Then calls {@link Dashboard#getImage()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#replaceBase64WithImageUrl(HasImage, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(HasImage, String)"})
  public void testReplaceBase64WithImageUrlWithHasImageString_givenImage_thenCallsGetImage() {
    // Arrange
    Dashboard entity = mock(Dashboard.class);
    when(entity.getImage()).thenReturn("Image");
    when(entity.getName()).thenReturn("Name");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(entity).setImage(Mockito.<String>any());

    // Act
    boolean actualReplaceBase64WithImageUrlResult =
        baseImageService.replaceBase64WithImageUrl(entity, "https://example.org/example");

    // Assert
    verify(entity).getImage();
    verify(entity, atLeast(1)).getName();
    verify(entity, atLeast(1)).getTenantId();
    verify(entity).setImage(eq("Image"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(HasImage, String)"})
  public void testReplaceBase64WithImageUrlWithHasImageString_givenSpace() {
    // Arrange
    Dashboard entity = new Dashboard(new Dashboard());
    entity.setTenantId(null);
    entity.setImage(" ");

    // Act and Assert
    assertFalse(baseImageService.replaceBase64WithImageUrl(entity, "https://example.org/example"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(HasImage, String)"})
  public void testReplaceBase64WithImageUrlWithHasImageString_whenDashboard_thenReturnFalse() {
    // Arrange, Act and Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(WidgetTypeDetails)"})
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails() {
    // Arrange
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(WidgetTypeDetails)"})
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails2() {
    // Arrange
    WidgetTypeDetails entity = mock(WidgetTypeDetails.class);
    when(entity.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(entity.getName()).thenReturn("Name");
    when(entity.getImage()).thenReturn("Image");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entity.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(WidgetTypeDetails)"})
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails3() {
    // Arrange
    WidgetTypeDetails entity = mock(WidgetTypeDetails.class);
    when(entity.getDescriptor())
        .thenReturn(new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));
    when(entity.getName()).thenReturn("Name");
    when(entity.getImage()).thenReturn("Image");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entity.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean BaseImageService.replaceBase64WithImageUrl(WidgetTypeDetails)"})
  public void testReplaceBase64WithImageUrlWithWidgetTypeDetails4() {
    // Arrange
    WidgetTypeDetails entity = mock(WidgetTypeDetails.class);
    when(entity.getDescriptor()).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));
    when(entity.getName()).thenReturn("Name");
    when(entity.getImage()).thenReturn("Image");
    when(entity.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(entity.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
   *   <li>When {@link Dashboard} {@link Dashboard#getImage()} return {@code Image}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImage(HasImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImage(HasImage)"})
  public void testInlineImageWithEntity_givenImage_whenDashboardGetImageReturnImage() {
    // Arrange
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
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/system/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImage(HasImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImage(HasImage)"})
  public void testInlineImageWithEntity_givenTbImageApiImagesSystem() {
    // Arrange
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
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/tenant/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImage(HasImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImage(HasImage)"})
  public void testInlineImageWithEntity_givenTbImageApiImagesTenant() {
    // Arrange
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
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@code Image}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails_givenImage() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getImage()).thenReturn("Image");
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/system/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails_givenTbImageApiImagesSystem() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getImage()).thenReturn("tb-image;/api/images/system/");
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
   * Test {@link BaseImageService#inlineImages(WidgetTypeDetails)} with {@code widgetTypeDetails}.
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/tenant/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImages(WidgetTypeDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImages(WidgetTypeDetails)"})
  public void testInlineImagesWithWidgetTypeDetails_givenTbImageApiImagesTenant() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getImage()).thenReturn("tb-image;/api/images/tenant/");
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
   *
   * <ul>
   *   <li>Given {@code Image}.
   *   <li>When {@link Dashboard} {@link Dashboard#getImage()} return {@code Image}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImageForEdge(HasImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImageForEdge(HasImage)"})
  public void testInlineImageForEdge_givenImage_whenDashboardGetImageReturnImage() {
    // Arrange
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
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/system/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImageForEdge(HasImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImageForEdge(HasImage)"})
  public void testInlineImageForEdge_givenTbImageApiImagesSystem() {
    // Arrange
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
   *
   * <ul>
   *   <li>Given {@code tb-image;/api/images/tenant/}.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImageForEdge(HasImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImageForEdge(HasImage)"})
  public void testInlineImageForEdge_givenTbImageApiImagesTenant() {
    // Arrange
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
   * Test {@link BaseImageService#inlineImagesForEdge(WidgetTypeDetails)} with {@code
   * widgetTypeDetails}.
   *
   * <p>Method under test: {@link BaseImageService#inlineImagesForEdge(WidgetTypeDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImagesForEdge(WidgetTypeDetails)"})
  public void testInlineImagesForEdgeWithWidgetTypeDetails() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getImage()).thenReturn("Image");
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
   * Test {@link BaseImageService#inlineImagesForEdge(WidgetTypeDetails)} with {@code
   * widgetTypeDetails}.
   *
   * <ul>
   *   <li>Given valueOf ten.
   * </ul>
   *
   * <p>Method under test: {@link BaseImageService#inlineImagesForEdge(WidgetTypeDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseImageService.inlineImagesForEdge(WidgetTypeDetails)"})
  public void testInlineImagesForEdgeWithWidgetTypeDetails_givenValueOfTen() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.getDescriptor()).thenReturn(DoubleNode.valueOf(10.0d));
    when(widgetTypeDetails.getName()).thenReturn("Name");
    when(widgetTypeDetails.getImage()).thenReturn("Image");
    when(widgetTypeDetails.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(widgetTypeDetails.getId())
        .thenReturn(new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
