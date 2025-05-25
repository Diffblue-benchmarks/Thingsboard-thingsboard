package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@RunWith(MockitoJUnitRunner.class)
public class AssetProfileServiceImplDiffblueTest {
  @Mock
  private AssetProfileDao assetProfileDao;

  @InjectMocks
  private AssetProfileServiceImpl assetProfileServiceImpl;

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   * <ul>
   *   <li>Given {@link AssetProfileDao} {@link Dao#findById(TenantId, UUID)} return {@code null}.</li>
   *   <li>Then calls {@link Dao#findById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  public void testDeleteAssetProfile_givenAssetProfileDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    assetProfileServiceImpl.deleteAssetProfile(ModelConstants.SYSTEM_TENANT,
        new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  public void testDeleteAssetProfile_thenCallsGetId() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(assetProfile);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> assetProfileServiceImpl.deleteAssetProfile(ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfile).isDefault();
    verify(assetProfileId, atLeast(1)).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  public void testDeleteAssetProfile_thenThrowConstraintViolationException() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(assetProfile);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> assetProfileServiceImpl.deleteAssetProfile(ModelConstants.SYSTEM_TENANT,
            new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(assetProfile).isDefault();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link AssetProfileDao#findAssetProfiles(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfilesByTenantId(TenantId)"})
  public void testDeleteAssetProfilesByTenantId_thenCallsFindAssetProfiles() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    assetProfileServiceImpl.deleteAssetProfilesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfilesByTenantId(TenantId)"})
  public void testDeleteAssetProfilesByTenantId_thenThrowDataValidationException() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "fk_asset_profile"));

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setId(assetProfileId);

    ArrayList<AssetProfile> data = new ArrayList<>();
    data.add(assetProfile);
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(new PageData<>(data, 100, 100L, true));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileServiceImpl.deleteAssetProfilesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(assetProfileId).getId();
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link AssetProfileDao#findAssetProfiles(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsFindAssetProfiles() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    assetProfileServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowDataValidationException() {
    // Arrange
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "fk_asset_profile"));

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setId(assetProfileId);

    ArrayList<AssetProfile> data = new ArrayList<>();
    data.add(assetProfile);
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(new PageData<>(data, 100, 100L, true));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(assetProfileId).getId();
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link AssetProfileServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType AssetProfileServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET_PROFILE, (new AssetProfileServiceImpl()).getEntityType());
  }
}
