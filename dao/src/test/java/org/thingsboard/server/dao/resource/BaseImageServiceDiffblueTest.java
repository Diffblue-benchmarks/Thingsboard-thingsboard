package org.thingsboard.server.dao.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.ResourceType;
import org.thingsboard.server.common.data.TbImageDeleteResult;
import org.thingsboard.server.common.data.TbResource;
import org.thingsboard.server.common.data.TbResourceInfo;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;

@RunWith(MockitoJUnitRunner.class)
public class BaseImageServiceDiffblueTest {
  @InjectMocks
  private BaseImageService baseImageService;

  @Mock
  private ResourceDataValidator resourceDataValidator;

  @Mock
  private TbResourceDao tbResourceDao;

  @Mock
  private TbResourceInfoDao tbResourceInfoDao;

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   * <p>
   * Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    TbResourceInfo imageInfo = new TbResourceInfo();
    imageInfo.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, true);

    // Assert
    verify(tbResourceDao).findById(isNull(), isA(UUID.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   * <ul>
   *   <li>Given {@link TbResourceDao} {@link Dao#findById(TenantId, UUID)} return {@code null}.</li>
   *   <li>Then calls {@link TbResourceInfo#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage_givenTbResourceDaoFindByIdReturnNull_thenCallsGetId() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    TbResource imageInfo = mock(TbResource.class);
    when(imageInfo.getId()).thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(imageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(imageInfo).setId(Mockito.<TbResourceId>any());
    imageInfo.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, true);

    // Assert
    verify(imageInfo).getId();
    verify(imageInfo).getTenantId();
    verify(imageInfo).setId(isA(TbResourceId.class));
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}.
   * <ul>
   *   <li>Then calls {@link TbResourceInfo#getLink()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseImageService#deleteImage(TbResourceInfo, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbImageDeleteResult BaseImageService.deleteImage(TbResourceInfo, boolean)"})
  public void testDeleteImage_thenCallsGetLink() {
    // Arrange
    when(tbResourceDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    doNothing().when(resourceDataValidator).validateDelete(Mockito.<TenantId>any(), Mockito.<EntityId>any());
    TbResource imageInfo = mock(TbResource.class);
    when(imageInfo.getLink()).thenReturn("Link");
    when(imageInfo.getId()).thenReturn(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(imageInfo.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(imageInfo).setId(Mockito.<TbResourceId>any());
    imageInfo.setId(new TbResourceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    TbImageDeleteResult actualDeleteImageResult = baseImageService.deleteImage(imageInfo, false);

    // Assert
    verify(imageInfo).getId();
    verify(imageInfo).getLink();
    verify(imageInfo).getTenantId();
    verify(imageInfo).setId(isA(TbResourceId.class));
    verify(tbResourceDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(resourceDataValidator).validateDelete(isA(TenantId.class), isA(EntityId.class));
    assertNull(actualDeleteImageResult.getReferences());
    assertTrue(actualDeleteImageResult.isSuccess());
  }

  /**
   * Test {@link BaseImageService#calculateImageEtag(byte[])}.
   * <p>
   * Method under test: {@link BaseImageService#calculateImageEtag(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String BaseImageService.calculateImageEtag(byte[])"})
  public void testCalculateImageEtag() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("5c5b6209d867a8c020ea0d75a22fb3ccf66cb4d88a4b53e001e1398f1a60badc",
        baseImageService.calculateImageEtag("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link BaseImageService#findSystemOrTenantImageByEtag(TenantId, String)}.
   * <p>
   * Method under test: {@link BaseImageService#findSystemOrTenantImageByEtag(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TbResourceInfo BaseImageService.findSystemOrTenantImageByEtag(TenantId, String)"})
  public void testFindSystemOrTenantImageByEtag() {
    // Arrange
    TbResourceInfo tbResourceInfo = new TbResourceInfo();
    when(tbResourceInfoDao.findSystemOrTenantImageByEtag(Mockito.<TenantId>any(), Mockito.<ResourceType>any(),
        Mockito.<String>any())).thenReturn(tbResourceInfo);

    // Act
    TbResourceInfo actualFindSystemOrTenantImageByEtagResult = baseImageService
        .findSystemOrTenantImageByEtag(ModelConstants.SYSTEM_TENANT, "Etag");

    // Assert
    verify(tbResourceInfoDao).findSystemOrTenantImageByEtag(isA(TenantId.class), eq(ResourceType.IMAGE), eq("Etag"));
    assertSame(tbResourceInfo, actualFindSystemOrTenantImageByEtagResult);
  }
}
