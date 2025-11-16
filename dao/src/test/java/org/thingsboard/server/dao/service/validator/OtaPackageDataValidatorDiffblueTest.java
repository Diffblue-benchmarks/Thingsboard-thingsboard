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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.nio.ByteBuffer;
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
import org.thingsboard.server.common.data.OtaPackage;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.dao.device.DeviceProfileDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.ota.OtaPackageDao;
import org.thingsboard.server.dao.ota.OtaPackageService;
import org.thingsboard.server.dao.service.OtaPackageServiceTest;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantService;

@ContextConfiguration(classes = {OtaPackageDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class OtaPackageDataValidatorDiffblueTest {
  @MockBean private DeviceProfileDao deviceProfileDao;

  @MockBean private OtaPackageDao otaPackageDao;

  @Autowired private OtaPackageDataValidator otaPackageDataValidator;

  @MockBean private OtaPackageService otaPackageService;

  @MockBean private TbTenantProfileCache tbTenantProfileCache;

  @MockBean private TenantService tenantService;

  /**
   * Test {@link OtaPackageDataValidator#validateCreate(TenantId, OtaPackage)} with {@code
   * TenantId}, {@code OtaPackage}.
   *
   * <ul>
   *   <li>Then calls {@link TbTenantProfileCache#get(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageDataValidator#validateCreate(TenantId, OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageDataValidator.validateCreate(TenantId, OtaPackage)"})
  public void testValidateCreateWithTenantIdOtaPackage_thenCallsGet() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));
    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);

    // Act
    otaPackageDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, otaPackage);

    // Assert
    verify(tbTenantProfileCache).get(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)} with {@code
   * TenantId}, {@code OtaPackage}.
   *
   * <p>Method under test: {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageDataValidator.validateDataImpl(TenantId, OtaPackage)"})
  public void testValidateDataImplWithTenantIdOtaPackage() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    when(otaPackageService.generateChecksum(
            Mockito.<ChecksumAlgorithm>any(), Mockito.<ByteBuffer>any()))
        .thenReturn("Generate Checksum");
    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackageService).generateChecksum(eq(ChecksumAlgorithm.SHA256), isA(ByteBuffer.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)} with {@code
   * TenantId}, {@code OtaPackage}.
   *
   * <p>Method under test: {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageDataValidator.validateDataImpl(TenantId, OtaPackage)"})
  public void testValidateDataImplWithTenantIdOtaPackage2() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    when(otaPackageService.generateChecksum(
            Mockito.<ChecksumAlgorithm>any(), Mockito.<ByteBuffer>any()))
        .thenReturn("4bf5122f344554c53bde2ebb8cd2b7e3d1600ad631c385a5d7cce23c7785459a");
    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);

    // Act
    otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage);

    // Assert
    verify(otaPackageService).generateChecksum(eq(ChecksumAlgorithm.SHA256), isA(ByteBuffer.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)} with {@code
   * TenantId}, {@code OtaPackage}.
   *
   * <p>Method under test: {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageDataValidator.validateDataImpl(TenantId, OtaPackage)"})
  public void testValidateDataImplWithTenantIdOtaPackage3() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "", null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)} with {@code
   * TenantId}, {@code OtaPackage}.
   *
   * <p>Method under test: {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageDataValidator.validateDataImpl(TenantId, OtaPackage)"})
  public void testValidateDataImplWithTenantIdOtaPackage4() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    when(otaPackageService.generateChecksum(
            Mockito.<ChecksumAlgorithm>any(), Mockito.<ByteBuffer>any()))
        .thenReturn("Generate Checksum");

    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);
    otaPackage.setUrl("");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackageService).generateChecksum(eq(ChecksumAlgorithm.SHA256), isA(ByteBuffer.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)} with {@code
   * TenantId}, {@code OtaPackage}.
   *
   * <ul>
   *   <li>Given {@code https://example.org/example}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageDataValidator.validateDataImpl(TenantId, OtaPackage)"})
  public void testValidateDataImplWithTenantIdOtaPackage_givenHttpsExampleOrgExample() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);

    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);
    otaPackage.setUrl("https://example.org/example");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> otaPackageDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)} with {@code
   * TenantId}, {@code OtaPackage}.
   *
   * <ul>
   *   <li>When {@link OtaPackage#OtaPackage()}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageDataValidator#validateDataImpl(TenantId, OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageDataValidator.validateDataImpl(TenantId, OtaPackage)"})
  public void testValidateDataImplWithTenantIdOtaPackage_whenOtaPackage() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            otaPackageDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new OtaPackage()));
  }

  /**
   * Test {@link OtaPackageDataValidator#validateUpdate(TenantId, OtaPackage)} with {@code
   * TenantId}, {@code OtaPackage}.
   *
   * <p>Method under test: {@link OtaPackageDataValidator#validateUpdate(TenantId, OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage OtaPackageDataValidator.validateUpdate(TenantId, OtaPackage)"})
  public void testValidateUpdateWithTenantIdOtaPackage() {
    // Arrange
    OtaPackage createFirmwareResult =
        OtaPackageServiceTest.createFirmware(
            ModelConstants.SYSTEM_TENANT, "1.0.2", new DeviceProfileId(ModelConstants.NULL_UUID));
    when(otaPackageDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createFirmwareResult);
    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(
            ModelConstants.SYSTEM_TENANT, "1.0.2", new DeviceProfileId(ModelConstants.NULL_UUID));

    // Act
    OtaPackage actualValidateUpdateResult =
        otaPackageDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, otaPackage);

    // Assert
    verify(otaPackageDao).findById(isA(TenantId.class), isNull());
    assertSame(createFirmwareResult, actualValidateUpdateResult);
  }

  /**
   * Test {@link OtaPackageDataValidator#validateUpdate(TenantId, OtaPackage)} with {@code
   * TenantId}, {@code OtaPackage}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageDataValidator#validateUpdate(TenantId, OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"OtaPackage OtaPackageDataValidator.validateUpdate(TenantId, OtaPackage)"})
  public void testValidateUpdateWithTenantIdOtaPackage_thenThrowDataValidationException() {
    // Arrange
    when(otaPackageDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> otaPackageDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(otaPackageDao).findById(isA(TenantId.class), isNull());
  }
}
