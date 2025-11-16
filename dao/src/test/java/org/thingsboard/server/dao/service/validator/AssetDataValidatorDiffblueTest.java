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
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.Asset;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.asset.AssetDao;
import org.thingsboard.server.dao.customer.CustomerDao;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {AssetDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class AssetDataValidatorDiffblueTest {
  @MockBean private ApiLimitService apiLimitService;

  @MockBean private AssetDao assetDao;

  @Autowired private AssetDataValidator assetDataValidator;

  @MockBean private CustomerDao customerDao;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link AssetDataValidator#validateCreate(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <ul>
   *   <li>Then calls {@link ApiLimitService#checkEntitiesLimit(TenantId, EntityType)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetDataValidator#validateCreate(TenantId, Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetDataValidator.validateCreate(TenantId, Asset)"})
  public void testValidateCreateWithTenantIdAsset_thenCallsCheckEntitiesLimit() {
    // Arrange
    when(apiLimitService.checkEntitiesLimit(Mockito.<TenantId>any(), Mockito.<EntityType>any()))
        .thenReturn(true);

    // Act
    assetDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Asset());

    // Assert
    verify(apiLimitService).checkEntitiesLimit(isA(TenantId.class), eq(EntityType.ASSET));
  }

  /**
   * Test {@link AssetDataValidator#validateUpdate(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <p>Method under test: {@link AssetDataValidator#validateUpdate(TenantId, Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AssetDataValidator.validateUpdate(TenantId, Asset)"})
  public void testValidateUpdateWithTenantIdAsset() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    Asset asset = new Asset();
    asset.setId(new AssetId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AssetDataValidator.validateUpdate(TenantId, Asset)"})
  public void testValidateUpdateWithTenantIdAsset_givenAssetDaoFindByIdReturnNull() {
    // Arrange
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    Asset asset = new Asset();
    asset.setId(new AssetId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Asset AssetDataValidator.validateUpdate(TenantId, Asset)"})
  public void testValidateUpdateWithTenantIdAsset_thenReturnAsset() {
    // Arrange
    Asset asset = new Asset();
    when(assetDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(asset);

    Asset asset2 = new Asset();
    asset2.setId(new AssetId(ModelConstants.NULL_UUID));

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
   * <p>Method under test: {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetDataValidator.validateDataImpl(TenantId, Asset)"})
  public void testValidateDataImplWithTenantIdAsset() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    Asset asset = new Asset();
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    asset.setName("Asset name");

    // Act
    assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
    CustomerId customerId = asset.getCustomerId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", customerId.getId().toString());
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <p>Method under test: {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetDataValidator.validateDataImpl(TenantId, Asset)"})
  public void testValidateDataImplWithTenantIdAsset2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenThrow(new DataValidationException("An error occurred"));

    Asset asset = new Asset();
    asset.setCustomerId(customerId);
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    asset.setName("Asset name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
    verify(customerId).getId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <p>Method under test: {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetDataValidator.validateDataImpl(TenantId, Asset)"})
  public void testValidateDataImplWithTenantIdAsset3() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    Asset asset = new Asset();
    asset.setCustomerId(customerId);
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    asset.setName("Asset name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <ul>
   *   <li>Given {@link CustomerDao} {@link CustomerDao#findById(TenantId, UUID)} return {@code
   *       null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetDataValidator.validateDataImpl(TenantId, Asset)"})
  public void testValidateDataImplWithTenantIdAsset_givenCustomerDaoFindByIdReturnNull() {
    // Arrange
    when(customerDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.randomUUID());

    Asset asset = new Asset();
    asset.setCustomerId(customerId);
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    asset.setName("Asset name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
    verify(customerId, atLeast(1)).getId();
    verify(customerDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <ul>
   *   <li>Given {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetDataValidator.validateDataImpl(TenantId, Asset)"})
  public void testValidateDataImplWithTenantIdAsset_givenNull_customer_id() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    Asset asset = new Asset();
    asset.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    asset.setName("Asset name");

    // Act
    assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset);

    // Assert that nothing has changed
    verify(tenantService).tenantExists(isA(TenantId.class));
    CustomerId customerId = asset.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId.getEntityType());
    assertTrue(customerId.isNullUid());
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetDataValidator.validateDataImpl(TenantId, Asset)"})
  public void testValidateDataImplWithTenantIdAsset_givenTenantServiceTenantExistsReturnFalse() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    Asset asset = new Asset();
    asset.setTenantId(ModelConstants.SYSTEM_TENANT);
    asset.setName("Asset name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetDataValidator.validateDataImpl(TenantId, Asset)"})
  public void testValidateDataImplWithTenantIdAsset_thenThrowDataValidationException() {
    // Arrange
    Asset asset = new Asset();
    asset.setName("Asset name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, asset));
  }

  /**
   * Test {@link AssetDataValidator#validateDataImpl(TenantId, Asset)} with {@code TenantId}, {@code
   * Asset}.
   *
   * <ul>
   *   <li>When {@link Asset#Asset()}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetDataValidator#validateDataImpl(TenantId, Asset)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetDataValidator.validateDataImpl(TenantId, Asset)"})
  public void testValidateDataImplWithTenantIdAsset_whenAsset_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new Asset()));
  }
}
