package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetDao;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {AssetDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class AssetDataValidatorDiffblueTest {
  @MockBean private AssetDao assetDao;

  @Autowired private AssetDataValidator assetDataValidator;

  @MockBean private CustomerDao customerDao;

  /**
   * Test {@link AssetDataValidator#validateUpdate(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <p>Method under test: {@link AssetDataValidator#validateUpdate(TenantId, Asset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Asset AssetDataValidator.validateUpdate(TenantId, Asset)"})
  public void testValidateUpdateWithTenantIdAsset() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Asset asset = new Asset();
    asset.setId(new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, asset));
    verify(assetDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link AssetDataValidator#validateUpdate(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <ul>
   *   <li>Given {@link AssetDao} {@link AssetDao#findById(TenantId, UUID)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetDataValidator#validateUpdate(TenantId, Asset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Asset AssetDataValidator.validateUpdate(TenantId, Asset)"})
  public void testValidateUpdateWithTenantIdAsset_givenAssetDaoFindByIdReturnNull() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    Asset asset = new Asset();
    asset.setId(new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, asset));
    verify(assetDao).findById(isNull(), isA(UUID.class));
  }

  /**
   * Test {@link AssetDataValidator#validateUpdate(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <ul>
   *   <li>Then return {@link Asset#Asset()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetDataValidator#validateUpdate(TenantId, Asset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Asset AssetDataValidator.validateUpdate(TenantId, Asset)"})
  public void testValidateUpdateWithTenantIdAsset_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    Asset asset2 = new Asset();
    asset2.setId(new AssetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    Asset actualValidateUpdateResult =
        assetDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, asset2);

    // Assert
    verify(assetDao).findById(isNull(), isA(UUID.class));
    assertSame(asset, actualValidateUpdateResult);
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <ul>
   *   <li>When {@link Asset#Asset()} Name is {@code Asset name}.
   * </ul>
   *
   * <p>Method under test: {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetDataValidator.validateDataImpl(TenantId, Asset)"})
  public void testValidateDataImplWithTenantIdAsset_whenAssetNameIsAssetName() {
    // Arrange
    Asset asset = new Asset();
    asset.setName("Asset name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
  }
}
