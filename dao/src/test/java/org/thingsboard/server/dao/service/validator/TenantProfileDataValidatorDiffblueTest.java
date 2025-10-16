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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;
import org.thingsboard.server.dao.tenant.TenantProfileDao;
import org.thingsboard.server.dao.tenant.TenantProfileService;

@ContextConfiguration(classes = {TenantProfileDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class TenantProfileDataValidatorDiffblueTest {
  @MockBean private TenantProfileDao tenantProfileDao;

  @Autowired private TenantProfileDataValidator tenantProfileDataValidator;

  @MockBean private TenantProfileService tenantProfileService;

  /**
   * Test {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)} with {@code
   * TenantId}, {@code TenantProfile}.
   *
   * <p>Method under test: {@link TenantProfileDataValidator#validateDataImpl(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileDataValidator.validateDataImpl(TenantId, TenantProfile)"})
  public void testValidateDataImplWithTenantIdTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileData())
        .thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfile).getName();
    verify(tenantProfile).getProfileData();
  }

  /**
   * Test {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)} with {@code
   * TenantId}, {@code TenantProfile}.
   *
   * <p>Method under test: {@link TenantProfileDataValidator#validateDataImpl(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileDataValidator.validateDataImpl(TenantId, TenantProfile)"})
  public void testValidateDataImplWithTenantIdTenantProfile2() {
    // Arrange
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
    when(tenantProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(tenantProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfile).getName();
    verify(tenantProfile, atLeast(1)).getProfileData();
    verify(tenantProfile).isDefault();
  }

  /**
   * Test {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)} with {@code
   * TenantId}, {@code TenantProfile}.
   *
   * <p>Method under test: {@link TenantProfileDataValidator#validateDataImpl(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileDataValidator.validateDataImpl(TenantId, TenantProfile)"})
  public void testValidateDataImplWithTenantIdTenantProfile3() {
    // Arrange
    when(tenantProfileService.findDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

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
    when(tenantProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(tenantProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfile).getId();
    verify(tenantProfile).getName();
    verify(tenantProfile, atLeast(1)).getProfileData();
    verify(tenantProfile).isDefault();
    verify(tenantProfileService).findDefaultTenantProfile(isA(TenantId.class));
  }

  /**
   * Test {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)} with {@code
   * TenantId}, {@code TenantProfile}.
   *
   * <p>Method under test: {@link TenantProfileDataValidator#validateDataImpl(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileDataValidator.validateDataImpl(TenantId, TenantProfile)"})
  public void testValidateDataImplWithTenantIdTenantProfile4() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfileService.findDefaultTenantProfile(Mockito.<TenantId>any()))
        .thenReturn(tenantProfile);

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

    TenantProfile tenantProfile2 = mock(TenantProfile.class);
    when(tenantProfile2.isDefault()).thenReturn(true);
    when(tenantProfile2.getProfileData()).thenReturn(tenantProfileData);
    when(tenantProfile2.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, tenantProfile2));
    verify(tenantProfile).getId();
    verify(tenantProfile2).getName();
    verify(tenantProfile2, atLeast(1)).getProfileData();
    verify(tenantProfile2).isDefault();
    verify(tenantProfileService).findDefaultTenantProfile(isA(TenantId.class));
  }

  /**
   * Test {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)} with {@code
   * TenantId}, {@code TenantProfile}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfile#isIsolatedTbRuleEngine()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileDataValidator#validateDataImpl(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileDataValidator.validateDataImpl(TenantId, TenantProfile)"})
  public void testValidateDataImplWithTenantIdTenantProfile_thenCallsIsIsolatedTbRuleEngine() {
    // Arrange
    when(tenantProfileService.findDefaultTenantProfile(Mockito.<TenantId>any())).thenReturn(null);

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
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(tenantProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfile).getName();
    verify(tenantProfile, atLeast(1)).getProfileData();
    verify(tenantProfile).isDefault();
    verify(tenantProfile).isIsolatedTbRuleEngine();
    verify(tenantProfileService).findDefaultTenantProfile(isA(TenantId.class));
  }

  /**
   * Test {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)} with {@code
   * TenantId}, {@code TenantProfile}.
   *
   * <ul>
   *   <li>When {@link TenantProfile#TenantProfile()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileDataValidator#validateDataImpl(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TenantProfileDataValidator.validateDataImpl(TenantId, TenantProfile)"})
  public void testValidateDataImplWithTenantIdTenantProfile_whenTenantProfile() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new TenantProfile()));
  }

  /**
   * Test {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)} with {@code
   * TenantId}, {@code TenantProfile}.
   *
   * <p>Method under test: {@link TenantProfileDataValidator#validateUpdate(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileDataValidator.validateUpdate(TenantId, TenantProfile)"
  })
  public void testValidateUpdateWithTenantIdTenantProfile() {
    // Arrange
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantProfile tenantProfile = TenantProfileServiceTest.createTenantProfile("Name");
    tenantProfile.setId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)} with {@code
   * TenantId}, {@code TenantProfile}.
   *
   * <p>Method under test: {@link TenantProfileDataValidator#validateUpdate(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileDataValidator.validateUpdate(TenantId, TenantProfile)"
  })
  public void testValidateUpdateWithTenantIdTenantProfile2() {
    // Arrange
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    TenantProfile tenantProfile = TenantProfileServiceTest.createTenantProfile("Name");
    tenantProfile.setId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            tenantProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)} with {@code
   * TenantId}, {@code TenantProfile}.
   *
   * <ul>
   *   <li>Then return createTenantProfile {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link TenantProfileDataValidator#validateUpdate(TenantId,
   * TenantProfile)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TenantProfile TenantProfileDataValidator.validateUpdate(TenantId, TenantProfile)"
  })
  public void testValidateUpdateWithTenantIdTenantProfile_thenReturnCreateTenantProfileName() {
    // Arrange
    TenantProfile createTenantProfileResult = TenantProfileServiceTest.createTenantProfile("Name");
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createTenantProfileResult);

    TenantProfile tenantProfile = TenantProfileServiceTest.createTenantProfile("Name");
    tenantProfile.setId(new TenantProfileId(ModelConstants.NULL_UUID));

    // Act
    TenantProfile actualValidateUpdateResult =
        tenantProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, tenantProfile);

    // Assert
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(createTenantProfileResult, actualValidateUpdateResult);
  }
}
