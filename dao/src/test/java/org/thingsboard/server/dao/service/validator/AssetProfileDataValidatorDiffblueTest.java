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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
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
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.asset.AssetProfileDao;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {AssetProfileDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class AssetProfileDataValidatorDiffblueTest {
  @MockBean private AssetProfileDao assetProfileDao;

  @Autowired private AssetProfileDataValidator assetProfileDataValidator;

  @MockBean private AssetProfileService assetProfileService;

  @MockBean private DashboardService dashboardService;

  @MockBean private QueueService queueService;

  @MockBean private RuleChainService ruleChainService;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateDataImpl(TenantId,
   * AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileDataValidator.validateDataImpl(TenantId, AssetProfile)"})
  public void testValidateDataImplWithTenantIdAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setName("Asset profile name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateDataImpl(TenantId,
   * AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileDataValidator.validateDataImpl(TenantId, AssetProfile)"})
  public void testValidateDataImplWithTenantIdAssetProfile2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    assetProfile.setName("Asset profile name");

    // Act
    assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateDataImpl(TenantId,
   * AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileDataValidator.validateDataImpl(TenantId, AssetProfile)"})
  public void testValidateDataImplWithTenantIdAssetProfile3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    assetProfile.setName("Asset profile name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateDataImpl(TenantId,
   * AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileDataValidator.validateDataImpl(TenantId, AssetProfile)"})
  public void testValidateDataImplWithTenantIdAssetProfile4() {
    // Arrange
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(null);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefault(true);
    assetProfile.setDefaultQueueName("not empty");
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(null);
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    assetProfile.setName("Asset profile name");

    // Act
    assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile);

    // Assert
    verify(assetProfileService).findDefaultAssetProfile(isA(TenantId.class));
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("not empty"));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateDataImpl(TenantId,
   * AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileDataValidator.validateDataImpl(TenantId, AssetProfile)"})
  public void testValidateDataImplWithTenantIdAssetProfile5() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefault(true);
    assetProfile.setDefaultQueueName("not empty");
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(null);
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    assetProfile.setName("Asset profile name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateDataImpl(TenantId,
   * AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileDataValidator.validateDataImpl(TenantId, AssetProfile)"})
  public void testValidateDataImplWithTenantIdAssetProfile_givenEmptyString() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setName("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateDataImpl(TenantId,
   * AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileDataValidator.validateDataImpl(TenantId, AssetProfile)"})
  public void testValidateDataImplWithTenantIdAssetProfile_givenTenantService() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefault(true);
    assetProfile.setDefaultQueueName("not empty");
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(null);
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    assetProfile.setName("Asset profile name\u0000");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <ul>
   *   <li>Given {@link TenantService}.
   *   <li>When {@link AssetProfile#AssetProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateDataImpl(TenantId,
   * AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileDataValidator.validateDataImpl(TenantId, AssetProfile)"})
  public void testValidateDataImplWithTenantIdAssetProfile_givenTenantService_whenAssetProfile() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new AssetProfile()));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <ul>
   *   <li>Then calls {@link QueueService#findQueueByTenantIdAndName(TenantId, String)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateDataImpl(TenantId,
   * AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileDataValidator.validateDataImpl(TenantId, AssetProfile)"})
  public void testValidateDataImplWithTenantIdAssetProfile_thenCallsFindQueueByTenantIdAndName() {
    // Arrange
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    AssetProfile assetProfile = new AssetProfile(new AssetProfile());
    assetProfile.setTenantId(null);
    assetProfile.setDefault(false);
    assetProfile.setDefaultQueueName("not empty");
    assetProfile.setDefaultRuleChainId(null);
    assetProfile.setDefaultDashboardId(null);
    assetProfile.setTenantId(ModelConstants.SYSTEM_TENANT);
    assetProfile.setName("Asset profile name");

    // Act
    assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile);

    // Assert
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("not empty"));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateDataImpl(TenantId,
   * AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileDataValidator.validateDataImpl(TenantId, AssetProfile)"})
  public void testValidateDataImplWithTenantIdAssetProfile_thenCallsGetId() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any()))
        .thenReturn(assetProfile);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    AssetProfile assetProfile2 = new AssetProfile(new AssetProfile());
    assetProfile2.setTenantId(null);
    assetProfile2.setDefault(true);
    assetProfile2.setDefaultQueueName("not empty");
    assetProfile2.setDefaultRuleChainId(null);
    assetProfile2.setDefaultDashboardId(null);
    assetProfile2.setTenantId(ModelConstants.SYSTEM_TENANT);
    assetProfile2.setName("Asset profile name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, assetProfile2));
    verify(assetProfile).getId();
    verify(assetProfileService).findDefaultAssetProfile(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateUpdate(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <ul>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateUpdate(TenantId, AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfile AssetProfileDataValidator.validateUpdate(TenantId, AssetProfile)"
  })
  public void testValidateUpdateWithTenantIdAssetProfile_thenReturnAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);

    AssetProfile assetProfile2 = new AssetProfile();
    assetProfile2.setId(new AssetProfileId(ModelConstants.NULL_UUID));

    // Act
    AssetProfile actualValidateUpdateResult =
        assetProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, assetProfile2);

    // Assert
    verify(assetProfileDao).findById(isNull(), isA(UUID.class));
    assertSame(assetProfile, actualValidateUpdateResult);
  }

  /**
   * Test {@link AssetProfileDataValidator#validateUpdate(TenantId, AssetProfile)} with {@code
   * TenantId}, {@code AssetProfile}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileDataValidator#validateUpdate(TenantId, AssetProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfile AssetProfileDataValidator.validateUpdate(TenantId, AssetProfile)"
  })
  public void testValidateUpdateWithTenantIdAssetProfile_thenThrowDataValidationException() {
    // Arrange
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setId(new AssetProfileId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(assetProfileDao).findById(isNull(), isA(UUID.class));
  }
}
