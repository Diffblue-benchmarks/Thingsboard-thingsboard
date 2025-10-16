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
import java.nio.ByteBuffer;
import java.util.ArrayList;
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
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.ota.ChecksumAlgorithm;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
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
   * Test {@link OtaPackageDataValidator#validateCreate(TenantId, OtaPackage)} with {@code
   * TenantId}, {@code OtaPackage}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackageDataValidator#validateCreate(TenantId, OtaPackage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackageDataValidator.validateCreate(TenantId, OtaPackage)"})
  public void testValidateCreateWithTenantIdOtaPackage_thenThrowDataValidationException() {
    // Arrange
    when(otaPackageDao.sumDataSizeByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(
        DefaultTenantProfileConfiguration.builder()
            .alarmsTtlDays(1)
            .cassandraQueryTenantRateLimitsConfiguration(
                "Cassandra Query Tenant Rate Limits Configuration")
            .customerServerRestLimitsConfiguration("Customer Server Rest Limits Configuration")
            .defaultStorageTtlDays(1)
            .edgeEventRateLimits("Edge Event Rate Limits")
            .edgeEventRateLimitsPerEdge("Edge Event Rate Limits Per Edge")
            .edgeUplinkMessagesRateLimits("Edge Uplink Messages Rate Limits")
            .edgeUplinkMessagesRateLimitsPerEdge("Edge Uplink Messages Rate Limits Per Edge")
            .maxAssets(1L)
            .maxCreatedAlarms(1L)
            .maxCustomers(1L)
            .maxDPStorageDays(1L)
            .maxDashboards(1L)
            .maxDevices(1L)
            .maxEmails(1L)
            .maxJSExecutions(1L)
            .maxOtaPackagesInBytes(1L)
            .maxREExecutions(1L)
            .maxResourceSize(3L)
            .maxResourcesInBytes(1L)
            .maxRuleChains(1L)
            .maxRuleNodeExecutionsPerMessage(3)
            .maxSms(1L)
            .maxTbelExecutions(1L)
            .maxTransportDataPoints(1L)
            .maxTransportMessages(1L)
            .maxUsers(1L)
            .maxWsSessionsPerCustomer(3)
            .maxWsSessionsPerPublicUser(3)
            .maxWsSessionsPerRegularUser(3)
            .maxWsSessionsPerTenant(3)
            .maxWsSubscriptionsPerCustomer(1L)
            .maxWsSubscriptionsPerPublicUser(1L)
            .maxWsSubscriptionsPerRegularUser(1L)
            .maxWsSubscriptionsPerTenant(1L)
            .queueStatsTtlDays(1)
            .rpcTtlDays(1)
            .ruleEngineExceptionsTtlDays(1)
            .smsEnabled(true)
            .tenantEntityExportRateLimit("Tenant Entity Export Rate Limit")
            .tenantEntityImportRateLimit("Tenant Entity Import Rate Limit")
            .tenantNotificationRequestsPerRuleRateLimit(
                "Tenant Notification Requests Per Rule Rate Limit")
            .tenantNotificationRequestsRateLimit("Tenant Notification Requests Rate Limit")
            .tenantServerRestLimitsConfiguration("Tenant Server Rest Limits Configuration")
            .transportDeviceMsgRateLimit("Transport Device Msg Rate Limit")
            .transportDeviceTelemetryDataPointsRateLimit(
                "Transport Device Telemetry Data Points Rate Limit")
            .transportDeviceTelemetryMsgRateLimit("Transport Device Telemetry Msg Rate Limit")
            .transportGatewayDeviceMsgRateLimit("Transport Gateway Device Msg Rate Limit")
            .transportGatewayDeviceTelemetryDataPointsRateLimit(
                "Transport Gateway Device Telemetry Data Points Rate Limit")
            .transportGatewayDeviceTelemetryMsgRateLimit(
                "Transport Gateway Device Telemetry Msg Rate Limit")
            .transportGatewayMsgRateLimit("Transport Gateway Msg Rate Limit")
            .transportGatewayTelemetryDataPointsRateLimit(
                "Transport Gateway Telemetry Data Points Rate Limit")
            .transportGatewayTelemetryMsgRateLimit("Transport Gateway Telemetry Msg Rate Limit")
            .transportTenantMsgRateLimit("Transport Tenant Msg Rate Limit")
            .transportTenantTelemetryDataPointsRateLimit(
                "Transport Tenant Telemetry Data Points Rate Limit")
            .transportTenantTelemetryMsgRateLimit("Transport Tenant Telemetry Msg Rate Limit")
            .warnThreshold(10.0d)
            .wsMsgQueueLimitPerSession(1)
            .wsUpdatesPerSessionRateLimit("2020-03-01")
            .build());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    OtaPackage otaPackage =
        OtaPackageServiceTest.createFirmware(ModelConstants.SYSTEM_TENANT, "1.0.2", null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> otaPackageDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, otaPackage));
    verify(tenantProfile).getProfileData();
    verify(otaPackageDao).sumDataSizeByTenantId(isA(TenantId.class));
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
