package org.thingsboard.server.service.apiusage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;

class TenantApiUsageStateDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantApiUsageState#setTenantProfileData(TenantProfileData)}
   *   <li>{@link TenantApiUsageState#getEntityType()}
   *   <li>{@link TenantApiUsageState#getTenantProfileData()}
   *   <li>{@link TenantApiUsageState#getTenantProfileId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityType TenantApiUsageState.getEntityType()",
    "TenantProfileData TenantApiUsageState.getTenantProfileData()",
    "org.thingsboard.server.common.data.id.TenantProfileId TenantApiUsageState.getTenantProfileId()",
    "void TenantApiUsageState.setTenantProfileData(TenantProfileData)",
    "void TenantApiUsageState.setTenantProfileId(org.thingsboard.server.common.data.id.TenantProfileId)"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());

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

    // Act
    tenantApiUsageState.setTenantProfileData(tenantProfileData);
    EntityType actualEntityType = tenantApiUsageState.getEntityType();
    TenantProfileData actualTenantProfileData = tenantApiUsageState.getTenantProfileData();

    // Assert
    assertNull(tenantApiUsageState.getTenantProfileId());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(tenantProfileData, actualTenantProfileData);
  }
}
