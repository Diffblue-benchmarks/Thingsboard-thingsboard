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

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.OtaPackageInfo;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.dao.device.DeviceProfileDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.ota.OtaPackageDao;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {OtaPackageDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseOtaPackageDataValidatorDiffblueTest {
  @Autowired private BaseOtaPackageDataValidator<OtaPackage> baseOtaPackageDataValidator;

  @MockBean private DeviceProfileDao deviceProfileDao;

  @MockBean private OtaPackageDao otaPackageDao;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Given {@code 1.0.2}.
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo()} Version is {@code 1.0.2}.
   *   <li>Then calls {@link TenantService#tenantExists(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageDataValidator.validateImpl(OtaPackageInfo)"})
  public void testValidateImpl_given102_whenOtaPackageInfoVersionIs102_thenCallsTenantExists() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setVersion("1.0.2");
    otaPackageInfo.setType(OtaPackageType.FIRMWARE);
    otaPackageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    otaPackageInfo.setTitle("Dr");

    // Act
    baseOtaPackageDataValidator.validateImpl(otaPackageInfo);

    // Assert
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Given {@code Dr}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageDataValidator.validateImpl(OtaPackageInfo)"})
  public void testValidateImpl_givenDr_thenThrowDataValidationException() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo()} Title is empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageDataValidator.validateImpl(OtaPackageInfo)"})
  public void testValidateImpl_givenEmptyString_whenOtaPackageInfoTitleIsEmptyString() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTitle("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Given {@code FIRMWARE}.
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo()} Type is {@code FIRMWARE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageDataValidator.validateImpl(OtaPackageInfo)"})
  public void testValidateImpl_givenFirmware_whenOtaPackageInfoTypeIsFirmware() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setType(OtaPackageType.FIRMWARE);
    otaPackageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    otaPackageInfo.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Given {@link OtaPackageDataValidator} (default constructor).
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageDataValidator.validateImpl(OtaPackageInfo)"})
  public void testValidateImpl_givenOtaPackageDataValidator_thenThrowDataValidationException() {
    // Arrange
    OtaPackageDataValidator otaPackageDataValidator = new OtaPackageDataValidator();

    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTitle("Dr\u0000");

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> otaPackageDataValidator.validateImpl(otaPackageInfo));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)} return {@code
   *       false}.
   *   <li>Then calls {@link TenantService#tenantExists(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageDataValidator.validateImpl(OtaPackageInfo)"})
  public void testValidateImpl_givenTenantServiceTenantExistsReturnFalse_thenCallsTenantExists() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);

    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    otaPackageInfo.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>Given {@link TenantService} {@link TenantService#tenantExists(TenantId)} return {@code
   *       true}.
   *   <li>Then calls {@link TenantService#tenantExists(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageDataValidator.validateImpl(OtaPackageInfo)"})
  public void testValidateImpl_givenTenantServiceTenantExistsReturnTrue_thenCallsTenantExists() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setTenantId(ModelConstants.SYSTEM_TENANT);
    otaPackageInfo.setTitle("Dr");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateImpl(otaPackageInfo));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}.
   *
   * <ul>
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo()}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateImpl(OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseOtaPackageDataValidator.validateImpl(OtaPackageInfo)"})
  public void testValidateImpl_whenOtaPackageInfo_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateImpl(new OtaPackageInfo()));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo, OtaPackageInfo)} with
   * {@code otaPackage}, {@code otaPackageOld}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#validateUpdate(OtaPackageInfo,
   * OtaPackageInfo)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseOtaPackageDataValidator.validateUpdate(OtaPackageInfo, OtaPackageInfo)"
  })
  public void testValidateUpdateWithOtaPackageOtaPackageOld_thenThrowDataValidationException() {
    // Arrange
    OtaPackageInfo otaPackage = new OtaPackageInfo();

    OtaPackageInfo otaPackageOld = new OtaPackageInfo();
    otaPackageOld.setType(OtaPackageType.FIRMWARE);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseOtaPackageDataValidator.validateUpdate(otaPackage, otaPackageOld));
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#getDeviceProfileDao()}.
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#getDeviceProfileDao()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfileDao BaseOtaPackageDataValidator.getDeviceProfileDao()"})
  public void testGetDeviceProfileDao() {
    // Arrange, Act and Assert
    assertNull(new OtaPackageDataValidator().getDeviceProfileDao());
  }

  /**
   * Test {@link BaseOtaPackageDataValidator#getTenantService()}.
   *
   * <p>Method under test: {@link BaseOtaPackageDataValidator#getTenantService()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"TenantService BaseOtaPackageDataValidator.getTenantService()"})
  public void testGetTenantService() {
    // Arrange, Act and Assert
    assertNull(new OtaPackageDataValidator().getTenantService());
  }
}
